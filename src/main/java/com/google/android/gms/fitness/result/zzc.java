package com.google.android.gms.fitness.result;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzc implements Parcelable.Creator<DataReadResult> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new DataReadResult[i];
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r10) {
        /*
            r9 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r10)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1 = 0
            r3 = 0
            r6 = r1
            r5 = r3
            r3 = r6
        L_0x0013:
            int r1 = r10.dataPosition()
            if (r1 >= r0) goto L_0x0062
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r10)
            int r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r8 = 1
            if (r7 == r8) goto L_0x0056
            r8 = 2
            if (r7 == r8) goto L_0x004c
            r8 = 3
            if (r7 == r8) goto L_0x0040
            r8 = 5
            if (r7 == r8) goto L_0x003b
            r8 = 6
            if (r7 == r8) goto L_0x0034
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r10, r1)
            goto L_0x0013
        L_0x0034:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataSource> r6 = com.google.android.gms.fitness.data.DataSource.CREATOR
            java.util.ArrayList r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r10, r1, r6)
            goto L_0x0013
        L_0x003b:
            int r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r10, r1)
            goto L_0x0013
        L_0x0040:
            java.lang.Class r7 = r9.getClass()
            java.lang.ClassLoader r7 = r7.getClassLoader()
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readList(r10, r1, r4, r7)
            goto L_0x0013
        L_0x004c:
            android.os.Parcelable$Creator<com.google.android.gms.common.api.Status> r3 = com.google.android.gms.common.api.Status.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r10, r1, r3)
            r3 = r1
            com.google.android.gms.common.api.Status r3 = (com.google.android.gms.common.api.Status) r3
            goto L_0x0013
        L_0x0056:
            java.lang.Class r7 = r9.getClass()
            java.lang.ClassLoader r7 = r7.getClassLoader()
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readList(r10, r1, r2, r7)
            goto L_0x0013
        L_0x0062:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r10, r0)
            com.google.android.gms.fitness.result.DataReadResult r10 = new com.google.android.gms.fitness.result.DataReadResult
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.result.zzc.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
