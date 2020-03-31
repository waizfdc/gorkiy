package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class BleDevicesResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<BleDevicesResult> CREATOR = new zza();
    private final List<BleDevice> zzqq;
    private final Status zzqr;

    public BleDevicesResult(List<BleDevice> list, Status status) {
        this.zzqq = Collections.unmodifiableList(list);
        this.zzqr = status;
    }

    public static BleDevicesResult zzb(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    public List<BleDevice> getClaimedBleDevices() {
        return this.zzqq;
    }

    public List<BleDevice> getClaimedBleDevices(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (BleDevice next : this.zzqq) {
            if (next.getDataTypes().contains(dataType)) {
                arrayList.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BleDevicesResult) {
                BleDevicesResult bleDevicesResult = (BleDevicesResult) obj;
                if (this.zzqr.equals(bleDevicesResult.zzqr) && Objects.equal(this.zzqq, bleDevicesResult.zzqq)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zzqq);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("status", this.zzqr).add("bleDevices", this.zzqq).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getClaimedBleDevices(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, getStatus(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
