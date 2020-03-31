package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.measurement.zzbx;
import com.google.android.gms.internal.measurement.zzcm;
import com.google.android.gms.internal.measurement.zzjd;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzap {
    public static zzez<Long> zza;
    public static zzez<Long> zzaa = zza("measurement.upload.retry_time", 1800000L, 1800000L, zzbt.zza);
    public static zzez<Integer> zzab = zza("measurement.upload.retry_count", 6, 6, zzbw.zza);
    public static zzez<Long> zzac = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbv.zza);
    public static zzez<Integer> zzad = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzby.zza);
    public static zzez<Integer> zzae;
    public static zzez<Integer> zzaf = zza("measurement.upload.max_public_user_properties", 25, 25, null);
    public static zzez<Integer> zzag = zza("measurement.upload.max_event_name_cardinality", 500, 500, null);
    public static zzez<Long> zzah = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzbz.zza);
    public static zzez<Boolean> zzai = zza("measurement.test.boolean_flag", false, false, zzcc.zza);
    public static zzez<String> zzaj = zza("measurement.test.string_flag", "---", "---", zzcb.zza);
    public static zzez<Long> zzak = zza("measurement.test.long_flag", -1L, -1L, zzce.zza);
    public static zzez<Integer> zzal = zza("measurement.test.int_flag", -2, -2, zzcd.zza);
    public static zzez<Double> zzam;
    public static zzez<Integer> zzan = zza("measurement.experiment.max_ids", 50, 50, zzcf.zza);
    public static zzez<Integer> zzao = zza("measurement.max_bundles_per_iteration", 1, 1, zzci.zza);
    public static zzez<Boolean> zzap = zza("measurement.validation.internal_limits_internal_event_params", false, false, zzch.zza);
    public static zzez<Boolean> zzaq = zza("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", false, false, zzcj.zza);
    public static zzez<Boolean> zzar = zza("measurement.client.sessions.session_id_enabled", true, true, zzcm.zza);
    public static zzez<Boolean> zzas = zza("measurement.service.sessions.session_number_enabled", true, true, zzcl.zza);
    public static zzez<Boolean> zzat = zza("measurement.client.sessions.background_sessions_enabled", true, true, zzco.zza);
    public static zzez<Boolean> zzau = zza("measurement.client.sessions.remove_expired_session_properties_enabled", true, true, zzcn.zza);
    public static zzez<Boolean> zzav = zza("measurement.service.sessions.session_number_backfill_enabled", true, true, zzcq.zza);
    public static zzez<Boolean> zzaw = zza("measurement.service.sessions.remove_disabled_session_number", true, true, zzcp.zza);
    public static zzez<Boolean> zzax = zza("measurement.client.sessions.start_session_before_view_screen", true, true, zzcs.zza);
    public static zzez<Boolean> zzay = zza("measurement.client.sessions.check_on_startup", true, true, zzcr.zza);
    public static zzez<Boolean> zzaz = zza("measurement.collection.firebase_global_collection_flag_enabled", true, true, zzcu.zza);
    public static zzez<Long> zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, zzar.zza);
    public static zzez<Boolean> zzba = zza("measurement.collection.efficient_engagement_reporting_enabled_2", false, false, zzcw.zza);
    public static zzez<Boolean> zzbb = zza("measurement.collection.redundant_engagement_removal_enabled", false, false, zzcv.zza);
    public static zzez<Boolean> zzbc = zza("measurement.personalized_ads_signals_collection_enabled", true, true, zzcy.zza);
    public static zzez<Boolean> zzbd = zza("measurement.personalized_ads_property_translation_enabled", true, true, zzcx.zza);
    public static zzez<Boolean> zzbe = zza("measurement.experiment.enable_experiment_reporting", true, true, zzda.zza);
    public static zzez<Boolean> zzbf = zza("measurement.collection.log_event_and_bundle_v2", true, true, zzcz.zza);
    public static zzez<Boolean> zzbg = zza("measurement.quality.checksum", false, false, null);
    public static zzez<Boolean> zzbh = zza("measurement.module.collection.conditionally_omit_admob_app_id", true, true, zzdc.zza);
    public static zzez<Boolean> zzbi = zza("measurement.sdk.dynamite.use_dynamite2", false, false, zzdb.zza);
    public static zzez<Boolean> zzbj = zza("measurement.sdk.dynamite.allow_remote_dynamite", false, false, zzde.zza);
    public static zzez<Boolean> zzbk = zza("measurement.sdk.collection.validate_param_names_alphabetical", false, false, zzdd.zza);
    public static zzez<Boolean> zzbl = zza("measurement.collection.event_safelist", true, true, zzdf.zza);
    public static zzez<Boolean> zzbm = zza("measurement.service.audience.scoped_filters_v27", true, true, zzdi.zza);
    public static zzez<Boolean> zzbn = zza("measurement.service.audience.session_scoped_event_aggregates", true, true, zzdh.zza);
    public static zzez<Boolean> zzbo = zza("measurement.service.audience.session_scoped_user_engagement", true, true, zzdk.zza);
    public static zzez<Boolean> zzbp = zza("measurement.service.audience.scoped_engagement_removal_when_session_expired", true, true, zzdj.zza);
    public static zzez<Boolean> zzbq = zza("measurement.client.audience.scoped_engagement_removal_when_session_expired", true, true, zzdm.zza);
    public static zzez<Boolean> zzbr = zza("measurement.service.audience.remove_disabled_session_scoped_user_engagement", false, false, zzdl.zza);
    public static zzez<Boolean> zzbs = zza("measurement.service.audience.use_bundle_timestamp_for_property_filters", true, true, zzdo.zza);
    public static zzez<Boolean> zzbt = zza("measurement.service.audience.fix_prepending_previous_sequence_timestamp", true, true, zzdn.zza);
    public static zzez<Boolean> zzbu = zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true, true, zzds.zza);
    public static zzez<Boolean> zzbv = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, zzdr.zza);
    public static zzez<Boolean> zzbw = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, zzdu.zza);
    public static zzez<Boolean> zzbx = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, zzdt.zza);
    public static zzez<Boolean> zzby = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, zzdw.zza);
    public static zzez<Boolean> zzbz = zza("measurement.app_launch.event_ordering_fix", false, false, zzdv.zza);
    public static zzez<Long> zzc = zza("measurement.config.cache_time", 86400000L, 3600000L, zzbo.zza);
    public static zzez<Boolean> zzca = zza("measurement.sdk.collection.last_deep_link_referrer2", true, true, zzdy.zza);
    public static zzez<Boolean> zzcb = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, zzdx.zza);
    public static zzez<Boolean> zzcc = zza("measurement.sdk.collection.last_gclid_from_referrer2", false, false, zzea.zza);
    public static zzez<Boolean> zzcd = zza("measurement.sdk.collection.worker_thread_referrer", true, true, zzdz.zza);
    public static zzez<Boolean> zzce = zza("measurement.sdk.collection.enable_extend_user_property_size", true, true, zzeb.zza);
    public static zzez<Boolean> zzcf = zza("measurement.upload.file_lock_state_check", false, false, zzee.zza);
    public static zzez<Boolean> zzcg = zza("measurement.sampling.calculate_bundle_timestamp_before_sampling", true, true, zzed.zza);
    public static zzez<Boolean> zzch = zza("measurement.ga.ga_app_id", false, false, zzeg.zza);
    public static zzez<Boolean> zzci = zza("measurement.lifecycle.app_backgrounded_tracking", true, true, zzef.zza);
    public static zzez<Boolean> zzcj = zza("measurement.lifecycle.app_in_background_parameter", false, false, zzei.zza);
    public static zzez<Boolean> zzck = zza("measurement.integration.disable_firebase_instance_id", false, false, zzeh.zza);
    public static zzez<Boolean> zzcl = zza("measurement.lifecycle.app_backgrounded_engagement", false, false, zzek.zza);
    public static zzez<Boolean> zzcm = zza("measurement.service.fix_gmp_version", false, false, zzej.zza);
    public static zzez<Boolean> zzcn = zza("measurement.collection.service.update_with_analytics_fix", false, false, zzem.zza);
    public static zzez<Boolean> zzco = zza("measurement.service.disable_install_state_reporting", true, true, zzeo.zza);
    public static zzez<Boolean> zzcp = zza("measurement.service.use_appinfo_modified", false, false, zzen.zza);
    public static zzez<Boolean> zzcq = zza("measurement.client.firebase_feature_rollout.v1.enable", true, true, zzeq.zza);
    public static zzez<Boolean> zzcr = zza("measurement.client.sessions.check_on_reset_and_enable", false, false, zzep.zza);
    public static zzez<Boolean> zzcs = zza("measurement.config.string.always_update_disk_on_set", false, false, zzes.zza);
    public static zzez<Boolean> zzct = zza("measurement.scheduler.task_thread.cleanup_on_exit", false, false, zzer.zza);
    public static zzez<Boolean> zzcu = zza("measurement.upload.file_truncate_fix", false, false, zzeu.zza);
    public static zzez<Boolean> zzcv = zza("measurement.lifecycle.app_background_timestamp_when_backgrounded", true, true, zzet.zza);
    public static zzez<Boolean> zzcw = zza("measurement.engagement_time_main_thread", true, true, zzew.zza);
    public static zzez<Boolean> zzcx = zza("measurement.sdk.referrer.delayed_install_referrer_api", false, false, zzev.zza);
    public static zzez<Boolean> zzcy = zza("measurement.logging.improved_messaging_q4_2019_client", true, true, zzat.zza);
    public static zzez<Boolean> zzcz = zza("measurement.logging.improved_messaging_q4_2019_service", true, true, zzaw.zza);
    public static zzez<String> zzd = zza("measurement.config.url_scheme", "https", "https", zzbx.zza);
    public static zzez<Boolean> zzda = zza("measurement.gold.enhanced_ecommerce.format_logs", false, false, zzav.zza);
    public static zzez<Boolean> zzdb = zza("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", false, false, zzay.zza);
    public static zzez<Boolean> zzdc = zza("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", false, false, zzax.zza);
    public static zzez<Boolean> zzdd = zza("measurement.gold.enhanced_ecommerce.log_nested_complex_events.dev", false, false, zzba.zza);
    public static zzez<Boolean> zzde = zza("measurement.gold.enhanced_ecommerce.updated_schema.client.dev", false, false, zzaz.zza);
    public static zzez<Boolean> zzdf = zza("measurement.gold.enhanced_ecommerce.updated_schema.service", false, false, zzbc.zza);
    public static zzez<Boolean> zzdg = zza("measurement.collection.configurable_service_limits.dev", false, false, zzbe.zza);
    /* access modifiers changed from: private */
    public static List<zzez<?>> zzdh = Collections.synchronizedList(new ArrayList());
    private static Set<zzez<?>> zzdi = Collections.synchronizedSet(new HashSet());
    private static zzez<Boolean> zzdj = zza("measurement.service.audience.invalidate_config_cache_after_app_unisntall", true, true, zzdq.zza);
    private static zzez<Boolean> zzdk = zza("measurement.collection.synthetic_data_mitigation", false, false, zzbb.zza);
    public static zzez<String> zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzck.zza);
    public static zzez<Integer> zzf = zza("measurement.upload.max_bundles", 100, 100, zzct.zza);
    public static zzez<Integer> zzg = zza("measurement.upload.max_batch_size", 65536, 65536, zzdg.zza);
    public static zzez<Integer> zzh = zza("measurement.upload.max_bundle_size", 65536, 65536, zzdp.zza);
    public static zzez<Integer> zzi = zza("measurement.upload.max_events_per_bundle", 1000, 1000, zzec.zza);
    public static zzez<Integer> zzj = zza("measurement.upload.max_events_per_day", 100000, 100000, zzel.zza);
    public static zzez<Integer> zzk = zza("measurement.upload.max_error_events_per_day", 1000, 1000, zzau.zza);
    public static zzez<Integer> zzl = zza("measurement.upload.max_public_events_per_day", 50000, 50000, zzbd.zza);
    public static zzez<Integer> zzm;
    public static zzez<Integer> zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, zzbf.zza);
    public static zzez<Integer> zzo = zza("measurement.store.max_stored_events_per_app", 100000, 100000, zzbi.zza);
    public static zzez<String> zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzbh.zza);
    public static zzez<Long> zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, zzbk.zza);
    public static zzez<Long> zzr = zza("measurement.upload.window_interval", 3600000L, 3600000L, zzbj.zza);
    public static zzez<Long> zzs = zza("measurement.upload.interval", 3600000L, 3600000L, zzbm.zza);
    public static zzez<Long> zzt;
    public static zzez<Long> zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbn.zza);
    public static zzez<Long> zzv = zza("measurement.upload.minimum_delay", 500L, 500L, zzbq.zza);
    public static zzez<Long> zzw = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, zzbp.zza);
    public static zzez<Long> zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, zzbs.zza);
    public static zzez<Long> zzy = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbr.zza);
    public static zzez<Long> zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, zzbu.zza);

    public static Map<String, String> zza(Context context) {
        zzbx zza2 = zzbx.zza(context.getContentResolver(), zzcm.zza("com.google.android.gms.measurement"));
        return zza2 == null ? Collections.emptyMap() : zza2.zza();
    }

    private static <V> zzez<V> zza(String str, V v, V v2, zzex<V> zzex) {
        zzez zzez = new zzez(str, v, v2, zzex);
        zzdh.add(zzez);
        return zzez;
    }

    static final /* synthetic */ Long zzdd() {
        if (zzfa.zza != null) {
            zzw zzw2 = zzfa.zza;
        }
        return Long.valueOf(zzjd.zzc());
    }

    static {
        Long valueOf = Long.valueOf((long) WorkRequest.MIN_BACKOFF_MILLIS);
        zza = zza("measurement.ad_id_cache_time", valueOf, valueOf, zzas.zza);
        Integer valueOf2 = Integer.valueOf((int) AbstractSpiCall.DEFAULT_TIMEOUT);
        zzm = zza("measurement.upload.max_conversions_per_day", valueOf2, valueOf2, zzbg.zza);
        zzt = zza("measurement.upload.realtime_upload_interval", valueOf, valueOf, zzbl.zza);
        Integer valueOf3 = Integer.valueOf((int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        zzae = zza("measurement.audience.filter_result_max_count", valueOf3, valueOf3, zzca.zza);
        Double valueOf4 = Double.valueOf(-3.0d);
        zzam = zza("measurement.test.double_flag", valueOf4, valueOf4, zzcg.zza);
    }
}
