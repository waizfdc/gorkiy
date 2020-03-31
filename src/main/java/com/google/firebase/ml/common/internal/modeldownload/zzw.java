package com.google.firebase.ml.common.internal.modeldownload;

import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznq;
import com.google.android.gms.internal.firebase_ml.zznu;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzpo;
import com.google.android.gms.internal.firebase_ml.zzqc;
import com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzw {
    private static final GmsLogger zzbbo = new GmsLogger("ModelDownloadLogger", "");
    private final zzqc zzbcm;
    private final FirebaseRemoteModel zzbfa;
    private final zzpo zzbfe;

    public zzw(zzpn zzpn, FirebaseRemoteModel firebaseRemoteModel) {
        this.zzbfe = zzpo.zza(zzpn, 4);
        this.zzbfa = firebaseRemoteModel;
        this.zzbcm = zzqc.zzb(zzpn);
    }

    public final void zza(zznq zznq, String str, boolean z, zzn zzn) {
        zza(zznq, str, false, false, zzn, zzng.zzag.zzb.UNKNOWN_STATUS, 0);
    }

    private final void zza(zznq zznq, String str, boolean z, boolean z2, zzn zzn, zzng.zzag.zzb zzb, int i) {
        zzng.zzag.zza zzk = zzng.zzag.zzlw().zzl(zznq).zza(zzb).zzn((long) i).zzk(zzt.zza(this.zzbfa, zzn));
        if (z) {
            long zzf = this.zzbcm.zzf(this.zzbfa);
            if (zzf == 0) {
                zzbbo.w("ModelDownloadLogger", "Model downloaded without its beginning time recorded.");
            } else {
                long zzg = this.zzbcm.zzg(this.zzbfa);
                if (zzg == 0) {
                    zzg = SystemClock.elapsedRealtime();
                    this.zzbcm.zza(this.zzbfa, zzg);
                }
                zzk.zzl(zzg - zzf);
            }
        }
        if (z2) {
            long zzf2 = this.zzbcm.zzf(this.zzbfa);
            if (zzf2 == 0) {
                zzbbo.w("ModelDownloadLogger", "Model downloaded without its beginning time recorded.");
            } else {
                zzk.zzm(SystemClock.elapsedRealtime() - zzf2);
            }
        }
        this.zzbfe.zza(zzng.zzab.zzln().zza(zzng.zzaw.zznh().zzbs(str)).zza(zzk), zznu.MODEL_DOWNLOAD);
    }

    public final void zza(zznq zznq, boolean z, zzn zzn, zzng.zzag.zzb zzb) {
        zza(zznq, "NA", z, false, zzn, zzb, 0);
    }

    public final void zza(zznq zznq, zzn zzn, zzng.zzag.zzb zzb) {
        zza(zznq, "NA", false, true, zzn, zzb, 0);
    }

    public final void zza(boolean z, zzn zzn, int i) {
        zza(zznq.DOWNLOAD_FAILED, "NA", false, false, zzn, zzng.zzag.zzb.FAILED, i);
    }

    /* access modifiers changed from: package-private */
    public final void zzo(zznq zznq) {
        zza(zznq, 0);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zznq zznq, int i) {
        zza(zznq, "NA", false, false, zzn.UNKNOWN, zzng.zzag.zzb.MODEL_INFO_RETRIEVAL_FAILED, i);
    }
}
