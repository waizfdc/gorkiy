package com.google.firebase.ml.common;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.ml.common.modeldownload.FirebaseModelManager;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final /* synthetic */ class zza implements ComponentFactory {
    static final ComponentFactory zzbbm = new zza();

    private zza() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new FirebaseModelManager(componentContainer.setOf(FirebaseModelManager.RemoteModelManagerRegistration.class));
    }
}
