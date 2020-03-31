package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzgh extends zzgf<zzgs.zzd> {
    zzgh() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(zzic zzic) {
        return zzic instanceof zzgs.zze;
    }

    /* access modifiers changed from: package-private */
    public final zzgi<zzgs.zzd> zze(Object obj) {
        return ((zzgs.zze) obj).zzwk;
    }

    /* access modifiers changed from: package-private */
    public final zzgi<zzgs.zzd> zzf(Object obj) {
        return ((zzgs.zze) obj).zzgk();
    }

    /* access modifiers changed from: package-private */
    public final void zzg(Object obj) {
        zze(obj).zzdp();
    }

    /* access modifiers changed from: package-private */
    public final <UT, UB> UB zza(zzis zzis, Object obj, zzgd zzgd, zzgi<zzgs.zzd> zzgi, UB ub, zzjj<UT, UB> zzjj) throws IOException {
        Object zza;
        ArrayList arrayList;
        zzgs.zzg zzg = (zzgs.zzg) obj;
        int i = zzg.zzxb.number;
        if (!zzg.zzxb.zzwi || !zzg.zzxb.zzwj) {
            Object obj2 = null;
            if (zzg.zzxb.zzwh != zzka.ENUM) {
                switch (zzgg.zzrr[zzg.zzxb.zzwh.ordinal()]) {
                    case 1:
                        obj2 = Double.valueOf(zzis.readDouble());
                        break;
                    case 2:
                        obj2 = Float.valueOf(zzis.readFloat());
                        break;
                    case 3:
                        obj2 = Long.valueOf(zzis.zzdx());
                        break;
                    case 4:
                        obj2 = Long.valueOf(zzis.zzdw());
                        break;
                    case 5:
                        obj2 = Integer.valueOf(zzis.zzdy());
                        break;
                    case 6:
                        obj2 = Long.valueOf(zzis.zzdz());
                        break;
                    case 7:
                        obj2 = Integer.valueOf(zzis.zzea());
                        break;
                    case 8:
                        obj2 = Boolean.valueOf(zzis.zzeb());
                        break;
                    case 9:
                        obj2 = Integer.valueOf(zzis.zzee());
                        break;
                    case 10:
                        obj2 = Integer.valueOf(zzis.zzeg());
                        break;
                    case 11:
                        obj2 = Long.valueOf(zzis.zzeh());
                        break;
                    case 12:
                        obj2 = Integer.valueOf(zzis.zzei());
                        break;
                    case 13:
                        obj2 = Long.valueOf(zzis.zzej());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        obj2 = zzis.zzed();
                        break;
                    case 16:
                        obj2 = zzis.readString();
                        break;
                    case 17:
                        obj2 = zzis.zzb(zzg.zzxa.getClass(), zzgd);
                        break;
                    case 18:
                        obj2 = zzis.zza(zzg.zzxa.getClass(), zzgd);
                        break;
                }
            } else {
                int zzdy = zzis.zzdy();
                if (zzg.zzxb.zzwg.zzg(zzdy) == null) {
                    return zzit.zza(i, zzdy, ub, zzjj);
                }
                obj2 = Integer.valueOf(zzdy);
            }
            if (zzg.zzxb.zzwi) {
                zzgi.zzb(zzg.zzxb, obj2);
            } else {
                int i2 = zzgg.zzrr[zzg.zzxb.zzwh.ordinal()];
                if ((i2 == 17 || i2 == 18) && (zza = zzgi.zza(zzg.zzxb)) != null) {
                    obj2 = zzgt.zzb(zza, obj2);
                }
                zzgi.zza(zzg.zzxb, obj2);
            }
        } else {
            switch (zzgg.zzrr[zzg.zzxb.zzwh.ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    zzis.zza(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    zzis.zzb(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    zzis.zzd(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    zzis.zzc(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    zzis.zze(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    zzis.zzf(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    zzis.zzg(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    zzis.zzh(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    zzis.zzk(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    zzis.zzm(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    zzis.zzn(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    zzis.zzo(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    zzis.zzp(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    zzis.zzl(arrayList);
                    ub = zzit.zza(i, arrayList, zzg.zzxb.zzwg, ub, zzjj);
                    break;
                default:
                    String valueOf = String.valueOf(zzg.zzxb.zzwh);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
                    sb.append("Type cannot be packed: ");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
            }
            zzgi.zza(zzg.zzxb, arrayList);
        }
        return ub;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Map.Entry<?, ?> entry) {
        return ((zzgs.zzd) entry.getKey()).number;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkg zzkg, Map.Entry<?, ?> entry) throws IOException {
        zzgs.zzd zzd = (zzgs.zzd) entry.getKey();
        if (zzd.zzwi) {
            switch (zzgg.zzrr[zzd.zzwh.ordinal()]) {
                case 1:
                    zzit.zza(zzd.number, (List) entry.getValue(), zzkg, zzd.zzwj);
                    return;
                case 2:
                    zzit.zzb(zzd.number, (List) entry.getValue(), zzkg, zzd.zzwj);
                    return;
                case 3:
                    zzit.zzc(zzd.number, (List) entry.getValue(), zzkg, zzd.zzwj);
                    return;
                case 4:
                    zzit.zzd(zzd.number, (List) entry.getValue(), zzkg, zzd.zzwj);
                    return;
                case 5:
                    zzit.zzh(zzd.number, (List) entry.getValue(), zzkg, zzd.zzwj);
                    return;
                case 6:
                    zzit.zzf(zzd.number, (List) entry.getValue(), zzkg, zzd.zzwj);
                    return;
                case 7:
                    zzit.zzk(zzd.number, (List) entry.getValue(), zzkg, zzd.zzwj);
                    return;
                case 8:
                    zzit.zzn(zzd.number, (List) entry.getValue(), zzkg, zzd.zzwj);
                    return;
                case 9:
                    zzit.zzi(zzd.number, (List) entry.getValue(), zzkg, zzd.zzwj);
                    return;
                case 10:
                    zzit.zzl(zzd.number, (List) entry.getValue(), zzkg, zzd.zzwj);
                    return;
                case 11:
                    zzit.zzg(zzd.number, (List) entry.getValue(), zzkg, zzd.zzwj);
                    return;
                case 12:
                    zzit.zzj(zzd.number, (List) entry.getValue(), zzkg, zzd.zzwj);
                    return;
                case 13:
                    zzit.zze(zzd.number, (List) entry.getValue(), zzkg, zzd.zzwj);
                    return;
                case 14:
                    zzit.zzh(zzd.number, (List) entry.getValue(), zzkg, zzd.zzwj);
                    return;
                case 15:
                    zzit.zzb(zzd.number, (List) entry.getValue(), zzkg);
                    return;
                case 16:
                    zzit.zza(zzd.number, (List) entry.getValue(), zzkg);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        zzit.zzb(zzd.number, (List) entry.getValue(), zzkg, zzin.zzho().zzf(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        zzit.zza(zzd.number, (List) entry.getValue(), zzkg, zzin.zzho().zzf(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (zzgg.zzrr[zzd.zzwh.ordinal()]) {
                case 1:
                    zzkg.zza(zzd.number, ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    zzkg.zza(zzd.number, ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    zzkg.zzi(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    zzkg.zza(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    zzkg.zzh(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    zzkg.zzc(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    zzkg.zzk(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    zzkg.zza(zzd.number, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    zzkg.zzi(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    zzkg.zzr(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    zzkg.zzj(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    zzkg.zzj(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    zzkg.zzb(zzd.number, ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    zzkg.zzh(zzd.number, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    zzkg.zza(zzd.number, (zzfh) entry.getValue());
                    return;
                case 16:
                    zzkg.zza(zzd.number, (String) entry.getValue());
                    return;
                case 17:
                    zzkg.zzb(zzd.number, entry.getValue(), zzin.zzho().zzf(entry.getValue().getClass()));
                    return;
                case 18:
                    zzkg.zza(zzd.number, entry.getValue(), zzin.zzho().zzf(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Object zza(zzgd zzgd, zzic zzic, int i) {
        return zzgd.zza(zzic, i);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzis zzis, Object obj, zzgd zzgd, zzgi<zzgs.zzd> zzgi) throws IOException {
        zzgs.zzg zzg = (zzgs.zzg) obj;
        zzgi.zza(zzg.zzxb, zzis.zza(zzg.zzxa.getClass(), zzgd));
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzfh zzfh, Object obj, zzgd zzgd, zzgi<zzgs.zzd> zzgi) throws IOException {
        byte[] bArr;
        zzgs.zzg zzg = (zzgs.zzg) obj;
        zzic zzgb = zzg.zzxa.zzgj().zzgb();
        int size = zzfh.size();
        if (size == 0) {
            bArr = zzgt.zzxc;
        } else {
            byte[] bArr2 = new byte[size];
            zzfh.zza(bArr2, 0, 0, size);
            bArr = bArr2;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.hasArray()) {
            zzfg zzfg = new zzfg(wrap, true);
            zzin.zzho().zzu(zzgb).zza(zzgb, zzfg, zzgd);
            zzgi.zza(zzg.zzxb, zzgb);
            if (zzfg.zzdu() != Integer.MAX_VALUE) {
                throw zzhc.zzgq();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
