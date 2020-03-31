package com.google.firebase.ml.vision.objects.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzj implements Parcelable.Creator<zzh> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzh[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int[] iArr = null;
        Integer num = null;
        Float f = null;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                iArr = SafeParcelReader.createIntArray(parcel, readHeader);
            } else if (fieldId == 2) {
                num = SafeParcelReader.readIntegerObject(parcel, readHeader);
            } else if (fieldId == 3) {
                f = SafeParcelReader.readFloatObject(parcel, readHeader);
            } else if (fieldId == 4) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                i = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzh(iArr, num, f, str, i);
    }
}
