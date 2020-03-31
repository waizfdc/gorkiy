package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzls implements zzlp {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Long> zzb;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, boolean):com.google.android.gms.internal.measurement.zzcl<java.lang.Boolean>
     arg types: [java.lang.String, int]
     candidates:
      com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, double):com.google.android.gms.internal.measurement.zzcl<java.lang.Double>
      com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, long):com.google.android.gms.internal.measurement.zzcl<java.lang.Long>
      com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, java.lang.String):com.google.android.gms.internal.measurement.zzcl<java.lang.String>
      com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, boolean):com.google.android.gms.internal.measurement.zzcl<java.lang.Boolean> */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, long):com.google.android.gms.internal.measurement.zzcl<java.lang.Long>
     arg types: [java.lang.String, int]
     candidates:
      com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, double):com.google.android.gms.internal.measurement.zzcl<java.lang.Double>
      com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, java.lang.String):com.google.android.gms.internal.measurement.zzcl<java.lang.String>
      com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, boolean):com.google.android.gms.internal.measurement.zzcl<java.lang.Boolean>
      com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, long):com.google.android.gms.internal.measurement.zzcl<java.lang.Long> */
    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", false);
        zzb = zzcr.zza("measurement.id.referrer.enable_logging_install_referrer_cmp_from_apk", 0L);
    }
}
