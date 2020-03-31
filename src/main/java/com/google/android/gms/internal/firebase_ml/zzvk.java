package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzvx;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class zzvk {
    private static volatile boolean zzbzz = false;
    private static boolean zzcaa = true;
    private static volatile zzvk zzcab;
    private static final zzvk zzcac = new zzvk(true);
    private final Map<zza, zzvx.zzg<?, ?>> zzcad;

    public static zzvk zzth() {
        zzvk zzvk = zzcab;
        if (zzvk == null) {
            synchronized (zzvk.class) {
                zzvk = zzcab;
                if (zzvk == null) {
                    zzvk = zzcac;
                    zzcab = zzvk;
                }
            }
        }
        return zzvk;
    }

    /* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
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

    public final <ContainingType extends zzxg> zzvx.zzg<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzcad.get(new zza(containingtype, i));
    }

    zzvk() {
        this.zzcad = new HashMap();
    }

    private zzvk(boolean z) {
        this.zzcad = Collections.emptyMap();
    }
}
