package com.google.android.gms.measurement.internal;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public interface zzfc extends IInterface {
    List<zzkz> zza(zzm zzm, boolean z) throws RemoteException;

    List<zzv> zza(String str, String str2, zzm zzm) throws RemoteException;

    List<zzv> zza(String str, String str2, String str3) throws RemoteException;

    List<zzkz> zza(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzkz> zza(String str, String str2, boolean z, zzm zzm) throws RemoteException;

    void zza(long j, String str, String str2, String str3) throws RemoteException;

    void zza(zzan zzan, zzm zzm) throws RemoteException;

    void zza(zzan zzan, String str, String str2) throws RemoteException;

    void zza(zzkz zzkz, zzm zzm) throws RemoteException;

    void zza(zzm zzm) throws RemoteException;

    void zza(zzv zzv) throws RemoteException;

    void zza(zzv zzv, zzm zzm) throws RemoteException;

    byte[] zza(zzan zzan, String str) throws RemoteException;

    void zzb(zzm zzm) throws RemoteException;

    String zzc(zzm zzm) throws RemoteException;

    void zzd(zzm zzm) throws RemoteException;
}
