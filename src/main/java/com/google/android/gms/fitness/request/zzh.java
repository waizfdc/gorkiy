package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzba;
import com.google.android.gms.internal.fitness.zzbd;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzg();
    private DataType zzhz;
    private final zzba zzol;
    private final boolean zzom;

    zzh(IBinder iBinder, DataType dataType, boolean z) {
        this.zzol = zzbd.zzb(iBinder);
        this.zzhz = dataType;
        this.zzom = z;
    }

    public zzh(zzba zzba, DataType dataType, boolean z) {
        this.zzol = zzba;
        this.zzhz = dataType;
        this.zzom = z;
    }

    public final String toString() {
        Object[] objArr = new Object[1];
        DataType dataType = this.zzhz;
        objArr[0] = dataType == null ? "null" : dataType.zzp();
        return String.format("DailyTotalRequest{%s}", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zzol.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzhz, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzom);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
