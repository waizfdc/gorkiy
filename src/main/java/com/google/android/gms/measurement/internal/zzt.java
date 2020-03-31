package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbj;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzt extends zzu {
    private zzbj.zze zzg;
    private final /* synthetic */ zzn zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzt(zzn zzn, String str, int i, zzbj.zze zze) {
        super(str, i);
        this.zzh = zzn;
        this.zzg = zze;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzg.zzb();
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.Long r14, java.lang.Long r15, com.google.android.gms.internal.measurement.zzbr.zzk r16, boolean r17) {
        /*
            r13 = this;
            r0 = r13
            com.google.android.gms.measurement.internal.zzn r1 = r0.zzh
            com.google.android.gms.measurement.internal.zzx r1 = r1.zzt()
            java.lang.String r2 = r0.zza
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzap.zzbm
            boolean r1 = r1.zzd(r2, r3)
            com.google.android.gms.measurement.internal.zzn r2 = r0.zzh
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzt()
            java.lang.String r3 = r0.zza
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzap.zzbs
            boolean r2 = r2.zzd(r3, r4)
            boolean r3 = com.google.android.gms.internal.measurement.zzkb.zzb()
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0037
            com.google.android.gms.measurement.internal.zzn r3 = r0.zzh
            com.google.android.gms.measurement.internal.zzx r3 = r3.zzt()
            java.lang.String r6 = r0.zza
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzap.zzbv
            boolean r3 = r3.zzd(r6, r7)
            if (r3 == 0) goto L_0x0037
            r3 = r5
            goto L_0x0038
        L_0x0037:
            r3 = r4
        L_0x0038:
            com.google.android.gms.internal.measurement.zzbj$zze r6 = r0.zzg
            boolean r6 = r6.zze()
            com.google.android.gms.internal.measurement.zzbj$zze r7 = r0.zzg
            boolean r7 = r7.zzf()
            if (r1 == 0) goto L_0x0050
            com.google.android.gms.internal.measurement.zzbj$zze r8 = r0.zzg
            boolean r8 = r8.zzh()
            if (r8 == 0) goto L_0x0050
            r8 = r5
            goto L_0x0051
        L_0x0050:
            r8 = r4
        L_0x0051:
            if (r6 != 0) goto L_0x005a
            if (r7 != 0) goto L_0x005a
            if (r8 == 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r6 = r4
            goto L_0x005b
        L_0x005a:
            r6 = r5
        L_0x005b:
            r7 = 0
            if (r17 == 0) goto L_0x0088
            if (r6 != 0) goto L_0x0088
            com.google.android.gms.measurement.internal.zzn r1 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfm r1 = r1.zzx()
            int r2 = r0.zzb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.google.android.gms.internal.measurement.zzbj$zze r3 = r0.zzg
            boolean r3 = r3.zza()
            if (r3 == 0) goto L_0x0082
            com.google.android.gms.internal.measurement.zzbj$zze r3 = r0.zzg
            int r3 = r3.zzb()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
        L_0x0082:
            java.lang.String r3 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r1.zza(r3, r2, r7)
            return r5
        L_0x0088:
            com.google.android.gms.internal.measurement.zzbj$zze r9 = r0.zzg
            com.google.android.gms.internal.measurement.zzbj$zzc r9 = r9.zzd()
            boolean r10 = r9.zzf()
            boolean r11 = r16.zzf()
            if (r11 == 0) goto L_0x00cf
            boolean r11 = r9.zzc()
            if (r11 != 0) goto L_0x00bd
            com.google.android.gms.measurement.internal.zzn r9 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r9 = r9.zzr()
            com.google.android.gms.measurement.internal.zzfm r9 = r9.zzi()
            com.google.android.gms.measurement.internal.zzn r10 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzo()
            java.lang.String r11 = r16.zzc()
            java.lang.String r10 = r10.zzc(r11)
            java.lang.String r11 = "No number filter for long property. property"
            r9.zza(r11, r10)
            goto L_0x01ad
        L_0x00bd:
            long r11 = r16.zzg()
            com.google.android.gms.internal.measurement.zzbj$zzd r7 = r9.zzd()
            java.lang.Boolean r7 = zza(r11, r7)
            java.lang.Boolean r7 = zza(r7, r10)
            goto L_0x01ad
        L_0x00cf:
            boolean r11 = r16.zzh()
            if (r11 == 0) goto L_0x010c
            boolean r11 = r9.zzc()
            if (r11 != 0) goto L_0x00fa
            com.google.android.gms.measurement.internal.zzn r9 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r9 = r9.zzr()
            com.google.android.gms.measurement.internal.zzfm r9 = r9.zzi()
            com.google.android.gms.measurement.internal.zzn r10 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzo()
            java.lang.String r11 = r16.zzc()
            java.lang.String r10 = r10.zzc(r11)
            java.lang.String r11 = "No number filter for double property. property"
            r9.zza(r11, r10)
            goto L_0x01ad
        L_0x00fa:
            double r11 = r16.zzi()
            com.google.android.gms.internal.measurement.zzbj$zzd r7 = r9.zzd()
            java.lang.Boolean r7 = zza(r11, r7)
            java.lang.Boolean r7 = zza(r7, r10)
            goto L_0x01ad
        L_0x010c:
            boolean r11 = r16.zzd()
            if (r11 == 0) goto L_0x0190
            boolean r11 = r9.zza()
            if (r11 != 0) goto L_0x0179
            boolean r11 = r9.zzc()
            if (r11 != 0) goto L_0x013c
            com.google.android.gms.measurement.internal.zzn r9 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r9 = r9.zzr()
            com.google.android.gms.measurement.internal.zzfm r9 = r9.zzi()
            com.google.android.gms.measurement.internal.zzn r10 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzo()
            java.lang.String r11 = r16.zzc()
            java.lang.String r10 = r10.zzc(r11)
            java.lang.String r11 = "No string or number filter defined. property"
            r9.zza(r11, r10)
            goto L_0x01ad
        L_0x013c:
            java.lang.String r11 = r16.zze()
            boolean r11 = com.google.android.gms.measurement.internal.zzkw.zza(r11)
            if (r11 == 0) goto L_0x0157
            java.lang.String r7 = r16.zze()
            com.google.android.gms.internal.measurement.zzbj$zzd r9 = r9.zzd()
            java.lang.Boolean r7 = zza(r7, r9)
            java.lang.Boolean r7 = zza(r7, r10)
            goto L_0x01ad
        L_0x0157:
            com.google.android.gms.measurement.internal.zzn r9 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r9 = r9.zzr()
            com.google.android.gms.measurement.internal.zzfm r9 = r9.zzi()
            com.google.android.gms.measurement.internal.zzn r10 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzo()
            java.lang.String r11 = r16.zzc()
            java.lang.String r10 = r10.zzc(r11)
            java.lang.String r11 = r16.zze()
            java.lang.String r12 = "Invalid user property value for Numeric number filter. property, value"
            r9.zza(r12, r10, r11)
            goto L_0x01ad
        L_0x0179:
            java.lang.String r7 = r16.zze()
            com.google.android.gms.internal.measurement.zzbj$zzf r9 = r9.zzb()
            com.google.android.gms.measurement.internal.zzn r11 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r11 = r11.zzr()
            java.lang.Boolean r7 = zza(r7, r9, r11)
            java.lang.Boolean r7 = zza(r7, r10)
            goto L_0x01ad
        L_0x0190:
            com.google.android.gms.measurement.internal.zzn r9 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r9 = r9.zzr()
            com.google.android.gms.measurement.internal.zzfm r9 = r9.zzi()
            com.google.android.gms.measurement.internal.zzn r10 = r0.zzh
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzo()
            java.lang.String r11 = r16.zzc()
            java.lang.String r10 = r10.zzc(r11)
            java.lang.String r11 = "User property has no value, property"
            r9.zza(r11, r10)
        L_0x01ad:
            com.google.android.gms.measurement.internal.zzn r9 = r0.zzh
            com.google.android.gms.measurement.internal.zzfk r9 = r9.zzr()
            com.google.android.gms.measurement.internal.zzfm r9 = r9.zzx()
            if (r7 != 0) goto L_0x01bc
            java.lang.String r10 = "null"
            goto L_0x01bd
        L_0x01bc:
            r10 = r7
        L_0x01bd:
            java.lang.String r11 = "Property filter result"
            r9.zza(r11, r10)
            if (r7 != 0) goto L_0x01c5
            return r4
        L_0x01c5:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r5)
            r0.zzc = r4
            if (r1 == 0) goto L_0x01d6
            if (r8 == 0) goto L_0x01d6
            boolean r1 = r7.booleanValue()
            if (r1 != 0) goto L_0x01d6
            return r5
        L_0x01d6:
            if (r17 == 0) goto L_0x01e0
            com.google.android.gms.internal.measurement.zzbj$zze r1 = r0.zzg
            boolean r1 = r1.zze()
            if (r1 == 0) goto L_0x01e2
        L_0x01e0:
            r0.zzd = r7
        L_0x01e2:
            boolean r1 = r7.booleanValue()
            if (r1 == 0) goto L_0x0229
            if (r6 == 0) goto L_0x0229
            boolean r1 = r16.zza()
            if (r1 == 0) goto L_0x0229
            long r6 = r16.zzb()
            if (r2 == 0) goto L_0x01fc
            if (r14 == 0) goto L_0x01fc
            long r6 = r14.longValue()
        L_0x01fc:
            if (r3 == 0) goto L_0x0214
            com.google.android.gms.internal.measurement.zzbj$zze r1 = r0.zzg
            boolean r1 = r1.zze()
            if (r1 == 0) goto L_0x0214
            com.google.android.gms.internal.measurement.zzbj$zze r1 = r0.zzg
            boolean r1 = r1.zzf()
            if (r1 != 0) goto L_0x0214
            if (r15 == 0) goto L_0x0214
            long r6 = r15.longValue()
        L_0x0214:
            com.google.android.gms.internal.measurement.zzbj$zze r1 = r0.zzg
            boolean r1 = r1.zzf()
            if (r1 == 0) goto L_0x0223
            java.lang.Long r1 = java.lang.Long.valueOf(r6)
            r0.zzf = r1
            goto L_0x0229
        L_0x0223:
            java.lang.Long r1 = java.lang.Long.valueOf(r6)
            r0.zze = r1
        L_0x0229:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zza(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzbr$zzk, boolean):boolean");
    }
}
