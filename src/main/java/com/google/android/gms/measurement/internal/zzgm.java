package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
final class zzgm<V> extends FutureTask<V> implements Comparable<zzgm<V>> {
    final boolean zza;
    private final long zzb;
    private final String zzc;
    private final /* synthetic */ zzgh zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgm(zzgh zzgh, Callable callable, boolean z, String str) {
        super(callable);
        this.zzd = zzgh;
        Preconditions.checkNotNull(str);
        long andIncrement = zzgh.zzj.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z;
        if (andIncrement == LongCompanionObject.MAX_VALUE) {
            zzgh.zzr().zzf().zza("Tasks index overflow");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgm(zzgh zzgh, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.zzd = zzgh;
        Preconditions.checkNotNull(str);
        long andIncrement = zzgh.zzj.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = false;
        if (andIncrement == LongCompanionObject.MAX_VALUE) {
            zzgh.zzr().zzf().zza("Tasks index overflow");
        }
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.zzd.zzr().zzf().zza(this.zzc, th);
        if (th instanceof zzgk) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        zzgm zzgm = (zzgm) obj;
        boolean z = this.zza;
        if (z != zzgm.zza) {
            return z ? -1 : 1;
        }
        long j = this.zzb;
        long j2 = zzgm.zzb;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzd.zzr().zzg().zza("Two tasks share the same index. index", Long.valueOf(this.zzb));
        return 0;
    }
}
