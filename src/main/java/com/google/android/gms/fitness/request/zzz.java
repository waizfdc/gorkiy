package com.google.android.gms.fitness.request;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzz implements Parcelable.Creator<DataUpdateRequest> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new DataUpdateRequest[i];
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r12) {
        /*
            r11 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r12)
            r1 = 0
            r2 = 0
            r9 = r1
            r10 = r9
            r5 = r2
            r7 = r5
        L_0x000b:
            int r1 = r12.dataPosition()
            if (r1 >= r0) goto L_0x0042
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r12)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r3 = 1
            if (r2 == r3) goto L_0x003d
            r3 = 2
            if (r2 == r3) goto L_0x0038
            r3 = 3
            if (r2 == r3) goto L_0x002e
            r3 = 4
            if (r2 == r3) goto L_0x0029
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r12, r1)
            goto L_0x000b
        L_0x0029:
            android.os.IBinder r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r12, r1)
            goto L_0x000b
        L_0x002e:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataSet> r2 = com.google.android.gms.fitness.data.DataSet.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r12, r1, r2)
            r9 = r1
            com.google.android.gms.fitness.data.DataSet r9 = (com.google.android.gms.fitness.data.DataSet) r9
            goto L_0x000b
        L_0x0038:
            long r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r12, r1)
            goto L_0x000b
        L_0x003d:
            long r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r12, r1)
            goto L_0x000b
        L_0x0042:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r12, r0)
            com.google.android.gms.fitness.request.DataUpdateRequest r12 = new com.google.android.gms.fitness.request.DataUpdateRequest
            r4 = r12
            r4.<init>(r5, r7, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.request.zzz.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
