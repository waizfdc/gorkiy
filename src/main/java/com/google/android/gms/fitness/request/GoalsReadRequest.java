package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzbm;
import com.google.android.gms.internal.fitness.zzbp;
import com.google.android.gms.internal.fitness.zzi;
import com.google.android.gms.internal.fitness.zzjn;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class GoalsReadRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoalsReadRequest> CREATOR = new zzad();
    private final List<DataType> zzio;
    private final List<Integer> zzll;
    private final zzbm zzpl;
    private final List<Integer> zzpm;

    public List<DataType> getDataTypes() {
        return this.zzio;
    }

    public List<Integer> getObjectiveTypes() {
        if (this.zzpm.isEmpty()) {
            return null;
        }
        return this.zzpm;
    }

    public List<String> getActivityNames() {
        if (this.zzll.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : this.zzll) {
            arrayList.add(zzjn.getName(intValue.intValue()));
        }
        return arrayList;
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class Builder {
        /* access modifiers changed from: private */
        public final List<DataType> zzio = new ArrayList();
        /* access modifiers changed from: private */
        public final List<Integer> zzll = new ArrayList();
        /* access modifiers changed from: private */
        public final List<Integer> zzpm = new ArrayList();

        public Builder addDataType(DataType dataType) {
            Preconditions.checkNotNull(dataType, "Attempting to use a null data type");
            if (!this.zzio.contains(dataType)) {
                this.zzio.add(dataType);
            }
            return this;
        }

        public Builder addActivity(String str) {
            int zzp = zzjn.zzp(str);
            Preconditions.checkState(zzp != 4, "Attempting to add an unknown activity");
            zzi.zza(Integer.valueOf(zzp), this.zzll);
            return this;
        }

        public Builder addObjectiveType(int i) {
            boolean z = true;
            if (!(i == 1 || i == 2 || i == 3)) {
                z = false;
            }
            Preconditions.checkState(z, "Attempting to add an invalid objective type");
            if (!this.zzpm.contains(Integer.valueOf(i))) {
                this.zzpm.add(Integer.valueOf(i));
            }
            return this;
        }

        public GoalsReadRequest build() {
            Preconditions.checkState(!this.zzio.isEmpty(), "At least one data type should be specified.");
            return new GoalsReadRequest(this);
        }
    }

    GoalsReadRequest(IBinder iBinder, List<DataType> list, List<Integer> list2, List<Integer> list3) {
        zzbm zzbm;
        if (iBinder == null) {
            zzbm = null;
        } else {
            zzbm = zzbp.zzf(iBinder);
        }
        this.zzpl = zzbm;
        this.zzio = list;
        this.zzpm = list2;
        this.zzll = list3;
    }

    private GoalsReadRequest(Builder builder) {
        this((zzbm) null, builder.zzio, builder.zzpm, builder.zzll);
    }

    public GoalsReadRequest(GoalsReadRequest goalsReadRequest, zzbm zzbm) {
        this(zzbm, goalsReadRequest.getDataTypes(), goalsReadRequest.zzpm, goalsReadRequest.zzll);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private GoalsReadRequest(zzbm zzbm, List<DataType> list, List<Integer> list2, List<Integer> list3) {
        this(zzbm == null ? null : zzbm.asBinder(), list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof GoalsReadRequest) {
                GoalsReadRequest goalsReadRequest = (GoalsReadRequest) obj;
                if (Objects.equal(this.zzio, goalsReadRequest.zzio) && Objects.equal(this.zzpm, goalsReadRequest.zzpm) && Objects.equal(this.zzll, goalsReadRequest.zzll)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzio, this.zzpm, getActivityNames());
    }

    public String toString() {
        return Objects.toStringHelper(this).add("dataTypes", this.zzio).add("objectiveTypes", this.zzpm).add("activities", getActivityNames()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zzpl.asBinder(), false);
        SafeParcelWriter.writeList(parcel, 2, getDataTypes(), false);
        SafeParcelWriter.writeList(parcel, 3, this.zzpm, false);
        SafeParcelWriter.writeList(parcel, 4, this.zzll, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
