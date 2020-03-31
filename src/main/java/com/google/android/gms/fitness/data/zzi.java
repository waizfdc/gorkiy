package com.google.android.gms.fitness.data;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzi implements Parcelable.Creator<DataSet> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new DataSet[i];
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r10) {
        /*
            r9 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r10)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1 = 0
            r2 = 0
            r3 = r1
            r5 = r3
            r6 = r2
        L_0x000e:
            int r1 = r10.dataPosition()
            if (r1 >= r0) goto L_0x0057
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r10)
            int r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r8 = 1
            if (r7 == r8) goto L_0x004d
            r8 = 1000(0x3e8, float:1.401E-42)
            if (r7 == r8) goto L_0x0048
            r8 = 3
            if (r7 == r8) goto L_0x003c
            r8 = 4
            if (r7 == r8) goto L_0x0035
            r8 = 5
            if (r7 == r8) goto L_0x0030
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r10, r1)
            goto L_0x000e
        L_0x0030:
            boolean r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r10, r1)
            goto L_0x000e
        L_0x0035:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataSource> r5 = com.google.android.gms.fitness.data.DataSource.CREATOR
            java.util.ArrayList r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r10, r1, r5)
            goto L_0x000e
        L_0x003c:
            java.lang.Class r7 = r9.getClass()
            java.lang.ClassLoader r7 = r7.getClassLoader()
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readList(r10, r1, r4, r7)
            goto L_0x000e
        L_0x0048:
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r10, r1)
            goto L_0x000e
        L_0x004d:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.DataSource> r3 = com.google.android.gms.fitness.data.DataSource.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r10, r1, r3)
            r3 = r1
            com.google.android.gms.fitness.data.DataSource r3 = (com.google.android.gms.fitness.data.DataSource) r3
            goto L_0x000e
        L_0x0057:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r10, r0)
            com.google.android.gms.fitness.data.DataSet r10 = new com.google.android.gms.fitness.data.DataSet
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.zzi.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
