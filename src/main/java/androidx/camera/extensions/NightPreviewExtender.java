package androidx.camera.extensions;

import android.util.Log;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.extensions.impl.NightPreviewExtenderImpl;

public class NightPreviewExtender extends PreviewExtender {
    private static final String TAG = "NightPreviewExtender";

    public static NightPreviewExtender create(Preview.Builder builder) {
        if (ExtensionVersion.isExtensionVersionSupported()) {
            try {
                return new VendorNightPreviewExtender(builder);
            } catch (NoClassDefFoundError unused) {
                Log.d(TAG, "No night preview extender found. Falling back to default.");
            }
        }
        return new DefaultNightPreviewExtender();
    }

    static class DefaultNightPreviewExtender extends NightPreviewExtender {
        public void enableExtension(CameraSelector cameraSelector) {
        }

        public boolean isExtensionAvailable(CameraSelector cameraSelector) {
            return false;
        }

        DefaultNightPreviewExtender() {
            super();
        }
    }

    static class VendorNightPreviewExtender extends NightPreviewExtender {
        private final NightPreviewExtenderImpl mImpl;

        VendorNightPreviewExtender(Preview.Builder builder) {
            super();
            NightPreviewExtenderImpl nightPreviewExtenderImpl = new NightPreviewExtenderImpl();
            this.mImpl = nightPreviewExtenderImpl;
            init(builder, nightPreviewExtenderImpl, ExtensionsManager.EffectMode.NIGHT);
        }
    }

    private NightPreviewExtender() {
    }
}
