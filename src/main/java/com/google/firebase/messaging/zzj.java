package com.google.firebase.messaging;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.2 */
final /* synthetic */ class zzj implements ComponentFactory {
    static final ComponentFactory zza = new zzj();

    private zzj() {
    }

    public final Object create(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.get(FirebaseApp.class);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class);
        TransportFactory transportFactory = (TransportFactory) componentContainer.get(TransportFactory.class);
        if (transportFactory == null || !CCTDestination.LEGACY_INSTANCE.getSupportedEncodings().contains(Encoding.of("json"))) {
            transportFactory = new FirebaseMessagingRegistrar.zza();
        }
        return new FirebaseMessaging(firebaseApp, firebaseInstanceId, transportFactory);
    }
}
