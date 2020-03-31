package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;

/* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
public final class zzkn extends zzgs<zzkn, zza> implements zzie {
    /* access modifiers changed from: private */
    public static final zzkn zzagb;
    private static volatile zzil<zzkn> zzbd;
    private zzgz<zzkf> zzaga = zzgh();
    private byte zzju = 2;

    private zzkn() {
    }

    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    public static final class zza extends zzgs.zza<zzkn, zza> implements zzie {
        private zza() {
            super(zzkn.zzagb);
        }

        /* synthetic */ zza(zzkp zzkp) {
            this();
        }
    }

    public final int zzjl() {
        return this.zzaga.size();
    }

    public final zzkf zzcb(int i) {
        return this.zzaga.get(i);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzkn>, com.google.android.gms.internal.vision.zzgs$zzc] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzil<zzkn> zzil;
        int i2 = 1;
        switch (zzkp.zzbe[i - 1]) {
            case 1:
                return new zzkn();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzagb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzaga", zzkf.class});
            case 4:
                return zzagb;
            case 5:
                zzil<zzkn> zzil2 = zzbd;
                zzil<zzkn> zzil3 = zzil2;
                if (zzil2 == null) {
                    synchronized (zzkn.class) {
                        zzil<zzkn> zzil4 = zzbd;
                        zzil = zzil4;
                        if (zzil4 == null) {
                            ? zzc = new zzgs.zzc(zzagb);
                            zzbd = zzc;
                            zzil = zzc;
                        }
                    }
                    zzil3 = zzil;
                }
                return zzil3;
            case 6:
                return Byte.valueOf(this.zzju);
            case 7:
                if (obj == null) {
                    i2 = 0;
                }
                this.zzju = (byte) i2;
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static zzkn zzjm() {
        return zzagb;
    }

    static {
        zzkn zzkn = new zzkn();
        zzagb = zzkn;
        zzgs.zza(zzkn.class, super);
    }
}
