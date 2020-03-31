package com.google.android.gms.internal.firebase_ml;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.ml.common.internal.modeldownload.zzaa;
import com.google.firebase.ml.common.internal.modeldownload.zzn;
import com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel;
import java.util.UUID;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class zzqc {
    private static final GmsLogger zzbbo = new GmsLogger("SharedPrefManager", "");
    public static final Component<?> zzbcb = Component.builder(zzqc.class).add(Dependency.required(zzpn.class)).add(Dependency.required(Context.class)).factory(zzqb.zzbbm).build();
    private final Context zzbdd;
    private final String zzbdn;

    private zzqc(zzpn zzpn, Context context) {
        this.zzbdd = context;
        this.zzbdn = zzpn.getPersistenceKey();
    }

    public static zzqc zzb(zzpn zzpn) {
        return (zzqc) zzpn.get(zzqc.class);
    }

    public final synchronized boolean zzny() {
        return getSharedPreferences().getBoolean(String.format("logging_%s_%s", "vision", this.zzbdn), true);
    }

    public final synchronized void zzar(boolean z) {
        getSharedPreferences().edit().putBoolean(String.format("logging_%s_%s", "vision", this.zzbdn), z).apply();
    }

    public final synchronized boolean zznz() {
        return getSharedPreferences().getBoolean(String.format("logging_%s_%s", "model", this.zzbdn), true);
    }

    public final synchronized void zzas(boolean z) {
        getSharedPreferences().edit().putBoolean(String.format("logging_%s_%s", "model", this.zzbdn), z).apply();
    }

    public final synchronized Long zza(FirebaseRemoteModel firebaseRemoteModel) {
        long j = getSharedPreferences().getLong(String.format("downloading_model_id_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist()), -1);
        if (j < 0) {
            return null;
        }
        return Long.valueOf(j);
    }

    public final synchronized zzn zzbv(String str) {
        return zzbw(getSharedPreferences().getString(String.format("downloading_model_type_%s", str), ""));
    }

    public final synchronized String zzb(FirebaseRemoteModel firebaseRemoteModel) {
        return getSharedPreferences().getString(String.format("downloading_model_hash_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist()), null);
    }

    public final synchronized String zzc(FirebaseRemoteModel firebaseRemoteModel) {
        return getSharedPreferences().getString(String.format("current_model_hash_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist()), null);
    }

    public final synchronized zzn zzd(FirebaseRemoteModel firebaseRemoteModel) {
        return zzbw(getSharedPreferences().getString(String.format("current_model_type_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist()), zzn.UNKNOWN.name()));
    }

    public final synchronized String zze(FirebaseRemoteModel firebaseRemoteModel) {
        return getSharedPreferences().getString(String.format("bad_hash_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist()), null);
    }

    public final synchronized String zzoa() {
        return getSharedPreferences().getString("app_version", null);
    }

    public final synchronized long zzf(FirebaseRemoteModel firebaseRemoteModel) {
        return getSharedPreferences().getLong(String.format("downloading_begin_time_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist()), 0);
    }

    public final synchronized long zzg(FirebaseRemoteModel firebaseRemoteModel) {
        return getSharedPreferences().getLong(String.format("model_first_use_time_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist()), 0);
    }

    public final synchronized void zza(FirebaseRemoteModel firebaseRemoteModel, long j) {
        getSharedPreferences().edit().putLong(String.format("model_first_use_time_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist()), j).apply();
    }

    public final synchronized void zzh(FirebaseRemoteModel firebaseRemoteModel) {
        String zzb = zzb(firebaseRemoteModel);
        getSharedPreferences().edit().remove(String.format("downloading_model_id_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist())).remove(String.format("downloading_model_hash_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist())).remove(String.format("downloading_model_type_%s", zzb)).remove(String.format("downloading_begin_time_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist())).remove(String.format("model_first_use_time_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist())).apply();
    }

    public final synchronized void zzi(FirebaseRemoteModel firebaseRemoteModel) {
        getSharedPreferences().edit().remove(String.format("current_model_hash_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist())).remove(String.format("current_model_type_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist())).commit();
    }

    public final synchronized void zza(FirebaseRemoteModel firebaseRemoteModel, String str, zzn zzn) {
        getSharedPreferences().edit().putString(String.format("current_model_hash_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist()), str).putString(String.format("current_model_type_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist()), zzn.name()).apply();
    }

    public final synchronized void zza(long j, zzaa zzaa) {
        String zzou = zzaa.zzou();
        String modelHash = zzaa.getModelHash();
        zzn zzov = zzaa.zzov();
        getSharedPreferences().edit().putString(String.format("downloading_model_hash_%s_%s", this.zzbdn, zzou), modelHash).putLong(String.format("downloading_model_id_%s_%s", this.zzbdn, zzou), j).putString(String.format("downloading_model_type_%s", modelHash), zzov.name()).putLong(String.format("downloading_begin_time_%s_%s", this.zzbdn, zzou), SystemClock.elapsedRealtime()).apply();
    }

    public final synchronized void zza(FirebaseRemoteModel firebaseRemoteModel, String str, String str2) {
        getSharedPreferences().edit().putString(String.format("bad_hash_%s_%s", this.zzbdn, firebaseRemoteModel.getUniqueModelNameForPersist()), str).putString("app_version", str2).apply();
    }

    public final synchronized String zzob() {
        String string = getSharedPreferences().getString("ml_sdk_instance_id", null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        getSharedPreferences().edit().putString("ml_sdk_instance_id", uuid).apply();
        return uuid;
    }

    private final SharedPreferences getSharedPreferences() {
        return this.zzbdd.getSharedPreferences("com.google.firebase.ml.internal", 0);
    }

    private static zzn zzbw(String str) {
        if (str == null) {
            return zzn.UNKNOWN;
        }
        try {
            return zzn.zzbx(str);
        } catch (IllegalArgumentException unused) {
            GmsLogger gmsLogger = zzbbo;
            String valueOf = String.valueOf(str);
            gmsLogger.e("SharedPrefManager", valueOf.length() != 0 ? "Invalid model type ".concat(valueOf) : new String("Invalid model type "));
            return zzn.UNKNOWN;
        }
    }

    static final /* synthetic */ zzqc zze(ComponentContainer componentContainer) {
        return new zzqc((zzpn) componentContainer.get(zzpn.class), (Context) componentContainer.get(Context.class));
    }
}
