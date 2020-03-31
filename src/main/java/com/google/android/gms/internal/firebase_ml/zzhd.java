package com.google.android.gms.internal.firebase_ml;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public abstract class zzhd {
    static final Logger zzaav = Logger.getLogger(zzhd.class.getName());
    private static final String[] zzaaw;

    /* access modifiers changed from: protected */
    public abstract zzhc zzc(String str, String str2) throws IOException;

    public final zzgx zza(zzgw zzgw) {
        return new zzgx(this, zzgw);
    }

    public boolean zzai(String str) throws IOException {
        return Arrays.binarySearch(zzaaw, str) >= 0;
    }

    static {
        String[] strArr = {HttpRequest.METHOD_DELETE, HttpRequest.METHOD_GET, HttpRequest.METHOD_POST, HttpRequest.METHOD_PUT};
        zzaaw = strArr;
        Arrays.sort(strArr);
    }
}
