package com.google.firebase.ml.vision.label;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzpp;
import com.google.android.gms.internal.firebase_ml.zzrq;
import com.google.android.gms.internal.firebase_ml.zzrr;
import com.google.android.gms.internal.firebase_ml.zzru;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.vision.cloud.FirebaseVisionCloudDetectorOptions;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionImageLabeler implements Closeable {
    public static final int CLOUD = 2;
    public static final int ON_DEVICE = 1;
    public static final int ON_DEVICE_AUTOML = 3;
    private static final Map<zzpp<FirebaseVisionOnDeviceImageLabelerOptions>, FirebaseVisionImageLabeler> zzbms = new HashMap();
    private static final Map<zzpp<FirebaseVisionCloudImageLabelerOptions>, FirebaseVisionImageLabeler> zzbmt = new HashMap();
    private static final Map<zzpp<FirebaseVisionOnDeviceAutoMLImageLabelerOptions>, FirebaseVisionImageLabeler> zzbmu = new HashMap();
    private final zzrr zzbmn;
    private final zzrq zzbmo;
    private final zzru zzbmp;
    /* access modifiers changed from: private */
    public final FirebaseVisionCloudImageLabelerOptions zzbmq;
    private final int zzbmr;

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public @interface ImageLabelerType {
    }

    public static synchronized FirebaseVisionImageLabeler zza(zzpn zzpn, FirebaseVisionOnDeviceImageLabelerOptions firebaseVisionOnDeviceImageLabelerOptions) {
        FirebaseVisionImageLabeler firebaseVisionImageLabeler;
        synchronized (FirebaseVisionImageLabeler.class) {
            Preconditions.checkNotNull(zzpn, "MlKitContext must not be null");
            Preconditions.checkNotNull(zzpn.getPersistenceKey(), "Persistence key must not be null");
            zzpp zzj = zzpp.zzj(zzpn.getPersistenceKey(), firebaseVisionOnDeviceImageLabelerOptions);
            firebaseVisionImageLabeler = zzbms.get(zzj);
            if (firebaseVisionImageLabeler == null) {
                FirebaseVisionImageLabeler firebaseVisionImageLabeler2 = new FirebaseVisionImageLabeler(new zzrq(zzpn, firebaseVisionOnDeviceImageLabelerOptions));
                zzbms.put(zzj, firebaseVisionImageLabeler2);
                firebaseVisionImageLabeler = firebaseVisionImageLabeler2;
            }
        }
        return firebaseVisionImageLabeler;
    }

    public static synchronized FirebaseVisionImageLabeler zza(zzpn zzpn, FirebaseVisionOnDeviceAutoMLImageLabelerOptions firebaseVisionOnDeviceAutoMLImageLabelerOptions) throws FirebaseMLException {
        FirebaseVisionImageLabeler firebaseVisionImageLabeler;
        synchronized (FirebaseVisionImageLabeler.class) {
            Preconditions.checkNotNull(zzpn, "MlKitContext must not be null");
            Preconditions.checkNotNull(zzpn.getPersistenceKey(), "Persistence key must not be null");
            zzpp zzj = zzpp.zzj(zzpn.getPersistenceKey(), firebaseVisionOnDeviceAutoMLImageLabelerOptions);
            firebaseVisionImageLabeler = zzbmu.get(zzj);
            if (firebaseVisionImageLabeler == null) {
                FirebaseVisionImageLabeler firebaseVisionImageLabeler2 = new FirebaseVisionImageLabeler(new zzru(zzpn, firebaseVisionOnDeviceAutoMLImageLabelerOptions));
                zzbmu.put(zzj, firebaseVisionImageLabeler2);
                firebaseVisionImageLabeler = firebaseVisionImageLabeler2;
            }
        }
        return firebaseVisionImageLabeler;
    }

    public static synchronized FirebaseVisionImageLabeler zza(zzpn zzpn, FirebaseVisionCloudImageLabelerOptions firebaseVisionCloudImageLabelerOptions) {
        FirebaseVisionImageLabeler firebaseVisionImageLabeler;
        synchronized (FirebaseVisionImageLabeler.class) {
            Preconditions.checkNotNull(zzpn, "MlKitContext must not be null");
            Preconditions.checkNotNull(zzpn.getPersistenceKey(), "Persistence key must not be null");
            zzpp zzj = zzpp.zzj(zzpn.getPersistenceKey(), firebaseVisionCloudImageLabelerOptions);
            firebaseVisionImageLabeler = zzbmt.get(zzj);
            if (firebaseVisionImageLabeler == null) {
                FirebaseVisionCloudDetectorOptions.Builder maxResults = new FirebaseVisionCloudDetectorOptions.Builder().setMaxResults(20);
                if (firebaseVisionCloudImageLabelerOptions.isEnforceCertFingerprintMatch()) {
                    maxResults.enforceCertFingerprintMatch();
                }
                firebaseVisionImageLabeler = new FirebaseVisionImageLabeler(new zzrr(zzpn, maxResults.build()), firebaseVisionCloudImageLabelerOptions);
                zzbmt.put(zzj, firebaseVisionImageLabeler);
            }
        }
        return firebaseVisionImageLabeler;
    }

    public Task<List<FirebaseVisionImageLabel>> processImage(FirebaseVisionImage firebaseVisionImage) {
        Preconditions.checkState((this.zzbmo == null && this.zzbmn == null && this.zzbmp == null) ? false : true, "One of on-device, cloud, or on-device AutoML image labeler should be set.");
        zzrq zzrq = this.zzbmo;
        if (zzrq != null) {
            return zzrq.detectInImage(firebaseVisionImage);
        }
        zzru zzru = this.zzbmp;
        if (zzru != null) {
            return zzru.detectInImage(firebaseVisionImage);
        }
        return this.zzbmn.detectInImage(firebaseVisionImage).continueWith(new zzb(this));
    }

    public int getImageLabelerType() {
        return this.zzbmr;
    }

    public void close() throws IOException {
        zzrq zzrq = this.zzbmo;
        if (zzrq != null) {
            zzrq.close();
        }
        zzrr zzrr = this.zzbmn;
        if (zzrr != null) {
            zzrr.close();
        }
        zzru zzru = this.zzbmp;
        if (zzru != null) {
            zzru.close();
        }
    }

    private FirebaseVisionImageLabeler(zzrq zzrq) {
        this(zzrq, null, null, null);
    }

    private FirebaseVisionImageLabeler(zzrr zzrr, FirebaseVisionCloudImageLabelerOptions firebaseVisionCloudImageLabelerOptions) {
        this(null, zzrr, null, firebaseVisionCloudImageLabelerOptions);
    }

    private FirebaseVisionImageLabeler(zzru zzru) {
        this(null, null, zzru, null);
    }

    private FirebaseVisionImageLabeler(zzrq zzrq, zzrr zzrr, zzru zzru, FirebaseVisionCloudImageLabelerOptions firebaseVisionCloudImageLabelerOptions) {
        Preconditions.checkArgument((zzrq == null && zzrr == null && zzru == null) ? false : true, "One of on-device, cloud or on-device AutoML image labeler should be set.");
        this.zzbmo = zzrq;
        this.zzbmn = zzrr;
        this.zzbmq = firebaseVisionCloudImageLabelerOptions;
        this.zzbmp = zzru;
        if (zzrr != null) {
            this.zzbmr = 2;
        } else if (zzrq != null) {
            this.zzbmr = 1;
        } else {
            this.zzbmr = 3;
        }
    }
}
