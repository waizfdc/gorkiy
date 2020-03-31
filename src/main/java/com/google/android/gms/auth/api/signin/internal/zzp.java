package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public final class zzp {
    private static zzp zzbn;
    private Storage zzbo;
    private GoogleSignInAccount zzbp;
    private GoogleSignInOptions zzbq = this.zzbo.getSavedDefaultGoogleSignInOptions();

    private zzp(Context context) {
        Storage instance = Storage.getInstance(context);
        this.zzbo = instance;
        this.zzbp = instance.getSavedDefaultGoogleSignInAccount();
    }

    public static synchronized zzp zzd(Context context) {
        zzp zze;
        synchronized (zzp.class) {
            zze = zze(context.getApplicationContext());
        }
        return zze;
    }

    private static synchronized zzp zze(Context context) {
        zzp zzp;
        synchronized (zzp.class) {
            if (zzbn == null) {
                zzbn = new zzp(context);
            }
            zzp = zzbn;
        }
        return zzp;
    }

    public final synchronized void clear() {
        this.zzbo.clear();
        this.zzbp = null;
        this.zzbq = null;
    }

    public final synchronized void zzc(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.zzbo.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
        this.zzbp = googleSignInAccount;
        this.zzbq = googleSignInOptions;
    }

    public final synchronized GoogleSignInAccount zzh() {
        return this.zzbp;
    }

    public final synchronized GoogleSignInOptions zzi() {
        return this.zzbq;
    }
}
