package com.askgps.personaltrackercore.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.core.app.NotificationCompat;
import com.askgps.personaltrackercore.LogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/askgps/personaltrackercore/utils/FallUtils$sensorEventListener$1", "Landroid/hardware/SensorEventListener;", "onAccuracyChanged", "", "sensor", "Landroid/hardware/Sensor;", "accuracy", "", "onSensorChanged", NotificationCompat.CATEGORY_EVENT, "Landroid/hardware/SensorEvent;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: FallUtils.kt */
public final class FallUtils$sensorEventListener$1 implements SensorEventListener {
    final /* synthetic */ FallUtils this$0;

    public void onAccuracyChanged(Sensor sensor, int i) {
        Intrinsics.checkParameterIsNotNull(sensor, "sensor");
    }

    FallUtils$sensorEventListener$1(FallUtils fallUtils) {
        this.this$0 = fallUtils;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkParameterIsNotNull(sensorEvent, NotificationCompat.CATEGORY_EVENT);
        float sqrt = (float) Math.sqrt((double) ((sensorEvent.values[0] * sensorEvent.values[0]) + (sensorEvent.values[1] * sensorEvent.values[1]) + (sensorEvent.values[2] * sensorEvent.values[2])));
        this.this$0.moveDetect(sqrt);
        this.this$0.addToLastItemList(sqrt);
        if (sqrt <= 4.0f && !this.this$0.checkFallIsStart) {
            this.this$0.checkFallBeginTime = sensorEvent.timestamp;
            this.this$0.checkFallIsStart = true;
            LogKt.toLog$default(Long.valueOf(this.this$0.checkFallBeginTime), "start fall time", (String) null, (String) null, 6, (Object) null);
        } else if (sqrt > 4.0f && this.this$0.checkFallIsStart) {
            this.this$0.checkFallEndTime = sensorEvent.timestamp;
            LogKt.toLog$default(Long.valueOf(this.this$0.checkFallEndTime), "end fall time", (String) null, (String) null, 6, (Object) null);
            this.this$0.checkFallIsStart = false;
            long access$getCheckFallEndTime$p = this.this$0.checkFallEndTime - this.this$0.checkFallBeginTime;
            LogKt.toLog$default(Long.valueOf(access$getCheckFallEndTime$p), "fallTime", (String) null, (String) null, 6, (Object) null);
            if (access$getCheckFallEndTime$p >= ((long) FallUtils.MIN_FALL_TIME)) {
                this.this$0.getRepo().processingFallMessage();
            }
            this.this$0.checkFallBeginTime = 0;
            this.this$0.checkFallEndTime = 0;
        }
    }
}
