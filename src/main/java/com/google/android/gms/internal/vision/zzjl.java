package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzjl extends zzjj<zzjm, zzjm> {
    zzjl() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzis zzis) {
        return false;
    }

    private static void zza(Object obj, zzjm zzjm) {
        ((zzgs) obj).zzwd = zzjm;
    }

    /* access modifiers changed from: package-private */
    public final void zzg(Object obj) {
        ((zzgs) obj).zzwd.zzdp();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzr(Object obj) {
        return ((zzjm) obj).zzgf();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzx(Object obj) {
        return ((zzjm) obj).zzii();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzh(Object obj, Object obj2) {
        zzjm zzjm = (zzjm) obj;
        zzjm zzjm2 = (zzjm) obj2;
        if (zzjm2.equals(zzjm.zzig())) {
            return zzjm;
        }
        return zzjm.zza(zzjm, zzjm2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, zzkg zzkg) throws IOException {
        ((zzjm) obj).zza(zzkg);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzkg zzkg) throws IOException {
        ((zzjm) obj).zzb(zzkg);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(Object obj, Object obj2) {
        zza(obj, (zzjm) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzw(Object obj) {
        zzjm zzjm = ((zzgs) obj).zzwd;
        if (zzjm != zzjm.zzig()) {
            return zzjm;
        }
        zzjm zzih = zzjm.zzih();
        zza(obj, zzih);
        return zzih;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzv(Object obj) {
        return ((zzgs) obj).zzwd;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        zza(obj, (zzjm) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzn(Object obj) {
        zzjm zzjm = (zzjm) obj;
        zzjm.zzdp();
        return zzjm;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzif() {
        return zzjm.zzih();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzjm) obj).zzb((i << 3) | 3, (zzjm) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzfh zzfh) {
        ((zzjm) obj).zzb((i << 3) | 2, zzfh);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzjm) obj).zzb((i << 3) | 1, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzjm) obj).zzb((i << 3) | 5, Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzjm) obj).zzb(i << 3, Long.valueOf(j));
    }
}
