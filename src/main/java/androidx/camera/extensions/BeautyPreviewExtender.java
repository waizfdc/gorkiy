package androidx.camera.extensions;

import android.util.Log;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.extensions.impl.BeautyPreviewExtenderImpl;

public class BeautyPreviewExtender extends PreviewExtender {
    private static final String TAG = "BeautyPreviewExtender";

    public static BeautyPreviewExtender create(Preview.Builder builder) {
        if (ExtensionVersion.isExtensionVersionSupported()) {
            try {
                return new VendorBeautyPreviewExtender(builder);
            } catch (NoClassDefFoundError unused) {
                Log.d(TAG, "No beauty preview extender found. Falling back to default.");
            }
        }
        return new DefaultBeautyPreviewExtender();
    }

    static class DefaultBeautyPreviewExtender extends BeautyPreviewExtender {
        public void enableExtension(CameraSelector cameraSelector) {
        }

        public boolean isExtensionAvailable(CameraSelector cameraSelector) {
            return false;
        }

        DefaultBeautyPreviewExtender() {
            super();
        }
    }

    static class VendorBeautyPreviewExtender extends BeautyPreviewExtender {
        private final BeautyPreviewExtenderImpl mImpl;

        VendorBeautyPreviewExtender(Preview.Builder builder) {
            super();
            BeautyPreviewExtenderImpl beautyPreviewExtenderImpl = new BeautyPreviewExtenderImpl();
            this.mImpl = beautyPreviewExtenderImpl;
            init(builder, beautyPreviewExtenderImpl, ExtensionsManager.EffectMode.BEAUTY);
        }
    }

    private BeautyPreviewExtender() {
    }
}
