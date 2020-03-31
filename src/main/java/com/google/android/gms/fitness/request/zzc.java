package com.google.android.gms.fitness.request;

import android.os.Looper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzc {
    private static final zzc zzoh = new zzc();
    private final Map<ListenerHolder.ListenerKey<BleScanCallback>, zzb> zzoi = new HashMap();

    private zzc() {
    }

    public static zzc zzx() {
        return zzoh;
    }

    public final zzb zza(BleScanCallback bleScanCallback, Looper looper) {
        return zza(zzc(bleScanCallback, looper));
    }

    public final zzb zza(ListenerHolder<BleScanCallback> listenerHolder) {
        zzb zzb;
        synchronized (this.zzoi) {
            zzb = this.zzoi.get(listenerHolder.getListenerKey());
            if (zzb == null) {
                zzb = new zzb(listenerHolder, null);
                this.zzoi.put(listenerHolder.getListenerKey(), zzb);
            }
        }
        return zzb;
    }

    public final zzb zzb(BleScanCallback bleScanCallback, Looper looper) {
        return zzb(zzc(bleScanCallback, looper));
    }

    public final zzb zzb(ListenerHolder<BleScanCallback> listenerHolder) {
        zzb zzb;
        synchronized (this.zzoi) {
            zzb = this.zzoi.get(listenerHolder.getListenerKey());
            if (zzb != null) {
                zzb.release();
            }
        }
        return zzb;
    }

    private static ListenerHolder<BleScanCallback> zzc(BleScanCallback bleScanCallback, Looper looper) {
        return ListenerHolders.createListenerHolder(bleScanCallback, looper, BleScanCallback.class.getSimpleName());
    }
}
