package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzeo;
import com.google.android.gms.internal.fitness.zzep;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzag> CREATOR = new zzaj();
    private final zzep zzpn;

    zzag(IBinder iBinder) {
        this.zzpn = zzeo.zzk(iBinder);
    }

    public zzag(zzep zzep) {
        this.zzpn = zzep;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zzpn.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
