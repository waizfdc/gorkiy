package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;

public interface CaptureProcessor {
    void onOutputSurface(Surface surface, int i);

    void onResolutionUpdate(Size size);

    void process(ImageProxyBundle imageProxyBundle);
}
