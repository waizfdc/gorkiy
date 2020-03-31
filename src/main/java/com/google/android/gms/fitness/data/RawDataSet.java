package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzi;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class RawDataSet extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RawDataSet> CREATOR = new zzaa();
    public final boolean zzis;
    public final int zzlx;
    public final List<RawDataPoint> zzlz;

    public RawDataSet(int i, List<RawDataPoint> list, boolean z) {
        this.zzlx = i;
        this.zzlz = list;
        this.zzis = z;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> list) {
        this.zzlz = dataSet.zza(list);
        this.zzis = dataSet.zze();
        this.zzlx = zzi.zza(dataSet.getDataSource(), list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawDataSet)) {
            return false;
        }
        RawDataSet rawDataSet = (RawDataSet) obj;
        return this.zzlx == rawDataSet.zzlx && this.zzis == rawDataSet.zzis && Objects.equal(this.zzlz, rawDataSet.zzlz);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzlx));
    }

    public final String toString() {
        return String.format("RawDataSet{%s@[%s]}", Integer.valueOf(this.zzlx), this.zzlz);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzlx);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzlz, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzis);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
