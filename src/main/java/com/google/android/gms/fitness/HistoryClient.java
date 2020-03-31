package com.google.android.gms.fitness;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DataReadResponse;
import com.google.android.gms.internal.fitness.zzac;
import com.google.android.gms.internal.fitness.zzdh;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class HistoryClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private static final HistoryApi zzhx = new zzdh();

    protected HistoryClient(Context context, Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, zzac.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.common.api.GoogleApi.<init>(android.app.Activity, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.GoogleApi$Settings):void
     arg types: [android.app.Activity, com.google.android.gms.common.api.Api<com.google.android.gms.common.api.Api$ApiOptions$HasGoogleSignInAccountOptions>, com.google.android.gms.common.api.Api$ApiOptions$HasGoogleSignInAccountOptions, com.google.android.gms.common.api.GoogleApi$Settings]
     candidates:
      com.google.android.gms.common.api.GoogleApi.<init>(android.app.Activity, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void
      com.google.android.gms.common.api.GoogleApi.<init>(android.content.Context, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.GoogleApi$Settings):void
      com.google.android.gms.common.api.GoogleApi.<init>(android.content.Context, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void
      com.google.android.gms.common.api.GoogleApi.<init>(android.app.Activity, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.GoogleApi$Settings):void */
    HistoryClient(Activity activity, Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(activity, (Api) zzac.zzmx, (Api.ApiOptions) hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<DataReadResponse> readData(DataReadRequest dataReadRequest) {
        return PendingResultUtil.toResponseTask(zzhx.readData(asGoogleApiClient(), dataReadRequest), new DataReadResponse());
    }

    public Task<DataSet> readDailyTotal(DataType dataType) {
        return PendingResultUtil.toTask(zzhx.readDailyTotal(asGoogleApiClient(), dataType), zzk.zzho);
    }

    public Task<DataSet> readDailyTotalFromLocalDevice(DataType dataType) {
        return PendingResultUtil.toTask(zzhx.readDailyTotalFromLocalDevice(asGoogleApiClient(), dataType), zzj.zzho);
    }

    public Task<Void> insertData(DataSet dataSet) {
        return PendingResultUtil.toVoidTask(zzhx.insertData(asGoogleApiClient(), dataSet));
    }

    public Task<Void> deleteData(DataDeleteRequest dataDeleteRequest) {
        return PendingResultUtil.toVoidTask(zzhx.deleteData(asGoogleApiClient(), dataDeleteRequest));
    }

    public Task<Void> updateData(DataUpdateRequest dataUpdateRequest) {
        return PendingResultUtil.toVoidTask(zzhx.updateData(asGoogleApiClient(), dataUpdateRequest));
    }

    public Task<Void> registerDataUpdateListener(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) {
        return PendingResultUtil.toVoidTask(zzhx.registerDataUpdateListener(asGoogleApiClient(), dataUpdateListenerRegistrationRequest));
    }

    public Task<Void> unregisterDataUpdateListener(PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(zzhx.unregisterDataUpdateListener(asGoogleApiClient(), pendingIntent));
    }
}
