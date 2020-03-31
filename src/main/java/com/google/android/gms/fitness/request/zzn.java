package com.google.android.gms.fitness.request;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzn implements Parcelable.Creator<DataReadRequest> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new DataReadRequest[i];
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r28) {
        /*
            r27 = this;
            r0 = r28
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r28)
            r2 = 0
            r4 = 0
            r5 = 0
            r9 = r2
            r11 = r9
            r16 = r11
            r15 = r4
            r19 = r15
            r20 = r19
            r21 = r20
            r7 = r5
            r8 = r7
            r13 = r8
            r14 = r13
            r18 = r14
            r22 = r18
            r23 = r22
            r24 = r23
            r25 = r24
            r26 = r25
        L_0x0025:
            int r2 = r28.dataPosition()
            if (r2 >= r1) goto L_0x009f
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r28)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x0098;
                case 2: goto L_0x0091;
                case 3: goto L_0x008c;
                case 4: goto L_0x0087;
                case 5: goto L_0x0080;
                case 6: goto L_0x0079;
                case 7: goto L_0x0074;
                case 8: goto L_0x006f;
                case 9: goto L_0x0064;
                case 10: goto L_0x005f;
                case 11: goto L_0x0036;
                case 12: goto L_0x005a;
                case 13: goto L_0x0055;
                case 14: goto L_0x0050;
                case 15: goto L_0x0036;
                case 16: goto L_0x0049;
                case 17: goto L_0x0044;
                case 18: goto L_0x003f;
                case 19: goto L_0x003a;
                default: goto L_0x0036;
            }
        L_0x0036:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0025
        L_0x003a:
            java.util.ArrayList r26 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createLongList(r0, r2)
            goto L_0x0025
        L_0x003f:
            java.util.ArrayList r25 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createLongList(r0, r2)
            goto L_0x0025
        L_0x0044:
            java.util.ArrayList r24 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createIntegerList(r0, r2)
            goto L_0x0025
        L_0x0049:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.Device> r3 = com.google.android.gms.fitness.data.Device.CREATOR
            java.util.ArrayList r23 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r0, r2, r3)
            goto L_0x0025
        L_0x0050:
            android.os.IBinder r22 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x0025
        L_0x0055:
            boolean r21 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0025
        L_0x005a:
            boolean r20 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0025
        L_0x005f:
            int r19 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0025
        L_0x0064:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataSource> r3 = com.google.android.gms.fitness.data.DataSource.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r18 = r2
            com.google.android.gms.fitness.data.DataSource r18 = (com.google.android.gms.fitness.data.DataSource) r18
            goto L_0x0025
        L_0x006f:
            long r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0025
        L_0x0074:
            int r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0025
        L_0x0079:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataSource> r3 = com.google.android.gms.fitness.data.DataSource.CREATOR
            java.util.ArrayList r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r0, r2, r3)
            goto L_0x0025
        L_0x0080:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataType> r3 = com.google.android.gms.fitness.data.DataType.CREATOR
            java.util.ArrayList r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r0, r2, r3)
            goto L_0x0025
        L_0x0087:
            long r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0025
        L_0x008c:
            long r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0025
        L_0x0091:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataSource> r3 = com.google.android.gms.fitness.data.DataSource.CREATOR
            java.util.ArrayList r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r0, r2, r3)
            goto L_0x0025
        L_0x0098:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataType> r3 = com.google.android.gms.fitness.data.DataType.CREATOR
            java.util.ArrayList r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r0, r2, r3)
            goto L_0x0025
        L_0x009f:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.fitness.request.DataReadRequest r0 = new com.google.android.gms.fitness.request.DataReadRequest
            r6 = r0
            r6.<init>(r7, r8, r9, r11, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.request.zzn.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
