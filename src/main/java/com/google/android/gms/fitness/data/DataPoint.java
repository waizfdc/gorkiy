package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.fitness.zzjn;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class DataPoint extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DataPoint> CREATOR = new zzg();
    private final DataSource zzia;
    private long zzit;
    private long zziu;
    private final Value[] zziv;
    private DataSource zziw;
    private long zzix;
    private long zziy;

    public DataPoint(DataSource dataSource, long j, long j2, Value[] valueArr, DataSource dataSource2, long j3, long j4) {
        this.zzia = dataSource;
        this.zziw = dataSource2;
        this.zzit = j;
        this.zziu = j2;
        this.zziv = valueArr;
        this.zzix = j3;
        this.zziy = j4;
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class Builder {
        private final DataPoint zziz;
        private boolean zzja;

        private Builder(DataSource dataSource) {
            this.zzja = false;
            this.zziz = DataPoint.create(dataSource);
        }

        public DataPoint build() {
            Preconditions.checkState(!this.zzja, "DataPoint#build should not be called multiple times.");
            this.zzja = true;
            return this.zziz;
        }

        public Builder setTimestamp(long j, TimeUnit timeUnit) {
            Preconditions.checkState(!this.zzja, "Builder should not be mutated after calling #build.");
            this.zziz.setTimestamp(j, timeUnit);
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            Preconditions.checkState(!this.zzja, "Builder should not be mutated after calling #build.");
            this.zziz.setTimeInterval(j, j2, timeUnit);
            return this;
        }

        public Builder setActivityField(Field field, String str) {
            Preconditions.checkState(!this.zzja, "Builder should not be mutated after calling #build.");
            this.zziz.getValue(field).setInt(zzjn.zzp(str));
            return this;
        }

        public Builder setField(Field field, int i) {
            Preconditions.checkState(!this.zzja, "Builder should not be mutated after calling #build.");
            this.zziz.getValue(field).setInt(i);
            return this;
        }

        public Builder setField(Field field, float f) {
            Preconditions.checkState(!this.zzja, "Builder should not be mutated after calling #build.");
            this.zziz.getValue(field).setFloat(f);
            return this;
        }

        public Builder setField(Field field, String str) {
            Preconditions.checkState(!this.zzja, "Builder should not be mutated after calling #build.");
            this.zziz.getValue(field).setString(str);
            return this;
        }

        public Builder setField(Field field, Map<String, Float> map) {
            Preconditions.checkState(!this.zzja, "Builder should not be mutated after calling #build.");
            this.zziz.getValue(field).zza(map);
            return this;
        }

        public Builder setFloatValues(float... fArr) {
            Preconditions.checkState(!this.zzja, "Builder should not be mutated after calling #build.");
            this.zziz.setFloatValues(fArr);
            return this;
        }

        public Builder setIntValues(int... iArr) {
            Preconditions.checkState(!this.zzja, "Builder should not be mutated after calling #build.");
            this.zziz.setIntValues(iArr);
            return this;
        }
    }

    DataPoint(List<DataSource> list, RawDataPoint rawDataPoint) {
        this(zza(list, rawDataPoint.zzs()), zza(list, rawDataPoint.zzt()), rawDataPoint);
    }

    private DataPoint(DataSource dataSource, DataSource dataSource2, RawDataPoint rawDataPoint) {
        this(dataSource, rawDataPoint.zzq(), rawDataPoint.zzr(), rawDataPoint.zzf(), dataSource2, rawDataPoint.zzh(), rawDataPoint.zzi());
    }

    private static DataSource zza(List<DataSource> list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    private DataPoint(DataSource dataSource) {
        this.zzia = (DataSource) Preconditions.checkNotNull(dataSource, "Data source cannot be null");
        List<Field> fields = dataSource.getDataType().getFields();
        this.zziv = new Value[fields.size()];
        int i = 0;
        for (Field format : fields) {
            this.zziv[i] = new Value(format.getFormat());
            i++;
        }
    }

    public static Builder builder(DataSource dataSource) {
        Preconditions.checkNotNull(dataSource, "DataSource should be specified");
        return new Builder(dataSource);
    }

    @Deprecated
    public static DataPoint create(DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    public static DataPoint extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (DataPoint) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
    }

    @Deprecated
    public final DataPoint setTimestamp(long j, TimeUnit timeUnit) {
        this.zzit = timeUnit.toNanos(j);
        return this;
    }

    @Deprecated
    public final DataPoint setTimeInterval(long j, long j2, TimeUnit timeUnit) {
        this.zziu = timeUnit.toNanos(j);
        this.zzit = timeUnit.toNanos(j2);
        return this;
    }

    public final Value zzb(int i) {
        DataType dataType = getDataType();
        Preconditions.checkArgument(i >= 0 && i < dataType.getFields().size(), "fieldIndex %s is out of range for %s", Integer.valueOf(i), dataType);
        return this.zziv[i];
    }

    public final Value getValue(Field field) {
        return this.zziv[getDataType().indexOf(field)];
    }

    public final Value[] zzf() {
        return this.zziv;
    }

    @Deprecated
    public final DataPoint setFloatValues(float... fArr) {
        zzc(fArr.length);
        for (int i = 0; i < fArr.length; i++) {
            this.zziv[i].setFloat(fArr[i]);
        }
        return this;
    }

    @Deprecated
    public final DataPoint setIntValues(int... iArr) {
        zzc(iArr.length);
        for (int i = 0; i < iArr.length; i++) {
            this.zziv[i].setInt(iArr[i]);
        }
        return this;
    }

    private final void zzc(int i) {
        List<Field> fields = getDataType().getFields();
        int size = fields.size();
        Preconditions.checkArgument(i == size, "Attempting to insert %s values, but needed %s: %s", Integer.valueOf(i), Integer.valueOf(size), fields);
    }

    public final DataType getDataType() {
        return this.zzia.getDataType();
    }

    public final DataSource getDataSource() {
        return this.zzia;
    }

    public final DataSource getOriginalDataSource() {
        DataSource dataSource = this.zziw;
        return dataSource != null ? dataSource : this.zzia;
    }

    public final DataSource zzg() {
        return this.zziw;
    }

    public final long getTimestamp(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzit, TimeUnit.NANOSECONDS);
    }

    public final long zzh() {
        return this.zzix;
    }

    public final long zzi() {
        return this.zziy;
    }

    public final long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zziu, TimeUnit.NANOSECONDS);
    }

    public final long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzit, TimeUnit.NANOSECONDS);
    }

    public final void zzj() {
        Preconditions.checkArgument(getDataType().getName().equals(getDataSource().getDataType().getName()), "Conflicting data types found %s vs %s", getDataType(), getDataType());
        Preconditions.checkArgument(this.zzit > 0, "Data point does not have the timestamp set: %s", this);
        Preconditions.checkArgument(this.zziu <= this.zzit, "Data point with start time greater than end time found: %s", this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataPoint)) {
            return false;
        }
        DataPoint dataPoint = (DataPoint) obj;
        return Objects.equal(this.zzia, dataPoint.zzia) && this.zzit == dataPoint.zzit && this.zziu == dataPoint.zziu && Arrays.equals(this.zziv, dataPoint.zziv) && Objects.equal(getOriginalDataSource(), dataPoint.getOriginalDataSource());
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzia, Long.valueOf(this.zzit), Long.valueOf(this.zziu));
    }

    public final String toString() {
        Object[] objArr = new Object[7];
        objArr[0] = Arrays.toString(this.zziv);
        objArr[1] = Long.valueOf(this.zziu);
        objArr[2] = Long.valueOf(this.zzit);
        objArr[3] = Long.valueOf(this.zzix);
        objArr[4] = Long.valueOf(this.zziy);
        objArr[5] = this.zzia.toDebugString();
        DataSource dataSource = this.zziw;
        objArr[6] = dataSource != null ? dataSource.toDebugString() : "N/A";
        return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataSource(), i, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzit);
        SafeParcelWriter.writeLong(parcel, 4, this.zziu);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zziv, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zziw, i, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzix);
        SafeParcelWriter.writeLong(parcel, 8, this.zziy);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
