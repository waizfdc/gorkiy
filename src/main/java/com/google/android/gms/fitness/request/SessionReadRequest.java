package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcg;
import com.google.android.gms.internal.fitness.zzcj;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class SessionReadRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SessionReadRequest> CREATOR = new zzaw();
    private final long zzib;
    private final long zzic;
    private final List<DataType> zzio;
    private final List<DataSource> zzon;
    private final boolean zzoy;
    private final String zzqd;
    private final String zzqe;
    private boolean zzqf;
    private final List<String> zzqg;
    private final zzcg zzqh;

    SessionReadRequest(String str, String str2, long j, long j2, List<DataType> list, List<DataSource> list2, boolean z, boolean z2, List<String> list3, IBinder iBinder) {
        this.zzqd = str;
        this.zzqe = str2;
        this.zzib = j;
        this.zzic = j2;
        this.zzio = list;
        this.zzon = list2;
        this.zzqf = z;
        this.zzoy = z2;
        this.zzqg = list3;
        this.zzqh = zzcj.zzh(iBinder);
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class Builder {
        /* access modifiers changed from: private */
        public long zzib = 0;
        /* access modifiers changed from: private */
        public long zzic = 0;
        /* access modifiers changed from: private */
        public List<DataType> zzio = new ArrayList();
        /* access modifiers changed from: private */
        public List<DataSource> zzon = new ArrayList();
        /* access modifiers changed from: private */
        public boolean zzoy = false;
        /* access modifiers changed from: private */
        public String zzqd;
        /* access modifiers changed from: private */
        public String zzqe;
        /* access modifiers changed from: private */
        public List<String> zzqg = new ArrayList();
        /* access modifiers changed from: private */
        public boolean zzqi = false;

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            this.zzib = timeUnit.toMillis(j);
            this.zzic = timeUnit.toMillis(j2);
            return this;
        }

        public Builder setSessionName(String str) {
            this.zzqd = str;
            return this;
        }

        public Builder setSessionId(String str) {
            this.zzqe = str;
            return this;
        }

        public Builder read(DataSource dataSource) {
            Preconditions.checkNotNull(dataSource, "Attempting to add a null data source");
            if (!this.zzon.contains(dataSource)) {
                this.zzon.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            Preconditions.checkNotNull(dataType, "Attempting to use a null data type");
            if (!this.zzio.contains(dataType)) {
                this.zzio.add(dataType);
            }
            return this;
        }

        public Builder readSessionsFromAllApps() {
            this.zzqi = true;
            return this;
        }

        public Builder excludePackage(String str) {
            Preconditions.checkNotNull(str, "Attempting to use a null package name");
            if (!this.zzqg.contains(str)) {
                this.zzqg.add(str);
            }
            return this;
        }

        public Builder enableServerQueries() {
            this.zzoy = true;
            return this;
        }

        public SessionReadRequest build() {
            Preconditions.checkArgument(this.zzib > 0, "Invalid start time: %s", Long.valueOf(this.zzib));
            long j = this.zzic;
            Preconditions.checkArgument(j > 0 && j > this.zzib, "Invalid end time: %s", Long.valueOf(this.zzic));
            return new SessionReadRequest(this);
        }
    }

    private SessionReadRequest(Builder builder) {
        this(builder.zzqd, builder.zzqe, builder.zzib, builder.zzic, builder.zzio, builder.zzon, builder.zzqi, builder.zzoy, builder.zzqg, (zzcg) null);
    }

    public SessionReadRequest(SessionReadRequest sessionReadRequest, zzcg zzcg) {
        this(sessionReadRequest.zzqd, sessionReadRequest.zzqe, sessionReadRequest.zzib, sessionReadRequest.zzic, sessionReadRequest.zzio, sessionReadRequest.zzon, sessionReadRequest.zzqf, sessionReadRequest.zzoy, sessionReadRequest.zzqg, zzcg);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private SessionReadRequest(String str, String str2, long j, long j2, List<DataType> list, List<DataSource> list2, boolean z, boolean z2, List<String> list3, zzcg zzcg) {
        this(str, str2, j, j2, list, list2, z, z2, list3, zzcg == null ? null : zzcg.asBinder());
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzib, TimeUnit.MILLISECONDS);
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzic, TimeUnit.MILLISECONDS);
    }

    public String getSessionName() {
        return this.zzqd;
    }

    public String getSessionId() {
        return this.zzqe;
    }

    public List<DataType> getDataTypes() {
        return this.zzio;
    }

    public List<DataSource> getDataSources() {
        return this.zzon;
    }

    public boolean includeSessionsFromAllApps() {
        return this.zzqf;
    }

    public List<String> getExcludedPackages() {
        return this.zzqg;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SessionReadRequest) {
                SessionReadRequest sessionReadRequest = (SessionReadRequest) obj;
                if (Objects.equal(this.zzqd, sessionReadRequest.zzqd) && this.zzqe.equals(sessionReadRequest.zzqe) && this.zzib == sessionReadRequest.zzib && this.zzic == sessionReadRequest.zzic && Objects.equal(this.zzio, sessionReadRequest.zzio) && Objects.equal(this.zzon, sessionReadRequest.zzon) && this.zzqf == sessionReadRequest.zzqf && this.zzqg.equals(sessionReadRequest.zzqg) && this.zzoy == sessionReadRequest.zzoy) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqd, this.zzqe, Long.valueOf(this.zzib), Long.valueOf(this.zzic));
    }

    public String toString() {
        return Objects.toStringHelper(this).add("sessionName", this.zzqd).add("sessionId", this.zzqe).add("startTimeMillis", Long.valueOf(this.zzib)).add("endTimeMillis", Long.valueOf(this.zzic)).add("dataTypes", this.zzio).add("dataSources", this.zzon).add("sessionsFromAllApps", Boolean.valueOf(this.zzqf)).add("excludedPackages", this.zzqg).add("useServer", Boolean.valueOf(this.zzoy)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getSessionName(), false);
        SafeParcelWriter.writeString(parcel, 2, getSessionId(), false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzib);
        SafeParcelWriter.writeLong(parcel, 4, this.zzic);
        SafeParcelWriter.writeTypedList(parcel, 5, getDataTypes(), false);
        SafeParcelWriter.writeTypedList(parcel, 6, getDataSources(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, includeSessionsFromAllApps());
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzoy);
        SafeParcelWriter.writeStringList(parcel, 9, getExcludedPackages(), false);
        zzcg zzcg = this.zzqh;
        SafeParcelWriter.writeIBinder(parcel, 10, zzcg == null ? null : zzcg.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
