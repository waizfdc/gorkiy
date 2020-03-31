package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;
import com.google.android.gms.internal.fitness.zzh;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class SessionInsertRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SessionInsertRequest> CREATOR = new zzau();
    /* access modifiers changed from: private */
    public static final TimeUnit zzqa = TimeUnit.MILLISECONDS;
    private final Session zzii;
    private final List<DataSet> zziq;
    private final zzcm zzok;
    private final List<DataPoint> zzqb;

    SessionInsertRequest(Session session, List<DataSet> list, List<DataPoint> list2, IBinder iBinder) {
        this.zzii = session;
        this.zziq = Collections.unmodifiableList(list);
        this.zzqb = Collections.unmodifiableList(list2);
        this.zzok = zzcp.zzj(iBinder);
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class Builder {
        /* access modifiers changed from: private */
        public Session zzii;
        /* access modifiers changed from: private */
        public List<DataSet> zziq = new ArrayList();
        /* access modifiers changed from: private */
        public List<DataPoint> zzqb = new ArrayList();
        private List<DataSource> zzqc = new ArrayList();

        public Builder setSession(Session session) {
            this.zzii = session;
            return this;
        }

        public Builder addDataSet(DataSet dataSet) {
            Preconditions.checkArgument(dataSet != null, "Must specify a valid data set.");
            DataSource dataSource = dataSet.getDataSource();
            Preconditions.checkState(!this.zzqc.contains(dataSource), "Data set for this data source %s is already added.", dataSource);
            Preconditions.checkArgument(!dataSet.getDataPoints().isEmpty(), "No data points specified in the input data set.");
            this.zzqc.add(dataSource);
            this.zziq.add(dataSet);
            return this;
        }

        public Builder addAggregateDataPoint(DataPoint dataPoint) {
            Preconditions.checkArgument(dataPoint != null, "Must specify a valid aggregate data point.");
            DataSource dataSource = dataPoint.getDataSource();
            Preconditions.checkState(!this.zzqc.contains(dataSource), "Data set/Aggregate data point for this data source %s is already added.", dataSource);
            DataSet.zzb(dataPoint);
            this.zzqc.add(dataSource);
            this.zzqb.add(dataPoint);
            return this;
        }

        public SessionInsertRequest build() {
            boolean z = true;
            Preconditions.checkState(this.zzii != null, "Must specify a valid session.");
            if (this.zzii.getEndTime(TimeUnit.MILLISECONDS) == 0) {
                z = false;
            }
            Preconditions.checkState(z, "Must specify a valid end time, cannot insert a continuing session.");
            for (DataSet dataPoints : this.zziq) {
                for (DataPoint zzd : dataPoints.getDataPoints()) {
                    zzd(zzd);
                }
            }
            for (DataPoint zzd2 : this.zzqb) {
                zzd(zzd2);
            }
            return new SessionInsertRequest(this);
        }

        private final void zzd(DataPoint dataPoint) {
            DataPoint dataPoint2 = dataPoint;
            long startTime = this.zzii.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzii.getEndTime(TimeUnit.NANOSECONDS);
            long timestamp = dataPoint2.getTimestamp(TimeUnit.NANOSECONDS);
            if (timestamp != 0) {
                if (timestamp < startTime || timestamp > endTime) {
                    timestamp = zzh.zza(timestamp, TimeUnit.NANOSECONDS, SessionInsertRequest.zzqa);
                }
                Preconditions.checkState(timestamp >= startTime && timestamp <= endTime, "Data point %s has time stamp outside session interval [%d, %d]", dataPoint2, Long.valueOf(startTime), Long.valueOf(endTime));
                if (dataPoint2.getTimestamp(TimeUnit.NANOSECONDS) != timestamp) {
                    Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", Long.valueOf(dataPoint2.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(timestamp), SessionInsertRequest.zzqa));
                    dataPoint2.setTimestamp(timestamp, TimeUnit.NANOSECONDS);
                }
            }
            long startTime2 = this.zzii.getStartTime(TimeUnit.NANOSECONDS);
            long endTime2 = this.zzii.getEndTime(TimeUnit.NANOSECONDS);
            long startTime3 = dataPoint2.getStartTime(TimeUnit.NANOSECONDS);
            long endTime3 = dataPoint2.getEndTime(TimeUnit.NANOSECONDS);
            if (startTime3 != 0 && endTime3 != 0) {
                if (endTime3 > endTime2) {
                    endTime3 = zzh.zza(endTime3, TimeUnit.NANOSECONDS, SessionInsertRequest.zzqa);
                }
                Preconditions.checkState(startTime3 >= startTime2 && endTime3 <= endTime2, "Data point %s has start and end times outside session interval [%d, %d]", dataPoint2, Long.valueOf(startTime2), Long.valueOf(endTime2));
                if (endTime3 != dataPoint2.getEndTime(TimeUnit.NANOSECONDS)) {
                    Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", Long.valueOf(dataPoint2.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(endTime3), SessionInsertRequest.zzqa));
                    dataPoint.setTimeInterval(startTime3, endTime3, TimeUnit.NANOSECONDS);
                }
            }
        }
    }

    private SessionInsertRequest(Builder builder) {
        this(builder.zzii, builder.zziq, builder.zzqb, (zzcm) null);
    }

    public SessionInsertRequest(SessionInsertRequest sessionInsertRequest, zzcm zzcm) {
        this(sessionInsertRequest.zzii, sessionInsertRequest.zziq, sessionInsertRequest.zzqb, zzcm);
    }

    private SessionInsertRequest(Session session, List<DataSet> list, List<DataPoint> list2, zzcm zzcm) {
        this.zzii = session;
        this.zziq = Collections.unmodifiableList(list);
        this.zzqb = Collections.unmodifiableList(list2);
        this.zzok = zzcm;
    }

    public Session getSession() {
        return this.zzii;
    }

    public List<DataSet> getDataSets() {
        return this.zziq;
    }

    public List<DataPoint> getAggregateDataPoints() {
        return this.zzqb;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof SessionInsertRequest) {
                SessionInsertRequest sessionInsertRequest = (SessionInsertRequest) obj;
                if (Objects.equal(this.zzii, sessionInsertRequest.zzii) && Objects.equal(this.zziq, sessionInsertRequest.zziq) && Objects.equal(this.zzqb, sessionInsertRequest.zzqb)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzii, this.zziq, this.zzqb);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(SettingsJsonConstants.SESSION_KEY, this.zzii).add("dataSets", this.zziq).add("aggregateDataPoints", this.zzqb).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getSession(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 2, getDataSets(), false);
        SafeParcelWriter.writeTypedList(parcel, 3, getAggregateDataPoints(), false);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 4, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
