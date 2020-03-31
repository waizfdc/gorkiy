package androidx.camera.camera2.internal;

import android.content.Context;
import android.view.WindowManager;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.SessionConfig;

public final class ImageCaptureConfigProvider implements ConfigProvider<ImageCaptureConfig> {
    private static final String TAG = "ImageCaptureProvider";
    private final WindowManager mWindowManager;

    public ImageCaptureConfigProvider(Context context) {
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    public ImageCaptureConfig getConfig(CameraInfo cameraInfo) {
        ImageCapture.Builder fromConfig = ImageCapture.Builder.fromConfig(ImageCapture.DEFAULT_CONFIG.getConfig(cameraInfo));
        SessionConfig.Builder builder = new SessionConfig.Builder();
        boolean z = true;
        builder.setTemplateType(1);
        fromConfig.setDefaultSessionConfig(builder.build());
        fromConfig.setSessionOptionUnpacker((SessionConfig.OptionUnpacker) Camera2SessionOptionUnpacker.INSTANCE);
        CaptureConfig.Builder builder2 = new CaptureConfig.Builder();
        builder2.setTemplateType(2);
        fromConfig.setDefaultCaptureConfig(builder2.build());
        fromConfig.setCaptureOptionUnpacker((CaptureConfig.OptionUnpacker) ImageCaptureOptionUnpacker.INSTANCE);
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
