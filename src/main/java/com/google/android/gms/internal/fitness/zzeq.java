package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzeq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeq> CREATOR = new zzet();
    private final List<DataType> zzio;

    public zzeq(List<DataType> list) {
        this.zzio = list;
    }

    public final List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzio);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("dataTypes", this.zzio).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, Collections.unmodifiableList(this.zzio), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
