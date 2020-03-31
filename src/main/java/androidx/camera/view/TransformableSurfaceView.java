package androidx.camera.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;

final class TransformableSurfaceView extends SurfaceView {
    private RectF mOverriddenLayoutRect;

    TransformableSurfaceView(Context context) {
        super(context);
    }

    TransformableSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    TransformableSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    TransformableSurfaceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        RectF rectF = this.mOverriddenLayoutRect;
        if (rectF == null) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension((int) rectF.width(), (int) this.mOverriddenLayoutRect.height());
        }
    }

    /* access modifiers changed from: package-private */
    public void setTransform(Matrix matrix) {
        if (!hasRotation(matrix)) {
            RectF rectF = new RectF((float) getLeft(), (float) getTop(), (float) getRight(), (float) getBottom());
            matrix.mapRect(rectF);
            overrideLayout(rectF);
            return;
        }
        throw new IllegalArgumentException("TransformableSurfaceView does not support rotation transformations.");
    }

    private boolean hasRotation(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        if (Math.round((-Math.atan2((double) fArr[1], (double) fArr[0])) * 57.29577951308232d) != 0) {
            return true;
        }
        return false;
    }

    private void overrideLayout(RectF rectF) {
        this.mOverriddenLayoutRect = rectF;
        setX(rectF.left);
        setY(rectF.top);
        requestLayout();
    }
}
