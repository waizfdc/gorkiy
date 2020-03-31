package androidx.camera.extensions;

import android.util.Log;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.extensions.impl.NightImageCaptureExtenderImpl;

public class NightImageCaptureExtender extends ImageCaptureExtender {
    private static final String TAG = "NightICExtender";

    public static NightImageCaptureExtender create(ImageCapture.Builder builder) {
        if (ExtensionVersion.isExtensionVersionSupported()) {
            try {
                return new VendorNightImageCaptureExtender(builder);
            } catch (NoClassDefFoundError unused) {
                Log.d(TAG, "No night image capture extender found. Falling back to default.");
            }
        }
        return new DefaultNightImageCaptureExtender();
    }

    static class DefaultNightImageCaptureExtender extends NightImageCaptureExtender {
        public void enableExtension(CameraSelector cameraSelector) {
        }

        public boolean isExtensionAvailable(CameraSelector cameraSelector) {
            return false;
        }

        DefaultNightImageCaptureExtender() {
            super();
        }
    }

    static class VendorNightImageCaptureExtender extends NightImageCaptureExtender {
        private final NightImageCaptureExtenderImpl mImpl;

        VendorNightImageCaptureExtender(ImageCapture.Builder builder) {
            super();
            NightImageCaptureExtenderImpl nightImageCaptureExtenderImpl = new NightImageCaptureExtenderImpl();
            this.mImpl = nightImageCaptureExtenderImpl;
            init(builder, nightImageCaptureExtenderImpl, ExtensionsManager.EffectMode.NIGHT);
        }
    }

    private NightImageCaptureExtender() {
    }
}
