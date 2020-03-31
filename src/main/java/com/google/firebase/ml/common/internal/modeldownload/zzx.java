package com.google.firebase.ml.common.internal.modeldownload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznq;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.ml.common.FirebaseMLException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzx extends BroadcastReceiver {
    private final long zzbff;
    private final TaskCompletionSource<Void> zzbfg;
    private final /* synthetic */ zzv zzbfh;

    private zzx(zzv zzv, long j, TaskCompletionSource<Void> taskCompletionSource) {
        this.zzbfh = zzv;
        this.zzbff = j;
        this.zzbfg = taskCompletionSource;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.ml.common.internal.modeldownload.zzw.zza(boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, int):void
     arg types: [int, com.google.firebase.ml.common.internal.modeldownload.zzn, int]
     candidates:
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, int):void */
    public final void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("extra_download_id", -1);
        if (longExtra == this.zzbff) {
            Integer zzol = this.zzbfh.zzol();
            synchronized (this.zzbfh) {
                try {
                    this.zzbfh.zzbdc.getApplicationContext().unregisterReceiver(super);
                } catch (IllegalArgumentException e) {
                    zzv.zzbbo.w("ModelDownloadManager", "Exception thrown while trying to unregister the broadcast receiver for the download", e);
                }
                this.zzbfh.zzbex.remove(this.zzbff);
                this.zzbfh.zzbey.remove(this.zzbff);
            }
            if (zzol != null) {
                if (zzol.intValue() == 16) {
                    this.zzbfh.zzbfb.zza(false, this.zzbfh.zzor(), this.zzbfh.zza(Long.valueOf(longExtra)));
                    this.zzbfg.setException(this.zzbfh.zzb(Long.valueOf(longExtra)));
                    return;
                } else if (zzol.intValue() == 8) {
                    this.zzbfh.zzbfb.zza(zznq.NO_ERROR, this.zzbfh.zzor(), zzng.zzag.zzb.SUCCEEDED);
                    this.zzbfg.setResult(null);
                    return;
                }
            }
            this.zzbfh.zzbfb.zza(false, this.zzbfh.zzor(), 0);
            this.zzbfg.setException(new FirebaseMLException("Model downloading failed", 13));
        }
    }
}
