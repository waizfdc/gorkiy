package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;
import java.util.Collections;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class StartBleScanRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StartBleScanRequest> CREATOR = new zzbg();
    private final List<DataType> zzio;
    private final zzcm zzok;
    private final zzaf zzqk;
    private final int zzql;
    private final BleScanCallback zzqm;

    StartBleScanRequest(List<DataType> list, IBinder iBinder, int i, IBinder iBinder2) {
        zzaf zzaf;
        this.zzio = list;
        if (iBinder == null) {
            zzaf = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.request.IBleScanCallback");
            if (queryLocalInterface instanceof zzaf) {
                zzaf = (zzaf) queryLocalInterface;
            } else {
                zzaf = new zzah(iBinder);
            }
        }
        this.zzqk = zzaf;
        this.zzql = i;
        this.zzok = zzcp.zzj(iBinder2);
        this.zzqm = null;
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class Builder {
        private DataType[] zzph = new DataType[0];
        private int zzql = 10;
        private BleScanCallback zzqn;

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.zzph = dataTypeArr;
            return this;
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            this.zzqn = bleScanCallback;
            return this;
        }

        public Builder setTimeoutSecs(int i) {
            boolean z = true;
            Preconditions.checkArgument(i > 0, "Stop time must be greater than zero");
            if (i > 60) {
                z = false;
            }
            Preconditions.checkArgument(z, "Stop time must be less than 1 minute");
            this.zzql = i;
            return this;
        }

        public StartBleScanRequest build() {
            Preconditions.checkState(this.zzqn != null, "Must set BleScanCallback");
            return new StartBleScanRequest(ArrayUtils.toArrayList(this.zzph), this.zzqn, this.zzql);
        }
    }

    private StartBleScanRequest(List<DataType> list, BleScanCallback bleScanCallback, int i) {
        this.zzio = list;
        this.zzqk = null;
        this.zzql = i;
        this.zzok = null;
        this.zzqm = bleScanCallback;
    }

    public StartBleScanRequest(List<DataType> list, zzaf zzaf, int i, zzcm zzcm) {
        this.zzio = list;
        this.zzqk = zzaf;
        this.zzql = i;
        this.zzok = zzcm;
        this.zzqm = null;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzio);
    }

    public int getTimeoutSecs() {
        return this.zzql;
    }

    public final BleScanCallback zzad() {
        return this.zzqm;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("dataTypes", this.zzio).add("timeoutSecs", Integer.valueOf(this.zzql)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getDataTypes(), false);
        zzaf zzaf = this.zzqk;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 2, zzaf == null ? null : zzaf.asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 3, getTimeoutSecs());
        zzcm zzcm = this.zzok;
        if (zzcm != null) {
            iBinder = zzcm.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 4, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
