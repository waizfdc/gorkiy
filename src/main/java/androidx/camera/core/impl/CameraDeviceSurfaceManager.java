package androidx.camera.core.impl;

import android.content.Context;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.UseCase;
import java.util.List;
import java.util.Map;

public interface CameraDeviceSurfaceManager {

    public interface Provider {
        CameraDeviceSurfaceManager newInstance(Context context);
    }

    boolean checkSupported(String str, List<SurfaceConfig> list);

    Rational getCorrectedAspectRatio(String str, int i);

    Size getMaxOutputSize(String str, int i);

    Size getPreviewSize();

    Map<UseCase, Size> getSuggestedResolutions(String str, List<UseCase> list, List<UseCase> list2);

    boolean requiresCorrectedAspectRatio(String str);

    SurfaceConfig transformSurfaceConfig(String str, int i, Size size);
}
