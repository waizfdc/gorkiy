package com.askgps.personaltrackercore.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.repository.Repository;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f*\u0001\u0019\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0011H\u0002J\b\u0010#\u001a\u00020\u001eH\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\b\u0010'\u001a\u00020\u001eH\u0016J\b\u0010(\u001a\u00020\u001eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006*"}, d2 = {"Lcom/askgps/personaltrackercore/utils/FallUtils;", "Lcom/askgps/personaltrackercore/utils/Utils;", "Lorg/koin/core/KoinComponent;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkFallBeginTime", "", "checkFallEndTime", "checkFallIsStart", "", "getContext", "()Landroid/content/Context;", "handlerThread", "Landroid/os/HandlerThread;", "lastValueList", "Ljava/util/LinkedList;", "", "repo", "Lcom/askgps/personaltrackercore/repository/Repository;", "getRepo", "()Lcom/askgps/personaltrackercore/repository/Repository;", "repo$delegate", "Lkotlin/Lazy;", "sensorEventListener", "com/askgps/personaltrackercore/utils/FallUtils$sensorEventListener$1", "Lcom/askgps/personaltrackercore/utils/FallUtils$sensorEventListener$1;", "stayStartTime", "Ljava/lang/Long;", "addToLastItemList", "", "item", "initFields", "moveDetect", "newValue", "onCreate", "onDestroy", "onPause", "onResume", "registerSensorListener", "unregisterSensorListener", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FallUtils.kt */
public final class FallUtils extends Utils implements KoinComponent {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(FallUtils.class), "repo", "getRepo()Lcom/askgps/personaltrackercore/repository/Repository;"))};
    public static final Companion Companion = new Companion(null);
    private static final int LAST_ITEM_LIST_SIZE = 5;
    public static final int MIN_FALL_TIME = 400000000;
    private static final float MOVE_EPS = 0.5f;
    public static final int SENSOR_DELAY = 200000;
    private static final int STAY_THRESHOLD = 60000;
    public static final float THRESHOLD = 4.0f;
    /* access modifiers changed from: private */
    public long checkFallBeginTime;
    /* access modifiers changed from: private */
    public long checkFallEndTime;
    /* access modifiers changed from: private */
    public boolean checkFallIsStart;
    private final Context context;
    private HandlerThread handlerThread;
    private final LinkedList<Float> lastValueList = new LinkedList<>();
    private final Lazy repo$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new FallUtils$$special$$inlined$inject$1(this, null, null));
    private final FallUtils$sensorEventListener$1 sensorEventListener = new FallUtils$sensorEventListener$1(this);
    private Long stayStartTime;

    /* access modifiers changed from: private */
    public final Repository getRepo() {
        Lazy lazy = this.repo$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Repository) lazy.getValue();
    }

    private final void initFields() {
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, com.askgps.personaltrackercore.utils.FallUtils$$special$$inlined$inject$1]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public FallUtils(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    public Context getContext() {
        return this.context;
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/askgps/personaltrackercore/utils/FallUtils$Companion;", "", "()V", "LAST_ITEM_LIST_SIZE", "", "MIN_FALL_TIME", "MOVE_EPS", "", "SENSOR_DELAY", "STAY_THRESHOLD", "THRESHOLD", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: FallUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void addToLastItemList(float f) {
        if (this.lastValueList.size() == 5) {
            this.lastValueList.remove();
        }
        this.lastValueList.add(Float.valueOf(f));
    }

    /* access modifiers changed from: private */
    public final void moveDetect(float f) {
        if (Math.abs(((double) f) - CollectionsKt.averageOfFloat(this.lastValueList)) >= ((double) MOVE_EPS)) {
            this.stayStartTime = null;
            if (!getRepo().isMove()) {
                getRepo().setMove(true);
            }
        } else if (getRepo().isMove()) {
            if (this.stayStartTime == null) {
                this.stayStartTime = Long.valueOf(System.currentTimeMillis());
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Long l = this.stayStartTime;
            if (l == null) {
                Intrinsics.throwNpe();
            }
            if (currentTimeMillis - l.longValue() >= ((long) STAY_THRESHOLD)) {
                getRepo().setMove(false);
            }
        }
    }

    public void registerSensorListener() {
        if (getListenerIsStart()) {
            LogKt.toFile$default("Utils " + getClass().getSimpleName() + " already started", null, null, null, 7, null);
            return;
        }
        Object systemService = getContext().getSystemService("sensor");
        if (systemService != null) {
            SensorManager sensorManager = (SensorManager) systemService;
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            HandlerThread handlerThread2 = new HandlerThread("FallThread");
            this.handlerThread = handlerThread2;
            if (handlerThread2 != null) {
                handlerThread2.start();
            }
            initFields();
            SensorEventListener sensorEventListener2 = this.sensorEventListener;
            HandlerThread handlerThread3 = this.handlerThread;
            sensorManager.registerListener(sensorEventListener2, defaultSensor, SENSOR_DELAY, 1000000, new Handler(handlerThread3 != null ? handlerThread3.getLooper() : null));
            setListenerIsStart(true);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.SensorManager");
    }

    public void unregisterSensorListener() {
        Object systemService = getContext().getSystemService("sensor");
        if (systemService != null) {
            SensorManager sensorManager = (SensorManager) systemService;
            sensorManager.unregisterListener(this.sensorEventListener, sensorManager.getDefaultSensor(1));
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
