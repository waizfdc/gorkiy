package com.google.android.gms.vision.clearcut;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public final class zzb {
    private final Object lock = new Object();
    private final long zzbt = Math.round(30000.0d);
    private long zzbu = Long.MIN_VALUE;

    public zzb(double d) {
    }

    public final boolean tryAcquire() {
        synchronized (this.lock) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zzbu + this.zzbt > currentTimeMillis) {
                return false;
            }
            this.zzbu = currentTimeMillis;
            return true;
        }
    }
}
