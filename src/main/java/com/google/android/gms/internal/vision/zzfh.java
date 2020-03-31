package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public abstract class zzfh implements Serializable, Iterable<Byte> {
    public static final zzfh zzrx = new zzfr(zzgt.zzxc);
    private static final zzfn zzry = (zzfa.zzdr() ? new zzfu(null) : new zzfl(null));
    private static final Comparator<zzfh> zzrz = new zzfj();
    private int zzmi = 0;

    zzfh() {
    }

    /* access modifiers changed from: private */
    public static int zza(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzfi zzfi) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void zza(byte[] bArr, int i, int i2, int i3);

    public abstract byte zzan(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzao(int i);

    /* access modifiers changed from: protected */
    public abstract int zzb(int i, int i2, int i3);

    public abstract boolean zzes();

    public abstract zzfh zzf(int i, int i2);

    public static zzfh zza(byte[] bArr, int i, int i2) {
        zzc(i, i + i2, bArr.length);
        return new zzfr(zzry.zzd(bArr, i, i2));
    }

    static zzfh zzd(byte[] bArr) {
        return new zzfr(bArr);
    }

    static zzfh zzb(byte[] bArr, int i, int i2) {
        return new zzfo(bArr, i, i2);
    }

    public static zzfh zzw(String str) {
        return new zzfr(str.getBytes(zzgt.UTF_8));
    }

    public final String zzer() {
        return size() == 0 ? "" : zza(zzgt.UTF_8);
    }

    public final int hashCode() {
        int i = this.zzmi;
        if (i == 0) {
            int size = size();
            i = zzb(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzmi = i;
        }
        return i;
    }

    static zzfp zzap(int i) {
        return new zzfp(i, null);
    }

    /* access modifiers changed from: protected */
    public final int zzet() {
        return this.zzmi;
    }

    static int zzc(int i, int i2, int i3) {
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
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? zzjf.zzd(this) : String.valueOf(zzjf.zzd(zzf(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public /* synthetic */ Iterator iterator() {
        return new zzfk(this);
    }
}
