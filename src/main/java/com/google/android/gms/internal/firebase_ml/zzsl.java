package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzvx;
import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzsl {

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzb extends zzvx<zzb, zza> implements zzxi {
        /* access modifiers changed from: private */
        public static final zzb zzbps;
        private static volatile zzxt<zzb> zzj;
        private float zzarf;
        private int zzbpo;
        private int zzbpp;
        private boolean zzbpq;
        private boolean zzbpr;
        private int zzf;
        private int zzmy;

        /* renamed from: com.google.android.gms.internal.firebase_ml.zzsl$zzb$zzb  reason: collision with other inner class name */
        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum C0020zzb implements zzwb {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);
            
            private static final zzwa<C0020zzb> zzt = new zzsp();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static C0020zzb zzcc(int i) {
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

            public static zzwd zzd() {
                return zzsq.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private C0020zzb(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public enum zzc implements zzwb {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);
            
            private static final zzwa<zzc> zzt = new zzss();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zzc zzcd(int i) {
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

            public static zzwd zzd() {
                return zzsr.zzae;
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
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);
            
            private static final zzwa<zzd> zzt = new zzst();
            private final int value;

            public final int zzb() {
                return this.value;
            }

            public static zzd zzce(int i) {
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

            public static zzwd zzd() {
                return zzsv.zzae;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + ((char) Typography.greater);
            }

            private zzd(int i) {
                this.value = i;
            }
        }

        private zzb() {
        }

        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class zza extends zzvx.zza<zzb, zza> implements zzxi {
            private zza() {
                super(zzb.zzbps);
            }

            /* synthetic */ zza(zzsn zzsn) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzsn.zzk[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzbps, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\f\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u0001\u0005", new Object[]{"zzf", "zzmy", zzd.zzd(), "zzbpo", zzc.zzd(), "zzbpp", C0020zzb.zzd(), "zzbpq", "zzbpr", "zzarf"});
                case 4:
                    return zzbps;
                case 5:
                    zzxt<zzb> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zzb.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzbps);
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
            zzbps = zzb;
            zzvx.zza(zzb.class, super);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zza extends zzvx<zza, C0019zza> implements zzxi {
        private static final zzwe<Integer, zzuf> zzbpm = new zzso();
        /* access modifiers changed from: private */
        public static final zza zzbpn;
        private static volatile zzxt<zza> zzj;
        private zzwf zzbpl = zzub();

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_ml.zzsl$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
        public static final class C0019zza extends zzvx.zza<zza, C0019zza> implements zzxi {
            private C0019zza() {
                super(zza.zzbpn);
            }

            public final C0019zza zzz(Iterable<? extends zzuf> iterable) {
                if (super.zzcdf) {
                    zztt();
                    super.zzcdf = false;
                }
                ((zza) this.zzcde).zzy(iterable);
                return this;
            }

            /* synthetic */ C0019zza(zzsn zzsn) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzy(Iterable<? extends zzuf> iterable) {
            if (!this.zzbpl.zzso()) {
                this.zzbpl = zzvx.zza(this.zzbpl);
            }
            for (zzuf zzb : iterable) {
                this.zzbpl.zzdo(zzb.zzb());
            }
        }

        public static C0019zza zzqz() {
            return (C0019zza) zzbpn.zztz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzsn.zzk[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0019zza(null);
                case 3:
                    return zza(zzbpn, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzbpl", zzuf.zzd()});
                case 4:
                    return zzbpn;
                case 5:
                    zzxt<zza> zzxt = zzj;
                    if (zzxt == null) {
                        synchronized (zza.class) {
                            zzxt = zzj;
                            if (zzxt == null) {
                                zzxt = new zzvx.zzc<>(zzbpn);
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
            zzbpn = zza;
            zzvx.zza(zza.class, super);
        }
    }
}
