package com.google.firebase.ml.vision.automl.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class OnDeviceAutoMLImageLabelerOptionsParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<OnDeviceAutoMLImageLabelerOptionsParcel> CREATOR = new zzm();
    public final float zzbix;
    public final String zzbiy;
    public final String zzbiz;
    public final String zzbja;

    public OnDeviceAutoMLImageLabelerOptionsParcel(float f, String str, String str2, String str3) {
        this.zzbix = f;
        this.zzbiy = str;
        this.zzbiz = str2;
        this.zzbja = str3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 1, this.zzbix);
        SafeParcelWriter.writeString(parcel, 2, this.zzbiy, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbiz, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzbja, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
