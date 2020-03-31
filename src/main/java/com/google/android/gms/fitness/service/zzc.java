package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzu;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzc implements SensorEventDispatcher {
    private final zzu zzpt;

    zzc(zzu zzu) {
        this.zzpt = (zzu) Preconditions.checkNotNull(zzu);
    }

    public final void publish(DataPoint dataPoint) throws RemoteException {
        dataPoint.zzj();
        this.zzpt.zzc(dataPoint);
    }

    public final void publish(List<DataPoint> list) throws RemoteException {
        for (DataPoint publish : list) {
            publish(publish);
        }
    }
}
