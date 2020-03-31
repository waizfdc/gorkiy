package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zaaf implements zabb {
    /* access modifiers changed from: private */
    public final zabe zafv;
    private boolean zafw = false;

    public zaaf(zabe zabe) {
        this.zafv = zabe;
    }

    public final void begin() {
    }

    public final void onConnected(Bundle bundle) {
    }

    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        return execute(t);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        try {
            this.zafv.zaeh.zahj.zac(t);
            zaaw zaaw = this.zafv.zaeh;
            Api.Client client = zaaw.zahd.get(t.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !this.zafv.zaht.containsKey(t.getClientKey())) {
                boolean z = client instanceof SimpleClientAdapter;
                Object obj = client;
                if (z) {
                    obj = ((SimpleClientAdapter) client).getClient();
                }
                t.run(obj);
                return t;
            }
            t.setFailedResult(new Status(17));
            return t;
        } catch (DeadObjectException unused) {
            this.zafv.zaa(new zaai(this, this));
        }
    }

    public final boolean disconnect() {
        if (this.zafw) {
            return false;
        }
        if (this.zafv.zaeh.zaav()) {
            this.zafw = true;
            for (zack zabt : this.zafv.zaeh.zahi) {
                zabt.zabt();
            }
            return false;
        }
        this.zafv.zaf(null);
        return true;
    }

    public final void connect() {
        if (this.zafw) {
            this.zafw = false;
            this.zafv.zaa(new zaah(this, this));
        }
    }

    public final void onConnectionSuspended(int i) {
        this.zafv.zaf(null);
        this.zafv.zahx.zab(i, this.zafw);
    }

    /* access modifiers changed from: package-private */
    public final void zaak() {
        if (this.zafw) {
            this.zafw = false;
            this.zafv.zaeh.zahj.release();
            disconnect();
        }
    }
}
