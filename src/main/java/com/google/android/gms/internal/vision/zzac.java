package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new zzab();
    private final float zzdo;
    public final String zzec;
    public final zzaj[] zzeh;
    public final zzw zzei;
    private final zzw zzej;
    private final zzw zzek;
    public final String zzel;
    private final int zzem;
    public final boolean zzen;
    public final int zzeo;
    public final int zzep;

    public zzac(zzaj[] zzajArr, zzw zzw, zzw zzw2, zzw zzw3, String str, float f, String str2, int i, boolean z, int i2, int i3) {
        this.zzeh = zzajArr;
        this.zzei = zzw;
        this.zzej = zzw2;
        this.zzek = zzw3;
        this.zzel = str;
        this.zzdo = f;
        this.zzec = str2;
        this.zzem = i;
        this.zzen = z;
        this.zzeo = i2;
        this.zzep = i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzeh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzei, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzej, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzek, i, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzel, false);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzdo);
        SafeParcelWriter.writeString(parcel, 8, this.zzec, false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzem);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzen);
        SafeParcelWriter.writeInt(parcel, 11, this.zzeo);
        SafeParcelWriter.writeInt(parcel, 12, this.zzep);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
