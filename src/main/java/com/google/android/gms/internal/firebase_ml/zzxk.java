package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzvx;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
final class zzxk<T> implements zzya<T> {
    private static final int[] zzcfr = new int[0];
    private static final Unsafe zzcfs = zzyy.zzwh();
    private final int[] zzcft;
    private final Object[] zzcfu;
    private final int zzcfv;
    private final int zzcfw;
    private final zzxg zzcfx;
    private final boolean zzcfy;
    private final boolean zzcfz;
    private final boolean zzcga;
    private final boolean zzcgb;
    private final int[] zzcgc;
    private final int zzcgd;
    private final int zzcge;
    private final zzxo zzcgf;
    private final zzwq zzcgg;
    private final zzys<?, ?> zzcgh;
    private final zzvm<?> zzcgi;
    private final zzxd zzcgj;

    private zzxk(int[] iArr, Object[] objArr, int i, int i2, zzxg zzxg, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzxo zzxo, zzwq zzwq, zzys<?, ?> zzys, zzvm<?> zzvm, zzxd zzxd) {
        this.zzcft = iArr;
        this.zzcfu = objArr;
        this.zzcfv = i;
        this.zzcfw = i2;
        this.zzcfz = zzxg instanceof zzvx;
        this.zzcga = z;
        this.zzcfy = zzvm != null && zzvm.zze(zzxg);
        this.zzcgb = false;
        this.zzcgc = iArr2;
        this.zzcgd = i3;
        this.zzcge = i4;
        this.zzcgf = zzxo;
        this.zzcgg = zzwq;
        this.zzcgh = zzys;
        this.zzcgi = zzvm;
        this.zzcfx = zzxg;
        this.zzcgj = zzxd;
    }

    static <T> zzxk<T> zza(Class<T> cls, zzxe zzxe, zzxo zzxo, zzwq zzwq, zzys<?, ?> zzys, zzvm<?> zzvm, zzxd zzxd) {
        int i;
        char c;
        int[] iArr;
        char c2;
        int i2;
        char c3;
        char c4;
        char c5;
        char c6;
        int i3;
        boolean z;
        int i4;
        zzxx zzxx;
        int i5;
        Class<?> cls2;
        int i6;
        String str;
        int i7;
        int i8;
        char c7;
        char c8;
        Field field;
        int i9;
        char charAt;
        int i10;
        Field field2;
        Field field3;
        int i11;
        char charAt2;
        int i12;
        char charAt3;
        int i13;
        char charAt4;
        int i14;
        int i15;
        char charAt5;
        int i16;
        char charAt6;
        int i17;
        char charAt7;
        int i18;
        char charAt8;
        int i19;
        char charAt9;
        int i20;
        char charAt10;
        int i21;
        char charAt11;
        int i22;
        char charAt12;
        int i23;
        char charAt13;
        char charAt14;
        zzxe zzxe2 = zzxe;
        if (zzxe2 instanceof zzxx) {
            zzxx zzxx2 = (zzxx) zzxe2;
            char c9 = 0;
            boolean z2 = zzxx2.zzva() == zzvx.zzf.zzcdt;
            String zzvl = zzxx2.zzvl();
            int length = zzvl.length();
            char charAt15 = zzvl.charAt(0);
            if (charAt15 >= 55296) {
                char c10 = charAt15 & 8191;
                int i24 = 1;
                int i25 = 13;
                while (true) {
                    i = i24 + 1;
                    charAt14 = zzvl.charAt(i24);
                    if (charAt14 < 55296) {
                        break;
                    }
                    c10 |= (charAt14 & 8191) << i25;
                    i25 += 13;
                    i24 = i;
                }
                charAt15 = c10 | (charAt14 << i25);
            } else {
                i = 1;
            }
            int i26 = i + 1;
            char charAt16 = zzvl.charAt(i);
            if (charAt16 >= 55296) {
                char c11 = charAt16 & 8191;
                int i27 = 13;
                while (true) {
                    i23 = i26 + 1;
                    charAt13 = zzvl.charAt(i26);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c11 |= (charAt13 & 8191) << i27;
                    i27 += 13;
                    i26 = i23;
                }
                charAt16 = c11 | (charAt13 << i27);
                i26 = i23;
            }
            if (charAt16 == 0) {
                c5 = 0;
                c3 = 0;
                i2 = 0;
                c2 = 0;
                c = 0;
                iArr = zzcfr;
                c4 = 0;
            } else {
                int i28 = i26 + 1;
                char charAt17 = zzvl.charAt(i26);
                if (charAt17 >= 55296) {
                    char c12 = charAt17 & 8191;
                    int i29 = 13;
                    while (true) {
                        i22 = i28 + 1;
                        charAt12 = zzvl.charAt(i28);
                        if (charAt12 < 55296) {
                            break;
                        }
                        c12 |= (charAt12 & 8191) << i29;
                        i29 += 13;
                        i28 = i22;
                    }
                    charAt17 = c12 | (charAt12 << i29);
                    i28 = i22;
                }
                int i30 = i28 + 1;
                char charAt18 = zzvl.charAt(i28);
                if (charAt18 >= 55296) {
                    char c13 = charAt18 & 8191;
                    int i31 = 13;
                    while (true) {
                        i21 = i30 + 1;
                        charAt11 = zzvl.charAt(i30);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c13 |= (charAt11 & 8191) << i31;
                        i31 += 13;
                        i30 = i21;
                    }
                    charAt18 = c13 | (charAt11 << i31);
                    i30 = i21;
                }
                int i32 = i30 + 1;
                c3 = zzvl.charAt(i30);
                if (c3 >= 55296) {
                    char c14 = c3 & 8191;
                    int i33 = 13;
                    while (true) {
                        i20 = i32 + 1;
                        charAt10 = zzvl.charAt(i32);
                        if (charAt10 < 55296) {
                            break;
                        }
                        c14 |= (charAt10 & 8191) << i33;
                        i33 += 13;
                        i32 = i20;
                    }
                    c3 = c14 | (charAt10 << i33);
                    i32 = i20;
                }
                int i34 = i32 + 1;
                char charAt19 = zzvl.charAt(i32);
                if (charAt19 >= 55296) {
                    char c15 = charAt19 & 8191;
                    int i35 = 13;
                    while (true) {
                        i19 = i34 + 1;
                        charAt9 = zzvl.charAt(i34);
                        if (charAt9 < 55296) {
                            break;
                        }
                        c15 |= (charAt9 & 8191) << i35;
                        i35 += 13;
                        i34 = i19;
                    }
                    charAt19 = c15 | (charAt9 << i35);
                    i34 = i19;
                }
                int i36 = i34 + 1;
                c2 = zzvl.charAt(i34);
                if (c2 >= 55296) {
                    char c16 = c2 & 8191;
                    int i37 = 13;
                    while (true) {
                        i18 = i36 + 1;
                        charAt8 = zzvl.charAt(i36);
                        if (charAt8 < 55296) {
                            break;
                        }
                        c16 |= (charAt8 & 8191) << i37;
                        i37 += 13;
                        i36 = i18;
                    }
                    c2 = c16 | (charAt8 << i37);
                    i36 = i18;
                }
                int i38 = i36 + 1;
                char charAt20 = zzvl.charAt(i36);
                if (charAt20 >= 55296) {
                    char c17 = charAt20 & 8191;
                    int i39 = 13;
                    while (true) {
                        i17 = i38 + 1;
                        charAt7 = zzvl.charAt(i38);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c17 |= (charAt7 & 8191) << i39;
                        i39 += 13;
                        i38 = i17;
                    }
                    charAt20 = c17 | (charAt7 << i39);
                    i38 = i17;
                }
                int i40 = i38 + 1;
                char charAt21 = zzvl.charAt(i38);
                if (charAt21 >= 55296) {
                    char c18 = charAt21 & 8191;
                    int i41 = i40;
                    int i42 = 13;
                    while (true) {
                        i16 = i41 + 1;
                        charAt6 = zzvl.charAt(i41);
                        if (charAt6 < 55296) {
                            break;
                        }
                        c18 |= (charAt6 & 8191) << i42;
                        i42 += 13;
                        i41 = i16;
                    }
                    charAt21 = c18 | (charAt6 << i42);
                    i14 = i16;
                } else {
                    i14 = i40;
                }
                int i43 = i14 + 1;
                char charAt22 = zzvl.charAt(i14);
                if (charAt22 >= 55296) {
                    char c19 = charAt22 & 8191;
                    int i44 = i43;
                    int i45 = 13;
                    while (true) {
                        i15 = i44 + 1;
                        charAt5 = zzvl.charAt(i44);
                        if (charAt5 < 55296) {
                            break;
                        }
                        c19 |= (charAt5 & 8191) << i45;
                        i45 += 13;
                        i44 = i15;
                    }
                    charAt22 = c19 | (charAt5 << i45);
                    i43 = i15;
                }
                int i46 = (charAt17 << 1) + charAt18;
                c4 = charAt19;
                i2 = i46;
                c = charAt22;
                c9 = charAt17;
                i26 = i43;
                char c20 = charAt20;
                iArr = new int[(charAt22 + charAt20 + charAt21)];
                c5 = c20;
            }
            Unsafe unsafe = zzcfs;
            Object[] zzvm2 = zzxx2.zzvm();
            Class<?> cls3 = zzxx2.zzvc().getClass();
            int i47 = i26;
            int[] iArr2 = new int[(c2 * 3)];
            Object[] objArr = new Object[(c2 << 1)];
            int i48 = c + c5;
            char c21 = c;
            int i49 = i47;
            int i50 = i48;
            int i51 = 0;
            int i52 = 0;
            while (i49 < length) {
                int i53 = i49 + 1;
                int charAt23 = zzvl.charAt(i49);
                int i54 = length;
                if (charAt23 >= 55296) {
                    int i55 = charAt23 & 8191;
                    int i56 = i53;
                    int i57 = 13;
                    while (true) {
                        i13 = i56 + 1;
                        charAt4 = zzvl.charAt(i56);
                        c6 = c;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i55 |= (charAt4 & 8191) << i57;
                        i57 += 13;
                        i56 = i13;
                        c = c6;
                    }
                    charAt23 = i55 | (charAt4 << i57);
                    i3 = i13;
                } else {
                    c6 = c;
                    i3 = i53;
                }
                int i58 = i3 + 1;
                char charAt24 = zzvl.charAt(i3);
                int i59 = i58;
                if (charAt24 >= 55296) {
                    char c22 = charAt24 & 8191;
                    int i60 = i59;
                    int i61 = 13;
                    while (true) {
                        i12 = i60 + 1;
                        charAt3 = zzvl.charAt(i60);
                        z = z2;
                        if (charAt3 < 55296) {
                            break;
                        }
                        c22 |= (charAt3 & 8191) << i61;
                        i61 += 13;
                        i60 = i12;
                        z2 = z;
                    }
                    charAt24 = c22 | (charAt3 << i61);
                    i4 = i12;
                } else {
                    z = z2;
                    i4 = i59;
                }
                char c23 = charAt24 & 255;
                char c24 = c4;
                if ((charAt24 & 1024) != 0) {
                    iArr[i51] = i52;
                    i51++;
                }
                char c25 = c3;
                if (c23 >= '3') {
                    int i62 = i4 + 1;
                    char charAt25 = zzvl.charAt(i4);
                    char c26 = 55296;
                    if (charAt25 >= 55296) {
                        char c27 = charAt25 & 8191;
                        int i63 = 13;
                        while (true) {
                            i11 = i62 + 1;
                            charAt2 = zzvl.charAt(i62);
                            if (charAt2 < c26) {
                                break;
                            }
                            c27 |= (charAt2 & 8191) << i63;
                            i63 += 13;
                            i62 = i11;
                            c26 = 55296;
                        }
                        charAt25 = c27 | (charAt2 << i63);
                        i62 = i11;
                    }
                    int i64 = c23 - '3';
                    int i65 = i62;
                    if (i64 == 9 || i64 == 17) {
                        objArr[((i52 / 3) << 1) + 1] = zzvm2[i2];
                        i2++;
                    } else if (i64 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i52 / 3) << 1) + 1] = zzvm2[i2];
                        i2++;
                    }
                    int i66 = charAt25 << 1;
                    Object obj = zzvm2[i66];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zzvm2[i66] = field2;
                    }
                    zzxx = zzxx2;
                    String str2 = zzvl;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i67 = i66 + 1;
                    Object obj2 = zzvm2[i67];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zzvm2[i67] = field3;
                    }
                    cls2 = cls3;
                    i5 = i2;
                    i4 = i65;
                    str = str2;
                    i6 = 0;
                    i7 = (int) unsafe.objectFieldOffset(field3);
                    i8 = objectFieldOffset;
                    c7 = c9;
                } else {
                    zzxx = zzxx2;
                    String str3 = zzvl;
                    int i68 = i2 + 1;
                    Field zza = zza(cls3, (String) zzvm2[i2]);
                    if (c23 == 9 || c23 == 17) {
                        c8 = 1;
                        objArr[((i52 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c23 == 27 || c23 == '1') {
                            c8 = 1;
                            i10 = i68 + 1;
                            objArr[((i52 / 3) << 1) + 1] = zzvm2[i68];
                        } else if (c23 == 12 || c23 == 30 || c23 == ',') {
                            c8 = 1;
                            if ((charAt15 & 1) == 1) {
                                i10 = i68 + 1;
                                objArr[((i52 / 3) << 1) + 1] = zzvm2[i68];
                            }
                        } else {
                            if (c23 == '2') {
                                int i69 = c21 + 1;
                                iArr[c21] = i52;
                                int i70 = (i52 / 3) << 1;
                                int i71 = i68 + 1;
                                objArr[i70] = zzvm2[i68];
                                if ((charAt24 & 2048) != 0) {
                                    i68 = i71 + 1;
                                    objArr[i70 + 1] = zzvm2[i71];
                                    c21 = i69;
                                } else {
                                    i68 = i71;
                                    c8 = 1;
                                    c21 = i69;
                                }
                            }
                            c8 = 1;
                        }
                        i68 = i10;
                    }
                    i8 = (int) unsafe.objectFieldOffset(zza);
                    if ((charAt15 & 1) != c8) {
                        i5 = i68;
                        c7 = c9;
                        cls2 = cls3;
                        str = str3;
                    } else if (c23 <= 17) {
                        int i72 = i4 + 1;
                        str = str3;
                        char charAt26 = str.charAt(i4);
                        if (charAt26 >= 55296) {
                            char c28 = charAt26 & 8191;
                            int i73 = 13;
                            while (true) {
                                i9 = i72 + 1;
                                charAt = str.charAt(i72);
                                if (charAt < 55296) {
                                    break;
                                }
                                c28 |= (charAt & 8191) << i73;
                                i73 += 13;
                                i72 = i9;
                            }
                            charAt26 = c28 | (charAt << i73);
                            i72 = i9;
                        }
                        int i74 = (c9 << 1) + (charAt26 / ' ');
                        Object obj3 = zzvm2[i74];
                        i5 = i68;
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = zza(cls3, (String) obj3);
                            zzvm2[i74] = field;
                        }
                        c7 = c9;
                        cls2 = cls3;
                        i6 = charAt26 % ' ';
                        i7 = (int) unsafe.objectFieldOffset(field);
                        i4 = i72;
                        if (c23 >= 18 && c23 <= '1') {
                            iArr[i50] = i8;
                            i50++;
                        }
                    } else {
                        i5 = i68;
                        c7 = c9;
                        cls2 = cls3;
                        str = str3;
                    }
                    i7 = 0;
                    i6 = 0;
                    iArr[i50] = i8;
                    i50++;
                }
                int i75 = i52 + 1;
                iArr2[i52] = charAt23;
                int i76 = i75 + 1;
                iArr2[i75] = i8 | ((charAt24 & 256) != 0 ? 268435456 : 0) | ((charAt24 & 512) != 0 ? 536870912 : 0) | (c23 << 20);
                i52 = i76 + 1;
                iArr2[i76] = (i6 << 20) | i7;
                c9 = c7;
                zzvl = str;
                i49 = i4;
                cls3 = cls2;
                c4 = c24;
                length = i54;
                c = c6;
                z2 = z;
                c3 = c25;
                i2 = i5;
                zzxx2 = zzxx;
            }
            return new zzxk(iArr2, objArr, c3, c4, zzxx2.zzvc(), z2, false, iArr, c, i48, zzxo, zzwq, zzys, zzvm, zzxd);
        }
        int zzva = ((zzyp) zzxe2).zzva();
        int i77 = zzvx.zzf.zzcdt;
        throw new NoSuchMethodError();
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    public final T newInstance() {
        return this.zzcgf.newInstance(this.zzcfx);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyc.zzf(com.google.android.gms.internal.firebase_ml.zzyy.zzp(r10, r6), com.google.android.gms.internal.firebase_ml.zzyy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyy.zzl(r10, r6) == com.google.android.gms.internal.firebase_ml.zzyy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyy.zzk(r10, r6) == com.google.android.gms.internal.firebase_ml.zzyy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyy.zzl(r10, r6) == com.google.android.gms.internal.firebase_ml.zzyy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyy.zzk(r10, r6) == com.google.android.gms.internal.firebase_ml.zzyy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyy.zzk(r10, r6) == com.google.android.gms.internal.firebase_ml.zzyy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyy.zzk(r10, r6) == com.google.android.gms.internal.firebase_ml.zzyy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyc.zzf(com.google.android.gms.internal.firebase_ml.zzyy.zzp(r10, r6), com.google.android.gms.internal.firebase_ml.zzyy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyc.zzf(com.google.android.gms.internal.firebase_ml.zzyy.zzp(r10, r6), com.google.android.gms.internal.firebase_ml.zzyy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyc.zzf(com.google.android.gms.internal.firebase_ml.zzyy.zzp(r10, r6), com.google.android.gms.internal.firebase_ml.zzyy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyy.zzm(r10, r6) == com.google.android.gms.internal.firebase_ml.zzyy.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyy.zzk(r10, r6) == com.google.android.gms.internal.firebase_ml.zzyy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyy.zzl(r10, r6) == com.google.android.gms.internal.firebase_ml.zzyy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyy.zzk(r10, r6) == com.google.android.gms.internal.firebase_ml.zzyy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyy.zzl(r10, r6) == com.google.android.gms.internal.firebase_ml.zzyy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyy.zzl(r10, r6) == com.google.android.gms.internal.firebase_ml.zzyy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.firebase_ml.zzyy.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.firebase_ml.zzyy.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.firebase_ml.zzyy.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.firebase_ml.zzyy.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.firebase_ml.zzyc.zzf(com.google.android.gms.internal.firebase_ml.zzyy.zzp(r10, r6), com.google.android.gms.internal.firebase_ml.zzyy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzcft
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzds(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zzdt(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r10, r4)
            int r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_ml.zzyc.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.firebase_ml.zzyc.zzf(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.firebase_ml.zzyc.zzf(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_ml.zzyc.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_ml.zzyc.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_ml.zzyc.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_ml.zzyc.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzm(r10, r6)
            boolean r5 = com.google.android.gms.internal.firebase_ml.zzyy.zzm(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzn(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.firebase_ml.zzyy.zzn(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzo(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.firebase_ml.zzyy.zzo(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = r1
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.firebase_ml.zzys<?, ?> r0 = r9.zzcgh
            java.lang.Object r0 = r0.zzae(r10)
            com.google.android.gms.internal.firebase_ml.zzys<?, ?> r2 = r9.zzcgh
            java.lang.Object r2 = r2.zzae(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzcfy
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.firebase_ml.zzvm<?> r0 = r9.zzcgi
            com.google.android.gms.internal.firebase_ml.zzvq r10 = r0.zzo(r10)
            com.google.android.gms.internal.firebase_ml.zzvm<?> r0 = r9.zzcgi
            com.google.android.gms.internal.firebase_ml.zzvq r11 = r0.zzo(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzxk.equals(java.lang.Object, java.lang.Object):boolean");
    }

    public final int hashCode(T t) {
        int i;
        int i2;
        int length = this.zzcft.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzds = zzds(i4);
            int i5 = this.zzcft[i4];
            long j = (long) (1048575 & zzds);
            int i6 = 37;
            switch ((zzds & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    i = zzvy.zzaf(Double.doubleToLongBits(zzyy.zzo(t, j)));
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    i = Float.floatToIntBits(zzyy.zzn(t, j));
                    i3 = i2 + i;
                    break;
                case 2:
                    i2 = i3 * 53;
                    i = zzvy.zzaf(zzyy.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 3:
                    i2 = i3 * 53;
                    i = zzvy.zzaf(zzyy.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    i = zzyy.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 5:
                    i2 = i3 * 53;
                    i = zzvy.zzaf(zzyy.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    i = zzyy.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    i = zzvy.zzaz(zzyy.zzm(t, j));
                    i3 = i2 + i;
                    break;
                case 8:
                    i2 = i3 * 53;
                    i = ((String) zzyy.zzp(t, j)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    Object zzp = zzyy.zzp(t, j);
                    if (zzp != null) {
                        i6 = zzp.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    i = zzyy.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    i = zzyy.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 12:
                    i2 = i3 * 53;
                    i = zzyy.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 13:
                    i2 = i3 * 53;
                    i = zzyy.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 14:
                    i2 = i3 * 53;
                    i = zzvy.zzaf(zzyy.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    i = zzyy.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 16:
                    i2 = i3 * 53;
                    i = zzvy.zzaf(zzyy.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 17:
                    Object zzp2 = zzyy.zzp(t, j);
                    if (zzp2 != null) {
                        i6 = zzp2.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i3 * 53;
                    i = zzyy.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 50:
                    i2 = i3 * 53;
                    i = zzyy.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 51:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzvy.zzaf(Double.doubleToLongBits(zzf(t, j)));
                        i3 = i2 + i;
                        break;
                    }
                case 52:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = Float.floatToIntBits(zzg(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 53:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzvy.zzaf(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 54:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzvy.zzaf(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 55:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 56:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzvy.zzaf(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 57:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 58:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzvy.zzaz(zzj(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 59:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = ((String) zzyy.zzp(t, j)).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 60:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzyy.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 61:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzyy.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 62:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 63:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 64:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 65:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzvy.zzaf(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 66:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 67:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzvy.zzaf(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 68:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzyy.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzcgh.zzae(t).hashCode();
        return this.zzcfy ? (hashCode * 53) + this.zzcgi.zzo(t).hashCode() : hashCode;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, long):void
     arg types: [T, long, long]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(byte[], long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, long):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, int):void
     arg types: [T, long, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(byte[], long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, boolean):void
     arg types: [T, long, boolean]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(byte[], long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, float):void
     arg types: [T, long, float]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(byte[], long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, float):void */
    public final void zze(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzcft.length; i += 3) {
                int zzds = zzds(i);
                long j = (long) (1048575 & zzds);
                int i2 = this.zzcft[i];
                switch ((zzds & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza(t, j, zzyy.zzo(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza((Object) t, j, zzyy.zzn(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza((Object) t, j, zzyy.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza((Object) t, j, zzyy.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza((Object) t, j, zzyy.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza((Object) t, j, zzyy.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza((Object) t, j, zzyy.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza((Object) t, j, zzyy.zzm(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza(t, j, zzyy.zzp(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza(t, j, zzyy.zzp(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza((Object) t, j, zzyy.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza((Object) t, j, zzyy.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza((Object) t, j, zzyy.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza((Object) t, j, zzyy.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza((Object) t, j, zzyy.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzyy.zza((Object) t, j, zzyy.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzcgg.zza(t, t2, j);
                        break;
                    case 50:
                        zzyc.zza(this.zzcgj, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzyy.zza(t, j, zzyy.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzyy.zza(t, j, zzyy.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            zzyc.zza(this.zzcgh, t, t2);
            if (this.zzcfy) {
                zzyc.zza(this.zzcgi, t, t2);
                return;
            }
            return;
        }
        throw null;
    }

    private final void zza(T t, T t2, int i) {
        long zzds = (long) (zzds(i) & 1048575);
        if (zza(t2, i)) {
            Object zzp = zzyy.zzp(t, zzds);
            Object zzp2 = zzyy.zzp(t2, zzds);
            if (zzp != null && zzp2 != null) {
                zzyy.zza(t, zzds, zzvy.zzc(zzp, zzp2));
                zzb(t, i);
            } else if (zzp2 != null) {
                zzyy.zza(t, zzds, zzp2);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzds = zzds(i);
        int i2 = this.zzcft[i];
        long j = (long) (zzds & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zzyy.zzp(t, j);
            Object zzp2 = zzyy.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzyy.zza(t, j, zzvy.zzc(zzp, zzp2));
                zzb(t, i2, i);
            } else if (zzp2 != null) {
                zzyy.zza(t, j, zzp2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzvh.zzh(int, long):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzvh.zzh(int, int):void
      com.google.android.gms.internal.firebase_ml.zzvh.zzh(int, long):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, boolean):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, double):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, float):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, com.google.android.gms.internal.firebase_ml.zzwp):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, com.google.android.gms.internal.firebase_ml.zzxg):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, long):void
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, com.google.android.gms.internal.firebase_ml.zzuq):void
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, java.lang.String):void
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, float):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, double):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, com.google.android.gms.internal.firebase_ml.zzwp):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, com.google.android.gms.internal.firebase_ml.zzxg):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, boolean):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, long):void
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, com.google.android.gms.internal.firebase_ml.zzuq):void
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, java.lang.String):void
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, float):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, double):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, float):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, com.google.android.gms.internal.firebase_ml.zzwp):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, com.google.android.gms.internal.firebase_ml.zzxg):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, boolean):int
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, long):void
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, com.google.android.gms.internal.firebase_ml.zzuq):void
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, java.lang.String):void
      com.google.android.gms.internal.firebase_ml.zzvh.zzb(int, double):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzxk.zza(com.google.android.gms.internal.firebase_ml.zzys, java.lang.Object):int
     arg types: [com.google.android.gms.internal.firebase_ml.zzys<?, ?>, T]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzxk.zza(java.lang.Class<?>, java.lang.String):java.lang.reflect.Field
      com.google.android.gms.internal.firebase_ml.zzxk.zza(java.lang.Object, int):boolean
      com.google.android.gms.internal.firebase_ml.zzxk.zza(java.lang.Object, com.google.android.gms.internal.firebase_ml.zzzp):void
      com.google.android.gms.internal.firebase_ml.zzya.zza(java.lang.Object, com.google.android.gms.internal.firebase_ml.zzzp):void
      com.google.android.gms.internal.firebase_ml.zzxk.zza(com.google.android.gms.internal.firebase_ml.zzys, java.lang.Object):int */
    public final int zzaa(T t) {
        int i;
        int i2;
        long j;
        boolean z;
        int i3;
        int i4;
        int i5;
        int zzc;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int zzb;
        int i11;
        int i12;
        int i13;
        T t2 = t;
        int i14 = 267386880;
        int i15 = 1;
        int i16 = 0;
        if (this.zzcga) {
            Unsafe unsafe = zzcfs;
            int i17 = 0;
            int i18 = 0;
            while (i17 < this.zzcft.length) {
                int zzds = zzds(i17);
                int i19 = (zzds & i14) >>> 20;
                int i20 = this.zzcft[i17];
                long j2 = (long) (zzds & 1048575);
                int i21 = (i19 < zzvr.DOUBLE_LIST_PACKED.id() || i19 > zzvr.SINT64_LIST_PACKED.id()) ? 0 : this.zzcft[i17 + 2] & 1048575;
                switch (i19) {
                    case 0:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 1:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 2:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzd(i20, zzyy.zzl(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 3:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zze(i20, zzyy.zzl(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 4:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzm(i20, zzyy.zzk(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 5:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzg(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 6:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzp(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 7:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzb(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 8:
                        if (zza(t2, i17)) {
                            Object zzp = zzyy.zzp(t2, j2);
                            if (!(zzp instanceof zzuq)) {
                                zzb = zzvh.zzc(i20, (String) zzp);
                                break;
                            } else {
                                zzb = zzvh.zzc(i20, (zzuq) zzp);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 9:
                        if (zza(t2, i17)) {
                            zzb = zzyc.zzc(i20, zzyy.zzp(t2, j2), zzdp(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 10:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzc(i20, (zzuq) zzyy.zzp(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 11:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzn(i20, zzyy.zzk(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 12:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzr(i20, zzyy.zzk(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 13:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzq(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 14:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 15:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzo(i20, zzyy.zzk(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 16:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzf(i20, zzyy.zzl(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 17:
                        if (zza(t2, i17)) {
                            zzb = zzvh.zzc(i20, (zzxg) zzyy.zzp(t2, j2), zzdp(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 18:
                        zzb = zzyc.zzw(i20, zze(t2, j2), false);
                        break;
                    case 19:
                        zzb = zzyc.zzv(i20, zze(t2, j2), false);
                        break;
                    case 20:
                        zzb = zzyc.zzo(i20, zze(t2, j2), false);
                        break;
                    case 21:
                        zzb = zzyc.zzp(i20, zze(t2, j2), false);
                        break;
                    case 22:
                        zzb = zzyc.zzs(i20, zze(t2, j2), false);
                        break;
                    case 23:
                        zzb = zzyc.zzw(i20, zze(t2, j2), false);
                        break;
                    case 24:
                        zzb = zzyc.zzv(i20, zze(t2, j2), false);
                        break;
                    case 25:
                        zzb = zzyc.zzx(i20, zze(t2, j2), false);
                        break;
                    case 26:
                        zzb = zzyc.zzc(i20, zze(t2, j2));
                        break;
                    case 27:
                        zzb = zzyc.zzc(i20, zze(t2, j2), zzdp(i17));
                        break;
                    case 28:
                        zzb = zzyc.zzd(i20, zze(t2, j2));
                        break;
                    case 29:
                        zzb = zzyc.zzt(i20, zze(t2, j2), false);
                        break;
                    case 30:
                        zzb = zzyc.zzr(i20, zze(t2, j2), false);
                        break;
                    case 31:
                        zzb = zzyc.zzv(i20, zze(t2, j2), false);
                        break;
                    case 32:
                        zzb = zzyc.zzw(i20, zze(t2, j2), false);
                        break;
                    case 33:
                        zzb = zzyc.zzu(i20, zze(t2, j2), false);
                        break;
                    case 34:
                        zzb = zzyc.zzq(i20, zze(t2, j2), false);
                        break;
                    case 35:
                        i12 = zzyc.zzq((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzcgb) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzvh.zzdb(i20);
                            i11 = zzvh.zzdd(i12);
                            zzb = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 36:
                        i12 = zzyc.zzp((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzcgb) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzvh.zzdb(i20);
                            i11 = zzvh.zzdd(i12);
                            zzb = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 37:
                        i12 = zzyc.zzi((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzcgb) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzvh.zzdb(i20);
                            i11 = zzvh.zzdd(i12);
                            zzb = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 38:
                        i12 = zzyc.zzj((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzcgb) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzvh.zzdb(i20);
                            i11 = zzvh.zzdd(i12);
                            zzb = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 39:
                        i12 = zzyc.zzm((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzcgb) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzvh.zzdb(i20);
                            i11 = zzvh.zzdd(i12);
                            zzb = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 40:
                        i12 = zzyc.zzq((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzcgb) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzvh.zzdb(i20);
                            i11 = zzvh.zzdd(i12);
                            zzb = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 41:
                        i12 = zzyc.zzp((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzcgb) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzvh.zzdb(i20);
                            i11 = zzvh.zzdd(i12);
                            zzb = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 42:
                        i12 = zzyc.zzr((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzcgb) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzvh.zzdb(i20);
                            i11 = zzvh.zzdd(i12);
                            zzb = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 43:
                        i12 = zzyc.zzn((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzcgb) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzvh.zzdb(i20);
                            i11 = zzvh.zzdd(i12);
                            zzb = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 44:
                        i12 = zzyc.zzl((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzcgb) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzvh.zzdb(i20);
                            i11 = zzvh.zzdd(i12);
                            zzb = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 45:
                        i12 = zzyc.zzp((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzcgb) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzvh.zzdb(i20);
                            i11 = zzvh.zzdd(i12);
                            zzb = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 46:
                        i12 = zzyc.zzq((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzcgb) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzvh.zzdb(i20);
                            i11 = zzvh.zzdd(i12);
                            zzb = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 47:
                        i12 = zzyc.zzo((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzcgb) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzvh.zzdb(i20);
                            i11 = zzvh.zzdd(i12);
                            zzb = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 48:
                        i12 = zzyc.zzk((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzcgb) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzvh.zzdb(i20);
                            i11 = zzvh.zzdd(i12);
                            zzb = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 49:
                        zzb = zzyc.zzd(i20, zze(t2, j2), zzdp(i17));
                        break;
                    case 50:
                        zzb = this.zzcgj.zzd(i20, zzyy.zzp(t2, j2), zzdq(i17));
                        break;
                    case 51:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 52:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 53:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzd(i20, zzi(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 54:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zze(i20, zzi(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 55:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzm(i20, zzh(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 56:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzg(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 57:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzp(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 58:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzb(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 59:
                        if (zza(t2, i20, i17)) {
                            Object zzp2 = zzyy.zzp(t2, j2);
                            if (!(zzp2 instanceof zzuq)) {
                                zzb = zzvh.zzc(i20, (String) zzp2);
                                break;
                            } else {
                                zzb = zzvh.zzc(i20, (zzuq) zzp2);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 60:
                        if (zza(t2, i20, i17)) {
                            zzb = zzyc.zzc(i20, zzyy.zzp(t2, j2), zzdp(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 61:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzc(i20, (zzuq) zzyy.zzp(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 62:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzn(i20, zzh(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 63:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzr(i20, zzh(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 64:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzq(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 65:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 66:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzo(i20, zzh(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 67:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzf(i20, zzi(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 68:
                        if (zza(t2, i20, i17)) {
                            zzb = zzvh.zzc(i20, (zzxg) zzyy.zzp(t2, j2), zzdp(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    default:
                        i17 += 3;
                        i14 = 267386880;
                }
                i18 += zzb;
                i17 += 3;
                i14 = 267386880;
            }
            return i18 + zza((zzys) this.zzcgh, (Object) t2);
        }
        Unsafe unsafe2 = zzcfs;
        int i22 = -1;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i23 < this.zzcft.length) {
            int zzds2 = zzds(i23);
            int[] iArr = this.zzcft;
            int i26 = iArr[i23];
            int i27 = (zzds2 & 267386880) >>> 20;
            if (i27 <= 17) {
                int i28 = iArr[i23 + 2];
                int i29 = i28 & 1048575;
                i = i15 << (i28 >>> 20);
                if (i29 != i22) {
                    i25 = unsafe2.getInt(t2, (long) i29);
                    i22 = i29;
                }
                i2 = i28;
            } else {
                i2 = (!this.zzcgb || i27 < zzvr.DOUBLE_LIST_PACKED.id() || i27 > zzvr.SINT64_LIST_PACKED.id()) ? 0 : this.zzcft[i23 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzds2 & 1048575);
            switch (i27) {
                case 0:
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i24 += zzvh.zzb(i26, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        z = false;
                        i24 += zzvh.zzb(i26, 0.0f);
                        break;
                    }
                    z = false;
                case 2:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzvh.zzd(i26, unsafe2.getLong(t2, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 3:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzvh.zze(i26, unsafe2.getLong(t2, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 4:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzvh.zzm(i26, unsafe2.getInt(t2, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 5:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzvh.zzg(i26, 0);
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 6:
                    i4 = 1;
                    if ((i25 & i) != 0) {
                        i3 = 0;
                        i24 += zzvh.zzp(i26, 0);
                        z = false;
                        j = 0;
                        break;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                case 7:
                    if ((i25 & i) != 0) {
                        i4 = 1;
                        i24 += zzvh.zzb(i26, true);
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                case 8:
                    if ((i25 & i) != 0) {
                        Object object = unsafe2.getObject(t2, j3);
                        if (object instanceof zzuq) {
                            zzc = zzvh.zzc(i26, (zzuq) object);
                        } else {
                            zzc = zzvh.zzc(i26, (String) object);
                        }
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 9:
                    if ((i25 & i) != 0) {
                        zzc = zzyc.zzc(i26, unsafe2.getObject(t2, j3), zzdp(i23));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 10:
                    if ((i25 & i) != 0) {
                        zzc = zzvh.zzc(i26, (zzuq) unsafe2.getObject(t2, j3));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 11:
                    if ((i25 & i) != 0) {
                        zzc = zzvh.zzn(i26, unsafe2.getInt(t2, j3));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 12:
                    if ((i25 & i) != 0) {
                        zzc = zzvh.zzr(i26, unsafe2.getInt(t2, j3));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 13:
                    if ((i25 & i) != 0) {
                        i6 = zzvh.zzq(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 14:
                    if ((i25 & i) != 0) {
                        zzc = zzvh.zzh(i26, 0L);
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 15:
                    if ((i25 & i) != 0) {
                        zzc = zzvh.zzo(i26, unsafe2.getInt(t2, j3));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 16:
                    if ((i25 & i) != 0) {
                        zzc = zzvh.zzf(i26, unsafe2.getLong(t2, j3));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 17:
                    if ((i25 & i) != 0) {
                        zzc = zzvh.zzc(i26, (zzxg) unsafe2.getObject(t2, j3), zzdp(i23));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 18:
                    zzc = zzyc.zzw(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += zzc;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 19:
                    i3 = 0;
                    i7 = zzyc.zzv(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 20:
                    i3 = 0;
                    i7 = zzyc.zzo(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 21:
                    i3 = 0;
                    i7 = zzyc.zzp(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 22:
                    i3 = 0;
                    i7 = zzyc.zzs(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 23:
                    i3 = 0;
                    i7 = zzyc.zzw(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 24:
                    i3 = 0;
                    i7 = zzyc.zzv(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 25:
                    i3 = 0;
                    i7 = zzyc.zzx(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 26:
                    zzc = zzyc.zzc(i26, (List) unsafe2.getObject(t2, j3));
                    i24 += zzc;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 27:
                    zzc = zzyc.zzc(i26, (List<?>) ((List) unsafe2.getObject(t2, j3)), zzdp(i23));
                    i24 += zzc;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 28:
                    zzc = zzyc.zzd(i26, (List) unsafe2.getObject(t2, j3));
                    i24 += zzc;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 29:
                    zzc = zzyc.zzt(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += zzc;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 30:
                    i3 = 0;
                    i7 = zzyc.zzr(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 31:
                    i3 = 0;
                    i7 = zzyc.zzv(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 32:
                    i3 = 0;
                    i7 = zzyc.zzw(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 33:
                    i3 = 0;
                    i7 = zzyc.zzu(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 34:
                    i3 = 0;
                    i7 = zzyc.zzq(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 35:
                    i10 = zzyc.zzq((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzcgb) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzvh.zzdb(i26);
                        i8 = zzvh.zzdd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 36:
                    i10 = zzyc.zzp((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzcgb) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzvh.zzdb(i26);
                        i8 = zzvh.zzdd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 37:
                    i10 = zzyc.zzi((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzcgb) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzvh.zzdb(i26);
                        i8 = zzvh.zzdd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 38:
                    i10 = zzyc.zzj((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzcgb) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzvh.zzdb(i26);
                        i8 = zzvh.zzdd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 39:
                    i10 = zzyc.zzm((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzcgb) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzvh.zzdb(i26);
                        i8 = zzvh.zzdd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 40:
                    i10 = zzyc.zzq((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzcgb) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzvh.zzdb(i26);
                        i8 = zzvh.zzdd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 41:
                    i10 = zzyc.zzp((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzcgb) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzvh.zzdb(i26);
                        i8 = zzvh.zzdd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 42:
                    i10 = zzyc.zzr((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzcgb) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzvh.zzdb(i26);
                        i8 = zzvh.zzdd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 43:
                    i10 = zzyc.zzn((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzcgb) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzvh.zzdb(i26);
                        i8 = zzvh.zzdd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 44:
                    i10 = zzyc.zzl((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzcgb) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzvh.zzdb(i26);
                        i8 = zzvh.zzdd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 45:
                    i10 = zzyc.zzp((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzcgb) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzvh.zzdb(i26);
                        i8 = zzvh.zzdd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 46:
                    i10 = zzyc.zzq((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzcgb) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzvh.zzdb(i26);
                        i8 = zzvh.zzdd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 47:
                    i10 = zzyc.zzo((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzcgb) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzvh.zzdb(i26);
                        i8 = zzvh.zzdd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 48:
                    i10 = zzyc.zzk((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzcgb) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzvh.zzdb(i26);
                        i8 = zzvh.zzdd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 49:
                    zzc = zzyc.zzd(i26, (List) unsafe2.getObject(t2, j3), zzdp(i23));
                    i24 += zzc;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 50:
                    zzc = this.zzcgj.zzd(i26, unsafe2.getObject(t2, j3), zzdq(i23));
                    i24 += zzc;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 51:
                    if (zza(t2, i26, i23)) {
                        zzc = zzvh.zzb(i26, 0.0d);
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 52:
                    if (zza(t2, i26, i23)) {
                        i6 = zzvh.zzb(i26, 0.0f);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 53:
                    if (zza(t2, i26, i23)) {
                        zzc = zzvh.zzd(i26, zzi(t2, j3));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 54:
                    if (zza(t2, i26, i23)) {
                        zzc = zzvh.zze(i26, zzi(t2, j3));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 55:
                    if (zza(t2, i26, i23)) {
                        zzc = zzvh.zzm(i26, zzh(t2, j3));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 56:
                    if (zza(t2, i26, i23)) {
                        zzc = zzvh.zzg(i26, 0);
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 57:
                    if (zza(t2, i26, i23)) {
                        i6 = zzvh.zzp(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 58:
                    if (zza(t2, i26, i23)) {
                        i6 = zzvh.zzb(i26, true);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 59:
                    if (zza(t2, i26, i23)) {
                        Object object2 = unsafe2.getObject(t2, j3);
                        if (object2 instanceof zzuq) {
                            zzc = zzvh.zzc(i26, (zzuq) object2);
                        } else {
                            zzc = zzvh.zzc(i26, (String) object2);
                        }
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 60:
                    if (zza(t2, i26, i23)) {
                        zzc = zzyc.zzc(i26, unsafe2.getObject(t2, j3), zzdp(i23));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 61:
                    if (zza(t2, i26, i23)) {
                        zzc = zzvh.zzc(i26, (zzuq) unsafe2.getObject(t2, j3));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 62:
                    if (zza(t2, i26, i23)) {
                        zzc = zzvh.zzn(i26, zzh(t2, j3));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 63:
                    if (zza(t2, i26, i23)) {
                        zzc = zzvh.zzr(i26, zzh(t2, j3));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 64:
                    if (zza(t2, i26, i23)) {
                        i6 = zzvh.zzq(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 65:
                    if (zza(t2, i26, i23)) {
                        zzc = zzvh.zzh(i26, 0L);
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 66:
                    if (zza(t2, i26, i23)) {
                        zzc = zzvh.zzo(i26, zzh(t2, j3));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 67:
                    if (zza(t2, i26, i23)) {
                        zzc = zzvh.zzf(i26, zzi(t2, j3));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 68:
                    if (zza(t2, i26, i23)) {
                        zzc = zzvh.zzc(i26, (zzxg) unsafe2.getObject(t2, j3), zzdp(i23));
                        i24 += zzc;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                default:
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
            }
            i23 += 3;
            i16 = i3;
            i15 = i4;
        }
        int i30 = i16;
        int zza = i24 + zza((zzys) this.zzcgh, (Object) t2);
        if (!this.zzcfy) {
            return zza;
        }
        zzvq<?> zzo = this.zzcgi.zzo(t2);
        for (int i31 = i30; i31 < zzo.zzcai.zzvt(); i31++) {
            Map.Entry<T, Object> zzdx = zzo.zzcai.zzdx(i31);
            i30 += zzvq.zzb((zzvs) zzdx.getKey(), zzdx.getValue());
        }
        for (Map.Entry next : zzo.zzcai.zzvu()) {
            i30 += zzvq.zzb((zzvs) next.getKey(), next.getValue());
        }
        return zza + i30;
    }

    private static <UT, UB> int zza(zzys<UT, UB> zzys, T t) {
        return zzys.zzaa(zzys.zzae(t));
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzyy.zzp(obj, j);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzyc.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.firebase_ml.zzzp, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.firebase_ml.zzzp, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzyc.zzb(int, java.util.List<?>, com.google.android.gms.internal.firebase_ml.zzzp, com.google.android.gms.internal.firebase_ml.zzya):void
      com.google.android.gms.internal.firebase_ml.zzyc.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.firebase_ml.zzzp, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzyc.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.firebase_ml.zzzp, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.firebase_ml.zzzp, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzyc.zza(int, int, java.lang.Object, com.google.android.gms.internal.firebase_ml.zzys):UB
      com.google.android.gms.internal.firebase_ml.zzyc.zza(int, java.util.List<?>, com.google.android.gms.internal.firebase_ml.zzzp, com.google.android.gms.internal.firebase_ml.zzya):void
      com.google.android.gms.internal.firebase_ml.zzyc.zza(com.google.android.gms.internal.firebase_ml.zzxd, java.lang.Object, java.lang.Object, long):void
      com.google.android.gms.internal.firebase_ml.zzyc.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.firebase_ml.zzzp, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.firebase_ml.zzzp r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zztg()
            int r1 = com.google.android.gms.internal.firebase_ml.zzvx.zzf.zzcdw
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.firebase_ml.zzys<?, ?> r0 = r13.zzcgh
            zza(r0, r14, r15)
            boolean r0 = r13.zzcfy
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.firebase_ml.zzvm<?> r0 = r13.zzcgi
            com.google.android.gms.internal.firebase_ml.zzvq r0 = r0.zzo(r14)
            com.google.android.gms.internal.firebase_ml.zzyf<T, java.lang.Object> r1 = r0.zzcai
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zzcft
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzds(r7)
            int[] r9 = r13.zzcft
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.firebase_ml.zzvm<?> r10 = r13.zzcgi
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.firebase_ml.zzvm<?> r10 = r13.zzcgi
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0043
        L_0x005f:
            r1 = r3
            goto L_0x0043
        L_0x0061:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04fe;
                case 1: goto L_0x04ee;
                case 2: goto L_0x04de;
                case 3: goto L_0x04ce;
                case 4: goto L_0x04be;
                case 5: goto L_0x04ae;
                case 6: goto L_0x049e;
                case 7: goto L_0x048d;
                case 8: goto L_0x047c;
                case 9: goto L_0x0467;
                case 10: goto L_0x0454;
                case 11: goto L_0x0443;
                case 12: goto L_0x0432;
                case 13: goto L_0x0421;
                case 14: goto L_0x0410;
                case 15: goto L_0x03ff;
                case 16: goto L_0x03ee;
                case 17: goto L_0x03d9;
                case 18: goto L_0x03c8;
                case 19: goto L_0x03b7;
                case 20: goto L_0x03a6;
                case 21: goto L_0x0395;
                case 22: goto L_0x0384;
                case 23: goto L_0x0373;
                case 24: goto L_0x0362;
                case 25: goto L_0x0351;
                case 26: goto L_0x0340;
                case 27: goto L_0x032b;
                case 28: goto L_0x031a;
                case 29: goto L_0x0309;
                case 30: goto L_0x02f8;
                case 31: goto L_0x02e7;
                case 32: goto L_0x02d6;
                case 33: goto L_0x02c5;
                case 34: goto L_0x02b4;
                case 35: goto L_0x02a3;
                case 36: goto L_0x0292;
                case 37: goto L_0x0281;
                case 38: goto L_0x0270;
                case 39: goto L_0x025f;
                case 40: goto L_0x024e;
                case 41: goto L_0x023d;
                case 42: goto L_0x022c;
                case 43: goto L_0x021b;
                case 44: goto L_0x020a;
                case 45: goto L_0x01f9;
                case 46: goto L_0x01e8;
                case 47: goto L_0x01d7;
                case 48: goto L_0x01c6;
                case 49: goto L_0x01b1;
                case 50: goto L_0x01a6;
                case 51: goto L_0x0195;
                case 52: goto L_0x0184;
                case 53: goto L_0x0173;
                case 54: goto L_0x0162;
                case 55: goto L_0x0151;
                case 56: goto L_0x0140;
                case 57: goto L_0x012f;
                case 58: goto L_0x011e;
                case 59: goto L_0x010d;
                case 60: goto L_0x00f8;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d4;
                case 63: goto L_0x00c3;
                case 64: goto L_0x00b2;
                case 65: goto L_0x00a1;
                case 66: goto L_0x0090;
                case 67: goto L_0x007f;
                case 68: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x050d
        L_0x006a:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            com.google.android.gms.internal.firebase_ml.zzya r10 = r13.zzdp(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzk(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzs(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzt(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzj(r9, r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            com.google.android.gms.internal.firebase_ml.zzuq r8 = (com.google.android.gms.internal.firebase_ml.zzuq) r8
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            com.google.android.gms.internal.firebase_ml.zzya r10 = r13.zzdp(r7)
            r15.zza(r9, r8, r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            zza(r9, r8, r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzj(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzl(r9, r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzi(r9, r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzg(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzf(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            r13.zza(r15, r9, r8, r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzya r10 = r13.zzdp(r7)
            com.google.android.gms.internal.firebase_ml.zzyc.zzb(r9, r8, r15, r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzb(r9, r8, r15, r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zza(r9, r8, r15, r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzb(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzya r10 = r13.zzdp(r7)
            com.google.android.gms.internal.firebase_ml.zzyc.zza(r9, r8, r15, r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zza(r9, r8, r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zzb(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzcft
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.zzyc.zza(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            com.google.android.gms.internal.firebase_ml.zzya r10 = r13.zzdp(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r14, r10)
            r15.zzk(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r14, r10)
            r15.zzs(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r14, r10)
            r15.zzt(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r14, r10)
            r15.zzj(r9, r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            com.google.android.gms.internal.firebase_ml.zzuq r8 = (com.google.android.gms.internal.firebase_ml.zzuq) r8
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            com.google.android.gms.internal.firebase_ml.zzya r10 = r13.zzdp(r7)
            r15.zza(r9, r8, r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r10)
            zza(r9, r8, r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzm(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r14, r10)
            r15.zzl(r9, r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r14, r10)
            r15.zzi(r9, r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.firebase_ml.zzyy.zzn(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.firebase_ml.zzyy.zzo(r14, r10)
            r15.zza(r9, r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.firebase_ml.zzvm<?> r14 = r13.zzcgi
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0526
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x0511
        L_0x0526:
            r1 = r3
            goto L_0x0511
        L_0x0528:
            return
        L_0x0529:
            boolean r0 = r13.zzcga
            if (r0 == 0) goto L_0x0a44
            boolean r0 = r13.zzcfy
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.firebase_ml.zzvm<?> r0 = r13.zzcgi
            com.google.android.gms.internal.firebase_ml.zzvq r0 = r0.zzo(r14)
            com.google.android.gms.internal.firebase_ml.zzyf<T, java.lang.Object> r1 = r0.zzcai
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x054a
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x054c
        L_0x054a:
            r0 = r3
            r1 = r0
        L_0x054c:
            int[] r7 = r13.zzcft
            int r7 = r7.length
            r8 = r5
        L_0x0550:
            if (r8 >= r7) goto L_0x0a28
            int r9 = r13.zzds(r8)
            int[] r10 = r13.zzcft
            r10 = r10[r8]
        L_0x055a:
            if (r1 == 0) goto L_0x0578
            com.google.android.gms.internal.firebase_ml.zzvm<?> r11 = r13.zzcgi
            int r11 = r11.zza(r1)
            if (r11 > r10) goto L_0x0578
            com.google.android.gms.internal.firebase_ml.zzvm<?> r11 = r13.zzcgi
            r11.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0576
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x055a
        L_0x0576:
            r1 = r3
            goto L_0x055a
        L_0x0578:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a15;
                case 1: goto L_0x0a05;
                case 2: goto L_0x09f5;
                case 3: goto L_0x09e5;
                case 4: goto L_0x09d5;
                case 5: goto L_0x09c5;
                case 6: goto L_0x09b5;
                case 7: goto L_0x09a4;
                case 8: goto L_0x0993;
                case 9: goto L_0x097e;
                case 10: goto L_0x096b;
                case 11: goto L_0x095a;
                case 12: goto L_0x0949;
                case 13: goto L_0x0938;
                case 14: goto L_0x0927;
                case 15: goto L_0x0916;
                case 16: goto L_0x0905;
                case 17: goto L_0x08f0;
                case 18: goto L_0x08df;
                case 19: goto L_0x08ce;
                case 20: goto L_0x08bd;
                case 21: goto L_0x08ac;
                case 22: goto L_0x089b;
                case 23: goto L_0x088a;
                case 24: goto L_0x0879;
                case 25: goto L_0x0868;
                case 26: goto L_0x0857;
                case 27: goto L_0x0842;
                case 28: goto L_0x0831;
                case 29: goto L_0x0820;
                case 30: goto L_0x080f;
                case 31: goto L_0x07fe;
                case 32: goto L_0x07ed;
                case 33: goto L_0x07dc;
                case 34: goto L_0x07cb;
                case 35: goto L_0x07ba;
                case 36: goto L_0x07a9;
                case 37: goto L_0x0798;
                case 38: goto L_0x0787;
                case 39: goto L_0x0776;
                case 40: goto L_0x0765;
                case 41: goto L_0x0754;
                case 42: goto L_0x0743;
                case 43: goto L_0x0732;
                case 44: goto L_0x0721;
                case 45: goto L_0x0710;
                case 46: goto L_0x06ff;
                case 47: goto L_0x06ee;
                case 48: goto L_0x06dd;
                case 49: goto L_0x06c8;
                case 50: goto L_0x06bd;
                case 51: goto L_0x06ac;
                case 52: goto L_0x069b;
                case 53: goto L_0x068a;
                case 54: goto L_0x0679;
                case 55: goto L_0x0668;
                case 56: goto L_0x0657;
                case 57: goto L_0x0646;
                case 58: goto L_0x0635;
                case 59: goto L_0x0624;
                case 60: goto L_0x060f;
                case 61: goto L_0x05fc;
                case 62: goto L_0x05eb;
                case 63: goto L_0x05da;
                case 64: goto L_0x05c9;
                case 65: goto L_0x05b8;
                case 66: goto L_0x05a7;
                case 67: goto L_0x0596;
                case 68: goto L_0x0581;
                default: goto L_0x057f;
            }
        L_0x057f:
            goto L_0x0a24
        L_0x0581:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            com.google.android.gms.internal.firebase_ml.zzya r11 = r13.zzdp(r8)
            r15.zzb(r10, r9, r11)
            goto L_0x0a24
        L_0x0596:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0a24
        L_0x05a7:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzk(r10, r9)
            goto L_0x0a24
        L_0x05b8:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x05c9:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzs(r10, r9)
            goto L_0x0a24
        L_0x05da:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzt(r10, r9)
            goto L_0x0a24
        L_0x05eb:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzj(r10, r9)
            goto L_0x0a24
        L_0x05fc:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            com.google.android.gms.internal.firebase_ml.zzuq r9 = (com.google.android.gms.internal.firebase_ml.zzuq) r9
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x060f:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            com.google.android.gms.internal.firebase_ml.zzya r11 = r13.zzdp(r8)
            r15.zza(r10, r9, r11)
            goto L_0x0a24
        L_0x0624:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0a24
        L_0x0635:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzj(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x0646:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzl(r10, r9)
            goto L_0x0a24
        L_0x0657:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a24
        L_0x0668:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzi(r10, r9)
            goto L_0x0a24
        L_0x0679:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a24
        L_0x068a:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a24
        L_0x069b:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzg(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x06ac:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzf(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a24
        L_0x06bd:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            r13.zza(r15, r10, r9, r8)
            goto L_0x0a24
        L_0x06c8:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzya r11 = r13.zzdp(r8)
            com.google.android.gms.internal.firebase_ml.zzyc.zzb(r10, r9, r15, r11)
            goto L_0x0a24
        L_0x06dd:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zze(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ee:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzj(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ff:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzg(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0710:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzl(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0721:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzm(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0732:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzi(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0743:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzn(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0754:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzk(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0765:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzf(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0776:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzh(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0787:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzd(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0798:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzc(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07a9:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzb(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07ba:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zza(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07cb:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zze(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07dc:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzj(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07ed:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzg(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07fe:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzl(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x080f:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzm(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0820:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzi(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0831:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzb(r10, r9, r15)
            goto L_0x0a24
        L_0x0842:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzya r11 = r13.zzdp(r8)
            com.google.android.gms.internal.firebase_ml.zzyc.zza(r10, r9, r15, r11)
            goto L_0x0a24
        L_0x0857:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zza(r10, r9, r15)
            goto L_0x0a24
        L_0x0868:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzn(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0879:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzk(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x088a:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzf(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x089b:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzh(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ac:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzd(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08bd:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzc(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ce:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzb(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08df:
            int[] r10 = r13.zzcft
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zza(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08f0:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            com.google.android.gms.internal.firebase_ml.zzya r11 = r13.zzdp(r8)
            r15.zzb(r10, r9, r11)
            goto L_0x0a24
        L_0x0905:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0a24
        L_0x0916:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r14, r11)
            r15.zzk(r10, r9)
            goto L_0x0a24
        L_0x0927:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x0938:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r14, r11)
            r15.zzs(r10, r9)
            goto L_0x0a24
        L_0x0949:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r14, r11)
            r15.zzt(r10, r9)
            goto L_0x0a24
        L_0x095a:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r14, r11)
            r15.zzj(r10, r9)
            goto L_0x0a24
        L_0x096b:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            com.google.android.gms.internal.firebase_ml.zzuq r9 = (com.google.android.gms.internal.firebase_ml.zzuq) r9
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x097e:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            com.google.android.gms.internal.firebase_ml.zzya r11 = r13.zzdp(r8)
            r15.zza(r10, r9, r11)
            goto L_0x0a24
        L_0x0993:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0a24
        L_0x09a4:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzm(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x09b5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r14, r11)
            r15.zzl(r10, r9)
            goto L_0x0a24
        L_0x09c5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a24
        L_0x09d5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzk(r14, r11)
            r15.zzi(r10, r9)
            goto L_0x0a24
        L_0x09e5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a24
        L_0x09f5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_ml.zzyy.zzl(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a24
        L_0x0a05:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzn(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x0a15:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.firebase_ml.zzyy.zzo(r14, r11)
            r15.zza(r10, r11)
        L_0x0a24:
            int r8 = r8 + 3
            goto L_0x0550
        L_0x0a28:
            if (r1 == 0) goto L_0x0a3e
            com.google.android.gms.internal.firebase_ml.zzvm<?> r2 = r13.zzcgi
            r2.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a3c
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0a28
        L_0x0a3c:
            r1 = r3
            goto L_0x0a28
        L_0x0a3e:
            com.google.android.gms.internal.firebase_ml.zzys<?, ?> r0 = r13.zzcgh
            zza(r0, r14, r15)
            return
        L_0x0a44:
            r13.zzb(r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzxk.zza(java.lang.Object, com.google.android.gms.internal.firebase_ml.zzzp):void");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzyc.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.firebase_ml.zzzp, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.firebase_ml.zzzp, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzyc.zzb(int, java.util.List<?>, com.google.android.gms.internal.firebase_ml.zzzp, com.google.android.gms.internal.firebase_ml.zzya):void
      com.google.android.gms.internal.firebase_ml.zzyc.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.firebase_ml.zzzp, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzyc.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.firebase_ml.zzzp, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.firebase_ml.zzzp, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzyc.zza(int, int, java.lang.Object, com.google.android.gms.internal.firebase_ml.zzys):UB
      com.google.android.gms.internal.firebase_ml.zzyc.zza(int, java.util.List<?>, com.google.android.gms.internal.firebase_ml.zzzp, com.google.android.gms.internal.firebase_ml.zzya):void
      com.google.android.gms.internal.firebase_ml.zzyc.zza(com.google.android.gms.internal.firebase_ml.zzxd, java.lang.Object, java.lang.Object, long):void
      com.google.android.gms.internal.firebase_ml.zzyc.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.firebase_ml.zzzp, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.firebase_ml.zzzp r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzcfy
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.firebase_ml.zzvm<?> r3 = r0.zzcgi
            com.google.android.gms.internal.firebase_ml.zzvq r3 = r3.zzo(r1)
            com.google.android.gms.internal.firebase_ml.zzyf<T, java.lang.Object> r5 = r3.zzcai
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            r6 = -1
            int[] r7 = r0.zzcft
            int r7 = r7.length
            sun.misc.Unsafe r8 = com.google.android.gms.internal.firebase_ml.zzxk.zzcfs
            r10 = 0
            r11 = 0
        L_0x002d:
            if (r10 >= r7) goto L_0x0494
            int r12 = r0.zzds(r10)
            int[] r13 = r0.zzcft
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzcga
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x005d
            r4 = 17
            if (r15 > r4) goto L_0x005d
            int r4 = r10 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            r17 = r10
            if (r13 == r6) goto L_0x0057
            long r9 = (long) r13
            int r11 = r8.getInt(r1, r9)
            r6 = r13
        L_0x0057:
            int r4 = r4 >>> 20
            r9 = 1
            int r4 = r9 << r4
            goto L_0x0060
        L_0x005d:
            r17 = r10
            r4 = 0
        L_0x0060:
            if (r5 == 0) goto L_0x007e
            com.google.android.gms.internal.firebase_ml.zzvm<?> r9 = r0.zzcgi
            int r9 = r9.zza(r5)
            if (r9 > r14) goto L_0x007e
            com.google.android.gms.internal.firebase_ml.zzvm<?> r9 = r0.zzcgi
            r9.zza(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007c
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0060
        L_0x007c:
            r5 = 0
            goto L_0x0060
        L_0x007e:
            r9 = r12 & r16
            long r9 = (long) r9
            r12 = r17
            switch(r15) {
                case 0: goto L_0x0485;
                case 1: goto L_0x0479;
                case 2: goto L_0x046d;
                case 3: goto L_0x0461;
                case 4: goto L_0x0455;
                case 5: goto L_0x0449;
                case 6: goto L_0x043d;
                case 7: goto L_0x0431;
                case 8: goto L_0x0425;
                case 9: goto L_0x0414;
                case 10: goto L_0x0405;
                case 11: goto L_0x03f8;
                case 12: goto L_0x03eb;
                case 13: goto L_0x03de;
                case 14: goto L_0x03d1;
                case 15: goto L_0x03c4;
                case 16: goto L_0x03b7;
                case 17: goto L_0x03a6;
                case 18: goto L_0x0396;
                case 19: goto L_0x0386;
                case 20: goto L_0x0376;
                case 21: goto L_0x0366;
                case 22: goto L_0x0356;
                case 23: goto L_0x0346;
                case 24: goto L_0x0336;
                case 25: goto L_0x0326;
                case 26: goto L_0x0317;
                case 27: goto L_0x0304;
                case 28: goto L_0x02f5;
                case 29: goto L_0x02e5;
                case 30: goto L_0x02d5;
                case 31: goto L_0x02c5;
                case 32: goto L_0x02b5;
                case 33: goto L_0x02a5;
                case 34: goto L_0x0295;
                case 35: goto L_0x0285;
                case 36: goto L_0x0275;
                case 37: goto L_0x0265;
                case 38: goto L_0x0255;
                case 39: goto L_0x0245;
                case 40: goto L_0x0235;
                case 41: goto L_0x0225;
                case 42: goto L_0x0215;
                case 43: goto L_0x0205;
                case 44: goto L_0x01f5;
                case 45: goto L_0x01e5;
                case 46: goto L_0x01d5;
                case 47: goto L_0x01c5;
                case 48: goto L_0x01b5;
                case 49: goto L_0x01a2;
                case 50: goto L_0x0199;
                case 51: goto L_0x018a;
                case 52: goto L_0x017b;
                case 53: goto L_0x016c;
                case 54: goto L_0x015d;
                case 55: goto L_0x014e;
                case 56: goto L_0x013f;
                case 57: goto L_0x0130;
                case 58: goto L_0x0121;
                case 59: goto L_0x0112;
                case 60: goto L_0x00ff;
                case 61: goto L_0x00ef;
                case 62: goto L_0x00e1;
                case 63: goto L_0x00d3;
                case 64: goto L_0x00c5;
                case 65: goto L_0x00b7;
                case 66: goto L_0x00a9;
                case 67: goto L_0x009b;
                case 68: goto L_0x0089;
                default: goto L_0x0086;
            }
        L_0x0086:
            r13 = 0
            goto L_0x0490
        L_0x0089:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.firebase_ml.zzya r9 = r0.zzdp(r12)
            r2.zzb(r14, r4, r9)
            goto L_0x0086
        L_0x009b:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zzb(r14, r9)
            goto L_0x0086
        L_0x00a9:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzk(r14, r4)
            goto L_0x0086
        L_0x00b7:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zzj(r14, r9)
            goto L_0x0086
        L_0x00c5:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzs(r14, r4)
            goto L_0x0086
        L_0x00d3:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzt(r14, r4)
            goto L_0x0086
        L_0x00e1:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzj(r14, r4)
            goto L_0x0086
        L_0x00ef:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.firebase_ml.zzuq r4 = (com.google.android.gms.internal.firebase_ml.zzuq) r4
            r2.zza(r14, r4)
            goto L_0x0086
        L_0x00ff:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.firebase_ml.zzya r9 = r0.zzdp(r12)
            r2.zza(r14, r4, r9)
            goto L_0x0086
        L_0x0112:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza(r14, r4, r2)
            goto L_0x0086
        L_0x0121:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            boolean r4 = zzj(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0086
        L_0x0130:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzl(r14, r4)
            goto L_0x0086
        L_0x013f:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zzc(r14, r9)
            goto L_0x0086
        L_0x014e:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzi(r14, r4)
            goto L_0x0086
        L_0x015d:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zza(r14, r9)
            goto L_0x0086
        L_0x016c:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zzi(r14, r9)
            goto L_0x0086
        L_0x017b:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            float r4 = zzg(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0086
        L_0x018a:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            double r9 = zzf(r1, r9)
            r2.zza(r14, r9)
            goto L_0x0086
        L_0x0199:
            java.lang.Object r4 = r8.getObject(r1, r9)
            r0.zza(r2, r14, r4, r12)
            goto L_0x0086
        L_0x01a2:
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzya r10 = r0.zzdp(r12)
            com.google.android.gms.internal.firebase_ml.zzyc.zzb(r4, r9, r2, r10)
            goto L_0x0086
        L_0x01b5:
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.firebase_ml.zzyc.zze(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01c5:
            r13 = 1
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzj(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01d5:
            r13 = 1
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzg(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01e5:
            r13 = 1
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzl(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01f5:
            r13 = 1
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzm(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0205:
            r13 = 1
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzi(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0215:
            r13 = 1
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzn(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0225:
            r13 = 1
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzk(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0235:
            r13 = 1
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzf(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0245:
            r13 = 1
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzh(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0255:
            r13 = 1
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzd(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0265:
            r13 = 1
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzc(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0275:
            r13 = 1
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzb(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0285:
            r13 = 1
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zza(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0295:
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_ml.zzyc.zze(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02a5:
            r13 = 0
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzj(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02b5:
            r13 = 0
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzg(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02c5:
            r13 = 0
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzl(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02d5:
            r13 = 0
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzm(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02e5:
            r13 = 0
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzi(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02f5:
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzb(r4, r9, r2)
            goto L_0x0086
        L_0x0304:
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzya r10 = r0.zzdp(r12)
            com.google.android.gms.internal.firebase_ml.zzyc.zza(r4, r9, r2, r10)
            goto L_0x0086
        L_0x0317:
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zza(r4, r9, r2)
            goto L_0x0086
        L_0x0326:
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.firebase_ml.zzyc.zzn(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0336:
            r13 = 0
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzk(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0346:
            r13 = 0
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzf(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0356:
            r13 = 0
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzh(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0366:
            r13 = 0
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzd(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0376:
            r13 = 0
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzc(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0386:
            r13 = 0
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zzb(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0396:
            r13 = 0
            int[] r4 = r0.zzcft
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.zzyc.zza(r4, r9, r2, r13)
            goto L_0x0490
        L_0x03a6:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.firebase_ml.zzya r9 = r0.zzdp(r12)
            r2.zzb(r14, r4, r9)
            goto L_0x0490
        L_0x03b7:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzb(r14, r9)
            goto L_0x0490
        L_0x03c4:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzk(r14, r4)
            goto L_0x0490
        L_0x03d1:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzj(r14, r9)
            goto L_0x0490
        L_0x03de:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzs(r14, r4)
            goto L_0x0490
        L_0x03eb:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzt(r14, r4)
            goto L_0x0490
        L_0x03f8:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzj(r14, r4)
            goto L_0x0490
        L_0x0405:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.firebase_ml.zzuq r4 = (com.google.android.gms.internal.firebase_ml.zzuq) r4
            r2.zza(r14, r4)
            goto L_0x0490
        L_0x0414:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.firebase_ml.zzya r9 = r0.zzdp(r12)
            r2.zza(r14, r4, r9)
            goto L_0x0490
        L_0x0425:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza(r14, r4, r2)
            goto L_0x0490
        L_0x0431:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            boolean r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzm(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0490
        L_0x043d:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzl(r14, r4)
            goto L_0x0490
        L_0x0449:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzc(r14, r9)
            goto L_0x0490
        L_0x0455:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzi(r14, r4)
            goto L_0x0490
        L_0x0461:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zza(r14, r9)
            goto L_0x0490
        L_0x046d:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzi(r14, r9)
            goto L_0x0490
        L_0x0479:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            float r4 = com.google.android.gms.internal.firebase_ml.zzyy.zzn(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0490
        L_0x0485:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            double r9 = com.google.android.gms.internal.firebase_ml.zzyy.zzo(r1, r9)
            r2.zza(r14, r9)
        L_0x0490:
            int r10 = r12 + 3
            goto L_0x002d
        L_0x0494:
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.firebase_ml.zzvm<?> r4 = r0.zzcgi
            r4.zza(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a9
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x0494
        L_0x04a9:
            r5 = 0
            goto L_0x0494
        L_0x04ab:
            com.google.android.gms.internal.firebase_ml.zzys<?, ?> r3 = r0.zzcgh
            zza(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzxk.zzb(java.lang.Object, com.google.android.gms.internal.firebase_ml.zzzp):void");
    }

    private final <K, V> void zza(zzzp zzzp, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzzp.zza(i, this.zzcgj.zzv(zzdq(i2)), this.zzcgj.zzw(obj));
        }
    }

    private static <UT, UB> void zza(zzys<UT, UB> zzys, T t, zzzp zzzp) throws IOException {
        zzys.zza(zzys.zzae(t), zzzp);
    }

    private static zzyv zzab(Object obj) {
        zzvx zzvx = (zzvx) obj;
        zzyv zzyv = zzvx.zzcdg;
        if (zzyv != zzyv.zzwc()) {
            return zzyv;
        }
        zzyv zzwd = zzyv.zzwd();
        zzvx.zzcdg = zzwd;
        return zzwd;
    }

    private static int zza(byte[] bArr, int i, int i2, zzzj zzzj, Class<?> cls, zzup zzup) throws IOException {
        switch (zzxn.zzcah[zzzj.ordinal()]) {
            case 1:
                int zzb = zzum.zzb(bArr, i, zzup);
                zzup.zzbzg = Boolean.valueOf(zzup.zzbzf != 0);
                return zzb;
            case 2:
                return zzum.zze(bArr, i, zzup);
            case 3:
                zzup.zzbzg = Double.valueOf(zzum.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzup.zzbzg = Integer.valueOf(zzum.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzup.zzbzg = Long.valueOf(zzum.zzb(bArr, i));
                return i + 8;
            case 8:
                zzup.zzbzg = Float.valueOf(zzum.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza = zzum.zza(bArr, i, zzup);
                zzup.zzbzg = Integer.valueOf(zzup.zzbze);
                return zza;
            case 12:
            case 13:
                int zzb2 = zzum.zzb(bArr, i, zzup);
                zzup.zzbzg = Long.valueOf(zzup.zzbzf);
                return zzb2;
            case 14:
                return zzum.zza(zzxv.zzvk().zzl(cls), bArr, i, i2, zzup);
            case 15:
                int zza2 = zzum.zza(bArr, i, zzup);
                zzup.zzbzg = Integer.valueOf(zzvc.zzcw(zzup.zzbze));
                return zza2;
            case 16:
                int zzb3 = zzum.zzb(bArr, i, zzup);
                zzup.zzbzg = Long.valueOf(zzvc.zzv(zzup.zzbzf));
                return zzb3;
            case 17:
                return zzum.zzd(bArr, i, zzup);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:52)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:86)
        */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0423 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01eb  */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.firebase_ml.zzup r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = com.google.android.gms.internal.firebase_ml.zzxk.zzcfs
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.firebase_ml.zzwh r11 = (com.google.android.gms.internal.firebase_ml.zzwh) r11
            boolean r12 = r11.zzso()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.firebase_ml.zzwh r11 = r11.zzcr(r12)
            sun.misc.Unsafe r12 = com.google.android.gms.internal.firebase_ml.zzxk.zzcfs
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x03e4;
                case 19: goto L_0x03a6;
                case 20: goto L_0x0365;
                case 21: goto L_0x0365;
                case 22: goto L_0x034b;
                case 23: goto L_0x030c;
                case 24: goto L_0x02cd;
                case 25: goto L_0x0276;
                case 26: goto L_0x01c3;
                case 27: goto L_0x01a9;
                case 28: goto L_0x0151;
                case 29: goto L_0x034b;
                case 30: goto L_0x0119;
                case 31: goto L_0x02cd;
                case 32: goto L_0x030c;
                case 33: goto L_0x00cc;
                case 34: goto L_0x007f;
                case 35: goto L_0x03e4;
                case 36: goto L_0x03a6;
                case 37: goto L_0x0365;
                case 38: goto L_0x0365;
                case 39: goto L_0x034b;
                case 40: goto L_0x030c;
                case 41: goto L_0x02cd;
                case 42: goto L_0x0276;
                case 43: goto L_0x034b;
                case 44: goto L_0x0119;
                case 45: goto L_0x02cd;
                case 46: goto L_0x030c;
                case 47: goto L_0x00cc;
                case 48: goto L_0x007f;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0422
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x0422
            com.google.android.gms.internal.firebase_ml.zzya r1 = r0.zzdp(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzbzg
            r11.add(r8)
        L_0x005f:
            if (r4 >= r5) goto L_0x0422
            int r8 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r9 = r7.zzbze
            if (r2 != r9) goto L_0x0422
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzbzg
            r11.add(r8)
            goto L_0x005f
        L_0x007f:
            if (r6 != r10) goto L_0x00a3
            com.google.android.gms.internal.firebase_ml.zzwu r11 = (com.google.android.gms.internal.firebase_ml.zzwu) r11
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r2 = r7.zzbze
            int r2 = r2 + r1
        L_0x008a:
            if (r1 >= r2) goto L_0x009a
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r3, r1, r7)
            long r4 = r7.zzbzf
            long r4 = com.google.android.gms.internal.firebase_ml.zzvc.zzv(r4)
            r11.zzag(r4)
            goto L_0x008a
        L_0x009a:
            if (r1 != r2) goto L_0x009e
            goto L_0x0423
        L_0x009e:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzui()
            throw r1
        L_0x00a3:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.firebase_ml.zzwu r11 = (com.google.android.gms.internal.firebase_ml.zzwu) r11
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r3, r4, r7)
            long r8 = r7.zzbzf
            long r8 = com.google.android.gms.internal.firebase_ml.zzvc.zzv(r8)
            r11.zzag(r8)
        L_0x00b4:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r1, r7)
            int r6 = r7.zzbze
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r3, r4, r7)
            long r8 = r7.zzbzf
            long r8 = com.google.android.gms.internal.firebase_ml.zzvc.zzv(r8)
            r11.zzag(r8)
            goto L_0x00b4
        L_0x00cc:
            if (r6 != r10) goto L_0x00f0
            com.google.android.gms.internal.firebase_ml.zzvz r11 = (com.google.android.gms.internal.firebase_ml.zzvz) r11
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r2 = r7.zzbze
            int r2 = r2 + r1
        L_0x00d7:
            if (r1 >= r2) goto L_0x00e7
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r1, r7)
            int r4 = r7.zzbze
            int r4 = com.google.android.gms.internal.firebase_ml.zzvc.zzcw(r4)
            r11.zzdo(r4)
            goto L_0x00d7
        L_0x00e7:
            if (r1 != r2) goto L_0x00eb
            goto L_0x0423
        L_0x00eb:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzui()
            throw r1
        L_0x00f0:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.firebase_ml.zzvz r11 = (com.google.android.gms.internal.firebase_ml.zzvz) r11
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r4 = r7.zzbze
            int r4 = com.google.android.gms.internal.firebase_ml.zzvc.zzcw(r4)
            r11.zzdo(r4)
        L_0x0101:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r1, r7)
            int r6 = r7.zzbze
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r4 = r7.zzbze
            int r4 = com.google.android.gms.internal.firebase_ml.zzvc.zzcw(r4)
            r11.zzdo(r4)
            goto L_0x0101
        L_0x0119:
            if (r6 != r10) goto L_0x0120
            int r2 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r11, r7)
            goto L_0x0131
        L_0x0120:
            if (r6 != 0) goto L_0x0422
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.firebase_ml.zzum.zza(r2, r3, r4, r5, r6, r7)
        L_0x0131:
            com.google.android.gms.internal.firebase_ml.zzvx r1 = (com.google.android.gms.internal.firebase_ml.zzvx) r1
            com.google.android.gms.internal.firebase_ml.zzyv r3 = r1.zzcdg
            com.google.android.gms.internal.firebase_ml.zzyv r4 = com.google.android.gms.internal.firebase_ml.zzyv.zzwc()
            if (r3 != r4) goto L_0x013c
            r3 = 0
        L_0x013c:
            com.google.android.gms.internal.firebase_ml.zzwd r4 = r0.zzdr(r8)
            com.google.android.gms.internal.firebase_ml.zzys<?, ?> r5 = r0.zzcgh
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.zzyc.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.firebase_ml.zzyv r3 = (com.google.android.gms.internal.firebase_ml.zzyv) r3
            if (r3 == 0) goto L_0x014e
            r1.zzcdg = r3
        L_0x014e:
            r1 = r2
            goto L_0x0423
        L_0x0151:
            if (r6 != r10) goto L_0x0422
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r4 = r7.zzbze
            if (r4 < 0) goto L_0x01a4
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x019f
            if (r4 != 0) goto L_0x0167
            com.google.android.gms.internal.firebase_ml.zzuq r4 = com.google.android.gms.internal.firebase_ml.zzuq.zzbzh
            r11.add(r4)
            goto L_0x016f
        L_0x0167:
            com.google.android.gms.internal.firebase_ml.zzuq r6 = com.google.android.gms.internal.firebase_ml.zzuq.zzb(r3, r1, r4)
            r11.add(r6)
        L_0x016e:
            int r1 = r1 + r4
        L_0x016f:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r1, r7)
            int r6 = r7.zzbze
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r4 = r7.zzbze
            if (r4 < 0) goto L_0x019a
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0195
            if (r4 != 0) goto L_0x018d
            com.google.android.gms.internal.firebase_ml.zzuq r4 = com.google.android.gms.internal.firebase_ml.zzuq.zzbzh
            r11.add(r4)
            goto L_0x016f
        L_0x018d:
            com.google.android.gms.internal.firebase_ml.zzuq r6 = com.google.android.gms.internal.firebase_ml.zzuq.zzb(r3, r1, r4)
            r11.add(r6)
            goto L_0x016e
        L_0x0195:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzui()
            throw r1
        L_0x019a:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzuj()
            throw r1
        L_0x019f:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzui()
            throw r1
        L_0x01a4:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzuj()
            throw r1
        L_0x01a9:
            if (r6 != r10) goto L_0x0422
            com.google.android.gms.internal.firebase_ml.zzya r1 = r0.zzdp(r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x0423
        L_0x01c3:
            if (r6 != r10) goto L_0x0422
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            int r1 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x0216
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r4 = r7.zzbze
            if (r4 < 0) goto L_0x0211
            if (r4 != 0) goto L_0x01de
            r11.add(r6)
            goto L_0x01e9
        L_0x01de:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.firebase_ml.zzvy.UTF_8
            r8.<init>(r3, r1, r4, r9)
            r11.add(r8)
        L_0x01e8:
            int r1 = r1 + r4
        L_0x01e9:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r1, r7)
            int r8 = r7.zzbze
            if (r2 != r8) goto L_0x0423
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r4 = r7.zzbze
            if (r4 < 0) goto L_0x020c
            if (r4 != 0) goto L_0x0201
            r11.add(r6)
            goto L_0x01e9
        L_0x0201:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.firebase_ml.zzvy.UTF_8
            r8.<init>(r3, r1, r4, r9)
            r11.add(r8)
            goto L_0x01e8
        L_0x020c:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzuj()
            throw r1
        L_0x0211:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzuj()
            throw r1
        L_0x0216:
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r4 = r7.zzbze
            if (r4 < 0) goto L_0x0271
            if (r4 != 0) goto L_0x0224
            r11.add(r6)
            goto L_0x0237
        L_0x0224:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.firebase_ml.zzzb.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x026c
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.firebase_ml.zzvy.UTF_8
            r9.<init>(r3, r1, r4, r10)
            r11.add(r9)
        L_0x0236:
            r1 = r8
        L_0x0237:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r1, r7)
            int r8 = r7.zzbze
            if (r2 != r8) goto L_0x0423
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r4 = r7.zzbze
            if (r4 < 0) goto L_0x0267
            if (r4 != 0) goto L_0x024f
            r11.add(r6)
            goto L_0x0237
        L_0x024f:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.firebase_ml.zzzb.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0262
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.firebase_ml.zzvy.UTF_8
            r9.<init>(r3, r1, r4, r10)
            r11.add(r9)
            goto L_0x0236
        L_0x0262:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzun()
            throw r1
        L_0x0267:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzuj()
            throw r1
        L_0x026c:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzun()
            throw r1
        L_0x0271:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzuj()
            throw r1
        L_0x0276:
            r1 = 0
            if (r6 != r10) goto L_0x029e
            com.google.android.gms.internal.firebase_ml.zzuo r11 = (com.google.android.gms.internal.firebase_ml.zzuo) r11
            int r2 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r4 = r7.zzbze
            int r4 = r4 + r2
        L_0x0282:
            if (r2 >= r4) goto L_0x0295
            int r2 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r3, r2, r7)
            long r5 = r7.zzbzf
            int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r5 == 0) goto L_0x0290
            r5 = r13
            goto L_0x0291
        L_0x0290:
            r5 = r1
        L_0x0291:
            r11.addBoolean(r5)
            goto L_0x0282
        L_0x0295:
            if (r2 != r4) goto L_0x0299
            goto L_0x014e
        L_0x0299:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzui()
            throw r1
        L_0x029e:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.firebase_ml.zzuo r11 = (com.google.android.gms.internal.firebase_ml.zzuo) r11
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r3, r4, r7)
            long r8 = r7.zzbzf
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = r13
            goto L_0x02af
        L_0x02ae:
            r6 = r1
        L_0x02af:
            r11.addBoolean(r6)
        L_0x02b2:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r8 = r7.zzbze
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r3, r6, r7)
            long r8 = r7.zzbzf
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02c8
            r6 = r13
            goto L_0x02c9
        L_0x02c8:
            r6 = r1
        L_0x02c9:
            r11.addBoolean(r6)
            goto L_0x02b2
        L_0x02cd:
            if (r6 != r10) goto L_0x02ed
            com.google.android.gms.internal.firebase_ml.zzvz r11 = (com.google.android.gms.internal.firebase_ml.zzvz) r11
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r2 = r7.zzbze
            int r2 = r2 + r1
        L_0x02d8:
            if (r1 >= r2) goto L_0x02e4
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r1)
            r11.zzdo(r4)
            int r1 = r1 + 4
            goto L_0x02d8
        L_0x02e4:
            if (r1 != r2) goto L_0x02e8
            goto L_0x0423
        L_0x02e8:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzui()
            throw r1
        L_0x02ed:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.firebase_ml.zzvz r11 = (com.google.android.gms.internal.firebase_ml.zzvz) r11
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r18, r19)
            r11.zzdo(r1)
        L_0x02f8:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r1, r7)
            int r6 = r7.zzbze
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4)
            r11.zzdo(r1)
            goto L_0x02f8
        L_0x030c:
            if (r6 != r10) goto L_0x032c
            com.google.android.gms.internal.firebase_ml.zzwu r11 = (com.google.android.gms.internal.firebase_ml.zzwu) r11
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r2 = r7.zzbze
            int r2 = r2 + r1
        L_0x0317:
            if (r1 >= r2) goto L_0x0323
            long r4 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r3, r1)
            r11.zzag(r4)
            int r1 = r1 + 8
            goto L_0x0317
        L_0x0323:
            if (r1 != r2) goto L_0x0327
            goto L_0x0423
        L_0x0327:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzui()
            throw r1
        L_0x032c:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.firebase_ml.zzwu r11 = (com.google.android.gms.internal.firebase_ml.zzwu) r11
            long r8 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r18, r19)
            r11.zzag(r8)
        L_0x0337:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r1, r7)
            int r6 = r7.zzbze
            if (r2 != r6) goto L_0x0423
            long r8 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r3, r4)
            r11.zzag(r8)
            goto L_0x0337
        L_0x034b:
            if (r6 != r10) goto L_0x0353
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r11, r7)
            goto L_0x0423
        L_0x0353:
            if (r6 != 0) goto L_0x0422
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r21, r22, r23, r24, r25, r26)
            goto L_0x0423
        L_0x0365:
            if (r6 != r10) goto L_0x0385
            com.google.android.gms.internal.firebase_ml.zzwu r11 = (com.google.android.gms.internal.firebase_ml.zzwu) r11
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r2 = r7.zzbze
            int r2 = r2 + r1
        L_0x0370:
            if (r1 >= r2) goto L_0x037c
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r3, r1, r7)
            long r4 = r7.zzbzf
            r11.zzag(r4)
            goto L_0x0370
        L_0x037c:
            if (r1 != r2) goto L_0x0380
            goto L_0x0423
        L_0x0380:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzui()
            throw r1
        L_0x0385:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.firebase_ml.zzwu r11 = (com.google.android.gms.internal.firebase_ml.zzwu) r11
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r3, r4, r7)
            long r8 = r7.zzbzf
            r11.zzag(r8)
        L_0x0392:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r1, r7)
            int r6 = r7.zzbze
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r3, r4, r7)
            long r8 = r7.zzbzf
            r11.zzag(r8)
            goto L_0x0392
        L_0x03a6:
            if (r6 != r10) goto L_0x03c5
            com.google.android.gms.internal.firebase_ml.zzvw r11 = (com.google.android.gms.internal.firebase_ml.zzvw) r11
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r2 = r7.zzbze
            int r2 = r2 + r1
        L_0x03b1:
            if (r1 >= r2) goto L_0x03bd
            float r4 = com.google.android.gms.internal.firebase_ml.zzum.zzd(r3, r1)
            r11.zzs(r4)
            int r1 = r1 + 4
            goto L_0x03b1
        L_0x03bd:
            if (r1 != r2) goto L_0x03c0
            goto L_0x0423
        L_0x03c0:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzui()
            throw r1
        L_0x03c5:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.firebase_ml.zzvw r11 = (com.google.android.gms.internal.firebase_ml.zzvw) r11
            float r1 = com.google.android.gms.internal.firebase_ml.zzum.zzd(r18, r19)
            r11.zzs(r1)
        L_0x03d0:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r1, r7)
            int r6 = r7.zzbze
            if (r2 != r6) goto L_0x0423
            float r1 = com.google.android.gms.internal.firebase_ml.zzum.zzd(r3, r4)
            r11.zzs(r1)
            goto L_0x03d0
        L_0x03e4:
            if (r6 != r10) goto L_0x0403
            com.google.android.gms.internal.firebase_ml.zzvi r11 = (com.google.android.gms.internal.firebase_ml.zzvi) r11
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r4, r7)
            int r2 = r7.zzbze
            int r2 = r2 + r1
        L_0x03ef:
            if (r1 >= r2) goto L_0x03fb
            double r4 = com.google.android.gms.internal.firebase_ml.zzum.zzc(r3, r1)
            r11.zze(r4)
            int r1 = r1 + 8
            goto L_0x03ef
        L_0x03fb:
            if (r1 != r2) goto L_0x03fe
            goto L_0x0423
        L_0x03fe:
            com.google.android.gms.internal.firebase_ml.zzwg r1 = com.google.android.gms.internal.firebase_ml.zzwg.zzui()
            throw r1
        L_0x0403:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.firebase_ml.zzvi r11 = (com.google.android.gms.internal.firebase_ml.zzvi) r11
            double r8 = com.google.android.gms.internal.firebase_ml.zzum.zzc(r18, r19)
            r11.zze(r8)
        L_0x040e:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.firebase_ml.zzum.zza(r3, r1, r7)
            int r6 = r7.zzbze
            if (r2 != r6) goto L_0x0423
            double r8 = com.google.android.gms.internal.firebase_ml.zzum.zzc(r3, r4)
            r11.zze(r8)
            goto L_0x040e
        L_0x0422:
            r1 = r4
        L_0x0423:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzxk.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.firebase_ml.zzup):int");
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.firebase_ml.zzup r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = com.google.android.gms.internal.firebase_ml.zzxk.zzcfs
            java.lang.Object r12 = r7.zzdq(r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.firebase_ml.zzxd r2 = r7.zzcgj
            boolean r2 = r2.zzx(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.firebase_ml.zzxd r2 = r7.zzcgj
            java.lang.Object r2 = r2.zzz(r12)
            com.google.android.gms.internal.firebase_ml.zzxd r3 = r7.zzcgj
            r3.zzd(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.firebase_ml.zzxd r8 = r7.zzcgj
            com.google.android.gms.internal.firebase_ml.zzxb r8 = r8.zzv(r12)
            com.google.android.gms.internal.firebase_ml.zzxd r12 = r7.zzcgj
            java.util.Map r12 = r12.zzu(r1)
            int r10 = com.google.android.gms.internal.firebase_ml.zzum.zza(r9, r10, r15)
            int r13 = r15.zzbze
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzcfm
            V r0 = r8.zzcfo
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zza(r10, r9, r1, r15)
            int r10 = r15.zzbze
        L_0x004c:
            r2 = r1
            int r1 = r10 >>> 3
            r3 = r10 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0072
            r4 = 2
            if (r1 == r4) goto L_0x0058
            goto L_0x0087
        L_0x0058:
            com.google.android.gms.internal.firebase_ml.zzzj r1 = r8.zzcfn
            int r1 = r1.zzwm()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.firebase_ml.zzzj r4 = r8.zzcfn
            V r10 = r8.zzcfo
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza(r1, r2, r3, r4, r5, r6)
            java.lang.Object r0 = r15.zzbzg
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.firebase_ml.zzzj r1 = r8.zzcfl
            int r1 = r1.zzwm()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.firebase_ml.zzzj r4 = r8.zzcfl
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza(r1, r2, r3, r4, r5, r6)
            java.lang.Object r14 = r15.zzbzg
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.firebase_ml.zzum.zza(r10, r9, r2, r11, r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.firebase_ml.zzwg r8 = com.google.android.gms.internal.firebase_ml.zzwg.zzum()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.firebase_ml.zzwg r8 = com.google.android.gms.internal.firebase_ml.zzwg.zzui()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzxk.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.firebase_ml.zzup):int");
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzup zzup) throws IOException {
        int i9;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i10 = i;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        long j2 = j;
        int i14 = i8;
        zzup zzup2 = zzup;
        Unsafe unsafe = zzcfs;
        long j3 = (long) (this.zzcft[i14 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i13 == 1) {
                    unsafe.putObject(t2, j2, Double.valueOf(zzum.zzc(bArr, i)));
                    i9 = i10 + 8;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 52:
                if (i13 == 5) {
                    unsafe.putObject(t2, j2, Float.valueOf(zzum.zzd(bArr, i)));
                    i9 = i10 + 4;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 53:
            case 54:
                if (i13 == 0) {
                    i9 = zzum.zzb(bArr2, i10, zzup2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzup2.zzbzf));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 55:
            case 62:
                if (i13 == 0) {
                    i9 = zzum.zza(bArr2, i10, zzup2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzup2.zzbze));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 56:
            case 65:
                if (i13 == 1) {
                    unsafe.putObject(t2, j2, Long.valueOf(zzum.zzb(bArr, i)));
                    i9 = i10 + 8;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 57:
            case 64:
                if (i13 == 5) {
                    unsafe.putObject(t2, j2, Integer.valueOf(zzum.zza(bArr, i)));
                    i9 = i10 + 4;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 58:
                if (i13 == 0) {
                    i9 = zzum.zzb(bArr2, i10, zzup2);
                    unsafe.putObject(t2, j2, Boolean.valueOf(zzup2.zzbzf != 0));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 59:
                if (i13 == 2) {
                    int zza = zzum.zza(bArr2, i10, zzup2);
                    int i15 = zzup2.zzbze;
                    if (i15 == 0) {
                        unsafe.putObject(t2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zzzb.zzf(bArr2, zza, zza + i15)) {
                        unsafe.putObject(t2, j2, new String(bArr2, zza, i15, zzvy.UTF_8));
                        zza += i15;
                    } else {
                        throw zzwg.zzun();
                    }
                    unsafe.putInt(t2, j3, i12);
                    return zza;
                }
                return i10;
            case 60:
                if (i13 == 2) {
                    int zza2 = zzum.zza(zzdp(i14), bArr2, i10, i2, zzup2);
                    Object object = unsafe.getInt(t2, j3) == i12 ? unsafe.getObject(t2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t2, j2, zzup2.zzbzg);
                    } else {
                        unsafe.putObject(t2, j2, zzvy.zzc(object, zzup2.zzbzg));
                    }
                    unsafe.putInt(t2, j3, i12);
                    return zza2;
                }
                return i10;
            case 61:
                if (i13 == 2) {
                    i9 = zzum.zze(bArr2, i10, zzup2);
                    unsafe.putObject(t2, j2, zzup2.zzbzg);
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 63:
                if (i13 == 0) {
                    int zza3 = zzum.zza(bArr2, i10, zzup2);
                    int i16 = zzup2.zzbze;
                    zzwd zzdr = zzdr(i14);
                    if (zzdr == null || zzdr.zzb(i16)) {
                        unsafe.putObject(t2, j2, Integer.valueOf(i16));
                        i9 = zza3;
                        unsafe.putInt(t2, j3, i12);
                        return i9;
                    }
                    zzab(t).zzb(i11, Long.valueOf((long) i16));
                    return zza3;
                }
                return i10;
            case 66:
                if (i13 == 0) {
                    i9 = zzum.zza(bArr2, i10, zzup2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzvc.zzcw(zzup2.zzbze)));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 67:
                if (i13 == 0) {
                    i9 = zzum.zzb(bArr2, i10, zzup2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzvc.zzv(zzup2.zzbzf)));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 68:
                if (i13 == 3) {
                    i9 = zzum.zza(zzdp(i14), bArr, i, i2, (i11 & -8) | 4, zzup);
                    Object object2 = unsafe.getInt(t2, j3) == i12 ? unsafe.getObject(t2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t2, j2, zzup2.zzbzg);
                    } else {
                        unsafe.putObject(t2, j2, zzvy.zzc(object2, zzup2.zzbzg));
                    }
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            default:
                return i10;
        }
    }

    private final zzya zzdp(int i) {
        int i2 = (i / 3) << 1;
        zzya zzya = (zzya) this.zzcfu[i2];
        if (zzya != null) {
            return zzya;
        }
        zzya zzl = zzxv.zzvk().zzl((Class) this.zzcfu[i2 + 1]);
        this.zzcfu[i2] = zzl;
        return zzl;
    }

    private final Object zzdq(int i) {
        return this.zzcfu[(i / 3) << 1];
    }

    private final zzwd zzdr(int i) {
        return (zzwd) this.zzcfu[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Type inference failed for: r35v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v27, types: [int] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x036d, code lost:
        if (r0 == r15) goto L_0x03e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03b6, code lost:
        if (r0 == r15) goto L_0x03e0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r31, byte[] r32, int r33, int r34, int r35, com.google.android.gms.internal.firebase_ml.zzup r36) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            sun.misc.Unsafe r10 = com.google.android.gms.internal.firebase_ml.zzxk.zzcfs
            r16 = 0
            r0 = r33
            r2 = r16
            r3 = r2
            r6 = r3
            r1 = -1
            r7 = -1
        L_0x0018:
            r17 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 >= r13) goto L_0x0480
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r0, r12, r3, r9)
            int r3 = r9.zzbze
            r4 = r0
            r5 = r3
            goto L_0x002e
        L_0x002c:
            r5 = r0
            r4 = r3
        L_0x002e:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x003b
            int r2 = r2 / r8
            int r1 = r15.zzu(r3, r2)
            goto L_0x003f
        L_0x003b:
            int r1 = r15.zzdu(r3)
        L_0x003f:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004e
            r25 = r3
            r2 = r4
            r9 = r5
            r27 = r10
            r8 = r11
            r19 = r16
            goto L_0x03e4
        L_0x004e:
            int[] r1 = r15.zzcft
            int r19 = r2 + 1
            r8 = r1[r19]
            r19 = 267386880(0xff00000, float:2.3665827E-29)
            r19 = r8 & r19
            int r11 = r19 >>> 20
            r19 = r5
            r5 = r8 & r17
            long r12 = (long) r5
            r5 = 17
            r20 = r8
            if (r11 > r5) goto L_0x02d7
            int r5 = r2 + 2
            r1 = r1[r5]
            int r5 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r5
            r1 = r1 & r17
            r5 = -1
            if (r1 == r7) goto L_0x007f
            if (r7 == r5) goto L_0x0079
            long r8 = (long) r7
            r10.putInt(r14, r8, r6)
        L_0x0079:
            long r6 = (long) r1
            int r6 = r10.getInt(r14, r6)
            r7 = r1
        L_0x007f:
            r1 = 5
            switch(r11) {
                case 0: goto L_0x02a1;
                case 1: goto L_0x0287;
                case 2: goto L_0x0261;
                case 3: goto L_0x0261;
                case 4: goto L_0x0246;
                case 5: goto L_0x0220;
                case 6: goto L_0x01fd;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01af;
                case 9: goto L_0x0179;
                case 10: goto L_0x015e;
                case 11: goto L_0x0246;
                case 12: goto L_0x012c;
                case 13: goto L_0x01fd;
                case 14: goto L_0x0220;
                case 15: goto L_0x0111;
                case 16: goto L_0x00e4;
                case 17: goto L_0x0092;
                default: goto L_0x0083;
            }
        L_0x0083:
            r12 = r32
            r13 = r36
            r9 = r2
            r11 = r3
            r33 = r7
            r8 = r19
            r7 = r4
            r19 = r5
            goto L_0x02c9
        L_0x0092:
            r8 = 3
            if (r0 != r8) goto L_0x00d8
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.firebase_ml.zzya r0 = r15.zzdp(r2)
            r1 = r32
            r9 = r2
            r2 = r4
            r11 = r3
            r3 = r34
            r4 = r8
            r8 = r19
            r19 = r5
            r5 = r36
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00bb
            r5 = r36
            java.lang.Object r1 = r5.zzbzg
            r10.putObject(r14, r12, r1)
            goto L_0x00ca
        L_0x00bb:
            r5 = r36
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r5.zzbzg
            java.lang.Object r1 = com.google.android.gms.internal.firebase_ml.zzvy.zzc(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x00ca:
            r6 = r6 | r22
            r12 = r32
            r13 = r34
            r3 = r8
            r2 = r9
            r1 = r11
            r11 = r35
            r9 = r5
            goto L_0x0018
        L_0x00d8:
            r9 = r2
            r11 = r3
            r8 = r19
            r19 = r5
            r12 = r32
            r13 = r36
            goto L_0x0241
        L_0x00e4:
            r9 = r2
            r11 = r3
            r8 = r19
            r19 = r5
            r5 = r36
            if (r0 != 0) goto L_0x010c
            r2 = r12
            r12 = r32
            int r13 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r12, r4, r5)
            long r0 = r5.zzbzf
            long r17 = com.google.android.gms.internal.firebase_ml.zzvc.zzv(r0)
            r0 = r10
            r1 = r31
            r33 = r13
            r13 = r5
            r4 = r17
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r33
            goto L_0x02bf
        L_0x010c:
            r12 = r32
            r13 = r5
            goto L_0x0241
        L_0x0111:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r12 = r32
            r13 = r36
            r19 = r5
            if (r0 != 0) goto L_0x0241
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r12, r4, r13)
            int r1 = r13.zzbze
            int r1 = com.google.android.gms.internal.firebase_ml.zzvc.zzcw(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x0175
        L_0x012c:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r12 = r32
            r13 = r36
            r19 = r5
            if (r0 != 0) goto L_0x0241
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r12, r4, r13)
            int r1 = r13.zzbze
            com.google.android.gms.internal.firebase_ml.zzwd r4 = r15.zzdr(r9)
            if (r4 == 0) goto L_0x015a
            boolean r4 = r4.zzb(r1)
            if (r4 == 0) goto L_0x014c
            goto L_0x015a
        L_0x014c:
            com.google.android.gms.internal.firebase_ml.zzyv r2 = zzab(r31)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzb(r8, r1)
            goto L_0x02bf
        L_0x015a:
            r10.putInt(r14, r2, r1)
            goto L_0x0175
        L_0x015e:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r12 = r32
            r13 = r36
            r19 = r5
            if (r0 != r1) goto L_0x0241
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zze(r12, r4, r13)
            java.lang.Object r1 = r13.zzbzg
            r10.putObject(r14, r2, r1)
        L_0x0175:
            r6 = r6 | r22
            goto L_0x02bf
        L_0x0179:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r12 = r32
            r13 = r36
            r19 = r5
            if (r0 != r1) goto L_0x01ab
            com.google.android.gms.internal.firebase_ml.zzya r0 = r15.zzdp(r9)
            r5 = r34
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r0, r12, r4, r5, r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x019c
            java.lang.Object r1 = r13.zzbzg
            r10.putObject(r14, r2, r1)
            goto L_0x0215
        L_0x019c:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r13.zzbzg
            java.lang.Object r1 = com.google.android.gms.internal.firebase_ml.zzvy.zzc(r1, r4)
            r10.putObject(r14, r2, r1)
            goto L_0x0215
        L_0x01ab:
            r5 = r34
            goto L_0x0241
        L_0x01af:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r12 = r32
            r13 = r36
            r19 = r5
            r5 = r34
            if (r0 != r1) goto L_0x0241
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zzc(r12, r4, r13)
            goto L_0x01ce
        L_0x01ca:
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zzd(r12, r4, r13)
        L_0x01ce:
            java.lang.Object r1 = r13.zzbzg
            r10.putObject(r14, r2, r1)
            goto L_0x0215
        L_0x01d4:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r12 = r32
            r13 = r36
            r19 = r5
            r5 = r34
            if (r0 != 0) goto L_0x0241
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r12, r4, r13)
            r33 = r0
            long r0 = r13.zzbzf
            r20 = 0
            int r0 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x01f3
            r0 = 1
            goto L_0x01f5
        L_0x01f3:
            r0 = r16
        L_0x01f5:
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r14, r2, r0)
            r6 = r6 | r22
            r0 = r33
            goto L_0x0217
        L_0x01fd:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r12 = r32
            r13 = r36
            r19 = r5
            r5 = r34
            if (r0 != r1) goto L_0x0241
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
        L_0x0215:
            r6 = r6 | r22
        L_0x0217:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r35
            r13 = r5
            goto L_0x0018
        L_0x0220:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 1
            r12 = r32
            r13 = r36
            r19 = r5
            r5 = r34
            if (r0 != r1) goto L_0x0241
            long r17 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r12, r4)
            r0 = r10
            r1 = r31
            r33 = r7
            r7 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            goto L_0x02b9
        L_0x0241:
            r33 = r7
            r7 = r4
            goto L_0x02c9
        L_0x0246:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r19
            r12 = r32
            r13 = r36
            r7 = r4
            r19 = r5
            if (r0 != 0) goto L_0x02c9
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r12, r7, r13)
            int r1 = r13.zzbze
            r10.putInt(r14, r2, r1)
            goto L_0x02bb
        L_0x0261:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r19
            r12 = r32
            r13 = r36
            r7 = r4
            r19 = r5
            if (r0 != 0) goto L_0x02c9
            int r7 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r12, r7, r13)
            long r4 = r13.zzbzf
            r0 = r10
            r1 = r31
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r7
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r7 = r33
            goto L_0x02c3
        L_0x0287:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r19
            r12 = r32
            r13 = r36
            r7 = r4
            r19 = r5
            if (r0 != r1) goto L_0x02c9
            float r0 = com.google.android.gms.internal.firebase_ml.zzum.zzd(r12, r7)
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r14, r2, r0)
            int r0 = r7 + 4
            goto L_0x02bb
        L_0x02a1:
            r9 = r2
            r11 = r3
            r33 = r7
            r2 = r12
            r8 = r19
            r1 = 1
            r12 = r32
            r13 = r36
            r7 = r4
            r19 = r5
            if (r0 != r1) goto L_0x02c9
            double r0 = com.google.android.gms.internal.firebase_ml.zzum.zzc(r12, r7)
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r14, r2, r0)
        L_0x02b9:
            int r0 = r7 + 8
        L_0x02bb:
            r6 = r6 | r22
            r7 = r33
        L_0x02bf:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
        L_0x02c3:
            r13 = r34
            r11 = r35
            goto L_0x0018
        L_0x02c9:
            r2 = r7
            r19 = r9
            r27 = r10
            r25 = r11
            r7 = r33
            r9 = r8
            r8 = r35
            goto L_0x03e4
        L_0x02d7:
            r5 = r3
            r18 = r7
            r8 = r19
            r19 = -1
            r7 = r4
            r28 = r12
            r12 = r32
            r13 = r9
            r9 = r2
            r2 = r28
            r1 = 27
            if (r11 != r1) goto L_0x033c
            r1 = 2
            if (r0 != r1) goto L_0x032f
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.firebase_ml.zzwh r0 = (com.google.android.gms.internal.firebase_ml.zzwh) r0
            boolean r1 = r0.zzso()
            if (r1 != 0) goto L_0x030c
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0303
            r1 = 10
            goto L_0x0305
        L_0x0303:
            int r1 = r1 << 1
        L_0x0305:
            com.google.android.gms.internal.firebase_ml.zzwh r0 = r0.zzcr(r1)
            r10.putObject(r14, r2, r0)
        L_0x030c:
            r11 = r0
            com.google.android.gms.internal.firebase_ml.zzya r0 = r15.zzdp(r9)
            r1 = r8
            r2 = r32
            r3 = r7
            r4 = r34
            r7 = r5
            r5 = r11
            r22 = r6
            r6 = r36
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r0, r1, r2, r3, r4, r5, r6)
            r11 = r35
            r1 = r7
            r3 = r8
            r2 = r9
            r9 = r13
            r7 = r18
            r6 = r22
            r13 = r34
            goto L_0x0018
        L_0x032f:
            r22 = r6
            r25 = r5
            r15 = r7
            r26 = r8
            r19 = r9
            r27 = r10
            goto L_0x03b9
        L_0x033c:
            r22 = r6
            r6 = r5
            r1 = 49
            if (r11 > r1) goto L_0x038b
            r5 = r20
            long r4 = (long) r5
            r1 = r0
            r0 = r30
            r33 = r1
            r1 = r31
            r23 = r2
            r2 = r32
            r3 = r7
            r20 = r4
            r4 = r34
            r5 = r8
            r25 = r6
            r15 = r7
            r7 = r33
            r26 = r8
            r8 = r9
            r19 = r9
            r27 = r10
            r9 = r20
            r12 = r23
            r14 = r36
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 != r15) goto L_0x0371
            goto L_0x03e0
        L_0x0371:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            r7 = r18
            r2 = r19
            r6 = r22
            r1 = r25
            r3 = r26
            r10 = r27
            goto L_0x0018
        L_0x038b:
            r33 = r0
            r23 = r2
            r25 = r6
            r15 = r7
            r26 = r8
            r19 = r9
            r27 = r10
            r5 = r20
            r0 = 50
            if (r11 != r0) goto L_0x03c3
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x03b9
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r23
            r8 = r36
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r8)
            if (r0 != r15) goto L_0x0371
            goto L_0x03e0
        L_0x03b9:
            r8 = r35
            r2 = r15
        L_0x03bc:
            r7 = r18
            r6 = r22
            r9 = r26
            goto L_0x03e4
        L_0x03c3:
            r7 = r33
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r8 = r5
            r5 = r26
            r6 = r25
            r9 = r11
            r10 = r23
            r12 = r19
            r13 = r36
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r15) goto L_0x0464
        L_0x03e0:
            r8 = r35
            r2 = r0
            goto L_0x03bc
        L_0x03e4:
            if (r9 != r8) goto L_0x03f2
            if (r8 != 0) goto L_0x03e9
            goto L_0x03f2
        L_0x03e9:
            r1 = -1
            r10 = r30
            r13 = r31
            r0 = r7
            r7 = r2
            goto L_0x048e
        L_0x03f2:
            r10 = r30
            boolean r0 = r10.zzcfy
            if (r0 == 0) goto L_0x043f
            r11 = r36
            com.google.android.gms.internal.firebase_ml.zzvk r0 = r11.zzkj
            com.google.android.gms.internal.firebase_ml.zzvk r1 = com.google.android.gms.internal.firebase_ml.zzvk.zzth()
            if (r0 == r1) goto L_0x043c
            com.google.android.gms.internal.firebase_ml.zzxg r0 = r10.zzcfx
            com.google.android.gms.internal.firebase_ml.zzvk r1 = r11.zzkj
            r12 = r25
            com.google.android.gms.internal.firebase_ml.zzvx$zzg r0 = r1.zza(r0, r12)
            if (r0 != 0) goto L_0x042c
            com.google.android.gms.internal.firebase_ml.zzyv r4 = zzab(r31)
            r0 = r9
            r1 = r32
            r3 = r34
            r5 = r36
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r0, r1, r2, r3, r4, r5)
            r14 = r31
            r13 = r34
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r2 = r19
            r10 = r27
            r12 = r32
            goto L_0x0461
        L_0x042c:
            r13 = r31
            r0 = r13
            com.google.android.gms.internal.firebase_ml.zzvx$zze r0 = (com.google.android.gms.internal.firebase_ml.zzvx.zze) r0
            r0.zzug()
            com.google.android.gms.internal.firebase_ml.zzvq<com.google.android.gms.internal.firebase_ml.zzvx$zzd> r0 = r0.zzcdj
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x043c:
            r13 = r31
            goto L_0x0443
        L_0x043f:
            r13 = r31
            r11 = r36
        L_0x0443:
            r12 = r25
            com.google.android.gms.internal.firebase_ml.zzyv r4 = zzab(r31)
            r0 = r9
            r1 = r32
            r3 = r34
            r5 = r36
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r0, r1, r2, r3, r4, r5)
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r14 = r13
            r2 = r19
            r10 = r27
            r12 = r32
            r13 = r34
        L_0x0461:
            r11 = r8
            goto L_0x0018
        L_0x0464:
            r12 = r25
            r9 = r26
            r15 = r30
            r14 = r31
            r13 = r34
            r11 = r35
            r3 = r9
            r1 = r12
            r7 = r18
            r2 = r19
            r6 = r22
            r10 = r27
            r12 = r32
            r9 = r36
            goto L_0x0018
        L_0x0480:
            r22 = r6
            r18 = r7
            r27 = r10
            r8 = r11
            r13 = r14
            r10 = r15
            r7 = r0
            r9 = r3
            r0 = r18
            r1 = -1
        L_0x048e:
            if (r0 == r1) goto L_0x0496
            long r0 = (long) r0
            r2 = r27
            r2.putInt(r13, r0, r6)
        L_0x0496:
            r0 = 0
            int r1 = r10.zzcgd
            r5 = r0
            r11 = r1
        L_0x049b:
            int r0 = r10.zzcge
            if (r11 >= r0) goto L_0x04cf
            int[] r0 = r10.zzcgc
            r1 = r0[r11]
            com.google.android.gms.internal.firebase_ml.zzys<?, ?> r6 = r10.zzcgh
            int[] r0 = r10.zzcft
            r2 = r0[r1]
            int r0 = r10.zzds(r1)
            r0 = r0 & r17
            long r3 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_ml.zzyy.zzp(r13, r3)
            if (r0 != 0) goto L_0x04b7
            goto L_0x04ca
        L_0x04b7:
            com.google.android.gms.internal.firebase_ml.zzwd r4 = r10.zzdr(r1)
            if (r4 != 0) goto L_0x04be
            goto L_0x04ca
        L_0x04be:
            com.google.android.gms.internal.firebase_ml.zzxd r3 = r10.zzcgj
            java.util.Map r3 = r3.zzu(r0)
            r0 = r30
            java.lang.Object r5 = r0.zza(r1, r2, r3, r4, r5, r6)
        L_0x04ca:
            com.google.android.gms.internal.firebase_ml.zzyv r5 = (com.google.android.gms.internal.firebase_ml.zzyv) r5
            int r11 = r11 + 1
            goto L_0x049b
        L_0x04cf:
            if (r5 == 0) goto L_0x04d6
            com.google.android.gms.internal.firebase_ml.zzys<?, ?> r0 = r10.zzcgh
            r0.zzh(r13, r5)
        L_0x04d6:
            if (r8 != 0) goto L_0x04e2
            r0 = r34
            if (r7 != r0) goto L_0x04dd
            goto L_0x04e8
        L_0x04dd:
            com.google.android.gms.internal.firebase_ml.zzwg r0 = com.google.android.gms.internal.firebase_ml.zzwg.zzum()
            throw r0
        L_0x04e2:
            r0 = r34
            if (r7 > r0) goto L_0x04e9
            if (r9 != r8) goto L_0x04e9
        L_0x04e8:
            return r7
        L_0x04e9:
            com.google.android.gms.internal.firebase_ml.zzwg r0 = com.google.android.gms.internal.firebase_ml.zzwg.zzum()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzxk.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.firebase_ml.zzup):int");
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, boolean):void
     arg types: [T, long, boolean]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(byte[], long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, float):void
     arg types: [T, long, float]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(byte[], long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, float):void */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01e4, code lost:
        if (r0 == r15) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0211, code lost:
        if (r0 == r15) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0230, code lost:
        if (r0 == r15) goto L_0x0232;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.firebase_ml.zzup r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.zzcga
            if (r0 == 0) goto L_0x0260
            sun.misc.Unsafe r9 = com.google.android.gms.internal.firebase_ml.zzxk.zzcfs
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = r10
            r2 = r16
        L_0x0018:
            if (r0 >= r13) goto L_0x0257
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002a
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r0, r12, r3, r11)
            int r3 = r11.zzbze
            r8 = r0
            r17 = r3
            goto L_0x002d
        L_0x002a:
            r17 = r0
            r8 = r3
        L_0x002d:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x003a
            int r2 = r2 / 3
            int r0 = r15.zzu(r7, r2)
            goto L_0x003e
        L_0x003a:
            int r0 = r15.zzdu(r7)
        L_0x003e:
            r4 = r0
            if (r4 != r10) goto L_0x004c
            r24 = r7
            r2 = r8
            r18 = r9
            r26 = r10
            r19 = r16
            goto L_0x0233
        L_0x004c:
            int[] r0 = r15.zzcft
            int r1 = r4 + 1
            r5 = r0[r1]
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r3 = r0 >>> 20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r1 = (long) r0
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x016a
            r0 = 1
            switch(r3) {
                case 0: goto L_0x0150;
                case 1: goto L_0x0141;
                case 2: goto L_0x012f;
                case 3: goto L_0x012f;
                case 4: goto L_0x0121;
                case 5: goto L_0x0111;
                case 6: goto L_0x0100;
                case 7: goto L_0x00e9;
                case 8: goto L_0x00d2;
                case 9: goto L_0x00b1;
                case 10: goto L_0x00a4;
                case 11: goto L_0x0121;
                case 12: goto L_0x0095;
                case 13: goto L_0x0100;
                case 14: goto L_0x0111;
                case 15: goto L_0x0082;
                case 16: goto L_0x0067;
                default: goto L_0x0065;
            }
        L_0x0065:
            goto L_0x01a6
        L_0x0067:
            if (r6 != 0) goto L_0x01a6
            int r6 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r12, r8, r11)
            r19 = r1
            long r0 = r11.zzbzf
            long r21 = com.google.android.gms.internal.firebase_ml.zzvc.zzv(r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x013f
        L_0x0082:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0162
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r12, r8, r11)
            int r1 = r11.zzbze
            int r1 = com.google.android.gms.internal.firebase_ml.zzvc.zzcw(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x0095:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0162
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r12, r8, r11)
            int r1 = r11.zzbze
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x00a4:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zze(r12, r8, r11)
            java.lang.Object r1 = r11.zzbzg
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00b1:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            com.google.android.gms.internal.firebase_ml.zzya r0 = r15.zzdp(r4)
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r0, r12, r8, r13, r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00c8
            java.lang.Object r1 = r11.zzbzg
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00c8:
            java.lang.Object r5 = r11.zzbzg
            java.lang.Object r1 = com.google.android.gms.internal.firebase_ml.zzvy.zzc(r1, r5)
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00d2:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00df
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zzc(r12, r8, r11)
            goto L_0x00e3
        L_0x00df:
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zzd(r12, r8, r11)
        L_0x00e3:
            java.lang.Object r1 = r11.zzbzg
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00e9:
            r2 = r1
            if (r6 != 0) goto L_0x01a6
            int r1 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r12, r8, r11)
            long r5 = r11.zzbzf
            r19 = 0
            int r5 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r5 == 0) goto L_0x00f9
            goto L_0x00fb
        L_0x00f9:
            r0 = r16
        L_0x00fb:
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r14, r2, r0)
            r0 = r1
            goto L_0x010d
        L_0x0100:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x01a6
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x010d:
            r2 = r4
            r1 = r7
            goto L_0x015f
        L_0x0111:
            r2 = r1
            if (r6 != r0) goto L_0x01a6
            long r5 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            goto L_0x015b
        L_0x0121:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0162
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r12, r8, r11)
            int r1 = r11.zzbze
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x012f:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0162
            int r6 = com.google.android.gms.internal.firebase_ml.zzum.zzb(r12, r8, r11)
            long r4 = r11.zzbzf
            r0 = r9
            r1 = r28
            r0.putLong(r1, r2, r4)
        L_0x013f:
            r0 = r6
            goto L_0x015d
        L_0x0141:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x0162
            float r0 = com.google.android.gms.internal.firebase_ml.zzum.zzd(r12, r8)
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r14, r2, r0)
            int r0 = r8 + 4
            goto L_0x015d
        L_0x0150:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x0162
            double r0 = com.google.android.gms.internal.firebase_ml.zzum.zzc(r12, r8)
            com.google.android.gms.internal.firebase_ml.zzyy.zza(r14, r2, r0)
        L_0x015b:
            int r0 = r8 + 8
        L_0x015d:
            r1 = r7
            r2 = r10
        L_0x015f:
            r10 = -1
            goto L_0x0018
        L_0x0162:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x01ad
        L_0x016a:
            r0 = 27
            if (r3 != r0) goto L_0x01b1
            if (r6 != r10) goto L_0x01a6
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.android.gms.internal.firebase_ml.zzwh r0 = (com.google.android.gms.internal.firebase_ml.zzwh) r0
            boolean r3 = r0.zzso()
            if (r3 != 0) goto L_0x018e
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0185
            r3 = 10
            goto L_0x0187
        L_0x0185:
            int r3 = r3 << 1
        L_0x0187:
            com.google.android.gms.internal.firebase_ml.zzwh r0 = r0.zzcr(r3)
            r9.putObject(r14, r1, r0)
        L_0x018e:
            r5 = r0
            com.google.android.gms.internal.firebase_ml.zzya r0 = r15.zzdp(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x015f
        L_0x01a6:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x01ad:
            r26 = -1
            goto L_0x0214
        L_0x01b1:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01e7
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r25 = r10
            r26 = -1
            r9 = r22
            r11 = r25
            r12 = r20
            r14 = r32
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 != r15) goto L_0x0243
            goto L_0x0232
        L_0x01e7:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x0216
            r7 = r30
            if (r7 != r10) goto L_0x0214
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r8)
            if (r0 != r15) goto L_0x0243
            goto L_0x0232
        L_0x0214:
            r2 = r15
            goto L_0x0233
        L_0x0216:
            r7 = r30
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r15) goto L_0x0243
        L_0x0232:
            r2 = r0
        L_0x0233:
            com.google.android.gms.internal.firebase_ml.zzyv r4 = zzab(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.android.gms.internal.firebase_ml.zzum.zza(r0, r1, r2, r3, r4, r5)
        L_0x0243:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
            r10 = r26
            goto L_0x0018
        L_0x0257:
            r4 = r13
            if (r0 != r4) goto L_0x025b
            return
        L_0x025b:
            com.google.android.gms.internal.firebase_ml.zzwg r0 = com.google.android.gms.internal.firebase_ml.zzwg.zzum()
            throw r0
        L_0x0260:
            r4 = r13
            r5 = 0
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r6 = r32
            r0.zza(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzxk.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.firebase_ml.zzup):void");
    }

    public final void zzq(T t) {
        int i;
        int i2 = this.zzcgd;
        while (true) {
            i = this.zzcge;
            if (i2 >= i) {
                break;
            }
            long zzds = (long) (zzds(this.zzcgc[i2]) & 1048575);
            Object zzp = zzyy.zzp(t, zzds);
            if (zzp != null) {
                zzyy.zza(t, zzds, this.zzcgj.zzy(zzp));
            }
            i2++;
        }
        int length = this.zzcgc.length;
        while (i < length) {
            this.zzcgg.zzb(t, (long) this.zzcgc[i]);
            i++;
        }
        this.zzcgh.zzq(t);
        if (this.zzcfy) {
            this.zzcgi.zzq(t);
        }
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map map, zzwd zzwd, Object obj, zzys zzys) {
        zzxb<?, ?> zzv = this.zzcgj.zzv(zzdq(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zzwd.zzb(((Integer) entry.getValue()).intValue())) {
                if (obj == null) {
                    obj = zzys.zzwb();
                }
                zzuy zzcu = zzuq.zzcu(zzwy.zza(zzv, entry.getKey(), entry.getValue()));
                try {
                    zzwy.zza(zzcu.zztb(), zzv, entry.getKey(), entry.getValue());
                    zzys.zza(obj, i2, zzcu.zzta());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    public final boolean zzac(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.zzcgd) {
                return !this.zzcfy || this.zzcgi.zzo(t).isInitialized();
            }
            int i5 = this.zzcgc[i3];
            int i6 = this.zzcft[i5];
            int zzds = zzds(i5);
            if (!this.zzcga) {
                int i7 = this.zzcft[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = zzcfs.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzds) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzds) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza(t, zzds, zzdp(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzw = this.zzcgj.zzw(zzyy.zzp(t, (long) (zzds & 1048575)));
                            if (!zzw.isEmpty()) {
                                if (this.zzcgj.zzv(zzdq(i5)).zzcfn.zzwl() == zzzm.MESSAGE) {
                                    zzya zzya = null;
                                    Iterator<?> it = zzw.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzya == null) {
                                            zzya = zzxv.zzvk().zzl(next.getClass());
                                        }
                                        if (!zzya.zzac(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzyy.zzp(t, (long) (zzds & 1048575));
                if (!list.isEmpty()) {
                    zzya zzdp = zzdp(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzdp.zzac(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i5, i4, i) && !zza(t, zzds, zzdp(i5))) {
                return false;
            }
            i3++;
        }
    }

    private static boolean zza(Object obj, int i, zzya zzya) {
        return zzya.zzac(zzyy.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzzp zzzp) throws IOException {
        if (obj instanceof String) {
            zzzp.zzb(i, (String) obj);
        } else {
            zzzp.zza(i, (zzuq) obj);
        }
    }

    private final int zzds(int i) {
        return this.zzcft[i + 1];
    }

    private final int zzdt(int i) {
        return this.zzcft[i + 2];
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzyy.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzyy.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzyy.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzyy.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzyy.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzcga) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzcga) {
            int zzds = zzds(i);
            long j = (long) (zzds & 1048575);
            switch ((zzds & 267386880) >>> 20) {
                case 0:
                    return zzyy.zzo(t, j) != 0.0d;
                case 1:
                    return zzyy.zzn(t, j) != 0.0f;
                case 2:
                    return zzyy.zzl(t, j) != 0;
                case 3:
                    return zzyy.zzl(t, j) != 0;
                case 4:
                    return zzyy.zzk(t, j) != 0;
                case 5:
                    return zzyy.zzl(t, j) != 0;
                case 6:
                    return zzyy.zzk(t, j) != 0;
                case 7:
                    return zzyy.zzm(t, j);
                case 8:
                    Object zzp = zzyy.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzuq) {
                        return !zzuq.zzbzh.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzyy.zzp(t, j) != null;
                case 10:
                    return !zzuq.zzbzh.equals(zzyy.zzp(t, j));
                case 11:
                    return zzyy.zzk(t, j) != 0;
                case 12:
                    return zzyy.zzk(t, j) != 0;
                case 13:
                    return zzyy.zzk(t, j) != 0;
                case 14:
                    return zzyy.zzl(t, j) != 0;
                case 15:
                    return zzyy.zzk(t, j) != 0;
                case 16:
                    return zzyy.zzl(t, j) != 0;
                case 17:
                    return zzyy.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzdt = zzdt(i);
            return (zzyy.zzk(t, (long) (zzdt & 1048575)) & (1 << (zzdt >>> 20))) != 0;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, int):void
     arg types: [T, long, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(byte[], long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, int):void */
    private final void zzb(T t, int i) {
        if (!this.zzcga) {
            int zzdt = zzdt(i);
            long j = (long) (zzdt & 1048575);
            zzyy.zza((Object) t, j, zzyy.zzk(t, j) | (1 << (zzdt >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzyy.zzk(t, (long) (zzdt(i2) & 1048575)) == i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, int):void
     arg types: [T, long, int]
     candidates:
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(byte[], long, byte):void
      com.google.android.gms.internal.firebase_ml.zzyy.zza(java.lang.Object, long, int):void */
    private final void zzb(T t, int i, int i2) {
        zzyy.zza((Object) t, (long) (zzdt(i2) & 1048575), i);
    }

    private final int zzdu(int i) {
        if (i < this.zzcfv || i > this.zzcfw) {
            return -1;
        }
        return zzv(i, 0);
    }

    private final int zzu(int i, int i2) {
        if (i < this.zzcfv || i > this.zzcfw) {
            return -1;
        }
        return zzv(i, i2);
    }

    private final int zzv(int i, int i2) {
        int length = (this.zzcft.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzcft[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
