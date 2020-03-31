package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfd.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
public abstract class zzfd<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdl<MessageType, BuilderType> {
    private static Map<Object, zzfd<?, ?>> zzd = new ConcurrentHashMap();
    protected zzhy zzb = zzhy.zza();
    private int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
    public static class zza<T extends zzfd<T, ?>> extends zzdp<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
    static final class zzc implements zzey<zzc> {
        public final int zza() {
            throw new NoSuchMethodError();
        }

        public final zzim zzb() {
            throw new NoSuchMethodError();
        }

        public final zzip zzc() {
            throw new NoSuchMethodError();
        }

        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        public final zzgn zza(zzgn zzgn, zzgo zzgo) {
            throw new NoSuchMethodError();
        }

        public final zzgt zza(zzgt zzgt, zzgt zzgt2) {
            throw new NoSuchMethodError();
        }

        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
    public static final class zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 1;
        public static final int zzi = 2;
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzl = {1, 2, 3, 4, 5, 6, 7};
        private static final /* synthetic */ int[] zzm = {1, 2};
        private static final /* synthetic */ int[] zzn = {1, 2};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
    public static class zzf<ContainingType extends zzgo, Type> extends zzer<ContainingType, Type> {
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzfd<MessageType, BuilderType> implements zzgq {
        protected zzew<zzc> zzc = zzew.zza();

        /* access modifiers changed from: package-private */
        public final zzew<zzc> zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zzew) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public String toString() {
        return zzgp.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzgz.zza().zza(this).zza(this);
        return this.zza;
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
    public static abstract class zzb<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdn<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        protected zzb(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (zzfd) messagetype.zza(zze.zzd, null, null);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.internal.measurement.zzfd.zzb.zza(com.google.android.gms.internal.measurement.zzfd, com.google.android.gms.internal.measurement.zzfd):void
         arg types: [MessageType, MessageType]
         candidates:
          com.google.android.gms.internal.measurement.zzfd.zzb.zza(com.google.android.gms.internal.measurement.zzeg, com.google.android.gms.internal.measurement.zzeq):com.google.android.gms.internal.measurement.zzdn
          com.google.android.gms.internal.measurement.zzdn.zza(com.google.android.gms.internal.measurement.zzeg, com.google.android.gms.internal.measurement.zzeq):BuilderType
          com.google.android.gms.internal.measurement.zzdn.zza(byte[], com.google.android.gms.internal.measurement.zzeq):com.google.android.gms.internal.measurement.zzgn
          com.google.android.gms.internal.measurement.zzgn.zza(byte[], com.google.android.gms.internal.measurement.zzeq):com.google.android.gms.internal.measurement.zzgn
          com.google.android.gms.internal.measurement.zzfd.zzb.zza(com.google.android.gms.internal.measurement.zzfd, com.google.android.gms.internal.measurement.zzfd):void */
        /* access modifiers changed from: protected */
        public void zzq() {
            MessageType messagetype = (zzfd) this.zza.zza(zze.zzd, null, null);
            zza((zzfd) messagetype, (zzfd) this.zza);
            this.zza = messagetype;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.internal.measurement.zzfd.zza(com.google.android.gms.internal.measurement.zzfd, boolean):boolean
         arg types: [MessageType, int]
         candidates:
          com.google.android.gms.internal.measurement.zzfd.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzfd):void
          com.google.android.gms.internal.measurement.zzdl.zza(java.lang.Iterable, java.util.List):void
          com.google.android.gms.internal.measurement.zzfd.zza(com.google.android.gms.internal.measurement.zzfd, boolean):boolean */
        public final boolean zzbl() {
            return zzfd.zza((zzfd) this.zza, false);
        }

        /* renamed from: zzr */
        public MessageType zzt() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzgz.zza().zza((Object) messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        /* renamed from: zzs */
        public final MessageType zzu() {
            MessageType messagetype = (zzfd) zzt();
            if (messagetype.zzbl()) {
                return messagetype;
            }
            throw new zzhw(messagetype);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.internal.measurement.zzfd.zzb.zza(com.google.android.gms.internal.measurement.zzfd, com.google.android.gms.internal.measurement.zzfd):void
         arg types: [MessageType, MessageType]
         candidates:
          com.google.android.gms.internal.measurement.zzfd.zzb.zza(com.google.android.gms.internal.measurement.zzeg, com.google.android.gms.internal.measurement.zzeq):com.google.android.gms.internal.measurement.zzdn
          com.google.android.gms.internal.measurement.zzdn.zza(com.google.android.gms.internal.measurement.zzeg, com.google.android.gms.internal.measurement.zzeq):BuilderType
          com.google.android.gms.internal.measurement.zzdn.zza(byte[], com.google.android.gms.internal.measurement.zzeq):com.google.android.gms.internal.measurement.zzgn
          com.google.android.gms.internal.measurement.zzgn.zza(byte[], com.google.android.gms.internal.measurement.zzeq):com.google.android.gms.internal.measurement.zzgn
          com.google.android.gms.internal.measurement.zzfd.zzb.zza(com.google.android.gms.internal.measurement.zzfd, com.google.android.gms.internal.measurement.zzfd):void */
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            zza((zzfd) this.zza, (zzfd) messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzgz.zza().zza((Object) messagetype).zzb(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzeq zzeq) throws zzfo {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzgz.zza().zza((Object) this.zza).zza(this.zza, bArr, 0, i2 + 0, new zzdt(zzeq));
                return this;
            } catch (zzfo e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzfo.zza();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzeg zzeg, zzeq zzeq) throws IOException {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzgz.zza().zza((Object) this.zza).zza(this.zza, zzel.zza(zzeg), zzeq);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        public final /* synthetic */ zzdn zza(byte[] bArr, int i, int i2, zzeq zzeq) throws zzfo {
            return zzb(bArr, 0, i2, zzeq);
        }

        public final /* synthetic */ zzdn zza(byte[] bArr, int i, int i2) throws zzfo {
            return zzb(bArr, 0, i2, zzeq.zza());
        }

        public final /* synthetic */ zzdn zzp() {
            return (zzb) clone();
        }

        public final /* synthetic */ zzgo zzbt() {
            return this.zzc;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb2 = (zzb) ((zzfd) this.zzc).zza(zze.zze, (Object) null, (Object) null);
            zzb2.zza((zzfd) zzt());
            return zzb2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzgz.zza().zza(this).zza(this, (zzfd) obj);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbk() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final boolean zzbl() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzbm() {
        BuilderType buildertype = (zzb) zza(zze.zze, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    /* access modifiers changed from: package-private */
    public final int zzbj() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i) {
        this.zzc = i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
     arg types: [com.google.android.gms.internal.measurement.zzfd, com.google.android.gms.internal.measurement.zzep]
     candidates:
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void */
    public final void zza(zzen zzen) throws IOException {
        zzgz.zza().zza(this).zza((Object) this, (zzis) zzep.zza(zzen));
    }

    public final int zzbn() {
        if (this.zzc == -1) {
            this.zzc = zzgz.zza().zza(this).zzb(this);
        }
        return this.zzc;
    }

    static <T extends zzfd<?, ?>> T zza(Class cls) {
        T t = (zzfd) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzfd) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzfd) ((zzfd) zzib.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
            if (t != null) {
                zzd.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzfd<?, ?>> void zza(Class cls, zzfd zzfd) {
        zzd.put(cls, zzfd);
    }

    protected static Object zza(zzgo zzgo, String str, Object[] objArr) {
        return new zzhb(zzgo, str, objArr);
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

    protected static final <T extends zzfd<T, ?>> boolean zza(zzfd zzfd, boolean z) {
        byte byteValue = ((Byte) zzfd.zza(zze.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzgz.zza().zza(zzfd).zzd(zzfd);
        if (z) {
            zzfd.zza(zze.zzb, zzd2 ? zzfd : null, (Object) null);
        }
        return zzd2;
    }

    protected static zzfj zzbo() {
        return zzfg.zzd();
    }

    protected static zzfm zzbp() {
        return zzgc.zzd();
    }

    protected static zzfm zza(zzfm zzfm) {
        int size = zzfm.size();
        return zzfm.zzc(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzfl<E> zzbq() {
        return zzhc.zzd();
    }

    protected static <E> zzfl<E> zza(zzfl zzfl) {
        int size = zzfl.size();
        return zzfl.zza(size == 0 ? 10 : size << 1);
    }

    public final /* synthetic */ zzgn zzbr() {
        zzb zzb2 = (zzb) zza(zze.zze, (Object) null, (Object) null);
        zzb2.zza(this);
        return zzb2;
    }

    public final /* synthetic */ zzgn zzbs() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzgo zzbt() {
        return (zzfd) zza(zze.zzf, (Object) null, (Object) null);
    }
}
