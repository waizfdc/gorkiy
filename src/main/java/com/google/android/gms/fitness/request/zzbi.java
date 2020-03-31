package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzcm;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzbi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbi> CREATOR = new zzbh();
    private final zzcm zzok;
    private final zzaf zzqk;

    /* JADX WARN: Type inference failed for: r0v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzbi(android.os.IBinder r3, android.os.IBinder r4) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 != 0) goto L_0x0007
            r3 = 0
            goto L_0x001b
        L_0x0007:
            java.lang.String r0 = "com.google.android.gms.fitness.request.IBleScanCallback"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.fitness.request.zzaf
            if (r1 == 0) goto L_0x0015
            r3 = r0
            com.google.android.gms.fitness.request.zzaf r3 = (com.google.android.gms.fitness.request.zzaf) r3
            goto L_0x001b
        L_0x0015:
            com.google.android.gms.fitness.request.zzah r0 = new com.google.android.gms.fitness.request.zzah
            r0.<init>(r3)
            r3 = r0
        L_0x001b:
            r2.zzqk = r3
            com.google.android.gms.internal.fitness.zzcm r3 = com.google.android.gms.internal.fitness.zzcp.zzj(r4)
            r2.zzok = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.request.zzbi.<init>(android.os.IBinder, android.os.IBinder):void");
    }

    public zzbi(zzaf zzaf, zzcm zzcm) {
        this.zzqk = zzaf;
        this.zzok = zzcm;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zzqk.asBinder(), false);
        zzcm zzcm = this.zzok;
        SafeParcelWriter.writeIBinder(parcel, 2, zzcm == null ? null : zzcm.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
