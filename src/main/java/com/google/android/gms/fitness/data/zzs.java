package com.google.android.gms.fitness.data;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzs implements Parcelable.Creator<Goal> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new Goal[i];
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r14) {
        /*
            r13 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r14)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r1 = 0
            r3 = 0
            r4 = 0
            r7 = r3
            r9 = r7
            r10 = r9
            r11 = r10
            r8 = r4
            r4 = r1
            r2 = r4
        L_0x0014:
            int r1 = r14.dataPosition()
            if (r1 >= r0) goto L_0x006c
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r14)
            int r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r12) {
                case 1: goto L_0x0067;
                case 2: goto L_0x0062;
                case 3: goto L_0x0056;
                case 4: goto L_0x004c;
                case 5: goto L_0x0047;
                case 6: goto L_0x003d;
                case 7: goto L_0x0033;
                case 8: goto L_0x0029;
                default: goto L_0x0025;
            }
        L_0x0025:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r14, r1)
            goto L_0x0014
        L_0x0029:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.Goal$FrequencyObjective> r11 = com.google.android.gms.fitness.data.Goal.FrequencyObjective.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r14, r1, r11)
            r11 = r1
            com.google.android.gms.fitness.data.Goal$FrequencyObjective r11 = (com.google.android.gms.fitness.data.Goal.FrequencyObjective) r11
            goto L_0x0014
        L_0x0033:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.Goal$DurationObjective> r10 = com.google.android.gms.fitness.data.Goal.DurationObjective.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r14, r1, r10)
            r10 = r1
            com.google.android.gms.fitness.data.Goal$DurationObjective r10 = (com.google.android.gms.fitness.data.Goal.DurationObjective) r10
            goto L_0x0014
        L_0x003d:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.Goal$MetricObjective> r9 = com.google.android.gms.fitness.data.Goal.MetricObjective.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r14, r1, r9)
            r9 = r1
            com.google.android.gms.fitness.data.Goal$MetricObjective r9 = (com.google.android.gms.fitness.data.Goal.MetricObjective) r9
            goto L_0x0014
        L_0x0047:
            int r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x0014
        L_0x004c:
            android.os.Parcelable$Creator<com.google.android.gms.fitness.data.Goal$Recurrence> r7 = com.google.android.gms.fitness.data.Goal.Recurrence.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r14, r1, r7)
            r7 = r1
            com.google.android.gms.fitness.data.Goal$Recurrence r7 = (com.google.android.gms.fitness.data.Goal.Recurrence) r7
            goto L_0x0014
        L_0x0056:
            java.lang.Class r12 = r13.getClass()
            java.lang.ClassLoader r12 = r12.getClassLoader()
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readList(r14, r1, r6, r12)
            goto L_0x0014
        L_0x0062:
            long r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r14, r1)
            goto L_0x0014
        L_0x0067:
            long r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r14, r1)
            goto L_0x0014
        L_0x006c:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r14, r0)
            com.google.android.gms.fitness.data.Goal r14 = new com.google.android.gms.fitness.data.Goal
            r1 = r14
            r1.<init>(r2, r4, r6, r7, r8, r9, r10, r11)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.zzs.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
