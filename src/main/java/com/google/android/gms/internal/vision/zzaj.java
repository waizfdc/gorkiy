package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new zzam();
    private final float zzdo;
    public final String zzec;
    public final zzw zzei;
    private final zzw zzej;
    public final String zzel;
    private final zzag[] zzer;
    private final boolean zzes;

    public zzaj(zzag[] zzagArr, zzw zzw, zzw zzw2, String str, float f, String str2, boolean z) {
        this.zzer = zzagArr;
        this.zzei = zzw;
        this.zzej = zzw2;
        this.zzel = str;
        this.zzdo = f;
        this.zzec = str2;
        this.zzes = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzer, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzei, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzej, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzel, false);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzdo);
        SafeParcelWriter.writeString(parcel, 7, this.zzec, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzes);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
