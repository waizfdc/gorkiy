package com.google.android.gms.internal.firebase_ml;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzsi implements Closeable {
    private static final char[] zzboi = ")]}'\n".toCharArray();
    private final Reader in;
    private int limit = 0;
    private int pos = 0;
    private boolean zzboj = false;
    private final char[] zzbok = new char[1024];
    private int zzbol = 0;
    private int zzbom = 0;
    private int zzbon = 0;
    private long zzboo;
    private int zzbop;
    private String zzboq;
    private int[] zzbor;
    private int zzbos;
    private String[] zzbot;
    private int[] zzbou;

    public zzsi(Reader reader) {
        int[] iArr = new int[32];
        this.zzbor = iArr;
        this.zzbos = 0;
        this.zzbos = 0 + 1;
        iArr[0] = 6;
        this.zzbot = new String[32];
        this.zzbou = new int[32];
        if (reader != null) {
            this.in = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    public final void setLenient(boolean z) {
        this.zzboj = true;
    }

    public final void beginArray() throws IOException {
        int i = this.zzbon;
        if (i == 0) {
            i = zzql();
        }
        if (i == 3) {
            zzbz(1);
            this.zzbou[this.zzbos - 1] = 0;
            this.zzbon = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + zzqk() + zzqp());
    }

    public final void endArray() throws IOException {
        int i = this.zzbon;
        if (i == 0) {
            i = zzql();
        }
        if (i == 4) {
            int i2 = this.zzbos - 1;
            this.zzbos = i2;
            int[] iArr = this.zzbou;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.zzbon = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + zzqk() + zzqp());
    }

    public final void beginObject() throws IOException {
        int i = this.zzbon;
        if (i == 0) {
            i = zzql();
        }
        if (i == 1) {
            zzbz(3);
            this.zzbon = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + zzqk() + zzqp());
    }

    public final void endObject() throws IOException {
        int i = this.zzbon;
        if (i == 0) {
            i = zzql();
        }
        if (i == 2) {
            int i2 = this.zzbos - 1;
            this.zzbos = i2;
            this.zzbot[i2] = null;
            int[] iArr = this.zzbou;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.zzbon = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + zzqk() + zzqp());
    }

    public final zzsk zzqk() throws IOException {
        int i = this.zzbon;
        if (i == 0) {
            i = zzql();
        }
        switch (i) {
            case 1:
                return zzsk.BEGIN_OBJECT;
            case 2:
                return zzsk.END_OBJECT;
            case 3:
                return zzsk.BEGIN_ARRAY;
            case 4:
                return zzsk.END_ARRAY;
            case 5:
            case 6:
                return zzsk.BOOLEAN;
            case 7:
                return zzsk.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return zzsk.STRING;
            case 12:
            case 13:
            case 14:
                return zzsk.NAME;
            case 15:
            case 16:
                return zzsk.NUMBER;
            case 17:
                return zzsk.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:142:0x01fb, code lost:
        if (zze(r5) == false) goto L_0x01fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x01fe, code lost:
        if (r4 != 2) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0200, code lost:
        if (r11 == false) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0206, code lost:
        if (r12 != Long.MIN_VALUE) goto L_0x020a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0208, code lost:
        if (r16 == false) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x020e, code lost:
        if (r12 != 0) goto L_0x0212;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0210, code lost:
        if (r16 != false) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0212, code lost:
        if (r16 == false) goto L_0x0215;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0215, code lost:
        r12 = -r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0216, code lost:
        r0.zzboo = r12;
        r0.pos += r9;
        r5 = 15;
        r0.zzbon = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0222, code lost:
        if (r4 == 2) goto L_0x022d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0225, code lost:
        if (r4 == 4) goto L_0x022d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0228, code lost:
        if (r4 != 7) goto L_0x022b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x022d, code lost:
        r0.zzbop = r9;
        r5 = 16;
        r0.zzbon = 16;
     */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0173 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0174  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzql() throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            int[] r1 = r0.zzbor
            int r2 = r0.zzbos
            int r3 = r2 + -1
            r3 = r1[r3]
            r4 = 8
            r7 = 93
            r8 = 59
            r9 = 44
            r10 = 3
            r11 = 6
            r12 = 7
            r13 = 4
            r14 = 5
            r15 = 2
            r5 = 0
            r6 = 1
            if (r3 != r6) goto L_0x0021
            int r2 = r2 - r6
            r1[r2] = r15
            goto L_0x00d0
        L_0x0021:
            if (r3 != r15) goto L_0x003c
            int r1 = r0.zzav(r6)
            if (r1 == r9) goto L_0x00d0
            if (r1 == r8) goto L_0x0037
            if (r1 != r7) goto L_0x0030
            r0.zzbon = r13
            return r13
        L_0x0030:
            java.lang.String r1 = "Unterminated array"
            java.io.IOException r1 = r0.zzcd(r1)
            throw r1
        L_0x0037:
            r19.zzqn()
            goto L_0x00d0
        L_0x003c:
            if (r3 == r10) goto L_0x02b0
            if (r3 != r14) goto L_0x0042
            goto L_0x02b0
        L_0x0042:
            if (r3 != r13) goto L_0x0077
            int r2 = r2 - r6
            r1[r2] = r14
            int r1 = r0.zzav(r6)
            r2 = 58
            if (r1 == r2) goto L_0x00d0
            r2 = 61
            if (r1 != r2) goto L_0x0070
            r19.zzqn()
            int r1 = r0.pos
            int r2 = r0.limit
            if (r1 < r2) goto L_0x0062
            boolean r1 = r0.zzca(r6)
            if (r1 == 0) goto L_0x00d0
        L_0x0062:
            char[] r1 = r0.zzbok
            int r2 = r0.pos
            char r1 = r1[r2]
            r13 = 62
            if (r1 != r13) goto L_0x00d0
            int r2 = r2 + r6
            r0.pos = r2
            goto L_0x00d0
        L_0x0070:
            java.lang.String r1 = "Expected ':'"
            java.io.IOException r1 = r0.zzcd(r1)
            throw r1
        L_0x0077:
            if (r3 != r11) goto L_0x00b7
            boolean r1 = r0.zzboj
            if (r1 == 0) goto L_0x00af
            r0.zzav(r6)
            int r1 = r0.pos
            int r1 = r1 - r6
            r0.pos = r1
            char[] r2 = com.google.android.gms.internal.firebase_ml.zzsi.zzboi
            int r13 = r2.length
            int r1 = r1 + r13
            int r13 = r0.limit
            if (r1 <= r13) goto L_0x0094
            int r1 = r2.length
            boolean r1 = r0.zzca(r1)
            if (r1 == 0) goto L_0x00af
        L_0x0094:
            r1 = r5
        L_0x0095:
            char[] r2 = com.google.android.gms.internal.firebase_ml.zzsi.zzboi
            int r13 = r2.length
            if (r1 >= r13) goto L_0x00a9
            char[] r13 = r0.zzbok
            int r11 = r0.pos
            int r11 = r11 + r1
            char r11 = r13[r11]
            char r2 = r2[r1]
            if (r11 != r2) goto L_0x00af
            int r1 = r1 + 1
            r11 = 6
            goto L_0x0095
        L_0x00a9:
            int r1 = r0.pos
            int r2 = r2.length
            int r1 = r1 + r2
            r0.pos = r1
        L_0x00af:
            int[] r1 = r0.zzbor
            int r2 = r0.zzbos
            int r2 = r2 - r6
            r1[r2] = r12
            goto L_0x00d0
        L_0x00b7:
            if (r3 != r12) goto L_0x00ce
            int r1 = r0.zzav(r5)
            r2 = -1
            if (r1 != r2) goto L_0x00c5
            r1 = 17
            r0.zzbon = r1
            return r1
        L_0x00c5:
            r19.zzqn()
            int r1 = r0.pos
            int r1 = r1 - r6
            r0.pos = r1
            goto L_0x00d0
        L_0x00ce:
            if (r3 == r4) goto L_0x02a8
        L_0x00d0:
            int r1 = r0.zzav(r6)
            r2 = 34
            if (r1 == r2) goto L_0x02a3
            r2 = 39
            if (r1 == r2) goto L_0x029d
            if (r1 == r9) goto L_0x0284
            if (r1 == r8) goto L_0x0284
            r2 = 91
            if (r1 == r2) goto L_0x0281
            if (r1 == r7) goto L_0x027a
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x0276
            int r1 = r0.pos
            int r1 = r1 - r6
            r0.pos = r1
            char[] r2 = r0.zzbok
            char r1 = r2[r1]
            r2 = 116(0x74, float:1.63E-43)
            if (r1 == r2) goto L_0x0119
            r2 = 84
            if (r1 != r2) goto L_0x00fc
            goto L_0x0119
        L_0x00fc:
            r2 = 102(0x66, float:1.43E-43)
            if (r1 == r2) goto L_0x0113
            r2 = 70
            if (r1 != r2) goto L_0x0105
            goto L_0x0113
        L_0x0105:
            r2 = 110(0x6e, float:1.54E-43)
            if (r1 == r2) goto L_0x010d
            r2 = 78
            if (r1 != r2) goto L_0x0168
        L_0x010d:
            java.lang.String r1 = "null"
            java.lang.String r2 = "NULL"
            r3 = r12
            goto L_0x011e
        L_0x0113:
            java.lang.String r1 = "false"
            java.lang.String r2 = "FALSE"
            r3 = 6
            goto L_0x011e
        L_0x0119:
            java.lang.String r1 = "true"
            java.lang.String r2 = "TRUE"
            r3 = r14
        L_0x011e:
            int r4 = r1.length()
            r7 = r6
        L_0x0123:
            if (r7 >= r4) goto L_0x014c
            int r8 = r0.pos
            int r8 = r8 + r7
            int r9 = r0.limit
            if (r8 < r9) goto L_0x0135
            int r8 = r7 + 1
            boolean r8 = r0.zzca(r8)
            if (r8 != 0) goto L_0x0135
            goto L_0x0168
        L_0x0135:
            char[] r8 = r0.zzbok
            int r9 = r0.pos
            int r9 = r9 + r7
            char r8 = r8[r9]
            char r9 = r1.charAt(r7)
            if (r8 == r9) goto L_0x0149
            char r9 = r2.charAt(r7)
            if (r8 == r9) goto L_0x0149
            goto L_0x0168
        L_0x0149:
            int r7 = r7 + 1
            goto L_0x0123
        L_0x014c:
            int r1 = r0.pos
            int r1 = r1 + r4
            int r2 = r0.limit
            if (r1 < r2) goto L_0x015b
            int r1 = r4 + 1
            boolean r1 = r0.zzca(r1)
            if (r1 == 0) goto L_0x016a
        L_0x015b:
            char[] r1 = r0.zzbok
            int r2 = r0.pos
            int r2 = r2 + r4
            char r1 = r1[r2]
            boolean r1 = r0.zze(r1)
            if (r1 == 0) goto L_0x016a
        L_0x0168:
            r3 = r5
            goto L_0x0171
        L_0x016a:
            int r1 = r0.pos
            int r1 = r1 + r4
            r0.pos = r1
            r0.zzbon = r3
        L_0x0171:
            if (r3 == 0) goto L_0x0174
            return r3
        L_0x0174:
            char[] r1 = r0.zzbok
            int r2 = r0.pos
            int r3 = r0.limit
            r7 = 0
            r4 = r5
            r9 = r4
            r16 = r9
            r11 = r6
            r12 = r7
        L_0x0182:
            int r5 = r2 + r9
            if (r5 != r3) goto L_0x0195
            int r2 = r1.length
            if (r9 == r2) goto L_0x022b
            int r2 = r9 + 1
            boolean r2 = r0.zzca(r2)
            if (r2 == 0) goto L_0x01fe
            int r2 = r0.pos
            int r3 = r0.limit
        L_0x0195:
            int r5 = r2 + r9
            char r5 = r1[r5]
            r14 = 43
            if (r5 == r14) goto L_0x024e
            r14 = 69
            if (r5 == r14) goto L_0x0245
            r14 = 101(0x65, float:1.42E-43)
            if (r5 == r14) goto L_0x0245
            r14 = 45
            if (r5 == r14) goto L_0x0239
            r14 = 46
            if (r5 == r14) goto L_0x0234
            r14 = 48
            if (r5 < r14) goto L_0x01f7
            r14 = 57
            if (r5 <= r14) goto L_0x01b6
            goto L_0x01f7
        L_0x01b6:
            if (r4 == r6) goto L_0x01ed
            if (r4 != 0) goto L_0x01bb
            goto L_0x01ed
        L_0x01bb:
            if (r4 != r15) goto L_0x01e1
            int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r14 == 0) goto L_0x022b
            r17 = 10
            long r17 = r17 * r12
            int r5 = r5 + -48
            long r6 = (long) r5
            long r17 = r17 - r6
            r5 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x01dc
            if (r5 != 0) goto L_0x01da
            int r5 = (r17 > r12 ? 1 : (r17 == r12 ? 0 : -1))
            if (r5 >= 0) goto L_0x01da
            goto L_0x01dc
        L_0x01da:
            r5 = 0
            goto L_0x01dd
        L_0x01dc:
            r5 = 1
        L_0x01dd:
            r11 = r11 & r5
            r12 = r17
            goto L_0x01f3
        L_0x01e1:
            if (r4 != r10) goto L_0x01e5
            r4 = 4
            goto L_0x01f3
        L_0x01e5:
            r5 = 5
            r6 = 6
            if (r4 == r5) goto L_0x01eb
            if (r4 != r6) goto L_0x01f3
        L_0x01eb:
            r4 = 7
            goto L_0x01f3
        L_0x01ed:
            r6 = 6
            int r5 = r5 + -48
            int r4 = -r5
            long r12 = (long) r4
            r4 = r15
        L_0x01f3:
            r7 = 0
            goto L_0x0252
        L_0x01f7:
            boolean r1 = r0.zze(r5)
            if (r1 == 0) goto L_0x01fe
            goto L_0x022b
        L_0x01fe:
            if (r4 != r15) goto L_0x0222
            if (r11 == 0) goto L_0x0222
            r1 = -9223372036854775808
            int r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x020a
            if (r16 == 0) goto L_0x0222
        L_0x020a:
            r7 = 0
            int r1 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x0212
            if (r16 != 0) goto L_0x0222
        L_0x0212:
            if (r16 == 0) goto L_0x0215
            goto L_0x0216
        L_0x0215:
            long r12 = -r12
        L_0x0216:
            r0.zzboo = r12
            int r1 = r0.pos
            int r1 = r1 + r9
            r0.pos = r1
            r5 = 15
            r0.zzbon = r5
            goto L_0x0258
        L_0x0222:
            if (r4 == r15) goto L_0x022d
            r1 = 4
            if (r4 == r1) goto L_0x022d
            r1 = 7
            if (r4 != r1) goto L_0x022b
            goto L_0x022d
        L_0x022b:
            r5 = 0
            goto L_0x0258
        L_0x022d:
            r0.zzbop = r9
            r5 = 16
            r0.zzbon = r5
            goto L_0x0258
        L_0x0234:
            r6 = 6
            if (r4 != r15) goto L_0x022b
            r4 = r10
            goto L_0x0252
        L_0x0239:
            r6 = 6
            if (r4 != 0) goto L_0x0240
            r4 = 1
            r16 = 1
            goto L_0x0252
        L_0x0240:
            r5 = 5
            if (r4 != r5) goto L_0x022b
            r4 = r6
            goto L_0x0252
        L_0x0245:
            r5 = 5
            r6 = 6
            if (r4 == r15) goto L_0x024c
            r6 = 4
            if (r4 != r6) goto L_0x022b
        L_0x024c:
            r4 = r5
            goto L_0x0252
        L_0x024e:
            r5 = 5
            if (r4 != r5) goto L_0x022b
            r4 = 6
        L_0x0252:
            int r9 = r9 + 1
            r6 = 1
            r14 = 5
            goto L_0x0182
        L_0x0258:
            if (r5 == 0) goto L_0x025b
            return r5
        L_0x025b:
            char[] r1 = r0.zzbok
            int r2 = r0.pos
            char r1 = r1[r2]
            boolean r1 = r0.zze(r1)
            if (r1 == 0) goto L_0x026f
            r19.zzqn()
            r1 = 10
            r0.zzbon = r1
            return r1
        L_0x026f:
            java.lang.String r1 = "Expected value"
            java.io.IOException r1 = r0.zzcd(r1)
            throw r1
        L_0x0276:
            r1 = r6
            r0.zzbon = r1
            return r1
        L_0x027a:
            r1 = r6
            if (r3 != r1) goto L_0x0285
            r2 = 4
            r0.zzbon = r2
            return r2
        L_0x0281:
            r0.zzbon = r10
            return r10
        L_0x0284:
            r1 = r6
        L_0x0285:
            if (r3 == r1) goto L_0x0291
            if (r3 != r15) goto L_0x028a
            goto L_0x0291
        L_0x028a:
            java.lang.String r1 = "Unexpected value"
            java.io.IOException r1 = r0.zzcd(r1)
            throw r1
        L_0x0291:
            r19.zzqn()
            int r2 = r0.pos
            int r2 = r2 - r1
            r0.pos = r2
            r1 = 7
            r0.zzbon = r1
            return r1
        L_0x029d:
            r19.zzqn()
            r0.zzbon = r4
            return r4
        L_0x02a3:
            r1 = 9
            r0.zzbon = r1
            return r1
        L_0x02a8:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "JsonReader is closed"
            r1.<init>(r2)
            throw r1
        L_0x02b0:
            int[] r1 = r0.zzbor
            int r2 = r0.zzbos
            r4 = 1
            int r2 = r2 - r4
            r5 = 4
            r1[r2] = r5
            r1 = 125(0x7d, float:1.75E-43)
            r2 = 5
            if (r3 != r2) goto L_0x02d7
            int r2 = r0.zzav(r4)
            if (r2 == r9) goto L_0x02d5
            if (r2 == r8) goto L_0x02d2
            if (r2 != r1) goto L_0x02cb
            r0.zzbon = r15
            return r15
        L_0x02cb:
            java.lang.String r1 = "Unterminated object"
            java.io.IOException r1 = r0.zzcd(r1)
            throw r1
        L_0x02d2:
            r19.zzqn()
        L_0x02d5:
            r2 = 1
            goto L_0x02d8
        L_0x02d7:
            r2 = r4
        L_0x02d8:
            int r4 = r0.zzav(r2)
            r5 = 34
            if (r4 == r5) goto L_0x0314
            r5 = 39
            if (r4 == r5) goto L_0x030c
            java.lang.String r5 = "Expected name"
            if (r4 == r1) goto L_0x0301
            r19.zzqn()
            int r1 = r0.pos
            int r1 = r1 - r2
            r0.pos = r1
            char r1 = (char) r4
            boolean r1 = r0.zze(r1)
            if (r1 == 0) goto L_0x02fc
            r1 = 14
            r0.zzbon = r1
            return r1
        L_0x02fc:
            java.io.IOException r1 = r0.zzcd(r5)
            throw r1
        L_0x0301:
            r1 = 5
            if (r3 == r1) goto L_0x0307
            r0.zzbon = r15
            return r15
        L_0x0307:
            java.io.IOException r1 = r0.zzcd(r5)
            throw r1
        L_0x030c:
            r19.zzqn()
            r1 = 12
            r0.zzbon = r1
            return r1
        L_0x0314:
            r1 = 13
            r0.zzbon = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzsi.zzql():int");
    }

    private final boolean zze(char c) throws IOException {
        if (c == 9 || c == 10 || c == 12 || c == 13 || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (!(c == '/' || c == '=')) {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        zzqn();
        return false;
    }

    public final String nextName() throws IOException {
        String str;
        int i = this.zzbon;
        if (i == 0) {
            i = zzql();
        }
        if (i == 14) {
            str = zzqm();
        } else if (i == 12) {
            str = zzf('\'');
        } else if (i == 13) {
            str = zzf(Typography.quote);
        } else {
            throw new IllegalStateException("Expected a name but was " + zzqk() + zzqp());
        }
        this.zzbon = 0;
        this.zzbot[this.zzbos - 1] = str;
        return str;
    }

    public final String nextString() throws IOException {
        int i = this.zzbon;
        if (i == 0) {
            i = zzql();
        }
        String str = null;
        if (i == 10) {
            str = zzqm();
        } else if (i == 8) {
            str = zzf('\'');
        } else if (i == 9) {
            str = zzf(Typography.quote);
        } else if (i == 11) {
            this.zzboq = null;
        } else if (i == 15) {
            str = Long.toString(this.zzboo);
        } else if (i == 16) {
            str = new String(this.zzbok, this.pos, this.zzbop);
            this.pos += this.zzbop;
        } else {
            throw new IllegalStateException("Expected a string but was " + zzqk() + zzqp());
        }
        this.zzbon = 0;
        int[] iArr = this.zzbou;
        int i2 = this.zzbos - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final boolean nextBoolean() throws IOException {
        int i = this.zzbon;
        if (i == 0) {
            i = zzql();
        }
        if (i == 5) {
            this.zzbon = 0;
            int[] iArr = this.zzbou;
            int i2 = this.zzbos - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.zzbon = 0;
            int[] iArr2 = this.zzbou;
            int i3 = this.zzbos - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + zzqk() + zzqp());
        }
    }

    public final void nextNull() throws IOException {
        int i = this.zzbon;
        if (i == 0) {
            i = zzql();
        }
        if (i == 7) {
            this.zzbon = 0;
            int[] iArr = this.zzbou;
            int i2 = this.zzbos - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + zzqk() + zzqp());
    }

    private final String zzf(char c) throws IOException {
        char[] cArr = this.zzbok;
        StringBuilder sb = null;
        while (true) {
            int i = this.pos;
            int i2 = this.limit;
            int i3 = i;
            while (true) {
                if (i3 < i2) {
                    int i4 = i3 + 1;
                    char c2 = cArr[i3];
                    if (c2 == c) {
                        this.pos = i4;
                        int i5 = (i4 - i) - 1;
                        if (sb == null) {
                            return new String(cArr, i, i5);
                        }
                        sb.append(cArr, i, i5);
                        return sb.toString();
                    } else if (c2 == '\\') {
                        this.pos = i4;
                        int i6 = (i4 - i) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i6 + 1) << 1, 16));
                        }
                        sb.append(cArr, i, i6);
                        sb.append(zzqq());
                    } else {
                        if (c2 == 10) {
                            this.zzbol++;
                            this.zzbom = i4;
                        }
                        i3 = i4;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i3 - i) << 1, 16));
                    }
                    sb.append(cArr, i, i3 - i);
                    this.pos = i3;
                    if (!zzca(1)) {
                        throw zzcd("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        zzqn();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzqm() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = r0
        L_0x0003:
            int r3 = r6.pos
            int r4 = r3 + r2
            int r5 = r6.limit
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.zzbok
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.zzqn()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.zzbok
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.zzca(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r0 = r2
            goto L_0x007e
        L_0x005e:
            if (r1 != 0) goto L_0x006b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L_0x006b:
            char[] r3 = r6.zzbok
            int r4 = r6.pos
            r1.append(r3, r4, r2)
            int r3 = r6.pos
            int r3 = r3 + r2
            r6.pos = r3
            r2 = 1
            boolean r2 = r6.zzca(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r1 != 0) goto L_0x008a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.zzbok
            int r3 = r6.pos
            r1.<init>(r2, r3, r0)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.zzbok
            int r3 = r6.pos
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L_0x0095:
            int r2 = r6.pos
            int r2 = r2 + r0
            r6.pos = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzsi.zzqm():java.lang.String");
    }

    private final void zzg(char c) throws IOException {
        char[] cArr = this.zzbok;
        while (true) {
            int i = this.pos;
            int i2 = this.limit;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.pos = i3;
                        return;
                    } else if (c2 == '\\') {
                        this.pos = i3;
                        zzqq();
                        break;
                    } else {
                        if (c2 == 10) {
                            this.zzbol++;
                            this.zzbom = i3;
                        }
                        i = i3;
                    }
                } else {
                    this.pos = i;
                    if (!zzca(1)) {
                        throw zzcd("Unterminated string");
                    }
                }
            }
        }
    }

    public final void close() throws IOException {
        this.zzbon = 0;
        this.zzbor[0] = 8;
        this.zzbos = 1;
        this.in.close();
    }

    public final void skipValue() throws IOException {
        int i;
        int i2 = 0;
        do {
            int i3 = this.zzbon;
            if (i3 == 0) {
                i3 = zzql();
            }
            if (i3 == 3) {
                zzbz(1);
            } else if (i3 == 1) {
                zzbz(3);
            } else {
                if (i3 == 4) {
                    this.zzbos--;
                } else if (i3 == 2) {
                    this.zzbos--;
                } else if (i3 == 14 || i3 == 10) {
                    while (true) {
                        i = 0;
                        while (true) {
                            int i4 = this.pos;
                            if (i4 + i < this.limit) {
                                char c = this.zzbok[i4 + i];
                                if (!(c == 9 || c == 10 || c == 12 || c == 13 || c == ' ')) {
                                    if (c != '#') {
                                        if (c != ',') {
                                            if (!(c == '/' || c == '=')) {
                                                if (!(c == '{' || c == '}' || c == ':')) {
                                                    if (c != ';') {
                                                        switch (c) {
                                                            case '[':
                                                            case ']':
                                                                break;
                                                            case '\\':
                                                                break;
                                                            default:
                                                                i++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                this.pos = i4 + i;
                                if (!zzca(1)) {
                                }
                            }
                        }
                    }
                    zzqn();
                    this.pos += i;
                    this.zzbon = 0;
                } else if (i3 == 8 || i3 == 12) {
                    zzg('\'');
                    this.zzbon = 0;
                } else if (i3 == 9 || i3 == 13) {
                    zzg(Typography.quote);
                    this.zzbon = 0;
                } else {
                    if (i3 == 16) {
                        this.pos += this.zzbop;
                    }
                    this.zzbon = 0;
                }
                i2--;
                this.zzbon = 0;
            }
            i2++;
            this.zzbon = 0;
        } while (i2 != 0);
        int[] iArr = this.zzbou;
        int i5 = this.zzbos;
        int i6 = i5 - 1;
        iArr[i6] = iArr[i6] + 1;
        this.zzbot[i5 - 1] = "null";
    }

    private final void zzbz(int i) {
        int i2 = this.zzbos;
        int[] iArr = this.zzbor;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(i2 << 1)];
            int[] iArr3 = new int[(i2 << 1)];
            String[] strArr = new String[(i2 << 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.zzbou, 0, iArr3, 0, this.zzbos);
            System.arraycopy(this.zzbot, 0, strArr, 0, this.zzbos);
            this.zzbor = iArr2;
            this.zzbou = iArr3;
            this.zzbot = strArr;
        }
        int[] iArr4 = this.zzbor;
        int i3 = this.zzbos;
        this.zzbos = i3 + 1;
        iArr4[i3] = i;
    }

    private final boolean zzca(int i) throws IOException {
        int i2;
        char[] cArr = this.zzbok;
        int i3 = this.zzbom;
        int i4 = this.pos;
        this.zzbom = i3 - i4;
        int i5 = this.limit;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.limit = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i7 = this.limit;
            int read = reader.read(cArr, i7, cArr.length - i7);
            if (read == -1) {
                return false;
            }
            int i8 = this.limit + read;
            this.limit = i8;
            if (this.zzbol == 0 && (i2 = this.zzbom) == 0 && i8 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.zzbom = i2 + 1;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private final int zzav(boolean z) throws IOException {
        char[] cArr = this.zzbok;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            boolean z2 = true;
            if (i == i2) {
                this.pos = i;
                if (zzca(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + zzqp());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == 10) {
                this.zzbol++;
                this.zzbom = i3;
            } else if (!(c == ' ' || c == 13 || c == 9)) {
                if (c == '/') {
                    this.pos = i3;
                    if (i3 == i2) {
                        this.pos = i3 - 1;
                        boolean zzca = zzca(2);
                        this.pos++;
                        if (!zzca) {
                            return c;
                        }
                    }
                    zzqn();
                    int i4 = this.pos;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.pos = i4 + 1;
                        while (true) {
                            int i5 = 0;
                            if (this.pos + 2 > this.limit && !zzca(2)) {
                                z2 = false;
                                break;
                            }
                            char[] cArr2 = this.zzbok;
                            int i6 = this.pos;
                            if (cArr2[i6] != 10) {
                                while (i5 < 2) {
                                    if (this.zzbok[this.pos + i5] == "*/".charAt(i5)) {
                                        i5++;
                                    }
                                }
                                break;
                            }
                            this.zzbol++;
                            this.zzbom = i6 + 1;
                            this.pos++;
                        }
                        if (z2) {
                            i = this.pos + 2;
                            i2 = this.limit;
                        } else {
                            throw zzcd("Unterminated comment");
                        }
                    } else if (c2 != '/') {
                        return c;
                    } else {
                        this.pos = i4 + 1;
                        zzqo();
                        i = this.pos;
                        i2 = this.limit;
                    }
                } else if (c == '#') {
                    this.pos = i3;
                    zzqn();
                    zzqo();
                    i = this.pos;
                    i2 = this.limit;
                } else {
                    this.pos = i3;
                    return c;
                }
            }
            i = i3;
        }
    }

    private final void zzqn() throws IOException {
        if (!this.zzboj) {
            throw zzcd("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private final void zzqo() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || zzca(1)) {
                char[] cArr = this.zzbok;
                int i = this.pos;
                int i2 = i + 1;
                this.pos = i2;
                c = cArr[i];
                if (c == 10) {
                    this.zzbol++;
                    this.zzbom = i2;
                    return;
                }
            } else {
                return;
            }
        } while (c != 13);
    }

    public final String toString() {
        return getClass().getSimpleName() + zzqp();
    }

    private final String zzqp() {
        StringBuilder sb = new StringBuilder(" at line ");
        sb.append(this.zzbol + 1);
        sb.append(" column ");
        sb.append((this.pos - this.zzbom) + 1);
        sb.append(" path ");
        StringBuilder sb2 = new StringBuilder("$");
        int i = this.zzbos;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.zzbor[i2];
            if (i3 == 1 || i3 == 2) {
                sb2.append('[');
                sb2.append(this.zzbou[i2]);
                sb2.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb2.append('.');
                String[] strArr = this.zzbot;
                if (strArr[i2] != null) {
                    sb2.append(strArr[i2]);
                }
            }
        }
        sb.append(sb2.toString());
        return sb.toString();
    }

    private final char zzqq() throws IOException {
        int i;
        int i2;
        if (this.pos != this.limit || zzca(1)) {
            char[] cArr = this.zzbok;
            int i3 = this.pos;
            int i4 = i3 + 1;
            this.pos = i4;
            char c = cArr[i3];
            if (c == 10) {
                this.zzbol++;
                this.zzbom = i4;
            } else if (!(c == '\"' || c == '\'' || c == '/' || c == '\\')) {
                if (c == 'b') {
                    return 8;
                }
                if (c == 'f') {
                    return 12;
                }
                if (c == 'n') {
                    return 10;
                }
                if (c == 'r') {
                    return 13;
                }
                if (c == 't') {
                    return 9;
                }
                if (c != 'u') {
                    throw zzcd("Invalid escape sequence");
                } else if (i4 + 4 <= this.limit || zzca(4)) {
                    char c2 = 0;
                    int i5 = this.pos;
                    int i6 = i5 + 4;
                    while (i5 < i6) {
                        char c3 = this.zzbok[i5];
                        char c4 = (char) (c2 << 4);
                        if (c3 < '0' || c3 > '9') {
                            if (c3 >= 'a' && c3 <= 'f') {
                                i = c3 - 'a';
                            } else if (c3 < 'A' || c3 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.zzbok, this.pos, 4));
                            } else {
                                i = c3 - 'A';
                            }
                            i2 = i + 10;
                        } else {
                            i2 = c3 - '0';
                        }
                        c2 = (char) (c4 + i2);
                        i5++;
                    }
                    this.pos += 4;
                    return c2;
                } else {
                    throw zzcd("Unterminated escape sequence");
                }
            }
            return c;
        }
        throw zzcd("Unterminated escape sequence");
    }

    private final IOException zzcd(String str) throws IOException {
        throw new zzsm(str + zzqp());
    }

    static {
        zzsf.zzboh = new zzsh();
    }
}
