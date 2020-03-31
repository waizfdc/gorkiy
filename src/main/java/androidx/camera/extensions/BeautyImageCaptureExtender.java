package androidx.camera.extensions;

import android.util.Log;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.extensions.impl.BeautyImageCaptureExtenderImpl;

public class BeautyImageCaptureExtender extends ImageCaptureExtender {
    private static final String TAG = "BeautyICExtender";

    public static BeautyImageCaptureExtender create(ImageCapture.Builder builder) {
        if (ExtensionVersion.isExtensionVersionSupported()) {
            try {
                return new VendorBeautyImageCaptureExtender(builder);
            } catch (NoClassDefFoundError unused) {
                Log.d(TAG, "No beauty image capture extender found. Falling back to default.");
            }
        }
        return new DefaultBeautyImageCaptureExtender();
    }

    static class DefaultBeautyImageCaptureExtender extends BeautyImageCaptureExtender {
        public void enableExtension(CameraSelector cameraSelector) {
        }

        public boolean isExtensionAvailable(CameraSelector cameraSelector) {
            return false;
        }

        DefaultBeautyImageCaptureExtender() {
            super();
        }
    }

    static class VendorBeautyImageCaptureExtender extends BeautyImageCaptureExtender {
        private final BeautyImageCaptureExtenderImpl mImpl;

        VendorBeautyImageCaptureExtender(ImageCapture.Builder builder) {
            super();
            BeautyImageCaptureExtenderImpl beautyImageCaptureExtenderImpl = new BeautyImageCaptureExtenderImpl();
            this.mImpl = beautyImageCaptureExtenderImpl;
            init(builder, beautyImageCaptureExtenderImpl, ExtensionsManager.EffectMode.BEAUTY);
        }
    }

    private BeautyImageCaptureExtender() {
    }
}
