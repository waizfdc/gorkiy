package com.askgps.personaltrackercore.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/askgps/personaltrackercore/utils/RemovalFromHandUtils$eventListener$1", "Landroid/hardware/SensorEventListener;", "onAccuracyChanged", "", "sensor", "Landroid/hardware/Sensor;", "accuracy", "", "onSensorChanged", NotificationCompat.CATEGORY_EVENT, "Landroid/hardware/SensorEvent;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: RemovalFromHandUtils.kt */
public final class RemovalFromHandUtils$eventListener$1 implements SensorEventListener {
    final /* synthetic */ RemovalFromHandUtils this$0;

    public void onAccuracyChanged(Sensor sensor, int i) {
        Intrinsics.checkParameterIsNotNull(sensor, "sensor");
    }

    RemovalFromHandUtils$eventListener$1(RemovalFromHandUtils removalFromHandUtils) {
        this.this$0 = removalFromHandUtils;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkParameterIsNotNull(sensorEvent, NotificationCompat.CATEGORY_EVENT);
        this.this$0.calcHeartRate(sensorEvent.values[0]);
    }
}
