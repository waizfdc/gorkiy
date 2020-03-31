package com.google.firebase.ml.common.internal.modeldownload;

import android.os.Build;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.firebase.ml.common.FirebaseMLException;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzi {
    private static final GmsLogger zzbbo = new GmsLogger("ModelFileHelper", "");
    private static final String zzbdx = String.format("com.google.firebase.ml.%s.models", SchedulerSupport.CUSTOM);
    private static final String zzbdy = String.format("com.google.firebase.ml.%s.models", "automl");
    private static final String zzbdz = String.format("com.google.firebase.ml.%s.models", "base");
    private static final String zzbea = String.format("com.google.firebase.ml.%s.models", "translate");
    private final zzpn zzbdc;

    public zzi(zzpn zzpn) {
        this.zzbdc = zzpn;
    }

    public final void zza(String str, zzn zzn) throws FirebaseMLException {
        if (zzn == zzn.AUTOML) {
            File parentFile = zza.zza(this.zzbdc, str).getParentFile();
            if (!zzc(parentFile)) {
                GmsLogger gmsLogger = zzbbo;
                String valueOf = String.valueOf(parentFile != null ? parentFile.getAbsolutePath() : null);
                gmsLogger.e("ModelFileHelper", valueOf.length() != 0 ? "Failed to delete the temp labels file directory: ".concat(valueOf) : new String("Failed to delete the temp labels file directory: "));
            }
        }
    }

    public final boolean zzb(String str, zzn zzn) throws FirebaseMLException {
        String str2;
        if (zzn == zzn.UNKNOWN) {
            return false;
        }
        File zza = zza(str, zzn, false);
        int zzb = zzb(zza);
        if (zzb == -1) {
            str2 = null;
        } else {
            String absolutePath = zza.getAbsolutePath();
            StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 12);
            sb.append(absolutePath);
            sb.append("/");
            sb.append(zzb);
            str2 = sb.toString();
        }
        if (str2 != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final File zzc(String str, zzn zzn) throws FirebaseMLException {
        return zza(str, zzn, false);
    }

    private final File zza(String str, zzn zzn, boolean z) throws FirebaseMLException {
        File zzb = zzb(str, zzn, z);
        if (!zzb.exists()) {
            GmsLogger gmsLogger = zzbbo;
            String valueOf = String.valueOf(zzb.getAbsolutePath());
            gmsLogger.d("ModelFileHelper", valueOf.length() != 0 ? "model folder does not exist, creating one: ".concat(valueOf) : new String("model folder does not exist, creating one: "));
            if (!zzb.mkdirs()) {
                String valueOf2 = String.valueOf(zzb);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 31);
                sb.append("Failed to create model folder: ");
                sb.append(valueOf2);
                throw new FirebaseMLException(sb.toString(), 13);
            }
        } else if (!zzb.isDirectory()) {
            String valueOf3 = String.valueOf(zzb);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 71);
            sb2.append("Can not create model folder, since an existing file has the same name: ");
            sb2.append(valueOf3);
            throw new FirebaseMLException(sb2.toString(), 6);
        }
        return zzb;
    }

    public final File zzb(String str, zzn zzn, boolean z) {
        String str2;
        File file;
        int i = zzh.zzbdw[zzn.ordinal()];
        if (i == 1) {
            str2 = zzbdx;
        } else if (i == 2) {
            str2 = zzbdz;
        } else if (i == 3) {
            str2 = zzbdy;
        } else if (i == 4) {
            str2 = zzbea;
        } else {
            String name = zzn.name();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 69);
            sb.append("Unknown model type ");
            sb.append(name);
            sb.append(". Cannot find a dir to store the downloaded model.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            file = new File(this.zzbdc.getApplicationContext().getNoBackupFilesDir(), str2);
        } else {
            file = this.zzbdc.getApplicationContext().getDir(str2, 0);
        }
        if (z) {
            file = new File(file, "temp");
        }
        return new File(new File(file, this.zzbdc.getPersistenceKey()), str);
    }

    public final synchronized void zza(zzn zzn, String str) {
        zzc(zzb(str, zzn, false));
        zzc(zzb(str, zzn, true));
    }

    /* access modifiers changed from: package-private */
    public final File zzd(String str, zzn zzn) throws FirebaseMLException {
        return zza(str, zzn, true);
    }

    static int zzb(File file) {
        File[] listFiles = file.listFiles();
        int i = -1;
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                try {
                    i = Math.max(i, Integer.parseInt(file2.getName()));
                } catch (NumberFormatException unused) {
                    GmsLogger gmsLogger = zzbbo;
                    String valueOf = String.valueOf(file2.getName());
                    gmsLogger.d("ModelFileHelper", valueOf.length() != 0 ? "Contains non-integer file name ".concat(valueOf) : new String("Contains non-integer file name "));
                }
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(File file) {
        boolean z;
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            z = true;
            for (File zzc : (File[]) Preconditions.checkNotNull(file.listFiles())) {
                z = z && zzc(zzc);
            }
        } else {
            z = true;
        }
        return z && file.delete();
    }
}
