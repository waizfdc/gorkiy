package com.google.android.gms.fitness.data;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzk implements Parcelable.Creator<DataSource> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new DataSource[i];
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r12) {
        /*
            r11 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r12)
            r1 = 0
            r2 = 0
            r4 = r1
            r5 = r4
            r7 = r5
            r8 = r7
            r9 = r8
            r10 = r9
            r6 = r2
        L_0x000d:
            int r1 = r12.dataPosition()
            if (r1 >= r0) goto L_0x0054
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r12)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 1: goto L_0x004a;
                case 2: goto L_0x0045;
                case 3: goto L_0x0040;
                case 4: goto L_0x0036;
                case 5: goto L_0x002c;
                case 6: goto L_0x0027;
                case 7: goto L_0x001e;
                case 8: goto L_0x0022;
                default: goto L_0x001e;
            }
        L_0x001e:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r12, r1)
            goto L_0x000d
        L_0x0022:
            int[] r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createIntArray(r12, r1)
            goto L_0x000d
        L_0x0027:
            java.lang.String r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r12, r1)
            goto L_0x000d
        L_0x002c:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.zzc> r2 = com.google.android.gms.fitness.data.zzc.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r12, r1, r2)
            r8 = r1
            com.google.android.gms.fitness.data.zzc r8 = (com.google.android.gms.fitness.data.zzc) r8
            goto L_0x000d
        L_0x0036:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.Device> r2 = com.google.android.gms.fitness.data.Device.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r12, r1, r2)
            r7 = r1
            com.google.android.gms.fitness.data.Device r7 = (com.google.android.gms.fitness.data.Device) r7
            goto L_0x000d
        L_0x0040:
            int r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r12, r1)
            goto L_0x000d
        L_0x0045:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r12, r1)
            goto L_0x000d
        L_0x004a:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataType> r2 = com.google.android.gms.fitness.data.DataType.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r12, r1, r2)
            r4 = r1
            com.google.android.gms.fitness.data.DataType r4 = (com.google.android.gms.fitness.data.DataType) r4
            goto L_0x000d
        L_0x0054:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r12, r0)
            com.google.android.gms.fitness.data.DataSource r12 = new com.google.android.gms.fitness.data.DataSource
            r3 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.zzk.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
