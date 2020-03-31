package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public abstract class zzft {
    int zzsf;
    int zzsg;
    private int zzsh;
    zzfy zzsi;
    private boolean zzsj;

    static zzft zza(byte[] bArr, int i, int i2, boolean z) {
        zzfv zzfv = new zzfv(bArr, 0, i2, false);
        try {
            zzfv.zzas(i2);
            return zzfv;
        } catch (zzhc e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzau(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zzr(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract void zzaq(int i) throws zzhc;

    public abstract boolean zzar(int i) throws IOException;

    public abstract int zzas(int i) throws zzhc;

    public abstract void zzat(int i);

    public abstract boolean zzdt() throws IOException;

    public abstract long zzdw() throws IOException;

    public abstract long zzdx() throws IOException;

    public abstract int zzdy() throws IOException;

    public abstract long zzdz() throws IOException;

    public abstract int zzea() throws IOException;

    public abstract boolean zzeb() throws IOException;

    public abstract String zzec() throws IOException;

    public abstract zzfh zzed() throws IOException;

    public abstract int zzee() throws IOException;

    public abstract int zzef() throws IOException;

    public abstract int zzeg() throws IOException;

    public abstract long zzeh() throws IOException;

    public abstract int zzei() throws IOException;

    public abstract long zzej() throws IOException;

    public abstract int zzex() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long zzey() throws IOException;

    public abstract int zzez();

    private zzft() {
        this.zzsg = 100;
        this.zzsh = Integer.MAX_VALUE;
        this.zzsj = false;
    }
}
