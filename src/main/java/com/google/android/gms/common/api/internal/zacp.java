package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zacp {
    public static final Status zalb = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult<?>[] zalc = new BasePendingResult[0];
    private final Map<Api.AnyClientKey<?>, Api.Client> zahd;
    final Set<BasePendingResult<?>> zald = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zacq zale = new zaco(this);

    public zacp(Map<Api.AnyClientKey<?>, Api.Client> map) {
        this.zahd = map;
    }

    /* access modifiers changed from: package-private */
    public final void zac(BasePendingResult<? extends Result> basePendingResult) {
        this.zald.add(basePendingResult);
        basePendingResult.zaa(this.zale);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.android.gms.common.api.ResultCallback, com.google.android.gms.common.api.zac, com.google.android.gms.common.api.internal.zacq, com.google.android.gms.common.api.internal.zaco] */
    public final void release() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.zald.toArray(zalc)) {
            ? r5 = 0;
            basePendingResult.zaa((zacq) r5);
            if (basePendingResult.zal() != null) {
                basePendingResult.setResultCallback(r5);
                IBinder serviceBrokerBinder = this.zahd.get(((BaseImplementation.ApiMethodImpl) basePendingResult).getClientKey()).getServiceBrokerBinder();
                if (basePendingResult.isReady()) {
                    basePendingResult.zaa(new zacr(basePendingResult, r5, serviceBrokerBinder, r5));
                } else if (serviceBrokerBinder == null || !serviceBrokerBinder.isBinderAlive()) {
                    basePendingResult.zaa((zacq) r5);
                    basePendingResult.cancel();
                    r5.remove(basePendingResult.zal().intValue());
                } else {
                    zacr zacr = new zacr(basePendingResult, r5, serviceBrokerBinder, r5);
                    basePendingResult.zaa(zacr);
                    try {
                        serviceBrokerBinder.linkToDeath(zacr, 0);
                    } catch (RemoteException unused) {
                        basePendingResult.cancel();
                        r5.remove(basePendingResult.zal().intValue());
                    }
                }
                this.zald.remove(basePendingResult);
            } else if (basePendingResult.zaq()) {
                this.zald.remove(basePendingResult);
            }
        }
    }

    public final void zabv() {
        for (BasePendingResult zab : (BasePendingResult[]) this.zald.toArray(zalc)) {
            zab.zab(zalb);
        }
    }
}
