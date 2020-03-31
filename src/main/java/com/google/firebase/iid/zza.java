package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-iid@@20.1.1 */
public final class zza implements zzb {
    private static final Object zza = new Object();
    private static zzbj zzb;
    private final Context zzc;
    private final ExecutorService zzd;

    public zza(Context context, ExecutorService executorService) {
        this.zzc = context;
        this.zzd = executorService;
    }

    public final Task<Integer> zza(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        boolean z = false;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        Context context = this.zzc;
        boolean z2 = PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & 268435456) != 0) {
            z = true;
        }
        if (!z2 || z) {
            return Tasks.call(this.zzd, new zzd(context, intent)).continueWithTask(this.zzd, new zzc(context, intent));
        }
        return zzb(context, intent);
    }

    private static Task<Integer> zzb(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Binding to service");
        }
        return zza(context, "com.google.firebase.MESSAGING_EVENT").zza(intent).continueWith(zzh.zza(), zzf.zza);
    }

    private static zzbj zza(Context context, String str) {
        zzbj zzbj;
        synchronized (zza) {
            if (zzb == null) {
                zzb = new zzbj(context, str);
            }
            zzbj = zzb;
        }
        return zzbj;
    }

    static final /* synthetic */ Integer zza(Task task) throws Exception {
        return -1;
    }

    static final /* synthetic */ Task zza(Context context, Intent intent, Task task) throws Exception {
        return (!PlatformVersion.isAtLeastO() || ((Integer) task.getResult()).intValue() != 402) ? task : zzb(context, intent).continueWith(zzh.zza(), zze.zza);
    }

    static final /* synthetic */ Integer zzb(Task task) throws Exception {
        return 403;
    }
}
