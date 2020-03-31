package androidx.camera.view.preview.transform;

import android.graphics.Point;
import android.view.View;

final class GravityTransform {
    private GravityTransform() {
    }

    static Point start() {
        return new Point(0, 0);
    }

    static Point center(View view, View view2) {
        return new Point((view.getWidth() - view2.getWidth()) / 2, (view.getHeight() - view2.getHeight()) / 2);
    }

    static Point end(View view, View view2) {
        return new Point(view.getWidth() - view2.getWidth(), view.getHeight() - view2.getHeight());
    }
}
