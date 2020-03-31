package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
abstract class zzmi extends zzll<String> {
    private int limit;
    private int offset = 0;
    private final zzlq zzaha;
    private final boolean zzahb;
    final CharSequence zzahd;

    protected zzmi(zzmh zzmh, CharSequence charSequence) {
        this.zzaha = zzmh.zzaha;
        this.zzahb = false;
        this.limit = zzmh.limit;
        this.zzahd = charSequence;
    }

    /* access modifiers changed from: package-private */
    public abstract int zzan(int i);

    /* access modifiers changed from: package-private */
    public abstract int zzao(int i);

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zziw() {
        int i;
        int i2 = this.offset;
        while (true) {
            int i3 = this.offset;
            if (i3 != -1) {
                int zzan = zzan(i3);
                if (zzan == -1) {
                    zzan = this.zzahd.length();
                    this.offset = -1;
                } else {
                    this.offset = zzao(zzan);
                }
                int i4 = this.offset;
                if (i4 == i2) {
                    int i5 = i4 + 1;
                    this.offset = i5;
                    if (i5 > this.zzahd.length()) {
                        this.offset = -1;
                    }
                } else {
                    while (i2 < zzan && this.zzaha.zzb(this.zzahd.charAt(i2))) {
                        i2++;
                    }
                    while (i > i2 && this.zzaha.zzb(this.zzahd.charAt(i - 1))) {
                        zzan = i - 1;
                    }
                    if (!this.zzahb || i2 != i) {
                        int i6 = this.limit;
                    } else {
                        i2 = this.offset;
                    }
                }
            } else {
                zzix();
                return null;
            }
        }
        int i62 = this.limit;
        if (i62 == 1) {
            i = this.zzahd.length();
            this.offset = -1;
            while (i > i2 && this.zzaha.zzb(this.zzahd.charAt(i - 1))) {
                i--;
            }
        } else {
            this.limit = i62 - 1;
        }
        return this.zzahd.subSequence(i2, i).toString();
    }
}
