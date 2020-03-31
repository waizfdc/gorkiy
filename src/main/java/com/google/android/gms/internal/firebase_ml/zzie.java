package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final class zzie extends zzhs {
    private final zzic zzacq;
    private final zzsj zzacu;

    zzie(zzic zzic, zzsj zzsj) {
        this.zzacq = zzic;
        this.zzacu = zzsj;
        zzsj.setLenient(true);
    }

    public final void flush() throws IOException {
        this.zzacu.flush();
    }

    public final void writeBoolean(boolean z) throws IOException {
        this.zzacu.zzaw(z);
    }

    public final void zzgs() throws IOException {
        this.zzacu.zzqs();
    }

    public final void zzgu() throws IOException {
        this.zzacu.zzqu();
    }

    public final void zzal(String str) throws IOException {
        this.zzacu.zzce(str);
    }

    public final void zzgv() throws IOException {
        this.zzacu.zzqw();
    }

    public final void zzah(int i) throws IOException {
        this.zzacu.zzu((long) i);
    }

    public final void zze(long j) throws IOException {
        this.zzacu.zzu(j);
    }

    public final void zza(BigInteger bigInteger) throws IOException {
        this.zzacu.zza(bigInteger);
    }

    public final void zza(double d) throws IOException {
        this.zzacu.zzb(d);
    }

    public final void zzj(float f) throws IOException {
        this.zzacu.zzb((double) f);
    }

    public final void zza(BigDecimal bigDecimal) throws IOException {
        this.zzacu.zza(bigDecimal);
    }

    public final void zzgr() throws IOException {
        this.zzacu.zzqr();
    }

    public final void zzgt() throws IOException {
        this.zzacu.zzqt();
    }

    public final void writeString(String str) throws IOException {
        this.zzacu.zzcf(str);
    }

    public final void zzgw() throws IOException {
        this.zzacu.setIndent("  ");
    }
}
