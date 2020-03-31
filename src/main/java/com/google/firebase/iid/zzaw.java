package com.google.firebase.iid;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.firebase_messaging.zze;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
final class zzaw extends zze {
    private final /* synthetic */ zzax zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaw(zzax zzax, Looper looper) {
        super(looper);
        this.zza = zzax;
    }

    public final void handleMessage(Message message) {
        this.zza.zza(message);
    }
}
