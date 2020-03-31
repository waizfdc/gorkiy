package androidx.camera.extensions;

import android.util.Log;
import androidx.camera.extensions.impl.ExtensionVersionImpl;

abstract class ExtensionVersion {
    private static final String TAG = "ExtenderVersion";
    private static volatile ExtensionVersion sExtensionVersion;

    /* access modifiers changed from: package-private */
    public abstract Version getVersionObject();

    ExtensionVersion() {
    }

    private static ExtensionVersion getInstance() {
        if (sExtensionVersion != null) {
            return sExtensionVersion;
        }
        synchronized (ExtensionVersion.class) {
            if (sExtensionVersion == null) {
                try {
                    sExtensionVersion = new VendorExtenderVersioning();
                } catch (NoClassDefFoundError unused) {
                    Log.d(TAG, "No versioning extender found. Falling back to default.");
                    sExtensionVersion = new DefaultExtenderVersioning();
                }
            }
        }
        return sExtensionVersion;
    }

    static boolean isExtensionVersionSupported() {
        return getInstance().getVersionObject() != null;
    }

    static Version getRuntimeVersion() {
        return getInstance().getVersionObject();
    }

    private static class VendorExtenderVersioning extends ExtensionVersion {
        private ExtensionVersionImpl mImpl;
        private Version mRuntimeVersion;

        VendorExtenderVersioning() {
            ExtensionVersionImpl extensionVersionImpl = new ExtensionVersionImpl();
            this.mImpl = extensionVersionImpl;
            Version parse = Version.parse(extensionVersionImpl.checkApiVersion(VersionName.getCurrentVersion().toVersionString()));
            if (parse != null && VersionName.getCurrentVersion().getVersion().getMajor() == parse.getMajor()) {
                this.mRuntimeVersion = parse;
            }
            Log.d(ExtensionVersion.TAG, "Selected vendor runtime: " + this.mRuntimeVersion);
        }

        /* access modifiers changed from: package-private */
        public Version getVersionObject() {
            return this.mRuntimeVersion;
        }
    }

    private static class DefaultExtenderVersioning extends ExtensionVersion {
        /* access modifiers changed from: package-private */
        public Version getVersionObject() {
            return null;
        }

        DefaultExtenderVersioning() {
        }
    }
}
