package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import java.util.concurrent.Executor;

public final class CameraManagerCompat {
    private final CameraManagerCompatImpl mImpl;

    interface CameraManagerCompatImpl {
        CameraManager getCameraManager();

        void openCamera(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessException;

        void registerAvailabilityCallback(Executor executor, CameraManager.AvailabilityCallback availabilityCallback);

        void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback availabilityCallback);
    }

    private CameraManagerCompat(CameraManagerCompatImpl cameraManagerCompatImpl) {
        this.mImpl = cameraManagerCompatImpl;
    }

    public static CameraManagerCompat from(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new CameraManagerCompat(new CameraManagerCompatApi28Impl(context));
        }
        return new CameraManagerCompat(new CameraManagerCompatBaseImpl(context));
    }

    public void registerAvailabilityCallback(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        this.mImpl.registerAvailabilityCallback(executor, availabilityCallback);
    }

    public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback availabilityCallback) {
        this.mImpl.unregisterAvailabilityCallback(availabilityCallback);
    }

    public void openCamera(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessException {
        this.mImpl.openCamera(str, executor, stateCallback);
    }

    public CameraManager unwrap() {
        return this.mImpl.getCameraManager();
    }

    static final class AvailabilityCallbackExecutorWrapper extends CameraManager.AvailabilityCallback {
        private final Executor mExecutor;
        final CameraManager.AvailabilityCallback mWrappedCallback;

        AvailabilityCallbackExecutorWrapper(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = super;
        }

        public void onCameraAccessPrioritiesChanged() {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraManagerCompat.AvailabilityCallbackExecutorWrapper.AnonymousClass1 */

                public void run() {
                    AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraAccessPrioritiesChanged();
                }
            });
        }

        public void onCameraAvailable(final String str) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraManagerCompat.AvailabilityCallbackExecutorWrapper.AnonymousClass2 */

                public void run() {
                    AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraAvailable(str);
                }
            });
        }

        public void onCameraUnavailable(final String str) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.camera2.internal.compat.CameraManagerCompat.AvailabilityCallbackExecutorWrapper.AnonymousClass3 */

                public void run() {
                    AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraUnavailable(str);
                }
            });
        }
    }
}
