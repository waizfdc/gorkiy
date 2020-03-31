package com.askgps.personaltrackercore.database.model;

import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/askgps/personaltrackercore/database/model/IndoorDevice;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "rssi", "", "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getRssi", "()I", "component1", "component2", "copy", "equals", "", FitnessActivities.OTHER, "hashCode", "toString", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: model.kt */
public final class IndoorDevice {
    private final String name;
    private final int rssi;

    public static /* synthetic */ IndoorDevice copy$default(IndoorDevice indoorDevice, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = indoorDevice.name;
        }
        if ((i2 & 2) != 0) {
            i = indoorDevice.rssi;
        }
        return indoorDevice.copy(str, i);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.rssi;
    }

    public final IndoorDevice copy(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        return new IndoorDevice(str, i);
    }

    public String toString() {
        return "IndoorDevice(name=" + this.name + ", rssi=" + this.rssi + ")";
    }

    public IndoorDevice(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.name = str;
        this.rssi = i;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof IndoorDevice) && !(!Intrinsics.areEqual(this.name, ((IndoorDevice) obj).name))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }
}
