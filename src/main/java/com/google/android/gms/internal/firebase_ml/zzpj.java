package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class zzpj {
    private static final GmsLogger zzbbz = new GmsLogger("MLTaskManager", "");
    public static final Component<?> zzbcb = Component.builder(zzpj.class).add(Dependency.required(zzpz.class)).factory(zzpk.zzbbm).build();
    private final zzpz zzbca;

    private zzpj(zzpz zzpz) {
        this.zzbca = zzpz;
    }

    public static synchronized zzpj zza(zzpn zzpn) {
        zzpj zzpj;
        Class<zzpj> cls = zzpj.class;
        synchronized (cls) {
            zzpj = (zzpj) zzpn.get(cls);
        }
        return zzpj;
    }

    public final <T, S extends zzpg> void zza(zzpc<T, S> zzpc) {
        zzpx zznl = zzpc.zznl();
        if (zznl != null) {
            this.zzbca.zza(zznl);
        }
    }

    public final <T, S extends zzpg> void zzb(zzpc<T, S> zzpc) {
        zzpx zznl = zzpc.zznl();
        if (zznl != null) {
            this.zzbca.zzd(zznl);
        }
    }

    public final synchronized <TResult> Task<TResult> zza(zzpx zzpx, Callable<TResult> callable) {
        Preconditions.checkNotNull(callable, "Operation can not be null");
        Preconditions.checkNotNull(zzpx, "Model resource can not be null");
        zzbbz.d("MLTaskManager", "Execute task");
        this.zzbca.zzb(zzpx);
        return zzpf.zzno().zza(new zzpi(this, zzpx, callable));
    }

    public final synchronized <T, S extends zzpg> Task<T> zza(zzpc<T, S> zzpc, S s) {
        zzpx zznl;
        Preconditions.checkNotNull(zzpc, "Operation can not be null");
        Preconditions.checkNotNull(s, "Input can not be null");
        zzbbz.d("MLTaskManager", "Execute task");
        zznl = zzpc.zznl();
        if (zznl != null) {
            this.zzbca.zzb(zznl);
        }
        return zzpf.zzno().zza(new zzpl(this, zznl, zzpc, s));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(zzpx zzpx, zzpc zzpc, zzpg zzpg) throws Exception {
        if (zzpx != null) {
            this.zzbca.zzf(zzpx);
        }
        return zzpc.zza(zzpg);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzb(zzpx zzpx, Callable callable) throws Exception {
        this.zzbca.zzf(zzpx);
        return callable.call();
    }

    static final /* synthetic */ zzpj zza(ComponentContainer componentContainer) {
        return new zzpj((zzpz) componentContainer.get(zzpz.class));
    }
}
