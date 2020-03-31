package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public final class zzea {

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zzb extends zzgs<zzb, zza> implements zzie {
        private static volatile zzil<zzb> zzbd;
        private static final zzha<Integer, zzeo> zzmn = new zzeb();
        /* access modifiers changed from: private */
        public static final zzb zzmo;
        private zzgx zzmm = zzgg();

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class zza extends zzgs.zza<zzb, zza> implements zzie {
            private zza() {
                super(zzb.zzmo);
            }

            /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzb>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzb> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzmo, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzmm", zzeo.zzah()});
                case 4:
                    return zzmo;
                case 5:
                    zzil<zzb> zzil2 = zzbd;
                    zzil<zzb> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzb.class) {
                            zzil<zzb> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzmo);
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

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.zzeb, com.google.android.gms.internal.vision.zzha<java.lang.Integer, com.google.android.gms.internal.vision.zzeo>] */
        static {
            zzb zzb = new zzb();
            zzmo = zzb;
            zzgs.zza(zzb.class, super);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zzc extends zzgs<zzc, zza> implements zzie {
        private static volatile zzil<zzc> zzbd;
        /* access modifiers changed from: private */
        public static final zzc zzms;
        private int zzbf;
        private int zzmp = 1;
        private int zzmq = 1;
        private String zzmr = "";

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class zza extends zzgs.zza<zzc, zza> implements zzie {
            private zza() {
                super(zzc.zzms);
            }

            /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzc>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzc> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzms, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\b\u0002", new Object[]{"zzbf", "zzmp", zzeo.zzah(), "zzmq", zzes.zzah(), "zzmr"});
                case 4:
                    return zzms;
                case 5:
                    zzil<zzc> zzil2 = zzbd;
                    zzil<zzc> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzc.class) {
                            zzil<zzc> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzms);
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
            zzms = zzc;
            zzgs.zza(zzc.class, super);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zze extends zzgs<zze, zzb> implements zzie {
        private static volatile zzil<zze> zzbd;
        /* access modifiers changed from: private */
        public static final zze zznd;
        private int zzbf;
        private String zzmv = "";
        private boolean zzmw;
        private int zzmx;
        private long zzmy;
        private long zzmz;
        private long zzna;
        private String zznb = "";
        private boolean zznc;

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public enum zza implements zzgw {
            REASON_UNKNOWN(0),
            REASON_MISSING(1),
            REASON_UPGRADE(2),
            REASON_INVALID(3);
            
            private static final zzgv<zza> zzgy = new zzed();
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static zza zzs(int i) {
                if (i == 0) {
                    return REASON_UNKNOWN;
                }
                if (i == 1) {
                    return REASON_MISSING;
                }
                if (i == 2) {
                    return REASON_UPGRADE;
                }
                if (i != 3) {
                    return null;
                }
                return REASON_INVALID;
            }

            public static zzgy zzah() {
                return zzec.zzhb;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zza(int i) {
                this.value = i;
            }
        }

        private zze() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class zzb extends zzgs.zza<zze, zzb> implements zzie {
            private zzb() {
                super(zze.zznd);
            }

            /* synthetic */ zzb(zzdz zzdz) {
                this();
            }
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zze>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zze> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zznd, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\b\u0000\u0002\u0007\u0001\u0003\f\u0002\u0004\u0002\u0003\u0005\u0002\u0004\u0006\u0002\u0005\u0007\b\u0006\b\u0007\u0007", new Object[]{"zzbf", "zzmv", "zzmw", "zzmx", zza.zzah(), "zzmy", "zzmz", "zzna", "zznb", "zznc"});
                case 4:
                    return zznd;
                case 5:
                    zzil<zze> zzil2 = zzbd;
                    zzil<zze> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zze.class) {
                            zzil<zze> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zznd);
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
            zznd = zze;
            zzgs.zza(zze.class, super);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zzl extends zzgs<zzl, zza> implements zzie {
        private static volatile zzil<zzl> zzbd;
        /* access modifiers changed from: private */
        public static final zzl zzpq;
        private int zzbf;
        private long zzno;
        private long zznp;

        private zzl() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class zza extends zzgs.zza<zzl, zza> implements zzie {
            private zza() {
                super(zzl.zzpq);
            }

            /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzl>, com.google.android.gms.internal.vision.zzgs$zzc] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzl> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzpq, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0002\u0001", new Object[]{"zzbf", "zzno", "zznp"});
                case 4:
                    return zzpq;
                case 5:
                    zzil<zzl> zzil2 = zzbd;
                    zzil<zzl> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzl.class) {
                            zzil<zzl> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzpq);
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
            zzl zzl = new zzl();
            zzpq = zzl;
            zzgs.zza(zzl.class, super);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zza extends zzgs<zza, C0026zza> implements zzie {
        private static volatile zzil<zza> zzbd;
        /* access modifiers changed from: private */
        public static final zza zzml;
        private int zzbf;
        private String zzmj = "";
        private String zzmk = "";

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.vision.zzea$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class C0026zza extends zzgs.zza<zza, C0026zza> implements zzie {
            private C0026zza() {
                super(zza.zzml);
            }

            public final C0026zza zzl(String str) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zza) this.zzwb).zzn(str);
                return this;
            }

            public final C0026zza zzm(String str) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zza) this.zzwb).zzo(str);
                return this;
            }

            /* synthetic */ C0026zza(zzdz zzdz) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzbf |= 1;
            this.zzmj = str;
        }

        /* access modifiers changed from: private */
        public final void zzo(String str) {
            str.getClass();
            this.zzbf |= 2;
            this.zzmk = str;
        }

        public static C0026zza zzcj() {
            return (C0026zza) zzml.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zza> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0026zza(null);
                case 3:
                    return zza(zzml, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzbf", "zzmj", "zzmk"});
                case 4:
                    return zzml;
                case 5:
                    zzil<zza> zzil2 = zzbd;
                    zzil<zza> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zza.class) {
                            zzil<zza> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzml);
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
            zzml = zza;
            zzgs.zza(zza.class, super);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zzd extends zzgs<zzd, zza> implements zzie {
        private static volatile zzil<zzd> zzbd;
        /* access modifiers changed from: private */
        public static final zzd zzmu;
        private zzgz<zzm> zzmt = zzgh();

        private zzd() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class zza extends zzgs.zza<zzd, zza> implements zzie {
            private zza() {
                super(zzd.zzmu);
            }

            public final zza zzb(zzm zzm) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzd) this.zzwb).zza(zzm);
                return this;
            }

            /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzm zzm) {
            zzm.getClass();
            if (!this.zzmt.zzdo()) {
                this.zzmt = zzgs.zza(this.zzmt);
            }
            this.zzmt.add(zzm);
        }

        public static zza zzcn() {
            return (zza) zzmu.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzd>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzd> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzmu, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzmt", zzm.class});
                case 4:
                    return zzmu;
                case 5:
                    zzil<zzd> zzil2 = zzbd;
                    zzil<zzd> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzd.class) {
                            zzil<zzd> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzmu);
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
            zzmu = zzd;
            zzgs.zza(zzd.class, super);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zzf extends zzgs<zzf, zza> implements zzie {
        private static volatile zzil<zzf> zzbd;
        /* access modifiers changed from: private */
        public static final zzf zznr;
        private int zzbf;
        private String zznj = "";
        private String zznk = "";
        private zzgz<String> zznl = zzgs.zzgh();
        private int zznm;
        private String zznn = "";
        private long zzno;
        private long zznp;
        private zzgz<zzn> zznq = zzgh();

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public enum zzb implements zzgw {
            RESULT_UNKNOWN(0),
            RESULT_SUCCESS(1),
            RESULT_FAIL(2),
            RESULT_SKIPPED(3);
            
            private static final zzgv<zzb> zzgy = new zzee();
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static zzb zzt(int i) {
                if (i == 0) {
                    return RESULT_UNKNOWN;
                }
                if (i == 1) {
                    return RESULT_SUCCESS;
                }
                if (i == 2) {
                    return RESULT_FAIL;
                }
                if (i != 3) {
                    return null;
                }
                return RESULT_SKIPPED;
            }

            public static zzgy zzah() {
                return zzef.zzhb;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzb(int i) {
                this.value = i;
            }
        }

        private zzf() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class zza extends zzgs.zza<zzf, zza> implements zzie {
            private zza() {
                super(zzf.zznr);
            }

            public final zza zzp(String str) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzf) this.zzwb).setName(str);
                return this;
            }

            public final zza zzq(String str) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzf) this.zzwb).zzr(str);
                return this;
            }

            public final zza zzd(long j) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzf) this.zzwb).zzf(j);
                return this;
            }

            public final zza zze(long j) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzf) this.zzwb).zzg(j);
                return this;
            }

            public final zza zzc(Iterable<? extends zzn> iterable) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzf) this.zzwb).zzd(iterable);
                return this;
            }

            /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void setName(String str) {
            str.getClass();
            this.zzbf |= 1;
            this.zznj = str;
        }

        /* access modifiers changed from: private */
        public final void zzr(String str) {
            str.getClass();
            this.zzbf |= 8;
            this.zznn = str;
        }

        /* access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzbf |= 16;
            this.zzno = j;
        }

        /* access modifiers changed from: private */
        public final void zzg(long j) {
            this.zzbf |= 32;
            this.zznp = j;
        }

        /* access modifiers changed from: private */
        public final void zzd(Iterable<? extends zzn> iterable) {
            if (!this.zznq.zzdo()) {
                this.zznq = zzgs.zza(this.zznq);
            }
            zzet.zza(iterable, this.zznq);
        }

        public static zza zzcq() {
            return (zza) zznr.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzf>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzf> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zznr, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u001a\u0004\f\u0002\u0005\b\u0003\u0006\u0002\u0004\u0007\u0002\u0005\b\u001b", new Object[]{"zzbf", "zznj", "zznk", "zznl", "zznm", zzb.zzah(), "zznn", "zzno", "zznp", "zznq", zzn.class});
                case 4:
                    return zznr;
                case 5:
                    zzil<zzf> zzil2 = zzbd;
                    zzil<zzf> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzf.class) {
                            zzil<zzf> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zznr);
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
            zznr = zzf;
            zzgs.zza(zzf.class, super);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zzg extends zzgs<zzg, zzb> implements zzie {
        private static volatile zzil<zzg> zzbd;
        /* access modifiers changed from: private */
        public static final zzg zzob;
        private int zzbf;
        private float zzjw;
        private boolean zzka;
        private int zznx;
        private int zzny;
        private int zznz;
        private boolean zzoa;

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public enum zza implements zzgw {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);
            
            private static final zzgv<zza> zzgy = new zzeh();
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static zza zzu(int i) {
                if (i == 0) {
                    return CLASSIFICATION_UNKNOWN;
                }
                if (i == 1) {
                    return CLASSIFICATION_NONE;
                }
                if (i != 2) {
                    return null;
                }
                return CLASSIFICATION_ALL;
            }

            public static zzgy zzah() {
                return zzeg.zzhb;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zza(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public enum zzc implements zzgw {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);
            
            private static final zzgv<zzc> zzgy = new zzei();
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static zzc zzv(int i) {
                if (i == 0) {
                    return LANDMARK_UNKNOWN;
                }
                if (i == 1) {
                    return LANDMARK_NONE;
                }
                if (i == 2) {
                    return LANDMARK_ALL;
                }
                if (i != 3) {
                    return null;
                }
                return LANDMARK_CONTOUR;
            }

            public static zzgy zzah() {
                return zzej.zzhb;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzc(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public enum zzd implements zzgw {
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);
            
            private static final zzgv<zzd> zzgy = new zzel();
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static zzd zzw(int i) {
                if (i == 0) {
                    return MODE_UNKNOWN;
                }
                if (i == 1) {
                    return MODE_ACCURATE;
                }
                if (i == 2) {
                    return MODE_FAST;
                }
                if (i != 3) {
                    return null;
                }
                return MODE_SELFIE;
            }

            public static zzgy zzah() {
                return zzek.zzhb;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzd(int i) {
                this.value = i;
            }
        }

        private zzg() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class zzb extends zzgs.zza<zzg, zzb> implements zzie {
            private zzb() {
                super(zzg.zzob);
            }

            public final zzb zzb(zzd zzd) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzg) this.zzwb).zza(zzd);
                return this;
            }

            public final zzb zzb(zzc zzc) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzg) this.zzwb).zza(zzc);
                return this;
            }

            public final zzb zzb(zza zza) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzg) this.zzwb).zza(zza);
                return this;
            }

            public final zzb zzh(boolean z) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzg) this.zzwb).zza(z);
                return this;
            }

            public final zzb zzi(boolean z) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzg) this.zzwb).zzg(z);
                return this;
            }

            public final zzb zzf(float f) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzg) this.zzwb).zzd(f);
                return this;
            }

            /* synthetic */ zzb(zzdz zzdz) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzd zzd2) {
            this.zznx = zzd2.zzag();
            this.zzbf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            this.zzny = zzc2.zzag();
            this.zzbf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            this.zznz = zza2.zzag();
            this.zzbf |= 4;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzbf |= 8;
            this.zzka = z;
        }

        /* access modifiers changed from: private */
        public final void zzg(boolean z) {
            this.zzbf |= 16;
            this.zzoa = z;
        }

        /* access modifiers changed from: private */
        public final void zzd(float f) {
            this.zzbf |= 32;
            this.zzjw = f;
        }

        public static zzb zzcs() {
            return (zzb) zzob.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzg>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzg> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzob, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\f\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u0001\u0005", new Object[]{"zzbf", "zznx", zzd.zzah(), "zzny", zzc.zzah(), "zznz", zza.zzah(), "zzka", "zzoa", "zzjw"});
                case 4:
                    return zzob;
                case 5:
                    zzil<zzg> zzil2 = zzbd;
                    zzil<zzg> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzg.class) {
                            zzil<zzg> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc2 = new zzgs.zzc(zzob);
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
            zzg zzg = new zzg();
            zzob = zzg;
            zzgs.zza(zzg.class, super);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zzh extends zzgs<zzh, zza> implements zzie {
        private static volatile zzil<zzh> zzbd;
        /* access modifiers changed from: private */
        public static final zzh zzow;
        private int zzbf;
        private float zzoq;
        private float zzor;
        private float zzos;
        private float zzot;
        private float zzou;
        private float zzov;

        private zzh() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class zza extends zzgs.zza<zzh, zza> implements zzie {
            private zza() {
                super(zzh.zzow);
            }

            public final zza zzg(float f) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzh) this.zzwb).zzm(f);
                return this;
            }

            public final zza zzh(float f) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzh) this.zzwb).zzn(f);
                return this;
            }

            public final zza zzi(float f) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzh) this.zzwb).zzo(f);
                return this;
            }

            public final zza zzj(float f) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzh) this.zzwb).zzp(f);
                return this;
            }

            public final zza zzk(float f) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzh) this.zzwb).zzq(f);
                return this;
            }

            public final zza zzl(float f) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzh) this.zzwb).zzr(f);
                return this;
            }

            /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzm(float f) {
            this.zzbf |= 1;
            this.zzoq = f;
        }

        /* access modifiers changed from: private */
        public final void zzn(float f) {
            this.zzbf |= 2;
            this.zzor = f;
        }

        /* access modifiers changed from: private */
        public final void zzo(float f) {
            this.zzbf |= 4;
            this.zzos = f;
        }

        /* access modifiers changed from: private */
        public final void zzp(float f) {
            this.zzbf |= 8;
            this.zzot = f;
        }

        /* access modifiers changed from: private */
        public final void zzq(float f) {
            this.zzbf |= 16;
            this.zzou = f;
        }

        /* access modifiers changed from: private */
        public final void zzr(float f) {
            this.zzbf |= 32;
            this.zzov = f;
        }

        public static zza zzcu() {
            return (zza) zzow.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzh>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzh> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzow, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0001\u0000\u0002\u0001\u0001\u0003\u0001\u0002\u0004\u0001\u0003\u0005\u0001\u0004\u0006\u0001\u0005", new Object[]{"zzbf", "zzoq", "zzor", "zzos", "zzot", "zzou", "zzov"});
                case 4:
                    return zzow;
                case 5:
                    zzil<zzh> zzil2 = zzbd;
                    zzil<zzh> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzh.class) {
                            zzil<zzh> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzow);
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
            zzh zzh = new zzh();
            zzow = zzh;
            zzgs.zza(zzh.class, super);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zzi extends zzgs<zzi, zza> implements zzie {
        private static volatile zzil<zzi> zzbd;
        /* access modifiers changed from: private */
        public static final zzi zzpa;
        private int zzbf;
        private zzj zzox;
        private zzl zzoy;
        private zzgz<zzf> zzoz = zzgh();

        private zzi() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class zza extends zzgs.zza<zzi, zza> implements zzie {
            private zza() {
                super(zzi.zzpa);
            }

            public final zza zza(zzj zzj) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzi) this.zzwb).zzb(zzj);
                return this;
            }

            public final zza zza(zzf.zza zza) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzi) this.zzwb).zza((zzf) ((zzgs) super.zzgc()));
                return this;
            }

            public final zza zze(Iterable<? extends zzf> iterable) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzi) this.zzwb).zzf(iterable);
                return this;
            }

            /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzb(zzj zzj) {
            zzj.getClass();
            this.zzox = zzj;
            this.zzbf |= 1;
        }

        private final void zzcw() {
            if (!this.zzoz.zzdo()) {
                this.zzoz = zzgs.zza(this.zzoz);
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzf zzf) {
            zzf.getClass();
            zzcw();
            this.zzoz.add(zzf);
        }

        /* access modifiers changed from: private */
        public final void zzf(Iterable<? extends zzf> iterable) {
            zzcw();
            zzet.zza(iterable, this.zzoz);
        }

        public static zza zzcx() {
            return (zza) zzpa.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzi>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzi> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzpa, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u001b", new Object[]{"zzbf", "zzox", "zzoy", "zzoz", zzf.class});
                case 4:
                    return zzpa;
                case 5:
                    zzil<zzi> zzil2 = zzbd;
                    zzil<zzi> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzi.class) {
                            zzil<zzi> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzpa);
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
            zzi zzi = new zzi();
            zzpa = zzi;
            zzgs.zza(zzi.class, super);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zzj extends zzgs<zzj, zza> implements zzie {
        private static volatile zzil<zzj> zzbd;
        /* access modifiers changed from: private */
        public static final zzj zzpf;
        private int zzbf;
        private int zzmp;
        private long zzpb;
        private long zzpc;
        private long zzpd;
        private long zzpe;

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public enum zzb implements zzgw {
            FORMAT_UNKNOWN(0),
            FORMAT_LUMINANCE(1),
            FORMAT_RGB8(2),
            FORMAT_MONOCHROME(3);
            
            private static final zzgv<zzb> zzgy = new zzem();
            private final int value;

            public final int zzag() {
                return this.value;
            }

            public static zzb zzx(int i) {
                if (i == 0) {
                    return FORMAT_UNKNOWN;
                }
                if (i == 1) {
                    return FORMAT_LUMINANCE;
                }
                if (i == 2) {
                    return FORMAT_RGB8;
                }
                if (i != 3) {
                    return null;
                }
                return FORMAT_MONOCHROME;
            }

            public static zzgy zzah() {
                return zzen.zzhb;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzb(int i) {
                this.value = i;
            }
        }

        private zzj() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class zza extends zzgs.zza<zzj, zza> implements zzie {
            private zza() {
                super(zzj.zzpf);
            }

            public final zza zzh(long j) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzj) this.zzwb).zzl(j);
                return this;
            }

            public final zza zzi(long j) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzj) this.zzwb).zzm(j);
                return this;
            }

            public final zza zzj(long j) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzj) this.zzwb).zzn(j);
                return this;
            }

            public final zza zzk(long j) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzj) this.zzwb).zzo(j);
                return this;
            }

            /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzl(long j) {
            this.zzbf |= 2;
            this.zzpb = j;
        }

        /* access modifiers changed from: private */
        public final void zzm(long j) {
            this.zzbf |= 4;
            this.zzpc = j;
        }

        /* access modifiers changed from: private */
        public final void zzn(long j) {
            this.zzbf |= 8;
            this.zzpd = j;
        }

        /* access modifiers changed from: private */
        public final void zzo(long j) {
            this.zzbf |= 16;
            this.zzpe = j;
        }

        public static zza zzcz() {
            return (zza) zzpf.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzj>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzj> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzpf, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\u0002\u0001\u0003\u0002\u0002\u0004\u0002\u0004\u0005\u0002\u0003", new Object[]{"zzbf", "zzmp", zzb.zzah(), "zzpb", "zzpc", "zzpe", "zzpd"});
                case 4:
                    return zzpf;
                case 5:
                    zzil<zzj> zzil2 = zzbd;
                    zzil<zzj> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzj.class) {
                            zzil<zzj> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzpf);
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
            zzj zzj = new zzj();
            zzpf = zzj;
            zzgs.zza(zzj.class, super);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zzk extends zzgs<zzk, zza> implements zzie {
        private static volatile zzil<zzk> zzbd;
        /* access modifiers changed from: private */
        public static final zzk zzpp;
        private int zzbf;
        private String zznb = "";
        private String zznj = "";
        private long zzpl;
        private zza zzpm;
        private zzg zzpn;
        private zzb zzpo;

        private zzk() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class zza extends zzgs.zza<zzk, zza> implements zzie {
            private zza() {
                super(zzk.zzpp);
            }

            public final zza zzt(String str) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzk) this.zzwb).setName(str);
                return this;
            }

            public final zza zzq(long j) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzk) this.zzwb).zzp(j);
                return this;
            }

            public final zza zzb(zza zza) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzk) this.zzwb).zza(zza);
                return this;
            }

            public final zza zzu(String str) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzk) this.zzwb).zzs(str);
                return this;
            }

            public final zza zza(zzg.zzb zzb) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzk) this.zzwb).zza((zzg) ((zzgs) super.zzgc()));
                return this;
            }

            /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void setName(String str) {
            str.getClass();
            this.zzbf |= 1;
            this.zznj = str;
        }

        /* access modifiers changed from: private */
        public final void zzp(long j) {
            this.zzbf |= 2;
            this.zzpl = j;
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            zza2.getClass();
            this.zzpm = zza2;
            this.zzbf |= 4;
        }

        /* access modifiers changed from: private */
        public final void zzs(String str) {
            str.getClass();
            this.zzbf |= 8;
            this.zznb = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zzg zzg) {
            zzg.getClass();
            this.zzpn = zzg;
            this.zzbf |= 16;
        }

        public static zza zzdb() {
            return (zza) zzpp.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzk>, com.google.android.gms.internal.vision.zzgs$zzc] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzk> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzpp, "\u0001\u0006\u0000\u0001\u0001\u0011\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\t\u0002\u0006\b\u0003\u0010\t\u0004\u0011\t\u0005", new Object[]{"zzbf", "zznj", "zzpl", "zzpm", "zznb", "zzpn", "zzpo"});
                case 4:
                    return zzpp;
                case 5:
                    zzil<zzk> zzil2 = zzbd;
                    zzil<zzk> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzk.class) {
                            zzil<zzk> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzpp);
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
            zzk zzk = new zzk();
            zzpp = zzk;
            zzgs.zza(zzk.class, super);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zzm extends zzgs<zzm, zza> implements zzie {
        private static volatile zzil<zzm> zzbd;
        /* access modifiers changed from: private */
        public static final zzm zzpt;
        private int zzbf;
        private int zzpr;
        private int zzps;

        private zzm() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class zza extends zzgs.zza<zzm, zza> implements zzie {
            private zza() {
                super(zzm.zzpt);
            }

            public final zza zzy(int i) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzm) this.zzwb).setX(i);
                return this;
            }

            public final zza zzz(int i) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzm) this.zzwb).setY(i);
                return this;
            }

            /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void setX(int i) {
            this.zzbf |= 1;
            this.zzpr = i;
        }

        /* access modifiers changed from: private */
        public final void setY(int i) {
            this.zzbf |= 2;
            this.zzps = i;
        }

        public static zza zzde() {
            return (zza) zzpt.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzm>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzm> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzpt, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzbf", "zzpr", "zzps"});
                case 4:
                    return zzpt;
                case 5:
                    zzil<zzm> zzil2 = zzbd;
                    zzil<zzm> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzm.class) {
                            zzil<zzm> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzpt);
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
            zzm zzm = new zzm();
            zzpt = zzm;
            zzgs.zza(zzm.class, super);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zzn extends zzgs<zzn, zza> implements zzie {
        private static volatile zzil<zzn> zzbd;
        /* access modifiers changed from: private */
        public static final zzn zzpy;
        private int zzbf;
        private zzd zzpu;
        private int zzpv;
        private zzh zzpw;
        private zzc zzpx;

        private zzn() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class zza extends zzgs.zza<zzn, zza> implements zzie {
            private zza() {
                super(zzn.zzpy);
            }

            public final zza zza(zzd.zza zza) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzn) this.zzwb).zza((zzd) ((zzgs) super.zzgc()));
                return this;
            }

            public final zza zzaa(int i) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzn) this.zzwb).setId(i);
                return this;
            }

            public final zza zzb(zzh zzh) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzn) this.zzwb).zza(zzh);
                return this;
            }

            /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzd zzd) {
            zzd.getClass();
            this.zzpu = zzd;
            this.zzbf |= 1;
        }

        /* access modifiers changed from: private */
        public final void setId(int i) {
            this.zzbf |= 2;
            this.zzpv = i;
        }

        /* access modifiers changed from: private */
        public final void zza(zzh zzh) {
            zzh.getClass();
            this.zzpw = zzh;
            this.zzbf |= 4;
        }

        public static zza zzdg() {
            return (zza) zzpy.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzn>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzn> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzpy, "\u0001\u0004\u0000\u0001\u0001\u0011\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\u0004\u0001\u0010\t\u0002\u0011\t\u0003", new Object[]{"zzbf", "zzpu", "zzpv", "zzpw", "zzpx"});
                case 4:
                    return zzpy;
                case 5:
                    zzil<zzn> zzil2 = zzbd;
                    zzil<zzn> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzn.class) {
                            zzil<zzn> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzpy);
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
            zzn zzn = new zzn();
            zzpy = zzn;
            zzgs.zza(zzn.class, super);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zzo extends zzgs<zzo, zza> implements zzie {
        private static volatile zzil<zzo> zzbd;
        /* access modifiers changed from: private */
        public static final zzo zzqd;
        private int zzbf;
        private zze zzpz;
        private zzk zzqa;
        private zzi zzqb;
        private int zzqc;

        private zzo() {
        }

        /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
        public static final class zza extends zzgs.zza<zzo, zza> implements zzie {
            private zza() {
                super(zzo.zzqd);
            }

            public final zza zza(zzk.zza zza) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzo) this.zzwb).zza((zzk) ((zzgs) super.zzgc()));
                return this;
            }

            public final zza zzb(zzi zzi) {
                if (super.zzwc) {
                    zzfy();
                    super.zzwc = false;
                }
                ((zzo) this.zzwb).zza(zzi);
                return this;
            }

            /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzk zzk) {
            zzk.getClass();
            this.zzqa = zzk;
            this.zzbf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zza(zzi zzi) {
            zzi.getClass();
            this.zzqb = zzi;
            this.zzbf |= 4;
        }

        public static zza zzdi() {
            return (zza) zzqd.zzge();
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzo>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzil<zzo> zzil;
            switch (zzdz.zzbe[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzqd, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\u0004\u0003", new Object[]{"zzbf", "zzpz", "zzqa", "zzqb", "zzqc"});
                case 4:
                    return zzqd;
                case 5:
                    zzil<zzo> zzil2 = zzbd;
                    zzil<zzo> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzo.class) {
                            zzil<zzo> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzqd);
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
            zzo zzo = new zzo();
            zzqd = zzo;
            zzgs.zza(zzo.class, super);
        }
    }
}
