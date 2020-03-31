package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzll;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzir extends zzkp {
    public zzir(zzks zzks) {
        super(zzks);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzla.zza(android.os.Bundle, java.lang.String, java.lang.Object):void
     arg types: [android.os.Bundle, java.lang.String, long]
     candidates:
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, int, boolean):java.lang.String
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, int, java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String, java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(java.lang.String, java.lang.String[], java.lang.String):boolean
      com.google.android.gms.measurement.internal.zzla.zza(android.os.Bundle, java.lang.String, java.lang.Object):void */
    public final byte[] zza(zzan zzan, String str) {
        zzlb zzlb;
        zzbr.zzf.zza zza;
        zzbr.zzg.zza zza2;
        zzg zzg;
        byte[] bArr;
        Bundle bundle;
        zzaj zzaj;
        long j;
        zzan zzan2 = zzan;
        String str2 = str;
        zzd();
        this.zzx.zzaf();
        Preconditions.checkNotNull(zzan);
        Preconditions.checkNotEmpty(str);
        if (!zzt().zze(str2, zzap.zzbf)) {
            zzr().zzw().zza("Generating ScionPayload disabled. packageName", str2);
            return new byte[0];
        } else if ("_iap".equals(zzan2.zza) || "_iapx".equals(zzan2.zza)) {
            zzbr.zzf.zza zzb = zzbr.zzf.zzb();
            zzi().zzf();
            try {
                zzg zzb2 = zzi().zzb(str2);
                if (zzb2 == null) {
                    zzr().zzw().zza("Log and bundle not available. package_name", str2);
                    return new byte[0];
                } else if (!zzb2.zzr()) {
                    zzr().zzw().zza("Log and bundle disabled. package_name", str2);
                    byte[] bArr2 = new byte[0];
                    zzi().zzh();
                    return bArr2;
                } else {
                    zzbr.zzg.zza zza3 = zzbr.zzg.zzbf().zza(1).zza(AbstractSpiCall.ANDROID_CLIENT_TYPE);
                    if (!TextUtils.isEmpty(zzb2.zzc())) {
                        zza3.zzf(zzb2.zzc());
                    }
                    if (!TextUtils.isEmpty(zzb2.zzn())) {
                        zza3.zze(zzb2.zzn());
                    }
                    if (!TextUtils.isEmpty(zzb2.zzl())) {
                        zza3.zzg(zzb2.zzl());
                    }
                    if (zzb2.zzm() != -2147483648L) {
                        zza3.zzh((int) zzb2.zzm());
                    }
                    zza3.zzf(zzb2.zzo()).zzk(zzb2.zzq());
                    if (!zzll.zzb() || !zzt().zze(zzb2.zzc(), zzap.zzch)) {
                        if (!TextUtils.isEmpty(zzb2.zze())) {
                            zza3.zzk(zzb2.zze());
                        } else if (!TextUtils.isEmpty(zzb2.zzf())) {
                            zza3.zzo(zzb2.zzf());
                        }
                    } else if (!TextUtils.isEmpty(zzb2.zze())) {
                        zza3.zzk(zzb2.zze());
                    } else if (!TextUtils.isEmpty(zzb2.zzg())) {
                        zza3.zzp(zzb2.zzg());
                    } else if (!TextUtils.isEmpty(zzb2.zzf())) {
                        zza3.zzo(zzb2.zzf());
                    }
                    zza3.zzh(zzb2.zzp());
                    if (this.zzx.zzab() && zzt().zzf(zza3.zzj())) {
                        zza3.zzj();
                        if (!TextUtils.isEmpty(null)) {
                            zza3.zzn(null);
                        }
                    }
                    Pair<String, Boolean> zza4 = zzs().zza(zzb2.zzc());
                    if (zzb2.zzaf() && zza4 != null && !TextUtils.isEmpty((CharSequence) zza4.first)) {
                        zza3.zzh(zza((String) zza4.first, Long.toString(zzan2.zzd)));
                        if (zza4.second != null) {
                            zza3.zza(((Boolean) zza4.second).booleanValue());
                        }
                    }
                    zzl().zzaa();
                    zzbr.zzg.zza zzc = zza3.zzc(Build.MODEL);
                    zzl().zzaa();
                    zzc.zzb(Build.VERSION.RELEASE).zzf((int) zzl().zzf()).zzd(zzl().zzg());
                    try {
                        zza3.zzi(zza(zzb2.zzd(), Long.toString(zzan2.zzd)));
                        if (!TextUtils.isEmpty(zzb2.zzi())) {
                            zza3.zzl(zzb2.zzi());
                        }
                        String zzc2 = zzb2.zzc();
                        List<zzlb> zza5 = zzi().zza(zzc2);
                        Iterator<zzlb> it = zza5.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                zzlb = null;
                                break;
                            }
                            zzlb = it.next();
                            if ("_lte".equals(zzlb.zzc)) {
                                break;
                            }
                        }
                        if (zzlb == null || zzlb.zze == null) {
                            zzlb zzlb2 = new zzlb(zzc2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzm().currentTimeMillis(), 0L);
                            zza5.add(zzlb2);
                            zzi().zza(zzlb2);
                        }
                        if (zzt().zze(zzc2, zzap.zzbc)) {
                            zzkw zzg2 = zzg();
                            zzg2.zzr().zzx().zza("Checking account type status for ad personalization signals");
                            if (zzg2.zzl().zzj()) {
                                String zzc3 = zzb2.zzc();
                                if (zzb2.zzaf() && zzg2.zzj().zze(zzc3)) {
                                    zzg2.zzr().zzw().zza("Turning off ad personalization due to account type");
                                    Iterator<zzlb> it2 = zza5.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        } else if ("_npa".equals(it2.next().zzc)) {
                                            it2.remove();
                                            break;
                                        }
                                    }
                                    zza5.add(new zzlb(zzc3, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_npa", zzg2.zzm().currentTimeMillis(), 1L));
                                }
                            }
                        }
                        zzbr.zzk[] zzkArr = new zzbr.zzk[zza5.size()];
                        for (int i = 0; i < zza5.size(); i++) {
                            zzbr.zzk.zza zza6 = zzbr.zzk.zzj().zza(zza5.get(i).zzc).zza(zza5.get(i).zzd);
                            zzg().zza(zza6, zza5.get(i).zze);
                            zzkArr[i] = (zzbr.zzk) ((zzfd) zza6.zzu());
                        }
                        zza3.zzb(Arrays.asList(zzkArr));
                        Bundle zzb3 = zzan2.zzb.zzb();
                        zzb3.putLong("_c", 1);
                        zzr().zzw().zza("Marking in-app purchase as real-time");
                        zzb3.putLong("_r", 1);
                        zzb3.putString("_o", zzan2.zzc);
                        if (zzp().zzf(zza3.zzj())) {
                            zzp().zza(zzb3, "_dbg", (Object) 1L);
                            zzp().zza(zzb3, "_r", (Object) 1L);
                        }
                        zzaj zza7 = zzi().zza(str2, zzan2.zza);
                        if (zza7 == null) {
                            zzg = zzb2;
                            zza2 = zza3;
                            zza = zzb;
                            bundle = zzb3;
                            bArr = null;
                            zzaj = new zzaj(str, zzan2.zza, 0, 0, zzan2.zzd, 0, null, null, null, null);
                            j = 0;
                        } else {
                            zzg = zzb2;
                            zza2 = zza3;
                            zza = zzb;
                            bundle = zzb3;
                            bArr = null;
                            j = zza7.zzf;
                            zzaj = zza7.zza(zzan2.zzd);
                        }
                        zzi().zza(zzaj);
                        zzak zzak = new zzak(this.zzx, zzan2.zzc, str, zzan2.zza, zzan2.zzd, j, bundle);
                        zzbr.zzc.zza zzb4 = zzbr.zzc.zzj().zza(zzak.zzc).zza(zzak.zzb).zzb(zzak.zzd);
                        Iterator<String> it3 = zzak.zze.iterator();
                        while (it3.hasNext()) {
                            String next = it3.next();
                            zzbr.zze.zza zza8 = zzbr.zze.zzk().zza(next);
                            zzg().zza(zza8, zzak.zze.zza(next));
                            zzb4.zza(zza8);
                        }
                        zzbr.zzg.zza zza9 = zza2;
                        zza9.zza(zzb4).zza(zzbr.zzh.zza().zza(zzbr.zzd.zza().zza(zzaj.zzc).zza(zzan2.zza)));
                        zza9.zzc(e_().zza(zzg.zzc(), Collections.emptyList(), zza9.zzd(), Long.valueOf(zzb4.zzf()), Long.valueOf(zzb4.zzf())));
                        if (zzb4.zze()) {
                            zza9.zzb(zzb4.zzf()).zzc(zzb4.zzf());
                        }
                        long zzk = zzg.zzk();
                        int i2 = (zzk > 0 ? 1 : (zzk == 0 ? 0 : -1));
                        if (i2 != 0) {
                            zza9.zze(zzk);
                        }
                        long zzj = zzg.zzj();
                        if (zzj != 0) {
                            zza9.zzd(zzj);
                        } else if (i2 != 0) {
                            zza9.zzd(zzk);
                        }
                        zzg.zzv();
                        zza9.zzg((int) zzg.zzs()).zzg(zzt().zze()).zza(zzm().currentTimeMillis()).zzb(Boolean.TRUE.booleanValue());
                        zzbr.zzf.zza zza10 = zza;
                        zza10.zza(zza9);
                        zzg zzg3 = zzg;
                        zzg3.zza(zza9.zzf());
                        zzg3.zzb(zza9.zzg());
                        zzi().zza(zzg3);
                        zzi().b_();
                        zzi().zzh();
                        try {
                            return zzg().zzc(((zzbr.zzf) ((zzfd) zza10.zzu())).zzbi());
                        } catch (IOException e) {
                            zzr().zzf().zza("Data loss. Failed to bundle and serialize. appId", zzfk.zza(str), e);
                            return bArr;
                        }
                    } catch (SecurityException e2) {
                        zzr().zzw().zza("app instance id encryption failed", e2.getMessage());
                        byte[] bArr3 = new byte[0];
                        zzi().zzh();
                        return bArr3;
                    }
                }
            } catch (SecurityException e3) {
                zzr().zzw().zza("Resettable device id encryption failed", e3.getMessage());
                return new byte[0];
            } finally {
                zzi().zzh();
            }
        } else {
            zzr().zzw().zza("Generating a payload for this event is not available. package_name, event_name", str2, zzan2.zza);
            return null;
        }
    }

    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
