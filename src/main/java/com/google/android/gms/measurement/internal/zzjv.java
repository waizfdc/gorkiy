package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.internal.zzjz;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
public final class zzjv<T extends Context & zzjz> {
    private final T zza;

    public zzjv(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    public final void zza() {
        zzgo zza2 = zzgo.zza(this.zza, (zzv) null);
        zzfk zzr = zza2.zzr();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService is starting up");
    }

    public final void zzb() {
        zzgo zza2 = zzgo.zza(this.zza, (zzv) null);
        zzfk zzr = zza2.zzr();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService is shutting down");
    }

    public final int zza(Intent intent, int i, int i2) {
        zzgo zza2 = zzgo.zza(this.zza, (zzv) null);
        zzfk zzr = zza2.zzr();
        if (intent == null) {
            zzr.zzi().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza(new zzjy(this, i2, zzr, intent));
        }
        return 2;
    }

    private final void zza(Runnable runnable) {
        zzks zza2 = zzks.zza((Context) this.zza);
        zza2.zzq().zza(new zzka(this, zza2, runnable));
    }

    public final IBinder zza(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgp(zzks.zza((Context) this.zza));
        }
        zzc().zzi().zza("onBind received unknown action", action);
        return null;
    }

    public final boolean zzb(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzx().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final boolean zza(JobParameters jobParameters) {
        zzgo zza2 = zzgo.zza(this.zza, (zzv) null);
        zzfk zzr = zza2.zzr();
        String string = jobParameters.getExtras().getString("action");
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zza(new zzjx(this, zzr, jobParameters));
        return true;
    }

    public final void zzc(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onRebind called with null intent");
            return;
        }
        zzc().zzx().zza("onRebind called. action", intent.getAction());
    }

    private final zzfk zzc() {
        return zzgo.zza(this.zza, (zzv) null).zzr();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzfk zzfk, JobParameters jobParameters) {
        zzfk.zzx().zza("AppMeasurementJobService processed last upload request.");
        ((zzjz) this.zza).zza(jobParameters, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, zzfk zzfk, Intent intent) {
        if (((zzjz) this.zza).zza(i)) {
            zzfk.zzx().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzc().zzx().zza("Completed wakeful intent.");
            ((zzjz) this.zza).zza(intent);
        }
    }
}
