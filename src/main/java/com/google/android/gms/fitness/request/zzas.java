package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.zzt;
import com.google.android.gms.fitness.data.zzu;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzas> CREATOR = new zzar();
    private final zzcm zzok;
    private final PendingIntent zzpk;
    private final zzu zzpt;

    zzas(IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2) {
        zzu zzu;
        if (iBinder == null) {
            zzu = null;
        } else {
            zzu = zzt.zza(iBinder);
        }
        this.zzpt = zzu;
        this.zzpk = pendingIntent;
        this.zzok = zzcp.zzj(iBinder2);
    }

    public zzas(zzu zzu, PendingIntent pendingIntent, zzcm zzcm) {
        this.zzpt = zzu;
        this.zzpk = pendingIntent;
        this.zzok = zzcm;
    }

    public final String toString() {
        return String.format("SensorUnregistrationRequest{%s}", this.zzpt);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzu zzu = this.zzpt;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 1, zzu == null ? null : zzu.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzpk, i, false);
        zzcm zzcm = this.zzok;
        if (zzcm != null) {
            iBinder = zzcm.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
