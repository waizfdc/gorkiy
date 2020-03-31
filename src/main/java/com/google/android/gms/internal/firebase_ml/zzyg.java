package com.google.android.gms.internal.firebase_ml;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzyg extends zzym {
    private final /* synthetic */ zzyf zzchm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzyg(zzyf zzyf) {
        super(zzyf, null);
        this.zzchm = zzyf;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzyh(this.zzchm, null);
    }

    /* synthetic */ zzyg(zzyf zzyf, zzye zzye) {
        this(zzyf);
    }
}
