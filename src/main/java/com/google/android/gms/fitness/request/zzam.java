package com.google.android.gms.fitness.request;

import android.os.Looper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzam {
    private static final zzam zzpq = new zzam();
    private final Map<ListenerHolder.ListenerKey<OnDataPointListener>, zzak> zzpr = new HashMap();

    private zzam() {
    }

    public static zzam zzaa() {
        return zzpq;
    }

    public final zzak zzc(ListenerHolder<OnDataPointListener> listenerHolder) {
        zzak zzak;
        synchronized (this.zzpr) {
            zzak = this.zzpr.get(listenerHolder.getListenerKey());
            if (zzak == null) {
                zzak = new zzak(listenerHolder, null);
                this.zzpr.put(listenerHolder.getListenerKey(), zzak);
            }
        }
        return zzak;
    }

    public final zzak zza(OnDataPointListener onDataPointListener, Looper looper) {
        return zzc(zzc(onDataPointListener, looper));
    }

    public final zzak zzd(ListenerHolder<OnDataPointListener> listenerHolder) {
        zzak remove;
        synchronized (this.zzpr) {
            remove = this.zzpr.remove(listenerHolder.getListenerKey());
            if (remove != null) {
                remove.release();
            }
        }
        return remove;
    }

    public final zzak zzb(OnDataPointListener onDataPointListener, Looper looper) {
        return zzd(zzc(onDataPointListener, looper));
    }

    private static ListenerHolder<OnDataPointListener> zzc(OnDataPointListener onDataPointListener, Looper looper) {
        return ListenerHolders.createListenerHolder(onDataPointListener, looper, OnDataPointListener.class.getSimpleName());
    }
}
