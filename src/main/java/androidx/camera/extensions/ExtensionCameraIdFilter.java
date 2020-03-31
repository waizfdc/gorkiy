package androidx.camera.extensions;

import androidx.camera.core.impl.CameraIdFilter;
import androidx.camera.extensions.impl.ImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.PreviewExtenderImpl;
import java.util.LinkedHashSet;
import java.util.Set;

public final class ExtensionCameraIdFilter implements CameraIdFilter {
    private ImageCaptureExtenderImpl mImageCaptureExtenderImpl;
    private PreviewExtenderImpl mPreviewExtenderImpl;

    ExtensionCameraIdFilter(PreviewExtenderImpl previewExtenderImpl) {
        this.mPreviewExtenderImpl = previewExtenderImpl;
        this.mImageCaptureExtenderImpl = null;
    }

    ExtensionCameraIdFilter(ImageCaptureExtenderImpl imageCaptureExtenderImpl) {
        this.mPreviewExtenderImpl = null;
        this.mImageCaptureExtenderImpl = imageCaptureExtenderImpl;
    }

    ExtensionCameraIdFilter(PreviewExtenderImpl previewExtenderImpl, ImageCaptureExtenderImpl imageCaptureExtenderImpl) {
        this.mPreviewExtenderImpl = previewExtenderImpl;
        this.mImageCaptureExtenderImpl = imageCaptureExtenderImpl;
    }

    public Set<String> filter(Set<String> set) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String next : set) {
            boolean z = true;
            PreviewExtenderImpl previewExtenderImpl = this.mPreviewExtenderImpl;
            if (previewExtenderImpl != null) {
                z = previewExtenderImpl.isExtensionAvailable(next, CameraUtil.getCameraCharacteristics(next));
            }
            ImageCaptureExtenderImpl imageCaptureExtenderImpl = this.mImageCaptureExtenderImpl;
            if (imageCaptureExtenderImpl != null) {
                z = imageCaptureExtenderImpl.isExtensionAvailable(next, CameraUtil.getCameraCharacteristics(next));
            }
            if (z) {
                linkedHashSet.add(next);
            }
        }
        return linkedHashSet;
    }
}
