package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public final class zzaq implements zzau {
    private static final Map<Uri, zzaq> zzfj = new ArrayMap();
    private static final String[] zzfp = {"key", "value"};
    private final Uri uri;
    private final ContentResolver zzfk;
    private final ContentObserver zzfl = new zzas(this, null);
    private final Object zzfm = new Object();
    private volatile Map<String, String> zzfn;
    private final List<zzar> zzfo = new ArrayList();

    private zzaq(ContentResolver contentResolver, Uri uri2) {
        this.zzfk = contentResolver;
        this.uri = uri2;
        contentResolver.registerContentObserver(uri2, false, this.zzfl);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(5:5|6|7|8|9)|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.vision.zzaq zza(android.content.ContentResolver r3, android.net.Uri r4) {
        /*
            java.lang.Class<com.google.android.gms.internal.vision.zzaq> r0 = com.google.android.gms.internal.vision.zzaq.class
            monitor-enter(r0)
            java.util.Map<android.net.Uri, com.google.android.gms.internal.vision.zzaq> r1 = com.google.android.gms.internal.vision.zzaq.zzfj     // Catch:{ all -> 0x001a }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.vision.zzaq r1 = (com.google.android.gms.internal.vision.zzaq) r1     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0018
            com.google.android.gms.internal.vision.zzaq r2 = new com.google.android.gms.internal.vision.zzaq     // Catch:{ SecurityException -> 0x0018 }
            r2.<init>(r3, r4)     // Catch:{ SecurityException -> 0x0018 }
            java.util.Map<android.net.Uri, com.google.android.gms.internal.vision.zzaq> r3 = com.google.android.gms.internal.vision.zzaq.zzfj     // Catch:{ SecurityException -> 0x0017 }
            r3.put(r4, r2)     // Catch:{ SecurityException -> 0x0017 }
        L_0x0017:
            r1 = r2
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return r1
        L_0x001a:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzaq.zza(android.content.ContentResolver, android.net.Uri):com.google.android.gms.internal.vision.zzaq");
    }

    private final Map<String, String> zzu() {
        Map<String, String> map = this.zzfn;
        if (map == null) {
            synchronized (this.zzfm) {
                map = this.zzfn;
                if (map == null) {
                    map = zzw();
                    this.zzfn = map;
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.emptyMap();
    }

    public final void zzv() {
        synchronized (this.zzfm) {
            this.zzfn = null;
            zzbe.zzab();
        }
        synchronized (this) {
            for (zzar zzz : this.zzfo) {
                zzz.zzz();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private final Map<String, String> zzw() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Map<String, String> map = (Map) zzat.zza(new zzap(this));
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return map;
        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return null;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    static synchronized void zzx() {
        synchronized (zzaq.class) {
            for (zzaq next : zzfj.values()) {
                next.zzfk.unregisterContentObserver(next.zzfl);
            }
            zzfj.clear();
        }
    }

    public final /* synthetic */ Object zzb(String str) {
        return zzu().get(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map zzy() {
        Map map;
        Cursor query = this.zzfk.query(this.uri, zzfp, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            query.close();
            return map;
        } finally {
            query.close();
        }
    }
}
