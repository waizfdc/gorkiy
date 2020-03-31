package com.google.firebase.ml.vision.cloud.landmark;

import android.graphics.Rect;
import com.google.android.gms.internal.firebase_ml.zzkn;
import com.google.android.gms.internal.firebase_ml.zzky;
import com.google.android.gms.internal.firebase_ml.zzmn;
import com.google.android.gms.internal.firebase_ml.zzqy;
import com.google.firebase.ml.vision.common.FirebaseVisionLatLng;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionCloudLandmark {
    private final List<FirebaseVisionLatLng> locations;
    private final String mid;
    private final float zzbiw;
    private final String zzbkr;
    private final Rect zzbks;

    public String getEntityId() {
        return this.mid;
    }

    public String getLandmark() {
        return this.zzbkr;
    }

    public Rect getBoundingBox() {
        return this.zzbks;
    }

    public float getConfidence() {
        return this.zzbiw;
    }

    public List<FirebaseVisionLatLng> getLocations() {
        return this.locations;
    }

    private FirebaseVisionCloudLandmark(String str, float f, Rect rect, String str2, List<FirebaseVisionLatLng> list) {
        this.zzbks = rect;
        this.zzbkr = zzmn.zzba(str);
        this.mid = zzmn.zzba(str2);
        this.locations = list;
        if (Float.compare(f, 0.0f) < 0) {
            f = 0.0f;
        } else if (Float.compare(f, 1.0f) > 0) {
            f = 1.0f;
        }
        this.zzbiw = f;
    }

    static FirebaseVisionCloudLandmark zza(zzkn zzkn, float f) {
        ArrayList arrayList;
        if (zzkn == null) {
            return null;
        }
        float zza = zzqy.zza(zzkn.zzio());
        Rect zza2 = zzqy.zza(zzkn.zzin(), f);
        String description = zzkn.getDescription();
        String mid2 = zzkn.getMid();
        List<zzky> locations2 = zzkn.getLocations();
        if (locations2 == null) {
            arrayList = new ArrayList();
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (zzky next : locations2) {
                if (!(next.zzir() == null || next.zzir().zzip() == null || next.zzir().zziq() == null)) {
                    arrayList2.add(new FirebaseVisionLatLng(next.zzir().zzip().doubleValue(), next.zzir().zziq().doubleValue()));
                }
            }
            arrayList = arrayList2;
        }
        return new FirebaseVisionCloudLandmark(description, zza, zza2, mid2, arrayList);
    }
}
