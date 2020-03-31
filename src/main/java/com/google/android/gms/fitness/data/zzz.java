package com.google.android.gms.fitness.data;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzz implements Parcelable.Creator<RawDataPoint> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new RawDataPoint[i];
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r19) {
        /*
            r18 = this;
            r0 = r19
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r19)
            r2 = 0
            r3 = 0
            r5 = 0
            r12 = r2
            r13 = r12
            r7 = r3
            r9 = r7
            r14 = r9
            r16 = r14
            r11 = r5
        L_0x0012:
            int r2 = r19.dataPosition()
            if (r2 >= r1) goto L_0x004f
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r19)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x004a;
                case 2: goto L_0x0045;
                case 3: goto L_0x003b;
                case 4: goto L_0x0036;
                case 5: goto L_0x0031;
                case 6: goto L_0x002c;
                case 7: goto L_0x0027;
                default: goto L_0x0023;
            }
        L_0x0023:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0012
        L_0x0027:
            long r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0012
        L_0x002c:
            long r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0012
        L_0x0031:
            int r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0012
        L_0x0036:
            int r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0012
        L_0x003b:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.Value> r3 = com.google.android.gms.fitness.data.Value.CREATOR
            java.lang.Object[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r0, r2, r3)
            r11 = r2
            com.google.android.gms.fitness.data.Value[] r11 = (com.google.android.gms.fitness.data.Value[]) r11
            goto L_0x0012
        L_0x0045:
            long r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0012
        L_0x004a:
            long r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0012
        L_0x004f:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.fitness.data.RawDataPoint r0 = new com.google.android.gms.fitness.data.RawDataPoint
            r6 = r0
            r6.<init>(r7, r9, r11, r12, r13, r14, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.zzz.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
