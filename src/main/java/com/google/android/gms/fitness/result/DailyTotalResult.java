package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class DailyTotalResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<DailyTotalResult> CREATOR = new zzb();
    private final DataSet zzjd;
    private final Status zzqr;

    DailyTotalResult(Status status, DataSet dataSet) {
        this.zzqr = status;
        this.zzjd = dataSet;
    }

    private DailyTotalResult(DataSet dataSet, Status status) {
        this.zzqr = status;
        this.zzjd = dataSet;
    }

    public static DailyTotalResult zza(Status status, DataType dataType) {
        return new DailyTotalResult(DataSet.create(new DataSource.Builder().setType(1).setDataType(dataType).build()), status);
    }

    public DataSet getTotal() {
        return this.zzjd;
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DailyTotalResult) {
                DailyTotalResult dailyTotalResult = (DailyTotalResult) obj;
                if (this.zzqr.equals(dailyTotalResult.zzqr) && Objects.equal(this.zzjd, dailyTotalResult.zzjd)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zzjd);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("status", this.zzqr).add("dataPoint", this.zzjd).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getTotal(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
