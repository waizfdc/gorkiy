package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzky;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
public final class zzgp extends zzfb {
    /* access modifiers changed from: private */
    public final zzks zza;
    private Boolean zzb;
    private String zzc;

    public zzgp(zzks zzks) {
        this(zzks, null);
    }

    private zzgp(zzks zzks, String str) {
        Preconditions.checkNotNull(zzks);
        this.zza = zzks;
        this.zzc = null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void
     arg types: [com.google.android.gms.measurement.internal.zzm, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):com.google.android.gms.measurement.internal.zzan
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void */
    public final void zzb(zzm zzm) {
        zzb(zzm, false);
        zza(new zzgs(this, zzm));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void
     arg types: [com.google.android.gms.measurement.internal.zzm, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):com.google.android.gms.measurement.internal.zzan
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void */
    public final void zza(zzan zzan, zzm zzm) {
        Preconditions.checkNotNull(zzan);
        zzb(zzm, false);
        zza(new zzgx(this, zzan, zzm));
    }

    /* access modifiers changed from: package-private */
    public final zzan zzb(zzan zzan, zzm zzm) {
        boolean z = false;
        if (!(!"_cmp".equals(zzan.zza) || zzan.zzb == null || zzan.zzb.zza() == 0)) {
            String zzd = zzan.zzb.zzd("_cis");
            if (!TextUtils.isEmpty(zzd) && (("referrer broadcast".equals(zzd) || "referrer API".equals(zzd)) && this.zza.zzb().zze(zzm.zza, zzap.zzaq))) {
                z = true;
            }
        }
        if (!z) {
            return zzan;
        }
        this.zza.zzr().zzv().zza("Event has been filtered ", zzan.toString());
        return new zzan("_cmpx", zzan.zzb, zzan.zzc, zzan.zzd);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzm, boolean):java.util.List<com.google.android.gms.measurement.internal.zzkz>
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzkz, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzv, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):byte[]
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzm, boolean):java.util.List<com.google.android.gms.measurement.internal.zzkz>
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzkz, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzv, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):byte[]
      com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, boolean):void */
    public final void zza(zzan zzan, String str, String str2) {
        Preconditions.checkNotNull(zzan);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zza(new zzha(this, zzan, str));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzm, boolean):java.util.List<com.google.android.gms.measurement.internal.zzkz>
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzkz, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzv, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):byte[]
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzm, boolean):java.util.List<com.google.android.gms.measurement.internal.zzkz>
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzkz, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzv, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):byte[]
      com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, boolean):void */
    public final byte[] zza(zzan zzan, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzan);
        zza(str, true);
        this.zza.zzr().zzw().zza("Log and bundle. event", this.zza.zzi().zza(zzan.zza));
        long nanoTime = this.zza.zzm().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzq().zzb(new zzgz(this, zzan, str)).get();
            if (bArr == null) {
                this.zza.zzr().zzf().zza("Log and bundle returned null. appId", zzfk.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzr().zzw().zza("Log and bundle processed. event, size, time_ms", this.zza.zzi().zza(zzan.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzm().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to log and bundle. appId, event, error", zzfk.zza(str), this.zza.zzi().zza(zzan.zza), e);
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void
     arg types: [com.google.android.gms.measurement.internal.zzm, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):com.google.android.gms.measurement.internal.zzan
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void */
    public final void zza(zzkz zzkz, zzm zzm) {
        Preconditions.checkNotNull(zzkz);
        zzb(zzm, false);
        zza(new zzhc(this, zzkz, zzm));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void
     arg types: [com.google.android.gms.measurement.internal.zzm, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):com.google.android.gms.measurement.internal.zzan
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void */
    public final List<zzkz> zza(zzm zzm, boolean z) {
        zzb(zzm, false);
        try {
            List<zzlb> list = (List) this.zza.zzq().zza(new zzhb(this, zzm)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzlb zzlb : list) {
                if (z || !zzla.zze(zzlb.zzc)) {
                    arrayList.add(new zzkz(zzlb));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            if (!zzky.zzb() || !this.zza.zzb().zze(zzm.zza, zzap.zzcz)) {
                this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzfk.zza(zzm.zza), e);
                return null;
            }
            this.zza.zzr().zzf().zza("Failed to get user properties. appId", zzfk.zza(zzm.zza), e);
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void
     arg types: [com.google.android.gms.measurement.internal.zzm, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):com.google.android.gms.measurement.internal.zzan
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void */
    public final void zza(zzm zzm) {
        zzb(zzm, false);
        zza(new zzhe(this, zzm));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzm, boolean):java.util.List<com.google.android.gms.measurement.internal.zzkz>
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzkz, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzv, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):byte[]
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzm, boolean):java.util.List<com.google.android.gms.measurement.internal.zzkz>
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzkz, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzv, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):byte[]
      com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, boolean):void */
    private final void zzb(zzm zzm, boolean z) {
        Preconditions.checkNotNull(zzm);
        zza(zzm.zza, false);
        this.zza.zzj().zza(zzm.zzb, zzm.zzr, zzm.zzv);
    }

    private final void zza(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzn(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zza.zzn()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzb = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zza.zzr().zzf().zza("Measurement Service called with invalid calling package. appId", zzfk.zza(str));
                    throw e;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzn(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
            }
            return;
        }
        this.zza.zzr().zzf().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    public final void zza(long j, String str, String str2, String str3) {
        zza(new zzhd(this, str2, str3, str, j));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void
     arg types: [com.google.android.gms.measurement.internal.zzm, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):com.google.android.gms.measurement.internal.zzan
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void */
    public final String zzc(zzm zzm) {
        zzb(zzm, false);
        return this.zza.zzd(zzm);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void
     arg types: [com.google.android.gms.measurement.internal.zzm, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):com.google.android.gms.measurement.internal.zzan
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void */
    public final void zza(zzv zzv, zzm zzm) {
        Preconditions.checkNotNull(zzv);
        Preconditions.checkNotNull(zzv.zzc);
        zzb(zzm, false);
        zzv zzv2 = new zzv(zzv);
        zzv2.zza = zzm.zza;
        zza(new zzhg(this, zzv2, zzm));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzm, boolean):java.util.List<com.google.android.gms.measurement.internal.zzkz>
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzkz, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzv, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):byte[]
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzm, boolean):java.util.List<com.google.android.gms.measurement.internal.zzkz>
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzkz, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzv, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):byte[]
      com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, boolean):void */
    public final void zza(zzv zzv) {
        Preconditions.checkNotNull(zzv);
        Preconditions.checkNotNull(zzv.zzc);
        zza(zzv.zza, true);
        zza(new zzgr(this, new zzv(zzv)));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void
     arg types: [com.google.android.gms.measurement.internal.zzm, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):com.google.android.gms.measurement.internal.zzan
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void */
    public final List<zzkz> zza(String str, String str2, boolean z, zzm zzm) {
        zzb(zzm, false);
        try {
            List<zzlb> list = (List) this.zza.zzq().zza(new zzgu(this, zzm, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzlb zzlb : list) {
                if (z || !zzla.zze(zzlb.zzc)) {
                    arrayList.add(new zzkz(zzlb));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            if (!zzky.zzb() || !this.zza.zzb().zze(zzm.zza, zzap.zzcz)) {
                this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzfk.zza(zzm.zza), e);
            } else {
                this.zza.zzr().zzf().zza("Failed to query user properties. appId", zzfk.zza(zzm.zza), e);
            }
            return Collections.emptyList();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzm, boolean):java.util.List<com.google.android.gms.measurement.internal.zzkz>
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzkz, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzv, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):byte[]
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzm, boolean):java.util.List<com.google.android.gms.measurement.internal.zzkz>
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzkz, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzv, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):byte[]
      com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, boolean):void */
    public final List<zzkz> zza(String str, String str2, String str3, boolean z) {
        zza(str, true);
        try {
            List<zzlb> list = (List) this.zza.zzq().zza(new zzgt(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzlb zzlb : list) {
                if (z || !zzla.zze(zzlb.zzc)) {
                    arrayList.add(new zzkz(zzlb));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            if (!zzky.zzb() || !this.zza.zzb().zze(str, zzap.zzcz)) {
                this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzfk.zza(str), e);
            } else {
                this.zza.zzr().zzf().zza("Failed to get user properties as. appId", zzfk.zza(str), e);
            }
            return Collections.emptyList();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void
     arg types: [com.google.android.gms.measurement.internal.zzm, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):com.google.android.gms.measurement.internal.zzan
      com.google.android.gms.measurement.internal.zzgp.zzb(com.google.android.gms.measurement.internal.zzm, boolean):void */
    public final List<zzv> zza(String str, String str2, zzm zzm) {
        zzb(zzm, false);
        try {
            return (List) this.zza.zzq().zza(new zzgw(this, zzm, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzm, boolean):java.util.List<com.google.android.gms.measurement.internal.zzkz>
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzkz, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzv, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):byte[]
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzm, boolean):java.util.List<com.google.android.gms.measurement.internal.zzkz>
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzkz, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzv, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):byte[]
      com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, boolean):void */
    public final List<zzv> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzq().zza(new zzgv(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            if (!zzky.zzb() || !this.zza.zzb().zze(str, zzap.zzcz)) {
                this.zza.zzr().zzf().zza("Failed to get conditional user properties", e);
            } else {
                this.zza.zzr().zzf().zza("Failed to get conditional user properties as", e);
            }
            return Collections.emptyList();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzm, boolean):java.util.List<com.google.android.gms.measurement.internal.zzkz>
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzkz, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzv, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzgp.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):byte[]
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzm, boolean):java.util.List<com.google.android.gms.measurement.internal.zzkz>
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzkz, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzv, com.google.android.gms.measurement.internal.zzm):void
      com.google.android.gms.measurement.internal.zzfc.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):byte[]
      com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, boolean):void */
    public final void zzd(zzm zzm) {
        zza(zzm.zza, false);
        zza(new zzgy(this, zzm));
    }

    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzq().zzg()) {
            runnable.run();
        } else {
            this.zza.zzq().zza(runnable);
        }
    }
}
