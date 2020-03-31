package androidx.camera.core.impl.utils;

import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;

final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T mReference;

    public boolean isPresent() {
        return true;
    }

    Present(T t) {
        this.mReference = t;
    }

    public T get() {
        return this.mReference;
    }

    public T or(T t) {
        Preconditions.checkNotNull(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.mReference;
    }

    public Optional<T> or(Optional<? extends T> optional) {
        Preconditions.checkNotNull(optional);
        return super;
    }

    public T or(Supplier<? extends T> supplier) {
        Preconditions.checkNotNull(supplier);
        return this.mReference;
    }

    public T orNull() {
        return this.mReference;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Present) {
            return this.mReference.equals(((Present) obj).mReference);
        }
        return false;
    }

    public int hashCode() {
        return this.mReference.hashCode() + 1502476572;
    }

    public String toString() {
        return "Optional.of(" + ((Object) this.mReference) + ")";
    }
}
