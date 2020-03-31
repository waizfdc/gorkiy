package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb();
    public static final zzc zzil = new zzc("com.google.android.gms");
    private final String packageName;

    public static zzc zza(String str) {
        if ("com.google.android.gms".equals(str)) {
            return zzil;
        }
        return new zzc(str);
    }

    public zzc(String str) {
        this.packageName = (String) Preconditions.checkNotNull(str);
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzc)) {
            return false;
        }
        return this.packageName.equals(((zzc) obj).packageName);
    }

    public final int hashCode() {
        return this.packageName.hashCode();
    }

    public final String toString() {
        return String.format("Application{%s}", this.packageName);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.packageName, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
