package com.google.android.gms.internal.firebase_ml;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final class zzre extends zzkb {
    private final /* synthetic */ FirebaseApp zzbkq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzre(zzrc zzrc, String str, FirebaseApp firebaseApp) {
        super(str);
        this.zzbkq = firebaseApp;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzkc<?> zzkc) throws IOException {
        super.zza(zzkc);
        Context applicationContext = this.zzbkq.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        zzkc.zzfi().put("X-Android-Package", packageName);
        zzkc.zzfi().put("X-Android-Cert", zzrc.zzb(applicationContext, packageName));
    }
}
