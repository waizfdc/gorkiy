package com.google.android.gms.internal.vision;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.internal.vision.zzgs;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
public final class zzkf extends zzgs.zze<zzkf, zzd> implements zzie {
    /* access modifiers changed from: private */
    public static final zzkf zzadd;
    private static volatile zzil<zzkf> zzbd;
    private zzb zzacr;
    private zzgz<zze> zzacs = zzgh();
    private float zzact;
    private float zzacu;
    private float zzacv;
    private float zzacw;
    private zzgz<zzc> zzacx = zzgh();
    private zzgz<zza> zzacy = zzgh();
    private long zzacz;
    private long zzada;
    private long zzadb;
    private float zzadc;
    private int zzbf;
    private byte zzju = 2;

    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    public static final class zza extends zzgs<zza, zzb> implements zzie {
        /* access modifiers changed from: private */
        public static final zza zzadf;
        private static volatile zzil<zza> zzbd;
        private float zzact;
        private float zzade;
        private int zzbf;
        private int zziv;
        private String zznj = "";

        /* renamed from: com.google.android.gms.internal.vision.zzkf$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public enum C0027zza implements zzgw {
            TYPE_UNKNOWN(0),
            FREE_FORM(1),
            FEMALE(2),
            MALE(3),
            AGE(5),
            NON_HUMAN(6),
            GLASSES(7),
            DARK_GLASSES(8),
            HEADWEAR(9),
            EYES_VISIBLE(10),
            MOUTH_OPEN(11),
            FACIAL_HAIR(12),
            LONG_HAIR(13),
            FRONTAL_GAZE(14),
            SMILING(15);
            
            private static final zzgv<C0027zza> zzgy = new zzkj();
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static C0027zza zzby(int i) {
                switch (i) {
                    case 0:
                        return TYPE_UNKNOWN;
                    case 1:
                        return FREE_FORM;
                    case 2:
                        return FEMALE;
                    case 3:
                        return MALE;
                    case 4:
                    default:
                        return null;
                    case 5:
                        return AGE;
                    case 6:
                        return NON_HUMAN;
                    case 7:
                        return GLASSES;
                    case 8:
                        return DARK_GLASSES;
                    case 9:
                        return HEADWEAR;
                    case 10:
                        return EYES_VISIBLE;
                    case 11:
                        return MOUTH_OPEN;
                    case 12:
                        return FACIAL_HAIR;
                    case 13:
                        return LONG_HAIR;
                    case 14:
                        return FRONTAL_GAZE;
                    case 15:
                        return SMILING;
                }
            }

            public static zzgy zzah() {
                return zzki.zzhb;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private C0027zza(int i) {
                this.value = i;
            }
        }

        private zza() {
        }

        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public static final class zzb extends zzgs.zza<zza, zzb> implements zzie {
            private zzb() {
                super(zza.zzadf);
            }

            /* synthetic */ zzb(zzkh zzkh) {
                this();
            }
        }

        public final String getName() {
            return this.zznj;
        }

        public final float getConfidence() {
            return this.zzact;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzkf$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zza> zzil;
            switch (zzkh.zzbe[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzadf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\u0001\u0002\u0004\u0001\u0003", new Object[]{"zzbf", "zziv", C0027zza.zzah(), "zznj", "zzact", "zzade"});
                case 4:
                    return zzadf;
                case 5:
                    zzil<zza> zzil2 = zzbd;
                    zzil<zza> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zza.class) {
                            zzil<zza> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzadf);
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
            zzadf = zza;
            zzgs.zza(zza.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    public static final class zzb extends zzgs<zzb, zza> implements zzie {
        /* access modifiers changed from: private */
        public static final zzb zzaea;
        private static volatile zzil<zzb> zzbd;
        private float zzadw;
        private float zzadx;
        private float zzady;
        private float zzadz;
        private int zzbf;

        private zzb() {
        }

        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public static final class zza extends zzgs.zza<zzb, zza> implements zzie {
            private zza() {
                super(zzb.zzaea);
            }

            /* synthetic */ zza(zzkh zzkh) {
                this();
            }
        }

        public final float zzjc() {
            return this.zzadw;
        }

        public final float zzjd() {
            return this.zzadx;
        }

        public final float zzje() {
            return this.zzady;
        }

        public final float zzjf() {
            return this.zzadz;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzkf$zzb>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzb> zzil;
            switch (zzkh.zzbe[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzaea, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0001\u0000\u0002\u0001\u0001\u0003\u0001\u0002\u0004\u0001\u0003", new Object[]{"zzbf", "zzadw", "zzadx", "zzady", "zzadz"});
                case 4:
                    return zzaea;
                case 5:
                    zzil<zzb> zzil2 = zzbd;
                    zzil<zzb> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzb.class) {
                            zzil<zzb> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzaea);
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

        public static zzb zzjg() {
            return zzaea;
        }

        static {
            zzb zzb = new zzb();
            zzaea = zzb;
            zzgs.zza(zzb.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    public static final class zzc extends zzgs<zzc, zza> implements zzie {
        /* access modifiers changed from: private */
        public static final zzc zzaee;
        private static volatile zzil<zzc> zzbd;
        private float zzact;
        private int zzaeb;
        private zzfh zzaec = zzfh.zzrx;
        private String zzaed = "";
        private int zzbf;

        private zzc() {
        }

        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public static final class zza extends zzgs.zza<zzc, zza> implements zzie {
            private zza() {
                super(zzc.zzaee);
            }

            /* synthetic */ zza(zzkh zzkh) {
                this();
            }
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzkf$zzc>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzc> zzil;
            switch (zzkh.zzbe[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzaee, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\n\u0001\u0003\b\u0002\u0004\u0001\u0003", new Object[]{"zzbf", "zzaeb", "zzaec", "zzaed", "zzact"});
                case 4:
                    return zzaee;
                case 5:
                    zzil<zzc> zzil2 = zzbd;
                    zzil<zzc> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzc.class) {
                            zzil<zzc> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzaee);
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
            zzc zzc = new zzc();
            zzaee = zzc;
            zzgs.zza(zzc.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    public static final class zze extends zzgs<zze, zzb> implements zzie {
        /* access modifiers changed from: private */
        public static final zze zzaeg;
        private static volatile zzil<zze> zzbd;
        private float zzact;
        private int zzaef;
        private int zzbf;
        private int zziv = 15000;
        private float zziy;
        private float zziz;
        private float zzja;

        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public enum zza implements zzgw {
            LEFT_EYE(0),
            RIGHT_EYE(1),
            LEFT_OF_LEFT_EYEBROW(2),
            RIGHT_OF_LEFT_EYEBROW(3),
            LEFT_OF_RIGHT_EYEBROW(4),
            RIGHT_OF_RIGHT_EYEBROW(5),
            MIDPOINT_BETWEEN_EYES(6),
            NOSE_TIP(9),
            UPPER_LIP(10),
            LOWER_LIP(11),
            MOUTH_LEFT(12),
            MOUTH_RIGHT(13),
            MOUTH_CENTER(45),
            NOSE_BOTTOM_RIGHT(43),
            NOSE_BOTTOM_LEFT(44),
            NOSE_BOTTOM_CENTER(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION),
            LEFT_EYE_TOP_BOUNDARY(220),
            LEFT_EYE_RIGHT_CORNER(221),
            LEFT_EYE_BOTTOM_BOUNDARY(222),
            LEFT_EYE_LEFT_CORNER(223),
            RIGHT_EYE_TOP_BOUNDARY(224),
            RIGHT_EYE_RIGHT_CORNER(225),
            RIGHT_EYE_BOTTOM_BOUNDARY(226),
            RIGHT_EYE_LEFT_CORNER(227),
            LEFT_EYEBROW_UPPER_MIDPOINT(300),
            RIGHT_EYEBROW_UPPER_MIDPOINT(302),
            LEFT_EAR_TRAGION(240),
            RIGHT_EAR_TRAGION(241),
            LEFT_EYE_PUPIL(304),
            RIGHT_EYE_PUPIL(305),
            FOREHEAD_GLABELLA(312),
            CHIN_GNATHION(314),
            CHIN_LEFT_GONION(315),
            CHIN_RIGHT_GONION(316),
            LEFT_CHEEK_CENTER(238),
            RIGHT_CHEEK_CENTER(239),
            LEFT_EAR_TOP(242),
            RIGHT_EAR_TOP(243),
            LANDMARK_UNKNOWN(15000);
            
            private static final zzgv<zza> zzgy = new zzkl();
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static zza zzbz(int i) {
                if (i == 200) {
                    return NOSE_BOTTOM_CENTER;
                }
                if (i == 300) {
                    return LEFT_EYEBROW_UPPER_MIDPOINT;
                }
                if (i == 302) {
                    return RIGHT_EYEBROW_UPPER_MIDPOINT;
                }
                if (i == 312) {
                    return FOREHEAD_GLABELLA;
                }
                if (i == 15000) {
                    return LANDMARK_UNKNOWN;
                }
                if (i == 304) {
                    return LEFT_EYE_PUPIL;
                }
                if (i == 305) {
                    return RIGHT_EYE_PUPIL;
                }
                switch (i) {
                    case 0:
                        return LEFT_EYE;
                    case 1:
                        return RIGHT_EYE;
                    case 2:
                        return LEFT_OF_LEFT_EYEBROW;
                    case 3:
                        return RIGHT_OF_LEFT_EYEBROW;
                    case 4:
                        return LEFT_OF_RIGHT_EYEBROW;
                    case 5:
                        return RIGHT_OF_RIGHT_EYEBROW;
                    case 6:
                        return MIDPOINT_BETWEEN_EYES;
                    default:
                        switch (i) {
                            case 9:
                                return NOSE_TIP;
                            case 10:
                                return UPPER_LIP;
                            case 11:
                                return LOWER_LIP;
                            case 12:
                                return MOUTH_LEFT;
                            case 13:
                                return MOUTH_RIGHT;
                            default:
                                switch (i) {
                                    case 43:
                                        return NOSE_BOTTOM_RIGHT;
                                    case 44:
                                        return NOSE_BOTTOM_LEFT;
                                    case 45:
                                        return MOUTH_CENTER;
                                    default:
                                        switch (i) {
                                            case 220:
                                                return LEFT_EYE_TOP_BOUNDARY;
                                            case 221:
                                                return LEFT_EYE_RIGHT_CORNER;
                                            case 222:
                                                return LEFT_EYE_BOTTOM_BOUNDARY;
                                            case 223:
                                                return LEFT_EYE_LEFT_CORNER;
                                            case 224:
                                                return RIGHT_EYE_TOP_BOUNDARY;
                                            case 225:
                                                return RIGHT_EYE_RIGHT_CORNER;
                                            case 226:
                                                return RIGHT_EYE_BOTTOM_BOUNDARY;
                                            case 227:
                                                return RIGHT_EYE_LEFT_CORNER;
                                            default:
                                                switch (i) {
                                                    case 238:
                                                        return LEFT_CHEEK_CENTER;
                                                    case 239:
                                                        return RIGHT_CHEEK_CENTER;
                                                    case 240:
                                                        return LEFT_EAR_TRAGION;
                                                    case 241:
                                                        return RIGHT_EAR_TRAGION;
                                                    case 242:
                                                        return LEFT_EAR_TOP;
                                                    case 243:
                                                        return RIGHT_EAR_TOP;
                                                    default:
                                                        switch (i) {
                                                            case 314:
                                                                return CHIN_GNATHION;
                                                            case 315:
                                                                return CHIN_LEFT_GONION;
                                                            case 316:
                                                                return CHIN_RIGHT_GONION;
                                                            default:
                                                                return null;
                                                        }
                                                }
                                        }
                                }
                        }
                }
            }

            public static zzgy zzah() {
                return zzkk.zzhb;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zza(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public enum zzc implements zzgw {
            VISIBILITY_UNKNOWN(0),
            VISIBLE(1),
            OCCLUDED_SELF(2),
            OCCLUDED_OTHER(3);
            
            private static final zzgv<zzc> zzgy = new zzkm();
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static zzc zzca(int i) {
                if (i == 0) {
                    return VISIBILITY_UNKNOWN;
                }
                if (i == 1) {
                    return VISIBLE;
                }
                if (i == 2) {
                    return OCCLUDED_SELF;
                }
                if (i != 3) {
                    return null;
                }
                return OCCLUDED_OTHER;
            }

            public static zzgy zzah() {
                return zzko.zzhb;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzc(int i) {
                this.value = i;
            }
        }

        private zze() {
        }

        /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
        public static final class zzb extends zzgs.zza<zze, zzb> implements zzie {
            private zzb() {
                super(zze.zzaeg);
            }

            /* synthetic */ zzb(zzkh zzkh) {
                this();
            }
        }

        public final float getX() {
            return this.zziy;
        }

        public final float getY() {
            return this.zziz;
        }

        public final zza zzjj() {
            zza zzbz = zza.zzbz(this.zziv);
            return zzbz == null ? zza.LANDMARK_UNKNOWN : zzbz;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzkf$zze>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zze> zzil;
            switch (zzkh.zzbe[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzaeg, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0001\u0000\u0002\u0001\u0001\u0003\u0001\u0002\u0004\f\u0003\u0005\f\u0004\u0006\u0001\u0005", new Object[]{"zzbf", "zziy", "zziz", "zzja", "zziv", zza.zzah(), "zzaef", zzc.zzah(), "zzact"});
                case 4:
                    return zzaeg;
                case 5:
                    zzil<zze> zzil2 = zzbd;
                    zzil<zze> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zze.class) {
                            zzil<zze> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc2 = new zzgs.zzc(zzaeg);
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

        static {
            zze zze = new zze();
            zzaeg = zze;
            zzgs.zza(zze.class, super);
        }
    }

    private zzkf() {
    }

    /* compiled from: com.google.firebase:firebase-ml-vision-face-model@@19.0.0 */
    public static final class zzd extends zzgs.zzb<zzkf, zzd> implements zzie {
        private zzd() {
            super(zzkf.zzadd);
        }

        /* synthetic */ zzd(zzkh zzkh) {
            this();
        }
    }

    public final zzb zzir() {
        zzb zzb2 = this.zzacr;
        return zzb2 == null ? zzb.zzjg() : zzb2;
    }

    public final List<zze> zzis() {
        return this.zzacs;
    }

    public final boolean zzit() {
        return (this.zzbf & 2) != 0;
    }

    public final float getConfidence() {
        return this.zzact;
    }

    public final float zziu() {
        return this.zzacu;
    }

    public final float zziv() {
        return this.zzacv;
    }

    public final float zziw() {
        return this.zzacw;
    }

    public final List<zza> zzix() {
        return this.zzacy;
    }

    public final long zziy() {
        return this.zzada;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzkf>] */
    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzil<zzkf> zzil;
        int i2 = 1;
        switch (zzkh.zzbe[i - 1]) {
            case 1:
                return new zzkf();
            case 2:
                return new zzd(null);
            case 3:
                return zza(zzadd, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0003\u0000\u0001\t\u0000\u0002\u001b\u0003\u0001\u0001\u0004\u0001\u0002\u0005\u0001\u0003\u0006\u0001\u0004\u0007\u001b\b\u001b\t\u0003\u0006\n\u0001\b\u000b\u0003\u0007\f\u0003\u0005", new Object[]{"zzbf", "zzacr", "zzacs", zze.class, "zzact", "zzacu", "zzacv", "zzacw", "zzacx", zzc.class, "zzacy", zza.class, "zzada", "zzadc", "zzadb", "zzacz"});
            case 4:
                return zzadd;
            case 5:
                zzil<zzkf> zzil2 = zzbd;
                zzil<zzkf> zzil3 = zzil2;
                if (zzil2 == null) {
                    synchronized (zzkf.class) {
                        zzil<zzkf> zzil4 = zzbd;
                        zzil = zzil4;
                        if (zzil4 == null) {
                            ? zzc2 = new zzgs.zzc(zzadd);
                            zzbd = zzc2;
                            zzil = zzc2;
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

    public static zzkf zziz() {
        return zzadd;
    }

    static {
        zzkf zzkf = new zzkf();
        zzadd = zzkf;
        zzgs.zza(zzkf.class, zzkf);
    }
}
