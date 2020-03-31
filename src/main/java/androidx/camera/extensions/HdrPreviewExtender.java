package androidx.camera.extensions;

import android.util.Log;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.extensions.impl.HdrPreviewExtenderImpl;

public class HdrPreviewExtender extends PreviewExtender {
    private static final String TAG = "HdrPreviewExtender";

    public static HdrPreviewExtender create(Preview.Builder builder) {
        if (ExtensionVersion.isExtensionVersionSupported()) {
            try {
                return new VendorHdrPreviewExtender(builder);
            } catch (NoClassDefFoundError unused) {
                Log.d(TAG, "No HDR preview extender found. Falling back to default.");
            }
        }
        return new DefaultHdrPreviewExtender();
    }

    static class DefaultHdrPreviewExtender extends HdrPreviewExtender {
        public void enableExtension(CameraSelector cameraSelector) {
        }

        public boolean isExtensionAvailable(CameraSelector cameraSelector) {
            return false;
        }

        DefaultHdrPreviewExtender() {
            super();
        }
    }

    static class VendorHdrPreviewExtender extends HdrPreviewExtender {
        private final HdrPreviewExtenderImpl mImpl;

        VendorHdrPreviewExtender(Preview.Builder builder) {
            super();
            HdrPreviewExtenderImpl hdrPreviewExtenderImpl = new HdrPreviewExtenderImpl();
            this.mImpl = hdrPreviewExtenderImpl;
            init(builder, hdrPreviewExtenderImpl, ExtensionsManager.EffectMode.HDR);
        }
    }

    private HdrPreviewExtender() {
    }
}
