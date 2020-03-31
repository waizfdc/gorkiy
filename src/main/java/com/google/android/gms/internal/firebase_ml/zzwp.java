package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class zzwp {
    private static final zzvk zzbyz = zzvk.zzth();
    private zzuq zzcex;
    private volatile zzxg zzcey;
    private volatile zzuq zzcez;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzwp)) {
            return false;
        }
        zzwp zzwp = (zzwp) obj;
        zzxg zzxg = this.zzcey;
        zzxg zzxg2 = zzwp.zzcey;
        if (zzxg == null && zzxg2 == null) {
            return zzsk().equals(zzwp.zzsk());
        }
        if (zzxg != null && zzxg2 != null) {
            return zzxg.equals(zzxg2);
        }
        if (zzxg != null) {
            return zzxg.equals(zzwp.zzh(zzxg.zzty()));
        }
        return zzh(zzxg2.zzty()).equals(zzxg2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.firebase_ml.zzxg zzh(com.google.android.gms.internal.firebase_ml.zzxg r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase_ml.zzxg r0 = r1.zzcey
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.firebase_ml.zzxg r0 = r1.zzcey     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzcey = r2     // Catch:{ zzwg -> 0x0012 }
            com.google.android.gms.internal.firebase_ml.zzuq r0 = com.google.android.gms.internal.firebase_ml.zzuq.zzbzh     // Catch:{ zzwg -> 0x0012 }
            r1.zzcez = r0     // Catch:{ zzwg -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzcey = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.firebase_ml.zzuq r2 = com.google.android.gms.internal.firebase_ml.zzuq.zzbzh     // Catch:{ all -> 0x001a }
            r1.zzcez = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.firebase_ml.zzxg r2 = r1.zzcey
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzwp.zzh(com.google.android.gms.internal.firebase_ml.zzxg):com.google.android.gms.internal.firebase_ml.zzxg");
    }

    public final zzxg zzi(zzxg zzxg) {
        zzxg zzxg2 = this.zzcey;
        this.zzcex = null;
        this.zzcez = null;
        this.zzcey = zzxg;
        return zzxg2;
    }

    public final int zzua() {
        if (this.zzcez != null) {
            return this.zzcez.size();
        }
        if (this.zzcey != null) {
            return this.zzcey.zzua();
        }
        return 0;
    }

    public final zzuq zzsk() {
        if (this.zzcez != null) {
            return this.zzcez;
        }
        synchronized (this) {
            if (this.zzcez != null) {
                zzuq zzuq = this.zzcez;
                return zzuq;
            }
            if (this.zzcey == null) {
                this.zzcez = zzuq.zzbzh;
            } else {
                this.zzcez = this.zzcey.zzsk();
            }
            zzuq zzuq2 = this.zzcez;
            return zzuq2;
        }
    }
}
