package com.google.android.gms.internal.firebase_ml;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzrk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzrk> CREATOR = new zzrj();
    public final int height;
    private final int id;
    public final int rotation;
    public final int width;
    public final long zzblj;

    public zzrk(int i, int i2, int i3, long j, int i4) {
        this.width = i;
        this.height = i2;
        this.id = i3;
        this.zzblj = j;
        this.rotation = i4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.width);
        SafeParcelWriter.writeInt(parcel, 2, this.height);
        SafeParcelWriter.writeInt(parcel, 3, this.id);
        SafeParcelWriter.writeLong(parcel, 4, this.zzblj);
        SafeParcelWriter.writeInt(parcel, 5, this.rotation);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Matrix zzpy() {
        if (this.rotation == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate(((float) (-this.width)) / 2.0f, ((float) (-this.height)) / 2.0f);
        matrix.postRotate((float) (this.rotation * 90));
        boolean z = this.rotation % 2 != 0;
        matrix.postTranslate(((float) (z ? this.height : this.width)) / 2.0f, ((float) (z ? this.width : this.height)) / 2.0f);
        return matrix;
    }
}
