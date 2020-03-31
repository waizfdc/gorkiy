package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzkz;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzkd {
    final /* synthetic */ zzkc zza;
    private zzki zzb;
    private final Runnable zzc = new zzkg(this);

    zzkd(zzkc zzkc) {
        this.zza = zzkc;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zzd();
        if (!this.zza.zzt().zza(zzap.zzci)) {
            return;
        }
        if (!zzkz.zzb() || !this.zza.zzt().zze(this.zza.zzg().zzab(), zzap.zzcv)) {
            this.zza.zzc.removeCallbacks(this.zzc);
        } else if (this.zzb != null) {
            this.zza.zzc.removeCallbacks(this.zzb);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        if (!this.zza.zzt().zza(zzap.zzci)) {
            return;
        }
        if (!zzkz.zzb() || !this.zza.zzt().zze(this.zza.zzg().zzab(), zzap.zzcv)) {
            this.zza.zzc.postDelayed(this.zzc, 2000);
            return;
        }
        this.zzb = new zzki(this, this.zza.zzm().currentTimeMillis());
        this.zza.zzc.postDelayed(this.zzb, 2000);
    }
}
