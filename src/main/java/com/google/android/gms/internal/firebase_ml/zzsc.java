package com.google.android.gms.internal.firebase_ml;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.vision.text.FirebaseVisionText;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzsc implements zzpc<FirebaseVisionText, zzrl>, zzpx {
    static boolean zzbjr = true;
    private final Context zzbdu;
    private final zzpo zzbfe;
    private final zzrg zzbjt = new zzrg();
    private TextRecognizer zzbog;

    zzsc(zzpn zzpn) {
        Preconditions.checkNotNull(zzpn, "MlKitContext can not be null");
        this.zzbdu = zzpn.getApplicationContext();
        this.zzbfe = zzpo.zza(zzpn, 1);
    }

    public final zzpx zznl() {
        return this;
    }

    public final synchronized void zznu() {
        if (this.zzbog == null) {
            this.zzbog = new TextRecognizer.Builder(this.zzbdu).build();
        }
    }

    public final synchronized void release() {
        if (this.zzbog != null) {
            this.zzbog.release();
            this.zzbog = null;
        }
        zzbjr = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final synchronized FirebaseVisionText zza(zzrl zzrl) throws FirebaseMLException {
        SparseArray<TextBlock> detect;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzbog == null) {
            zza(zznq.UNKNOWN_ERROR, elapsedRealtime, zzrl);
            throw new FirebaseMLException("Model source is unavailable. Please load the model resource first.", 13);
        } else if (this.zzbog.isOperational()) {
            this.zzbjt.zzc(zzrl);
            detect = this.zzbog.detect(zzrl.zzbkx);
            zza(zznq.NO_ERROR, elapsedRealtime, zzrl);
            zzbjr = false;
        } else {
            zza(zznq.MODEL_NOT_DOWNLOADED, elapsedRealtime, zzrl);
            throw new FirebaseMLException("Waiting for the text recognition model to be downloaded. Please wait.", 14);
        }
        return new FirebaseVisionText(detect);
    }

    private final void zza(zznq zznq, long j, zzrl zzrl) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zzbfe.zza(new zzsb(elapsedRealtime, zznq, zzrl), zznu.ON_DEVICE_TEXT_DETECT);
        zzpu zzpu = zzse.zzbhp;
        this.zzbfe.zza((zzng.zzg.zza) ((zzvx) zzng.zzg.zza.zzkg().zzh(zznq).zzv(zzbjr).zzg(zzrf.zzb(zzrl)).zztx()), elapsedRealtime, zznu.AGGREGATED_ON_DEVICE_TEXT_DETECTION, zzpu);
    }
}
