package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
public class zzft {
    private static final zzeq zza = zzeq.zza();
    private zzdu zzb;
    private volatile zzgo zzc;
    private volatile zzdu zzd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzft)) {
            return false;
        }
        zzft zzft = (zzft) obj;
        zzgo zzgo = this.zzc;
        zzgo zzgo2 = zzft.zzc;
        if (zzgo == null && zzgo2 == null) {
            return zzc().equals(zzft.zzc());
        }
        if (zzgo != null && zzgo2 != null) {
            return zzgo.equals(zzgo2);
        }
        if (zzgo != null) {
            return zzgo.equals(zzft.zzb(zzgo.zzbt()));
        }
        return zzb(zzgo2.zzbt()).equals(zzgo2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzgo zzb(com.google.android.gms.internal.measurement.zzgo r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzgo r0 = r1.zzc
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzgo r0 = r1.zzc     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzc = r2     // Catch:{ zzfo -> 0x0012 }
            com.google.android.gms.internal.measurement.zzdu r0 = com.google.android.gms.internal.measurement.zzdu.zza     // Catch:{ zzfo -> 0x0012 }
            r1.zzd = r0     // Catch:{ zzfo -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzc = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.measurement.zzdu r2 = com.google.android.gms.internal.measurement.zzdu.zza     // Catch:{ all -> 0x001a }
            r1.zzd = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.measurement.zzgo r2 = r1.zzc
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzft.zzb(com.google.android.gms.internal.measurement.zzgo):com.google.android.gms.internal.measurement.zzgo");
    }

    public final zzgo zza(zzgo zzgo) {
        zzgo zzgo2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzgo;
        return zzgo2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzbn();
        }
        return 0;
    }

    public final zzdu zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzdu zzdu = this.zzd;
                return zzdu;
            }
            if (this.zzc == null) {
                this.zzd = zzdu.zza;
            } else {
                this.zzd = this.zzc.zzbh();
            }
            zzdu zzdu2 = this.zzd;
            return zzdu2;
        }
    }
}
