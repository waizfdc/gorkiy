package com.google.firebase.ml.common.internal.modeldownload;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.firebase.ml.common.FirebaseMLException;
import java.io.File;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzab implements zzk {
    private final zzpn zzbdc;
    private final String zzbdo;

    zzab(zzpn zzpn, String str) {
        this.zzbdc = zzpn;
        this.zzbdo = str;
    }

    public final File zza(File file) throws FirebaseMLException {
        File zzc = new zzi(this.zzbdc).zzc(this.zzbdo, zzn.CUSTOM);
        File file2 = new File(zzc, String.valueOf(zzi.zzb(zzc) + 1));
        if (file.renameTo(file2)) {
            zzz.zzbbo.d("RemoteModelFileManager", "Rename to serving model successfully");
            file2.setExecutable(false);
            file2.setWritable(false);
            return file2;
        }
        zzz.zzbbo.d("RemoteModelFileManager", "Rename to serving model failed, remove the temp file.");
        if (file.delete()) {
            return null;
        }
        GmsLogger zznw = zzz.zzbbo;
        String valueOf = String.valueOf(file.getAbsolutePath());
        zznw.d("RemoteModelFileManager", valueOf.length() != 0 ? "Failed to delete the temp file: ".concat(valueOf) : new String("Failed to delete the temp file: "));
        return null;
    }
}
