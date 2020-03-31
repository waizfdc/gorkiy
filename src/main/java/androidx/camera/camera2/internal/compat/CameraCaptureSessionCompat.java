package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.view.Surface;
import java.util.List;
import java.util.concurrent.Executor;

public final class CameraCaptureSessionCompat {
    private static final CameraCaptureSessionCompatImpl IMPL = chooseImplementation();

    interface CameraCaptureSessionCompatImpl {
        int captureBurstRequests(CameraCaptureSession cameraCaptureSession, List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        int captureSingleRequest(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        int setRepeatingBurstRequests(CameraCaptureSession cameraCaptureSession, List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        int setSingleRepeatingRequest(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;
    }

    private CameraCaptureSessionCompat() {
    }

    private static CameraCaptureSessionCompatImpl chooseImplementation() {
        if (Build.VERSION.SDK_INT >= 28) {
            return new CameraCaptureSessionCompatApi28Impl();
        }
        return new CameraCaptureSessionCompatBaseImpl();
    }

    public static int captureBurstRequests(CameraCaptureSession cameraCaptureSession, List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return IMPL.captureBurstRequests(cameraCaptureSession, list, executor, captureCallback);
    }

    public static int captureSingleRequest(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return IMPL.captureSingleRequest(cameraCaptureSession, captureRequest, executor, captureCallback);
    }

    public static int setRepeatingBurstRequests(CameraCaptureSession cameraCaptureSession, List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return IMPL.setRepeatingBurstRequests(cameraCaptureSession, list, executor, captureCallback);
    }

    public static int setSingleRepeatingRequest(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return IMPL.setSingleRepeatingRequest(cameraCaptureSession, captureRequest, executor, captureCallback);
    }

    static final class CaptureCallbackExecutorWrapper extends CameraCaptureSession.CaptureCallback {
        private final Executor mExecutor;
        final CameraCaptureSession.CaptureCallback mWrappedCallback;

        CaptureCallbackExecutorWrapper(Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = super;
        }

        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            final CameraCaptureSession cameraCaptureSession2 = cameraCaptureSession;
            final CaptureRequest captureRequest2 = captureRequest;
            final long j3 = j;
            final long j4 = j2;
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.AnonymousClass1 */

                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureStarted(cameraCaptureSession2, captureRequest2, j3, j4);
                }
            });
        }

        public void onCaptureProgressed(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final CaptureResult captureResult) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.AnonymousClass2 */

                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                }
            });
        }

        public void onCaptureCompleted(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final TotalCaptureResult totalCaptureResult) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.AnonymousClass3 */

                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                }
            });
        }

        public void onCaptureFailed(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final CaptureFailure captureFailure) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.AnonymousClass4 */

                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                }
            });
        }

        public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
            final CameraCaptureSession cameraCaptureSession2 = cameraCaptureSession;
            final int i2 = i;
            final long j2 = j;
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.AnonymousClass5 */

                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureSequenceCompleted(cameraCaptureSession2, i2, j2);
                }
            });
        }

        public void onCaptureSequenceAborted(final CameraCaptureSession cameraCaptureSession, final int i) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.AnonymousClass6 */

                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureSequenceAborted(cameraCaptureSession, i);
                }
            });
        }

        public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j) {
            final CameraCaptureSession cameraCaptureSession2 = cameraCaptureSession;
            final CaptureRequest captureRequest2 = captureRequest;
            final Surface surface2 = surface;
            final long j2 = j;
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.AnonymousClass7 */

                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureBufferLost(cameraCaptureSession2, captureRequest2, surface2, j2);
                }
            });
        }
    }

    static final class StateCallbackExecutorWrapper extends CameraCaptureSession.StateCallback {
        private final Executor mExecutor;
        final CameraCaptureSession.StateCallback mWrappedCallback;

        StateCallbackExecutorWrapper(Executor executor, CameraCaptureSession.StateCallback stateCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = super;
        }

        public void onConfigured(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.StateCallbackExecutorWrapper.AnonymousClass1 */

                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onConfigured(cameraCaptureSession);
                }
            });
        }

        public void onConfigureFailed(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.StateCallbackExecutorWrapper.AnonymousClass2 */

                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onConfigureFailed(cameraCaptureSession);
                }
            });
        }

        public void onReady(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.StateCallbackExecutorWrapper.AnonymousClass3 */

                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onReady(cameraCaptureSession);
                }
            });
        }

        public void onActive(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.StateCallbackExecutorWrapper.AnonymousClass4 */

                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onActive(cameraCaptureSession);
                }
            });
        }

        public void onCaptureQueueEmpty(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.StateCallbackExecutorWrapper.AnonymousClass5 */

                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onCaptureQueueEmpty(cameraCaptureSession);
                }
            });
        }

        public void onClosed(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.StateCallbackExecutorWrapper.AnonymousClass6 */

                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onClosed(cameraCaptureSession);
                }
            });
        }

        public void onSurfacePrepared(final CameraCaptureSession cameraCaptureSession, final Surface surface) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.StateCallbackExecutorWrapper.AnonymousClass7 */

                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onSurfacePrepared(cameraCaptureSession, surface);
                }
            });
        }
    }
}
