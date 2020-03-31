package com.google.firebase.ml.vision.face;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.firebase_ml.zzlw;
import com.google.android.gms.internal.firebase_ml.zzly;
import com.google.android.gms.vision.face.Contour;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import com.google.firebase.ml.vision.common.FirebaseVisionPoint;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionFace {
    public static final int INVALID_ID = -1;
    public static final float UNCOMPUTED_PROBABILITY = -1.0f;
    private final Rect zzbks;
    private int zzblr;
    private float zzbls;
    private float zzblt;
    private float zzblu;
    private final float zzblv;
    private final float zzblw;
    private final SparseArray<FirebaseVisionFaceLandmark> zzblx = new SparseArray<>();
    private final SparseArray<FirebaseVisionFaceContour> zzbly = new SparseArray<>();

    private static boolean zzbx(int i) {
        return i == 0 || i == 1 || i == 7 || i == 3 || i == 9 || i == 4 || i == 10 || i == 5 || i == 11 || i == 6;
    }

    public Rect getBoundingBox() {
        return this.zzbks;
    }

    public int getTrackingId() {
        return this.zzblr;
    }

    public FirebaseVisionFace(Face face) {
        int i;
        PointF position = face.getPosition();
        this.zzbks = new Rect((int) position.x, (int) position.y, (int) (position.x + face.getWidth()), (int) (position.y + face.getHeight()));
        this.zzblr = face.getId();
        for (Landmark next : face.getLandmarks()) {
            if (zzbx(next.getType()) && next.getPosition() != null) {
                this.zzblx.put(next.getType(), new FirebaseVisionFaceLandmark(next.getType(), new FirebaseVisionPoint(Float.valueOf(next.getPosition().x), Float.valueOf(next.getPosition().y), null)));
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Contour> it = face.getContours().iterator();
        while (true) {
            boolean z = true;
            if (it.hasNext()) {
                Contour next2 = it.next();
                switch (next2.getType()) {
                    case 1:
                        i = 2;
                        break;
                    case 2:
                        i = 3;
                        break;
                    case 3:
                        i = 4;
                        break;
                    case 4:
                        i = 5;
                        break;
                    case 5:
                        i = 6;
                        break;
                    case 6:
                        i = 7;
                        break;
                    case 7:
                        i = 8;
                        break;
                    case 8:
                        i = 9;
                        break;
                    case 9:
                        i = 10;
                        break;
                    case 10:
                        i = 11;
                        break;
                    case 11:
                        i = 12;
                        break;
                    case 12:
                        i = 13;
                        break;
                    case 13:
                        i = 14;
                        break;
                    default:
                        i = -1;
                        break;
                }
                if ((i > 14 || i <= 0) ? false : z) {
                    PointF[] positions = next2.getPositions();
                    ArrayList arrayList2 = new ArrayList();
                    if (positions != null) {
                        for (PointF pointF : positions) {
                            arrayList2.add(new FirebaseVisionPoint(Float.valueOf(pointF.x), Float.valueOf(pointF.y), null));
                        }
                        this.zzbly.put(i, new FirebaseVisionFaceContour(i, arrayList2));
                        arrayList.addAll(arrayList2);
                    }
                }
            } else {
                this.zzbly.put(1, new FirebaseVisionFaceContour(1, arrayList));
                this.zzblv = face.getEulerY();
                this.zzblw = face.getEulerZ();
                this.zzblu = face.getIsSmilingProbability();
                this.zzblt = face.getIsLeftEyeOpenProbability();
                this.zzbls = face.getIsRightEyeOpenProbability();
                return;
            }
        }
    }

    public float getHeadEulerAngleY() {
        return this.zzblv;
    }

    public float getHeadEulerAngleZ() {
        return this.zzblw;
    }

    public FirebaseVisionFaceLandmark getLandmark(int i) {
        return this.zzblx.get(i);
    }

    public FirebaseVisionFaceContour getContour(int i) {
        FirebaseVisionFaceContour firebaseVisionFaceContour = this.zzbly.get(i);
        if (firebaseVisionFaceContour != null) {
            return firebaseVisionFaceContour;
        }
        return new FirebaseVisionFaceContour(i, new ArrayList());
    }

    public final SparseArray<FirebaseVisionFaceContour> zzqa() {
        return this.zzbly;
    }

    public final void zza(SparseArray<FirebaseVisionFaceContour> sparseArray) {
        this.zzbly.clear();
        for (int i = 0; i < sparseArray.size(); i++) {
            this.zzbly.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
        }
    }

    public final void zzbh(int i) {
        this.zzblr = -1;
    }

    public float getSmilingProbability() {
        return this.zzblu;
    }

    public float getLeftEyeOpenProbability() {
        return this.zzblt;
    }

    public float getRightEyeOpenProbability() {
        return this.zzbls;
    }

    public String toString() {
        zzly zza = zzlw.zzay("FirebaseVisionFace").zzh("boundingBox", this.zzbks).zzb("trackingId", this.zzblr).zza("rightEyeOpenProbability", this.zzbls).zza("leftEyeOpenProbability", this.zzblt).zza("smileProbability", this.zzblu).zza("eulerY", this.zzblv).zza("eulerZ", this.zzblw);
        zzly zzay = zzlw.zzay("Landmarks");
        for (int i = 0; i <= 11; i++) {
            if (zzbx(i)) {
                StringBuilder sb = new StringBuilder(20);
                sb.append("landmark_");
                sb.append(i);
                zzay.zzh(sb.toString(), getLandmark(i));
            }
        }
        zza.zzh("landmarks", zzay.toString());
        zzly zzay2 = zzlw.zzay("Contours");
        for (int i2 = 1; i2 <= 14; i2++) {
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append("Contour_");
            sb2.append(i2);
            zzay2.zzh(sb2.toString(), getContour(i2));
        }
        zza.zzh("contours", zzay2.toString());
        return zza.toString();
    }
}
