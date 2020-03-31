package com.google.android.gms.vision.face;

import android.graphics.PointF;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public class Face {
    public static final float UNCOMPUTED_PROBABILITY = -1.0f;
    private float height;
    private int id;
    private float width;
    private PointF zzby;
    private float zzbz;
    private float zzca;
    private float zzcb;
    private List<Landmark> zzcc;
    private final List<Contour> zzcd;
    private float zzce;
    private float zzcf;
    private float zzcg;
    private final float zzch;

    private static float zza(float f) {
        if (f < 0.0f || f > 1.0f) {
            return -1.0f;
        }
        return f;
    }

    public PointF getPosition() {
        return new PointF(this.zzby.x - (this.width / 2.0f), this.zzby.y - (this.height / 2.0f));
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float getEulerY() {
        return this.zzbz;
    }

    public float getEulerZ() {
        return this.zzca;
    }

    public List<Landmark> getLandmarks() {
        return this.zzcc;
    }

    public List<Contour> getContours() {
        return this.zzcd;
    }

    public float getIsLeftEyeOpenProbability() {
        return this.zzce;
    }

    public float getIsRightEyeOpenProbability() {
        return this.zzcf;
    }

    public float getIsSmilingProbability() {
        return this.zzcg;
    }

    public int getId() {
        return this.id;
    }

    public Face(int i, PointF pointF, float f, float f2, float f3, float f4, float f5, Landmark[] landmarkArr, Contour[] contourArr, float f6, float f7, float f8, float f9) {
        this.id = i;
        this.zzby = pointF;
        this.width = f;
        this.height = f2;
        this.zzbz = f3;
        this.zzca = f4;
        this.zzcb = f5;
        this.zzcc = Arrays.asList(landmarkArr);
        this.zzcd = Arrays.asList(contourArr);
        this.zzce = zza(f6);
        this.zzcf = zza(f7);
        this.zzcg = zza(f8);
        this.zzch = zza(f9);
    }
}
