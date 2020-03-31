package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class zzfz {
    private static final Logger logger = Logger.getLogger(zzfz.class.getName());
    private final zzgf zzyb;
    private final zzji zzyd;
    private final String zzye;
    private final String zzyf;
    private final String zzyg;
    private final String zzyh;
    private final zzgx zzyi;
    private final boolean zzyj;
    private final boolean zzyk;

    protected zzfz(zza zza2) {
        zzgx zzgx;
        this.zzyb = zza2.zzyb;
        this.zzye = zzl(zza2.zzye);
        this.zzyf = zzm(zza2.zzyf);
        this.zzyg = zza2.zzyg;
        if (zzmn.zzbb(zza2.zzyh)) {
            logger.logp(Level.WARNING, "com.google.api.client.googleapis.services.AbstractGoogleClient", "<init>", "Application name is not set. Call Builder#setApplicationName.");
        }
        this.zzyh = zza2.zzyh;
        if (zza2.zzyc == null) {
            zzgx = zza2.zzya.zza(null);
        } else {
            zzgx = zza2.zzya.zza(zza2.zzyc);
        }
        this.zzyi = zzgx;
        this.zzyd = zza2.zzyd;
        this.zzyj = false;
        this.zzyk = false;
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static abstract class zza {
        final zzhd zzya;
        zzgf zzyb;
        zzgw zzyc;
        final zzji zzyd;
        String zzye;
        String zzyf;
        String zzyg;
        String zzyh;

        protected zza(zzhd zzhd, String str, String str2, zzji zzji, zzgw zzgw) {
            this.zzya = (zzhd) zzmf.checkNotNull(zzhd);
            this.zzyd = zzji;
            zzh(str);
            zzi(str2);
            this.zzyc = zzgw;
        }

        public zza zzh(String str) {
            this.zzye = zzfz.zzl(str);
            return this;
        }

        public zza zzi(String str) {
            this.zzyf = zzfz.zzm(str);
            return this;
        }

        public zza zzj(String str) {
            this.zzyg = str;
            return this;
        }

        public zza zza(zzgf zzgf) {
            this.zzyb = zzgf;
            return this;
        }

        public zza zzk(String str) {
            this.zzyh = str;
            return this;
        }
    }

    public final String zzfd() {
        String valueOf = String.valueOf(this.zzye);
        String valueOf2 = String.valueOf(this.zzyf);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String zzfe() {
        return this.zzyh;
    }

    public final zzgx zzff() {
        return this.zzyi;
    }

    public zzji zzfg() {
        return this.zzyd;
    }

    /* access modifiers changed from: protected */
    public void zza(zzgb<?> zzgb) throws IOException {
        zzgf zzgf = this.zzyb;
        if (zzgf != null) {
            zzgf.zza(zzgb);
        }
    }

    static String zzl(String str) {
        zzmf.checkNotNull(str, "root URL cannot be null.");
        return !str.endsWith("/") ? String.valueOf(str).concat("/") : str;
    }

    static String zzm(String str) {
        zzmf.checkNotNull(str, "service path cannot be null");
        if (str.length() == 1) {
            zzmf.checkArgument("/".equals(str), "service path must equal \"/\" if it is of length 1.");
            return "";
        } else if (str.length() <= 0) {
            return str;
        } else {
            if (!str.endsWith("/")) {
                str = String.valueOf(str).concat("/");
            }
            return str.startsWith("/") ? str.substring(1) : str;
        }
    }
}
