package androidx.camera.extensions;

final class AutoValue_Version extends Version {
    private final String description;
    private final int major;
    private final int minor;
    private final int patch;

    AutoValue_Version(int i, int i2, int i3, String str) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
        if (str != null) {
            this.description = str;
            return;
        }
        throw new NullPointerException("Null description");
    }

    /* access modifiers changed from: package-private */
    public int getMajor() {
        return this.major;
    }

    /* access modifiers changed from: package-private */
    public int getMinor() {
        return this.minor;
    }

    /* access modifiers changed from: package-private */
    public int getPatch() {
        return this.patch;
    }

    /* access modifiers changed from: package-private */
    public String getDescription() {
        return this.description;
    }
}
