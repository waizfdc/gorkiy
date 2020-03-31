package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzbk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbk> CREATOR = new zzbj();
    private final zzcm zzok;
    private Subscription zzqo;
    private final boolean zzqp;

    zzbk(Subscription subscription, boolean z, IBinder iBinder) {
        this.zzqo = subscription;
        this.zzqp = z;
        this.zzok = zzcp.zzj(iBinder);
    }

    public zzbk(Subscription subscription, boolean z, zzcm zzcm) {
        this.zzqo = subscription;
        this.zzqp = false;
        this.zzok = zzcm;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("subscription", this.zzqo).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzqo, i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzqp);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 3, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
