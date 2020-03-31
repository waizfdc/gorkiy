package com.google.android.gms.internal.firebase_ml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzmh {
    /* access modifiers changed from: private */
    public final int limit;
    /* access modifiers changed from: private */
    public final zzlq zzaha;
    private final boolean zzahb;
    private final zzml zzahc;

    private zzmh(zzml zzml) {
        this(zzml, false, zzlu.zzags, Integer.MAX_VALUE);
    }

    private zzmh(zzml zzml, boolean z, zzlq zzlq, int i) {
        this.zzahc = zzml;
        this.zzahb = false;
        this.zzaha = zzlq;
        this.limit = Integer.MAX_VALUE;
    }

    public static zzmh zza(zzlq zzlq) {
        zzmf.checkNotNull(zzlq);
        return new zzmh(new zzmg(zzlq));
    }

    public final List<String> zza(CharSequence charSequence) {
        zzmf.checkNotNull(charSequence);
        Iterator<String> zza = this.zzahc.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zza.hasNext()) {
            arrayList.add(zza.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
