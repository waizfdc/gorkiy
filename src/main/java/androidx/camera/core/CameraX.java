package androidx.camera.core;

import android.content.Context;
import android.util.Log;
import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCaseGroupRepository;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraIdFilter;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.UseCaseGroup;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class CameraX {
    private static final String TAG = "CameraX";
    private static final long WAIT_INITIALIZED_TIMEOUT = 3;
    private static ListenableFuture<Void> sInitializeFuture = Futures.immediateFailedFuture(new IllegalStateException("CameraX is not initialized."));
    static final Object sInitializeLock = new Object();
    static CameraX sInstance = null;
    private static ListenableFuture<Void> sShutdownFuture = Futures.immediateFuture(null);
    private static boolean sTargetInitialized = false;
    private final Executor mCameraExecutor;
    private CameraFactory mCameraFactory;
    final CameraRepository mCameraRepository = new CameraRepository();
    private Context mContext;
    private UseCaseConfigFactory mDefaultConfigFactory;
    private InternalInitState mInitState = InternalInitState.UNINITIALIZED;
    private final Object mInitializeLock = new Object();
    private ListenableFuture<Void> mShutdownInternalFuture = Futures.immediateFuture(null);
    private CameraDeviceSurfaceManager mSurfaceManager;
    private final UseCaseGroupRepository mUseCaseGroupRepository = new UseCaseGroupRepository();

    private enum InternalInitState {
        UNINITIALIZED,
        INITIALIZING,
        INITIALIZED,
        SHUTDOWN
    }

    static /* synthetic */ CameraX lambda$getInstanceLocked$4(CameraX cameraX, Void voidR) {
        return cameraX;
    }

    CameraX(Executor executor) {
        Preconditions.checkNotNull(executor);
        this.mCameraExecutor = executor;
    }

    public static Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase... useCaseArr) {
        Threads.checkMainThread();
        CameraX checkInitialized = checkInitialized();
        UseCaseGroupLifecycleController orCreateUseCaseGroup = checkInitialized.getOrCreateUseCaseGroup(lifecycleOwner);
        UseCaseGroup useCaseGroup = orCreateUseCaseGroup.getUseCaseGroup();
        Collection<UseCaseGroupLifecycleController> useCaseGroups = checkInitialized.mUseCaseGroupRepository.getUseCaseGroups();
        for (UseCase useCase : useCaseArr) {
            for (UseCaseGroupLifecycleController useCaseGroup2 : useCaseGroups) {
                UseCaseGroup useCaseGroup3 = useCaseGroup2.getUseCaseGroup();
                if (useCaseGroup3.contains(useCase) && useCaseGroup3 != useCaseGroup) {
                    throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", useCase));
                }
            }
        }
        CameraSelector.Builder fromSelector = CameraSelector.Builder.fromSelector(cameraSelector);
        for (UseCase useCaseConfig : useCaseArr) {
            CameraSelector cameraSelector2 = useCaseConfig.getUseCaseConfig().getCameraSelector(null);
            if (cameraSelector2 != null) {
                Iterator<CameraIdFilter> it = cameraSelector2.getCameraFilterSet().iterator();
                while (it.hasNext()) {
                    fromSelector.appendFilter(it.next());
                }
            }
        }
        String cameraWithCameraSelector = getCameraWithCameraSelector(fromSelector.build());
        CameraInternal camera = checkInitialized.getCameraRepository().getCamera(cameraWithCameraSelector);
        for (UseCase onBind : useCaseArr) {
            onBind.onBind(camera);
        }
        calculateSuggestedResolutions(lifecycleOwner, cameraWithCameraSelector, useCaseArr);
        for (UseCase useCase2 : useCaseArr) {
            useCaseGroup.addUseCase(useCase2);
            for (String attach : useCase2.getAttachedCameraIds()) {
                attach(attach, useCase2);
            }
        }
        orCreateUseCaseGroup.notifyState();
        return camera;
    }

    public static boolean isBound(UseCase useCase) {
        for (UseCaseGroupLifecycleController useCaseGroup : checkInitialized().mUseCaseGroupRepository.getUseCaseGroups()) {
            if (useCaseGroup.getUseCaseGroup().contains(useCase)) {
                return true;
            }
        }
        return false;
    }

    public static void unbind(UseCase... useCaseArr) {
        Threads.checkMainThread();
        Collection<UseCaseGroupLifecycleController> useCaseGroups = checkInitialized().mUseCaseGroupRepository.getUseCaseGroups();
        HashMap hashMap = new HashMap();
        for (UseCase useCase : useCaseArr) {
            for (UseCaseGroupLifecycleController useCaseGroup : useCaseGroups) {
                if (useCaseGroup.getUseCaseGroup().removeUseCase(useCase)) {
                    for (String next : useCase.getAttachedCameraIds()) {
                        Object obj = (List) hashMap.get(next);
                        if (obj == null) {
                            obj = new ArrayList();
                            hashMap.put(next, obj);
                        }
                        obj.add(useCase);
                    }
                }
            }
        }
        for (String str : hashMap.keySet()) {
            detach(str, (List) hashMap.get(str));
        }
        for (UseCase clear : useCaseArr) {
            clear.clear();
        }
    }

    public static void unbindAll() {
        Threads.checkMainThread();
        Collection<UseCaseGroupLifecycleController> useCaseGroups = checkInitialized().mUseCaseGroupRepository.getUseCaseGroups();
        ArrayList arrayList = new ArrayList();
        for (UseCaseGroupLifecycleController useCaseGroup : useCaseGroups) {
            arrayList.addAll(useCaseGroup.getUseCaseGroup().getUseCases());
        }
        unbind((UseCase[]) arrayList.toArray(new UseCase[0]));
    }

    public static boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        checkInitialized();
        try {
            cameraSelector.select(getCameraFactory().getAvailableCameraIds());
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static String getCameraWithLensFacing(int i) throws CameraInfoUnavailableException {
        checkInitialized();
        return getCameraFactory().cameraIdForLensFacing(i);
    }

    public static String getCameraWithCameraSelector(CameraSelector cameraSelector) {
        checkInitialized();
        try {
            return cameraSelector.select(getCameraFactory().getAvailableCameraIds());
        } catch (CameraInfoUnavailableException unused) {
            return null;
        }
    }

    public static int getDefaultLensFacing() throws CameraInfoUnavailableException {
        Integer num;
        checkInitialized();
        Iterator it = Arrays.asList(1, 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                num = null;
                break;
            }
            num = (Integer) it.next();
            if (getCameraFactory().cameraIdForLensFacing(num.intValue()) != null) {
                break;
            }
        }
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("Unable to get default lens facing.");
    }

    public static CameraInfoInternal getCameraInfo(String str) {
        return checkInitialized().getCameraRepository().getCamera(str).getCameraInfoInternal();
    }

    public static CameraDeviceSurfaceManager getSurfaceManager() {
        return checkInitialized().getCameraDeviceSurfaceManager();
    }

    public static <C extends UseCaseConfig<?>> C getDefaultUseCaseConfig(Class<C> cls, CameraInfo cameraInfo) {
        return checkInitialized().getDefaultConfigFactory().getConfig(cls, cameraInfo);
    }

    public static ListenableFuture<Void> initialize(Context context, CameraXConfig cameraXConfig) {
        ListenableFuture<Void> initializeLocked;
        synchronized (sInitializeLock) {
            initializeLocked = initializeLocked(context, cameraXConfig);
        }
        return initializeLocked;
    }

    private static ListenableFuture<Void> initializeLocked(Context context, CameraXConfig cameraXConfig) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(cameraXConfig);
        Preconditions.checkState(!sTargetInitialized, "Must call CameraX.shutdown() first.");
        sTargetInitialized = true;
        Executor cameraExecutor = cameraXConfig.getCameraExecutor(null);
        if (cameraExecutor == null) {
            cameraExecutor = new CameraExecutor();
        }
        CameraX cameraX = new CameraX(cameraExecutor);
        sInstance = cameraX;
        ListenableFuture<Void> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(context, cameraXConfig) {
            /* class androidx.camera.core.$$Lambda$CameraX$FR7eKDFrmm030DhYj6aYstpPnQI */
            private final /* synthetic */ Context f$1;
            private final /* synthetic */ CameraXConfig f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return CameraX.lambda$initializeLocked$1(CameraX.this, this.f$1, this.f$2, completer);
            }
        });
        sInitializeFuture = future;
        return future;
    }

    static /* synthetic */ Object lambda$initializeLocked$1(final CameraX cameraX, Context context, CameraXConfig cameraXConfig, final CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (sInitializeLock) {
            Futures.addCallback(FutureChain.from(sShutdownFuture).transformAsync(new AsyncFunction(context, cameraXConfig) {
                /* class androidx.camera.core.$$Lambda$CameraX$aEHXdwKLnBG6WvOzgAvbL9bn4U8 */
                private final /* synthetic */ Context f$1;
                private final /* synthetic */ CameraXConfig f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final ListenableFuture apply(Object obj) {
                    return CameraX.this.initInternal(this.f$1, this.f$2);
                }
            }, CameraXExecutors.directExecutor()), new FutureCallback<Void>() {
                /* class androidx.camera.core.CameraX.AnonymousClass1 */

                public void onSuccess(Void voidR) {
                    completer.set(null);
                }

                public void onFailure(Throwable th) {
                    Log.w(CameraX.TAG, "CameraX initialize() failed", th);
                    synchronized (CameraX.sInitializeLock) {
                        if (CameraX.sInstance == cameraX) {
                            CameraX.shutdown();
                        }
                    }
                    completer.setException(th);
                }
            }, CameraXExecutors.directExecutor());
        }
        return "CameraX-initialize";
    }

    public static ListenableFuture<Void> shutdown() {
        ListenableFuture<Void> shutdownLocked;
        synchronized (sInitializeLock) {
            shutdownLocked = shutdownLocked();
        }
        return shutdownLocked;
    }

    private static ListenableFuture<Void> shutdownLocked() {
        if (!sTargetInitialized) {
            return sShutdownFuture;
        }
        sTargetInitialized = false;
        CameraX cameraX = sInstance;
        sInstance = null;
        ListenableFuture<Void> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() {
            /* class androidx.camera.core.$$Lambda$CameraX$41c4Yl7XOftWrniEb_aDSAzTLpg */

            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return CameraX.lambda$shutdownLocked$3(CameraX.this, completer);
            }
        });
        sShutdownFuture = future;
        return future;
    }

    static /* synthetic */ Object lambda$shutdownLocked$3(CameraX cameraX, CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (sInitializeLock) {
            sInitializeFuture.addListener(new Runnable(completer) {
                /* class androidx.camera.core.$$Lambda$CameraX$TPquHYHv57gEH6ZGHKF2obR59Ag */
                private final /* synthetic */ CallbackToFutureAdapter.Completer f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    Futures.propagate(CameraX.this.shutdownInternal(), this.f$1);
                }
            }, CameraXExecutors.directExecutor());
        }
        return "CameraX shutdown";
    }

    public static Context getContext() {
        return checkInitialized().mContext;
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (sInitializeLock) {
            z = sInstance != null && sInstance.isInitializedInternal();
        }
        return z;
    }

    public static Collection<UseCase> getActiveUseCases() {
        for (UseCaseGroupLifecycleController next : checkInitialized().mUseCaseGroupRepository.getUseCaseGroups()) {
            if (next.getUseCaseGroup().isActive()) {
                return next.getUseCaseGroup().getUseCases();
            }
        }
        return null;
    }

    public static CameraFactory getCameraFactory() {
        CameraFactory cameraFactory = checkInitialized().mCameraFactory;
        if (cameraFactory != null) {
            return cameraFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    private static CameraX checkInitialized() {
        CameraX waitInitialized = waitInitialized();
        Preconditions.checkState(waitInitialized.isInitializedInternal(), "Must call CameraX.initialize() first");
        return waitInitialized;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: android.app.Application} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: androidx.camera.core.CameraXConfig$Provider} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0017 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX> getOrCreateInstance(android.content.Context r5) {
        /*
            java.lang.String r0 = "Context must not be null."
            androidx.core.util.Preconditions.checkNotNull(r5, r0)
            java.lang.Object r0 = androidx.camera.core.CameraX.sInitializeLock
            monitor-enter(r0)
            com.google.common.util.concurrent.ListenableFuture r1 = getInstanceLocked()     // Catch:{ all -> 0x007e }
            boolean r2 = r1.isDone()     // Catch:{ all -> 0x007e }
            r3 = 0
            if (r2 == 0) goto L_0x0025
            r1.get()     // Catch:{ InterruptedException -> 0x001c, ExecutionException -> 0x0017 }
            goto L_0x0025
        L_0x0017:
            shutdownLocked()     // Catch:{ all -> 0x007e }
            r1 = r3
            goto L_0x0025
        L_0x001c:
            r5 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x007e }
            java.lang.String r2 = "Unexpected thread interrupt. Should not be possible since future is already complete."
            r1.<init>(r2, r5)     // Catch:{ all -> 0x007e }
            throw r1     // Catch:{ all -> 0x007e }
        L_0x0025:
            if (r1 != 0) goto L_0x007c
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ all -> 0x007e }
            android.app.Application r5 = (android.app.Application) r5     // Catch:{ all -> 0x007e }
            boolean r1 = r5 instanceof androidx.camera.core.CameraXConfig.Provider     // Catch:{ all -> 0x007e }
            if (r1 == 0) goto L_0x0035
            r3 = r5
            androidx.camera.core.CameraXConfig$Provider r3 = (androidx.camera.core.CameraXConfig.Provider) r3     // Catch:{ all -> 0x007e }
            goto L_0x0066
        L_0x0035:
            android.content.res.Resources r1 = r5.getResources()     // Catch:{ NotFoundException -> 0x005e, ClassNotFoundException -> 0x005c, InstantiationException -> 0x005a, InvocationTargetException -> 0x0058, NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0054 }
            int r2 = androidx.camera.core.R.string.androidx_camera_default_config_provider     // Catch:{ NotFoundException -> 0x005e, ClassNotFoundException -> 0x005c, InstantiationException -> 0x005a, InvocationTargetException -> 0x0058, NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0054 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ NotFoundException -> 0x005e, ClassNotFoundException -> 0x005c, InstantiationException -> 0x005a, InvocationTargetException -> 0x0058, NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0054 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ NotFoundException -> 0x005e, ClassNotFoundException -> 0x005c, InstantiationException -> 0x005a, InvocationTargetException -> 0x0058, NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0054 }
            r2 = 0
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ NotFoundException -> 0x005e, ClassNotFoundException -> 0x005c, InstantiationException -> 0x005a, InvocationTargetException -> 0x0058, NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0054 }
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r4)     // Catch:{ NotFoundException -> 0x005e, ClassNotFoundException -> 0x005c, InstantiationException -> 0x005a, InvocationTargetException -> 0x0058, NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0054 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ NotFoundException -> 0x005e, ClassNotFoundException -> 0x005c, InstantiationException -> 0x005a, InvocationTargetException -> 0x0058, NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0054 }
            java.lang.Object r1 = r1.newInstance(r2)     // Catch:{ NotFoundException -> 0x005e, ClassNotFoundException -> 0x005c, InstantiationException -> 0x005a, InvocationTargetException -> 0x0058, NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0054 }
            androidx.camera.core.CameraXConfig$Provider r1 = (androidx.camera.core.CameraXConfig.Provider) r1     // Catch:{ NotFoundException -> 0x005e, ClassNotFoundException -> 0x005c, InstantiationException -> 0x005a, InvocationTargetException -> 0x0058, NoSuchMethodException -> 0x0056, IllegalAccessException -> 0x0054 }
            r3 = r1
            goto L_0x0066
        L_0x0054:
            r1 = move-exception
            goto L_0x005f
        L_0x0056:
            r1 = move-exception
            goto L_0x005f
        L_0x0058:
            r1 = move-exception
            goto L_0x005f
        L_0x005a:
            r1 = move-exception
            goto L_0x005f
        L_0x005c:
            r1 = move-exception
            goto L_0x005f
        L_0x005e:
            r1 = move-exception
        L_0x005f:
            java.lang.String r2 = "CameraX"
            java.lang.String r4 = "Failed to retrieve default CameraXConfig.Provider from resources"
            android.util.Log.e(r2, r4, r1)     // Catch:{ all -> 0x007e }
        L_0x0066:
            if (r3 == 0) goto L_0x0074
            androidx.camera.core.CameraXConfig r1 = r3.getCameraXConfig()     // Catch:{ all -> 0x007e }
            initializeLocked(r5, r1)     // Catch:{ all -> 0x007e }
            com.google.common.util.concurrent.ListenableFuture r1 = getInstanceLocked()     // Catch:{ all -> 0x007e }
            goto L_0x007c
        L_0x0074:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007e }
            java.lang.String r1 = "CameraX is not initialized properly. Either the CameraXConfig.Provider interface must be implemented by your Application class or a CameraXConfig must be explicitly provided for initialization."
            r5.<init>(r1)     // Catch:{ all -> 0x007e }
            throw r5     // Catch:{ all -> 0x007e }
        L_0x007c:
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            return r1
        L_0x007e:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.CameraX.getOrCreateInstance(android.content.Context):com.google.common.util.concurrent.ListenableFuture");
    }

    private static ListenableFuture<CameraX> getInstance() {
        ListenableFuture<CameraX> instanceLocked;
        synchronized (sInitializeLock) {
            instanceLocked = getInstanceLocked();
        }
        return instanceLocked;
    }

    private static ListenableFuture<CameraX> getInstanceLocked() {
        if (!sTargetInitialized) {
            return Futures.immediateFailedFuture(new IllegalStateException("Must call CameraX.initialize() first"));
        }
        return Futures.transform(sInitializeFuture, new Function() {
            /* class androidx.camera.core.$$Lambda$CameraX$VEE9dh7_HJjJWwjbSbma1Kbo5Y */

            public final Object apply(Object obj) {
                return CameraX.lambda$getInstanceLocked$4(CameraX.this, (Void) obj);
            }
        }, CameraXExecutors.directExecutor());
    }

    private static CameraX waitInitialized() {
        try {
            return getInstance().get(3, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            throw new IllegalStateException(e);
        } catch (TimeoutException e2) {
            throw new IllegalStateException(e2);
        } catch (InterruptedException e3) {
            throw new IllegalStateException(e3);
        }
    }

    private static void attach(String str, UseCase useCase) {
        CameraInternal camera = checkInitialized().getCameraRepository().getCamera(str);
        useCase.addStateChangeCallback(camera);
        useCase.attachCameraControl(str, camera.getCameraControlInternal());
    }

    private static void detach(String str, List<UseCase> list) {
        CameraInternal camera = checkInitialized().getCameraRepository().getCamera(str);
        for (UseCase next : list) {
            next.removeStateChangeCallback(camera);
            next.detachCameraControl(str);
        }
        camera.removeOnlineUseCase(list);
    }

    private static void calculateSuggestedResolutions(LifecycleOwner lifecycleOwner, String str, UseCase... useCaseArr) {
        UseCaseGroup useCaseGroup = checkInitialized().getOrCreateUseCaseGroup(lifecycleOwner).getUseCaseGroup();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (UseCase next : useCaseGroup.getUseCases()) {
            for (String next2 : next.getAttachedCameraIds()) {
                Object obj = (List) hashMap.get(next2);
                if (obj == null) {
                    obj = new ArrayList();
                    hashMap.put(next2, obj);
                }
                obj.add(next);
            }
        }
        for (UseCase useCase : useCaseArr) {
            Object obj2 = (List) hashMap2.get(str);
            if (obj2 == null) {
                obj2 = new ArrayList();
                hashMap2.put(str, obj2);
            }
            obj2.add(useCase);
        }
        for (String str2 : hashMap2.keySet()) {
            Map<UseCase, Size> suggestedResolutions = getSurfaceManager().getSuggestedResolutions(str2, (List) hashMap.get(str2), (List) hashMap2.get(str2));
            for (UseCase useCase2 : (List) hashMap2.get(str2)) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put(str2, suggestedResolutions.get(useCase2));
                useCase2.updateSuggestedResolution(hashMap3);
            }
        }
    }

    private CameraDeviceSurfaceManager getCameraDeviceSurfaceManager() {
        CameraDeviceSurfaceManager cameraDeviceSurfaceManager = this.mSurfaceManager;
        if (cameraDeviceSurfaceManager != null) {
            return cameraDeviceSurfaceManager;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    private UseCaseConfigFactory getDefaultConfigFactory() {
        UseCaseConfigFactory useCaseConfigFactory = this.mDefaultConfigFactory;
        if (useCaseConfigFactory != null) {
            return useCaseConfigFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    /* access modifiers changed from: private */
    public ListenableFuture<Void> initInternal(Context context, CameraXConfig cameraXConfig) {
        ListenableFuture<Void> future;
        synchronized (this.mInitializeLock) {
            Preconditions.checkState(this.mInitState == InternalInitState.UNINITIALIZED, "CameraX.initInternal() should only be called once per instance");
            this.mInitState = InternalInitState.INITIALIZING;
            future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(context, cameraXConfig) {
                /* class androidx.camera.core.$$Lambda$CameraX$4E6qa025Kj0hVMOg15hnO5sf0U */
                private final /* synthetic */ Context f$1;
                private final /* synthetic */ CameraXConfig f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return CameraX.this.lambda$initInternal$6$CameraX(this.f$1, this.f$2, completer);
                }
            });
        }
        return future;
    }

    public /* synthetic */ Object lambda$initInternal$6$CameraX(Context context, CameraXConfig cameraXConfig, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCameraExecutor.execute(new Runnable(context, cameraXConfig, completer) {
            /* class androidx.camera.core.$$Lambda$CameraX$B_UROWi02gt7Lkfhqiard2zQIIw */
            private final /* synthetic */ Context f$1;
            private final /* synthetic */ CameraXConfig f$2;
            private final /* synthetic */ CallbackToFutureAdapter.Completer f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                CameraX.this.lambda$null$5$CameraX(this.f$1, this.f$2, this.f$3);
            }
        });
        return "CameraX initInternal";
    }

    public /* synthetic */ void lambda$null$5$CameraX(Context context, CameraXConfig cameraXConfig, CallbackToFutureAdapter.Completer completer) {
        try {
            this.mContext = context.getApplicationContext();
            CameraFactory.Provider cameraFactoryProvider = cameraXConfig.getCameraFactoryProvider(null);
            if (cameraFactoryProvider == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid app configuration provided. Missing CameraFactory.");
                synchronized (this.mInitializeLock) {
                    this.mInitState = InternalInitState.INITIALIZED;
                }
                completer.setException(illegalArgumentException);
                return;
            }
            this.mCameraFactory = cameraFactoryProvider.newInstance(context);
            CameraDeviceSurfaceManager.Provider deviceSurfaceManagerProvider = cameraXConfig.getDeviceSurfaceManagerProvider(null);
            if (deviceSurfaceManagerProvider == null) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Invalid app configuration provided. Missing CameraDeviceSurfaceManager.");
                synchronized (this.mInitializeLock) {
                    this.mInitState = InternalInitState.INITIALIZED;
                }
                completer.setException(illegalArgumentException2);
                return;
            }
            this.mSurfaceManager = deviceSurfaceManagerProvider.newInstance(context);
            UseCaseConfigFactory.Provider useCaseConfigFactoryProvider = cameraXConfig.getUseCaseConfigFactoryProvider(null);
            if (useCaseConfigFactoryProvider == null) {
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid app configuration provided. Missing UseCaseConfigFactory.");
                synchronized (this.mInitializeLock) {
                    this.mInitState = InternalInitState.INITIALIZED;
                }
                completer.setException(illegalArgumentException3);
                return;
            }
            this.mDefaultConfigFactory = useCaseConfigFactoryProvider.newInstance(context);
            if (this.mCameraExecutor instanceof CameraExecutor) {
                ((CameraExecutor) this.mCameraExecutor).init(this.mCameraFactory);
            }
            this.mCameraRepository.init(this.mCameraFactory);
            synchronized (this.mInitializeLock) {
                this.mInitState = InternalInitState.INITIALIZED;
            }
            completer.set(null);
        } catch (Throwable th) {
            synchronized (this.mInitializeLock) {
                this.mInitState = InternalInitState.INITIALIZED;
                completer.set(null);
                throw th;
            }
        }
    }

    /* renamed from: androidx.camera.core.CameraX$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$CameraX$InternalInitState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.camera.core.CameraX$InternalInitState[] r0 = androidx.camera.core.CameraX.InternalInitState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.camera.core.CameraX.AnonymousClass3.$SwitchMap$androidx$camera$core$CameraX$InternalInitState = r0
                androidx.camera.core.CameraX$InternalInitState r1 = androidx.camera.core.CameraX.InternalInitState.UNINITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = androidx.camera.core.CameraX.AnonymousClass3.$SwitchMap$androidx$camera$core$CameraX$InternalInitState     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.CameraX$InternalInitState r1 = androidx.camera.core.CameraX.InternalInitState.INITIALIZING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = androidx.camera.core.CameraX.AnonymousClass3.$SwitchMap$androidx$camera$core$CameraX$InternalInitState     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.core.CameraX$InternalInitState r1 = androidx.camera.core.CameraX.InternalInitState.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = androidx.camera.core.CameraX.AnonymousClass3.$SwitchMap$androidx$camera$core$CameraX$InternalInitState     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.core.CameraX$InternalInitState r1 = androidx.camera.core.CameraX.InternalInitState.SHUTDOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.CameraX.AnonymousClass3.<clinit>():void");
        }
    }

    private ListenableFuture<Void> shutdownInternal() {
        synchronized (this.mInitializeLock) {
            int i = AnonymousClass3.$SwitchMap$androidx$camera$core$CameraX$InternalInitState[this.mInitState.ordinal()];
            if (i == 1) {
                this.mInitState = InternalInitState.SHUTDOWN;
                ListenableFuture<Void> immediateFuture = Futures.immediateFuture(null);
                return immediateFuture;
            } else if (i != 2) {
                if (i == 3) {
                    this.mInitState = InternalInitState.SHUTDOWN;
                    this.mShutdownInternalFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() {
                        /* class androidx.camera.core.$$Lambda$CameraX$kZGZ3U2NTHv0yUj9yNdcLq1kc */

                        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                            return CameraX.this.lambda$shutdownInternal$8$CameraX(completer);
                        }
                    });
                }
                ListenableFuture<Void> listenableFuture = this.mShutdownInternalFuture;
                return listenableFuture;
            } else {
                throw new IllegalStateException("CameraX could not be shutdown when it is initializing.");
            }
        }
    }

    public /* synthetic */ Object lambda$shutdownInternal$8$CameraX(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCameraRepository.deinit().addListener(new Runnable(completer) {
            /* class androidx.camera.core.$$Lambda$CameraX$VxBiwU0AmjLKqFxHW1ZhUUIGWI */
            private final /* synthetic */ CallbackToFutureAdapter.Completer f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                CameraX.this.lambda$null$7$CameraX(this.f$1);
            }
        }, this.mCameraExecutor);
        return "CameraX shutdownInternal";
    }

    public /* synthetic */ void lambda$null$7$CameraX(CallbackToFutureAdapter.Completer completer) {
        Executor executor = this.mCameraExecutor;
        if (executor instanceof CameraExecutor) {
            ((CameraExecutor) executor).deinit();
        }
        completer.set(null);
    }

    private boolean isInitializedInternal() {
        boolean z;
        synchronized (this.mInitializeLock) {
            z = this.mInitState == InternalInitState.INITIALIZED;
        }
        return z;
    }

    private UseCaseGroupLifecycleController getOrCreateUseCaseGroup(LifecycleOwner lifecycleOwner) {
        return this.mUseCaseGroupRepository.getOrCreateUseCaseGroup(lifecycleOwner, new UseCaseGroupRepository.UseCaseGroupSetup() {
            /* class androidx.camera.core.CameraX.AnonymousClass2 */

            public void setup(UseCaseGroup useCaseGroup) {
                useCaseGroup.setListener(CameraX.this.mCameraRepository);
            }
        });
    }

    private CameraRepository getCameraRepository() {
        return this.mCameraRepository;
    }
}
