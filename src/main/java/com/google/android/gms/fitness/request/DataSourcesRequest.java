package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzbg;
import com.google.android.gms.internal.fitness.zzbj;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class DataSourcesRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new zzp();
    private final List<DataType> zzio;
    private final List<Integer> zzpe;
    private final boolean zzpf;
    private final zzbg zzpg;

    DataSourcesRequest(List<DataType> list, List<Integer> list2, boolean z, IBinder iBinder) {
        this.zzio = list;
        this.zzpe = list2;
        this.zzpf = z;
        this.zzpg = zzbj.zzd(iBinder);
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class Builder {
        private boolean zzpf = false;
        /* access modifiers changed from: private */
        public DataType[] zzph = new DataType[0];
        /* access modifiers changed from: private */
        public int[] zzpi = {0, 1};

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.zzph = dataTypeArr;
            return this;
        }

        public Builder setDataSourceTypes(int... iArr) {
            this.zzpi = iArr;
            return this;
        }

        public DataSourcesRequest build() {
            boolean z = true;
            Preconditions.checkState(this.zzph.length > 0, "Must add at least one data type");
            if (this.zzpi.length <= 0) {
                z = false;
            }
            Preconditions.checkState(z, "Must add at least one data source type");
            return new DataSourcesRequest(this);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.fitness.request.DataSourcesRequest.<init>(java.util.List<com.google.android.gms.fitness.data.DataType>, java.util.List<java.lang.Integer>, boolean, com.google.android.gms.internal.fitness.zzbg):void
     arg types: [java.util.ArrayList, java.util.List, int, ?[OBJECT, ARRAY]]
     candidates:
      com.google.android.gms.fitness.request.DataSourcesRequest.<init>(java.util.List<com.google.android.gms.fitness.data.DataType>, java.util.List<java.lang.Integer>, boolean, android.os.IBinder):void
      com.google.android.gms.fitness.request.DataSourcesRequest.<init>(java.util.List<com.google.android.gms.fitness.data.DataType>, java.util.List<java.lang.Integer>, boolean, com.google.android.gms.internal.fitness.zzbg):void */
    private DataSourcesRequest(Builder builder) {
        this((List<DataType>) ArrayUtils.toArrayList(builder.zzph), (List<Integer>) Arrays.asList(ArrayUtils.toWrapperArray(builder.zzpi)), false, (zzbg) null);
    }

    public DataSourcesRequest(DataSourcesRequest dataSourcesRequest, zzbg zzbg) {
        this(dataSourcesRequest.zzio, dataSourcesRequest.zzpe, dataSourcesRequest.zzpf, zzbg);
    }

    private DataSourcesRequest(List<DataType> list, List<Integer> list2, boolean z, zzbg zzbg) {
        this.zzio = list;
        this.zzpe = list2;
        this.zzpf = z;
        this.zzpg = zzbg;
    }

    public List<DataType> getDataTypes() {
        return this.zzio;
    }

    public String toString() {
        Objects.ToStringHelper add = Objects.toStringHelper(this).add("dataTypes", this.zzio).add("sourceTypes", this.zzpe);
        if (this.zzpf) {
            add.add("includeDbOnlySources", "true");
        }
        return add.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getDataTypes(), false);
        SafeParcelWriter.writeIntegerList(parcel, 2, this.zzpe, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzpf);
        zzbg zzbg = this.zzpg;
        SafeParcelWriter.writeIBinder(parcel, 4, zzbg == null ? null : zzbg.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
