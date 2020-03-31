package com.google.android.gms.fitness.request;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzap implements Parcelable.Creator<zzao> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzao[i];
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r22) {
        /*
            r21 = this;
            r0 = r22
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r22)
            r2 = 0
            r4 = 0
            r5 = 0
            r10 = r2
            r12 = r10
            r15 = r12
            r18 = r15
            r7 = r4
            r8 = r7
            r9 = r8
            r14 = r9
            r20 = r14
            r17 = r5
        L_0x0017:
            int r2 = r22.dataPosition()
            if (r2 >= r1) goto L_0x006d
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r22)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x0063;
                case 2: goto L_0x0059;
                case 3: goto L_0x0054;
                case 4: goto L_0x0028;
                case 5: goto L_0x0028;
                case 6: goto L_0x004f;
                case 7: goto L_0x004a;
                case 8: goto L_0x0040;
                case 9: goto L_0x003b;
                case 10: goto L_0x0036;
                case 11: goto L_0x0028;
                case 12: goto L_0x0031;
                case 13: goto L_0x002c;
                default: goto L_0x0028;
            }
        L_0x0028:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0017
        L_0x002c:
            android.os.IBinder r20 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x0017
        L_0x0031:
            long r18 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0017
        L_0x0036:
            int r17 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0017
        L_0x003b:
            long r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0017
        L_0x0040:
            android.os.Parcelable$Creator r3 = android.app.PendingIntent.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r14 = r2
            android.app.PendingIntent r14 = (android.app.PendingIntent) r14
            goto L_0x0017
        L_0x004a:
            long r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0017
        L_0x004f:
            long r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0017
        L_0x0054:
            android.os.IBinder r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x0017
        L_0x0059:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataType> r3 = com.google.android.gms.fitness.data.DataType.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r8 = r2
            com.google.android.gms.fitness.data.DataType r8 = (com.google.android.gms.fitness.data.DataType) r8
            goto L_0x0017
        L_0x0063:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataSource> r3 = com.google.android.gms.fitness.data.DataSource.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r7 = r2
            com.google.android.gms.fitness.data.DataSource r7 = (com.google.android.gms.fitness.data.DataSource) r7
            goto L_0x0017
        L_0x006d:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.fitness.request.zzao r0 = new com.google.android.gms.fitness.request.zzao
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r12, r14, r15, r17, r18, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.request.zzap.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
