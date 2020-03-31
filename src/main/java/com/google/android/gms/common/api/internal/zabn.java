package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zabn<O extends Api.ApiOptions> extends zaag {
    private final GoogleApi<O> zajj;

    public zabn(GoogleApi<O> googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.zajj = googleApi;
    }

    public final void zaa(zack zack) {
    }

    public final void zab(zack zack) {
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        return this.zajj.doRead((BaseImplementation.ApiMethodImpl) t);
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        return this.zajj.doWrite((BaseImplementation.ApiMethodImpl) t);
    }

    public final Looper getLooper() {
        return this.zajj.getLooper();
    }

    public final Context getContext() {
        return this.zajj.getApplicationContext();
    }
}
