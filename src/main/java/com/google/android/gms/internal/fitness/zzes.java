package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzes extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzes> CREATOR = new zzev();
    private final DataSource zzia;

    public zzes(DataSource dataSource) {
        this.zzia = dataSource;
    }

    public final DataSource getDataSource() {
        return this.zzia;
    }

    public final String toString() {
        return String.format("ApplicationUnregistrationRequest{%s}", this.zzia);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzia, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
