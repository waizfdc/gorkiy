package com.askgps.personaltrackercore.database.model;

import com.google.android.gms.fitness.FitnessActivities;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/askgps/personaltrackercore/database/model/StepSensor;", "", "lastSensorValue", "", "stepsTimeStamp", "", "stepsAtStartDay", "stepCount", "id", "(IJIII)V", "getId", "()I", "getLastSensorValue", "getStepCount", "getStepsAtStartDay", "getStepsTimeStamp", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FitnessActivities.OTHER, "hashCode", "toString", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: model.kt */
public final class StepSensor {
    private final int id;
    private final int lastSensorValue;
    private final int stepCount;
    private final int stepsAtStartDay;
    private final long stepsTimeStamp;

    public static /* synthetic */ StepSensor copy$default(StepSensor stepSensor, int i, long j, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = stepSensor.lastSensorValue;
        }
        if ((i5 & 2) != 0) {
            j = stepSensor.stepsTimeStamp;
        }
        long j2 = j;
        if ((i5 & 4) != 0) {
            i2 = stepSensor.stepsAtStartDay;
        }
        int i6 = i2;
        if ((i5 & 8) != 0) {
            i3 = stepSensor.stepCount;
        }
        int i7 = i3;
        if ((i5 & 16) != 0) {
            i4 = stepSensor.id;
        }
        return stepSensor.copy(i, j2, i6, i7, i4);
    }

    public final int component1() {
        return this.lastSensorValue;
    }

    public final long component2() {
        return this.stepsTimeStamp;
    }

    public final int component3() {
        return this.stepsAtStartDay;
    }

    public final int component4() {
        return this.stepCount;
    }

    public final int component5() {
        return this.id;
    }

    public final StepSensor copy(int i, long j, int i2, int i3, int i4) {
        return new StepSensor(i, j, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StepSensor)) {
            return false;
        }
        StepSensor stepSensor = (StepSensor) obj;
        return this.lastSensorValue == stepSensor.lastSensorValue && this.stepsTimeStamp == stepSensor.stepsTimeStamp && this.stepsAtStartDay == stepSensor.stepsAtStartDay && this.stepCount == stepSensor.stepCount && this.id == stepSensor.id;
    }

    public int hashCode() {
        return (((((((this.lastSensorValue * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.stepsTimeStamp)) * 31) + this.stepsAtStartDay) * 31) + this.stepCount) * 31) + this.id;
    }

    public String toString() {
        return "StepSensor(lastSensorValue=" + this.lastSensorValue + ", stepsTimeStamp=" + this.stepsTimeStamp + ", stepsAtStartDay=" + this.stepsAtStartDay + ", stepCount=" + this.stepCount + ", id=" + this.id + ")";
    }

    public StepSensor(int i, long j, int i2, int i3, int i4) {
        this.lastSensorValue = i;
        this.stepsTimeStamp = j;
        this.stepsAtStartDay = i2;
        this.stepCount = i3;
        this.id = i4;
    }

    public final int getLastSensorValue() {
        return this.lastSensorValue;
    }

    public final long getStepsTimeStamp() {
        return this.stepsTimeStamp;
    }

    public final int getStepsAtStartDay() {
        return this.stepsAtStartDay;
    }

    public final int getStepCount() {
        return this.stepCount;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StepSensor(int i, long j, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, j, i2, i3, (i5 & 16) != 0 ? 1 : i4);
    }

    public final int getId() {
        return this.id;
    }
}
