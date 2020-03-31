package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzrz extends zzri<FirebaseVisionText> implements Closeable {
    private static final Map<String, zzrz> zzbbn = new HashMap();

    public static synchronized zzrz zzc(zzpn zzpn) {
        zzrz zzrz;
        synchronized (zzrz.class) {
            Preconditions.checkNotNull(zzpn, "MlKitContext can not be null.");
            Preconditions.checkNotNull(zzpn.getPersistenceKey(), "Persistence key must not be null");
            zzrz = zzbbn.get(zzpn.getPersistenceKey());
            if (zzrz == null) {
                zzrz = new zzrz(zzpn);
                zzbbn.put(zzpn.getPersistenceKey(), zzrz);
            }
        }
        return zzrz;
    }

    private zzrz(zzpn zzpn) {
        super(zzpn, new zzsc(zzpn));
        zzpo.zza(zzpn, 1).zza(zzng.zzab.zzln().zzb(zzng.zzau.zznd()), zznu.ON_DEVICE_TEXT_CREATE);
    }

    public final Task<FirebaseVisionText> processImage(FirebaseVisionImage firebaseVisionImage) {
        return super.zza(firebaseVisionImage, false, true);
    }
}
