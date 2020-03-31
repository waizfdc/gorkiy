package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.os.Build;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import java.util.concurrent.Executor;

public final class CameraDeviceCompat {
    private static final CameraDeviceCompatImpl IMPL = chooseImplementation();
    public static final int SESSION_OPERATION_MODE_CONSTRAINED_HIGH_SPEED = 1;
    public static final int SESSION_OPERATION_MODE_NORMAL = 0;

    interface CameraDeviceCompatImpl {
        void createCaptureSession(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessException;
    }

    private CameraDeviceCompat() {
    }

    public static void createCaptureSession(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessException {
        IMPL.createCaptureSession(cameraDevice, sessionConfigurationCompat);
    }

    private static CameraDeviceCompatImpl chooseImplementation() {
        if (Build.VERSION.SDK_INT >= 28) {
            return new CameraDeviceCompatApi28Impl();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return new CameraDeviceCompatApi24Impl();
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return new CameraDeviceCompatApi23Impl();
        }
        return new CameraDeviceCompatBaseImpl();
    }

    static final class StateCallbackExecutorWrapper extends CameraDevice.StateCallback {
        private final Executor mExecutor;
        final CameraDevice.StateCallback mWrappedCallback;

        StateCallbackExecutorWrapper(Executor executor, CameraDevice.StateCallback stateCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = super;
        }

        public void onOpened(final CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraDeviceCompat.StateCallbackExecutorWrapper.AnonymousClass1 */

                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onOpened(cameraDevice);
                }
            });
        }

        public void onDisconnected(final CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraDeviceCompat.StateCallbackExecutorWrapper.AnonymousClass2 */

                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onDisconnected(cameraDevice);
                }
            });
        }

        public void onError(final CameraDevice cameraDevice, final int i) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraDeviceCompat.StateCallbackExecutorWrapper.AnonymousClass3 */

                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onError(cameraDevice, i);
                }
            });
        }

        public void onClosed(final CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraDeviceCompat.StateCallbackExecutorWrapper.AnonymousClass4 */

                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onClosed(cameraDevice);
                }
            });
        }
    }
}
