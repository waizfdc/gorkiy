package com.google.firebase.ml.vision.barcode.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class BarcodeDetectorOptionsParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BarcodeDetectorOptionsParcel> CREATOR = new zzb();
    public final int zzbjp;

    public BarcodeDetectorOptionsParcel(int i) {
        this.zzbjp = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzbjp);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
