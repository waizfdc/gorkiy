package com.google.firebase.iid;

import android.os.Handler;
import android.os.Message;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
final /* synthetic */ class zzae implements Handler.Callback {
    private final zzaf zza;

    zzae(zzaf zzaf) {
        this.zza = zzaf;
    }

    public final boolean handleMessage(Message message) {
        return this.zza.zza(message);
    }
}
