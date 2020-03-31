package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
public class zzeq {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzeq zzc;
    private static volatile zzeq zzd;
    private static final zzeq zze = new zzeq(true);
    private final Map<zza, zzfd.zzf<?, ?>> zzf;

    public static zzeq zza() {
        zzeq zzeq = zzc;
        if (zzeq == null) {
            synchronized (zzeq.class) {
                zzeq = zzc;
                if (zzeq == null) {
                    zzeq = zze;
                    zzc = zzeq;
                }
            }
        }
        return zzeq;
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
    static final class zza {
        private final Object zza;
        private final int zzb;

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza2 = (zza) obj;
            if (this.zza == zza2.zza && this.zzb == zza2.zzb) {
                return true;
            }
            return false;
        }
    }

    public static zzeq zzb() {
        Class<zzeq> cls = zzeq.class;
        zzeq zzeq = zzd;
        if (zzeq != null) {
            return zzeq;
        }
        synchronized (cls) {
            zzeq zzeq2 = zzd;
            if (zzeq2 != null) {
                return zzeq2;
            }
            zzeq zza2 = zzfb.zza(cls);
            zzd = zza2;
            return zza2;
        }
    }

    public final <ContainingType extends zzgo> zzfd.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzf.get(new zza(containingtype, i));
    }

    zzeq() {
        this.zzf = new HashMap();
    }

    private zzeq(boolean z) {
        this.zzf = Collections.emptyMap();
    }
}
