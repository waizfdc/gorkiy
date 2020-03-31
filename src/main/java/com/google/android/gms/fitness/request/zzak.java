package com.google.android.gms.fitness.request;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzt;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzak extends zzt {
    private final ListenerHolder<OnDataPointListener> zzpp;

    private zzak(ListenerHolder<OnDataPointListener> listenerHolder) {
        this.zzpp = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    public final void zzc(DataPoint dataPoint) {
        this.zzpp.notifyListener(new zzan(this, dataPoint));
    }

    public final void release() {
        this.zzpp.clear();
    }

    /* synthetic */ zzak(ListenerHolder listenerHolder, zzan zzan) {
        this(listenerHolder);
    }
}
