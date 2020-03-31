package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzgs.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public abstract class zzgs<MessageType extends zzgs<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzet<MessageType, BuilderType> {
    private static Map<Object, zzgs<?, ?>> zzwf = new ConcurrentHashMap();
    protected zzjm zzwd = zzjm.zzig();
    private int zzwe = -1;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static class zzc<T extends zzgs<T, ?>> extends zzey<T> {
        private final T zzwa;

        public zzc(T t) {
            this.zzwa = t;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static final class zzf {
        public static final int zzwl = 1;
        public static final int zzwm = 2;
        public static final int zzwn = 3;
        public static final int zzwo = 4;
        public static final int zzwp = 5;
        public static final int zzwq = 6;
        public static final int zzwr = 7;
        private static final /* synthetic */ int[] zzws = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzwt = 1;
        public static final int zzwu = 2;
        private static final /* synthetic */ int[] zzwv = {1, 2};
        public static final int zzww = 1;
        public static final int zzwx = 2;
        private static final /* synthetic */ int[] zzwy = {1, 2};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzws.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static abstract class zzb<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzie {
        protected zzb(MessageType messagetype) {
            super(messagetype);
        }

        /* access modifiers changed from: protected */
        public void zzfy() {
            super.zzfy();
            ((zze) this.zzwb).zzwk = (zzgi) ((zze) this.zzwb).zzwk.clone();
        }

        public /* synthetic */ zzgs zzfz() {
            return (zze) zzgb();
        }

        public /* synthetic */ zzic zzgb() {
            if (this.zzwc) {
                return (zze) this.zzwb;
            }
            ((zze) this.zzwb).zzwk.zzdp();
            return (zze) super.zzgb();
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static abstract class zze<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgs<MessageType, BuilderType> implements zzie {
        protected zzgi<zzd> zzwk = zzgi.zzfn();

        /* access modifiers changed from: package-private */
        public final zzgi<zzd> zzgk() {
            if (this.zzwk.isImmutable()) {
                this.zzwk = (zzgi) this.zzwk.clone();
            }
            return this.zzwk;
        }

        public final <Type> Type zzc(zzge<MessageType, Type> zzge) {
            zzg zzb = zzgs.zza(zzge);
            if (zzb.zzwz == ((zzgs) zzgd())) {
                Type zza = this.zzwk.zza(zzb.zzxb);
                if (zza == null) {
                    return zzb.zzgc;
                }
                if (!zzb.zzxb.zzwi) {
                    return zzb.zzi(zza);
                }
                if (zzb.zzxb.zzwh.zzip() != zzkd.ENUM) {
                    return zza;
                }
                Type arrayList = new ArrayList();
                for (Object zzi : (List) zza) {
                    arrayList.add(zzb.zzi(zzi));
                }
                return arrayList;
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    public String toString() {
        return zzid.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzri != 0) {
            return this.zzri;
        }
        this.zzri = zzin.zzho().zzu(this).hashCode(this);
        return this.zzri;
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    static final class zzd implements zzgk<zzd> {
        final int number = 202056002;
        final zzgv<?> zzwg = null;
        final zzka zzwh;
        final boolean zzwi;
        final boolean zzwj;

        zzd(zzgv<?> zzgv, int i, zzka zzka, boolean z, boolean z2) {
            this.zzwh = zzka;
            this.zzwi = true;
            this.zzwj = false;
        }

        public final int zzag() {
            return this.number;
        }

        public final zzka zzfs() {
            return this.zzwh;
        }

        public final zzkd zzft() {
            return this.zzwh.zzip();
        }

        public final boolean zzfu() {
            return this.zzwi;
        }

        public final boolean zzfv() {
            return this.zzwj;
        }

        public final zzib zza(zzib zzib, zzic zzic) {
            return ((zza) zzib).zza((zzgs) zzic);
        }

        public final zzih zza(zzih zzih, zzih zzih2) {
            throw new UnsupportedOperationException();
        }

        public final /* synthetic */ int compareTo(Object obj) {
            return this.number - ((zzd) obj).number;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static abstract class zza<MessageType extends zzgs<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzew<MessageType, BuilderType> {
        private final MessageType zzwa;
        protected MessageType zzwb;
        protected boolean zzwc = false;

        protected zza(MessageType messagetype) {
            this.zzwa = messagetype;
            this.zzwb = (zzgs) messagetype.zza(zzf.zzwo, null, null);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.internal.vision.zzgs.zza.zza(com.google.android.gms.internal.vision.zzgs, com.google.android.gms.internal.vision.zzgs):void
         arg types: [MessageType, MessageType]
         candidates:
          com.google.android.gms.internal.vision.zzgs.zza.zza(com.google.android.gms.internal.vision.zzft, com.google.android.gms.internal.vision.zzgd):com.google.android.gms.internal.vision.zzew
          com.google.android.gms.internal.vision.zzew.zza(com.google.android.gms.internal.vision.zzft, com.google.android.gms.internal.vision.zzgd):BuilderType
          com.google.android.gms.internal.vision.zzgs.zza.zza(com.google.android.gms.internal.vision.zzgs, com.google.android.gms.internal.vision.zzgs):void */
        /* access modifiers changed from: protected */
        public void zzfy() {
            MessageType messagetype = (zzgs) this.zzwb.zza(zzf.zzwo, null, null);
            zza((zzgs) messagetype, (zzgs) this.zzwb);
            this.zzwb = messagetype;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.internal.vision.zzgs.zza(com.google.android.gms.internal.vision.zzgs, boolean):boolean
         arg types: [MessageType, int]
         candidates:
          com.google.android.gms.internal.vision.zzgs.zza(com.google.android.gms.internal.vision.zzgs, byte[]):T
          com.google.android.gms.internal.vision.zzgs.zza(java.lang.Class, com.google.android.gms.internal.vision.zzgs):void
          com.google.android.gms.internal.vision.zzet.zza(java.lang.Iterable, java.util.List):void
          com.google.android.gms.internal.vision.zzgs.zza(com.google.android.gms.internal.vision.zzgs, boolean):boolean */
        public final boolean isInitialized() {
            return zzgs.zza((zzgs) this.zzwb, false);
        }

        /* renamed from: zzfz */
        public MessageType zzgb() {
            if (this.zzwc) {
                return this.zzwb;
            }
            MessageType messagetype = this.zzwb;
            zzin.zzho().zzu(messagetype).zzg(messagetype);
            this.zzwc = true;
            return this.zzwb;
        }

        /* renamed from: zzga */
        public final MessageType zzgc() {
            MessageType messagetype = (zzgs) zzgb();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzjk(messagetype);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.internal.vision.zzgs.zza.zza(com.google.android.gms.internal.vision.zzgs, com.google.android.gms.internal.vision.zzgs):void
         arg types: [MessageType, MessageType]
         candidates:
          com.google.android.gms.internal.vision.zzgs.zza.zza(com.google.android.gms.internal.vision.zzft, com.google.android.gms.internal.vision.zzgd):com.google.android.gms.internal.vision.zzew
          com.google.android.gms.internal.vision.zzew.zza(com.google.android.gms.internal.vision.zzft, com.google.android.gms.internal.vision.zzgd):BuilderType
          com.google.android.gms.internal.vision.zzgs.zza.zza(com.google.android.gms.internal.vision.zzgs, com.google.android.gms.internal.vision.zzgs):void */
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzwc) {
                zzfy();
                this.zzwc = false;
            }
            zza((zzgs) this.zzwb, (zzgs) messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzin.zzho().zzu(messagetype).zzd(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzgd zzgd) throws zzhc {
            if (this.zzwc) {
                zzfy();
                this.zzwc = false;
            }
            try {
                zzin.zzho().zzu(this.zzwb).zza(this.zzwb, bArr, 0, i2 + 0, new zzfb(zzgd));
                return this;
            } catch (zzhc e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzhc.zzgm();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzft zzft, zzgd zzgd) throws IOException {
            if (this.zzwc) {
                zzfy();
                this.zzwc = false;
            }
            try {
                zzin.zzho().zzu(this.zzwb).zza(this.zzwb, zzfy.zza(zzft), zzgd);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        public final /* synthetic */ zzew zza(byte[] bArr, int i, int i2, zzgd zzgd) throws zzhc {
            return zzb(bArr, 0, i2, zzgd);
        }

        public final /* synthetic */ zzew zzdn() {
            return (zza) clone();
        }

        public final /* synthetic */ zzic zzgd() {
            return this.zzwa;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) ((zzgs) this.zzwa).zza(zzf.zzwp, (Object) null, (Object) null);
            zza.zza((zzgs) zzgb());
            return zza;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    public static class zzg<ContainingType extends zzic, Type> extends zzge<ContainingType, Type> {
        final Type zzgc;
        final ContainingType zzwz;
        final zzic zzxa;
        final zzd zzxb;

        zzg(ContainingType containingtype, Type type, zzic zzic, zzd zzd, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (zzd.zzwh == zzka.MESSAGE && zzic == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.zzwz = containingtype;
                this.zzgc = type;
                this.zzxa = zzic;
                this.zzxb = zzd;
            }
        }

        /* access modifiers changed from: package-private */
        public final Object zzi(Object obj) {
            return this.zzxb.zzwh.zzip() == zzkd.ENUM ? this.zzxb.zzwg.zzg(((Integer) obj).intValue()) : obj;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzgs) zza(zzf.zzwq, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzin.zzho().zzu(this).equals(this, (zzgs) obj);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzgs<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzge() {
        return (zza) zza(zzf.zzwp, (Object) null, (Object) null);
    }

    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    /* access modifiers changed from: package-private */
    public final int zzdl() {
        return this.zzwe;
    }

    /* access modifiers changed from: package-private */
    public final void zzad(int i) {
        this.zzwe = i;
    }

    public final void zzb(zzga zzga) throws IOException {
        zzin.zzho().zzu(this).zza(this, zzgc.zza(zzga));
    }

    public final int zzgf() {
        if (this.zzwe == -1) {
            this.zzwe = zzin.zzho().zzu(this).zzr(this);
        }
        return this.zzwe;
    }

    static <T extends zzgs<?, ?>> T zzd(Class<T> cls) {
        T t = (zzgs) zzwf.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzgs) zzwf.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzgs) ((zzgs) zzjp.zzh(cls)).zza(zzf.zzwq, (Object) null, (Object) null);
            if (t != null) {
                zzwf.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzgs<?, ?>> void zza(Class<T> cls, T t) {
        zzwf.put(cls, t);
    }

    protected static Object zza(zzic zzic, String str, Object[] objArr) {
        return new zzip(zzic, str, objArr);
    }

    public static <ContainingType extends zzic, Type> zzg<ContainingType, Type> zza(ContainingType containingtype, zzic zzic, zzgv<?> zzgv, int i, zzka zzka, boolean z, Class cls) {
        return new zzg(containingtype, Collections.emptyList(), zzic, new zzd(null, 202056002, zzka, true, false), cls);
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

    /* access modifiers changed from: private */
    public static <MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>, T> zzg<MessageType, T> zza(zzge<MessageType, T> zzge) {
        return (zzg) zzge;
    }

    protected static final <T extends zzgs<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzf.zzwl, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzt = zzin.zzho().zzu(t).zzt(t);
        if (z) {
            t.zza(zzf.zzwm, zzt ? t : null, null);
        }
        return zzt;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.zzgx, com.google.android.gms.internal.vision.zzgu] */
    protected static zzgx zzgg() {
        return zzgu.zzgl();
    }

    protected static <E> zzgz<E> zzgh() {
        return zziq.zzhr();
    }

    protected static <E> zzgz<E> zza(zzgz<E> zzgz) {
        int size = zzgz.size();
        return zzgz.zzag(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzgs<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzgd zzgd) throws zzhc {
        T t2 = (zzgs) t.zza(zzf.zzwo, null, null);
        try {
            zzir zzu = zzin.zzho().zzu(t2);
            zzu.zza(t2, bArr, 0, i2, new zzfb(zzgd));
            zzu.zzg(t2);
            if (t2.zzri == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzhc) {
                throw ((zzhc) e.getCause());
            }
            throw new zzhc(e.getMessage()).zzg(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzhc.zzgm().zzg(t2);
        }
    }

    private static <T extends zzgs<T, ?>> T zzb(T t) throws zzhc {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzhc(new zzjk(t).getMessage()).zzg(t);
    }

    protected static <T extends zzgs<T, ?>> T zza(T t, byte[] bArr) throws zzhc {
        return zzb(zza(t, bArr, 0, bArr.length, zzgd.zzfl()));
    }

    protected static <T extends zzgs<T, ?>> T zza(T t, byte[] bArr, zzgd zzgd) throws zzhc {
        return zzb(zza(t, bArr, 0, bArr.length, zzgd));
    }

    public final /* synthetic */ zzib zzgi() {
        zza zza2 = (zza) zza(zzf.zzwp, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzib zzgj() {
        return (zza) zza(zzf.zzwp, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzic zzgd() {
        return (zzgs) zza(zzf.zzwq, (Object) null, (Object) null);
    }
}
