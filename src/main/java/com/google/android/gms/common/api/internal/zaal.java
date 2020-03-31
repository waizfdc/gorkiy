package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaal extends zaau {
    final /* synthetic */ zaak zafz;
    private final Map<Api.Client, zaam> zagn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaal(zaak zaak, Map<Api.Client, zaam> map) {
        super(zaak, null);
        this.zafz = zaak;
        this.zagn = map;
    }

    public final void zaal() {
        GoogleApiAvailabilityCache googleApiAvailabilityCache = new GoogleApiAvailabilityCache(this.zafz.zaey);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client next : this.zagn.keySet()) {
            if (!next.requiresGooglePlayServices() || this.zagn.get(next).zaee) {
                arrayList2.add(next);
            } else {
                arrayList.add(next);
            }
        }
        int i = -1;
        int i2 = 0;
        if (!arrayList.isEmpty()) {
            ArrayList arrayList3 = arrayList;
            int size = arrayList3.size();
            while (i2 < size) {
                Object obj = arrayList3.get(i2);
                i2++;
                i = googleApiAvailabilityCache.getClientAvailability(this.zafz.mContext, (Api.Client) obj);
                if (i != 0) {
                    break;
                }
            }
        } else {
            ArrayList arrayList4 = arrayList2;
            int size2 = arrayList4.size();
            while (i2 < size2) {
                Object obj2 = arrayList4.get(i2);
                i2++;
                i = googleApiAvailabilityCache.getClientAvailability(this.zafz.mContext, (Api.Client) obj2);
                if (i == 0) {
                    break;
                }
            }
        }
        if (i != 0) {
            this.zafz.zafv.zaa(new zaao(this, this.zafz, new ConnectionResult(i, null)));
            return;
        }
        if (this.zafz.zagh && this.zafz.zagf != null) {
            this.zafz.zagf.connect();
        }
        for (Api.Client next2 : this.zagn.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = this.zagn.get(next2);
            if (!next2.requiresGooglePlayServices() || googleApiAvailabilityCache.getClientAvailability(this.zafz.mContext, next2) == 0) {
                next2.connect(connectionProgressReportCallbacks);
            } else {
                this.zafz.zafv.zaa(new zaan(this, this.zafz, connectionProgressReportCallbacks));
            }
        }
    }
}
