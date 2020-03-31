package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public class zzgd {
    private static volatile boolean zzsv = false;
    private static boolean zzsw = true;
    private static volatile zzgd zzsx;
    private static volatile zzgd zzsy;
    private static final zzgd zzsz = new zzgd(true);
    private final Map<zza, zzgs.zzg<?, ?>> zzta;

    public static zzgd zzfk() {
        return new zzgd();
    }

    public static zzgd zzfl() {
        zzgd zzgd = zzsx;
        if (zzgd == null) {
            synchronized (zzgd.class) {
                zzgd = zzsx;
                if (zzgd == null) {
                    zzgd = zzsz;
                    zzsx = zzgd;
                }
            }
        }
        return zzgd;
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }
    }

    public static zzgd zzfm() {
        Class<zzgd> cls = zzgd.class;
        zzgd zzgd = zzsy;
        if (zzgd == null) {
            synchronized (cls) {
                zzgd = zzsy;
                if (zzgd == null) {
                    zzgd = zzgr.zzc(cls);
                    zzsy = zzgd;
                }
            }
        }
        return zzgd;
    }

    public final <ContainingType extends zzic> zzgs.zzg<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzta.get(new zza(containingtype, i));
    }

    public final void zza(zzgs.zzg<?, ?> zzg) {
        this.zzta.put(new zza(zzg.zzwz, zzg.zzxb.number), zzg);
    }

    zzgd() {
        this.zzta = new HashMap();
    }

    private zzgd(boolean z) {
        this.zzta = Collections.emptyMap();
    }
}
