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
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzbo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbo> CREATOR = new zzbn();
    private final DataType zzhz;
    private final DataSource zzia;
    private final zzcm zzok;

    zzbo(DataType dataType, DataSource dataSource, IBinder iBinder) {
        this(dataType, dataSource, zzcp.zzj(iBinder));
    }

    public zzbo(DataType dataType, DataSource dataSource, zzcm zzcm) {
        Preconditions.checkArgument((dataType == null) == (dataSource == null) ? false : true, "Must specify exactly one of dataType and dataSource.");
        this.zzhz = dataType;
        this.zzia = dataSource;
        this.zzok = zzcm;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzhz, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzia, i, false);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 3, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof zzbo) {
                zzbo zzbo = (zzbo) obj;
                if (Objects.equal(this.zzia, zzbo.zzia) && Objects.equal(this.zzhz, zzbo.zzhz)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzia, this.zzhz);
    }
}
