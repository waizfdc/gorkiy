package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class zzgy extends IOException {
    private final String content;
    private final int statusCode;
    private final String zzaam;
    private final transient zzgt zzzp;

    public zzgy(zzgz zzgz) {
        this(new zzhb(zzgz));
    }

    protected zzgy(zzhb zzhb) {
        super(zzhb.message);
        this.statusCode = zzhb.statusCode;
        this.zzaam = zzhb.zzaam;
        this.zzzp = zzhb.zzzp;
        this.content = zzhb.content;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public static StringBuilder zzc(zzgz zzgz) {
        StringBuilder sb = new StringBuilder();
        int statusCode2 = zzgz.getStatusCode();
        if (statusCode2 != 0) {
            sb.append(statusCode2);
        }
        String statusMessage = zzgz.getStatusMessage();
        if (statusMessage != null) {
            if (statusCode2 != 0) {
                sb.append(' ');
            }
            sb.append(statusMessage);
        }
        return sb;
    }
}
