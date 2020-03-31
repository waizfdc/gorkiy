package com.google.android.gms.internal.vision;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzdh extends zzdf<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzdf zzls;

    zzdh(zzdf zzdf, int i, int i2) {
        this.zzls = super;
        this.offset = i;
        this.length = i2;
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzbz() {
        return this.zzls.zzbz();
    }

    /* access modifiers changed from: package-private */
    public final int zzca() {
        return this.zzls.zzca() + this.offset;
    }

    /* access modifiers changed from: package-private */
    public final int zzcb() {
        return this.zzls.zzca() + this.offset + this.length;
    }

    public final E get(int i) {
        zzct.zzc(i, this.length);
        return this.zzls.get(i + this.offset);
    }

    public final zzdf<E> zze(int i, int i2) {
        zzct.zza(i, i2, this.length);
        zzdf zzdf = this.zzls;
        int i3 = this.offset;
        return (zzdf) super.subList(i + i3, i2 + i3);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
