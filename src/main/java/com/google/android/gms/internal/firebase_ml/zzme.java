package com.google.android.gms.internal.firebase_ml;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzme<T> extends zzlz<T> {
    private final T zzagy;

    zzme(T t) {
        this.zzagy = t;
    }

    public final boolean isPresent() {
        return true;
    }

    public final T get() {
        return this.zzagy;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzme) {
            return this.zzagy.equals(((zzme) obj).zzagy);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzagy.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzagy);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
