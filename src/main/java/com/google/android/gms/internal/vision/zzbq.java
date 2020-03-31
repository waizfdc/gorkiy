package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;

/* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
public final class zzbq extends zzgs<zzbq, zza> implements zzie {
    private static volatile zzil<zzbq> zzbd;
    /* access modifiers changed from: private */
    public static final zzbq zzhi;
    private int zzbf;
    private int zzhc;
    private int zzhd;
    private int zzhe;
    private int zzhf;
    private boolean zzhg;
    private long zzhh;

    private zzbq() {
    }

    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    public static final class zza extends zzgs.zza<zzbq, zza> implements zzie {
        private zza() {
            super(zzbq.zzhi);
        }

        public final zza zzi(int i) {
            if (super.zzwc) {
                zzfy();
                super.zzwc = false;
            }
            ((zzbq) this.zzwb).setWidth(i);
            return this;
        }

        public final zza zzj(int i) {
            if (super.zzwc) {
                zzfy();
                super.zzwc = false;
            }
            ((zzbq) this.zzwb).setHeight(i);
            return this;
        }

        public final zza zzb(zzbl zzbl) {
            if (super.zzwc) {
                zzfy();
                super.zzwc = false;
            }
            ((zzbq) this.zzwb).zza(zzbl);
            return this;
        }

        public final zza zzb(zzbr zzbr) {
            if (super.zzwc) {
                zzfy();
                super.zzwc = false;
            }
            ((zzbq) this.zzwb).zza(zzbr);
            return this;
        }

        public final zza zzc(long j) {
            if (super.zzwc) {
                zzfy();
                super.zzwc = false;
            }
            ((zzbq) this.zzwb).zzb(j);
            return this;
        }

        /* synthetic */ zza(zzbp zzbp) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void setWidth(int i) {
        this.zzbf |= 1;
        this.zzhc = i;
    }

    /* access modifiers changed from: private */
    public final void setHeight(int i) {
        this.zzbf |= 2;
        this.zzhd = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzbl zzbl) {
        this.zzhe = zzbl.zzag();
        this.zzbf |= 4;
    }

    /* access modifiers changed from: private */
    public final void zza(zzbr zzbr) {
        this.zzhf = zzbr.zzag();
        this.zzbf |= 8;
    }

    /* access modifiers changed from: private */
    public final void zzb(long j) {
        this.zzbf |= 32;
        this.zzhh = j;
    }

    public static zza zzai() {
        return (zza) zzhi.zzge();
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzbq>] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzil<zzbq> zzil;
        switch (zzbp.zzbe[i - 1]) {
            case 1:
                return new zzbq();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhi, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\f\u0002\u0004\f\u0003\u0005\u0007\u0004\u0006\u0002\u0005", new Object[]{"zzbf", "zzhc", "zzhd", "zzhe", zzbl.zzah(), "zzhf", zzbr.zzah(), "zzhg", "zzhh"});
            case 4:
                return zzhi;
            case 5:
                zzil<zzbq> zzil2 = zzbd;
                zzil<zzbq> zzil3 = zzil2;
                if (zzil2 == null) {
                    synchronized (zzbq.class) {
                        zzil<zzbq> zzil4 = zzbd;
                        zzil = zzil4;
                        if (zzil4 == null) {
                            ? zzc = new zzgs.zzc(zzhi);
                            zzbd = zzc;
                            zzil = zzc;
                        }
                    }
                    zzil3 = zzil;
                }
                return zzil3;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzbq zzbq = new zzbq();
        zzhi = zzbq;
        zzgs.zza(zzbq.class, super);
    }
}
