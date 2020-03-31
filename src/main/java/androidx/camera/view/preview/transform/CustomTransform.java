package androidx.camera.view.preview.transform;

import android.graphics.Matrix;
import android.view.View;

final class CustomTransform {
    private CustomTransform() {
    }

    static Transformation getTransformation(View view, Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return new Transformation(fArr[0], fArr[4], view.getX() + fArr[2], view.getY() + fArr[5], getRotationDegrees(fArr));
    }

    private static float getRotationDegrees(float[] fArr) {
        return (float) Math.toDegrees(-Math.atan2((double) fArr[1], (double) fArr[0]));
    }
}
