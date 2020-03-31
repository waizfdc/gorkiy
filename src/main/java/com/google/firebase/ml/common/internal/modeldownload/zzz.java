package com.google.firebase.ml.common.internal.modeldownload;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.firebase_ml.zzmz;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.android.gms.internal.firebase_ml.zznq;
import com.google.android.gms.internal.firebase_ml.zzpb;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.android.gms.internal.firebase_ml.zzqc;
import com.google.firebase.ml.common.FirebaseMLException;
import com.google.firebase.ml.common.modeldownload.FirebaseRemoteModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzz {
    /* access modifiers changed from: private */
    public static final GmsLogger zzbbo = new GmsLogger("RemoteModelFileManager", "");
    private final zzqc zzbcm;
    private final zzpn zzbdc;
    private final String zzbdo;
    private final zzi zzbdp;
    private final FirebaseRemoteModel zzbfa;
    private final zzn zzbfi;
    private final zzah zzbfj;
    private final zzk zzbfk;

    public zzz(zzpn zzpn, FirebaseRemoteModel firebaseRemoteModel, zzp zzp, zzn zzn, zzi zzi) {
        String str;
        this.zzbdc = zzpn;
        this.zzbfa = firebaseRemoteModel;
        if (zzn == zzn.TRANSLATE) {
            str = firebaseRemoteModel.getModelNameForBackend();
        } else {
            str = firebaseRemoteModel.getUniqueModelNameForPersist();
        }
        this.zzbdo = str;
        this.zzbfi = zzn;
        this.zzbfj = new zzah(zzp);
        this.zzbcm = zzqc.zzb(zzpn);
        this.zzbdp = zzi;
        int i = zzac.zzbdw[zzn.ordinal()];
        if (i == 1) {
            this.zzbfk = new zza(zzpn, this.zzbdo);
        } else if (i == 2) {
            this.zzbfk = new zzae(zzpn, this.zzbdo);
        } else if (i == 3 || i == 4) {
            this.zzbfk = new zzab(zzpn, this.zzbdo);
        } else {
            throw new IllegalArgumentException("Unexpected model type");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void
     arg types: [com.google.android.gms.internal.firebase_ml.zznq, int, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb]
     candidates:
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, java.lang.String, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn):void
      com.google.firebase.ml.common.internal.modeldownload.zzw.zza(com.google.android.gms.internal.firebase_ml.zznq, boolean, com.google.firebase.ml.common.internal.modeldownload.zzn, com.google.android.gms.internal.firebase_ml.zzng$zzag$zzb):void */
    public final synchronized File zza(ParcelFileDescriptor parcelFileDescriptor, String str, zzw zzw) throws FirebaseMLException {
        File file;
        FileOutputStream fileOutputStream;
        FirebaseMLException firebaseMLException;
        zzn zzbv = this.zzbcm.zzbv(str);
        boolean z = false;
        if (this.zzbfi == zzbv) {
            file = new File(this.zzbdp.zzd(this.zzbdo, this.zzbfi), "to_be_validated_model.tmp");
            try {
                ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
                try {
                    fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = autoCloseInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                    autoCloseInputStream.close();
                    boolean zza = zzah.zza(file, str);
                    if (zza) {
                        zzs zzb = this.zzbfj.zzb(file, zzw);
                        z = zzb.isValid();
                        if (zzb.zzoh().equals(zzr.TFLITE_VERSION_INCOMPATIBLE)) {
                            String zza2 = zzpb.zza(this.zzbdc.getApplicationContext());
                            this.zzbcm.zza(this.zzbfa, str, zza2);
                            GmsLogger gmsLogger = zzbbo;
                            String valueOf = String.valueOf(str);
                            gmsLogger.d("RemoteModelFileManager", valueOf.length() != 0 ? "Model is not compatible. Model hash: ".concat(valueOf) : new String("Model is not compatible. Model hash: "));
                            GmsLogger gmsLogger2 = zzbbo;
                            String valueOf2 = String.valueOf(zza2);
                            gmsLogger2.d("RemoteModelFileManager", valueOf2.length() != 0 ? "The current app version is: ".concat(valueOf2) : new String("The current app version is: "));
                        }
                    }
                    if (zza) {
                        if (!z) {
                        }
                    }
                    if (!zza) {
                        GmsLogger gmsLogger3 = zzbbo;
                        String valueOf3 = String.valueOf(str);
                        gmsLogger3.d("RemoteModelFileManager", valueOf3.length() != 0 ? "Hash does not match with expected: ".concat(valueOf3) : new String("Hash does not match with expected: "));
                        zzw.zza(zznq.MODEL_HASH_MISMATCH, true, this.zzbfi, zzng.zzag.zzb.SUCCEEDED);
                        firebaseMLException = new FirebaseMLException("Hash does not match with expected", 102);
                    } else {
                        firebaseMLException = new FirebaseMLException("Model is not compatible with TFLite run time", 100);
                    }
                    if (!file.delete()) {
                        GmsLogger gmsLogger4 = zzbbo;
                        String valueOf4 = String.valueOf(file.getAbsolutePath());
                        gmsLogger4.d("RemoteModelFileManager", valueOf4.length() != 0 ? "Failed to delete the temp file: ".concat(valueOf4) : new String("Failed to delete the temp file: "));
                    }
                    throw firebaseMLException;
                } catch (Throwable th) {
                    autoCloseInputStream.close();
                    throw th;
                }
            } catch (IOException e) {
                GmsLogger gmsLogger5 = zzbbo;
                String valueOf5 = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf5).length() + 56);
                sb.append("Failed to copy downloaded model file to private folder: ");
                sb.append(valueOf5);
                gmsLogger5.e("RemoteModelFileManager", sb.toString());
                return null;
            } catch (Throwable th2) {
                zzmz.zza(th, th2);
            }
        } else {
            zzw.zza(zznq.MODEL_TYPE_MISUSE, false, zzbv, zzng.zzag.zzb.DOWNLOADED);
            String name = zzbv.name();
            String name2 = this.zzbfi.name();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 93 + String.valueOf(name2).length());
            sb2.append("You are trying to use a ");
            sb2.append(name);
            sb2.append(" model as a ");
            sb2.append(name2);
            sb2.append(" model. Please make sure you specified the correct model.");
            throw new FirebaseMLException(sb2.toString(), 3);
        }
        return this.zzbfk.zza(file);
        throw th;
    }

    public final synchronized boolean zzd(File file) throws FirebaseMLException {
        File zzc = this.zzbdp.zzc(this.zzbdo, this.zzbfi);
        if (!zzc.exists()) {
            return false;
        }
        boolean z = true;
        for (File file2 : zzc.listFiles()) {
            if (!file2.equals(file) && !this.zzbdp.zzc(file2)) {
                z = false;
            }
        }
        return z;
    }

    public final synchronized void zze(File file) {
        File zzb = this.zzbdp.zzb(this.zzbdo, this.zzbfi, false);
        if (zzb.exists()) {
            for (File equals : zzb.listFiles()) {
                if (equals.equals(file)) {
                    this.zzbdp.zzc(file);
                    return;
                }
            }
        }
    }

    public final synchronized File zzf(File file) throws FirebaseMLException {
        File file2 = new File(String.valueOf(this.zzbdp.zzc(this.zzbdo, this.zzbfi).getAbsolutePath()).concat("/0"));
        if (file2.exists()) {
            return file;
        }
        if (file.renameTo(file2)) {
            return file2;
        }
        return file;
    }

    public final synchronized String zzot() throws FirebaseMLException {
        File zzc = this.zzbdp.zzc(this.zzbdo, this.zzbfi);
        int zzb = zzi.zzb(zzc);
        if (zzb < 0) {
            return null;
        }
        String absolutePath = zzc.getAbsolutePath();
        StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 12);
        sb.append(absolutePath);
        sb.append("/");
        sb.append(zzb);
        return sb.toString();
    }
}
