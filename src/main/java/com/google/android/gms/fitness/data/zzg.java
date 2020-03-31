package com.google.android.gms.fitness.data;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzg implements Parcelable.Creator<DataPoint> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new DataPoint[i];
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r18) {
        /*
            r17 = this;
            r0 = r18
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r18)
            r2 = 0
            r3 = 0
            r6 = r2
            r11 = r6
            r12 = r11
            r7 = r3
            r9 = r7
            r13 = r9
            r15 = r13
        L_0x0010:
            int r2 = r18.dataPosition()
            if (r2 >= r1) goto L_0x0057
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r18)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x004d;
                case 2: goto L_0x0021;
                case 3: goto L_0x0048;
                case 4: goto L_0x0043;
                case 5: goto L_0x0039;
                case 6: goto L_0x002f;
                case 7: goto L_0x002a;
                case 8: goto L_0x0025;
                default: goto L_0x0021;
            }
        L_0x0021:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0010
        L_0x0025:
            long r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0010
        L_0x002a:
            long r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0010
        L_0x002f:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataSource> r3 = com.google.android.gms.fitness.data.DataSource.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r12 = r2
            com.google.android.gms.fitness.data.DataSource r12 = (com.google.android.gms.fitness.data.DataSource) r12
            goto L_0x0010
        L_0x0039:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.Value> r3 = com.google.android.gms.fitness.data.Value.CREATOR
            java.lang.Object[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r0, r2, r3)
            r11 = r2
            com.google.android.gms.fitness.data.Value[] r11 = (com.google.android.gms.fitness.data.Value[]) r11
            goto L_0x0010
        L_0x0043:
            long r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0010
        L_0x0048:
            long r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0010
        L_0x004d:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataSource> r3 = com.google.android.gms.fitness.data.DataSource.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r6 = r2
            com.google.android.gms.fitness.data.DataSource r6 = (com.google.android.gms.fitness.data.DataSource) r6
            goto L_0x0010
        L_0x0057:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.fitness.data.DataPoint r0 = new com.google.android.gms.fitness.data.DataPoint
            r5 = r0
            r5.<init>(r6, r7, r9, r11, r12, r13, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.zzg.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
