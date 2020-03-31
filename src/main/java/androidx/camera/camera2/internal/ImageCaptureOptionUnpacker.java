package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeviceProperties;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.UseCaseConfig;

final class ImageCaptureOptionUnpacker extends Camera2CaptureOptionUnpacker {
    static final ImageCaptureOptionUnpacker INSTANCE = new ImageCaptureOptionUnpacker();
    private DeviceProperties mDeviceProperties = DeviceProperties.create();

    ImageCaptureOptionUnpacker() {
    }

    public void unpack(UseCaseConfig<?> useCaseConfig, CaptureConfig.Builder builder) {
        super.unpack(useCaseConfig, builder);
        if (useCaseConfig instanceof ImageCaptureConfig) {
            ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) useCaseConfig;
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            if (imageCaptureConfig.hasCaptureMode()) {
                applyPixelHdrPlusChangeForCaptureMode(imageCaptureConfig.getCaptureMode(), builder2);
            }
            builder.addImplementationOptions(builder2.build());
            return;
        }
        throw new IllegalArgumentException("config is not ImageCaptureConfig");
    }

    /* access modifiers changed from: package-private */
    public void setDeviceProperty(DeviceProperties deviceProperties) {
        this.mDeviceProperties = deviceProperties;
    }

    private void applyPixelHdrPlusChangeForCaptureMode(int i, Camera2ImplConfig.Builder builder) {
        if (!"Google".equals(this.mDeviceProperties.manufacturer())) {
            return;
        }
        if ((!"Pixel 2".equals(this.mDeviceProperties.model()) && !"Pixel 3".equals(this.mDeviceProperties.model())) || this.mDeviceProperties.sdkVersion() < 26) {
            return;
        }
        if (i == 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_ENABLE_ZSL, true);
        } else if (i == 1) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_ENABLE_ZSL, false);
        }
    }
}
