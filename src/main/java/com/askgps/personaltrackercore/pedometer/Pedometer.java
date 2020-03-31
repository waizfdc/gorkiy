package com.askgps.personaltrackercore.pedometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.core.app.NotificationCompat;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.database.DatabaseHelper;
import com.askgps.personaltrackercore.database.model.StepSensor;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u000fH\u0002J\b\u0010#\u001a\u00020\u0015H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/askgps/personaltrackercore/pedometer/Pedometer;", "Landroid/hardware/SensorEventListener;", "Lkotlinx/coroutines/CoroutineScope;", "databaseHelper", "Lcom/askgps/personaltrackercore/database/DatabaseHelper;", "(Lcom/askgps/personaltrackercore/database/DatabaseHelper;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "job", "Lkotlinx/coroutines/CompletableJob;", "mLastSensorDate", "Ljava/util/Calendar;", "mLastSensorValue", "", "mLastStepsCount", "mSensorValueAtStartDay", "calcStepsForDay", "steps", "newDay", "", "time", "", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "onSensorChanged", NotificationCompat.CATEGORY_EVENT, "Landroid/hardware/SensorEvent;", "setLastSensorDate", "setLastSensorValue", "setSensorValueAtStartDay", "sensorValueAtStartDay", "updateSensorInfoAsync", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Pedometer.kt */
public final class Pedometer implements SensorEventListener, CoroutineScope {
    /* access modifiers changed from: private */
    public final DatabaseHelper databaseHelper;
    private final CompletableJob job = JobKt.Job$default((Job) null, 1, (Object) null);
    /* access modifiers changed from: private */
    public final Calendar mLastSensorDate;
    /* access modifiers changed from: private */
    public int mLastSensorValue;
    /* access modifiers changed from: private */
    public int mLastStepsCount;
    /* access modifiers changed from: private */
    public int mSensorValueAtStartDay;

    public void onAccuracyChanged(Sensor sensor, int i) {
        Intrinsics.checkParameterIsNotNull(sensor, "sensor");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlinx.coroutines.JobKt.Job$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.CompletableJob
     arg types: [?[OBJECT, ARRAY], int, ?[OBJECT, ARRAY]]
     candidates:
      kotlinx.coroutines.JobKt.Job$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.Job
      kotlinx.coroutines.JobKt.Job$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.CompletableJob */
    public Pedometer(DatabaseHelper databaseHelper2) {
        Intrinsics.checkParameterIsNotNull(databaseHelper2, "databaseHelper");
        this.databaseHelper = databaseHelper2;
        LogKt.toLog$default("Pedometer was created!", (String) null, (String) null, (String) null, 7, (Object) null);
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance()");
        this.mLastSensorDate = instance;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getDefault(), null, new AnonymousClass1(this, null), 2, null);
    }

    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getIO().plus(this.job);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
    @DebugMetadata(c = "com.askgps.personaltrackercore.pedometer.Pedometer$1", f = "Pedometer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.askgps.personaltrackercore.pedometer.Pedometer$1  reason: invalid class name */
    /* compiled from: Pedometer.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ Pedometer this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, continuation);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StepSensor stepInfo = this.this$0.databaseHelper.stepSensorDao().getStepInfo();
                if (stepInfo != null) {
                    this.this$0.mLastSensorDate.setTimeInMillis(stepInfo.getStepsTimeStamp());
                    this.this$0.mLastSensorValue = stepInfo.getLastSensorValue();
                    this.this$0.mLastStepsCount = stepInfo.getStepCount();
                    this.this$0.mSensorValueAtStartDay = stepInfo.getStepsAtStartDay();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkParameterIsNotNull(sensorEvent, NotificationCompat.CATEGORY_EVENT);
        Sensor sensor = sensorEvent.sensor;
        Intrinsics.checkExpressionValueIsNotNull(sensor, "event.sensor");
        if (sensor.getType() == 19) {
            long currentTimeMillis = System.currentTimeMillis();
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "newTime");
            instance.setTimeInMillis(currentTimeMillis);
            if (instance.get(6) != this.mLastSensorDate.get(6)) {
                newDay(currentTimeMillis);
            }
            int calcStepsForDay = calcStepsForDay((int) sensorEvent.values[0]);
            if (calcStepsForDay != this.mLastStepsCount) {
                this.mLastStepsCount = calcStepsForDay;
                updateSensorInfoAsync();
            }
        }
    }

    private final void newDay(long j) {
        setSensorValueAtStartDay(this.mLastSensorValue);
        setLastSensorDate(j);
    }

    private final void updateSensorInfoAsync() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, null, null, new Pedometer$updateSensorInfoAsync$1(this, null), 3, null);
    }

    private final int calcStepsForDay(int i) {
        int i2;
        int i3 = this.mLastSensorValue;
        if (i3 > i) {
            i2 = (i3 - this.mSensorValueAtStartDay) + i;
            setSensorValueAtStartDay(i - i2);
        } else {
            i2 = i - this.mSensorValueAtStartDay;
        }
        setLastSensorValue(i);
        return i2;
    }

    private final void setSensorValueAtStartDay(int i) {
        this.mSensorValueAtStartDay = i;
        updateSensorInfoAsync();
    }

    private final void setLastSensorDate(long j) {
        this.mLastSensorDate.setTimeInMillis(j);
        updateSensorInfoAsync();
    }

    private final void setLastSensorValue(int i) {
        this.mLastSensorValue = i;
        updateSensorInfoAsync();
    }
}
