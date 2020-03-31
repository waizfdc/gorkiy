package com.google.firebase.ml.common.internal.modeldownload;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zznq;
import com.google.firebase.ml.common.FirebaseMLException;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class zzj {
    private static final GmsLogger zzbbo = new GmsLogger("ModelLoader", "");
    private final zzag zzbeb;
    public final zzf zzbec;
    private final zzl zzbed;
    protected int zzbee = zzo.zzbel;

    public zzj(zzag zzag, zzf zzf, zzl zzl) {
        Preconditions.checkArgument((zzag == null && zzf == null) ? false : true, "At least one of RemoteModelLoader or LocalModelLoader must be non-null.");
        Preconditions.checkNotNull(zzl);
        this.zzbeb = zzag;
        this.zzbec = zzf;
        this.zzbed = zzl;
    }

    public final synchronized void zza(zzm zzm) throws FirebaseMLException {
        Exception exc;
        boolean z;
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        Exception e = null;
        try {
            z = zza(zzm, arrayList);
            exc = null;
        } catch (Exception e2) {
            exc = e2;
            z = false;
        }
        if (z) {
            this.zzbed.zze(arrayList);
            this.zzbee = zzo.zzbem;
            return;
        }
        try {
            z2 = zzb(zzm, arrayList);
        } catch (Exception e3) {
            e = e3;
        }
        if (z2) {
            this.zzbed.zze(arrayList);
            this.zzbee = zzo.zzben;
            return;
        }
        arrayList.add(zznq.NO_VALID_MODEL);
        this.zzbed.zze(arrayList);
        this.zzbee = zzo.zzbel;
        if (exc != null) {
            String valueOf = String.valueOf(zzoe());
            throw new FirebaseMLException(valueOf.length() != 0 ? "Remote model load failed with the model options: ".concat(valueOf) : new String("Remote model load failed with the model options: "), 14, exc);
        } else if (e != null) {
            String valueOf2 = String.valueOf(zzoe());
            throw new FirebaseMLException(valueOf2.length() != 0 ? "Local model load failed with the model options: ".concat(valueOf2) : new String("Local model load failed with the model options: "), 14, e);
        } else {
            String valueOf3 = String.valueOf(zzoe());
            throw new FirebaseMLException(valueOf3.length() != 0 ? "Cannot load any model with the model options: ".concat(valueOf3) : new String("Cannot load any model with the model options: "), 14);
        }
    }

    public final synchronized boolean zzod() {
        return this.zzbee == zzo.zzbem;
    }

    private final synchronized boolean zza(zzm zzm, List<zznq> list) throws FirebaseMLException {
        if (this.zzbeb != null) {
            try {
                MappedByteBuffer load = this.zzbeb.load();
                if (load != null) {
                    zzm.zza(load);
                    zzbbo.d("ModelLoader", "Remote model source is loaded successfully");
                    return true;
                }
                zzbbo.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(zznq.REMOTE_MODEL_LOADER_LOADS_NO_MODEL);
            } catch (FirebaseMLException e) {
                zzbbo.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(zznq.REMOTE_MODEL_LOADER_ERROR);
                throw e;
            } catch (RuntimeException e2) {
                list.add(zznq.REMOTE_MODEL_INVALID);
                throw e2;
            }
        }
        return false;
    }

    private final synchronized boolean zzb(zzm zzm, List<zznq> list) throws FirebaseMLException {
        MappedByteBuffer load;
        if (this.zzbec == null || (load = this.zzbec.load()) == null) {
            return false;
        }
        try {
            zzm.zza(load);
            zzbbo.d("ModelLoader", "Local model source is loaded successfully");
            return true;
        } catch (RuntimeException e) {
            list.add(zznq.LOCAL_MODEL_INVALID);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzoe() {
        /*
            r4 = this;
            com.google.firebase.ml.common.internal.modeldownload.zzf r0 = r4.zzbec
            if (r0 == 0) goto L_0x0030
            com.google.firebase.ml.common.modeldownload.FirebaseLocalModel r0 = r0.zzoc()
            java.lang.String r0 = r0.getAssetFilePath()
            if (r0 == 0) goto L_0x0019
            com.google.firebase.ml.common.internal.modeldownload.zzf r0 = r4.zzbec
            com.google.firebase.ml.common.modeldownload.FirebaseLocalModel r0 = r0.zzoc()
            java.lang.String r0 = r0.getAssetFilePath()
            goto L_0x0031
        L_0x0019:
            com.google.firebase.ml.common.internal.modeldownload.zzf r0 = r4.zzbec
            com.google.firebase.ml.common.modeldownload.FirebaseLocalModel r0 = r0.zzoc()
            java.lang.String r0 = r0.getFilePath()
            if (r0 == 0) goto L_0x0030
            com.google.firebase.ml.common.internal.modeldownload.zzf r0 = r4.zzbec
            com.google.firebase.ml.common.modeldownload.FirebaseLocalModel r0 = r0.zzoc()
            java.lang.String r0 = r0.getFilePath()
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            com.google.firebase.ml.common.internal.modeldownload.zzag r1 = r4.zzbeb
            if (r1 != 0) goto L_0x0038
            java.lang.String r1 = "unspecified"
            goto L_0x0040
        L_0x0038:
            com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel r1 = r1.zzow()
            java.lang.String r1 = r1.getUniqueModelNameForPersist()
        L_0x0040:
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r0
            r0 = 1
            r2[r0] = r1
            java.lang.String r0 = "Local model path: %s. Remote model name: %s. "
            java.lang.String r0 = java.lang.String.format(r0, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ml.common.internal.modeldownload.zzj.zzoe():java.lang.String");
    }
}
