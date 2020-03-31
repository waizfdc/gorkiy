package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzac;
import com.google.android.gms.internal.vision.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public class TextBlock implements Text {
    private Point[] cornerPoints;
    private zzac[] zzea;
    private List<Line> zzeb;
    private String zzec;
    private Rect zzed;

    TextBlock(SparseArray<zzac> sparseArray) {
        this.zzea = new zzac[sparseArray.size()];
        int i = 0;
        while (true) {
            zzac[] zzacArr = this.zzea;
            if (i < zzacArr.length) {
                zzacArr[i] = sparseArray.valueAt(i);
                i++;
            } else {
                return;
            }
        }
    }

    public String getLanguage() {
        String str = this.zzec;
        if (str != null) {
            return str;
        }
        HashMap hashMap = new HashMap();
        for (zzac zzac : this.zzea) {
            hashMap.put(zzac.zzec, Integer.valueOf((hashMap.containsKey(zzac.zzec) ? ((Integer) hashMap.get(zzac.zzec)).intValue() : 0) + 1));
        }
        String str2 = (String) ((Map.Entry) Collections.max(hashMap.entrySet(), new zza(this))).getKey();
        this.zzec = str2;
        if (str2 == null || str2.isEmpty()) {
            this.zzec = "und";
        }
        return this.zzec;
    }

    public String getValue() {
        zzac[] zzacArr = this.zzea;
        if (zzacArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zzacArr[0].zzel);
        for (int i = 1; i < this.zzea.length; i++) {
            sb.append("\n");
            sb.append(this.zzea[i].zzel);
        }
        return sb.toString();
    }

    public Point[] getCornerPoints() {
        TextBlock textBlock;
        zzac[] zzacArr;
        TextBlock textBlock2 = this;
        if (textBlock2.cornerPoints == null) {
            char c = 0;
            if (textBlock2.zzea.length == 0) {
                textBlock2.cornerPoints = new Point[0];
            } else {
                int i = Integer.MIN_VALUE;
                int i2 = 0;
                int i3 = Integer.MAX_VALUE;
                int i4 = Integer.MAX_VALUE;
                int i5 = Integer.MIN_VALUE;
                while (true) {
                    zzacArr = textBlock2.zzea;
                    if (i2 >= zzacArr.length) {
                        break;
                    }
                    zzw zzw = zzacArr[i2].zzei;
                    zzw zzw2 = textBlock2.zzea[c].zzei;
                    double sin = Math.sin(Math.toRadians((double) zzw2.zzeg));
                    double cos = Math.cos(Math.toRadians((double) zzw2.zzeg));
                    Point[] pointArr = new Point[4];
                    pointArr[c] = new Point(zzw.left, zzw.top);
                    pointArr[c].offset(-zzw2.left, -zzw2.top);
                    int i6 = i5;
                    int i7 = (int) ((((double) pointArr[c].x) * cos) + (((double) pointArr[c].y) * sin));
                    int i8 = (int) ((((double) (-pointArr[0].x)) * sin) + (((double) pointArr[0].y) * cos));
                    pointArr[0].x = i7;
                    pointArr[0].y = i8;
                    pointArr[1] = new Point(zzw.width + i7, i8);
                    pointArr[2] = new Point(zzw.width + i7, zzw.height + i8);
                    pointArr[3] = new Point(i7, i8 + zzw.height);
                    i5 = i6;
                    for (int i9 = 0; i9 < 4; i9++) {
                        Point point = pointArr[i9];
                        i3 = Math.min(i3, point.x);
                        i = Math.max(i, point.x);
                        i4 = Math.min(i4, point.y);
                        i5 = Math.max(i5, point.y);
                    }
                    i2++;
                    c = 0;
                    textBlock2 = this;
                }
                int i10 = i5;
                zzw zzw3 = zzacArr[c].zzei;
                int i11 = zzw3.left;
                int i12 = zzw3.top;
                double sin2 = Math.sin(Math.toRadians((double) zzw3.zzeg));
                double cos2 = Math.cos(Math.toRadians((double) zzw3.zzeg));
                int i13 = i10;
                Point[] pointArr2 = {new Point(i3, i4), new Point(i, i4), new Point(i, i13), new Point(i3, i13)};
                for (int i14 = 0; i14 < 4; i14++) {
                    pointArr2[i14].x = (int) ((((double) pointArr2[i14].x) * cos2) - (((double) pointArr2[i14].y) * sin2));
                    pointArr2[i14].y = (int) ((((double) pointArr2[i14].x) * sin2) + (((double) pointArr2[i14].y) * cos2));
                    pointArr2[i14].offset(i11, i12);
                }
                textBlock = this;
                textBlock.cornerPoints = pointArr2;
                return textBlock.cornerPoints;
            }
        }
        textBlock = textBlock2;
        return textBlock.cornerPoints;
    }

    public List<? extends Text> getComponents() {
        if (this.zzea.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzeb == null) {
            this.zzeb = new ArrayList(this.zzea.length);
            for (zzac line : this.zzea) {
                this.zzeb.add(new Line(line));
            }
        }
        return this.zzeb;
    }

    public Rect getBoundingBox() {
        if (this.zzed == null) {
            this.zzed = zzc.zza(this);
        }
        return this.zzed;
    }
}
