package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzck;
import com.google.android.gms.internal.fitness.zzcl;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbb();
    private final String name;
    private final String zzma;
    private final zzcl zzqj;

    zzbc(String str, String str2, IBinder iBinder) {
        this.name = str;
        this.zzma = str2;
        this.zzqj = zzck.zzi(iBinder);
    }

    public zzbc(String str, String str2, zzcl zzcl) {
        this.name = str;
        this.zzma = str2;
        this.zzqj = zzcl;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof zzbc) {
                zzbc zzbc = (zzbc) obj;
                if (Objects.equal(this.name, zzbc.name) && Objects.equal(this.zzma, zzbc.zzma)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.name, this.zzma);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).add(SettingsJsonConstants.APP_IDENTIFIER_KEY, this.zzma).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.name, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzma, false);
        zzcl zzcl = this.zzqj;
        SafeParcelWriter.writeIBinder(parcel, 3, zzcl == null ? null : zzcl.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
