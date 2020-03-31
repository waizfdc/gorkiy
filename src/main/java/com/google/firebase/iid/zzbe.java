package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
public final class zzbe extends Binder {
    private final zzbg zza;

    public zzbe(zzbg zzbg) {
        this.zza = zzbg;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbi zzbi) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
            }
            this.zza.zza(zzbi.zza).addOnCompleteListener(zzh.zza(), new zzbh(zzbi));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
