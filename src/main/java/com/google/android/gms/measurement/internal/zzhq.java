package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzv;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzhq {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    zzv zzg;
    boolean zzh = true;

    public zzhq(Context context, zzv zzv) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        if (zzv != null) {
            this.zzg = zzv;
            this.zzb = zzv.zzf;
            this.zzc = zzv.zze;
            this.zzd = zzv.zzd;
            this.zzh = zzv.zzc;
            this.zzf = zzv.zzb;
            if (zzv.zzg != null) {
                this.zze = Boolean.valueOf(zzv.zzg.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
