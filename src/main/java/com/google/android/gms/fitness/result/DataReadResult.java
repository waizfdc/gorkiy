package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class DataReadResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<DataReadResult> CREATOR = new zzc();
    private final List<DataSet> zziq;
    private final List<DataSource> zzjc;
    private final Status zzqr;
    private final List<Bucket> zzqs;
    private int zzqt;

    DataReadResult(List<RawDataSet> list, Status status, List<RawBucket> list2, int i, List<DataSource> list3) {
        this.zzqr = status;
        this.zzqt = i;
        this.zzjc = list3;
        this.zziq = new ArrayList(list.size());
        for (RawDataSet dataSet : list) {
            this.zziq.add(new DataSet(dataSet, list3));
        }
        this.zzqs = new ArrayList(list2.size());
        for (RawBucket bucket : list2) {
            this.zzqs.add(new Bucket(bucket, list3));
        }
    }

    private DataReadResult(List<DataSet> list, List<Bucket> list2, Status status) {
        this.zziq = list;
        this.zzqr = status;
        this.zzqs = list2;
        this.zzqt = 1;
        this.zzjc = new ArrayList();
    }

    public static DataReadResult zza(Status status, List<DataType> list, List<DataSource> list2) {
        ArrayList arrayList = new ArrayList();
        for (DataSource create : list2) {
            arrayList.add(DataSet.create(create));
        }
        for (DataType dataType : list) {
            arrayList.add(DataSet.create(new DataSource.Builder().setType(1).setDataType(dataType).setName("Default").build()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet next : this.zziq) {
            if (dataType.equals(next.getDataType())) {
                return next;
            }
        }
        return DataSet.create(new DataSource.Builder().setType(1).setDataType(dataType).build());
    }

    public DataSet getDataSet(DataSource dataSource) {
        for (DataSet next : this.zziq) {
            if (dataSource.equals(next.getDataSource())) {
                return next;
            }
        }
        return DataSet.create(dataSource);
    }

    public List<DataSet> getDataSets() {
        return this.zziq;
    }

    public List<Bucket> getBuckets() {
        return this.zzqs;
    }

    public final int zzae() {
        return this.zzqt;
    }

    public final void zzb(DataReadResult dataReadResult) {
        for (DataSet zza : dataReadResult.getDataSets()) {
            zza(zza, this.zziq);
        }
        for (Bucket next : dataReadResult.getBuckets()) {
            Iterator<Bucket> it = this.zzqs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    this.zzqs.add(next);
                    break;
                }
                Bucket next2 = it.next();
                if (next2.zza(next)) {
                    for (DataSet zza2 : next.getDataSets()) {
                        zza(zza2, next2.getDataSets());
                    }
                }
            }
        }
    }

    private static void zza(DataSet dataSet, List<DataSet> list) {
        for (DataSet next : list) {
            if (next.getDataSource().equals(dataSet.getDataSource())) {
                next.zza(dataSet.getDataPoints());
                return;
            }
        }
        list.add(dataSet);
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DataReadResult) {
                DataReadResult dataReadResult = (DataReadResult) obj;
                if (this.zzqr.equals(dataReadResult.zzqr) && Objects.equal(this.zziq, dataReadResult.zziq) && Objects.equal(this.zzqs, dataReadResult.zzqs)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zziq, this.zzqs);
    }

    public String toString() {
        Object obj;
        Object obj2;
        Objects.ToStringHelper add = Objects.toStringHelper(this).add("status", this.zzqr);
        if (this.zziq.size() > 5) {
            int size = this.zziq.size();
            StringBuilder sb = new StringBuilder(21);
            sb.append(size);
            sb.append(" data sets");
            obj = sb.toString();
        } else {
            obj = this.zziq;
        }
        Objects.ToStringHelper add2 = add.add("dataSets", obj);
        if (this.zzqs.size() > 5) {
            int size2 = this.zzqs.size();
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append(size2);
            sb2.append(" buckets");
            obj2 = sb2.toString();
        } else {
            obj2 = this.zzqs;
        }
        return add2.add("buckets", obj2).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        ArrayList arrayList = new ArrayList(this.zziq.size());
        for (DataSet rawDataSet : this.zziq) {
            arrayList.add(new RawDataSet(rawDataSet, this.zzjc));
        }
        SafeParcelWriter.writeList(parcel, 1, arrayList, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getStatus(), i, false);
        ArrayList arrayList2 = new ArrayList(this.zzqs.size());
        for (Bucket rawBucket : this.zzqs) {
            arrayList2.add(new RawBucket(rawBucket, this.zzjc));
        }
        SafeParcelWriter.writeList(parcel, 3, arrayList2, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzqt);
        SafeParcelWriter.writeTypedList(parcel, 6, this.zzjc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
