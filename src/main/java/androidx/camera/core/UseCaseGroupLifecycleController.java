package androidx.camera.core;

import androidx.camera.core.impl.UseCaseGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

final class UseCaseGroupLifecycleController implements LifecycleObserver {
    private final Lifecycle mLifecycle;
    private final UseCaseGroup mUseCaseGroup;
    private final Object mUseCaseGroupLock;

    UseCaseGroupLifecycleController(Lifecycle lifecycle) {
        this(lifecycle, new UseCaseGroup());
    }

    UseCaseGroupLifecycleController(Lifecycle lifecycle, UseCaseGroup useCaseGroup) {
        this.mUseCaseGroupLock = new Object();
        this.mUseCaseGroup = useCaseGroup;
        this.mLifecycle = lifecycle;
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner lifecycleOwner) {
        synchronized (this.mUseCaseGroupLock) {
            this.mUseCaseGroup.start();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner lifecycleOwner) {
        synchronized (this.mUseCaseGroupLock) {
            this.mUseCaseGroup.stop();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        synchronized (this.mUseCaseGroupLock) {
            this.mUseCaseGroup.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyState() {
        synchronized (this.mUseCaseGroupLock) {
            if (this.mLifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                this.mUseCaseGroup.start();
            }
            for (UseCase notifyState : this.mUseCaseGroup.getUseCases()) {
                notifyState.notifyState();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public UseCaseGroup getUseCaseGroup() {
        UseCaseGroup useCaseGroup;
        synchronized (this.mUseCaseGroupLock) {
            useCaseGroup = this.mUseCaseGroup;
        }
        return useCaseGroup;
    }

    /* access modifiers changed from: package-private */
    public void release() {
        this.mLifecycle.removeObserver(this);
    }
}
