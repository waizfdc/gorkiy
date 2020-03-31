package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public abstract class zzff implements Serializable, Iterable<Byte> {
    public static final zzff zzri = new zzfp(zzgk.zzvz);
    private static final zzfl zzrj = (zzfd.zzan() ? new zzfo(null) : new zzfj(null));
    private static final Comparator<zzff> zzrl = new zzfh();
    private int zzrk = 0;

    zzff() {
    }

    /* access modifiers changed from: private */
    public static int zza(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    public abstract zzff zza(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzfc zzfc) throws IOException;

    public abstract boolean zzaq();

    public abstract byte zzh(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzi(int i);

    public static zzff zzl(String str) {
        return new zzfp(str.getBytes(zzgk.UTF_8));
    }

    public final String zzap() {
        return size() == 0 ? "" : zza(zzgk.UTF_8);
    }

    public final int hashCode() {
        int i = this.zzrk;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzrk = i;
        }
        return i;
    }

    static zzfn zzj(int i) {
        return new zzfn(i, null);
    }

    /* access modifiers changed from: protected */
    public final int zzar() {
        return this.zzrk;
    }

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public /* synthetic */ Iterator iterator() {
        return new zzfe(this);
    }
}
