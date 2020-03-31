package androidx.camera.core;

final class AutoValue_ImmutableImageInfo extends ImmutableImageInfo {
    private final int rotationDegrees;
    private final Object tag;
    private final long timestamp;

    AutoValue_ImmutableImageInfo(Object obj, long j, int i) {
        this.tag = obj;
        this.timestamp = j;
        this.rotationDegrees = i;
    }

    public Object getTag() {
        return this.tag;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public String toString() {
        return "ImmutableImageInfo{tag=" + this.tag + ", timestamp=" + this.timestamp + ", rotationDegrees=" + this.rotationDegrees + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableImageInfo)) {
            return false;
        }
        ImmutableImageInfo immutableImageInfo = (ImmutableImageInfo) obj;
        Object obj2 = this.tag;
        if (obj2 != null ? obj2.equals(super.getTag()) : super.getTag() == null) {
            if (this.timestamp == super.getTimestamp() && this.rotationDegrees == super.getRotationDegrees()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.tag;
        int hashCode = obj == null ? 0 : obj.hashCode();
        long j = this.timestamp;
        return ((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.rotationDegrees;
    }
}
