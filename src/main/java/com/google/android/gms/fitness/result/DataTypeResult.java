package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class DataTypeResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<DataTypeResult> CREATOR = new zze();
    private final DataType zzhz;
    private final Status zzqr;

    public DataTypeResult(Status status, DataType dataType) {
        this.zzqr = status;
        this.zzhz = dataType;
    }

    public static DataTypeResult zzc(Status status) {
        return new DataTypeResult(status, null);
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public DataType getDataType() {
        return this.zzhz;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DataTypeResult) {
                DataTypeResult dataTypeResult = (DataTypeResult) obj;
                if (this.zzqr.equals(dataTypeResult.zzqr) && Objects.equal(this.zzhz, dataTypeResult.zzhz)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zzhz);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("status", this.zzqr).add("dataType", this.zzhz).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getDataType(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
