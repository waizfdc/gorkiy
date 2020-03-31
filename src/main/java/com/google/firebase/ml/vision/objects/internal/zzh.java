package com.google.firebase.ml.vision.objects.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzj();
    public final int category;
    public final Float confidence;
    private final String zzbiv;
    public final Integer zzbnf;
    public final int[] zzbnt;

    public zzh(int[] iArr, Integer num, Float f, String str, int i) {
        this.zzbnt = iArr;
        this.zzbnf = num;
        this.confidence = f;
        this.zzbiv = str;
        this.category = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntArray(parcel, 1, this.zzbnt, false);
        SafeParcelWriter.writeIntegerObject(parcel, 2, this.zzbnf, false);
        SafeParcelWriter.writeFloatObject(parcel, 3, this.confidence, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzbiv, false);
        SafeParcelWriter.writeInt(parcel, 5, this.category);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
