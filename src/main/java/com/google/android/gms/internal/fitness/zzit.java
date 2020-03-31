package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzgg;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzit {
    private static final zzit zzzc = new zzit(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzrc;
    private int zzvc;
    private Object[] zzxt;
    private int[] zzzd;

    public static zzit zzdd() {
        return zzzc;
    }

    static zzit zza(zzit zzit, zzit zzit2) {
        int i = zzit.count + zzit2.count;
        int[] copyOf = Arrays.copyOf(zzit.zzzd, i);
        System.arraycopy(zzit2.zzzd, 0, copyOf, zzit.count, zzit2.count);
        Object[] copyOf2 = Arrays.copyOf(zzit.zzxt, i);
        System.arraycopy(zzit2.zzxt, 0, copyOf2, zzit.count, zzit2.count);
        return new zzit(i, copyOf, copyOf2, true);
    }

    private zzit() {
        this(0, new int[8], new Object[8], true);
    }

    private zzit(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzvc = -1;
        this.count = i;
        this.zzzd = iArr;
        this.zzxt = objArr;
        this.zzrc = z;
    }

    public final void zzal() {
        this.zzrc = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzjo zzjo) throws IOException {
        if (zzjo.zzay() == zzgg.zze.zzvx) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzjo.zza(this.zzzd[i] >>> 3, this.zzxt[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzjo.zza(this.zzzd[i2] >>> 3, this.zzxt[i2]);
        }
    }

    public final void zzb(zzjo zzjo) throws IOException {
        if (this.count != 0) {
            if (zzjo.zzay() == zzgg.zze.zzvw) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzzd[i], this.zzxt[i], zzjo);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzzd[i2], this.zzxt[i2], zzjo);
            }
        }
    }

    private static void zzb(int i, Object obj, zzjo zzjo) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzjo.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzjo.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzjo.zza(i2, (zzff) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzjo.zzf(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzgo.zzbt());
        } else if (zzjo.zzay() == zzgg.zze.zzvw) {
            zzjo.zzy(i2);
            ((zzit) obj).zzb(zzjo);
            zzjo.zzz(i2);
        } else {
            zzjo.zzz(i2);
            ((zzit) obj).zzb(zzjo);
            zzjo.zzy(i2);
        }
    }

    public final int zzde() {
        int i = this.zzvc;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzfs.zzd(this.zzzd[i3] >>> 3, (zzff) this.zzxt[i3]);
        }
        this.zzvc = i2;
        return i2;
    }

    public final int zzbk() {
        int i;
        int i2 = this.zzvc;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzzd[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzfs.zze(i6, ((Long) this.zzxt[i4]).longValue());
            } else if (i7 == 1) {
                i = zzfs.zzg(i6, ((Long) this.zzxt[i4]).longValue());
            } else if (i7 == 2) {
                i = zzfs.zzc(i6, (zzff) this.zzxt[i4]);
            } else if (i7 == 3) {
                i = (zzfs.zzp(i6) << 1) + ((zzit) this.zzxt[i4]).zzbk();
            } else if (i7 == 5) {
                i = zzfs.zzj(i6, ((Integer) this.zzxt[i4]).intValue());
            } else {
                throw new IllegalStateException(zzgo.zzbt());
            }
            i3 += i;
        }
        this.zzvc = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzit)) {
            return false;
        }
        zzit zzit = (zzit) obj;
        int i = this.count;
        if (i == zzit.count) {
            int[] iArr = this.zzzd;
            int[] iArr2 = zzit.zzzd;
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
                Object[] objArr = this.zzxt;
                Object[] objArr2 = zzit.zzxt;
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
        int[] iArr = this.zzzd;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzxt;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzhp.zza(sb, i, String.valueOf(this.zzzd[i2] >>> 3), this.zzxt[i2]);
        }
    }
}
