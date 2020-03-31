package androidx.camera.extensions;

import android.util.Log;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.extensions.impl.HdrImageCaptureExtenderImpl;

public class HdrImageCaptureExtender extends ImageCaptureExtender {
    private static final String TAG = "HdrImageCaptureExtender";

    public static HdrImageCaptureExtender create(ImageCapture.Builder builder) {
        if (ExtensionVersion.isExtensionVersionSupported()) {
            try {
                return new VendorHdrImageCaptureExtender(builder);
            } catch (NoClassDefFoundError unused) {
                Log.d(TAG, "No HDR image capture extender found. Falling back to default.");
            }
        }
        return new DefaultHdrImageCaptureExtender();
    }

    static class DefaultHdrImageCaptureExtender extends HdrImageCaptureExtender {
        public void enableExtension(CameraSelector cameraSelector) {
        }

        public boolean isExtensionAvailable(CameraSelector cameraSelector) {
            return false;
        }

        DefaultHdrImageCaptureExtender() {
            super();
        }
    }

    static class VendorHdrImageCaptureExtender extends HdrImageCaptureExtender {
        private final HdrImageCaptureExtenderImpl mImpl;

        VendorHdrImageCaptureExtender(ImageCapture.Builder builder) {
            super();
            HdrImageCaptureExtenderImpl hdrImageCaptureExtenderImpl = new HdrImageCaptureExtenderImpl();
            this.mImpl = hdrImageCaptureExtenderImpl;
            init(builder, hdrImageCaptureExtenderImpl, ExtensionsManager.EffectMode.HDR);
        }
    }

    private HdrImageCaptureExtender() {
    }
}
