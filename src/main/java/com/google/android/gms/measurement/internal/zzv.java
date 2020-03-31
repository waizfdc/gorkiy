package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new zzy();
    public String zza;
    public String zzb;
    public zzkz zzc;
    public long zzd;
    public boolean zze;
    public String zzf;
    public zzan zzg;
    public long zzh;
    public zzan zzi;
    public long zzj;
    public zzan zzk;

    zzv(zzv zzv) {
        Preconditions.checkNotNull(zzv);
        this.zza = zzv.zza;
        this.zzb = zzv.zzb;
        this.zzc = zzv.zzc;
        this.zzd = zzv.zzd;
        this.zze = zzv.zze;
        this.zzf = zzv.zzf;
        this.zzg = zzv.zzg;
        this.zzh = zzv.zzh;
        this.zzi = zzv.zzi;
        this.zzj = zzv.zzj;
        this.zzk = zzv.zzk;
    }

    zzv(String str, String str2, zzkz zzkz, long j, boolean z, String str3, zzan zzan, long j2, zzan zzan2, long j3, zzan zzan3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzkz;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzan;
        this.zzh = j2;
        this.zzi = zzan2;
        this.zzj = j3;
        this.zzk = zzan3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
