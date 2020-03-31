package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public interface CameraControlInternal extends CameraControl {
    public static final CameraControlInternal DEFAULT_EMPTY_INSTANCE = new CameraControlInternal() {
        /* class androidx.camera.core.impl.CameraControlInternal.AnonymousClass1 */

        public void cancelAfAeTrigger(boolean z, boolean z2) {
        }

        public int getFlashMode() {
            return 2;
        }

        public void setCropRegion(Rect rect) {
        }

        public void setFlashMode(int i) {
        }

        public void submitCaptureRequests(List<CaptureConfig> list) {
        }

        public void triggerAePrecapture() {
        }

        public void triggerAf() {
        }

        public ListenableFuture<Void> enableTorch(boolean z) {
            return Futures.immediateFuture(null);
        }

        public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction focusMeteringAction) {
            return Futures.immediateFuture(FocusMeteringResult.emptyInstance());
        }

        public ListenableFuture<Void> cancelFocusAndMetering() {
            return Futures.immediateFuture(null);
        }

        public ListenableFuture<Void> setZoomRatio(float f) {
            return Futures.immediateFuture(null);
        }

        public ListenableFuture<Void> setLinearZoom(float f) {
            return Futures.immediateFuture(null);
        }
    };

    public interface ControlUpdateCallback {
        void onCameraControlCaptureRequests(List<CaptureConfig> list);

        void onCameraControlUpdateSessionConfig(SessionConfig sessionConfig);
    }

    void cancelAfAeTrigger(boolean z, boolean z2);

    int getFlashMode();

    void setCropRegion(Rect rect);

    void setFlashMode(int i);

    void submitCaptureRequests(List<CaptureConfig> list);

    void triggerAePrecapture();

    void triggerAf();
}
