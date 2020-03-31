package androidx.camera.extensions;

import android.util.Log;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.extensions.impl.BokehImageCaptureExtenderImpl;

public class BokehImageCaptureExtender extends ImageCaptureExtender {
    private static final String TAG = "BokehImgCaptureExtender";

    public static BokehImageCaptureExtender create(ImageCapture.Builder builder) {
        if (ExtensionVersion.isExtensionVersionSupported()) {
            try {
                return new VendorBokehImageCaptureExtender(builder);
            } catch (NoClassDefFoundError unused) {
                Log.d(TAG, "No bokeh image capture extender found. Falling back to default.");
            }
        }
        return new DefaultBokehImageCaptureExtender();
    }

    private static class DefaultBokehImageCaptureExtender extends BokehImageCaptureExtender {
        public void enableExtension(CameraSelector cameraSelector) {
        }

        public boolean isExtensionAvailable(CameraSelector cameraSelector) {
            return false;
        }

        DefaultBokehImageCaptureExtender() {
            super();
        }
    }

    private static class VendorBokehImageCaptureExtender extends BokehImageCaptureExtender {
        private final BokehImageCaptureExtenderImpl mImpl;

        VendorBokehImageCaptureExtender(ImageCapture.Builder builder) {
            super();
            BokehImageCaptureExtenderImpl bokehImageCaptureExtenderImpl = new BokehImageCaptureExtenderImpl();
            this.mImpl = bokehImageCaptureExtenderImpl;
            init(builder, bokehImageCaptureExtenderImpl, ExtensionsManager.EffectMode.BOKEH);
        }
    }

    private BokehImageCaptureExtender() {
    }
}
