package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.fitness.zzbk;
import com.google.android.gms.internal.fitness.zzbl;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class DataTypeCreateRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new zzr();
    private final String name;
    private final List<Field> zzjv;
    private final zzbl zzpj;

    DataTypeCreateRequest(String str, List<Field> list, IBinder iBinder) {
        this.name = str;
        this.zzjv = Collections.unmodifiableList(list);
        this.zzpj = zzbk.zze(iBinder);
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class Builder {
        /* access modifiers changed from: private */
        public String name;
        /* access modifiers changed from: private */
        public List<Field> zzjv = new ArrayList();

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder addField(Field field) {
            if (!this.zzjv.contains(field)) {
                this.zzjv.add(field);
            }
            return this;
        }

        public Builder addField(String str, int i) {
            Preconditions.checkArgument(str != null && !str.isEmpty(), "Invalid name specified");
            return addField(Field.zza(str, i));
        }

        public DataTypeCreateRequest build() {
            Preconditions.checkState(this.name != null, "Must set the name");
            Preconditions.checkState(!this.zzjv.isEmpty(), "Must specify the data fields");
            return new DataTypeCreateRequest(this);
        }
    }

    private DataTypeCreateRequest(Builder builder) {
        this(builder.name, builder.zzjv, (zzbl) null);
    }

    public DataTypeCreateRequest(DataTypeCreateRequest dataTypeCreateRequest, zzbl zzbl) {
        this(dataTypeCreateRequest.name, dataTypeCreateRequest.zzjv, zzbl);
    }

    private DataTypeCreateRequest(String str, List<Field> list, zzbl zzbl) {
        this.name = str;
        this.zzjv = Collections.unmodifiableList(list);
        this.zzpj = zzbl;
    }

    public String getName() {
        return this.name;
    }

    public List<Field> getFields() {
        return this.zzjv;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof DataTypeCreateRequest) {
                DataTypeCreateRequest dataTypeCreateRequest = (DataTypeCreateRequest) obj;
                if (Objects.equal(this.name, dataTypeCreateRequest.name) && Objects.equal(this.zzjv, dataTypeCreateRequest.zzjv)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.name, this.zzjv);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).add("fields", this.zzjv).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeTypedList(parcel, 2, getFields(), false);
        zzbl zzbl = this.zzpj;
        SafeParcelWriter.writeIBinder(parcel, 3, zzbl == null ? null : zzbl.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
