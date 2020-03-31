package com.google.android.gms.fitness.service;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzb implements Parcelable.Creator<FitnessSensorServiceRequest> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new FitnessSensorServiceRequest[i];
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r12) {
        /*
            r11 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r12)
            r1 = 0
            r3 = 0
            r7 = r1
            r9 = r7
            r5 = r3
            r6 = r5
        L_0x000b:
            int r1 = r12.dataPosition()
            if (r1 >= r0) goto L_0x0042
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r12)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r3 = 1
            if (r2 == r3) goto L_0x0038
            r3 = 2
            if (r2 == r3) goto L_0x0033
            r3 = 3
            if (r2 == r3) goto L_0x002e
            r3 = 4
            if (r2 == r3) goto L_0x0029
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r12, r1)
            goto L_0x000b
        L_0x0029:
            long r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r12, r1)
            goto L_0x000b
        L_0x002e:
            long r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r12, r1)
            goto L_0x000b
        L_0x0033:
            android.os.IBinder r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r12, r1)
            goto L_0x000b
        L_0x0038:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataSource> r2 = com.google.android.gms.fitness.data.DataSource.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r12, r1, r2)
            r5 = r1
            com.google.android.gms.fitness.data.DataSource r5 = (com.google.android.gms.fitness.data.DataSource) r5
            goto L_0x000b
        L_0x0042:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r12, r0)
            com.google.android.gms.fitness.service.FitnessSensorServiceRequest r12 = new com.google.android.gms.fitness.service.FitnessSensorServiceRequest
            r4 = r12
            r4.<init>(r5, r6, r7, r9)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.service.zzb.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
