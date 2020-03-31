package androidx.camera.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInfoProcessor;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class Preview extends UseCase {
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final String TAG = "Preview";
    private Size mLatestResolution;
    Executor mPreviewSurfaceProviderExecutor;
    private Handler mProcessingPreviewHandler;
    private HandlerThread mProcessingPreviewThread;
    private DeferrableSurface mSessionDeferrableSurface;
    SurfaceProvider mSurfaceProvider;

    public interface SurfaceProvider {
        void onSurfaceRequested(SurfaceRequest surfaceRequest);
    }

    Preview(PreviewConfig previewConfig) {
        super(previewConfig);
    }

    /* access modifiers changed from: package-private */
    public SessionConfig.Builder createPipeline(final String str, final PreviewConfig previewConfig, final Size size) {
        Threads.checkMainThread();
        Preconditions.checkState(isPreviewSurfaceProviderSet());
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(previewConfig);
        CaptureProcessor captureProcessor = previewConfig.getCaptureProcessor(null);
        SurfaceRequest surfaceRequest = new SurfaceRequest(size);
        this.mPreviewSurfaceProviderExecutor.execute(new Runnable(surfaceRequest) {
            /* class androidx.camera.core.$$Lambda$Preview$TapRxcAo4pDHsGfM4Thz6iica6w */
            private final /* synthetic */ SurfaceRequest f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Preview.this.lambda$createPipeline$0$Preview(this.f$1);
            }
        });
        if (captureProcessor != null) {
            CaptureStage.DefaultCaptureStage defaultCaptureStage = new CaptureStage.DefaultCaptureStage();
            if (this.mProcessingPreviewHandler == null) {
                HandlerThread handlerThread = new HandlerThread("ProcessingSurfaceTexture");
                this.mProcessingPreviewThread = handlerThread;
                handlerThread.start();
                this.mProcessingPreviewHandler = new Handler(this.mProcessingPreviewThread.getLooper());
            }
            ProcessingSurface processingSurface = new ProcessingSurface(size.getWidth(), size.getHeight(), 35, this.mProcessingPreviewHandler, defaultCaptureStage, captureProcessor, surfaceRequest.getDeferrableSurface());
            createFrom.addCameraCaptureCallback(processingSurface.getCameraCaptureCallback());
            this.mSessionDeferrableSurface = processingSurface;
            createFrom.setTag(Integer.valueOf(defaultCaptureStage.getId()));
        } else {
            final ImageInfoProcessor imageInfoProcessor = previewConfig.getImageInfoProcessor(null);
            if (imageInfoProcessor != null) {
                createFrom.addCameraCaptureCallback(new CameraCaptureCallback() {
                    /* class androidx.camera.core.Preview.AnonymousClass1 */

                    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
                        super.onCaptureCompleted(cameraCaptureResult);
                        if (imageInfoProcessor.process(new CameraCaptureResultImageInfo(cameraCaptureResult))) {
                            Preview.this.notifyUpdated();
                        }
                    }
                });
            }
            this.mSessionDeferrableSurface = surfaceRequest.getDeferrableSurface();
        }
        createFrom.addSurface(this.mSessionDeferrableSurface);
        createFrom.addErrorListener(new SessionConfig.ErrorListener() {
            /* class androidx.camera.core.Preview.AnonymousClass2 */

            public void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                if (Preview.this.isCurrentlyBoundCamera(str)) {
                    Preview.this.attachToCamera(str, Preview.this.createPipeline(str, previewConfig, size).build());
                    Preview.this.notifyReset();
                }
            }
        });
        return createFrom;
    }

    public /* synthetic */ void lambda$createPipeline$0$Preview(SurfaceRequest surfaceRequest) {
        this.mSurfaceProvider.onSurfaceRequested(surfaceRequest);
    }

    public void setSurfaceProvider(Executor executor, SurfaceProvider surfaceProvider) {
        Threads.checkMainThread();
        if (surfaceProvider == null) {
            this.mSurfaceProvider = null;
            notifyInactive();
            return;
        }
        this.mSurfaceProvider = surfaceProvider;
        this.mPreviewSurfaceProviderExecutor = executor;
        notifyActive();
        if (this.mLatestResolution != null) {
            updateConfigAndOutput(getBoundCameraId(), (PreviewConfig) getUseCaseConfig(), this.mLatestResolution);
        }
    }

    public void setSurfaceProvider(SurfaceProvider surfaceProvider) {
        setSurfaceProvider(CameraXExecutors.mainThreadExecutor(), surfaceProvider);
    }

    /* access modifiers changed from: package-private */
    public boolean isPreviewSurfaceProviderSet() {
        return (this.mSurfaceProvider == null || this.mPreviewSurfaceProviderExecutor == null) ? false : true;
    }

    private void updateConfigAndOutput(String str, PreviewConfig previewConfig, Size size) {
        Preconditions.checkState(isPreviewSurfaceProviderSet());
        attachToCamera(str, createPipeline(str, previewConfig, size).build());
    }

    public int getTargetRotation() {
        return ((PreviewConfig) getUseCaseConfig()).getTargetRotation();
    }

    public String toString() {
        return "Preview:" + getName();
    }

    /* access modifiers changed from: protected */
    public UseCaseConfig.Builder<?, ?, ?> getDefaultBuilder(CameraInfo cameraInfo) {
        PreviewConfig previewConfig = (PreviewConfig) CameraX.getDefaultUseCaseConfig(PreviewConfig.class, cameraInfo);
        if (previewConfig != null) {
            return Builder.fromConfig(previewConfig);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public UseCaseConfig<?> applyDefaults(UseCaseConfig<?> useCaseConfig, UseCaseConfig.Builder<?, ?, ?> builder) {
        Rational correctedAspectRatio;
        PreviewConfig previewConfig = (PreviewConfig) super.applyDefaults(useCaseConfig, builder);
        CameraInternal boundCamera = getBoundCamera();
        if (boundCamera == null || !CameraX.getSurfaceManager().requiresCorrectedAspectRatio(boundCamera.getCameraInfoInternal().getCameraId()) || (correctedAspectRatio = CameraX.getSurfaceManager().getCorrectedAspectRatio(boundCamera.getCameraInfoInternal().getCameraId(), previewConfig.getTargetRotation(0))) == null) {
            return previewConfig;
        }
        Builder fromConfig = Builder.fromConfig(previewConfig);
        fromConfig.setTargetAspectRatioCustom(correctedAspectRatio);
        return fromConfig.getUseCaseConfig();
    }

    public void clear() {
        notifyInactive();
        DeferrableSurface deferrableSurface = this.mSessionDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        super.clear();
    }

    /* access modifiers changed from: protected */
    public Map<String, Size> onSuggestedResolutionUpdated(Map<String, Size> map) {
        String boundCameraId = getBoundCameraId();
        Size size = map.get(boundCameraId);
        if (size != null) {
            this.mLatestResolution = size;
            if (isPreviewSurfaceProviderSet()) {
                updateConfigAndOutput(boundCameraId, (PreviewConfig) getUseCaseConfig(), size);
            }
            return map;
        }
        throw new IllegalArgumentException("Suggested resolution map missing resolution for camera " + boundCameraId);
    }

    public static final class Defaults implements ConfigProvider<PreviewConfig> {
        private static final PreviewConfig DEFAULT_CONFIG = new Builder().setMaxResolution(DEFAULT_MAX_RESOLUTION).setSurfaceOccupancyPriority(2).getUseCaseConfig();
        private static final Size DEFAULT_MAX_RESOLUTION = CameraX.getSurfaceManager().getPreviewSize();
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 2;

        public PreviewConfig getConfig(CameraInfo cameraInfo) {
            return DEFAULT_CONFIG;
        }
    }

    public static final class Builder implements UseCaseConfig.Builder<Preview, PreviewConfig, Builder>, ImageOutputConfig.Builder<Builder>, ThreadConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(Preview.class)) {
                setTargetClass((Class<Preview>) Preview.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }

        public static Builder fromConfig(PreviewConfig previewConfig) {
            return new Builder(MutableOptionsBundle.from((Config) previewConfig));
        }

        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        public PreviewConfig getUseCaseConfig() {
            return new PreviewConfig(OptionsBundle.from(this.mMutableConfig));
        }

        public Preview build() {
            if (getMutableConfig().retrieveOption(PreviewConfig.OPTION_TARGET_ASPECT_RATIO, null) == null || getMutableConfig().retrieveOption(PreviewConfig.OPTION_TARGET_RESOLUTION, null) == null) {
                return new Preview(getUseCaseConfig());
            }
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }

        public Builder setTargetClass(Class<Preview> cls) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(PreviewConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        public Builder setTargetName(String str) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_TARGET_NAME, str);
            return this;
        }

        public Builder setTargetAspectRatioCustom(Rational rational) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_TARGET_ASPECT_RATIO_CUSTOM, rational);
            getMutableConfig().removeOption(PreviewConfig.OPTION_TARGET_ASPECT_RATIO);
            return this;
        }

        public Builder setTargetAspectRatio(int i) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_TARGET_ASPECT_RATIO, Integer.valueOf(i));
            return this;
        }

        public Builder setTargetRotation(int i) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i));
            return this;
        }

        public Builder setTargetResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, size);
            if (size != null) {
                getMutableConfig().insertOption(PreviewConfig.OPTION_TARGET_ASPECT_RATIO_CUSTOM, new Rational(size.getWidth(), size.getHeight()));
            }
            return this;
        }

        public Builder setDefaultResolution(Size size) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_DEFAULT_RESOLUTION, size);
            return this;
        }

        public Builder setMaxResolution(Size size) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_MAX_RESOLUTION, size);
            return this;
        }

        public Builder setSupportedResolutions(List<Pair<Integer, Size[]>> list) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
            return this;
        }

        public Builder setBackgroundExecutor(Executor executor) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_BACKGROUND_EXECUTOR, executor);
            return this;
        }

        public Builder setDefaultSessionConfig(SessionConfig sessionConfig) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        public Builder setDefaultCaptureConfig(CaptureConfig captureConfig) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        public Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        public Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        public Builder setSurfaceOccupancyPriority(int i) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i));
            return this;
        }

        public Builder setCameraSelector(CameraSelector cameraSelector) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
            return this;
        }

        public Builder setUseCaseEventCallback(UseCase.EventCallback eventCallback) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
            return this;
        }

        public Builder setImageInfoProcessor(ImageInfoProcessor imageInfoProcessor) {
            getMutableConfig().insertOption(PreviewConfig.IMAGE_INFO_PROCESSOR, imageInfoProcessor);
            return this;
        }

        public Builder setCaptureProcessor(CaptureProcessor captureProcessor) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_PREVIEW_CAPTURE_PROCESSOR, captureProcessor);
            return this;
        }
    }
}
