package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzn extends zzkp {
    private String zzb;
    private Set<Integer> zzc;
    private Map<Integer, zzp> zzd;
    private Long zze;
    private Long zzf;

    zzn(zzks zzks) {
        super(zzks);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x03ee  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x05e1  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x074b  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x076f  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x032c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzbr.zza> zza(java.lang.String r53, java.util.List<com.google.android.gms.internal.measurement.zzbr.zzc> r54, java.util.List<com.google.android.gms.internal.measurement.zzbr.zzk> r55, java.lang.Long r56, java.lang.Long r57) {
        /*
            r52 = this;
            r10 = r52
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r53)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r54)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r55)
            r0 = r53
            r10.zzb = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzc = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.zzd = r0
            r0 = r56
            r10.zze = r0
            r0 = r57
            r10.zzf = r0
            com.google.android.gms.measurement.internal.zzx r0 = r52.zzt()
            java.lang.String r1 = r10.zzb
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzap.zzbm
            boolean r0 = r0.zzd(r1, r2)
            r11 = 0
            r12 = 1
            if (r0 != 0) goto L_0x0043
            com.google.android.gms.measurement.internal.zzx r0 = r52.zzt()
            java.lang.String r1 = r10.zzb
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzap.zzbn
            boolean r0 = r0.zzd(r1, r2)
            if (r0 == 0) goto L_0x0061
        L_0x0043:
            java.util.Iterator r0 = r54.iterator()
        L_0x0047:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0061
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzbr$zzc r1 = (com.google.android.gms.internal.measurement.zzbr.zzc) r1
            java.lang.String r1 = r1.zzc()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0047
            r1 = r12
            goto L_0x0062
        L_0x0061:
            r1 = r11
        L_0x0062:
            com.google.android.gms.measurement.internal.zzx r0 = r52.zzt()
            java.lang.String r2 = r10.zzb
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzap.zzbm
            boolean r13 = r0.zzd(r2, r3)
            com.google.android.gms.measurement.internal.zzx r0 = r52.zzt()
            java.lang.String r2 = r10.zzb
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzap.zzbn
            boolean r0 = r0.zzd(r2, r3)
            boolean r2 = com.google.android.gms.internal.measurement.zzkb.zzb()
            if (r2 == 0) goto L_0x0090
            com.google.android.gms.measurement.internal.zzx r2 = r52.zzt()
            java.lang.String r3 = r10.zzb
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzap.zzbx
            boolean r2 = r2.zzd(r3, r4)
            if (r2 == 0) goto L_0x0090
            r14 = r12
            goto L_0x0091
        L_0x0090:
            r14 = r11
        L_0x0091:
            boolean r2 = com.google.android.gms.internal.measurement.zzkb.zzb()
            if (r2 == 0) goto L_0x00a7
            com.google.android.gms.measurement.internal.zzx r2 = r52.zzt()
            java.lang.String r3 = r10.zzb
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzap.zzbw
            boolean r2 = r2.zzd(r3, r4)
            if (r2 == 0) goto L_0x00a7
            r15 = r12
            goto L_0x00a8
        L_0x00a7:
            r15 = r11
        L_0x00a8:
            if (r1 == 0) goto L_0x00eb
            if (r0 == 0) goto L_0x00eb
            com.google.android.gms.measurement.internal.zzac r2 = r52.zzi()
            java.lang.String r3 = r10.zzb
            r2.zzak()
            r2.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            java.lang.String r5 = "current_session_count"
            r0.put(r5, r4)
            android.database.sqlite.SQLiteDatabase r4 = r2.c_()     // Catch:{ SQLiteException -> 0x00d9 }
            java.lang.String r5 = "events"
            java.lang.String r6 = "app_id = ?"
            java.lang.String[] r7 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x00d9 }
            r7[r11] = r3     // Catch:{ SQLiteException -> 0x00d9 }
            r4.update(r5, r0, r6, r7)     // Catch:{ SQLiteException -> 0x00d9 }
            goto L_0x00eb
        L_0x00d9:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfk.zza(r3)
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            r2.zza(r4, r3, r0)
        L_0x00eb:
            java.util.Map r0 = java.util.Collections.emptyMap()
            if (r15 == 0) goto L_0x00fd
            if (r14 == 0) goto L_0x00fd
            com.google.android.gms.measurement.internal.zzac r0 = r52.zzi()
            java.lang.String r2 = r10.zzb
            java.util.Map r0 = r0.zze(r2)
        L_0x00fd:
            com.google.android.gms.measurement.internal.zzac r2 = r52.zzi()
            java.lang.String r3 = r10.zzb
            java.util.Map r9 = r2.zzg(r3)
            if (r9 == 0) goto L_0x03e3
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto L_0x0111
            goto L_0x03e3
        L_0x0111:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r3 = r9.keySet()
            r2.<init>(r3)
            if (r13 == 0) goto L_0x0202
            if (r1 == 0) goto L_0x0202
            java.lang.String r1 = r10.zzb
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            boolean r4 = r9.isEmpty()
            if (r4 != 0) goto L_0x0200
            com.google.android.gms.measurement.internal.zzac r4 = r52.zzi()
            java.util.Map r1 = r4.zzf(r1)
            java.util.Set r4 = r9.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0141:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0200
            java.lang.Object r5 = r4.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            java.lang.Object r6 = r9.get(r6)
            com.google.android.gms.internal.measurement.zzbr$zzi r6 = (com.google.android.gms.internal.measurement.zzbr.zzi) r6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            java.lang.Object r7 = r1.get(r7)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x01f5
            boolean r16 = r7.isEmpty()
            if (r16 == 0) goto L_0x016f
            goto L_0x01f5
        L_0x016f:
            com.google.android.gms.measurement.internal.zzkw r8 = r52.zzg()
            java.util.List r11 = r6.zzc()
            java.util.List r8 = r8.zza(r11, r7)
            boolean r11 = r8.isEmpty()
            if (r11 != 0) goto L_0x01f2
            com.google.android.gms.internal.measurement.zzfd$zzb r11 = r6.zzbm()
            com.google.android.gms.internal.measurement.zzfd$zzb r11 = (com.google.android.gms.internal.measurement.zzfd.zzb) r11
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r11 = (com.google.android.gms.internal.measurement.zzbr.zzi.zza) r11
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r11 = r11.zzb()
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r8 = r11.zzb(r8)
            com.google.android.gms.measurement.internal.zzkw r11 = r52.zzg()
            java.util.List r12 = r6.zza()
            java.util.List r11 = r11.zza(r12, r7)
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r12 = r8.zza()
            r12.zza(r11)
            r11 = 0
        L_0x01a5:
            int r12 = r6.zzf()
            if (r11 >= r12) goto L_0x01c3
            com.google.android.gms.internal.measurement.zzbr$zzb r12 = r6.zza(r11)
            int r12 = r12.zzb()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            boolean r12 = r7.contains(r12)
            if (r12 == 0) goto L_0x01c0
            r8.zza(r11)
        L_0x01c0:
            int r11 = r11 + 1
            goto L_0x01a5
        L_0x01c3:
            r11 = 0
        L_0x01c4:
            int r12 = r6.zzh()
            if (r11 >= r12) goto L_0x01e2
            com.google.android.gms.internal.measurement.zzbr$zzj r12 = r6.zzb(r11)
            int r12 = r12.zzb()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            boolean r12 = r7.contains(r12)
            if (r12 == 0) goto L_0x01df
            r8.zzb(r11)
        L_0x01df:
            int r11 = r11 + 1
            goto L_0x01c4
        L_0x01e2:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.internal.measurement.zzgo r6 = r8.zzu()
            com.google.android.gms.internal.measurement.zzfd r6 = (com.google.android.gms.internal.measurement.zzfd) r6
            com.google.android.gms.internal.measurement.zzbr$zzi r6 = (com.google.android.gms.internal.measurement.zzbr.zzi) r6
            r3.put(r5, r6)
            goto L_0x01fc
        L_0x01f2:
            r11 = 0
            goto L_0x0141
        L_0x01f5:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.put(r5, r6)
        L_0x01fc:
            r11 = 0
            r12 = 1
            goto L_0x0141
        L_0x0200:
            r11 = r3
            goto L_0x0203
        L_0x0202:
            r11 = r9
        L_0x0203:
            java.util.Iterator r12 = r2.iterator()
        L_0x0207:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x03df
            java.lang.Object r1 = r12.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r16 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r16)
            java.lang.Object r1 = r11.get(r1)
            com.google.android.gms.internal.measurement.zzbr$zzi r1 = (com.google.android.gms.internal.measurement.zzbr.zzi) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x026f
            int r2 = r1.zzf()
            if (r2 != 0) goto L_0x0239
            goto L_0x026f
        L_0x0239:
            java.util.List r2 = r1.zze()
            java.util.Iterator r2 = r2.iterator()
        L_0x0241:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x026f
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzbr$zzb r3 = (com.google.android.gms.internal.measurement.zzbr.zzb) r3
            boolean r4 = r3.zza()
            if (r4 == 0) goto L_0x0241
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.zzc()
            if (r8 == 0) goto L_0x026a
            long r17 = r3.zzd()
            java.lang.Long r3 = java.lang.Long.valueOf(r17)
            goto L_0x026b
        L_0x026a:
            r3 = 0
        L_0x026b:
            r7.put(r4, r3)
            goto L_0x0241
        L_0x026f:
            boolean r2 = com.google.android.gms.internal.measurement.zzmv.zzb()
            if (r2 == 0) goto L_0x02da
            com.google.android.gms.measurement.internal.zzx r2 = r52.zzt()
            java.lang.String r3 = r10.zzb
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzap.zzbt
            boolean r2 = r2.zzd(r3, r4)
            if (r2 == 0) goto L_0x02da
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            if (r1 == 0) goto L_0x02d6
            int r3 = r1.zzh()
            if (r3 != 0) goto L_0x0291
            goto L_0x02d6
        L_0x0291:
            java.util.List r3 = r1.zzg()
            java.util.Iterator r3 = r3.iterator()
        L_0x0299:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x02d6
            java.lang.Object r4 = r3.next()
            com.google.android.gms.internal.measurement.zzbr$zzj r4 = (com.google.android.gms.internal.measurement.zzbr.zzj) r4
            boolean r8 = r4.zza()
            if (r8 == 0) goto L_0x02cf
            int r8 = r4.zzd()
            if (r8 <= 0) goto L_0x02cf
            int r8 = r4.zzb()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            int r17 = r4.zzd()
            r57 = r3
            r18 = 1
            int r3 = r17 + -1
            long r3 = r4.zza(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r2.put(r8, r3)
            goto L_0x02d3
        L_0x02cf:
            r57 = r3
            r18 = 1
        L_0x02d3:
            r3 = r57
            goto L_0x0299
        L_0x02d6:
            r18 = 1
            r8 = r2
            goto L_0x02dd
        L_0x02da:
            r18 = 1
            r8 = 0
        L_0x02dd:
            if (r1 == 0) goto L_0x0333
            r2 = 0
        L_0x02e0:
            int r3 = r1.zzb()
            int r3 = r3 << 6
            if (r2 >= r3) goto L_0x0333
            java.util.List r3 = r1.zza()
            boolean r3 = com.google.android.gms.measurement.internal.zzkw.zza(r3, r2)
            if (r3 == 0) goto L_0x031e
            com.google.android.gms.measurement.internal.zzfk r3 = r52.zzr()
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzx()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r16)
            r17 = r11
            java.lang.Integer r11 = java.lang.Integer.valueOf(r2)
            r57 = r12
            java.lang.String r12 = "Filter already evaluated. audience ID, filter ID"
            r3.zza(r12, r4, r11)
            r6.set(r2)
            java.util.List r3 = r1.zzc()
            boolean r3 = com.google.android.gms.measurement.internal.zzkw.zza(r3, r2)
            if (r3 == 0) goto L_0x0322
            r5.set(r2)
            r3 = r18
            goto L_0x0323
        L_0x031e:
            r17 = r11
            r57 = r12
        L_0x0322:
            r3 = 0
        L_0x0323:
            if (r3 != 0) goto L_0x032c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r7.remove(r3)
        L_0x032c:
            int r2 = r2 + 1
            r12 = r57
            r11 = r17
            goto L_0x02e0
        L_0x0333:
            r17 = r11
            r57 = r12
            if (r13 == 0) goto L_0x0343
            java.lang.Integer r1 = java.lang.Integer.valueOf(r16)
            java.lang.Object r1 = r9.get(r1)
            com.google.android.gms.internal.measurement.zzbr$zzi r1 = (com.google.android.gms.internal.measurement.zzbr.zzi) r1
        L_0x0343:
            r4 = r1
            if (r15 == 0) goto L_0x03bb
            if (r14 == 0) goto L_0x03bb
            java.lang.Integer r1 = java.lang.Integer.valueOf(r16)
            java.lang.Object r1 = r0.get(r1)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x03bb
            java.lang.Long r2 = r10.zzf
            if (r2 == 0) goto L_0x03bb
            java.lang.Long r2 = r10.zze
            if (r2 != 0) goto L_0x035d
            goto L_0x03bb
        L_0x035d:
            java.util.Iterator r1 = r1.iterator()
        L_0x0361:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x03bb
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzbj$zzb r2 = (com.google.android.gms.internal.measurement.zzbj.zzb) r2
            int r3 = r2.zzb()
            java.lang.Long r11 = r10.zzf
            long r11 = r11.longValue()
            r19 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 / r19
            boolean r2 = r2.zzi()
            if (r2 == 0) goto L_0x0389
            java.lang.Long r2 = r10.zze
            long r11 = r2.longValue()
            long r11 = r11 / r19
        L_0x0389:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            boolean r2 = r7.containsKey(r2)
            if (r2 == 0) goto L_0x03a1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r19 = r0
            java.lang.Long r0 = java.lang.Long.valueOf(r11)
            r7.put(r2, r0)
            goto L_0x03a3
        L_0x03a1:
            r19 = r0
        L_0x03a3:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            boolean r0 = r8.containsKey(r0)
            if (r0 == 0) goto L_0x03b8
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            java.lang.Long r2 = java.lang.Long.valueOf(r11)
            r8.put(r0, r2)
        L_0x03b8:
            r0 = r19
            goto L_0x0361
        L_0x03bb:
            r19 = r0
            com.google.android.gms.measurement.internal.zzp r0 = new com.google.android.gms.measurement.internal.zzp
            java.lang.String r3 = r10.zzb
            r11 = 0
            r1 = r0
            r2 = r52
            r12 = 0
            r20 = r9
            r9 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzp> r1 = r10.zzd
            java.lang.Integer r2 = java.lang.Integer.valueOf(r16)
            r1.put(r2, r0)
            r12 = r57
            r11 = r17
            r0 = r19
            r9 = r20
            goto L_0x0207
        L_0x03df:
            r12 = 0
            r18 = 1
            goto L_0x03e6
        L_0x03e3:
            r18 = r12
            r12 = 0
        L_0x03e6:
            boolean r0 = r54.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 != 0) goto L_0x05d6
            com.google.android.gms.measurement.internal.zzs r0 = new com.google.android.gms.measurement.internal.zzs
            r0.<init>(r10, r12)
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r54.iterator()
        L_0x03fc:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x05d6
            java.lang.Object r4 = r3.next()
            com.google.android.gms.internal.measurement.zzbr$zzc r4 = (com.google.android.gms.internal.measurement.zzbr.zzc) r4
            java.lang.String r5 = r10.zzb
            com.google.android.gms.internal.measurement.zzbr$zzc r5 = r0.zza(r5, r4)
            if (r5 == 0) goto L_0x03fc
            com.google.android.gms.measurement.internal.zzac r6 = r52.zzi()
            java.lang.String r7 = r10.zzb
            java.lang.String r8 = r5.zzc()
            com.google.android.gms.measurement.internal.zzx r9 = r6.zzt()
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzap.zzbn
            boolean r9 = r9.zzd(r7, r11)
            java.lang.String r11 = r4.zzc()
            com.google.android.gms.measurement.internal.zzaj r11 = r6.zza(r7, r11)
            if (r11 != 0) goto L_0x048d
            com.google.android.gms.measurement.internal.zzfk r11 = r6.zzr()
            com.google.android.gms.measurement.internal.zzfm r11 = r11.zzi()
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzfk.zza(r7)
            com.google.android.gms.measurement.internal.zzfi r6 = r6.zzo()
            java.lang.String r6 = r6.zza(r8)
            java.lang.String r8 = "Event aggregate wasn't created during raw event logging. appId, event"
            r11.zza(r8, r13, r6)
            if (r9 == 0) goto L_0x046c
            com.google.android.gms.measurement.internal.zzaj r6 = new com.google.android.gms.measurement.internal.zzaj
            r19 = r6
            java.lang.String r21 = r4.zzc()
            r22 = 1
            r24 = 1
            r26 = 1
            long r28 = r4.zze()
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r20 = r7
            r19.<init>(r20, r21, r22, r24, r26, r28, r30, r32, r33, r34, r35)
            goto L_0x04f9
        L_0x046c:
            com.google.android.gms.measurement.internal.zzaj r6 = new com.google.android.gms.measurement.internal.zzaj
            java.lang.String r21 = r4.zzc()
            r22 = 1
            r24 = 1
            long r26 = r4.zze()
            r28 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r19 = r6
            r20 = r7
            r19.<init>(r20, r21, r22, r24, r26, r28, r30, r31, r32, r33)
            goto L_0x04f9
        L_0x048d:
            r6 = 1
            if (r9 == 0) goto L_0x04c5
            com.google.android.gms.measurement.internal.zzaj r4 = new com.google.android.gms.measurement.internal.zzaj
            r19 = r4
            java.lang.String r8 = r11.zza
            r20 = r8
            java.lang.String r8 = r11.zzb
            r21 = r8
            long r8 = r11.zzc
            long r22 = r8 + r6
            long r8 = r11.zzd
            long r24 = r8 + r6
            long r8 = r11.zze
            long r26 = r8 + r6
            long r6 = r11.zzf
            r28 = r6
            long r6 = r11.zzg
            r30 = r6
            java.lang.Long r6 = r11.zzh
            r32 = r6
            java.lang.Long r6 = r11.zzi
            r33 = r6
            java.lang.Long r6 = r11.zzj
            r34 = r6
            java.lang.Boolean r6 = r11.zzk
            r35 = r6
            r19.<init>(r20, r21, r22, r24, r26, r28, r30, r32, r33, r34, r35)
            goto L_0x04f8
        L_0x04c5:
            com.google.android.gms.measurement.internal.zzaj r4 = new com.google.android.gms.measurement.internal.zzaj
            r35 = r4
            java.lang.String r8 = r11.zza
            r36 = r8
            java.lang.String r8 = r11.zzb
            r37 = r8
            long r8 = r11.zzc
            long r38 = r8 + r6
            long r8 = r11.zzd
            long r40 = r8 + r6
            long r6 = r11.zze
            r42 = r6
            long r6 = r11.zzf
            r44 = r6
            long r6 = r11.zzg
            r46 = r6
            java.lang.Long r6 = r11.zzh
            r48 = r6
            java.lang.Long r6 = r11.zzi
            r49 = r6
            java.lang.Long r6 = r11.zzj
            r50 = r6
            java.lang.Boolean r6 = r11.zzk
            r51 = r6
            r35.<init>(r36, r37, r38, r40, r42, r44, r46, r48, r49, r50, r51)
        L_0x04f8:
            r6 = r4
        L_0x04f9:
            com.google.android.gms.measurement.internal.zzac r4 = r52.zzi()
            r4.zza(r6)
            long r7 = r6.zzc
            java.lang.String r4 = r5.zzc()
            java.lang.Object r9 = r2.get(r4)
            java.util.Map r9 = (java.util.Map) r9
            if (r9 != 0) goto L_0x0522
            com.google.android.gms.measurement.internal.zzac r9 = r52.zzi()
            java.lang.String r11 = r10.zzb
            java.util.Map r9 = r9.zzf(r11, r4)
            if (r9 != 0) goto L_0x051f
            androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap
            r9.<init>()
        L_0x051f:
            r2.put(r4, r9)
        L_0x0522:
            java.util.Set r4 = r9.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x052a:
            boolean r11 = r4.hasNext()
            if (r11 == 0) goto L_0x03fc
            java.lang.Object r11 = r4.next()
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            java.util.Set<java.lang.Integer> r13 = r10.zzc
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)
            boolean r13 = r13.contains(r14)
            if (r13 == 0) goto L_0x0556
            com.google.android.gms.measurement.internal.zzfk r13 = r52.zzr()
            com.google.android.gms.measurement.internal.zzfm r13 = r13.zzx()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r13.zza(r1, r11)
            goto L_0x052a
        L_0x0556:
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)
            java.lang.Object r13 = r9.get(r13)
            java.util.List r13 = (java.util.List) r13
            java.util.Iterator r13 = r13.iterator()
            r14 = r18
        L_0x0566:
            boolean r15 = r13.hasNext()
            if (r15 == 0) goto L_0x05c0
            java.lang.Object r14 = r13.next()
            com.google.android.gms.internal.measurement.zzbj$zzb r14 = (com.google.android.gms.internal.measurement.zzbj.zzb) r14
            com.google.android.gms.measurement.internal.zzr r15 = new com.google.android.gms.measurement.internal.zzr
            java.lang.String r12 = r10.zzb
            r15.<init>(r10, r12, r11, r14)
            java.lang.Long r12 = r10.zze
            r57 = r0
            java.lang.Long r0 = r10.zzf
            int r14 = r14.zzb()
            boolean r26 = r10.zza(r11, r14)
            r19 = r15
            r20 = r12
            r21 = r0
            r22 = r5
            r23 = r7
            r25 = r6
            boolean r14 = r19.zza(r20, r21, r22, r23, r25, r26)
            com.google.android.gms.measurement.internal.zzx r0 = r52.zzt()
            java.lang.String r12 = r10.zzb
            r16 = r2
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzap.zzbu
            boolean r0 = r0.zzd(r12, r2)
            if (r0 == 0) goto L_0x05b3
            if (r14 != 0) goto L_0x05b3
            java.util.Set<java.lang.Integer> r0 = r10.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            r0.add(r2)
            goto L_0x05c4
        L_0x05b3:
            com.google.android.gms.measurement.internal.zzp r0 = r10.zza(r11)
            r0.zza(r15)
            r0 = r57
            r2 = r16
            r12 = 0
            goto L_0x0566
        L_0x05c0:
            r57 = r0
            r16 = r2
        L_0x05c4:
            if (r14 != 0) goto L_0x05cf
            java.util.Set<java.lang.Integer> r0 = r10.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            r0.add(r2)
        L_0x05cf:
            r0 = r57
            r2 = r16
            r12 = 0
            goto L_0x052a
        L_0x05d6:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r2 = r55.isEmpty()
            if (r2 != 0) goto L_0x0738
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r55.iterator()
        L_0x05ea:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0738
            java.lang.Object r4 = r3.next()
            com.google.android.gms.internal.measurement.zzbr$zzk r4 = (com.google.android.gms.internal.measurement.zzbr.zzk) r4
            java.lang.String r5 = r4.zzc()
            r0.add(r5)
            java.lang.String r5 = r4.zzc()
            java.lang.Object r6 = r2.get(r5)
            java.util.Map r6 = (java.util.Map) r6
            if (r6 != 0) goto L_0x061d
            com.google.android.gms.measurement.internal.zzac r6 = r52.zzi()
            java.lang.String r7 = r10.zzb
            java.util.Map r6 = r6.zzg(r7, r5)
            if (r6 != 0) goto L_0x061a
            androidx.collection.ArrayMap r6 = new androidx.collection.ArrayMap
            r6.<init>()
        L_0x061a:
            r2.put(r5, r6)
        L_0x061d:
            java.util.Set r5 = r6.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0625:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x05ea
            java.lang.Object r7 = r5.next()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.util.Set<java.lang.Integer> r8 = r10.zzc
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto L_0x0651
            com.google.android.gms.measurement.internal.zzfk r4 = r52.zzr()
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzx()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r4.zza(r1, r5)
            goto L_0x05ea
        L_0x0651:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            java.lang.Object r8 = r6.get(r8)
            java.util.List r8 = (java.util.List) r8
            java.util.Iterator r8 = r8.iterator()
            r9 = r18
        L_0x0661:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x072b
            java.lang.Object r9 = r8.next()
            com.google.android.gms.internal.measurement.zzbj$zze r9 = (com.google.android.gms.internal.measurement.zzbj.zze) r9
            com.google.android.gms.measurement.internal.zzfk r11 = r52.zzr()
            r12 = 2
            boolean r11 = r11.zza(r12)
            if (r11 == 0) goto L_0x06ba
            com.google.android.gms.measurement.internal.zzfk r11 = r52.zzr()
            com.google.android.gms.measurement.internal.zzfm r11 = r11.zzx()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r7)
            boolean r13 = r9.zza()
            if (r13 == 0) goto L_0x0693
            int r13 = r9.zzb()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            goto L_0x0694
        L_0x0693:
            r13 = 0
        L_0x0694:
            com.google.android.gms.measurement.internal.zzfi r14 = r52.zzo()
            java.lang.String r15 = r9.zzc()
            java.lang.String r14 = r14.zzc(r15)
            java.lang.String r15 = "Evaluating filter. audience, filter, property"
            r11.zza(r15, r12, r13, r14)
            com.google.android.gms.measurement.internal.zzfk r11 = r52.zzr()
            com.google.android.gms.measurement.internal.zzfm r11 = r11.zzx()
            com.google.android.gms.measurement.internal.zzkw r12 = r52.zzg()
            java.lang.String r12 = r12.zza(r9)
            java.lang.String r13 = "Filter definition"
            r11.zza(r13, r12)
        L_0x06ba:
            boolean r11 = r9.zza()
            if (r11 == 0) goto L_0x0703
            int r11 = r9.zzb()
            r12 = 256(0x100, float:3.59E-43)
            if (r11 <= r12) goto L_0x06c9
            goto L_0x0703
        L_0x06c9:
            com.google.android.gms.measurement.internal.zzt r11 = new com.google.android.gms.measurement.internal.zzt
            java.lang.String r12 = r10.zzb
            r11.<init>(r10, r12, r7, r9)
            java.lang.Long r12 = r10.zze
            java.lang.Long r13 = r10.zzf
            int r9 = r9.zzb()
            boolean r9 = r10.zza(r7, r9)
            boolean r9 = r11.zza(r12, r13, r4, r9)
            com.google.android.gms.measurement.internal.zzx r12 = r52.zzt()
            java.lang.String r13 = r10.zzb
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzap.zzbu
            boolean r12 = r12.zzd(r13, r14)
            if (r12 == 0) goto L_0x06fa
            if (r9 != 0) goto L_0x06fa
            java.util.Set<java.lang.Integer> r8 = r10.zzc
            java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
            r8.add(r11)
            goto L_0x072b
        L_0x06fa:
            com.google.android.gms.measurement.internal.zzp r12 = r10.zza(r7)
            r12.zza(r11)
            goto L_0x0661
        L_0x0703:
            com.google.android.gms.measurement.internal.zzfk r8 = r52.zzr()
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzi()
            java.lang.String r11 = r10.zzb
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfk.zza(r11)
            boolean r12 = r9.zza()
            if (r12 == 0) goto L_0x0720
            int r9 = r9.zzb()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x0721
        L_0x0720:
            r9 = 0
        L_0x0721:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r12 = "Invalid property filter ID. appId, id"
            r8.zza(r12, r11, r9)
            r9 = 0
        L_0x072b:
            if (r9 != 0) goto L_0x0625
            java.util.Set<java.lang.Integer> r8 = r10.zzc
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r8.add(r7)
            goto L_0x0625
        L_0x0738:
            com.google.android.gms.measurement.internal.zzx r1 = r52.zzt()
            java.lang.String r2 = r10.zzb
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzap.zzbs
            boolean r1 = r1.zzd(r2, r3)
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            if (r1 == 0) goto L_0x0755
            com.google.android.gms.measurement.internal.zzac r1 = r52.zzi()
            java.lang.String r2 = r10.zzb
            java.util.Map r2 = r1.zza(r2, r0)
        L_0x0755:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzp> r0 = r10.zzd
            java.util.Set r0 = r0.keySet()
            java.util.Set<java.lang.Integer> r3 = r10.zzc
            r0.removeAll(r3)
            java.util.Iterator r3 = r0.iterator()
        L_0x0769:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0804
            java.lang.Object r0 = r3.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzp> r4 = r10.zzd
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            java.lang.Object r4 = r4.get(r5)
            com.google.android.gms.measurement.internal.zzp r4 = (com.google.android.gms.measurement.internal.zzp) r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            java.lang.Object r5 = r2.get(r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzbr$zza r4 = r4.zza(r0, r5)
            r1.add(r4)
            com.google.android.gms.measurement.internal.zzac r5 = r52.zzi()
            java.lang.String r6 = r10.zzb
            com.google.android.gms.internal.measurement.zzbr$zzi r4 = r4.zzc()
            r5.zzak()
            r5.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            byte[] r4 = r4.zzbi()
            android.content.ContentValues r7 = new android.content.ContentValues
            r7.<init>()
            java.lang.String r8 = "app_id"
            r7.put(r8, r6)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r8 = "audience_id"
            r7.put(r8, r0)
            java.lang.String r0 = "current_results"
            r7.put(r0, r4)
            android.database.sqlite.SQLiteDatabase r0 = r5.c_()     // Catch:{ SQLiteException -> 0x07ef }
            java.lang.String r4 = "audience_filter_values"
            r8 = 5
            r9 = 0
            long r7 = r0.insertWithOnConflict(r4, r9, r7, r8)     // Catch:{ SQLiteException -> 0x07ed }
            r11 = -1
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x0769
            com.google.android.gms.measurement.internal.zzfk r0 = r5.zzr()     // Catch:{ SQLiteException -> 0x07ed }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x07ed }
            java.lang.String r4 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfk.zza(r6)     // Catch:{ SQLiteException -> 0x07ed }
            r0.zza(r4, r7)     // Catch:{ SQLiteException -> 0x07ed }
            goto L_0x0769
        L_0x07ed:
            r0 = move-exception
            goto L_0x07f1
        L_0x07ef:
            r0 = move-exception
            r9 = 0
        L_0x07f1:
            com.google.android.gms.measurement.internal.zzfk r4 = r5.zzr()
            com.google.android.gms.measurement.internal.zzfm r4 = r4.zzf()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfk.zza(r6)
            java.lang.String r6 = "Error storing filter results. appId"
            r4.zza(r6, r5, r0)
            goto L_0x0769
        L_0x0804:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzn.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    private final zzp zza(int i) {
        if (this.zzd.containsKey(Integer.valueOf(i))) {
            return this.zzd.get(Integer.valueOf(i));
        }
        zzp zzp = new zzp(this, this.zzb, null);
        this.zzd.put(Integer.valueOf(i), zzp);
        return zzp;
    }

    private final boolean zza(int i, int i2) {
        if (this.zzd.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.zzd.get(Integer.valueOf(i)).zzd.get(i2);
    }
}
