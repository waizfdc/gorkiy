package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgk;
import com.google.android.gms.internal.vision.zzgs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzgi<T extends zzgk<T>> {
    private static final zzgi zzte = new zzgi(true);
    final zziw<T, Object> zztb;
    private boolean zztc;
    private boolean zztd;

    private zzgi() {
        this.zztb = zziw.zzbt(16);
    }

    private zzgi(boolean z) {
        this(zziw.zzbt(0));
        zzdp();
    }

    private zzgi(zziw<T, Object> zziw) {
        this.zztb = zziw;
        zzdp();
    }

    public static <T extends zzgk<T>> zzgi<T> zzfn() {
        return zzte;
    }

    public final void zzdp() {
        if (!this.zztc) {
            this.zztb.zzdp();
            this.zztc = true;
        }
    }

    public final boolean isImmutable() {
        return this.zztc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgi)) {
            return false;
        }
        return this.zztb.equals(((zzgi) obj).zztb);
    }

    public final int hashCode() {
        return this.zztb.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        if (this.zztd) {
            return new zzhi(this.zztb.entrySet().iterator());
        }
        return this.zztb.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.zztd) {
            return new zzhi(this.zztb.zzhz().iterator());
        }
        return this.zztb.zzhz().iterator();
    }

    public final Object zza(zzgs.zzd zzd) {
        Object obj = this.zztb.get(zzd);
        if (!(obj instanceof zzhd)) {
            return obj;
        }
        zzhd zzhd = (zzhd) obj;
        return zzhd.zzgu();
    }

    public final void zza(zzgs.zzd zzd, Object obj) {
        if (!zzd.zzfu()) {
            zza(zzd.zzfs(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(zzd.zzfs(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzhd) {
            this.zztd = true;
        }
        this.zztb.put(zzd, obj);
    }

    public final void zzb(zzgs.zzd zzd, Object obj) {
        Object obj2;
        if (zzd.zzfu()) {
            zza(zzd.zzfs(), obj);
            Object zza = zza(zzd);
            if (zza == null) {
                obj2 = new ArrayList();
                this.zztb.put(zzd, obj2);
            } else {
                obj2 = (List) zza;
            }
            obj2.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.vision.zzgw) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.vision.zzhd) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.vision.zzka r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.vision.zzgt.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.vision.zzgl.zzth
            com.google.android.gms.internal.vision.zzkd r2 = r2.zzip()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.zzic
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.zzhd
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.zzgw
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.vision.zzfh
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzgi.zza(com.google.android.gms.internal.vision.zzka, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zztb.zzhx(); i++) {
            if (!zzb(this.zztb.zzbu(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zzb : this.zztb.zzhy()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzgk<T>> boolean zzb(Map.Entry<T, Object> entry) {
        zzgk zzgk = (zzgk) entry.getKey();
        if (zzgk.zzft() == zzkd.MESSAGE) {
            if (zzgk.zzfu()) {
                for (zzic isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzic) {
                    if (!((zzic) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzhd) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzgi<zzgs.zzd> zzgi) {
        for (int i = 0; i < zzgi.zztb.zzhx(); i++) {
            zzc(zzgi.zztb.zzbu(i));
        }
        for (Map.Entry<T, Object> zzc : zzgi.zztb.zzhy()) {
            zzc(zzc);
        }
    }

    private static Object zzh(Object obj) {
        if (obj instanceof zzih) {
            return ((zzih) obj).zzdm();
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
        zzgk zzgk = (zzgk) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzhd) {
            zzhd zzhd = (zzhd) value;
            value = zzhd.zzgu();
        }
        if (zzgk.zzfu()) {
            Object zza = zza((zzgs.zzd) zzgk);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzh : (List) value) {
                ((List) zza).add(zzh(zzh));
            }
            this.zztb.put(zzgk, zza);
        } else if (zzgk.zzft() == zzkd.MESSAGE) {
            Object zza2 = zza((zzgs.zzd) zzgk);
            if (zza2 == null) {
                this.zztb.put(zzgk, zzh(value));
                return;
            }
            if (zza2 instanceof zzih) {
                obj = zzgk.zza((zzih) zza2, (zzih) value);
            } else {
                obj = zzgk.zza(((zzic) zza2).zzgi(), (zzic) value).zzgc();
            }
            this.zztb.put(zzgk, obj);
        } else {
            this.zztb.put(zzgk, zzh(value));
        }
    }

    static void zza(zzga zzga, zzka zzka, int i, Object obj) throws IOException {
        if (zzka == zzka.GROUP) {
            zzic zzic = (zzic) obj;
            zzgt.zzf(zzic);
            zzga.zzg(i, 3);
            zzic.zzb(zzga);
            zzga.zzg(i, 4);
            return;
        }
        zzga.zzg(i, zzka.zziq());
        switch (zzgl.zzrr[zzka.ordinal()]) {
            case 1:
                zzga.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzga.zzs(((Float) obj).floatValue());
                return;
            case 3:
                zzga.zzs(((Long) obj).longValue());
                return;
            case 4:
                zzga.zzs(((Long) obj).longValue());
                return;
            case 5:
                zzga.zzaw(((Integer) obj).intValue());
                return;
            case 6:
                zzga.zzu(((Long) obj).longValue());
                return;
            case 7:
                zzga.zzaz(((Integer) obj).intValue());
                return;
            case 8:
                zzga.zzk(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzic) obj).zzb(zzga);
                return;
            case 10:
                zzga.zzb((zzic) obj);
                return;
            case 11:
                if (obj instanceof zzfh) {
                    zzga.zza((zzfh) obj);
                    return;
                } else {
                    zzga.zzx((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzfh) {
                    zzga.zza((zzfh) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzga.zze(bArr, 0, bArr.length);
                return;
            case 13:
                zzga.zzax(((Integer) obj).intValue());
                return;
            case 14:
                zzga.zzaz(((Integer) obj).intValue());
                return;
            case 15:
                zzga.zzu(((Long) obj).longValue());
                return;
            case 16:
                zzga.zzay(((Integer) obj).intValue());
                return;
            case 17:
                zzga.zzt(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzgw) {
                    zzga.zzaw(((zzgw) obj).zzag());
                    return;
                } else {
                    zzga.zzaw(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzfo() {
        int i = 0;
        for (int i2 = 0; i2 < this.zztb.zzhx(); i2++) {
            i += zzd(this.zztb.zzbu(i2));
        }
        for (Map.Entry<T, Object> zzd : this.zztb.zzhy()) {
            i += zzd(zzd);
        }
        return i;
    }

    private static int zzd(Map.Entry<T, Object> entry) {
        zzgk zzgk = (zzgk) entry.getKey();
        Object value = entry.getValue();
        if (zzgk.zzft() != zzkd.MESSAGE || zzgk.zzfu() || zzgk.zzfv()) {
            return zzc(zzgk, value);
        }
        if (value instanceof zzhd) {
            return zzga.zzb(((zzgk) entry.getKey()).zzag(), (zzhd) value);
        }
        return zzga.zzb(((zzgk) entry.getKey()).zzag(), (zzic) value);
    }

    static int zza(zzka zzka, int i, Object obj) {
        int zzba = zzga.zzba(i);
        if (zzka == zzka.GROUP) {
            zzgt.zzf((zzic) obj);
            zzba <<= 1;
        }
        return zzba + zzb(zzka, obj);
    }

    private static int zzb(zzka zzka, Object obj) {
        switch (zzgl.zzrr[zzka.ordinal()]) {
            case 1:
                return zzga.zzb(((Double) obj).doubleValue());
            case 2:
                return zzga.zzt(((Float) obj).floatValue());
            case 3:
                return zzga.zzv(((Long) obj).longValue());
            case 4:
                return zzga.zzw(((Long) obj).longValue());
            case 5:
                return zzga.zzbb(((Integer) obj).intValue());
            case 6:
                return zzga.zzy(((Long) obj).longValue());
            case 7:
                return zzga.zzbe(((Integer) obj).intValue());
            case 8:
                return zzga.zzl(((Boolean) obj).booleanValue());
            case 9:
                return zzga.zzd((zzic) obj);
            case 10:
                if (obj instanceof zzhd) {
                    return zzga.zza((zzhd) obj);
                }
                return zzga.zzc((zzic) obj);
            case 11:
                if (obj instanceof zzfh) {
                    return zzga.zzb((zzfh) obj);
                }
                return zzga.zzy((String) obj);
            case 12:
                if (obj instanceof zzfh) {
                    return zzga.zzb((zzfh) obj);
                }
                return zzga.zzf((byte[]) obj);
            case 13:
                return zzga.zzbc(((Integer) obj).intValue());
            case 14:
                return zzga.zzbf(((Integer) obj).intValue());
            case 15:
                return zzga.zzz(((Long) obj).longValue());
            case 16:
                return zzga.zzbd(((Integer) obj).intValue());
            case 17:
                return zzga.zzx(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzgw) {
                    return zzga.zzbg(((zzgw) obj).zzag());
                }
                return zzga.zzbg(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzc(zzgk<?> zzgk, Object obj) {
        zzka zzfs = zzgk.zzfs();
        int zzag = zzgk.zzag();
        if (!zzgk.zzfu()) {
            return zza(zzfs, zzag, obj);
        }
        int i = 0;
        if (zzgk.zzfv()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzfs, zzb);
            }
            return zzga.zzba(zzag) + i + zzga.zzbi(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzfs, zzag, zza);
        }
        return i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzgi.zza(com.google.android.gms.internal.vision.zzgs$zzd, java.lang.Object):void
     arg types: [com.google.android.gms.internal.vision.zzgk, java.lang.Object]
     candidates:
      com.google.android.gms.internal.vision.zzgi.zza(com.google.android.gms.internal.vision.zzka, java.lang.Object):void
      com.google.android.gms.internal.vision.zzgi.zza(com.google.android.gms.internal.vision.zzgs$zzd, java.lang.Object):void */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgi zzgi = new zzgi();
        for (int i = 0; i < this.zztb.zzhx(); i++) {
            Map.Entry<T, Object> zzbu = this.zztb.zzbu(i);
            zzgi.zza((zzgs.zzd) ((zzgk) zzbu.getKey()), zzbu.getValue());
        }
        for (Map.Entry next : this.zztb.zzhy()) {
            zzgi.zza((zzgs.zzd) ((zzgk) next.getKey()), next.getValue());
        }
        zzgi.zztd = this.zztd;
        return zzgi;
    }
}
