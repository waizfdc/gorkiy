package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public final class zzjm {
    private static final zzjm zzaaj = new zzjm(0, new int[0], new Object[0], false);
    private int count;
    private int[] zzaak;
    private boolean zzrj;
    private int zzwe;
    private Object[] zzyv;

    public static zzjm zzig() {
        return zzaaj;
    }

    static zzjm zzih() {
        return new zzjm();
    }

    static zzjm zza(zzjm zzjm, zzjm zzjm2) {
        int i = zzjm.count + zzjm2.count;
        int[] copyOf = Arrays.copyOf(zzjm.zzaak, i);
        System.arraycopy(zzjm2.zzaak, 0, copyOf, zzjm.count, zzjm2.count);
        Object[] copyOf2 = Arrays.copyOf(zzjm.zzyv, i);
        System.arraycopy(zzjm2.zzyv, 0, copyOf2, zzjm.count, zzjm2.count);
        return new zzjm(i, copyOf, copyOf2, true);
    }

    private zzjm() {
        this(0, new int[8], new Object[8], true);
    }

    private zzjm(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzwe = -1;
        this.count = i;
        this.zzaak = iArr;
        this.zzyv = objArr;
        this.zzrj = z;
    }

    public final void zzdp() {
        this.zzrj = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkg zzkg) throws IOException {
        if (zzkg.zzfj() == zzgs.zzf.zzwx) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzkg.zza(this.zzaak[i] >>> 3, this.zzyv[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzkg.zza(this.zzaak[i2] >>> 3, this.zzyv[i2]);
        }
    }

    public final void zzb(zzkg zzkg) throws IOException {
        if (this.count != 0) {
            if (zzkg.zzfj() == zzgs.zzf.zzww) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzaak[i], this.zzyv[i], zzkg);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzaak[i2], this.zzyv[i2], zzkg);
            }
        }
    }

    private static void zzb(int i, Object obj, zzkg zzkg) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzkg.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzkg.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzkg.zza(i2, (zzfh) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzkg.zzk(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzhc.zzgr());
        } else if (zzkg.zzfj() == zzgs.zzf.zzww) {
            zzkg.zzbj(i2);
            ((zzjm) obj).zzb(zzkg);
            zzkg.zzbk(i2);
        } else {
            zzkg.zzbk(i2);
            ((zzjm) obj).zzb(zzkg);
            zzkg.zzbj(i2);
        }
    }

    public final int zzii() {
        int i = this.zzwe;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzga.zzd(this.zzaak[i3] >>> 3, (zzfh) this.zzyv[i3]);
        }
        this.zzwe = i2;
        return i2;
    }

    public final int zzgf() {
        int i;
        int i2 = this.zzwe;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzaak[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzga.zze(i6, ((Long) this.zzyv[i4]).longValue());
            } else if (i7 == 1) {
                i = zzga.zzg(i6, ((Long) this.zzyv[i4]).longValue());
            } else if (i7 == 2) {
                i = zzga.zzc(i6, (zzfh) this.zzyv[i4]);
            } else if (i7 == 3) {
                i = (zzga.zzba(i6) << 1) + ((zzjm) this.zzyv[i4]).zzgf();
            } else if (i7 == 5) {
                i = zzga.zzo(i6, ((Integer) this.zzyv[i4]).intValue());
            } else {
                throw new IllegalStateException(zzhc.zzgr());
            }
            i3 += i;
        }
        this.zzwe = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzjm)) {
            return false;
        }
        zzjm zzjm = (zzjm) obj;
        int i = this.count;
        if (i == zzjm.count) {
            int[] iArr = this.zzaak;
            int[] iArr2 = zzjm.zzaak;
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
                Object[] objArr = this.zzyv;
                Object[] objArr2 = zzjm.zzyv;
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
        int[] iArr = this.zzaak;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzyv;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzid.zza(sb, i, String.valueOf(this.zzaak[i2] >>> 3), this.zzyv[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, Object obj) {
        if (this.zzrj) {
            int i2 = this.count;
            if (i2 == this.zzaak.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzaak = Arrays.copyOf(this.zzaak, i3);
                this.zzyv = Arrays.copyOf(this.zzyv, i3);
            }
            int[] iArr = this.zzaak;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzyv[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
