package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzgd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzgb<T extends zzgd<T>> {
    private static final zzgb zzsm = new zzgb(true);
    final zzid<T, Object> zzsj;
    private boolean zzsk;
    private boolean zzsl;

    private zzgb() {
        this.zzsj = zzid.zzai(16);
    }

    private zzgb(boolean z) {
        this(zzid.zzai(0));
        zzal();
    }

    private zzgb(zzid<T, Object> zzid) {
        this.zzsj = zzid;
        zzal();
    }

    public static <T extends zzgd<T>> zzgb<T> zzbe() {
        return zzsm;
    }

    public final void zzal() {
        if (!this.zzsk) {
            this.zzsj.zzal();
            this.zzsk = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzsk;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgb)) {
            return false;
        }
        return this.zzsj.equals(((zzgb) obj).zzsj);
    }

    public final int hashCode() {
        return this.zzsj.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        if (this.zzsl) {
            return new zzgu(this.zzsj.entrySet().iterator());
        }
        return this.zzsj.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.zzsl) {
            return new zzgu(this.zzsj.zzcs().iterator());
        }
        return this.zzsj.zzcs().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zzsj.get(t);
        if (!(obj instanceof zzgp)) {
            return obj;
        }
        zzgp zzgp = (zzgp) obj;
        return zzgp.zzbu();
    }

    private final void zza(T t, Object obj) {
        if (!t.zzbi()) {
            zza(t.zzbg(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzbg(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzgp) {
            this.zzsl = true;
        }
        this.zzsj.put(t, obj);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.fitness.zzgj) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.fitness.zzgp) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.fitness.zzji r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.fitness.zzgk.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.fitness.zzga.zzsh
            com.google.android.gms.internal.fitness.zzjl r2 = r2.zzdl()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.fitness.zzho
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.fitness.zzgp
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.fitness.zzgj
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.fitness.zzff
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fitness.zzgb.zza(com.google.android.gms.internal.fitness.zzji, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzsj.zzcq(); i++) {
            if (!zzb(this.zzsj.zzaj(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zzb : this.zzsj.zzcr()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzgd<T>> boolean zzb(Map.Entry<T, Object> entry) {
        zzgd zzgd = (zzgd) entry.getKey();
        if (zzgd.zzbh() == zzjl.MESSAGE) {
            if (zzgd.zzbi()) {
                for (zzho isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzho) {
                    if (!((zzho) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzgp) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzgb<T> zzgb) {
        for (int i = 0; i < zzgb.zzsj.zzcq(); i++) {
            zzc(zzgb.zzsj.zzaj(i));
        }
        for (Map.Entry<T, Object> zzc : zzgb.zzsj.zzcr()) {
            zzc(zzc);
        }
    }

    private static Object zzd(Object obj) {
        if (obj instanceof zzhu) {
            return ((zzhu) obj).zzai();
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
        zzgd zzgd = (zzgd) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzgp) {
            zzgp zzgp = (zzgp) value;
            value = zzgp.zzbu();
        }
        if (zzgd.zzbi()) {
            Object zza = zza(zzgd);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzd : (List) value) {
                ((List) zza).add(zzd(zzd));
            }
            this.zzsj.put(zzgd, zza);
        } else if (zzgd.zzbh() == zzjl.MESSAGE) {
            Object zza2 = zza(zzgd);
            if (zza2 == null) {
                this.zzsj.put(zzgd, zzd(value));
                return;
            }
            if (zza2 instanceof zzhu) {
                obj = zzgd.zza((zzhu) zza2, (zzhu) value);
            } else {
                obj = zzgd.zza(((zzho) zza2).zzbl(), (zzho) value).zzbr();
            }
            this.zzsj.put(zzgd, obj);
        } else {
            this.zzsj.put(zzgd, zzd(value));
        }
    }

    static void zza(zzfs zzfs, zzji zzji, int i, Object obj) throws IOException {
        if (zzji == zzji.GROUP) {
            zzho zzho = (zzho) obj;
            zzgk.zzf(zzho);
            zzfs.zzb(i, 3);
            zzho.zzb(zzfs);
            zzfs.zzb(i, 4);
            return;
        }
        zzfs.zzb(i, zzji.zzdm());
        switch (zzga.zzsi[zzji.ordinal()]) {
            case 1:
                zzfs.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzfs.zzb(((Float) obj).floatValue());
                return;
            case 3:
                zzfs.zza(((Long) obj).longValue());
                return;
            case 4:
                zzfs.zza(((Long) obj).longValue());
                return;
            case 5:
                zzfs.zzl(((Integer) obj).intValue());
                return;
            case 6:
                zzfs.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzfs.zzo(((Integer) obj).intValue());
                return;
            case 8:
                zzfs.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzho) obj).zzb(zzfs);
                return;
            case 10:
                zzfs.zzb((zzho) obj);
                return;
            case 11:
                if (obj instanceof zzff) {
                    zzfs.zza((zzff) obj);
                    return;
                } else {
                    zzfs.zzm((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzff) {
                    zzfs.zza((zzff) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzfs.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzfs.zzm(((Integer) obj).intValue());
                return;
            case 14:
                zzfs.zzo(((Integer) obj).intValue());
                return;
            case 15:
                zzfs.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzfs.zzn(((Integer) obj).intValue());
                return;
            case 17:
                zzfs.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzgj) {
                    zzfs.zzl(((zzgj) obj).zzc());
                    return;
                } else {
                    zzfs.zzl(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzbf() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzsj.zzcq(); i2++) {
            i += zzd((Map.Entry) this.zzsj.zzaj(i2));
        }
        for (Map.Entry<T, Object> entry : this.zzsj.zzcr()) {
            i += zzd((Map.Entry) entry);
        }
        return i;
    }

    private static int zzd(Map.Entry<T, Object> entry) {
        zzgd zzgd = (zzgd) entry.getKey();
        Object value = entry.getValue();
        if (zzgd.zzbh() != zzjl.MESSAGE || zzgd.zzbi() || zzgd.zzbj()) {
            return zzb(zzgd, value);
        }
        if (value instanceof zzgp) {
            return zzfs.zzb(((zzgd) entry.getKey()).zzc(), (zzgp) value);
        }
        return zzfs.zzb(((zzgd) entry.getKey()).zzc(), (zzho) value);
    }

    static int zza(zzji zzji, int i, Object obj) {
        int zzp = zzfs.zzp(i);
        if (zzji == zzji.GROUP) {
            zzgk.zzf((zzho) obj);
            zzp <<= 1;
        }
        return zzp + zzb(zzji, obj);
    }

    private static int zzb(zzji zzji, Object obj) {
        switch (zzga.zzsi[zzji.ordinal()]) {
            case 1:
                return zzfs.zzc(((Double) obj).doubleValue());
            case 2:
                return zzfs.zzc(((Float) obj).floatValue());
            case 3:
                return zzfs.zzd(((Long) obj).longValue());
            case 4:
                return zzfs.zze(((Long) obj).longValue());
            case 5:
                return zzfs.zzq(((Integer) obj).intValue());
            case 6:
                return zzfs.zzg(((Long) obj).longValue());
            case 7:
                return zzfs.zzt(((Integer) obj).intValue());
            case 8:
                return zzfs.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzfs.zzd((zzho) obj);
            case 10:
                if (obj instanceof zzgp) {
                    return zzfs.zza((zzgp) obj);
                }
                return zzfs.zzc((zzho) obj);
            case 11:
                if (obj instanceof zzff) {
                    return zzfs.zzb((zzff) obj);
                }
                return zzfs.zzn((String) obj);
            case 12:
                if (obj instanceof zzff) {
                    return zzfs.zzb((zzff) obj);
                }
                return zzfs.zzb((byte[]) obj);
            case 13:
                return zzfs.zzr(((Integer) obj).intValue());
            case 14:
                return zzfs.zzu(((Integer) obj).intValue());
            case 15:
                return zzfs.zzh(((Long) obj).longValue());
            case 16:
                return zzfs.zzs(((Integer) obj).intValue());
            case 17:
                return zzfs.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzgj) {
                    return zzfs.zzv(((zzgj) obj).zzc());
                }
                return zzfs.zzv(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzgd<?> zzgd, Object obj) {
        zzji zzbg = zzgd.zzbg();
        int zzc = zzgd.zzc();
        if (!zzgd.zzbi()) {
            return zza(zzbg, zzc, obj);
        }
        int i = 0;
        if (zzgd.zzbj()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzbg, zzb);
            }
            return zzfs.zzp(zzc) + i + zzfs.zzx(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzbg, zzc, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgb zzgb = new zzgb();
        for (int i = 0; i < this.zzsj.zzcq(); i++) {
            Map.Entry<T, Object> zzaj = this.zzsj.zzaj(i);
            zzgb.zza((zzgd) zzaj.getKey(), zzaj.getValue());
        }
        for (Map.Entry next : this.zzsj.zzcr()) {
            zzgb.zza((zzgd) next.getKey(), next.getValue());
        }
        zzgb.zzsl = this.zzsl;
        return zzgb;
    }
}
