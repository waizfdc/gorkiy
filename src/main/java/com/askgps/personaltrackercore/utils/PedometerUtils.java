package com.askgps.personaltrackercore.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.database.DatabaseHelper;
import com.askgps.personaltrackercore.pedometer.Pedometer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/askgps/personaltrackercore/utils/PedometerUtils;", "Lcom/askgps/personaltrackercore/utils/Utils;", "Lorg/koin/core/KoinComponent;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "handlerThread", "Landroid/os/HandlerThread;", "pedometer", "Lcom/askgps/personaltrackercore/pedometer/Pedometer;", "onCreate", "", "onDestroy", "onPause", "onResume", "registerSensorListener", "unregisterSensorListener", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PedometerUtils.kt */
public final class PedometerUtils extends Utils implements KoinComponent {
    private final Context context;
    private HandlerThread handlerThread;
    private final Pedometer pedometer = new Pedometer((DatabaseHelper) getKoin().get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(DatabaseHelper.class), (Qualifier) null, (Function0<DefinitionParameters>) null));

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public PedometerUtils(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    public Context getContext() {
        return this.context;
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public void registerSensorListener() {
        if (getListenerIsStart()) {
            LogKt.toFile$default("Utils " + getClass().getSimpleName() + " already started", null, null, null, 7, null);
            return;
        }
        Object systemService = getContext().getSystemService("sensor");
        if (systemService != null) {
            SensorManager sensorManager = (SensorManager) systemService;
            Sensor defaultSensor = sensorManager.getDefaultSensor(19);
            HandlerThread handlerThread2 = new HandlerThread("PedometerThread");
            this.handlerThread = handlerThread2;
            if (handlerThread2 != null) {
                handlerThread2.start();
            }
            SensorEventListener sensorEventListener = this.pedometer;
            HandlerThread handlerThread3 = this.handlerThread;
            sensorManager.registerListener(sensorEventListener, defaultSensor, 3, 1000000, new Handler(handlerThread3 != null ? handlerThread3.getLooper() : null));
            setListenerIsStart(true);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.SensorManager");
    }

    public void unregisterSensorListener() {
        Object systemService = getContext().getSystemService("sensor");
        if (systemService != null) {
            SensorManager sensorManager = (SensorManager) systemService;
            sensorManager.unregisterListener(this.pedometer, sensorManager.getDefaultSensor(19));
            HandlerThread handlerThread2 = this.handlerThread;
            if (handlerThread2 != null) {
                handlerThread2.quitSafely();
            }
            setListenerIsStart(false);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.SensorManager");
    }
}
