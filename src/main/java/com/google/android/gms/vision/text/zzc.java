package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzw;

/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
final class zzc {
    static Rect zza(Text text) {
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (Point point : text.getCornerPoints()) {
            i4 = Math.min(i4, point.x);
            i = Math.max(i, point.x);
            i2 = Math.min(i2, point.y);
            i3 = Math.max(i3, point.y);
        }
        return new Rect(i4, i2, i, i3);
    }

    static Point[] zza(zzw zzw) {
        Point[] pointArr = new Point[4];
        double sin = Math.sin(Math.toRadians((double) zzw.zzeg));
        double cos = Math.cos(Math.toRadians((double) zzw.zzeg));
        pointArr[0] = new Point(zzw.left, zzw.top);
        pointArr[1] = new Point((int) (((double) zzw.left) + (((double) zzw.width) * cos)), (int) (((double) zzw.top) + (((double) zzw.width) * sin)));
        pointArr[2] = new Point((int) (((double) pointArr[1].x) - (((double) zzw.height) * sin)), (int) (((double) pointArr[1].y) + (((double) zzw.height) * cos)));
        pointArr[3] = new Point(pointArr[0].x + (pointArr[2].x - pointArr[1].x), pointArr[0].y + (pointArr[2].y - pointArr[1].y));
        return pointArr;
    }
}
