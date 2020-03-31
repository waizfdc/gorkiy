package androidx.camera.core.impl;

import android.util.Log;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.SessionConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class UseCaseAttachState {
    private static final String TAG = "UseCaseAttachState";
    private final Map<UseCase, UseCaseAttachInfo> mAttachedUseCasesToInfoMap = new HashMap();
    private final String mCameraId;

    private interface AttachStateFilter {
        boolean filter(UseCaseAttachInfo useCaseAttachInfo);
    }

    public UseCaseAttachState(String str) {
        this.mCameraId = str;
    }

    public void setUseCaseActive(UseCase useCase) {
        getOrCreateUseCaseAttachInfo(useCase).setActive(true);
    }

    public void setUseCaseInactive(UseCase useCase) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(useCase)) {
            UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(useCase);
            useCaseAttachInfo.setActive(false);
            if (!useCaseAttachInfo.getOnline()) {
                this.mAttachedUseCasesToInfoMap.remove(useCase);
            }
        }
    }

    public void setUseCaseOnline(UseCase useCase) {
        getOrCreateUseCaseAttachInfo(useCase).setOnline(true);
    }

    public void setUseCaseOffline(UseCase useCase) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(useCase)) {
            UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(useCase);
            useCaseAttachInfo.setOnline(false);
            if (!useCaseAttachInfo.getActive()) {
                this.mAttachedUseCasesToInfoMap.remove(useCase);
            }
        }
    }

    public boolean isUseCaseOnline(UseCase useCase) {
        if (!this.mAttachedUseCasesToInfoMap.containsKey(useCase)) {
            return false;
        }
        return this.mAttachedUseCasesToInfoMap.get(useCase).getOnline();
    }

    public Collection<UseCase> getOnlineUseCases() {
        return Collections.unmodifiableCollection(getUseCases(new AttachStateFilter() {
            /* class androidx.camera.core.impl.UseCaseAttachState.AnonymousClass1 */

            public boolean filter(UseCaseAttachInfo useCaseAttachInfo) {
                return useCaseAttachInfo.getOnline();
            }
        }));
    }

    public Collection<UseCase> getActiveAndOnlineUseCases() {
        return Collections.unmodifiableCollection(getUseCases(new AttachStateFilter() {
            /* class androidx.camera.core.impl.UseCaseAttachState.AnonymousClass2 */

            public boolean filter(UseCaseAttachInfo useCaseAttachInfo) {
                return useCaseAttachInfo.getActive() && useCaseAttachInfo.getOnline();
            }
        }));
    }

    public void updateUseCase(UseCase useCase) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(useCase)) {
            UseCaseAttachInfo useCaseAttachInfo = new UseCaseAttachInfo(useCase.getSessionConfig(this.mCameraId));
            UseCaseAttachInfo useCaseAttachInfo2 = this.mAttachedUseCasesToInfoMap.get(useCase);
            useCaseAttachInfo.setOnline(useCaseAttachInfo2.getOnline());
            useCaseAttachInfo.setActive(useCaseAttachInfo2.getActive());
            this.mAttachedUseCasesToInfoMap.put(useCase, useCaseAttachInfo);
        }
    }

    public SessionConfig.ValidatingBuilder getActiveAndOnlineBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.mAttachedUseCasesToInfoMap.entrySet()) {
            UseCaseAttachInfo useCaseAttachInfo = (UseCaseAttachInfo) next.getValue();
            if (useCaseAttachInfo.getActive() && useCaseAttachInfo.getOnline()) {
                validatingBuilder.add(useCaseAttachInfo.getSessionConfig());
                arrayList.add(((UseCase) next.getKey()).getName());
            }
        }
        Log.d(TAG, "Active and online use case: " + arrayList + " for camera: " + this.mCameraId);
        return validatingBuilder;
    }

    public SessionConfig.ValidatingBuilder getOnlineBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.mAttachedUseCasesToInfoMap.entrySet()) {
            UseCaseAttachInfo useCaseAttachInfo = (UseCaseAttachInfo) next.getValue();
            if (useCaseAttachInfo.getOnline()) {
                validatingBuilder.add(useCaseAttachInfo.getSessionConfig());
                arrayList.add(((UseCase) next.getKey()).getName());
            }
        }
        Log.d(TAG, "All use case: " + arrayList + " for camera: " + this.mCameraId);
        return validatingBuilder;
    }

    public SessionConfig getUseCaseSessionConfig(UseCase useCase) {
        if (!this.mAttachedUseCasesToInfoMap.containsKey(useCase)) {
            return SessionConfig.defaultEmptySessionConfig();
        }
        return this.mAttachedUseCasesToInfoMap.get(useCase).getSessionConfig();
    }

    private UseCaseAttachInfo getOrCreateUseCaseAttachInfo(UseCase useCase) {
        UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(useCase);
        if (useCaseAttachInfo != null) {
            return useCaseAttachInfo;
        }
        UseCaseAttachInfo useCaseAttachInfo2 = new UseCaseAttachInfo(useCase.getSessionConfig(this.mCameraId));
        this.mAttachedUseCasesToInfoMap.put(useCase, useCaseAttachInfo2);
        return useCaseAttachInfo2;
    }

    private Collection<UseCase> getUseCases(AttachStateFilter attachStateFilter) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.mAttachedUseCasesToInfoMap.entrySet()) {
            if (attachStateFilter == null || attachStateFilter.filter((UseCaseAttachInfo) next.getValue())) {
                arrayList.add(next.getKey());
            }
        }
        return arrayList;
    }

    private static final class UseCaseAttachInfo {
        private boolean mActive = false;
        private boolean mOnline = false;
        private final SessionConfig mSessionConfig;

        UseCaseAttachInfo(SessionConfig sessionConfig) {
            this.mSessionConfig = sessionConfig;
        }

        /* access modifiers changed from: package-private */
        public SessionConfig getSessionConfig() {
            return this.mSessionConfig;
        }

        /* access modifiers changed from: package-private */
        public boolean getOnline() {
            return this.mOnline;
        }

        /* access modifiers changed from: package-private */
        public void setOnline(boolean z) {
            this.mOnline = z;
        }

        /* access modifiers changed from: package-private */
        public boolean getActive() {
            return this.mActive;
        }

        /* access modifiers changed from: package-private */
        public void setActive(boolean z) {
            this.mActive = z;
        }
    }
}
