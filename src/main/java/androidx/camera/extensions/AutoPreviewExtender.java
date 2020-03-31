package androidx.camera.extensions;

import android.util.Log;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.extensions.impl.AutoPreviewExtenderImpl;

public class AutoPreviewExtender extends PreviewExtender {
    private static final String TAG = "AutoPreviewExtender";

    public static AutoPreviewExtender create(Preview.Builder builder) {
        if (ExtensionVersion.isExtensionVersionSupported()) {
            try {
                return new VendorAutoPreviewExtender(builder);
            } catch (NoClassDefFoundError unused) {
                Log.d(TAG, "No auto preview extender found. Falling back to default.");
            }
        }
        return new DefaultAutoPreviewExtender();
    }

    static class DefaultAutoPreviewExtender extends AutoPreviewExtender {
        public void enableExtension(CameraSelector cameraSelector) {
        }

        public boolean isExtensionAvailable(CameraSelector cameraSelector) {
            return false;
        }

        DefaultAutoPreviewExtender() {
            super();
        }
    }

    static class VendorAutoPreviewExtender extends AutoPreviewExtender {
        private final AutoPreviewExtenderImpl mImpl;

        VendorAutoPreviewExtender(Preview.Builder builder) {
            super();
            AutoPreviewExtenderImpl autoPreviewExtenderImpl = new AutoPreviewExtenderImpl();
            this.mImpl = autoPreviewExtenderImpl;
            init(builder, autoPreviewExtenderImpl, ExtensionsManager.EffectMode.AUTO);
        }
    }

    private AutoPreviewExtender() {
    }
}
