package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzce;
import com.google.android.gms.internal.fitness.zzcf;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new zzal();
    private final DataType zzhz;
    private final zzcf zzpo;

    zzai(DataType dataType, IBinder iBinder) {
        this.zzhz = dataType;
        this.zzpo = zzce.zzg(iBinder);
    }

    public zzai(DataType dataType, zzcf zzcf) {
        this.zzhz = dataType;
        this.zzpo = zzcf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzhz, i, false);
        zzcf zzcf = this.zzpo;
        SafeParcelWriter.writeIBinder(parcel, 2, zzcf == null ? null : zzcf.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
