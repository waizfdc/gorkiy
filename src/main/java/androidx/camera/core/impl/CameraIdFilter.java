package androidx.camera.core.impl;

import java.util.Set;

public interface CameraIdFilter {
    Set<String> filter(Set<String> set);
}
