package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final /* synthetic */ class zzct implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzcu zza;

    zzct(zzcu zzcu) {
        this.zza = zzcu;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zza(sharedPreferences, str);
    }
}
