package androidx.camera.view.preview.transform;

import android.graphics.Point;
import android.util.Pair;
import android.util.Size;
import android.view.Display;
import android.view.View;

final class ScaleTransform {
    private ScaleTransform() {
    }

    static Pair<Float, Float> fill(View view, View view2, Size size) {
        int i;
        int i2;
        if (view.getWidth() == 0 || view.getHeight() == 0 || view2.getWidth() == 0 || view2.getHeight() == 0 || size.getWidth() == 0 || size.getHeight() == 0) {
            return new Pair<>(Float.valueOf(1.0f), Float.valueOf(1.0f));
        }
        int rotationDegrees = (int) RotationTransform.getRotationDegrees(view2);
        if (isNaturalPortrait(view2, rotationDegrees)) {
            i2 = size.getHeight();
            i = size.getWidth();
        } else {
            i2 = size.getWidth();
            i = size.getHeight();
        }
        float width = ((float) i2) / ((float) view2.getWidth());
        float height = ((float) i) / ((float) view2.getHeight());
        if (rotationDegrees == 0 || rotationDegrees == 180) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        float max = Math.max(((float) view.getWidth()) / ((float) i), ((float) view.getHeight()) / ((float) i2));
        return new Pair<>(Float.valueOf(width * max), Float.valueOf(height * max));
    }

    static Pair<Float, Float> fit(View view, View view2, Size size) {
        Float valueOf = Float.valueOf(1.0f);
        return new Pair<>(valueOf, valueOf);
    }

    private static boolean isNaturalPortrait(View view, int i) {
        Display display = view.getDisplay();
        if (display == null) {
            return true;
        }
        Point point = new Point();
        display.getRealSize(point);
        int i2 = point.x;
        int i3 = point.y;
        if ((i == 0 || i == 180) && i2 < i3) {
            return true;
        }
        if ((i == 90 || i == 270) && i2 >= i3) {
            return true;
        }
        return false;
    }
}
