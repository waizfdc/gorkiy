package com.google.android.gms.internal.firebase_ml;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.vision.dynamite.face.ModuleDescriptor;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.vision.face.FirebaseVisionFace;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzro implements zzpc<List<FirebaseVisionFace>, zzrl>, zzpx {
    private static AtomicBoolean zzbhb = new AtomicBoolean(true);
    private static volatile Boolean zzbmj;
    private final Context zzbdu;
    private final zzpo zzbfe;
    private final zzrg zzbjt = new zzrg();
    private final FirebaseVisionFaceDetectorOptions zzbmk;
    private FaceDetector zzbml;
    private FaceDetector zzbmm;

    public zzro(zzpn zzpn, FirebaseVisionFaceDetectorOptions firebaseVisionFaceDetectorOptions) {
        Preconditions.checkNotNull(zzpn, "MlKitContext can not be null");
        Preconditions.checkNotNull(firebaseVisionFaceDetectorOptions, "FirebaseVisionFaceDetectorOptions can not be null");
        this.zzbdu = zzpn.getApplicationContext();
        this.zzbmk = firebaseVisionFaceDetectorOptions;
        this.zzbfe = zzpo.zza(zzpn, 1);
    }

    public final zzpx zznl() {
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00e6, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zznu() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r0 = r3.zzbmk     // Catch:{ all -> 0x00e7 }
            int r0 = r0.getContourMode()     // Catch:{ all -> 0x00e7 }
            r1 = 2
            if (r0 != r1) goto L_0x0096
            com.google.android.gms.vision.face.FaceDetector r0 = r3.zzbmm     // Catch:{ all -> 0x00e7 }
            if (r0 != 0) goto L_0x002d
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = new com.google.android.gms.vision.face.FaceDetector$Builder     // Catch:{ all -> 0x00e7 }
            android.content.Context r2 = r3.zzbdu     // Catch:{ all -> 0x00e7 }
            r0.<init>(r2)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = r0.setLandmarkType(r1)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = r0.setMode(r1)     // Catch:{ all -> 0x00e7 }
            r2 = 0
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = r0.setTrackingEnabled(r2)     // Catch:{ all -> 0x00e7 }
            r2 = 1
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = r0.setProminentFaceOnly(r2)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector r0 = r0.build()     // Catch:{ all -> 0x00e7 }
            r3.zzbmm = r0     // Catch:{ all -> 0x00e7 }
        L_0x002d:
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r0 = r3.zzbmk     // Catch:{ all -> 0x00e7 }
            int r0 = r0.getLandmarkMode()     // Catch:{ all -> 0x00e7 }
            if (r0 == r1) goto L_0x0045
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r0 = r3.zzbmk     // Catch:{ all -> 0x00e7 }
            int r0 = r0.getClassificationMode()     // Catch:{ all -> 0x00e7 }
            if (r0 == r1) goto L_0x0045
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r0 = r3.zzbmk     // Catch:{ all -> 0x00e7 }
            int r0 = r0.getPerformanceMode()     // Catch:{ all -> 0x00e7 }
            if (r0 != r1) goto L_0x00e5
        L_0x0045:
            com.google.android.gms.vision.face.FaceDetector r0 = r3.zzbml     // Catch:{ all -> 0x00e7 }
            if (r0 != 0) goto L_0x00e5
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = new com.google.android.gms.vision.face.FaceDetector$Builder     // Catch:{ all -> 0x00e7 }
            android.content.Context r1 = r3.zzbdu     // Catch:{ all -> 0x00e7 }
            r0.<init>(r1)     // Catch:{ all -> 0x00e7 }
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r1 = r3.zzbmk     // Catch:{ all -> 0x00e7 }
            int r1 = r1.getLandmarkMode()     // Catch:{ all -> 0x00e7 }
            int r1 = com.google.android.gms.internal.firebase_ml.zzrf.zzbu(r1)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = r0.setLandmarkType(r1)     // Catch:{ all -> 0x00e7 }
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r1 = r3.zzbmk     // Catch:{ all -> 0x00e7 }
            int r1 = r1.getClassificationMode()     // Catch:{ all -> 0x00e7 }
            int r1 = com.google.android.gms.internal.firebase_ml.zzrf.zzbw(r1)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = r0.setClassificationType(r1)     // Catch:{ all -> 0x00e7 }
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r1 = r3.zzbmk     // Catch:{ all -> 0x00e7 }
            int r1 = r1.getPerformanceMode()     // Catch:{ all -> 0x00e7 }
            int r1 = com.google.android.gms.internal.firebase_ml.zzrf.zzbv(r1)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = r0.setMode(r1)     // Catch:{ all -> 0x00e7 }
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r1 = r3.zzbmk     // Catch:{ all -> 0x00e7 }
            float r1 = r1.getMinFaceSize()     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = r0.setMinFaceSize(r1)     // Catch:{ all -> 0x00e7 }
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r1 = r3.zzbmk     // Catch:{ all -> 0x00e7 }
            boolean r1 = r1.isTrackingEnabled()     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = r0.setTrackingEnabled(r1)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector r0 = r0.build()     // Catch:{ all -> 0x00e7 }
            r3.zzbml = r0     // Catch:{ all -> 0x00e7 }
            monitor-exit(r3)
            return
        L_0x0096:
            com.google.android.gms.vision.face.FaceDetector r0 = r3.zzbml     // Catch:{ all -> 0x00e7 }
            if (r0 != 0) goto L_0x00e5
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = new com.google.android.gms.vision.face.FaceDetector$Builder     // Catch:{ all -> 0x00e7 }
            android.content.Context r1 = r3.zzbdu     // Catch:{ all -> 0x00e7 }
            r0.<init>(r1)     // Catch:{ all -> 0x00e7 }
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r1 = r3.zzbmk     // Catch:{ all -> 0x00e7 }
            int r1 = r1.getLandmarkMode()     // Catch:{ all -> 0x00e7 }
            int r1 = com.google.android.gms.internal.firebase_ml.zzrf.zzbu(r1)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = r0.setLandmarkType(r1)     // Catch:{ all -> 0x00e7 }
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r1 = r3.zzbmk     // Catch:{ all -> 0x00e7 }
            int r1 = r1.getClassificationMode()     // Catch:{ all -> 0x00e7 }
            int r1 = com.google.android.gms.internal.firebase_ml.zzrf.zzbw(r1)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = r0.setClassificationType(r1)     // Catch:{ all -> 0x00e7 }
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r1 = r3.zzbmk     // Catch:{ all -> 0x00e7 }
            int r1 = r1.getPerformanceMode()     // Catch:{ all -> 0x00e7 }
            int r1 = com.google.android.gms.internal.firebase_ml.zzrf.zzbv(r1)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = r0.setMode(r1)     // Catch:{ all -> 0x00e7 }
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r1 = r3.zzbmk     // Catch:{ all -> 0x00e7 }
            float r1 = r1.getMinFaceSize()     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = r0.setMinFaceSize(r1)     // Catch:{ all -> 0x00e7 }
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r1 = r3.zzbmk     // Catch:{ all -> 0x00e7 }
            boolean r1 = r1.isTrackingEnabled()     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector$Builder r0 = r0.setTrackingEnabled(r1)     // Catch:{ all -> 0x00e7 }
            com.google.android.gms.vision.face.FaceDetector r0 = r0.build()     // Catch:{ all -> 0x00e7 }
            r3.zzbml = r0     // Catch:{ all -> 0x00e7 }
        L_0x00e5:
            monitor-exit(r3)
            return
        L_0x00e7:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzro.zznu():void");
    }

    public final synchronized void release() {
        if (this.zzbml != null) {
            this.zzbml.release();
            this.zzbml = null;
        }
        if (this.zzbmm != null) {
            this.zzbmm.release();
            this.zzbmm = null;
        }
        zzbhb.set(true);
    }

    private final synchronized List<FirebaseVisionFace> zza(FaceDetector faceDetector, zzrl zzrl, long j) throws FirebaseMLException {
        ArrayList arrayList;
        if (this.zzbmm != null) {
            if (zzbmj == null) {
                zzbmj = Boolean.valueOf(DynamiteModule.getLocalVersion(this.zzbdu, ModuleDescriptor.MODULE_ID) > 0);
            }
            if (!zzbmj.booleanValue()) {
                throw new FirebaseMLException("No Face Contour model is bundled. Please check your app setup to include firebase-ml-vision-face-model dependency.", 14);
            }
        }
        if (faceDetector.isOperational()) {
            SparseArray<Face> detect = faceDetector.detect(zzrl.zzbkx);
            arrayList = new ArrayList();
            for (int i = 0; i < detect.size(); i++) {
                arrayList.add(new FirebaseVisionFace(detect.get(detect.keyAt(i))));
            }
        } else {
            zza(zznq.MODEL_NOT_DOWNLOADED, j, zzrl, 0, 0);
            throw new FirebaseMLException("Waiting for the face detection model to be downloaded. Please wait.", 14);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.google.firebase.ml.vision.face.FirebaseVisionFace> zza(com.google.android.gms.internal.firebase_ml.zzrl r22) throws com.google.firebase.ml.common.FirebaseMLException {
        /*
            r21 = this;
            r8 = r21
            r0 = r22
            monitor-enter(r21)
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0157 }
            com.google.android.gms.vision.face.FaceDetector r1 = r8.zzbml     // Catch:{ all -> 0x0157 }
            r9 = 13
            if (r1 != 0) goto L_0x0027
            com.google.android.gms.vision.face.FaceDetector r1 = r8.zzbmm     // Catch:{ all -> 0x0157 }
            if (r1 == 0) goto L_0x0014
            goto L_0x0027
        L_0x0014:
            com.google.android.gms.internal.firebase_ml.zznq r2 = com.google.android.gms.internal.firebase_ml.zznq.UNKNOWN_ERROR     // Catch:{ all -> 0x0157 }
            r6 = 0
            r7 = 0
            r1 = r21
            r5 = r22
            r1.zza(r2, r3, r5, r6, r7)     // Catch:{ all -> 0x0157 }
            com.google.firebase.ml.common.FirebaseMLException r0 = new com.google.firebase.ml.common.FirebaseMLException     // Catch:{ all -> 0x0157 }
            java.lang.String r1 = "Face detector wasn't initialized correctly. This is most likely caused by invalid face detector options."
            r0.<init>(r1, r9)     // Catch:{ all -> 0x0157 }
            throw r0     // Catch:{ all -> 0x0157 }
        L_0x0027:
            com.google.android.gms.internal.firebase_ml.zzrg r1 = r8.zzbjt     // Catch:{ all -> 0x0157 }
            r1.zzc(r0)     // Catch:{ all -> 0x0157 }
            com.google.android.gms.vision.face.FaceDetector r1 = r8.zzbml     // Catch:{ all -> 0x0157 }
            r2 = 0
            if (r1 == 0) goto L_0x0043
            com.google.android.gms.vision.face.FaceDetector r1 = r8.zzbml     // Catch:{ all -> 0x0157 }
            java.util.List r1 = r8.zza(r1, r0, r3)     // Catch:{ all -> 0x0157 }
            com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions r5 = r8.zzbmk     // Catch:{ all -> 0x0157 }
            boolean r5 = r5.isTrackingEnabled()     // Catch:{ all -> 0x0157 }
            if (r5 != 0) goto L_0x0044
            zzh(r1)     // Catch:{ all -> 0x0157 }
            goto L_0x0044
        L_0x0043:
            r1 = r2
        L_0x0044:
            com.google.android.gms.vision.face.FaceDetector r5 = r8.zzbmm     // Catch:{ all -> 0x0157 }
            if (r5 == 0) goto L_0x0051
            com.google.android.gms.vision.face.FaceDetector r2 = r8.zzbmm     // Catch:{ all -> 0x0157 }
            java.util.List r2 = r8.zza(r2, r0, r3)     // Catch:{ all -> 0x0157 }
            zzh(r2)     // Catch:{ all -> 0x0157 }
        L_0x0051:
            if (r1 != 0) goto L_0x005e
            if (r2 == 0) goto L_0x0056
            goto L_0x005e
        L_0x0056:
            com.google.firebase.ml.common.FirebaseMLException r0 = new com.google.firebase.ml.common.FirebaseMLException     // Catch:{ all -> 0x0157 }
            java.lang.String r1 = "No detector is enabled"
            r0.<init>(r1, r9)     // Catch:{ all -> 0x0157 }
            throw r0     // Catch:{ all -> 0x0157 }
        L_0x005e:
            if (r1 != 0) goto L_0x0065
            r0 = r2
        L_0x0061:
            r19 = r3
            goto L_0x0131
        L_0x0065:
            if (r2 != 0) goto L_0x0069
            r0 = r1
            goto L_0x0061
        L_0x0069:
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ all -> 0x0157 }
            r5.<init>()     // Catch:{ all -> 0x0157 }
            java.util.Iterator r6 = r2.iterator()     // Catch:{ all -> 0x0157 }
        L_0x0072:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0157 }
            if (r7 == 0) goto L_0x012a
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0157 }
            com.google.firebase.ml.vision.face.FirebaseVisionFace r7 = (com.google.firebase.ml.vision.face.FirebaseVisionFace) r7     // Catch:{ all -> 0x0157 }
            java.util.Iterator r10 = r1.iterator()     // Catch:{ all -> 0x0157 }
            r11 = 0
        L_0x0083:
            boolean r12 = r10.hasNext()     // Catch:{ all -> 0x0157 }
            if (r12 == 0) goto L_0x0119
            java.lang.Object r12 = r10.next()     // Catch:{ all -> 0x0157 }
            com.google.firebase.ml.vision.face.FirebaseVisionFace r12 = (com.google.firebase.ml.vision.face.FirebaseVisionFace) r12     // Catch:{ all -> 0x0157 }
            android.graphics.Rect r13 = r7.getBoundingBox()     // Catch:{ all -> 0x0157 }
            if (r13 == 0) goto L_0x00fb
            android.graphics.Rect r13 = r12.getBoundingBox()     // Catch:{ all -> 0x0157 }
            if (r13 != 0) goto L_0x009c
            goto L_0x00fb
        L_0x009c:
            android.graphics.Rect r13 = r7.getBoundingBox()     // Catch:{ all -> 0x0157 }
            android.graphics.Rect r15 = r12.getBoundingBox()     // Catch:{ all -> 0x0157 }
            boolean r16 = r13.intersect(r15)     // Catch:{ all -> 0x0157 }
            if (r16 == 0) goto L_0x00fb
            int r14 = r13.right     // Catch:{ all -> 0x0157 }
            int r9 = r15.right     // Catch:{ all -> 0x0157 }
            int r9 = java.lang.Math.min(r14, r9)     // Catch:{ all -> 0x0157 }
            int r14 = r13.left     // Catch:{ all -> 0x0157 }
            int r0 = r15.left     // Catch:{ all -> 0x0157 }
            int r0 = java.lang.Math.max(r14, r0)     // Catch:{ all -> 0x0157 }
            int r9 = r9 - r0
            int r0 = r13.bottom     // Catch:{ all -> 0x0157 }
            int r14 = r15.bottom     // Catch:{ all -> 0x0157 }
            int r0 = java.lang.Math.min(r0, r14)     // Catch:{ all -> 0x0157 }
            int r14 = r13.top     // Catch:{ all -> 0x0157 }
            r17 = r6
            int r6 = r15.top     // Catch:{ all -> 0x0157 }
            int r6 = java.lang.Math.max(r14, r6)     // Catch:{ all -> 0x0157 }
            int r0 = r0 - r6
            int r9 = r9 * r0
            r0 = r10
            double r9 = (double) r9     // Catch:{ all -> 0x0157 }
            int r6 = r13.right     // Catch:{ all -> 0x0157 }
            int r14 = r13.left     // Catch:{ all -> 0x0157 }
            int r6 = r6 - r14
            int r14 = r13.bottom     // Catch:{ all -> 0x0157 }
            int r13 = r13.top     // Catch:{ all -> 0x0157 }
            int r14 = r14 - r13
            int r6 = r6 * r14
            double r13 = (double) r6     // Catch:{ all -> 0x0157 }
            int r6 = r15.right     // Catch:{ all -> 0x0157 }
            r18 = r0
            int r0 = r15.left     // Catch:{ all -> 0x0157 }
            int r6 = r6 - r0
            int r0 = r15.bottom     // Catch:{ all -> 0x0157 }
            int r15 = r15.top     // Catch:{ all -> 0x0157 }
            int r0 = r0 - r15
            int r6 = r6 * r0
            r19 = r3
            double r3 = (double) r6     // Catch:{ all -> 0x0157 }
            double r13 = r13 + r3
            double r13 = r13 - r9
            double r9 = r9 / r13
            r3 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0101
            r0 = 1
            goto L_0x0102
        L_0x00fb:
            r19 = r3
            r17 = r6
            r18 = r10
        L_0x0101:
            r0 = 0
        L_0x0102:
            if (r0 == 0) goto L_0x010c
            android.util.SparseArray r0 = r7.zzqa()     // Catch:{ all -> 0x0157 }
            r12.zza(r0)     // Catch:{ all -> 0x0157 }
            r11 = 1
        L_0x010c:
            r5.add(r12)     // Catch:{ all -> 0x0157 }
            r0 = r22
            r6 = r17
            r10 = r18
            r3 = r19
            goto L_0x0083
        L_0x0119:
            r19 = r3
            r17 = r6
            if (r11 != 0) goto L_0x0122
            r5.add(r7)     // Catch:{ all -> 0x0157 }
        L_0x0122:
            r0 = r22
            r6 = r17
            r3 = r19
            goto L_0x0072
        L_0x012a:
            r19 = r3
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0157 }
            r0.<init>(r5)     // Catch:{ all -> 0x0157 }
        L_0x0131:
            com.google.android.gms.internal.firebase_ml.zznq r3 = com.google.android.gms.internal.firebase_ml.zznq.NO_ERROR     // Catch:{ all -> 0x0157 }
            if (r2 != 0) goto L_0x0137
            r6 = 0
            goto L_0x013c
        L_0x0137:
            int r2 = r2.size()     // Catch:{ all -> 0x0157 }
            r6 = r2
        L_0x013c:
            if (r1 != 0) goto L_0x0140
            r7 = 0
            goto L_0x0145
        L_0x0140:
            int r1 = r1.size()     // Catch:{ all -> 0x0157 }
            r7 = r1
        L_0x0145:
            r1 = r21
            r2 = r3
            r3 = r19
            r5 = r22
            r1.zza(r2, r3, r5, r6, r7)     // Catch:{ all -> 0x0157 }
            java.util.concurrent.atomic.AtomicBoolean r1 = com.google.android.gms.internal.firebase_ml.zzro.zzbhb     // Catch:{ all -> 0x0157 }
            r2 = 0
            r1.set(r2)     // Catch:{ all -> 0x0157 }
            monitor-exit(r21)
            return r0
        L_0x0157:
            r0 = move-exception
            monitor-exit(r21)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzro.zza(com.google.android.gms.internal.firebase_ml.zzrl):java.util.List");
    }

    private static void zzh(List<FirebaseVisionFace> list) {
        for (FirebaseVisionFace zzbh : list) {
            zzbh.zzbh(-1);
        }
    }

    private final synchronized void zza(zznq zznq, long j, zzrl zzrl, int i, int i2) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zzbfe.zza(new zzrn(this, elapsedRealtime, zznq, i, i2, zzrl), zznu.ON_DEVICE_FACE_DETECT);
        zzpu zzpu = zzrp.zzbhp;
        this.zzbfe.zza((zzng.zzd.zza) ((zzvx) zzng.zzd.zza.zzjx().zze(zznq).zzq(zzbhb.get()).zzd(zzrf.zzb(zzrl)).zzar(i).zzas(i2).zzb(this.zzbmk.zzqb()).zztx()), elapsedRealtime, zznu.AGGREGATED_ON_DEVICE_FACE_DETECTION, zzpu);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzng.zzab.zza zza(long j, zznq zznq, int i, int i2, zzrl zzrl) {
        return zzng.zzab.zzln().zzb((zzng.zzal) ((zzvx) zzng.zzal.zzmi().zzd(zzng.zzad.zzlr().zzj(j).zzk(zznq).zzae(zzbhb.get()).zzaf(true).zzag(true)).zzc(this.zzbmk.zzqb()).zzbm(i).zzbn(i2).zzj(zzrf.zzb(zzrl)).zztx()));
    }
}
