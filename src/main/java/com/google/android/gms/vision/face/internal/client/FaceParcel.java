package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public class FaceParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FaceParcel> CREATOR = new zzd();
    public final float centerX;
    public final float centerY;
    public final float height;
    public final int id;
    private final int versionCode;
    public final float width;
    public final float zzce;
    public final float zzcf;
    public final float zzcg;
    public final float zzch;
    public final float zzcz;
    public final float zzda;
    public final float zzdb;
    public final LandmarkParcel[] zzdc;
    public final zza[] zzdd;

    public FaceParcel(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, LandmarkParcel[] landmarkParcelArr, float f8, float f9, float f10, zza[] zzaArr, float f11) {
        this.versionCode = i;
        this.id = i2;
        this.centerX = f;
        this.centerY = f2;
        this.width = f3;
        this.height = f4;
        this.zzcz = f5;
        this.zzda = f6;
        this.zzdb = f7;
        this.zzdc = landmarkParcelArr;
        this.zzce = f8;
        this.zzcf = f9;
        this.zzcg = f10;
        this.zzdd = zzaArr;
        this.zzch = f11;
    }

    public FaceParcel(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, LandmarkParcel[] landmarkParcelArr, float f7, float f8, float f9) {
        this(i, i2, f, f2, f3, f4, f5, f6, 0.0f, landmarkParcelArr, f7, f8, f9, new zza[0], -1.0f);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.id);
        SafeParcelWriter.writeFloat(parcel, 3, this.centerX);
        SafeParcelWriter.writeFloat(parcel, 4, this.centerY);
        SafeParcelWriter.writeFloat(parcel, 5, this.width);
        SafeParcelWriter.writeFloat(parcel, 6, this.height);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzcz);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzda);
        SafeParcelWriter.writeTypedArray(parcel, 9, this.zzdc, i, false);
        SafeParcelWriter.writeFloat(parcel, 10, this.zzce);
        SafeParcelWriter.writeFloat(parcel, 11, this.zzcf);
        SafeParcelWriter.writeFloat(parcel, 12, this.zzcg);
        SafeParcelWriter.writeTypedArray(parcel, 13, this.zzdd, i, false);
        SafeParcelWriter.writeFloat(parcel, 14, this.zzdb);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzch);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
