package androidx.camera.camera2;

import android.content.Context;
import androidx.camera.camera2.internal.ImageAnalysisConfigProvider;
import androidx.camera.camera2.internal.ImageCaptureConfigProvider;
import androidx.camera.camera2.internal.PreviewConfigProvider;
import androidx.camera.camera2.internal.VideoCaptureConfigProvider;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.impl.ExtendableUseCaseConfigFactory;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.VideoCaptureConfig;

public final class Camera2Config {
    private Camera2Config() {
    }

    public static CameraXConfig defaultConfig() {
        $$Lambda$ejR8dmSIsD2lu5sM8guFNf47Yk r0 = $$Lambda$ejR8dmSIsD2lu5sM8guFNf47Yk.INSTANCE;
        $$Lambda$Zqb088M5OSR69nGBYdSNqZX7Yfw r1 = $$Lambda$Zqb088M5OSR69nGBYdSNqZX7Yfw.INSTANCE;
        return new CameraXConfig.Builder().setCameraFactoryProvider(r0).setDeviceSurfaceManagerProvider(r1).setUseCaseConfigFactoryProvider($$Lambda$Camera2Config$92ESQ0e9eCnVdV8AqGLQ_KzLN1U.INSTANCE).build();
    }

    static /* synthetic */ UseCaseConfigFactory lambda$defaultConfig$0(Context context) {
        ExtendableUseCaseConfigFactory extendableUseCaseConfigFactory = new ExtendableUseCaseConfigFactory();
        extendableUseCaseConfigFactory.installDefaultProvider(ImageAnalysisConfig.class, new ImageAnalysisConfigProvider(context));
        extendableUseCaseConfigFactory.installDefaultProvider(ImageCaptureConfig.class, new ImageCaptureConfigProvider(context));
        extendableUseCaseConfigFactory.installDefaultProvider(VideoCaptureConfig.class, new VideoCaptureConfigProvider(context));
        extendableUseCaseConfigFactory.installDefaultProvider(PreviewConfig.class, new PreviewConfigProvider(context));
        return extendableUseCaseConfigFactory;
    }

    public static final class DefaultProvider implements CameraXConfig.Provider {
        public CameraXConfig getCameraXConfig() {
            return Camera2Config.defaultConfig();
        }
    }
}
