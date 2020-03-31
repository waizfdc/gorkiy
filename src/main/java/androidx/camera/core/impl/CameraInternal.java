package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.UseCase;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;

public interface CameraInternal extends Camera, UseCase.StateChangeCallback {

    public enum State {
        PENDING_OPEN,
        OPENING,
        OPEN,
        CLOSING,
        CLOSED,
        RELEASING,
        RELEASED
    }

    void addOnlineUseCase(Collection<UseCase> collection);

    void close();

    CameraControlInternal getCameraControlInternal();

    CameraInfoInternal getCameraInfoInternal();

    Observable<State> getCameraState();

    void open();

    ListenableFuture<Void> release();

    void removeOnlineUseCase(Collection<UseCase> collection);
}
