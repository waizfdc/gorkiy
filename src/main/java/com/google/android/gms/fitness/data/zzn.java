package com.google.android.gms.fitness.data;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzn implements Parcelable.Creator<DataUpdateNotification> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new DataUpdateNotification[i];
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r14) {
        /*
            r13 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r14)
            r1 = 0
            r2 = 0
            r4 = 0
            r11 = r1
            r12 = r11
            r6 = r2
            r8 = r6
            r10 = r4
        L_0x000d:
            int r1 = r14.dataPosition()
            if (r1 >= r0) goto L_0x0051
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r14)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r3 = 1
            if (r2 == r3) goto L_0x004c
            r3 = 2
            if (r2 == r3) goto L_0x0047
            r3 = 3
            if (r2 == r3) goto L_0x0042
            r3 = 4
            if (r2 == r3) goto L_0x0038
            r3 = 5
            if (r2 == r3) goto L_0x002e
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r14, r1)
            goto L_0x000d
        L_0x002e:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataType> r2 = com.google.android.gms.fitness.data.DataType.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r14, r1, r2)
            r12 = r1
            com.google.android.gms.fitness.data.DataType r12 = (com.google.android.gms.fitness.data.DataType) r12
            goto L_0x000d
        L_0x0038:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataSource> r2 = com.google.android.gms.fitness.data.DataSource.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r14, r1, r2)
            r11 = r1
            com.google.android.gms.fitness.data.DataSource r11 = (com.google.android.gms.fitness.data.DataSource) r11
            goto L_0x000d
        L_0x0042:
            int r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x000d
        L_0x0047:
            long r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r14, r1)
            goto L_0x000d
        L_0x004c:
            long r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r14, r1)
            goto L_0x000d
        L_0x0051:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r14, r0)
            com.google.android.gms.fitness.data.DataUpdateNotification r14 = new com.google.android.gms.fitness.data.DataUpdateNotification
            r5 = r14
            r5.<init>(r6, r8, r10, r11, r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.zzn.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
