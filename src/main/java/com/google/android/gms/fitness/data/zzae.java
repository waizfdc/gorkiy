package com.google.android.gms.fitness.data;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzae implements Parcelable.Creator<Session> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new Session[i];
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r18) {
        /*
            r17 = this;
            r0 = r18
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r18)
            r2 = 0
            r4 = 0
            r5 = 0
            r7 = r2
            r9 = r7
            r11 = r4
            r12 = r11
            r13 = r12
            r15 = r13
            r16 = r15
            r14 = r5
        L_0x0013:
            int r2 = r18.dataPosition()
            if (r2 >= r1) goto L_0x0055
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r18)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x0050;
                case 2: goto L_0x004b;
                case 3: goto L_0x0046;
                case 4: goto L_0x0041;
                case 5: goto L_0x003c;
                case 6: goto L_0x0024;
                case 7: goto L_0x0037;
                case 8: goto L_0x002d;
                case 9: goto L_0x0028;
                default: goto L_0x0024;
            }
        L_0x0024:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0013
        L_0x0028:
            java.lang.Long r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLongObject(r0, r2)
            goto L_0x0013
        L_0x002d:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.zzc> r3 = com.google.android.gms.fitness.data.zzc.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r15 = r2
            com.google.android.gms.fitness.data.zzc r15 = (com.google.android.gms.fitness.data.zzc) r15
            goto L_0x0013
        L_0x0037:
            int r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0013
        L_0x003c:
            java.lang.String r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0013
        L_0x0041:
            java.lang.String r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0013
        L_0x0046:
            java.lang.String r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0013
        L_0x004b:
            long r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0013
        L_0x0050:
            long r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0013
        L_0x0055:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.fitness.data.Session r0 = new com.google.android.gms.fitness.data.Session
            r6 = r0
            r6.<init>(r7, r9, r11, r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.zzae.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
