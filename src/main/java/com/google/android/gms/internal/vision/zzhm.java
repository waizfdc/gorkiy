package com.google.android.gms.internal.vision;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
abstract class zzhm {
    private static final zzhm zzye = new zzho();
    private static final zzhm zzyf = new zzhn();

    private zzhm() {
    }

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);

    static zzhm zzgz() {
        return zzye;
    }

    static zzhm zzha() {
        return zzyf;
    }
}
