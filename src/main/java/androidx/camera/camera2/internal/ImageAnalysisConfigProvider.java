package androidx.camera.camera2.internal;

import android.content.Context;
import android.view.WindowManager;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.SessionConfig;

public final class ImageAnalysisConfigProvider implements ConfigProvider<ImageAnalysisConfig> {
    private static final String TAG = "ImageAnalysisProvider";
    private final WindowManager mWindowManager;

    public ImageAnalysisConfigProvider(Context context) {
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    public ImageAnalysisConfig getConfig(CameraInfo cameraInfo) {
        ImageAnalysis.Builder fromConfig = ImageAnalysis.Builder.fromConfig(ImageAnalysis.DEFAULT_CONFIG.getConfig(cameraInfo));
        SessionConfig.Builder builder = new SessionConfig.Builder();
        boolean z = true;
        builder.setTemplateType(1);
        fromConfig.setDefaultSessionConfig(builder.build());
        fromConfig.setSessionOptionUnpacker((SessionConfig.OptionUnpacker) Camera2SessionOptionUnpacker.INSTANCE);
        CaptureConfig.Builder builder2 = new CaptureConfig.Builder();
        builder2.setTemplateType(1);
        fromConfig.setDefaultCaptureConfig(builder2.build());
        fromConfig.setCaptureOptionUnpacker((CaptureConfig.OptionUnpacker) Camera2CaptureOptionUnpacker.INSTANCE);
        int rotation = this.mWindowManager.getDefaultDisplay().getRotation();
        fromConfig.setTargetRotation(rotation);
        if (cameraInfo != null) {
            int sensorRotationDegrees = cameraInfo.getSensorRotationDegrees(rotation);
            if (!(sensorRotationDegrees == 90 || sensorRotationDegrees == 270)) {
                z = false;
            }
            fromConfig.setTargetAspectRatioCustom(z ? ImageOutputConfig.DEFAULT_ASPECT_RATIO_PORTRAIT : ImageOutputConfig.DEFAULT_ASPECT_RATIO_LANDSCAPE);
        }
        return fromConfig.getUseCaseConfig();
    }
}
