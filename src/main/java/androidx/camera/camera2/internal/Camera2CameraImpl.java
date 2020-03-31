package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseAttachState;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

final class Camera2CameraImpl implements CameraInternal {
    private static final int ERROR_NONE = 0;
    private static final String TAG = "Camera";
    private final Observable<Integer> mAvailableCamerasObservable;
    private final CameraAvailability mCameraAvailability;
    private final Camera2CameraControl mCameraControlInternal;
    SessionConfig mCameraControlSessionConfig = SessionConfig.defaultEmptySessionConfig();
    CameraDevice mCameraDevice;
    int mCameraDeviceError = 0;
    final CameraInfoInternal mCameraInfoInternal;
    private final CameraManagerCompat mCameraManager;
    CaptureSession mCaptureSession;
    private CaptureSession.Builder mCaptureSessionBuilder = new CaptureSession.Builder();
    final Set<CaptureSession> mConfiguringForClose = new HashSet();
    private final Executor mExecutor;
    private final LiveDataObservable<CameraInternal.State> mObservableState = new LiveDataObservable<>();
    final AtomicInteger mReleaseRequestCount = new AtomicInteger(0);
    final Map<CaptureSession, ListenableFuture<Void>> mReleasedCaptureSessions = new LinkedHashMap();
    volatile InternalState mState = InternalState.INITIALIZED;
    private final StateCallback mStateCallback = new StateCallback();
    private final UseCaseAttachState mUseCaseAttachState;
    ListenableFuture<Void> mUserReleaseFuture;
    CallbackToFutureAdapter.Completer<Void> mUserReleaseNotifier;

    enum InternalState {
        INITIALIZED,
        PENDING_OPEN,
        OPENING,
        OPENED,
        CLOSING,
        REOPENING,
        RELEASING,
        RELEASED
    }

    static String getErrorMessage(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "UNKNOWN ERROR" : "ERROR_CAMERA_SERVICE" : "ERROR_CAMERA_DEVICE" : "ERROR_CAMERA_DISABLED" : "ERROR_MAX_CAMERAS_IN_USE" : "ERROR_CAMERA_IN_USE" : "ERROR_NONE";
    }

    Camera2CameraImpl(CameraManagerCompat cameraManagerCompat, String str, Observable<Integer> observable, Handler handler) {
        this.mCameraManager = cameraManagerCompat;
        this.mAvailableCamerasObservable = observable;
        ScheduledExecutorService newHandlerExecutor = CameraXExecutors.newHandlerExecutor(handler);
        this.mExecutor = newHandlerExecutor;
        this.mUseCaseAttachState = new UseCaseAttachState(str);
        this.mObservableState.postValue(CameraInternal.State.CLOSED);
        try {
            CameraCharacteristics cameraCharacteristics = this.mCameraManager.unwrap().getCameraCharacteristics(str);
            Camera2CameraControl camera2CameraControl = new Camera2CameraControl(cameraCharacteristics, newHandlerExecutor, this.mExecutor, new ControlUpdateListenerInternal());
            this.mCameraControlInternal = camera2CameraControl;
            Camera2CameraInfoImpl camera2CameraInfoImpl = new Camera2CameraInfoImpl(str, cameraCharacteristics, camera2CameraControl.getZoomControl(), this.mCameraControlInternal.getTorchControl());
            this.mCameraInfoInternal = camera2CameraInfoImpl;
            this.mCaptureSessionBuilder.setSupportedHardwareLevel(camera2CameraInfoImpl.getSupportedHardwareLevel());
            this.mCaptureSessionBuilder.setExecutor(this.mExecutor);
            this.mCaptureSessionBuilder.setScheduledExecutorService(newHandlerExecutor);
            this.mCaptureSession = this.mCaptureSessionBuilder.build();
            CameraAvailability cameraAvailability = new CameraAvailability(str);
            this.mCameraAvailability = cameraAvailability;
            this.mAvailableCamerasObservable.addObserver(this.mExecutor, cameraAvailability);
            this.mCameraManager.registerAvailabilityCallback(this.mExecutor, this.mCameraAvailability);
        } catch (CameraAccessException e) {
            throw new IllegalStateException("Cannot access camera", e);
        }
    }

    public void open() {
        this.mExecutor.execute(new Runnable() {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$tFCuzMJVSd_6gQqkOS71yo2JPHA */

            public final void run() {
                Camera2CameraImpl.this.openInternal();
            }
        });
    }

    /* renamed from: androidx.camera.camera2.internal.Camera2CameraImpl$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState[] r0 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.camera.camera2.internal.Camera2CameraImpl.AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState = r0
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = androidx.camera.camera2.internal.Camera2CameraImpl.AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.CLOSING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = androidx.camera.camera2.internal.Camera2CameraImpl.AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.OPENED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = androidx.camera.camera2.internal.Camera2CameraImpl.AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.OPENING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = androidx.camera.camera2.internal.Camera2CameraImpl.AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.REOPENING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = androidx.camera.camera2.internal.Camera2CameraImpl.AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.PENDING_OPEN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = androidx.camera.camera2.internal.Camera2CameraImpl.AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.RELEASING     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = androidx.camera.camera2.internal.Camera2CameraImpl.AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.RELEASED     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.Camera2CameraImpl.AnonymousClass4.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void openInternal() {
        int i = AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[this.mState.ordinal()];
        boolean z = true;
        if (i == 1) {
            openCameraDevice();
        } else if (i != 2) {
            Log.d(TAG, "open() ignored due to being in state: " + this.mState);
        } else {
            setState(InternalState.REOPENING);
            if (!isSessionCloseComplete() && this.mCameraDeviceError == 0) {
                if (this.mCameraDevice == null) {
                    z = false;
                }
                Preconditions.checkState(z, "Camera Device should be open if session close is not complete");
                setState(InternalState.OPENED);
                openCaptureSession();
            }
        }
    }

    public void close() {
        this.mExecutor.execute(new Runnable() {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$UC0M7m80_HJTLdlzE6dfb6TvRHY */

            public final void run() {
                Camera2CameraImpl.this.closeInternal();
            }
        });
    }

    /* access modifiers changed from: private */
    public void closeInternal() {
        Log.d(TAG, "Closing camera: " + this.mCameraInfoInternal.getCameraId());
        int i = AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[this.mState.ordinal()];
        boolean z = false;
        if (i == 3) {
            setState(InternalState.CLOSING);
            closeCamera(false);
        } else if (i == 4 || i == 5) {
            setState(InternalState.CLOSING);
        } else if (i != 6) {
            Log.d(TAG, "close() ignored due to being in state: " + this.mState);
        } else {
            if (this.mCameraDevice == null) {
                z = true;
            }
            Preconditions.checkState(z);
            setState(InternalState.INITIALIZED);
        }
    }

    private void configAndClose(boolean z) {
        final CaptureSession build = this.mCaptureSessionBuilder.build();
        this.mConfiguringForClose.add(build);
        resetCaptureSession(z);
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(640, 480);
        Surface surface = new Surface(surfaceTexture);
        final $$Lambda$Camera2CameraImpl$uk0LTTpHa2F5WWH3KTX1TkFW3ps r2 = new Runnable(surface, surfaceTexture) {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$uk0LTTpHa2F5WWH3KTX1TkFW3ps */
            private final /* synthetic */ Surface f$0;
            private final /* synthetic */ SurfaceTexture f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                Camera2CameraImpl.lambda$configAndClose$0(this.f$0, this.f$1);
            }
        };
        SessionConfig.Builder builder = new SessionConfig.Builder();
        builder.addNonRepeatingSurface(new ImmediateSurface(surface));
        builder.setTemplateType(1);
        Log.d(TAG, "Start configAndClose.");
        Futures.addCallback(build.open(builder.build(), this.mCameraDevice), new FutureCallback<Void>() {
            /* class androidx.camera.camera2.internal.Camera2CameraImpl.AnonymousClass1 */

            public void onSuccess(Void voidR) {
                Camera2CameraImpl.this.closeStaleCaptureSessions(build);
                Camera2CameraImpl.this.releaseDummySession(build, r2);
            }

            public void onFailure(Throwable th) {
                Log.d(Camera2CameraImpl.TAG, "Unable to configure camera " + Camera2CameraImpl.this.mCameraInfoInternal.getCameraId() + " due to " + th.getMessage());
                Camera2CameraImpl.this.releaseDummySession(build, r2);
            }
        }, this.mExecutor);
    }

    static /* synthetic */ void lambda$configAndClose$0(Surface surface, SurfaceTexture surfaceTexture) {
        surface.release();
        surfaceTexture.release();
    }

    /* access modifiers changed from: package-private */
    public void releaseDummySession(CaptureSession captureSession, Runnable runnable) {
        this.mConfiguringForClose.remove(captureSession);
        releaseSession(captureSession, false).addListener(runnable, CameraXExecutors.directExecutor());
    }

    /* access modifiers changed from: package-private */
    public boolean isSessionCloseComplete() {
        return this.mReleasedCaptureSessions.isEmpty() && this.mConfiguringForClose.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void finishClose() {
        Preconditions.checkState(this.mState == InternalState.RELEASING || this.mState == InternalState.CLOSING);
        Preconditions.checkState(this.mReleasedCaptureSessions.isEmpty());
        this.mCameraDevice = null;
        if (this.mState == InternalState.CLOSING) {
            setState(InternalState.INITIALIZED);
            return;
        }
        setState(InternalState.RELEASED);
        this.mAvailableCamerasObservable.removeObserver(this.mCameraAvailability);
        this.mCameraManager.unregisterAvailabilityCallback(this.mCameraAvailability);
        CallbackToFutureAdapter.Completer<Void> completer = this.mUserReleaseNotifier;
        if (completer != null) {
            completer.set(null);
            this.mUserReleaseNotifier = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void closeCamera(boolean z) {
        boolean z2 = false;
        Preconditions.checkState(this.mState == InternalState.CLOSING || this.mState == InternalState.RELEASING || (this.mState == InternalState.REOPENING && this.mCameraDeviceError != 0), "closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + this.mState + " (error: " + getErrorMessage(this.mCameraDeviceError) + ")");
        if (((Camera2CameraInfoImpl) getCameraInfoInternal()).getSupportedHardwareLevel() == 2) {
            z2 = true;
        }
        if (Build.VERSION.SDK_INT <= 23 || Build.VERSION.SDK_INT >= 29 || !z2 || this.mCameraDeviceError != 0) {
            resetCaptureSession(z);
        } else {
            configAndClose(z);
        }
        this.mCaptureSession.cancelIssuedCaptureRequests();
    }

    public ListenableFuture<Void> release() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$5CchKeuwJTmxSf_8XdoUol5CxQU */

            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return Camera2CameraImpl.this.lambda$release$2$Camera2CameraImpl(completer);
            }
        });
    }

    public /* synthetic */ Object lambda$release$2$Camera2CameraImpl(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable(completer) {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$fQ9YsYV4n5_gJs1fPK4m2eb4ic */
            private final /* synthetic */ CallbackToFutureAdapter.Completer f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Camera2CameraImpl.this.lambda$null$1$Camera2CameraImpl(this.f$1);
            }
        });
        return "Release[request=" + this.mReleaseRequestCount.getAndIncrement() + "]";
    }

    public /* synthetic */ void lambda$null$1$Camera2CameraImpl(CallbackToFutureAdapter.Completer completer) {
        Futures.propagate(releaseInternal(), completer);
    }

    private ListenableFuture<Void> releaseInternal() {
        ListenableFuture<Void> orCreateUserReleaseFuture = getOrCreateUserReleaseFuture();
        boolean z = true;
        switch (AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[this.mState.ordinal()]) {
            case 1:
            case 6:
                if (this.mCameraDevice != null) {
                    z = false;
                }
                Preconditions.checkState(z);
                setState(InternalState.RELEASING);
                Preconditions.checkState(isSessionCloseComplete());
                finishClose();
                break;
            case 2:
            case 4:
            case 5:
            case 7:
                setState(InternalState.RELEASING);
                break;
            case 3:
                setState(InternalState.RELEASING);
                closeCamera(true);
                break;
            default:
                Log.d(TAG, "release() ignored due to being in state: " + this.mState);
                break;
        }
        return orCreateUserReleaseFuture;
    }

    private ListenableFuture<Void> getOrCreateUserReleaseFuture() {
        if (this.mUserReleaseFuture == null) {
            if (this.mState != InternalState.RELEASED) {
                this.mUserReleaseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() {
                    /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$fdO_RSwTpczwJ8hciYGsVqCv1gs */

                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return Camera2CameraImpl.this.lambda$getOrCreateUserReleaseFuture$3$Camera2CameraImpl(completer);
                    }
                });
            } else {
                this.mUserReleaseFuture = Futures.immediateFuture(null);
            }
        }
        return this.mUserReleaseFuture;
    }

    public /* synthetic */ Object lambda$getOrCreateUserReleaseFuture$3$Camera2CameraImpl(CallbackToFutureAdapter.Completer completer) throws Exception {
        Preconditions.checkState(this.mUserReleaseNotifier == null, "Camera can only be released once, so release completer should be null on creation.");
        this.mUserReleaseNotifier = completer;
        return "Release[camera=" + this + "]";
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> releaseSession(final CaptureSession captureSession, boolean z) {
        captureSession.close();
        ListenableFuture<Void> release = captureSession.release(z);
        Log.d(TAG, "releasing session in state " + this.mState.name());
        this.mReleasedCaptureSessions.put(captureSession, release);
        Futures.addCallback(release, new FutureCallback<Void>() {
            /* class androidx.camera.camera2.internal.Camera2CameraImpl.AnonymousClass2 */

            public void onFailure(Throwable th) {
            }

            public void onSuccess(Void voidR) {
                Camera2CameraImpl.this.mReleasedCaptureSessions.remove(captureSession);
                int i = AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[Camera2CameraImpl.this.mState.ordinal()];
                if (i != 2) {
                    if (i != 5) {
                        if (i != 7) {
                            return;
                        }
                    } else if (Camera2CameraImpl.this.mCameraDeviceError == 0) {
                        return;
                    }
                }
                if (Camera2CameraImpl.this.isSessionCloseComplete() && Camera2CameraImpl.this.mCameraDevice != null) {
                    Camera2CameraImpl.this.mCameraDevice.close();
                    Camera2CameraImpl.this.mCameraDevice = null;
                }
            }
        }, CameraXExecutors.directExecutor());
        return release;
    }

    public Observable<CameraInternal.State> getCameraState() {
        return this.mObservableState;
    }

    public void onUseCaseActive(UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new Runnable(useCase) {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$TMsHTDAH1CH4sDiZkII1XxPFppI */
            private final /* synthetic */ UseCase f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Camera2CameraImpl.this.lambda$onUseCaseActive$4$Camera2CameraImpl(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$onUseCaseActive$4$Camera2CameraImpl(UseCase useCase) {
        Log.d(TAG, "Use case " + useCase + " ACTIVE for camera " + this.mCameraInfoInternal.getCameraId());
        this.mUseCaseAttachState.setUseCaseActive(useCase);
        this.mUseCaseAttachState.updateUseCase(useCase);
        updateCaptureSessionConfig();
    }

    public void onUseCaseInactive(UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new Runnable(useCase) {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$7Txc67S146YaHtfnM8aykQqncpw */
            private final /* synthetic */ UseCase f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Camera2CameraImpl.this.lambda$onUseCaseInactive$5$Camera2CameraImpl(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$onUseCaseInactive$5$Camera2CameraImpl(UseCase useCase) {
        Log.d(TAG, "Use case " + useCase + " INACTIVE for camera " + this.mCameraInfoInternal.getCameraId());
        this.mUseCaseAttachState.setUseCaseInactive(useCase);
        updateCaptureSessionConfig();
    }

    public void onUseCaseUpdated(UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new Runnable(useCase) {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$SEVETBHTZqPnYRa2CLtP3I8vao */
            private final /* synthetic */ UseCase f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Camera2CameraImpl.this.lambda$onUseCaseUpdated$6$Camera2CameraImpl(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$onUseCaseUpdated$6$Camera2CameraImpl(UseCase useCase) {
        Log.d(TAG, "Use case " + useCase + " UPDATED for camera " + this.mCameraInfoInternal.getCameraId());
        this.mUseCaseAttachState.updateUseCase(useCase);
        updateCaptureSessionConfig();
    }

    public void onUseCaseReset(UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new Runnable(useCase) {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$A1amYMQE9w_YK1K0m9xJmwJAeE */
            private final /* synthetic */ UseCase f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Camera2CameraImpl.this.lambda$onUseCaseReset$7$Camera2CameraImpl(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$onUseCaseReset$7$Camera2CameraImpl(UseCase useCase) {
        Log.d(TAG, "Use case " + useCase + " RESET for camera " + this.mCameraInfoInternal.getCameraId());
        this.mUseCaseAttachState.updateUseCase(useCase);
        resetCaptureSession(false);
        updateCaptureSessionConfig();
        openCaptureSession();
    }

    /* access modifiers changed from: package-private */
    public boolean isUseCaseOnline(UseCase useCase) {
        try {
            return ((Boolean) CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(useCase) {
                /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$HxsWLzBhhzqtn9xJwDP3Uu34o */
                private final /* synthetic */ UseCase f$1;

                {
                    this.f$1 = r2;
                }

                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return Camera2CameraImpl.this.lambda$isUseCaseOnline$9$Camera2CameraImpl(this.f$1, completer);
                }
            }).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Unable to check if use case is online.", e);
        }
    }

    public /* synthetic */ Object lambda$isUseCaseOnline$9$Camera2CameraImpl(UseCase useCase, CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            this.mExecutor.execute(new Runnable(completer, useCase) {
                /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$bS0o8K6yo95RAhoLXadw5rkivGc */
                private final /* synthetic */ CallbackToFutureAdapter.Completer f$1;
                private final /* synthetic */ UseCase f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    Camera2CameraImpl.this.lambda$null$8$Camera2CameraImpl(this.f$1, this.f$2);
                }
            });
            return "isUseCaseOnline";
        } catch (RejectedExecutionException unused) {
            completer.setException(new RuntimeException("Unable to check if use case is online. Camera executor shut down."));
            return "isUseCaseOnline";
        }
    }

    public /* synthetic */ void lambda$null$8$Camera2CameraImpl(CallbackToFutureAdapter.Completer completer, UseCase useCase) {
        completer.set(Boolean.valueOf(this.mUseCaseAttachState.isUseCaseOnline(useCase)));
    }

    public void addOnlineUseCase(Collection<UseCase> collection) {
        if (!collection.isEmpty()) {
            this.mCameraControlInternal.setActive(true);
            this.mExecutor.execute(new Runnable(collection) {
                /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$Df5M1T9h5eRGRFHHyDoZKAxYbL4 */
                private final /* synthetic */ Collection f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    Camera2CameraImpl.this.lambda$addOnlineUseCase$10$Camera2CameraImpl(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: tryAddOnlineUseCases */
    public void lambda$addOnlineUseCase$10$Camera2CameraImpl(Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList();
        String cameraId = this.mCameraInfoInternal.getCameraId();
        for (UseCase next : collection) {
            if (!this.mUseCaseAttachState.isUseCaseOnline(next)) {
                arrayList.add(next);
                this.mUseCaseAttachState.setUseCaseOnline(next);
            }
        }
        if (!arrayList.isEmpty()) {
            Log.d(TAG, "Use cases [" + TextUtils.join(", ", arrayList) + "] now ONLINE for camera " + cameraId);
            notifyStateOnlineToUseCases(arrayList);
            updateCaptureSessionConfig();
            resetCaptureSession(false);
            if (this.mState == InternalState.OPENED) {
                openCaptureSession();
            } else {
                openInternal();
            }
            updateCameraControlPreviewAspectRatio(arrayList);
        }
    }

    private void notifyStateOnlineToUseCases(List<UseCase> list) {
        CameraXExecutors.mainThreadExecutor().execute(new Runnable(list) {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$1GBcDQ7vAmdwUiKUN55462xnj_8 */
            private final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Camera2CameraImpl.this.lambda$notifyStateOnlineToUseCases$11$Camera2CameraImpl(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$notifyStateOnlineToUseCases$11$Camera2CameraImpl(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((UseCase) it.next()).onStateOnline(this.mCameraInfoInternal.getCameraId());
        }
    }

    private void notifyStateOfflineToUseCases(List<UseCase> list) {
        CameraXExecutors.mainThreadExecutor().execute(new Runnable(list) {
            /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$12f6LAfz84Ochaa_VfAClFjUcj0 */
            private final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                Camera2CameraImpl.this.lambda$notifyStateOfflineToUseCases$12$Camera2CameraImpl(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$notifyStateOfflineToUseCases$12$Camera2CameraImpl(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((UseCase) it.next()).onStateOffline(this.mCameraInfoInternal.getCameraId());
        }
    }

    private void updateCameraControlPreviewAspectRatio(Collection<UseCase> collection) {
        for (UseCase next : collection) {
            if (next instanceof Preview) {
                Size attachedSurfaceResolution = next.getAttachedSurfaceResolution(this.mCameraInfoInternal.getCameraId());
                this.mCameraControlInternal.setPreviewAspectRatio(new Rational(attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight()));
                return;
            }
        }
    }

    private void clearCameraControlPreviewAspectRatio(Collection<UseCase> collection) {
        for (UseCase useCase : collection) {
            if (useCase instanceof Preview) {
                this.mCameraControlInternal.setPreviewAspectRatio(null);
                return;
            }
        }
    }

    public void removeOnlineUseCase(Collection<UseCase> collection) {
        if (!collection.isEmpty()) {
            this.mExecutor.execute(new Runnable(collection) {
                /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$5wc8VkOCNW87m5eLEZfzgWUlnY */
                private final /* synthetic */ Collection f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    Camera2CameraImpl.this.lambda$removeOnlineUseCase$13$Camera2CameraImpl(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: tryRemoveOnlineUseCases */
    public void lambda$removeOnlineUseCase$13$Camera2CameraImpl(Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList();
        for (UseCase next : collection) {
            if (this.mUseCaseAttachState.isUseCaseOnline(next)) {
                this.mUseCaseAttachState.setUseCaseOffline(next);
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            Log.d(TAG, "Use cases [" + TextUtils.join(", ", arrayList) + "] now OFFLINE for camera " + this.mCameraInfoInternal.getCameraId());
            clearCameraControlPreviewAspectRatio(arrayList);
            notifyStateOfflineToUseCases(arrayList);
            if (this.mUseCaseAttachState.getOnlineUseCases().isEmpty()) {
                this.mCameraControlInternal.setActive(false);
                resetCaptureSession(false);
                closeInternal();
                return;
            }
            updateCaptureSessionConfig();
            resetCaptureSession(false);
            if (this.mState == InternalState.OPENED) {
                openCaptureSession();
            }
        }
    }

    public CameraInfoInternal getCameraInfoInternal() {
        return this.mCameraInfoInternal;
    }

    /* access modifiers changed from: package-private */
    public void openCameraDevice() {
        if (!this.mCameraAvailability.isCameraAvailable()) {
            Log.d(TAG, "No cameras available. Waiting for available camera before opening camera: " + this.mCameraInfoInternal.getCameraId());
            setState(InternalState.PENDING_OPEN);
            return;
        }
        setState(InternalState.OPENING);
        Log.d(TAG, "Opening camera: " + this.mCameraInfoInternal.getCameraId());
        try {
            this.mCameraManager.openCamera(this.mCameraInfoInternal.getCameraId(), this.mExecutor, createDeviceStateCallback());
        } catch (CameraAccessException e) {
            Log.d(TAG, "Unable to open camera " + this.mCameraInfoInternal.getCameraId() + " due to " + e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public void updateCaptureSessionConfig() {
        SessionConfig.ValidatingBuilder activeAndOnlineBuilder = this.mUseCaseAttachState.getActiveAndOnlineBuilder();
        if (activeAndOnlineBuilder.isValid()) {
            activeAndOnlineBuilder.add(this.mCameraControlSessionConfig);
            this.mCaptureSession.setSessionConfig(activeAndOnlineBuilder.build());
        }
    }

    /* access modifiers changed from: package-private */
    public void openCaptureSession() {
        Preconditions.checkState(this.mState == InternalState.OPENED);
        SessionConfig.ValidatingBuilder onlineBuilder = this.mUseCaseAttachState.getOnlineBuilder();
        if (!onlineBuilder.isValid()) {
            Log.d(TAG, "Unable to create capture session due to conflicting configurations");
            return;
        }
        final CaptureSession captureSession = this.mCaptureSession;
        Futures.addCallback(captureSession.open(onlineBuilder.build(), this.mCameraDevice), new FutureCallback<Void>() {
            /* class androidx.camera.camera2.internal.Camera2CameraImpl.AnonymousClass3 */

            public void onSuccess(Void voidR) {
                Camera2CameraImpl.this.closeStaleCaptureSessions(captureSession);
            }

            public void onFailure(Throwable th) {
                if (th instanceof CameraAccessException) {
                    Log.d(Camera2CameraImpl.TAG, "Unable to configure camera " + Camera2CameraImpl.this.mCameraInfoInternal.getCameraId() + " due to " + th.getMessage());
                } else if (th instanceof CancellationException) {
                    Log.d(Camera2CameraImpl.TAG, "Unable to configure camera " + Camera2CameraImpl.this.mCameraInfoInternal.getCameraId() + " cancelled");
                } else if (th instanceof DeferrableSurface.SurfaceClosedException) {
                    UseCase findUseCaseForSurface = Camera2CameraImpl.this.findUseCaseForSurface(((DeferrableSurface.SurfaceClosedException) th).getDeferrableSurface());
                    if (findUseCaseForSurface != null) {
                        Camera2CameraImpl.this.postSurfaceClosedError(findUseCaseForSurface);
                    }
                } else if (th instanceof TimeoutException) {
                    Log.e(Camera2CameraImpl.TAG, "Unable to configure camera " + Camera2CameraImpl.this.mCameraInfoInternal.getCameraId() + ", timeout!");
                } else {
                    throw new RuntimeException(th);
                }
            }
        }, this.mExecutor);
    }

    /* access modifiers changed from: package-private */
    public void closeStaleCaptureSessions(CaptureSession captureSession) {
        if (Build.VERSION.SDK_INT < 23) {
            int i = 0;
            CaptureSession[] captureSessionArr = (CaptureSession[]) this.mReleasedCaptureSessions.keySet().toArray(new CaptureSession[0]);
            int length = captureSessionArr.length;
            while (i < length) {
                CaptureSession captureSession2 = captureSessionArr[i];
                if (captureSession != captureSession2) {
                    captureSession2.forceClose();
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public UseCase findUseCaseForSurface(DeferrableSurface deferrableSurface) {
        for (UseCase next : this.mUseCaseAttachState.getOnlineUseCases()) {
            if (next.getSessionConfig(this.mCameraInfoInternal.getCameraId()).getSurfaces().contains(deferrableSurface)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void postSurfaceClosedError(UseCase useCase) {
        ScheduledExecutorService mainThreadExecutor = CameraXExecutors.mainThreadExecutor();
        SessionConfig sessionConfig = useCase.getSessionConfig(this.mCameraInfoInternal.getCameraId());
        List<SessionConfig.ErrorListener> errorListeners = sessionConfig.getErrorListeners();
        if (!errorListeners.isEmpty()) {
            Log.d(TAG, "Posting surface closed", new Throwable());
            mainThreadExecutor.execute(new Runnable(sessionConfig) {
                /* class androidx.camera.camera2.internal.$$Lambda$Camera2CameraImpl$3_Ci3Ca1SfnAk2LfH6SIwQMfLYo */
                private final /* synthetic */ SessionConfig f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SessionConfig.ErrorListener.this.onError(this.f$1, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void resetCaptureSession(boolean z) {
        Preconditions.checkState(this.mCaptureSession != null);
        Log.d(TAG, "Resetting Capture Session");
        CaptureSession captureSession = this.mCaptureSession;
        SessionConfig sessionConfig = captureSession.getSessionConfig();
        List<CaptureConfig> captureConfigs = captureSession.getCaptureConfigs();
        CaptureSession build = this.mCaptureSessionBuilder.build();
        this.mCaptureSession = build;
        build.setSessionConfig(sessionConfig);
        this.mCaptureSession.issueCaptureRequests(captureConfigs);
        releaseSession(captureSession, z);
    }

    private CameraDevice.StateCallback createDeviceStateCallback() {
        ArrayList arrayList = new ArrayList(this.mUseCaseAttachState.getOnlineBuilder().build().getDeviceStateCallbacks());
        arrayList.add(this.mStateCallback);
        return CameraDeviceStateCallbacks.createComboCallback(arrayList);
    }

    private boolean checkAndAttachRepeatingSurface(CaptureConfig.Builder builder) {
        if (!builder.getSurfaces().isEmpty()) {
            Log.w(TAG, "The capture config builder already has surface inside.");
            return false;
        }
        for (UseCase sessionConfig : this.mUseCaseAttachState.getActiveAndOnlineUseCases()) {
            List<DeferrableSurface> surfaces = sessionConfig.getSessionConfig(this.mCameraInfoInternal.getCameraId()).getRepeatingCaptureConfig().getSurfaces();
            if (!surfaces.isEmpty()) {
                for (DeferrableSurface addSurface : surfaces) {
                    builder.addSurface(addSurface);
                }
            }
        }
        if (!builder.getSurfaces().isEmpty()) {
            return true;
        }
        Log.w(TAG, "Unable to find a repeating surface to attach to CaptureConfig");
        return false;
    }

    public CameraControlInternal getCameraControlInternal() {
        return this.mCameraControlInternal;
    }

    /* access modifiers changed from: package-private */
    public void submitCaptureRequests(List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureConfig next : list) {
            CaptureConfig.Builder from = CaptureConfig.Builder.from(next);
            if (!next.getSurfaces().isEmpty() || !next.isUseRepeatingSurface() || checkAndAttachRepeatingSurface(from)) {
                arrayList.add(from.build());
            }
        }
        Log.d(TAG, "issue capture request for camera " + this.mCameraInfoInternal.getCameraId());
        this.mCaptureSession.issueCaptureRequests(arrayList);
    }

    public String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", Integer.valueOf(hashCode()), this.mCameraInfoInternal.getCameraId());
    }

    public CameraControl getCameraControl() {
        return getCameraControlInternal();
    }

    public CameraInfo getCameraInfo() {
        return getCameraInfoInternal();
    }

    /* access modifiers changed from: package-private */
    public void setState(InternalState internalState) {
        Log.d(TAG, "Transitioning camera internal state: " + this.mState + " --> " + internalState);
        this.mState = internalState;
        switch (AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[internalState.ordinal()]) {
            case 1:
                this.mObservableState.postValue(CameraInternal.State.CLOSED);
                return;
            case 2:
                this.mObservableState.postValue(CameraInternal.State.CLOSING);
                return;
            case 3:
                this.mObservableState.postValue(CameraInternal.State.OPEN);
                return;
            case 4:
            case 5:
                this.mObservableState.postValue(CameraInternal.State.OPENING);
                return;
            case 6:
                this.mObservableState.postValue(CameraInternal.State.PENDING_OPEN);
                return;
            case 7:
                this.mObservableState.postValue(CameraInternal.State.RELEASING);
                return;
            case 8:
                this.mObservableState.postValue(CameraInternal.State.RELEASED);
                return;
            default:
                return;
        }
    }

    final class StateCallback extends CameraDevice.StateCallback {
        StateCallback() {
        }

        public void onOpened(CameraDevice cameraDevice) {
            Log.d(Camera2CameraImpl.TAG, "CameraDevice.onOpened(): " + cameraDevice.getId());
            Camera2CameraImpl.this.mCameraDevice = cameraDevice;
            Camera2CameraImpl.this.updateDefaultRequestBuilderToCameraControl(cameraDevice);
            Camera2CameraImpl.this.mCameraDeviceError = 0;
            int i = AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[Camera2CameraImpl.this.mState.ordinal()];
            if (i == 2 || i == 7) {
                Preconditions.checkState(Camera2CameraImpl.this.isSessionCloseComplete());
                Camera2CameraImpl.this.mCameraDevice.close();
                Camera2CameraImpl.this.mCameraDevice = null;
            } else if (i == 4 || i == 5) {
                Camera2CameraImpl.this.setState(InternalState.OPENED);
                Camera2CameraImpl.this.openCaptureSession();
            } else {
                throw new IllegalStateException("onOpened() should not be possible from state: " + Camera2CameraImpl.this.mState);
            }
        }

        public void onClosed(CameraDevice cameraDevice) {
            Log.d(Camera2CameraImpl.TAG, "CameraDevice.onClosed(): " + cameraDevice.getId());
            boolean z = Camera2CameraImpl.this.mCameraDevice == null;
            Preconditions.checkState(z, "Unexpected onClose callback on camera device: " + cameraDevice);
            int i = AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[Camera2CameraImpl.this.mState.ordinal()];
            if (i != 2) {
                if (i == 5) {
                    Camera2CameraImpl.this.openCameraDevice();
                    return;
                } else if (i != 7) {
                    throw new IllegalStateException("Camera closed while in state: " + Camera2CameraImpl.this.mState);
                }
            }
            Preconditions.checkState(Camera2CameraImpl.this.isSessionCloseComplete());
            Camera2CameraImpl.this.finishClose();
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            Log.d(Camera2CameraImpl.TAG, "CameraDevice.onDisconnected(): " + cameraDevice.getId());
            for (CaptureSession forceClose : Camera2CameraImpl.this.mReleasedCaptureSessions.keySet()) {
                forceClose.forceClose();
            }
            Camera2CameraImpl.this.mCaptureSession.forceClose();
            onError(cameraDevice, 1);
        }

        public void onError(CameraDevice cameraDevice, int i) {
            Camera2CameraImpl.this.mCameraDevice = cameraDevice;
            Camera2CameraImpl.this.mCameraDeviceError = i;
            int i2 = AnonymousClass4.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[Camera2CameraImpl.this.mState.ordinal()];
            if (i2 != 2) {
                if (i2 == 3 || i2 == 4 || i2 == 5) {
                    handleErrorOnOpen(cameraDevice, i);
                    return;
                } else if (i2 != 7) {
                    throw new IllegalStateException("onError() should not be possible from state: " + Camera2CameraImpl.this.mState);
                }
            }
            Log.e(Camera2CameraImpl.TAG, "CameraDevice.onError(): " + cameraDevice.getId() + " with error: " + Camera2CameraImpl.getErrorMessage(i));
            Camera2CameraImpl.this.closeCamera(false);
        }

        private void handleErrorOnOpen(CameraDevice cameraDevice, int i) {
            boolean z = Camera2CameraImpl.this.mState == InternalState.OPENING || Camera2CameraImpl.this.mState == InternalState.OPENED || Camera2CameraImpl.this.mState == InternalState.REOPENING;
            Preconditions.checkState(z, "Attempt to handle open error from non open state: " + Camera2CameraImpl.this.mState);
            if (i == 1 || i == 2 || i == 4) {
                reopenCameraAfterError();
                return;
            }
            Log.e(Camera2CameraImpl.TAG, "Error observed on open (or opening) camera device " + cameraDevice.getId() + ": " + Camera2CameraImpl.getErrorMessage(i));
            Camera2CameraImpl.this.setState(InternalState.CLOSING);
            Camera2CameraImpl.this.closeCamera(false);
        }

        private void reopenCameraAfterError() {
            Preconditions.checkState(Camera2CameraImpl.this.mCameraDeviceError != 0, "Can only reopen camera device after error if the camera device is actually in an error state.");
            Camera2CameraImpl.this.setState(InternalState.REOPENING);
            Camera2CameraImpl.this.closeCamera(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateDefaultRequestBuilderToCameraControl(CameraDevice cameraDevice) {
        try {
            this.mCameraControlInternal.setDefaultRequestBuilder(cameraDevice.createCaptureRequest(this.mCameraControlInternal.getDefaultTemplate()));
        } catch (CameraAccessException e) {
            Log.e(TAG, "fail to create capture request.", e);
        }
    }

    final class CameraAvailability extends CameraManager.AvailabilityCallback implements Observable.Observer<Integer> {
        private boolean mCameraAvailable = true;
        private final String mCameraId;
        private int mNumAvailableCameras = 0;

        public void onError(Throwable th) {
        }

        CameraAvailability(String str) {
            this.mCameraId = str;
        }

        public void onCameraAvailable(String str) {
            if (this.mCameraId.equals(str)) {
                this.mCameraAvailable = true;
                if (Camera2CameraImpl.this.mState == InternalState.PENDING_OPEN) {
                    Camera2CameraImpl.this.openCameraDevice();
                }
            }
        }

        public void onCameraUnavailable(String str) {
            if (this.mCameraId.equals(str)) {
                this.mCameraAvailable = false;
            }
        }

        public void onNewData(Integer num) {
            Preconditions.checkNotNull(num);
            if (num.intValue() != this.mNumAvailableCameras) {
                this.mNumAvailableCameras = num.intValue();
                if (Camera2CameraImpl.this.mState == InternalState.PENDING_OPEN) {
                    Camera2CameraImpl.this.openCameraDevice();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isCameraAvailable() {
            return this.mCameraAvailable && this.mNumAvailableCameras > 0;
        }
    }

    final class ControlUpdateListenerInternal implements CameraControlInternal.ControlUpdateCallback {
        ControlUpdateListenerInternal() {
        }

        public void onCameraControlUpdateSessionConfig(SessionConfig sessionConfig) {
            Camera2CameraImpl.this.mCameraControlSessionConfig = (SessionConfig) Preconditions.checkNotNull(sessionConfig);
            Camera2CameraImpl.this.updateCaptureSessionConfig();
        }

        public void onCameraControlCaptureRequests(List<CaptureConfig> list) {
            Camera2CameraImpl.this.submitCaptureRequests((List) Preconditions.checkNotNull(list));
        }
    }
}
