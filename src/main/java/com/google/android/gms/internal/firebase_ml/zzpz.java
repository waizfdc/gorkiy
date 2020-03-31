package com.google.android.gms.internal.firebase_ml;

import android.app.Application;
import android.content.Context;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.ml.common.FirebaseMLException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzpz {
    /* access modifiers changed from: private */
    public static final GmsLogger zzbbz = new GmsLogger("ModelResourceManager", "");
    public static final Component<?> zzbcb = Component.builder(zzpz.class).add(Dependency.required(Context.class)).factory(zzqa.zzbbm).build();
    private final zzpf zzbdf = zzpf.zzno();
    private final AtomicLong zzbdg = new AtomicLong(PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
    private final Set<zzpx> zzbdh = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzpx> zzbdi = new HashSet();
    private final ConcurrentHashMap<zzpx, zza> zzbdj = new ConcurrentHashMap<>();

    private zzpz(Context context) {
        if (context instanceof Application) {
            BackgroundDetector.initialize((Application) context);
        } else {
            zzbbz.e("ModelResourceManager", "No valid Application available and auto-manage cannot work");
        }
        BackgroundDetector.getInstance().addListener(new zzpy(this));
        if (BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
            this.zzbdg.set(2000);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    class zza implements Callable<Void> {
        private final zzpx zzbdk;
        private final String zzbdl;

        zza(zzpx zzpx, String str) {
            this.zzbdk = zzpx;
            this.zzbdl = str;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
        /* renamed from: zznx */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Void call() {
            /*
                r4 = this;
                java.lang.String r0 = r4.zzbdl
                int r1 = r0.hashCode()
                r2 = 97847535(0x5d508ef, float:2.0033705E-35)
                r3 = 1
                if (r1 == r2) goto L_0x001c
                r2 = 710591710(0x2a5ac4de, float:1.9430592E-13)
                if (r1 == r2) goto L_0x0012
                goto L_0x0026
            L_0x0012:
                java.lang.String r1 = "OPERATION_LOAD"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0026
                r0 = 0
                goto L_0x0027
            L_0x001c:
                java.lang.String r1 = "OPERATION_RELEASE"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0026
                r0 = r3
                goto L_0x0027
            L_0x0026:
                r0 = -1
            L_0x0027:
                java.lang.String r1 = "ModelResourceManager"
                if (r0 == 0) goto L_0x0046
                if (r0 == r3) goto L_0x002e
                goto L_0x0058
            L_0x002e:
                com.google.android.gms.internal.firebase_ml.zzpx r0 = r4.zzbdk
                com.google.android.gms.common.internal.GmsLogger r2 = com.google.android.gms.internal.firebase_ml.zzpz.zzbbz
                java.lang.String r3 = "Releasing modelResource"
                r2.v(r1, r3)
                r0.release()
                com.google.android.gms.internal.firebase_ml.zzpz r1 = com.google.android.gms.internal.firebase_ml.zzpz.this
                java.util.Set r1 = r1.zzbdi
                r1.remove(r0)
                goto L_0x0058
            L_0x0046:
                com.google.android.gms.internal.firebase_ml.zzpx r0 = r4.zzbdk
                com.google.android.gms.internal.firebase_ml.zzpz r2 = com.google.android.gms.internal.firebase_ml.zzpz.this     // Catch:{ FirebaseMLException -> 0x004e }
                r2.zzf(r0)     // Catch:{ FirebaseMLException -> 0x004e }
                goto L_0x0058
            L_0x004e:
                r0 = move-exception
                com.google.android.gms.common.internal.GmsLogger r2 = com.google.android.gms.internal.firebase_ml.zzpz.zzbbz
                java.lang.String r3 = "Error preloading model resource"
                r2.e(r1, r3, r0)
            L_0x0058:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzpz.zza.call():java.lang.Void");
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (!Objects.equal(this.zzbdk, zza.zzbdk) || !Objects.equal(this.zzbdl, zza.zzbdl)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return Objects.hashCode(this.zzbdk, this.zzbdl);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.internal.firebase_ml.zzpx r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "Model source can not be null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4, r0)     // Catch:{ all -> 0x003a }
            com.google.android.gms.common.internal.GmsLogger r0 = com.google.android.gms.internal.firebase_ml.zzpz.zzbbz     // Catch:{ all -> 0x003a }
            java.lang.String r1 = "ModelResourceManager"
            java.lang.String r2 = "Add auto-managed model resource"
            r0.d(r1, r2)     // Catch:{ all -> 0x003a }
            java.util.Set<com.google.android.gms.internal.firebase_ml.zzpx> r0 = r3.zzbdh     // Catch:{ all -> 0x003a }
            boolean r0 = r0.contains(r4)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.common.internal.GmsLogger r4 = com.google.android.gms.internal.firebase_ml.zzpz.zzbbz     // Catch:{ all -> 0x003a }
            java.lang.String r0 = "ModelResourceManager"
            java.lang.String r1 = "The model resource is already registered."
            r4.i(r0, r1)     // Catch:{ all -> 0x003a }
            monitor-exit(r3)
            return
        L_0x0022:
            java.util.Set<com.google.android.gms.internal.firebase_ml.zzpx> r0 = r3.zzbdh     // Catch:{ all -> 0x003a }
            r0.add(r4)     // Catch:{ all -> 0x003a }
            if (r4 == 0) goto L_0x0038
            com.google.android.gms.internal.firebase_ml.zzpf r0 = r3.zzbdf     // Catch:{ all -> 0x003a }
            com.google.android.gms.internal.firebase_ml.zzpz$zza r1 = new com.google.android.gms.internal.firebase_ml.zzpz$zza     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "OPERATION_LOAD"
            r1.<init>(r4, r2)     // Catch:{ all -> 0x003a }
            r0.zza(r1)     // Catch:{ all -> 0x003a }
            r3.zzb(r4)     // Catch:{ all -> 0x003a }
        L_0x0038:
            monitor-exit(r3)
            return
        L_0x003a:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzpz.zza(com.google.android.gms.internal.firebase_ml.zzpx):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzb(zzpx zzpx) {
        if (this.zzbdh.contains(zzpx)) {
            zzc(zzpx);
        }
    }

    private final synchronized void zznv() {
        for (zzpx zzc : this.zzbdh) {
            zzc(zzc);
        }
    }

    private final void zzc(zzpx zzpx) {
        zza zze = zze(zzpx);
        this.zzbdf.zzb(zze);
        long j = this.zzbdg.get();
        GmsLogger gmsLogger = zzbbz;
        StringBuilder sb = new StringBuilder(62);
        sb.append("Rescheduling modelResource release after: ");
        sb.append(j);
        gmsLogger.v("ModelResourceManager", sb.toString());
        this.zzbdf.zza(zze, j);
    }

    public final synchronized void zzd(zzpx zzpx) {
        if (zzpx != null) {
            zza zze = zze(zzpx);
            this.zzbdf.zzb(zze);
            this.zzbdf.zza(zze, 0);
        }
    }

    private final zza zze(zzpx zzpx) {
        this.zzbdj.putIfAbsent(zzpx, new zza(zzpx, "OPERATION_RELEASE"));
        return this.zzbdj.get(zzpx);
    }

    /* access modifiers changed from: package-private */
    public final void zzf(zzpx zzpx) throws FirebaseMLException {
        if (!this.zzbdi.contains(zzpx)) {
            try {
                zzpx.zznu();
                this.zzbdi.add(zzpx);
            } catch (RuntimeException e) {
                throw new FirebaseMLException("The load task failed", 13, e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaq(boolean z) {
        GmsLogger gmsLogger = zzbbz;
        StringBuilder sb = new StringBuilder(34);
        sb.append("Background state changed to: ");
        sb.append(z);
        gmsLogger.v("ModelResourceManager", sb.toString());
        this.zzbdg.set(z ? 2000 : PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        zznv();
    }

    static final /* synthetic */ zzpz zzd(ComponentContainer componentContainer) {
        return new zzpz((Context) componentContainer.get(Context.class));
    }
}
