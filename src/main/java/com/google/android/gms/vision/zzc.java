package com.google.android.gms.vision;

import android.util.SparseIntArray;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public final class zzc {
    private static final Object lock = new Object();
    private static int zzat = 0;
    private final SparseIntArray zzau = new SparseIntArray();
    private final SparseIntArray zzav = new SparseIntArray();

    public final int zzb(int i) {
        synchronized (lock) {
            int i2 = this.zzau.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            int i3 = zzat;
            zzat++;
            this.zzau.append(i, i3);
            this.zzav.append(i3, i);
            return i3;
        }
    }

    public final int zzc(int i) {
        int i2;
        synchronized (lock) {
            i2 = this.zzav.get(i);
        }
        return i2;
    }
}
