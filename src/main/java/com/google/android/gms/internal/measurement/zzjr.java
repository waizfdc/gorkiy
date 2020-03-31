package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzjr implements zzjs {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;
    private static final zzcl<Boolean> zzc;
    private static final zzcl<Boolean> zzd;
    private static final zzcl<Boolean> zze;
    private static final zzcl<Boolean> zzf;

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    public final boolean zzd() {
        return zzc.zzc().booleanValue();
    }

    public final boolean zze() {
        return zzd.zzc().booleanValue();
    }

    public final boolean zzf() {
        return zze.zzc().booleanValue();
    }

    public final boolean zzg() {
        return zzf.zzc().booleanValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, boolean):com.google.android.gms.internal.measurement.zzcl<java.lang.Boolean>
     arg types: [java.lang.String, int]
     candidates:
      com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, double):com.google.android.gms.internal.measurement.zzcl<java.lang.Double>
      com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, long):com.google.android.gms.internal.measurement.zzcl<java.lang.Long>
      com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, java.lang.String):com.google.android.gms.internal.measurement.zzcl<java.lang.String>
      com.google.android.gms.internal.measurement.zzcr.zza(java.lang.String, boolean):com.google.android.gms.internal.measurement.zzcl<java.lang.Boolean> */
    static {
        zzcr zzcr = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcr.zza("measurement.gold.enhanced_ecommerce.format_logs", false);
        zzb = zzcr.zza("measurement.gold.enhanced_ecommerce.log_nested_complex_events.dev", false);
        zzc = zzcr.zza("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", false);
        zzd = zzcr.zza("measurement.gold.enhanced_ecommerce.updated_schema.client.dev", false);
        zze = zzcr.zza("measurement.gold.enhanced_ecommerce.updated_schema.service", false);
        zzf = zzcr.zza("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", false);
    }
}
