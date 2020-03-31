package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zze();
    private final String deviceAddress;
    private final BleDevice zzoj;
    private final zzcm zzok;

    zzf(String str, BleDevice bleDevice, IBinder iBinder) {
        this.deviceAddress = str;
        this.zzoj = bleDevice;
        this.zzok = zzcp.zzj(iBinder);
    }

    public zzf(String str, BleDevice bleDevice, zzcm zzcm) {
        this.deviceAddress = str;
        this.zzoj = bleDevice;
        this.zzok = zzcm;
    }

    public final String toString() {
        return String.format("ClaimBleDeviceRequest{%s %s}", this.deviceAddress, this.zzoj);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.deviceAddress, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzoj, i, false);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 3, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
