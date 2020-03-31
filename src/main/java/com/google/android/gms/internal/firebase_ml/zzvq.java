package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzvs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzvq<T extends zzvs<T>> {
    private static final zzvq zzcal = new zzvq(true);
    final zzyf<T, Object> zzcai;
    private boolean zzcaj;
    private boolean zzcak;

    private zzvq() {
        this.zzcai = zzyf.zzdw(16);
    }

    private zzvq(boolean z) {
        this(zzyf.zzdw(0));
        zzsp();
    }

    private zzvq(zzyf<T, Object> zzyf) {
        this.zzcai = zzyf;
        zzsp();
    }

    public static <T extends zzvs<T>> zzvq<T> zztl() {
        return zzcal;
    }

    public final void zzsp() {
        if (!this.zzcaj) {
            this.zzcai.zzsp();
            this.zzcaj = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzcaj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvq)) {
            return false;
        }
        return this.zzcai.equals(((zzvq) obj).zzcai);
    }

    public final int hashCode() {
        return this.zzcai.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        if (this.zzcak) {
            return new zzwm(this.zzcai.entrySet().iterator());
        }
        return this.zzcai.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.zzcak) {
            return new zzwm(this.zzcai.zzvv().iterator());
        }
        return this.zzcai.zzvv().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zzcai.get(t);
        if (!(obj instanceof zzwl)) {
            return obj;
        }
        zzwl zzwl = (zzwl) obj;
        return zzwl.zzup();
    }

    private final void zza(T t, Object obj) {
        if (!t.zztp()) {
            zza(t.zztn(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zztn(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzwl) {
            this.zzcak = true;
        }
        this.zzcai.put(t, obj);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.firebase_ml.zzwb) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.firebase_ml.zzwl) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.firebase_ml.zzzj r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.firebase_ml.zzvy.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.firebase_ml.zzvp.zzcag
            com.google.android.gms.internal.firebase_ml.zzzm r2 = r2.zzwl()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001f;
                case 9: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r0 = r1
            goto L_0x0042
        L_0x0016:
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_ml.zzxg
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_ml.zzwl
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_ml.zzwb
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_ml.zzuq
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            if (r0 == 0) goto L_0x0045
            return
        L_0x0045:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzvq.zza(com.google.android.gms.internal.firebase_ml.zzzj, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzcai.zzvt(); i++) {
            if (!zzb(this.zzcai.zzdx(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zzb : this.zzcai.zzvu()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzvs<T>> boolean zzb(Map.Entry<T, Object> entry) {
        zzvs zzvs = (zzvs) entry.getKey();
        if (zzvs.zzto() == zzzm.MESSAGE) {
            if (zzvs.zztp()) {
                for (zzxg isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzxg) {
                    if (!((zzxg) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzwl) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzvq<T> zzvq) {
        for (int i = 0; i < zzvq.zzcai.zzvt(); i++) {
            zzc(zzvq.zzcai.zzdx(i));
        }
        for (Map.Entry<T, Object> zzc : zzvq.zzcai.zzvu()) {
            zzc(zzc);
        }
    }

    private static Object zzr(Object obj) {
        if (obj instanceof zzxp) {
            return ((zzxp) obj).zzsm();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzc(Map.Entry<T, Object> entry) {
        Object obj;
        zzvs zzvs = (zzvs) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzwl) {
            zzwl zzwl = (zzwl) value;
            value = zzwl.zzup();
        }
        if (zzvs.zztp()) {
            Object zza = zza(zzvs);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzr : (List) value) {
                ((List) zza).add(zzr(zzr));
            }
            this.zzcai.put(zzvs, zza);
        } else if (zzvs.zzto() == zzzm.MESSAGE) {
            Object zza2 = zza(zzvs);
            if (zza2 == null) {
                this.zzcai.put(zzvs, zzr(value));
                return;
            }
            if (zza2 instanceof zzxp) {
                obj = zzvs.zza((zzxp) zza2, (zzxp) value);
            } else {
                obj = zzvs.zza(((zzxg) zza2).zzue(), (zzxg) value).zztx();
            }
            this.zzcai.put(zzvs, obj);
        } else {
            this.zzcai.put(zzvs, zzr(value));
        }
    }

    static void zza(zzvh zzvh, zzzj zzzj, int i, Object obj) throws IOException {
        if (zzzj == zzzj.GROUP) {
            zzxg zzxg = (zzxg) obj;
            zzvy.zzf(zzxg);
            zzvh.zzh(i, 3);
            zzxg.zzb(zzvh);
            zzvh.zzh(i, 4);
            return;
        }
        zzvh.zzh(i, zzzj.zzwm());
        switch (zzvp.zzcah[zzzj.ordinal()]) {
            case 1:
                zzvh.zzc(((Double) obj).doubleValue());
                return;
            case 2:
                zzvh.zzq(((Float) obj).floatValue());
                return;
            case 3:
                zzvh.zzw(((Long) obj).longValue());
                return;
            case 4:
                zzvh.zzw(((Long) obj).longValue());
                return;
            case 5:
                zzvh.zzcx(((Integer) obj).intValue());
                return;
            case 6:
                zzvh.zzy(((Long) obj).longValue());
                return;
            case 7:
                zzvh.zzda(((Integer) obj).intValue());
                return;
            case 8:
                zzvh.zzax(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzxg) obj).zzb(zzvh);
                return;
            case 10:
                zzvh.zzb((zzxg) obj);
                return;
            case 11:
                if (obj instanceof zzuq) {
                    zzvh.zzc((zzuq) obj);
                    return;
                } else {
                    zzvh.zzcj((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzuq) {
                    zzvh.zzc((zzuq) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzvh.zze(bArr, 0, bArr.length);
                return;
            case 13:
                zzvh.zzcy(((Integer) obj).intValue());
                return;
            case 14:
                zzvh.zzda(((Integer) obj).intValue());
                return;
            case 15:
                zzvh.zzy(((Long) obj).longValue());
                return;
            case 16:
                zzvh.zzcz(((Integer) obj).intValue());
                return;
            case 17:
                zzvh.zzx(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzwb) {
                    zzvh.zzcx(((zzwb) obj).zzb());
                    return;
                } else {
                    zzvh.zzcx(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zztm() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzcai.zzvt(); i2++) {
            i += zzd(this.zzcai.zzdx(i2));
        }
        for (Map.Entry<T, Object> zzd : this.zzcai.zzvu()) {
            i += zzd(zzd);
        }
        return i;
    }

    private static int zzd(Map.Entry<T, Object> entry) {
        zzvs zzvs = (zzvs) entry.getKey();
        Object value = entry.getValue();
        if (zzvs.zzto() != zzzm.MESSAGE || zzvs.zztp() || zzvs.zztq()) {
            return zzb(zzvs, value);
        }
        if (value instanceof zzwl) {
            return zzvh.zzb(((zzvs) entry.getKey()).zzb(), (zzwl) value);
        }
        return zzvh.zzb(((zzvs) entry.getKey()).zzb(), (zzxg) value);
    }

    static int zza(zzzj zzzj, int i, Object obj) {
        int zzdb = zzvh.zzdb(i);
        if (zzzj == zzzj.GROUP) {
            zzvy.zzf((zzxg) obj);
            zzdb <<= 1;
        }
        return zzdb + zzb(zzzj, obj);
    }

    private static int zzb(zzzj zzzj, Object obj) {
        switch (zzvp.zzcah[zzzj.ordinal()]) {
            case 1:
                return zzvh.zzd(((Double) obj).doubleValue());
            case 2:
                return zzvh.zzr(((Float) obj).floatValue());
            case 3:
                return zzvh.zzz(((Long) obj).longValue());
            case 4:
                return zzvh.zzaa(((Long) obj).longValue());
            case 5:
                return zzvh.zzdc(((Integer) obj).intValue());
            case 6:
                return zzvh.zzac(((Long) obj).longValue());
            case 7:
                return zzvh.zzdf(((Integer) obj).intValue());
            case 8:
                return zzvh.zzay(((Boolean) obj).booleanValue());
            case 9:
                return zzvh.zzd((zzxg) obj);
            case 10:
                if (obj instanceof zzwl) {
                    return zzvh.zza((zzwl) obj);
                }
                return zzvh.zzc((zzxg) obj);
            case 11:
                if (obj instanceof zzuq) {
                    return zzvh.zzd((zzuq) obj);
                }
                return zzvh.zzck((String) obj);
            case 12:
                if (obj instanceof zzuq) {
                    return zzvh.zzd((zzuq) obj);
                }
                return zzvh.zzh((byte[]) obj);
            case 13:
                return zzvh.zzdd(((Integer) obj).intValue());
            case 14:
                return zzvh.zzdg(((Integer) obj).intValue());
            case 15:
                return zzvh.zzad(((Long) obj).longValue());
            case 16:
                return zzvh.zzde(((Integer) obj).intValue());
            case 17:
                return zzvh.zzab(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzwb) {
                    return zzvh.zzdh(((zzwb) obj).zzb());
                }
                return zzvh.zzdh(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzvs<?> zzvs, Object obj) {
        zzzj zztn = zzvs.zztn();
        int zzb = zzvs.zzb();
        if (!zzvs.zztp()) {
            return zza(zztn, zzb, obj);
        }
        int i = 0;
        if (zzvs.zztq()) {
            for (Object zzb2 : (List) obj) {
                i += zzb(zztn, zzb2);
            }
            return zzvh.zzdb(zzb) + i + zzvh.zzdk(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zztn, zzb, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzvq zzvq = new zzvq();
        for (int i = 0; i < this.zzcai.zzvt(); i++) {
            Map.Entry<T, Object> zzdx = this.zzcai.zzdx(i);
            zzvq.zza((zzvs) zzdx.getKey(), zzdx.getValue());
        }
        for (Map.Entry next : this.zzcai.zzvu()) {
            zzvq.zza((zzvs) next.getKey(), next.getValue());
        }
        zzvq.zzcak = this.zzcak;
        return zzvq;
    }
}
