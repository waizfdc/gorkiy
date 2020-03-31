package com.google.android.gms.vision.clearcut;

import com.google.android.gms.internal.vision.zzea;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zza implements Runnable {
    private final /* synthetic */ int zzbq;
    private final /* synthetic */ zzea.zzo zzbr;
    private final /* synthetic */ DynamiteClearcutLogger zzbs;

    zza(DynamiteClearcutLogger dynamiteClearcutLogger, int i, zzea.zzo zzo) {
        this.zzbs = dynamiteClearcutLogger;
        this.zzbq = i;
        this.zzbr = zzo;
    }

    public final void run() {
        this.zzbs.zzbp.zzb(this.zzbq, this.zzbr);
    }
}
