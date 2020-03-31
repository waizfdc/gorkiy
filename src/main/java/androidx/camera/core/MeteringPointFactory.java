package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;

public abstract class MeteringPointFactory {
    private Rational mSurfaceAspectRatio;

    public static float getDefaultPointSize() {
        return 0.15f;
    }

    /* access modifiers changed from: protected */
    public abstract PointF convertPoint(float f, float f2);

    public MeteringPointFactory() {
        this(null);
    }

    public MeteringPointFactory(Rational rational) {
        this.mSurfaceAspectRatio = rational;
    }

    public final MeteringPoint createPoint(float f, float f2) {
        return createPoint(f, f2, getDefaultPointSize());
    }

    public final MeteringPoint createPoint(float f, float f2, float f3) {
        PointF convertPoint = convertPoint(f, f2);
        return new MeteringPoint(convertPoint.x, convertPoint.y, f3, this.mSurfaceAspectRatio);
    }
}
