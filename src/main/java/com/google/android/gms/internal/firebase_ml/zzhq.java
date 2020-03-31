package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class zzhq extends zziy implements Cloneable {
    private zzht zzabs;

    public final void zza(zzht zzht) {
        this.zzabs = zzht;
    }

    public String toString() {
        zzht zzht = this.zzabs;
        if (zzht == null) {
            return super.toString();
        }
        try {
            return zzht.toString(this);
        } catch (IOException e) {
            throw zzmm.zza(e);
        }
    }

    public final String zzgq() throws IOException {
        zzht zzht = this.zzabs;
        if (zzht != null) {
            return zzht.zzd(this);
        }
        return super.toString();
    }

    /* renamed from: zzfa */
    public zzhq clone() {
        return (zzhq) super.clone();
    }

    /* renamed from: zza */
    public zzhq zzb(String str, Object obj) {
        return (zzhq) super.zzb(str, obj);
    }

    public /* synthetic */ zziy zzfb() {
        return (zzhq) clone();
    }
}
