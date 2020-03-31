package com.google.firebase.ml.common.internal.modeldownload;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznq;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzqc;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzag {
    private static final GmsLogger zzbbo = new GmsLogger("RemoteModelLoader", "");
    private static final Map<String, zzag> zzbew = new HashMap();
    private final zzpn zzbdc;
    private final FirebaseRemoteModel zzbfa;
    private final zzw zzbfb;
    private final zzn zzbfi;
    private final zzv zzbfo;
    private final zzz zzbfp;
    private final zzaf zzbfq;
    private boolean zzbfr = true;

    private zzag(zzpn zzpn, FirebaseRemoteModel firebaseRemoteModel, zzp zzp, zzaf zzaf, zzn zzn) {
        this.zzbfp = new zzz(zzpn, firebaseRemoteModel, zzp, zzn, new zzi(zzpn));
        this.zzbfb = new zzw(zzpn, firebaseRemoteModel);
        this.zzbfo = zzv.zza(zzpn, firebaseRemoteModel, new zzg(zzpn), this.zzbfb);
        this.zzbfq = zzaf;
        this.zzbdc = zzpn;
        this.zzbfa = firebaseRemoteModel;
        this.zzbfi = zzn;
    }

    public static synchronized zzag zza(zzpn zzpn, FirebaseRemoteModel firebaseRemoteModel, zzp zzp, zzaf zzaf, zzn zzn) {
        zzag zzag;
        synchronized (zzag.class) {
            String uniqueModelNameForPersist = firebaseRemoteModel.getUniqueModelNameForPersist();
            if (!zzbew.containsKey(uniqueModelNameForPersist)) {
                zzbew.put(uniqueModelNameForPersist, new zzag(zzpn, firebaseRemoteModel, zzp, zzaf, zzn));
            }
            zzag = zzbew.get(uniqueModelNameForPersist);
        }
        return zzag;
    }

    public final synchronized MappedByteBuffer load() throws FirebaseMLException {
        MappedByteBuffer zzat;
        zzbbo.d("RemoteModelLoader", "Try to load newly downloaded model file.");
        zzat = zzat(this.zzbfr);
        if (zzat == null) {
            zzbbo.d("RemoteModelLoader", "Loading existing model file.");
            zzat = zzox();
        }
        return zzat;
    }

    public final FirebaseRemoteModel zzow() {
        return this.zzbfa;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void
     arg types: [com.google.android.gms.internal.firebase_ml.zznq, int, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb]
     candidates:
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, java.lang.String, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn):void
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.ml.common.internal.modeldownload.zzw.zza(boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, int):void
     arg types: [int, com.google.firebase.ml.common.internal.modeldownload.zzn, int]
     candidates:
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, int):void */
    private final MappedByteBuffer zzat(boolean z) throws FirebaseMLException {
        Long zzoi = this.zzbfo.zzoi();
        String zzoj = this.zzbfo.zzoj();
        if (zzoi == null || zzoj == null) {
            zzbbo.d("RemoteModelLoader", "No new model is downloading.");
            this.zzbfo.zzok();
            return null;
        }
        Integer zzol = this.zzbfo.zzol();
        if (zzol == null) {
            this.zzbfo.zzok();
            return null;
        }
        GmsLogger gmsLogger = zzbbo;
        String valueOf = String.valueOf(zzol);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Download Status code: ");
        sb.append(valueOf);
        gmsLogger.d("RemoteModelLoader", sb.toString());
        if (zzol.intValue() == 8) {
            zzbbo.d("RemoteModelLoader", "Model downloaded successfully");
            this.zzbfb.zza(zznq.NO_ERROR, true, this.zzbfi, zzng.zzag.zzb.SUCCEEDED);
            ParcelFileDescriptor zzom = this.zzbfo.zzom();
            if (zzom == null) {
                this.zzbfo.zzok();
                return null;
            }
            zzbbo.d("RemoteModelLoader", "moving downloaded model from external storage to private folder.");
            try {
                File zza = this.zzbfp.zza(zzom, zzoj, this.zzbfb);
                if (zza == null) {
                    return null;
                }
                MappedByteBuffer zzg = zzg(zza);
                GmsLogger gmsLogger2 = zzbbo;
                String valueOf2 = String.valueOf(zza.getParent());
                gmsLogger2.d("RemoteModelLoader", valueOf2.length() != 0 ? "Moved the downloaded model to private folder successfully: ".concat(valueOf2) : new String("Moved the downloaded model to private folder successfully: "));
                this.zzbfo.zze(zzoj, this.zzbfi);
                if (!z || !this.zzbfp.zzd(zza)) {
                    return zzg;
                }
                zzbbo.d("RemoteModelLoader", "All old models are deleted.");
                return zzg(this.zzbfp.zzf(zza));
            } finally {
                this.zzbfo.zzok();
            }
        } else {
            if (zzol.intValue() == 16) {
                this.zzbfb.zza(false, this.zzbfi, this.zzbfo.zza(zzoi));
                this.zzbfo.zzok();
            }
            return null;
        }
    }

    private final MappedByteBuffer zzg(File file) throws FirebaseMLException {
        try {
            return zzbz(file.getAbsolutePath());
        } catch (Exception e) {
            this.zzbfp.zze(file);
            throw new FirebaseMLException("Failed to load newly downloaded model.", 14, e);
        }
    }

    private final MappedByteBuffer zzox() throws FirebaseMLException {
        String zzot = this.zzbfp.zzot();
        if (zzot == null) {
            zzbbo.d("RemoteModelLoader", "No existing model file");
            return null;
        }
        try {
            return zzbz(zzot);
        } catch (Exception e) {
            this.zzbfp.zze(new File(zzot));
            zzqc.zzb(this.zzbdc).zzi(this.zzbfa);
            throw new FirebaseMLException("Failed to load an already downloaded model.", 14, e);
        }
    }

    private final MappedByteBuffer zzbz(String str) throws FirebaseMLException {
        return this.zzbfq.zzby(str);
    }
}
