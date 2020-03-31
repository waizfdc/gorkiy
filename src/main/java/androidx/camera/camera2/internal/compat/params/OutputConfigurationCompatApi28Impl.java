package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.util.Preconditions;

class OutputConfigurationCompatApi28Impl extends OutputConfigurationCompatApi26Impl {
    public String getPhysicalCameraId() {
        return null;
    }

    OutputConfigurationCompatApi28Impl(Surface surface) {
        super(new OutputConfiguration(surface));
    }

    OutputConfigurationCompatApi28Impl(Object obj) {
        super(obj);
    }

    static OutputConfigurationCompatApi28Impl wrap(OutputConfiguration outputConfiguration) {
        return new OutputConfigurationCompatApi28Impl(outputConfiguration);
    }

    public void removeSurface(Surface surface) {
        ((OutputConfiguration) getOutputConfiguration()).removeSurface(surface);
    }

    public int getMaxSharedSurfaceCount() {
        return ((OutputConfiguration) getOutputConfiguration()).getMaxSharedSurfaceCount();
    }

    public void setPhysicalCameraId(String str) {
        ((OutputConfiguration) getOutputConfiguration()).setPhysicalCameraId(str);
    }

    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfiguration);
        return this.mObject;
    }
}
