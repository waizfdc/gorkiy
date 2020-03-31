package com.askgps.personaltrackercore.database.model;

import com.google.android.gms.fitness.FitnessActivities;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/askgps/personaltrackercore/database/model/IndoorNavigation;", "", "bluetoothDevices", "", "Lcom/askgps/personaltrackercore/database/model/IndoorDevice;", "wifiDevices", "(Ljava/util/Set;Ljava/util/Set;)V", "getBluetoothDevices", "()Ljava/util/Set;", "getWifiDevices", "component1", "component2", "copy", "equals", "", FitnessActivities.OTHER, "hashCode", "", "toString", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: model.kt */
public final class IndoorNavigation {
    private final Set<IndoorDevice> bluetoothDevices;
    private final Set<IndoorDevice> wifiDevices;

    public static /* synthetic */ IndoorNavigation copy$default(IndoorNavigation indoorNavigation, Set set, Set set2, int i, Object obj) {
        if ((i & 1) != 0) {
            set = indoorNavigation.bluetoothDevices;
        }
        if ((i & 2) != 0) {
            set2 = indoorNavigation.wifiDevices;
        }
        return indoorNavigation.copy(set, set2);
    }

    public final Set<IndoorDevice> component1() {
        return this.bluetoothDevices;
    }

    public final Set<IndoorDevice> component2() {
        return this.wifiDevices;
    }

    public final IndoorNavigation copy(Set<IndoorDevice> set, Set<IndoorDevice> set2) {
        Intrinsics.checkParameterIsNotNull(set, "bluetoothDevices");
        Intrinsics.checkParameterIsNotNull(set2, "wifiDevices");
        return new IndoorNavigation(set, set2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndoorNavigation)) {
            return false;
        }
        IndoorNavigation indoorNavigation = (IndoorNavigation) obj;
        return Intrinsics.areEqual(this.bluetoothDevices, indoorNavigation.bluetoothDevices) && Intrinsics.areEqual(this.wifiDevices, indoorNavigation.wifiDevices);
    }

    public int hashCode() {
        Set<IndoorDevice> set = this.bluetoothDevices;
        int i = 0;
        int hashCode = (set != null ? set.hashCode() : 0) * 31;
        Set<IndoorDevice> set2 = this.wifiDevices;
        if (set2 != null) {
            i = set2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "IndoorNavigation(bluetoothDevices=" + this.bluetoothDevices + ", wifiDevices=" + this.wifiDevices + ")";
    }

    public IndoorNavigation(Set<IndoorDevice> set, Set<IndoorDevice> set2) {
        Intrinsics.checkParameterIsNotNull(set, "bluetoothDevices");
        Intrinsics.checkParameterIsNotNull(set2, "wifiDevices");
        this.bluetoothDevices = set;
        this.wifiDevices = set2;
    }

    public final Set<IndoorDevice> getBluetoothDevices() {
        return this.bluetoothDevices;
    }

    public final Set<IndoorDevice> getWifiDevices() {
        return this.wifiDevices;
    }
}
