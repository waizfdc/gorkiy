package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzi;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class RawDataPoint extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RawDataPoint> CREATOR = new zzz();
    private final long zziu;
    private final Value[] zziv;
    private final long zzix;
    private final long zziy;
    private final long zzlw;
    private final int zzlx;
    private final int zzly;

    public RawDataPoint(long j, long j2, Value[] valueArr, int i, int i2, long j3, long j4) {
        this.zzlw = j;
        this.zziu = j2;
        this.zzlx = i;
        this.zzly = i2;
        this.zzix = j3;
        this.zziy = j4;
        this.zziv = valueArr;
    }

    RawDataPoint(DataPoint dataPoint, List<DataSource> list) {
        this.zzlw = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
        this.zziu = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
        this.zziv = dataPoint.zzf();
        this.zzlx = zzi.zza(dataPoint.getDataSource(), list);
        this.zzly = zzi.zza(dataPoint.zzg(), list);
        this.zzix = dataPoint.zzh();
        this.zziy = dataPoint.zzi();
    }

    public final long zzq() {
        return this.zzlw;
    }

    public final long zzr() {
        return this.zziu;
    }

    public final Value[] zzf() {
        return this.zziv;
    }

    public final int zzs() {
        return this.zzlx;
    }

    public final int zzt() {
        return this.zzly;
    }

    public final long zzh() {
        return this.zzix;
    }

    public final long zzi() {
        return this.zziy;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawDataPoint)) {
            return false;
        }
        RawDataPoint rawDataPoint = (RawDataPoint) obj;
        return this.zzlw == rawDataPoint.zzlw && this.zziu == rawDataPoint.zziu && Arrays.equals(this.zziv, rawDataPoint.zziv) && this.zzlx == rawDataPoint.zzlx && this.zzly == rawDataPoint.zzly && this.zzix == rawDataPoint.zzix;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzlw), Long.valueOf(this.zziu));
    }

    public final String toString() {
        return String.format(Locale.US, "RawDataPoint{%s@[%s, %s](%d,%d)}", Arrays.toString(this.zziv), Long.valueOf(this.zziu), Long.valueOf(this.zzlw), Integer.valueOf(this.zzlx), Integer.valueOf(this.zzly));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzlw);
        SafeParcelWriter.writeLong(parcel, 2, this.zziu);
        SafeParcelWriter.writeTypedArray(parcel, 3, this.zziv, i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzlx);
        SafeParcelWriter.writeInt(parcel, 5, this.zzly);
        SafeParcelWriter.writeLong(parcel, 6, this.zzix);
        SafeParcelWriter.writeLong(parcel, 7, this.zziy);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
