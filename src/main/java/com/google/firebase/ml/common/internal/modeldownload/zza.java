package com.google.firebase.ml.common.internal.modeldownload;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.firebase_ml.zzmz;
import com.google.android.gms.internal.firebase_ml.zzpn;
import com.google.firebase.ml.common.FirebaseMLException;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zza implements zzk {
    private static final GmsLogger zzbbo = new GmsLogger("AutoMLModelFileManager", "");
    private final zzpn zzbdc;
    private final String zzbdo;
    private final zzi zzbdp;

    zza(zzpn zzpn, String str) {
        this.zzbdc = zzpn;
        this.zzbdo = str;
        this.zzbdp = new zzi(zzpn);
    }

    public final File zza(File file) throws FirebaseMLException {
        File zzc = this.zzbdp.zzc(this.zzbdo, zzn.AUTOML);
        File file2 = new File(new File(zzc, String.valueOf(zzi.zzb(zzc) + 1)), "model.tflite");
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        File zza = zza(this.zzbdc, this.zzbdo);
        File file3 = new File(parentFile, "labels.txt");
        if (!file.renameTo(file2) || !zza.renameTo(file3)) {
            zzbbo.d("AutoMLModelFileManager", "Rename to serving model failed, remove the temp file.");
            if (!file.delete()) {
                GmsLogger gmsLogger = zzbbo;
                String valueOf = String.valueOf(file.getAbsolutePath());
                gmsLogger.d("AutoMLModelFileManager", valueOf.length() != 0 ? "Failed to delete the temp model file: ".concat(valueOf) : new String("Failed to delete the temp model file: "));
            }
            if (zza.delete()) {
                return null;
            }
            GmsLogger gmsLogger2 = zzbbo;
            String valueOf2 = String.valueOf(zza.getAbsolutePath());
            gmsLogger2.d("AutoMLModelFileManager", valueOf2.length() != 0 ? "Failed to delete the temp labels file: ".concat(valueOf2) : new String("Failed to delete the temp labels file: "));
            return null;
        }
        zzbbo.d("AutoMLModelFileManager", "Rename to serving model successfully");
        file2.setExecutable(false);
        file2.setWritable(false);
        file3.setExecutable(false);
        file3.setWritable(false);
        try {
            zza(new File(parentFile, "manifest.json"), new zzc(String.format("{\n\t\"modelType\": \"%s\",\n\t\"modelFile\": \"%s\",\n\t\"labelsFile\": \"%s\"\n}", "IMAGE_LABELING", "model.tflite", "labels.txt")));
            return file2.getParentFile();
        } catch (IOException e) {
            String valueOf3 = String.valueOf(this.zzbdo);
            throw new FirebaseMLException(valueOf3.length() != 0 ? "Failed to write manifest json for the AutoML model: ".concat(valueOf3) : new String("Failed to write manifest json for the AutoML model: "), 13, e);
        }
    }

    public static void zza(zzpn zzpn, String str, List<String> list) throws FirebaseMLException {
        try {
            zza(zza(zzpn, str), new zzb(list));
        } catch (IOException e) {
            String valueOf = String.valueOf(str);
            throw new FirebaseMLException(valueOf.length() != 0 ? "Failed to write labels file for the AutoML model: ".concat(valueOf) : new String("Failed to write labels file for the AutoML model: "), 13, e);
        }
    }

    public static File zza(zzpn zzpn, String str) throws FirebaseMLException {
        File zzd = new zzi(zzpn).zzd(str, zzn.AUTOML);
        if (!zzd.exists() || !zzd.isFile() || zzd.delete()) {
            if (!zzd.exists()) {
                GmsLogger gmsLogger = zzbbo;
                String valueOf = String.valueOf(zzd.getAbsolutePath());
                gmsLogger.d("AutoMLModelFileManager", valueOf.length() != 0 ? "Temp labels folder does not exist, creating one: ".concat(valueOf) : new String("Temp labels folder does not exist, creating one: "));
                if (!zzd.mkdirs()) {
                    throw new FirebaseMLException("Failed to create a directory to hold the AutoML model's labels file.", 13);
                }
            }
            return new File(zzd, "labels.txt");
        }
        String valueOf2 = String.valueOf(zzd.getAbsolutePath());
        throw new FirebaseMLException(valueOf2.length() != 0 ? "Failed to delete the temp labels file: ".concat(valueOf2) : new String("Failed to delete the temp labels file: "), 13);
    }

    private static void zza(File file, zze zze) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), Charset.forName(HttpRequest.CHARSET_UTF8)));
        try {
            zze.zza(bufferedWriter);
            bufferedWriter.close();
            return;
        } catch (Throwable th) {
            zzmz.zza(th, th);
        }
        throw th;
    }

    static final /* synthetic */ void zza(List list, BufferedWriter bufferedWriter) throws IOException {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bufferedWriter.write((String) it.next());
            bufferedWriter.newLine();
        }
    }
}
