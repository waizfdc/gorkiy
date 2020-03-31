package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public abstract class UseCase {
    private final Map<String, CameraControlInternal> mAttachedCameraControlMap = new HashMap();
    private final Map<String, SessionConfig> mAttachedCameraIdToSessionConfigMap = new HashMap();
    private final Map<String, Size> mAttachedSurfaceResolutionMap = new HashMap();
    private CameraInternal mBoundCamera;
    private final Object mBoundCameraLock = new Object();
    private int mImageFormat = 34;
    private State mState = State.INACTIVE;
    private final Set<StateChangeCallback> mStateChangeCallbacks = new HashSet();
    private UseCaseConfig<?> mUseCaseConfig;

    public interface EventCallback {
        void onBind(String str);

        void onUnbind();
    }

    enum State {
        ACTIVE,
        INACTIVE
    }

    public interface StateChangeCallback {
        void onUseCaseActive(UseCase useCase);

        void onUseCaseInactive(UseCase useCase);

        void onUseCaseReset(UseCase useCase);

        void onUseCaseUpdated(UseCase useCase);
    }

    /* access modifiers changed from: protected */
    public UseCaseConfig.Builder<?, ?, ?> getDefaultBuilder(CameraInfo cameraInfo) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCameraControlReady(String str) {
    }

    public void onStateOffline(String str) {
    }

    public void onStateOnline(String str) {
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, Size> onSuggestedResolutionUpdated(Map<String, Size> map);

    protected UseCase(UseCaseConfig<?> useCaseConfig) {
        updateUseCaseConfig(useCaseConfig);
    }

    /* access modifiers changed from: protected */
    public final void updateUseCaseConfig(UseCaseConfig<?> useCaseConfig) {
        this.mUseCaseConfig = applyDefaults(useCaseConfig, getDefaultBuilder(getBoundCamera() == null ? null : getBoundCamera().getCameraInfo()));
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    /* access modifiers changed from: protected */
    public UseCaseConfig<?> applyDefaults(UseCaseConfig<?> useCaseConfig, UseCaseConfig.Builder<?, ?, ?> builder) {
        if (builder == null) {
            return useCaseConfig;
        }
        MutableConfig mutableConfig = builder.getMutableConfig();
        if (useCaseConfig.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO) && mutableConfig.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO_CUSTOM)) {
            mutableConfig.removeOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO_CUSTOM);
        }
        for (Config.Option next : useCaseConfig.listOptions()) {
            mutableConfig.insertOption(next, useCaseConfig.retrieveOption(next));
        }
        return builder.getUseCaseConfig();
    }

    public Set<String> getAttachedCameraIds() {
        return this.mAttachedCameraIdToSessionConfigMap.keySet();
    }

    /* access modifiers changed from: protected */
    public void attachToCamera(String str, SessionConfig sessionConfig) {
        this.mAttachedCameraIdToSessionConfigMap.put(str, sessionConfig);
    }

    public void addStateChangeCallback(StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.add(stateChangeCallback);
    }

    public final void attachCameraControl(String str, CameraControlInternal cameraControlInternal) {
        this.mAttachedCameraControlMap.put(str, cameraControlInternal);
        onCameraControlReady(str);
    }

    /* access modifiers changed from: package-private */
    public final void detachCameraControl(String str) {
        this.mAttachedCameraControlMap.remove(str);
    }

    public void removeStateChangeCallback(StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.remove(stateChangeCallback);
    }

    public SessionConfig getSessionConfig(String str) {
        SessionConfig sessionConfig = this.mAttachedCameraIdToSessionConfigMap.get(str);
        if (sessionConfig != null) {
            return sessionConfig;
        }
        throw new IllegalArgumentException("Invalid camera: " + str);
    }

    /* access modifiers changed from: protected */
    public final void notifyActive() {
        this.mState = State.ACTIVE;
        notifyState();
    }

    /* access modifiers changed from: protected */
    public final void notifyInactive() {
        this.mState = State.INACTIVE;
        notifyState();
    }

    /* access modifiers changed from: protected */
    public final void notifyUpdated() {
        for (StateChangeCallback onUseCaseUpdated : this.mStateChangeCallbacks) {
            onUseCaseUpdated.onUseCaseUpdated(this);
        }
    }

    /* access modifiers changed from: protected */
    public final void notifyReset() {
        for (StateChangeCallback onUseCaseReset : this.mStateChangeCallbacks) {
            onUseCaseReset.onUseCaseReset(this);
        }
    }

    /* renamed from: androidx.camera.core.UseCase$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$UseCase$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.camera.core.UseCase$State[] r0 = androidx.camera.core.UseCase.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.camera.core.UseCase.AnonymousClass1.$SwitchMap$androidx$camera$core$UseCase$State = r0
                androidx.camera.core.UseCase$State r1 = androidx.camera.core.UseCase.State.INACTIVE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = androidx.camera.core.UseCase.AnonymousClass1.$SwitchMap$androidx$camera$core$UseCase$State     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.UseCase$State r1 = androidx.camera.core.UseCase.State.ACTIVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.UseCase.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final void notifyState() {
        int i = AnonymousClass1.$SwitchMap$androidx$camera$core$UseCase$State[this.mState.ordinal()];
        if (i == 1) {
            for (StateChangeCallback onUseCaseInactive : this.mStateChangeCallbacks) {
                onUseCaseInactive.onUseCaseInactive(this);
            }
        } else if (i == 2) {
            for (StateChangeCallback onUseCaseActive : this.mStateChangeCallbacks) {
                onUseCaseActive.onUseCaseActive(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getBoundCameraId() {
        CameraInternal boundCamera = getBoundCamera();
        return ((CameraInternal) Preconditions.checkNotNull(boundCamera, "No camera bound to use case: " + this)).getCameraInfoInternal().getCameraId();
    }

    /* access modifiers changed from: protected */
    public boolean isCurrentlyBoundCamera(String str) {
        if (getBoundCamera() == null) {
            return false;
        }
        return Objects.equals(str, getBoundCameraId());
    }

    public void clear() {
        EventCallback useCaseEventCallback = this.mUseCaseConfig.getUseCaseEventCallback(null);
        if (useCaseEventCallback != null) {
            useCaseEventCallback.onUnbind();
        }
        synchronized (this.mBoundCameraLock) {
            this.mBoundCamera = null;
        }
        this.mStateChangeCallbacks.clear();
    }

    public String getName() {
        UseCaseConfig<?> useCaseConfig = this.mUseCaseConfig;
        return useCaseConfig.getTargetName("<UnknownUseCase-" + hashCode() + ">");
    }

    public UseCaseConfig<?> getUseCaseConfig() {
        return this.mUseCaseConfig;
    }

    public CameraInternal getBoundCamera() {
        CameraInternal cameraInternal;
        synchronized (this.mBoundCameraLock) {
            cameraInternal = this.mBoundCamera;
        }
        return cameraInternal;
    }

    public Size getAttachedSurfaceResolution(String str) {
        return this.mAttachedSurfaceResolutionMap.get(str);
    }

    public void updateSuggestedResolution(Map<String, Size> map) {
        for (Map.Entry next : onSuggestedResolutionUpdated(map).entrySet()) {
            this.mAttachedSurfaceResolutionMap.put(next.getKey(), next.getValue());
        }
    }

    /* access modifiers changed from: protected */
    public void onBind(CameraInternal cameraInternal) {
        synchronized (this.mBoundCameraLock) {
            this.mBoundCamera = cameraInternal;
        }
        updateUseCaseConfig(this.mUseCaseConfig);
        EventCallback useCaseEventCallback = this.mUseCaseConfig.getUseCaseEventCallback(null);
        if (useCaseEventCallback != null) {
            useCaseEventCallback.onBind(cameraInternal.getCameraInfoInternal().getCameraId());
        }
    }

    /* access modifiers changed from: protected */
    public CameraControlInternal getCameraControl(String str) {
        CameraControlInternal cameraControlInternal = this.mAttachedCameraControlMap.get(str);
        return cameraControlInternal == null ? CameraControlInternal.DEFAULT_EMPTY_INSTANCE : cameraControlInternal;
    }

    public int getImageFormat() {
        return this.mImageFormat;
    }

    /* access modifiers changed from: protected */
    public void setImageFormat(int i) {
        this.mImageFormat = i;
    }
}
