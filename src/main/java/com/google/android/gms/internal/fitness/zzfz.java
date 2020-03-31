package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzgg;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzfz extends zzfw<zzgg.zzc> {
    zzfz() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(zzho zzho) {
        return zzho instanceof zzgg.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzgb<zzgg.zzc> zza(Object obj) {
        return ((zzgg.zzd) obj).zzvi;
    }

    /* access modifiers changed from: package-private */
    public final zzgb<zzgg.zzc> zzb(Object obj) {
        zzgg.zzd zzd = (zzgg.zzd) obj;
        if (zzd.zzvi.isImmutable()) {
            zzd.zzvi = (zzgb) zzd.zzvi.clone();
        }
        return zzd.zzvi;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj) {
        zza(obj).zzal();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Map.Entry<?, ?> entry) {
        zzgg.zzc zzc = (zzgg.zzc) entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzjo zzjo, Map.Entry<?, ?> entry) throws IOException {
        zzgg.zzc zzc = (zzgg.zzc) entry.getKey();
        throw new NoSuchMethodError();
    }
}
