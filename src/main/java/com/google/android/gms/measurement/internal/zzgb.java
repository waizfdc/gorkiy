package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzkh;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzgb implements Runnable {
    private final /* synthetic */ zzd zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzgc zzc;

    zzgb(zzgc zzgc, zzd zzd, ServiceConnection serviceConnection) {
        this.zzc = zzgc;
        this.zza = zzd;
        this.zzb = serviceConnection;
    }

    public final void run() {
        zzfz zzfz = this.zzc.zza;
        String zza2 = this.zzc.zzb;
        zzd zzd = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle zza3 = zzfz.zza(zza2, zzd);
        zzfz.zza.zzq().zzd();
        if (zza3 != null) {
            long j = zza3.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzfz.zza.zzr().zzf().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = zza3.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzfz.zza.zzr().zzf().zza("No referrer defined in Install Referrer response");
                } else {
                    zzfz.zza.zzr().zzx().zza("InstallReferrer API result", string);
                    zzla zzi = zzfz.zza.zzi();
                    String valueOf = String.valueOf(string);
                    Bundle zza4 = zzi.zza(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
                    if (zza4 == null) {
                        zzfz.zza.zzr().zzf().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zza4.getString(FirebaseAnalytics.Param.MEDIUM);
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = zza3.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzfz.zza.zzr().zzf().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zza4.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzfz.zza.zzc().zzi.zza()) {
                            zzfz.zza.zzu();
                            zzfz.zza.zzr().zzx().zza("Install Referrer campaign has already been logged");
                        } else if (!zzkh.zzb() || !zzfz.zza.zzb().zza(zzap.zzcx) || zzfz.zza.zzab()) {
                            zzfz.zza.zzc().zzi.zza(j);
                            zzfz.zza.zzu();
                            zzfz.zza.zzr().zzx().zza("Logging Install Referrer campaign from sdk with ", "referrer API");
                            zza4.putString("_cis", "referrer API");
                            zzfz.zza.zzh().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_cmp", zza4);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzfz.zza.zzn(), serviceConnection);
        }
    }
}
