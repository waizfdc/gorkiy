package com.google.android.gms.vision.label.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-vision-image-label@@18.0.1 */
public class ImageLabelerOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ImageLabelerOptions> CREATOR = new zzg();
    private int zzds;
    public int zzdt;
    public float zzdu;
    public int zzdv;

    public static int zza(String str) {
        if (str.equals(Locale.ENGLISH.getLanguage())) {
        }
        return 1;
    }

    public ImageLabelerOptions(int i, int i2, float f, int i3) {
        if (i == 1) {
            this.zzds = i;
            this.zzdt = i2;
            this.zzdu = f;
            this.zzdv = i3;
            return;
        }
        throw new IllegalArgumentException("Unknown language.");
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzds);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdt);
        SafeParcelWriter.writeFloat(parcel, 4, this.zzdu);
        SafeParcelWriter.writeInt(parcel, 5, this.zzdv);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
