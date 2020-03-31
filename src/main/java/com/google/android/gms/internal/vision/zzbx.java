package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
public final class zzbx {
    public static final zzgs.zzg<zzkf, List<zzb>> zzin = zzgs.zza(zzkf.zziz(), zzb.zzbi(), null, 202056002, zzka.MESSAGE, false, zzb.class);

    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    public static final class zzb extends zzgs<zzb, zza> implements zzie {
        private static volatile zzil<zzb> zzbd;
        /* access modifiers changed from: private */
        public static final zzb zzix;
        private int zzbf;
        private int zziv;
        private zzgz<C0025zzb> zziw = zzgh();

        /* renamed from: com.google.android.gms.internal.vision.zzbx$zzb$zzb  reason: collision with other inner class name */
        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public static final class C0025zzb extends zzgs<C0025zzb, zza> implements zzie {
            private static volatile zzil<C0025zzb> zzbd;
            /* access modifiers changed from: private */
            public static final C0025zzb zzjb;
            private int zzbf;
            private float zziy;
            private float zziz;
            private float zzja;

            private C0025zzb() {
            }

            /* renamed from: com.google.android.gms.internal.vision.zzbx$zzb$zzb$zza */
            /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
            public static final class zza extends zzgs.zza<C0025zzb, zza> implements zzie {
                private zza() {
                    super(C0025zzb.zzjb);
                }

                /* synthetic */ zza(zzby zzby) {
                    this();
                }
            }

            public final float getX() {
                return this.zziy;
            }

            public final float getY() {
                return this.zziz;
            }

            /* JADX INFO: additional move instructions added (1) to help type inference */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzbx$zzb$zzb>] */
            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                zzil<C0025zzb> zzil;
                switch (zzby.zzbe[i - 1]) {
                    case 1:
                        return new C0025zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzjb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0001\u0000\u0002\u0001\u0001\u0003\u0001\u0002", new Object[]{"zzbf", "zziy", "zziz", "zzja"});
                    case 4:
                        return zzjb;
                    case 5:
                        zzil<C0025zzb> zzil2 = zzbd;
                        zzil<C0025zzb> zzil3 = zzil2;
                        if (zzil2 == null) {
                            synchronized (C0025zzb.class) {
                                zzil<C0025zzb> zzil4 = zzbd;
                                zzil = zzil4;
                                if (zzil4 == null) {
                                    ? zzc = new zzgs.zzc(zzjb);
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
                C0025zzb zzb = new C0025zzb();
                zzjb = zzb;
                zzgs.zza(C0025zzb.class, super);
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public enum zzc implements zzgw {
            CONTOUR_UNKNOWN(0),
            FACE_OVAL(1),
            LEFT_EYEBROW_TOP(2),
            LEFT_EYEBROW_BOTTOM(3),
            RIGHT_EYEBROW_TOP(4),
            RIGHT_EYEBROW_BOTTOM(5),
            LEFT_EYE(6),
            RIGHT_EYE(7),
            UPPER_LIP_TOP(8),
            UPPER_LIP_BOTTOM(9),
            LOWER_LIP_TOP(10),
            LOWER_LIP_BOTTOM(11),
            NOSE_BRIDGE(12),
            NOSE_BOTTOM(13),
            LEFT_CHEEK_CENTER(14),
            RIGHT_CHEEK_CENTER(15);
            
            private static final zzgv<zzc> zzgy = new zzcc();
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static zzc zzo(int i) {
                switch (i) {
                    case 0:
                        return CONTOUR_UNKNOWN;
                    case 1:
                        return FACE_OVAL;
                    case 2:
                        return LEFT_EYEBROW_TOP;
                    case 3:
                        return LEFT_EYEBROW_BOTTOM;
                    case 4:
                        return RIGHT_EYEBROW_TOP;
                    case 5:
                        return RIGHT_EYEBROW_BOTTOM;
                    case 6:
                        return LEFT_EYE;
                    case 7:
                        return RIGHT_EYE;
                    case 8:
                        return UPPER_LIP_TOP;
                    case 9:
                        return UPPER_LIP_BOTTOM;
                    case 10:
                        return LOWER_LIP_TOP;
                    case 11:
                        return LOWER_LIP_BOTTOM;
                    case 12:
                        return NOSE_BRIDGE;
                    case 13:
                        return NOSE_BOTTOM;
                    case 14:
                        return LEFT_CHEEK_CENTER;
                    case 15:
                        return RIGHT_CHEEK_CENTER;
                    default:
                        return null;
                }
            }

            public static zzgy zzah() {
                return zzcd.zzhb;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzc(int i) {
                this.value = i;
            }
        }

        private zzb() {
        }

        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public static final class zza extends zzgs.zza<zzb, zza> implements zzie {
            private zza() {
                super(zzb.zzix);
            }

            /* synthetic */ zza(zzby zzby) {
                this();
            }
        }

        public final zzc zzbf() {
            zzc zzo = zzc.zzo(this.zziv);
            return zzo == null ? zzc.CONTOUR_UNKNOWN : zzo;
        }

        public final List<C0025zzb> zzbg() {
            return this.zziw;
        }

        public final int zzbh() {
            return this.zziw.size();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzbx$zzb>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzb> zzil;
            switch (zzby.zzbe[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzix, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u001b", new Object[]{"zzbf", "zziv", zzc.zzah(), "zziw", C0025zzb.class});
                case 4:
                    return zzix;
                case 5:
                    zzil<zzb> zzil2 = zzbd;
                    zzil<zzb> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzb.class) {
                            zzil<zzb> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc2 = new zzgs.zzc(zzix);
                                zzbd = zzc2;
                                zzil = zzc2;
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

        public static zzb zzbi() {
            return zzix;
        }

        static {
            zzb zzb = new zzb();
            zzix = zzb;
            zzgs.zza(zzb.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    public static final class zzc extends zzgs<zzc, zza> implements zzie {
        private static volatile zzil<zzc> zzbd;
        /* access modifiers changed from: private */
        public static final zzc zzjv;
        private int zzbf;
        private zzkn zzjt;
        private byte zzju = 2;

        private zzc() {
        }

        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public static final class zza extends zzgs.zza<zzc, zza> implements zzie {
            private zza() {
                super(zzc.zzjv);
            }

            /* synthetic */ zza(zzby zzby) {
                this();
            }
        }

        public final zzkn zzbl() {
            zzkn zzkn = this.zzjt;
            return zzkn == null ? zzkn.zzjm() : zzkn;
        }

        public static zzc zza(byte[] bArr, zzgd zzgd) throws zzhc {
            return (zzc) zzgs.zza(zzjv, bArr, zzgd);
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzbx$zzc>, com.google.android.gms.internal.vision.zzgs$zzc] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzc> zzil;
            int i2 = 1;
            switch (zzby.zzbe[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzjv, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Љ\u0000", new Object[]{"zzbf", "zzjt"});
                case 4:
                    return zzjv;
                case 5:
                    zzil<zzc> zzil2 = zzbd;
                    zzil<zzc> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzc.class) {
                            zzil<zzc> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzjv);
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

        static {
            zzc zzc = new zzc();
            zzjv = zzc;
            zzgs.zza(zzc.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    public static final class zza extends zzgs<zza, C0024zza> implements zzie {
        private static volatile zzil<zza> zzbd;
        /* access modifiers changed from: private */
        public static final zza zziq;
        private int zzbf;
        private zzg zzio;
        private zzg zzip;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.vision.zzbx$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public static final class C0024zza extends zzgs.zza<zza, C0024zza> implements zzie {
            private C0024zza() {
                super(zza.zziq);
            }

            public final C0024zza zzc(zzg zzg) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zza) this.zzwb).zza(zzg);
                return this;
            }

            public final C0024zza zzd(zzg zzg) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zza) this.zzwb).zzb(zzg);
                return this;
            }

            /* synthetic */ C0024zza(zzby zzby) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzg zzg) {
            zzg.getClass();
            this.zzio = zzg;
            this.zzbf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zzb(zzg zzg) {
            zzg.getClass();
            this.zzip = zzg;
            this.zzbf |= 2;
        }

        public static C0024zza zzbd() {
            return (C0024zza) zziq.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzbx$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zza> zzil;
            switch (zzby.zzbe[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0024zza(null);
                case 3:
                    return zza(zziq, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001", new Object[]{"zzbf", "zzio", "zzip"});
                case 4:
                    return zziq;
                case 5:
                    zzil<zza> zzil2 = zzbd;
                    zzil<zza> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zza.class) {
                            zzil<zza> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zziq);
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
            zza zza = new zza();
            zziq = zza;
            zzgs.zza(zza.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    public static final class zzd extends zzgs<zzd, zza> implements zzie {
        private static volatile zzil<zzd> zzbd;
        /* access modifiers changed from: private */
        public static final zzd zzki;
        private int zzbf;
        private float zzjw = 0.1f;
        private int zzjx = 1;
        private int zzjy = 1;
        private int zzjz = 1;
        private boolean zzka;
        private boolean zzkb;
        private float zzkc = 45.0f;
        private float zzkd = 0.5f;
        private boolean zzke;
        private zze zzkf;
        private zza zzkg;
        private zzf zzkh;

        private zzd() {
        }

        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public static final class zza extends zzgs.zza<zzd, zza> implements zzie {
            private zza() {
                super(zzd.zzki);
            }

            public final zza zze(float f) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzd) this.zzwb).zzd(f);
                return this;
            }

            public final zza zzb(zzce zzce) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzd) this.zzwb).zza(zzce);
                return this;
            }

            public final zza zzb(zzbz zzbz) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzd) this.zzwb).zza(zzbz);
                return this;
            }

            public final zza zzb(zzci zzci) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzd) this.zzwb).zza(zzci);
                return this;
            }

            public final zza zzd(boolean z) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzd) this.zzwb).zza(z);
                return this;
            }

            public final zza zze(boolean z) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzd) this.zzwb).zzb(z);
                return this;
            }

            public final zza zzf(boolean z) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzd) this.zzwb).zzc(true);
                return this;
            }

            public final zza zza(zze.zza zza) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzd) this.zzwb).zza((zze) ((zzgs) super.zzgc()));
                return this;
            }

            public final zza zza(zza.C0024zza zza) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzd) this.zzwb).zza((zza) ((zzgs) super.zzgc()));
                return this;
            }

            public final zza zza(zzf.zza zza) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzd) this.zzwb).zza((zzf) ((zzgs) super.zzgc()));
                return this;
            }

            /* synthetic */ zza(zzby zzby) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzd(float f) {
            this.zzbf |= 1;
            this.zzjw = f;
        }

        public final zzce zzbn() {
            zzce zzp = zzce.zzp(this.zzjx);
            return zzp == null ? zzce.NO_LANDMARK : zzp;
        }

        /* access modifiers changed from: private */
        public final void zza(zzce zzce) {
            this.zzjx = zzce.zzag();
            this.zzbf |= 2;
        }

        public final zzbz zzbo() {
            zzbz zzn = zzbz.zzn(this.zzjy);
            return zzn == null ? zzbz.NO_CLASSIFICATION : zzn;
        }

        /* access modifiers changed from: private */
        public final void zza(zzbz zzbz) {
            this.zzjy = zzbz.zzag();
            this.zzbf |= 4;
        }

        /* access modifiers changed from: private */
        public final void zza(zzci zzci) {
            this.zzjz = zzci.zzag();
            this.zzbf |= 8;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzbf |= 16;
            this.zzka = z;
        }

        /* access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzbf |= 32;
            this.zzkb = z;
        }

        /* access modifiers changed from: private */
        public final void zzc(boolean z) {
            this.zzbf |= 256;
            this.zzke = z;
        }

        /* access modifiers changed from: private */
        public final void zza(zze zze) {
            zze.getClass();
            this.zzkf = zze;
            this.zzbf |= 512;
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            zza2.getClass();
            this.zzkg = zza2;
            this.zzbf |= 1024;
        }

        /* access modifiers changed from: private */
        public final void zza(zzf zzf) {
            zzf.getClass();
            this.zzkh = zzf;
            this.zzbf |= 2048;
        }

        public static zza zzbp() {
            return (zza) zzki.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzbx$zzd>, com.google.android.gms.internal.vision.zzgs$zzc] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzd> zzil;
            switch (zzby.zzbe[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzki, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001\u0001\u0000\u0002\f\u0001\u0003\f\u0002\u0004\f\u0003\u0005\u0007\u0004\u0006\u0007\u0005\u0007\u0001\u0006\b\u0001\u0007\t\u0007\b\n\t\t\u000b\t\n\f\t\u000b", new Object[]{"zzbf", "zzjw", "zzjx", zzce.zzah(), "zzjy", zzbz.zzah(), "zzjz", zzci.zzah(), "zzka", "zzkb", "zzkc", "zzkd", "zzke", "zzkf", "zzkg", "zzkh"});
                case 4:
                    return zzki;
                case 5:
                    zzil<zzd> zzil2 = zzbd;
                    zzil<zzd> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzd.class) {
                            zzil<zzd> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzki);
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
            zzd zzd = new zzd();
            zzki = zzd;
            zzgs.zza(zzd.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    public static final class zze extends zzgs<zze, zza> implements zzie {
        private static volatile zzil<zze> zzbd;
        /* access modifiers changed from: private */
        public static final zze zzkm;
        private int zzbf;
        private zzg zzkj;
        private zzg zzkk;
        private zzg zzkl;

        private zze() {
        }

        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public static final class zza extends zzgs.zza<zze, zza> implements zzie {
            private zza() {
                super(zze.zzkm);
            }

            public final zza zzh(zzg zzg) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zze) this.zzwb).zze(zzg);
                return this;
            }

            public final zza zzi(zzg zzg) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zze) this.zzwb).zzf(zzg);
                return this;
            }

            public final zza zzj(zzg zzg) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zze) this.zzwb).zzg(zzg);
                return this;
            }

            /* synthetic */ zza(zzby zzby) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zze(zzg zzg) {
            zzg.getClass();
            this.zzkj = zzg;
            this.zzbf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zzf(zzg zzg) {
            zzg.getClass();
            this.zzkk = zzg;
            this.zzbf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zzg(zzg zzg) {
            zzg.getClass();
            this.zzkl = zzg;
            this.zzbf |= 4;
        }

        public static zza zzbr() {
            return (zza) zzkm.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzbx$zze>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zze> zzil;
            switch (zzby.zzbe[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzkm, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzbf", "zzkj", "zzkk", "zzkl"});
                case 4:
                    return zzkm;
                case 5:
                    zzil<zze> zzil2 = zzbd;
                    zzil<zze> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zze.class) {
                            zzil<zze> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzkm);
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
            zze zze = new zze();
            zzkm = zze;
            zzgs.zza(zze.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    public static final class zzf extends zzgs<zzf, zza> implements zzie {
        private static volatile zzil<zzf> zzbd;
        /* access modifiers changed from: private */
        public static final zzf zzkw;
        private int zzbf;
        private zzg zzks;
        private zzg zzkt;
        private zzg zzku;
        private zzg zzkv;

        private zzf() {
        }

        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public static final class zza extends zzgs.zza<zzf, zza> implements zzie {
            private zza() {
                super(zzf.zzkw);
            }

            public final zza zzk(zzg zzg) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzf) this.zzwb).zzo(zzg);
                return this;
            }

            public final zza zzl(zzg zzg) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzf) this.zzwb).zzp(zzg);
                return this;
            }

            public final zza zzm(zzg zzg) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzf) this.zzwb).zzq(zzg);
                return this;
            }

            public final zza zzn(zzg zzg) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzf) this.zzwb).zzr(zzg);
                return this;
            }

            /* synthetic */ zza(zzby zzby) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzo(zzg zzg) {
            zzg.getClass();
            this.zzks = zzg;
            this.zzbf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zzp(zzg zzg) {
            zzg.getClass();
            this.zzkt = zzg;
            this.zzbf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zzq(zzg zzg) {
            zzg.getClass();
            this.zzku = zzg;
            this.zzbf |= 4;
        }

        /* access modifiers changed from: private */
        public final void zzr(zzg zzg) {
            zzg.getClass();
            this.zzkv = zzg;
            this.zzbf |= 8;
        }

        public static zza zzbt() {
            return (zza) zzkw.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzbx$zzf>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzf> zzil;
            switch (zzby.zzbe[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzkw, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003", new Object[]{"zzbf", "zzks", "zzkt", "zzku", "zzkv"});
                case 4:
                    return zzkw;
                case 5:
                    zzil<zzf> zzil2 = zzbd;
                    zzil<zzf> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzf.class) {
                            zzil<zzf> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzkw);
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
            zzf zzf = new zzf();
            zzkw = zzf;
            zzgs.zza(zzf.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    public static final class zzg extends zzgs<zzg, zza> implements zzie {
        private static volatile zzil<zzg> zzbd;
        /* access modifiers changed from: private */
        public static final zzg zzle;
        private int zzbf;
        private zzfh zzlc = zzfh.zzrx;
        private String zzld = "";

        private zzg() {
        }

        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public static final class zza extends zzgs.zza<zzg, zza> implements zzie {
            private zza() {
                super(zzg.zzle);
            }

            public final zza zzj(String str) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzg) this.zzwb).zzi(str);
                return this;
            }

            /* synthetic */ zza(zzby zzby) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzi(String str) {
            str.getClass();
            this.zzbf |= 2;
            this.zzld = str;
        }

        public static zza zzbv() {
            return (zza) zzle.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzbx$zzg>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzg> zzil;
            switch (zzby.zzbe[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzle, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\n\u0000\u0002\b\u0001", new Object[]{"zzbf", "zzlc", "zzld"});
                case 4:
                    return zzle;
                case 5:
                    zzil<zzg> zzil2 = zzbd;
                    zzil<zzg> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzg.class) {
                            zzil<zzg> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzle);
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
            zzg zzg = new zzg();
            zzle = zzg;
            zzgs.zza(zzg.class, super);
        }
    }
}
