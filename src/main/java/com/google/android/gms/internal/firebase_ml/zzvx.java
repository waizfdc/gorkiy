package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzvx;
import com.google.android.gms.internal.firebase_ml.zzvx.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public abstract class zzvx<MessageType extends zzvx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzug<MessageType, BuilderType> {
    private static Map<Object, zzvx<?, ?>> zzcdi = new ConcurrentHashMap();
    protected zzyv zzcdg = zzyv.zzwc();
    private int zzcdh = -1;

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static class zzc<T extends zzvx<T, ?>> extends zzul<T> {
        private final T zzcdd;

        public zzc(T t) {
            this.zzcdd = t;
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    static final class zzd implements zzvs<zzd> {
        public final int zzb() {
            throw new NoSuchMethodError();
        }

        public final zzzj zztn() {
            throw new NoSuchMethodError();
        }

        public final zzzm zzto() {
            throw new NoSuchMethodError();
        }

        public final boolean zztp() {
            throw new NoSuchMethodError();
        }

        public final boolean zztq() {
            throw new NoSuchMethodError();
        }

        public final zzxj zza(zzxj zzxj, zzxg zzxg) {
            throw new NoSuchMethodError();
        }

        public final zzxp zza(zzxp zzxp, zzxp zzxp2) {
            throw new NoSuchMethodError();
        }

        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static final class zzf {
        public static final int zzcdk = 1;
        public static final int zzcdl = 2;
        public static final int zzcdm = 3;
        public static final int zzcdn = 4;
        public static final int zzcdo = 5;
        public static final int zzcdp = 6;
        public static final int zzcdq = 7;
        private static final /* synthetic */ int[] zzcdr = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzcds = 1;
        public static final int zzcdt = 2;
        private static final /* synthetic */ int[] zzcdu = {1, 2};
        public static final int zzcdv = 1;
        public static final int zzcdw = 2;
        private static final /* synthetic */ int[] zzcdx = {1, 2};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzcdr.clone();
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static class zzg<ContainingType extends zzxg, Type> extends zzvl<ContainingType, Type> {
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static abstract class zzb<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzxi {
        protected zzb(MessageType messagetype) {
            super(messagetype);
        }

        /* access modifiers changed from: protected */
        public void zztt() {
            super.zztt();
            ((zze) this.zzcde).zzcdj = (zzvq) ((zze) this.zzcde).zzcdj.clone();
        }

        public /* synthetic */ zzvx zztu() {
            return (zze) zztw();
        }

        public /* synthetic */ zzxg zztw() {
            if (this.zzcdf) {
                return (zze) this.zzcde;
            }
            ((zze) this.zzcde).zzcdj.zzsp();
            return (zze) super.zztw();
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static abstract class zze<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzvx<MessageType, BuilderType> implements zzxi {
        protected zzvq<zzd> zzcdj = zzvq.zztl();

        /* access modifiers changed from: package-private */
        public final zzvq<zzd> zzug() {
            if (this.zzcdj.isImmutable()) {
                this.zzcdj = (zzvq) this.zzcdj.clone();
            }
            return this.zzcdj;
        }
    }

    public String toString() {
        return zzxl.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzbyw != 0) {
            return this.zzbyw;
        }
        this.zzbyw = zzxv.zzvk().zzad(this).hashCode(this);
        return this.zzbyw;
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
    public static abstract class zza<MessageType extends zzvx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzuj<MessageType, BuilderType> {
        private final MessageType zzcdd;
        protected MessageType zzcde;
        protected boolean zzcdf = false;

        protected zza(MessageType messagetype) {
            this.zzcdd = messagetype;
            this.zzcde = (zzvx) messagetype.zza(zzf.zzcdn, null, null);
        }

        /* access modifiers changed from: protected */
        public void zztt() {
            MessageType messagetype = (zzvx) this.zzcde.zza(zzf.zzcdn, null, null);
            zza(messagetype, this.zzcde);
            this.zzcde = messagetype;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.internal.firebase_ml.zzvx.zza(com.google.android.gms.internal.firebase_ml.zzvx, boolean):boolean
         arg types: [MessageType, int]
         candidates:
          com.google.android.gms.internal.firebase_ml.zzvx.zza(java.lang.Class, com.google.android.gms.internal.firebase_ml.zzvx):void
          com.google.android.gms.internal.firebase_ml.zzug.zza(java.lang.Iterable, java.util.List):void
          com.google.android.gms.internal.firebase_ml.zzvx.zza(com.google.android.gms.internal.firebase_ml.zzvx, boolean):boolean */
        public final boolean isInitialized() {
            return zzvx.zza((zzvx) this.zzcde, false);
        }

        /* renamed from: zztu */
        public MessageType zztw() {
            if (this.zzcdf) {
                return this.zzcde;
            }
            MessageType messagetype = this.zzcde;
            zzxv.zzvk().zzad(messagetype).zzq(messagetype);
            this.zzcdf = true;
            return this.zzcde;
        }

        /* renamed from: zztv */
        public final MessageType zztx() {
            MessageType messagetype = (zzvx) zztw();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzyt(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzcdf) {
                zztt();
                this.zzcdf = false;
            }
            zza(this.zzcde, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzxv.zzvk().zzad(messagetype).zze(messagetype, messagetype2);
        }

        public final /* synthetic */ zzuj zzsn() {
            return (zza) clone();
        }

        public final /* synthetic */ zzxg zzty() {
            return this.zzcdd;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) ((zzvx) this.zzcdd).zza(zzf.zzcdo, (Object) null, (Object) null);
            zza.zza((zzvx) zztw());
            return zza;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzvx) zza(zzf.zzcdp, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzxv.zzvk().zzad(this).equals(this, (zzvx) obj);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzvx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zztz() {
        return (zza) zza(zzf.zzcdo, (Object) null, (Object) null);
    }

    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    /* access modifiers changed from: package-private */
    public final int zzsl() {
        return this.zzcdh;
    }

    /* access modifiers changed from: package-private */
    public final void zzco(int i) {
        this.zzcdh = i;
    }

    public final void zzb(zzvh zzvh) throws IOException {
        zzxv.zzvk().zzad(this).zza(this, zzvj.zza(zzvh));
    }

    public final int zzua() {
        if (this.zzcdh == -1) {
            this.zzcdh = zzxv.zzvk().zzad(this).zzaa(this);
        }
        return this.zzcdh;
    }

    static <T extends zzvx<?, ?>> T zzj(Class<T> cls) {
        T t = (zzvx) zzcdi.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzvx) zzcdi.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzvx) ((zzvx) zzyy.zzn(cls)).zza(zzf.zzcdp, (Object) null, (Object) null);
            if (t != null) {
                zzcdi.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzvx<?, ?>> void zza(Class cls, zzvx zzvx) {
        zzcdi.put(cls, zzvx);
    }

    protected static Object zza(zzxg zzxg, String str, Object[] objArr) {
        return new zzxx(zzxg, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzvx<T, ?>> boolean zza(zzvx zzvx, boolean z) {
        byte byteValue = ((Byte) zzvx.zza(zzf.zzcdk, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzac = zzxv.zzvk().zzad(zzvx).zzac(zzvx);
        if (z) {
            zzvx.zza(zzf.zzcdl, zzac ? zzvx : null, (Object) null);
        }
        return zzac;
    }

    protected static zzwf zzub() {
        return zzvz.zzuh();
    }

    protected static zzwf zza(zzwf zzwf) {
        int size = zzwf.size();
        return zzwf.zzdn(size == 0 ? 10 : size << 1);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.firebase_ml.zzwc, com.google.android.gms.internal.firebase_ml.zzvw] */
    protected static zzwc zzuc() {
        return zzvw.zzts();
    }

    protected static <E> zzwh<E> zzud() {
        return zzxu.zzvj();
    }

    protected static <E> zzwh<E> zza(zzwh zzwh) {
        int size = zzwh.size();
        return zzwh.zzcr(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzvx<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzvk zzvk) throws zzwg {
        T t2 = (zzvx) t.zza(zzf.zzcdn, null, null);
        try {
            zzya zzad = zzxv.zzvk().zzad(t2);
            zzad.zza(t2, bArr, 0, i2, new zzup(zzvk));
            zzad.zzq(t2);
            if (t2.zzbyw == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzwg) {
                throw ((zzwg) e.getCause());
            }
            throw new zzwg(e.getMessage()).zzg(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzwg.zzui().zzg(t2);
        }
    }

    protected static <T extends zzvx<T, ?>> T zza(zzvx zzvx, byte[] bArr, zzvk zzvk) throws zzwg {
        T zza2 = zza(zzvx, bArr, 0, bArr.length, zzvk);
        if (zza2 == null || zza2.isInitialized()) {
            return zza2;
        }
        throw new zzwg(new zzyt(zza2).getMessage()).zzg(zza2);
    }

    public final /* synthetic */ zzxj zzue() {
        zza zza2 = (zza) zza(zzf.zzcdo, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzxj zzuf() {
        return (zza) zza(zzf.zzcdo, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzxg zzty() {
        return (zzvx) zza(zzf.zzcdp, (Object) null, (Object) null);
    }
}
