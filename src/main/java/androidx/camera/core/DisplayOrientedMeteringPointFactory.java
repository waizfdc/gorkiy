package androidx.camera.core;

import android.view.Display;
import androidx.camera.core.impl.CameraInfoInternal;

public final class DisplayOrientedMeteringPointFactory extends MeteringPointFactory {
    private final CameraInfoInternal mCameraInfo;
    private final CameraSelector mCameraSelector;
    private final Display mDisplay;
    private final float mHeight;
    private final float mWidth;

    public DisplayOrientedMeteringPointFactory(Display display, CameraSelector cameraSelector, float f, float f2) {
        this.mWidth = f;
        this.mHeight = f2;
        this.mCameraSelector = cameraSelector;
        this.mDisplay = display;
        try {
            this.mCameraInfo = CameraX.getCameraInfo(CameraX.getCameraWithCameraSelector(cameraSelector));
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to get camera id for the CameraSelector.", e);
        }
    }

    private Integer getLensFacing() {
        return this.mCameraInfo.getLensFacing();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.PointF convertPoint(float r9, float r10) {
        /*
            r8 = this;
            float r0 = r8.mWidth
            float r1 = r8.mHeight
            java.lang.Integer r2 = r8.getLensFacing()
            if (r2 == 0) goto L_0x0012
            int r2 = r2.intValue()
            if (r2 != 0) goto L_0x0012
            r2 = 1
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            int r3 = r8.getRelativeCameraOrientation(r2)
            r4 = 270(0x10e, float:3.78E-43)
            r5 = 90
            if (r3 == r5) goto L_0x0026
            if (r3 != r4) goto L_0x0020
            goto L_0x0026
        L_0x0020:
            r6 = r10
            r10 = r9
            r9 = r6
            r7 = r1
            r1 = r0
            r0 = r7
        L_0x0026:
            if (r3 == r5) goto L_0x0034
            r5 = 180(0xb4, float:2.52E-43)
            if (r3 == r5) goto L_0x0032
            if (r3 == r4) goto L_0x002f
            goto L_0x0036
        L_0x002f:
            float r10 = r1 - r10
            goto L_0x0036
        L_0x0032:
            float r10 = r1 - r10
        L_0x0034:
            float r9 = r0 - r9
        L_0x0036:
            if (r2 == 0) goto L_0x003a
            float r10 = r1 - r10
        L_0x003a:
            float r10 = r10 / r1
            float r9 = r9 / r0
            android.graphics.PointF r0 = new android.graphics.PointF
            r0.<init>(r10, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.DisplayOrientedMeteringPointFactory.convertPoint(float, float):android.graphics.PointF");
    }

    private int getRelativeCameraOrientation(boolean z) {
        try {
            int sensorRotationDegrees = this.mCameraInfo.getSensorRotationDegrees(this.mDisplay.getRotation());
            return z ? (360 - sensorRotationDegrees) % 360 : sensorRotationDegrees;
        } catch (Exception unused) {
            return 0;
        }
    }
}
