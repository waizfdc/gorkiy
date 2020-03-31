package com.google.android.gms.internal.vision;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final /* synthetic */ class zzbm implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzbj zzha;

    zzbm(zzbj zzbj) {
        this.zzha = zzbj;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zzha.zza(sharedPreferences, str);
    }
}
