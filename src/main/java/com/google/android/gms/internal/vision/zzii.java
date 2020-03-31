package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzii<T> implements zzir<T> {
    private final zzic zzyy;
    private final boolean zzyz;
    private final zzjj<?, ?> zzzi;
    private final zzgf<?> zzzj;

    private zzii(zzjj<?, ?> zzjj, zzgf<?> zzgf, zzic zzic) {
        this.zzzi = zzjj;
        this.zzyz = zzgf.zze(zzic);
        this.zzzj = zzgf;
        this.zzyy = zzic;
    }

    static <T> zzii<T> zza(zzjj<?, ?> zzjj, zzgf<?> zzgf, zzic zzic) {
        return new zzii<>(zzjj, zzgf, zzic);
    }

    public final T newInstance() {
        return this.zzyy.zzgj().zzgb();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzzi.zzv(t).equals(this.zzzi.zzv(t2))) {
            return false;
        }
        if (this.zzyz) {
            return this.zzzj.zze((Object) t).equals(this.zzzj.zze((Object) t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzzi.zzv(t).hashCode();
        return this.zzyz ? (hashCode * 53) + this.zzzj.zze((Object) t).hashCode() : hashCode;
    }

    public final void zzd(T t, T t2) {
        zzit.zza(this.zzzi, t, t2);
        if (this.zzyz) {
            zzit.zza(this.zzzj, t, t2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzkg.zza(int, java.lang.Object):void
     arg types: [int, com.google.android.gms.internal.vision.zzfh]
     candidates:
      com.google.android.gms.internal.vision.zzkg.zza(int, double):void
      com.google.android.gms.internal.vision.zzkg.zza(int, float):void
      com.google.android.gms.internal.vision.zzkg.zza(int, long):void
      com.google.android.gms.internal.vision.zzkg.zza(int, com.google.android.gms.internal.vision.zzfh):void
      com.google.android.gms.internal.vision.zzkg.zza(int, java.lang.String):void
      com.google.android.gms.internal.vision.zzkg.zza(int, java.util.List<java.lang.String>):void
      com.google.android.gms.internal.vision.zzkg.zza(int, boolean):void
      com.google.android.gms.internal.vision.zzkg.zza(int, java.lang.Object):void */
    public final void zza(T t, zzkg zzkg) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzzj.zze((Object) t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzgk zzgk = (zzgk) next.getKey();
            if (zzgk.zzft() != zzkd.MESSAGE || zzgk.zzfu() || zzgk.zzfv()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzhf) {
                zzkg.zza(zzgk.zzag(), (Object) ((zzhf) next).zzgw().zzdk());
            } else {
                zzkg.zza(zzgk.zzag(), next.getValue());
            }
        }
        zzjj<?, ?> zzjj = this.zzzi;
        zzjj.zzc(zzjj.zzv(t), zzkg);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.google.android.gms.internal.vision.zzgs$zzg} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.vision.zzfb r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.android.gms.internal.vision.zzgs r0 = (com.google.android.gms.internal.vision.zzgs) r0
            com.google.android.gms.internal.vision.zzjm r1 = r0.zzwd
            com.google.android.gms.internal.vision.zzjm r2 = com.google.android.gms.internal.vision.zzjm.zzig()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.vision.zzjm r1 = com.google.android.gms.internal.vision.zzjm.zzih()
            r0.zzwd = r1
        L_0x0011:
            com.google.android.gms.internal.vision.zzgs$zze r11 = (com.google.android.gms.internal.vision.zzgs.zze) r11
            com.google.android.gms.internal.vision.zzgi r11 = r11.zzgk()
            r0 = 0
            r2 = r0
        L_0x0019:
            if (r13 >= r14) goto L_0x00c9
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r12, r13, r15)
            int r13 = r15.zzro
            r3 = 11
            r5 = 2
            if (r13 == r3) goto L_0x0065
            r3 = r13 & 7
            if (r3 != r5) goto L_0x0060
            com.google.android.gms.internal.vision.zzgf<?> r2 = r10.zzzj
            com.google.android.gms.internal.vision.zzgd r3 = r15.zzcm
            com.google.android.gms.internal.vision.zzic r5 = r10.zzyy
            int r6 = r13 >>> 3
            java.lang.Object r2 = r2.zza(r3, r5, r6)
            r8 = r2
            com.google.android.gms.internal.vision.zzgs$zzg r8 = (com.google.android.gms.internal.vision.zzgs.zzg) r8
            if (r8 == 0) goto L_0x0055
            com.google.android.gms.internal.vision.zzin r13 = com.google.android.gms.internal.vision.zzin.zzho()
            com.google.android.gms.internal.vision.zzic r2 = r8.zzxa
            java.lang.Class r2 = r2.getClass()
            com.google.android.gms.internal.vision.zzir r13 = r13.zzf(r2)
            int r13 = com.google.android.gms.internal.vision.zzez.zza(r13, r12, r4, r14, r15)
            com.google.android.gms.internal.vision.zzgs$zzd r2 = r8.zzxb
            java.lang.Object r3 = r15.zzrq
            r11.zza(r2, r3)
            goto L_0x005e
        L_0x0055:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.android.gms.internal.vision.zzez.zza(r2, r3, r4, r5, r6, r7)
        L_0x005e:
            r2 = r8
            goto L_0x0019
        L_0x0060:
            int r13 = com.google.android.gms.internal.vision.zzez.zza(r13, r12, r4, r14, r15)
            goto L_0x0019
        L_0x0065:
            r13 = 0
            r3 = r0
        L_0x0067:
            if (r4 >= r14) goto L_0x00be
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r12, r4, r15)
            int r6 = r15.zzro
            int r7 = r6 >>> 3
            r8 = r6 & 7
            if (r7 == r5) goto L_0x00a0
            r9 = 3
            if (r7 == r9) goto L_0x0079
            goto L_0x00b5
        L_0x0079:
            if (r2 == 0) goto L_0x0095
            com.google.android.gms.internal.vision.zzin r6 = com.google.android.gms.internal.vision.zzin.zzho()
            com.google.android.gms.internal.vision.zzic r7 = r2.zzxa
            java.lang.Class r7 = r7.getClass()
            com.google.android.gms.internal.vision.zzir r6 = r6.zzf(r7)
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r6, r12, r4, r14, r15)
            com.google.android.gms.internal.vision.zzgs$zzd r6 = r2.zzxb
            java.lang.Object r7 = r15.zzrq
            r11.zza(r6, r7)
            goto L_0x0067
        L_0x0095:
            if (r8 != r5) goto L_0x00b5
            int r4 = com.google.android.gms.internal.vision.zzez.zze(r12, r4, r15)
            java.lang.Object r3 = r15.zzrq
            com.google.android.gms.internal.vision.zzfh r3 = (com.google.android.gms.internal.vision.zzfh) r3
            goto L_0x0067
        L_0x00a0:
            if (r8 != 0) goto L_0x00b5
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r12, r4, r15)
            int r13 = r15.zzro
            com.google.android.gms.internal.vision.zzgf<?> r2 = r10.zzzj
            com.google.android.gms.internal.vision.zzgd r6 = r15.zzcm
            com.google.android.gms.internal.vision.zzic r7 = r10.zzyy
            java.lang.Object r2 = r2.zza(r6, r7, r13)
            com.google.android.gms.internal.vision.zzgs$zzg r2 = (com.google.android.gms.internal.vision.zzgs.zzg) r2
            goto L_0x0067
        L_0x00b5:
            r7 = 12
            if (r6 == r7) goto L_0x00be
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r6, r12, r4, r14, r15)
            goto L_0x0067
        L_0x00be:
            if (r3 == 0) goto L_0x00c6
            int r13 = r13 << 3
            r13 = r13 | r5
            r1.zzb(r13, r3)
        L_0x00c6:
            r13 = r4
            goto L_0x0019
        L_0x00c9:
            if (r13 != r14) goto L_0x00cc
            return
        L_0x00cc:
            com.google.android.gms.internal.vision.zzhc r11 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzii.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.zzfb):void");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzjj.zza(java.lang.Object, int, com.google.android.gms.internal.vision.zzfh):void
     arg types: [?, int, com.google.android.gms.internal.vision.zzfh]
     candidates:
      com.google.android.gms.internal.vision.zzjj.zza(java.lang.Object, int, long):void
      com.google.android.gms.internal.vision.zzjj.zza(java.lang.Object, int, java.lang.Object):void
      com.google.android.gms.internal.vision.zzjj.zza(java.lang.Object, int, com.google.android.gms.internal.vision.zzfh):void */
    public final void zza(Object obj, zzis zzis, zzgd zzgd) throws IOException {
        boolean z;
        zzjj<?, ?> zzjj = this.zzzi;
        zzgf<?> zzgf = this.zzzj;
        Object zzw = zzjj.zzw(obj);
        zzgi<?> zzf = zzgf.zzf(obj);
        do {
            try {
                if (zzis.zzdu() == Integer.MAX_VALUE) {
                    zzjj.zzg(obj, zzw);
                    return;
                }
                int tag = zzis.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj2 = null;
                    zzfh zzfh = null;
                    while (zzis.zzdu() != Integer.MAX_VALUE) {
                        int tag2 = zzis.getTag();
                        if (tag2 == 16) {
                            i = zzis.zzee();
                            obj2 = zzgf.zza(zzgd, this.zzyy, i);
                        } else if (tag2 == 26) {
                            if (obj2 != null) {
                                zzgf.zza(zzis, obj2, zzgd, zzf);
                            } else {
                                zzfh = zzis.zzed();
                            }
                        } else if (!zzis.zzdv()) {
                            break;
                        }
                    }
                    if (zzis.getTag() != 12) {
                        throw zzhc.zzgq();
                    } else if (zzfh != null) {
                        if (obj2 != null) {
                            zzgf.zza(zzfh, obj2, zzgd, zzf);
                        } else {
                            zzjj.zza((Object) zzw, i, zzfh);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzgf.zza(zzgd, this.zzyy, tag >>> 3);
                    if (zza != null) {
                        zzgf.zza(zzis, zza, zzgd, zzf);
                    } else {
                        z = zzjj.zza(zzw, zzis);
                        continue;
                    }
                } else {
                    z = zzis.zzdv();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzjj.zzg(obj, zzw);
            }
        } while (z);
    }

    public final void zzg(T t) {
        this.zzzi.zzg(t);
        this.zzzj.zzg(t);
    }

    public final boolean zzt(T t) {
        return this.zzzj.zze((Object) t).isInitialized();
    }

    public final int zzr(T t) {
        zzjj<?, ?> zzjj = this.zzzi;
        int zzx = zzjj.zzx(zzjj.zzv(t)) + 0;
        return this.zzyz ? zzx + this.zzzj.zze((Object) t).zzfo() : zzx;
    }
}
