package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
final class zzhx extends zzhv<zzhy, zzhy> {
    zzhx() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzhe zzhe) {
        return false;
    }

    private static void zza(Object obj, zzhy zzhy) {
        ((zzfd) obj).zzb = zzhy;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Object obj) {
        ((zzfd) obj).zzb.zzc();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzf(Object obj) {
        return ((zzhy) obj).zze();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zze(Object obj) {
        return ((zzhy) obj).zzd();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj, Object obj2) {
        zzhy zzhy = (zzhy) obj;
        zzhy zzhy2 = (zzhy) obj2;
        if (zzhy2.equals(zzhy.zza())) {
            return zzhy;
        }
        return zzhy.zza(zzhy, zzhy2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, zzis zzis) throws IOException {
        ((zzhy) obj).zza(zzis);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzis zzis) throws IOException {
        ((zzhy) obj).zzb(zzis);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, Object obj2) {
        zza(obj, (zzhy) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj) {
        zzhy zzhy = ((zzfd) obj).zzb;
        if (zzhy != zzhy.zza()) {
            return zzhy;
        }
        zzhy zzb = zzhy.zzb();
        zza(obj, zzb);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzb(Object obj) {
        return ((zzfd) obj).zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Object obj2) {
        zza(obj, (zzhy) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj) {
        zzhy zzhy = (zzhy) obj;
        zzhy.zzc();
        return zzhy;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza() {
        return zzhy.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzhy) obj).zza((i << 3) | 3, (zzhy) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzdu zzdu) {
        ((zzhy) obj).zza((i << 3) | 2, zzdu);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzhy) obj).zza((i << 3) | 1, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, int i2) {
        ((zzhy) obj).zza((i << 3) | 5, Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzhy) obj).zza(i << 3, Long.valueOf(j));
    }
}
