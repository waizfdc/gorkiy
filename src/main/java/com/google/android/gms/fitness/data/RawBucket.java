package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class RawBucket extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RawBucket> CREATOR = new zzy();
    public final long zzib;
    public final long zzic;
    public final Session zzii;
    public final List<RawDataSet> zziq;
    public final int zzir;
    public final boolean zzis;
    public final int zzlv;

    public RawBucket(long j, long j2, Session session, int i, List<RawDataSet> list, int i2, boolean z) {
        this.zzib = j;
        this.zzic = j2;
        this.zzii = session;
        this.zzlv = i;
        this.zziq = list;
        this.zzir = i2;
        this.zzis = z;
    }

    public RawBucket(Bucket bucket, List<DataSource> list) {
        this.zzib = bucket.getStartTime(TimeUnit.MILLISECONDS);
        this.zzic = bucket.getEndTime(TimeUnit.MILLISECONDS);
        this.zzii = bucket.getSession();
        this.zzlv = bucket.zzd();
        this.zzir = bucket.getBucketType();
        this.zzis = bucket.zze();
        List<DataSet> dataSets = bucket.getDataSets();
        this.zziq = new ArrayList(dataSets.size());
        for (DataSet rawDataSet : dataSets) {
            this.zziq.add(new RawDataSet(rawDataSet, list));
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawBucket)) {
            return false;
        }
        RawBucket rawBucket = (RawBucket) obj;
        return this.zzib == rawBucket.zzib && this.zzic == rawBucket.zzic && this.zzlv == rawBucket.zzlv && Objects.equal(this.zziq, rawBucket.zziq) && this.zzir == rawBucket.zzir && this.zzis == rawBucket.zzis;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzib), Long.valueOf(this.zzic), Integer.valueOf(this.zzir));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("startTime", Long.valueOf(this.zzib)).add("endTime", Long.valueOf(this.zzic)).add("activity", Integer.valueOf(this.zzlv)).add("dataSets", this.zziq).add("bucketType", Integer.valueOf(this.zzir)).add("serverHasMoreData", Boolean.valueOf(this.zzis)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzib);
        SafeParcelWriter.writeLong(parcel, 2, this.zzic);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzii, i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzlv);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zziq, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzir);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzis);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
