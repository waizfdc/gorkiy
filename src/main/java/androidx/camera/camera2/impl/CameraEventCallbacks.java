package androidx.camera.camera2.impl;

import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.MultiValueSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class CameraEventCallbacks extends MultiValueSet<CameraEventCallback> {
    public CameraEventCallbacks(CameraEventCallback... cameraEventCallbackArr) {
        addAll(Arrays.asList(cameraEventCallbackArr));
    }

    public ComboCameraEventCallback createComboCallback() {
        return new ComboCameraEventCallback(getAllItems());
    }

    public static CameraEventCallbacks createEmptyCallback() {
        return new CameraEventCallbacks(new CameraEventCallback[0]);
    }

    public MultiValueSet<CameraEventCallback> clone() {
        CameraEventCallbacks createEmptyCallback = createEmptyCallback();
        createEmptyCallback.addAll(getAllItems());
        return super;
    }

    public static final class ComboCameraEventCallback {
        private final List<CameraEventCallback> mCallbacks = new ArrayList();

        ComboCameraEventCallback(List<CameraEventCallback> list) {
            for (CameraEventCallback add : list) {
                this.mCallbacks.add(add);
            }
        }

        public List<CaptureConfig> onPresetSession() {
            LinkedList linkedList = new LinkedList();
            for (CameraEventCallback onPresetSession : this.mCallbacks) {
                CaptureConfig onPresetSession2 = onPresetSession.onPresetSession();
                if (onPresetSession2 != null) {
                    linkedList.add(onPresetSession2);
                }
            }
            return linkedList;
        }

        public List<CaptureConfig> onEnableSession() {
            LinkedList linkedList = new LinkedList();
            for (CameraEventCallback onEnableSession : this.mCallbacks) {
                CaptureConfig onEnableSession2 = onEnableSession.onEnableSession();
                if (onEnableSession2 != null) {
                    linkedList.add(onEnableSession2);
                }
            }
            return linkedList;
        }

        public List<CaptureConfig> onRepeating() {
            LinkedList linkedList = new LinkedList();
            for (CameraEventCallback onRepeating : this.mCallbacks) {
                CaptureConfig onRepeating2 = onRepeating.onRepeating();
                if (onRepeating2 != null) {
                    linkedList.add(onRepeating2);
                }
            }
            return linkedList;
        }

        public List<CaptureConfig> onDisableSession() {
            LinkedList linkedList = new LinkedList();
            for (CameraEventCallback onDisableSession : this.mCallbacks) {
                CaptureConfig onDisableSession2 = onDisableSession.onDisableSession();
                if (onDisableSession2 != null) {
                    linkedList.add(onDisableSession2);
                }
            }
            return linkedList;
        }

        public List<CameraEventCallback> getCallbacks() {
            return this.mCallbacks;
        }
    }
}
