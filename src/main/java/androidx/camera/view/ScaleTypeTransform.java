package androidx.camera.view;

import android.content.Context;
import android.graphics.Point;
import android.util.Pair;
import android.util.Size;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

final class ScaleTypeTransform {
    static Pair<Float, Float> getFillScaleWithBufferAspectRatio(View view, View view2, Size size) {
        int i;
        int i2;
        if (view.getWidth() == 0 || view.getHeight() == 0 || view2.getWidth() == 0 || view2.getHeight() == 0 || size.getWidth() == 0 || size.getHeight() == 0) {
            return new Pair<>(Float.valueOf(1.0f), Float.valueOf(1.0f));
        }
        int rotationDegrees = getRotationDegrees(view2);
        if (isNaturalPortrait(view2.getContext(), rotationDegrees)) {
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

    static Point getOriginOfCenteredView(View view, View view2) {
        return new Point(-((view2.getWidth() - view.getWidth()) / 2), -((view2.getHeight() - view.getHeight()) / 2));
    }

    static int getRotationDegrees(View view) {
        WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        return SurfaceRotation.rotationDegreesFromSurfaceRotation(windowManager.getDefaultDisplay().getRotation());
    }

    private static boolean isNaturalPortrait(Context context, int i) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return true;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
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

    private ScaleTypeTransform() {
    }
}
