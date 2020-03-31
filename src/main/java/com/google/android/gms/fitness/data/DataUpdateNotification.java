package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class DataUpdateNotification extends AbstractSafeParcelable {
    public static final String ACTION = "com.google.android.gms.fitness.DATA_UPDATE_NOTIFICATION";
    public static final Parcelable.Creator<DataUpdateNotification> CREATOR = new zzn();
    public static final String EXTRA_DATA_UPDATE_NOTIFICATION = "vnd.google.fitness.data_udpate_notification";
    public static final int OPERATION_DELETE = 2;
    public static final int OPERATION_INSERT = 1;
    public static final int OPERATION_UPDATE = 3;
    private final DataType zzhz;
    private final DataSource zzia;
    private final long zzka;
    private final long zzkb;
    private final int zzkc;

    public DataUpdateNotification(long j, long j2, int i, DataSource dataSource, DataType dataType) {
        this.zzka = j;
        this.zzkb = j2;
        this.zzkc = i;
        this.zzia = dataSource;
        this.zzhz = dataType;
    }

    public static DataUpdateNotification getDataUpdateNotification(Intent intent) {
        return (DataUpdateNotification) SafeParcelableSerializer.deserializeFromIntentExtra(intent, EXTRA_DATA_UPDATE_NOTIFICATION, CREATOR);
    }

    public long getUpdateStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzka, TimeUnit.NANOSECONDS);
    }

    public long getUpdateEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzkb, TimeUnit.NANOSECONDS);
    }

    public int getOperationType() {
        return this.zzkc;
    }

    public DataSource getDataSource() {
        return this.zzia;
    }

    public DataType getDataType() {
        return this.zzhz;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataUpdateNotification)) {
            return false;
        }
        DataUpdateNotification dataUpdateNotification = (DataUpdateNotification) obj;
        return this.zzka == dataUpdateNotification.zzka && this.zzkb == dataUpdateNotification.zzkb && this.zzkc == dataUpdateNotification.zzkc && Objects.equal(this.zzia, dataUpdateNotification.zzia) && Objects.equal(this.zzhz, dataUpdateNotification.zzhz);
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzka), Long.valueOf(this.zzkb), Integer.valueOf(this.zzkc), this.zzia, this.zzhz);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("updateStartTimeNanos", Long.valueOf(this.zzka)).add("updateEndTimeNanos", Long.valueOf(this.zzkb)).add("operationType", Integer.valueOf(this.zzkc)).add("dataSource", this.zzia).add("dataType", this.zzhz).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzka);
        SafeParcelWriter.writeLong(parcel, 2, this.zzkb);
        SafeParcelWriter.writeInt(parcel, 3, getOperationType());
        SafeParcelWriter.writeParcelable(parcel, 4, getDataSource(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, getDataType(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
