package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.TextureView;
import androidx.camera.core.MeteringPointFactory;

public class TextureViewMeteringPointFactory extends MeteringPointFactory {
    private final TextureView mTextureView;

    public TextureViewMeteringPointFactory(TextureView textureView) {
        this.mTextureView = textureView;
    }

    /* access modifiers changed from: protected */
    public PointF convertPoint(float f, float f2) {
        Matrix matrix = new Matrix();
        this.mTextureView.getTransform(matrix);
        Matrix matrix2 = new Matrix();
        matrix.invert(matrix2);
        float[] fArr = {f, f2};
        matrix2.mapPoints(fArr);
        float[] fArr2 = new float[16];
        this.mTextureView.getSurfaceTexture().getTransformMatrix(fArr2);
        Matrix glMatrixToGraphicsMatrix = glMatrixToGraphicsMatrix(fArr2);
        float[] fArr3 = {fArr[0] / ((float) this.mTextureView.getWidth()), (((float) this.mTextureView.getHeight()) - fArr[1]) / ((float) this.mTextureView.getHeight())};
        glMatrixToGraphicsMatrix.mapPoints(fArr3);
        return new PointF(fArr3[0], fArr3[1]);
    }

    private Matrix glMatrixToGraphicsMatrix(float[] fArr) {
        float[] fArr2 = {fArr[0], fArr[4], fArr[12], fArr[1], fArr[5], fArr[13], fArr[3], fArr[7], fArr[15]};
        Matrix matrix = new Matrix();
        matrix.setValues(fArr2);
        return matrix;
    }
}
