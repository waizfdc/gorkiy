package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzvx;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzyv {
    private static final zzyv zzchu = new zzyv(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzbyx;
    private int zzcdh;
    private Object[] zzcfu;
    private int[] zzchv;

    public static zzyv zzwc() {
        return zzchu;
    }

    static zzyv zzwd() {
        return new zzyv();
    }

    static zzyv zza(zzyv zzyv, zzyv zzyv2) {
        int i = zzyv.count + zzyv2.count;
        int[] copyOf = Arrays.copyOf(zzyv.zzchv, i);
        System.arraycopy(zzyv2.zzchv, 0, copyOf, zzyv.count, zzyv2.count);
        Object[] copyOf2 = Arrays.copyOf(zzyv.zzcfu, i);
        System.arraycopy(zzyv2.zzcfu, 0, copyOf2, zzyv.count, zzyv2.count);
        return new zzyv(i, copyOf, copyOf2, true);
    }

    private zzyv() {
        this(0, new int[8], new Object[8], true);
    }

    private zzyv(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzcdh = -1;
        this.count = i;
        this.zzchv = iArr;
        this.zzcfu = objArr;
        this.zzbyx = z;
    }

    public final void zzsp() {
        this.zzbyx = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzzp zzzp) throws IOException {
        if (zzzp.zztg() == zzvx.zzf.zzcdw) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzzp.zza(this.zzchv[i] >>> 3, this.zzcfu[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzzp.zza(this.zzchv[i2] >>> 3, this.zzcfu[i2]);
        }
    }

    public final void zzb(zzzp zzzp) throws IOException {
        if (this.count != 0) {
            if (zzzp.zztg() == zzvx.zzf.zzcdv) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzchv[i], this.zzcfu[i], zzzp);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzchv[i2], this.zzcfu[i2], zzzp);
            }
        }
    }

    private static void zzb(int i, Object obj, zzzp zzzp) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzzp.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzzp.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzzp.zza(i2, (zzuq) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzzp.zzl(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzwg.zzul());
        } else if (zzzp.zztg() == zzvx.zzf.zzcdv) {
            zzzp.zzdl(i2);
            ((zzyv) obj).zzb(zzzp);
            zzzp.zzdm(i2);
        } else {
            zzzp.zzdm(i2);
            ((zzyv) obj).zzb(zzzp);
            zzzp.zzdl(i2);
        }
    }

    public final int zzwe() {
        int i = this.zzcdh;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzvh.zzd(this.zzchv[i3] >>> 3, (zzuq) this.zzcfu[i3]);
        }
        this.zzcdh = i2;
        return i2;
    }

    public final int zzua() {
        int i;
        int i2 = this.zzcdh;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzchv[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzvh.zze(i6, ((Long) this.zzcfu[i4]).longValue());
            } else if (i7 == 1) {
                i = zzvh.zzg(i6, ((Long) this.zzcfu[i4]).longValue());
            } else if (i7 == 2) {
                i = zzvh.zzc(i6, (zzuq) this.zzcfu[i4]);
            } else if (i7 == 3) {
                i = (zzvh.zzdb(i6) << 1) + ((zzyv) this.zzcfu[i4]).zzua();
            } else if (i7 == 5) {
                i = zzvh.zzp(i6, ((Integer) this.zzcfu[i4]).intValue());
            } else {
                throw new IllegalStateException(zzwg.zzul());
            }
            i3 += i;
        }
        this.zzcdh = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzyv)) {
            return false;
        }
        zzyv zzyv = (zzyv) obj;
        int i = this.count;
        if (i == zzyv.count) {
            int[] iArr = this.zzchv;
            int[] iArr2 = zzyv.zzchv;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzcfu;
                Object[] objArr2 = zzyv.zzcfu;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzchv;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzcfu;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzxl.zza(sb, i, String.valueOf(this.zzchv[i2] >>> 3), this.zzcfu[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, Object obj) {
        if (this.zzbyx) {
            int i2 = this.count;
            if (i2 == this.zzchv.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzchv = Arrays.copyOf(this.zzchv, i3);
                this.zzcfu = Arrays.copyOf(this.zzcfu, i3);
            }
            int[] iArr = this.zzchv;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzcfu[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
