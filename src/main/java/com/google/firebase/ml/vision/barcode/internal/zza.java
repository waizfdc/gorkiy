package com.google.firebase.ml.vision.barcode.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznq;
import com.google.android.gms.internal.firebase_ml.zznu;
import com.google.android.gms.internal.firebase_ml.zzpc;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzpo;
import com.google.android.gms.internal.firebase_ml.zzpx;
import com.google.android.gms.internal.firebase_ml.zzrf;
import com.google.android.gms.internal.firebase_ml.zzrg;
import com.google.android.gms.internal.firebase_ml.zzrk;
import com.google.android.gms.internal.firebase_ml.zzrl;
import com.google.android.gms.internal.firebase_ml.zzvx;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zza implements zzpc<List<FirebaseVisionBarcode>, zzrl>, zzpx {
    private static boolean zzbjr = true;
    private final Context zzbdu;
    private final zzpo zzbfe;
    private final FirebaseVisionBarcodeDetectorOptions zzbjs;
    private final zzrg zzbjt = new zzrg();
    private IBarcodeDetector zzbju;
    private BarcodeDetector zzbjv;

    public zza(zzpn zzpn, FirebaseVisionBarcodeDetectorOptions firebaseVisionBarcodeDetectorOptions) {
        Preconditions.checkNotNull(zzpn, "MlKitContext can not be null");
        Preconditions.checkNotNull(firebaseVisionBarcodeDetectorOptions, "FirebaseVisionBarcodeDetectorOptions can not be null");
        this.zzbdu = zzpn.getApplicationContext();
        this.zzbjs = firebaseVisionBarcodeDetectorOptions;
        this.zzbfe = zzpo.zza(zzpn, 1);
    }

    public final zzpx zznl() {
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zznu() throws com.google.firebase.ml.common.FirebaseMLException {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.firebase.ml.vision.barcode.internal.IBarcodeDetector r0 = r4.zzbju     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x000b
            com.google.firebase.ml.vision.barcode.internal.IBarcodeDetector r0 = r4.zzps()     // Catch:{ all -> 0x003e }
            r4.zzbju = r0     // Catch:{ all -> 0x003e }
        L_0x000b:
            com.google.firebase.ml.vision.barcode.internal.IBarcodeDetector r0 = r4.zzbju     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0021
            com.google.firebase.ml.vision.barcode.internal.IBarcodeDetector r0 = r4.zzbju     // Catch:{ RemoteException -> 0x0016 }
            r0.start()     // Catch:{ RemoteException -> 0x0016 }
            monitor-exit(r4)
            return
        L_0x0016:
            r0 = move-exception
            com.google.firebase.ml.common.FirebaseMLException r1 = new com.google.firebase.ml.common.FirebaseMLException     // Catch:{ all -> 0x003e }
            java.lang.String r2 = "Failed to start barcode detector pipeline."
            r3 = 14
            r1.<init>(r2, r3, r0)     // Catch:{ all -> 0x003e }
            throw r1     // Catch:{ all -> 0x003e }
        L_0x0021:
            com.google.android.gms.vision.barcode.BarcodeDetector r0 = r4.zzbjv     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x003c
            com.google.android.gms.vision.barcode.BarcodeDetector$Builder r0 = new com.google.android.gms.vision.barcode.BarcodeDetector$Builder     // Catch:{ all -> 0x003e }
            android.content.Context r1 = r4.zzbdu     // Catch:{ all -> 0x003e }
            r0.<init>(r1)     // Catch:{ all -> 0x003e }
            com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions r1 = r4.zzbjs     // Catch:{ all -> 0x003e }
            int r1 = r1.zzpq()     // Catch:{ all -> 0x003e }
            com.google.android.gms.vision.barcode.BarcodeDetector$Builder r0 = r0.setBarcodeFormats(r1)     // Catch:{ all -> 0x003e }
            com.google.android.gms.vision.barcode.BarcodeDetector r0 = r0.build()     // Catch:{ all -> 0x003e }
            r4.zzbjv = r0     // Catch:{ all -> 0x003e }
        L_0x003c:
            monitor-exit(r4)
            return
        L_0x003e:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ml.vision.barcode.internal.zza.zznu():void");
    }

    private final IBarcodeDetector zzps() throws FirebaseMLException {
        if (DynamiteModule.getLocalVersion(this.zzbdu, "com.google.firebase.ml.vision.dynamite.barcode") <= 0) {
            return null;
        }
        try {
            return zzj.asInterface(DynamiteModule.load(this.zzbdu, DynamiteModule.PREFER_LOCAL, "com.google.firebase.ml.vision.dynamite.barcode").instantiate("com.google.firebase.ml.vision.barcode.BarcodeDetectorCreator")).newBarcodeDetector(new BarcodeDetectorOptionsParcel(this.zzbjs.zzpq()));
        } catch (RemoteException | DynamiteModule.LoadingException e) {
            throw new FirebaseMLException("Failed to load barcode detector module.", 14, e);
        }
    }

    public final synchronized void release() {
        if (this.zzbju != null) {
            try {
                this.zzbju.stop();
            } catch (RemoteException e) {
                Log.e("BarcodeDetectorTask", "Failed to stop barcode detector pipeline.", e);
            }
            this.zzbju = null;
        }
        if (this.zzbjv != null) {
            this.zzbjv.release();
            this.zzbjv = null;
        }
        zzbjr = true;
    }

    /* access modifiers changed from: private */
    public final synchronized List<FirebaseVisionBarcode> zza(zzrl zzrl) throws FirebaseMLException {
        ArrayList arrayList;
        zzrl zzrl2 = zzrl;
        synchronized (this) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbjt.zzc(zzrl2);
            arrayList = new ArrayList();
            if (this.zzbju != null) {
                try {
                    IObjectWrapper wrap = ObjectWrapper.wrap(zzrl2.zzbkx);
                    Frame.Metadata metadata = zzrl2.zzbkx.getMetadata();
                    for (zzf firebaseVisionBarcode : (List) ObjectWrapper.unwrap(this.zzbju.zzb(wrap, new zzrk(metadata.getWidth(), metadata.getHeight(), metadata.getId(), metadata.getTimestampMillis(), metadata.getRotation())))) {
                        arrayList.add(new FirebaseVisionBarcode(firebaseVisionBarcode));
                    }
                } catch (RemoteException e) {
                    throw new FirebaseMLException("Failed to run barcode detector.", 14, e);
                }
            } else if (this.zzbjv == null) {
                zza(zznq.UNKNOWN_ERROR, elapsedRealtime, zzrl, null);
                throw new FirebaseMLException("Model source is unavailable. Please load the model resource first.", 14);
            } else if (this.zzbjv.isOperational()) {
                SparseArray<Barcode> detect = this.zzbjv.detect(zzrl2.zzbkx);
                for (int i = 0; i < detect.size(); i++) {
                    arrayList.add(new FirebaseVisionBarcode(new zze(detect.get(detect.keyAt(i)))));
                }
            } else {
                zza(zznq.MODEL_NOT_DOWNLOADED, elapsedRealtime, zzrl, null);
                throw new FirebaseMLException("Waiting for the barcode detection model to be downloaded. Please wait.", 14);
            }
            zza(zznq.NO_ERROR, elapsedRealtime, zzrl, arrayList);
            zzbjr = false;
        }
        return arrayList;
    }

    private final void zza(zznq zznq, long j, zzrl zzrl, List<FirebaseVisionBarcode> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            for (FirebaseVisionBarcode next : list) {
                arrayList.add(next.zzpo());
                arrayList2.add(next.zzpp());
            }
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zzbfe.zza(new zzd(this, elapsedRealtime, zznq, arrayList, arrayList2, zzrl), zznu.ON_DEVICE_BARCODE_DETECT);
        zzc zzc = new zzc(this);
        this.zzbfe.zza((zzng.zzc.zza) ((zzvx) zzng.zzc.zza.zzju().zzd(zznq).zzp(zzbjr).zzc(zzrf.zzb(zzrl)).zzb(this.zzbjs.zzpr()).zzj(arrayList).zzk(arrayList2).zztx()), elapsedRealtime, zznu.AGGREGATED_ON_DEVICE_BARCODE_DETECTION, zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzng.zzab.zza zza(long j, zznq zznq, List list, List list2, zzrl zzrl) {
        boolean z = true;
        zzng.zzak.zzc zzi = zzng.zzak.zzmg().zzc(zzng.zzad.zzlr().zzj(j).zzk(zznq).zzae(zzbjr).zzaf(true).zzag(true)).zzc(this.zzbjs.zzpr()).zzs(list).zzt(list2).zzi(zzrf.zzb(zzrl));
        zzng.zzab.zza zzln = zzng.zzab.zzln();
        if (this.zzbju == null) {
            z = false;
        }
        return zzln.zzad(z).zza(zzi);
    }
}
