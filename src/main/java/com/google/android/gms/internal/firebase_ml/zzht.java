package com.google.android.gms.internal.firebase_ml;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public abstract class zzht {
    public abstract zzhs zza(OutputStream outputStream, Charset charset) throws IOException;

    public abstract zzhx zza(InputStream inputStream) throws IOException;

    public abstract zzhx zza(InputStream inputStream, Charset charset) throws IOException;

    public abstract zzhx zzam(String str) throws IOException;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzht.zza(java.lang.Object, boolean):java.lang.String
     arg types: [java.lang.Object, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzht.zza(java.io.OutputStream, java.nio.charset.Charset):com.google.android.gms.internal.firebase_ml.zzhs
      com.google.android.gms.internal.firebase_ml.zzht.zza(java.io.InputStream, java.nio.charset.Charset):com.google.android.gms.internal.firebase_ml.zzhx
      com.google.android.gms.internal.firebase_ml.zzht.zza(java.lang.Object, boolean):java.lang.String */
    public final String toString(Object obj) throws IOException {
        return zza(obj, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzht.zza(java.lang.Object, boolean):java.lang.String
     arg types: [java.lang.Object, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzht.zza(java.io.OutputStream, java.nio.charset.Charset):com.google.android.gms.internal.firebase_ml.zzhs
      com.google.android.gms.internal.firebase_ml.zzht.zza(java.io.InputStream, java.nio.charset.Charset):com.google.android.gms.internal.firebase_ml.zzhx
      com.google.android.gms.internal.firebase_ml.zzht.zza(java.lang.Object, boolean):java.lang.String */
    public final String zzd(Object obj) throws IOException {
        return zza(obj, true);
    }

    private final String zza(Object obj, boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        zzhs zza = zza(byteArrayOutputStream, zzio.UTF_8);
        if (z) {
            zza.zzgw();
        }
        zza.zzc(obj);
        zza.flush();
        return byteArrayOutputStream.toString(HttpRequest.CHARSET_UTF8);
    }
}
