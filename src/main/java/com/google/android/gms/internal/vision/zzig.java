package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzig<T> implements zzir<T> {
    private static final int[] zzys = new int[0];
    private static final Unsafe zzyt = zzjp.zzil();
    private final int[] zzyu;
    private final Object[] zzyv;
    private final int zzyw;
    private final int zzyx;
    private final zzic zzyy;
    private final boolean zzyz;
    private final boolean zzza;
    private final boolean zzzb;
    private final boolean zzzc;
    private final int[] zzzd;
    private final int zzze;
    private final int zzzf;
    private final zzik zzzg;
    private final zzhm zzzh;
    private final zzjj<?, ?> zzzi;
    private final zzgf<?> zzzj;
    private final zzhv zzzk;

    private zzig(int[] iArr, Object[] objArr, int i, int i2, zzic zzic, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzik zzik, zzhm zzhm, zzjj<?, ?> zzjj, zzgf<?> zzgf, zzhv zzhv) {
        this.zzyu = iArr;
        this.zzyv = objArr;
        this.zzyw = i;
        this.zzyx = i2;
        this.zzza = zzic instanceof zzgs;
        this.zzzb = z;
        this.zzyz = zzgf != null && zzgf.zze(zzic);
        this.zzzc = false;
        this.zzzd = iArr2;
        this.zzze = i3;
        this.zzzf = i4;
        this.zzzg = zzik;
        this.zzzh = zzhm;
        this.zzzi = zzjj;
        this.zzzj = zzgf;
        this.zzyy = zzic;
        this.zzzk = zzhv;
    }

    private static boolean zzbr(int i) {
        return (i & 536870912) != 0;
    }

    static <T> zzig<T> zza(Class<T> cls, zzia zzia, zzik zzik, zzhm zzhm, zzjj<?, ?> zzjj, zzgf<?> zzgf, zzhv zzhv) {
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
        zzip zzip;
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
        zzia zzia2 = zzia;
        if (zzia2 instanceof zzip) {
            zzip zzip2 = (zzip) zzia2;
            char c9 = 0;
            boolean z2 = zzip2.zzhi() == zzgs.zzf.zzwu;
            String zzhp = zzip2.zzhp();
            int length = zzhp.length();
            char charAt15 = zzhp.charAt(0);
            if (charAt15 >= 55296) {
                char c10 = charAt15 & 8191;
                int i24 = 1;
                int i25 = 13;
                while (true) {
                    i = i24 + 1;
                    charAt14 = zzhp.charAt(i24);
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
            char charAt16 = zzhp.charAt(i);
            if (charAt16 >= 55296) {
                char c11 = charAt16 & 8191;
                int i27 = 13;
                while (true) {
                    i23 = i26 + 1;
                    charAt13 = zzhp.charAt(i26);
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
                iArr = zzys;
                c4 = 0;
            } else {
                int i28 = i26 + 1;
                char charAt17 = zzhp.charAt(i26);
                if (charAt17 >= 55296) {
                    char c12 = charAt17 & 8191;
                    int i29 = 13;
                    while (true) {
                        i22 = i28 + 1;
                        charAt12 = zzhp.charAt(i28);
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
                char charAt18 = zzhp.charAt(i28);
                if (charAt18 >= 55296) {
                    char c13 = charAt18 & 8191;
                    int i31 = 13;
                    while (true) {
                        i21 = i30 + 1;
                        charAt11 = zzhp.charAt(i30);
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
                c3 = zzhp.charAt(i30);
                if (c3 >= 55296) {
                    char c14 = c3 & 8191;
                    int i33 = 13;
                    while (true) {
                        i20 = i32 + 1;
                        charAt10 = zzhp.charAt(i32);
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
                char charAt19 = zzhp.charAt(i32);
                if (charAt19 >= 55296) {
                    char c15 = charAt19 & 8191;
                    int i35 = 13;
                    while (true) {
                        i19 = i34 + 1;
                        charAt9 = zzhp.charAt(i34);
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
                c2 = zzhp.charAt(i34);
                if (c2 >= 55296) {
                    char c16 = c2 & 8191;
                    int i37 = 13;
                    while (true) {
                        i18 = i36 + 1;
                        charAt8 = zzhp.charAt(i36);
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
                char charAt20 = zzhp.charAt(i36);
                if (charAt20 >= 55296) {
                    char c17 = charAt20 & 8191;
                    int i39 = 13;
                    while (true) {
                        i17 = i38 + 1;
                        charAt7 = zzhp.charAt(i38);
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
                char charAt21 = zzhp.charAt(i38);
                if (charAt21 >= 55296) {
                    char c18 = charAt21 & 8191;
                    int i41 = i40;
                    int i42 = 13;
                    while (true) {
                        i16 = i41 + 1;
                        charAt6 = zzhp.charAt(i41);
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
                char charAt22 = zzhp.charAt(i14);
                if (charAt22 >= 55296) {
                    char c19 = charAt22 & 8191;
                    int i44 = i43;
                    int i45 = 13;
                    while (true) {
                        i15 = i44 + 1;
                        charAt5 = zzhp.charAt(i44);
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
            Unsafe unsafe = zzyt;
            Object[] zzhq = zzip2.zzhq();
            Class<?> cls3 = zzip2.zzhk().getClass();
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
                int charAt23 = zzhp.charAt(i49);
                int i54 = length;
                if (charAt23 >= 55296) {
                    int i55 = charAt23 & 8191;
                    int i56 = i53;
                    int i57 = 13;
                    while (true) {
                        i13 = i56 + 1;
                        charAt4 = zzhp.charAt(i56);
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
                char charAt24 = zzhp.charAt(i3);
                int i59 = i58;
                if (charAt24 >= 55296) {
                    char c22 = charAt24 & 8191;
                    int i60 = i59;
                    int i61 = 13;
                    while (true) {
                        i12 = i60 + 1;
                        charAt3 = zzhp.charAt(i60);
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
                    char charAt25 = zzhp.charAt(i4);
                    char c26 = 55296;
                    if (charAt25 >= 55296) {
                        char c27 = charAt25 & 8191;
                        int i63 = 13;
                        while (true) {
                            i11 = i62 + 1;
                            charAt2 = zzhp.charAt(i62);
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
                        objArr[((i52 / 3) << 1) + 1] = zzhq[i2];
                        i2++;
                    } else if (i64 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i52 / 3) << 1) + 1] = zzhq[i2];
                        i2++;
                    }
                    int i66 = charAt25 << 1;
                    Object obj = zzhq[i66];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zzhq[i66] = field2;
                    }
                    zzip = zzip2;
                    String str2 = zzhp;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i67 = i66 + 1;
                    Object obj2 = zzhq[i67];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zzhq[i67] = field3;
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
                    zzip = zzip2;
                    String str3 = zzhp;
                    int i68 = i2 + 1;
                    Field zza = zza(cls3, (String) zzhq[i2]);
                    if (c23 == 9 || c23 == 17) {
                        c8 = 1;
                        objArr[((i52 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c23 == 27 || c23 == '1') {
                            c8 = 1;
                            i10 = i68 + 1;
                            objArr[((i52 / 3) << 1) + 1] = zzhq[i68];
                        } else if (c23 == 12 || c23 == 30 || c23 == ',') {
                            c8 = 1;
                            if ((charAt15 & 1) == 1) {
                                i10 = i68 + 1;
                                objArr[((i52 / 3) << 1) + 1] = zzhq[i68];
                            }
                        } else {
                            if (c23 == '2') {
                                int i69 = c21 + 1;
                                iArr[c21] = i52;
                                int i70 = (i52 / 3) << 1;
                                int i71 = i68 + 1;
                                objArr[i70] = zzhq[i68];
                                if ((charAt24 & 2048) != 0) {
                                    i68 = i71 + 1;
                                    objArr[i70 + 1] = zzhq[i71];
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
                        Object obj3 = zzhq[i74];
                        i5 = i68;
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = zza(cls3, (String) obj3);
                            zzhq[i74] = field;
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
                zzhp = str;
                i49 = i4;
                cls3 = cls2;
                c4 = c24;
                length = i54;
                c = c6;
                z2 = z;
                c3 = c25;
                i2 = i5;
                zzip2 = zzip;
            }
            return new zzig(iArr2, objArr, c3, c4, zzip2.zzhk(), z2, false, iArr, c, i48, zzik, zzhm, zzjj, zzgf, zzhv);
        }
        int zzhi = ((zzjg) zzia2).zzhi();
        int i77 = zzgs.zzf.zzwu;
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
        return this.zzzg.newInstance(this.zzyy);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzm(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.zzjp.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.zzjp.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.zzjp.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.zzjp.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzyu
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzbp(r2)
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
            int r4 = r9.zzbq(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r4)
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.vision.zzit.zze(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.vision.zzit.zze(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.vision.zzjp.zzm(r10, r6)
            boolean r5 = com.google.android.gms.internal.vision.zzjp.zzm(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.vision.zzjp.zzn(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.vision.zzjp.zzn(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.vision.zzjp.zzo(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.vision.zzjp.zzo(r11, r6)
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
            com.google.android.gms.internal.vision.zzjj<?, ?> r0 = r9.zzzi
            java.lang.Object r0 = r0.zzv(r10)
            com.google.android.gms.internal.vision.zzjj<?, ?> r2 = r9.zzzi
            java.lang.Object r2 = r2.zzv(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzyz
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.vision.zzgf<?> r0 = r9.zzzj
            com.google.android.gms.internal.vision.zzgi r10 = r0.zze(r10)
            com.google.android.gms.internal.vision.zzgf<?> r0 = r9.zzzj
            com.google.android.gms.internal.vision.zzgi r11 = r0.zze(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.equals(java.lang.Object, java.lang.Object):boolean");
    }

    public final int hashCode(T t) {
        int i;
        int i2;
        int length = this.zzyu.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzbp = zzbp(i4);
            int i5 = this.zzyu[i4];
            long j = (long) (1048575 & zzbp);
            int i6 = 37;
            switch ((zzbp & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    i = zzgt.zzab(Double.doubleToLongBits(zzjp.zzo(t, j)));
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    i = Float.floatToIntBits(zzjp.zzn(t, j));
                    i3 = i2 + i;
                    break;
                case 2:
                    i2 = i3 * 53;
                    i = zzgt.zzab(zzjp.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 3:
                    i2 = i3 * 53;
                    i = zzgt.zzab(zzjp.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    i = zzjp.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 5:
                    i2 = i3 * 53;
                    i = zzgt.zzab(zzjp.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    i = zzjp.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    i = zzgt.zzm(zzjp.zzm(t, j));
                    i3 = i2 + i;
                    break;
                case 8:
                    i2 = i3 * 53;
                    i = ((String) zzjp.zzp(t, j)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    Object zzp = zzjp.zzp(t, j);
                    if (zzp != null) {
                        i6 = zzp.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    i = zzjp.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    i = zzjp.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 12:
                    i2 = i3 * 53;
                    i = zzjp.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 13:
                    i2 = i3 * 53;
                    i = zzjp.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 14:
                    i2 = i3 * 53;
                    i = zzgt.zzab(zzjp.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    i = zzjp.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 16:
                    i2 = i3 * 53;
                    i = zzgt.zzab(zzjp.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 17:
                    Object zzp2 = zzjp.zzp(t, j);
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
                    i = zzjp.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 50:
                    i2 = i3 * 53;
                    i = zzjp.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 51:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzgt.zzab(Double.doubleToLongBits(zzf(t, j)));
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
                        i = zzgt.zzab(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 54:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzgt.zzab(zzi(t, j));
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
                        i = zzgt.zzab(zzi(t, j));
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
                        i = zzgt.zzm(zzj(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 59:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = ((String) zzjp.zzp(t, j)).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 60:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzjp.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 61:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzjp.zzp(t, j).hashCode();
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
                        i = zzgt.zzab(zzi(t, j));
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
                        i = zzgt.zzab(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 68:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzjp.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzzi.zzv(t).hashCode();
        return this.zzyz ? (hashCode * 53) + this.zzzj.zze((Object) t).hashCode() : hashCode;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, long):void
     arg types: [T, long, long]
     candidates:
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.vision.zzjp.zza(byte[], long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, long):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, boolean):void
     arg types: [T, long, boolean]
     candidates:
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.vision.zzjp.zza(byte[], long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, float):void
     arg types: [T, long, float]
     candidates:
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.vision.zzjp.zza(byte[], long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, float):void */
    public final void zzd(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzyu.length; i += 3) {
                int zzbp = zzbp(i);
                long j = (long) (1048575 & zzbp);
                int i2 = this.zzyu[i];
                switch ((zzbp & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza(t, j, zzjp.zzo(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzn(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zzb(t, j, zzjp.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zzb(t, j, zzjp.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzm(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza(t, j, zzjp.zzp(t2, j));
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
                            zzjp.zza(t, j, zzjp.zzp(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zzb(t, j, zzjp.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zzb(t, j, zzjp.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zzb(t, j, zzjp.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zzb(t, j, zzjp.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzjp.zza((Object) t, j, zzjp.zzl(t2, j));
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
                        this.zzzh.zza(t, t2, j);
                        break;
                    case 50:
                        zzit.zza(this.zzzk, t, t2, j);
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
                            zzjp.zza(t, j, zzjp.zzp(t2, j));
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
                            zzjp.zza(t, j, zzjp.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            if (!this.zzzb) {
                zzit.zza(this.zzzi, t, t2);
                if (this.zzyz) {
                    zzit.zza(this.zzzj, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw null;
    }

    private final void zza(T t, T t2, int i) {
        long zzbp = (long) (zzbp(i) & 1048575);
        if (zza(t2, i)) {
            Object zzp = zzjp.zzp(t, zzbp);
            Object zzp2 = zzjp.zzp(t2, zzbp);
            if (zzp != null && zzp2 != null) {
                zzjp.zza(t, zzbp, zzgt.zzb(zzp, zzp2));
                zzb(t, i);
            } else if (zzp2 != null) {
                zzjp.zza(t, zzbp, zzp2);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzbp = zzbp(i);
        int i2 = this.zzyu[i];
        long j = (long) (zzbp & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zzjp.zzp(t, j);
            Object zzp2 = zzjp.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzjp.zza(t, j, zzgt.zzb(zzp, zzp2));
                zzb(t, i2, i);
            } else if (zzp2 != null) {
                zzjp.zza(t, j, zzp2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzga.zzh(int, long):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.vision.zzga.zzh(int, int):void
      com.google.android.gms.internal.vision.zzga.zzh(int, long):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzga.zzb(int, boolean):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.vision.zzga.zzb(int, double):int
      com.google.android.gms.internal.vision.zzga.zzb(int, float):int
      com.google.android.gms.internal.vision.zzga.zzb(int, com.google.android.gms.internal.vision.zzhh):int
      com.google.android.gms.internal.vision.zzga.zzb(int, com.google.android.gms.internal.vision.zzic):int
      com.google.android.gms.internal.vision.zzga.zzb(int, java.lang.String):int
      com.google.android.gms.internal.vision.zzga.zzb(int, long):void
      com.google.android.gms.internal.vision.zzga.zzb(int, com.google.android.gms.internal.vision.zzfh):void
      com.google.android.gms.internal.vision.zzga.zzb(int, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzga.zzg(int, long):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.vision.zzga.zzg(int, int):void
      com.google.android.gms.internal.vision.zzga.zzg(int, long):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzga.zzb(int, float):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.vision.zzga.zzb(int, double):int
      com.google.android.gms.internal.vision.zzga.zzb(int, com.google.android.gms.internal.vision.zzhh):int
      com.google.android.gms.internal.vision.zzga.zzb(int, com.google.android.gms.internal.vision.zzic):int
      com.google.android.gms.internal.vision.zzga.zzb(int, java.lang.String):int
      com.google.android.gms.internal.vision.zzga.zzb(int, boolean):int
      com.google.android.gms.internal.vision.zzga.zzb(int, long):void
      com.google.android.gms.internal.vision.zzga.zzb(int, com.google.android.gms.internal.vision.zzfh):void
      com.google.android.gms.internal.vision.zzga.zzb(int, float):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzga.zzb(int, double):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.vision.zzga.zzb(int, float):int
      com.google.android.gms.internal.vision.zzga.zzb(int, com.google.android.gms.internal.vision.zzhh):int
      com.google.android.gms.internal.vision.zzga.zzb(int, com.google.android.gms.internal.vision.zzic):int
      com.google.android.gms.internal.vision.zzga.zzb(int, java.lang.String):int
      com.google.android.gms.internal.vision.zzga.zzb(int, boolean):int
      com.google.android.gms.internal.vision.zzga.zzb(int, long):void
      com.google.android.gms.internal.vision.zzga.zzb(int, com.google.android.gms.internal.vision.zzfh):void
      com.google.android.gms.internal.vision.zzga.zzb(int, double):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzig.zza(com.google.android.gms.internal.vision.zzjj, java.lang.Object):int
     arg types: [com.google.android.gms.internal.vision.zzjj<?, ?>, T]
     candidates:
      com.google.android.gms.internal.vision.zzig.zza(java.lang.Class<?>, java.lang.String):java.lang.reflect.Field
      com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, int):boolean
      com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, com.google.android.gms.internal.vision.zzkg):void
      com.google.android.gms.internal.vision.zzir.zza(java.lang.Object, com.google.android.gms.internal.vision.zzkg):void
      com.google.android.gms.internal.vision.zzig.zza(com.google.android.gms.internal.vision.zzjj, java.lang.Object):int */
    public final int zzr(T t) {
        int i;
        int i2;
        long j;
        boolean z;
        int i3;
        int i4;
        int i5;
        int zzb;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int zzb2;
        int i11;
        int i12;
        int i13;
        T t2 = t;
        int i14 = 267386880;
        int i15 = 1;
        int i16 = 0;
        if (this.zzzb) {
            Unsafe unsafe = zzyt;
            int i17 = 0;
            int i18 = 0;
            while (i17 < this.zzyu.length) {
                int zzbp = zzbp(i17);
                int i19 = (zzbp & i14) >>> 20;
                int i20 = this.zzyu[i17];
                long j2 = (long) (zzbp & 1048575);
                int i21 = (i19 < zzgn.DOUBLE_LIST_PACKED.id() || i19 > zzgn.SINT64_LIST_PACKED.id()) ? 0 : this.zzyu[i17 + 2] & 1048575;
                switch (i19) {
                    case 0:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 1:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 2:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzd(i20, zzjp.zzl(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 3:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zze(i20, zzjp.zzl(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 4:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzl(i20, zzjp.zzk(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 5:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzg(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 6:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzo(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 7:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzb(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 8:
                        if (zza(t2, i17)) {
                            Object zzp = zzjp.zzp(t2, j2);
                            if (!(zzp instanceof zzfh)) {
                                zzb2 = zzga.zzb(i20, (String) zzp);
                                break;
                            } else {
                                zzb2 = zzga.zzc(i20, (zzfh) zzp);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 9:
                        if (zza(t2, i17)) {
                            zzb2 = zzit.zzc(i20, zzjp.zzp(t2, j2), zzbm(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 10:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzc(i20, (zzfh) zzjp.zzp(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 11:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzm(i20, zzjp.zzk(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 12:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzq(i20, zzjp.zzk(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 13:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzp(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 14:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 15:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzn(i20, zzjp.zzk(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 16:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzf(i20, zzjp.zzl(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 17:
                        if (zza(t2, i17)) {
                            zzb2 = zzga.zzc(i20, (zzic) zzjp.zzp(t2, j2), zzbm(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 18:
                        zzb2 = zzit.zzw(i20, zze(t2, j2), false);
                        break;
                    case 19:
                        zzb2 = zzit.zzv(i20, zze(t2, j2), false);
                        break;
                    case 20:
                        zzb2 = zzit.zzo(i20, zze(t2, j2), false);
                        break;
                    case 21:
                        zzb2 = zzit.zzp(i20, zze(t2, j2), false);
                        break;
                    case 22:
                        zzb2 = zzit.zzs(i20, zze(t2, j2), false);
                        break;
                    case 23:
                        zzb2 = zzit.zzw(i20, zze(t2, j2), false);
                        break;
                    case 24:
                        zzb2 = zzit.zzv(i20, zze(t2, j2), false);
                        break;
                    case 25:
                        zzb2 = zzit.zzx(i20, zze(t2, j2), false);
                        break;
                    case 26:
                        zzb2 = zzit.zzc(i20, zze(t2, j2));
                        break;
                    case 27:
                        zzb2 = zzit.zzc(i20, zze(t2, j2), zzbm(i17));
                        break;
                    case 28:
                        zzb2 = zzit.zzd(i20, zze(t2, j2));
                        break;
                    case 29:
                        zzb2 = zzit.zzt(i20, zze(t2, j2), false);
                        break;
                    case 30:
                        zzb2 = zzit.zzr(i20, zze(t2, j2), false);
                        break;
                    case 31:
                        zzb2 = zzit.zzv(i20, zze(t2, j2), false);
                        break;
                    case 32:
                        zzb2 = zzit.zzw(i20, zze(t2, j2), false);
                        break;
                    case 33:
                        zzb2 = zzit.zzu(i20, zze(t2, j2), false);
                        break;
                    case 34:
                        zzb2 = zzit.zzq(i20, zze(t2, j2), false);
                        break;
                    case 35:
                        i12 = zzit.zzy((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzzc) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzga.zzba(i20);
                            i11 = zzga.zzbc(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 36:
                        i12 = zzit.zzx((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzzc) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzga.zzba(i20);
                            i11 = zzga.zzbc(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 37:
                        i12 = zzit.zzq((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzzc) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzga.zzba(i20);
                            i11 = zzga.zzbc(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 38:
                        i12 = zzit.zzr((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzzc) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzga.zzba(i20);
                            i11 = zzga.zzbc(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 39:
                        i12 = zzit.zzu((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzzc) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzga.zzba(i20);
                            i11 = zzga.zzbc(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 40:
                        i12 = zzit.zzy((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzzc) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzga.zzba(i20);
                            i11 = zzga.zzbc(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 41:
                        i12 = zzit.zzx((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzzc) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzga.zzba(i20);
                            i11 = zzga.zzbc(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 42:
                        i12 = zzit.zzz((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzzc) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzga.zzba(i20);
                            i11 = zzga.zzbc(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 43:
                        i12 = zzit.zzv((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzzc) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzga.zzba(i20);
                            i11 = zzga.zzbc(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 44:
                        i12 = zzit.zzt((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzzc) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzga.zzba(i20);
                            i11 = zzga.zzbc(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 45:
                        i12 = zzit.zzx((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzzc) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzga.zzba(i20);
                            i11 = zzga.zzbc(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 46:
                        i12 = zzit.zzy((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzzc) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzga.zzba(i20);
                            i11 = zzga.zzbc(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 47:
                        i12 = zzit.zzw((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzzc) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzga.zzba(i20);
                            i11 = zzga.zzbc(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 48:
                        i12 = zzit.zzs((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzzc) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzga.zzba(i20);
                            i11 = zzga.zzbc(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 49:
                        zzb2 = zzit.zzd(i20, zze(t2, j2), zzbm(i17));
                        break;
                    case 50:
                        zzb2 = this.zzzk.zzb(i20, zzjp.zzp(t2, j2), zzbn(i17));
                        break;
                    case 51:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 52:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 53:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzd(i20, zzi(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 54:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zze(i20, zzi(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 55:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzl(i20, zzh(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 56:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzg(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 57:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzo(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 58:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzb(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 59:
                        if (zza(t2, i20, i17)) {
                            Object zzp2 = zzjp.zzp(t2, j2);
                            if (!(zzp2 instanceof zzfh)) {
                                zzb2 = zzga.zzb(i20, (String) zzp2);
                                break;
                            } else {
                                zzb2 = zzga.zzc(i20, (zzfh) zzp2);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 60:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzit.zzc(i20, zzjp.zzp(t2, j2), zzbm(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 61:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzc(i20, (zzfh) zzjp.zzp(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 62:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzm(i20, zzh(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 63:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzq(i20, zzh(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 64:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzp(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 65:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 66:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzn(i20, zzh(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 67:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzf(i20, zzi(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 68:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzga.zzc(i20, (zzic) zzjp.zzp(t2, j2), zzbm(i17));
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
                i18 += zzb2;
                i17 += 3;
                i14 = 267386880;
            }
            return i18 + zza((zzjj) this.zzzi, (Object) t2);
        }
        Unsafe unsafe2 = zzyt;
        int i22 = -1;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i23 < this.zzyu.length) {
            int zzbp2 = zzbp(i23);
            int[] iArr = this.zzyu;
            int i26 = iArr[i23];
            int i27 = (zzbp2 & 267386880) >>> 20;
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
                i2 = (!this.zzzc || i27 < zzgn.DOUBLE_LIST_PACKED.id() || i27 > zzgn.SINT64_LIST_PACKED.id()) ? 0 : this.zzyu[i23 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzbp2 & 1048575);
            switch (i27) {
                case 0:
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i24 += zzga.zzb(i26, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        z = false;
                        i24 += zzga.zzb(i26, 0.0f);
                        break;
                    }
                    z = false;
                case 2:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzga.zzd(i26, unsafe2.getLong(t2, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 3:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzga.zze(i26, unsafe2.getLong(t2, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 4:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzga.zzl(i26, unsafe2.getInt(t2, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 5:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzga.zzg(i26, 0L);
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 6:
                    i4 = 1;
                    if ((i25 & i) != 0) {
                        i3 = 0;
                        i24 += zzga.zzo(i26, 0);
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
                        i24 += zzga.zzb(i26, true);
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
                        if (object instanceof zzfh) {
                            zzb = zzga.zzc(i26, (zzfh) object);
                        } else {
                            zzb = zzga.zzb(i26, (String) object);
                        }
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 9:
                    if ((i25 & i) != 0) {
                        zzb = zzit.zzc(i26, unsafe2.getObject(t2, j3), zzbm(i23));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 10:
                    if ((i25 & i) != 0) {
                        zzb = zzga.zzc(i26, (zzfh) unsafe2.getObject(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 11:
                    if ((i25 & i) != 0) {
                        zzb = zzga.zzm(i26, unsafe2.getInt(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 12:
                    if ((i25 & i) != 0) {
                        zzb = zzga.zzq(i26, unsafe2.getInt(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 13:
                    if ((i25 & i) != 0) {
                        i6 = zzga.zzp(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 14:
                    if ((i25 & i) != 0) {
                        zzb = zzga.zzh(i26, 0L);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 15:
                    if ((i25 & i) != 0) {
                        zzb = zzga.zzn(i26, unsafe2.getInt(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 16:
                    if ((i25 & i) != 0) {
                        zzb = zzga.zzf(i26, unsafe2.getLong(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 17:
                    if ((i25 & i) != 0) {
                        zzb = zzga.zzc(i26, (zzic) unsafe2.getObject(t2, j3), zzbm(i23));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 18:
                    zzb = zzit.zzw(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 19:
                    i3 = 0;
                    i7 = zzit.zzv(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 20:
                    i3 = 0;
                    i7 = zzit.zzo(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 21:
                    i3 = 0;
                    i7 = zzit.zzp(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 22:
                    i3 = 0;
                    i7 = zzit.zzs(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 23:
                    i3 = 0;
                    i7 = zzit.zzw(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 24:
                    i3 = 0;
                    i7 = zzit.zzv(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 25:
                    i3 = 0;
                    i7 = zzit.zzx(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 26:
                    zzb = zzit.zzc(i26, (List) unsafe2.getObject(t2, j3));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 27:
                    zzb = zzit.zzc(i26, (List<?>) ((List) unsafe2.getObject(t2, j3)), zzbm(i23));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 28:
                    zzb = zzit.zzd(i26, (List) unsafe2.getObject(t2, j3));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 29:
                    zzb = zzit.zzt(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 30:
                    i3 = 0;
                    i7 = zzit.zzr(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 31:
                    i3 = 0;
                    i7 = zzit.zzv(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 32:
                    i3 = 0;
                    i7 = zzit.zzw(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 33:
                    i3 = 0;
                    i7 = zzit.zzu(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 34:
                    i3 = 0;
                    i7 = zzit.zzq(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 35:
                    i10 = zzit.zzy((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzzc) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzga.zzba(i26);
                        i8 = zzga.zzbc(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 36:
                    i10 = zzit.zzx((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzzc) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzga.zzba(i26);
                        i8 = zzga.zzbc(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 37:
                    i10 = zzit.zzq((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzzc) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzga.zzba(i26);
                        i8 = zzga.zzbc(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 38:
                    i10 = zzit.zzr((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzzc) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzga.zzba(i26);
                        i8 = zzga.zzbc(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 39:
                    i10 = zzit.zzu((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzzc) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzga.zzba(i26);
                        i8 = zzga.zzbc(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 40:
                    i10 = zzit.zzy((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzzc) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzga.zzba(i26);
                        i8 = zzga.zzbc(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 41:
                    i10 = zzit.zzx((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzzc) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzga.zzba(i26);
                        i8 = zzga.zzbc(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 42:
                    i10 = zzit.zzz((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzzc) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzga.zzba(i26);
                        i8 = zzga.zzbc(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 43:
                    i10 = zzit.zzv((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzzc) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzga.zzba(i26);
                        i8 = zzga.zzbc(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 44:
                    i10 = zzit.zzt((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzzc) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzga.zzba(i26);
                        i8 = zzga.zzbc(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 45:
                    i10 = zzit.zzx((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzzc) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzga.zzba(i26);
                        i8 = zzga.zzbc(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 46:
                    i10 = zzit.zzy((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzzc) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzga.zzba(i26);
                        i8 = zzga.zzbc(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 47:
                    i10 = zzit.zzw((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzzc) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzga.zzba(i26);
                        i8 = zzga.zzbc(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 48:
                    i10 = zzit.zzs((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzzc) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzga.zzba(i26);
                        i8 = zzga.zzbc(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 49:
                    zzb = zzit.zzd(i26, (List) unsafe2.getObject(t2, j3), zzbm(i23));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 50:
                    zzb = this.zzzk.zzb(i26, unsafe2.getObject(t2, j3), zzbn(i23));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 51:
                    if (zza(t2, i26, i23)) {
                        zzb = zzga.zzb(i26, 0.0d);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 52:
                    if (zza(t2, i26, i23)) {
                        i6 = zzga.zzb(i26, 0.0f);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 53:
                    if (zza(t2, i26, i23)) {
                        zzb = zzga.zzd(i26, zzi(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 54:
                    if (zza(t2, i26, i23)) {
                        zzb = zzga.zze(i26, zzi(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 55:
                    if (zza(t2, i26, i23)) {
                        zzb = zzga.zzl(i26, zzh(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 56:
                    if (zza(t2, i26, i23)) {
                        zzb = zzga.zzg(i26, 0L);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 57:
                    if (zza(t2, i26, i23)) {
                        i6 = zzga.zzo(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 58:
                    if (zza(t2, i26, i23)) {
                        i6 = zzga.zzb(i26, true);
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
                        if (object2 instanceof zzfh) {
                            zzb = zzga.zzc(i26, (zzfh) object2);
                        } else {
                            zzb = zzga.zzb(i26, (String) object2);
                        }
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 60:
                    if (zza(t2, i26, i23)) {
                        zzb = zzit.zzc(i26, unsafe2.getObject(t2, j3), zzbm(i23));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 61:
                    if (zza(t2, i26, i23)) {
                        zzb = zzga.zzc(i26, (zzfh) unsafe2.getObject(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 62:
                    if (zza(t2, i26, i23)) {
                        zzb = zzga.zzm(i26, zzh(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 63:
                    if (zza(t2, i26, i23)) {
                        zzb = zzga.zzq(i26, zzh(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 64:
                    if (zza(t2, i26, i23)) {
                        i6 = zzga.zzp(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 65:
                    if (zza(t2, i26, i23)) {
                        zzb = zzga.zzh(i26, 0L);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 66:
                    if (zza(t2, i26, i23)) {
                        zzb = zzga.zzn(i26, zzh(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 67:
                    if (zza(t2, i26, i23)) {
                        zzb = zzga.zzf(i26, zzi(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 68:
                    if (zza(t2, i26, i23)) {
                        zzb = zzga.zzc(i26, (zzic) unsafe2.getObject(t2, j3), zzbm(i23));
                        i24 += zzb;
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
        int zza = i24 + zza((zzjj) this.zzzi, (Object) t2);
        if (!this.zzyz) {
            return zza;
        }
        zzgi<?> zze = this.zzzj.zze((Object) t2);
        for (int i31 = i30; i31 < zze.zztb.zzhx(); i31++) {
            Map.Entry<T, Object> zzbu = zze.zztb.zzbu(i31);
            i30 += zzgi.zzc((zzgk) zzbu.getKey(), zzbu.getValue());
        }
        for (Map.Entry next : zze.zztb.zzhy()) {
            i30 += zzgi.zzc((zzgk) next.getKey(), next.getValue());
        }
        return zza + i30;
    }

    private static <UT, UB> int zza(zzjj<UT, UB> zzjj, T t) {
        return zzjj.zzr(zzjj.zzv(t));
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzjp.zzp(obj, j);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzit.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.vision.zzkg, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.vision.zzkg, int]
     candidates:
      com.google.android.gms.internal.vision.zzit.zzb(int, java.util.List<?>, com.google.android.gms.internal.vision.zzkg, com.google.android.gms.internal.vision.zzir):void
      com.google.android.gms.internal.vision.zzit.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.vision.zzkg, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzit.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.vision.zzkg, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.vision.zzkg, int]
     candidates:
      com.google.android.gms.internal.vision.zzit.zza(int, int, java.lang.Object, com.google.android.gms.internal.vision.zzjj):UB
      com.google.android.gms.internal.vision.zzit.zza(int, java.util.List<?>, com.google.android.gms.internal.vision.zzkg, com.google.android.gms.internal.vision.zzir):void
      com.google.android.gms.internal.vision.zzit.zza(com.google.android.gms.internal.vision.zzhv, java.lang.Object, java.lang.Object, long):void
      com.google.android.gms.internal.vision.zzit.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.vision.zzkg, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.vision.zzkg r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzfj()
            int r1 = com.google.android.gms.internal.vision.zzgs.zzf.zzwx
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.vision.zzjj<?, ?> r0 = r13.zzzi
            zza(r0, r14, r15)
            boolean r0 = r13.zzyz
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.vision.zzgf<?> r0 = r13.zzzj
            com.google.android.gms.internal.vision.zzgi r0 = r0.zze(r14)
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r1 = r0.zztb
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
            int[] r7 = r13.zzyu
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzbp(r7)
            int[] r9 = r13.zzyu
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.vision.zzgf<?> r10 = r13.zzzj
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.vision.zzgf<?> r10 = r13.zzzj
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
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
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
            r15.zzj(r9, r8)
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
            r15.zzr(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzs(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzi(r9, r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzfh r8 = (com.google.android.gms.internal.vision.zzfh) r8
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            r15.zza(r9, r8, r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
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
            r15.zzk(r9, r8)
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
            r15.zzh(r9, r8)
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
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            r13.zza(r15, r9, r8, r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            com.google.android.gms.internal.vision.zzit.zzb(r9, r8, r15, r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzb(r9, r8, r15, r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zza(r9, r8, r15, r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzb(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            com.google.android.gms.internal.vision.zzit.zza(r9, r8, r15, r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zza(r9, r8, r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzb(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zza(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzj(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzs(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzi(r9, r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzfh r8 = (com.google.android.gms.internal.vision.zzfh) r8
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            r15.zza(r9, r8, r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            zza(r9, r8, r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.vision.zzjp.zzm(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzk(r9, r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.vision.zzjp.zzn(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.vision.zzjp.zzo(r14, r10)
            r15.zza(r9, r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.vision.zzgf<?> r14 = r13.zzzj
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
            boolean r0 = r13.zzzb
            if (r0 == 0) goto L_0x0a44
            boolean r0 = r13.zzyz
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.vision.zzgf<?> r0 = r13.zzzj
            com.google.android.gms.internal.vision.zzgi r0 = r0.zze(r14)
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r1 = r0.zztb
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
            int[] r7 = r13.zzyu
            int r7 = r7.length
            r8 = r5
        L_0x0550:
            if (r8 >= r7) goto L_0x0a28
            int r9 = r13.zzbp(r8)
            int[] r10 = r13.zzyu
            r10 = r10[r8]
        L_0x055a:
            if (r1 == 0) goto L_0x0578
            com.google.android.gms.internal.vision.zzgf<?> r11 = r13.zzzj
            int r11 = r11.zza(r1)
            if (r11 > r10) goto L_0x0578
            com.google.android.gms.internal.vision.zzgf<?> r11 = r13.zzzj
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
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r8)
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
            r15.zzj(r10, r9)
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
            r15.zzr(r10, r9)
            goto L_0x0a24
        L_0x05da:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzs(r10, r9)
            goto L_0x0a24
        L_0x05eb:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzi(r10, r9)
            goto L_0x0a24
        L_0x05fc:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzfh r9 = (com.google.android.gms.internal.vision.zzfh) r9
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x060f:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r8)
            r15.zza(r10, r9, r11)
            goto L_0x0a24
        L_0x0624:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
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
            r15.zzk(r10, r9)
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
            r15.zzh(r10, r9)
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
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            r13.zza(r15, r10, r9, r8)
            goto L_0x0a24
        L_0x06c8:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r8)
            com.google.android.gms.internal.vision.zzit.zzb(r10, r9, r15, r11)
            goto L_0x0a24
        L_0x06dd:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zze(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ee:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzj(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ff:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzg(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0710:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzl(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0721:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzm(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0732:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzi(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0743:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzn(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0754:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzk(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0765:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzf(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0776:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzh(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0787:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzd(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0798:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzc(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07a9:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzb(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07ba:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zza(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07cb:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zze(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07dc:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzj(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07ed:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzg(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07fe:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzl(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x080f:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzm(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0820:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzi(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0831:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzb(r10, r9, r15)
            goto L_0x0a24
        L_0x0842:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r8)
            com.google.android.gms.internal.vision.zzit.zza(r10, r9, r15, r11)
            goto L_0x0a24
        L_0x0857:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zza(r10, r9, r15)
            goto L_0x0a24
        L_0x0868:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzn(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0879:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzk(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x088a:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzf(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x089b:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzh(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ac:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzd(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08bd:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzc(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ce:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzb(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08df:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zza(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08f0:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r8)
            r15.zzb(r10, r9, r11)
            goto L_0x0a24
        L_0x0905:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0a24
        L_0x0916:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzj(r10, r9)
            goto L_0x0a24
        L_0x0927:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x0938:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0a24
        L_0x0949:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzs(r10, r9)
            goto L_0x0a24
        L_0x095a:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzi(r10, r9)
            goto L_0x0a24
        L_0x096b:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzfh r9 = (com.google.android.gms.internal.vision.zzfh) r9
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x097e:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r8)
            r15.zza(r10, r9, r11)
            goto L_0x0a24
        L_0x0993:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0a24
        L_0x09a4:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.vision.zzjp.zzm(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x09b5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzk(r10, r9)
            goto L_0x0a24
        L_0x09c5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a24
        L_0x09d5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a24
        L_0x09e5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a24
        L_0x09f5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a24
        L_0x0a05:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.vision.zzjp.zzn(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x0a15:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.vision.zzjp.zzo(r14, r11)
            r15.zza(r10, r11)
        L_0x0a24:
            int r8 = r8 + 3
            goto L_0x0550
        L_0x0a28:
            if (r1 == 0) goto L_0x0a3e
            com.google.android.gms.internal.vision.zzgf<?> r2 = r13.zzzj
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
            com.google.android.gms.internal.vision.zzjj<?, ?> r0 = r13.zzzi
            zza(r0, r14, r15)
            return
        L_0x0a44:
            r13.zzb(r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, com.google.android.gms.internal.vision.zzkg):void");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzit.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.vision.zzkg, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.vision.zzkg, int]
     candidates:
      com.google.android.gms.internal.vision.zzit.zzb(int, java.util.List<?>, com.google.android.gms.internal.vision.zzkg, com.google.android.gms.internal.vision.zzir):void
      com.google.android.gms.internal.vision.zzit.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.vision.zzkg, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzit.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.vision.zzkg, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.vision.zzkg, int]
     candidates:
      com.google.android.gms.internal.vision.zzit.zza(int, int, java.lang.Object, com.google.android.gms.internal.vision.zzjj):UB
      com.google.android.gms.internal.vision.zzit.zza(int, java.util.List<?>, com.google.android.gms.internal.vision.zzkg, com.google.android.gms.internal.vision.zzir):void
      com.google.android.gms.internal.vision.zzit.zza(com.google.android.gms.internal.vision.zzhv, java.lang.Object, java.lang.Object, long):void
      com.google.android.gms.internal.vision.zzit.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.vision.zzkg, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.vision.zzkg r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzyz
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.vision.zzgf<?> r3 = r0.zzzj
            com.google.android.gms.internal.vision.zzgi r3 = r3.zze(r1)
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r5 = r3.zztb
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
            int[] r7 = r0.zzyu
            int r7 = r7.length
            sun.misc.Unsafe r8 = com.google.android.gms.internal.vision.zzig.zzyt
            r10 = 0
            r11 = 0
        L_0x002d:
            if (r10 >= r7) goto L_0x0494
            int r12 = r0.zzbp(r10)
            int[] r13 = r0.zzyu
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzzb
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
            com.google.android.gms.internal.vision.zzgf<?> r9 = r0.zzzj
            int r9 = r9.zza(r5)
            if (r9 > r14) goto L_0x007e
            com.google.android.gms.internal.vision.zzgf<?> r9 = r0.zzzj
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
            com.google.android.gms.internal.vision.zzir r9 = r0.zzbm(r12)
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
            r2.zzj(r14, r4)
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
            r2.zzr(r14, r4)
            goto L_0x0086
        L_0x00d3:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzs(r14, r4)
            goto L_0x0086
        L_0x00e1:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzi(r14, r4)
            goto L_0x0086
        L_0x00ef:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzfh r4 = (com.google.android.gms.internal.vision.zzfh) r4
            r2.zza(r14, r4)
            goto L_0x0086
        L_0x00ff:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzir r9 = r0.zzbm(r12)
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
            r2.zzk(r14, r4)
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
            r2.zzh(r14, r4)
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
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzir r10 = r0.zzbm(r12)
            com.google.android.gms.internal.vision.zzit.zzb(r4, r9, r2, r10)
            goto L_0x0086
        L_0x01b5:
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.vision.zzit.zze(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01c5:
            r13 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzj(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01d5:
            r13 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzg(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01e5:
            r13 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzl(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01f5:
            r13 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzm(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0205:
            r13 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzi(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0215:
            r13 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzn(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0225:
            r13 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzk(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0235:
            r13 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzf(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0245:
            r13 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzh(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0255:
            r13 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzd(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0265:
            r13 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzc(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0275:
            r13 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzb(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0285:
            r13 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zza(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0295:
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.vision.zzit.zze(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02a5:
            r13 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzj(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02b5:
            r13 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzg(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02c5:
            r13 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzl(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02d5:
            r13 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzm(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02e5:
            r13 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzi(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02f5:
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzb(r4, r9, r2)
            goto L_0x0086
        L_0x0304:
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzir r10 = r0.zzbm(r12)
            com.google.android.gms.internal.vision.zzit.zza(r4, r9, r2, r10)
            goto L_0x0086
        L_0x0317:
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zza(r4, r9, r2)
            goto L_0x0086
        L_0x0326:
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.vision.zzit.zzn(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0336:
            r13 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzk(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0346:
            r13 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzf(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0356:
            r13 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzh(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0366:
            r13 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzd(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0376:
            r13 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzc(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0386:
            r13 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzb(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0396:
            r13 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zza(r4, r9, r2, r13)
            goto L_0x0490
        L_0x03a6:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzir r9 = r0.zzbm(r12)
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
            r2.zzj(r14, r4)
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
            r2.zzr(r14, r4)
            goto L_0x0490
        L_0x03eb:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzs(r14, r4)
            goto L_0x0490
        L_0x03f8:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzi(r14, r4)
            goto L_0x0490
        L_0x0405:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzfh r4 = (com.google.android.gms.internal.vision.zzfh) r4
            r2.zza(r14, r4)
            goto L_0x0490
        L_0x0414:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzir r9 = r0.zzbm(r12)
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
            boolean r4 = com.google.android.gms.internal.vision.zzjp.zzm(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0490
        L_0x043d:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzk(r14, r4)
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
            r2.zzh(r14, r4)
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
            float r4 = com.google.android.gms.internal.vision.zzjp.zzn(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0490
        L_0x0485:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            double r9 = com.google.android.gms.internal.vision.zzjp.zzo(r1, r9)
            r2.zza(r14, r9)
        L_0x0490:
            int r10 = r12 + 3
            goto L_0x002d
        L_0x0494:
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.vision.zzgf<?> r4 = r0.zzzj
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
            com.google.android.gms.internal.vision.zzjj<?, ?> r3 = r0.zzzi
            zza(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zzb(java.lang.Object, com.google.android.gms.internal.vision.zzkg):void");
    }

    private final <K, V> void zza(zzkg zzkg, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzkg.zza(i, this.zzzk.zzp(zzbn(i2)), this.zzzk.zzl(obj));
        }
    }

    private static <UT, UB> void zza(zzjj<UT, UB> zzjj, T t, zzkg zzkg) throws IOException {
        zzjj.zza(zzjj.zzv(t), zzkg);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, long):void
     arg types: [T, long, long]
     candidates:
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.vision.zzjp.zza(byte[], long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, long):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, boolean):void
     arg types: [T, long, boolean]
     candidates:
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.vision.zzjp.zza(byte[], long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, float):void
     arg types: [T, long, float]
     candidates:
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.vision.zzjp.zza(byte[], long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, float):void */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:149|150|(1:152)|153|(5:174|155|(2:158|156)|256|(2:160|264)(1:265))(1:252)) */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        r8.zza(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x05a0, code lost:
        if (r10 == null) goto L_0x05a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x05a2, code lost:
        r10 = r8.zzw(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x05ab, code lost:
        if (r8.zza(r10, r14) == false) goto L_0x05ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x05ad, code lost:
        r14 = r12.zzze;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x05b1, code lost:
        if (r14 < r12.zzzf) goto L_0x05b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x05b3, code lost:
        r10 = zza(r13, r12.zzzd[r14], r10, r8);
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x05be, code lost:
        if (r10 != null) goto L_0x05c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x05c0, code lost:
        r8.zzg(r13, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:149:0x059d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r13, com.google.android.gms.internal.vision.zzis r14, com.google.android.gms.internal.vision.zzgd r15) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            if (r15 == 0) goto L_0x05dc
            com.google.android.gms.internal.vision.zzjj<?, ?> r8 = r12.zzzi
            com.google.android.gms.internal.vision.zzgf<?> r9 = r12.zzzj
            r1 = r0
            r10 = r1
        L_0x0009:
            int r2 = r14.zzdu()     // Catch:{ all -> 0x05c4 }
            int r3 = r12.zzbs(r2)     // Catch:{ all -> 0x05c4 }
            if (r3 >= 0) goto L_0x0077
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x002f
            int r14 = r12.zzze
        L_0x001a:
            int r15 = r12.zzzf
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzzd
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x002e
            r8.zzg(r13, r10)
        L_0x002e:
            return
        L_0x002f:
            boolean r3 = r12.zzyz     // Catch:{ all -> 0x05c4 }
            if (r3 != 0) goto L_0x0035
            r3 = r0
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.vision.zzic r3 = r12.zzyy     // Catch:{ all -> 0x05c4 }
            java.lang.Object r2 = r9.zza(r15, r3, r2)     // Catch:{ all -> 0x05c4 }
            r3 = r2
        L_0x003c:
            if (r3 == 0) goto L_0x0051
            if (r1 != 0) goto L_0x0044
            com.google.android.gms.internal.vision.zzgi r1 = r9.zzf(r13)     // Catch:{ all -> 0x05c4 }
        L_0x0044:
            r11 = r1
            r1 = r9
            r2 = r14
            r4 = r15
            r5 = r11
            r6 = r10
            r7 = r8
            java.lang.Object r10 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x05c4 }
            r1 = r11
            goto L_0x0009
        L_0x0051:
            r8.zza(r14)     // Catch:{ all -> 0x05c4 }
            if (r10 != 0) goto L_0x005a
            java.lang.Object r10 = r8.zzw(r13)     // Catch:{ all -> 0x05c4 }
        L_0x005a:
            boolean r2 = r8.zza(r10, r14)     // Catch:{ all -> 0x05c4 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzze
        L_0x0062:
            int r15 = r12.zzzf
            if (r14 >= r15) goto L_0x0071
            int[] r15 = r12.zzzd
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0062
        L_0x0071:
            if (r10 == 0) goto L_0x0076
            r8.zzg(r13, r10)
        L_0x0076:
            return
        L_0x0077:
            int r4 = r12.zzbp(r3)     // Catch:{ all -> 0x05c4 }
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r5 = r5 & r4
            int r5 = r5 >>> 20
            r6 = 1048575(0xfffff, float:1.469367E-39)
            switch(r5) {
                case 0: goto L_0x0571;
                case 1: goto L_0x0562;
                case 2: goto L_0x0553;
                case 3: goto L_0x0544;
                case 4: goto L_0x0535;
                case 5: goto L_0x0526;
                case 6: goto L_0x0517;
                case 7: goto L_0x0508;
                case 8: goto L_0x0500;
                case 9: goto L_0x04cf;
                case 10: goto L_0x04c0;
                case 11: goto L_0x04b1;
                case 12: goto L_0x048f;
                case 13: goto L_0x0480;
                case 14: goto L_0x0471;
                case 15: goto L_0x0462;
                case 16: goto L_0x0453;
                case 17: goto L_0x0422;
                case 18: goto L_0x0414;
                case 19: goto L_0x0406;
                case 20: goto L_0x03f8;
                case 21: goto L_0x03ea;
                case 22: goto L_0x03dc;
                case 23: goto L_0x03ce;
                case 24: goto L_0x03c0;
                case 25: goto L_0x03b2;
                case 26: goto L_0x0390;
                case 27: goto L_0x037e;
                case 28: goto L_0x0370;
                case 29: goto L_0x0362;
                case 30: goto L_0x034d;
                case 31: goto L_0x033f;
                case 32: goto L_0x0331;
                case 33: goto L_0x0323;
                case 34: goto L_0x0315;
                case 35: goto L_0x0307;
                case 36: goto L_0x02f9;
                case 37: goto L_0x02eb;
                case 38: goto L_0x02dd;
                case 39: goto L_0x02cf;
                case 40: goto L_0x02c1;
                case 41: goto L_0x02b3;
                case 42: goto L_0x02a5;
                case 43: goto L_0x0297;
                case 44: goto L_0x0282;
                case 45: goto L_0x0274;
                case 46: goto L_0x0266;
                case 47: goto L_0x0258;
                case 48: goto L_0x024a;
                case 49: goto L_0x0238;
                case 50: goto L_0x01f6;
                case 51: goto L_0x01e4;
                case 52: goto L_0x01d2;
                case 53: goto L_0x01c0;
                case 54: goto L_0x01ae;
                case 55: goto L_0x019c;
                case 56: goto L_0x018a;
                case 57: goto L_0x0178;
                case 58: goto L_0x0166;
                case 59: goto L_0x015e;
                case 60: goto L_0x012d;
                case 61: goto L_0x011f;
                case 62: goto L_0x010d;
                case 63: goto L_0x00e8;
                case 64: goto L_0x00d6;
                case 65: goto L_0x00c4;
                case 66: goto L_0x00b2;
                case 67: goto L_0x00a0;
                case 68: goto L_0x008e;
                default: goto L_0x0086;
            }
        L_0x0086:
            if (r10 != 0) goto L_0x0580
            java.lang.Object r10 = r8.zzif()     // Catch:{ zzhb -> 0x059d }
            goto L_0x0580
        L_0x008e:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzir r6 = r12.zzbm(r3)     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r6 = r14.zzc(r6, r15)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x00a0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            long r6 = r14.zzej()     // Catch:{ zzhb -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x00b2:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            int r6 = r14.zzei()     // Catch:{ zzhb -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x00c4:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            long r6 = r14.zzeh()     // Catch:{ zzhb -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x00d6:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            int r6 = r14.zzeg()     // Catch:{ zzhb -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x00e8:
            int r5 = r14.zzef()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzgy r7 = r12.zzbo(r3)     // Catch:{ zzhb -> 0x059d }
            if (r7 == 0) goto L_0x00ff
            boolean r7 = r7.zzf(r5)     // Catch:{ zzhb -> 0x059d }
            if (r7 == 0) goto L_0x00f9
            goto L_0x00ff
        L_0x00f9:
            java.lang.Object r10 = com.google.android.gms.internal.vision.zzit.zza(r2, r5, r10, r8)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x00ff:
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzhb -> 0x059d }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r6, r4)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x010d:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            int r6 = r14.zzee()     // Catch:{ zzhb -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x011f:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzfh r6 = r14.zzed()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x012d:
            boolean r5 = r12.zza(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            if (r5 == 0) goto L_0x0149
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r6 = com.google.android.gms.internal.vision.zzjp.zzp(r13, r4)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzir r7 = r12.zzbm(r3)     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r7 = r14.zza(r7, r15)     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r6 = com.google.android.gms.internal.vision.zzgt.zzb(r6, r7)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0159
        L_0x0149:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzir r6 = r12.zzbm(r3)     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r6 = r14.zza(r6, r15)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
        L_0x0159:
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x015e:
            r12.zza(r13, r4, r14)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0166:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            boolean r6 = r14.zzeb()     // Catch:{ zzhb -> 0x059d }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0178:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            int r6 = r14.zzea()     // Catch:{ zzhb -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x018a:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            long r6 = r14.zzdz()     // Catch:{ zzhb -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x019c:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            int r6 = r14.zzdy()     // Catch:{ zzhb -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x01ae:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            long r6 = r14.zzdw()     // Catch:{ zzhb -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x01c0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            long r6 = r14.zzdx()     // Catch:{ zzhb -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x01d2:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            float r6 = r14.readFloat()     // Catch:{ zzhb -> 0x059d }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x01e4:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhb -> 0x059d }
            double r6 = r14.readDouble()     // Catch:{ zzhb -> 0x059d }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x01f6:
            java.lang.Object r2 = r12.zzbn(r3)     // Catch:{ zzhb -> 0x059d }
            int r3 = r12.zzbp(r3)     // Catch:{ zzhb -> 0x059d }
            r3 = r3 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r13, r3)     // Catch:{ zzhb -> 0x059d }
            if (r5 != 0) goto L_0x0210
            com.google.android.gms.internal.vision.zzhv r5 = r12.zzzk     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r5 = r5.zzo(r2)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r3, r5)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0227
        L_0x0210:
            com.google.android.gms.internal.vision.zzhv r6 = r12.zzzk     // Catch:{ zzhb -> 0x059d }
            boolean r6 = r6.zzm(r5)     // Catch:{ zzhb -> 0x059d }
            if (r6 == 0) goto L_0x0227
            com.google.android.gms.internal.vision.zzhv r6 = r12.zzzk     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r6 = r6.zzo(r2)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzhv r7 = r12.zzzk     // Catch:{ zzhb -> 0x059d }
            r7.zzc(r6, r5)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r3, r6)     // Catch:{ zzhb -> 0x059d }
            r5 = r6
        L_0x0227:
            com.google.android.gms.internal.vision.zzhv r3 = r12.zzzk     // Catch:{ zzhb -> 0x059d }
            java.util.Map r3 = r3.zzk(r5)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzhv r4 = r12.zzzk     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzht r2 = r4.zzp(r2)     // Catch:{ zzhb -> 0x059d }
            r14.zza(r3, r2, r15)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0238:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzir r2 = r12.zzbm(r3)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzhm r3 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            java.util.List r3 = r3.zza(r13, r4)     // Catch:{ zzhb -> 0x059d }
            r14.zzb(r3, r2, r15)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x024a:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzp(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0258:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzo(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0266:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzn(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0274:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzm(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0282:
            com.google.android.gms.internal.vision.zzhm r5 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzhb -> 0x059d }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzhb -> 0x059d }
            r14.zzl(r4)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzgy r3 = r12.zzbo(r3)     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.vision.zzit.zza(r2, r4, r3, r10, r8)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0297:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzk(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x02a5:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzh(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x02b3:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzg(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x02c1:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzf(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x02cf:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zze(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x02dd:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzc(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x02eb:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzd(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x02f9:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzb(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0307:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zza(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0315:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzp(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0323:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzo(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0331:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzn(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x033f:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzm(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x034d:
            com.google.android.gms.internal.vision.zzhm r5 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzhb -> 0x059d }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzhb -> 0x059d }
            r14.zzl(r4)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzgy r3 = r12.zzbo(r3)     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.vision.zzit.zza(r2, r4, r3, r10, r8)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0362:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzk(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0370:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzj(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x037e:
            com.google.android.gms.internal.vision.zzir r2 = r12.zzbm(r3)     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzhm r5 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            java.util.List r3 = r5.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zza(r3, r2, r15)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0390:
            boolean r2 = zzbr(r4)     // Catch:{ zzhb -> 0x059d }
            if (r2 == 0) goto L_0x03a4
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzi(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x03a4:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.readStringList(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x03b2:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzh(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x03c0:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzg(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x03ce:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzf(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x03dc:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zze(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x03ea:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzc(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x03f8:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzd(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0406:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zzb(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0414:
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhb -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            r14.zza(r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0422:
            boolean r2 = r12.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            if (r2 == 0) goto L_0x0440
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.vision.zzjp.zzp(r13, r4)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzir r3 = r12.zzbm(r3)     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r3 = r14.zzc(r3, r15)     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.vision.zzgt.zzb(r2, r3)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0440:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzir r2 = r12.zzbm(r3)     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r2 = r14.zzc(r2, r15)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r2)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0453:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            long r6 = r14.zzej()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0462:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            int r2 = r14.zzei()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zzb(r13, r4, r2)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0471:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            long r6 = r14.zzeh()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0480:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            int r2 = r14.zzeg()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zzb(r13, r4, r2)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x048f:
            int r5 = r14.zzef()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzgy r7 = r12.zzbo(r3)     // Catch:{ zzhb -> 0x059d }
            if (r7 == 0) goto L_0x04a6
            boolean r7 = r7.zzf(r5)     // Catch:{ zzhb -> 0x059d }
            if (r7 == 0) goto L_0x04a0
            goto L_0x04a6
        L_0x04a0:
            java.lang.Object r10 = com.google.android.gms.internal.vision.zzit.zza(r2, r5, r10, r8)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x04a6:
            r2 = r4 & r6
            long r6 = (long) r2     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zzb(r13, r6, r5)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x04b1:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            int r2 = r14.zzee()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zzb(r13, r4, r2)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x04c0:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzfh r2 = r14.zzed()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r2)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x04cf:
            boolean r2 = r12.zza(r13, r3)     // Catch:{ zzhb -> 0x059d }
            if (r2 == 0) goto L_0x04ed
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.vision.zzjp.zzp(r13, r4)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzir r3 = r12.zzbm(r3)     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r3 = r14.zza(r3, r15)     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.vision.zzgt.zzb(r2, r3)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r2)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x04ed:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzir r2 = r12.zzbm(r3)     // Catch:{ zzhb -> 0x059d }
            java.lang.Object r2 = r14.zza(r2, r15)     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r2)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0500:
            r12.zza(r13, r4, r14)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0508:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            boolean r2 = r14.zzeb()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r2)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0517:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            int r2 = r14.zzea()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zzb(r13, r4, r2)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0526:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            long r6 = r14.zzdz()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0535:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            int r2 = r14.zzdy()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zzb(r13, r4, r2)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0544:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            long r6 = r14.zzdw()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0553:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            long r6 = r14.zzdx()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0562:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            float r2 = r14.readFloat()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r2)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0571:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhb -> 0x059d }
            double r6 = r14.readDouble()     // Catch:{ zzhb -> 0x059d }
            com.google.android.gms.internal.vision.zzjp.zza(r13, r4, r6)     // Catch:{ zzhb -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhb -> 0x059d }
            goto L_0x0009
        L_0x0580:
            boolean r2 = r8.zza(r10, r14)     // Catch:{ zzhb -> 0x059d }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzze
        L_0x0588:
            int r15 = r12.zzzf
            if (r14 >= r15) goto L_0x0597
            int[] r15 = r12.zzzd
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0588
        L_0x0597:
            if (r10 == 0) goto L_0x059c
            r8.zzg(r13, r10)
        L_0x059c:
            return
        L_0x059d:
            r8.zza(r14)     // Catch:{ all -> 0x05c4 }
            if (r10 != 0) goto L_0x05a7
            java.lang.Object r2 = r8.zzw(r13)     // Catch:{ all -> 0x05c4 }
            r10 = r2
        L_0x05a7:
            boolean r2 = r8.zza(r10, r14)     // Catch:{ all -> 0x05c4 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzze
        L_0x05af:
            int r15 = r12.zzzf
            if (r14 >= r15) goto L_0x05be
            int[] r15 = r12.zzzd
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x05af
        L_0x05be:
            if (r10 == 0) goto L_0x05c3
            r8.zzg(r13, r10)
        L_0x05c3:
            return
        L_0x05c4:
            r14 = move-exception
            int r15 = r12.zzze
        L_0x05c7:
            int r0 = r12.zzzf
            if (r15 >= r0) goto L_0x05d6
            int[] r0 = r12.zzzd
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza(r13, r0, r10, r8)
            int r15 = r15 + 1
            goto L_0x05c7
        L_0x05d6:
            if (r10 == 0) goto L_0x05db
            r8.zzg(r13, r10)
        L_0x05db:
            throw r14
        L_0x05dc:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, com.google.android.gms.internal.vision.zzis, com.google.android.gms.internal.vision.zzgd):void");
    }

    private static zzjm zzs(Object obj) {
        zzgs zzgs = (zzgs) obj;
        zzjm zzjm = zzgs.zzwd;
        if (zzjm != zzjm.zzig()) {
            return zzjm;
        }
        zzjm zzih = zzjm.zzih();
        zzgs.zzwd = zzih;
        return zzih;
    }

    private static int zza(byte[] bArr, int i, int i2, zzka zzka, Class<?> cls, zzfb zzfb) throws IOException {
        switch (zzif.zzrr[zzka.ordinal()]) {
            case 1:
                int zzb = zzez.zzb(bArr, i, zzfb);
                zzfb.zzrq = Boolean.valueOf(zzfb.zzrp != 0);
                return zzb;
            case 2:
                return zzez.zze(bArr, i, zzfb);
            case 3:
                zzfb.zzrq = Double.valueOf(zzez.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzfb.zzrq = Integer.valueOf(zzez.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzfb.zzrq = Long.valueOf(zzez.zzb(bArr, i));
                return i + 8;
            case 8:
                zzfb.zzrq = Float.valueOf(zzez.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza = zzez.zza(bArr, i, zzfb);
                zzfb.zzrq = Integer.valueOf(zzfb.zzro);
                return zza;
            case 12:
            case 13:
                int zzb2 = zzez.zzb(bArr, i, zzfb);
                zzfb.zzrq = Long.valueOf(zzfb.zzrp);
                return zzb2;
            case 14:
                return zzez.zza(zzin.zzho().zzf(cls), bArr, i, i2, zzfb);
            case 15:
                int zza2 = zzez.zza(bArr, i, zzfb);
                zzfb.zzrq = Integer.valueOf(zzft.zzau(zzfb.zzro));
                return zza2;
            case 16:
                int zzb3 = zzez.zzb(bArr, i, zzfb);
                zzfb.zzrq = Long.valueOf(zzft.zzr(zzfb.zzrp));
                return zzb3;
            case 17:
                return zzez.zzd(bArr, i, zzfb);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:52)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:86)
        */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0354 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b3  */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.vision.zzfb r30) throws java.io.IOException {
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
            sun.misc.Unsafe r11 = com.google.android.gms.internal.vision.zzig.zzyt
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzgz r11 = (com.google.android.gms.internal.vision.zzgz) r11
            boolean r12 = r11.zzdo()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.vision.zzgz r11 = r11.zzag(r12)
            sun.misc.Unsafe r12 = com.google.android.gms.internal.vision.zzig.zzyt
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x032d;
                case 19: goto L_0x0307;
                case 20: goto L_0x02de;
                case 21: goto L_0x02de;
                case 22: goto L_0x02c4;
                case 23: goto L_0x029d;
                case 24: goto L_0x0276;
                case 25: goto L_0x023e;
                case 26: goto L_0x018b;
                case 27: goto L_0x0171;
                case 28: goto L_0x0119;
                case 29: goto L_0x02c4;
                case 30: goto L_0x00e1;
                case 31: goto L_0x0276;
                case 32: goto L_0x029d;
                case 33: goto L_0x00b0;
                case 34: goto L_0x007f;
                case 35: goto L_0x032d;
                case 36: goto L_0x0307;
                case 37: goto L_0x02de;
                case 38: goto L_0x02de;
                case 39: goto L_0x02c4;
                case 40: goto L_0x029d;
                case 41: goto L_0x0276;
                case 42: goto L_0x023e;
                case 43: goto L_0x02c4;
                case 44: goto L_0x00e1;
                case 45: goto L_0x0276;
                case 46: goto L_0x029d;
                case 47: goto L_0x00b0;
                case 48: goto L_0x007f;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0353
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x0353
            com.google.android.gms.internal.vision.zzir r1 = r0.zzbm(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzrq
            r11.add(r8)
        L_0x005f:
            if (r4 >= r5) goto L_0x0353
            int r8 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r9 = r7.zzro
            if (r2 != r9) goto L_0x0353
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzrq
            r11.add(r8)
            goto L_0x005f
        L_0x007f:
            if (r6 != r10) goto L_0x0087
            int r1 = com.google.android.gms.internal.vision.zzez.zzi(r3, r4, r11, r7)
            goto L_0x0354
        L_0x0087:
            if (r6 != 0) goto L_0x0353
            com.google.android.gms.internal.vision.zzhq r11 = (com.google.android.gms.internal.vision.zzhq) r11
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            long r8 = com.google.android.gms.internal.vision.zzft.zzr(r8)
            r11.zzac(r8)
        L_0x0098:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            long r8 = com.google.android.gms.internal.vision.zzft.zzr(r8)
            r11.zzac(r8)
            goto L_0x0098
        L_0x00b0:
            if (r6 != r10) goto L_0x00b8
            int r1 = com.google.android.gms.internal.vision.zzez.zzh(r3, r4, r11, r7)
            goto L_0x0354
        L_0x00b8:
            if (r6 != 0) goto L_0x0353
            com.google.android.gms.internal.vision.zzgu r11 = (com.google.android.gms.internal.vision.zzgu) r11
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            int r4 = com.google.android.gms.internal.vision.zzft.zzau(r4)
            r11.zzbl(r4)
        L_0x00c9:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            int r4 = com.google.android.gms.internal.vision.zzft.zzau(r4)
            r11.zzbl(r4)
            goto L_0x00c9
        L_0x00e1:
            if (r6 != r10) goto L_0x00e8
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r11, r7)
            goto L_0x00f9
        L_0x00e8:
            if (r6 != 0) goto L_0x0353
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r2, r3, r4, r5, r6, r7)
        L_0x00f9:
            com.google.android.gms.internal.vision.zzgs r1 = (com.google.android.gms.internal.vision.zzgs) r1
            com.google.android.gms.internal.vision.zzjm r3 = r1.zzwd
            com.google.android.gms.internal.vision.zzjm r4 = com.google.android.gms.internal.vision.zzjm.zzig()
            if (r3 != r4) goto L_0x0104
            r3 = 0
        L_0x0104:
            com.google.android.gms.internal.vision.zzgy r4 = r0.zzbo(r8)
            com.google.android.gms.internal.vision.zzjj<?, ?> r5 = r0.zzzi
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzit.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.vision.zzjm r3 = (com.google.android.gms.internal.vision.zzjm) r3
            if (r3 == 0) goto L_0x0116
            r1.zzwd = r3
        L_0x0116:
            r1 = r2
            goto L_0x0354
        L_0x0119:
            if (r6 != r10) goto L_0x0353
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x016c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0167
            if (r4 != 0) goto L_0x012f
            com.google.android.gms.internal.vision.zzfh r4 = com.google.android.gms.internal.vision.zzfh.zzrx
            r11.add(r4)
            goto L_0x0137
        L_0x012f:
            com.google.android.gms.internal.vision.zzfh r6 = com.google.android.gms.internal.vision.zzfh.zza(r3, r1, r4)
            r11.add(r6)
        L_0x0136:
            int r1 = r1 + r4
        L_0x0137:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x0162
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x015d
            if (r4 != 0) goto L_0x0155
            com.google.android.gms.internal.vision.zzfh r4 = com.google.android.gms.internal.vision.zzfh.zzrx
            r11.add(r4)
            goto L_0x0137
        L_0x0155:
            com.google.android.gms.internal.vision.zzfh r6 = com.google.android.gms.internal.vision.zzfh.zza(r3, r1, r4)
            r11.add(r6)
            goto L_0x0136
        L_0x015d:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgm()
            throw r1
        L_0x0162:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x0167:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgm()
            throw r1
        L_0x016c:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x0171:
            if (r6 != r10) goto L_0x0353
            com.google.android.gms.internal.vision.zzir r1 = r0.zzbm(r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x0354
        L_0x018b:
            if (r6 != r10) goto L_0x0353
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            int r1 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x01de
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x01d9
            if (r4 != 0) goto L_0x01a6
            r11.add(r6)
            goto L_0x01b1
        L_0x01a6:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.vision.zzgt.UTF_8
            r8.<init>(r3, r1, r4, r9)
            r11.add(r8)
        L_0x01b0:
            int r1 = r1 + r4
        L_0x01b1:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r8 = r7.zzro
            if (r2 != r8) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x01d4
            if (r4 != 0) goto L_0x01c9
            r11.add(r6)
            goto L_0x01b1
        L_0x01c9:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.vision.zzgt.UTF_8
            r8.<init>(r3, r1, r4, r9)
            r11.add(r8)
            goto L_0x01b0
        L_0x01d4:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x01d9:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x01de:
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x0239
            if (r4 != 0) goto L_0x01ec
            r11.add(r6)
            goto L_0x01ff
        L_0x01ec:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.vision.zzjs.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0234
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.vision.zzgt.UTF_8
            r9.<init>(r3, r1, r4, r10)
            r11.add(r9)
        L_0x01fe:
            r1 = r8
        L_0x01ff:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r8 = r7.zzro
            if (r2 != r8) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x022f
            if (r4 != 0) goto L_0x0217
            r11.add(r6)
            goto L_0x01ff
        L_0x0217:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.vision.zzjs.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x022a
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.vision.zzgt.UTF_8
            r9.<init>(r3, r1, r4, r10)
            r11.add(r9)
            goto L_0x01fe
        L_0x022a:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgt()
            throw r1
        L_0x022f:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x0234:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgt()
            throw r1
        L_0x0239:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x023e:
            if (r6 != r10) goto L_0x0246
            int r1 = com.google.android.gms.internal.vision.zzez.zzg(r3, r4, r11, r7)
            goto L_0x0354
        L_0x0246:
            if (r6 != 0) goto L_0x0353
            com.google.android.gms.internal.vision.zzff r11 = (com.google.android.gms.internal.vision.zzff) r11
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            int r4 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            r6 = 0
            if (r4 == 0) goto L_0x0257
            r4 = r13
            goto L_0x0258
        L_0x0257:
            r4 = r6
        L_0x0258:
            r11.addBoolean(r4)
        L_0x025b:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r8 = r7.zzro
            if (r2 != r8) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            int r4 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x0271
            r4 = r13
            goto L_0x0272
        L_0x0271:
            r4 = r6
        L_0x0272:
            r11.addBoolean(r4)
            goto L_0x025b
        L_0x0276:
            if (r6 != r10) goto L_0x027e
            int r1 = com.google.android.gms.internal.vision.zzez.zzc(r3, r4, r11, r7)
            goto L_0x0354
        L_0x027e:
            if (r6 != r9) goto L_0x0353
            com.google.android.gms.internal.vision.zzgu r11 = (com.google.android.gms.internal.vision.zzgu) r11
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r18, r19)
            r11.zzbl(r1)
        L_0x0289:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4)
            r11.zzbl(r1)
            goto L_0x0289
        L_0x029d:
            if (r6 != r10) goto L_0x02a5
            int r1 = com.google.android.gms.internal.vision.zzez.zzd(r3, r4, r11, r7)
            goto L_0x0354
        L_0x02a5:
            if (r6 != r13) goto L_0x0353
            com.google.android.gms.internal.vision.zzhq r11 = (com.google.android.gms.internal.vision.zzhq) r11
            long r8 = com.google.android.gms.internal.vision.zzez.zzb(r18, r19)
            r11.zzac(r8)
        L_0x02b0:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0354
            long r8 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4)
            r11.zzac(r8)
            goto L_0x02b0
        L_0x02c4:
            if (r6 != r10) goto L_0x02cc
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r11, r7)
            goto L_0x0354
        L_0x02cc:
            if (r6 != 0) goto L_0x0353
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r21, r22, r23, r24, r25, r26)
            goto L_0x0354
        L_0x02de:
            if (r6 != r10) goto L_0x02e6
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r11, r7)
            goto L_0x0354
        L_0x02e6:
            if (r6 != 0) goto L_0x0353
            com.google.android.gms.internal.vision.zzhq r11 = (com.google.android.gms.internal.vision.zzhq) r11
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            r11.zzac(r8)
        L_0x02f3:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            r11.zzac(r8)
            goto L_0x02f3
        L_0x0307:
            if (r6 != r10) goto L_0x030e
            int r1 = com.google.android.gms.internal.vision.zzez.zze(r3, r4, r11, r7)
            goto L_0x0354
        L_0x030e:
            if (r6 != r9) goto L_0x0353
            com.google.android.gms.internal.vision.zzgo r11 = (com.google.android.gms.internal.vision.zzgo) r11
            float r1 = com.google.android.gms.internal.vision.zzez.zzd(r18, r19)
            r11.zzu(r1)
        L_0x0319:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0354
            float r1 = com.google.android.gms.internal.vision.zzez.zzd(r3, r4)
            r11.zzu(r1)
            goto L_0x0319
        L_0x032d:
            if (r6 != r10) goto L_0x0334
            int r1 = com.google.android.gms.internal.vision.zzez.zzf(r3, r4, r11, r7)
            goto L_0x0354
        L_0x0334:
            if (r6 != r13) goto L_0x0353
            com.google.android.gms.internal.vision.zzgb r11 = (com.google.android.gms.internal.vision.zzgb) r11
            double r8 = com.google.android.gms.internal.vision.zzez.zzc(r18, r19)
            r11.zzc(r8)
        L_0x033f:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0354
            double r8 = com.google.android.gms.internal.vision.zzez.zzc(r3, r4)
            r11.zzc(r8)
            goto L_0x033f
        L_0x0353:
            r1 = r4
        L_0x0354:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.vision.zzfb):int");
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.vision.zzfb r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = com.google.android.gms.internal.vision.zzig.zzyt
            java.lang.Object r12 = r7.zzbn(r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.vision.zzhv r2 = r7.zzzk
            boolean r2 = r2.zzm(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.vision.zzhv r2 = r7.zzzk
            java.lang.Object r2 = r2.zzo(r12)
            com.google.android.gms.internal.vision.zzhv r3 = r7.zzzk
            r3.zzc(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.vision.zzhv r8 = r7.zzzk
            com.google.android.gms.internal.vision.zzht r8 = r8.zzp(r12)
            com.google.android.gms.internal.vision.zzhv r12 = r7.zzzk
            java.util.Map r12 = r12.zzk(r1)
            int r10 = com.google.android.gms.internal.vision.zzez.zza(r9, r10, r15)
            int r13 = r15.zzro
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzyn
            V r0 = r8.zzgc
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r10, r9, r1, r15)
            int r10 = r15.zzro
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
            com.google.android.gms.internal.vision.zzka r1 = r8.zzyo
            int r1 = r1.zziq()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.vision.zzka r4 = r8.zzyo
            V r10 = r8.zzgc
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza(r1, r2, r3, r4, r5, r6)
            java.lang.Object r0 = r15.zzrq
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.vision.zzka r1 = r8.zzym
            int r1 = r1.zziq()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.vision.zzka r4 = r8.zzym
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza(r1, r2, r3, r4, r5, r6)
            java.lang.Object r14 = r15.zzrq
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.vision.zzez.zza(r10, r9, r2, r11, r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.vision.zzhc r8 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.vision.zzhc r8 = com.google.android.gms.internal.vision.zzhc.zzgm()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.vision.zzfb):int");
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzfb zzfb) throws IOException {
        int i9;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i10 = i;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        long j2 = j;
        int i14 = i8;
        zzfb zzfb2 = zzfb;
        Unsafe unsafe = zzyt;
        long j3 = (long) (this.zzyu[i14 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i13 == 1) {
                    unsafe.putObject(t2, j2, Double.valueOf(zzez.zzc(bArr, i)));
                    i9 = i10 + 8;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 52:
                if (i13 == 5) {
                    unsafe.putObject(t2, j2, Float.valueOf(zzez.zzd(bArr, i)));
                    i9 = i10 + 4;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 53:
            case 54:
                if (i13 == 0) {
                    i9 = zzez.zzb(bArr2, i10, zzfb2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzfb2.zzrp));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 55:
            case 62:
                if (i13 == 0) {
                    i9 = zzez.zza(bArr2, i10, zzfb2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzfb2.zzro));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 56:
            case 65:
                if (i13 == 1) {
                    unsafe.putObject(t2, j2, Long.valueOf(zzez.zzb(bArr, i)));
                    i9 = i10 + 8;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 57:
            case 64:
                if (i13 == 5) {
                    unsafe.putObject(t2, j2, Integer.valueOf(zzez.zza(bArr, i)));
                    i9 = i10 + 4;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 58:
                if (i13 == 0) {
                    i9 = zzez.zzb(bArr2, i10, zzfb2);
                    unsafe.putObject(t2, j2, Boolean.valueOf(zzfb2.zzrp != 0));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 59:
                if (i13 == 2) {
                    int zza = zzez.zza(bArr2, i10, zzfb2);
                    int i15 = zzfb2.zzro;
                    if (i15 == 0) {
                        unsafe.putObject(t2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zzjs.zzf(bArr2, zza, zza + i15)) {
                        unsafe.putObject(t2, j2, new String(bArr2, zza, i15, zzgt.UTF_8));
                        zza += i15;
                    } else {
                        throw zzhc.zzgt();
                    }
                    unsafe.putInt(t2, j3, i12);
                    return zza;
                }
                return i10;
            case 60:
                if (i13 == 2) {
                    int zza2 = zzez.zza(zzbm(i14), bArr2, i10, i2, zzfb2);
                    Object object = unsafe.getInt(t2, j3) == i12 ? unsafe.getObject(t2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t2, j2, zzfb2.zzrq);
                    } else {
                        unsafe.putObject(t2, j2, zzgt.zzb(object, zzfb2.zzrq));
                    }
                    unsafe.putInt(t2, j3, i12);
                    return zza2;
                }
                return i10;
            case 61:
                if (i13 == 2) {
                    i9 = zzez.zze(bArr2, i10, zzfb2);
                    unsafe.putObject(t2, j2, zzfb2.zzrq);
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 63:
                if (i13 == 0) {
                    int zza3 = zzez.zza(bArr2, i10, zzfb2);
                    int i16 = zzfb2.zzro;
                    zzgy zzbo = zzbo(i14);
                    if (zzbo == null || zzbo.zzf(i16)) {
                        unsafe.putObject(t2, j2, Integer.valueOf(i16));
                        i9 = zza3;
                        unsafe.putInt(t2, j3, i12);
                        return i9;
                    }
                    zzs(t).zzb(i11, Long.valueOf((long) i16));
                    return zza3;
                }
                return i10;
            case 66:
                if (i13 == 0) {
                    i9 = zzez.zza(bArr2, i10, zzfb2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzft.zzau(zzfb2.zzro)));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 67:
                if (i13 == 0) {
                    i9 = zzez.zzb(bArr2, i10, zzfb2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzft.zzr(zzfb2.zzrp)));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 68:
                if (i13 == 3) {
                    i9 = zzez.zza(zzbm(i14), bArr, i, i2, (i11 & -8) | 4, zzfb);
                    Object object2 = unsafe.getInt(t2, j3) == i12 ? unsafe.getObject(t2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t2, j2, zzfb2.zzrq);
                    } else {
                        unsafe.putObject(t2, j2, zzgt.zzb(object2, zzfb2.zzrq));
                    }
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            default:
                return i10;
        }
    }

    private final zzir zzbm(int i) {
        int i2 = (i / 3) << 1;
        zzir zzir = (zzir) this.zzyv[i2];
        if (zzir != null) {
            return zzir;
        }
        zzir zzf = zzin.zzho().zzf((Class) this.zzyv[i2 + 1]);
        this.zzyv[i2] = zzf;
        return zzf;
    }

    private final Object zzbn(int i) {
        return this.zzyv[(i / 3) << 1];
    }

    private final zzgy zzbo(int i) {
        return (zzgy) this.zzyv[((i / 3) << 1) + 1];
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r37v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v50, types: [int] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0347, code lost:
        if (r0 == r15) goto L_0x03ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0390, code lost:
        if (r0 == r15) goto L_0x03ba;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0680  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0686  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r33, byte[] r34, int r35, int r36, int r37, com.google.android.gms.internal.vision.zzfb r38) throws java.io.IOException {
        /*
            r32 = this;
            r15 = r32
            r14 = r33
            r12 = r34
            r13 = r36
            r11 = r37
            r9 = r38
            sun.misc.Unsafe r10 = com.google.android.gms.internal.vision.zzig.zzyt
            r16 = 0
            r0 = r35
            r2 = r16
            r3 = r2
            r6 = r3
            r1 = -1
            r7 = -1
        L_0x0018:
            r17 = 0
            if (r0 >= r13) goto L_0x06fb
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r0, r12, r3, r9)
            int r3 = r9.zzro
            r4 = r0
            r5 = r3
            goto L_0x002d
        L_0x002b:
            r5 = r0
            r4 = r3
        L_0x002d:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x003a
            int r2 = r2 / r8
            int r1 = r15.zzt(r3, r2)
            goto L_0x003e
        L_0x003a:
            int r1 = r15.zzbs(r3)
        L_0x003e:
            r2 = r1
            r19 = 0
            r8 = -1
            if (r2 != r8) goto L_0x0051
            r23 = r3
            r2 = r4
            r9 = r5
            r29 = r10
            r8 = r11
            r27 = r16
            r18 = 1
            goto L_0x03be
        L_0x0051:
            int[] r8 = r15.zzyu
            int r22 = r2 + 1
            r1 = r8[r22]
            r22 = 267386880(0xff00000, float:2.3665827E-29)
            r22 = r1 & r22
            int r11 = r22 >>> 20
            r22 = 1048575(0xfffff, float:1.469367E-39)
            r24 = r5
            r5 = r1 & r22
            long r12 = (long) r5
            r5 = 17
            if (r11 > r5) goto L_0x02b0
            int r23 = r2 + 2
            r8 = r8[r23]
            int r23 = r8 >>> 20
            r21 = 1
            int r23 = r21 << r23
            r8 = r8 & r22
            r25 = r12
            if (r8 == r7) goto L_0x0086
            r12 = -1
            if (r7 == r12) goto L_0x0080
            long r12 = (long) r7
            r10.putInt(r14, r12, r6)
        L_0x0080:
            long r6 = (long) r8
            int r6 = r10.getInt(r14, r6)
            r7 = r8
        L_0x0086:
            r8 = 5
            switch(r11) {
                case 0: goto L_0x027b;
                case 1: goto L_0x0262;
                case 2: goto L_0x0238;
                case 3: goto L_0x0238;
                case 4: goto L_0x021a;
                case 5: goto L_0x01f6;
                case 6: goto L_0x01db;
                case 7: goto L_0x01ba;
                case 8: goto L_0x019b;
                case 9: goto L_0x015e;
                case 10: goto L_0x0146;
                case 11: goto L_0x021a;
                case 12: goto L_0x0117;
                case 13: goto L_0x01db;
                case 14: goto L_0x01f6;
                case 15: goto L_0x00ff;
                case 16: goto L_0x00d8;
                case 17: goto L_0x0096;
                default: goto L_0x008a;
            }
        L_0x008a:
            r5 = r34
            r12 = r2
            r13 = r3
            r35 = r7
            r11 = r24
        L_0x0092:
            r8 = 1
            r7 = r4
            goto L_0x02a0
        L_0x0096:
            r11 = 3
            if (r0 != r11) goto L_0x00d3
            int r0 = r3 << 3
            r5 = r0 | 4
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r2)
            r1 = r34
            r12 = r2
            r2 = r4
            r13 = r3
            r3 = r36
            r4 = r5
            r11 = r24
            r5 = r38
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r23
            if (r1 != 0) goto L_0x00bd
            java.lang.Object r1 = r9.zzrq
            r2 = r25
            r10.putObject(r14, r2, r1)
            goto L_0x00cc
        L_0x00bd:
            r2 = r25
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.zzrq
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzgt.zzb(r1, r4)
            r10.putObject(r14, r2, r1)
        L_0x00cc:
            r6 = r6 | r23
            r3 = r11
            r2 = r12
            r1 = r13
            goto L_0x02fe
        L_0x00d3:
            r12 = r2
            r13 = r3
            r11 = r24
            goto L_0x00fb
        L_0x00d8:
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            if (r0 != 0) goto L_0x00fb
            r8 = r34
            int r17 = com.google.android.gms.internal.vision.zzez.zzb(r8, r4, r9)
            long r0 = r9.zzrp
            long r4 = com.google.android.gms.internal.vision.zzft.zzr(r0)
            r0 = r10
            r1 = r33
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r3 = r11
            r2 = r12
            r1 = r13
            r0 = r17
            goto L_0x0259
        L_0x00fb:
            r5 = r34
            goto L_0x01f2
        L_0x00ff:
            r8 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            if (r0 != 0) goto L_0x01d6
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r8, r4, r9)
            int r1 = r9.zzro
            int r1 = com.google.android.gms.internal.vision.zzft.zzau(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x015a
        L_0x0117:
            r8 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            if (r0 != 0) goto L_0x01d6
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r8, r4, r9)
            int r1 = r9.zzro
            com.google.android.gms.internal.vision.zzgy r4 = r15.zzbo(r12)
            if (r4 == 0) goto L_0x0142
            boolean r4 = r4.zzf(r1)
            if (r4 == 0) goto L_0x0134
            goto L_0x0142
        L_0x0134:
            com.google.android.gms.internal.vision.zzjm r2 = zzs(r33)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzb(r11, r1)
            goto L_0x0234
        L_0x0142:
            r10.putInt(r14, r2, r1)
            goto L_0x015a
        L_0x0146:
            r8 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            r1 = 2
            if (r0 != r1) goto L_0x01d6
            int r0 = com.google.android.gms.internal.vision.zzez.zze(r8, r4, r9)
            java.lang.Object r1 = r9.zzrq
            r10.putObject(r14, r2, r1)
        L_0x015a:
            r6 = r6 | r23
            goto L_0x0234
        L_0x015e:
            r8 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            r1 = 2
            if (r0 != r1) goto L_0x0198
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r12)
            r1 = r36
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r0, r8, r4, r1, r9)
            r4 = r6 & r23
            if (r4 != 0) goto L_0x017d
            java.lang.Object r4 = r9.zzrq
            r10.putObject(r14, r2, r4)
            goto L_0x018a
        L_0x017d:
            java.lang.Object r4 = r10.getObject(r14, r2)
            java.lang.Object r5 = r9.zzrq
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzgt.zzb(r4, r5)
            r10.putObject(r14, r2, r4)
        L_0x018a:
            r6 = r6 | r23
            r3 = r11
            r2 = r12
            r11 = r37
            r12 = r8
            r30 = r13
            r13 = r1
            r1 = r30
            goto L_0x0018
        L_0x0198:
            r1 = r36
            goto L_0x01d6
        L_0x019b:
            r8 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            r5 = 2
            if (r0 != r5) goto L_0x01d6
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x01b0
            int r0 = com.google.android.gms.internal.vision.zzez.zzc(r8, r4, r9)
            goto L_0x01b4
        L_0x01b0:
            int r0 = com.google.android.gms.internal.vision.zzez.zzd(r8, r4, r9)
        L_0x01b4:
            java.lang.Object r1 = r9.zzrq
            r10.putObject(r14, r2, r1)
            goto L_0x015a
        L_0x01ba:
            r8 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            if (r0 != 0) goto L_0x01d6
            int r0 = com.google.android.gms.internal.vision.zzez.zzb(r8, r4, r9)
            long r4 = r9.zzrp
            int r1 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r1 == 0) goto L_0x01d0
            r1 = 1
            goto L_0x01d2
        L_0x01d0:
            r1 = r16
        L_0x01d2:
            com.google.android.gms.internal.vision.zzjp.zza(r14, r2, r1)
            goto L_0x015a
        L_0x01d6:
            r35 = r7
            r5 = r8
            goto L_0x0092
        L_0x01db:
            r5 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            if (r0 != r8) goto L_0x01f2
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r5, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
            r6 = r6 | r23
            goto L_0x0296
        L_0x01f2:
            r35 = r7
            goto L_0x0092
        L_0x01f6:
            r5 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            r1 = 1
            if (r0 != r1) goto L_0x0214
            long r19 = com.google.android.gms.internal.vision.zzez.zzb(r5, r4)
            r0 = r10
            r1 = r33
            r8 = r5
            r35 = r7
            r7 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x0230
        L_0x0214:
            r35 = r7
            r7 = r4
            r8 = r1
            goto L_0x02a0
        L_0x021a:
            r8 = r34
            r12 = r2
            r13 = r3
            r35 = r7
            r11 = r24
            r2 = r25
            r7 = r4
            if (r0 != 0) goto L_0x0260
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r8, r7, r9)
            int r1 = r9.zzro
            r10.putInt(r14, r2, r1)
        L_0x0230:
            r6 = r6 | r23
            r7 = r35
        L_0x0234:
            r3 = r11
            r2 = r12
            r1 = r13
            goto L_0x0259
        L_0x0238:
            r8 = r34
            r12 = r2
            r13 = r3
            r35 = r7
            r11 = r24
            r2 = r25
            r7 = r4
            if (r0 != 0) goto L_0x0260
            int r7 = com.google.android.gms.internal.vision.zzez.zzb(r8, r7, r9)
            long r4 = r9.zzrp
            r0 = r10
            r1 = r33
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r0 = r7
            r3 = r11
            r2 = r12
            r1 = r13
            r7 = r35
        L_0x0259:
            r13 = r36
            r11 = r37
            r12 = r8
            goto L_0x0018
        L_0x0260:
            r5 = r8
            goto L_0x0279
        L_0x0262:
            r5 = r34
            r12 = r2
            r13 = r3
            r35 = r7
            r11 = r24
            r2 = r25
            r7 = r4
            if (r0 != r8) goto L_0x0279
            float r0 = com.google.android.gms.internal.vision.zzez.zzd(r5, r7)
            com.google.android.gms.internal.vision.zzjp.zza(r14, r2, r0)
            int r0 = r7 + 4
            goto L_0x0292
        L_0x0279:
            r8 = 1
            goto L_0x02a0
        L_0x027b:
            r5 = r34
            r12 = r2
            r13 = r3
            r35 = r7
            r11 = r24
            r2 = r25
            r8 = 1
            r7 = r4
            if (r0 != r8) goto L_0x02a0
            double r0 = com.google.android.gms.internal.vision.zzez.zzc(r5, r7)
            com.google.android.gms.internal.vision.zzjp.zza(r14, r2, r0)
            int r0 = r7 + 8
        L_0x0292:
            r6 = r6 | r23
            r7 = r35
        L_0x0296:
            r3 = r11
            r2 = r12
            r1 = r13
            r13 = r36
            r11 = r37
            r12 = r5
            goto L_0x0018
        L_0x02a0:
            r2 = r7
            r18 = r8
            r29 = r10
            r9 = r11
            r27 = r12
            r23 = r13
            r7 = r35
            r8 = r37
            goto L_0x03be
        L_0x02b0:
            r5 = r34
            r21 = r7
            r7 = r4
            r4 = r24
            r30 = r12
            r12 = r2
            r13 = r3
            r2 = r30
            r8 = 27
            if (r11 != r8) goto L_0x0315
            r8 = 2
            if (r0 != r8) goto L_0x0306
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.vision.zzgz r0 = (com.google.android.gms.internal.vision.zzgz) r0
            boolean r1 = r0.zzdo()
            if (r1 != 0) goto L_0x02e2
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02d9
            r1 = 10
            goto L_0x02db
        L_0x02d9:
            int r1 = r1 << 1
        L_0x02db:
            com.google.android.gms.internal.vision.zzgz r0 = r0.zzag(r1)
            r10.putObject(r14, r2, r0)
        L_0x02e2:
            r8 = r0
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r12)
            r1 = r4
            r2 = r34
            r3 = r7
            r11 = r4
            r4 = r36
            r5 = r8
            r24 = r6
            r6 = r38
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r0, r1, r2, r3, r4, r5, r6)
            r3 = r11
            r2 = r12
            r1 = r13
            r7 = r21
            r6 = r24
        L_0x02fe:
            r12 = r34
            r13 = r36
            r11 = r37
            goto L_0x0018
        L_0x0306:
            r24 = r6
            r22 = r4
            r15 = r7
            r29 = r10
            r27 = r12
            r23 = r13
            r18 = 1
            goto L_0x0393
        L_0x0315:
            r8 = r4
            r24 = r6
            r4 = 49
            if (r11 > r4) goto L_0x0365
            long r5 = (long) r1
            r4 = r0
            r0 = r32
            r1 = r33
            r25 = r2
            r2 = r34
            r3 = r7
            r35 = r4
            r4 = r36
            r27 = r5
            r5 = r8
            r6 = r13
            r15 = r7
            r7 = r35
            r22 = r8
            r18 = 1
            r8 = r12
            r29 = r10
            r9 = r27
            r27 = r12
            r23 = r13
            r12 = r25
            r14 = r38
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 != r15) goto L_0x034b
            goto L_0x03ba
        L_0x034b:
            r15 = r32
            r14 = r33
            r12 = r34
            r13 = r36
            r11 = r37
            r9 = r38
            r7 = r21
            r3 = r22
            r1 = r23
            r6 = r24
            r2 = r27
            r10 = r29
            goto L_0x0018
        L_0x0365:
            r35 = r0
            r25 = r2
            r15 = r7
            r22 = r8
            r29 = r10
            r27 = r12
            r23 = r13
            r18 = 1
            r0 = 50
            if (r11 != r0) goto L_0x039d
            r7 = r35
            r0 = 2
            if (r7 != r0) goto L_0x0393
            r0 = r32
            r1 = r33
            r2 = r34
            r3 = r15
            r4 = r36
            r5 = r27
            r6 = r25
            r8 = r38
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r8)
            if (r0 != r15) goto L_0x034b
            goto L_0x03ba
        L_0x0393:
            r8 = r37
            r2 = r15
        L_0x0396:
            r7 = r21
            r9 = r22
            r6 = r24
            goto L_0x03be
        L_0x039d:
            r7 = r35
            r0 = r32
            r8 = r1
            r1 = r33
            r2 = r34
            r3 = r15
            r4 = r36
            r5 = r22
            r6 = r23
            r9 = r11
            r10 = r25
            r12 = r27
            r13 = r38
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r15) goto L_0x06df
        L_0x03ba:
            r8 = r37
            r2 = r0
            goto L_0x0396
        L_0x03be:
            if (r9 != r8) goto L_0x03cf
            if (r8 != 0) goto L_0x03c3
            goto L_0x03cf
        L_0x03c3:
            r10 = r32
            r14 = r33
            r0 = r2
            r1 = r6
            r3 = r9
            r2 = -1
            r6 = r36
            goto L_0x0707
        L_0x03cf:
            r10 = r32
            boolean r0 = r10.zzyz
            if (r0 == 0) goto L_0x06b1
            r11 = r38
            com.google.android.gms.internal.vision.zzgd r0 = r11.zzcm
            com.google.android.gms.internal.vision.zzgd r1 = com.google.android.gms.internal.vision.zzgd.zzfl()
            if (r0 == r1) goto L_0x06ae
            com.google.android.gms.internal.vision.zzic r0 = r10.zzyy
            com.google.android.gms.internal.vision.zzjj<?, ?> r1 = r10.zzzi
            com.google.android.gms.internal.vision.zzgd r3 = r11.zzcm
            r12 = r23
            com.google.android.gms.internal.vision.zzgs$zzg r13 = r3.zza(r0, r12)
            if (r13 != 0) goto L_0x0408
            com.google.android.gms.internal.vision.zzjm r4 = zzs(r33)
            r0 = r9
            r1 = r34
            r3 = r36
            r5 = r38
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r0, r1, r2, r3, r4, r5)
            r14 = r33
            r35 = r6
            r21 = r7
            r7 = r34
            r6 = r36
            goto L_0x06ce
        L_0x0408:
            r14 = r33
            r0 = r14
            com.google.android.gms.internal.vision.zzgs$zze r0 = (com.google.android.gms.internal.vision.zzgs.zze) r0
            r0.zzgk()
            com.google.android.gms.internal.vision.zzgi<com.google.android.gms.internal.vision.zzgs$zzd> r15 = r0.zzwk
            com.google.android.gms.internal.vision.zzgs$zzd r3 = r13.zzxb
            boolean r3 = r3.zzwi
            if (r3 == 0) goto L_0x04f9
            com.google.android.gms.internal.vision.zzgs$zzd r3 = r13.zzxb
            boolean r3 = r3.zzwj
            if (r3 == 0) goto L_0x04f9
            int[] r3 = com.google.android.gms.internal.vision.zzfc.zzrr
            com.google.android.gms.internal.vision.zzgs$zzd r4 = r13.zzxb
            com.google.android.gms.internal.vision.zzka r4 = r4.zzwh
            int r4 = r4.ordinal()
            r3 = r3[r4]
            switch(r3) {
                case 1: goto L_0x04e4;
                case 2: goto L_0x04d8;
                case 3: goto L_0x04cc;
                case 4: goto L_0x04cc;
                case 5: goto L_0x04c0;
                case 6: goto L_0x04c0;
                case 7: goto L_0x04b4;
                case 8: goto L_0x04b4;
                case 9: goto L_0x04a8;
                case 10: goto L_0x04a8;
                case 11: goto L_0x049c;
                case 12: goto L_0x0490;
                case 13: goto L_0x0484;
                case 14: goto L_0x0456;
                default: goto L_0x042d;
            }
        L_0x042d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r13.zzxb
            com.google.android.gms.internal.vision.zzka r1 = r1.zzwh
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r2 = r2 + 23
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Type cannot be packed: "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x0456:
            com.google.android.gms.internal.vision.zzgu r3 = new com.google.android.gms.internal.vision.zzgu
            r3.<init>()
            r5 = r34
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r5, r2, r3, r11)
            com.google.android.gms.internal.vision.zzjm r4 = r0.zzwd
            r35 = r2
            com.google.android.gms.internal.vision.zzjm r2 = com.google.android.gms.internal.vision.zzjm.zzig()
            if (r4 != r2) goto L_0x046d
            r4 = r17
        L_0x046d:
            com.google.android.gms.internal.vision.zzgs$zzd r2 = r13.zzxb
            com.google.android.gms.internal.vision.zzgv<?> r2 = r2.zzwg
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzit.zza(r12, r3, r2, r4, r1)
            com.google.android.gms.internal.vision.zzjm r1 = (com.google.android.gms.internal.vision.zzjm) r1
            if (r1 == 0) goto L_0x047b
            r0.zzwd = r1
        L_0x047b:
            com.google.android.gms.internal.vision.zzgs$zzd r0 = r13.zzxb
            r15.zza(r0, r3)
            r2 = r35
            goto L_0x0526
        L_0x0484:
            r5 = r34
            com.google.android.gms.internal.vision.zzhq r0 = new com.google.android.gms.internal.vision.zzhq
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzi(r5, r2, r0, r11)
            goto L_0x04ef
        L_0x0490:
            r5 = r34
            com.google.android.gms.internal.vision.zzgu r0 = new com.google.android.gms.internal.vision.zzgu
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzh(r5, r2, r0, r11)
            goto L_0x04ef
        L_0x049c:
            r5 = r34
            com.google.android.gms.internal.vision.zzff r0 = new com.google.android.gms.internal.vision.zzff
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzg(r5, r2, r0, r11)
            goto L_0x04ef
        L_0x04a8:
            r5 = r34
            com.google.android.gms.internal.vision.zzgu r0 = new com.google.android.gms.internal.vision.zzgu
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzc(r5, r2, r0, r11)
            goto L_0x04ef
        L_0x04b4:
            r5 = r34
            com.google.android.gms.internal.vision.zzhq r0 = new com.google.android.gms.internal.vision.zzhq
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzd(r5, r2, r0, r11)
            goto L_0x04ef
        L_0x04c0:
            r5 = r34
            com.google.android.gms.internal.vision.zzgu r0 = new com.google.android.gms.internal.vision.zzgu
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r5, r2, r0, r11)
            goto L_0x04ef
        L_0x04cc:
            r5 = r34
            com.google.android.gms.internal.vision.zzhq r0 = new com.google.android.gms.internal.vision.zzhq
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r5, r2, r0, r11)
            goto L_0x04ef
        L_0x04d8:
            r5 = r34
            com.google.android.gms.internal.vision.zzgo r0 = new com.google.android.gms.internal.vision.zzgo
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zze(r5, r2, r0, r11)
            goto L_0x04ef
        L_0x04e4:
            r5 = r34
            com.google.android.gms.internal.vision.zzgb r0 = new com.google.android.gms.internal.vision.zzgb
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzf(r5, r2, r0, r11)
        L_0x04ef:
            r2 = r1
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            goto L_0x06a7
        L_0x04f9:
            r5 = r34
            com.google.android.gms.internal.vision.zzgs$zzd r3 = r13.zzxb
            com.google.android.gms.internal.vision.zzka r3 = r3.zzwh
            com.google.android.gms.internal.vision.zzka r4 = com.google.android.gms.internal.vision.zzka.ENUM
            if (r3 != r4) goto L_0x053e
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r5, r2, r11)
            com.google.android.gms.internal.vision.zzgs$zzd r3 = r13.zzxb
            com.google.android.gms.internal.vision.zzgv<?> r3 = r3.zzwg
            int r4 = r11.zzro
            com.google.android.gms.internal.vision.zzgw r3 = r3.zzg(r4)
            if (r3 != 0) goto L_0x052f
            com.google.android.gms.internal.vision.zzjm r3 = r0.zzwd
            com.google.android.gms.internal.vision.zzjm r4 = com.google.android.gms.internal.vision.zzjm.zzig()
            if (r3 != r4) goto L_0x0521
            com.google.android.gms.internal.vision.zzjm r3 = com.google.android.gms.internal.vision.zzjm.zzih()
            r0.zzwd = r3
        L_0x0521:
            int r0 = r11.zzro
            com.google.android.gms.internal.vision.zzit.zza(r12, r0, r3, r1)
        L_0x0526:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            goto L_0x06ac
        L_0x052f:
            int r0 = r11.zzro
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            r35 = r6
            r21 = r7
            r0 = r17
            r6 = r36
            goto L_0x0573
        L_0x053e:
            int[] r0 = com.google.android.gms.internal.vision.zzfc.zzrr
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r13.zzxb
            com.google.android.gms.internal.vision.zzka r1 = r1.zzwh
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x0667;
                case 2: goto L_0x0654;
                case 3: goto L_0x0641;
                case 4: goto L_0x0641;
                case 5: goto L_0x062e;
                case 6: goto L_0x062e;
                case 7: goto L_0x061e;
                case 8: goto L_0x061e;
                case 9: goto L_0x060e;
                case 10: goto L_0x060e;
                case 11: goto L_0x05f4;
                case 12: goto L_0x05dd;
                case 13: goto L_0x05c6;
                case 14: goto L_0x05be;
                case 15: goto L_0x05af;
                case 16: goto L_0x05a0;
                case 17: goto L_0x0576;
                case 18: goto L_0x0558;
                default: goto L_0x054d;
            }
        L_0x054d:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
        L_0x0554:
            r0 = r17
            goto L_0x067a
        L_0x0558:
            com.google.android.gms.internal.vision.zzin r0 = com.google.android.gms.internal.vision.zzin.zzho()
            com.google.android.gms.internal.vision.zzic r1 = r13.zzxa
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.vision.zzir r0 = r0.zzf(r1)
            r4 = r36
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r0, r5, r2, r4, r11)
            java.lang.Object r0 = r11.zzrq
            r35 = r6
            r21 = r7
            r6 = r4
        L_0x0573:
            r7 = r5
            goto L_0x067a
        L_0x0576:
            r4 = r36
            int r0 = r12 << 3
            r17 = r0 | 4
            com.google.android.gms.internal.vision.zzin r0 = com.google.android.gms.internal.vision.zzin.zzho()
            com.google.android.gms.internal.vision.zzic r1 = r13.zzxa
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.vision.zzir r0 = r0.zzf(r1)
            r1 = r34
            r3 = r36
            r35 = r6
            r6 = r4
            r4 = r17
            r21 = r7
            r7 = r5
            r5 = r38
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r0, r1, r2, r3, r4, r5)
            java.lang.Object r0 = r11.zzrq
            goto L_0x067a
        L_0x05a0:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r2 = com.google.android.gms.internal.vision.zzez.zzc(r7, r2, r11)
            java.lang.Object r0 = r11.zzrq
            goto L_0x067a
        L_0x05af:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r2 = com.google.android.gms.internal.vision.zzez.zze(r7, r2, r11)
            java.lang.Object r0 = r11.zzrq
            goto L_0x067a
        L_0x05be:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Shouldn't reach here."
            r0.<init>(r1)
            throw r0
        L_0x05c6:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r7, r2, r11)
            long r0 = r11.zzrp
            long r0 = com.google.android.gms.internal.vision.zzft.zzr(r0)
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            goto L_0x0554
        L_0x05dd:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r7, r2, r11)
            int r0 = r11.zzro
            int r0 = com.google.android.gms.internal.vision.zzft.zzau(r0)
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x0554
        L_0x05f4:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r7, r2, r11)
            long r0 = r11.zzrp
            int r0 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0606
            goto L_0x0608
        L_0x0606:
            r18 = r16
        L_0x0608:
            java.lang.Boolean r17 = java.lang.Boolean.valueOf(r18)
            goto L_0x0554
        L_0x060e:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r7, r2)
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x0663
        L_0x061e:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            long r0 = com.google.android.gms.internal.vision.zzez.zzb(r7, r2)
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            goto L_0x0676
        L_0x062e:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r7, r2, r11)
            int r0 = r11.zzro
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x0554
        L_0x0641:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r7, r2, r11)
            long r0 = r11.zzrp
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            goto L_0x0554
        L_0x0654:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            float r0 = com.google.android.gms.internal.vision.zzez.zzd(r7, r2)
            java.lang.Float r17 = java.lang.Float.valueOf(r0)
        L_0x0663:
            int r2 = r2 + 4
            goto L_0x0554
        L_0x0667:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            double r0 = com.google.android.gms.internal.vision.zzez.zzc(r7, r2)
            java.lang.Double r17 = java.lang.Double.valueOf(r0)
        L_0x0676:
            int r2 = r2 + 8
            goto L_0x0554
        L_0x067a:
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r13.zzxb
            boolean r1 = r1.zzwi
            if (r1 == 0) goto L_0x0686
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r13.zzxb
            r15.zzb(r1, r0)
            goto L_0x06ac
        L_0x0686:
            int[] r1 = com.google.android.gms.internal.vision.zzfc.zzrr
            com.google.android.gms.internal.vision.zzgs$zzd r3 = r13.zzxb
            com.google.android.gms.internal.vision.zzka r3 = r3.zzwh
            int r3 = r3.ordinal()
            r1 = r1[r3]
            r3 = 17
            if (r1 == r3) goto L_0x069b
            r3 = 18
            if (r1 == r3) goto L_0x069b
            goto L_0x06a7
        L_0x069b:
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r13.zzxb
            java.lang.Object r1 = r15.zza(r1)
            if (r1 == 0) goto L_0x06a7
            java.lang.Object r0 = com.google.android.gms.internal.vision.zzgt.zzb(r1, r0)
        L_0x06a7:
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r13.zzxb
            r15.zza(r1, r0)
        L_0x06ac:
            r0 = r2
            goto L_0x06ce
        L_0x06ae:
            r14 = r33
            goto L_0x06b5
        L_0x06b1:
            r14 = r33
            r11 = r38
        L_0x06b5:
            r35 = r6
            r21 = r7
            r12 = r23
            r7 = r34
            r6 = r36
            com.google.android.gms.internal.vision.zzjm r4 = zzs(r33)
            r0 = r9
            r1 = r34
            r3 = r36
            r5 = r38
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r0, r1, r2, r3, r4, r5)
        L_0x06ce:
            r13 = r6
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r2 = r27
            r10 = r29
            r6 = r35
            r12 = r7
            r11 = r8
            r7 = r21
            goto L_0x0018
        L_0x06df:
            r9 = r22
            r12 = r23
            r15 = r32
            r14 = r33
            r13 = r36
            r11 = r37
            r3 = r9
            r1 = r12
            r7 = r21
            r6 = r24
            r2 = r27
            r10 = r29
            r12 = r34
            r9 = r38
            goto L_0x0018
        L_0x06fb:
            r24 = r6
            r21 = r7
            r29 = r10
            r8 = r11
            r6 = r13
            r10 = r15
            r1 = r24
            r2 = -1
        L_0x0707:
            if (r7 == r2) goto L_0x070f
            long r4 = (long) r7
            r2 = r29
            r2.putInt(r14, r4, r1)
        L_0x070f:
            int r1 = r10.zzze
            r2 = r17
        L_0x0713:
            int r4 = r10.zzzf
            if (r1 >= r4) goto L_0x0726
            int[] r4 = r10.zzzd
            r4 = r4[r1]
            com.google.android.gms.internal.vision.zzjj<?, ?> r5 = r10.zzzi
            java.lang.Object r2 = r10.zza(r14, r4, r2, r5)
            com.google.android.gms.internal.vision.zzjm r2 = (com.google.android.gms.internal.vision.zzjm) r2
            int r1 = r1 + 1
            goto L_0x0713
        L_0x0726:
            if (r2 == 0) goto L_0x072d
            com.google.android.gms.internal.vision.zzjj<?, ?> r1 = r10.zzzi
            r1.zzg(r14, r2)
        L_0x072d:
            if (r8 != 0) goto L_0x0737
            if (r0 != r6) goto L_0x0732
            goto L_0x073b
        L_0x0732:
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r0
        L_0x0737:
            if (r0 > r6) goto L_0x073c
            if (r3 != r8) goto L_0x073c
        L_0x073b:
            return r0
        L_0x073c:
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.vision.zzfb):int");
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, boolean):void
     arg types: [T, long, boolean]
     candidates:
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.vision.zzjp.zza(byte[], long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, float):void
     arg types: [T, long, float]
     candidates:
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.vision.zzjp.zza(byte[], long, byte):void
      com.google.android.gms.internal.vision.zzjp.zza(java.lang.Object, long, float):void */
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
    public final void zza(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.vision.zzfb r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.zzzb
            if (r0 == 0) goto L_0x0260
            sun.misc.Unsafe r9 = com.google.android.gms.internal.vision.zzig.zzyt
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
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r0, r12, r3, r11)
            int r3 = r11.zzro
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
            int r0 = r15.zzt(r7, r2)
            goto L_0x003e
        L_0x003a:
            int r0 = r15.zzbs(r7)
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
            int[] r0 = r15.zzyu
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
            int r6 = com.google.android.gms.internal.vision.zzez.zzb(r12, r8, r11)
            r19 = r1
            long r0 = r11.zzrp
            long r21 = com.google.android.gms.internal.vision.zzft.zzr(r0)
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
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r8, r11)
            int r1 = r11.zzro
            int r1 = com.google.android.gms.internal.vision.zzft.zzau(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x0095:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0162
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r8, r11)
            int r1 = r11.zzro
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x00a4:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            int r0 = com.google.android.gms.internal.vision.zzez.zze(r12, r8, r11)
            java.lang.Object r1 = r11.zzrq
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00b1:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r4)
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r0, r12, r8, r13, r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00c8
            java.lang.Object r1 = r11.zzrq
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00c8:
            java.lang.Object r5 = r11.zzrq
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzgt.zzb(r1, r5)
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00d2:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00df
            int r0 = com.google.android.gms.internal.vision.zzez.zzc(r12, r8, r11)
            goto L_0x00e3
        L_0x00df:
            int r0 = com.google.android.gms.internal.vision.zzez.zzd(r12, r8, r11)
        L_0x00e3:
            java.lang.Object r1 = r11.zzrq
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00e9:
            r2 = r1
            if (r6 != 0) goto L_0x01a6
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r12, r8, r11)
            long r5 = r11.zzrp
            r19 = 0
            int r5 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r5 == 0) goto L_0x00f9
            goto L_0x00fb
        L_0x00f9:
            r0 = r16
        L_0x00fb:
            com.google.android.gms.internal.vision.zzjp.zza(r14, r2, r0)
            r0 = r1
            goto L_0x010d
        L_0x0100:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x01a6
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x010d:
            r2 = r4
            r1 = r7
            goto L_0x015f
        L_0x0111:
            r2 = r1
            if (r6 != r0) goto L_0x01a6
            long r5 = com.google.android.gms.internal.vision.zzez.zzb(r12, r8)
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
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r8, r11)
            int r1 = r11.zzro
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x012f:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0162
            int r6 = com.google.android.gms.internal.vision.zzez.zzb(r12, r8, r11)
            long r4 = r11.zzrp
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
            float r0 = com.google.android.gms.internal.vision.zzez.zzd(r12, r8)
            com.google.android.gms.internal.vision.zzjp.zza(r14, r2, r0)
            int r0 = r8 + 4
            goto L_0x015d
        L_0x0150:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x0162
            double r0 = com.google.android.gms.internal.vision.zzez.zzc(r12, r8)
            com.google.android.gms.internal.vision.zzjp.zza(r14, r2, r0)
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
            com.google.android.gms.internal.vision.zzgz r0 = (com.google.android.gms.internal.vision.zzgz) r0
            boolean r3 = r0.zzdo()
            if (r3 != 0) goto L_0x018e
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0185
            r3 = 10
            goto L_0x0187
        L_0x0185:
            int r3 = r3 << 1
        L_0x0187:
            com.google.android.gms.internal.vision.zzgz r0 = r0.zzag(r3)
            r9.putObject(r14, r1, r0)
        L_0x018e:
            r5 = r0
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r0, r1, r2, r3, r4, r5, r6)
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
            com.google.android.gms.internal.vision.zzjm r4 = zzs(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r0, r1, r2, r3, r4, r5)
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
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgs()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.zzfb):void");
    }

    public final void zzg(T t) {
        int i;
        int i2 = this.zzze;
        while (true) {
            i = this.zzzf;
            if (i2 >= i) {
                break;
            }
            long zzbp = (long) (zzbp(this.zzzd[i2]) & 1048575);
            Object zzp = zzjp.zzp(t, zzbp);
            if (zzp != null) {
                zzjp.zza(t, zzbp, this.zzzk.zzn(zzp));
            }
            i2++;
        }
        int length = this.zzzd.length;
        while (i < length) {
            this.zzzh.zzb(t, (long) this.zzzd[i]);
            i++;
        }
        this.zzzi.zzg(t);
        if (this.zzyz) {
            this.zzzj.zzg(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzjj<UT, UB> zzjj) {
        zzgy zzbo;
        int i2 = this.zzyu[i];
        Object zzp = zzjp.zzp(obj, (long) (zzbp(i) & 1048575));
        if (zzp == null || (zzbo = zzbo(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzzk.zzk(zzp), zzbo, ub, zzjj);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map map, zzgy zzgy, Object obj, zzjj zzjj) {
        zzht<?, ?> zzp = this.zzzk.zzp(zzbn(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zzgy.zzf(((Integer) entry.getValue()).intValue())) {
                if (obj == null) {
                    obj = zzjj.zzif();
                }
                zzfp zzap = zzfh.zzap(zzhu.zza(zzp, entry.getKey(), entry.getValue()));
                try {
                    zzhu.zza(zzap.zzew(), zzp, entry.getKey(), entry.getValue());
                    zzjj.zza(obj, i2, zzap.zzev());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    public final boolean zzt(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.zzze) {
                return !this.zzyz || this.zzzj.zze(t).isInitialized();
            }
            int i5 = this.zzzd[i3];
            int i6 = this.zzyu[i5];
            int zzbp = zzbp(i5);
            if (!this.zzzb) {
                int i7 = this.zzyu[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = zzyt.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzbp) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzbp) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza(t, zzbp, zzbm(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzl = this.zzzk.zzl(zzjp.zzp(t, (long) (zzbp & 1048575)));
                            if (!zzl.isEmpty()) {
                                if (this.zzzk.zzp(zzbn(i5)).zzyo.zzip() == zzkd.MESSAGE) {
                                    zzir zzir = null;
                                    Iterator<?> it = zzl.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzir == null) {
                                            zzir = zzin.zzho().zzf(next.getClass());
                                        }
                                        if (!zzir.zzt(next)) {
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
                List list = (List) zzjp.zzp(t, (long) (zzbp & 1048575));
                if (!list.isEmpty()) {
                    zzir zzbm = zzbm(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzbm.zzt(list.get(i10))) {
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
            } else if (zza(t, i5, i4, i) && !zza(t, zzbp, zzbm(i5))) {
                return false;
            }
            i3++;
        }
    }

    private static boolean zza(Object obj, int i, zzir zzir) {
        return zzir.zzt(zzjp.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzkg zzkg) throws IOException {
        if (obj instanceof String) {
            zzkg.zza(i, (String) obj);
        } else {
            zzkg.zza(i, (zzfh) obj);
        }
    }

    private final void zza(Object obj, int i, zzis zzis) throws IOException {
        if (zzbr(i)) {
            zzjp.zza(obj, (long) (i & 1048575), zzis.zzec());
        } else if (this.zzza) {
            zzjp.zza(obj, (long) (i & 1048575), zzis.readString());
        } else {
            zzjp.zza(obj, (long) (i & 1048575), zzis.zzed());
        }
    }

    private final int zzbp(int i) {
        return this.zzyu[i + 1];
    }

    private final int zzbq(int i) {
        return this.zzyu[i + 2];
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzjp.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzjp.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzjp.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzjp.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzjp.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzzb) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzzb) {
            int zzbp = zzbp(i);
            long j = (long) (zzbp & 1048575);
            switch ((zzbp & 267386880) >>> 20) {
                case 0:
                    return zzjp.zzo(t, j) != 0.0d;
                case 1:
                    return zzjp.zzn(t, j) != 0.0f;
                case 2:
                    return zzjp.zzl(t, j) != 0;
                case 3:
                    return zzjp.zzl(t, j) != 0;
                case 4:
                    return zzjp.zzk(t, j) != 0;
                case 5:
                    return zzjp.zzl(t, j) != 0;
                case 6:
                    return zzjp.zzk(t, j) != 0;
                case 7:
                    return zzjp.zzm(t, j);
                case 8:
                    Object zzp = zzjp.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzfh) {
                        return !zzfh.zzrx.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzjp.zzp(t, j) != null;
                case 10:
                    return !zzfh.zzrx.equals(zzjp.zzp(t, j));
                case 11:
                    return zzjp.zzk(t, j) != 0;
                case 12:
                    return zzjp.zzk(t, j) != 0;
                case 13:
                    return zzjp.zzk(t, j) != 0;
                case 14:
                    return zzjp.zzl(t, j) != 0;
                case 15:
                    return zzjp.zzk(t, j) != 0;
                case 16:
                    return zzjp.zzl(t, j) != 0;
                case 17:
                    return zzjp.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzbq = zzbq(i);
            return (zzjp.zzk(t, (long) (zzbq & 1048575)) & (1 << (zzbq >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zzzb) {
            int zzbq = zzbq(i);
            long j = (long) (zzbq & 1048575);
            zzjp.zzb(t, j, zzjp.zzk(t, j) | (1 << (zzbq >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzjp.zzk(t, (long) (zzbq(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzjp.zzb(t, (long) (zzbq(i2) & 1048575), i);
    }

    private final int zzbs(int i) {
        if (i < this.zzyw || i > this.zzyx) {
            return -1;
        }
        return zzu(i, 0);
    }

    private final int zzt(int i, int i2) {
        if (i < this.zzyw || i > this.zzyx) {
            return -1;
        }
        return zzu(i, i2);
    }

    private final int zzu(int i, int i2) {
        int length = (this.zzyu.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzyu[i4];
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
