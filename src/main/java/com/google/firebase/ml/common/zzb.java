package com.google.firebase.ml.common;

import android.content.Context;
import com.google.android.gms.internal.firebase_ml.zzqd;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final /* synthetic */ class zzb implements ComponentFactory {
    static final ComponentFactory zzbbm = new zzb();

    private zzb() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new zzqd((Context) componentContainer.get(Context.class));
    }
}
