package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public class zzhh {
    private static final zzgd zzrl = zzgd.zzfl();
    private zzfh zzxx;
    private volatile zzic zzxy;
    private volatile zzfh zzxz;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhh)) {
            return false;
        }
        zzhh zzhh = (zzhh) obj;
        zzic zzic = this.zzxy;
        zzic zzic2 = zzhh.zzxy;
        if (zzic == null && zzic2 == null) {
            return zzdk().equals(zzhh.zzdk());
        }
        if (zzic != null && zzic2 != null) {
            return zzic.equals(zzic2);
        }
        if (zzic != null) {
            return zzic.equals(zzhh.zzh(zzic.zzgd()));
        }
        return zzh(zzic2.zzgd()).equals(zzic2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.vision.zzic zzh(com.google.android.gms.internal.vision.zzic r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.vision.zzic r0 = r1.zzxy
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.vision.zzic r0 = r1.zzxy     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzxy = r2     // Catch:{ zzhc -> 0x0012 }
            com.google.android.gms.internal.vision.zzfh r0 = com.google.android.gms.internal.vision.zzfh.zzrx     // Catch:{ zzhc -> 0x0012 }
            r1.zzxz = r0     // Catch:{ zzhc -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzxy = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.vision.zzfh r2 = com.google.android.gms.internal.vision.zzfh.zzrx     // Catch:{ all -> 0x001a }
            r1.zzxz = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.vision.zzic r2 = r1.zzxy
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzhh.zzh(com.google.android.gms.internal.vision.zzic):com.google.android.gms.internal.vision.zzic");
    }

    public final zzic zzi(zzic zzic) {
        zzic zzic2 = this.zzxy;
        this.zzxx = null;
        this.zzxz = null;
        this.zzxy = zzic;
        return zzic2;
    }

    public final int zzgf() {
        if (this.zzxz != null) {
            return this.zzxz.size();
        }
        if (this.zzxy != null) {
            return this.zzxy.zzgf();
        }
        return 0;
    }

    public final zzfh zzdk() {
        if (this.zzxz != null) {
            return this.zzxz;
        }
        synchronized (this) {
            if (this.zzxz != null) {
                zzfh zzfh = this.zzxz;
                return zzfh;
            }
            if (this.zzxy == null) {
                this.zzxz = zzfh.zzrx;
            } else {
                this.zzxz = this.zzxy.zzdk();
            }
            zzfh zzfh2 = this.zzxz;
            return zzfh2;
        }
    }
}
