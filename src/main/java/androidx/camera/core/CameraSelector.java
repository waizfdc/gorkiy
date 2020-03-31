package androidx.camera.core;

import androidx.camera.core.impl.CameraIdFilter;
import androidx.camera.core.impl.LensFacingCameraIdFilter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class CameraSelector {
    public static final CameraSelector DEFAULT_BACK_CAMERA = new Builder().requireLensFacing(1).build();
    public static final CameraSelector DEFAULT_FRONT_CAMERA = new Builder().requireLensFacing(0).build();
    public static final int LENS_FACING_BACK = 1;
    public static final int LENS_FACING_FRONT = 0;
    private LinkedHashSet<CameraIdFilter> mCameraFilterSet;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LensFacing {
    }

    CameraSelector(LinkedHashSet<CameraIdFilter> linkedHashSet) {
        this.mCameraFilterSet = linkedHashSet;
    }

    public String select(Set<String> set) {
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Iterator<CameraIdFilter> it = this.mCameraFilterSet.iterator();
        while (it.hasNext()) {
            linkedHashSet = it.next().filter(set);
            if (linkedHashSet.isEmpty()) {
                throw new IllegalArgumentException("No available camera can be found.");
            } else if (set.containsAll(linkedHashSet)) {
                set = linkedHashSet;
            } else {
                throw new IllegalArgumentException("The output isn't contained in the input.");
            }
        }
        return linkedHashSet.iterator().next();
    }

    public LinkedHashSet<CameraIdFilter> getCameraFilterSet() {
        return this.mCameraFilterSet;
    }

    public Integer getLensFacing() {
        Iterator<CameraIdFilter> it = this.mCameraFilterSet.iterator();
        Integer num = null;
        while (it.hasNext()) {
            CameraIdFilter next = it.next();
            if (next instanceof LensFacingCameraIdFilter) {
                Integer valueOf = Integer.valueOf(((LensFacingCameraIdFilter) next).getLensFacing());
                if (num == null) {
                    num = valueOf;
                } else if (!num.equals(valueOf)) {
                    throw new IllegalStateException("Multiple conflicting lens facing requirements exist.");
                }
            }
        }
        return num;
    }

    public static final class Builder {
        private final LinkedHashSet<CameraIdFilter> mCameraFilterSet;

        public Builder() {
            this.mCameraFilterSet = new LinkedHashSet<>();
        }

        private Builder(LinkedHashSet<CameraIdFilter> linkedHashSet) {
            this.mCameraFilterSet = new LinkedHashSet<>(linkedHashSet);
        }

        public Builder requireLensFacing(int i) {
            this.mCameraFilterSet.add(new LensFacingCameraIdFilter(i));
            return this;
        }

        public Builder appendFilter(CameraIdFilter cameraIdFilter) {
            this.mCameraFilterSet.add(cameraIdFilter);
            return this;
        }

        public static Builder fromSelector(CameraSelector cameraSelector) {
            return new Builder(cameraSelector.getCameraFilterSet());
        }

        public CameraSelector build() {
            return new CameraSelector(this.mCameraFilterSet);
        }
    }
}
