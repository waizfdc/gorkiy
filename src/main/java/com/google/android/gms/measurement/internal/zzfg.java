package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.util.Clock;
import okhttp3.internal.cache.DiskLruCache;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public final class zzfg extends zze {
    private final zzff zza = new zzff(this, zzn(), "google_app_measurement_local.db");
    private boolean zzb;

    zzfg(zzgo zzgo) {
        super(zzgo);
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    public final void zzab() {
        zzb();
        zzd();
        try {
            int delete = zzae().delete("messages", null, null) + 0;
            if (delete > 0) {
                zzr().zzx().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error resetting local analytics data. error", e);
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:72:0x0100 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:63:0x00ee */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c4 A[SYNTHETIC, Splitter:B:47:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x011a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x011a A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.zzb()
            r16.zzd()
            boolean r0 = r1.zzb
            r2 = 0
            if (r0 == 0) goto L_0x000e
            return r2
        L_0x000e:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            java.lang.String r4 = "type"
            r3.put(r4, r0)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            r4 = 5
            r5 = r2
            r6 = r4
        L_0x0026:
            if (r5 >= r4) goto L_0x012c
            r7 = 0
            r8 = 1
            android.database.sqlite.SQLiteDatabase r9 = r16.zzae()     // Catch:{ SQLiteFullException -> 0x00fe, SQLiteDatabaseLockedException -> 0x00ec, SQLiteException -> 0x00c0, all -> 0x00bd }
            if (r9 != 0) goto L_0x0038
            r1.zzb = r8     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ed, SQLiteException -> 0x00b7 }
            if (r9 == 0) goto L_0x0037
            r9.close()
        L_0x0037:
            return r2
        L_0x0038:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ed, SQLiteException -> 0x00b7 }
            r10 = 0
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r12 = r9.rawQuery(r0, r7)     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ed, SQLiteException -> 0x00b7 }
            if (r12 == 0) goto L_0x0059
            boolean r0 = r12.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            if (r0 == 0) goto L_0x0059
            long r10 = r12.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            goto L_0x0059
        L_0x0050:
            r0 = move-exception
            goto L_0x00ea
        L_0x0053:
            r0 = move-exception
            goto L_0x00b9
        L_0x0055:
            r0 = move-exception
            r7 = r12
            goto L_0x0100
        L_0x0059:
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r0 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            java.lang.String r15 = "messages"
            if (r0 < 0) goto L_0x00a0
            com.google.android.gms.measurement.internal.zzfk r0 = r16.zzr()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            java.lang.String r4 = "Data loss, local db full"
            r0.zza(r4)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            long r13 = r13 - r10
            r10 = 1
            long r13 = r13 + r10
            java.lang.String r0 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r4 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            java.lang.String r10 = java.lang.Long.toString(r13)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            r4[r2] = r10     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            int r0 = r9.delete(r15, r0, r4)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            long r10 = (long) r0     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            int r0 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x00a0
            com.google.android.gms.measurement.internal.zzfk r0 = r16.zzr()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            java.lang.String r4 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            long r13 = r13 - r10
            java.lang.Long r10 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            r0.zza(r4, r2, r8, r10)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
        L_0x00a0:
            r9.insertOrThrow(r15, r7, r3)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            if (r12 == 0) goto L_0x00ae
            r12.close()
        L_0x00ae:
            if (r9 == 0) goto L_0x00b3
            r9.close()
        L_0x00b3:
            r2 = 1
            return r2
        L_0x00b5:
            r7 = r12
            goto L_0x00ed
        L_0x00b7:
            r0 = move-exception
            r12 = r7
        L_0x00b9:
            r7 = r9
            goto L_0x00c2
        L_0x00bb:
            r0 = move-exception
            goto L_0x0100
        L_0x00bd:
            r0 = move-exception
            r9 = r7
            goto L_0x0121
        L_0x00c0:
            r0 = move-exception
            r12 = r7
        L_0x00c2:
            if (r7 == 0) goto L_0x00cd
            boolean r2 = r7.inTransaction()     // Catch:{ all -> 0x00e8 }
            if (r2 == 0) goto L_0x00cd
            r7.endTransaction()     // Catch:{ all -> 0x00e8 }
        L_0x00cd:
            com.google.android.gms.measurement.internal.zzfk r2 = r16.zzr()     // Catch:{ all -> 0x00e8 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()     // Catch:{ all -> 0x00e8 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zza(r4, r0)     // Catch:{ all -> 0x00e8 }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x00e8 }
            if (r12 == 0) goto L_0x00e2
            r12.close()
        L_0x00e2:
            if (r7 == 0) goto L_0x011a
            r7.close()
            goto L_0x011a
        L_0x00e8:
            r0 = move-exception
            r9 = r7
        L_0x00ea:
            r7 = r12
            goto L_0x0121
        L_0x00ec:
            r9 = r7
        L_0x00ed:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x0120 }
            int r6 = r6 + 20
            if (r7 == 0) goto L_0x00f8
            r7.close()
        L_0x00f8:
            if (r9 == 0) goto L_0x011a
            r9.close()
            goto L_0x011a
        L_0x00fe:
            r0 = move-exception
            r9 = r7
        L_0x0100:
            com.google.android.gms.measurement.internal.zzfk r2 = r16.zzr()     // Catch:{ all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzfm r2 = r2.zzf()     // Catch:{ all -> 0x0120 }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zza(r4, r0)     // Catch:{ all -> 0x0120 }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x0120 }
            if (r7 == 0) goto L_0x0115
            r7.close()
        L_0x0115:
            if (r9 == 0) goto L_0x011a
            r9.close()
        L_0x011a:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0026
        L_0x0120:
            r0 = move-exception
        L_0x0121:
            if (r7 == 0) goto L_0x0126
            r7.close()
        L_0x0126:
            if (r9 == 0) goto L_0x012b
            r9.close()
        L_0x012b:
            throw r0
        L_0x012c:
            com.google.android.gms.measurement.internal.zzfk r0 = r16.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzx()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfg.zza(int, byte[]):boolean");
    }

    public final boolean zza(zzan zzan) {
        Parcel obtain = Parcel.obtain();
        zzan.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzr().zzg().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzkz zzkz) {
        Parcel obtain = Parcel.obtain();
        zzkz.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzr().zzg().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zza(zzv zzv) {
        zzp();
        byte[] zza2 = zzla.zza((Parcelable) zzv);
        if (zza2.length <= 131072) {
            return zza(2, zza2);
        }
        zzr().zzg().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:78|79|80|81) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:93|94|95|96) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:65|66|67|68|212) */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01d8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01d9, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01de, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01df, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01e2, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01e5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01e6, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x01e9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x01ea, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01f4, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x01fe, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0205, code lost:
        r13 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0206, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x020b, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0219, code lost:
        if (r15.inTransaction() != false) goto L_0x021b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x021b, code lost:
        r15.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x022d, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0232, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0240, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0245, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x025b, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0260, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0267, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0268, code lost:
        r3 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0269, code lost:
        r13 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x026c, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0271, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0088, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0089, code lost:
        r15 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008e, code lost:
        r15 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0092, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0093, code lost:
        r24 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0097, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        zzr().zzf().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        zzr().zzf().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        zzr().zzf().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00ef */
    /* JADX WARNING: Missing exception handler attribute for start block: B:78:0x011f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x0155 */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01d8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:51:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:132:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:51:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01e9 A[ExcHandler: all (th java.lang.Throwable), PHI: r24 10  PHI: (r24v3 android.database.sqlite.SQLiteDatabase) = (r24v5 android.database.sqlite.SQLiteDatabase), (r24v9 android.database.sqlite.SQLiteDatabase) binds: [B:48:0x00a5, B:35:0x0083] A[DONT_GENERATE, DONT_INLINE], Splitter:B:35:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:141:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), PHI: r24 10  PHI: (r24v1 android.database.sqlite.SQLiteDatabase) = (r24v5 android.database.sqlite.SQLiteDatabase), (r24v9 android.database.sqlite.SQLiteDatabase) binds: [B:48:0x00a5, B:35:0x0083] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:35:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01fe A[ExcHandler: all (th java.lang.Throwable), Splitter:B:12:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0215 A[SYNTHETIC, Splitter:B:162:0x0215] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0263 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0263 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0263 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zza(int r24) {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r2 = "Error reading entries from local database"
            r23.zzd()
            r23.zzb()
            boolean r0 = r1.zzb
            r3 = 0
            if (r0 == 0) goto L_0x0010
            return r3
        L_0x0010:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r0 = r23.zzaf()
            if (r0 != 0) goto L_0x001c
            return r4
        L_0x001c:
            r5 = 5
            r6 = 0
            r8 = r5
            r7 = r6
        L_0x0020:
            if (r7 >= r5) goto L_0x0275
            r9 = 1
            android.database.sqlite.SQLiteDatabase r15 = r23.zzae()     // Catch:{ SQLiteFullException -> 0x0249, SQLiteDatabaseLockedException -> 0x0236, SQLiteException -> 0x0210, all -> 0x020d }
            if (r15 != 0) goto L_0x0037
            r1.zzb = r9     // Catch:{ SQLiteFullException -> 0x0034, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x0031, all -> 0x01fe }
            if (r15 == 0) goto L_0x0030
            r15.close()
        L_0x0030:
            return r3
        L_0x0031:
            r0 = move-exception
            goto L_0x0203
        L_0x0034:
            r0 = move-exception
            goto L_0x020b
        L_0x0037:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0209, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x0201, all -> 0x01fe }
            com.google.android.gms.measurement.internal.zzx r0 = r23.zzt()     // Catch:{ SQLiteFullException -> 0x0209, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x0201, all -> 0x01fe }
            com.google.android.gms.measurement.internal.zzez<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzap.zzbz     // Catch:{ SQLiteFullException -> 0x0209, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x0201, all -> 0x01fe }
            boolean r0 = r0.zza(r10)     // Catch:{ SQLiteFullException -> 0x0209, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x0201, all -> 0x01fe }
            r10 = 100
            java.lang.String r11 = "entry"
            java.lang.String r12 = "type"
            java.lang.String r13 = "rowid"
            r19 = -1
            if (r0 == 0) goto L_0x00a1
            long r16 = zza(r15)     // Catch:{ SQLiteFullException -> 0x009c, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x0097, all -> 0x0092 }
            int r0 = (r16 > r19 ? 1 : (r16 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0063
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r14 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0034, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x0031, all -> 0x01fe }
            java.lang.String r16 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteFullException -> 0x0034, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x0031, all -> 0x01fe }
            r14[r6] = r16     // Catch:{ SQLiteFullException -> 0x0034, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x0031, all -> 0x01fe }
            goto L_0x0065
        L_0x0063:
            r0 = r3
            r14 = r0
        L_0x0065:
            java.lang.String r16 = "messages"
            java.lang.String[] r12 = new java.lang.String[]{r13, r12, r11}     // Catch:{ SQLiteFullException -> 0x009c, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x0097, all -> 0x0092 }
            r17 = 0
            r18 = 0
            java.lang.String r21 = "rowid asc"
            java.lang.String r22 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x009c, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x0097, all -> 0x0092 }
            r10 = r15
            r11 = r16
            r13 = r0
            r24 = r15
            r15 = r17
            r16 = r18
            r17 = r21
            r18 = r22
            android.database.Cursor r0 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x008d, SQLiteDatabaseLockedException -> 0x01f4, SQLiteException -> 0x0088, all -> 0x01e9 }
            goto L_0x00bb
        L_0x0088:
            r0 = move-exception
            r15 = r24
            goto L_0x0203
        L_0x008d:
            r0 = move-exception
            r15 = r24
            goto L_0x020b
        L_0x0092:
            r0 = move-exception
            r24 = r15
            goto L_0x01ea
        L_0x0097:
            r0 = move-exception
            r24 = r15
            goto L_0x0203
        L_0x009c:
            r0 = move-exception
            r24 = r15
            goto L_0x020b
        L_0x00a1:
            r24 = r15
            java.lang.String r0 = "messages"
            java.lang.String[] r12 = new java.lang.String[]{r13, r12, r11}     // Catch:{ SQLiteFullException -> 0x01f7, SQLiteDatabaseLockedException -> 0x01f4, SQLiteException -> 0x01ee, all -> 0x01e9 }
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            java.lang.String r17 = "rowid asc"
            java.lang.String r18 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x01f7, SQLiteDatabaseLockedException -> 0x01f4, SQLiteException -> 0x01ee, all -> 0x01e9 }
            r10 = r24
            r11 = r0
            android.database.Cursor r0 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x01f7, SQLiteDatabaseLockedException -> 0x01f4, SQLiteException -> 0x01ee, all -> 0x01e9 }
        L_0x00bb:
            r10 = r0
        L_0x00bc:
            boolean r0 = r10.moveToNext()     // Catch:{ SQLiteFullException -> 0x01e5, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x01de, all -> 0x01d8 }
            if (r0 == 0) goto L_0x019c
            long r19 = r10.getLong(r6)     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            int r0 = r10.getInt(r9)     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            r11 = 2
            byte[] r12 = r10.getBlob(r11)     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            if (r0 != 0) goto L_0x0104
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            int r0 = r12.length     // Catch:{ ParseException -> 0x00ef }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x00ef }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x00ef }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzan> r0 = com.google.android.gms.measurement.internal.zzan.CREATOR     // Catch:{ ParseException -> 0x00ef }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x00ef }
            com.google.android.gms.measurement.internal.zzan r0 = (com.google.android.gms.measurement.internal.zzan) r0     // Catch:{ ParseException -> 0x00ef }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            if (r0 == 0) goto L_0x00bc
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            goto L_0x00bc
        L_0x00ed:
            r0 = move-exception
            goto L_0x0100
        L_0x00ef:
            com.google.android.gms.measurement.internal.zzfk r0 = r23.zzr()     // Catch:{ all -> 0x00ed }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ all -> 0x00ed }
            java.lang.String r12 = "Failed to load event from local database"
            r0.zza(r12)     // Catch:{ all -> 0x00ed }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            goto L_0x00bc
        L_0x0100:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
        L_0x0104:
            if (r0 != r9) goto L_0x013a
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            int r0 = r12.length     // Catch:{ ParseException -> 0x011f }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x011f }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x011f }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkz> r0 = com.google.android.gms.measurement.internal.zzkz.CREATOR     // Catch:{ ParseException -> 0x011f }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x011f }
            com.google.android.gms.measurement.internal.zzkz r0 = (com.google.android.gms.measurement.internal.zzkz) r0     // Catch:{ ParseException -> 0x011f }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            goto L_0x0130
        L_0x011d:
            r0 = move-exception
            goto L_0x0136
        L_0x011f:
            com.google.android.gms.measurement.internal.zzfk r0 = r23.zzr()     // Catch:{ all -> 0x011d }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ all -> 0x011d }
            java.lang.String r12 = "Failed to load user property from local database"
            r0.zza(r12)     // Catch:{ all -> 0x011d }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            r0 = r3
        L_0x0130:
            if (r0 == 0) goto L_0x00bc
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            goto L_0x00bc
        L_0x0136:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
        L_0x013a:
            if (r0 != r11) goto L_0x0171
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            int r0 = r12.length     // Catch:{ ParseException -> 0x0155 }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x0155 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x0155 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzv> r0 = com.google.android.gms.measurement.internal.zzv.CREATOR     // Catch:{ ParseException -> 0x0155 }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x0155 }
            com.google.android.gms.measurement.internal.zzv r0 = (com.google.android.gms.measurement.internal.zzv) r0     // Catch:{ ParseException -> 0x0155 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            goto L_0x0166
        L_0x0153:
            r0 = move-exception
            goto L_0x016d
        L_0x0155:
            com.google.android.gms.measurement.internal.zzfk r0 = r23.zzr()     // Catch:{ all -> 0x0153 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ all -> 0x0153 }
            java.lang.String r12 = "Failed to load conditional user property from local database"
            r0.zza(r12)     // Catch:{ all -> 0x0153 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            r0 = r3
        L_0x0166:
            if (r0 == 0) goto L_0x00bc
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            goto L_0x00bc
        L_0x016d:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
        L_0x0171:
            r11 = 3
            if (r0 != r11) goto L_0x0183
            com.google.android.gms.measurement.internal.zzfk r0 = r23.zzr()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzi()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            java.lang.String r11 = "Skipping app launch break"
            r0.zza(r11)     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            goto L_0x00bc
        L_0x0183:
            com.google.android.gms.measurement.internal.zzfk r0 = r23.zzr()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            java.lang.String r11 = "Unknown record type in local database"
            r0.zza(r11)     // Catch:{ SQLiteFullException -> 0x0197, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x0192, all -> 0x01d8 }
            goto L_0x00bc
        L_0x0192:
            r0 = move-exception
            r15 = r24
            goto L_0x0213
        L_0x0197:
            r0 = move-exception
            r15 = r24
            goto L_0x024c
        L_0x019c:
            java.lang.String r0 = "messages"
            java.lang.String r11 = "rowid <= ?"
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x01e5, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x01de, all -> 0x01d8 }
            java.lang.String r13 = java.lang.Long.toString(r19)     // Catch:{ SQLiteFullException -> 0x01e5, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x01de, all -> 0x01d8 }
            r12[r6] = r13     // Catch:{ SQLiteFullException -> 0x01e5, SQLiteDatabaseLockedException -> 0x01e2, SQLiteException -> 0x01de, all -> 0x01d8 }
            r13 = r24
            int r0 = r13.delete(r0, r11, r12)     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x0207, SQLiteException -> 0x01d4, all -> 0x01d2 }
            int r11 = r4.size()     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x0207, SQLiteException -> 0x01d4, all -> 0x01d2 }
            if (r0 >= r11) goto L_0x01c1
            com.google.android.gms.measurement.internal.zzfk r0 = r23.zzr()     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x0207, SQLiteException -> 0x01d4, all -> 0x01d2 }
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzf()     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x0207, SQLiteException -> 0x01d4, all -> 0x01d2 }
            java.lang.String r11 = "Fewer entries removed from local database than expected"
            r0.zza(r11)     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x0207, SQLiteException -> 0x01d4, all -> 0x01d2 }
        L_0x01c1:
            r13.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x0207, SQLiteException -> 0x01d4, all -> 0x01d2 }
            r13.endTransaction()     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x0207, SQLiteException -> 0x01d4, all -> 0x01d2 }
            if (r10 == 0) goto L_0x01cc
            r10.close()
        L_0x01cc:
            if (r13 == 0) goto L_0x01d1
            r13.close()
        L_0x01d1:
            return r4
        L_0x01d2:
            r0 = move-exception
            goto L_0x01db
        L_0x01d4:
            r0 = move-exception
            goto L_0x01f2
        L_0x01d6:
            r0 = move-exception
            goto L_0x01fb
        L_0x01d8:
            r0 = move-exception
            r13 = r24
        L_0x01db:
            r3 = r10
            goto L_0x026a
        L_0x01de:
            r0 = move-exception
            r13 = r24
            goto L_0x01f2
        L_0x01e2:
            r13 = r24
            goto L_0x0207
        L_0x01e5:
            r0 = move-exception
            r13 = r24
            goto L_0x01fb
        L_0x01e9:
            r0 = move-exception
        L_0x01ea:
            r13 = r24
            goto L_0x026a
        L_0x01ee:
            r0 = move-exception
            r13 = r24
            r10 = r3
        L_0x01f2:
            r15 = r13
            goto L_0x0213
        L_0x01f4:
            r13 = r24
            goto L_0x0206
        L_0x01f7:
            r0 = move-exception
            r13 = r24
            r10 = r3
        L_0x01fb:
            r15 = r13
            goto L_0x024c
        L_0x01fe:
            r0 = move-exception
            goto L_0x0269
        L_0x0201:
            r0 = move-exception
            r13 = r15
        L_0x0203:
            r10 = r3
            goto L_0x0213
        L_0x0205:
            r13 = r15
        L_0x0206:
            r10 = r3
        L_0x0207:
            r15 = r13
            goto L_0x0238
        L_0x0209:
            r0 = move-exception
            r13 = r15
        L_0x020b:
            r10 = r3
            goto L_0x024c
        L_0x020d:
            r0 = move-exception
            r13 = r3
            goto L_0x026a
        L_0x0210:
            r0 = move-exception
            r10 = r3
            r15 = r10
        L_0x0213:
            if (r15 == 0) goto L_0x021e
            boolean r11 = r15.inTransaction()     // Catch:{ all -> 0x0267 }
            if (r11 == 0) goto L_0x021e
            r15.endTransaction()     // Catch:{ all -> 0x0267 }
        L_0x021e:
            com.google.android.gms.measurement.internal.zzfk r11 = r23.zzr()     // Catch:{ all -> 0x0267 }
            com.google.android.gms.measurement.internal.zzfm r11 = r11.zzf()     // Catch:{ all -> 0x0267 }
            r11.zza(r2, r0)     // Catch:{ all -> 0x0267 }
            r1.zzb = r9     // Catch:{ all -> 0x0267 }
            if (r10 == 0) goto L_0x0230
            r10.close()
        L_0x0230:
            if (r15 == 0) goto L_0x0263
            r15.close()
            goto L_0x0263
        L_0x0236:
            r10 = r3
            r15 = r10
        L_0x0238:
            long r11 = (long) r8
            android.os.SystemClock.sleep(r11)     // Catch:{ all -> 0x0267 }
            int r8 = r8 + 20
            if (r10 == 0) goto L_0x0243
            r10.close()
        L_0x0243:
            if (r15 == 0) goto L_0x0263
            r15.close()
            goto L_0x0263
        L_0x0249:
            r0 = move-exception
            r10 = r3
            r15 = r10
        L_0x024c:
            com.google.android.gms.measurement.internal.zzfk r11 = r23.zzr()     // Catch:{ all -> 0x0267 }
            com.google.android.gms.measurement.internal.zzfm r11 = r11.zzf()     // Catch:{ all -> 0x0267 }
            r11.zza(r2, r0)     // Catch:{ all -> 0x0267 }
            r1.zzb = r9     // Catch:{ all -> 0x0267 }
            if (r10 == 0) goto L_0x025e
            r10.close()
        L_0x025e:
            if (r15 == 0) goto L_0x0263
            r15.close()
        L_0x0263:
            int r7 = r7 + 1
            goto L_0x0020
        L_0x0267:
            r0 = move-exception
            r3 = r10
        L_0x0269:
            r13 = r15
        L_0x026a:
            if (r3 == 0) goto L_0x026f
            r3.close()
        L_0x026f:
            if (r13 == 0) goto L_0x0274
            r13.close()
        L_0x0274:
            throw r0
        L_0x0275:
            com.google.android.gms.measurement.internal.zzfk r0 = r23.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzi()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zza(r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfg.zza(int):java.util.List");
    }

    public final boolean zzac() {
        return zza(3, new byte[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0089, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzad() {
        /*
            r11 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r11.zzd()
            r11.zzb()
            boolean r1 = r11.zzb
            r2 = 0
            if (r1 == 0) goto L_0x000e
            return r2
        L_0x000e:
            boolean r1 = r11.zzaf()
            if (r1 != 0) goto L_0x0015
            return r2
        L_0x0015:
            r1 = 5
            r4 = r1
            r3 = r2
        L_0x0018:
            if (r3 >= r1) goto L_0x0092
            r5 = 0
            r6 = 1
            android.database.sqlite.SQLiteDatabase r5 = r11.zzae()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            if (r5 != 0) goto L_0x002a
            r11.zzb = r6     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            if (r5 == 0) goto L_0x0029
            r5.close()
        L_0x0029:
            return r2
        L_0x002a:
            r5.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            java.lang.String r7 = "messages"
            java.lang.String r8 = "type == ?"
            java.lang.String[] r9 = new java.lang.String[r6]     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r10 = 3
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r9[r2] = r10     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r5.delete(r7, r8, r9)     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r5.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r5.endTransaction()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            if (r5 == 0) goto L_0x0048
            r5.close()
        L_0x0048:
            return r6
        L_0x0049:
            r0 = move-exception
            goto L_0x008c
        L_0x004b:
            r7 = move-exception
            if (r5 == 0) goto L_0x0057
            boolean r8 = r5.inTransaction()     // Catch:{ all -> 0x0049 }
            if (r8 == 0) goto L_0x0057
            r5.endTransaction()     // Catch:{ all -> 0x0049 }
        L_0x0057:
            com.google.android.gms.measurement.internal.zzfk r8 = r11.zzr()     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzf()     // Catch:{ all -> 0x0049 }
            r8.zza(r0, r7)     // Catch:{ all -> 0x0049 }
            r11.zzb = r6     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0089
            r5.close()
            goto L_0x0089
        L_0x006a:
            long r6 = (long) r4
            android.os.SystemClock.sleep(r6)     // Catch:{ all -> 0x0049 }
            int r4 = r4 + 20
            if (r5 == 0) goto L_0x0089
            r5.close()
            goto L_0x0089
        L_0x0076:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzfk r8 = r11.zzr()     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.zzfm r8 = r8.zzf()     // Catch:{ all -> 0x0049 }
            r8.zza(r0, r7)     // Catch:{ all -> 0x0049 }
            r11.zzb = r6     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0089
            r5.close()
        L_0x0089:
            int r3 = r3 + 1
            goto L_0x0018
        L_0x008c:
            if (r5 == 0) goto L_0x0091
            r5.close()
        L_0x0091:
            throw r0
        L_0x0092:
            com.google.android.gms.measurement.internal.zzfk r0 = r11.zzr()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzi()
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.zza(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfg.zzad():boolean");
    }

    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, null, null, "rowid desc", DiskLruCache.VERSION_1);
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final SQLiteDatabase zzae() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    private final boolean zzaf() {
        return zzn().getDatabasePath("google_app_measurement_local.db").exists();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzhp zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzfd zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzix zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zziw zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfg zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzkc zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzfi zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzla zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzgh zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfk zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzft zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }
}
