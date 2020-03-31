package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzgg;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
final class zzhs<T> implements zzic<T> {
    private static final int[] zzxq = new int[0];
    private static final Unsafe zzxr = zzja.zzdh();
    private final zzho zzxm;
    private final zziu<?, ?> zzxn;
    private final boolean zzxo;
    private final zzfw<?> zzxp;
    private final int[] zzxs;
    private final Object[] zzxt;
    private final int zzxu;
    private final int zzxv;
    private final boolean zzxw;
    private final boolean zzxx;
    private final boolean zzxy;
    private final int[] zzxz;
    private final int zzya;
    private final int zzyb;
    private final zzht zzyc;
    private final zzgy zzyd;
    private final zzhh zzye;

    private zzhs(int[] iArr, Object[] objArr, int i, int i2, zzho zzho, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzht zzht, zzgy zzgy, zziu<?, ?> zziu, zzfw<?> zzfw, zzhh zzhh) {
        this.zzxs = iArr;
        this.zzxt = objArr;
        this.zzxu = i;
        this.zzxv = i2;
        this.zzxw = zzho instanceof zzgg;
        this.zzxx = z;
        this.zzxo = zzfw != null && zzfw.zze(zzho);
        this.zzxy = false;
        this.zzxz = iArr2;
        this.zzya = i3;
        this.zzyb = i4;
        this.zzyc = zzht;
        this.zzyd = zzgy;
        this.zzxn = zziu;
        this.zzxp = zzfw;
        this.zzxm = zzho;
        this.zzye = zzhh;
    }

    static <T> zzhs<T> zza(Class<T> cls, zzhm zzhm, zzht zzht, zzgy zzgy, zziu<?, ?> zziu, zzfw<?> zzfw, zzhh zzhh) {
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
        zzhz zzhz;
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
        zzhm zzhm2 = zzhm;
        if (zzhm2 instanceof zzhz) {
            zzhz zzhz2 = (zzhz) zzhm2;
            char c9 = 0;
            boolean z2 = zzhz2.zzch() == zzgg.zze.zzvu;
            String zzcn = zzhz2.zzcn();
            int length = zzcn.length();
            char charAt15 = zzcn.charAt(0);
            if (charAt15 >= 55296) {
                char c10 = charAt15 & 8191;
                int i24 = 1;
                int i25 = 13;
                while (true) {
                    i = i24 + 1;
                    charAt14 = zzcn.charAt(i24);
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
            char charAt16 = zzcn.charAt(i);
            if (charAt16 >= 55296) {
                char c11 = charAt16 & 8191;
                int i27 = 13;
                while (true) {
                    i23 = i26 + 1;
                    charAt13 = zzcn.charAt(i26);
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
                iArr = zzxq;
                c4 = 0;
            } else {
                int i28 = i26 + 1;
                char charAt17 = zzcn.charAt(i26);
                if (charAt17 >= 55296) {
                    char c12 = charAt17 & 8191;
                    int i29 = 13;
                    while (true) {
                        i22 = i28 + 1;
                        charAt12 = zzcn.charAt(i28);
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
                char charAt18 = zzcn.charAt(i28);
                if (charAt18 >= 55296) {
                    char c13 = charAt18 & 8191;
                    int i31 = 13;
                    while (true) {
                        i21 = i30 + 1;
                        charAt11 = zzcn.charAt(i30);
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
                c3 = zzcn.charAt(i30);
                if (c3 >= 55296) {
                    char c14 = c3 & 8191;
                    int i33 = 13;
                    while (true) {
                        i20 = i32 + 1;
                        charAt10 = zzcn.charAt(i32);
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
                char charAt19 = zzcn.charAt(i32);
                if (charAt19 >= 55296) {
                    char c15 = charAt19 & 8191;
                    int i35 = 13;
                    while (true) {
                        i19 = i34 + 1;
                        charAt9 = zzcn.charAt(i34);
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
                c2 = zzcn.charAt(i34);
                if (c2 >= 55296) {
                    char c16 = c2 & 8191;
                    int i37 = 13;
                    while (true) {
                        i18 = i36 + 1;
                        charAt8 = zzcn.charAt(i36);
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
                char charAt20 = zzcn.charAt(i36);
                if (charAt20 >= 55296) {
                    char c17 = charAt20 & 8191;
                    int i39 = 13;
                    while (true) {
                        i17 = i38 + 1;
                        charAt7 = zzcn.charAt(i38);
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
                char charAt21 = zzcn.charAt(i38);
                if (charAt21 >= 55296) {
                    char c18 = charAt21 & 8191;
                    int i41 = i40;
                    int i42 = 13;
                    while (true) {
                        i16 = i41 + 1;
                        charAt6 = zzcn.charAt(i41);
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
                char charAt22 = zzcn.charAt(i14);
                if (charAt22 >= 55296) {
                    char c19 = charAt22 & 8191;
                    int i44 = i43;
                    int i45 = 13;
                    while (true) {
                        i15 = i44 + 1;
                        charAt5 = zzcn.charAt(i44);
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
            Unsafe unsafe = zzxr;
            Object[] zzco = zzhz2.zzco();
            Class<?> cls3 = zzhz2.zzcj().getClass();
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
                int charAt23 = zzcn.charAt(i49);
                int i54 = length;
                if (charAt23 >= 55296) {
                    int i55 = charAt23 & 8191;
                    int i56 = i53;
                    int i57 = 13;
                    while (true) {
                        i13 = i56 + 1;
                        charAt4 = zzcn.charAt(i56);
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
                char charAt24 = zzcn.charAt(i3);
                int i59 = i58;
                if (charAt24 >= 55296) {
                    char c22 = charAt24 & 8191;
                    int i60 = i59;
                    int i61 = 13;
                    while (true) {
                        i12 = i60 + 1;
                        charAt3 = zzcn.charAt(i60);
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
                    char charAt25 = zzcn.charAt(i4);
                    char c26 = 55296;
                    if (charAt25 >= 55296) {
                        char c27 = charAt25 & 8191;
                        int i63 = 13;
                        while (true) {
                            i11 = i62 + 1;
                            charAt2 = zzcn.charAt(i62);
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
                        objArr[((i52 / 3) << 1) + 1] = zzco[i2];
                        i2++;
                    } else if (i64 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i52 / 3) << 1) + 1] = zzco[i2];
                        i2++;
                    }
                    int i66 = charAt25 << 1;
                    Object obj = zzco[i66];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zzco[i66] = field2;
                    }
                    zzhz = zzhz2;
                    String str2 = zzcn;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i67 = i66 + 1;
                    Object obj2 = zzco[i67];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zzco[i67] = field3;
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
                    zzhz = zzhz2;
                    String str3 = zzcn;
                    int i68 = i2 + 1;
                    Field zza = zza(cls3, (String) zzco[i2]);
                    if (c23 == 9 || c23 == 17) {
                        c8 = 1;
                        objArr[((i52 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c23 == 27 || c23 == '1') {
                            c8 = 1;
                            i10 = i68 + 1;
                            objArr[((i52 / 3) << 1) + 1] = zzco[i68];
                        } else if (c23 == 12 || c23 == 30 || c23 == ',') {
                            c8 = 1;
                            if ((charAt15 & 1) == 1) {
                                i10 = i68 + 1;
                                objArr[((i52 / 3) << 1) + 1] = zzco[i68];
                            }
                        } else {
                            if (c23 == '2') {
                                int i69 = c21 + 1;
                                iArr[c21] = i52;
                                int i70 = (i52 / 3) << 1;
                                int i71 = i68 + 1;
                                objArr[i70] = zzco[i68];
                                if ((charAt24 & 2048) != 0) {
                                    i68 = i71 + 1;
                                    objArr[i70 + 1] = zzco[i71];
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
                        Object obj3 = zzco[i74];
                        i5 = i68;
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = zza(cls3, (String) obj3);
                            zzco[i74] = field;
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
                zzcn = str;
                i49 = i4;
                cls3 = cls2;
                c4 = c24;
                length = i54;
                c = c6;
                z2 = z;
                c3 = c25;
                i2 = i5;
                zzhz2 = zzhz;
            }
            return new zzhs(iArr2, objArr, c3, c4, zzhz2.zzcj(), z2, false, iArr, c, i48, zzht, zzgy, zziu, zzfw, zzhh);
        }
        int zzch = ((zzin) zzhm2).zzch();
        int i77 = zzgg.zze.zzvu;
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

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.fitness.zzie.zze(com.google.android.gms.internal.fitness.zzja.zzo(r10, r6), com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzk(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzj(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzk(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzj(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzj(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzj(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.fitness.zzie.zze(com.google.android.gms.internal.fitness.zzja.zzo(r10, r6), com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.fitness.zzie.zze(com.google.android.gms.internal.fitness.zzja.zzo(r10, r6), com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.fitness.zzie.zze(com.google.android.gms.internal.fitness.zzja.zzo(r10, r6), com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzl(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzj(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzk(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzj(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzk(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.fitness.zzja.zzk(r10, r6) == com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.fitness.zzja.zzm(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.fitness.zzja.zzm(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.fitness.zzja.zzn(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.fitness.zzja.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.fitness.zzie.zze(com.google.android.gms.internal.fitness.zzja.zzo(r10, r6), com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzxs
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzag(r2)
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
            int r4 = r9.zzah(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.fitness.zzja.zzj(r10, r4)
            int r4 = com.google.android.gms.internal.fitness.zzja.zzj(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.fitness.zzja.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.fitness.zzie.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.fitness.zzja.zzo(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)
            boolean r3 = com.google.android.gms.internal.fitness.zzie.zze(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.fitness.zzja.zzo(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)
            boolean r3 = com.google.android.gms.internal.fitness.zzie.zze(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.fitness.zzja.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.fitness.zzie.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.fitness.zzja.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.fitness.zzja.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.fitness.zzja.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.fitness.zzja.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.fitness.zzja.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.fitness.zzja.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.fitness.zzja.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.fitness.zzie.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.fitness.zzja.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.fitness.zzie.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.fitness.zzja.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.fitness.zzja.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.fitness.zzie.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.fitness.zzja.zzl(r10, r6)
            boolean r5 = com.google.android.gms.internal.fitness.zzja.zzl(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.fitness.zzja.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.fitness.zzja.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.fitness.zzja.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.fitness.zzja.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.fitness.zzja.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.fitness.zzja.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.fitness.zzja.zzk(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.fitness.zzja.zzm(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.fitness.zzja.zzm(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.fitness.zzja.zzn(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.fitness.zzja.zzn(r11, r6)
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
            com.google.android.gms.internal.fitness.zziu<?, ?> r0 = r9.zzxn
            java.lang.Object r0 = r0.zzm(r10)
            com.google.android.gms.internal.fitness.zziu<?, ?> r2 = r9.zzxn
            java.lang.Object r2 = r2.zzm(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzxo
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.fitness.zzfw<?> r0 = r9.zzxp
            com.google.android.gms.internal.fitness.zzgb r10 = r0.zza(r10)
            com.google.android.gms.internal.fitness.zzfw<?> r0 = r9.zzxp
            com.google.android.gms.internal.fitness.zzgb r11 = r0.zza(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fitness.zzhs.equals(java.lang.Object, java.lang.Object):boolean");
    }

    public final int hashCode(T t) {
        int i;
        int i2;
        int length = this.zzxs.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzag = zzag(i4);
            int i5 = this.zzxs[i4];
            long j = (long) (1048575 & zzag);
            int i6 = 37;
            switch ((zzag & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    i = zzgk.zzj(Double.doubleToLongBits(zzja.zzn(t, j)));
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    i = Float.floatToIntBits(zzja.zzm(t, j));
                    i3 = i2 + i;
                    break;
                case 2:
                    i2 = i3 * 53;
                    i = zzgk.zzj(zzja.zzk(t, j));
                    i3 = i2 + i;
                    break;
                case 3:
                    i2 = i3 * 53;
                    i = zzgk.zzj(zzja.zzk(t, j));
                    i3 = i2 + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    i = zzja.zzj(t, j);
                    i3 = i2 + i;
                    break;
                case 5:
                    i2 = i3 * 53;
                    i = zzgk.zzj(zzja.zzk(t, j));
                    i3 = i2 + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    i = zzja.zzj(t, j);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    i = zzgk.zzc(zzja.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 8:
                    i2 = i3 * 53;
                    i = ((String) zzja.zzo(t, j)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    Object zzo = zzja.zzo(t, j);
                    if (zzo != null) {
                        i6 = zzo.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    i = zzja.zzo(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    i = zzja.zzj(t, j);
                    i3 = i2 + i;
                    break;
                case 12:
                    i2 = i3 * 53;
                    i = zzja.zzj(t, j);
                    i3 = i2 + i;
                    break;
                case 13:
                    i2 = i3 * 53;
                    i = zzja.zzj(t, j);
                    i3 = i2 + i;
                    break;
                case 14:
                    i2 = i3 * 53;
                    i = zzgk.zzj(zzja.zzk(t, j));
                    i3 = i2 + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    i = zzja.zzj(t, j);
                    i3 = i2 + i;
                    break;
                case 16:
                    i2 = i3 * 53;
                    i = zzgk.zzj(zzja.zzk(t, j));
                    i3 = i2 + i;
                    break;
                case 17:
                    Object zzo2 = zzja.zzo(t, j);
                    if (zzo2 != null) {
                        i6 = zzo2.hashCode();
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
                    i = zzja.zzo(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 50:
                    i2 = i3 * 53;
                    i = zzja.zzo(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 51:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzgk.zzj(Double.doubleToLongBits(zze(t, j)));
                        i3 = i2 + i;
                        break;
                    }
                case 52:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = Float.floatToIntBits(zzf(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 53:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzgk.zzj(zzh(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 54:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzgk.zzj(zzh(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 55:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzg(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 56:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzgk.zzj(zzh(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 57:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzg(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 58:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzgk.zzc(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 59:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = ((String) zzja.zzo(t, j)).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 60:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzja.zzo(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 61:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzja.zzo(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 62:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzg(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 63:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzg(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 64:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzg(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 65:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzgk.zzj(zzh(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 66:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzg(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 67:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzgk.zzj(zzh(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 68:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzja.zzo(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzxn.zzm(t).hashCode();
        return this.zzxo ? (hashCode * 53) + this.zzxp.zza((Object) t).hashCode() : hashCode;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, long):void
     arg types: [T, long, long]
     candidates:
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.fitness.zzja.zza(byte[], long, byte):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, long):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, int):void
     arg types: [T, long, int]
     candidates:
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.fitness.zzja.zza(byte[], long, byte):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, boolean):void
     arg types: [T, long, boolean]
     candidates:
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.fitness.zzja.zza(byte[], long, byte):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, float):void
     arg types: [T, long, float]
     candidates:
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.fitness.zzja.zza(byte[], long, byte):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, float):void */
    public final void zzd(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzxs.length; i += 3) {
                int zzag = zzag(i);
                long j = (long) (1048575 & zzag);
                int i2 = this.zzxs[i];
                switch ((zzag & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza(t, j, zzja.zzn(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza((Object) t, j, zzja.zzm(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza((Object) t, j, zzja.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza((Object) t, j, zzja.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza((Object) t, j, zzja.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza((Object) t, j, zzja.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza((Object) t, j, zzja.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza((Object) t, j, zzja.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza(t, j, zzja.zzo(t2, j));
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
                            zzja.zza(t, j, zzja.zzo(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza((Object) t, j, zzja.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza((Object) t, j, zzja.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza((Object) t, j, zzja.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza((Object) t, j, zzja.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza((Object) t, j, zzja.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzja.zza((Object) t, j, zzja.zzk(t2, j));
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
                        this.zzyd.zza(t, t2, j);
                        break;
                    case 50:
                        zzie.zza(this.zzye, t, t2, j);
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
                            zzja.zza(t, j, zzja.zzo(t2, j));
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
                            zzja.zza(t, j, zzja.zzo(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            if (!this.zzxx) {
                zzie.zza(this.zzxn, t, t2);
                if (this.zzxo) {
                    zzie.zza(this.zzxp, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw null;
    }

    private final void zza(T t, T t2, int i) {
        long zzag = (long) (zzag(i) & 1048575);
        if (zza(t2, i)) {
            Object zzo = zzja.zzo(t, zzag);
            Object zzo2 = zzja.zzo(t2, zzag);
            if (zzo != null && zzo2 != null) {
                zzja.zza(t, zzag, zzgk.zzb(zzo, zzo2));
                zzb(t, i);
            } else if (zzo2 != null) {
                zzja.zza(t, zzag, zzo2);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzag = zzag(i);
        int i2 = this.zzxs[i];
        long j = (long) (zzag & 1048575);
        if (zza(t2, i2, i)) {
            Object zzo = zzja.zzo(t, j);
            Object zzo2 = zzja.zzo(t2, j);
            if (zzo != null && zzo2 != null) {
                zzja.zza(t, j, zzgk.zzb(zzo, zzo2));
                zzb(t, i2, i);
            } else if (zzo2 != null) {
                zzja.zza(t, j, zzo2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzfs.zzh(int, long):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.fitness.zzfs.zzh(int, int):int
      com.google.android.gms.internal.fitness.zzfs.zzh(int, long):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzfs.zzb(int, boolean):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.fitness.zzfs.zzb(int, double):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, float):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, com.google.android.gms.internal.fitness.zzgt):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, com.google.android.gms.internal.fitness.zzho):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, java.lang.String):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, int):void
      com.google.android.gms.internal.fitness.zzfs.zzb(int, long):void
      com.google.android.gms.internal.fitness.zzfs.zzb(int, com.google.android.gms.internal.fitness.zzff):void
      com.google.android.gms.internal.fitness.zzfs.zzb(int, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzfs.zzg(int, long):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.fitness.zzfs.zzg(int, int):int
      com.google.android.gms.internal.fitness.zzfs.zzg(int, long):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzfs.zzb(int, float):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.fitness.zzfs.zzb(int, double):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, com.google.android.gms.internal.fitness.zzgt):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, com.google.android.gms.internal.fitness.zzho):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, java.lang.String):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, boolean):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, int):void
      com.google.android.gms.internal.fitness.zzfs.zzb(int, long):void
      com.google.android.gms.internal.fitness.zzfs.zzb(int, com.google.android.gms.internal.fitness.zzff):void
      com.google.android.gms.internal.fitness.zzfs.zzb(int, float):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzfs.zzb(int, double):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.fitness.zzfs.zzb(int, float):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, com.google.android.gms.internal.fitness.zzgt):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, com.google.android.gms.internal.fitness.zzho):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, java.lang.String):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, boolean):int
      com.google.android.gms.internal.fitness.zzfs.zzb(int, int):void
      com.google.android.gms.internal.fitness.zzfs.zzb(int, long):void
      com.google.android.gms.internal.fitness.zzfs.zzb(int, com.google.android.gms.internal.fitness.zzff):void
      com.google.android.gms.internal.fitness.zzfs.zzb(int, double):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzhs.zza(com.google.android.gms.internal.fitness.zziu, java.lang.Object):int
     arg types: [com.google.android.gms.internal.fitness.zziu<?, ?>, T]
     candidates:
      com.google.android.gms.internal.fitness.zzhs.zza(java.lang.Class<?>, java.lang.String):java.lang.reflect.Field
      com.google.android.gms.internal.fitness.zzhs.zza(java.lang.Object, int):boolean
      com.google.android.gms.internal.fitness.zzhs.zza(java.lang.Object, com.google.android.gms.internal.fitness.zzjo):void
      com.google.android.gms.internal.fitness.zzic.zza(java.lang.Object, com.google.android.gms.internal.fitness.zzjo):void
      com.google.android.gms.internal.fitness.zzhs.zza(com.google.android.gms.internal.fitness.zziu, java.lang.Object):int */
    public final int zzk(T t) {
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
        if (this.zzxx) {
            Unsafe unsafe = zzxr;
            int i17 = 0;
            int i18 = 0;
            while (i17 < this.zzxs.length) {
                int zzag = zzag(i17);
                int i19 = (zzag & i14) >>> 20;
                int i20 = this.zzxs[i17];
                long j2 = (long) (zzag & 1048575);
                int i21 = (i19 < zzgc.DOUBLE_LIST_PACKED.id() || i19 > zzgc.SINT64_LIST_PACKED.id()) ? 0 : this.zzxs[i17 + 2] & 1048575;
                switch (i19) {
                    case 0:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 1:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 2:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzd(i20, zzja.zzk(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 3:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zze(i20, zzja.zzk(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 4:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzg(i20, zzja.zzj(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 5:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzg(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 6:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzj(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 7:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzb(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 8:
                        if (zza(t2, i17)) {
                            Object zzo = zzja.zzo(t2, j2);
                            if (!(zzo instanceof zzff)) {
                                zzb2 = zzfs.zzb(i20, (String) zzo);
                                break;
                            } else {
                                zzb2 = zzfs.zzc(i20, (zzff) zzo);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 9:
                        if (zza(t2, i17)) {
                            zzb2 = zzie.zzc(i20, zzja.zzo(t2, j2), zzae(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 10:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzc(i20, (zzff) zzja.zzo(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 11:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzh(i20, zzja.zzj(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 12:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzl(i20, zzja.zzj(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 13:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzk(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 14:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 15:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzi(i20, zzja.zzj(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 16:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzf(i20, zzja.zzk(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 17:
                        if (zza(t2, i17)) {
                            zzb2 = zzfs.zzc(i20, (zzho) zzja.zzo(t2, j2), zzae(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 18:
                        zzb2 = zzie.zzw(i20, zzd(t2, j2), false);
                        break;
                    case 19:
                        zzb2 = zzie.zzv(i20, zzd(t2, j2), false);
                        break;
                    case 20:
                        zzb2 = zzie.zzo(i20, zzd(t2, j2), false);
                        break;
                    case 21:
                        zzb2 = zzie.zzp(i20, zzd(t2, j2), false);
                        break;
                    case 22:
                        zzb2 = zzie.zzs(i20, zzd(t2, j2), false);
                        break;
                    case 23:
                        zzb2 = zzie.zzw(i20, zzd(t2, j2), false);
                        break;
                    case 24:
                        zzb2 = zzie.zzv(i20, zzd(t2, j2), false);
                        break;
                    case 25:
                        zzb2 = zzie.zzx(i20, zzd(t2, j2), false);
                        break;
                    case 26:
                        zzb2 = zzie.zzc(i20, zzd(t2, j2));
                        break;
                    case 27:
                        zzb2 = zzie.zzc(i20, zzd(t2, j2), zzae(i17));
                        break;
                    case 28:
                        zzb2 = zzie.zzd(i20, zzd(t2, j2));
                        break;
                    case 29:
                        zzb2 = zzie.zzt(i20, zzd(t2, j2), false);
                        break;
                    case 30:
                        zzb2 = zzie.zzr(i20, zzd(t2, j2), false);
                        break;
                    case 31:
                        zzb2 = zzie.zzv(i20, zzd(t2, j2), false);
                        break;
                    case 32:
                        zzb2 = zzie.zzw(i20, zzd(t2, j2), false);
                        break;
                    case 33:
                        zzb2 = zzie.zzu(i20, zzd(t2, j2), false);
                        break;
                    case 34:
                        zzb2 = zzie.zzq(i20, zzd(t2, j2), false);
                        break;
                    case 35:
                        i12 = zzie.zzj((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzxy) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzfs.zzp(i20);
                            i11 = zzfs.zzr(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 36:
                        i12 = zzie.zzi((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzxy) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzfs.zzp(i20);
                            i11 = zzfs.zzr(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 37:
                        i12 = zzie.zzb((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzxy) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzfs.zzp(i20);
                            i11 = zzfs.zzr(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 38:
                        i12 = zzie.zzc((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzxy) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzfs.zzp(i20);
                            i11 = zzfs.zzr(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 39:
                        i12 = zzie.zzf((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzxy) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzfs.zzp(i20);
                            i11 = zzfs.zzr(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 40:
                        i12 = zzie.zzj((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzxy) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzfs.zzp(i20);
                            i11 = zzfs.zzr(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 41:
                        i12 = zzie.zzi((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzxy) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzfs.zzp(i20);
                            i11 = zzfs.zzr(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 42:
                        i12 = zzie.zzk((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzxy) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzfs.zzp(i20);
                            i11 = zzfs.zzr(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 43:
                        i12 = zzie.zzg((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzxy) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzfs.zzp(i20);
                            i11 = zzfs.zzr(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 44:
                        i12 = zzie.zze((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzxy) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzfs.zzp(i20);
                            i11 = zzfs.zzr(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 45:
                        i12 = zzie.zzi((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzxy) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzfs.zzp(i20);
                            i11 = zzfs.zzr(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 46:
                        i12 = zzie.zzj((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzxy) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzfs.zzp(i20);
                            i11 = zzfs.zzr(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 47:
                        i12 = zzie.zzh((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzxy) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzfs.zzp(i20);
                            i11 = zzfs.zzr(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 48:
                        i12 = zzie.zzd((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzxy) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzfs.zzp(i20);
                            i11 = zzfs.zzr(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 49:
                        zzb2 = zzie.zzd(i20, zzd(t2, j2), zzae(i17));
                        break;
                    case 50:
                        zzb2 = this.zzye.zzb(i20, zzja.zzo(t2, j2), zzaf(i17));
                        break;
                    case 51:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 52:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 53:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzd(i20, zzh(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 54:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zze(i20, zzh(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 55:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzg(i20, zzg(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 56:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzg(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 57:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzj(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 58:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzb(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 59:
                        if (zza(t2, i20, i17)) {
                            Object zzo2 = zzja.zzo(t2, j2);
                            if (!(zzo2 instanceof zzff)) {
                                zzb2 = zzfs.zzb(i20, (String) zzo2);
                                break;
                            } else {
                                zzb2 = zzfs.zzc(i20, (zzff) zzo2);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 60:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzie.zzc(i20, zzja.zzo(t2, j2), zzae(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 61:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzc(i20, (zzff) zzja.zzo(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 62:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzh(i20, zzg(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 63:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzl(i20, zzg(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 64:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzk(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 65:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 66:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzi(i20, zzg(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 67:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzf(i20, zzh(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 68:
                        if (zza(t2, i20, i17)) {
                            zzb2 = zzfs.zzc(i20, (zzho) zzja.zzo(t2, j2), zzae(i17));
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
            return i18 + zza((zziu) this.zzxn, (Object) t2);
        }
        Unsafe unsafe2 = zzxr;
        int i22 = -1;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i23 < this.zzxs.length) {
            int zzag2 = zzag(i23);
            int[] iArr = this.zzxs;
            int i26 = iArr[i23];
            int i27 = (zzag2 & 267386880) >>> 20;
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
                i2 = (!this.zzxy || i27 < zzgc.DOUBLE_LIST_PACKED.id() || i27 > zzgc.SINT64_LIST_PACKED.id()) ? 0 : this.zzxs[i23 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzag2 & 1048575);
            switch (i27) {
                case 0:
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i24 += zzfs.zzb(i26, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        z = false;
                        i24 += zzfs.zzb(i26, 0.0f);
                        break;
                    }
                    z = false;
                case 2:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzfs.zzd(i26, unsafe2.getLong(t2, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 3:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzfs.zze(i26, unsafe2.getLong(t2, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 4:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzfs.zzg(i26, unsafe2.getInt(t2, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 5:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzfs.zzg(i26, 0L);
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 6:
                    i4 = 1;
                    if ((i25 & i) != 0) {
                        i3 = 0;
                        i24 += zzfs.zzj(i26, 0);
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
                        i24 += zzfs.zzb(i26, true);
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
                        if (object instanceof zzff) {
                            zzb = zzfs.zzc(i26, (zzff) object);
                        } else {
                            zzb = zzfs.zzb(i26, (String) object);
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
                        zzb = zzie.zzc(i26, unsafe2.getObject(t2, j3), zzae(i23));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 10:
                    if ((i25 & i) != 0) {
                        zzb = zzfs.zzc(i26, (zzff) unsafe2.getObject(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 11:
                    if ((i25 & i) != 0) {
                        zzb = zzfs.zzh(i26, unsafe2.getInt(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 12:
                    if ((i25 & i) != 0) {
                        zzb = zzfs.zzl(i26, unsafe2.getInt(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 13:
                    if ((i25 & i) != 0) {
                        i6 = zzfs.zzk(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 14:
                    if ((i25 & i) != 0) {
                        zzb = zzfs.zzh(i26, 0L);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 15:
                    if ((i25 & i) != 0) {
                        zzb = zzfs.zzi(i26, unsafe2.getInt(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 16:
                    if ((i25 & i) != 0) {
                        zzb = zzfs.zzf(i26, unsafe2.getLong(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 17:
                    if ((i25 & i) != 0) {
                        zzb = zzfs.zzc(i26, (zzho) unsafe2.getObject(t2, j3), zzae(i23));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 18:
                    zzb = zzie.zzw(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 19:
                    i3 = 0;
                    i7 = zzie.zzv(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 20:
                    i3 = 0;
                    i7 = zzie.zzo(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 21:
                    i3 = 0;
                    i7 = zzie.zzp(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 22:
                    i3 = 0;
                    i7 = zzie.zzs(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 23:
                    i3 = 0;
                    i7 = zzie.zzw(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 24:
                    i3 = 0;
                    i7 = zzie.zzv(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 25:
                    i3 = 0;
                    i7 = zzie.zzx(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 26:
                    zzb = zzie.zzc(i26, (List) unsafe2.getObject(t2, j3));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 27:
                    zzb = zzie.zzc(i26, (List<?>) ((List) unsafe2.getObject(t2, j3)), zzae(i23));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 28:
                    zzb = zzie.zzd(i26, (List) unsafe2.getObject(t2, j3));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 29:
                    zzb = zzie.zzt(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 30:
                    i3 = 0;
                    i7 = zzie.zzr(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 31:
                    i3 = 0;
                    i7 = zzie.zzv(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 32:
                    i3 = 0;
                    i7 = zzie.zzw(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 33:
                    i3 = 0;
                    i7 = zzie.zzu(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 34:
                    i3 = 0;
                    i7 = zzie.zzq(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 35:
                    i10 = zzie.zzj((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzxy) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzfs.zzp(i26);
                        i8 = zzfs.zzr(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 36:
                    i10 = zzie.zzi((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzxy) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzfs.zzp(i26);
                        i8 = zzfs.zzr(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 37:
                    i10 = zzie.zzb((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzxy) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzfs.zzp(i26);
                        i8 = zzfs.zzr(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 38:
                    i10 = zzie.zzc((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzxy) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzfs.zzp(i26);
                        i8 = zzfs.zzr(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 39:
                    i10 = zzie.zzf((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzxy) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzfs.zzp(i26);
                        i8 = zzfs.zzr(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 40:
                    i10 = zzie.zzj((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzxy) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzfs.zzp(i26);
                        i8 = zzfs.zzr(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 41:
                    i10 = zzie.zzi((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzxy) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzfs.zzp(i26);
                        i8 = zzfs.zzr(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 42:
                    i10 = zzie.zzk((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzxy) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzfs.zzp(i26);
                        i8 = zzfs.zzr(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 43:
                    i10 = zzie.zzg((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzxy) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzfs.zzp(i26);
                        i8 = zzfs.zzr(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 44:
                    i10 = zzie.zze((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzxy) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzfs.zzp(i26);
                        i8 = zzfs.zzr(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 45:
                    i10 = zzie.zzi((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzxy) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzfs.zzp(i26);
                        i8 = zzfs.zzr(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 46:
                    i10 = zzie.zzj((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzxy) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzfs.zzp(i26);
                        i8 = zzfs.zzr(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 47:
                    i10 = zzie.zzh((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzxy) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzfs.zzp(i26);
                        i8 = zzfs.zzr(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 48:
                    i10 = zzie.zzd((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzxy) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzfs.zzp(i26);
                        i8 = zzfs.zzr(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 49:
                    zzb = zzie.zzd(i26, (List) unsafe2.getObject(t2, j3), zzae(i23));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 50:
                    zzb = this.zzye.zzb(i26, unsafe2.getObject(t2, j3), zzaf(i23));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 51:
                    if (zza(t2, i26, i23)) {
                        zzb = zzfs.zzb(i26, 0.0d);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 52:
                    if (zza(t2, i26, i23)) {
                        i6 = zzfs.zzb(i26, 0.0f);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 53:
                    if (zza(t2, i26, i23)) {
                        zzb = zzfs.zzd(i26, zzh(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 54:
                    if (zza(t2, i26, i23)) {
                        zzb = zzfs.zze(i26, zzh(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 55:
                    if (zza(t2, i26, i23)) {
                        zzb = zzfs.zzg(i26, zzg(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 56:
                    if (zza(t2, i26, i23)) {
                        zzb = zzfs.zzg(i26, 0L);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 57:
                    if (zza(t2, i26, i23)) {
                        i6 = zzfs.zzj(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 58:
                    if (zza(t2, i26, i23)) {
                        i6 = zzfs.zzb(i26, true);
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
                        if (object2 instanceof zzff) {
                            zzb = zzfs.zzc(i26, (zzff) object2);
                        } else {
                            zzb = zzfs.zzb(i26, (String) object2);
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
                        zzb = zzie.zzc(i26, unsafe2.getObject(t2, j3), zzae(i23));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 61:
                    if (zza(t2, i26, i23)) {
                        zzb = zzfs.zzc(i26, (zzff) unsafe2.getObject(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 62:
                    if (zza(t2, i26, i23)) {
                        zzb = zzfs.zzh(i26, zzg(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 63:
                    if (zza(t2, i26, i23)) {
                        zzb = zzfs.zzl(i26, zzg(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 64:
                    if (zza(t2, i26, i23)) {
                        i6 = zzfs.zzk(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 65:
                    if (zza(t2, i26, i23)) {
                        zzb = zzfs.zzh(i26, 0L);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 66:
                    if (zza(t2, i26, i23)) {
                        zzb = zzfs.zzi(i26, zzg(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 67:
                    if (zza(t2, i26, i23)) {
                        zzb = zzfs.zzf(i26, zzh(t2, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 68:
                    if (zza(t2, i26, i23)) {
                        zzb = zzfs.zzc(i26, (zzho) unsafe2.getObject(t2, j3), zzae(i23));
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
        int zza = i24 + zza((zziu) this.zzxn, (Object) t2);
        if (!this.zzxo) {
            return zza;
        }
        zzgb<?> zza2 = this.zzxp.zza((Object) t2);
        for (int i31 = i30; i31 < zza2.zzsj.zzcq(); i31++) {
            Map.Entry<T, Object> zzaj = zza2.zzsj.zzaj(i31);
            i30 += zzgb.zzb((zzgd) zzaj.getKey(), zzaj.getValue());
        }
        for (Map.Entry next : zza2.zzsj.zzcr()) {
            i30 += zzgb.zzb((zzgd) next.getKey(), next.getValue());
        }
        return zza + i30;
    }

    private static <UT, UB> int zza(zziu<UT, UB> zziu, T t) {
        return zziu.zzk(zziu.zzm(t));
    }

    private static List<?> zzd(Object obj, long j) {
        return (List) zzja.zzo(obj, j);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzie.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.fitness.zzjo, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.fitness.zzjo, int]
     candidates:
      com.google.android.gms.internal.fitness.zzie.zzb(int, java.util.List<?>, com.google.android.gms.internal.fitness.zzjo, com.google.android.gms.internal.fitness.zzic):void
      com.google.android.gms.internal.fitness.zzie.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.fitness.zzjo, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzie.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.fitness.zzjo, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.fitness.zzjo, int]
     candidates:
      com.google.android.gms.internal.fitness.zzie.zza(int, java.util.List<?>, com.google.android.gms.internal.fitness.zzjo, com.google.android.gms.internal.fitness.zzic):void
      com.google.android.gms.internal.fitness.zzie.zza(com.google.android.gms.internal.fitness.zzhh, java.lang.Object, java.lang.Object, long):void
      com.google.android.gms.internal.fitness.zzie.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.fitness.zzjo, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.fitness.zzjo r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzay()
            int r1 = com.google.android.gms.internal.fitness.zzgg.zze.zzvx
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.fitness.zziu<?, ?> r0 = r13.zzxn
            zza(r0, r14, r15)
            boolean r0 = r13.zzxo
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.fitness.zzfw<?> r0 = r13.zzxp
            com.google.android.gms.internal.fitness.zzgb r0 = r0.zza(r14)
            com.google.android.gms.internal.fitness.zzid<T, java.lang.Object> r1 = r0.zzsj
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
            int[] r7 = r13.zzxs
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzag(r7)
            int[] r9 = r13.zzxs
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.fitness.zzfw<?> r10 = r13.zzxp
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.fitness.zzfw<?> r10 = r13.zzxp
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
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            com.google.android.gms.internal.fitness.zzic r10 = r13.zzae(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zze(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzm(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzn(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzd(r9, r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            com.google.android.gms.internal.fitness.zzff r8 = (com.google.android.gms.internal.fitness.zzff) r8
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            com.google.android.gms.internal.fitness.zzic r10 = r13.zzae(r7)
            r15.zza(r9, r8, r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            zza(r9, r8, r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzi(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzc(r9, r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzf(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zze(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            r13.zza(r15, r9, r8, r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzic r10 = r13.zzae(r7)
            com.google.android.gms.internal.fitness.zzie.zzb(r9, r8, r15, r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzb(r9, r8, r15, r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zza(r9, r8, r15, r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzb(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzic r10 = r13.zzae(r7)
            com.google.android.gms.internal.fitness.zzie.zza(r9, r8, r15, r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zza(r9, r8, r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zzb(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzxs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.fitness.zzie.zza(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            com.google.android.gms.internal.fitness.zzic r10 = r13.zzae(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r10)
            r15.zze(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r10)
            r15.zzm(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r10)
            r15.zzn(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r10)
            r15.zzd(r9, r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            com.google.android.gms.internal.fitness.zzff r8 = (com.google.android.gms.internal.fitness.zzff) r8
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            com.google.android.gms.internal.fitness.zzic r10 = r13.zzae(r7)
            r15.zza(r9, r8, r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r10)
            zza(r9, r8, r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.fitness.zzja.zzl(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r10)
            r15.zzc(r9, r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.fitness.zzja.zzm(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.fitness.zzja.zzn(r14, r10)
            r15.zza(r9, r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.fitness.zzfw<?> r14 = r13.zzxp
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
            boolean r0 = r13.zzxx
            if (r0 == 0) goto L_0x0a44
            boolean r0 = r13.zzxo
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.fitness.zzfw<?> r0 = r13.zzxp
            com.google.android.gms.internal.fitness.zzgb r0 = r0.zza(r14)
            com.google.android.gms.internal.fitness.zzid<T, java.lang.Object> r1 = r0.zzsj
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
            int[] r7 = r13.zzxs
            int r7 = r7.length
            r8 = r5
        L_0x0550:
            if (r8 >= r7) goto L_0x0a28
            int r9 = r13.zzag(r8)
            int[] r10 = r13.zzxs
            r10 = r10[r8]
        L_0x055a:
            if (r1 == 0) goto L_0x0578
            com.google.android.gms.internal.fitness.zzfw<?> r11 = r13.zzxp
            int r11 = r11.zza(r1)
            if (r11 > r10) goto L_0x0578
            com.google.android.gms.internal.fitness.zzfw<?> r11 = r13.zzxp
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
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            com.google.android.gms.internal.fitness.zzic r11 = r13.zzae(r8)
            r15.zzb(r10, r9, r11)
            goto L_0x0a24
        L_0x0596:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0a24
        L_0x05a7:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0a24
        L_0x05b8:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x05c9:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzm(r10, r9)
            goto L_0x0a24
        L_0x05da:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzn(r10, r9)
            goto L_0x0a24
        L_0x05eb:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzd(r10, r9)
            goto L_0x0a24
        L_0x05fc:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            com.google.android.gms.internal.fitness.zzff r9 = (com.google.android.gms.internal.fitness.zzff) r9
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x060f:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            com.google.android.gms.internal.fitness.zzic r11 = r13.zzae(r8)
            r15.zza(r10, r9, r11)
            goto L_0x0a24
        L_0x0624:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0a24
        L_0x0635:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzi(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x0646:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a24
        L_0x0657:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a24
        L_0x0668:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzc(r10, r9)
            goto L_0x0a24
        L_0x0679:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a24
        L_0x068a:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a24
        L_0x069b:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzf(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x06ac:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zze(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a24
        L_0x06bd:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            r13.zza(r15, r10, r9, r8)
            goto L_0x0a24
        L_0x06c8:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzic r11 = r13.zzae(r8)
            com.google.android.gms.internal.fitness.zzie.zzb(r10, r9, r15, r11)
            goto L_0x0a24
        L_0x06dd:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zze(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ee:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzj(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ff:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzg(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0710:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzl(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0721:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzm(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0732:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzi(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0743:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzn(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0754:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzk(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0765:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzf(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0776:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzh(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0787:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzd(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0798:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzc(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07a9:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzb(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07ba:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zza(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07cb:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zze(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07dc:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzj(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07ed:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzg(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07fe:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzl(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x080f:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzm(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0820:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzi(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0831:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzb(r10, r9, r15)
            goto L_0x0a24
        L_0x0842:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzic r11 = r13.zzae(r8)
            com.google.android.gms.internal.fitness.zzie.zza(r10, r9, r15, r11)
            goto L_0x0a24
        L_0x0857:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zza(r10, r9, r15)
            goto L_0x0a24
        L_0x0868:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzn(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0879:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzk(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x088a:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzf(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x089b:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzh(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ac:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzd(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08bd:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzc(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ce:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzb(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08df:
            int[] r10 = r13.zzxs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zza(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08f0:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            com.google.android.gms.internal.fitness.zzic r11 = r13.zzae(r8)
            r15.zzb(r10, r9, r11)
            goto L_0x0a24
        L_0x0905:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0a24
        L_0x0916:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0a24
        L_0x0927:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x0938:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r11)
            r15.zzm(r10, r9)
            goto L_0x0a24
        L_0x0949:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r11)
            r15.zzn(r10, r9)
            goto L_0x0a24
        L_0x095a:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r11)
            r15.zzd(r10, r9)
            goto L_0x0a24
        L_0x096b:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            com.google.android.gms.internal.fitness.zzff r9 = (com.google.android.gms.internal.fitness.zzff) r9
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x097e:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            com.google.android.gms.internal.fitness.zzic r11 = r13.zzae(r8)
            r15.zza(r10, r9, r11)
            goto L_0x0a24
        L_0x0993:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.fitness.zzja.zzo(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0a24
        L_0x09a4:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.fitness.zzja.zzl(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x09b5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a24
        L_0x09c5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a24
        L_0x09d5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.fitness.zzja.zzj(r14, r11)
            r15.zzc(r10, r9)
            goto L_0x0a24
        L_0x09e5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a24
        L_0x09f5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.fitness.zzja.zzk(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a24
        L_0x0a05:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.fitness.zzja.zzm(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x0a15:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.fitness.zzja.zzn(r14, r11)
            r15.zza(r10, r11)
        L_0x0a24:
            int r8 = r8 + 3
            goto L_0x0550
        L_0x0a28:
            if (r1 == 0) goto L_0x0a3e
            com.google.android.gms.internal.fitness.zzfw<?> r2 = r13.zzxp
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
            com.google.android.gms.internal.fitness.zziu<?, ?> r0 = r13.zzxn
            zza(r0, r14, r15)
            return
        L_0x0a44:
            r13.zzb(r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fitness.zzhs.zza(java.lang.Object, com.google.android.gms.internal.fitness.zzjo):void");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzie.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.fitness.zzjo, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.fitness.zzjo, int]
     candidates:
      com.google.android.gms.internal.fitness.zzie.zzb(int, java.util.List<?>, com.google.android.gms.internal.fitness.zzjo, com.google.android.gms.internal.fitness.zzic):void
      com.google.android.gms.internal.fitness.zzie.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.fitness.zzjo, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzie.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.fitness.zzjo, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.fitness.zzjo, int]
     candidates:
      com.google.android.gms.internal.fitness.zzie.zza(int, java.util.List<?>, com.google.android.gms.internal.fitness.zzjo, com.google.android.gms.internal.fitness.zzic):void
      com.google.android.gms.internal.fitness.zzie.zza(com.google.android.gms.internal.fitness.zzhh, java.lang.Object, java.lang.Object, long):void
      com.google.android.gms.internal.fitness.zzie.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.fitness.zzjo, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.fitness.zzjo r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzxo
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.fitness.zzfw<?> r3 = r0.zzxp
            com.google.android.gms.internal.fitness.zzgb r3 = r3.zza(r1)
            com.google.android.gms.internal.fitness.zzid<T, java.lang.Object> r5 = r3.zzsj
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
            int[] r7 = r0.zzxs
            int r7 = r7.length
            sun.misc.Unsafe r8 = com.google.android.gms.internal.fitness.zzhs.zzxr
            r10 = 0
            r11 = 0
        L_0x002d:
            if (r10 >= r7) goto L_0x0494
            int r12 = r0.zzag(r10)
            int[] r13 = r0.zzxs
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzxx
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
            com.google.android.gms.internal.fitness.zzfw<?> r9 = r0.zzxp
            int r9 = r9.zza(r5)
            if (r9 > r14) goto L_0x007e
            com.google.android.gms.internal.fitness.zzfw<?> r9 = r0.zzxp
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
            com.google.android.gms.internal.fitness.zzic r9 = r0.zzae(r12)
            r2.zzb(r14, r4, r9)
            goto L_0x0086
        L_0x009b:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zzb(r14, r9)
            goto L_0x0086
        L_0x00a9:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zze(r14, r4)
            goto L_0x0086
        L_0x00b7:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zzj(r14, r9)
            goto L_0x0086
        L_0x00c5:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzm(r14, r4)
            goto L_0x0086
        L_0x00d3:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzn(r14, r4)
            goto L_0x0086
        L_0x00e1:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzd(r14, r4)
            goto L_0x0086
        L_0x00ef:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.fitness.zzff r4 = (com.google.android.gms.internal.fitness.zzff) r4
            r2.zza(r14, r4)
            goto L_0x0086
        L_0x00ff:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.fitness.zzic r9 = r0.zzae(r12)
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
            boolean r4 = zzi(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0086
        L_0x0130:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzf(r14, r4)
            goto L_0x0086
        L_0x013f:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zzc(r14, r9)
            goto L_0x0086
        L_0x014e:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzg(r1, r9)
            r2.zzc(r14, r4)
            goto L_0x0086
        L_0x015d:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zza(r14, r9)
            goto L_0x0086
        L_0x016c:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzh(r1, r9)
            r2.zzi(r14, r9)
            goto L_0x0086
        L_0x017b:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            float r4 = zzf(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0086
        L_0x018a:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            double r9 = zze(r1, r9)
            r2.zza(r14, r9)
            goto L_0x0086
        L_0x0199:
            java.lang.Object r4 = r8.getObject(r1, r9)
            r0.zza(r2, r14, r4, r12)
            goto L_0x0086
        L_0x01a2:
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzic r10 = r0.zzae(r12)
            com.google.android.gms.internal.fitness.zzie.zzb(r4, r9, r2, r10)
            goto L_0x0086
        L_0x01b5:
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.fitness.zzie.zze(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01c5:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzj(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01d5:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzg(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01e5:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzl(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01f5:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzm(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0205:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzi(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0215:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzn(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0225:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzk(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0235:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzf(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0245:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzh(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0255:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzd(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0265:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzc(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0275:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzb(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0285:
            r13 = 1
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zza(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0295:
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.fitness.zzie.zze(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02a5:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzj(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02b5:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzg(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02c5:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzl(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02d5:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzm(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02e5:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzi(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02f5:
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzb(r4, r9, r2)
            goto L_0x0086
        L_0x0304:
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzic r10 = r0.zzae(r12)
            com.google.android.gms.internal.fitness.zzie.zza(r4, r9, r2, r10)
            goto L_0x0086
        L_0x0317:
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zza(r4, r9, r2)
            goto L_0x0086
        L_0x0326:
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.fitness.zzie.zzn(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0336:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzk(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0346:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzf(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0356:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzh(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0366:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzd(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0376:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzc(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0386:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zzb(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0396:
            r13 = 0
            int[] r4 = r0.zzxs
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.fitness.zzie.zza(r4, r9, r2, r13)
            goto L_0x0490
        L_0x03a6:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.fitness.zzic r9 = r0.zzae(r12)
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
            r2.zze(r14, r4)
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
            r2.zzm(r14, r4)
            goto L_0x0490
        L_0x03eb:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzn(r14, r4)
            goto L_0x0490
        L_0x03f8:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzd(r14, r4)
            goto L_0x0490
        L_0x0405:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.fitness.zzff r4 = (com.google.android.gms.internal.fitness.zzff) r4
            r2.zza(r14, r4)
            goto L_0x0490
        L_0x0414:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.fitness.zzic r9 = r0.zzae(r12)
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
            boolean r4 = com.google.android.gms.internal.fitness.zzja.zzl(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0490
        L_0x043d:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzf(r14, r4)
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
            r2.zzc(r14, r4)
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
            float r4 = com.google.android.gms.internal.fitness.zzja.zzm(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0490
        L_0x0485:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            double r9 = com.google.android.gms.internal.fitness.zzja.zzn(r1, r9)
            r2.zza(r14, r9)
        L_0x0490:
            int r10 = r12 + 3
            goto L_0x002d
        L_0x0494:
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.fitness.zzfw<?> r4 = r0.zzxp
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
            com.google.android.gms.internal.fitness.zziu<?, ?> r3 = r0.zzxn
            zza(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fitness.zzhs.zzb(java.lang.Object, com.google.android.gms.internal.fitness.zzjo):void");
    }

    private final <K, V> void zza(zzjo zzjo, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzjo.zza(i, this.zzye.zzh(zzaf(i2)), this.zzye.zzf(obj));
        }
    }

    private static <UT, UB> void zza(zziu<UT, UB> zziu, T t, zzjo zzjo) throws IOException {
        zziu.zza(zziu.zzm(t), zzjo);
    }

    private final zzic zzae(int i) {
        int i2 = (i / 3) << 1;
        zzic zzic = (zzic) this.zzxt[i2];
        if (zzic != null) {
            return zzic;
        }
        zzic zze = zzia.zzcp().zze((Class) this.zzxt[i2 + 1]);
        this.zzxt[i2] = zze;
        return zze;
    }

    private final Object zzaf(int i) {
        return this.zzxt[(i / 3) << 1];
    }

    public final void zzc(T t) {
        int i;
        int i2 = this.zzya;
        while (true) {
            i = this.zzyb;
            if (i2 >= i) {
                break;
            }
            long zzag = (long) (zzag(this.zzxz[i2]) & 1048575);
            Object zzo = zzja.zzo(t, zzag);
            if (zzo != null) {
                zzja.zza(t, zzag, this.zzye.zzg(zzo));
            }
            i2++;
        }
        int length = this.zzxz.length;
        while (i < length) {
            this.zzyd.zza(t, (long) this.zzxz[i]);
            i++;
        }
        this.zzxn.zzc(t);
        if (this.zzxo) {
            this.zzxp.zzc(t);
        }
    }

    public final boolean zzj(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.zzya) {
                return !this.zzxo || this.zzxp.zza(t).isInitialized();
            }
            int i5 = this.zzxz[i3];
            int i6 = this.zzxs[i5];
            int zzag = zzag(i5);
            if (!this.zzxx) {
                int i7 = this.zzxs[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = zzxr.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzag) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzag) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza(t, zzag, zzae(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzf = this.zzye.zzf(zzja.zzo(t, (long) (zzag & 1048575)));
                            if (!zzf.isEmpty()) {
                                if (this.zzye.zzh(zzaf(i5)).zzxi.zzdl() == zzjl.MESSAGE) {
                                    zzic zzic = null;
                                    Iterator<?> it = zzf.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzic == null) {
                                            zzic = zzia.zzcp().zze(next.getClass());
                                        }
                                        if (!zzic.zzj(next)) {
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
                List list = (List) zzja.zzo(t, (long) (zzag & 1048575));
                if (!list.isEmpty()) {
                    zzic zzae = zzae(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzae.zzj(list.get(i10))) {
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
            } else if (zza(t, i5, i4, i) && !zza(t, zzag, zzae(i5))) {
                return false;
            }
            i3++;
        }
    }

    private static boolean zza(Object obj, int i, zzic zzic) {
        return zzic.zzj(zzja.zzo(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzjo zzjo) throws IOException {
        if (obj instanceof String) {
            zzjo.zza(i, (String) obj);
        } else {
            zzjo.zza(i, (zzff) obj);
        }
    }

    private final int zzag(int i) {
        return this.zzxs[i + 1];
    }

    private final int zzah(int i) {
        return this.zzxs[i + 2];
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zzja.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zzja.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zzja.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zzja.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zzja.zzo(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzxx) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzxx) {
            int zzag = zzag(i);
            long j = (long) (zzag & 1048575);
            switch ((zzag & 267386880) >>> 20) {
                case 0:
                    return zzja.zzn(t, j) != 0.0d;
                case 1:
                    return zzja.zzm(t, j) != 0.0f;
                case 2:
                    return zzja.zzk(t, j) != 0;
                case 3:
                    return zzja.zzk(t, j) != 0;
                case 4:
                    return zzja.zzj(t, j) != 0;
                case 5:
                    return zzja.zzk(t, j) != 0;
                case 6:
                    return zzja.zzj(t, j) != 0;
                case 7:
                    return zzja.zzl(t, j);
                case 8:
                    Object zzo = zzja.zzo(t, j);
                    if (zzo instanceof String) {
                        return !((String) zzo).isEmpty();
                    }
                    if (zzo instanceof zzff) {
                        return !zzff.zzri.equals(zzo);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzja.zzo(t, j) != null;
                case 10:
                    return !zzff.zzri.equals(zzja.zzo(t, j));
                case 11:
                    return zzja.zzj(t, j) != 0;
                case 12:
                    return zzja.zzj(t, j) != 0;
                case 13:
                    return zzja.zzj(t, j) != 0;
                case 14:
                    return zzja.zzk(t, j) != 0;
                case 15:
                    return zzja.zzj(t, j) != 0;
                case 16:
                    return zzja.zzk(t, j) != 0;
                case 17:
                    return zzja.zzo(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzah = zzah(i);
            return (zzja.zzj(t, (long) (zzah & 1048575)) & (1 << (zzah >>> 20))) != 0;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, int):void
     arg types: [T, long, int]
     candidates:
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.fitness.zzja.zza(byte[], long, byte):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, int):void */
    private final void zzb(T t, int i) {
        if (!this.zzxx) {
            int zzah = zzah(i);
            long j = (long) (zzah & 1048575);
            zzja.zza((Object) t, j, zzja.zzj(t, j) | (1 << (zzah >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzja.zzj(t, (long) (zzah(i2) & 1048575)) == i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, int):void
     arg types: [T, long, int]
     candidates:
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.fitness.zzja.zza(byte[], long, byte):void
      com.google.android.gms.internal.fitness.zzja.zza(java.lang.Object, long, int):void */
    private final void zzb(T t, int i, int i2) {
        zzja.zza((Object) t, (long) (zzah(i2) & 1048575), i);
    }
}
