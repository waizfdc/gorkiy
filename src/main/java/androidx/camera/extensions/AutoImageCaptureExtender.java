package androidx.camera.extensions;

import android.util.Log;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.extensions.impl.AutoImageCaptureExtenderImpl;

public class AutoImageCaptureExtender extends ImageCaptureExtender {
    private static final String TAG = "AutoICExtender";

    public static AutoImageCaptureExtender create(ImageCapture.Builder builder) {
        if (ExtensionVersion.isExtensionVersionSupported()) {
            try {
                return new VendorAutoImageCaptureExtender(builder);
            } catch (NoClassDefFoundError unused) {
                Log.d(TAG, "No auto image capture extender found. Falling back to default.");
            }
        }
        return new DefaultAutoImageCaptureExtender();
    }

    static class DefaultAutoImageCaptureExtender extends AutoImageCaptureExtender {
        public void enableExtension(CameraSelector cameraSelector) {
        }

        public boolean isExtensionAvailable(CameraSelector cameraSelector) {
            return false;
        }

        DefaultAutoImageCaptureExtender() {
            super();
        }
    }

    static class VendorAutoImageCaptureExtender extends AutoImageCaptureExtender {
        private final AutoImageCaptureExtenderImpl mImpl;

        VendorAutoImageCaptureExtender(ImageCapture.Builder builder) {
            super();
            AutoImageCaptureExtenderImpl autoImageCaptureExtenderImpl = new AutoImageCaptureExtenderImpl();
            this.mImpl = autoImageCaptureExtenderImpl;
            init(builder, autoImageCaptureExtenderImpl, ExtensionsManager.EffectMode.AUTO);
        }
    }

    private AutoImageCaptureExtender() {
    }
}
