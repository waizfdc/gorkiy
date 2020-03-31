package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzxm<T> implements zzya<T> {
    private final zzxg zzcfx;
    private final boolean zzcfy;
    private final zzys<?, ?> zzcgh;
    private final zzvm<?> zzcgi;

    private zzxm(zzys<?, ?> zzys, zzvm<?> zzvm, zzxg zzxg) {
        this.zzcgh = zzys;
        this.zzcfy = zzvm.zze(zzxg);
        this.zzcgi = zzvm;
        this.zzcfx = zzxg;
    }

    static <T> zzxm<T> zza(zzys<?, ?> zzys, zzvm<?> zzvm, zzxg zzxg) {
        return new zzxm<>(zzys, zzvm, zzxg);
    }

    public final T newInstance() {
        return this.zzcfx.zzuf().zztw();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzcgh.zzae(t).equals(this.zzcgh.zzae(t2))) {
            return false;
        }
        if (this.zzcfy) {
            return this.zzcgi.zzo(t).equals(this.zzcgi.zzo(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzcgh.zzae(t).hashCode();
        return this.zzcfy ? (hashCode * 53) + this.zzcgi.zzo(t).hashCode() : hashCode;
    }

    public final void zze(T t, T t2) {
        zzyc.zza(this.zzcgh, t, t2);
        if (this.zzcfy) {
            zzyc.zza(this.zzcgi, t, t2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzzp.zza(int, java.lang.Object):void
     arg types: [int, com.google.android.gms.internal.firebase_ml.zzuq]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzzp.zza(int, double):void
      com.google.android.gms.internal.firebase_ml.zzzp.zza(int, float):void
      com.google.android.gms.internal.firebase_ml.zzzp.zza(int, long):void
      com.google.android.gms.internal.firebase_ml.zzzp.zza(int, com.google.android.gms.internal.firebase_ml.zzuq):void
      com.google.android.gms.internal.firebase_ml.zzzp.zza(int, java.util.List<java.lang.String>):void
      com.google.android.gms.internal.firebase_ml.zzzp.zza(int, boolean):void
      com.google.android.gms.internal.firebase_ml.zzzp.zza(int, java.lang.Object):void */
    public final void zza(T t, zzzp zzzp) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzcgi.zzo(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzvs zzvs = (zzvs) next.getKey();
            if (zzvs.zzto() != zzzm.MESSAGE || zzvs.zztp() || zzvs.zztq()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzwn) {
                zzzp.zza(zzvs.zzb(), (Object) ((zzwn) next).zzuq().zzsk());
            } else {
                zzzp.zza(zzvs.zzb(), next.getValue());
            }
        }
        zzys<?, ?> zzys = this.zzcgh;
        zzys.zzc(zzys.zzae(t), zzzp);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.firebase_ml.zzvx$zzg} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.firebase_ml.zzup r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.firebase_ml.zzvx r0 = (com.google.android.gms.internal.firebase_ml.zzvx) r0
            com.google.android.gms.internal.firebase_ml.zzyv r1 = r0.zzcdg
            com.google.android.gms.internal.firebase_ml.zzyv r2 = com.google.android.gms.internal.firebase_ml.zzyv.zzwc()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.firebase_ml.zzyv r1 = com.google.android.gms.internal.firebase_ml.zzyv.zzwd()
            r0.zzcdg = r1
        L_0x0011:
            com.google.android.gms.internal.firebase_ml.zzvx$zze r10 = (com.google.android.gms.internal.firebase_ml.zzvx.zze) r10
            r10.zzug()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r11, r12, r14)
            int r2 = r14.zzbze
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.firebase_ml.zzvm<?> r12 = r9.zzcgi
            com.google.android.gms.internal.firebase_ml.zzvk r0 = r14.zzkj
            com.google.android.gms.internal.firebase_ml.zzxg r3 = r9.zzcfx
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.firebase_ml.zzvx$zzg r0 = (com.google.android.gms.internal.firebase_ml.zzvx.zzg) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.firebase_ml.zzum.zza(r2, r3, r4, r5, r6, r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.firebase_ml.zzxv.zzvk()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.firebase_ml.zzum.zza(r2, r11, r4, r13, r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r11, r4, r14)
            int r5 = r14.zzbze
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zzbzg
            com.google.android.gms.internal.firebase_ml.zzuq r2 = (com.google.android.gms.internal.firebase_ml.zzuq) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.firebase_ml.zzxv.zzvk()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r11, r4, r14)
            int r12 = r14.zzbze
            com.google.android.gms.internal.firebase_ml.zzvm<?> r0 = r9.zzcgi
            com.google.android.gms.internal.firebase_ml.zzvk r5 = r14.zzkj
            com.google.android.gms.internal.firebase_ml.zzxg r6 = r9.zzcfx
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.firebase_ml.zzvx$zzg r0 = (com.google.android.gms.internal.firebase_ml.zzvx.zzg) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r5, r11, r4, r13, r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzb(r12, r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.firebase_ml.zzwg r10 = com.google.android.gms.internal.firebase_ml.zzwg.zzum()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzxm.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.firebase_ml.zzup):void");
    }

    public final void zzq(T t) {
        this.zzcgh.zzq(t);
        this.zzcgi.zzq(t);
    }

    public final boolean zzac(T t) {
        return this.zzcgi.zzo(t).isInitialized();
    }

    public final int zzaa(T t) {
        zzys<?, ?> zzys = this.zzcgh;
        int zzaf = zzys.zzaf(zzys.zzae(t)) + 0;
        return this.zzcfy ? zzaf + this.zzcgi.zzo(t).zztm() : zzaf;
    }
}
