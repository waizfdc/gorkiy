package androidx.camera.extensions;

public interface ExtensionsErrorListener {

    public enum ExtensionsErrorCode {
        UNKNOWN,
        PREVIEW_EXTENSION_REQUIRED,
        IMAGE_CAPTURE_EXTENSION_REQUIRED,
        MISMATCHED_EXTENSIONS_ENABLED
    }

    void onError(ExtensionsErrorCode extensionsErrorCode);
}
