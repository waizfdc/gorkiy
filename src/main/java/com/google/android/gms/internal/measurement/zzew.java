package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
final class zzew<T extends zzey<T>> {
    private static final zzew zzd = new zzew(true);
    final zzhi<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzew() {
        this.zza = zzhi.zza(16);
    }

    private zzew(boolean z) {
        this(zzhi.zza(0));
        zzb();
    }

    private zzew(zzhi<T, Object> zzhi) {
        this.zza = zzhi;
        zzb();
    }

    public static <T extends zzey<T>> zzew<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzew)) {
            return false;
        }
        return this.zza.equals(((zzew) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzfu(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzfu(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzfp)) {
            return obj;
        }
        zzfp zzfp = (zzfp) obj;
        return zzfp.zza();
    }

    private final void zzb(T t, Object obj) {
        if (!t.zzd()) {
            zza(t.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzfp) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzfi) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzfp) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.measurement.zzim r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzff.zza(r3)
            int[] r0 = com.google.android.gms.internal.measurement.zzev.zza
            com.google.android.gms.internal.measurement.zzip r2 = r2.zza()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzgo
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzfp
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzfi
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzdu
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzew.zza(com.google.android.gms.internal.measurement.zzim, java.lang.Object):void");
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza((Map.Entry) this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            if (!zza((Map.Entry) entry)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzey<T>> boolean zza(Map.Entry<T, Object> entry) {
        zzey zzey = (zzey) entry.getKey();
        if (zzey.zzc() == zzip.MESSAGE) {
            if (zzey.zzd()) {
                for (zzgo zzbl : (List) entry.getValue()) {
                    if (!zzbl.zzbl()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgo) {
                    if (!((zzgo) value).zzbl()) {
                        return false;
                    }
                } else if (value instanceof zzfp) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzew<T> zzew) {
        for (int i = 0; i < zzew.zza.zzc(); i++) {
            zzb(zzew.zza.zzb(i));
        }
        for (Map.Entry<T, Object> zzb2 : zzew.zza.zzd()) {
            zzb(zzb2);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzgt) {
            return ((zzgt) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        Object obj;
        zzey zzey = (zzey) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfp) {
            zzfp zzfp = (zzfp) value;
            value = zzfp.zza();
        }
        if (zzey.zzd()) {
            Object zza2 = zza(zzey);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object zza3 : (List) value) {
                ((List) zza2).add(zza(zza3));
            }
            this.zza.put(zzey, zza2);
        } else if (zzey.zzc() == zzip.MESSAGE) {
            Object zza4 = zza(zzey);
            if (zza4 == null) {
                this.zza.put(zzey, zza(value));
                return;
            }
            if (zza4 instanceof zzgt) {
                obj = zzey.zza((zzgt) zza4, (zzgt) value);
            } else {
                obj = zzey.zza(((zzgo) zza4).zzbr(), (zzgo) value).zzu();
            }
            this.zza.put(zzey, obj);
        } else {
            this.zza.put(zzey, zza(value));
        }
    }

    static void zza(zzen zzen, zzim zzim, int i, Object obj) throws IOException {
        if (zzim == zzim.GROUP) {
            zzgo zzgo = (zzgo) obj;
            zzff.zza(zzgo);
            zzen.zza(i, 3);
            zzgo.zza(zzen);
            zzen.zza(i, 4);
            return;
        }
        zzen.zza(i, zzim.zzb());
        switch (zzev.zzb[zzim.ordinal()]) {
            case 1:
                zzen.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzen.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzen.zza(((Long) obj).longValue());
                return;
            case 4:
                zzen.zza(((Long) obj).longValue());
                return;
            case 5:
                zzen.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzen.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzen.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzen.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzgo) obj).zza(zzen);
                return;
            case 10:
                zzen.zza((zzgo) obj);
                return;
            case 11:
                if (obj instanceof zzdu) {
                    zzen.zza((zzdu) obj);
                    return;
                } else {
                    zzen.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdu) {
                    zzen.zza((zzdu) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzen.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzen.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzen.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzen.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzen.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzen.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfi) {
                    zzen.zza(((zzfi) obj).zza());
                    return;
                } else {
                    zzen.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            i += zzc(this.zza.zzb(i2));
        }
        for (Map.Entry<T, Object> zzc2 : this.zza.zzd()) {
            i += zzc(zzc2);
        }
        return i;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        zzey zzey = (zzey) entry.getKey();
        Object value = entry.getValue();
        if (zzey.zzc() != zzip.MESSAGE || zzey.zzd() || zzey.zze()) {
            return zza(zzey, value);
        }
        if (value instanceof zzfp) {
            return zzen.zzb(((zzey) entry.getKey()).zza(), (zzfp) value);
        }
        return zzen.zzb(((zzey) entry.getKey()).zza(), (zzgo) value);
    }

    static int zza(zzim zzim, int i, Object obj) {
        int zze = zzen.zze(i);
        if (zzim == zzim.GROUP) {
            zzff.zza((zzgo) obj);
            zze <<= 1;
        }
        return zze + zzb(zzim, obj);
    }

    private static int zzb(zzim zzim, Object obj) {
        switch (zzev.zzb[zzim.ordinal()]) {
            case 1:
                return zzen.zzb(((Double) obj).doubleValue());
            case 2:
                return zzen.zzb(((Float) obj).floatValue());
            case 3:
                return zzen.zzd(((Long) obj).longValue());
            case 4:
                return zzen.zze(((Long) obj).longValue());
            case 5:
                return zzen.zzf(((Integer) obj).intValue());
            case 6:
                return zzen.zzg(((Long) obj).longValue());
            case 7:
                return zzen.zzi(((Integer) obj).intValue());
            case 8:
                return zzen.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzen.zzc((zzgo) obj);
            case 10:
                if (obj instanceof zzfp) {
                    return zzen.zza((zzfp) obj);
                }
                return zzen.zzb((zzgo) obj);
            case 11:
                if (obj instanceof zzdu) {
                    return zzen.zzb((zzdu) obj);
                }
                return zzen.zzb((String) obj);
            case 12:
                if (obj instanceof zzdu) {
                    return zzen.zzb((zzdu) obj);
                }
                return zzen.zzb((byte[]) obj);
            case 13:
                return zzen.zzg(((Integer) obj).intValue());
            case 14:
                return zzen.zzj(((Integer) obj).intValue());
            case 15:
                return zzen.zzh(((Long) obj).longValue());
            case 16:
                return zzen.zzh(((Integer) obj).intValue());
            case 17:
                return zzen.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfi) {
                    return zzen.zzk(((zzfi) obj).zza());
                }
                return zzen.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzey<?> zzey, Object obj) {
        zzim zzb2 = zzey.zzb();
        int zza2 = zzey.zza();
        if (!zzey.zzd()) {
            return zza(zzb2, zza2, obj);
        }
        int i = 0;
        if (zzey.zze()) {
            for (Object zzb3 : (List) obj) {
                i += zzb(zzb2, zzb3);
            }
            return zzen.zze(zza2) + i + zzen.zzl(i);
        }
        for (Object zza3 : (List) obj) {
            i += zza(zzb2, zza2, zza3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzew zzew = new zzew();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zzew.zzb((zzey) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry next : this.zza.zzd()) {
            zzew.zzb((zzey) next.getKey(), next.getValue());
        }
        zzew.zzc = this.zzc;
        return zzew;
    }
}
