package androidx.camera.view.preview.transform;

import android.graphics.Point;
import android.util.Pair;
import android.util.Size;
import android.view.View;
import androidx.camera.view.PreviewView;

final class ScaleTypeTransform {
    private ScaleTypeTransform() {
    }

    static Transformation getTransformation(View view, View view2, Size size, PreviewView.ScaleType scaleType) {
        Pair<Float, Float> scaleXY = getScaleXY(view, view2, size, scaleType);
        Point gravityOrigin = getGravityOrigin(view, view2, scaleType);
        return new Transformation(((Float) scaleXY.first).floatValue(), ((Float) scaleXY.second).floatValue(), (float) gravityOrigin.x, (float) gravityOrigin.y, -RotationTransform.getRotationDegrees(view2));
    }

    /* renamed from: androidx.camera.view.preview.transform.ScaleTypeTransform$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$view$PreviewView$ScaleType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.view.PreviewView$ScaleType[] r0 = androidx.camera.view.PreviewView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.camera.view.preview.transform.ScaleTypeTransform.AnonymousClass1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType = r0
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FILL_START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = androidx.camera.view.preview.transform.ScaleTypeTransform.AnonymousClass1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FILL_CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = androidx.camera.view.preview.transform.ScaleTypeTransform.AnonymousClass1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FILL_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = androidx.camera.view.preview.transform.ScaleTypeTransform.AnonymousClass1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = androidx.camera.view.preview.transform.ScaleTypeTransform.AnonymousClass1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = androidx.camera.view.preview.transform.ScaleTypeTransform.AnonymousClass1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.preview.transform.ScaleTypeTransform.AnonymousClass1.<clinit>():void");
        }
    }

    private static Pair<Float, Float> getScaleXY(View view, View view2, Size size, PreviewView.ScaleType scaleType) {
        switch (AnonymousClass1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[scaleType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return ScaleTransform.fill(view, view2, size);
            case 4:
            case 5:
            case 6:
                return ScaleTransform.fit(view, view2, size);
            default:
                throw new IllegalArgumentException("Unknown scale type " + scaleType);
        }
    }

    private static Point getGravityOrigin(View view, View view2, PreviewView.ScaleType scaleType) {
        switch (AnonymousClass1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[scaleType.ordinal()]) {
            case 1:
            case 4:
                return GravityTransform.start();
            case 2:
            case 5:
                return GravityTransform.center(view, view2);
            case 3:
            case 6:
                return GravityTransform.end(view, view2);
            default:
                throw new IllegalArgumentException("Unknown scale type " + scaleType);
        }
    }
}
