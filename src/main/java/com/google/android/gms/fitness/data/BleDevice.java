package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class BleDevice extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<BleDevice> CREATOR = new zzd();
    private final String name;
    private final String zzim;
    private final List<String> zzin;
    private final List<DataType> zzio;

    BleDevice(String str, String str2, List<String> list, List<DataType> list2) {
        this.zzim = str;
        this.name = str2;
        this.zzin = Collections.unmodifiableList(list);
        this.zzio = Collections.unmodifiableList(list2);
    }

    public String getAddress() {
        return this.zzim;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getSupportedProfiles() {
        return this.zzin;
    }

    public List<DataType> getDataTypes() {
        return this.zzio;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BleDevice)) {
            return false;
        }
        BleDevice bleDevice = (BleDevice) obj;
        return this.name.equals(bleDevice.name) && this.zzim.equals(bleDevice.zzim) && new HashSet(this.zzin).equals(new HashSet(bleDevice.zzin)) && new HashSet(this.zzio).equals(new HashSet(bleDevice.zzio));
    }

    public int hashCode() {
        return Objects.hashCode(this.name, this.zzim, this.zzin, this.zzio);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).add("address", this.zzim).add("dataTypes", this.zzio).add("supportedProfiles", this.zzin).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAddress(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeStringList(parcel, 3, getSupportedProfiles(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getDataTypes(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
