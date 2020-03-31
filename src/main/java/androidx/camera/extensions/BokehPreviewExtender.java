package androidx.camera.extensions;

import android.util.Log;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.extensions.impl.BokehPreviewExtenderImpl;

public class BokehPreviewExtender extends PreviewExtender {
    private static final String TAG = "BokehPreviewExtender";

    public static BokehPreviewExtender create(Preview.Builder builder) {
        if (ExtensionVersion.isExtensionVersionSupported()) {
            try {
                return new VendorBokehPreviewExtender(builder);
            } catch (NoClassDefFoundError unused) {
                Log.d(TAG, "No bokeh preview extender found. Falling back to default.");
            }
        }
        return new DefaultBokehPreviewExtender();
    }

    private static class DefaultBokehPreviewExtender extends BokehPreviewExtender {
        public void enableExtension(CameraSelector cameraSelector) {
        }

        public boolean isExtensionAvailable(CameraSelector cameraSelector) {
            return false;
        }

        DefaultBokehPreviewExtender() {
            super();
        }
    }

    private static class VendorBokehPreviewExtender extends BokehPreviewExtender {
        private final BokehPreviewExtenderImpl mImpl;

        VendorBokehPreviewExtender(Preview.Builder builder) {
            super();
            BokehPreviewExtenderImpl bokehPreviewExtenderImpl = new BokehPreviewExtenderImpl();
            this.mImpl = bokehPreviewExtenderImpl;
            init(builder, bokehPreviewExtenderImpl, ExtensionsManager.EffectMode.BOKEH);
        }
    }

    private BokehPreviewExtender() {
    }
}
