package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class DataUpdateRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataUpdateRequest> CREATOR = new zzz();
    private final long zzib;
    private final long zzic;
    private final DataSet zzjd;
    private final zzcm zzok;

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class Builder {
        /* access modifiers changed from: private */
        public long zzib;
        /* access modifiers changed from: private */
        public long zzic;
        /* access modifiers changed from: private */
        public DataSet zzjd;

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            Preconditions.checkArgument(j > 0, "Invalid start time :%d", Long.valueOf(j));
            Preconditions.checkArgument(j2 >= j, "Invalid end time :%d", Long.valueOf(j2));
            this.zzib = timeUnit.toMillis(j);
            this.zzic = timeUnit.toMillis(j2);
            return this;
        }

        public Builder setDataSet(DataSet dataSet) {
            Preconditions.checkNotNull(dataSet, "Must set the data set");
            this.zzjd = dataSet;
            return this;
        }

        public DataUpdateRequest build() {
            int i;
            Preconditions.checkNotZero(this.zzib, "Must set a non-zero value for startTimeMillis/startTime");
            Preconditions.checkNotZero(this.zzic, "Must set a non-zero value for endTimeMillis/endTime");
            Preconditions.checkNotNull(this.zzjd, "Must set the data set");
            for (DataPoint next : this.zzjd.getDataPoints()) {
                long startTime = next.getStartTime(TimeUnit.MILLISECONDS);
                long endTime = next.getEndTime(TimeUnit.MILLISECONDS);
                Preconditions.checkState(!(startTime > endTime || (startTime != 0 && startTime < this.zzib) || ((i != 0 && startTime > this.zzic) || endTime > this.zzic || endTime < this.zzib)), "Data Point's startTimeMillis %d, endTimeMillis %d should lie between timeRange provided in the request. StartTimeMillis %d, EndTimeMillis: %d", Long.valueOf(startTime), Long.valueOf(endTime), Long.valueOf(this.zzib), Long.valueOf(this.zzic));
            }
            return new DataUpdateRequest(this);
        }
    }

    public DataUpdateRequest(long j, long j2, DataSet dataSet, IBinder iBinder) {
        this.zzib = j;
        this.zzic = j2;
        this.zzjd = dataSet;
        this.zzok = zzcp.zzj(iBinder);
    }

    private DataUpdateRequest(Builder builder) {
        this(builder.zzib, builder.zzic, builder.zzjd, null);
    }

    public DataUpdateRequest(DataUpdateRequest dataUpdateRequest, IBinder iBinder) {
        this(dataUpdateRequest.zzib, dataUpdateRequest.zzic, dataUpdateRequest.getDataSet(), iBinder);
    }

    public final long zzy() {
        return this.zzib;
    }

    public final long zzz() {
        return this.zzic;
    }

    public DataSet getDataSet() {
        return this.zzjd;
    }

    public IBinder getCallbackBinder() {
        zzcm zzcm = this.zzok;
        if (zzcm == null) {
            return null;
        }
        return zzcm.asBinder();
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzib, TimeUnit.MILLISECONDS);
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzic, TimeUnit.MILLISECONDS);
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof DataUpdateRequest) {
                DataUpdateRequest dataUpdateRequest = (DataUpdateRequest) obj;
                if (this.zzib == dataUpdateRequest.zzib && this.zzic == dataUpdateRequest.zzic && Objects.equal(this.zzjd, dataUpdateRequest.zzjd)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzib), Long.valueOf(this.zzic), this.zzjd);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("startTimeMillis", Long.valueOf(this.zzib)).add("endTimeMillis", Long.valueOf(this.zzic)).add("dataSet", this.zzjd).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzib);
        SafeParcelWriter.writeLong(parcel, 2, this.zzic);
        SafeParcelWriter.writeParcelable(parcel, 3, getDataSet(), i, false);
        SafeParcelWriter.writeIBinder(parcel, 4, getCallbackBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
