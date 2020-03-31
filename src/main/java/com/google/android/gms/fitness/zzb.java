package com.google.android.gms.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzaf;
import com.google.android.gms.fitness.request.zzc;
import com.google.android.gms.internal.fitness.zzbr;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzel;
import com.google.android.gms.internal.fitness.zzn;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzb implements RemoteCall<zzn, TaskCompletionSource<Void>> {
    private final /* synthetic */ ListenerHolder zzhq;
    private final /* synthetic */ List zzhr;
    private final /* synthetic */ int zzhs;

    zzb(BleClient bleClient, ListenerHolder listenerHolder, List list, int i) {
        this.zzhq = listenerHolder;
        this.zzhr = list;
        this.zzhs = i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.fitness.request.StartBleScanRequest.<init>(java.util.List<com.google.android.gms.fitness.data.DataType>, com.google.android.gms.fitness.request.zzaf, int, com.google.android.gms.internal.fitness.zzcm):void
     arg types: [java.util.List, com.google.android.gms.fitness.request.zzb, int, com.google.android.gms.internal.fitness.zzel]
     candidates:
      com.google.android.gms.fitness.request.StartBleScanRequest.<init>(java.util.List<com.google.android.gms.fitness.data.DataType>, android.os.IBinder, int, android.os.IBinder):void
      com.google.android.gms.fitness.request.StartBleScanRequest.<init>(java.util.List, com.google.android.gms.fitness.request.BleScanCallback, int, com.google.android.gms.fitness.request.zzbf):void
      com.google.android.gms.fitness.request.StartBleScanRequest.<init>(java.util.List<com.google.android.gms.fitness.data.DataType>, com.google.android.gms.fitness.request.zzaf, int, com.google.android.gms.internal.fitness.zzcm):void */
    public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        ((zzbr) ((zzn) obj).getService()).zza(new StartBleScanRequest((List<DataType>) this.zzhr, (zzaf) zzc.zzx().zza(this.zzhq), this.zzhs, (zzcm) zzel.zza((TaskCompletionSource) obj2)));
    }
}
