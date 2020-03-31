package androidx.camera.extensions;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.CameraEventCallback;
import androidx.camera.camera2.impl.CameraEventCallbacks;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.extensions.ExtensionsErrorListener;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.extensions.impl.CaptureProcessorImpl;
import androidx.camera.extensions.impl.CaptureStageImpl;
import androidx.camera.extensions.impl.ImageCaptureExtenderImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ImageCaptureExtender {
    static final Config.Option<ExtensionsManager.EffectMode> OPTION_IMAGE_CAPTURE_EXTENDER_MODE = Config.Option.create("camerax.extensions.imageCaptureExtender.mode", ExtensionsManager.EffectMode.class);
    private static final String TAG = "ImageCaptureExtender";
    private ImageCapture.Builder mBuilder;
    private ExtensionsManager.EffectMode mEffectMode;
    private ExtensionCameraIdFilter mExtensionCameraIdFilter;
    private ImageCaptureExtenderImpl mImpl;

    /* access modifiers changed from: package-private */
    public void init(ImageCapture.Builder builder, ImageCaptureExtenderImpl imageCaptureExtenderImpl, ExtensionsManager.EffectMode effectMode) {
        this.mBuilder = builder;
        this.mImpl = imageCaptureExtenderImpl;
        this.mEffectMode = effectMode;
        this.mExtensionCameraIdFilter = new ExtensionCameraIdFilter(imageCaptureExtenderImpl);
    }

    public boolean isExtensionAvailable(CameraSelector cameraSelector) {
        return getCameraWithExtension(cameraSelector) != null;
    }

    private String getCameraWithExtension(CameraSelector cameraSelector) {
        CameraSelector.Builder fromSelector = CameraSelector.Builder.fromSelector(cameraSelector);
        fromSelector.appendFilter(this.mExtensionCameraIdFilter);
        return CameraUtil.getCameraIdUnchecked(fromSelector.build());
    }

    public void enableExtension(CameraSelector cameraSelector) {
        String cameraWithExtension = getCameraWithExtension(cameraSelector);
        if (cameraWithExtension != null) {
            CameraSelector cameraSelector2 = this.mBuilder.getUseCaseConfig().getCameraSelector(null);
            if (cameraSelector2 == null) {
                this.mBuilder.setCameraSelector(new CameraSelector.Builder().appendFilter(this.mExtensionCameraIdFilter).build());
            } else {
                this.mBuilder.setCameraSelector(CameraSelector.Builder.fromSelector(cameraSelector2).appendFilter(this.mExtensionCameraIdFilter).build());
            }
            this.mImpl.init(cameraWithExtension, CameraUtil.getCameraCharacteristics(cameraWithExtension));
            CaptureProcessorImpl captureProcessor = this.mImpl.getCaptureProcessor();
            if (captureProcessor != null) {
                this.mBuilder.setCaptureProcessor(new AdaptingCaptureProcessor(captureProcessor));
            }
            if (this.mImpl.getMaxCaptureStage() > 0) {
                this.mBuilder.setMaxCaptureStages(this.mImpl.getMaxCaptureStage());
            }
            ImageCaptureAdapter imageCaptureAdapter = new ImageCaptureAdapter(this.mImpl, this.mEffectMode);
            new Camera2ImplConfig.Extender(this.mBuilder).setCameraEventCallback(new CameraEventCallbacks(imageCaptureAdapter));
            this.mBuilder.setUseCaseEventCallback((UseCase.EventCallback) imageCaptureAdapter);
            this.mBuilder.setCaptureBundle(imageCaptureAdapter);
            this.mBuilder.getMutableConfig().insertOption(OPTION_IMAGE_CAPTURE_EXTENDER_MODE, this.mEffectMode);
            setSupportedResolutions();
        }
    }

    private void setSupportedResolutions() {
        if (ExtensionVersion.getRuntimeVersion().compareTo(Version.VERSION_1_1) >= 0) {
            List list = null;
            try {
                list = this.mImpl.getSupportedResolutions();
            } catch (NoSuchMethodError unused) {
                Log.e(TAG, "getSupportedResolution interface is not implemented in vendor library.");
            }
            if (list != null) {
                this.mBuilder.setSupportedResolutions((List<Pair<Integer, Size[]>>) list);
            }
        }
    }

    static void checkPreviewEnabled(ExtensionsManager.EffectMode effectMode, Collection<UseCase> collection) {
        if (collection != null && !collection.isEmpty()) {
            boolean z = false;
            boolean z2 = false;
            for (UseCase useCaseConfig : collection) {
                ExtensionsManager.EffectMode effectMode2 = (ExtensionsManager.EffectMode) useCaseConfig.getUseCaseConfig().retrieveOption(PreviewExtender.OPTION_PREVIEW_EXTENDER_MODE, null);
                if (effectMode == effectMode2) {
                    z2 = true;
                } else if (effectMode2 != null) {
                    z = true;
                }
            }
            if (z) {
                ExtensionsManager.postExtensionsError(ExtensionsErrorListener.ExtensionsErrorCode.MISMATCHED_EXTENSIONS_ENABLED);
            } else if (!z2) {
                ExtensionsManager.postExtensionsError(ExtensionsErrorListener.ExtensionsErrorCode.PREVIEW_EXTENSION_REQUIRED);
            }
        }
    }

    static class ImageCaptureAdapter extends CameraEventCallback implements UseCase.EventCallback, CaptureBundle {
        private final AtomicBoolean mActive = new AtomicBoolean(true);
        final ExtensionsManager.EffectMode mEffectMode;
        private volatile int mEnabledSessionCount = 0;
        private final ImageCaptureExtenderImpl mImpl;
        private final Object mLock = new Object();
        private volatile boolean mUnbind = false;

        ImageCaptureAdapter(ImageCaptureExtenderImpl imageCaptureExtenderImpl, ExtensionsManager.EffectMode effectMode) {
            this.mImpl = imageCaptureExtenderImpl;
            this.mEffectMode = effectMode;
        }

        public void onBind(String str) {
            if (this.mActive.get()) {
                this.mImpl.onInit(str, CameraUtil.getCameraCharacteristics(str), CameraX.getContext());
            }
        }

        public void onUnbind() {
            synchronized (this.mLock) {
                this.mUnbind = true;
                if (this.mEnabledSessionCount == 0) {
                    callDeInit();
                }
            }
        }

        private void callDeInit() {
            if (this.mActive.get()) {
                this.mImpl.onDeInit();
                this.mActive.set(false);
            }
        }

        public CaptureConfig onPresetSession() {
            if (!this.mActive.get()) {
                return null;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class androidx.camera.extensions.ImageCaptureExtender.ImageCaptureAdapter.AnonymousClass1 */

                public void run() {
                    ImageCaptureExtender.checkPreviewEnabled(ImageCaptureAdapter.this.mEffectMode, CameraX.getActiveUseCases());
                }
            });
            CaptureStageImpl onPresetSession = this.mImpl.onPresetSession();
            if (onPresetSession != null) {
                return new AdaptingCaptureStage(onPresetSession).getCaptureConfig();
            }
            return null;
        }

        public CaptureConfig onEnableSession() {
            CaptureStageImpl onEnableSession;
            try {
                if (!this.mActive.get() || (onEnableSession = this.mImpl.onEnableSession()) == null) {
                    synchronized (this.mLock) {
                        this.mEnabledSessionCount++;
                    }
                    return null;
                }
                CaptureConfig captureConfig = new AdaptingCaptureStage(onEnableSession).getCaptureConfig();
                synchronized (this.mLock) {
                    this.mEnabledSessionCount++;
                }
                return captureConfig;
            } catch (Throwable th) {
                synchronized (this.mLock) {
                    this.mEnabledSessionCount++;
                    throw th;
                }
            }
        }

        public CaptureConfig onDisableSession() {
            CaptureStageImpl onDisableSession;
            try {
                if (!this.mActive.get() || (onDisableSession = this.mImpl.onDisableSession()) == null) {
                    synchronized (this.mLock) {
                        this.mEnabledSessionCount--;
                        if (this.mEnabledSessionCount == 0 && this.mUnbind) {
                            callDeInit();
                        }
                    }
                    return null;
                }
                CaptureConfig captureConfig = new AdaptingCaptureStage(onDisableSession).getCaptureConfig();
                synchronized (this.mLock) {
                    this.mEnabledSessionCount--;
                    if (this.mEnabledSessionCount == 0 && this.mUnbind) {
                        callDeInit();
                    }
                }
                return captureConfig;
            } catch (Throwable th) {
                synchronized (this.mLock) {
                    this.mEnabledSessionCount--;
                    if (this.mEnabledSessionCount == 0 && this.mUnbind) {
                        callDeInit();
                    }
                    throw th;
                }
            }
        }

        public List<CaptureStage> getCaptureStages() {
            List<CaptureStageImpl> captureStages;
            if (!this.mActive.get() || (captureStages = this.mImpl.getCaptureStages()) == null || captureStages.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (CaptureStageImpl adaptingCaptureStage : captureStages) {
                arrayList.add(new AdaptingCaptureStage(adaptingCaptureStage));
            }
            return arrayList;
        }
    }
}
