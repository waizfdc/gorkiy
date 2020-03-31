package androidx.camera.core.impl;

import android.util.Log;
import androidx.camera.core.UseCase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class UseCaseGroup {
    private static final String TAG = "UseCaseGroup";
    private volatile boolean mIsActive = false;
    private final Object mListenerLock = new Object();
    private StateChangeCallback mStateChangeCallback;
    private final Set<UseCase> mUseCases = new HashSet();
    private final Object mUseCasesLock = new Object();

    public interface StateChangeCallback {
        void onGroupActive(UseCaseGroup useCaseGroup);

        void onGroupInactive(UseCaseGroup useCaseGroup);
    }

    public void start() {
        synchronized (this.mListenerLock) {
            if (this.mStateChangeCallback != null) {
                this.mStateChangeCallback.onGroupActive(this);
            }
            this.mIsActive = true;
        }
    }

    public void stop() {
        synchronized (this.mListenerLock) {
            if (this.mStateChangeCallback != null) {
                this.mStateChangeCallback.onGroupInactive(this);
            }
            this.mIsActive = false;
        }
    }

    public void setListener(StateChangeCallback stateChangeCallback) {
        synchronized (this.mListenerLock) {
            this.mStateChangeCallback = stateChangeCallback;
        }
    }

    public boolean addUseCase(UseCase useCase) {
        boolean add;
        synchronized (this.mUseCasesLock) {
            add = this.mUseCases.add(useCase);
        }
        return add;
    }

    public boolean contains(UseCase useCase) {
        boolean contains;
        synchronized (this.mUseCasesLock) {
            contains = this.mUseCases.contains(useCase);
        }
        return contains;
    }

    public boolean removeUseCase(UseCase useCase) {
        boolean remove;
        synchronized (this.mUseCasesLock) {
            remove = this.mUseCases.remove(useCase);
        }
        return remove;
    }

    public void clear() {
        ArrayList<UseCase> arrayList = new ArrayList<>();
        synchronized (this.mUseCasesLock) {
            arrayList.addAll(this.mUseCases);
            this.mUseCases.clear();
        }
        for (UseCase useCase : arrayList) {
            Log.d(TAG, "Clearing use case: " + useCase.getName());
            useCase.clear();
        }
    }

    public Collection<UseCase> getUseCases() {
        Collection<UseCase> unmodifiableCollection;
        synchronized (this.mUseCasesLock) {
            unmodifiableCollection = Collections.unmodifiableCollection(this.mUseCases);
        }
        return unmodifiableCollection;
    }

    public Map<String, Set<UseCase>> getCameraIdToUseCaseMap() {
        HashMap hashMap = new HashMap();
        synchronized (this.mUseCasesLock) {
            for (UseCase next : this.mUseCases) {
                for (String next2 : next.getAttachedCameraIds()) {
                    Object obj = (Set) hashMap.get(next2);
                    if (obj == null) {
                        obj = new HashSet();
                    }
                    obj.add(next);
                    hashMap.put(next2, obj);
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public boolean isActive() {
        return this.mIsActive;
    }
}
