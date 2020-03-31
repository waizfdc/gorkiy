package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzcy<T> implements zzcu<T>, Serializable {
    @NullableDecl
    private final T zzlk;

    zzcy(@NullableDecl T t) {
        this.zzlk = t;
    }

    public final T get() {
        return this.zzlk;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzcy) {
            return zzco.equal(this.zzlk, ((zzcy) obj).zzlk);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzlk});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzlk);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
