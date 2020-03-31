package com.google.android.gms.internal.firebase_ml;

import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
enum zzhh {
    PLUS('+', "", ",", false, true),
    HASH('#', "#", ",", false, true),
    DOT('.', ".", ".", false, false),
    FORWARD_SLASH('/', "/", "/", false, false),
    SEMI_COLON(';', ";", ";", true, false),
    QUERY('?', "?", "&", true, false),
    AMP(Character.valueOf(Typography.amp), "&", "&", true, false),
    SIMPLE(null, "", ",", false, false);
    
    private final Character zzabg;
    private final String zzabh;
    private final String zzabi;
    private final boolean zzabj;
    private final boolean zzabk;

    private zzhh(Character ch, String str, String str2, boolean z, boolean z2) {
        this.zzabg = ch;
        this.zzabh = (String) zzmf.checkNotNull(str);
        this.zzabi = (String) zzmf.checkNotNull(str2);
        this.zzabj = z;
        this.zzabk = z2;
        if (ch != null) {
            zzhe.zzaax.put(ch, this);
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzgk() {
        return this.zzabh;
    }

    /* access modifiers changed from: package-private */
    public final String zzgl() {
        return this.zzabi;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzgm() {
        return this.zzabj;
    }

    /* access modifiers changed from: package-private */
    public final int zzgn() {
        return this.zzabg == null ? 0 : 1;
    }

    /* access modifiers changed from: package-private */
    public final String zzaj(String str) {
        if (this.zzabk) {
            return zzjs.zzas(str);
        }
        return zzjs.zzaq(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzgo() {
        return this.zzabk;
    }
}
