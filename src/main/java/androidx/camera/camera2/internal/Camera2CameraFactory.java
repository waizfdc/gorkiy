package androidx.camera.camera2.internal;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraXThreads;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.LensFacingCameraIdFilter;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public final class Camera2CameraFactory implements CameraFactory {
    private static final int DEFAULT_ALLOWED_CONCURRENT_OPEN_CAMERAS = 1;
    private static final Handler sHandler = new Handler(sHandlerThread.getLooper());
    private static final HandlerThread sHandlerThread;
    private final CameraAvailabilityRegistry mAvailabilityRegistry = new CameraAvailabilityRegistry(1, CameraXExecutors.newHandlerExecutor(sHandler));
    private final CameraManagerCompat mCameraManager;

    static {
        HandlerThread handlerThread = new HandlerThread(CameraXThreads.TAG);
        sHandlerThread = handlerThread;
        handlerThread.start();
    }

    public Camera2CameraFactory(Context context) {
        this.mCameraManager = CameraManagerCompat.from(context);
    }

    public CameraInternal getCamera(String str) throws CameraInfoUnavailableException {
        if (getAvailableCameraIds().contains(str)) {
            Camera2CameraImpl camera2CameraImpl = new Camera2CameraImpl(this.mCameraManager, str, this.mAvailabilityRegistry.getAvailableCameraCount(), sHandler);
            this.mAvailabilityRegistry.registerCamera(camera2CameraImpl);
            return camera2CameraImpl;
        }
        throw new IllegalArgumentException("The given camera id is not on the available camera id list.");
    }

    public Set<String> getAvailableCameraIds() throws CameraInfoUnavailableException {
        try {
            return new LinkedHashSet(Arrays.asList(this.mCameraManager.unwrap().getCameraIdList()));
        } catch (CameraAccessException e) {
            throw new CameraInfoUnavailableException("Unable to retrieve list of cameras on device.", e);
        }
    }

    public String cameraIdForLensFacing(int i) throws CameraInfoUnavailableException {
        Set<String> filter = getLensFacingCameraIdFilter(i).filter(getAvailableCameraIds());
        if (!filter.isEmpty()) {
            return filter.iterator().next();
        }
        return null;
    }

    public LensFacingCameraIdFilter getLensFacingCameraIdFilter(int i) {
        return new Camera2LensFacingCameraIdFilter(i, this.mCameraManager.unwrap());
    }
}
