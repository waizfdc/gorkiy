package com.google.android.gms.internal.firebase_ml;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.vision.label.ImageLabeler;
import com.google.firebase.ml.vision.label.FirebaseVisionImageLabel;
import com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzrt implements zzpc<List<FirebaseVisionImageLabel>, zzrl>, zzpx {
    private static boolean zzbjr = true;
    private static volatile Boolean zzbmy;
    private final Context zzbdu;
    private final zzpo zzbfe;
    private final FirebaseVisionOnDeviceImageLabelerOptions zzbmz;
    private ImageLabeler zzbna;

    zzrt(zzpn zzpn, FirebaseVisionOnDeviceImageLabelerOptions firebaseVisionOnDeviceImageLabelerOptions) {
        Preconditions.checkNotNull(zzpn, "Context can not be null");
        Preconditions.checkNotNull(firebaseVisionOnDeviceImageLabelerOptions, "FirebaseVisionOnDeviceImageLabelerOptions can not be null");
        this.zzbdu = zzpn.getApplicationContext();
        this.zzbmz = firebaseVisionOnDeviceImageLabelerOptions;
        this.zzbfe = zzpo.zza(zzpn, 1);
    }

    public final zzpx zznl() {
        return this;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.google.firebase.ml.vision.label.FirebaseVisionImageLabel> zza(com.google.android.gms.internal.firebase_ml.zzrl r9) throws com.google.firebase.ml.common.FirebaseMLException {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.Boolean r0 = com.google.android.gms.internal.firebase_ml.zzrt.zzbmy     // Catch:{ all -> 0x0099 }
            r1 = 0
            if (r0 != 0) goto L_0x0027
            android.content.Context r0 = r8.zzbdu     // Catch:{ all -> 0x0099 }
            java.lang.String r2 = "com.google.android.gms.vision.dynamite.ica"
            int r2 = com.google.android.gms.dynamite.DynamiteModule.getLocalVersion(r0, r2)     // Catch:{ all -> 0x0099 }
            r3 = 1
            if (r2 > 0) goto L_0x001c
            java.lang.String r2 = "com.google.android.gms.vision.dynamite.imagelabel"
            int r0 = com.google.android.gms.dynamite.DynamiteModule.getLocalVersion(r0, r2)     // Catch:{ all -> 0x0099 }
            if (r0 <= 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r0 = r1
            goto L_0x001d
        L_0x001c:
            r0 = r3
        L_0x001d:
            if (r0 != 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r3 = r1
        L_0x0021:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0099 }
            com.google.android.gms.internal.firebase_ml.zzrt.zzbmy = r0     // Catch:{ all -> 0x0099 }
        L_0x0027:
            java.lang.Boolean r0 = com.google.android.gms.internal.firebase_ml.zzrt.zzbmy     // Catch:{ all -> 0x0099 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0099 }
            r2 = 14
            if (r0 != 0) goto L_0x0091
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0099 }
            com.google.android.gms.vision.label.ImageLabeler r0 = r8.zzbna     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x0082
            com.google.android.gms.vision.label.ImageLabeler r0 = r8.zzbna     // Catch:{ all -> 0x0099 }
            boolean r0 = r0.isOperational()     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x0075
            com.google.android.gms.vision.label.ImageLabeler r0 = r8.zzbna     // Catch:{ all -> 0x0099 }
            com.google.android.gms.vision.Frame r2 = r9.zzbkx     // Catch:{ all -> 0x0099 }
            android.util.SparseArray r0 = r0.detect(r2)     // Catch:{ all -> 0x0099 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0099 }
            r2.<init>()     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x006c
            r5 = r1
        L_0x0051:
            int r6 = r0.size()     // Catch:{ all -> 0x0099 }
            if (r5 >= r6) goto L_0x006c
            int r6 = r0.keyAt(r5)     // Catch:{ all -> 0x0099 }
            com.google.firebase.ml.vision.label.FirebaseVisionImageLabel r7 = new com.google.firebase.ml.vision.label.FirebaseVisionImageLabel     // Catch:{ all -> 0x0099 }
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x0099 }
            com.google.android.gms.vision.label.ImageLabel r6 = (com.google.android.gms.vision.label.ImageLabel) r6     // Catch:{ all -> 0x0099 }
            r7.<init>(r6)     // Catch:{ all -> 0x0099 }
            r2.add(r7)     // Catch:{ all -> 0x0099 }
            int r5 = r5 + 1
            goto L_0x0051
        L_0x006c:
            com.google.android.gms.internal.firebase_ml.zznq r0 = com.google.android.gms.internal.firebase_ml.zznq.NO_ERROR     // Catch:{ all -> 0x0099 }
            r8.zza(r0, r3, r9)     // Catch:{ all -> 0x0099 }
            com.google.android.gms.internal.firebase_ml.zzrt.zzbjr = r1     // Catch:{ all -> 0x0099 }
            monitor-exit(r8)
            return r2
        L_0x0075:
            com.google.android.gms.internal.firebase_ml.zznq r0 = com.google.android.gms.internal.firebase_ml.zznq.MODEL_NOT_DOWNLOADED     // Catch:{ all -> 0x0099 }
            r8.zza(r0, r3, r9)     // Catch:{ all -> 0x0099 }
            com.google.firebase.ml.common.FirebaseMLException r9 = new com.google.firebase.ml.common.FirebaseMLException     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = "Waiting for the label detection model to be downloaded. Please wait."
            r9.<init>(r0, r2)     // Catch:{ all -> 0x0099 }
            throw r9     // Catch:{ all -> 0x0099 }
        L_0x0082:
            com.google.android.gms.internal.firebase_ml.zznq r0 = com.google.android.gms.internal.firebase_ml.zznq.UNKNOWN_ERROR     // Catch:{ all -> 0x0099 }
            r8.zza(r0, r3, r9)     // Catch:{ all -> 0x0099 }
            com.google.firebase.ml.common.FirebaseMLException r9 = new com.google.firebase.ml.common.FirebaseMLException     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = "Model source is unavailable. Please load the model resource first."
            r1 = 13
            r9.<init>(r0, r1)     // Catch:{ all -> 0x0099 }
            throw r9     // Catch:{ all -> 0x0099 }
        L_0x0091:
            com.google.firebase.ml.common.FirebaseMLException r9 = new com.google.firebase.ml.common.FirebaseMLException     // Catch:{ all -> 0x0099 }
            java.lang.String r0 = "No model is bundled. Please check your app setup to includefirebase-ml-vision-image-label-model dependency."
            r9.<init>(r0, r2)     // Catch:{ all -> 0x0099 }
            throw r9     // Catch:{ all -> 0x0099 }
        L_0x0099:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzrt.zza(com.google.android.gms.internal.firebase_ml.zzrl):java.util.List");
    }

    public final synchronized void zznu() {
        if (this.zzbna == null) {
            this.zzbna = new ImageLabeler.Builder(this.zzbdu).setScoreThreshold(this.zzbmz.getConfidenceThreshold()).build();
        }
    }

    public final synchronized void release() {
        if (this.zzbna != null) {
            this.zzbna.release();
            this.zzbna = null;
        }
        zzbjr = true;
    }

    private final void zza(zznq zznq, long j, zzrl zzrl) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zzbfe.zza(new zzrs(this, elapsedRealtime, zznq, zzrl), zznu.ON_DEVICE_IMAGE_LABEL_DETECT);
        zzpu zzpu = zzrv.zzbhp;
        this.zzbfe.zza((zzng.zze.zza) ((zzvx) zzng.zze.zza.zzka().zzf(zznq).zzr(zzbjr).zze(zzrf.zzb(zzrl)).zzb(this.zzbmz.zzqe()).zztx()), elapsedRealtime, zznu.AGGREGATED_ON_DEVICE_IMAGE_LABEL_DETECTION, zzpu);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzng.zzab.zza zza(long j, zznq zznq, zzrl zzrl) {
        return zzng.zzab.zzln().zzb((zzng.zzam) ((zzvx) zzng.zzam.zzmk().zze(zzng.zzad.zzlr().zzj(j).zzk(zznq).zzae(zzbjr).zzaf(true).zzag(true)).zzc(this.zzbmz.zzqe()).zzk(zzrf.zzb(zzrl)).zztx()));
    }
}
