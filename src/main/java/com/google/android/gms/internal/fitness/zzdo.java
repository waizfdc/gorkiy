package com.google.android.gms.internal.fitness;

import android.util.Log;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.fitness.result.DataReadResult;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzdo extends zzbe {
    private final BaseImplementation.ResultHolder<DataReadResult> zzmv;
    private int zznp;
    private DataReadResult zznq;

    private zzdo(BaseImplementation.ResultHolder<DataReadResult> resultHolder) {
        this.zznp = 0;
        this.zznq = null;
        this.zzmv = resultHolder;
    }

    public final void zza(DataReadResult dataReadResult) {
        synchronized (this) {
            if (Log.isLoggable("Fitness", 2)) {
                int i = this.zznp;
                StringBuilder sb = new StringBuilder(33);
                sb.append("Received batch result ");
                sb.append(i);
                Log.v("Fitness", sb.toString());
            }
            if (this.zznq == null) {
                this.zznq = dataReadResult;
            } else {
                this.zznq.zzb(dataReadResult);
            }
            int i2 = this.zznp + 1;
            this.zznp = i2;
            if (i2 == this.zznq.zzae()) {
                this.zzmv.setResult(this.zznq);
            }
        }
    }

    /* synthetic */ zzdo(BaseImplementation.ResultHolder resultHolder, zzdg zzdg) {
        this(resultHolder);
    }
}
