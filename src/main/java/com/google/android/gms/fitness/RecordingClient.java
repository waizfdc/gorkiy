package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.fitness.zzai;
import com.google.android.gms.internal.fitness.zzdr;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class RecordingClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private static final RecordingApi zzie = new zzdr();

    protected RecordingClient(Context context, Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, zzai.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.common.api.GoogleApi.<init>(android.app.Activity, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.GoogleApi$Settings):void
     arg types: [android.app.Activity, com.google.android.gms.common.api.Api<com.google.android.gms.common.api.Api$ApiOptions$HasGoogleSignInAccountOptions>, com.google.android.gms.common.api.Api$ApiOptions$HasGoogleSignInAccountOptions, com.google.android.gms.common.api.GoogleApi$Settings]
     candidates:
      com.google.android.gms.common.api.GoogleApi.<init>(android.app.Activity, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void
      com.google.android.gms.common.api.GoogleApi.<init>(android.content.Context, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.GoogleApi$Settings):void
      com.google.android.gms.common.api.GoogleApi.<init>(android.content.Context, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void
      com.google.android.gms.common.api.GoogleApi.<init>(android.app.Activity, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.GoogleApi$Settings):void */
    RecordingClient(Activity activity, Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(activity, (Api) zzai.zzmx, (Api.ApiOptions) hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<Void> subscribe(DataType dataType) {
        return PendingResultUtil.toVoidTask(zzie.subscribe(asGoogleApiClient(), dataType));
    }

    public Task<Void> subscribe(DataSource dataSource) {
        return PendingResultUtil.toVoidTask(zzie.subscribe(asGoogleApiClient(), dataSource));
    }

    public Task<Void> unsubscribe(DataType dataType) {
        return PendingResultUtil.toVoidTask(zzie.unsubscribe(asGoogleApiClient(), dataType));
    }

    public Task<Void> unsubscribe(DataSource dataSource) {
        return PendingResultUtil.toVoidTask(zzie.unsubscribe(asGoogleApiClient(), dataSource));
    }

    public Task<Void> unsubscribe(Subscription subscription) {
        return PendingResultUtil.toVoidTask(zzie.unsubscribe(asGoogleApiClient(), subscription));
    }

    public Task<List<Subscription>> listSubscriptions() {
        return PendingResultUtil.toTask(zzie.listSubscriptions(asGoogleApiClient()), zzm.zzho);
    }

    public Task<List<Subscription>> listSubscriptions(DataType dataType) {
        return PendingResultUtil.toTask(zzie.listSubscriptions(asGoogleApiClient(), dataType), zzl.zzho);
    }
}
