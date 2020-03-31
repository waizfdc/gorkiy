package androidx.camera.view.preview.transform;

import android.graphics.Matrix;
import android.util.Size;
import android.view.View;
import androidx.camera.view.PreviewView;

public final class PreviewTransform {
    private PreviewTransform() {
    }

    public static void transform(View view, View view2, Size size, PreviewView.ScaleType scaleType) {
        applyTransformationToPreview(ScaleTypeTransform.getTransformation(view, view2, size, scaleType), view2);
    }

    public static void transform(View view, Matrix matrix) {
        applyTransformationToPreview(CustomTransform.getTransformation(view, matrix), view);
    }

    private static void applyTransformationToPreview(Transformation transformation, View view) {
        view.setScaleX(transformation.getScaleX());
        view.setScaleY(transformation.getScaleY());
        view.setX(transformation.getOriginX());
        view.setY(transformation.getOriginY());
        view.setRotation(transformation.getRotation());
    }
}
