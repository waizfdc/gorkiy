package com.google.android.gms.internal.vision;

import android.util.Base64;
import android.util.Log;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzbi extends zzbe<T> {
    private final /* synthetic */ zzbh zzgg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbi(zzbk zzbk, String str, Object obj, zzbh zzbh) {
        super(zzbk, str, obj, null);
        this.zzgg = zzbh;
    }

    /* access modifiers changed from: package-private */
    public final T zza(Object obj) {
        if (obj instanceof String) {
            try {
                return this.zzgg.zzb(Base64.decode((String) obj, 3));
            } catch (IOException | IllegalArgumentException unused) {
            }
        }
        String zzac = super.zzac();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzac).length() + 27 + String.valueOf(valueOf).length());
        sb.append("Invalid byte[] value for ");
        sb.append(zzac);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
