package com.google.android.gms.internal.firebase_ml;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.FrameMetricsAggregator;
import com.google.android.gms.internal.firebase_ml.zzsl;
import com.google.android.gms.internal.firebase_ml.zzvx;
import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzng {

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zza extends zzvx<zza, zzb> implements zzxi {
        /* access modifiers changed from: private */
        public static final zza zzajk;
        private static volatile zzxt<zza> zzj;
        private C0008zza zzajh;
        private int zzaji;
        private zzz zzajj;
        private int zzf;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_ml.zzng$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class C0008zza extends zzvx<C0008zza, C0009zza> implements zzxi {
            /* access modifiers changed from: private */
            public static final C0008zza zzajp;
            private static volatile zzxt<C0008zza> zzj;
            private int zzajl;
            private boolean zzajm;
            private zzac zzajn;
            private zzai zzajo;
            private int zzf;

            private C0008zza() {
            }

            /* renamed from: com.google.android.gms.internal.firebase_ml.zzng$zza$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
            public static final class C0009zza extends zzvx.zza<C0008zza, C0009zza> implements zzxi {
                private C0009zza() {
                    super(C0008zza.zzajp);
                }

                public final C0009zza zzb(zznq zznq) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((C0008zza) this.zzcde).zza(zznq);
                    return this;
                }

                public final C0009zza zzn(boolean z) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((C0008zza) this.zzcde).zzm(z);
                    return this;
                }

                public final C0009zza zzb(zzac zzac) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((C0008zza) this.zzcde).zza(zzac);
                    return this;
                }

                /* synthetic */ C0009zza(zznh zznh) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zza(zznq zznq) {
                this.zzajl = zznq.zzb();
                this.zzf |= 1;
            }

            /* access modifiers changed from: private */
            public final void zzm(boolean z) {
                this.zzf |= 2;
                this.zzajm = z;
            }

            /* access modifiers changed from: private */
            public final void zza(zzac zzac) {
                zzac.getClass();
                this.zzajn = zzac;
                this.zzf |= 4;
            }

            public static C0009zza zzjo() {
                return (C0009zza) zzajp.zztz();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zznh.zzk[i - 1]) {
                    case 1:
                        return new C0008zza();
                    case 2:
                        return new C0009zza(null);
                    case 3:
                        return zza(zzajp, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\t\u0002\u0004\t\u0003", new Object[]{"zzf", "zzajl", zznq.zzd(), "zzajm", "zzajn", "zzajo"});
                    case 4:
                        return zzajp;
                    case 5:
                        zzxt<C0008zza> zzxt = zzj;
                        if (zzxt == null) {
                            synchronized (C0008zza.class) {
                                zzxt = zzj;
                                if (zzxt == null) {
                                    zzxt = new zzvx.zzc<>(zzajp);
                                    zzj = zzxt;
                                }
                            }
                        }
                        return zzxt;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                C0008zza zza = new C0008zza();
                zzajp = zza;
                zzvx.zza(C0008zza.class, super);
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzb extends zzvx.zza<zza, zzb> implements zzxi {
            private zzb() {
                super(zza.zzajk);
            }

            /* synthetic */ zzb(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzajk, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\u000b\u0001\u0003\t\u0002", new Object[]{"zzf", "zzajh", "zzaji", "zzajj"});
                case 4:
                    return zzajk;
                case 5:
                    zzxt<zza> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zza.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzajk);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
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
            zzajk = zza;
            zzvx.zza(zza.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzab extends zzvx.zze<zzab, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzab zzatl;
        private static volatile zzxt<zzab> zzj;
        private int zzarx;
        private zzaw zzary;
        private int zzarz;
        private boolean zzasa;
        private zzag zzasb;
        private zzx zzasc;
        private zzw zzasd;
        private zzv zzase;
        private zzal zzasf;
        private zzau zzasg;
        private zzak zzash;
        private zzam zzasi;
        private zzap zzasj;
        private zzas zzask;
        private zzar zzasl;
        private zzat zzasm;
        private zzao zzasn;
        private zzav zzaso;
        private zzn zzasp;
        private zzk zzasq;
        private zzm zzasr;
        private zzp zzass;
        private zzo zzast;
        private zzq zzasu;
        private zzr zzasv;
        private zzs zzasw;
        private zzt zzasx;
        private zzu zzasy;
        private zzh zzasz;
        private zzj zzata;
        private zzi zzatb;
        private zzae zzatc;
        private zzy zzatd;
        private zza zzate;
        private zzb zzatf;
        private zzd zzatg;
        private zzc zzath;
        private zze zzati;
        private zzf zzatj;
        private zzg zzatk;
        private byte zzbr = 2;
        private int zzf;

        private zzab() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zzb<zzab, zza> implements zzxi {
            private zza() {
                super(zzab.zzatl);
            }

            public final zzaw zzlm() {
                return ((zzab) this.zzcde).zzlm();
            }

            public final zza zza(zzaw.zza zza) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza((zzaw) ((zzvx) zza.zztx()));
                return this;
            }

            public final zza zzb(zznu zznu) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza(zznu);
                return this;
            }

            public final zza zzad(boolean z) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zzac(z);
                return this;
            }

            public final zza zza(zzag.zza zza) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza((zzag) ((zzvx) zza.zztx()));
                return this;
            }

            public final zza zza(zzx.zza zza) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza((zzx) ((zzvx) zza.zztx()));
                return this;
            }

            public final zza zzb(zzw zzw) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza(zzw);
                return this;
            }

            public final zza zzb(zzv zzv) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza(zzv);
                return this;
            }

            public final zza zzb(zzal zzal) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza(zzal);
                return this;
            }

            public final zza zzb(zzau zzau) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza(zzau);
                return this;
            }

            public final zza zzb(zzak zzak) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza(zzak);
                return this;
            }

            public final zza zza(zzak.zzc zzc) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza((zzak) ((zzvx) zzc.zztx()));
                return this;
            }

            public final zza zzb(zzam zzam) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza(zzam);
                return this;
            }

            public final zza zza(zzap.zza zza) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza((zzap) ((zzvx) zza.zztx()));
                return this;
            }

            public final zza zza(zzas.zza zza) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza((zzas) ((zzvx) zza.zztx()));
                return this;
            }

            public final zza zza(zzar.zza zza) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza((zzar) ((zzvx) zza.zztx()));
                return this;
            }

            public final zza zzb(zzh zzh) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza(zzh);
                return this;
            }

            public final zza zza(zzj.zza zza) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza((zzj) ((zzvx) zza.zztx()));
                return this;
            }

            public final zza zza(zzi.zza zza) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza((zzi) ((zzvx) zza.zztx()));
                return this;
            }

            public final zza zzb(zzae zzae) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza(zzae);
                return this;
            }

            public final zza zzb(zzy zzy) {
                if (this.zzcdf) {
                    zztt();
                    this.zzcdf = false;
                }
                ((zzab) this.zzcde).zza(zzy);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        public final zzaw zzlm() {
            zzaw zzaw = this.zzary;
            return zzaw == null ? zzaw.zzni() : zzaw;
        }

        /* access modifiers changed from: private */
        public final void zza(zzaw zzaw) {
            zzaw.getClass();
            this.zzary = zzaw;
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(zznu zznu) {
            this.zzarz = zznu.zzb();
            this.zzf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zzac(boolean z) {
            this.zzf |= 4;
            this.zzasa = z;
        }

        /* access modifiers changed from: private */
        public final void zza(zzag zzag) {
            zzag.getClass();
            this.zzasb = zzag;
            this.zzf |= 8;
        }

        /* access modifiers changed from: private */
        public final void zza(zzx zzx) {
            zzx.getClass();
            this.zzasc = zzx;
            this.zzf |= 16;
        }

        /* access modifiers changed from: private */
        public final void zza(zzw zzw) {
            zzw.getClass();
            this.zzasd = zzw;
            this.zzf |= 32;
        }

        /* access modifiers changed from: private */
        public final void zza(zzv zzv) {
            zzv.getClass();
            this.zzase = zzv;
            this.zzf |= 64;
        }

        /* access modifiers changed from: private */
        public final void zza(zzal zzal) {
            zzal.getClass();
            this.zzasf = zzal;
            this.zzf |= 128;
        }

        /* access modifiers changed from: private */
        public final void zza(zzau zzau) {
            zzau.getClass();
            this.zzasg = zzau;
            this.zzf |= 256;
        }

        /* access modifiers changed from: private */
        public final void zza(zzak zzak) {
            zzak.getClass();
            this.zzash = zzak;
            this.zzf |= 512;
        }

        /* access modifiers changed from: private */
        public final void zza(zzam zzam) {
            zzam.getClass();
            this.zzasi = zzam;
            this.zzf |= 1024;
        }

        /* access modifiers changed from: private */
        public final void zza(zzap zzap) {
            zzap.getClass();
            this.zzasj = zzap;
            this.zzf |= 2048;
        }

        /* access modifiers changed from: private */
        public final void zza(zzas zzas) {
            zzas.getClass();
            this.zzask = zzas;
            this.zzf |= 4096;
        }

        /* access modifiers changed from: private */
        public final void zza(zzar zzar) {
            zzar.getClass();
            this.zzasl = zzar;
            this.zzf |= 8192;
        }

        /* access modifiers changed from: private */
        public final void zza(zzh zzh) {
            zzh.getClass();
            this.zzasz = zzh;
            this.zzf |= 134217728;
        }

        /* access modifiers changed from: private */
        public final void zza(zzj zzj2) {
            zzj2.getClass();
            this.zzata = zzj2;
            this.zzf |= 268435456;
        }

        /* access modifiers changed from: private */
        public final void zza(zzi zzi) {
            zzi.getClass();
            this.zzatb = zzi;
            this.zzf |= 536870912;
        }

        /* access modifiers changed from: private */
        public final void zza(zzae zzae) {
            zzae.getClass();
            this.zzatc = zzae;
            this.zzf |= BasicMeasure.EXACTLY;
        }

        /* access modifiers changed from: private */
        public final void zza(zzy zzy) {
            zzy.getClass();
            this.zzatd = zzy;
            this.zzf |= Integer.MIN_VALUE;
        }

        public static zza zzln() {
            return (zza) zzatl.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzab();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzatl, "\u0001'\u0000\u0002\u0001('\u0000\u0000\u0000\u0001\t\u0000\u0002\f\u0001\u0003\t\u0003\u0004\t\u0005\u0005\t\u0007\u0006\t\b\u0007\t\t\b\t\u0011\t\t\u0012\n\t\u0013\u000b\t\u0014\f\t\u0015\r\t\u0016\u000e\t\u0017\u000f\t\u0018\u0010\t\u0019\u0011\t\u001a\u0012\t\n\u0013\t\u000e\u0014\t\u0004\u0015\t\u000f\u0016\t\u0010\u0017\t\u001b\u0018\t\u001c\u0019\t\u001d\u001a\t\u000b\u001b\t\f\u001c\t\r\u001d\t\u0006\u001e\t \u001f\t! \t\"!\t#\"\t$#\t%$\t&%\u0007\u0002'\t\u001e(\t\u001f", new Object[]{"zzf", "zzarx", "zzary", "zzarz", zznu.zzd(), "zzasb", "zzasd", "zzasf", "zzasg", "zzash", "zzasp", "zzasq", "zzasr", "zzass", "zzast", "zzasu", "zzasv", "zzasw", "zzasx", "zzasy", "zzasi", "zzasm", "zzasc", "zzasn", "zzaso", "zzasz", "zzata", "zzatb", "zzasj", "zzask", "zzasl", "zzase", "zzate", "zzatf", "zzatg", "zzath", "zzati", "zzatj", "zzatk", "zzasa", "zzatc", "zzatd"});
                case 4:
                    return zzatl;
                case 5:
                    zzxt<zzab> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzab.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzatl);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return Byte.valueOf(this.zzbr);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzbr = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzab zzab = new zzab();
            zzatl = zzab;
            zzvx.zza(zzab.class, zzab);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzaf extends zzvx<zzaf, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzaf zzauh;
        private static volatile zzxt<zzaf> zzj;
        private float zzal;
        private float zzauf;
        private float zzaug;
        private int zzf;

        private zzaf() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzaf, zza> implements zzxi {
            private zza() {
                super(zzaf.zzauh);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzaf();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzauh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0001\u0000\u0002\u0001\u0001\u0003\u0001\u0002", new Object[]{"zzf", "zzauf", "zzaug", "zzal"});
                case 4:
                    return zzauh;
                case 5:
                    zzxt<zzaf> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzaf.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzauh);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzaf zzaf = new zzaf();
            zzauh = zzaf;
            zzvx.zza(zzaf.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzao extends zzvx<zzao, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzao zzaya;
        private static volatile zzxt<zzao> zzj;
        private zzad zzakw;
        private zzaf zzaxx;
        private zzc zzaxy;
        private zzd zzaxz;
        private int zzf;

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzb extends zzvx<zzb, zza> implements zzxi {
            /* access modifiers changed from: private */
            public static final zzb zzayc;
            private static volatile zzxt<zzb> zzj;
            private float zzai;
            private String zzayb = "";
            private int zzf;

            private zzb() {
            }

            /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
            public static final class zza extends zzvx.zza<zzb, zza> implements zzxi {
                private zza() {
                    super(zzb.zzayc);
                }

                /* synthetic */ zza(zznh zznh) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zznh.zzk[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzayc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0001\u0000\u0002\b\u0001", new Object[]{"zzf", "zzai", "zzayb"});
                    case 4:
                        return zzayc;
                    case 5:
                        zzxt<zzb> zzxt = zzj;
                        if (zzxt == null) {
                            synchronized (zzb.class) {
                                zzxt = zzj;
                                if (zzxt == null) {
                                    zzxt = new zzvx.zzc<>(zzayc);
                                    zzj = zzxt;
                                }
                            }
                        }
                        return zzxt;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzb zzb = new zzb();
                zzayc = zzb;
                zzvx.zza(zzb.class, super);
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzc extends zzvx<zzc, zza> implements zzxi {
            /* access modifiers changed from: private */
            public static final zzc zzaye;
            private static volatile zzxt<zzc> zzj;
            private zzb zzayd;
            private int zzf;

            private zzc() {
            }

            /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
            public static final class zza extends zzvx.zza<zzc, zza> implements zzxi {
                private zza() {
                    super(zzc.zzaye);
                }

                /* synthetic */ zza(zznh zznh) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zznh.zzk[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzaye, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t\u0000", new Object[]{"zzf", "zzayd"});
                    case 4:
                        return zzaye;
                    case 5:
                        zzxt<zzc> zzxt = zzj;
                        if (zzxt == null) {
                            synchronized (zzc.class) {
                                zzxt = zzj;
                                if (zzxt == null) {
                                    zzxt = new zzvx.zzc<>(zzaye);
                                    zzj = zzxt;
                                }
                            }
                        }
                        return zzxt;
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
                zzaye = zzc;
                zzvx.zza(zzc.class, super);
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzd extends zzvx<zzd, zza> implements zzxi {
            /* access modifiers changed from: private */
            public static final zzd zzayg;
            private static volatile zzxt<zzd> zzj;
            private zzwh<zzb> zzayf = zzud();

            private zzd() {
            }

            /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
            public static final class zza extends zzvx.zza<zzd, zza> implements zzxi {
                private zza() {
                    super(zzd.zzayg);
                }

                /* synthetic */ zza(zznh zznh) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zznh.zzk[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzayg, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzayf", zzb.class});
                    case 4:
                        return zzayg;
                    case 5:
                        zzxt<zzd> zzxt = zzj;
                        if (zzxt == null) {
                            synchronized (zzd.class) {
                                zzxt = zzj;
                                if (zzxt == null) {
                                    zzxt = new zzvx.zzc<>(zzayg);
                                    zzj = zzxt;
                                }
                            }
                        }
                        return zzxt;
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
                zzayg = zzd;
                zzvx.zza(zzd.class, super);
            }
        }

        private zzao() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzao, zza> implements zzxi {
            private zza() {
                super(zzao.zzaya);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzao();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzaya, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003", new Object[]{"zzf", "zzakw", "zzaxx", "zzaxy", "zzaxz"});
                case 4:
                    return zzaya;
                case 5:
                    zzxt<zzao> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzao.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzaya);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzao zzao = new zzao();
            zzaya = zzao;
            zzvx.zza(zzao.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzat extends zzvx<zzat, zzb> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzat zzayx;
        private static volatile zzxt<zzat> zzj;
        private zzad zzakw;
        private zzwh<zzc> zzayt = zzud();
        private int zzayu;
        private int zzayv;
        private int zzayw;
        private int zzf;

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zza implements zzwb {
            NO_ERROR(0),
            STATUS_SENSITIVE_TOPIC(1),
            STATUS_QUALITY_THRESHOLDED(2),
            STATUS_INTERNAL_ERROR(3),
            STATUS_NOT_SUPPORTED_LANGUAGE(101),
            STATUS_32_BIT_CPU(1001),
            STATUS_32_BIT_APP(1002);
            
            private static final zzwa<zza> zzt = new zzox();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zza zzbp(int i) {
                if (i == 0) {
                    return NO_ERROR;
                }
                if (i == 1) {
                    return STATUS_SENSITIVE_TOPIC;
                }
                if (i == 2) {
                    return STATUS_QUALITY_THRESHOLDED;
                }
                if (i == 3) {
                    return STATUS_INTERNAL_ERROR;
                }
                if (i == 101) {
                    return STATUS_NOT_SUPPORTED_LANGUAGE;
                }
                if (i == 1001) {
                    return STATUS_32_BIT_CPU;
                }
                if (i != 1002) {
                    return null;
                }
                return STATUS_32_BIT_APP;
            }

            public static zzwd zzd() {
                return zzow.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zza(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzc extends zzvx<zzc, zza> implements zzxi {
            /* access modifiers changed from: private */
            public static final zzc zzazg;
            private static volatile zzxt<zzc> zzj;
            private float zzai;
            private int zzf;

            private zzc() {
            }

            /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
            public static final class zza extends zzvx.zza<zzc, zza> implements zzxi {
                private zza() {
                    super(zzc.zzazg);
                }

                /* synthetic */ zza(zznh zznh) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zznh.zzk[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzazg, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000", new Object[]{"zzf", "zzai"});
                    case 4:
                        return zzazg;
                    case 5:
                        zzxt<zzc> zzxt = zzj;
                        if (zzxt == null) {
                            synchronized (zzc.class) {
                                zzxt = zzj;
                                if (zzxt == null) {
                                    zzxt = new zzvx.zzc<>(zzazg);
                                    zzj = zzxt;
                                }
                            }
                        }
                        return zzxt;
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
                zzazg = zzc;
                zzvx.zza(zzc.class, super);
            }
        }

        private zzat() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzb extends zzvx.zza<zzat, zzb> implements zzxi {
            private zzb() {
                super(zzat.zzayx);
            }

            /* synthetic */ zzb(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzat();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzayx, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\t\u0000\u0002\u001b\u0003\f\u0001\u0004\u0004\u0002\u0005\u0004\u0003", new Object[]{"zzf", "zzakw", "zzayt", zzc.class, "zzayu", zza.zzd(), "zzayv", "zzayw"});
                case 4:
                    return zzayx;
                case 5:
                    zzxt<zzat> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzat.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzayx);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzat zzat = new zzat();
            zzayx = zzat;
            zzvx.zza(zzat.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzav extends zzvx<zzav, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzav zzazp;
        private static volatile zzxt<zzav> zzj;
        private zzad zzakw;
        private zzax zzazi;
        private int zzazj;
        private int zzazk;
        private int zzazl;
        private int zzazm;
        private int zzazn;
        private int zzazo;
        private int zzf;

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zzb implements zzwb {
            NO_ERROR(0),
            METADATA_FILE_UNAVAILABLE(1),
            METADATA_ENTRY_NOT_FOUND(2),
            METADATA_JSON_INVALID(3),
            METADATA_HASH_NOT_FOUND(4),
            DOWNLOAD_MANAGER_SERVICE_MISSING(5),
            DOWNLOAD_MANAGER_HTTP_UNKNOWN_STATUS(6),
            DOWNLOAD_MANAGER_HTTP_BAD_REQUEST(400),
            DOWNLOAD_MANAGER_HTTP_UNAUTHORIZED(401),
            DOWNLOAD_MANAGER_HTTP_FORBIDDEN(403),
            DOWNLOAD_MANAGER_HTTP_NOT_FOUND(404),
            DOWNLOAD_MANAGER_HTTP_REQUEST_TIMEOUT(408),
            DOWNLOAD_MANAGER_HTTP_ABORTED(409),
            DOWNLOAD_MANAGER_HTTP_TOO_MANY_REQUESTS(429),
            DOWNLOAD_MANAGER_HTTP_CANCELLED(499),
            DOWNLOAD_MANAGER_HTTP_UNIMPLEMENTED(501),
            DOWNLOAD_MANAGER_HTTP_INTERNAL_SERVICE_ERROR(500),
            DOWNLOAD_MANAGER_HTTP_SERVICE_UNAVAILABLE(503),
            DOWNLOAD_MANAGER_HTTP_DEADLINE_EXCEEDED(504),
            DOWNLOAD_MANAGER_HTTP_NETWORK_AUTHENTICATION_REQUIRED(FrameMetricsAggregator.EVERY_DURATION),
            DOWNLOAD_MANAGER_FILE_ERROR(7),
            DOWNLOAD_MANAGER_UNHANDLED_HTTP_CODE(8),
            DOWNLOAD_MANAGER_HTTP_DATA_ERROR(9),
            DOWNLOAD_MANAGER_TOO_MANY_REDIRECTS(10),
            DOWNLOAD_MANAGER_INSUFFICIENT_SPACE(11),
            DOWNLOAD_MANAGER_DEVICE_NOT_FOUND(12),
            DOWNLOAD_MANAGER_CANNOT_RESUME(13),
            DOWNLOAD_MANAGER_FILE_ALREADY_EXISTS(14),
            DOWNLOAD_MANAGER_UNKNOWN_ERROR(15),
            POST_DOWNLOAD_FILE_NOT_FOUND(16),
            POST_DOWNLOAD_MOVE_FILE_FAILED(17),
            POST_DOWNLOAD_UNZIP_FAILED(18),
            RAPID_RESPONSE_COULD_NOT_BE_WRITTEN(19),
            DRIVER_OBJECT_DEALLOCATED(20);
            
            private static final zzwa<zzb> zzt = new zzoy();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zzb zzbq(int i) {
                if (i == 400) {
                    return DOWNLOAD_MANAGER_HTTP_BAD_REQUEST;
                }
                if (i == 401) {
                    return DOWNLOAD_MANAGER_HTTP_UNAUTHORIZED;
                }
                if (i == 403) {
                    return DOWNLOAD_MANAGER_HTTP_FORBIDDEN;
                }
                if (i == 404) {
                    return DOWNLOAD_MANAGER_HTTP_NOT_FOUND;
                }
                if (i == 408) {
                    return DOWNLOAD_MANAGER_HTTP_REQUEST_TIMEOUT;
                }
                if (i == 409) {
                    return DOWNLOAD_MANAGER_HTTP_ABORTED;
                }
                if (i == 429) {
                    return DOWNLOAD_MANAGER_HTTP_TOO_MANY_REQUESTS;
                }
                if (i == 511) {
                    return DOWNLOAD_MANAGER_HTTP_NETWORK_AUTHENTICATION_REQUIRED;
                }
                if (i == 503) {
                    return DOWNLOAD_MANAGER_HTTP_SERVICE_UNAVAILABLE;
                }
                if (i == 504) {
                    return DOWNLOAD_MANAGER_HTTP_DEADLINE_EXCEEDED;
                }
                switch (i) {
                    case 0:
                        return NO_ERROR;
                    case 1:
                        return METADATA_FILE_UNAVAILABLE;
                    case 2:
                        return METADATA_ENTRY_NOT_FOUND;
                    case 3:
                        return METADATA_JSON_INVALID;
                    case 4:
                        return METADATA_HASH_NOT_FOUND;
                    case 5:
                        return DOWNLOAD_MANAGER_SERVICE_MISSING;
                    case 6:
                        return DOWNLOAD_MANAGER_HTTP_UNKNOWN_STATUS;
                    case 7:
                        return DOWNLOAD_MANAGER_FILE_ERROR;
                    case 8:
                        return DOWNLOAD_MANAGER_UNHANDLED_HTTP_CODE;
                    case 9:
                        return DOWNLOAD_MANAGER_HTTP_DATA_ERROR;
                    case 10:
                        return DOWNLOAD_MANAGER_TOO_MANY_REDIRECTS;
                    case 11:
                        return DOWNLOAD_MANAGER_INSUFFICIENT_SPACE;
                    case 12:
                        return DOWNLOAD_MANAGER_DEVICE_NOT_FOUND;
                    case 13:
                        return DOWNLOAD_MANAGER_CANNOT_RESUME;
                    case 14:
                        return DOWNLOAD_MANAGER_FILE_ALREADY_EXISTS;
                    case 15:
                        return DOWNLOAD_MANAGER_UNKNOWN_ERROR;
                    case 16:
                        return POST_DOWNLOAD_FILE_NOT_FOUND;
                    case 17:
                        return POST_DOWNLOAD_MOVE_FILE_FAILED;
                    case 18:
                        return POST_DOWNLOAD_UNZIP_FAILED;
                    case 19:
                        return RAPID_RESPONSE_COULD_NOT_BE_WRITTEN;
                    case 20:
                        return DRIVER_OBJECT_DEALLOCATED;
                    default:
                        switch (i) {
                            case 499:
                                return DOWNLOAD_MANAGER_HTTP_CANCELLED;
                            case 500:
                                return DOWNLOAD_MANAGER_HTTP_INTERNAL_SERVICE_ERROR;
                            case 501:
                                return DOWNLOAD_MANAGER_HTTP_UNIMPLEMENTED;
                            default:
                                return null;
                        }
                }
            }

            public static zzwd zzd() {
                return zzoz.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzb(int i) {
                this.value = i;
            }
        }

        private zzav() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzav, zza> implements zzxi {
            private zza() {
                super(zzav.zzazp);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzav();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzazp, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0004\u0005\u0007\f\u0006\b\u0004\u0007", new Object[]{"zzf", "zzakw", "zzazi", "zzazj", "zzazk", "zzazl", "zzazm", "zzazn", zzb.zzd(), "zzazo"});
                case 4:
                    return zzazp;
                case 5:
                    zzxt<zzav> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzav.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzazp);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzav zzav = new zzav();
            zzazp = zzav;
            zzvx.zza(zzav.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzax extends zzvx<zzax, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzax zzbbl;
        private static volatile zzxt<zzax> zzj;
        private String zzbbj = "";
        private String zzbbk = "";
        private int zzf;

        private zzax() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzax, zza> implements zzxi {
            private zza() {
                super(zzax.zzbbl);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzax();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzbbl, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzf", "zzbbj", "zzbbk"});
                case 4:
                    return zzbbl;
                case 5:
                    zzxt<zzax> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzax.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzbbl);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzax zzax = new zzax();
            zzbbl = zzax;
            zzvx.zza(zzax.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzb extends zzvx<zzb, C0012zzb> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzb zzajr;
        private static volatile zzxt<zzb> zzj;
        private int zzaji;
        private zzz zzajj;
        private zza zzajq;
        private int zzf;

        private zzb() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx<zza, C0011zza> implements zzxi {
            /* access modifiers changed from: private */
            public static final zza zzaju;
            private static volatile zzxt<zza> zzj;
            private int zzajl;
            private boolean zzajm;
            private zzai zzajo;
            private zzwh<zzw.zza> zzajs = zzud();
            private zzwh<zzw.zza> zzajt = zzud();
            private int zzf;

            private zza() {
            }

            /* renamed from: com.google.android.gms.internal.firebase_ml.zzng$zzb$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
            public static final class C0011zza extends zzvx.zza<zza, C0011zza> implements zzxi {
                private C0011zza() {
                    super(zza.zzaju);
                }

                public final C0011zza zzc(zznq zznq) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zznq);
                    return this;
                }

                public final C0011zza zzo(boolean z) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zzm(z);
                    return this;
                }

                public final C0011zza zzf(Iterable<? extends zzw.zza> iterable) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zzd(iterable);
                    return this;
                }

                public final C0011zza zzg(Iterable<? extends zzw.zza> iterable) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zze(iterable);
                    return this;
                }

                /* synthetic */ C0011zza(zznh zznh) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zza(zznq zznq) {
                this.zzajl = zznq.zzb();
                this.zzf |= 1;
            }

            /* access modifiers changed from: private */
            public final void zzm(boolean z) {
                this.zzf |= 2;
                this.zzajm = z;
            }

            /* access modifiers changed from: private */
            public final void zzd(Iterable<? extends zzw.zza> iterable) {
                if (!this.zzajs.zzso()) {
                    this.zzajs = zzvx.zza(this.zzajs);
                }
                zzug.zza(iterable, this.zzajs);
            }

            /* access modifiers changed from: private */
            public final void zze(Iterable<? extends zzw.zza> iterable) {
                if (!this.zzajt.zzso()) {
                    this.zzajt = zzvx.zza(this.zzajt);
                }
                zzug.zza(iterable, this.zzajt);
            }

            public static C0011zza zzjr() {
                return (C0011zza) zzaju.zztz();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zznh.zzk[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0011zza(null);
                    case 3:
                        return zza(zzaju, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\u001b\u0004\u001b\u0005\t\u0002", new Object[]{"zzf", "zzajl", zznq.zzd(), "zzajm", "zzajs", zzw.zza.class, "zzajt", zzw.zza.class, "zzajo"});
                    case 4:
                        return zzaju;
                    case 5:
                        zzxt<zza> zzxt = zzj;
                        if (zzxt == null) {
                            synchronized (zza.class) {
                                zzxt = zzj;
                                if (zzxt == null) {
                                    zzxt = new zzvx.zzc<>(zzaju);
                                    zzj = zzxt;
                                }
                            }
                        }
                        return zzxt;
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
                zzaju = zza;
                zzvx.zza(zza.class, super);
            }
        }

        /* renamed from: com.google.android.gms.internal.firebase_ml.zzng$zzb$zzb  reason: collision with other inner class name */
        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class C0012zzb extends zzvx.zza<zzb, C0012zzb> implements zzxi {
            private C0012zzb() {
                super(zzb.zzajr);
            }

            /* synthetic */ C0012zzb(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C0012zzb(null);
                case 3:
                    return zza(zzajr, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\u000b\u0001\u0003\t\u0002", new Object[]{"zzf", "zzajq", "zzaji", "zzajj"});
                case 4:
                    return zzajr;
                case 5:
                    zzxt<zzb> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzb.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzajr);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzb = new zzb();
            zzajr = zzb;
            zzvx.zza(zzb.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzc extends zzvx<zzc, zzb> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzc zzajw;
        private static volatile zzxt<zzc> zzj;
        private int zzaji;
        private zzz zzajj;
        private zza zzajv;
        private int zzf;

        private zzc() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx<zza, C0013zza> implements zzxi {
            private static final zzwe<Integer, zzak.zza> zzaka = new zznj();
            private static final zzwe<Integer, zzak.zzb> zzakc = new zzni();
            /* access modifiers changed from: private */
            public static final zza zzakd;
            private static volatile zzxt<zza> zzj;
            private int zzajl;
            private boolean zzajm;
            private zzac zzajn;
            private boolean zzajx;
            private zzsl.zza zzajy;
            private zzwf zzajz = zzub();
            private zzwf zzakb = zzub();
            private int zzf;

            private zza() {
            }

            /* renamed from: com.google.android.gms.internal.firebase_ml.zzng$zzc$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
            public static final class C0013zza extends zzvx.zza<zza, C0013zza> implements zzxi {
                private C0013zza() {
                    super(zza.zzakd);
                }

                public final C0013zza zzd(zznq zznq) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zznq);
                    return this;
                }

                public final C0013zza zzp(boolean z) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zzm(z);
                    return this;
                }

                public final C0013zza zzc(zzac zzac) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zzac);
                    return this;
                }

                public final C0013zza zzb(zzsl.zza zza) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zza);
                    return this;
                }

                public final C0013zza zzj(Iterable<? extends zzak.zza> iterable) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zzh(iterable);
                    return this;
                }

                public final C0013zza zzk(Iterable<? extends zzak.zzb> iterable) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zzi(iterable);
                    return this;
                }

                /* synthetic */ C0013zza(zznh zznh) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zza(zznq zznq) {
                this.zzajl = zznq.zzb();
                this.zzf |= 1;
            }

            /* access modifiers changed from: private */
            public final void zzm(boolean z) {
                this.zzf |= 4;
                this.zzajm = z;
            }

            /* access modifiers changed from: private */
            public final void zza(zzac zzac) {
                zzac.getClass();
                this.zzajn = zzac;
                this.zzf |= 8;
            }

            /* access modifiers changed from: private */
            public final void zza(zzsl.zza zza) {
                zza.getClass();
                this.zzajy = zza;
                this.zzf |= 16;
            }

            /* access modifiers changed from: private */
            public final void zzh(Iterable<? extends zzak.zza> iterable) {
                if (!this.zzajz.zzso()) {
                    this.zzajz = zzvx.zza(this.zzajz);
                }
                for (zzak.zza zzb : iterable) {
                    this.zzajz.zzdo(zzb.zzb());
                }
            }

            /* access modifiers changed from: private */
            public final void zzi(Iterable<? extends zzak.zzb> iterable) {
                if (!this.zzakb.zzso()) {
                    this.zzakb = zzvx.zza(this.zzakb);
                }
                for (zzak.zzb zzb : iterable) {
                    this.zzakb.zzdo(zzb.zzb());
                }
            }

            public static C0013zza zzju() {
                return (C0013zza) zzakd.zztz();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zznh.zzk[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0013zza(null);
                    case 3:
                        return zza(zzakd, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\u0007\u0002\u0004\t\u0003\u0005\t\u0004\u0006\u001e\u0007\u001e", new Object[]{"zzf", "zzajl", zznq.zzd(), "zzajx", "zzajm", "zzajn", "zzajy", "zzajz", zzak.zza.zzd(), "zzakb", zzak.zzb.zzd()});
                    case 4:
                        return zzakd;
                    case 5:
                        zzxt<zza> zzxt = zzj;
                        if (zzxt == null) {
                            synchronized (zza.class) {
                                zzxt = zzj;
                                if (zzxt == null) {
                                    zzxt = new zzvx.zzc<>(zzakd);
                                    zzj = zzxt;
                                }
                            }
                        }
                        return zzxt;
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
                zzakd = zza;
                zzvx.zza(zza.class, super);
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzb extends zzvx.zza<zzc, zzb> implements zzxi {
            private zzb() {
                super(zzc.zzajw);
            }

            /* synthetic */ zzb(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzajw, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\u000b\u0001\u0003\t\u0002", new Object[]{"zzf", "zzajv", "zzaji", "zzajj"});
                case 4:
                    return zzajw;
                case 5:
                    zzxt<zzc> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzc.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzajw);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
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
            zzajw = zzc;
            zzvx.zza(zzc.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzd extends zzvx<zzd, zzb> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzd zzakf;
        private static volatile zzxt<zzd> zzj;
        private int zzaji;
        private zzz zzajj;
        private zza zzake;
        private int zzf;

        private zzd() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx<zza, C0014zza> implements zzxi {
            /* access modifiers changed from: private */
            public static final zza zzakj;
            private static volatile zzxt<zza> zzj;
            private int zzajl;
            private boolean zzajm;
            private zzac zzajn;
            private zzaa zzakg;
            private int zzakh;
            private int zzaki;
            private int zzf;

            private zza() {
            }

            /* renamed from: com.google.android.gms.internal.firebase_ml.zzng$zzd$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
            public static final class C0014zza extends zzvx.zza<zza, C0014zza> implements zzxi {
                private C0014zza() {
                    super(zza.zzakj);
                }

                public final C0014zza zze(zznq zznq) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zznq);
                    return this;
                }

                public final C0014zza zzq(boolean z) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zzm(z);
                    return this;
                }

                public final C0014zza zzd(zzac zzac) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zzac);
                    return this;
                }

                public final C0014zza zzb(zzaa zzaa) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zzaa);
                    return this;
                }

                public final C0014zza zzar(int i) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zzap(i);
                    return this;
                }

                public final C0014zza zzas(int i) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zzaq(i);
                    return this;
                }

                /* synthetic */ C0014zza(zznh zznh) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zza(zznq zznq) {
                this.zzajl = zznq.zzb();
                this.zzf |= 1;
            }

            /* access modifiers changed from: private */
            public final void zzm(boolean z) {
                this.zzf |= 2;
                this.zzajm = z;
            }

            /* access modifiers changed from: private */
            public final void zza(zzac zzac) {
                zzac.getClass();
                this.zzajn = zzac;
                this.zzf |= 4;
            }

            /* access modifiers changed from: private */
            public final void zza(zzaa zzaa) {
                zzaa.getClass();
                this.zzakg = zzaa;
                this.zzf |= 8;
            }

            /* access modifiers changed from: private */
            public final void zzap(int i) {
                this.zzf |= 16;
                this.zzakh = i;
            }

            /* access modifiers changed from: private */
            public final void zzaq(int i) {
                this.zzf |= 32;
                this.zzaki = i;
            }

            public static C0014zza zzjx() {
                return (C0014zza) zzakj.zztz();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zznh.zzk[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0014zza(null);
                    case 3:
                        return zza(zzakj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u000b\u0004\u0006\u000b\u0005", new Object[]{"zzf", "zzajl", zznq.zzd(), "zzajm", "zzajn", "zzakg", "zzakh", "zzaki"});
                    case 4:
                        return zzakj;
                    case 5:
                        zzxt<zza> zzxt = zzj;
                        if (zzxt == null) {
                            synchronized (zza.class) {
                                zzxt = zzj;
                                if (zzxt == null) {
                                    zzxt = new zzvx.zzc<>(zzakj);
                                    zzj = zzxt;
                                }
                            }
                        }
                        return zzxt;
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
                zzakj = zza;
                zzvx.zza(zza.class, super);
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzb extends zzvx.zza<zzd, zzb> implements zzxi {
            private zzb() {
                super(zzd.zzakf);
            }

            /* synthetic */ zzb(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzakf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\u000b\u0001\u0003\t\u0002", new Object[]{"zzf", "zzake", "zzaji", "zzajj"});
                case 4:
                    return zzakf;
                case 5:
                    zzxt<zzd> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzd.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzakf);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
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
            zzakf = zzd;
            zzvx.zza(zzd.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zze extends zzvx<zze, zzb> implements zzxi {
        /* access modifiers changed from: private */
        public static final zze zzakl;
        private static volatile zzxt<zze> zzj;
        private int zzaji;
        private zzz zzajj;
        private zza zzakk;
        private int zzf;

        private zze() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx<zza, C0015zza> implements zzxi {
            /* access modifiers changed from: private */
            public static final zza zzakn;
            private static volatile zzxt<zza> zzj;
            private int zzajl;
            private boolean zzajm;
            private zzac zzajn;
            private zzan zzakm;
            private int zzf;

            private zza() {
            }

            /* renamed from: com.google.android.gms.internal.firebase_ml.zzng$zze$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
            public static final class C0015zza extends zzvx.zza<zza, C0015zza> implements zzxi {
                private C0015zza() {
                    super(zza.zzakn);
                }

                public final C0015zza zzf(zznq zznq) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zznq);
                    return this;
                }

                public final C0015zza zzr(boolean z) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zzm(z);
                    return this;
                }

                public final C0015zza zze(zzac zzac) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zzac);
                    return this;
                }

                public final C0015zza zzb(zzan zzan) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zzan);
                    return this;
                }

                /* synthetic */ C0015zza(zznh zznh) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zza(zznq zznq) {
                this.zzajl = zznq.zzb();
                this.zzf |= 1;
            }

            /* access modifiers changed from: private */
            public final void zzm(boolean z) {
                this.zzf |= 2;
                this.zzajm = z;
            }

            /* access modifiers changed from: private */
            public final void zza(zzac zzac) {
                zzac.getClass();
                this.zzajn = zzac;
                this.zzf |= 4;
            }

            /* access modifiers changed from: private */
            public final void zza(zzan zzan) {
                zzan.getClass();
                this.zzakm = zzan;
                this.zzf |= 8;
            }

            public static C0015zza zzka() {
                return (C0015zza) zzakn.zztz();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zznh.zzk[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0015zza(null);
                    case 3:
                        return zza(zzakn, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\t\u0002\u0004\t\u0003", new Object[]{"zzf", "zzajl", zznq.zzd(), "zzajm", "zzajn", "zzakm"});
                    case 4:
                        return zzakn;
                    case 5:
                        zzxt<zza> zzxt = zzj;
                        if (zzxt == null) {
                            synchronized (zza.class) {
                                zzxt = zzj;
                                if (zzxt == null) {
                                    zzxt = new zzvx.zzc<>(zzakn);
                                    zzj = zzxt;
                                }
                            }
                        }
                        return zzxt;
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
                zzakn = zza;
                zzvx.zza(zza.class, super);
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzb extends zzvx.zza<zze, zzb> implements zzxi {
            private zzb() {
                super(zze.zzakl);
            }

            /* synthetic */ zzb(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzakl, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\u000b\u0001\u0003\t\u0002", new Object[]{"zzf", "zzakk", "zzaji", "zzajj"});
                case 4:
                    return zzakl;
                case 5:
                    zzxt<zze> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zze.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzakl);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
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
            zzakl = zze;
            zzvx.zza(zze.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzf extends zzvx<zzf, zzb> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzf zzakp;
        private static volatile zzxt<zzf> zzj;
        private int zzaji;
        private zzz zzajj;
        private zza zzako;
        private int zzf;

        private zzf() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx<zza, C0016zza> implements zzxi {
            /* access modifiers changed from: private */
            public static final zza zzakr;
            private static volatile zzxt<zza> zzj;
            private int zzajl;
            private boolean zzajm;
            private zzac zzajn;
            private boolean zzajx;
            private zzaq zzakq;
            private int zzf;

            private zza() {
            }

            /* renamed from: com.google.android.gms.internal.firebase_ml.zzng$zzf$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
            public static final class C0016zza extends zzvx.zza<zza, C0016zza> implements zzxi {
                private C0016zza() {
                    super(zza.zzakr);
                }

                public final C0016zza zzg(zznq zznq) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zznq);
                    return this;
                }

                public final C0016zza zzt(boolean z) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zzs(z);
                    return this;
                }

                public final C0016zza zzu(boolean z) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zzm(z);
                    return this;
                }

                public final C0016zza zzf(zzac zzac) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zzac);
                    return this;
                }

                public final C0016zza zzb(zzaq zzaq) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zzaq);
                    return this;
                }

                /* synthetic */ C0016zza(zznh zznh) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zza(zznq zznq) {
                this.zzajl = zznq.zzb();
                this.zzf |= 1;
            }

            /* access modifiers changed from: private */
            public final void zzs(boolean z) {
                this.zzf |= 2;
                this.zzajx = z;
            }

            /* access modifiers changed from: private */
            public final void zzm(boolean z) {
                this.zzf |= 4;
                this.zzajm = z;
            }

            /* access modifiers changed from: private */
            public final void zza(zzac zzac) {
                zzac.getClass();
                this.zzajn = zzac;
                this.zzf |= 8;
            }

            /* access modifiers changed from: private */
            public final void zza(zzaq zzaq) {
                zzaq.getClass();
                this.zzakq = zzaq;
                this.zzf |= 16;
            }

            public static C0016zza zzkd() {
                return (C0016zza) zzakr.zztz();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zznh.zzk[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0016zza(null);
                    case 3:
                        return zza(zzakr, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\u0007\u0002\u0004\t\u0003\u0005\t\u0004", new Object[]{"zzf", "zzajl", zznq.zzd(), "zzajx", "zzajm", "zzajn", "zzakq"});
                    case 4:
                        return zzakr;
                    case 5:
                        zzxt<zza> zzxt = zzj;
                        if (zzxt == null) {
                            synchronized (zza.class) {
                                zzxt = zzj;
                                if (zzxt == null) {
                                    zzxt = new zzvx.zzc<>(zzakr);
                                    zzj = zzxt;
                                }
                            }
                        }
                        return zzxt;
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
                zzakr = zza;
                zzvx.zza(zza.class, super);
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzb extends zzvx.zza<zzf, zzb> implements zzxi {
            private zzb() {
                super(zzf.zzakp);
            }

            /* synthetic */ zzb(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzakp, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\u000b\u0001\u0003\t\u0002", new Object[]{"zzf", "zzako", "zzaji", "zzajj"});
                case 4:
                    return zzakp;
                case 5:
                    zzxt<zzf> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzf.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzakp);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzf zzf2 = new zzf();
            zzakp = zzf2;
            zzvx.zza(zzf.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzg extends zzvx<zzg, zzb> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzg zzakt;
        private static volatile zzxt<zzg> zzj;
        private int zzaji;
        private zzz zzajj;
        private zza zzaks;
        private int zzf;

        private zzg() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx<zza, C0017zza> implements zzxi {
            /* access modifiers changed from: private */
            public static final zza zzaku;
            private static volatile zzxt<zza> zzj;
            private int zzajl;
            private boolean zzajm;
            private zzac zzajn;
            private boolean zzajx;
            private int zzf;

            private zza() {
            }

            /* renamed from: com.google.android.gms.internal.firebase_ml.zzng$zzg$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
            public static final class C0017zza extends zzvx.zza<zza, C0017zza> implements zzxi {
                private C0017zza() {
                    super(zza.zzaku);
                }

                public final C0017zza zzh(zznq zznq) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zznq);
                    return this;
                }

                public final C0017zza zzv(boolean z) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zzm(z);
                    return this;
                }

                public final C0017zza zzg(zzac zzac) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zzac);
                    return this;
                }

                /* synthetic */ C0017zza(zznh zznh) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zza(zznq zznq) {
                this.zzajl = zznq.zzb();
                this.zzf |= 1;
            }

            /* access modifiers changed from: private */
            public final void zzm(boolean z) {
                this.zzf |= 4;
                this.zzajm = z;
            }

            /* access modifiers changed from: private */
            public final void zza(zzac zzac) {
                zzac.getClass();
                this.zzajn = zzac;
                this.zzf |= 8;
            }

            public static C0017zza zzkg() {
                return (C0017zza) zzaku.zztz();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zznh.zzk[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0017zza(null);
                    case 3:
                        return zza(zzaku, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\u0007\u0002\u0004\t\u0003", new Object[]{"zzf", "zzajl", zznq.zzd(), "zzajx", "zzajm", "zzajn"});
                    case 4:
                        return zzaku;
                    case 5:
                        zzxt<zza> zzxt = zzj;
                        if (zzxt == null) {
                            synchronized (zza.class) {
                                zzxt = zzj;
                                if (zzxt == null) {
                                    zzxt = new zzvx.zzc<>(zzaku);
                                    zzj = zzxt;
                                }
                            }
                        }
                        return zzxt;
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
                zzaku = zza;
                zzvx.zza(zza.class, super);
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzb extends zzvx.zza<zzg, zzb> implements zzxi {
            private zzb() {
                super(zzg.zzakt);
            }

            /* synthetic */ zzb(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzakt, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\u000b\u0001\u0003\t\u0002", new Object[]{"zzf", "zzaks", "zzaji", "zzajj"});
                case 4:
                    return zzakt;
                case 5:
                    zzxt<zzg> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzg.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzakt);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
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
            zzakt = zzg;
            zzvx.zza(zzg.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzk extends zzvx<zzk, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzk zzalf;
        private static volatile zzxt<zzk> zzj;
        private zzac zzajn;
        private zzad zzakw;
        private zzl zzale;
        private int zzf;

        private zzk() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzk, zza> implements zzxi {
            private zza() {
                super(zzk.zzalf);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzalf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzf", "zzakw", "zzale", "zzajn"});
                case 4:
                    return zzalf;
                case 5:
                    zzxt<zzk> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzk.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzalf);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
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
            zzalf = zzk;
            zzvx.zza(zzk.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzl extends zzvx<zzl, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzl zzalh;
        private static volatile zzxt<zzl> zzj;
        private int zzalg;
        private int zzdv;
        private int zzf;

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zzb implements zzwb {
            UNKNOWN_MODEL_TYPE(0),
            STABLE_MODEL(1),
            LATEST_MODEL(2);
            
            private static final zzwa<zzb> zzt = new zznl();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zzb zzat(int i) {
                if (i == 0) {
                    return UNKNOWN_MODEL_TYPE;
                }
                if (i == 1) {
                    return STABLE_MODEL;
                }
                if (i != 2) {
                    return null;
                }
                return LATEST_MODEL;
            }

            public static zzwd zzd() {
                return zznm.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzb(int i) {
                this.value = i;
            }
        }

        private zzl() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzl, zza> implements zzxi {
            private zza() {
                super(zzl.zzalh);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzalh, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\f\u0001", new Object[]{"zzf", "zzdv", "zzalg", zzb.zzd()});
                case 4:
                    return zzalh;
                case 5:
                    zzxt<zzl> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzl.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzalh);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
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
            zzalh = zzl;
            zzvx.zza(zzl.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzm extends zzvx<zzm, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzm zzalm;
        private static volatile zzxt<zzm> zzj;
        private zzac zzajn;
        private zzad zzakw;
        private zzl zzale;
        private int zzf;

        private zzm() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzm, zza> implements zzxi {
            private zza() {
                super(zzm.zzalm);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzalm, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzf", "zzakw", "zzale", "zzajn"});
                case 4:
                    return zzalm;
                case 5:
                    zzxt<zzm> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzm.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzalm);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
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
            zzalm = zzm;
            zzvx.zza(zzm.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzn extends zzvx<zzn, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzn zzaln;
        private static volatile zzxt<zzn> zzj;
        private zzac zzajn;
        private zzad zzakw;
        private zzl zzale;
        private int zzf;

        private zzn() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzn, zza> implements zzxi {
            private zza() {
                super(zzn.zzaln);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzaln, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzf", "zzakw", "zzale", "zzajn"});
                case 4:
                    return zzaln;
                case 5:
                    zzxt<zzn> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzn.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzaln);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
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
            zzaln = zzn;
            zzvx.zza(zzn.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzo extends zzvx<zzo, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzo zzalo;
        private static volatile zzxt<zzo> zzj;
        private zzac zzajn;
        private zzad zzakw;
        private zzl zzale;
        private int zzf;

        private zzo() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzo, zza> implements zzxi {
            private zza() {
                super(zzo.zzalo);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzalo, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzf", "zzakw", "zzale", "zzajn"});
                case 4:
                    return zzalo;
                case 5:
                    zzxt<zzo> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzo.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzalo);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
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
            zzalo = zzo;
            zzvx.zza(zzo.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzp extends zzvx<zzp, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzp zzalp;
        private static volatile zzxt<zzp> zzj;
        private zzac zzajn;
        private zzad zzakw;
        private zzl zzale;
        private int zzf;

        private zzp() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzp, zza> implements zzxi {
            private zza() {
                super(zzp.zzalp);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzalp, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzf", "zzakw", "zzale", "zzajn"});
                case 4:
                    return zzalp;
                case 5:
                    zzxt<zzp> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzp.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzalp);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzp zzp = new zzp();
            zzalp = zzp;
            zzvx.zza(zzp.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzq extends zzvx<zzq, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzq zzalq;
        private static volatile zzxt<zzq> zzj;
        private zzac zzajn;
        private zzad zzakw;
        private zzl zzale;
        private int zzf;

        private zzq() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzq, zza> implements zzxi {
            private zza() {
                super(zzq.zzalq);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzalq, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzf", "zzakw", "zzale", "zzajn"});
                case 4:
                    return zzalq;
                case 5:
                    zzxt<zzq> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzq.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzalq);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzq zzq = new zzq();
            zzalq = zzq;
            zzvx.zza(zzq.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzr extends zzvx<zzr, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzr zzalr;
        private static volatile zzxt<zzr> zzj;
        private zzac zzajn;
        private zzad zzakw;
        private zzl zzale;
        private int zzf;

        private zzr() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzr, zza> implements zzxi {
            private zza() {
                super(zzr.zzalr);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzalr, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzf", "zzakw", "zzale", "zzajn"});
                case 4:
                    return zzalr;
                case 5:
                    zzxt<zzr> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzr.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzalr);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzr zzr = new zzr();
            zzalr = zzr;
            zzvx.zza(zzr.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzs extends zzvx<zzs, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzs zzals;
        private static volatile zzxt<zzs> zzj;
        private zzac zzajn;
        private zzad zzakw;
        private zzl zzale;
        private int zzf;

        private zzs() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzs, zza> implements zzxi {
            private zza() {
                super(zzs.zzals);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzals, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzf", "zzakw", "zzale", "zzajn"});
                case 4:
                    return zzals;
                case 5:
                    zzxt<zzs> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzs.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzals);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzs zzs = new zzs();
            zzals = zzs;
            zzvx.zza(zzs.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzt extends zzvx<zzt, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzt zzalt;
        private static volatile zzxt<zzt> zzj;
        private zzac zzajn;
        private zzad zzakw;
        private zzl zzale;
        private int zzf;

        private zzt() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzt, zza> implements zzxi {
            private zza() {
                super(zzt.zzalt);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzalt, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzf", "zzakw", "zzale", "zzajn"});
                case 4:
                    return zzalt;
                case 5:
                    zzxt<zzt> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzt.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzalt);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzt zzt = new zzt();
            zzalt = zzt;
            zzvx.zza(zzt.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzu extends zzvx<zzu, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzu zzalu;
        private static volatile zzxt<zzu> zzj;
        private zzac zzajn;
        private zzad zzakw;
        private zzl zzale;
        private int zzf;

        private zzu() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzu, zza> implements zzxi {
            private zza() {
                super(zzu.zzalu);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzalu, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzf", "zzakw", "zzale", "zzajn"});
                case 4:
                    return zzalu;
                case 5:
                    zzxt<zzu> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzu.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzalu);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzu zzu = new zzu();
            zzalu = zzu;
            zzvx.zza(zzu.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzw extends zzvx<zzw, zzb> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzw zzalw;
        private static volatile zzxt<zzw> zzj;
        private zzai zzajo;
        private zzwh<zza> zzajs = zzud();
        private zzwh<zza> zzajt = zzud();
        private zzad zzakw;
        private long zzakx;
        private int zzf;

        private zzw() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx<zza, zzb> implements zzxi {
            /* access modifiers changed from: private */
            public static final zza zzalz;
            private static volatile zzxt<zza> zzj;
            private int zzalx;
            private zzwf zzaly = zzub();
            private int zzf;

            /* renamed from: com.google.android.gms.internal.firebase_ml.zzng$zzw$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
            public enum C0018zza implements zzwb {
                UNKNOWN_DATA_TYPE(0),
                TYPE_FLOAT32(1),
                TYPE_INT32(2),
                TYPE_BYTE(3),
                TYPE_LONG(4);
                
                private static final zzwa<C0018zza> zzt = new zzno();
                private final int value;

                public final int zzb() {
                    return this.value;
                }

                public static C0018zza zzau(int i) {
                    if (i == 0) {
                        return UNKNOWN_DATA_TYPE;
                    }
                    if (i == 1) {
                        return TYPE_FLOAT32;
                    }
                    if (i == 2) {
                        return TYPE_INT32;
                    }
                    if (i == 3) {
                        return TYPE_BYTE;
                    }
                    if (i != 4) {
                        return null;
                    }
                    return TYPE_LONG;
                }

                public static zzwd zzd() {
                    return zznn.zzae;
                }

                public final String toString() {
                    return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
                }

                private C0018zza(int i) {
                    this.value = i;
                }
            }

            private zza() {
            }

            /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
            public static final class zzb extends zzvx.zza<zza, zzb> implements zzxi {
                private zzb() {
                    super(zza.zzalz);
                }

                public final zzb zzb(C0018zza zza) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zza(zza);
                    return this;
                }

                public final zzb zzq(Iterable<? extends Integer> iterable) {
                    if (super.zzcdf) {
                        zztt();
                        super.zzcdf = false;
                    }
                    ((zza) this.zzcde).zzn(iterable);
                    return this;
                }

                /* synthetic */ zzb(zznh zznh) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zza(C0018zza zza) {
                this.zzalx = zza.zzb();
                this.zzf |= 1;
            }

            /* access modifiers changed from: private */
            public final void zzn(Iterable<? extends Integer> iterable) {
                if (!this.zzaly.zzso()) {
                    this.zzaly = zzvx.zza(this.zzaly);
                }
                zzug.zza(iterable, this.zzaly);
            }

            public static zzb zzld() {
                return (zzb) zzalz.zztz();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zznh.zzk[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new zzb(null);
                    case 3:
                        return zza(zzalz, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u0016", new Object[]{"zzf", "zzalx", C0018zza.zzd(), "zzaly"});
                    case 4:
                        return zzalz;
                    case 5:
                        zzxt<zza> zzxt = zzj;
                        if (zzxt == null) {
                            synchronized (zza.class) {
                                zzxt = zzj;
                                if (zzxt == null) {
                                    zzxt = new zzvx.zzc<>(zzalz);
                                    zzj = zzxt;
                                }
                            }
                        }
                        return zzxt;
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
                zzalz = zza;
                zzvx.zza(zza.class, super);
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzb extends zzvx.zza<zzw, zzb> implements zzxi {
            private zzb() {
                super(zzw.zzalw);
            }

            public final zzb zzb(zzad.zza zza) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzw) this.zzcde).zza((zzad) ((zzvx) super.zztx()));
                return this;
            }

            public final zzb zzh(zzai zzai) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzw) this.zzcde).zza(zzai);
                return this;
            }

            public final zzb zzo(Iterable<? extends zza> iterable) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzw) this.zzcde).zzd(iterable);
                return this;
            }

            public final zzb zzp(Iterable<? extends zza> iterable) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzw) this.zzcde).zze(iterable);
                return this;
            }

            public final zzb zzh(long j) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzw) this.zzcde).zzf(j);
                return this;
            }

            /* synthetic */ zzb(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzad zzad) {
            zzad.getClass();
            this.zzakw = zzad;
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(zzai zzai) {
            zzai.getClass();
            this.zzajo = zzai;
            this.zzf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zzd(Iterable<? extends zza> iterable) {
            if (!this.zzajs.zzso()) {
                this.zzajs = zzvx.zza(this.zzajs);
            }
            zzug.zza(iterable, this.zzajs);
        }

        /* access modifiers changed from: private */
        public final void zze(Iterable<? extends zza> iterable) {
            if (!this.zzajt.zzso()) {
                this.zzajt = zzvx.zza(this.zzajt);
            }
            zzug.zza(iterable, this.zzajt);
        }

        /* access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzf |= 4;
            this.zzakx = j;
        }

        public static zzb zzlb() {
            return (zzb) zzalw.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzw();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzalw, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u001b\u0004\u001b\u0005\u0003\u0002", new Object[]{"zzf", "zzakw", "zzajo", "zzajs", zza.class, "zzajt", zza.class, "zzakx"});
                case 4:
                    return zzalw;
                case 5:
                    zzxt<zzw> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzw.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzalw);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzw zzw = new zzw();
            zzalw = zzw;
            zzvx.zza(zzw.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzz extends zzvx<zzz, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzz zzamq;
        private static volatile zzxt<zzz> zzj;
        private long zzamk;
        private long zzaml;
        private long zzamm;
        private long zzamn;
        private long zzamo;
        private long zzamp;
        private int zzf;

        private zzz() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzz, zza> implements zzxi {
            private zza() {
                super(zzz.zzamq);
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzz();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzamq, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0003\u0000\u0002\u0003\u0001\u0003\u0003\u0002\u0004\u0003\u0003\u0005\u0003\u0004\u0006\u0003\u0005", new Object[]{"zzf", "zzamk", "zzaml", "zzamm", "zzamn", "zzamo", "zzamp"});
                case 4:
                    return zzamq;
                case 5:
                    zzxt<zzz> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzz.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzamq);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzz zzz = new zzz();
            zzamq = zzz;
            zzvx.zza(zzz.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzaa extends zzvx<zzaa, zzb> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzaa zzarg;
        private static volatile zzxt<zzaa> zzj;
        private int zzara;
        private int zzarb;
        private int zzarc;
        private int zzard;
        private boolean zzare;
        private float zzarf;
        private int zzf;

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zza implements zzwb {
            UNKNOWN_CLASSIFICATIONS(0),
            NO_CLASSIFICATIONS(1),
            ALL_CLASSIFICATIONS(2);
            
            private static final zzwa<zza> zzt = new zznx();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zza zzax(int i) {
                if (i == 0) {
                    return UNKNOWN_CLASSIFICATIONS;
                }
                if (i == 1) {
                    return NO_CLASSIFICATIONS;
                }
                if (i != 2) {
                    return null;
                }
                return ALL_CLASSIFICATIONS;
            }

            public static zzwd zzd() {
                return zznw.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zza(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zzc implements zzwb {
            UNKNOWN_CONTOURS(0),
            NO_CONTOURS(1),
            ALL_CONTOURS(2);
            
            private static final zzwa<zzc> zzt = new zzny();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zzc zzay(int i) {
                if (i == 0) {
                    return UNKNOWN_CONTOURS;
                }
                if (i == 1) {
                    return NO_CONTOURS;
                }
                if (i != 2) {
                    return null;
                }
                return ALL_CONTOURS;
            }

            public static zzwd zzd() {
                return zznz.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzc(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zzd implements zzwb {
            UNKNOWN_LANDMARKS(0),
            NO_LANDMARKS(1),
            ALL_LANDMARKS(2);
            
            private static final zzwa<zzd> zzt = new zzob();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zzd zzaz(int i) {
                if (i == 0) {
                    return UNKNOWN_LANDMARKS;
                }
                if (i == 1) {
                    return NO_LANDMARKS;
                }
                if (i != 2) {
                    return null;
                }
                return ALL_LANDMARKS;
            }

            public static zzwd zzd() {
                return zzoa.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzd(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zze implements zzwb {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);
            
            private static final zzwa<zze> zzt = new zzoc();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zze zzba(int i) {
                if (i == 0) {
                    return UNKNOWN_PERFORMANCE;
                }
                if (i == 1) {
                    return FAST;
                }
                if (i != 2) {
                    return null;
                }
                return ACCURATE;
            }

            public static zzwd zzd() {
                return zzod.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zze(int i) {
                this.value = i;
            }
        }

        private zzaa() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzb extends zzvx.zza<zzaa, zzb> implements zzxi {
            private zzb() {
                super(zzaa.zzarg);
            }

            public final zzb zzb(zzd zzd) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaa) this.zzcde).zza(zzd);
                return this;
            }

            public final zzb zzb(zza zza) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaa) this.zzcde).zza(zza);
                return this;
            }

            public final zzb zzb(zze zze) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaa) this.zzcde).zza(zze);
                return this;
            }

            public final zzb zzb(zzc zzc) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaa) this.zzcde).zza(zzc);
                return this;
            }

            public final zzb zzab(boolean z) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaa) this.zzcde).zzaa(z);
                return this;
            }

            public final zzb zzl(float f) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaa) this.zzcde).zzk(f);
                return this;
            }

            /* synthetic */ zzb(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzd zzd2) {
            this.zzara = zzd2.zzb();
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            this.zzarb = zza2.zzb();
            this.zzf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zza(zze zze2) {
            this.zzarc = zze2.zzb();
            this.zzf |= 4;
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            this.zzard = zzc2.zzb();
            this.zzf |= 8;
        }

        /* access modifiers changed from: private */
        public final void zzaa(boolean z) {
            this.zzf |= 16;
            this.zzare = z;
        }

        /* access modifiers changed from: private */
        public final void zzk(float f) {
            this.zzf |= 32;
            this.zzarf = f;
        }

        public static zzb zzlk() {
            return (zzb) zzarg.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzaa();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzarg, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\f\u0002\u0004\f\u0003\u0005\u0007\u0004\u0006\u0001\u0005", new Object[]{"zzf", "zzara", zzd.zzd(), "zzarb", zza.zzd(), "zzarc", zze.zzd(), "zzard", zzc.zzd(), "zzare", "zzarf"});
                case 4:
                    return zzarg;
                case 5:
                    zzxt<zzaa> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzaa.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzarg);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzaa zzaa = new zzaa();
            zzarg = zzaa;
            zzvx.zza(zzaa.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzac extends zzvx<zzac, zzb> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzac zzatp;
        private static volatile zzxt<zzac> zzj;
        private int zzatm;
        private int zzatn;
        private int zzato;
        private int zzf;

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zza implements zzwb {
            UNKNOWN_FORMAT(0),
            NV16(1),
            NV21(2),
            YV12(3),
            BITMAP(4),
            CM_SAMPLE_BUFFER_REF(5),
            UI_IMAGE(6);
            
            private static final zzwa<zza> zzt = new zzof();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zza zzbc(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_FORMAT;
                    case 1:
                        return NV16;
                    case 2:
                        return NV21;
                    case 3:
                        return YV12;
                    case 4:
                        return BITMAP;
                    case 5:
                        return CM_SAMPLE_BUFFER_REF;
                    case 6:
                        return UI_IMAGE;
                    default:
                        return null;
                }
            }

            public static zzwd zzd() {
                return zzoe.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zza(int i) {
                this.value = i;
            }
        }

        private zzac() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzb extends zzvx.zza<zzac, zzb> implements zzxi {
            private zzb() {
                super(zzac.zzatp);
            }

            public final zzb zzb(zza zza) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzac) this.zzcde).zza(zza);
                return this;
            }

            public final zzb zzbd(int i) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzac) this.zzcde).zzbb(i);
                return this;
            }

            /* synthetic */ zzb(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            this.zzatm = zza2.zzb();
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zzbb(int i) {
            this.zzf |= 2;
            this.zzatn = i;
        }

        public static zzb zzlp() {
            return (zzb) zzatp.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzac();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzatp, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u000b\u0001\u0003\u000b\u0002", new Object[]{"zzf", "zzatm", zza.zzd(), "zzatn", "zzato"});
                case 4:
                    return zzatp;
                case 5:
                    zzxt<zzac> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzac.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzatp);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzac zzac = new zzac();
            zzatp = zzac;
            zzvx.zza(zzac.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzad extends zzvx<zzad, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzad zzauc;
        private static volatile zzxt<zzad> zzj;
        private int zzajl;
        private boolean zzajm;
        private boolean zzamg;
        private long zzaty;
        private boolean zzatz;
        private boolean zzaua;
        private int zzaub;
        private int zzf;

        private zzad() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzad, zza> implements zzxi {
            private zza() {
                super(zzad.zzauc);
            }

            public final zza zzj(long j) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzad) this.zzcde).zzk(j);
                return this;
            }

            public final zza zzk(zznq zznq) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzad) this.zzcde).zza(zznq);
                return this;
            }

            public final zza zzae(boolean z) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzad) this.zzcde).zzm(z);
                return this;
            }

            public final zza zzaf(boolean z) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzad) this.zzcde).zzai(true);
                return this;
            }

            public final zza zzag(boolean z) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzad) this.zzcde).zzaj(true);
                return this;
            }

            public final zza zzah(boolean z) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzad) this.zzcde).zzw(z);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzk(long j) {
            this.zzf |= 1;
            this.zzaty = j;
        }

        /* access modifiers changed from: private */
        public final void zza(zznq zznq) {
            this.zzajl = zznq.zzb();
            this.zzf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zzm(boolean z) {
            this.zzf |= 4;
            this.zzajm = z;
        }

        /* access modifiers changed from: private */
        public final void zzai(boolean z) {
            this.zzf |= 8;
            this.zzatz = z;
        }

        /* access modifiers changed from: private */
        public final void zzaj(boolean z) {
            this.zzf |= 16;
            this.zzaua = z;
        }

        /* access modifiers changed from: private */
        public final void zzw(boolean z) {
            this.zzf |= 32;
            this.zzamg = z;
        }

        public static zza zzlr() {
            return (zza) zzauc.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzad();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzauc, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0003\u0000\u0002\f\u0001\u0003\u0007\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u0007\u0005\u0007\u000b\u0006", new Object[]{"zzf", "zzaty", "zzajl", zznq.zzd(), "zzajm", "zzatz", "zzaua", "zzamg", "zzaub"});
                case 4:
                    return zzauc;
                case 5:
                    zzxt<zzad> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzad.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzauc);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzad zzad = new zzad();
            zzauc = zzad;
            zzvx.zza(zzad.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzae extends zzvx<zzae, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzae zzaue;
        private static volatile zzxt<zzae> zzj;
        private int zzalg;
        private boolean zzaud;
        private int zzf;

        private zzae() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzae, zza> implements zzxi {
            private zza() {
                super(zzae.zzaue);
            }

            public final zza zzc(zzah.zza zza) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzae) this.zzcde).zza(zza);
                return this;
            }

            public final zza zzak(boolean z) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzae) this.zzcde).zzal(z);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzah.zza zza2) {
            this.zzalg = zza2.zzb();
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zzal(boolean z) {
            this.zzf |= 2;
            this.zzaud = z;
        }

        public static zza zzlt() {
            return (zza) zzaue.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzae();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzaue, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001", new Object[]{"zzf", "zzalg", zzah.zza.zzd(), "zzaud"});
                case 4:
                    return zzaue;
                case 5:
                    zzxt<zzae> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzae.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzaue);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzae zzae = new zzae();
            zzaue = zzae;
            zzvx.zza(zzae.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzag extends zzvx<zzag, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzag zzaum;
        private static volatile zzxt<zzag> zzj;
        private int zzajl;
        private zzai zzajo;
        private long zzaui;
        private long zzauj;
        private int zzauk;
        private long zzaul;
        private int zzf;

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zzb implements zzwb {
            UNKNOWN_STATUS(0),
            EXPLICITLY_REQUESTED(1),
            IMPLICITLY_REQUESTED(2),
            MODEL_INFO_RETRIEVAL_SUCCEEDED(3),
            MODEL_INFO_RETRIEVAL_FAILED(4),
            SCHEDULED(5),
            DOWNLOADING(6),
            SUCCEEDED(7),
            FAILED(8),
            LIVE(9),
            UPDATE_AVAILABLE(10),
            DOWNLOADED(11);
            
            private static final zzwa<zzb> zzt = new zzog();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zzb zzbe(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_STATUS;
                    case 1:
                        return EXPLICITLY_REQUESTED;
                    case 2:
                        return IMPLICITLY_REQUESTED;
                    case 3:
                        return MODEL_INFO_RETRIEVAL_SUCCEEDED;
                    case 4:
                        return MODEL_INFO_RETRIEVAL_FAILED;
                    case 5:
                        return SCHEDULED;
                    case 6:
                        return DOWNLOADING;
                    case 7:
                        return SUCCEEDED;
                    case 8:
                        return FAILED;
                    case 9:
                        return LIVE;
                    case 10:
                        return UPDATE_AVAILABLE;
                    case 11:
                        return DOWNLOADED;
                    default:
                        return null;
                }
            }

            public static zzwd zzd() {
                return zzoh.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzb(int i) {
                this.value = i;
            }
        }

        private zzag() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzag, zza> implements zzxi {
            private zza() {
                super(zzag.zzaum);
            }

            public final zza zzk(zzai zzai) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzag) this.zzcde).zza(zzai);
                return this;
            }

            public final zza zzl(long j) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzag) this.zzcde).zzo(j);
                return this;
            }

            public final zza zzl(zznq zznq) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzag) this.zzcde).zza(zznq);
                return this;
            }

            public final zza zzm(long j) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzag) this.zzcde).zzp(j);
                return this;
            }

            public final zza zza(zzb zzb) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzag) this.zzcde).zzb(zzb);
                return this;
            }

            public final zza zzn(long j) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzag) this.zzcde).zzq(j);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzai zzai) {
            zzai.getClass();
            this.zzajo = zzai;
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zzo(long j) {
            this.zzf |= 2;
            this.zzaui = j;
        }

        /* access modifiers changed from: private */
        public final void zza(zznq zznq) {
            this.zzajl = zznq.zzb();
            this.zzf |= 4;
        }

        /* access modifiers changed from: private */
        public final void zzp(long j) {
            this.zzf |= 8;
            this.zzauj = j;
        }

        /* access modifiers changed from: private */
        public final void zzb(zzb zzb2) {
            this.zzauk = zzb2.zzb();
            this.zzf |= 16;
        }

        /* access modifiers changed from: private */
        public final void zzq(long j) {
            this.zzf |= 32;
            this.zzaul = j;
        }

        public static zza zzlw() {
            return (zza) zzaum.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzag();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzaum, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\t\u0000\u0002\u0003\u0001\u0003\f\u0002\u0004\u0003\u0003\u0005\f\u0004\u0006\u0002\u0005", new Object[]{"zzf", "zzajo", "zzaui", "zzajl", zznq.zzd(), "zzauj", "zzauk", zzb.zzd(), "zzaul"});
                case 4:
                    return zzaum;
                case 5:
                    zzxt<zzag> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzag.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzaum);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzag zzag = new zzag();
            zzaum = zzag;
            zzvx.zza(zzag.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzah extends zzvx<zzah, zzb> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzah zzavf;
        private static volatile zzxt<zzah> zzj;
        private int zzalg;
        private String zzava = "";
        private String zzavb = "";
        private int zzavc;
        private String zzavd = "";
        private String zzave = "";
        private int zzf;

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zza implements zzwb {
            TYPE_UNKNOWN(0),
            CUSTOM(1),
            AUTOML_IMAGE_LABELING(2),
            BASE_TRANSLATE(3);
            
            private static final zzwa<zza> zzt = new zzoj();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zza zzbf(int i) {
                if (i == 0) {
                    return TYPE_UNKNOWN;
                }
                if (i == 1) {
                    return CUSTOM;
                }
                if (i == 2) {
                    return AUTOML_IMAGE_LABELING;
                }
                if (i != 3) {
                    return null;
                }
                return BASE_TRANSLATE;
            }

            public static zzwd zzd() {
                return zzoi.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zza(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zzc implements zzwb {
            SOURCE_UNKNOWN(0),
            APP_ASSET(1),
            LOCAL(2),
            CLOUD(3),
            SDK_BUILT_IN(4);
            
            private static final zzwa<zzc> zzt = new zzok();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zzc zzbg(int i) {
                if (i == 0) {
                    return SOURCE_UNKNOWN;
                }
                if (i == 1) {
                    return APP_ASSET;
                }
                if (i == 2) {
                    return LOCAL;
                }
                if (i == 3) {
                    return CLOUD;
                }
                if (i != 4) {
                    return null;
                }
                return SDK_BUILT_IN;
            }

            public static zzwd zzd() {
                return zzol.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzc(int i) {
                this.value = i;
            }
        }

        private zzah() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzb extends zzvx.zza<zzah, zzb> implements zzxi {
            private zzb() {
                super(zzah.zzavf);
            }

            public final zzb zzbe(String str) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzah) this.zzcde).setName(str);
                return this;
            }

            public final zzb zzb(zzc zzc) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzah) this.zzcde).zza(zzc);
                return this;
            }

            public final zzb zzbf(String str) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzah) this.zzcde).zzbc(str);
                return this;
            }

            public final zzb zzbg(String str) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzah) this.zzcde).zzbd(str);
                return this;
            }

            public final zzb zzd(zza zza) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzah) this.zzcde).zza(zza);
                return this;
            }

            /* synthetic */ zzb(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void setName(String str) {
            str.getClass();
            this.zzf |= 1;
            this.zzava = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            this.zzavc = zzc2.zzb();
            this.zzf |= 4;
        }

        /* access modifiers changed from: private */
        public final void zzbc(String str) {
            str.getClass();
            this.zzf |= 8;
            this.zzavd = str;
        }

        /* access modifiers changed from: private */
        public final void zzbd(String str) {
            str.getClass();
            this.zzf |= 16;
            this.zzave = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            this.zzalg = zza2.zzb();
            this.zzf |= 32;
        }

        public static zzb zzly() {
            return (zzb) zzavf.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzah();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzavf, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\f\u0002\u0004\b\u0003\u0005\b\u0004\u0006\f\u0005", new Object[]{"zzf", "zzava", "zzavb", "zzavc", zzc.zzd(), "zzavd", "zzave", "zzalg", zza.zzd()});
                case 4:
                    return zzavf;
                case 5:
                    zzxt<zzah> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzah.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzavf);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzah zzah = new zzah();
            zzavf = zzah;
            zzvx.zza(zzah.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzai extends zzvx<zzai, zzb> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzai zzavv;
        private static volatile zzxt<zzai> zzj;
        private zzah zzavr;
        private zza zzavs;
        private zza zzavt;
        private boolean zzavu;
        private int zzf;

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx<zza, C0010zza> implements zzxi {
            /* access modifiers changed from: private */
            public static final zza zzawa;
            private static volatile zzxt<zza> zzj;
            private boolean zzavw;
            private boolean zzavx;
            private boolean zzavy;
            private boolean zzavz;
            private int zzf;

            private zza() {
            }

            /* renamed from: com.google.android.gms.internal.firebase_ml.zzng$zzai$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
            public static final class C0010zza extends zzvx.zza<zza, C0010zza> implements zzxi {
                private C0010zza() {
                    super(zza.zzawa);
                }

                /* synthetic */ C0010zza(zznh zznh) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zznh.zzk[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0010zza(null);
                    case 3:
                        return zza(zzawa, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0007\u0001\u0003\u0007\u0002\u0004\u0007\u0003", new Object[]{"zzf", "zzavw", "zzavx", "zzavy", "zzavz"});
                    case 4:
                        return zzawa;
                    case 5:
                        zzxt<zza> zzxt = zzj;
                        if (zzxt == null) {
                            synchronized (zza.class) {
                                zzxt = zzj;
                                if (zzxt == null) {
                                    zzxt = new zzvx.zzc<>(zzawa);
                                    zzj = zzxt;
                                }
                            }
                        }
                        return zzxt;
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
                zzawa = zza;
                zzvx.zza(zza.class, super);
            }
        }

        private zzai() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzb extends zzvx.zza<zzai, zzb> implements zzxi {
            private zzb() {
                super(zzai.zzavv);
            }

            public final zzb zza(zzah.zzb zzb) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzai) this.zzcde).zza((zzah) ((zzvx) super.zztx()));
                return this;
            }

            /* synthetic */ zzb(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzah zzah) {
            zzah.getClass();
            this.zzavr = zzah;
            this.zzf |= 1;
        }

        public static zzb zzma() {
            return (zzb) zzavv.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzai();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzavv, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\u0007\u0003", new Object[]{"zzf", "zzavr", "zzavs", "zzavt", "zzavu"});
                case 4:
                    return zzavv;
                case 5:
                    zzxt<zzai> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzai.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzavv);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzai zzmb() {
            return zzavv;
        }

        static {
            zzai zzai = new zzai();
            zzavv = zzai;
            zzvx.zza(zzai.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzaj extends zzvx<zzaj, zzb> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzaj zzawe;
        private static volatile zzxt<zzaj> zzj;
        private int zzawb;
        private float zzawc;
        private int zzawd;
        private int zzf;

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zza implements zzwb {
            CATEGORY_UNKNOWN(0),
            CATEGORY_HOME_GOOD(1),
            CATEGORY_FASHION_GOOD(2),
            CATEGORY_ANIMAL(3),
            CATEGORY_FOOD(4),
            CATEGORY_PLACE(5),
            CATEGORY_PLANT(6);
            
            private static final zzwa<zza> zzt = new zzon();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zza zzbi(int i) {
                switch (i) {
                    case 0:
                        return CATEGORY_UNKNOWN;
                    case 1:
                        return CATEGORY_HOME_GOOD;
                    case 2:
                        return CATEGORY_FASHION_GOOD;
                    case 3:
                        return CATEGORY_ANIMAL;
                    case 4:
                        return CATEGORY_FOOD;
                    case 5:
                        return CATEGORY_PLACE;
                    case 6:
                        return CATEGORY_PLANT;
                    default:
                        return null;
                }
            }

            public static zzwd zzd() {
                return zzom.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zza(int i) {
                this.value = i;
            }
        }

        private zzaj() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzb extends zzvx.zza<zzaj, zzb> implements zzxi {
            private zzb() {
                super(zzaj.zzawe);
            }

            public final zzb zzb(zza zza) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaj) this.zzcde).zza(zza);
                return this;
            }

            public final zzb zzn(float f) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaj) this.zzcde).zzm(f);
                return this;
            }

            public final zzb zzbj(int i) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaj) this.zzcde).zzbh(i);
                return this;
            }

            /* synthetic */ zzb(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            this.zzawb = zza2.zzb();
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zzm(float f) {
            this.zzf |= 2;
            this.zzawc = f;
        }

        /* access modifiers changed from: private */
        public final void zzbh(int i) {
            this.zzf |= 4;
            this.zzawd = i;
        }

        public static zzb zzme() {
            return (zzb) zzawe.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzaj();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzawe, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u0001\u0001\u0003\u0004\u0002", new Object[]{"zzf", "zzawb", zza.zzd(), "zzawc", "zzawd"});
                case 4:
                    return zzawe;
                case 5:
                    zzxt<zzaj> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzaj.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzawe);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzaj zzaj = new zzaj();
            zzawe = zzaj;
            zzvx.zza(zzaj.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzak extends zzvx<zzak, zzc> implements zzxi {
        private static final zzwe<Integer, zza> zzaka = new zzoo();
        private static final zzwe<Integer, zzb> zzakc = new zzop();
        /* access modifiers changed from: private */
        public static final zzak zzawn;
        private static volatile zzxt<zzak> zzj;
        private zzac zzajn;
        private zzsl.zza zzajy;
        private zzwf zzajz = zzub();
        private zzwf zzakb = zzub();
        private zzad zzakw;
        private int zzf;

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zza implements zzwb {
            FORMAT_UNKNOWN(0),
            FORMAT_CODE_128(1),
            FORMAT_CODE_39(2),
            FORMAT_CODE_93(4),
            FORMAT_CODABAR(8),
            FORMAT_DATA_MATRIX(16),
            FORMAT_EAN_13(32),
            FORMAT_EAN_8(64),
            FORMAT_ITF(128),
            FORMAT_QR_CODE(256),
            FORMAT_UPC_A(512),
            FORMAT_UPC_E(1024),
            FORMAT_PDF417(2048),
            FORMAT_AZTEC(4096);
            
            private static final zzwa<zza> zzt = new zzor();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zza zzbk(int i) {
                if (i == 0) {
                    return FORMAT_UNKNOWN;
                }
                if (i == 1) {
                    return FORMAT_CODE_128;
                }
                if (i == 2) {
                    return FORMAT_CODE_39;
                }
                switch (i) {
                    case 4:
                        return FORMAT_CODE_93;
                    case 8:
                        return FORMAT_CODABAR;
                    case 16:
                        return FORMAT_DATA_MATRIX;
                    case 32:
                        return FORMAT_EAN_13;
                    case 64:
                        return FORMAT_EAN_8;
                    case 128:
                        return FORMAT_ITF;
                    case 256:
                        return FORMAT_QR_CODE;
                    case 512:
                        return FORMAT_UPC_A;
                    case 1024:
                        return FORMAT_UPC_E;
                    case 2048:
                        return FORMAT_PDF417;
                    case 4096:
                        return FORMAT_AZTEC;
                    default:
                        return null;
                }
            }

            public static zzwd zzd() {
                return zzoq.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zza(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zzb implements zzwb {
            TYPE_UNKNOWN(0),
            TYPE_CONTACT_INFO(1),
            TYPE_EMAIL(2),
            TYPE_ISBN(3),
            TYPE_PHONE(4),
            TYPE_PRODUCT(5),
            TYPE_SMS(6),
            TYPE_TEXT(7),
            TYPE_URL(8),
            TYPE_WIFI(9),
            TYPE_GEO(10),
            TYPE_CALENDAR_EVENT(11),
            TYPE_DRIVER_LICENSE(12);
            
            private static final zzwa<zzb> zzt = new zzos();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zzb zzbl(int i) {
                switch (i) {
                    case 0:
                        return TYPE_UNKNOWN;
                    case 1:
                        return TYPE_CONTACT_INFO;
                    case 2:
                        return TYPE_EMAIL;
                    case 3:
                        return TYPE_ISBN;
                    case 4:
                        return TYPE_PHONE;
                    case 5:
                        return TYPE_PRODUCT;
                    case 6:
                        return TYPE_SMS;
                    case 7:
                        return TYPE_TEXT;
                    case 8:
                        return TYPE_URL;
                    case 9:
                        return TYPE_WIFI;
                    case 10:
                        return TYPE_GEO;
                    case 11:
                        return TYPE_CALENDAR_EVENT;
                    case 12:
                        return TYPE_DRIVER_LICENSE;
                    default:
                        return null;
                }
            }

            public static zzwd zzd() {
                return zzot.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzb(int i) {
                this.value = i;
            }
        }

        private zzak() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zzc extends zzvx.zza<zzak, zzc> implements zzxi {
            private zzc() {
                super(zzak.zzawn);
            }

            public final zzc zzc(zzad.zza zza) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzak) this.zzcde).zza((zzad) ((zzvx) super.zztx()));
                return this;
            }

            public final zzc zzc(zzsl.zza zza) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzak) this.zzcde).zza(zza);
                return this;
            }

            public final zzc zzs(Iterable<? extends zza> iterable) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzak) this.zzcde).zzh(iterable);
                return this;
            }

            public final zzc zzt(Iterable<? extends zzb> iterable) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzak) this.zzcde).zzi(iterable);
                return this;
            }

            public final zzc zzi(zzac zzac) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzak) this.zzcde).zza(zzac);
                return this;
            }

            /* synthetic */ zzc(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzad zzad) {
            zzad.getClass();
            this.zzakw = zzad;
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(zzsl.zza zza2) {
            zza2.getClass();
            this.zzajy = zza2;
            this.zzf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zzh(Iterable<? extends zza> iterable) {
            if (!this.zzajz.zzso()) {
                this.zzajz = zzvx.zza(this.zzajz);
            }
            for (zza zzb2 : iterable) {
                this.zzajz.zzdo(zzb2.zzb());
            }
        }

        /* access modifiers changed from: private */
        public final void zzi(Iterable<? extends zzb> iterable) {
            if (!this.zzakb.zzso()) {
                this.zzakb = zzvx.zza(this.zzakb);
            }
            for (zzb zzb2 : iterable) {
                this.zzakb.zzdo(zzb2.zzb());
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzac zzac) {
            zzac.getClass();
            this.zzajn = zzac;
            this.zzf |= 4;
        }

        public static zzc zzmg() {
            return (zzc) zzawn.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzak();
                case 2:
                    return new zzc(null);
                case 3:
                    return zza(zzawn, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u001e\u0004\u001e\u0005\t\u0002", new Object[]{"zzf", "zzakw", "zzajy", "zzajz", zza.zzd(), "zzakb", zzb.zzd(), "zzajn"});
                case 4:
                    return zzawn;
                case 5:
                    zzxt<zzak> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzak.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzawn);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzak zzak = new zzak();
            zzawn = zzak;
            zzvx.zza(zzak.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzal extends zzvx<zzal, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzal zzaxs;
        private static volatile zzxt<zzal> zzj;
        private zzac zzajn;
        private zzaa zzakg;
        private int zzakh;
        private int zzaki;
        private zzad zzakw;
        private zzsl.zzb zzaxr;
        private int zzf;

        private zzal() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzal, zza> implements zzxi {
            private zza() {
                super(zzal.zzaxs);
            }

            public final zza zzd(zzad.zza zza) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzal) this.zzcde).zza((zzad) ((zzvx) super.zztx()));
                return this;
            }

            public final zza zzj(zzac zzac) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzal) this.zzcde).zza(zzac);
                return this;
            }

            public final zza zzc(zzaa zzaa) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzal) this.zzcde).zza(zzaa);
                return this;
            }

            public final zza zzbm(int i) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzal) this.zzcde).zzap(i);
                return this;
            }

            public final zza zzbn(int i) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzal) this.zzcde).zzaq(i);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzad zzad) {
            zzad.getClass();
            this.zzakw = zzad;
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(zzac zzac) {
            zzac.getClass();
            this.zzajn = zzac;
            this.zzf |= 4;
        }

        /* access modifiers changed from: private */
        public final void zza(zzaa zzaa) {
            zzaa.getClass();
            this.zzakg = zzaa;
            this.zzf |= 8;
        }

        /* access modifiers changed from: private */
        public final void zzap(int i) {
            this.zzf |= 16;
            this.zzakh = i;
        }

        /* access modifiers changed from: private */
        public final void zzaq(int i) {
            this.zzf |= 32;
            this.zzaki = i;
        }

        public static zza zzmi() {
            return (zza) zzaxs.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzal();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzaxs, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u000b\u0004\u0006\u000b\u0005", new Object[]{"zzf", "zzakw", "zzaxr", "zzajn", "zzakg", "zzakh", "zzaki"});
                case 4:
                    return zzaxs;
                case 5:
                    zzxt<zzal> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzal.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzaxs);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzal zzal = new zzal();
            zzaxs = zzal;
            zzvx.zza(zzal.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzam extends zzvx<zzam, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzam zzaxu;
        private static volatile zzxt<zzam> zzj;
        private zzac zzajn;
        private zzad zzakw;
        private zzan zzaxt;
        private int zzf;

        private zzam() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzam, zza> implements zzxi {
            private zza() {
                super(zzam.zzaxu);
            }

            public final zza zze(zzad.zza zza) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzam) this.zzcde).zza((zzad) ((zzvx) super.zztx()));
                return this;
            }

            public final zza zzc(zzan zzan) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzam) this.zzcde).zzd(zzan);
                return this;
            }

            public final zza zzk(zzac zzac) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzam) this.zzcde).zza(zzac);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzad zzad) {
            zzad.getClass();
            this.zzakw = zzad;
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zzd(zzan zzan) {
            zzan.getClass();
            this.zzaxt = zzan;
            this.zzf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zza(zzac zzac) {
            zzac.getClass();
            this.zzajn = zzac;
            this.zzf |= 4;
        }

        public static zza zzmk() {
            return (zza) zzaxu.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzam();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzaxu, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzf", "zzakw", "zzaxt", "zzajn"});
                case 4:
                    return zzaxu;
                case 5:
                    zzxt<zzam> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzam.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzaxu);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzam zzam = new zzam();
            zzaxu = zzam;
            zzvx.zza(zzam.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzan extends zzvx<zzan, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzan zzaxw;
        private static volatile zzxt<zzan> zzj;
        private float zzal;
        private int zzaxv;
        private int zzf;

        private zzan() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzan, zza> implements zzxi {
            private zza() {
                super(zzan.zzaxw);
            }

            public final zza zzo(float f) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzan) this.zzcde).zzp(f);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzp(float f) {
            this.zzf |= 2;
            this.zzal = f;
        }

        public static zza zzmm() {
            return (zza) zzaxw.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzan();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzaxw, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0000\u0002\u0001\u0001", new Object[]{"zzf", "zzaxv", "zzal"});
                case 4:
                    return zzaxw;
                case 5:
                    zzxt<zzan> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzan.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzaxw);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzan zzan = new zzan();
            zzaxw = zzan;
            zzvx.zza(zzan.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzap extends zzvx<zzap, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzap zzayh;
        private static volatile zzxt<zzap> zzj;
        private int zzajl;
        private zzaq zzakq;
        private int zzf;

        private zzap() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzap, zza> implements zzxi {
            private zza() {
                super(zzap.zzayh);
            }

            public final zza zzc(zzaq zzaq) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzap) this.zzcde).zza(zzaq);
                return this;
            }

            public final zza zzm(zznq zznq) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzap) this.zzcde).zza(zznq);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzaq zzaq) {
            zzaq.getClass();
            this.zzakq = zzaq;
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(zznq zznq) {
            this.zzajl = zznq.zzb();
            this.zzf |= 2;
        }

        public static zza zzms() {
            return (zza) zzayh.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzap();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzayh, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0000\u0002\f\u0001", new Object[]{"zzf", "zzakq", "zzajl", zznq.zzd()});
                case 4:
                    return zzayh;
                case 5:
                    zzxt<zzap> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzap.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzayh);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzap zzap = new zzap();
            zzayh = zzap;
            zzvx.zza(zzap.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzaq extends zzvx<zzaq, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzaq zzayl;
        private static volatile zzxt<zzaq> zzj;
        private int zzayi;
        private boolean zzayj;
        private boolean zzayk;
        private int zzf;

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zzb implements zzwb {
            MODE_UNSPECIFIED(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final zzwa<zzb> zzt = new zzou();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zzb zzbo(int i) {
                if (i == 0) {
                    return MODE_UNSPECIFIED;
                }
                if (i == 1) {
                    return STREAM;
                }
                if (i != 2) {
                    return null;
                }
                return SINGLE_IMAGE;
            }

            public static zzwd zzd() {
                return zzov.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzb(int i) {
                this.value = i;
            }
        }

        private zzaq() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzaq, zza> implements zzxi {
            private zza() {
                super(zzaq.zzayl);
            }

            public final zza zza(zzb zzb) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaq) this.zzcde).zzb(zzb);
                return this;
            }

            public final zza zzam(boolean z) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaq) this.zzcde).zzao(z);
                return this;
            }

            public final zza zzan(boolean z) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaq) this.zzcde).zzap(z);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzb(zzb zzb2) {
            this.zzayi = zzb2.zzb();
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zzao(boolean z) {
            this.zzf |= 2;
            this.zzayj = z;
        }

        /* access modifiers changed from: private */
        public final void zzap(boolean z) {
            this.zzf |= 4;
            this.zzayk = z;
        }

        public static zza zzmu() {
            return (zza) zzayl.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzaq();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzayl, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\u0007\u0002", new Object[]{"zzf", "zzayi", zzb.zzd(), "zzayj", "zzayk"});
                case 4:
                    return zzayl;
                case 5:
                    zzxt<zzaq> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzaq.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzayl);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzaq zzaq = new zzaq();
            zzayl = zzaq;
            zzvx.zza(zzaq.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzar extends zzvx<zzar, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzar zzayr;
        private static volatile zzxt<zzar> zzj;
        private zzac zzajn;
        private zzaq zzakq;
        private zzad zzakw;
        private zzwh<zzaj> zzayq = zzud();
        private int zzf;

        private zzar() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzar, zza> implements zzxi {
            private zza() {
                super(zzar.zzayr);
            }

            public final zza zzf(zzad.zza zza) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzar) this.zzcde).zza((zzad) ((zzvx) super.zztx()));
                return this;
            }

            public final zza zzl(zzac zzac) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzar) this.zzcde).zza(zzac);
                return this;
            }

            public final zza zzd(zzaq zzaq) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzar) this.zzcde).zza(zzaq);
                return this;
            }

            public final zza zzv(Iterable<? extends zzaj> iterable) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzar) this.zzcde).zzu(iterable);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzad zzad) {
            zzad.getClass();
            this.zzakw = zzad;
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(zzac zzac) {
            zzac.getClass();
            this.zzajn = zzac;
            this.zzf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zza(zzaq zzaq) {
            zzaq.getClass();
            this.zzakq = zzaq;
            this.zzf |= 4;
        }

        /* access modifiers changed from: private */
        public final void zzu(Iterable<? extends zzaj> iterable) {
            if (!this.zzayq.zzso()) {
                this.zzayq = zzvx.zza(this.zzayq);
            }
            zzug.zza(iterable, this.zzayq);
        }

        public static zza zzmw() {
            return (zza) zzayr.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzar();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzayr, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\u001b", new Object[]{"zzf", "zzakw", "zzajn", "zzakq", "zzayq", zzaj.class});
                case 4:
                    return zzayr;
                case 5:
                    zzxt<zzar> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzar.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzayr);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzar zzar = new zzar();
            zzayr = zzar;
            zzvx.zza(zzar.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzas extends zzvx<zzas, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzas zzays;
        private static volatile zzxt<zzas> zzj;
        private int zzajl;
        private zzaq zzakq;
        private int zzf;

        private zzas() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzas, zza> implements zzxi {
            private zza() {
                super(zzas.zzays);
            }

            public final zza zze(zzaq zzaq) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzas) this.zzcde).zza(zzaq);
                return this;
            }

            public final zza zzn(zznq zznq) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzas) this.zzcde).zza(zznq);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzaq zzaq) {
            zzaq.getClass();
            this.zzakq = zzaq;
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(zznq zznq) {
            this.zzajl = zznq.zzb();
            this.zzf |= 2;
        }

        public static zza zzmy() {
            return (zza) zzays.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzas();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzays, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0000\u0002\f\u0001", new Object[]{"zzf", "zzakq", "zzajl", zznq.zzd()});
                case 4:
                    return zzays;
                case 5:
                    zzxt<zzas> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzas.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzays);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzas zzas = new zzas();
            zzays = zzas;
            zzvx.zza(zzas.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzau extends zzvx<zzau, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzau zzazh;
        private static volatile zzxt<zzau> zzj;
        private zzac zzajn;
        private zzad zzakw;
        private int zzf;

        private zzau() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzau, zza> implements zzxi {
            private zza() {
                super(zzau.zzazh);
            }

            public final zza zzg(zzad.zza zza) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzau) this.zzcde).zza((zzad) ((zzvx) super.zztx()));
                return this;
            }

            public final zza zzm(zzac zzac) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzau) this.zzcde).zza(zzac);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzad zzad) {
            zzad.getClass();
            this.zzakw = zzad;
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(zzac zzac) {
            zzac.getClass();
            this.zzajn = zzac;
            this.zzf |= 2;
        }

        public static zza zznc() {
            return (zza) zzazh.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzau();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzazh, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001", new Object[]{"zzf", "zzakw", "zzajn"});
                case 4:
                    return zzazh;
                case 5:
                    zzxt<zzau> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzau.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzazh);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzau zznd() {
            return zzazh;
        }

        static {
            zzau zzau = new zzau();
            zzazh = zzau;
            zzvx.zza(zzau.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzaw extends zzvx<zzaw, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzaw zzbbi;
        private static volatile zzxt<zzaw> zzj;
        private String zzbaz = "";
        private String zzbba = "";
        private String zzbbb = "";
        private String zzbbc = "";
        private String zzbbd = "";
        private String zzbbe = "";
        private String zzbbf = "";
        private zzwh<String> zzbbg = zzvx.zzud();
        private String zzbbh = "";
        private int zzf;

        private zzaw() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzaw, zza> implements zzxi {
            private zza() {
                super(zzaw.zzbbi);
            }

            public final zza zzbo(String str) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaw) this.zzcde).zzbh(str);
                return this;
            }

            public final zza zzbp(String str) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaw) this.zzcde).zzbi(str);
                return this;
            }

            public final zza zzbq(String str) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaw) this.zzcde).zzbj(str);
                return this;
            }

            public final zza zzbr(String str) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaw) this.zzcde).zzbk(str);
                return this;
            }

            public final zza zzbs(String str) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaw) this.zzcde).zzbl(str);
                return this;
            }

            public final zza zzbt(String str) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaw) this.zzcde).zzbm(str);
                return this;
            }

            public final zza zzbu(String str) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaw) this.zzcde).zzbn(str);
                return this;
            }

            public final zza zzx(Iterable<String> iterable) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzaw) this.zzcde).zzw(iterable);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzbh(String str) {
            str.getClass();
            this.zzf |= 1;
            this.zzbaz = str;
        }

        /* access modifiers changed from: private */
        public final void zzbi(String str) {
            str.getClass();
            this.zzf |= 2;
            this.zzbba = str;
        }

        /* access modifiers changed from: private */
        public final void zzbj(String str) {
            str.getClass();
            this.zzf |= 4;
            this.zzbbb = str;
        }

        /* access modifiers changed from: private */
        public final void zzbk(String str) {
            str.getClass();
            this.zzf |= 8;
            this.zzbbc = str;
        }

        public final String zzng() {
            return this.zzbbd;
        }

        /* access modifiers changed from: private */
        public final void zzbl(String str) {
            str.getClass();
            this.zzf |= 16;
            this.zzbbd = str;
        }

        /* access modifiers changed from: private */
        public final void zzbm(String str) {
            str.getClass();
            this.zzf |= 32;
            this.zzbbe = str;
        }

        /* access modifiers changed from: private */
        public final void zzbn(String str) {
            str.getClass();
            this.zzf |= 64;
            this.zzbbf = str;
        }

        /* access modifiers changed from: private */
        public final void zzw(Iterable<String> iterable) {
            if (!this.zzbbg.zzso()) {
                this.zzbbg = zzvx.zza(this.zzbbg);
            }
            zzug.zza(iterable, this.zzbbg);
        }

        public static zza zznh() {
            return (zza) zzbbi.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzaw();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzbbi, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u001a\t\b\u0007", new Object[]{"zzf", "zzbaz", "zzbba", "zzbbb", "zzbbc", "zzbbd", "zzbbe", "zzbbf", "zzbbg", "zzbbh"});
                case 4:
                    return zzbbi;
                case 5:
                    zzxt<zzaw> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzaw.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzbbi);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzaw zzni() {
            return zzbbi;
        }

        static {
            zzaw zzaw = new zzaw();
            zzbbi = zzaw;
            zzvx.zza(zzaw.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzh extends zzvx<zzh, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzh zzakv;
        private static volatile zzxt<zzh> zzj;
        private int zzajl;
        private int zzf;

        private zzh() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzh, zza> implements zzxi {
            private zza() {
                super(zzh.zzakv);
            }

            public final zza zzi(zznq zznq) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzh) this.zzcde).zza(zznq);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zznq zznq) {
            this.zzajl = zznq.zzb();
            this.zzf |= 1;
        }

        public static zza zzki() {
            return (zza) zzakv.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzakv, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"zzf", "zzajl", zznq.zzd()});
                case 4:
                    return zzakv;
                case 5:
                    zzxt<zzh> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzh.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzakv);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
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
            zzakv = zzh;
            zzvx.zza(zzh.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzi extends zzvx<zzi, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzi zzaky;
        private static volatile zzxt<zzi> zzj;
        private zzac zzajn;
        private zzai zzajo;
        private zzad zzakw;
        private long zzakx;
        private float zzal;
        private int zzf;

        private zzi() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzi, zza> implements zzxi {
            private zza() {
                super(zzi.zzaky);
            }

            public final zza zza(zzad.zza zza) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzi) this.zzcde).zza((zzad) ((zzvx) super.zztx()));
                return this;
            }

            public final zza zzd(zzai zzai) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzi) this.zzcde).zza(zzai);
                return this;
            }

            public final zza zzh(zzac zzac) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzi) this.zzcde).zza(zzac);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzad zzad) {
            zzad.getClass();
            this.zzakw = zzad;
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(zzai zzai) {
            zzai.getClass();
            this.zzajo = zzai;
            this.zzf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zza(zzac zzac) {
            zzac.getClass();
            this.zzajn = zzac;
            this.zzf |= 16;
        }

        public static zza zzkk() {
            return (zza) zzaky.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzaky, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u0003\u0002\u0004\u0001\u0003\u0005\t\u0004", new Object[]{"zzf", "zzakw", "zzajo", "zzakx", "zzal", "zzajn"});
                case 4:
                    return zzaky;
                case 5:
                    zzxt<zzi> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzi.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzaky);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
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
            zzaky = zzi;
            zzvx.zza(zzi.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzj extends zzvx<zzj, zza> implements zzxi {
        private static final zzwe<Integer, zznq> zzalc = new zznk();
        /* access modifiers changed from: private */
        public static final zzj zzald;
        private static volatile zzxt<zzj> zzj;
        private long zzakx;
        private zzai zzakz;
        private zzai zzala;
        private zzwf zzalb = zzub();
        private int zzf;

        private zzj() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzj, zza> implements zzxi {
            private zza() {
                super(zzj.zzald);
            }

            public final zza zze(zzai zzai) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzj) this.zzcde).zzb(zzai);
                return this;
            }

            public final zza zzf(zzai zzai) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzj) this.zzcde).zzc(zzai);
                return this;
            }

            public final zza zzm(Iterable<? extends zznq> iterable) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzj) this.zzcde).zzl(iterable);
                return this;
            }

            public final zza zzg(long j) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzj) this.zzcde).zzf(j);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzb(zzai zzai) {
            zzai.getClass();
            this.zzakz = zzai;
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zzc(zzai zzai) {
            zzai.getClass();
            this.zzala = zzai;
            this.zzf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zzl(Iterable<? extends zznq> iterable) {
            if (!this.zzalb.zzso()) {
                this.zzalb = zzvx.zza(this.zzalb);
            }
            for (zznq zzb : iterable) {
                this.zzalb.zzdo(zzb.zzb());
            }
        }

        /* access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzf |= 4;
            this.zzakx = j;
        }

        public static zza zzkm() {
            return (zza) zzald.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzald, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u001e\u0004\u0003\u0002", new Object[]{"zzf", "zzakz", "zzala", "zzalb", zznq.zzd(), "zzakx"});
                case 4:
                    return zzald;
                case 5:
                    zzxt<zzj> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzj.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzald);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzj zzj2 = new zzj();
            zzald = zzj2;
            zzvx.zza(zzj.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzv extends zzvx<zzv, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzv zzalv;
        private static volatile zzxt<zzv> zzj;
        private int zzajl;
        private zzai zzajo;
        private int zzf;

        private zzv() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzv, zza> implements zzxi {
            private zza() {
                super(zzv.zzalv);
            }

            public final zza zzg(zzai zzai) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzv) this.zzcde).zza(zzai);
                return this;
            }

            public final zza zzj(zznq zznq) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzv) this.zzcde).zza(zznq);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzai zzai) {
            zzai.getClass();
            this.zzajo = zzai;
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(zznq zznq) {
            this.zzajl = zznq.zzb();
            this.zzf |= 2;
        }

        public static zza zzkz() {
            return (zza) zzalv.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzalv, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0000\u0002\f\u0001", new Object[]{"zzf", "zzajo", "zzajl", zznq.zzd()});
                case 4:
                    return zzalv;
                case 5:
                    zzxt<zzv> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzv.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzalv);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzv zzv = new zzv();
            zzalv = zzv;
            zzvx.zza(zzv.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzx extends zzvx<zzx, zza> implements zzxi {
        private static final zzwe<Integer, zznq> zzalc = new zznp();
        /* access modifiers changed from: private */
        public static final zzx zzamh;
        private static volatile zzxt<zzx> zzj;
        private long zzakx;
        private zzai zzakz;
        private zzai zzala;
        private zzwf zzalb = zzub();
        private boolean zzamg;
        private int zzf;

        private zzx() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzx, zza> implements zzxi {
            private zza() {
                super(zzx.zzamh);
            }

            public final zza zzi(zzai zzai) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzx) this.zzcde).zzb(zzai);
                return this;
            }

            public final zza zzj(zzai zzai) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzx) this.zzcde).zzc(zzai);
                return this;
            }

            public final zza zzr(Iterable<? extends zznq> iterable) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzx) this.zzcde).zzl(iterable);
                return this;
            }

            public final zza zzi(long j) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzx) this.zzcde).zzf(j);
                return this;
            }

            public final zza zzy(boolean z) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzx) this.zzcde).zzw(z);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzb(zzai zzai) {
            zzai.getClass();
            this.zzakz = zzai;
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zzc(zzai zzai) {
            zzai.getClass();
            this.zzala = zzai;
            this.zzf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zzl(Iterable<? extends zznq> iterable) {
            if (!this.zzalb.zzso()) {
                this.zzalb = zzvx.zza(this.zzalb);
            }
            for (zznq zzb : iterable) {
                this.zzalb.zzdo(zzb.zzb());
            }
        }

        /* access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzf |= 4;
            this.zzakx = j;
        }

        /* access modifiers changed from: private */
        public final void zzw(boolean z) {
            this.zzf |= 8;
            this.zzamg = z;
        }

        public static zza zzlf() {
            return (zza) zzamh.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzx();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzamh, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u001e\u0004\u0003\u0002\u0005\u0007\u0003", new Object[]{"zzf", "zzakz", "zzala", "zzalb", zznq.zzd(), "zzakx", "zzamg"});
                case 4:
                    return zzamh;
                case 5:
                    zzxt<zzx> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzx.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzamh);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzx zzx = new zzx();
            zzamh = zzx;
            zzvx.zza(zzx.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzy extends zzvx<zzy, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzy zzamj;
        private static volatile zzxt<zzy> zzj;
        private int zzalg;
        private boolean zzami;
        private int zzf;

        private zzy() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzy, zza> implements zzxi {
            private zza() {
                super(zzy.zzamj);
            }

            public final zza zzb(zzah.zza zza) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzy) this.zzcde).zza(zza);
                return this;
            }

            public final zza zzz(boolean z) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zzy) this.zzcde).zzx(z);
                return this;
            }

            /* synthetic */ zza(zznh zznh) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzah.zza zza2) {
            this.zzalg = zza2.zzb();
            this.zzf |= 1;
        }

        /* access modifiers changed from: private */
        public final void zzx(boolean z) {
            this.zzf |= 2;
            this.zzami = z;
        }

        public static zza zzlh() {
            return (zza) zzamj.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zznh.zzk[i - 1]) {
                case 1:
                    return new zzy();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzamj, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001", new Object[]{"zzf", "zzalg", zzah.zza.zzd(), "zzami"});
                case 4:
                    return zzamj;
                case 5:
                    zzxt<zzy> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzy.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzamj);
                                zzj = zzxt;
                            }
                        }
                    }
                    return zzxt;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzy zzy = new zzy();
            zzamj = zzy;
            zzvx.zza(zzy.class, super);
        }
    }
}
