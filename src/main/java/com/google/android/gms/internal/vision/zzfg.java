package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzfg extends zzfe {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private int tag;
    private final boolean zzru = true;
    private final int zzrv;
    private int zzrw;

    public zzfg(ByteBuffer byteBuffer, boolean z) {
        super(null);
        this.buffer = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        this.pos = arrayOffset;
        this.zzrv = arrayOffset;
        this.limit = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    private final boolean zzdt() {
        return this.pos == this.limit;
    }

    public final int zzdu() throws IOException {
        if (zzdt()) {
            return Integer.MAX_VALUE;
        }
        int zzek = zzek();
        this.tag = zzek;
        if (zzek == this.zzrw) {
            return Integer.MAX_VALUE;
        }
        return zzek >>> 3;
    }

    public final int getTag() {
        return this.tag;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdv() throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.zzdt()
            r1 = 0
            if (r0 != 0) goto L_0x0085
            int r0 = r7.tag
            int r2 = r7.zzrw
            if (r0 != r2) goto L_0x000f
            goto L_0x0085
        L_0x000f:
            r3 = r0 & 7
            r4 = 1
            if (r3 == 0) goto L_0x0059
            if (r3 == r4) goto L_0x0053
            r1 = 2
            if (r3 == r1) goto L_0x004b
            r1 = 4
            r5 = 3
            if (r3 == r5) goto L_0x0029
            r0 = 5
            if (r3 != r0) goto L_0x0024
            r7.zzah(r1)
            return r4
        L_0x0024:
            com.google.android.gms.internal.vision.zzhb r0 = com.google.android.gms.internal.vision.zzhc.zzgr()
            throw r0
        L_0x0029:
            int r0 = r0 >>> r5
            int r0 = r0 << r5
            r0 = r0 | r1
            r7.zzrw = r0
        L_0x002e:
            int r0 = r7.zzdu()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x003d
            boolean r0 = r7.zzdv()
            if (r0 != 0) goto L_0x002e
        L_0x003d:
            int r0 = r7.tag
            int r1 = r7.zzrw
            if (r0 != r1) goto L_0x0046
            r7.zzrw = r2
            return r4
        L_0x0046:
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r0
        L_0x004b:
            int r0 = r7.zzek()
            r7.zzah(r0)
            return r4
        L_0x0053:
            r0 = 8
            r7.zzah(r0)
            return r4
        L_0x0059:
            int r0 = r7.limit
            int r2 = r7.pos
            int r0 = r0 - r2
            r3 = 10
            if (r0 < r3) goto L_0x0074
            byte[] r0 = r7.buffer
            r5 = r1
        L_0x0065:
            if (r5 >= r3) goto L_0x0074
            int r6 = r2 + 1
            byte r2 = r0[r2]
            if (r2 < 0) goto L_0x0070
            r7.pos = r6
            goto L_0x007f
        L_0x0070:
            int r5 = r5 + 1
            r2 = r6
            goto L_0x0065
        L_0x0074:
            if (r1 >= r3) goto L_0x0080
            byte r0 = r7.readByte()
            if (r0 >= 0) goto L_0x007f
            int r1 = r1 + 1
            goto L_0x0074
        L_0x007f:
            return r4
        L_0x0080:
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgo()
            throw r0
        L_0x0085:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfg.zzdv():boolean");
    }

    public final double readDouble() throws IOException {
        zzaj(1);
        return Double.longBitsToDouble(zzeo());
    }

    public final float readFloat() throws IOException {
        zzaj(5);
        return Float.intBitsToFloat(zzen());
    }

    public final long zzdw() throws IOException {
        zzaj(0);
        return zzel();
    }

    public final long zzdx() throws IOException {
        zzaj(0);
        return zzel();
    }

    public final int zzdy() throws IOException {
        zzaj(0);
        return zzek();
    }

    public final long zzdz() throws IOException {
        zzaj(1);
        return zzeo();
    }

    public final int zzea() throws IOException {
        zzaj(5);
        return zzen();
    }

    public final boolean zzeb() throws IOException {
        zzaj(0);
        if (zzek() != 0) {
            return true;
        }
        return false;
    }

    public final String readString() throws IOException {
        return zzj(false);
    }

    public final String zzec() throws IOException {
        return zzj(true);
    }

    private final String zzj(boolean z) throws IOException {
        zzaj(2);
        int zzek = zzek();
        if (zzek == 0) {
            return "";
        }
        zzai(zzek);
        if (z) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            if (!zzjs.zzf(bArr, i, i + zzek)) {
                throw zzhc.zzgt();
            }
        }
        String str = new String(this.buffer, this.pos, zzek, zzgt.UTF_8);
        this.pos += zzek;
        return str;
    }

    public final <T> T zza(Class<T> cls, zzgd zzgd) throws IOException {
        zzaj(2);
        return zzb(zzin.zzho().zzf(cls), zzgd);
    }

    public final <T> T zza(zzir<T> zzir, zzgd zzgd) throws IOException {
        zzaj(2);
        return zzb(zzir, zzgd);
    }

    private final <T> T zzb(zzir<T> zzir, zzgd zzgd) throws IOException {
        int zzek = zzek();
        zzai(zzek);
        int i = this.limit;
        int i2 = this.pos + zzek;
        this.limit = i2;
        try {
            T newInstance = zzir.newInstance();
            zzir.zza(newInstance, this, zzgd);
            zzir.zzg(newInstance);
            if (this.pos == i2) {
                return newInstance;
            }
            throw zzhc.zzgs();
        } finally {
            this.limit = i;
        }
    }

    public final <T> T zzb(Class<T> cls, zzgd zzgd) throws IOException {
        zzaj(3);
        return zzd(zzin.zzho().zzf(cls), zzgd);
    }

    public final <T> T zzc(zzir<T> zzir, zzgd zzgd) throws IOException {
        zzaj(3);
        return zzd(zzir, zzgd);
    }

    private final <T> T zzd(zzir<T> zzir, zzgd zzgd) throws IOException {
        int i = this.zzrw;
        this.zzrw = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzir.newInstance();
            zzir.zza(newInstance, this, zzgd);
            zzir.zzg(newInstance);
            if (this.tag == this.zzrw) {
                return newInstance;
            }
            throw zzhc.zzgs();
        } finally {
            this.zzrw = i;
        }
    }

    public final zzfh zzed() throws IOException {
        zzfh zzfh;
        zzaj(2);
        int zzek = zzek();
        if (zzek == 0) {
            return zzfh.zzrx;
        }
        zzai(zzek);
        if (this.zzru) {
            zzfh = zzfh.zzb(this.buffer, this.pos, zzek);
        } else {
            zzfh = zzfh.zza(this.buffer, this.pos, zzek);
        }
        this.pos += zzek;
        return zzfh;
    }

    public final int zzee() throws IOException {
        zzaj(0);
        return zzek();
    }

    public final int zzef() throws IOException {
        zzaj(0);
        return zzek();
    }

    public final int zzeg() throws IOException {
        zzaj(5);
        return zzen();
    }

    public final long zzeh() throws IOException {
        zzaj(1);
        return zzeo();
    }

    public final int zzei() throws IOException {
        zzaj(0);
        return zzft.zzau(zzek());
    }

    public final long zzej() throws IOException {
        zzaj(0);
        return zzft.zzr(zzel());
    }

    public final void zza(List<Double> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgb) {
            zzgb zzgb = (zzgb) list;
            int i3 = this.tag & 7;
            if (i3 == 1) {
                do {
                    zzgb.zzc(readDouble());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = zzek();
                zzak(zzek);
                int i4 = this.pos + zzek;
                while (this.pos < i4) {
                    zzgb.zzc(Double.longBitsToDouble(zzeq()));
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 1) {
                do {
                    list.add(Double.valueOf(readDouble()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i5 == 2) {
                int zzek2 = zzek();
                zzak(zzek2);
                int i6 = this.pos + zzek2;
                while (this.pos < i6) {
                    list.add(Double.valueOf(Double.longBitsToDouble(zzeq())));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzb(List<Float> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgo) {
            zzgo zzgo = (zzgo) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int zzek = zzek();
                zzal(zzek);
                int i4 = this.pos + zzek;
                while (this.pos < i4) {
                    zzgo.zzu(Float.intBitsToFloat(zzep()));
                }
            } else if (i3 == 5) {
                do {
                    zzgo.zzu(readFloat());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 2) {
                int zzek2 = zzek();
                zzal(zzek2);
                int i6 = this.pos + zzek2;
                while (this.pos < i6) {
                    list.add(Float.valueOf(Float.intBitsToFloat(zzep())));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzc(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzhq.zzac(zzdw());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzhq.zzac(zzel());
                }
                zzam(zzek);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzdw()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Long.valueOf(zzel()));
                }
                zzam(zzek2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzd(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzhq.zzac(zzdx());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzhq.zzac(zzel());
                }
                zzam(zzek);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzdx()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Long.valueOf(zzel()));
                }
                zzam(zzek2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zze(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzgu.zzbl(zzdy());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzgu.zzbl(zzek());
                }
                zzam(zzek);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzdy()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Integer.valueOf(zzek()));
                }
                zzam(zzek2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzf(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i3 = this.tag & 7;
            if (i3 == 1) {
                do {
                    zzhq.zzac(zzdz());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = zzek();
                zzak(zzek);
                int i4 = this.pos + zzek;
                while (this.pos < i4) {
                    zzhq.zzac(zzeq());
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 1) {
                do {
                    list.add(Long.valueOf(zzdz()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i5 == 2) {
                int zzek2 = zzek();
                zzak(zzek2);
                int i6 = this.pos + zzek2;
                while (this.pos < i6) {
                    list.add(Long.valueOf(zzeq()));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzg(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int zzek = zzek();
                zzal(zzek);
                int i4 = this.pos + zzek;
                while (this.pos < i4) {
                    zzgu.zzbl(zzep());
                }
            } else if (i3 == 5) {
                do {
                    zzgu.zzbl(zzea());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 2) {
                int zzek2 = zzek();
                zzal(zzek2);
                int i6 = this.pos + zzek2;
                while (this.pos < i6) {
                    list.add(Integer.valueOf(zzep()));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Integer.valueOf(zzea()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzh(List<Boolean> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzff.addBoolean(zzeb());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzff.addBoolean(zzek() != 0);
                }
                zzam(zzek);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Boolean.valueOf(zzeb()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Boolean.valueOf(zzek() != 0));
                }
                zzam(zzek2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzfg.zza(java.util.List<java.lang.String>, boolean):void
     arg types: [java.util.List<java.lang.String>, int]
     candidates:
      com.google.android.gms.internal.vision.zzfg.zza(com.google.android.gms.internal.vision.zzir, com.google.android.gms.internal.vision.zzgd):T
      com.google.android.gms.internal.vision.zzfg.zza(java.lang.Class, com.google.android.gms.internal.vision.zzgd):T
      com.google.android.gms.internal.vision.zzis.zza(com.google.android.gms.internal.vision.zzir, com.google.android.gms.internal.vision.zzgd):T
      com.google.android.gms.internal.vision.zzis.zza(java.lang.Class, com.google.android.gms.internal.vision.zzgd):T
      com.google.android.gms.internal.vision.zzfg.zza(java.util.List<java.lang.String>, boolean):void */
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzfg.zza(java.util.List<java.lang.String>, boolean):void
     arg types: [java.util.List<java.lang.String>, int]
     candidates:
      com.google.android.gms.internal.vision.zzfg.zza(com.google.android.gms.internal.vision.zzir, com.google.android.gms.internal.vision.zzgd):T
      com.google.android.gms.internal.vision.zzfg.zza(java.lang.Class, com.google.android.gms.internal.vision.zzgd):T
      com.google.android.gms.internal.vision.zzis.zza(com.google.android.gms.internal.vision.zzir, com.google.android.gms.internal.vision.zzgd):T
      com.google.android.gms.internal.vision.zzis.zza(java.lang.Class, com.google.android.gms.internal.vision.zzgd):T
      com.google.android.gms.internal.vision.zzfg.zza(java.util.List<java.lang.String>, boolean):void */
    public final void zzi(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int i;
        int i2;
        if ((this.tag & 7) != 2) {
            throw zzhc.zzgr();
        } else if (!(list instanceof zzhj) || z) {
            do {
                list.add(zzj(z));
                if (!zzdt()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzek() == this.tag);
            this.pos = i;
        } else {
            zzhj zzhj = (zzhj) list;
            do {
                zzhj.zzc(zzed());
                if (!zzdt()) {
                    i2 = this.pos;
                } else {
                    return;
                }
            } while (zzek() == this.tag);
            this.pos = i2;
        }
    }

    public final <T> void zza(List<T> list, zzir<T> zzir, zzgd zzgd) throws IOException {
        int i;
        int i2 = this.tag;
        if ((i2 & 7) == 2) {
            do {
                list.add(zzb(zzir, zzgd));
                if (!zzdt()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzek() == i2);
            this.pos = i;
            return;
        }
        throw zzhc.zzgr();
    }

    public final <T> void zzb(List<T> list, zzir<T> zzir, zzgd zzgd) throws IOException {
        int i;
        int i2 = this.tag;
        if ((i2 & 7) == 3) {
            do {
                list.add(zzd(zzir, zzgd));
                if (!zzdt()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzek() == i2);
            this.pos = i;
            return;
        }
        throw zzhc.zzgr();
    }

    public final void zzj(List<zzfh> list) throws IOException {
        int i;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzed());
                if (!zzdt()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzek() == this.tag);
            this.pos = i;
            return;
        }
        throw zzhc.zzgr();
    }

    public final void zzk(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzgu.zzbl(zzee());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzgu.zzbl(zzek());
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzee()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Integer.valueOf(zzek()));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzl(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzgu.zzbl(zzef());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzgu.zzbl(zzek());
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzef()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Integer.valueOf(zzek()));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzm(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int zzek = zzek();
                zzal(zzek);
                int i4 = this.pos + zzek;
                while (this.pos < i4) {
                    zzgu.zzbl(zzep());
                }
            } else if (i3 == 5) {
                do {
                    zzgu.zzbl(zzeg());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 2) {
                int zzek2 = zzek();
                zzal(zzek2);
                int i6 = this.pos + zzek2;
                while (this.pos < i6) {
                    list.add(Integer.valueOf(zzep()));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Integer.valueOf(zzeg()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzn(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i3 = this.tag & 7;
            if (i3 == 1) {
                do {
                    zzhq.zzac(zzeh());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = zzek();
                zzak(zzek);
                int i4 = this.pos + zzek;
                while (this.pos < i4) {
                    zzhq.zzac(zzeq());
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 1) {
                do {
                    list.add(Long.valueOf(zzeh()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i5 == 2) {
                int zzek2 = zzek();
                zzak(zzek2);
                int i6 = this.pos + zzek2;
                while (this.pos < i6) {
                    list.add(Long.valueOf(zzeq()));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzo(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzgu.zzbl(zzei());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzgu.zzbl(zzft.zzau(zzek()));
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzei()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Integer.valueOf(zzft.zzau(zzek())));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzp(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzhq.zzac(zzej());
                    if (!zzdt()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzhq.zzac(zzft.zzr(zzel()));
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzej()));
                    if (!zzdt()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Long.valueOf(zzft.zzr(zzel())));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:17|18|(2:20|36)(3:31|21|22)) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (zzdv() != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        throw new com.google.android.gms.internal.vision.zzhc("Unable to parse map entry.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0048 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.vision.zzht<K, V> r9, com.google.android.gms.internal.vision.zzgd r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzaj(r0)
            int r1 = r7.zzek()
            r7.zzai(r1)
            int r2 = r7.limit
            int r3 = r7.pos
            int r3 = r3 + r1
            r7.limit = r3
            K r1 = r9.zzyn     // Catch:{ all -> 0x005b }
            V r3 = r9.zzgc     // Catch:{ all -> 0x005b }
        L_0x0016:
            int r4 = r7.zzdu()     // Catch:{ all -> 0x005b }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x0055
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0040
            if (r4 == r0) goto L_0x0033
            boolean r4 = r7.zzdv()     // Catch:{ zzhb -> 0x0048 }
            if (r4 == 0) goto L_0x002d
            goto L_0x0016
        L_0x002d:
            com.google.android.gms.internal.vision.zzhc r4 = new com.google.android.gms.internal.vision.zzhc     // Catch:{ zzhb -> 0x0048 }
            r4.<init>(r6)     // Catch:{ zzhb -> 0x0048 }
            throw r4     // Catch:{ zzhb -> 0x0048 }
        L_0x0033:
            com.google.android.gms.internal.vision.zzka r4 = r9.zzyo     // Catch:{ zzhb -> 0x0048 }
            V r5 = r9.zzgc     // Catch:{ zzhb -> 0x0048 }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzhb -> 0x0048 }
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch:{ zzhb -> 0x0048 }
            goto L_0x0016
        L_0x0040:
            com.google.android.gms.internal.vision.zzka r4 = r9.zzym     // Catch:{ zzhb -> 0x0048 }
            r5 = 0
            java.lang.Object r1 = r7.zza(r4, r5, r5)     // Catch:{ zzhb -> 0x0048 }
            goto L_0x0016
        L_0x0048:
            boolean r4 = r7.zzdv()     // Catch:{ all -> 0x005b }
            if (r4 == 0) goto L_0x004f
            goto L_0x0016
        L_0x004f:
            com.google.android.gms.internal.vision.zzhc r8 = new com.google.android.gms.internal.vision.zzhc     // Catch:{ all -> 0x005b }
            r8.<init>(r6)     // Catch:{ all -> 0x005b }
            throw r8     // Catch:{ all -> 0x005b }
        L_0x0055:
            r8.put(r1, r3)     // Catch:{ all -> 0x005b }
            r7.limit = r2
            return
        L_0x005b:
            r8 = move-exception
            r7.limit = r2
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfg.zza(java.util.Map, com.google.android.gms.internal.vision.zzht, com.google.android.gms.internal.vision.zzgd):void");
    }

    private final Object zza(zzka zzka, Class<?> cls, zzgd zzgd) throws IOException {
        switch (zzfd.zzrr[zzka.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzeb());
            case 2:
                return zzed();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzef());
            case 5:
                return Integer.valueOf(zzea());
            case 6:
                return Long.valueOf(zzdz());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzdy());
            case 9:
                return Long.valueOf(zzdx());
            case 10:
                return zza(cls, zzgd);
            case 11:
                return Integer.valueOf(zzeg());
            case 12:
                return Long.valueOf(zzeh());
            case 13:
                return Integer.valueOf(zzei());
            case 14:
                return Long.valueOf(zzej());
            case 15:
                return zzj(true);
            case 16:
                return Integer.valueOf(zzee());
            case 17:
                return Long.valueOf(zzdw());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final int zzek() throws IOException {
        byte b;
        int i = this.pos;
        int i2 = this.limit;
        if (i2 != i) {
            byte[] bArr = this.buffer;
            int i3 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                this.pos = i3;
                return b2;
            } else if (i2 - i3 < 9) {
                return (int) zzem();
            } else {
                int i4 = i3 + 1;
                byte b3 = b2 ^ (bArr[i3] << 7);
                if (b3 < 0) {
                    b = b3 ^ ByteCompanionObject.MIN_VALUE;
                } else {
                    int i5 = i4 + 1;
                    byte b4 = b3 ^ (bArr[i4] << 14);
                    if (b4 >= 0) {
                        b = b4 ^ ByteCompanionObject.MIN_VALUE;
                    } else {
                        i4 = i5 + 1;
                        byte b5 = b4 ^ (bArr[i5] << 21);
                        if (b5 < 0) {
                            b = b5 ^ ByteCompanionObject.MIN_VALUE;
                        } else {
                            i5 = i4 + 1;
                            byte b6 = bArr[i4];
                            b = (b5 ^ (b6 << 28)) ^ ByteCompanionObject.MIN_VALUE;
                            if (b6 < 0) {
                                i4 = i5 + 1;
                                if (bArr[i5] < 0) {
                                    i5 = i4 + 1;
                                    if (bArr[i4] < 0) {
                                        i4 = i5 + 1;
                                        if (bArr[i5] < 0) {
                                            i5 = i4 + 1;
                                            if (bArr[i4] < 0) {
                                                i4 = i5 + 1;
                                                if (bArr[i5] < 0) {
                                                    throw zzhc.zzgo();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i4 = i5;
                }
                this.pos = i4;
                return b;
            }
        } else {
            throw zzhc.zzgm();
        }
    }

    private final long zzel() throws IOException {
        long j;
        int i;
        long j2;
        long j3;
        byte b;
        int i2 = this.pos;
        int i3 = this.limit;
        if (i3 != i2) {
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.pos = i4;
                return (long) b2;
            } else if (i3 - i4 < 9) {
                return zzem();
            } else {
                int i5 = i4 + 1;
                byte b3 = b2 ^ (bArr[i4] << 7);
                if (b3 < 0) {
                    b = b3 ^ ByteCompanionObject.MIN_VALUE;
                } else {
                    int i6 = i5 + 1;
                    byte b4 = b3 ^ (bArr[i5] << 14);
                    if (b4 >= 0) {
                        i = i6;
                        j = (long) (b4 ^ ByteCompanionObject.MIN_VALUE);
                    } else {
                        i5 = i6 + 1;
                        byte b5 = b4 ^ (bArr[i6] << 21);
                        if (b5 < 0) {
                            b = b5 ^ ByteCompanionObject.MIN_VALUE;
                        } else {
                            long j4 = (long) b5;
                            int i7 = i5 + 1;
                            long j5 = j4 ^ (((long) bArr[i5]) << 28);
                            if (j5 >= 0) {
                                j3 = 266354560;
                            } else {
                                int i8 = i7 + 1;
                                long j6 = j5 ^ (((long) bArr[i7]) << 35);
                                if (j6 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i7 = i8 + 1;
                                    j5 = j6 ^ (((long) bArr[i8]) << 42);
                                    if (j5 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i8 = i7 + 1;
                                        j6 = j5 ^ (((long) bArr[i7]) << 49);
                                        if (j6 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            int i9 = i8 + 1;
                                            long j7 = (j6 ^ (((long) bArr[i8]) << 56)) ^ 71499008037633920L;
                                            if (j7 < 0) {
                                                i = i9 + 1;
                                                if (((long) bArr[i9]) < 0) {
                                                    throw zzhc.zzgo();
                                                }
                                            } else {
                                                i = i9;
                                            }
                                            j = j7;
                                        }
                                    }
                                }
                                j = j6 ^ j2;
                            }
                            j = j5 ^ j3;
                            i = i7;
                        }
                    }
                    this.pos = i;
                    return j;
                }
                j = (long) b;
                this.pos = i;
                return j;
            }
        } else {
            throw zzhc.zzgm();
        }
    }

    private final long zzem() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte readByte = readByte();
            j |= ((long) (readByte & ByteCompanionObject.MAX_VALUE)) << i;
            if ((readByte & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzhc.zzgo();
    }

    private final byte readByte() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzhc.zzgm();
    }

    private final int zzen() throws IOException {
        zzai(4);
        return zzep();
    }

    private final long zzeo() throws IOException {
        zzai(8);
        return zzeq();
    }

    private final int zzep() {
        int i = this.pos;
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzeq() {
        int i = this.pos;
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final void zzah(int i) throws IOException {
        zzai(i);
        this.pos += i;
    }

    private final void zzai(int i) throws IOException {
        if (i < 0 || i > this.limit - this.pos) {
            throw zzhc.zzgm();
        }
    }

    private final void zzaj(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzhc.zzgr();
        }
    }

    private final void zzak(int i) throws IOException {
        zzai(i);
        if ((i & 7) != 0) {
            throw zzhc.zzgs();
        }
    }

    private final void zzal(int i) throws IOException {
        zzai(i);
        if ((i & 3) != 0) {
            throw zzhc.zzgs();
        }
    }

    private final void zzam(int i) throws IOException {
        if (this.pos != i) {
            throw zzhc.zzgm();
        }
    }
}
