package com.google.android.gms.internal.vision;

import java.util.Map;
import kotlin.UShort;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzdl<K, V> extends zzdg<K, V> {
    private static final zzdg<Object, Object> zzlz = new zzdl(null, new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzlx;
    private final transient Object zzma;

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [short[], byte[]], vars: [r0v4 ?, r0v2 ?, r0v5 ?, r0v6 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    static <K, V> com.google.android.gms.internal.vision.zzdl<K, V> zza(int r10, java.lang.Object[] r11) {
        /*
            int r10 = r11.length
            r0 = 1
            int r10 = r10 >> r0
            r1 = 4
            com.google.android.gms.internal.vision.zzct.zzd(r1, r10)
            r10 = 2
            int r10 = java.lang.Math.max(r1, r10)
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 0
            r4 = 751619276(0x2ccccccc, float:5.8207657E-12)
            if (r10 >= r4) goto L_0x002c
            int r2 = r10 + -1
            int r2 = java.lang.Integer.highestOneBit(r2)
            int r0 = r2 << 1
            r2 = r0
        L_0x001d:
            double r4 = (double) r2
            r6 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            double r4 = r4 * r6
            double r6 = (double) r10
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0035
            int r2 = r2 << 1
            goto L_0x001d
        L_0x002c:
            if (r10 >= r2) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r0 = r3
        L_0x0030:
            java.lang.String r10 = "collection too large"
            com.google.android.gms.internal.vision.zzct.checkArgument(r0, r10)
        L_0x0035:
            int r10 = r2 + -1
            r0 = 128(0x80, float:1.794E-43)
            r4 = -1
            if (r2 > r0) goto L_0x0074
            byte[] r0 = new byte[r2]
            java.util.Arrays.fill(r0, r4)
        L_0x0041:
            if (r3 >= r1) goto L_0x00e6
            int r2 = r3 * 2
            r4 = r11[r2]
            r5 = r2 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.vision.zzda.zza(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.vision.zzdd.zzr(r6)
        L_0x0056:
            r6 = r6 & r10
            byte r7 = r0[r6]
            r8 = 255(0xff, float:3.57E-43)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x0064
            byte r2 = (byte) r2
            r0[r6] = r2
            int r3 = r3 + 1
            goto L_0x0041
        L_0x0064:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x006f
            int r6 = r6 + 1
            goto L_0x0056
        L_0x006f:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x0074:
            r0 = 32768(0x8000, float:4.5918E-41)
            if (r2 > r0) goto L_0x00b2
            short[] r0 = new short[r2]
            java.util.Arrays.fill(r0, r4)
        L_0x007e:
            if (r3 >= r1) goto L_0x00e6
            int r2 = r3 * 2
            r4 = r11[r2]
            r5 = r2 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.vision.zzda.zza(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.vision.zzdd.zzr(r6)
        L_0x0093:
            r6 = r6 & r10
            short r7 = r0[r6]
            r8 = 65535(0xffff, float:9.1834E-41)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x00a2
            short r2 = (short) r2
            r0[r6] = r2
            int r3 = r3 + 1
            goto L_0x007e
        L_0x00a2:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00ad
            int r6 = r6 + 1
            goto L_0x0093
        L_0x00ad:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x00b2:
            int[] r0 = new int[r2]
            java.util.Arrays.fill(r0, r4)
        L_0x00b7:
            if (r3 >= r1) goto L_0x00e6
            int r2 = r3 * 2
            r5 = r11[r2]
            r6 = r2 ^ 1
            r6 = r11[r6]
            com.google.android.gms.internal.vision.zzda.zza(r5, r6)
            int r7 = r5.hashCode()
            int r7 = com.google.android.gms.internal.vision.zzdd.zzr(r7)
        L_0x00cc:
            r7 = r7 & r10
            r8 = r0[r7]
            if (r8 != r4) goto L_0x00d6
            r0[r7] = r2
            int r3 = r3 + 1
            goto L_0x00b7
        L_0x00d6:
            r9 = r11[r8]
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x00e1
            int r7 = r7 + 1
            goto L_0x00cc
        L_0x00e1:
            java.lang.IllegalArgumentException r10 = zza(r5, r6, r11, r8)
            throw r10
        L_0x00e6:
            com.google.android.gms.internal.vision.zzdl r10 = new com.google.android.gms.internal.vision.zzdl
            r10.<init>(r0, r11, r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzdl.zza(int, java.lang.Object[]):com.google.android.gms.internal.vision.zzdl");
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    private zzdl(Object obj, Object[] objArr, int i) {
        this.zzma = obj;
        this.zzlx = objArr;
        this.size = i;
    }

    public final int size() {
        return this.size;
    }

    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.zzma;
        V[] vArr = this.zzlx;
        int i = this.size;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (vArr[0].equals(obj)) {
                return vArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int zzr = zzdd.zzr(obj.hashCode());
                while (true) {
                    int i2 = zzr & length;
                    byte b = bArr[i2] & 255;
                    if (b == 255) {
                        return null;
                    }
                    if (vArr[b].equals(obj)) {
                        return vArr[b ^ 1];
                    }
                    zzr = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int zzr2 = zzdd.zzr(obj.hashCode());
                while (true) {
                    int i3 = zzr2 & length2;
                    short s = sArr[i3] & UShort.MAX_VALUE;
                    if (s == 65535) {
                        return null;
                    }
                    if (vArr[s].equals(obj)) {
                        return vArr[s ^ 1];
                    }
                    zzr2 = i3 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int zzr3 = zzdd.zzr(obj.hashCode());
                while (true) {
                    int i4 = zzr3 & length3;
                    int i5 = iArr[i4];
                    if (i5 == -1) {
                        return null;
                    }
                    if (vArr[i5].equals(obj)) {
                        return vArr[i5 ^ 1];
                    }
                    zzr3 = i4 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzdj<Map.Entry<K, V>> zzce() {
        return new zzdk(super, this.zzlx, 0, this.size);
    }

    /* access modifiers changed from: package-private */
    public final zzdj<K> zzcf() {
        return new zzdm(super, new zzdp(this.zzlx, 0, this.size));
    }

    /* access modifiers changed from: package-private */
    public final zzdc<V> zzcg() {
        return new zzdp(this.zzlx, 1, this.size);
    }
}
