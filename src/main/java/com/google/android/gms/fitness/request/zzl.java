package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new zzk();
    private final DataSet zzjd;
    private final zzcm zzok;
    private final boolean zzos;

    zzl(DataSet dataSet, IBinder iBinder, boolean z) {
        this.zzjd = dataSet;
        this.zzok = zzcp.zzj(iBinder);
        this.zzos = z;
    }

    public zzl(DataSet dataSet, zzcm zzcm, boolean z) {
        this.zzjd = dataSet;
        this.zzok = zzcm;
        this.zzos = z;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzl) && Objects.equal(this.zzjd, ((zzl) obj).zzjd);
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzjd);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("dataSet", this.zzjd).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzjd, i, false);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 2, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzos);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
