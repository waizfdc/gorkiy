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
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.extensions.ExtensionsErrorListener;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.extensions.impl.CaptureStageImpl;
import androidx.camera.extensions.impl.PreviewExtenderImpl;
import java.util.Collection;
import java.util.List;

public abstract class PreviewExtender {
    static final Config.Option<ExtensionsManager.EffectMode> OPTION_PREVIEW_EXTENDER_MODE = Config.Option.create("camerax.extensions.previewExtender.mode", ExtensionsManager.EffectMode.class);
    private static final String TAG = "PreviewExtender";
    private Preview.Builder mBuilder;
    private ExtensionsManager.EffectMode mEffectMode;
    private ExtensionCameraIdFilter mExtensionCameraIdFilter;
    private PreviewExtenderImpl mImpl;

    interface CloseableProcessor {
        void close();
    }

    /* access modifiers changed from: package-private */
    public void init(Preview.Builder builder, PreviewExtenderImpl previewExtenderImpl, ExtensionsManager.EffectMode effectMode) {
        this.mBuilder = builder;
        this.mImpl = previewExtenderImpl;
        this.mEffectMode = effectMode;
        this.mExtensionCameraIdFilter = new ExtensionCameraIdFilter(previewExtenderImpl);
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
        PreviewExtenderAdapter previewExtenderAdapter;
        PreviewExtenderAdapter previewExtenderAdapter2;
        String cameraWithExtension = getCameraWithExtension(cameraSelector);
        if (cameraWithExtension != null) {
            CameraSelector cameraSelector2 = this.mBuilder.getUseCaseConfig().getCameraSelector(null);
            if (cameraSelector2 == null) {
                this.mBuilder.setCameraSelector(new CameraSelector.Builder().appendFilter(this.mExtensionCameraIdFilter).build());
            } else {
                this.mBuilder.setCameraSelector(CameraSelector.Builder.fromSelector(cameraSelector2).appendFilter(this.mExtensionCameraIdFilter).build());
            }
            this.mImpl.init(cameraWithExtension, CameraUtil.getCameraCharacteristics(cameraWithExtension));
            int i = AnonymousClass1.$SwitchMap$androidx$camera$extensions$impl$PreviewExtenderImpl$ProcessorType[this.mImpl.getProcessorType().ordinal()];
            if (i == 1) {
                AdaptingRequestUpdateProcessor adaptingRequestUpdateProcessor = new AdaptingRequestUpdateProcessor(this.mImpl);
                this.mBuilder.setImageInfoProcessor(adaptingRequestUpdateProcessor);
                previewExtenderAdapter2 = new PreviewExtenderAdapter(this.mImpl, this.mEffectMode, adaptingRequestUpdateProcessor);
            } else if (i != 2) {
                previewExtenderAdapter = new PreviewExtenderAdapter(this.mImpl, this.mEffectMode, null);
                new Camera2ImplConfig.Extender(this.mBuilder).setCameraEventCallback(new CameraEventCallbacks(previewExtenderAdapter));
                this.mBuilder.setUseCaseEventCallback((UseCase.EventCallback) previewExtenderAdapter);
                this.mBuilder.getMutableConfig().insertOption(OPTION_PREVIEW_EXTENDER_MODE, this.mEffectMode);
                setSupportedResolutions();
            } else {
                AdaptingPreviewProcessor adaptingPreviewProcessor = new AdaptingPreviewProcessor(this.mImpl.getProcessor());
                this.mBuilder.setCaptureProcessor(adaptingPreviewProcessor);
                previewExtenderAdapter2 = new PreviewExtenderAdapter(this.mImpl, this.mEffectMode, adaptingPreviewProcessor);
            }
            previewExtenderAdapter = previewExtenderAdapter2;
            new Camera2ImplConfig.Extender(this.mBuilder).setCameraEventCallback(new CameraEventCallbacks(previewExtenderAdapter));
            this.mBuilder.setUseCaseEventCallback((UseCase.EventCallback) previewExtenderAdapter);
            this.mBuilder.getMutableConfig().insertOption(OPTION_PREVIEW_EXTENDER_MODE, this.mEffectMode);
            setSupportedResolutions();
        }
    }

    /* renamed from: androidx.camera.extensions.PreviewExtender$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$extensions$impl$PreviewExtenderImpl$ProcessorType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.camera.extensions.impl.PreviewExtenderImpl$ProcessorType[] r0 = androidx.camera.extensions.impl.PreviewExtenderImpl.ProcessorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.camera.extensions.PreviewExtender.AnonymousClass1.$SwitchMap$androidx$camera$extensions$impl$PreviewExtenderImpl$ProcessorType = r0
                androidx.camera.extensions.impl.PreviewExtenderImpl$ProcessorType r1 = androidx.camera.extensions.impl.PreviewExtenderImpl.ProcessorType.PROCESSOR_TYPE_REQUEST_UPDATE_ONLY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = androidx.camera.extensions.PreviewExtender.AnonymousClass1.$SwitchMap$androidx$camera$extensions$impl$PreviewExtenderImpl$ProcessorType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.extensions.impl.PreviewExtenderImpl$ProcessorType r1 = androidx.camera.extensions.impl.PreviewExtenderImpl.ProcessorType.PROCESSOR_TYPE_IMAGE_PROCESSOR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.PreviewExtender.AnonymousClass1.<clinit>():void");
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

    static void checkImageCaptureEnabled(ExtensionsManager.EffectMode effectMode, Collection<UseCase> collection) {
        if (collection != null && !collection.isEmpty()) {
            boolean z = false;
            boolean z2 = false;
            for (UseCase useCaseConfig : collection) {
                ExtensionsManager.EffectMode effectMode2 = (ExtensionsManager.EffectMode) useCaseConfig.getUseCaseConfig().retrieveOption(ImageCaptureExtender.OPTION_IMAGE_CAPTURE_EXTENDER_MODE, null);
                if (effectMode == effectMode2) {
                    z2 = true;
                } else if (effectMode2 != null) {
                    z = true;
                }
            }
            if (z) {
                ExtensionsManager.postExtensionsError(ExtensionsErrorListener.ExtensionsErrorCode.MISMATCHED_EXTENSIONS_ENABLED);
            } else if (!z2) {
                ExtensionsManager.postExtensionsError(ExtensionsErrorListener.ExtensionsErrorCode.IMAGE_CAPTURE_EXTENSION_REQUIRED);
            }
        }
    }

    private static class PreviewExtenderAdapter extends CameraEventCallback implements UseCase.EventCallback {
        volatile boolean mActive = true;
        final CloseableProcessor mCloseableProcessor;
        final ExtensionsManager.EffectMode mEffectMode;
        private volatile int mEnabledSessionCount = 0;
        final PreviewExtenderImpl mImpl;
        final Object mLock = new Object();
        private volatile boolean mUnbind = false;

        PreviewExtenderAdapter(PreviewExtenderImpl previewExtenderImpl, ExtensionsManager.EffectMode effectMode, CloseableProcessor closeableProcessor) {
            this.mImpl = previewExtenderImpl;
            this.mEffectMode = effectMode;
            this.mCloseableProcessor = closeableProcessor;
        }

        public void onBind(String str) {
            if (this.mActive) {
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
            synchronized (this.mLock) {
                if (this.mActive) {
                    if (this.mCloseableProcessor != null) {
                        this.mCloseableProcessor.close();
                    }
                    this.mImpl.onDeInit();
                    this.mActive = false;
                }
            }
        }

        public CaptureConfig onPresetSession() {
            synchronized (this.mLock) {
                if (this.mActive) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class androidx.camera.extensions.PreviewExtender.PreviewExtenderAdapter.AnonymousClass1 */

                        public void run() {
                            PreviewExtender.checkImageCaptureEnabled(PreviewExtenderAdapter.this.mEffectMode, CameraX.getActiveUseCases());
                        }
                    });
                }
                CaptureStageImpl onPresetSession = this.mImpl.onPresetSession();
                if (onPresetSession == null) {
                    return null;
                }
                CaptureConfig captureConfig = new AdaptingCaptureStage(onPresetSession).getCaptureConfig();
                return captureConfig;
            }
        }

        public CaptureConfig onEnableSession() {
            CaptureStageImpl onEnableSession;
            try {
                synchronized (this.mLock) {
                    if (!this.mActive || (onEnableSession = this.mImpl.onEnableSession()) == null) {
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
                }
            } catch (Throwable th) {
                synchronized (this.mLock) {
                    this.mEnabledSessionCount++;
                    throw th;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            r2 = r3.mLock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r3.mEnabledSessionCount--;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
            if (r3.mEnabledSessionCount != 0) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
            if (r3.mUnbind == false) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
            callDeInit();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0033, code lost:
            r1 = r3.mLock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0036, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            r3.mEnabledSessionCount--;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x003f, code lost:
            if (r3.mEnabledSessionCount != 0) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0043, code lost:
            if (r3.mUnbind == false) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0045, code lost:
            callDeInit();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0048, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0049, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.camera.core.impl.CaptureConfig onDisableSession() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.mLock     // Catch:{ all -> 0x0050 }
                monitor-enter(r0)     // Catch:{ all -> 0x0050 }
                boolean r1 = r3.mActive     // Catch:{ all -> 0x004d }
                if (r1 == 0) goto L_0x0032
                androidx.camera.extensions.impl.PreviewExtenderImpl r1 = r3.mImpl     // Catch:{ all -> 0x004d }
                androidx.camera.extensions.impl.CaptureStageImpl r1 = r1.onDisableSession()     // Catch:{ all -> 0x004d }
                if (r1 == 0) goto L_0x0032
                androidx.camera.extensions.AdaptingCaptureStage r2 = new androidx.camera.extensions.AdaptingCaptureStage     // Catch:{ all -> 0x004d }
                r2.<init>(r1)     // Catch:{ all -> 0x004d }
                androidx.camera.core.impl.CaptureConfig r1 = r2.getCaptureConfig()     // Catch:{ all -> 0x004d }
                monitor-exit(r0)     // Catch:{ all -> 0x004d }
                java.lang.Object r2 = r3.mLock
                monitor-enter(r2)
                int r0 = r3.mEnabledSessionCount     // Catch:{ all -> 0x002f }
                int r0 = r0 + -1
                r3.mEnabledSessionCount = r0     // Catch:{ all -> 0x002f }
                int r0 = r3.mEnabledSessionCount     // Catch:{ all -> 0x002f }
                if (r0 != 0) goto L_0x002d
                boolean r0 = r3.mUnbind     // Catch:{ all -> 0x002f }
                if (r0 == 0) goto L_0x002d
                r3.callDeInit()     // Catch:{ all -> 0x002f }
            L_0x002d:
                monitor-exit(r2)     // Catch:{ all -> 0x002f }
                return r1
            L_0x002f:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x002f }
                throw r0
            L_0x0032:
                monitor-exit(r0)     // Catch:{ all -> 0x004d }
                r0 = 0
                java.lang.Object r1 = r3.mLock
                monitor-enter(r1)
                int r2 = r3.mEnabledSessionCount     // Catch:{ all -> 0x004a }
                int r2 = r2 + -1
                r3.mEnabledSessionCount = r2     // Catch:{ all -> 0x004a }
                int r2 = r3.mEnabledSessionCount     // Catch:{ all -> 0x004a }
                if (r2 != 0) goto L_0x0048
                boolean r2 = r3.mUnbind     // Catch:{ all -> 0x004a }
                if (r2 == 0) goto L_0x0048
                r3.callDeInit()     // Catch:{ all -> 0x004a }
            L_0x0048:
                monitor-exit(r1)     // Catch:{ all -> 0x004a }
                return r0
            L_0x004a:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x004a }
                throw r0
            L_0x004d:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x004d }
                throw r1     // Catch:{ all -> 0x0050 }
            L_0x0050:
                r0 = move-exception
                java.lang.Object r1 = r3.mLock
                monitor-enter(r1)
                int r2 = r3.mEnabledSessionCount     // Catch:{ all -> 0x0067 }
                int r2 = r2 + -1
                r3.mEnabledSessionCount = r2     // Catch:{ all -> 0x0067 }
                int r2 = r3.mEnabledSessionCount     // Catch:{ all -> 0x0067 }
                if (r2 != 0) goto L_0x0065
                boolean r2 = r3.mUnbind     // Catch:{ all -> 0x0067 }
                if (r2 == 0) goto L_0x0065
                r3.callDeInit()     // Catch:{ all -> 0x0067 }
            L_0x0065:
                monitor-exit(r1)     // Catch:{ all -> 0x0067 }
                throw r0
            L_0x0067:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0067 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.PreviewExtender.PreviewExtenderAdapter.onDisableSession():androidx.camera.core.impl.CaptureConfig");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.camera.core.impl.CaptureConfig onRepeating() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.mLock
                monitor-enter(r0)
                boolean r1 = r3.mActive     // Catch:{ all -> 0x001d }
                if (r1 == 0) goto L_0x001a
                androidx.camera.extensions.impl.PreviewExtenderImpl r1 = r3.mImpl     // Catch:{ all -> 0x001d }
                androidx.camera.extensions.impl.CaptureStageImpl r1 = r1.getCaptureStage()     // Catch:{ all -> 0x001d }
                if (r1 == 0) goto L_0x001a
                androidx.camera.extensions.AdaptingCaptureStage r2 = new androidx.camera.extensions.AdaptingCaptureStage     // Catch:{ all -> 0x001d }
                r2.<init>(r1)     // Catch:{ all -> 0x001d }
                androidx.camera.core.impl.CaptureConfig r1 = r2.getCaptureConfig()     // Catch:{ all -> 0x001d }
                monitor-exit(r0)     // Catch:{ all -> 0x001d }
                return r1
            L_0x001a:
                monitor-exit(r0)     // Catch:{ all -> 0x001d }
                r0 = 0
                return r0
            L_0x001d:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x001d }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.PreviewExtender.PreviewExtenderAdapter.onRepeating():androidx.camera.core.impl.CaptureConfig");
        }
    }
}
