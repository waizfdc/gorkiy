package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.CameraInfo;

public interface UseCaseConfigFactory {

    public interface Provider {
        UseCaseConfigFactory newInstance(Context context);
    }

    <C extends UseCaseConfig<?>> C getConfig(Class<C> cls, CameraInfo cameraInfo);
}
