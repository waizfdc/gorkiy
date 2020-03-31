package com.google.android.gms.internal.firebase_ml;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zznb {
    private final ConcurrentHashMap<zzna, List<Throwable>> zzaiv = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzaiw = new ReferenceQueue<>();

    zznb() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zzaiw.poll();
        while (poll != null) {
            this.zzaiv.remove(poll);
            poll = this.zzaiw.poll();
        }
        List<Throwable> list = this.zzaiv.get(new zzna(th, null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzaiv.putIfAbsent(new zzna(th, this.zzaiw), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
