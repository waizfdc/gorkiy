package com.google.android.gms.internal.firebase_ml;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzyy {
    private static final Logger logger = Logger.getLogger(zzyy.class.getName());
    private static final Class<?> zzbza = zzun.zzss();
    private static final boolean zzbzv = zzwi();
    private static final Unsafe zzcfs = zzwh();
    private static final boolean zzcia = zzq(Long.TYPE);
    private static final boolean zzcib = zzq(Integer.TYPE);
    private static final zzd zzcic;
    private static final boolean zzcid = zzwj();
    private static final long zzcie = ((long) zzo(byte[].class));
    private static final long zzcif;
    private static final long zzcig;
    private static final long zzcih;
    private static final long zzcii;
    private static final long zzcij;
    private static final long zzcik;
    private static final long zzcil;
    private static final long zzcim;
    private static final long zzcin;
    private static final long zzcio;
    private static final long zzcip = ((long) zzo(Object[].class));
    private static final long zzciq = ((long) zzp(Object[].class));
    private static final long zzcir;
    private static final int zzcis = ((int) (zzcie & 7));
    static final boolean zzcit = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    private zzyy() {
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zzyy.zzcit) {
                return zzyy.zzq(obj, j);
            }
            return zzyy.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzyy.zzcit) {
                zzyy.zza(obj, j, b);
            } else {
                zzyy.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzyy.zzcit) {
                return zzyy.zzs(obj, j);
            }
            return zzyy.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzyy.zzcit) {
                zzyy.zzb(obj, j, z);
            } else {
                zzyy.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzciw.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzciw.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzciw.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzciw.putBoolean(obj, j, z);
        }

        public final float zzn(Object obj, long j) {
            return this.zzciw.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzciw.putFloat(obj, j, f);
        }

        public final double zzo(Object obj, long j) {
            return this.zzciw.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzciw.putDouble(obj, j, d);
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zzyy.zzcit) {
                return zzyy.zzq(obj, j);
            }
            return zzyy.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzyy.zzcit) {
                zzyy.zza(obj, j, b);
            } else {
                zzyy.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzyy.zzcit) {
                return zzyy.zzs(obj, j);
            }
            return zzyy.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzyy.zzcit) {
                zzyy.zzb(obj, j, z);
            } else {
                zzyy.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static boolean zzwf() {
        return zzbzv;
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    static abstract class zzd {
        Unsafe zzciw;

        zzd(Unsafe unsafe) {
            this.zzciw = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzciw.getInt(obj, j);
        }

        public final void zza(Object obj, long j, int i) {
            this.zzciw.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzciw.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzciw.putLong(obj, j, j2);
        }
    }

    static boolean zzwg() {
        return zzcid;
    }

    static <T> T zzn(Class<T> cls) {
        try {
            return zzcfs.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzo(Class<?> cls) {
        if (zzbzv) {
            return zzcic.zzciw.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzp(Class<?> cls) {
        if (zzbzv) {
            return zzcic.zzciw.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzcic.zzk(obj, j);
    }

    static void zza(Object obj, long j, int i) {
        zzcic.zza(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzcic.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzcic.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzcic.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzcic.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzcic.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzcic.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzcic.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzcic.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzcic.zzciw.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzcic.zzciw.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzcic.zzy(bArr, zzcie + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzcic.zze(bArr, zzcie + j, b);
    }

    static Unsafe zzwh() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzza());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzwi() {
        Unsafe unsafe = zzcfs;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzun.zzsr()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzwj() {
        Unsafe unsafe = zzcfs;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzwk() == null) {
                return false;
            }
            if (zzun.zzsr()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzq(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzun.zzsr()) {
            return false;
        }
        try {
            Class<?> cls3 = zzbza;
            cls3.getMethod("peekLong", cls, Boolean.TYPE);
            cls3.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls3.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls3.getMethod("peekInt", cls, Boolean.TYPE);
            cls3.getMethod("pokeByte", cls, Byte.TYPE);
            cls3.getMethod("peekByte", cls);
            cls3.getMethod("pokeByteArray", cls, cls2, Integer.TYPE, Integer.TYPE);
            cls3.getMethod("peekByteArray", cls, cls2, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field zzwk() {
        Field zzb2;
        if (zzun.zzsr() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzk = zzk(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzk & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    static {
        zzd zzd2;
        Class<double[]> cls = double[].class;
        Class<float[]> cls2 = float[].class;
        Class<long[]> cls3 = long[].class;
        Class<int[]> cls4 = int[].class;
        Class<boolean[]> cls5 = boolean[].class;
        zzd zzd3 = null;
        if (zzcfs != null) {
            if (!zzun.zzsr()) {
                zzd3 = new zzb(zzcfs);
            } else if (zzcia) {
                zzd3 = new zzc(zzcfs);
            } else if (zzcib) {
                zzd3 = new zza(zzcfs);
            }
        }
        zzcic = zzd3;
        zzcif = (long) zzo(cls5);
        zzcig = (long) zzp(cls5);
        zzcih = (long) zzo(cls4);
        zzcii = (long) zzp(cls4);
        zzcij = (long) zzo(cls3);
        zzcik = (long) zzp(cls3);
        zzcil = (long) zzo(cls2);
        zzcim = (long) zzp(cls2);
        zzcin = (long) zzo(cls);
        zzcio = (long) zzp(cls);
        Field zzwk = zzwk();
        zzcir = (zzwk == null || (zzd2 = zzcic) == null) ? -1 : zzd2.zzciw.objectFieldOffset(zzwk);
    }
}
