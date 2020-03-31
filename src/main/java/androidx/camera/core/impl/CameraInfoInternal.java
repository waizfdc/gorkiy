package androidx.camera.core.impl;

import androidx.camera.core.CameraInfo;

public interface CameraInfoInternal extends CameraInfo {
    String getCameraId();

    Integer getLensFacing();
}
