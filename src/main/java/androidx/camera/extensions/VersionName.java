package androidx.camera.extensions;

public class VersionName {
    private static final VersionName CURRENT = new VersionName(BuildConfig.CAMERA_VERSION);
    private final Version mVersion;

    static VersionName getCurrentVersion() {
        return CURRENT;
    }

    public Version getVersion() {
        return this.mVersion;
    }

    VersionName(String str) {
        this.mVersion = Version.parse(str);
    }

    VersionName(int i, int i2, int i3, String str) {
        this.mVersion = Version.create(i, i2, i3, str);
    }

    public String toVersionString() {
        return this.mVersion.toString();
    }
}
