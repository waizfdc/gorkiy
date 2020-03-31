package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new zzaf();
    private final Session zzii;
    private final DataSet zzjd;

    public zzad(Session session, DataSet dataSet) {
        this.zzii = session;
        this.zzjd = dataSet;
    }

    public final Session getSession() {
        return this.zzii;
    }

    public final DataSet getDataSet() {
        return this.zzjd;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzad)) {
            return false;
        }
        zzad zzad = (zzad) obj;
        return Objects.equal(this.zzii, zzad.zzii) && Objects.equal(this.zzjd, zzad.zzjd);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzii, this.zzjd);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(SettingsJsonConstants.SESSION_KEY, this.zzii).add("dataSet", this.zzjd).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzii, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzjd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
