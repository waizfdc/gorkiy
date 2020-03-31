package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public final class zzbj implements zzau {
    private static final Map<String, zzbj> zzgh = new ArrayMap();
    private final Object zzfm = new Object();
    private volatile Map<String, ?> zzfn;
    private final List<zzar> zzfo = new ArrayList();
    private final SharedPreferences zzgi;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzgj = new zzbm(this);

    static zzbj zzb(Context context, String str) {
        zzbj zzbj;
        SharedPreferences sharedPreferences;
        if (!((!zzan.zzs() || str.startsWith("direct_boot:")) ? true : zzan.isUserUnlocked(context))) {
            return null;
        }
        synchronized (zzbj.class) {
            zzbj = zzgh.get(str);
            if (zzbj == null) {
                if (str.startsWith("direct_boot:")) {
                    if (zzan.zzs()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    sharedPreferences = context.getSharedPreferences(str.substring(12), 0);
                } else {
                    sharedPreferences = context.getSharedPreferences(str, 0);
                }
                zzbj = new zzbj(sharedPreferences);
                zzgh.put(str, zzbj);
            }
        }
        return zzbj;
    }

    private zzbj(SharedPreferences sharedPreferences) {
        this.zzgi = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.zzgj);
    }

    public final Object zzb(String str) {
        Map<String, ?> map = this.zzfn;
        if (map == null) {
            synchronized (this.zzfm) {
                map = this.zzfn;
                if (map == null) {
                    map = this.zzgi.getAll();
                    this.zzfn = map;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    static synchronized void zzx() {
        synchronized (zzbj.class) {
            for (zzbj next : zzgh.values()) {
                next.zzgi.unregisterOnSharedPreferenceChangeListener(next.zzgj);
            }
            zzgh.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzfm) {
            this.zzfn = null;
            zzbe.zzab();
        }
        synchronized (this) {
            for (zzar zzz : this.zzfo) {
                zzz.zzz();
            }
        }
    }
}
