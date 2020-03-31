package com.google.android.gms.internal.measurement;

import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzjf implements zzjg {
    private static final zzcl<Long> zza;
    private static final zzcl<Long> zzaa;
    private static final zzcl<Long> zzab;
    private static final zzcl<Long> zzac;
    private static final zzcl<Long> zzad;
    private static final zzcl<Long> zzae;
    private static final zzcl<Long> zzaf;
    private static final zzcl<Long> zzag;
    private static final zzcl<Long> zzah;
    private static final zzcl<String> zzai;
    private static final zzcl<Long> zzaj;
    private static final zzcl<Long> zzb;
    private static final zzcl<String> zzc;
    private static final zzcl<String> zzd;
    private static final zzcl<String> zze;
    private static final zzcl<Long> zzf;
    private static final zzcl<Long> zzg;
    private static final zzcl<Long> zzh;
    private static final zzcl<Long> zzi;
    private static final zzcl<Long> zzj;
    private static final zzcl<Long> zzk;
    private static final zzcl<Long> zzl;
    private static final zzcl<Long> zzm;
    private static final zzcl<Long> zzn;
    private static final zzcl<Long> zzo;
    private static final zzcl<Long> zzp;
    private static final zzcl<Long> zzq;
    private static final zzcl<String> zzr;
    private static final zzcl<Long> zzs;
    private static final zzcl<Long> zzt;
    private static final zzcl<Long> zzu;
    private static final zzcl<Long> zzv;
    private static final zzcl<Long> zzw;
    private static final zzcl<Long> zzx;
    private static final zzcl<Long> zzy;
    private static final zzcl<Long> zzz;

    public final long zza() {
        return zza.zzc().longValue();
    }

    public final long zzb() {
        return zzb.zzc().longValue();
    }

    public final String zzc() {
        return zzd.zzc();
    }

    public final String zzd() {
        return zze.zzc();
    }

    public final long zze() {
        return zzf.zzc().longValue();
    }

    public final long zzf() {
        return zzg.zzc().longValue();
    }

    public final long zzg() {
        return zzh.zzc().longValue();
    }

    public final long zzh() {
        return zzi.zzc().longValue();
    }

    public final long zzi() {
        return zzj.zzc().longValue();
    }

    public final long zzj() {
        return zzk.zzc().longValue();
    }

    public final long zzk() {
        return zzl.zzc().longValue();
    }

    public final long zzl() {
        return zzm.zzc().longValue();
    }

    public final long zzm() {
        return zzn.zzc().longValue();
    }

    public final long zzn() {
        return zzo.zzc().longValue();
    }

    public final long zzo() {
        return zzq.zzc().longValue();
    }

    public final long zzp() {
        return zzs.zzc().longValue();
    }

    public final long zzq() {
        return zzt.zzc().longValue();
    }

    public final long zzr() {
        return zzu.zzc().longValue();
    }

    public final long zzs() {
        return zzv.zzc().longValue();
    }

    public final long zzt() {
        return zzw.zzc().longValue();
    }

    public final long zzu() {
        return zzx.zzc().longValue();
    }

    public final long zzv() {
        return zzy.zzc().longValue();
    }

    public final long zzw() {
        return zzz.zzc().longValue();
    }

    public final long zzx() {
        return zzaa.zzc().longValue();
    }

    public final long zzy() {
        return zzab.zzc().longValue();
    }

    public final long zzz() {
        return zzac.zzc().longValue();
    }

    public final long zzaa() {
        return zzad.zzc().longValue();
    }

    public final long zzab() {
        return zzae.zzc().longValue();
    }

    public final long zzac() {
        return zzaf.zzc().longValue();
    }

    public final long zzad() {
        return zzag.zzc().longValue();
    }

    public final long zzae() {
        return zzah.zzc().longValue();
    }

    public final String zzaf() {
        return zzai.zzc();
    }

    public final long zzag() {
        return zzaj.zzc().longValue();
    }

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
        zza = zzcr.zza("measurement.ad_id_cache_time", (long) WorkRequest.MIN_BACKOFF_MILLIS);
        zzb = zzcr.zza("measurement.config.cache_time", 86400000L);
        zzc = zzcr.zza("measurement.log_tag", "FA");
        zzd = zzcr.zza("measurement.config.url_authority", "app-measurement.com");
        zze = zzcr.zza("measurement.config.url_scheme", "https");
        zzf = zzcr.zza("measurement.upload.debug_upload_interval", 1000L);
        zzg = zzcr.zza("measurement.lifetimevalue.max_currency_tracked", 4L);
        zzh = zzcr.zza("measurement.store.max_stored_events_per_app", 100000L);
        zzi = zzcr.zza("measurement.experiment.max_ids", 50L);
        zzj = zzcr.zza("measurement.audience.filter_result_max_count", 200L);
        zzk = zzcr.zza("measurement.alarm_manager.minimum_interval", 60000L);
        zzl = zzcr.zza("measurement.upload.minimum_delay", 500L);
        zzm = zzcr.zza("measurement.monitoring.sample_period_millis", 86400000L);
        zzn = zzcr.zza("measurement.upload.realtime_upload_interval", (long) WorkRequest.MIN_BACKOFF_MILLIS);
        zzo = zzcr.zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        zzp = zzcr.zza("measurement.config.cache_time.service", 3600000L);
        zzq = zzcr.zza("measurement.service_client.idle_disconnect_millis", 5000L);
        zzr = zzcr.zza("measurement.log_tag.service", "FA-SVC");
        zzs = zzcr.zza("measurement.upload.stale_data_deletion_interval", 86400000L);
        zzt = zzcr.zza("measurement.upload.backoff_period", 43200000L);
        zzu = zzcr.zza("measurement.upload.initial_upload_delay_time", 15000L);
        zzv = zzcr.zza("measurement.upload.interval", 3600000L);
        zzw = zzcr.zza("measurement.upload.max_bundle_size", 65536L);
        zzx = zzcr.zza("measurement.upload.max_bundles", 100L);
        zzy = zzcr.zza("measurement.upload.max_conversions_per_day", 500L);
        zzz = zzcr.zza("measurement.upload.max_error_events_per_day", 1000L);
        zzaa = zzcr.zza("measurement.upload.max_events_per_bundle", 1000L);
        zzab = zzcr.zza("measurement.upload.max_events_per_day", 100000L);
        zzac = zzcr.zza("measurement.upload.max_public_events_per_day", 50000L);
        zzad = zzcr.zza("measurement.upload.max_queue_time", 2419200000L);
        zzae = zzcr.zza("measurement.upload.max_realtime_events_per_day", 10L);
        zzaf = zzcr.zza("measurement.upload.max_batch_size", 65536L);
        zzag = zzcr.zza("measurement.upload.retry_count", 6L);
        zzah = zzcr.zza("measurement.upload.retry_time", 1800000L);
        zzai = zzcr.zza("measurement.upload.url", "https://app-measurement.com/a");
        zzaj = zzcr.zza("measurement.upload.window_interval", 3600000L);
    }
}
