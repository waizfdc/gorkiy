package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public abstract class zzih {
    @Deprecated
    private final byte zzacw;
    protected final byte zzacx;
    private final int zzacy;
    private final int zzacz;
    protected final int zzada;
    private final int zzadb;

    protected zzih(int i, int i2, int i3, int i4) {
        this(3, 4, i3, i4, (byte) 61);
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(byte[] bArr, int i, int i2, zzik zzik);

    /* access modifiers changed from: protected */
    public abstract boolean zza(byte b);

    private zzih(int i, int i2, int i3, int i4, byte b) {
        this.zzacw = 61;
        this.zzacy = 3;
        this.zzacz = 4;
        this.zzada = i3 > 0 && i4 > 0 ? (i3 / 4) << 2 : 0;
        this.zzadb = i4;
        this.zzacx = 61;
    }

    /* access modifiers changed from: protected */
    public final byte[] zza(int i, zzik zzik) {
        if (zzik.buffer != null && zzik.buffer.length >= zzik.pos + i) {
            return zzik.buffer;
        }
        if (zzik.buffer == null) {
            zzik.buffer = new byte[8192];
            zzik.pos = 0;
            zzik.zzadm = 0;
        } else {
            byte[] bArr = new byte[(zzik.buffer.length << 1)];
            System.arraycopy(zzik.buffer, 0, bArr, 0, zzik.buffer.length);
            zzik.buffer = bArr;
        }
        return zzik.buffer;
    }

    public final long zzb(byte[] bArr) {
        int length = bArr.length;
        int i = this.zzacy;
        long j = ((long) (((length + i) - 1) / i)) * ((long) this.zzacz);
        int i2 = this.zzada;
        return i2 > 0 ? j + ((((((long) i2) + j) - 1) / ((long) i2)) * ((long) this.zzadb)) : j;
    }
}
