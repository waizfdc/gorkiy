package com.google.android.gms.internal.fitness;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzja {
    private static final Logger logger = Logger.getLogger(zzja.class.getName());
    private static final long zzaaa;
    private static final int zzaab = ((int) (zzzn & 7));
    static final boolean zzaac = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);
    private static final Class<?> zzrf = zzfd.zzao();
    private static final boolean zzrt = zzdi();
    private static final Unsafe zzxr = zzdh();
    private static final boolean zzzj = zzj(Long.TYPE);
    private static final boolean zzzk = zzj(Integer.TYPE);
    private static final zzc zzzl;
    private static final boolean zzzm = zzdj();
    private static final long zzzn = ((long) zzh(byte[].class));
    private static final long zzzo;
    private static final long zzzp;
    private static final long zzzq;
    private static final long zzzr;
    private static final long zzzs;
    private static final long zzzt;
    private static final long zzzu;
    private static final long zzzv;
    private static final long zzzw;
    private static final long zzzx;
    private static final long zzzy = ((long) zzh(Object[].class));
    private static final long zzzz = ((long) zzi(Object[].class));

    private zzja() {
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    static final class zza extends zzc {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            if (zzja.zzaac) {
                return zzja.zzp(obj, j);
            }
            return zzja.zzq(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzja.zzaac) {
                zzja.zza(obj, j, b);
            } else {
                zzja.zzb(obj, j, b);
            }
        }

        public final boolean zzl(Object obj, long j) {
            if (zzja.zzaac) {
                return zzja.zzr(obj, j);
            }
            return zzja.zzs(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzja.zzaac) {
                zzja.zzb(obj, j, z);
            } else {
                zzja.zzc(obj, j, z);
            }
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    static final class zzb extends zzc {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            if (zzja.zzaac) {
                return zzja.zzp(obj, j);
            }
            return zzja.zzq(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzja.zzaac) {
                zzja.zza(obj, j, b);
            } else {
                zzja.zzb(obj, j, b);
            }
        }

        public final boolean zzl(Object obj, long j) {
            if (zzja.zzaac) {
                return zzja.zzr(obj, j);
            }
            return zzja.zzs(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzja.zzaac) {
                zzja.zzb(obj, j, z);
            } else {
                zzja.zzc(obj, j, z);
            }
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    static final class zzd extends zzc {
        zzd(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            return this.zzaad.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzaad.putByte(obj, j, b);
        }

        public final boolean zzl(Object obj, long j) {
            return this.zzaad.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzaad.putBoolean(obj, j, z);
        }

        public final float zzm(Object obj, long j) {
            return this.zzaad.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzaad.putFloat(obj, j, f);
        }

        public final double zzn(Object obj, long j) {
            return this.zzaad.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzaad.putDouble(obj, j, d);
        }
    }

    static boolean zzdf() {
        return zzrt;
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    static abstract class zzc {
        Unsafe zzaad;

        zzc(Unsafe unsafe) {
            this.zzaad = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzl(Object obj, long j);

        public abstract float zzm(Object obj, long j);

        public abstract double zzn(Object obj, long j);

        public abstract byte zzx(Object obj, long j);

        public final int zzj(Object obj, long j) {
            return this.zzaad.getInt(obj, j);
        }

        public final void zza(Object obj, long j, int i) {
            this.zzaad.putInt(obj, j, i);
        }

        public final long zzk(Object obj, long j) {
            return this.zzaad.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzaad.putLong(obj, j, j2);
        }
    }

    static boolean zzdg() {
        return zzzm;
    }

    static <T> T zzg(Class<T> cls) {
        try {
            return zzxr.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzh(Class<?> cls) {
        if (zzrt) {
            return zzzl.zzaad.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzi(Class<?> cls) {
        if (zzrt) {
            return zzzl.zzaad.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzj(Object obj, long j) {
        return zzzl.zzj(obj, j);
    }

    static void zza(Object obj, long j, int i) {
        zzzl.zza(obj, j, i);
    }

    static long zzk(Object obj, long j) {
        return zzzl.zzk(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzzl.zza(obj, j, j2);
    }

    static boolean zzl(Object obj, long j) {
        return zzzl.zzl(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzzl.zza(obj, j, z);
    }

    static float zzm(Object obj, long j) {
        return zzzl.zzm(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzzl.zza(obj, j, f);
    }

    static double zzn(Object obj, long j) {
        return zzzl.zzn(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzzl.zza(obj, j, d);
    }

    static Object zzo(Object obj, long j) {
        return zzzl.zzaad.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzzl.zzaad.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzzl.zzx(bArr, zzzn + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzzl.zze(bArr, zzzn + j, b);
    }

    static Unsafe zzdh() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zziz());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzdi() {
        Unsafe unsafe = zzxr;
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
            if (zzfd.zzan()) {
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

    private static boolean zzdj() {
        Unsafe unsafe = zzxr;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzdk() == null) {
                return false;
            }
            if (zzfd.zzan()) {
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

    private static boolean zzj(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzfd.zzan()) {
            return false;
        }
        try {
            Class<?> cls3 = zzrf;
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

    private static Field zzdk() {
        Field zzb2;
        if (zzfd.zzan() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
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
    public static byte zzp(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzj = zzj(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj(obj, j2) & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static boolean zzr(Object obj, long j) {
        return zzp(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
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
        zzc zzc2;
        Class<double[]> cls = double[].class;
        Class<float[]> cls2 = float[].class;
        Class<long[]> cls3 = long[].class;
        Class<int[]> cls4 = int[].class;
        Class<boolean[]> cls5 = boolean[].class;
        zzc zzc3 = null;
        if (zzxr != null) {
            if (!zzfd.zzan()) {
                zzc3 = new zzd(zzxr);
            } else if (zzzj) {
                zzc3 = new zza(zzxr);
            } else if (zzzk) {
                zzc3 = new zzb(zzxr);
            }
        }
        zzzl = zzc3;
        zzzo = (long) zzh(cls5);
        zzzp = (long) zzi(cls5);
        zzzq = (long) zzh(cls4);
        zzzr = (long) zzi(cls4);
        zzzs = (long) zzh(cls3);
        zzzt = (long) zzi(cls3);
        zzzu = (long) zzh(cls2);
        zzzv = (long) zzi(cls2);
        zzzw = (long) zzh(cls);
        zzzx = (long) zzi(cls);
        Field zzdk = zzdk();
        zzaaa = (zzdk == null || (zzc2 = zzzl) == null) ? -1 : zzc2.zzaad.objectFieldOffset(zzdk);
    }
}
