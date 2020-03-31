package com.google.firebase.ml.vision;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzqc;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions;
import com.google.firebase.ml.vision.cloud.FirebaseVisionCloudDetectorOptions;
import com.google.firebase.ml.vision.cloud.landmark.FirebaseVisionCloudLandmarkDetector;
import com.google.firebase.ml.vision.document.FirebaseVisionCloudDocumentRecognizerOptions;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentTextRecognizer;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions;
import com.google.firebase.ml.vision.label.FirebaseVisionCloudImageLabelerOptions;
import com.google.firebase.ml.vision.label.FirebaseVisionImageLabeler;
import com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceAutoMLImageLabelerOptions;
import com.google.firebase.ml.vision.label.FirebaseVisionOnDeviceImageLabelerOptions;
import com.google.firebase.ml.vision.objects.FirebaseVisionObjectDetector;
import com.google.firebase.ml.vision.objects.FirebaseVisionObjectDetectorOptions;
import com.google.firebase.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVision {
    private static final FirebaseVisionCloudDetectorOptions zzbhq = new FirebaseVisionCloudDetectorOptions.Builder().build();
    private static final FirebaseVisionFaceDetectorOptions zzbhr = new FirebaseVisionFaceDetectorOptions.Builder().build();
    private static final FirebaseVisionBarcodeDetectorOptions zzbhs = new FirebaseVisionBarcodeDetectorOptions.Builder().build();
    private static final FirebaseVisionCloudTextRecognizerOptions zzbht = new FirebaseVisionCloudTextRecognizerOptions.Builder().build();
    private static final FirebaseVisionCloudDocumentRecognizerOptions zzbhu = new FirebaseVisionCloudDocumentRecognizerOptions.Builder().build();
    private static final FirebaseVisionOnDeviceImageLabelerOptions zzbhv = new FirebaseVisionOnDeviceImageLabelerOptions.Builder().build();
    private static final FirebaseVisionCloudImageLabelerOptions zzbhw = new FirebaseVisionCloudImageLabelerOptions.Builder().build();
    private static final FirebaseVisionObjectDetectorOptions zzbhx = new FirebaseVisionObjectDetectorOptions.Builder().build();
    private final zzqc zzbcm;
    private final zzpn zzbdc;

    public static FirebaseVision getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public static FirebaseVision getInstance(FirebaseApp firebaseApp) {
        Preconditions.checkNotNull(firebaseApp, "MlKitContext can not be null");
        return (FirebaseVision) firebaseApp.get(FirebaseVision.class);
    }

    public void setStatsCollectionEnabled(boolean z) {
        this.zzbcm.zzar(z);
    }

    public boolean isStatsCollectionEnabled() {
        return this.zzbcm.zzny();
    }

    public FirebaseVisionFaceDetector getVisionFaceDetector(FirebaseVisionFaceDetectorOptions firebaseVisionFaceDetectorOptions) {
        Preconditions.checkNotNull(firebaseVisionFaceDetectorOptions, "Please provide a valid FirebaseVisionFaceDetectorOptions");
        return FirebaseVisionFaceDetector.zza(this.zzbdc, firebaseVisionFaceDetectorOptions);
    }

    public FirebaseVisionFaceDetector getVisionFaceDetector() {
        return FirebaseVisionFaceDetector.zza(this.zzbdc, zzbhr);
    }

    public FirebaseVisionTextRecognizer getOnDeviceTextRecognizer() {
        return FirebaseVisionTextRecognizer.zza(this.zzbdc, null, true);
    }

    public FirebaseVisionTextRecognizer getCloudTextRecognizer() {
        return FirebaseVisionTextRecognizer.zza(this.zzbdc, zzbht, false);
    }

    public FirebaseVisionTextRecognizer getCloudTextRecognizer(FirebaseVisionCloudTextRecognizerOptions firebaseVisionCloudTextRecognizerOptions) {
        return FirebaseVisionTextRecognizer.zza(this.zzbdc, firebaseVisionCloudTextRecognizerOptions, false);
    }

    public FirebaseVisionBarcodeDetector getVisionBarcodeDetector(FirebaseVisionBarcodeDetectorOptions firebaseVisionBarcodeDetectorOptions) {
        return FirebaseVisionBarcodeDetector.zza(this.zzbdc, (FirebaseVisionBarcodeDetectorOptions) Preconditions.checkNotNull(firebaseVisionBarcodeDetectorOptions, "Please provide a valid FirebaseVisionBarcodeDetectorOptions"));
    }

    public FirebaseVisionBarcodeDetector getVisionBarcodeDetector() {
        return FirebaseVisionBarcodeDetector.zza(this.zzbdc, zzbhs);
    }

    public FirebaseVisionImageLabeler getOnDeviceImageLabeler(FirebaseVisionOnDeviceImageLabelerOptions firebaseVisionOnDeviceImageLabelerOptions) {
        return FirebaseVisionImageLabeler.zza(this.zzbdc, (FirebaseVisionOnDeviceImageLabelerOptions) Preconditions.checkNotNull(firebaseVisionOnDeviceImageLabelerOptions, "Please provide a valid FirebaseVisionOnDeviceImageLabelerOptions"));
    }

    public FirebaseVisionImageLabeler getOnDeviceImageLabeler() {
        return FirebaseVisionImageLabeler.zza(this.zzbdc, zzbhv);
    }

    public FirebaseVisionImageLabeler getOnDeviceAutoMLImageLabeler(FirebaseVisionOnDeviceAutoMLImageLabelerOptions firebaseVisionOnDeviceAutoMLImageLabelerOptions) throws FirebaseMLException {
        return FirebaseVisionImageLabeler.zza(this.zzbdc, (FirebaseVisionOnDeviceAutoMLImageLabelerOptions) Preconditions.checkNotNull(firebaseVisionOnDeviceAutoMLImageLabelerOptions, "Please provide a valid FirebaseVisionOnDeviceAutoMLImageLabelerOptions"));
    }

    public FirebaseVisionImageLabeler getCloudImageLabeler(FirebaseVisionCloudImageLabelerOptions firebaseVisionCloudImageLabelerOptions) {
        return FirebaseVisionImageLabeler.zza(this.zzbdc, firebaseVisionCloudImageLabelerOptions);
    }

    public FirebaseVisionImageLabeler getCloudImageLabeler() {
        return FirebaseVisionImageLabeler.zza(this.zzbdc, zzbhw);
    }

    public FirebaseVisionDocumentTextRecognizer getCloudDocumentTextRecognizer(FirebaseVisionCloudDocumentRecognizerOptions firebaseVisionCloudDocumentRecognizerOptions) {
        return FirebaseVisionDocumentTextRecognizer.zza(this.zzbdc, firebaseVisionCloudDocumentRecognizerOptions);
    }

    public FirebaseVisionDocumentTextRecognizer getCloudDocumentTextRecognizer() {
        return FirebaseVisionDocumentTextRecognizer.zza(this.zzbdc, zzbhu);
    }

    public FirebaseVisionCloudLandmarkDetector getVisionCloudLandmarkDetector(FirebaseVisionCloudDetectorOptions firebaseVisionCloudDetectorOptions) {
        return FirebaseVisionCloudLandmarkDetector.zza(this.zzbdc, firebaseVisionCloudDetectorOptions);
    }

    public FirebaseVisionCloudLandmarkDetector getVisionCloudLandmarkDetector() {
        return FirebaseVisionCloudLandmarkDetector.zza(this.zzbdc, zzbhq);
    }

    public FirebaseVisionObjectDetector getOnDeviceObjectDetector(FirebaseVisionObjectDetectorOptions firebaseVisionObjectDetectorOptions) {
        return FirebaseVisionObjectDetector.zza(this.zzbdc, firebaseVisionObjectDetectorOptions);
    }

    public FirebaseVisionObjectDetector getOnDeviceObjectDetector() {
        return FirebaseVisionObjectDetector.zza(this.zzbdc, zzbhx);
    }

    FirebaseVision(zzpn zzpn) {
        this.zzbdc = zzpn;
        this.zzbcm = zzqc.zzb(zzpn);
    }
}
