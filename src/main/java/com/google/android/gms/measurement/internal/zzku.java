package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
final class zzku implements zzfq {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzks zzb;

    zzku(zzks zzks, String str) {
        this.zzb = zzks;
        this.zza = str;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zza(i, th, bArr, this.zza);
    }
}
