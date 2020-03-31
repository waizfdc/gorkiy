package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzhb {
    String content;
    String message;
    int statusCode;
    String zzaam;
    zzgt zzzp;

    public zzhb(int i, String str, zzgt zzgt) {
        zzmf.checkArgument(i >= 0);
        this.statusCode = i;
        this.zzaam = str;
        this.zzzp = (zzgt) zzmf.checkNotNull(zzgt);
    }

    public zzhb(zzgz zzgz) {
        this(zzgz.getStatusCode(), zzgz.getStatusMessage(), zzgz.zzfw());
        try {
            String zzge = zzgz.zzge();
            this.content = zzge;
            if (zzge.length() == 0) {
                this.content = null;
            }
        } catch (IOException e) {
            zzmz.zzb(e);
        }
        StringBuilder zzc = zzgy.zzc(zzgz);
        if (this.content != null) {
            zzc.append(zzjl.zzafu);
            zzc.append(this.content);
        }
        this.message = zzc.toString();
    }

    public final zzhb zzag(String str) {
        this.message = str;
        return this;
    }

    public final zzhb zzah(String str) {
        this.content = str;
        return this;
    }
}
