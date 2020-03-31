package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzaj;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public class Element implements Text {
    private zzaj zzdx;

    Element(zzaj zzaj) {
        this.zzdx = zzaj;
    }

    public String getLanguage() {
        return this.zzdx.zzec;
    }

    public String getValue() {
        return this.zzdx.zzel;
    }

    public Rect getBoundingBox() {
        return zzc.zza(this);
    }

    public Point[] getCornerPoints() {
        return zzc.zza(this.zzdx.zzei);
    }

    public List<? extends Text> getComponents() {
        return new ArrayList();
    }
}
