package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzay extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzay> CREATOR = new zzax();
    private final zzcm zzok;
    private final PendingIntent zzpk;

    zzay(PendingIntent pendingIntent, IBinder iBinder) {
        zzcm zzcm;
        this.zzpk = pendingIntent;
        if (iBinder == null) {
            zzcm = null;
        } else {
            zzcm = zzcp.zzj(iBinder);
        }
        this.zzok = zzcm;
    }

    public zzay(PendingIntent pendingIntent, zzcm zzcm) {
        this.zzpk = pendingIntent;
        this.zzok = zzcm;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzpk, i, false);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 2, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(BaseGmsClient.KEY_PENDING_INTENT, this.zzpk).toString();
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof zzay) && Objects.equal(this.zzpk, ((zzay) obj).zzpk);
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzpk);
    }
}
