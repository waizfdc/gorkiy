package com.google.firebase.ml.vision;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.ml.common.modeldownload.FirebaseModelManager;
import com.google.firebase.ml.vision.automl.FirebaseAutoMLRemoteModel;
import com.google.firebase.ml.vision.automl.internal.zza;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final /* synthetic */ class zzb implements ComponentFactory {
    static final ComponentFactory zzbbm = new zzb();

    private zzb() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new FirebaseModelManager.RemoteModelManagerRegistration(FirebaseAutoMLRemoteModel.class, componentContainer.getProvider(zza.class));
    }
}
