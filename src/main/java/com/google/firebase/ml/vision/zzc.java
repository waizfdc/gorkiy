package com.google.firebase.ml.vision;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzpo;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.ml.vision.automl.internal.zza;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final /* synthetic */ class zzc implements ComponentFactory {
    static final ComponentFactory zzbbm = new zzc();

    private zzc() {
    }

    public final Object create(ComponentContainer componentContainer) {
        Preconditions.checkArgument(((zzpn) componentContainer.get(zzpn.class)).zznq().getName().equals(FirebaseApp.DEFAULT_APP_NAME), "FirebaseAutoMLModelManager doesn't support Nondefault FirebaseApp");
        return new zza((zzpn) componentContainer.get(zzpn.class), (zzpo) ((zzpo.zza) componentContainer.get(zzpo.zza.class)).get(5));
    }
}
