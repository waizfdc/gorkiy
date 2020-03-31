package com.google.firebase.ml.vision;

import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final /* synthetic */ class zza implements ComponentFactory {
    static final ComponentFactory zzbbm = new zza();

    private zza() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new FirebaseVision((zzpn) componentContainer.get(zzpn.class));
    }
}
