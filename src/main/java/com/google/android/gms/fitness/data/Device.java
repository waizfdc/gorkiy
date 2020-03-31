package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzj;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class Device extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Device> CREATOR = new zzo();
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_HEAD_MOUNTED = 6;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    private final int type;
    private final String zzkd;
    private final String zzke;
    private final String zzkf;
    private final int zzkg;

    public static Device getLocalDevice(Context context) {
        int zza = zzj.zza(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, Settings.Secure.getString(context.getContentResolver(), "android_id"), zza, 2);
    }

    public Device(String str, String str2, String str3, int i) {
        this(str, str2, str3, i, 0);
    }

    public Device(String str, String str2, String str3, int i, int i2) {
        this.zzkd = (String) Preconditions.checkNotNull(str);
        this.zzke = (String) Preconditions.checkNotNull(str2);
        if (str3 != null) {
            this.zzkf = str3;
            this.type = i;
            this.zzkg = i2;
            return;
        }
        throw new IllegalStateException("Device UID is null.");
    }

    public final String getManufacturer() {
        return this.zzkd;
    }

    public final String getModel() {
        return this.zzke;
    }

    public final String getUid() {
        return this.zzkf;
    }

    public final int getType() {
        return this.type;
    }

    /* access modifiers changed from: package-private */
    public final String getStreamIdentifier() {
        return String.format("%s:%s:%s", this.zzkd, this.zzke, this.zzkf);
    }

    public final String toString() {
        return String.format("Device{%s:%s:%s}", getStreamIdentifier(), Integer.valueOf(this.type), Integer.valueOf(this.zzkg));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        return Objects.equal(this.zzkd, device.zzkd) && Objects.equal(this.zzke, device.zzke) && Objects.equal(this.zzkf, device.zzkf) && this.type == device.type && this.zzkg == device.zzkg;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzkd, this.zzke, this.zzkf, Integer.valueOf(this.type));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getManufacturer(), false);
        SafeParcelWriter.writeString(parcel, 2, getModel(), false);
        SafeParcelWriter.writeString(parcel, 4, getUid(), false);
        SafeParcelWriter.writeInt(parcel, 5, getType());
        SafeParcelWriter.writeInt(parcel, 6, this.zzkg);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
