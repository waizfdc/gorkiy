package com.google.firebase.ml.vision.objects.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class ObjectDetectorOptionsParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ObjectDetectorOptionsParcel> CREATOR = new zze();
    public final int zzbng;
    public final boolean zzbnh;
    public final boolean zzbni;

    public ObjectDetectorOptionsParcel(int i, boolean z, boolean z2) {
        this.zzbng = i;
        this.zzbnh = z;
        this.zzbni = z2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzbng);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzbnh);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbni);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
