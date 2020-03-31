package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zzh;
import com.google.android.gms.fitness.result.DailyTotalResult;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzdm extends zzah<DailyTotalResult> {
    private final /* synthetic */ DataType zznm;
    private final /* synthetic */ boolean zznn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdm(zzdh zzdh, GoogleApiClient googleApiClient, DataType dataType, boolean z) {
        super(googleApiClient);
        this.zznm = dataType;
        this.zznn = z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.fitness.request.zzh.<init>(com.google.android.gms.internal.fitness.zzba, com.google.android.gms.fitness.data.DataType, boolean):void
     arg types: [com.google.android.gms.internal.fitness.zzdp, com.google.android.gms.fitness.data.DataType, boolean]
     candidates:
      com.google.android.gms.fitness.request.zzh.<init>(android.os.IBinder, com.google.android.gms.fitness.data.DataType, boolean):void
      com.google.android.gms.fitness.request.zzh.<init>(com.google.android.gms.internal.fitness.zzba, com.google.android.gms.fitness.data.DataType, boolean):void */
    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzbx) ((zzac) anyClient).getService()).zza(new zzh((zzba) new zzdp(this), this.zznm, this.zznn));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return DailyTotalResult.zza(status, this.zznm);
    }
}
