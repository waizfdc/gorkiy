package com.google.android.gms.measurement.internal;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzfj implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzfk zzf;

    zzfj(zzfk zzfk, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzfk;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzfk.zza(com.google.android.gms.measurement.internal.zzfk, char):char
     arg types: [com.google.android.gms.measurement.internal.zzfk, int]
     candidates:
      com.google.android.gms.measurement.internal.zzfk.zza(com.google.android.gms.measurement.internal.zzfk, long):long
      com.google.android.gms.measurement.internal.zzfk.zza(boolean, java.lang.Object):java.lang.String
      com.google.android.gms.measurement.internal.zzfk.zza(int, java.lang.String):void
      com.google.android.gms.measurement.internal.zzfk.zza(com.google.android.gms.measurement.internal.zzfk, char):char */
    public final void run() {
        zzft zzc2 = this.zzf.zzx.zzc();
        if (zzc2.zzz()) {
            if (this.zzf.zza == 0) {
                if (this.zzf.zzt().zzf()) {
                    zzfk zzfk = this.zzf;
                    zzfk.zzu();
                    char unused = zzfk.zza = 'C';
                } else {
                    zzfk zzfk2 = this.zzf;
                    zzfk2.zzu();
                    char unused2 = zzfk2.zza = 'c';
                }
            }
            if (this.zzf.zzb < 0) {
                zzfk zzfk3 = this.zzf;
                long unused3 = zzfk3.zzb = zzfk3.zzt().zze();
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            char zza2 = this.zzf.zza;
            long zzb2 = this.zzf.zzb;
            String zza3 = zzfk.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
            StringBuilder sb = new StringBuilder(String.valueOf(zza3).length() + 24);
            sb.append(ExifInterface.GPS_MEASUREMENT_2D);
            sb.append(charAt);
            sb.append(zza2);
            sb.append(zzb2);
            sb.append(":");
            sb.append(zza3);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = this.zzb.substring(0, 1024);
            }
            zzc2.zzb.zza(sb2, 1);
            return;
        }
        this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
    }
}
