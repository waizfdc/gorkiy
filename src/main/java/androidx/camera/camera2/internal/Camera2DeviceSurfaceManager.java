package androidx.camera.camera2.internal;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Camera2DeviceSurfaceManager implements CameraDeviceSurfaceManager {
    private static final Size MAXIMUM_PREVIEW_SIZE = new Size(1920, 1080);
    private static final String TAG = "Camera2DeviceSurfaceManager";
    private final CamcorderProfileHelper mCamcorderProfileHelper;
    private final Map<String, SupportedSurfaceCombination> mCameraSupportedSurfaceCombinationMap;

    public Camera2DeviceSurfaceManager(Context context) {
        this(context, $$Lambda$U7YGfX89lmJkjkmxjZTvW1ZUo0.INSTANCE);
    }

    Camera2DeviceSurfaceManager(Context context, CamcorderProfileHelper camcorderProfileHelper) {
        this.mCameraSupportedSurfaceCombinationMap = new HashMap();
        Preconditions.checkNotNull(camcorderProfileHelper);
        this.mCamcorderProfileHelper = camcorderProfileHelper;
        init(context);
    }

    private void init(Context context) {
        Preconditions.checkNotNull(context);
        try {
            for (String str : ((CameraManager) Preconditions.checkNotNull((CameraManager) context.getSystemService("camera"))).getCameraIdList()) {
                this.mCameraSupportedSurfaceCombinationMap.put(str, new SupportedSurfaceCombination(context, str, this.mCamcorderProfileHelper));
            }
        } catch (CameraAccessException e) {
            throw new IllegalArgumentException("Fail to get camera id list", e);
        }
    }

    public boolean checkSupported(String str, List<SurfaceConfig> list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.checkSupported(list);
        }
        return false;
    }

    public SurfaceConfig transformSurfaceConfig(String str, int i, Size size) {
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.transformSurfaceConfig(i, size);
        }
        return null;
    }

    public Map<UseCase, Size> getSuggestedResolutions(String str, List<UseCase> list, List<UseCase> list2) {
        Preconditions.checkNotNull(list2, "No new use cases to be bound.");
        Preconditions.checkArgument(!list2.isEmpty(), "No new use cases to be bound.");
        UseCaseSurfaceOccupancyManager.checkUseCaseLimitNotExceeded(list, list2);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (UseCase next : list) {
                arrayList.add(transformSurfaceConfig(str, next.getImageFormat(), next.getAttachedSurfaceResolution(((CameraInternal) Preconditions.checkNotNull(next.getBoundCamera())).getCameraInfoInternal().getCameraId())));
            }
        }
        for (UseCase imageFormat : list2) {
            arrayList.add(transformSurfaceConfig(str, imageFormat.getImageFormat(), new Size(640, 480)));
        }
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination != null && supportedSurfaceCombination.checkSupported(arrayList)) {
            return supportedSurfaceCombination.getSuggestedResolutions(list, list2);
        }
        throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + str + ".  May be attempting to bind too many use cases.");
    }

    public Size getMaxOutputSize(String str, int i) {
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.getMaxOutputSizeByFormat(i);
        }
        throw new IllegalArgumentException("Fail to find supported surface info - CameraId:" + str);
    }

    public Size getPreviewSize() {
        Size size = MAXIMUM_PREVIEW_SIZE;
        if (this.mCameraSupportedSurfaceCombinationMap.isEmpty()) {
            return size;
        }
        return this.mCameraSupportedSurfaceCombinationMap.get((String) this.mCameraSupportedSurfaceCombinationMap.keySet().toArray()[0]).getSurfaceSizeDefinition().getPreviewSize();
    }

    public boolean requiresCorrectedAspectRatio(String str) {
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.requiresCorrectedAspectRatio();
        }
        throw new IllegalArgumentException("Fail to find supported surface info - CameraId:" + str);
    }

    public Rational getCorrectedAspectRatio(String str, int i) {
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.getCorrectedAspectRatio(i);
        }
        throw new IllegalArgumentException("Fail to find supported surface info - CameraId:" + str);
    }
}
