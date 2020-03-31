package com.askgps.personaltrackercore.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.askgps.personaltrackercore.LogKt;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0018\u0018\u0000 92\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u00019B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020.H\u0004J\b\u0010/\u001a\u00020\nH\u0016J\b\u00100\u001a\u00020\nH\u0016J\b\u00101\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\nH\u0016J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020\u0003042\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\nH\u0016J\b\u00108\u001a\u00020\nH\u0016R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R \u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006:"}, d2 = {"Lcom/askgps/personaltrackercore/utils/RemovalFromHandUtils;", "Lcom/askgps/personaltrackercore/utils/Utils;", "Lcom/askgps/personaltrackercore/utils/Periodic;", "", "Lorg/koin/core/KoinComponent;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "callback", "Lkotlin/Function1;", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "getContext", "()Landroid/content/Context;", "defaultSensor", "Landroid/hardware/Sensor;", "getDefaultSensor", "()Landroid/hardware/Sensor;", "setDefaultSensor", "(Landroid/hardware/Sensor;)V", "eventListener", "com/askgps/personaltrackercore/utils/RemovalFromHandUtils$eventListener$1", "Lcom/askgps/personaltrackercore/utils/RemovalFromHandUtils$eventListener$1;", "handlerThread", "Landroid/os/HandlerThread;", "job", "Lkotlinx/coroutines/CompletableJob;", "result", "getResult", "()Z", "setResult", "(Z)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sensorTypes", "", "", "getSensorTypes", "()Ljava/util/List;", "setSensorTypes", "(Ljava/util/List;)V", "calcHeartRate", "value", "", "onCreate", "onDestroy", "onPause", "onResume", "periodicResultAsync", "Lkotlinx/coroutines/Deferred;", "period", "", "registerSensorListener", "unregisterSensorListener", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: RemovalFromHandUtils.kt */
public final class RemovalFromHandUtils extends Utils implements Periodic<Boolean>, KoinComponent {
    public static final Companion Companion = new Companion(null);
    public static final int SENSOR_PERIOD = 1000000;
    protected Function1<? super Boolean, Unit> callback;
    private final Context context;
    public Sensor defaultSensor;
    private final RemovalFromHandUtils$eventListener$1 eventListener = new RemovalFromHandUtils$eventListener$1(this);
    private HandlerThread handlerThread;
    private final CompletableJob job = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
    private volatile boolean result;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(this.job));
    private List<Integer> sensorTypes = CollectionsKt.listOf((Object[]) new Integer[]{8, 21});

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public Context getContext() {
        return this.context;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlinx.coroutines.SupervisorKt.SupervisorJob$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.CompletableJob
     arg types: [?[OBJECT, ARRAY], int, ?[OBJECT, ARRAY]]
     candidates:
      kotlinx.coroutines.SupervisorKt.SupervisorJob$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.Job
      kotlinx.coroutines.SupervisorKt.SupervisorJob$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.CompletableJob */
    public RemovalFromHandUtils(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/askgps/personaltrackercore/utils/RemovalFromHandUtils$Companion;", "", "()V", "SENSOR_PERIOD", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RemovalFromHandUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final List<Integer> getSensorTypes() {
        return this.sensorTypes;
    }

    public final void setSensorTypes(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.sensorTypes = list;
    }

    public final Sensor getDefaultSensor() {
        Sensor sensor = this.defaultSensor;
        if (sensor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultSensor");
        }
        return sensor;
    }

    public final void setDefaultSensor(Sensor sensor) {
        Intrinsics.checkParameterIsNotNull(sensor, "<set-?>");
        this.defaultSensor = sensor;
    }

    /* access modifiers changed from: protected */
    public final Function1<Boolean, Unit> getCallback() {
        Function1 function1 = this.callback;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        }
        return function1;
    }

    /* access modifiers changed from: protected */
    public final void setCallback(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "<set-?>");
        this.callback = function1;
    }

    public final boolean getResult() {
        return this.result;
    }

    public final void setResult(boolean z) {
        this.result = z;
    }

    /* access modifiers changed from: protected */
    public final void calcHeartRate(float f) {
        Sensor sensor = this.defaultSensor;
        if (sensor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultSensor");
        }
        int type = sensor.getType();
        boolean z = true;
        if (type != 8) {
            if (type == 21) {
                if (f != 0.0f) {
                    z = false;
                }
                this.result = z;
            }
        } else if (f <= ((float) CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE)) {
            boolean z2 = this.result;
            if (f >= ((float) 500)) {
                z = false;
            }
            this.result = z2 | z;
        }
    }

    public Deferred<Boolean> periodicResultAsync(long j) {
        return BuildersKt__Builders_commonKt.async$default(this.scope, null, null, new RemovalFromHandUtils$periodicResultAsync$1(this, j, null), 3, null);
    }

    public void registerSensorListener() {
        if (getListenerIsStart()) {
            LogKt.toFile$default("Utils " + getClass().getSimpleName() + " already started", null, null, null, 7, null);
            return;
        }
        this.result = false;
        Object systemService = getContext().getSystemService("sensor");
        if (systemService != null) {
            SensorManager sensorManager = (SensorManager) systemService;
            RemovalFromHandUtils removalFromHandUtils = this;
            if (removalFromHandUtils.defaultSensor == null) {
                Iterator<Integer> it = this.sensorTypes.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    int intValue = it.next().intValue();
                    if (!sensorManager.getSensorList(intValue).isEmpty()) {
                        Sensor defaultSensor2 = sensorManager.getDefaultSensor(intValue);
                        Intrinsics.checkExpressionValueIsNotNull(defaultSensor2, "sensorManager.getDefaultSensor(sensorType)");
                        this.defaultSensor = defaultSensor2;
                        break;
                    }
                }
            }
            if (removalFromHandUtils.defaultSensor != null) {
                HandlerThread handlerThread2 = new HandlerThread("RemovalThread");
                this.handlerThread = handlerThread2;
                if (handlerThread2 != null) {
                    handlerThread2.start();
                }
                SensorEventListener sensorEventListener = this.eventListener;
                Sensor sensor = this.defaultSensor;
                if (sensor == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("defaultSensor");
                }
                HandlerThread handlerThread3 = this.handlerThread;
                sensorManager.registerListener(sensorEventListener, sensor, 1000000, new Handler(handlerThread3 != null ? handlerThread3.getLooper() : null));
                setListenerIsStart(true);
                return;
            }
            LogKt.toFile$default("Error. defaultSensor is not initialized", null, "registerSensorListener", null, 5, null);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.SensorManager");
    }

    public void unregisterSensorListener() {
        if (this.defaultSensor != null) {
            Object systemService = getContext().getSystemService("sensor");
            if (systemService != null) {
                SensorManager sensorManager = (SensorManager) systemService;
                SensorEventListener sensorEventListener = this.eventListener;
                Sensor sensor = this.defaultSensor;
                if (sensor == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("defaultSensor");
                }
                sensorManager.unregisterListener(sensorEventListener, sensor);
                HandlerThread handlerThread2 = this.handlerThread;
                if (handlerThread2 != null) {
                    handlerThread2.quitSafely();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.hardware.SensorManager");
            }
        }
        setListenerIsStart(false);
    }
}
