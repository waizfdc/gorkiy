package com.google.firebase.ml.vision;

import com.google.android.gms.internal.firebase_ml.zzmr;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzpo;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.ml.common.modeldownload.FirebaseModelManager;
import com.google.firebase.ml.vision.automl.internal.zza;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class VisionRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        return zzmr.zza(Component.builder(FirebaseVision.class).add(Dependency.required(zzpn.class)).factory(zza.zzbbm).build(), Component.builder(zza.class).add(Dependency.required(zzpo.zza.class)).add(Dependency.required(zzpn.class)).factory(zzc.zzbbm).build(), Component.intoSetBuilder(FirebaseModelManager.RemoteModelManagerRegistration.class).add(Dependency.requiredProvider(zza.class)).factory(zzb.zzbbm).build());
    }
}
