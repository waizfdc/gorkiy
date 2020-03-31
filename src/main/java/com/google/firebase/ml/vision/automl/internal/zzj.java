package com.google.firebase.ml.vision.automl.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzl();
    public final String text;
    public final String zzbiv;
    public final float zzbiw;

    public zzj(String str, String str2, float f) {
        this.zzbiv = str;
        this.text = str2;
        this.zzbiw = f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzbiv, false);
        SafeParcelWriter.writeString(parcel, 2, this.text, false);
        SafeParcelWriter.writeFloat(parcel, 3, this.zzbiw);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzj = (zzj) obj;
        return Objects.equal(this.zzbiv, zzj.zzbiv) && Objects.equal(this.text, zzj.text) && Float.compare(this.zzbiw, zzj.zzbiw) == 0;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbiv, this.text, Float.valueOf(this.zzbiw));
    }
}
