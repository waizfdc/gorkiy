package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
abstract class zzfy {
    private static final zzfy zza = new zzga();
    private static final zzfy zzb = new zzfz();

    private zzfy() {
    }

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);

    static zzfy zza() {
        return zza;
    }

    static zzfy zzb() {
        return zzb;
    }
}
