package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class DataUpdateListenerRegistrationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataUpdateListenerRegistrationRequest> CREATOR = new zzv();
    private DataType zzhz;
    private DataSource zzia;
    private final zzcm zzok;
    private final PendingIntent zzpk;

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class Builder {
        /* access modifiers changed from: private */
        public DataType zzhz;
        /* access modifiers changed from: private */
        public DataSource zzia;
        /* access modifiers changed from: private */
        public PendingIntent zzpk;

        public Builder setDataSource(DataSource dataSource) throws NullPointerException {
            Preconditions.checkNotNull(dataSource);
            this.zzia = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            Preconditions.checkNotNull(dataType);
            this.zzhz = dataType;
            return this;
        }

        public Builder setPendingIntent(PendingIntent pendingIntent) {
            Preconditions.checkNotNull(pendingIntent);
            this.zzpk = pendingIntent;
            return this;
        }

        public DataUpdateListenerRegistrationRequest build() {
            Preconditions.checkState((this.zzia == null && this.zzhz == null) ? false : true, "Set either dataSource or dataTYpe");
            Preconditions.checkNotNull(this.zzpk, "pendingIntent must be set");
            return new DataUpdateListenerRegistrationRequest(this);
        }
    }

    public DataUpdateListenerRegistrationRequest(DataSource dataSource, DataType dataType, PendingIntent pendingIntent, IBinder iBinder) {
        this.zzia = dataSource;
        this.zzhz = dataType;
        this.zzpk = pendingIntent;
        this.zzok = zzcp.zzj(iBinder);
    }

    public DataUpdateListenerRegistrationRequest(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest, IBinder iBinder) {
        this(dataUpdateListenerRegistrationRequest.zzia, dataUpdateListenerRegistrationRequest.zzhz, dataUpdateListenerRegistrationRequest.zzpk, iBinder);
    }

    private DataUpdateListenerRegistrationRequest(Builder builder) {
        this(builder.zzia, builder.zzhz, builder.zzpk, null);
    }

    public DataSource getDataSource() {
        return this.zzia;
    }

    public DataType getDataType() {
        return this.zzhz;
    }

    public PendingIntent getIntent() {
        return this.zzpk;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("dataSource", this.zzia).add("dataType", this.zzhz).add(BaseGmsClient.KEY_PENDING_INTENT, this.zzpk).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataSource(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getDataType(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getIntent(), i, false);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 4, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DataUpdateListenerRegistrationRequest) {
                DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest = (DataUpdateListenerRegistrationRequest) obj;
                if (Objects.equal(this.zzia, dataUpdateListenerRegistrationRequest.zzia) && Objects.equal(this.zzhz, dataUpdateListenerRegistrationRequest.zzhz) && Objects.equal(this.zzpk, dataUpdateListenerRegistrationRequest.zzpk)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzia, this.zzhz, this.zzpk);
    }
}
