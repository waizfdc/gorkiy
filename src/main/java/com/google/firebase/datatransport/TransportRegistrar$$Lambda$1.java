package com.google.firebase.datatransport;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.firebase:firebase-datatransport@@17.0.3 */
final /* synthetic */ class TransportRegistrar$$Lambda$1 implements ComponentFactory {
    private static final TransportRegistrar$$Lambda$1 instance = new TransportRegistrar$$Lambda$1();

    private TransportRegistrar$$Lambda$1() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    public Object create(ComponentContainer componentContainer) {
        return TransportRuntime.initialize((Context) componentContainer.get(Context.class));
    }
}
