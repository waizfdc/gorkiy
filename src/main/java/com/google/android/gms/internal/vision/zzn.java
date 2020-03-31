package com.google.android.gms.internal.vision;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public abstract class zzn<T> {
    private static String PREFIX = "com.google.android.gms.vision.dynamite";
    private final Object lock = new Object();
    private final String tag;
    private final String zzde;
    private final String zzdf;
    private final boolean zzdg;
    private boolean zzdh;
    private boolean zzdi;
    private T zzdj;
    private final Context zze;

    public zzn(Context context, String str, String str2) {
        boolean z = false;
        this.zzdh = false;
        this.zzdi = false;
        this.zze = context;
        this.tag = str;
        String str3 = PREFIX;
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str2).length());
        sb.append(str3);
        sb.append(".");
        sb.append(str2);
        this.zzde = sb.toString();
        this.zzdf = str2;
        if (context != null) {
            zzbe.maybeInit(context);
            zzdg zza = zzdg.zza("barcode", Boolean.valueOf(zzkv.zzjp()), "face", Boolean.TRUE, "ica", Boolean.valueOf(zzkv.zzjq()), "ocr", Boolean.TRUE);
            if (zza.containsKey(str2) && ((Boolean) zza.get(str2)).booleanValue()) {
                z = true;
            }
        }
        this.zzdg = z;
    }

    /* access modifiers changed from: protected */
    public abstract T zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException;

    /* access modifiers changed from: protected */
    public abstract void zzn() throws RemoteException;

    public final boolean isOperational() {
        return zzp() != null;
    }

    public final void zzo() {
        synchronized (this.lock) {
            if (this.zzdj != null) {
                try {
                    zzn();
                } catch (RemoteException e) {
                    Log.e(this.tag, "Could not finalize native handle", e);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|(3:18|(1:20)(1:21)|22)) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        android.util.Log.d(r7.tag, "Cannot load feature, fall back to load dynamite module.");
        r2 = com.google.android.gms.internal.vision.zzr.zza(r7.zze, r7.zzdf, r7.zzdg);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        r3 = r7.tag;
        r5 = java.lang.String.valueOf(r7.zzdf);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        if (r5.length() != 0) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
        r4 = "Broadcasting download intent for dependency ".concat(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0047, code lost:
        r4 = new java.lang.String("Broadcasting download intent for dependency ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        android.util.Log.d(r3, r4);
        r3 = r7.zzdf;
        r4 = new android.content.Intent();
        r4.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
        r4.putExtra("com.google.android.gms.vision.DEPENDENCIES", r3);
        r4.setAction("com.google.android.gms.vision.DEPENDENCY");
        r7.zze.sendBroadcast(r4);
        r7.zzdh = true;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzp() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.lock
            monitor-enter(r0)
            T r1 = r7.zzdj     // Catch:{ all -> 0x00a9 }
            if (r1 == 0) goto L_0x000b
            T r1 = r7.zzdj     // Catch:{ all -> 0x00a9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            return r1
        L_0x000b:
            r1 = 1
            android.content.Context r2 = r7.zze     // Catch:{ LoadingException -> 0x0017 }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy r3 = com.google.android.gms.dynamite.DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION     // Catch:{ LoadingException -> 0x0017 }
            java.lang.String r4 = r7.zzde     // Catch:{ LoadingException -> 0x0017 }
            com.google.android.gms.dynamite.DynamiteModule r2 = com.google.android.gms.dynamite.DynamiteModule.load(r2, r3, r4)     // Catch:{ LoadingException -> 0x0017 }
            goto L_0x006f
        L_0x0017:
            java.lang.String r2 = r7.tag     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = "Cannot load feature, fall back to load dynamite module."
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x00a9 }
            android.content.Context r2 = r7.zze     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = r7.zzdf     // Catch:{ all -> 0x00a9 }
            boolean r4 = r7.zzdg     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.dynamite.DynamiteModule r2 = com.google.android.gms.internal.vision.zzr.zza(r2, r3, r4)     // Catch:{ all -> 0x00a9 }
            if (r2 != 0) goto L_0x006f
            boolean r3 = r7.zzdg     // Catch:{ all -> 0x00a9 }
            if (r3 == 0) goto L_0x006f
            boolean r3 = r7.zzdh     // Catch:{ all -> 0x00a9 }
            if (r3 != 0) goto L_0x006f
            java.lang.String r3 = r7.tag     // Catch:{ all -> 0x00a9 }
            java.lang.String r4 = "Broadcasting download intent for dependency "
            java.lang.String r5 = r7.zzdf     // Catch:{ all -> 0x00a9 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00a9 }
            int r6 = r5.length()     // Catch:{ all -> 0x00a9 }
            if (r6 == 0) goto L_0x0047
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x00a9 }
            goto L_0x004d
        L_0x0047:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x00a9 }
            r5.<init>(r4)     // Catch:{ all -> 0x00a9 }
            r4 = r5
        L_0x004d:
            android.util.Log.d(r3, r4)     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = r7.zzdf     // Catch:{ all -> 0x00a9 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ all -> 0x00a9 }
            r4.<init>()     // Catch:{ all -> 0x00a9 }
            java.lang.String r5 = "com.google.android.gms"
            java.lang.String r6 = "com.google.android.gms.vision.DependencyBroadcastReceiverProxy"
            r4.setClassName(r5, r6)     // Catch:{ all -> 0x00a9 }
            java.lang.String r5 = "com.google.android.gms.vision.DEPENDENCIES"
            r4.putExtra(r5, r3)     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = "com.google.android.gms.vision.DEPENDENCY"
            r4.setAction(r3)     // Catch:{ all -> 0x00a9 }
            android.content.Context r3 = r7.zze     // Catch:{ all -> 0x00a9 }
            r3.sendBroadcast(r4)     // Catch:{ all -> 0x00a9 }
            r7.zzdh = r1     // Catch:{ all -> 0x00a9 }
        L_0x006f:
            if (r2 == 0) goto L_0x0084
            android.content.Context r3 = r7.zze     // Catch:{ LoadingException -> 0x007c, RemoteException -> 0x007a }
            java.lang.Object r2 = r7.zza(r2, r3)     // Catch:{ LoadingException -> 0x007c, RemoteException -> 0x007a }
            r7.zzdj = r2     // Catch:{ LoadingException -> 0x007c, RemoteException -> 0x007a }
            goto L_0x0084
        L_0x007a:
            r2 = move-exception
            goto L_0x007d
        L_0x007c:
            r2 = move-exception
        L_0x007d:
            java.lang.String r3 = r7.tag     // Catch:{ all -> 0x00a9 }
            java.lang.String r4 = "Error creating remote native handle"
            android.util.Log.e(r3, r4, r2)     // Catch:{ all -> 0x00a9 }
        L_0x0084:
            boolean r2 = r7.zzdi     // Catch:{ all -> 0x00a9 }
            if (r2 != 0) goto L_0x0096
            T r2 = r7.zzdj     // Catch:{ all -> 0x00a9 }
            if (r2 != 0) goto L_0x0096
            java.lang.String r2 = r7.tag     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = "Native handle not yet available. Reverting to no-op handle."
            android.util.Log.w(r2, r3)     // Catch:{ all -> 0x00a9 }
            r7.zzdi = r1     // Catch:{ all -> 0x00a9 }
            goto L_0x00a5
        L_0x0096:
            boolean r1 = r7.zzdi     // Catch:{ all -> 0x00a9 }
            if (r1 == 0) goto L_0x00a5
            T r1 = r7.zzdj     // Catch:{ all -> 0x00a9 }
            if (r1 == 0) goto L_0x00a5
            java.lang.String r1 = r7.tag     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = "Native handle is now available."
            android.util.Log.w(r1, r2)     // Catch:{ all -> 0x00a9 }
        L_0x00a5:
            T r1 = r7.zzdj     // Catch:{ all -> 0x00a9 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            return r1
        L_0x00a9:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzn.zzp():java.lang.Object");
    }
}
