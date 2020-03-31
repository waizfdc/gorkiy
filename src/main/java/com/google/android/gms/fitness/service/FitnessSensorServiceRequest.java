package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzt;
import com.google.android.gms.fitness.data.zzu;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class FitnessSensorServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FitnessSensorServiceRequest> CREATOR = new zzb();
    public static final int UNSPECIFIED = -1;
    private final DataSource zzia;
    private final zzu zzpt;
    private final long zzqy;
    private final long zzqz;

    FitnessSensorServiceRequest(DataSource dataSource, IBinder iBinder, long j, long j2) {
        this.zzia = dataSource;
        this.zzpt = zzt.zza(iBinder);
        this.zzqy = j;
        this.zzqz = j2;
    }

    public DataSource getDataSource() {
        return this.zzia;
    }

    public SensorEventDispatcher getDispatcher() {
        return new zzc(this.zzpt);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        long j = this.zzqy;
        if (j == -1) {
            return -1;
        }
        return timeUnit.convert(j, TimeUnit.MICROSECONDS);
    }

    public long getBatchInterval(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzqz, TimeUnit.MICROSECONDS);
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", this.zzia);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataSource(), i, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzpt.asBinder(), false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzqy);
        SafeParcelWriter.writeLong(parcel, 4, this.zzqz);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FitnessSensorServiceRequest)) {
            return false;
        }
        FitnessSensorServiceRequest fitnessSensorServiceRequest = (FitnessSensorServiceRequest) obj;
        return Objects.equal(this.zzia, fitnessSensorServiceRequest.zzia) && this.zzqy == fitnessSensorServiceRequest.zzqy && this.zzqz == fitnessSensorServiceRequest.zzqz;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzia, Long.valueOf(this.zzqy), Long.valueOf(this.zzqz));
    }
}
