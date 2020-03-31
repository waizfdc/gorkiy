package com.google.android.gms.internal.firebase_ml;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class zzpn {
    public static final Component<zzpn> zzbcb = Component.builder(zzpn.class).add(Dependency.required(FirebaseApp.class)).factory(zzpm.zzbbm).build();
    private final FirebaseApp zzbce;

    private zzpn(FirebaseApp firebaseApp) {
        this.zzbce = firebaseApp;
    }

    public final <T> T get(Class<T> cls) {
        return this.zzbce.get(cls);
    }

    public static zzpn zznp() {
        return (zzpn) FirebaseApp.getInstance().get(zzpn.class);
    }

    public final Context getApplicationContext() {
        return this.zzbce.getApplicationContext();
    }

    public final FirebaseApp zznq() {
        return this.zzbce;
    }

    public final String getPersistenceKey() {
        return this.zzbce.getPersistenceKey();
    }

    static final /* synthetic */ zzpn zzb(ComponentContainer componentContainer) {
        return new zzpn((FirebaseApp) componentContainer.get(FirebaseApp.class));
    }
}
