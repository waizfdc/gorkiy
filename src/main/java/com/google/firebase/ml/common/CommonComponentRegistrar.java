package com.google.firebase.ml.common;

import android.content.Context;
import com.google.android.gms.internal.firebase_ml.zzmr;
import com.google.android.gms.internal.firebase_ml.zzpj;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzpo;
import com.google.android.gms.internal.firebase_ml.zzpz;
import com.google.android.gms.internal.firebase_ml.zzqc;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.ml.common.modeldownload.FirebaseModelManager;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class CommonComponentRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        return zzmr.zza(zzpo.zzbcu, zzpj.zzbcb, zzpz.zzbcb, zzqc.zzbcb, zzpn.zzbcb, Component.builder(zzpo.zzb.class).add(Dependency.required(Context.class)).factory(zzb.zzbbm).build(), Component.builder(FirebaseModelManager.class).add(Dependency.setOf(FirebaseModelManager.RemoteModelManagerRegistration.class)).factory(zza.zzbbm).build());
    }
}
