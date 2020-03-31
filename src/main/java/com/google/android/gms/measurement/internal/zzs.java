package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbr;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzs {
    private zzbr.zzc zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzn zzd;

    private zzs(zzn zzn) {
        this.zzd = zzn;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzbr.zzc zza(java.lang.String r19, com.google.android.gms.internal.measurement.zzbr.zzc r20) {
        /*
            r18 = this;
            r1 = r18
            r8 = r19
            r9 = r20
            java.lang.String r0 = r20.zzc()
            java.util.List r10 = r20.zza()
            com.google.android.gms.measurement.internal.zzn r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzkw r2 = r2.zzg()
            java.lang.String r3 = "_eid"
            java.lang.Object r2 = r2.zzb(r9, r3)
            r4 = r2
            java.lang.Long r4 = (java.lang.Long) r4
            r2 = 1
            r5 = 0
            if (r4 == 0) goto L_0x0023
            r6 = r2
            goto L_0x0024
        L_0x0023:
            r6 = r5
        L_0x0024:
            if (r6 == 0) goto L_0x0030
            java.lang.String r7 = "_ep"
            boolean r7 = r0.equals(r7)
            if (r7 == 0) goto L_0x0030
            r7 = r2
            goto L_0x0031
        L_0x0030:
            r7 = r5
        L_0x0031:
            r11 = 0
            if (r7 == 0) goto L_0x01b1
            com.google.android.gms.measurement.internal.zzn r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzkw r0 = r0.zzg()
            java.lang.String r6 = "_en"
            java.lang.Object r0 = r0.zzb(r9, r6)
            r13 = r0
            java.lang.String r13 = (java.lang.String) r13
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            r6 = 0
            if (r0 == 0) goto L_0x007d
            boolean r0 = com.google.android.gms.internal.measurement.zzky.zzb()
            java.lang.String r2 = "Extra parameter without an event name. eventId"
            if (r0 == 0) goto L_0x006f
            com.google.android.gms.measurement.internal.zzn r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzx r0 = r0.zzt()
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzap.zzcz
            boolean r0 = r0.zzd(r8, r3)
            if (r0 == 0) goto L_0x006f
            com.google.android.gms.measurement.internal.zzn r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzg()
            r0.zza(r2, r4)
            goto L_0x007c
        L_0x006f:
            com.google.android.gms.measurement.internal.zzn r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()
            r0.zza(r2, r4)
        L_0x007c:
            return r6
        L_0x007d:
            com.google.android.gms.internal.measurement.zzbr$zzc r0 = r1.zza
            if (r0 == 0) goto L_0x0093
            java.lang.Long r0 = r1.zzb
            if (r0 == 0) goto L_0x0093
            long r14 = r4.longValue()
            java.lang.Long r0 = r1.zzb
            long r16 = r0.longValue()
            int r0 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x00c5
        L_0x0093:
            com.google.android.gms.measurement.internal.zzn r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzac r0 = r0.zzi()
            android.util.Pair r0 = r0.zza(r8, r4)
            if (r0 == 0) goto L_0x017f
            java.lang.Object r7 = r0.first
            if (r7 != 0) goto L_0x00a5
            goto L_0x017f
        L_0x00a5:
            java.lang.Object r6 = r0.first
            com.google.android.gms.internal.measurement.zzbr$zzc r6 = (com.google.android.gms.internal.measurement.zzbr.zzc) r6
            r1.zza = r6
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r6 = r0.longValue()
            r1.zzc = r6
            com.google.android.gms.measurement.internal.zzn r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzkw r0 = r0.zzg()
            com.google.android.gms.internal.measurement.zzbr$zzc r6 = r1.zza
            java.lang.Object r0 = r0.zzb(r6, r3)
            java.lang.Long r0 = (java.lang.Long) r0
            r1.zzb = r0
        L_0x00c5:
            long r6 = r1.zzc
            r14 = 1
            long r6 = r6 - r14
            r1.zzc = r6
            int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r0 > 0) goto L_0x0103
            com.google.android.gms.measurement.internal.zzn r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzac r3 = r0.zzi()
            r3.zzd()
            com.google.android.gms.measurement.internal.zzfk r0 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzx()
            java.lang.String r4 = "Clearing complex main event info. appId"
            r0.zza(r4, r8)
            android.database.sqlite.SQLiteDatabase r0 = r3.c_()     // Catch:{ SQLiteException -> 0x00f4 }
            java.lang.String r4 = "delete from main_event_params where app_id=?"
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00f4 }
            r2[r5] = r8     // Catch:{ SQLiteException -> 0x00f4 }
            r0.execSQL(r4, r2)     // Catch:{ SQLiteException -> 0x00f4 }
            goto L_0x0112
        L_0x00f4:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfk r2 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()
            java.lang.String r3 = "Error clearing complex main event"
            r2.zza(r3, r0)
            goto L_0x0112
        L_0x0103:
            com.google.android.gms.measurement.internal.zzn r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzac r2 = r0.zzi()
            long r5 = r1.zzc
            com.google.android.gms.internal.measurement.zzbr$zzc r7 = r1.zza
            r3 = r19
            r2.zza(r3, r4, r5, r7)
        L_0x0112:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.android.gms.internal.measurement.zzbr$zzc r2 = r1.zza
            java.util.List r2 = r2.zza()
            java.util.Iterator r2 = r2.iterator()
        L_0x0121:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0140
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzbr$zze r3 = (com.google.android.gms.internal.measurement.zzbr.zze) r3
            com.google.android.gms.measurement.internal.zzn r4 = r1.zzd
            r4.zzg()
            java.lang.String r4 = r3.zzb()
            com.google.android.gms.internal.measurement.zzbr$zze r4 = com.google.android.gms.measurement.internal.zzkw.zza(r9, r4)
            if (r4 != 0) goto L_0x0121
            r0.add(r3)
            goto L_0x0121
        L_0x0140:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x014d
            r0.addAll(r10)
            r10 = r0
        L_0x014a:
            r0 = r13
            goto L_0x0218
        L_0x014d:
            boolean r0 = com.google.android.gms.internal.measurement.zzky.zzb()
            java.lang.String r2 = "No unique parameters in main event. eventName"
            if (r0 == 0) goto L_0x0171
            com.google.android.gms.measurement.internal.zzn r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzx r0 = r0.zzt()
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzap.zzcz
            boolean r0 = r0.zzd(r8, r3)
            if (r0 == 0) goto L_0x0171
            com.google.android.gms.measurement.internal.zzn r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzg()
            r0.zza(r2, r13)
            goto L_0x014a
        L_0x0171:
            com.google.android.gms.measurement.internal.zzn r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzi()
            r0.zza(r2, r13)
            goto L_0x014a
        L_0x017f:
            boolean r0 = com.google.android.gms.internal.measurement.zzky.zzb()
            java.lang.String r2 = "Extra parameter without existing main event. eventName, eventId"
            if (r0 == 0) goto L_0x01a3
            com.google.android.gms.measurement.internal.zzn r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzx r0 = r0.zzt()
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzap.zzcz
            boolean r0 = r0.zzd(r8, r3)
            if (r0 == 0) goto L_0x01a3
            com.google.android.gms.measurement.internal.zzn r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzg()
            r0.zza(r2, r13, r4)
            goto L_0x01b0
        L_0x01a3:
            com.google.android.gms.measurement.internal.zzn r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzfk r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()
            r0.zza(r2, r13, r4)
        L_0x01b0:
            return r6
        L_0x01b1:
            if (r6 == 0) goto L_0x0218
            r1.zzb = r4
            r1.zza = r9
            com.google.android.gms.measurement.internal.zzn r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzkw r2 = r2.zzg()
            java.lang.Long r3 = java.lang.Long.valueOf(r11)
            java.lang.String r5 = "_epc"
            java.lang.Object r2 = r2.zzb(r9, r5)
            if (r2 != 0) goto L_0x01ca
            goto L_0x01cb
        L_0x01ca:
            r3 = r2
        L_0x01cb:
            java.lang.Long r3 = (java.lang.Long) r3
            long r2 = r3.longValue()
            r1.zzc = r2
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x0209
            boolean r2 = com.google.android.gms.internal.measurement.zzky.zzb()
            java.lang.String r3 = "Complex event with zero extra param count. eventName"
            if (r2 == 0) goto L_0x01fb
            com.google.android.gms.measurement.internal.zzn r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzt()
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzap.zzcz
            boolean r2 = r2.zzd(r8, r4)
            if (r2 == 0) goto L_0x01fb
            com.google.android.gms.measurement.internal.zzn r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzg()
            r2.zza(r3, r0)
            goto L_0x0218
        L_0x01fb:
            com.google.android.gms.measurement.internal.zzn r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzi()
            r2.zza(r3, r0)
            goto L_0x0218
        L_0x0209:
            com.google.android.gms.measurement.internal.zzn r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzac r2 = r2.zzi()
            long r5 = r1.zzc
            r3 = r19
            r7 = r20
            r2.zza(r3, r4, r5, r7)
        L_0x0218:
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = r20.zzbm()
            com.google.android.gms.internal.measurement.zzfd$zzb r2 = (com.google.android.gms.internal.measurement.zzfd.zzb) r2
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r2
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r0 = r2.zza(r0)
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r0 = r0.zzc()
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r0 = r0.zza(r10)
            com.google.android.gms.internal.measurement.zzgo r0 = r0.zzu()
            com.google.android.gms.internal.measurement.zzfd r0 = (com.google.android.gms.internal.measurement.zzfd) r0
            com.google.android.gms.internal.measurement.zzbr$zzc r0 = (com.google.android.gms.internal.measurement.zzbr.zzc) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzs.zza(java.lang.String, com.google.android.gms.internal.measurement.zzbr$zzc):com.google.android.gms.internal.measurement.zzbr$zzc");
    }

    /* synthetic */ zzs(zzn zzn, zzq zzq) {
        this(zzn);
    }
}
