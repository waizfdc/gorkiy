package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.CameraEventCallbacks;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

final class CaptureSession {
    private static final String TAG = "CaptureSession";
    private static final long TIMEOUT_GET_SURFACE_IN_MS = 5000;
    CameraCaptureSession mCameraCaptureSession;
    volatile Config mCameraEventOnRepeatingOptions;
    private final CameraCaptureSession.CaptureCallback mCaptureCallback;
    private final List<CaptureConfig> mCaptureConfigs;
    private final StateCallback mCaptureSessionStateCallback;
    List<DeferrableSurface> mConfiguredDeferrableSurfaces;
    private Map<DeferrableSurface, Surface> mConfiguredSurfaceMap;
    private final Executor mExecutor;
    private final boolean mIsLegacyDevice;
    CallbackToFutureAdapter.Completer<Void> mOpenCaptureSessionCompleter;
    ListenableFuture<Void> mOpenFuture;
    CallbackToFutureAdapter.Completer<Void> mReleaseCompleter;
    ListenableFuture<Void> mReleaseFuture;
    private final ScheduledExecutorService mScheduleExecutor;
    volatile SessionConfig mSessionConfig;
    State mState;
    final Object mStateLock;

    enum State {
        UNINITIALIZED,
        INITIALIZED,
        GET_SURFACE,
        OPENING,
        OPENED,
        CLOSED,
        RELEASING,
        RELEASED
    }

    CaptureSession(Executor executor, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this.mStateLock = new Object();
        this.mCaptureConfigs = new ArrayList();
        this.mCaptureCallback = new CameraCaptureSession.CaptureCallback() {
            /* class androidx.camera.camera2.internal.CaptureSession.AnonymousClass1 */

            public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            }
        };
        this.mCaptureSessionStateCallback = new StateCallback();
        this.mConfiguredSurfaceMap = new HashMap();
        this.mConfiguredDeferrableSurfaces = Collections.emptyList();
        this.mState = State.UNINITIALIZED;
        this.mState = State.INITIALIZED;
        this.mExecutor = executor;
        this.mScheduleExecutor = scheduledExecutorService;
        this.mIsLegacyDevice = z;
    }

    /* access modifiers changed from: package-private */
    public SessionConfig getSessionConfig() {
        SessionConfig sessionConfig;
        synchronized (this.mStateLock) {
            sessionConfig = this.mSessionConfig;
        }
        return sessionConfig;
    }

    /* renamed from: androidx.camera.camera2.internal.CaptureSession$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;

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
                androidx.camera.camera2.internal.CaptureSession$State[] r0 = androidx.camera.camera2.internal.CaptureSession.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State = r0
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.UNINITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.GET_SURFACE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.OPENING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.OPENED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.CLOSED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.RELEASING     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSessionConfig(androidx.camera.core.impl.SessionConfig r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mStateLock
            monitor-enter(r0)
            int[] r1 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ all -> 0x005d }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch:{ all -> 0x005d }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x005d }
            r1 = r1[r2]     // Catch:{ all -> 0x005d }
            switch(r1) {
                case 1: goto L_0x0042;
                case 2: goto L_0x003f;
                case 3: goto L_0x003f;
                case 4: goto L_0x003f;
                case 5: goto L_0x0019;
                case 6: goto L_0x0011;
                case 7: goto L_0x0011;
                case 8: goto L_0x0011;
                default: goto L_0x0010;
            }     // Catch:{ all -> 0x005d }
        L_0x0010:
            goto L_0x005b
        L_0x0011:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005d }
            java.lang.String r1 = "Session configuration cannot be set on a closed/released session."
            r4.<init>(r1)     // Catch:{ all -> 0x005d }
            throw r4     // Catch:{ all -> 0x005d }
        L_0x0019:
            r3.mSessionConfig = r4     // Catch:{ all -> 0x005d }
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, android.view.Surface> r1 = r3.mConfiguredSurfaceMap     // Catch:{ all -> 0x005d }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x005d }
            java.util.List r4 = r4.getSurfaces()     // Catch:{ all -> 0x005d }
            boolean r4 = r1.containsAll(r4)     // Catch:{ all -> 0x005d }
            if (r4 != 0) goto L_0x0034
            java.lang.String r4 = "CaptureSession"
            java.lang.String r1 = "Does not have the proper configured lists"
            android.util.Log.e(r4, r1)     // Catch:{ all -> 0x005d }
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return
        L_0x0034:
            java.lang.String r4 = "CaptureSession"
            java.lang.String r1 = "Attempting to submit CaptureRequest after setting"
            android.util.Log.d(r4, r1)     // Catch:{ all -> 0x005d }
            r3.issueRepeatingCaptureRequests()     // Catch:{ all -> 0x005d }
            goto L_0x005b
        L_0x003f:
            r3.mSessionConfig = r4     // Catch:{ all -> 0x005d }
            goto L_0x005b
        L_0x0042:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r1.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r2 = "setSessionConfig() should not be possible in state: "
            r1.append(r2)     // Catch:{ all -> 0x005d }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch:{ all -> 0x005d }
            r1.append(r2)     // Catch:{ all -> 0x005d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x005d }
            r4.<init>(r1)     // Catch:{ all -> 0x005d }
            throw r4     // Catch:{ all -> 0x005d }
        L_0x005b:
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return
        L_0x005d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.setSessionConfig(androidx.camera.core.impl.SessionConfig):void");
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> open(SessionConfig sessionConfig, CameraDevice cameraDevice) {
        synchronized (this.mStateLock) {
            if (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()] != 2) {
                Log.e(TAG, "Open not allowed in state: " + this.mState);
                return Futures.immediateFailedFuture(new IllegalStateException("open() should not allow the state: " + this.mState));
            }
            this.mState = State.GET_SURFACE;
            ArrayList arrayList = new ArrayList(sessionConfig.getSurfaces());
            this.mConfiguredDeferrableSurfaces = arrayList;
            FutureChain transformAsync = FutureChain.from(DeferrableSurfaces.surfaceListWithTimeout(arrayList, false, TIMEOUT_GET_SURFACE_IN_MS, this.mExecutor, this.mScheduleExecutor)).transformAsync(new AsyncFunction(sessionConfig, cameraDevice) {
                /* class androidx.camera.camera2.internal.$$Lambda$CaptureSession$2IbSQd39wMeo2dJgmFG1rvePLoM */
                private final /* synthetic */ SessionConfig f$1;
                private final /* synthetic */ CameraDevice f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final ListenableFuture apply(Object obj) {
                    return CaptureSession.this.lambda$open$0$CaptureSession(this.f$1, this.f$2, (List) obj);
                }
            }, this.mExecutor);
            this.mOpenFuture = transformAsync;
            transformAsync.addListener(new Runnable() {
                /* class androidx.camera.camera2.internal.$$Lambda$CaptureSession$sXRVbG2Da097UMmXwOO3AjgT5k */

                public final void run() {
                    CaptureSession.this.lambda$open$1$CaptureSession();
                }
            }, this.mExecutor);
            ListenableFuture<Void> nonCancellationPropagating = Futures.nonCancellationPropagating(this.mOpenFuture);
            return nonCancellationPropagating;
        }
    }

    public /* synthetic */ void lambda$open$1$CaptureSession() {
        synchronized (this.mStateLock) {
            this.mOpenFuture = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: openCaptureSession */
    public ListenableFuture<Void> lambda$open$0$CaptureSession(List<Surface> list, SessionConfig sessionConfig, CameraDevice cameraDevice) {
        synchronized (this.mStateLock) {
            int i = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()];
            if (!(i == 1 || i == 2)) {
                if (i == 3) {
                    ListenableFuture<Void> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(list, sessionConfig, cameraDevice) {
                        /* class androidx.camera.camera2.internal.$$Lambda$CaptureSession$bwwGuGuBhJxfgB4Br9Wswwme0U */
                        private final /* synthetic */ List f$1;
                        private final /* synthetic */ SessionConfig f$2;
                        private final /* synthetic */ CameraDevice f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                            return CaptureSession.this.lambda$openCaptureSession$2$CaptureSession(this.f$1, this.f$2, this.f$3, completer);
                        }
                    });
                    return future;
                } else if (i != 5) {
                    ListenableFuture<Void> immediateFailedFuture = Futures.immediateFailedFuture(new CancellationException("openCaptureSession() not execute in state: " + this.mState));
                    return immediateFailedFuture;
                }
            }
            ListenableFuture<Void> immediateFailedFuture2 = Futures.immediateFailedFuture(new IllegalStateException("openCaptureSession() should not be possible in state: " + this.mState));
            return immediateFailedFuture2;
        }
    }

    public /* synthetic */ Object lambda$openCaptureSession$2$CaptureSession(List list, SessionConfig sessionConfig, CameraDevice cameraDevice, CallbackToFutureAdapter.Completer completer) throws Exception {
        Preconditions.checkState(Thread.holdsLock(this.mStateLock));
        if (list.contains(null)) {
            int indexOf = list.indexOf(null);
            Log.d(TAG, "Some surfaces were closed.");
            this.mConfiguredDeferrableSurfaces.clear();
            completer.setException(new DeferrableSurface.SurfaceClosedException("Surface closed", this.mConfiguredDeferrableSurfaces.get(indexOf)));
            return "openCaptureSession-cancelled[session=" + this + "]";
        } else if (list.isEmpty()) {
            completer.setException(new IllegalArgumentException("Unable to open capture session with no surfaces."));
            return "openCaptureSession-cancelled[session=" + this + "]";
        } else {
            try {
                DeferrableSurfaces.incrementAll(this.mConfiguredDeferrableSurfaces);
                this.mConfiguredSurfaceMap.clear();
                for (int i = 0; i < list.size(); i++) {
                    this.mConfiguredSurfaceMap.put(this.mConfiguredDeferrableSurfaces.get(i), list.get(i));
                }
                ArrayList<Surface> arrayList = new ArrayList<>(new HashSet(list));
                Preconditions.checkState(this.mOpenCaptureSessionCompleter == null, "The openCaptureSessionCompleter can only set once!");
                this.mState = State.OPENING;
                Log.d(TAG, "Opening capture session.");
                ArrayList arrayList2 = new ArrayList(sessionConfig.getSessionStateCallbacks());
                arrayList2.add(this.mCaptureSessionStateCallback);
                CameraCaptureSession.StateCallback createComboCallback = CameraCaptureSessionStateCallbacks.createComboCallback(arrayList2);
                List<CaptureConfig> onPresetSession = new Camera2ImplConfig(sessionConfig.getImplementationOptions()).getCameraEventCallback(CameraEventCallbacks.createEmptyCallback()).createComboCallback().onPresetSession();
                CaptureConfig.Builder from = CaptureConfig.Builder.from(sessionConfig.getRepeatingCaptureConfig());
                for (CaptureConfig implementationOptions : onPresetSession) {
                    from.addImplementationOptions(implementationOptions.getImplementationOptions());
                }
                LinkedList linkedList = new LinkedList();
                for (Surface outputConfigurationCompat : arrayList) {
                    linkedList.add(new OutputConfigurationCompat(outputConfigurationCompat));
                }
                SessionConfigurationCompat sessionConfigurationCompat = new SessionConfigurationCompat(0, linkedList, getExecutor(), createComboCallback);
                CaptureRequest buildWithoutTarget = Camera2CaptureRequestBuilder.buildWithoutTarget(from.build(), cameraDevice);
                if (buildWithoutTarget != null) {
                    sessionConfigurationCompat.setSessionParameters(buildWithoutTarget);
                }
                this.mOpenCaptureSessionCompleter = completer;
                CameraDeviceCompat.createCaptureSession(cameraDevice, sessionConfigurationCompat);
                return "openCaptureSession[session=" + this + "]";
            } catch (DeferrableSurface.SurfaceClosedException e) {
                this.mConfiguredDeferrableSurfaces.clear();
                completer.setException(e);
                return "openCaptureSession-cancelled[session=" + this + "]";
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void close() {
        synchronized (this.mStateLock) {
            int i = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                if (this.mSessionConfig != null) {
                                    List<CaptureConfig> onDisableSession = new Camera2ImplConfig(this.mSessionConfig.getImplementationOptions()).getCameraEventCallback(CameraEventCallbacks.createEmptyCallback()).createComboCallback().onDisableSession();
                                    if (!onDisableSession.isEmpty()) {
                                        try {
                                            issueCaptureRequests(setupConfiguredSurface(onDisableSession));
                                        } catch (IllegalStateException e) {
                                            Log.e(TAG, "Unable to issue the request before close the capture session", e);
                                        }
                                    }
                                }
                            }
                        }
                        this.mState = State.CLOSED;
                        this.mSessionConfig = null;
                        this.mCameraEventOnRepeatingOptions = null;
                        closeConfiguredDeferrableSurfaces();
                    } else if (this.mOpenFuture != null) {
                        this.mOpenFuture.cancel(true);
                    }
                }
                this.mState = State.RELEASED;
            } else {
                throw new IllegalStateException("close() should not be possible in state: " + this.mState);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006f, code lost:
        return androidx.camera.core.impl.utils.futures.Futures.immediateFuture(null);
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032 A[Catch:{ CameraAccessException -> 0x001d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.util.concurrent.ListenableFuture<java.lang.Void> release(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mStateLock
            monitor-enter(r0)
            int[] r1 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch:{ all -> 0x0070 }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch:{ all -> 0x0070 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0070 }
            r1 = r1[r2]     // Catch:{ all -> 0x0070 }
            switch(r1) {
                case 1: goto L_0x0050;
                case 2: goto L_0x004b;
                case 3: goto L_0x0041;
                case 4: goto L_0x002a;
                case 5: goto L_0x0011;
                case 6: goto L_0x0011;
                case 7: goto L_0x002e;
                default: goto L_0x0010;
            }     // Catch:{ all -> 0x0070 }
        L_0x0010:
            goto L_0x0069
        L_0x0011:
            android.hardware.camera2.CameraCaptureSession r1 = r3.mCameraCaptureSession     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x002a
            if (r4 == 0) goto L_0x0025
            android.hardware.camera2.CameraCaptureSession r4 = r3.mCameraCaptureSession     // Catch:{ CameraAccessException -> 0x001d }
            r4.abortCaptures()     // Catch:{ CameraAccessException -> 0x001d }
            goto L_0x0025
        L_0x001d:
            r4 = move-exception
            java.lang.String r1 = "CaptureSession"
            java.lang.String r2 = "Unable to abort captures."
            android.util.Log.e(r1, r2, r4)     // Catch:{ all -> 0x0070 }
        L_0x0025:
            android.hardware.camera2.CameraCaptureSession r4 = r3.mCameraCaptureSession     // Catch:{ all -> 0x0070 }
            r4.close()     // Catch:{ all -> 0x0070 }
        L_0x002a:
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASING     // Catch:{ all -> 0x0070 }
            r3.mState = r4     // Catch:{ all -> 0x0070 }
        L_0x002e:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r4 = r3.mReleaseFuture     // Catch:{ all -> 0x0070 }
            if (r4 != 0) goto L_0x003d
            androidx.camera.camera2.internal.CaptureSession$2 r4 = new androidx.camera.camera2.internal.CaptureSession$2     // Catch:{ all -> 0x0070 }
            r4.<init>()     // Catch:{ all -> 0x0070 }
            com.google.common.util.concurrent.ListenableFuture r4 = androidx.concurrent.futures.CallbackToFutureAdapter.getFuture(r4)     // Catch:{ all -> 0x0070 }
            r3.mReleaseFuture = r4     // Catch:{ all -> 0x0070 }
        L_0x003d:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r4 = r3.mReleaseFuture     // Catch:{ all -> 0x0070 }
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            return r4
        L_0x0041:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r4 = r3.mOpenFuture     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x004b
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r4 = r3.mOpenFuture     // Catch:{ all -> 0x0070 }
            r1 = 1
            r4.cancel(r1)     // Catch:{ all -> 0x0070 }
        L_0x004b:
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch:{ all -> 0x0070 }
            r3.mState = r4     // Catch:{ all -> 0x0070 }
            goto L_0x0069
        L_0x0050:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            r1.<init>()     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = "release() should not be possible in state: "
            r1.append(r2)     // Catch:{ all -> 0x0070 }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch:{ all -> 0x0070 }
            r1.append(r2)     // Catch:{ all -> 0x0070 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0070 }
            r4.<init>(r1)     // Catch:{ all -> 0x0070 }
            throw r4     // Catch:{ all -> 0x0070 }
        L_0x0069:
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            r4 = 0
            com.google.common.util.concurrent.ListenableFuture r4 = androidx.camera.core.impl.utils.futures.Futures.immediateFuture(r4)
            return r4
        L_0x0070:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.release(boolean):com.google.common.util.concurrent.ListenableFuture");
    }

    /* access modifiers changed from: package-private */
    public void forceClose() {
        this.mCaptureSessionStateCallback.onClosed(this.mCameraCaptureSession);
    }

    /* access modifiers changed from: package-private */
    public void clearConfiguredSurfaces() {
        DeferrableSurfaces.decrementAll(this.mConfiguredDeferrableSurfaces);
        this.mConfiguredDeferrableSurfaces.clear();
    }

    /* access modifiers changed from: package-private */
    public void issueCaptureRequests(List<CaptureConfig> list) {
        synchronized (this.mStateLock) {
            switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()]) {
                case 1:
                    throw new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.mState);
                case 2:
                case 3:
                case 4:
                    this.mCaptureConfigs.addAll(list);
                    break;
                case 5:
                    this.mCaptureConfigs.addAll(list);
                    issuePendingCaptureRequest();
                    break;
                case 6:
                case 7:
                case 8:
                    throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<CaptureConfig> getCaptureConfigs() {
        List<CaptureConfig> unmodifiableList;
        synchronized (this.mStateLock) {
            unmodifiableList = Collections.unmodifiableList(this.mCaptureConfigs);
        }
        return unmodifiableList;
    }

    /* access modifiers changed from: package-private */
    public State getState() {
        State state;
        synchronized (this.mStateLock) {
            state = this.mState;
        }
        return state;
    }

    /* access modifiers changed from: package-private */
    public void issueRepeatingCaptureRequests() {
        if (this.mSessionConfig == null) {
            Log.d(TAG, "Skipping issueRepeatingCaptureRequests for no configuration case.");
            return;
        }
        CaptureConfig repeatingCaptureConfig = this.mSessionConfig.getRepeatingCaptureConfig();
        try {
            Log.d(TAG, "Issuing request for session.");
            CaptureConfig.Builder from = CaptureConfig.Builder.from(repeatingCaptureConfig);
            this.mCameraEventOnRepeatingOptions = mergeOptions(new Camera2ImplConfig(this.mSessionConfig.getImplementationOptions()).getCameraEventCallback(CameraEventCallbacks.createEmptyCallback()).createComboCallback().onRepeating());
            if (this.mCameraEventOnRepeatingOptions != null) {
                from.addImplementationOptions(this.mCameraEventOnRepeatingOptions);
            }
            CaptureRequest build = Camera2CaptureRequestBuilder.build(from.build(), this.mCameraCaptureSession.getDevice(), this.mConfiguredSurfaceMap);
            if (build == null) {
                Log.d(TAG, "Skipping issuing empty request for session.");
                return;
            }
            CameraCaptureSessionCompat.setSingleRepeatingRequest(this.mCameraCaptureSession, build, this.mExecutor, createCamera2CaptureCallback(repeatingCaptureConfig.getCameraCaptureCallbacks(), this.mCaptureCallback));
        } catch (CameraAccessException e) {
            Log.e(TAG, "Unable to access camera: " + e.getMessage());
            Thread.dumpStack();
        }
    }

    /* access modifiers changed from: package-private */
    public void issuePendingCaptureRequest() {
        if (!this.mCaptureConfigs.isEmpty()) {
            try {
                issueBurstCaptureRequest(this.mCaptureConfigs);
            } finally {
                this.mCaptureConfigs.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void issueBurstCaptureRequest(List<CaptureConfig> list) {
        if (!list.isEmpty()) {
            try {
                CameraBurstCaptureCallback cameraBurstCaptureCallback = new CameraBurstCaptureCallback();
                ArrayList arrayList = new ArrayList();
                Log.d(TAG, "Issuing capture request.");
                for (CaptureConfig next : list) {
                    if (next.getSurfaces().isEmpty()) {
                        Log.d(TAG, "Skipping issuing empty capture request.");
                    } else {
                        boolean z = true;
                        Iterator<DeferrableSurface> it = next.getSurfaces().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            DeferrableSurface next2 = it.next();
                            if (!this.mConfiguredSurfaceMap.containsKey(next2)) {
                                Log.d(TAG, "Skipping capture request with invalid surface: " + next2);
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            CaptureConfig.Builder from = CaptureConfig.Builder.from(next);
                            if (this.mSessionConfig != null) {
                                from.addImplementationOptions(this.mSessionConfig.getRepeatingCaptureConfig().getImplementationOptions());
                            }
                            if (this.mCameraEventOnRepeatingOptions != null) {
                                from.addImplementationOptions(this.mCameraEventOnRepeatingOptions);
                            }
                            from.addImplementationOptions(next.getImplementationOptions());
                            CaptureRequest build = Camera2CaptureRequestBuilder.build(from.build(), this.mCameraCaptureSession.getDevice(), this.mConfiguredSurfaceMap);
                            if (build == null) {
                                Log.d(TAG, "Skipping issuing request without surface.");
                                return;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            for (CameraCaptureCallback captureCallback : next.getCameraCaptureCallbacks()) {
                                CaptureCallbackConverter.toCaptureCallback(captureCallback, arrayList2);
                            }
                            cameraBurstCaptureCallback.addCamera2Callbacks(build, arrayList2);
                            arrayList.add(build);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    CameraCaptureSessionCompat.captureBurstRequests(this.mCameraCaptureSession, arrayList, this.mExecutor, cameraBurstCaptureCallback);
                } else {
                    Log.d(TAG, "Skipping issuing burst request due to no valid request elements");
                }
            } catch (CameraAccessException e) {
                Log.e(TAG, "Unable to access camera: " + e.getMessage());
                Thread.dumpStack();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelIssuedCaptureRequests() {
        if (!this.mCaptureConfigs.isEmpty()) {
            for (CaptureConfig cameraCaptureCallbacks : this.mCaptureConfigs) {
                for (CameraCaptureCallback onCaptureCancelled : cameraCaptureCallbacks.getCameraCaptureCallbacks()) {
                    onCaptureCancelled.onCaptureCancelled();
                }
            }
            this.mCaptureConfigs.clear();
        }
    }

    private CameraCaptureSession.CaptureCallback createCamera2CaptureCallback(List<CameraCaptureCallback> list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        for (CameraCaptureCallback captureCallback : list) {
            arrayList.add(CaptureCallbackConverter.toCaptureCallback(captureCallback));
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return Camera2CaptureCallbacks.createComboCallback(arrayList);
    }

    private static Config mergeOptions(List<CaptureConfig> list) {
        MutableOptionsBundle create = MutableOptionsBundle.create();
        for (CaptureConfig implementationOptions : list) {
            Config implementationOptions2 = implementationOptions.getImplementationOptions();
            for (Config.Option next : implementationOptions2.listOptions()) {
                Object retrieveOption = implementationOptions2.retrieveOption(next, null);
                if (create.containsOption(next)) {
                    Object retrieveOption2 = create.retrieveOption(next, null);
                    if (!Objects.equals(retrieveOption2, retrieveOption)) {
                        Log.d(TAG, "Detect conflicting option " + next.getId() + " : " + retrieveOption + " != " + retrieveOption2);
                    }
                } else {
                    create.insertOption(next, retrieveOption);
                }
            }
        }
        return create;
    }

    final class StateCallback extends CameraCaptureSession.StateCallback {
        StateCallback() {
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            synchronized (CaptureSession.this.mStateLock) {
                Preconditions.checkNotNull(CaptureSession.this.mOpenCaptureSessionCompleter, "OpenCaptureSession completer should not null");
                CaptureSession.this.mOpenCaptureSessionCompleter.set(null);
                CaptureSession.this.mOpenCaptureSessionCompleter = null;
                switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 8:
                        throw new IllegalStateException("onConfigured() should not be possible in state: " + CaptureSession.this.mState);
                    case 4:
                        CaptureSession.this.mState = State.OPENED;
                        CaptureSession.this.mCameraCaptureSession = cameraCaptureSession;
                        if (CaptureSession.this.mSessionConfig != null) {
                            List<CaptureConfig> onEnableSession = new Camera2ImplConfig(CaptureSession.this.mSessionConfig.getImplementationOptions()).getCameraEventCallback(CameraEventCallbacks.createEmptyCallback()).createComboCallback().onEnableSession();
                            if (!onEnableSession.isEmpty()) {
                                CaptureSession.this.issueBurstCaptureRequest(CaptureSession.this.setupConfiguredSurface(onEnableSession));
                            }
                        }
                        Log.d(CaptureSession.TAG, "Attempting to send capture request onConfigured");
                        CaptureSession.this.issueRepeatingCaptureRequests();
                        CaptureSession.this.issuePendingCaptureRequest();
                        break;
                    case 6:
                        CaptureSession.this.mCameraCaptureSession = cameraCaptureSession;
                        break;
                    case 7:
                        cameraCaptureSession.close();
                        break;
                }
                Log.d(CaptureSession.TAG, "CameraCaptureSession.onConfigured() mState=" + CaptureSession.this.mState);
            }
        }

        public void onReady(CameraCaptureSession cameraCaptureSession) {
            synchronized (CaptureSession.this.mStateLock) {
                if (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()] != 1) {
                    Log.d(CaptureSession.TAG, "CameraCaptureSession.onReady() " + CaptureSession.this.mState);
                } else {
                    throw new IllegalStateException("onReady() should not be possible in state: " + CaptureSession.this.mState);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClosed(android.hardware.camera2.CameraCaptureSession r4) {
            /*
                r3 = this;
                androidx.camera.camera2.internal.CaptureSession r4 = androidx.camera.camera2.internal.CaptureSession.this
                java.lang.Object r4 = r4.mStateLock
                monitor-enter(r4)
                androidx.camera.camera2.internal.CaptureSession r0 = androidx.camera.camera2.internal.CaptureSession.this     // Catch:{ all -> 0x0061 }
                androidx.camera.camera2.internal.CaptureSession$State r0 = r0.mState     // Catch:{ all -> 0x0061 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.UNINITIALIZED     // Catch:{ all -> 0x0061 }
                if (r0 == r1) goto L_0x0046
                androidx.camera.camera2.internal.CaptureSession r0 = androidx.camera.camera2.internal.CaptureSession.this     // Catch:{ all -> 0x0061 }
                androidx.camera.camera2.internal.CaptureSession$State r0 = r0.mState     // Catch:{ all -> 0x0061 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch:{ all -> 0x0061 }
                if (r0 != r1) goto L_0x0017
                monitor-exit(r4)     // Catch:{ all -> 0x0061 }
                return
            L_0x0017:
                java.lang.String r0 = "CaptureSession"
                java.lang.String r1 = "CameraCaptureSession.onClosed()"
                android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0061 }
                androidx.camera.camera2.internal.CaptureSession r0 = androidx.camera.camera2.internal.CaptureSession.this     // Catch:{ all -> 0x0061 }
                r0.closeConfiguredDeferrableSurfaces()     // Catch:{ all -> 0x0061 }
                androidx.camera.camera2.internal.CaptureSession r0 = androidx.camera.camera2.internal.CaptureSession.this     // Catch:{ all -> 0x0061 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch:{ all -> 0x0061 }
                r0.mState = r1     // Catch:{ all -> 0x0061 }
                androidx.camera.camera2.internal.CaptureSession r0 = androidx.camera.camera2.internal.CaptureSession.this     // Catch:{ all -> 0x0061 }
                r1 = 0
                r0.mCameraCaptureSession = r1     // Catch:{ all -> 0x0061 }
                androidx.camera.camera2.internal.CaptureSession r0 = androidx.camera.camera2.internal.CaptureSession.this     // Catch:{ all -> 0x0061 }
                r0.clearConfiguredSurfaces()     // Catch:{ all -> 0x0061 }
                androidx.camera.camera2.internal.CaptureSession r0 = androidx.camera.camera2.internal.CaptureSession.this     // Catch:{ all -> 0x0061 }
                androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r0 = r0.mReleaseCompleter     // Catch:{ all -> 0x0061 }
                if (r0 == 0) goto L_0x0044
                androidx.camera.camera2.internal.CaptureSession r0 = androidx.camera.camera2.internal.CaptureSession.this     // Catch:{ all -> 0x0061 }
                androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r0 = r0.mReleaseCompleter     // Catch:{ all -> 0x0061 }
                r0.set(r1)     // Catch:{ all -> 0x0061 }
                androidx.camera.camera2.internal.CaptureSession r0 = androidx.camera.camera2.internal.CaptureSession.this     // Catch:{ all -> 0x0061 }
                r0.mReleaseCompleter = r1     // Catch:{ all -> 0x0061 }
            L_0x0044:
                monitor-exit(r4)     // Catch:{ all -> 0x0061 }
                return
            L_0x0046:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r1.<init>()     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = "onClosed() should not be possible in state: "
                r1.append(r2)     // Catch:{ all -> 0x0061 }
                androidx.camera.camera2.internal.CaptureSession r2 = androidx.camera.camera2.internal.CaptureSession.this     // Catch:{ all -> 0x0061 }
                androidx.camera.camera2.internal.CaptureSession$State r2 = r2.mState     // Catch:{ all -> 0x0061 }
                r1.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0061 }
                r0.<init>(r1)     // Catch:{ all -> 0x0061 }
                throw r0     // Catch:{ all -> 0x0061 }
            L_0x0061:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0061 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.StateCallback.onClosed(android.hardware.camera2.CameraCaptureSession):void");
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            synchronized (CaptureSession.this.mStateLock) {
                Preconditions.checkNotNull(CaptureSession.this.mOpenCaptureSessionCompleter, "OpenCaptureSession completer should not null");
                CaptureSession.this.mOpenCaptureSessionCompleter.setException(new CancellationException("onConfigureFailed"));
                CaptureSession.this.mOpenCaptureSessionCompleter = null;
                switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 8:
                        throw new IllegalStateException("onConfiguredFailed() should not be possible in state: " + CaptureSession.this.mState);
                    case 4:
                    case 6:
                        CaptureSession.this.mState = State.RELEASED;
                        CaptureSession.this.mCameraCaptureSession = null;
                        break;
                    case 7:
                        CaptureSession.this.mState = State.RELEASING;
                        cameraCaptureSession.close();
                        break;
                }
                Log.e(CaptureSession.TAG, "CameraCaptureSession.onConfiguredFailed() " + CaptureSession.this.mState);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void closeConfiguredDeferrableSurfaces() {
        if (this.mIsLegacyDevice || Build.VERSION.SDK_INT <= 23) {
            for (DeferrableSurface close : this.mConfiguredDeferrableSurfaces) {
                close.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<CaptureConfig> setupConfiguredSurface(List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureConfig from : list) {
            CaptureConfig.Builder from2 = CaptureConfig.Builder.from(from);
            from2.setTemplateType(1);
            for (DeferrableSurface addSurface : this.mSessionConfig.getRepeatingCaptureConfig().getSurfaces()) {
                from2.addSurface(addSurface);
            }
            arrayList.add(from2.build());
        }
        return arrayList;
    }

    private Executor getExecutor() {
        return this.mExecutor;
    }

    static final class Builder {
        private Executor mExecutor;
        private ScheduledExecutorService mScheduledExecutorService;
        private int mSupportedHardwareLevel = -1;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public CaptureSession build() {
            Executor executor = this.mExecutor;
            if (executor != null) {
                ScheduledExecutorService scheduledExecutorService = this.mScheduledExecutorService;
                if (scheduledExecutorService != null) {
                    return new CaptureSession(executor, scheduledExecutorService, this.mSupportedHardwareLevel == 2);
                }
                throw new IllegalStateException("Missing ScheduledExecutorService. ScheduledExecutorService must be set with setScheduledExecutorService()");
            }
            throw new IllegalStateException("Missing camera executor. Executor must be set with setExecutor()");
        }

        /* access modifiers changed from: package-private */
        public void setExecutor(Executor executor) {
            this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        }

        /* access modifiers changed from: package-private */
        public void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
            this.mScheduledExecutorService = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
        }

        /* access modifiers changed from: package-private */
        public void setSupportedHardwareLevel(int i) {
            this.mSupportedHardwareLevel = i;
        }
    }
}
