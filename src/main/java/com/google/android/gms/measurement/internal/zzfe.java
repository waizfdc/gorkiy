package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzb;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzfe extends zza implements zzfc {
    zzfe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void zza(zzan zzan, zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzan);
        zzb.zza(a_, zzm);
        zzb(1, a_);
    }

    public final void zza(zzkz zzkz, zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzkz);
        zzb.zza(a_, zzm);
        zzb(2, a_);
    }

    public final void zza(zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzm);
        zzb(4, a_);
    }

    public final void zza(zzan zzan, String str, String str2) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzan);
        a_.writeString(str);
        a_.writeString(str2);
        zzb(5, a_);
    }

    public final void zzb(zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzm);
        zzb(6, a_);
    }

    public final List<zzkz> zza(zzm zzm, boolean z) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzm);
        zzb.zza(a_, z);
        Parcel zza = zza(7, a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzkz.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final byte[] zza(zzan zzan, String str) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzan);
        a_.writeString(str);
        Parcel zza = zza(9, a_);
        byte[] createByteArray = zza.createByteArray();
        zza.recycle();
        return createByteArray;
    }

    public final void zza(long j, String str, String str2, String str3) throws RemoteException {
        Parcel a_ = a_();
        a_.writeLong(j);
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        zzb(10, a_);
    }

    public final String zzc(zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzm);
        Parcel zza = zza(11, a_);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void zza(zzv zzv, zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzv);
        zzb.zza(a_, zzm);
        zzb(12, a_);
    }

    public final void zza(zzv zzv) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzv);
        zzb(13, a_);
    }

    public final List<zzkz> zza(String str, String str2, boolean z, zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, z);
        zzb.zza(a_, zzm);
        Parcel zza = zza(14, a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzkz.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzkz> zza(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        zzb.zza(a_, z);
        Parcel zza = zza(15, a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzkz.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzv> zza(String str, String str2, zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, zzm);
        Parcel zza = zza(16, a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzv.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzv> zza(String str, String str2, String str3) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        Parcel zza = zza(17, a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzv.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final void zzd(zzm zzm) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzm);
        zzb(18, a_);
    }
}
