package com.google.firebase.ml.common.internal.modeldownload;

import android.app.DownloadManager;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Build;
import android.util.LongSparseArray;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznq;
import com.google.android.gms.internal.firebase_ml.zzpf;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzqc;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzv {
    /* access modifiers changed from: private */
    public static final GmsLogger zzbbo = new GmsLogger("ModelDownloadManager", "");
    private static final Map<String, zzv> zzbew = new HashMap();
    private final zzqc zzbcm;
    /* access modifiers changed from: private */
    public final zzpn zzbdc;
    /* access modifiers changed from: private */
    public final LongSparseArray<zzx> zzbex = new LongSparseArray<>();
    /* access modifiers changed from: private */
    public final LongSparseArray<TaskCompletionSource<Void>> zzbey = new LongSparseArray<>();
    private final DownloadManager zzbez;
    private final FirebaseRemoteModel zzbfa;
    /* access modifiers changed from: private */
    public final zzw zzbfb;
    private final zzg zzbfc;
    private FirebaseModelDownloadConditions zzbfd;

    public static synchronized zzv zza(zzpn zzpn, FirebaseRemoteModel firebaseRemoteModel, zzg zzg, zzw zzw) {
        zzv zzv;
        synchronized (zzv.class) {
            String uniqueModelNameForPersist = firebaseRemoteModel.getUniqueModelNameForPersist();
            if (!zzbew.containsKey(uniqueModelNameForPersist)) {
                zzbew.put(uniqueModelNameForPersist, new zzv(zzpn, firebaseRemoteModel, zzg, zzw));
            }
            zzv = zzbew.get(uniqueModelNameForPersist);
        }
        return zzv;
    }

    public final void zza(FirebaseModelDownloadConditions firebaseModelDownloadConditions) {
        Preconditions.checkNotNull(firebaseModelDownloadConditions, "DownloadConditions can not be null");
        this.zzbfd = firebaseModelDownloadConditions;
    }

    private zzv(zzpn zzpn, FirebaseRemoteModel firebaseRemoteModel, zzg zzg, zzw zzw) {
        this.zzbdc = zzpn;
        this.zzbfa = firebaseRemoteModel;
        DownloadManager downloadManager = (DownloadManager) zzpn.getApplicationContext().getSystemService("download");
        this.zzbez = downloadManager;
        if (downloadManager == null) {
            zzbbo.d("ModelDownloadManager", "Download manager service is not available in the service.");
        }
        this.zzbfc = zzg;
        this.zzbfb = zzw;
        this.zzbcm = zzqc.zzb(zzpn);
    }

    /* access modifiers changed from: package-private */
    public final synchronized Long zzoi() {
        return this.zzbcm.zza(this.zzbfa);
    }

    /* access modifiers changed from: package-private */
    public final synchronized String zzoj() {
        return this.zzbcm.zzb(this.zzbfa);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0061, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzok() throws com.google.firebase.ml.common.FirebaseMLException {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.Long r0 = r6.zzoi()     // Catch:{ all -> 0x0064 }
            android.app.DownloadManager r1 = r6.zzbez     // Catch:{ all -> 0x0064 }
            if (r1 == 0) goto L_0x0062
            if (r0 != 0) goto L_0x000c
            goto L_0x0062
        L_0x000c:
            com.google.android.gms.common.internal.GmsLogger r1 = com.google.firebase.ml.common.internal.modeldownload.zzv.zzbbo     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "ModelDownloadManager"
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0064 }
            int r4 = r4.length()     // Catch:{ all -> 0x0064 }
            int r4 = r4 + 44
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r5.<init>(r4)     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = "Cancel or remove existing downloading task: "
            r5.append(r4)     // Catch:{ all -> 0x0064 }
            r5.append(r3)     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0064 }
            r1.d(r2, r3)     // Catch:{ all -> 0x0064 }
            android.app.DownloadManager r1 = r6.zzbez     // Catch:{ all -> 0x0064 }
            r2 = 1
            long[] r2 = new long[r2]     // Catch:{ all -> 0x0064 }
            r3 = 0
            long r4 = r0.longValue()     // Catch:{ all -> 0x0064 }
            r2[r3] = r4     // Catch:{ all -> 0x0064 }
            int r0 = r1.remove(r2)     // Catch:{ all -> 0x0064 }
            if (r0 > 0) goto L_0x004a
            java.lang.Integer r0 = r6.zzol()     // Catch:{ all -> 0x0064 }
            if (r0 != 0) goto L_0x0060
        L_0x004a:
            com.google.firebase.ml.common.internal.modeldownload.zzg r0 = r6.zzbfc     // Catch:{ all -> 0x0064 }
            com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel r1 = r6.zzbfa     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = r1.getUniqueModelNameForPersist()     // Catch:{ all -> 0x0064 }
            com.google.firebase.ml.common.internal.modeldownload.zzn r2 = r6.zzor()     // Catch:{ all -> 0x0064 }
            r0.zza(r1, r2)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.firebase_ml.zzqc r0 = r6.zzbcm     // Catch:{ all -> 0x0064 }
            com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel r1 = r6.zzbfa     // Catch:{ all -> 0x0064 }
            r0.zzh(r1)     // Catch:{ all -> 0x0064 }
        L_0x0060:
            monitor-exit(r6)
            return
        L_0x0062:
            monitor-exit(r6)
            return
        L_0x0064:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ml.common.internal.modeldownload.zzv.zzok():void");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void
     arg types: [com.google.android.gms.internal.firebase_ml.zznq, int, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb]
     candidates:
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, java.lang.String, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn):void
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void */
    private final synchronized Long zza(DownloadManager.Request request, zzaa zzaa) {
        if (this.zzbez == null) {
            return null;
        }
        long enqueue = this.zzbez.enqueue(request);
        GmsLogger gmsLogger = zzbbo;
        StringBuilder sb = new StringBuilder(53);
        sb.append("Schedule a new downloading task: ");
        sb.append(enqueue);
        gmsLogger.d("ModelDownloadManager", sb.toString());
        this.zzbcm.zza(enqueue, zzaa);
        this.zzbfb.zza(zznq.NO_ERROR, false, zzaa.zzov(), zzng.zzag.zzb.SCHEDULED);
        return Long.valueOf(enqueue);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0076, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0083, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a A[SYNTHETIC, Splitter:B:20:0x004a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.Integer zzol() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.Long r0 = r9.zzoi()     // Catch:{ all -> 0x0084 }
            android.app.DownloadManager r1 = r9.zzbez     // Catch:{ all -> 0x0084 }
            r2 = 0
            if (r1 == 0) goto L_0x0082
            if (r0 != 0) goto L_0x000e
            goto L_0x0082
        L_0x000e:
            android.app.DownloadManager r1 = r9.zzbez     // Catch:{ all -> 0x0084 }
            android.app.DownloadManager$Query r3 = new android.app.DownloadManager$Query     // Catch:{ all -> 0x0084 }
            r3.<init>()     // Catch:{ all -> 0x0084 }
            r4 = 1
            long[] r5 = new long[r4]     // Catch:{ all -> 0x0084 }
            r6 = 0
            long r7 = r0.longValue()     // Catch:{ all -> 0x0084 }
            r5[r6] = r7     // Catch:{ all -> 0x0084 }
            android.app.DownloadManager$Query r0 = r3.setFilterById(r5)     // Catch:{ all -> 0x0084 }
            android.database.Cursor r0 = r1.query(r0)     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0040
            boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x0040
            java.lang.String r1 = "status"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ all -> 0x003e }
            int r1 = r0.getInt(r1)     // Catch:{ all -> 0x003e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x003e }
            goto L_0x0041
        L_0x003e:
            r1 = move-exception
            goto L_0x0077
        L_0x0040:
            r1 = r2
        L_0x0041:
            if (r1 != 0) goto L_0x004a
            if (r0 == 0) goto L_0x0048
            r0.close()     // Catch:{ all -> 0x0084 }
        L_0x0048:
            monitor-exit(r9)
            return r2
        L_0x004a:
            int r3 = r1.intValue()     // Catch:{ all -> 0x003e }
            r5 = 2
            if (r3 == r5) goto L_0x006f
            int r3 = r1.intValue()     // Catch:{ all -> 0x003e }
            r5 = 4
            if (r3 == r5) goto L_0x006f
            int r3 = r1.intValue()     // Catch:{ all -> 0x003e }
            if (r3 == r4) goto L_0x006f
            int r3 = r1.intValue()     // Catch:{ all -> 0x003e }
            r4 = 8
            if (r3 == r4) goto L_0x006f
            int r3 = r1.intValue()     // Catch:{ all -> 0x003e }
            r4 = 16
            if (r3 == r4) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = r1
        L_0x0070:
            if (r0 == 0) goto L_0x0075
            r0.close()     // Catch:{ all -> 0x0084 }
        L_0x0075:
            monitor-exit(r9)
            return r2
        L_0x0077:
            if (r0 == 0) goto L_0x0081
            r0.close()     // Catch:{ all -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r0 = move-exception
            com.google.android.gms.internal.firebase_ml.zzmz.zza(r1, r0)     // Catch:{ all -> 0x0084 }
        L_0x0081:
            throw r1     // Catch:{ all -> 0x0084 }
        L_0x0082:
            monitor-exit(r9)
            return r2
        L_0x0084:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ml.common.internal.modeldownload.zzv.zzol():java.lang.Integer");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        com.google.firebase.ml.common.internal.modeldownload.zzv.zzbbo.e("ModelDownloadManager", "Downloaded file is not found");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.os.ParcelFileDescriptor zzom() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.Long r0 = r5.zzoi()     // Catch:{ all -> 0x0025 }
            android.app.DownloadManager r1 = r5.zzbez     // Catch:{ all -> 0x0025 }
            r2 = 0
            if (r1 == 0) goto L_0x0023
            if (r0 != 0) goto L_0x000d
            goto L_0x0023
        L_0x000d:
            android.app.DownloadManager r1 = r5.zzbez     // Catch:{ FileNotFoundException -> 0x0018 }
            long r3 = r0.longValue()     // Catch:{ FileNotFoundException -> 0x0018 }
            android.os.ParcelFileDescriptor r2 = r1.openDownloadedFile(r3)     // Catch:{ FileNotFoundException -> 0x0018 }
            goto L_0x0021
        L_0x0018:
            com.google.android.gms.common.internal.GmsLogger r0 = com.google.firebase.ml.common.internal.modeldownload.zzv.zzbbo     // Catch:{ all -> 0x0025 }
            java.lang.String r1 = "ModelDownloadManager"
            java.lang.String r3 = "Downloaded file is not found"
            r0.e(r1, r3)     // Catch:{ all -> 0x0025 }
        L_0x0021:
            monitor-exit(r5)
            return r2
        L_0x0023:
            monitor-exit(r5)
            return r2
        L_0x0025:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ml.common.internal.modeldownload.zzv.zzom():android.os.ParcelFileDescriptor");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zze(String str, zzn zzn) throws FirebaseMLException {
        this.zzbcm.zza(this.zzbfa, str, zzn);
        zzok();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void
     arg types: [com.google.android.gms.internal.firebase_ml.zznq, int, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb]
     candidates:
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, java.lang.String, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn):void
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0086, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized com.google.firebase.ml.common.internal.modeldownload.zzaa zzon() throws com.google.firebase.ml.common.FirebaseMLException {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.zzoq()     // Catch:{ all -> 0x00bd }
            r1 = 0
            if (r0 == 0) goto L_0x0019
            com.google.firebase.ml.common.internal.modeldownload.zzw r2 = r8.zzbfb     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.firebase_ml.zznq r3 = com.google.android.gms.internal.firebase_ml.zznq.NO_ERROR     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.firebase_ml.zzqc r4 = r8.zzbcm     // Catch:{ all -> 0x00bd }
            com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel r5 = r8.zzbfa     // Catch:{ all -> 0x00bd }
            com.google.firebase.ml.common.internal.modeldownload.zzn r4 = r4.zzd(r5)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb r5 = com.google.android.gms.internal.firebase_ml.zzng.zzag.zzb.LIVE     // Catch:{ all -> 0x00bd }
            r2.zza(r3, r1, r4, r5)     // Catch:{ all -> 0x00bd }
        L_0x0019:
            com.google.android.gms.internal.firebase_ml.zzpn r2 = r8.zzbdc     // Catch:{ all -> 0x00bd }
            com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel r3 = r8.zzbfa     // Catch:{ all -> 0x00bd }
            com.google.firebase.ml.common.internal.modeldownload.zzw r4 = r8.zzbfb     // Catch:{ all -> 0x00bd }
            com.google.firebase.ml.common.internal.modeldownload.zzaa r2 = com.google.firebase.ml.common.internal.modeldownload.zzad.zza(r2, r3, r4)     // Catch:{ all -> 0x00bd }
            r3 = 0
            if (r2 != 0) goto L_0x0028
            monitor-exit(r8)
            return r3
        L_0x0028:
            com.google.android.gms.internal.firebase_ml.zzpn r4 = r8.zzbdc     // Catch:{ all -> 0x00bd }
            com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel r5 = r8.zzbfa     // Catch:{ all -> 0x00bd }
            java.lang.String r6 = r2.zzbfn     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.firebase_ml.zzqc r7 = com.google.android.gms.internal.firebase_ml.zzqc.zzb(r4)     // Catch:{ all -> 0x00bd }
            java.lang.String r5 = r7.zze(r5)     // Catch:{ all -> 0x00bd }
            boolean r5 = r6.equals(r5)     // Catch:{ all -> 0x00bd }
            r6 = 1
            if (r5 == 0) goto L_0x0053
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = com.google.android.gms.internal.firebase_ml.zzpb.zza(r4)     // Catch:{ all -> 0x00bd }
            java.lang.String r5 = r7.zzoa()     // Catch:{ all -> 0x00bd }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00bd }
            if (r4 == 0) goto L_0x0053
            r4 = r6
            goto L_0x0054
        L_0x0053:
            r4 = r1
        L_0x0054:
            if (r4 == 0) goto L_0x0060
            com.google.android.gms.common.internal.GmsLogger r4 = com.google.firebase.ml.common.internal.modeldownload.zzv.zzbbo     // Catch:{ all -> 0x00bd }
            java.lang.String r5 = "ModelDownloadManager"
            java.lang.String r7 = "The model is incompatible with TFLite and the app is not upgraded, do not download"
            r4.e(r5, r7)     // Catch:{ all -> 0x00bd }
            goto L_0x0061
        L_0x0060:
            r1 = r6
        L_0x0061:
            if (r0 != 0) goto L_0x006a
            com.google.android.gms.internal.firebase_ml.zzqc r4 = r8.zzbcm     // Catch:{ all -> 0x00bd }
            com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel r5 = r8.zzbfa     // Catch:{ all -> 0x00bd }
            r4.zzi(r5)     // Catch:{ all -> 0x00bd }
        L_0x006a:
            com.google.android.gms.internal.firebase_ml.zzpn r4 = r8.zzbdc     // Catch:{ all -> 0x00bd }
            com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel r5 = r8.zzbfa     // Catch:{ all -> 0x00bd }
            java.lang.String r7 = r2.zzbfn     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.firebase_ml.zzqc r4 = com.google.android.gms.internal.firebase_ml.zzqc.zzb(r4)     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = r4.zzc(r5)     // Catch:{ all -> 0x00bd }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00bd }
            r4 = r4 ^ r6
            if (r1 == 0) goto L_0x0087
            if (r0 == 0) goto L_0x0085
            if (r4 == 0) goto L_0x0087
        L_0x0085:
            monitor-exit(r8)
            return r2
        L_0x0087:
            if (r0 == 0) goto L_0x008f
            r0 = r4 ^ r1
            if (r0 == 0) goto L_0x008f
            monitor-exit(r8)
            return r3
        L_0x008f:
            com.google.firebase.ml.common.FirebaseMLException r0 = new com.google.firebase.ml.common.FirebaseMLException     // Catch:{ all -> 0x00bd }
            com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel r1 = r8.zzbfa     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = r1.getModelName()     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00bd }
            int r2 = r2.length()     // Catch:{ all -> 0x00bd }
            int r2 = r2 + 46
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r3.<init>(r2)     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = "The model "
            r3.append(r2)     // Catch:{ all -> 0x00bd }
            r3.append(r1)     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = " is incompatible with TFLite runtime"
            r3.append(r1)     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00bd }
            r2 = 100
            r0.<init>(r1, r2)     // Catch:{ all -> 0x00bd }
            throw r0     // Catch:{ all -> 0x00bd }
        L_0x00bd:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ml.common.internal.modeldownload.zzv.zzon():com.google.firebase.ml.common.internal.modeldownload.zzaa");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void
     arg types: [com.google.android.gms.internal.firebase_ml.zznq, int, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb]
     candidates:
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, java.lang.String, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn):void
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void */
    private final synchronized Long zza(zzaa zzaa, FirebaseModelDownloadConditions firebaseModelDownloadConditions) throws FirebaseMLException {
        Preconditions.checkNotNull(firebaseModelDownloadConditions, "DownloadConditions can not be null");
        String zzb = this.zzbcm.zzb(this.zzbfa);
        Integer zzol = zzol();
        if (zzb == null || !zzb.equals(zzaa.zzbfn) || zzol == null) {
            zzbbo.d("ModelDownloadManager", "Need to download a new model.");
            zzok();
            DownloadManager.Request request = new DownloadManager.Request(zzaa.zzbfm);
            request.setDestinationUri(null);
            if (this.zzbfc.zza(zzaa)) {
                zzbbo.d("ModelDownloadManager", "Model update is enabled and have a previous downloaded model, use download condition");
                this.zzbfb.zza(zznq.NO_ERROR, false, zzaa.zzov(), zzng.zzag.zzb.UPDATE_AVAILABLE);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                request.setRequiresCharging(firebaseModelDownloadConditions.isChargingRequired());
                request.setRequiresDeviceIdle(firebaseModelDownloadConditions.isDeviceIdleRequired());
            }
            if (firebaseModelDownloadConditions.isWifiRequired()) {
                request.setAllowedNetworkTypes(2);
            }
            return zza(request, zzaa);
        }
        if (!zzb(zzol())) {
            this.zzbfb.zza(zznq.NO_ERROR, false, zzor(), zzng.zzag.zzb.DOWNLOADING);
        }
        zzbbo.d("ModelDownloadManager", "New model is already in downloading, do nothing.");
        return null;
    }

    public final boolean zzoo() throws FirebaseMLException {
        try {
            return zzoq() || Objects.equal(zzol(), 8);
        } catch (FirebaseMLException e) {
            throw new FirebaseMLException("Failed to check if the model is downloaded.", 13, e);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void
     arg types: [com.google.android.gms.internal.firebase_ml.zznq, int, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb]
     candidates:
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, java.lang.String, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn):void
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068 A[Catch:{ FirebaseMLException -> 0x00bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0069 A[Catch:{ FirebaseMLException -> 0x00bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0071 A[Catch:{ FirebaseMLException -> 0x00bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d A[Catch:{ FirebaseMLException -> 0x00bd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<java.lang.Void> zzop() {
        /*
            r10 = this;
            com.google.firebase.ml.common.internal.modeldownload.zzw r0 = r10.zzbfb
            com.google.android.gms.internal.firebase_ml.zznq r1 = com.google.android.gms.internal.firebase_ml.zznq.NO_ERROR
            com.google.firebase.ml.common.internal.modeldownload.zzn r2 = com.google.firebase.ml.common.internal.modeldownload.zzn.UNKNOWN
            com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb r3 = com.google.android.gms.internal.firebase_ml.zzng.zzag.zzb.EXPLICITLY_REQUESTED
            r4 = 0
            r0.zza(r1, r4, r2, r3)
            r0 = 0
            com.google.firebase.ml.common.internal.modeldownload.zzaa r1 = r10.zzon()     // Catch:{ FirebaseMLException -> 0x0013 }
            r2 = r0
            goto L_0x0016
        L_0x0013:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x0016:
            r3 = 13
            java.lang.Integer r5 = r10.zzol()     // Catch:{ FirebaseMLException -> 0x00bd }
            java.lang.Long r6 = r10.zzoi()     // Catch:{ FirebaseMLException -> 0x00bd }
            boolean r7 = r10.zzoq()     // Catch:{ FirebaseMLException -> 0x00bd }
            if (r7 != 0) goto L_0x0086
            boolean r7 = zzb(r5)     // Catch:{ FirebaseMLException -> 0x00bd }
            if (r7 == 0) goto L_0x002d
            goto L_0x0086
        L_0x002d:
            r7 = 1
            if (r5 == 0) goto L_0x0045
            int r8 = r5.intValue()     // Catch:{ FirebaseMLException -> 0x00bd }
            r9 = 4
            if (r8 == r9) goto L_0x0046
            int r8 = r5.intValue()     // Catch:{ FirebaseMLException -> 0x00bd }
            r9 = 2
            if (r8 == r9) goto L_0x0046
            int r5 = r5.intValue()     // Catch:{ FirebaseMLException -> 0x00bd }
            if (r5 != r7) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r7 = r4
        L_0x0046:
            if (r7 == 0) goto L_0x0066
            if (r6 == 0) goto L_0x0066
            java.lang.String r5 = r10.zzoj()     // Catch:{ FirebaseMLException -> 0x00bd }
            if (r5 == 0) goto L_0x0066
            com.google.firebase.ml.common.internal.modeldownload.zzw r0 = r10.zzbfb     // Catch:{ FirebaseMLException -> 0x00bd }
            com.google.android.gms.internal.firebase_ml.zznq r1 = com.google.android.gms.internal.firebase_ml.zznq.NO_ERROR     // Catch:{ FirebaseMLException -> 0x00bd }
            com.google.firebase.ml.common.internal.modeldownload.zzn r2 = r10.zzor()     // Catch:{ FirebaseMLException -> 0x00bd }
            com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb r5 = com.google.android.gms.internal.firebase_ml.zzng.zzag.zzb.DOWNLOADING     // Catch:{ FirebaseMLException -> 0x00bd }
            r0.zza(r1, r4, r2, r5)     // Catch:{ FirebaseMLException -> 0x00bd }
            long r0 = r6.longValue()     // Catch:{ FirebaseMLException -> 0x00bd }
            com.google.android.gms.tasks.Task r0 = r10.zzt(r0)     // Catch:{ FirebaseMLException -> 0x00bd }
            return r0
        L_0x0066:
            if (r1 != 0) goto L_0x0069
            goto L_0x006f
        L_0x0069:
            com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions r0 = r10.zzbfd     // Catch:{ FirebaseMLException -> 0x00bd }
            java.lang.Long r0 = r10.zza(r1, r0)     // Catch:{ FirebaseMLException -> 0x00bd }
        L_0x006f:
            if (r0 != 0) goto L_0x007d
            com.google.firebase.ml.common.FirebaseMLException r0 = new com.google.firebase.ml.common.FirebaseMLException     // Catch:{ FirebaseMLException -> 0x00bd }
            java.lang.String r1 = "Failed to schedule the download task"
            r0.<init>(r1, r3, r2)     // Catch:{ FirebaseMLException -> 0x00bd }
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r0)     // Catch:{ FirebaseMLException -> 0x00bd }
            return r0
        L_0x007d:
            long r0 = r0.longValue()     // Catch:{ FirebaseMLException -> 0x00bd }
            com.google.android.gms.tasks.Task r0 = r10.zzt(r0)     // Catch:{ FirebaseMLException -> 0x00bd }
            return r0
        L_0x0086:
            if (r1 == 0) goto L_0x00a2
            com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions r2 = r10.zzbfd     // Catch:{ FirebaseMLException -> 0x00bd }
            java.lang.Long r1 = r10.zza(r1, r2)     // Catch:{ FirebaseMLException -> 0x00bd }
            if (r1 == 0) goto L_0x0099
            long r0 = r1.longValue()     // Catch:{ FirebaseMLException -> 0x00bd }
            com.google.android.gms.tasks.Task r0 = r10.zzt(r0)     // Catch:{ FirebaseMLException -> 0x00bd }
            return r0
        L_0x0099:
            com.google.android.gms.common.internal.GmsLogger r1 = com.google.firebase.ml.common.internal.modeldownload.zzv.zzbbo     // Catch:{ FirebaseMLException -> 0x00bd }
            java.lang.String r2 = "ModelDownloadManager"
            java.lang.String r4 = "Didn't schedule download for the updated model"
            r1.i(r2, r4)     // Catch:{ FirebaseMLException -> 0x00bd }
        L_0x00a2:
            if (r5 == 0) goto L_0x00b8
            int r1 = r5.intValue()     // Catch:{ FirebaseMLException -> 0x00bd }
            r2 = 16
            if (r1 != r2) goto L_0x00b8
            com.google.firebase.ml.common.FirebaseMLException r0 = r10.zzb(r6)     // Catch:{ FirebaseMLException -> 0x00bd }
            r10.zzok()     // Catch:{ FirebaseMLException -> 0x00bd }
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r0)     // Catch:{ FirebaseMLException -> 0x00bd }
            return r0
        L_0x00b8:
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forResult(r0)     // Catch:{ FirebaseMLException -> 0x00bd }
            return r0
        L_0x00bd:
            r0 = move-exception
            com.google.firebase.ml.common.FirebaseMLException r1 = new com.google.firebase.ml.common.FirebaseMLException
            java.lang.String r2 = "Failed to ensure the model is downloaded."
            r1.<init>(r2, r3, r0)
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ml.common.internal.modeldownload.zzv.zzop():com.google.android.gms.tasks.Task");
    }

    /* access modifiers changed from: package-private */
    public final int zza(Long l) {
        int columnIndex;
        DownloadManager downloadManager = this.zzbez;
        Cursor query = (downloadManager == null || l == null) ? null : downloadManager.query(new DownloadManager.Query().setFilterById(l.longValue()));
        if (query == null || !query.moveToFirst() || (columnIndex = query.getColumnIndex("reason")) == -1) {
            return 0;
        }
        return query.getInt(columnIndex);
    }

    private final boolean zzoq() throws FirebaseMLException {
        return this.zzbfc.zzb(this.zzbfa.getUniqueModelNameForPersist(), this.zzbcm.zzd(this.zzbfa));
    }

    /* access modifiers changed from: private */
    public final zzn zzor() {
        String zzb = this.zzbcm.zzb(this.zzbfa);
        if (zzb == null) {
            return zzn.UNKNOWN;
        }
        return this.zzbcm.zzbv(zzb);
    }

    private final synchronized zzx zzr(long j) {
        zzx zzx;
        zzx = this.zzbex.get(j);
        if (zzx == null) {
            zzx = new zzx(this, j, zzs(j));
            this.zzbex.put(j, zzx);
        }
        return zzx;
    }

    private final synchronized TaskCompletionSource<Void> zzs(long j) {
        TaskCompletionSource<Void> taskCompletionSource;
        taskCompletionSource = this.zzbey.get(j);
        if (taskCompletionSource == null) {
            taskCompletionSource = new TaskCompletionSource<>();
            this.zzbey.put(j, taskCompletionSource);
        }
        return taskCompletionSource;
    }

    /* access modifiers changed from: private */
    public final FirebaseMLException zzb(Long l) {
        Cursor cursor;
        String str;
        DownloadManager downloadManager = this.zzbez;
        if (downloadManager == null || l == null) {
            cursor = null;
        } else {
            cursor = downloadManager.query(new DownloadManager.Query().setFilterById(l.longValue()));
        }
        int i = 13;
        if (cursor == null || !cursor.moveToFirst()) {
            str = "Model downloading failed";
        } else {
            int i2 = cursor.getInt(cursor.getColumnIndex("reason"));
            if (i2 == 1006) {
                i = 101;
                str = "Model downloading failed due to insufficient space on the device.";
            } else {
                StringBuilder sb = new StringBuilder(84);
                sb.append("Model downloading failed due to error code: ");
                sb.append(i2);
                sb.append(" from Android DownloadManager");
                str = sb.toString();
            }
        }
        return new FirebaseMLException(str, i);
    }

    private static boolean zzb(Integer num) {
        if (num != null) {
            return num.intValue() == 8 || num.intValue() == 16;
        }
        return false;
    }

    private final Task<Void> zzt(long j) {
        this.zzbdc.getApplicationContext().registerReceiver(zzr(j), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), null, zzpf.zzno().getHandler());
        return zzs(j).getTask();
    }
}
