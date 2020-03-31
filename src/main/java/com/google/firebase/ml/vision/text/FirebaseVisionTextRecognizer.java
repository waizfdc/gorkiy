package com.google.firebase.ml.vision.text;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzrz;
import com.google.android.gms.internal.firebase_ml.zzsa;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionTextRecognizer implements Closeable {
    public static final int CLOUD = 2;
    public static final int ON_DEVICE = 1;
    private static final Map<zzrz, FirebaseVisionTextRecognizer> zzbms = new HashMap();
    private static final Map<zzsa, FirebaseVisionTextRecognizer> zzbmt = new HashMap();
    private final zzrz zzbny;
    private final zzsa zzbnz;
    private final int zzboa;

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public @interface RecognizerType {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer zza(com.google.android.gms.internal.firebase_ml.zzpn r3, com.google.firebase.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions r4, boolean r5) {
        /*
            java.lang.Class<com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer> r0 = com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer.class
            monitor-enter(r0)
            java.lang.String r1 = "MlKitContext must not be null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3, r1)     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = r3.getPersistenceKey()     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "Persistence key must not be null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1, r2)     // Catch:{ all -> 0x0051 }
            if (r5 != 0) goto L_0x0018
            java.lang.String r1 = "Options must not be null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4, r1)     // Catch:{ all -> 0x0051 }
        L_0x0018:
            r1 = 0
            if (r5 == 0) goto L_0x0036
            com.google.android.gms.internal.firebase_ml.zzrz r3 = com.google.android.gms.internal.firebase_ml.zzrz.zzc(r3)     // Catch:{ all -> 0x0051 }
            java.util.Map<com.google.android.gms.internal.firebase_ml.zzrz, com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer> r4 = com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer.zzbms     // Catch:{ all -> 0x0051 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x0051 }
            com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer r4 = (com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer) r4     // Catch:{ all -> 0x0051 }
            if (r4 != 0) goto L_0x0034
            com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer r4 = new com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer     // Catch:{ all -> 0x0051 }
            r5 = 1
            r4.<init>(r3, r1, r5)     // Catch:{ all -> 0x0051 }
            java.util.Map<com.google.android.gms.internal.firebase_ml.zzrz, com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer> r5 = com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer.zzbms     // Catch:{ all -> 0x0051 }
            r5.put(r3, r4)     // Catch:{ all -> 0x0051 }
        L_0x0034:
            monitor-exit(r0)
            return r4
        L_0x0036:
            com.google.android.gms.internal.firebase_ml.zzsa r3 = com.google.android.gms.internal.firebase_ml.zzsa.zza(r3, r4)     // Catch:{ all -> 0x0051 }
            java.util.Map<com.google.android.gms.internal.firebase_ml.zzsa, com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer> r4 = com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer.zzbmt     // Catch:{ all -> 0x0051 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x0051 }
            com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer r4 = (com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer) r4     // Catch:{ all -> 0x0051 }
            if (r4 != 0) goto L_0x004f
            com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer r4 = new com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer     // Catch:{ all -> 0x0051 }
            r5 = 2
            r4.<init>(r1, r3, r5)     // Catch:{ all -> 0x0051 }
            java.util.Map<com.google.android.gms.internal.firebase_ml.zzsa, com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer> r5 = com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer.zzbmt     // Catch:{ all -> 0x0051 }
            r5.put(r3, r4)     // Catch:{ all -> 0x0051 }
        L_0x004f:
            monitor-exit(r0)
            return r4
        L_0x0051:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer.zza(com.google.android.gms.internal.firebase_ml.zzpn, com.google.firebase.ml.vision.text.FirebaseVisionCloudTextRecognizerOptions, boolean):com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer");
    }

    private FirebaseVisionTextRecognizer(zzrz zzrz, zzsa zzsa, int i) {
        this.zzboa = i;
        this.zzbny = zzrz;
        this.zzbnz = zzsa;
    }

    public Task<FirebaseVisionText> processImage(FirebaseVisionImage firebaseVisionImage) {
        Preconditions.checkArgument((this.zzbny == null && this.zzbnz == null) ? false : true, "Either on-device or cloud text recognizer should be enabled.");
        zzrz zzrz = this.zzbny;
        if (zzrz != null) {
            return zzrz.processImage(firebaseVisionImage);
        }
        return this.zzbnz.processImage(firebaseVisionImage);
    }

    public int getRecognizerType() {
        return this.zzboa;
    }

    public void close() throws IOException {
        zzrz zzrz = this.zzbny;
        if (zzrz != null) {
            zzrz.close();
        }
        zzsa zzsa = this.zzbnz;
        if (zzsa != null) {
            zzsa.close();
        }
    }
}
