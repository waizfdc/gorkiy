package com.google.android.gms.internal.vision;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzdu {
    private final ConcurrentHashMap<zzdx, List<Throwable>> zzme = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzmf = new ReferenceQueue<>();

    zzdu() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zzmf.poll();
        while (poll != null) {
            this.zzme.remove(poll);
            poll = this.zzmf.poll();
        }
        List<Throwable> list = this.zzme.get(new zzdx(th, null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzme.putIfAbsent(new zzdx(th, this.zzmf), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
