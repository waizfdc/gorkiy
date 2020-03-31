package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
final class zzgs<T> implements zzhd<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzib.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgo zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzgw zzo;
    private final zzfy zzp;
    private final zzhv<?, ?> zzq;
    private final zzes<?> zzr;
    private final zzgh zzs;

    private zzgs(int[] iArr, Object[] objArr, int i, int i2, zzgo zzgo, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgw zzgw, zzfy zzfy, zzhv<?, ?> zzhv, zzes<?> zzes, zzgh zzgh) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzgo instanceof zzfd;
        this.zzj = z;
        this.zzh = zzes != null && zzes.zza(zzgo);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzgw;
        this.zzp = zzfy;
        this.zzq = zzhv;
        this.zzr = zzes;
        this.zzg = zzgo;
        this.zzs = zzgh;
    }

    private static boolean zzf(int i) {
        return (i & 536870912) != 0;
    }

    static <T> zzgs<T> zza(Class<T> cls, zzgm zzgm, zzgw zzgw, zzfy zzfy, zzhv<?, ?> zzhv, zzes<?> zzes, zzgh zzgh) {
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
        zzhb zzhb;
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
        zzgm zzgm2 = zzgm;
        if (zzgm2 instanceof zzhb) {
            zzhb zzhb2 = (zzhb) zzgm2;
            char c9 = 0;
            boolean z2 = zzhb2.zza() == zzfd.zze.zzi;
            String zzd2 = zzhb2.zzd();
            int length = zzd2.length();
            char charAt15 = zzd2.charAt(0);
            if (charAt15 >= 55296) {
                char c10 = charAt15 & 8191;
                int i24 = 1;
                int i25 = 13;
                while (true) {
                    i = i24 + 1;
                    charAt14 = zzd2.charAt(i24);
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
            char charAt16 = zzd2.charAt(i);
            if (charAt16 >= 55296) {
                char c11 = charAt16 & 8191;
                int i27 = 13;
                while (true) {
                    i23 = i26 + 1;
                    charAt13 = zzd2.charAt(i26);
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
                iArr = zza;
                c4 = 0;
            } else {
                int i28 = i26 + 1;
                char charAt17 = zzd2.charAt(i26);
                if (charAt17 >= 55296) {
                    char c12 = charAt17 & 8191;
                    int i29 = 13;
                    while (true) {
                        i22 = i28 + 1;
                        charAt12 = zzd2.charAt(i28);
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
                char charAt18 = zzd2.charAt(i28);
                if (charAt18 >= 55296) {
                    char c13 = charAt18 & 8191;
                    int i31 = 13;
                    while (true) {
                        i21 = i30 + 1;
                        charAt11 = zzd2.charAt(i30);
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
                c3 = zzd2.charAt(i30);
                if (c3 >= 55296) {
                    char c14 = c3 & 8191;
                    int i33 = 13;
                    while (true) {
                        i20 = i32 + 1;
                        charAt10 = zzd2.charAt(i32);
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
                char charAt19 = zzd2.charAt(i32);
                if (charAt19 >= 55296) {
                    char c15 = charAt19 & 8191;
                    int i35 = 13;
                    while (true) {
                        i19 = i34 + 1;
                        charAt9 = zzd2.charAt(i34);
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
                c2 = zzd2.charAt(i34);
                if (c2 >= 55296) {
                    char c16 = c2 & 8191;
                    int i37 = 13;
                    while (true) {
                        i18 = i36 + 1;
                        charAt8 = zzd2.charAt(i36);
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
                char charAt20 = zzd2.charAt(i36);
                if (charAt20 >= 55296) {
                    char c17 = charAt20 & 8191;
                    int i39 = 13;
                    while (true) {
                        i17 = i38 + 1;
                        charAt7 = zzd2.charAt(i38);
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
                char charAt21 = zzd2.charAt(i38);
                if (charAt21 >= 55296) {
                    char c18 = charAt21 & 8191;
                    int i41 = i40;
                    int i42 = 13;
                    while (true) {
                        i16 = i41 + 1;
                        charAt6 = zzd2.charAt(i41);
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
                char charAt22 = zzd2.charAt(i14);
                if (charAt22 >= 55296) {
                    char c19 = charAt22 & 8191;
                    int i44 = i43;
                    int i45 = 13;
                    while (true) {
                        i15 = i44 + 1;
                        charAt5 = zzd2.charAt(i44);
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
            Unsafe unsafe = zzb;
            Object[] zze2 = zzhb2.zze();
            Class<?> cls3 = zzhb2.zzc().getClass();
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
                int charAt23 = zzd2.charAt(i49);
                int i54 = length;
                if (charAt23 >= 55296) {
                    int i55 = charAt23 & 8191;
                    int i56 = i53;
                    int i57 = 13;
                    while (true) {
                        i13 = i56 + 1;
                        charAt4 = zzd2.charAt(i56);
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
                char charAt24 = zzd2.charAt(i3);
                int i59 = i58;
                if (charAt24 >= 55296) {
                    char c22 = charAt24 & 8191;
                    int i60 = i59;
                    int i61 = 13;
                    while (true) {
                        i12 = i60 + 1;
                        charAt3 = zzd2.charAt(i60);
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
                    char charAt25 = zzd2.charAt(i4);
                    char c26 = 55296;
                    if (charAt25 >= 55296) {
                        char c27 = charAt25 & 8191;
                        int i63 = 13;
                        while (true) {
                            i11 = i62 + 1;
                            charAt2 = zzd2.charAt(i62);
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
                        objArr[((i52 / 3) << 1) + 1] = zze2[i2];
                        i2++;
                    } else if (i64 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i52 / 3) << 1) + 1] = zze2[i2];
                        i2++;
                    }
                    int i66 = charAt25 << 1;
                    Object obj = zze2[i66];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zze2[i66] = field2;
                    }
                    zzhb = zzhb2;
                    String str2 = zzd2;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i67 = i66 + 1;
                    Object obj2 = zze2[i67];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zze2[i67] = field3;
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
                    zzhb = zzhb2;
                    String str3 = zzd2;
                    int i68 = i2 + 1;
                    Field zza2 = zza(cls3, (String) zze2[i2]);
                    if (c23 == 9 || c23 == 17) {
                        c8 = 1;
                        objArr[((i52 / 3) << 1) + 1] = zza2.getType();
                    } else {
                        if (c23 == 27 || c23 == '1') {
                            c8 = 1;
                            i10 = i68 + 1;
                            objArr[((i52 / 3) << 1) + 1] = zze2[i68];
                        } else if (c23 == 12 || c23 == 30 || c23 == ',') {
                            c8 = 1;
                            if ((charAt15 & 1) == 1) {
                                i10 = i68 + 1;
                                objArr[((i52 / 3) << 1) + 1] = zze2[i68];
                            }
                        } else {
                            if (c23 == '2') {
                                int i69 = c21 + 1;
                                iArr[c21] = i52;
                                int i70 = (i52 / 3) << 1;
                                int i71 = i68 + 1;
                                objArr[i70] = zze2[i68];
                                if ((charAt24 & 2048) != 0) {
                                    i68 = i71 + 1;
                                    objArr[i70 + 1] = zze2[i71];
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
                    i8 = (int) unsafe.objectFieldOffset(zza2);
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
                        Object obj3 = zze2[i74];
                        i5 = i68;
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = zza(cls3, (String) obj3);
                            zze2[i74] = field;
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
                zzd2 = str;
                i49 = i4;
                cls3 = cls2;
                c4 = c24;
                length = i54;
                c = c6;
                z2 = z;
                c3 = c25;
                i2 = i5;
                zzhb2 = zzhb;
            }
            return new zzgs(iArr2, objArr, c3, c4, zzhb2.zzc(), z2, false, iArr, c, i48, zzgw, zzfy, zzhv, zzes, zzgh);
        }
        int zza3 = ((zzhs) zzgm2).zza();
        int i77 = zzfd.zze.zzi;
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

    public final T zza() {
        return this.zzo.zza(this.zzg);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.measurement.zzhf.zza(com.google.android.gms.internal.measurement.zzib.zzf(r10, r6), com.google.android.gms.internal.measurement.zzib.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.measurement.zzib.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzib.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.measurement.zzib.zza(r10, r6) == com.google.android.gms.internal.measurement.zzib.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.measurement.zzib.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzib.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.measurement.zzib.zza(r10, r6) == com.google.android.gms.internal.measurement.zzib.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.measurement.zzib.zza(r10, r6) == com.google.android.gms.internal.measurement.zzib.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.measurement.zzib.zza(r10, r6) == com.google.android.gms.internal.measurement.zzib.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.measurement.zzhf.zza(com.google.android.gms.internal.measurement.zzib.zzf(r10, r6), com.google.android.gms.internal.measurement.zzib.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.measurement.zzhf.zza(com.google.android.gms.internal.measurement.zzib.zzf(r10, r6), com.google.android.gms.internal.measurement.zzib.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.measurement.zzhf.zza(com.google.android.gms.internal.measurement.zzib.zzf(r10, r6), com.google.android.gms.internal.measurement.zzib.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.measurement.zzib.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzib.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.measurement.zzib.zza(r10, r6) == com.google.android.gms.internal.measurement.zzib.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.measurement.zzib.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzib.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.measurement.zzib.zza(r10, r6) == com.google.android.gms.internal.measurement.zzib.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.measurement.zzib.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzib.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.measurement.zzib.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzib.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzib.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzib.zzd(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzib.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzib.zze(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.measurement.zzhf.zza(com.google.android.gms.internal.measurement.zzib.zzf(r10, r6), com.google.android.gms.internal.measurement.zzib.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzd(r2)
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
            int r4 = r9.zze(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.measurement.zzib.zza(r10, r4)
            int r4 = com.google.android.gms.internal.measurement.zzib.zza(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzib.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzib.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzhf.zza(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzib.zzf(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzib.zzf(r11, r6)
            boolean r3 = com.google.android.gms.internal.measurement.zzhf.zza(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzib.zzf(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzib.zzf(r11, r6)
            boolean r3 = com.google.android.gms.internal.measurement.zzhf.zza(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzib.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzib.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzhf.zza(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzib.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzib.zzb(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzib.zza(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.zzib.zza(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzib.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzib.zzb(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzib.zza(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.zzib.zza(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzib.zza(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.zzib.zza(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzib.zza(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.zzib.zza(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzib.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzib.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzhf.zza(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzib.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzib.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzhf.zza(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzib.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzib.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzhf.zza(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.measurement.zzib.zzc(r10, r6)
            boolean r5 = com.google.android.gms.internal.measurement.zzib.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzib.zza(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.zzib.zza(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzib.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzib.zzb(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzib.zza(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.zzib.zza(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzib.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzib.zzb(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzib.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzib.zzb(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.measurement.zzib.zzd(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.measurement.zzib.zzd(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.measurement.zzib.zze(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.measurement.zzib.zze(r11, r6)
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
            com.google.android.gms.internal.measurement.zzhv<?, ?> r0 = r9.zzq
            java.lang.Object r0 = r0.zzb(r10)
            com.google.android.gms.internal.measurement.zzhv<?, ?> r2 = r9.zzq
            java.lang.Object r2 = r2.zzb(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.measurement.zzes<?> r0 = r9.zzr
            com.google.android.gms.internal.measurement.zzew r10 = r0.zza(r10)
            com.google.android.gms.internal.measurement.zzes<?> r0 = r9.zzr
            com.google.android.gms.internal.measurement.zzew r11 = r0.zza(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, java.lang.Object):boolean");
    }

    public final int zza(T t) {
        int i;
        int i2;
        int length = this.zzc.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzd2 = zzd(i4);
            int i5 = this.zzc[i4];
            long j = (long) (1048575 & zzd2);
            int i6 = 37;
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    i = zzff.zza(Double.doubleToLongBits(zzib.zze(t, j)));
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    i = Float.floatToIntBits(zzib.zzd(t, j));
                    i3 = i2 + i;
                    break;
                case 2:
                    i2 = i3 * 53;
                    i = zzff.zza(zzib.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 3:
                    i2 = i3 * 53;
                    i = zzff.zza(zzib.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    i = zzib.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 5:
                    i2 = i3 * 53;
                    i = zzff.zza(zzib.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    i = zzib.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    i = zzff.zza(zzib.zzc(t, j));
                    i3 = i2 + i;
                    break;
                case 8:
                    i2 = i3 * 53;
                    i = ((String) zzib.zzf(t, j)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    Object zzf2 = zzib.zzf(t, j);
                    if (zzf2 != null) {
                        i6 = zzf2.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    i = zzib.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    i = zzib.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 12:
                    i2 = i3 * 53;
                    i = zzib.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 13:
                    i2 = i3 * 53;
                    i = zzib.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 14:
                    i2 = i3 * 53;
                    i = zzff.zza(zzib.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    i = zzib.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 16:
                    i2 = i3 * 53;
                    i = zzff.zza(zzib.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 17:
                    Object zzf3 = zzib.zzf(t, j);
                    if (zzf3 != null) {
                        i6 = zzf3.hashCode();
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
                    i = zzib.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 50:
                    i2 = i3 * 53;
                    i = zzib.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 51:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzff.zza(Double.doubleToLongBits(zzb(t, j)));
                        i3 = i2 + i;
                        break;
                    }
                case 52:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = Float.floatToIntBits(zzc(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 53:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzff.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 54:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzff.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 55:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 56:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzff.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 57:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 58:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzff.zza(zzf(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 59:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = ((String) zzib.zzf(t, j)).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 60:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzib.zzf(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 61:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzib.zzf(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 62:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 63:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 64:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 65:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzff.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 66:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 67:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzff.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 68:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzib.zzf(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzq.zzb(t).hashCode();
        return this.zzh ? (hashCode * 53) + this.zzr.zza((Object) t).hashCode() : hashCode;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, int):boolean
     arg types: [T, int]
     candidates:
      com.google.android.gms.internal.measurement.zzgs.zza(int, int):int
      com.google.android.gms.internal.measurement.zzgs.zza(com.google.android.gms.internal.measurement.zzhv, java.lang.Object):int
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Class<?>, java.lang.String):java.lang.reflect.Field
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, long):java.util.List<?>
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, int):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, long):void
     arg types: [T, long, long]
     candidates:
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.measurement.zzib.zza(byte[], long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, long):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, int):void
     arg types: [T, int]
     candidates:
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, long):double
      com.google.android.gms.internal.measurement.zzgs.zzb(int, int):int
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzhd.zzb(java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void
     arg types: [T, long, int]
     candidates:
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.measurement.zzib.zza(byte[], long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void
     arg types: [T, long, boolean]
     candidates:
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzib.zza(byte[], long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void
     arg types: [T, long, float]
     candidates:
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.measurement.zzib.zza(byte[], long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void */
    public final void zzb(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzd2 = zzd(i);
                long j = (long) (1048575 & zzd2);
                int i2 = this.zzc[i];
                switch ((zzd2 & 267386880) >>> 20) {
                    case 0:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza(t, j, zzib.zze(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 1:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzd(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 2:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 3:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 4:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 5:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 6:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 7:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzc(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 8:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza(t, j, zzib.zzf(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza(t, j, zzib.zzf(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 11:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 12:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 13:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 14:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 15:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        }
                    case 16:
                        if (!zza((Object) t2, i)) {
                            break;
                        } else {
                            zzib.zza((Object) t, j, zzib.zzb(t2, j));
                            zzb((Object) t, i);
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
                        this.zzp.zza(t, t2, j);
                        break;
                    case 50:
                        zzhf.zza(this.zzs, t, t2, j);
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
                            zzib.zza(t, j, zzib.zzf(t2, j));
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
                            zzib.zza(t, j, zzib.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            zzhf.zza(this.zzq, t, t2);
            if (this.zzh) {
                zzhf.zza(this.zzr, t, t2);
                return;
            }
            return;
        }
        throw null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, int):boolean
     arg types: [T, int]
     candidates:
      com.google.android.gms.internal.measurement.zzgs.zza(int, int):int
      com.google.android.gms.internal.measurement.zzgs.zza(com.google.android.gms.internal.measurement.zzhv, java.lang.Object):int
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Class<?>, java.lang.String):java.lang.reflect.Field
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, long):java.util.List<?>
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, int):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, int):void
     arg types: [T, int]
     candidates:
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, long):double
      com.google.android.gms.internal.measurement.zzgs.zzb(int, int):int
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzhd.zzb(java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, int):void */
    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza((Object) t2, i)) {
            Object zzf2 = zzib.zzf(t, zzd2);
            Object zzf3 = zzib.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzib.zza(t, zzd2, zzff.zza(zzf2, zzf3));
                zzb((Object) t, i);
            } else if (zzf3 != null) {
                zzib.zza(t, zzd2, zzf3);
                zzb((Object) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object zzf2 = zzib.zzf(t, j);
            Object zzf3 = zzib.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzib.zza(t, j, zzff.zza(zzf2, zzf3));
                zzb(t, i2, i);
            } else if (zzf3 != null) {
                zzib.zza(t, j, zzf3);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzen.zzh(int, long):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.measurement.zzen.zzh(int, int):int
      com.google.android.gms.internal.measurement.zzen.zzh(int, long):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzen.zzb(int, boolean):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.measurement.zzen.zzb(int, double):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, float):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, com.google.android.gms.internal.measurement.zzft):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, com.google.android.gms.internal.measurement.zzgo):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, java.lang.String):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, int):void
      com.google.android.gms.internal.measurement.zzen.zzb(int, long):void
      com.google.android.gms.internal.measurement.zzen.zzb(int, com.google.android.gms.internal.measurement.zzdu):void
      com.google.android.gms.internal.measurement.zzen.zzb(int, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzen.zzg(int, long):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.measurement.zzen.zzg(int, int):int
      com.google.android.gms.internal.measurement.zzen.zzg(int, long):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzen.zzb(int, float):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.measurement.zzen.zzb(int, double):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, com.google.android.gms.internal.measurement.zzft):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, com.google.android.gms.internal.measurement.zzgo):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, java.lang.String):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, boolean):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, int):void
      com.google.android.gms.internal.measurement.zzen.zzb(int, long):void
      com.google.android.gms.internal.measurement.zzen.zzb(int, com.google.android.gms.internal.measurement.zzdu):void
      com.google.android.gms.internal.measurement.zzen.zzb(int, float):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzen.zzb(int, double):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.measurement.zzen.zzb(int, float):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, com.google.android.gms.internal.measurement.zzft):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, com.google.android.gms.internal.measurement.zzgo):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, java.lang.String):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, boolean):int
      com.google.android.gms.internal.measurement.zzen.zzb(int, int):void
      com.google.android.gms.internal.measurement.zzen.zzb(int, long):void
      com.google.android.gms.internal.measurement.zzen.zzb(int, com.google.android.gms.internal.measurement.zzdu):void
      com.google.android.gms.internal.measurement.zzen.zzb(int, double):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<com.google.android.gms.internal.measurement.zzgo>, com.google.android.gms.internal.measurement.zzhd):int
     arg types: [int, java.util.List<?>, com.google.android.gms.internal.measurement.zzhd]
     candidates:
      com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<java.lang.Long>, boolean):int
      com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<com.google.android.gms.internal.measurement.zzdu>, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<com.google.android.gms.internal.measurement.zzgo>, com.google.android.gms.internal.measurement.zzhd):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<java.lang.Long>, boolean):int
     arg types: [int, java.util.List<?>, int]
     candidates:
      com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<com.google.android.gms.internal.measurement.zzgo>, com.google.android.gms.internal.measurement.zzhd):int
      com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<com.google.android.gms.internal.measurement.zzdu>, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<java.lang.Long>, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzhf.zza(int, java.util.List<java.lang.Long>, boolean):int
     arg types: [int, java.util.List<?>, int]
     candidates:
      com.google.android.gms.internal.measurement.zzhf.zza(int, java.lang.Object, com.google.android.gms.internal.measurement.zzhd):int
      com.google.android.gms.internal.measurement.zzhf.zza(int, java.util.List<?>, com.google.android.gms.internal.measurement.zzhd):int
      com.google.android.gms.internal.measurement.zzhf.zza(int, java.util.List<java.lang.String>, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzhf.zza(com.google.android.gms.internal.measurement.zzes, java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzhf.zza(com.google.android.gms.internal.measurement.zzhv, java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzhf.zza(int, java.util.List<java.lang.Long>, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, int):boolean
     arg types: [T, int]
     candidates:
      com.google.android.gms.internal.measurement.zzgs.zza(int, int):int
      com.google.android.gms.internal.measurement.zzgs.zza(com.google.android.gms.internal.measurement.zzhv, java.lang.Object):int
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Class<?>, java.lang.String):java.lang.reflect.Field
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, long):java.util.List<?>
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, int):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzgs.zza(com.google.android.gms.internal.measurement.zzhv, java.lang.Object):int
     arg types: [com.google.android.gms.internal.measurement.zzhv<?, ?>, T]
     candidates:
      com.google.android.gms.internal.measurement.zzgs.zza(int, int):int
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Class<?>, java.lang.String):java.lang.reflect.Field
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, long):java.util.List<?>
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, int):boolean
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzgs.zza(com.google.android.gms.internal.measurement.zzhv, java.lang.Object):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<java.lang.Long>, boolean):int
     arg types: [int, java.util.List, int]
     candidates:
      com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<com.google.android.gms.internal.measurement.zzgo>, com.google.android.gms.internal.measurement.zzhd):int
      com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<com.google.android.gms.internal.measurement.zzdu>, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<java.lang.Long>, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzhf.zza(int, java.util.List<java.lang.Long>, boolean):int
     arg types: [int, java.util.List, int]
     candidates:
      com.google.android.gms.internal.measurement.zzhf.zza(int, java.lang.Object, com.google.android.gms.internal.measurement.zzhd):int
      com.google.android.gms.internal.measurement.zzhf.zza(int, java.util.List<?>, com.google.android.gms.internal.measurement.zzhd):int
      com.google.android.gms.internal.measurement.zzhf.zza(int, java.util.List<java.lang.String>, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzhf.zza(com.google.android.gms.internal.measurement.zzes, java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzhf.zza(com.google.android.gms.internal.measurement.zzhv, java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzhf.zza(int, java.util.List<java.lang.Long>, boolean):int */
    public final int zzb(T t) {
        int i;
        int i2;
        long j;
        boolean z;
        int i3;
        int i4;
        int i5;
        int zzb2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int zzb3;
        int i11;
        int i12;
        int i13;
        T t2 = t;
        int i14 = 267386880;
        int i15 = 1;
        int i16 = 0;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i17 = 0;
            int i18 = 0;
            while (i17 < this.zzc.length) {
                int zzd2 = zzd(i17);
                int i19 = (zzd2 & i14) >>> 20;
                int i20 = this.zzc[i17];
                long j2 = (long) (zzd2 & 1048575);
                int i21 = (i19 < zzex.DOUBLE_LIST_PACKED.zza() || i19 > zzex.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i17 + 2] & 1048575;
                switch (i19) {
                    case 0:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 1:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 2:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzd(i20, zzib.zzb(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 3:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zze(i20, zzib.zzb(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 4:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzf(i20, zzib.zza(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 5:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzg(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 6:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzi(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 7:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzb(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 8:
                        if (zza((Object) t2, i17)) {
                            Object zzf2 = zzib.zzf(t2, j2);
                            if (!(zzf2 instanceof zzdu)) {
                                zzb3 = zzen.zzb(i20, (String) zzf2);
                                break;
                            } else {
                                zzb3 = zzen.zzc(i20, (zzdu) zzf2);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 9:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzhf.zza(i20, zzib.zzf(t2, j2), zza(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 10:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzc(i20, (zzdu) zzib.zzf(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 11:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzg(i20, zzib.zza(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 12:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzk(i20, zzib.zza(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 13:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzj(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 14:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 15:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzh(i20, zzib.zza(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 16:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzf(i20, zzib.zzb(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 17:
                        if (zza((Object) t2, i17)) {
                            zzb3 = zzen.zzc(i20, (zzgo) zzib.zzf(t2, j2), zza(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 18:
                        zzb3 = zzhf.zzi(i20, zza(t2, j2), false);
                        break;
                    case 19:
                        zzb3 = zzhf.zzh(i20, zza(t2, j2), false);
                        break;
                    case 20:
                        zzb3 = zzhf.zza(i20, (List<Long>) zza(t2, j2), false);
                        break;
                    case 21:
                        zzb3 = zzhf.zzb(i20, (List<Long>) zza(t2, j2), false);
                        break;
                    case 22:
                        zzb3 = zzhf.zze(i20, zza(t2, j2), false);
                        break;
                    case 23:
                        zzb3 = zzhf.zzi(i20, zza(t2, j2), false);
                        break;
                    case 24:
                        zzb3 = zzhf.zzh(i20, zza(t2, j2), false);
                        break;
                    case 25:
                        zzb3 = zzhf.zzj(i20, zza(t2, j2), false);
                        break;
                    case 26:
                        zzb3 = zzhf.zza(i20, zza(t2, j2));
                        break;
                    case 27:
                        zzb3 = zzhf.zza(i20, zza(t2, j2), zza(i17));
                        break;
                    case 28:
                        zzb3 = zzhf.zzb(i20, zza(t2, j2));
                        break;
                    case 29:
                        zzb3 = zzhf.zzf(i20, zza(t2, j2), false);
                        break;
                    case 30:
                        zzb3 = zzhf.zzd(i20, zza(t2, j2), false);
                        break;
                    case 31:
                        zzb3 = zzhf.zzh(i20, zza(t2, j2), false);
                        break;
                    case 32:
                        zzb3 = zzhf.zzi(i20, zza(t2, j2), false);
                        break;
                    case 33:
                        zzb3 = zzhf.zzg(i20, zza(t2, j2), false);
                        break;
                    case 34:
                        zzb3 = zzhf.zzc(i20, zza(t2, j2), false);
                        break;
                    case 35:
                        i12 = zzhf.zzi((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzen.zze(i20);
                            i11 = zzen.zzg(i12);
                            zzb3 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 36:
                        i12 = zzhf.zzh((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzen.zze(i20);
                            i11 = zzen.zzg(i12);
                            zzb3 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 37:
                        i12 = zzhf.zza((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzen.zze(i20);
                            i11 = zzen.zzg(i12);
                            zzb3 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 38:
                        i12 = zzhf.zzb((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzen.zze(i20);
                            i11 = zzen.zzg(i12);
                            zzb3 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 39:
                        i12 = zzhf.zze((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzen.zze(i20);
                            i11 = zzen.zzg(i12);
                            zzb3 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 40:
                        i12 = zzhf.zzi((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzen.zze(i20);
                            i11 = zzen.zzg(i12);
                            zzb3 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 41:
                        i12 = zzhf.zzh((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzen.zze(i20);
                            i11 = zzen.zzg(i12);
                            zzb3 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 42:
                        i12 = zzhf.zzj((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzen.zze(i20);
                            i11 = zzen.zzg(i12);
                            zzb3 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 43:
                        i12 = zzhf.zzf((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzen.zze(i20);
                            i11 = zzen.zzg(i12);
                            zzb3 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 44:
                        i12 = zzhf.zzd((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzen.zze(i20);
                            i11 = zzen.zzg(i12);
                            zzb3 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 45:
                        i12 = zzhf.zzh((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzen.zze(i20);
                            i11 = zzen.zzg(i12);
                            zzb3 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 46:
                        i12 = zzhf.zzi((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzen.zze(i20);
                            i11 = zzen.zzg(i12);
                            zzb3 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 47:
                        i12 = zzhf.zzg((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzen.zze(i20);
                            i11 = zzen.zzg(i12);
                            zzb3 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 48:
                        i12 = zzhf.zzc((List) unsafe.getObject(t2, j2));
                        if (i12 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i21, i12);
                            }
                            i13 = zzen.zze(i20);
                            i11 = zzen.zzg(i12);
                            zzb3 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 49:
                        zzb3 = zzhf.zzb(i20, (List<zzgo>) zza(t2, j2), zza(i17));
                        break;
                    case 50:
                        zzb3 = this.zzs.zza(i20, zzib.zzf(t2, j2), zzb(i17));
                        break;
                    case 51:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 52:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 53:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzd(i20, zze(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 54:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zze(i20, zze(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 55:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzf(i20, zzd(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 56:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzg(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 57:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzi(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 58:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzb(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 59:
                        if (zza(t2, i20, i17)) {
                            Object zzf3 = zzib.zzf(t2, j2);
                            if (!(zzf3 instanceof zzdu)) {
                                zzb3 = zzen.zzb(i20, (String) zzf3);
                                break;
                            } else {
                                zzb3 = zzen.zzc(i20, (zzdu) zzf3);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 60:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzhf.zza(i20, zzib.zzf(t2, j2), zza(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 61:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzc(i20, (zzdu) zzib.zzf(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 62:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzg(i20, zzd(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 63:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzk(i20, zzd(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 64:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzj(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 65:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 66:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzh(i20, zzd(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 67:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzf(i20, zze(t2, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 68:
                        if (zza(t2, i20, i17)) {
                            zzb3 = zzen.zzc(i20, (zzgo) zzib.zzf(t2, j2), zza(i17));
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
                i18 += zzb3;
                i17 += 3;
                i14 = 267386880;
            }
            return i18 + zza((zzhv) this.zzq, (Object) t2);
        }
        Unsafe unsafe2 = zzb;
        int i22 = -1;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i23 < this.zzc.length) {
            int zzd3 = zzd(i23);
            int[] iArr = this.zzc;
            int i26 = iArr[i23];
            int i27 = (zzd3 & 267386880) >>> 20;
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
                i2 = (!this.zzk || i27 < zzex.DOUBLE_LIST_PACKED.zza() || i27 > zzex.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i23 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzd3 & 1048575);
            switch (i27) {
                case 0:
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i24 += zzen.zzb(i26, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        z = false;
                        i24 += zzen.zzb(i26, 0.0f);
                        break;
                    }
                    z = false;
                case 2:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzen.zzd(i26, unsafe2.getLong(t2, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 3:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzen.zze(i26, unsafe2.getLong(t2, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 4:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzen.zzf(i26, unsafe2.getInt(t2, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 5:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzen.zzg(i26, 0L);
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 6:
                    i4 = 1;
                    if ((i25 & i) != 0) {
                        i3 = 0;
                        i24 += zzen.zzi(i26, 0);
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
                        i24 += zzen.zzb(i26, true);
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
                        if (object instanceof zzdu) {
                            zzb2 = zzen.zzc(i26, (zzdu) object);
                        } else {
                            zzb2 = zzen.zzb(i26, (String) object);
                        }
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 9:
                    if ((i25 & i) != 0) {
                        zzb2 = zzhf.zza(i26, unsafe2.getObject(t2, j3), zza(i23));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 10:
                    if ((i25 & i) != 0) {
                        zzb2 = zzen.zzc(i26, (zzdu) unsafe2.getObject(t2, j3));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 11:
                    if ((i25 & i) != 0) {
                        zzb2 = zzen.zzg(i26, unsafe2.getInt(t2, j3));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 12:
                    if ((i25 & i) != 0) {
                        zzb2 = zzen.zzk(i26, unsafe2.getInt(t2, j3));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 13:
                    if ((i25 & i) != 0) {
                        i6 = zzen.zzj(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 14:
                    if ((i25 & i) != 0) {
                        zzb2 = zzen.zzh(i26, 0L);
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 15:
                    if ((i25 & i) != 0) {
                        zzb2 = zzen.zzh(i26, unsafe2.getInt(t2, j3));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 16:
                    if ((i25 & i) != 0) {
                        zzb2 = zzen.zzf(i26, unsafe2.getLong(t2, j3));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 17:
                    if ((i25 & i) != 0) {
                        zzb2 = zzen.zzc(i26, (zzgo) unsafe2.getObject(t2, j3), zza(i23));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 18:
                    zzb2 = zzhf.zzi(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += zzb2;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 19:
                    i3 = 0;
                    i7 = zzhf.zzh(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 20:
                    i3 = 0;
                    i7 = zzhf.zza(i26, (List<Long>) ((List) unsafe2.getObject(t2, j3)), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 21:
                    i3 = 0;
                    i7 = zzhf.zzb(i26, (List<Long>) ((List) unsafe2.getObject(t2, j3)), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 22:
                    i3 = 0;
                    i7 = zzhf.zze(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 23:
                    i3 = 0;
                    i7 = zzhf.zzi(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 24:
                    i3 = 0;
                    i7 = zzhf.zzh(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 25:
                    i3 = 0;
                    i7 = zzhf.zzj(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 26:
                    zzb2 = zzhf.zza(i26, (List) unsafe2.getObject(t2, j3));
                    i24 += zzb2;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 27:
                    zzb2 = zzhf.zza(i26, (List<?>) ((List) unsafe2.getObject(t2, j3)), zza(i23));
                    i24 += zzb2;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 28:
                    zzb2 = zzhf.zzb(i26, (List) unsafe2.getObject(t2, j3));
                    i24 += zzb2;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 29:
                    zzb2 = zzhf.zzf(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += zzb2;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 30:
                    i3 = 0;
                    i7 = zzhf.zzd(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 31:
                    i3 = 0;
                    i7 = zzhf.zzh(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 32:
                    i3 = 0;
                    i7 = zzhf.zzi(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 33:
                    i3 = 0;
                    i7 = zzhf.zzg(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 34:
                    i3 = 0;
                    i7 = zzhf.zzc(i26, (List) unsafe2.getObject(t2, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 35:
                    i10 = zzhf.zzi((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzen.zze(i26);
                        i8 = zzen.zzg(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 36:
                    i10 = zzhf.zzh((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzen.zze(i26);
                        i8 = zzen.zzg(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 37:
                    i10 = zzhf.zza((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzen.zze(i26);
                        i8 = zzen.zzg(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 38:
                    i10 = zzhf.zzb((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzen.zze(i26);
                        i8 = zzen.zzg(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 39:
                    i10 = zzhf.zze((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzen.zze(i26);
                        i8 = zzen.zzg(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 40:
                    i10 = zzhf.zzi((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzen.zze(i26);
                        i8 = zzen.zzg(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 41:
                    i10 = zzhf.zzh((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzen.zze(i26);
                        i8 = zzen.zzg(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 42:
                    i10 = zzhf.zzj((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzen.zze(i26);
                        i8 = zzen.zzg(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 43:
                    i10 = zzhf.zzf((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzen.zze(i26);
                        i8 = zzen.zzg(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 44:
                    i10 = zzhf.zzd((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzen.zze(i26);
                        i8 = zzen.zzg(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 45:
                    i10 = zzhf.zzh((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzen.zze(i26);
                        i8 = zzen.zzg(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 46:
                    i10 = zzhf.zzi((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzen.zze(i26);
                        i8 = zzen.zzg(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 47:
                    i10 = zzhf.zzg((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzen.zze(i26);
                        i8 = zzen.zzg(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 48:
                    i10 = zzhf.zzc((List) unsafe2.getObject(t2, j3));
                    if (i10 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, i10);
                        }
                        i9 = zzen.zze(i26);
                        i8 = zzen.zzg(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 49:
                    zzb2 = zzhf.zzb(i26, (List) unsafe2.getObject(t2, j3), zza(i23));
                    i24 += zzb2;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 50:
                    zzb2 = this.zzs.zza(i26, unsafe2.getObject(t2, j3), zzb(i23));
                    i24 += zzb2;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 51:
                    if (zza(t2, i26, i23)) {
                        zzb2 = zzen.zzb(i26, 0.0d);
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 52:
                    if (zza(t2, i26, i23)) {
                        i6 = zzen.zzb(i26, 0.0f);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 53:
                    if (zza(t2, i26, i23)) {
                        zzb2 = zzen.zzd(i26, zze(t2, j3));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 54:
                    if (zza(t2, i26, i23)) {
                        zzb2 = zzen.zze(i26, zze(t2, j3));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 55:
                    if (zza(t2, i26, i23)) {
                        zzb2 = zzen.zzf(i26, zzd(t2, j3));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 56:
                    if (zza(t2, i26, i23)) {
                        zzb2 = zzen.zzg(i26, 0L);
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 57:
                    if (zza(t2, i26, i23)) {
                        i6 = zzen.zzi(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 58:
                    if (zza(t2, i26, i23)) {
                        i6 = zzen.zzb(i26, true);
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
                        if (object2 instanceof zzdu) {
                            zzb2 = zzen.zzc(i26, (zzdu) object2);
                        } else {
                            zzb2 = zzen.zzb(i26, (String) object2);
                        }
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 60:
                    if (zza(t2, i26, i23)) {
                        zzb2 = zzhf.zza(i26, unsafe2.getObject(t2, j3), zza(i23));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 61:
                    if (zza(t2, i26, i23)) {
                        zzb2 = zzen.zzc(i26, (zzdu) unsafe2.getObject(t2, j3));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 62:
                    if (zza(t2, i26, i23)) {
                        zzb2 = zzen.zzg(i26, zzd(t2, j3));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 63:
                    if (zza(t2, i26, i23)) {
                        zzb2 = zzen.zzk(i26, zzd(t2, j3));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 64:
                    if (zza(t2, i26, i23)) {
                        i6 = zzen.zzj(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 65:
                    if (zza(t2, i26, i23)) {
                        zzb2 = zzen.zzh(i26, 0L);
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 66:
                    if (zza(t2, i26, i23)) {
                        zzb2 = zzen.zzh(i26, zzd(t2, j3));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 67:
                    if (zza(t2, i26, i23)) {
                        zzb2 = zzen.zzf(i26, zze(t2, j3));
                        i24 += zzb2;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 68:
                    if (zza(t2, i26, i23)) {
                        zzb2 = zzen.zzc(i26, (zzgo) unsafe2.getObject(t2, j3), zza(i23));
                        i24 += zzb2;
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
        int zza2 = i24 + zza((zzhv) this.zzq, (Object) t2);
        if (!this.zzh) {
            return zza2;
        }
        zzew<?> zza3 = this.zzr.zza((Object) t2);
        for (int i31 = i30; i31 < zza3.zza.zzc(); i31++) {
            Map.Entry<T, Object> zzb4 = zza3.zza.zzb(i31);
            i30 += zzew.zza((zzey) zzb4.getKey(), zzb4.getValue());
        }
        for (Map.Entry next : zza3.zza.zzd()) {
            i30 += zzew.zza((zzey) next.getKey(), next.getValue());
        }
        return zza2 + i30;
    }

    private static <UT, UB> int zza(zzhv<UT, UB> zzhv, T t) {
        return zzhv.zzf(zzhv.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzib.zzf(obj, j);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.measurement.zzis, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.measurement.zzis, int]
     candidates:
      com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<?>, com.google.android.gms.internal.measurement.zzis, com.google.android.gms.internal.measurement.zzhd):void
      com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.measurement.zzis, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzhf.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.measurement.zzis, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.measurement.zzis, int]
     candidates:
      com.google.android.gms.internal.measurement.zzhf.zza(int, int, java.lang.Object, com.google.android.gms.internal.measurement.zzhv):UB
      com.google.android.gms.internal.measurement.zzhf.zza(int, java.util.List<?>, com.google.android.gms.internal.measurement.zzis, com.google.android.gms.internal.measurement.zzhd):void
      com.google.android.gms.internal.measurement.zzhf.zza(com.google.android.gms.internal.measurement.zzgh, java.lang.Object, java.lang.Object, long):void
      com.google.android.gms.internal.measurement.zzhf.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.measurement.zzis, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, int):boolean
     arg types: [T, int]
     candidates:
      com.google.android.gms.internal.measurement.zzgs.zza(int, int):int
      com.google.android.gms.internal.measurement.zzgs.zza(com.google.android.gms.internal.measurement.zzhv, java.lang.Object):int
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Class<?>, java.lang.String):java.lang.reflect.Field
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, long):java.util.List<?>
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, int):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
     arg types: [T, com.google.android.gms.internal.measurement.zzis]
     candidates:
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, long):double
      com.google.android.gms.internal.measurement.zzgs.zzb(int, int):int
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, int):void
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzhd.zzb(java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.measurement.zzis r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zza()
            int r1 = com.google.android.gms.internal.measurement.zzfd.zze.zzk
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.measurement.zzhv<?, ?> r0 = r13.zzq
            zza(r0, r14, r15)
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.measurement.zzes<?> r0 = r13.zzr
            com.google.android.gms.internal.measurement.zzew r0 = r0.zza(r14)
            com.google.android.gms.internal.measurement.zzhi<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.zze()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zzc
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzd(r7)
            int[] r9 = r13.zzc
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.measurement.zzes<?> r10 = r13.zzr
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.measurement.zzes<?> r10 = r13.zzr
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
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzhd r10 = r13.zza(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zze(r9, r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzb(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zze(r9, r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzdu r8 = (com.google.android.gms.internal.measurement.zzdu) r8
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzhd r10 = r13.zza(r7)
            r15.zza(r9, r8, r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            zza(r9, r8, r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzf(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzd(r9, r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzd(r9, r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzc(r9, r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzc(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzb(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            r13.zza(r15, r9, r8, r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhd r10 = r13.zza(r7)
            com.google.android.gms.internal.measurement.zzhf.zzb(r9, r8, r15, r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzb(r9, r8, r15, r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zza(r9, r8, r15, r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzb(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhd r10 = r13.zza(r7)
            com.google.android.gms.internal.measurement.zzhf.zza(r9, r8, r15, r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zza(r9, r8, r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zzb(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhf.zza(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzhd r10 = r13.zza(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r10)
            r15.zze(r9, r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzib.zza(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzib.zza(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzib.zza(r14, r10)
            r15.zzb(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzib.zza(r14, r10)
            r15.zze(r9, r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzdu r8 = (com.google.android.gms.internal.measurement.zzdu) r8
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzhd r10 = r13.zza(r7)
            r15.zza(r9, r8, r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r10)
            zza(r9, r8, r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.measurement.zzib.zzc(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzib.zza(r14, r10)
            r15.zzd(r9, r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r10)
            r15.zzd(r9, r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzib.zza(r14, r10)
            r15.zzc(r9, r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.measurement.zzib.zzd(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.measurement.zzib.zze(r14, r10)
            r15.zza(r9, r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.measurement.zzes<?> r14 = r13.zzr
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
            boolean r0 = r13.zzj
            if (r0 == 0) goto L_0x0a44
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.measurement.zzes<?> r0 = r13.zzr
            com.google.android.gms.internal.measurement.zzew r0 = r0.zza(r14)
            com.google.android.gms.internal.measurement.zzhi<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x054a
            java.util.Iterator r0 = r0.zzd()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x054c
        L_0x054a:
            r0 = r3
            r1 = r0
        L_0x054c:
            int[] r7 = r13.zzc
            int r7 = r7.length
            r8 = r5
        L_0x0550:
            if (r8 >= r7) goto L_0x0a28
            int r9 = r13.zzd(r8)
            int[] r10 = r13.zzc
            r10 = r10[r8]
        L_0x055a:
            if (r1 == 0) goto L_0x0578
            com.google.android.gms.internal.measurement.zzes<?> r11 = r13.zzr
            int r11 = r11.zza(r1)
            if (r11 > r10) goto L_0x0578
            com.google.android.gms.internal.measurement.zzes<?> r11 = r13.zzr
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
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzhd r11 = r13.zza(r8)
            r15.zzb(r10, r9, r11)
            goto L_0x0a24
        L_0x0596:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zze(r10, r11)
            goto L_0x0a24
        L_0x05a7:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a24
        L_0x05b8:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0a24
        L_0x05c9:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x05da:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzb(r10, r9)
            goto L_0x0a24
        L_0x05eb:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0a24
        L_0x05fc:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzdu r9 = (com.google.android.gms.internal.measurement.zzdu) r9
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x060f:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzhd r11 = r13.zza(r8)
            r15.zza(r10, r9, r11)
            goto L_0x0a24
        L_0x0624:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0a24
        L_0x0635:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzf(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x0646:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzd(r10, r9)
            goto L_0x0a24
        L_0x0657:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzd(r10, r11)
            goto L_0x0a24
        L_0x0668:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzc(r10, r9)
            goto L_0x0a24
        L_0x0679:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a24
        L_0x068a:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a24
        L_0x069b:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzc(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x06ac:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzb(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a24
        L_0x06bd:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            r13.zza(r15, r10, r9, r8)
            goto L_0x0a24
        L_0x06c8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhd r11 = r13.zza(r8)
            com.google.android.gms.internal.measurement.zzhf.zzb(r10, r9, r15, r11)
            goto L_0x0a24
        L_0x06dd:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zze(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ee:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzj(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ff:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzg(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0710:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzl(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0721:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzm(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0732:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzi(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0743:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzn(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0754:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzk(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0765:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzf(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0776:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzh(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0787:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzd(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0798:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzc(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07a9:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzb(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07ba:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zza(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07cb:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zze(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07dc:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzj(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07ed:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzg(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07fe:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzl(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x080f:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzm(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0820:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzi(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0831:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzb(r10, r9, r15)
            goto L_0x0a24
        L_0x0842:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhd r11 = r13.zza(r8)
            com.google.android.gms.internal.measurement.zzhf.zza(r10, r9, r15, r11)
            goto L_0x0a24
        L_0x0857:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zza(r10, r9, r15)
            goto L_0x0a24
        L_0x0868:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzn(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0879:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzk(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x088a:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzf(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x089b:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzh(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ac:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzd(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08bd:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzc(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ce:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzb(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08df:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zza(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08f0:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzhd r11 = r13.zza(r8)
            r15.zzb(r10, r9, r11)
            goto L_0x0a24
        L_0x0905:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r11)
            r15.zze(r10, r11)
            goto L_0x0a24
        L_0x0916:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzib.zza(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a24
        L_0x0927:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0a24
        L_0x0938:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzib.zza(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x0949:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzib.zza(r14, r11)
            r15.zzb(r10, r9)
            goto L_0x0a24
        L_0x095a:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzib.zza(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0a24
        L_0x096b:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzdu r9 = (com.google.android.gms.internal.measurement.zzdu) r9
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x097e:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzhd r11 = r13.zza(r8)
            r15.zza(r10, r9, r11)
            goto L_0x0a24
        L_0x0993:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzib.zzf(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0a24
        L_0x09a4:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.measurement.zzib.zzc(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x09b5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzib.zza(r14, r11)
            r15.zzd(r10, r9)
            goto L_0x0a24
        L_0x09c5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r11)
            r15.zzd(r10, r11)
            goto L_0x0a24
        L_0x09d5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzib.zza(r14, r11)
            r15.zzc(r10, r9)
            goto L_0x0a24
        L_0x09e5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a24
        L_0x09f5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzib.zzb(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a24
        L_0x0a05:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.measurement.zzib.zzd(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x0a15:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.measurement.zzib.zze(r14, r11)
            r15.zza(r10, r11)
        L_0x0a24:
            int r8 = r8 + 3
            goto L_0x0550
        L_0x0a28:
            if (r1 == 0) goto L_0x0a3e
            com.google.android.gms.internal.measurement.zzes<?> r2 = r13.zzr
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
            com.google.android.gms.internal.measurement.zzhv<?, ?> r0 = r13.zzq
            zza(r0, r14, r15)
            return
        L_0x0a44:
            r13.zzb(r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.measurement.zzis, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.measurement.zzis, int]
     candidates:
      com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<?>, com.google.android.gms.internal.measurement.zzis, com.google.android.gms.internal.measurement.zzhd):void
      com.google.android.gms.internal.measurement.zzhf.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.measurement.zzis, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzhf.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.measurement.zzis, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.measurement.zzis, int]
     candidates:
      com.google.android.gms.internal.measurement.zzhf.zza(int, int, java.lang.Object, com.google.android.gms.internal.measurement.zzhv):UB
      com.google.android.gms.internal.measurement.zzhf.zza(int, java.util.List<?>, com.google.android.gms.internal.measurement.zzis, com.google.android.gms.internal.measurement.zzhd):void
      com.google.android.gms.internal.measurement.zzhf.zza(com.google.android.gms.internal.measurement.zzgh, java.lang.Object, java.lang.Object, long):void
      com.google.android.gms.internal.measurement.zzhf.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.measurement.zzis, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.measurement.zzis r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.measurement.zzes<?> r3 = r0.zzr
            com.google.android.gms.internal.measurement.zzew r3 = r3.zza(r1)
            com.google.android.gms.internal.measurement.zzhi<T, java.lang.Object> r5 = r3.zza
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.zzd()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            r6 = -1
            int[] r7 = r0.zzc
            int r7 = r7.length
            sun.misc.Unsafe r8 = com.google.android.gms.internal.measurement.zzgs.zzb
            r10 = 0
            r11 = 0
        L_0x002d:
            if (r10 >= r7) goto L_0x0494
            int r12 = r0.zzd(r10)
            int[] r13 = r0.zzc
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzj
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
            com.google.android.gms.internal.measurement.zzes<?> r9 = r0.zzr
            int r9 = r9.zza(r5)
            if (r9 > r14) goto L_0x007e
            com.google.android.gms.internal.measurement.zzes<?> r9 = r0.zzr
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
            com.google.android.gms.internal.measurement.zzhd r9 = r0.zza(r12)
            r2.zzb(r14, r4, r9)
            goto L_0x0086
        L_0x009b:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zze(r1, r9)
            r2.zze(r14, r9)
            goto L_0x0086
        L_0x00a9:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzd(r1, r9)
            r2.zzf(r14, r4)
            goto L_0x0086
        L_0x00b7:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zze(r1, r9)
            r2.zzb(r14, r9)
            goto L_0x0086
        L_0x00c5:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzd(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0086
        L_0x00d3:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzd(r1, r9)
            r2.zzb(r14, r4)
            goto L_0x0086
        L_0x00e1:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzd(r1, r9)
            r2.zze(r14, r4)
            goto L_0x0086
        L_0x00ef:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzdu r4 = (com.google.android.gms.internal.measurement.zzdu) r4
            r2.zza(r14, r4)
            goto L_0x0086
        L_0x00ff:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzhd r9 = r0.zza(r12)
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
            boolean r4 = zzf(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0086
        L_0x0130:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzd(r1, r9)
            r2.zzd(r14, r4)
            goto L_0x0086
        L_0x013f:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zze(r1, r9)
            r2.zzd(r14, r9)
            goto L_0x0086
        L_0x014e:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzd(r1, r9)
            r2.zzc(r14, r4)
            goto L_0x0086
        L_0x015d:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zze(r1, r9)
            r2.zzc(r14, r9)
            goto L_0x0086
        L_0x016c:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zze(r1, r9)
            r2.zza(r14, r9)
            goto L_0x0086
        L_0x017b:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            float r4 = zzc(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0086
        L_0x018a:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0086
            double r9 = zzb(r1, r9)
            r2.zza(r14, r9)
            goto L_0x0086
        L_0x0199:
            java.lang.Object r4 = r8.getObject(r1, r9)
            r0.zza(r2, r14, r4, r12)
            goto L_0x0086
        L_0x01a2:
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhd r10 = r0.zza(r12)
            com.google.android.gms.internal.measurement.zzhf.zzb(r4, r9, r2, r10)
            goto L_0x0086
        L_0x01b5:
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.measurement.zzhf.zze(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01c5:
            r13 = 1
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzj(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01d5:
            r13 = 1
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzg(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01e5:
            r13 = 1
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzl(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01f5:
            r13 = 1
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzm(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0205:
            r13 = 1
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzi(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0215:
            r13 = 1
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzn(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0225:
            r13 = 1
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzk(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0235:
            r13 = 1
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzf(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0245:
            r13 = 1
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzh(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0255:
            r13 = 1
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzd(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0265:
            r13 = 1
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzc(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0275:
            r13 = 1
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzb(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0285:
            r13 = 1
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zza(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0295:
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.measurement.zzhf.zze(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02a5:
            r13 = 0
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzj(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02b5:
            r13 = 0
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzg(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02c5:
            r13 = 0
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzl(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02d5:
            r13 = 0
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzm(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02e5:
            r13 = 0
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzi(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02f5:
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzb(r4, r9, r2)
            goto L_0x0086
        L_0x0304:
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhd r10 = r0.zza(r12)
            com.google.android.gms.internal.measurement.zzhf.zza(r4, r9, r2, r10)
            goto L_0x0086
        L_0x0317:
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zza(r4, r9, r2)
            goto L_0x0086
        L_0x0326:
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.measurement.zzhf.zzn(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0336:
            r13 = 0
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzk(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0346:
            r13 = 0
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzf(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0356:
            r13 = 0
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzh(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0366:
            r13 = 0
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzd(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0376:
            r13 = 0
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzc(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0386:
            r13 = 0
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zzb(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0396:
            r13 = 0
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhf.zza(r4, r9, r2, r13)
            goto L_0x0490
        L_0x03a6:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzhd r9 = r0.zza(r12)
            r2.zzb(r14, r4, r9)
            goto L_0x0490
        L_0x03b7:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zze(r14, r9)
            goto L_0x0490
        L_0x03c4:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzf(r14, r4)
            goto L_0x0490
        L_0x03d1:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzb(r14, r9)
            goto L_0x0490
        L_0x03de:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0490
        L_0x03eb:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzb(r14, r4)
            goto L_0x0490
        L_0x03f8:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zze(r14, r4)
            goto L_0x0490
        L_0x0405:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzdu r4 = (com.google.android.gms.internal.measurement.zzdu) r4
            r2.zza(r14, r4)
            goto L_0x0490
        L_0x0414:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzhd r9 = r0.zza(r12)
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
            boolean r4 = com.google.android.gms.internal.measurement.zzib.zzc(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0490
        L_0x043d:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzd(r14, r4)
            goto L_0x0490
        L_0x0449:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzd(r14, r9)
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
            r2.zzc(r14, r9)
            goto L_0x0490
        L_0x046d:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zza(r14, r9)
            goto L_0x0490
        L_0x0479:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            float r4 = com.google.android.gms.internal.measurement.zzib.zzd(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0490
        L_0x0485:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            double r9 = com.google.android.gms.internal.measurement.zzib.zze(r1, r9)
            r2.zza(r14, r9)
        L_0x0490:
            int r10 = r12 + 3
            goto L_0x002d
        L_0x0494:
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.measurement.zzes<?> r4 = r0.zzr
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
            com.google.android.gms.internal.measurement.zzhv<?, ?> r3 = r0.zzq
            zza(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void");
    }

    private final <K, V> void zza(zzis zzis, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzis.zza(i, this.zzs.zzf(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzhv.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
     arg types: [UT, com.google.android.gms.internal.measurement.zzis]
     candidates:
      com.google.android.gms.internal.measurement.zzhv.zza(java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzhv.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzhe):boolean
      com.google.android.gms.internal.measurement.zzhv.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void */
    private static <UT, UB> void zza(zzhv<UT, UB> zzhv, T t, zzis zzis) throws IOException {
        zzhv.zza((Object) zzhv.zzb(t), zzis);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzhv.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzhe):boolean
     arg types: [?, com.google.android.gms.internal.measurement.zzhe]
     candidates:
      com.google.android.gms.internal.measurement.zzhv.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzhv.zza(java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzhv.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzhe):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, int):void
     arg types: [T, int]
     candidates:
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, long):double
      com.google.android.gms.internal.measurement.zzgs.zzb(int, int):int
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzhd.zzb(java.lang.Object, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzgs.zzb(java.lang.Object, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, int):boolean
     arg types: [T, int]
     candidates:
      com.google.android.gms.internal.measurement.zzgs.zza(int, int):int
      com.google.android.gms.internal.measurement.zzgs.zza(com.google.android.gms.internal.measurement.zzhv, java.lang.Object):int
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Class<?>, java.lang.String):java.lang.reflect.Field
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, long):java.util.List<?>
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, int):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, long):void
     arg types: [T, long, long]
     candidates:
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.measurement.zzib.zza(byte[], long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, long):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void
     arg types: [T, long, int]
     candidates:
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.measurement.zzib.zza(byte[], long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void
     arg types: [T, long, boolean]
     candidates:
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzib.zza(byte[], long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void
     arg types: [T, long, float]
     candidates:
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.measurement.zzib.zza(byte[], long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:149|150|(1:152)|153|(5:174|155|(2:158|156)|256|(2:160|264)(1:265))(1:252)) */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        r8.zza(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x05a0, code lost:
        if (r10 == null) goto L_0x05a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x05a2, code lost:
        r10 = r8.zzc(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x05ab, code lost:
        if (r8.zza((java.lang.Object) r10, r14) == false) goto L_0x05ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x05ad, code lost:
        r14 = r12.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x05b1, code lost:
        if (r14 < r12.zzn) goto L_0x05b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x05b3, code lost:
        r10 = zza(r13, r12.zzl[r14], r10, r8);
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x05be, code lost:
        if (r10 != null) goto L_0x05c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x05c0, code lost:
        r8.zzb(r13, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:149:0x059d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r13, com.google.android.gms.internal.measurement.zzhe r14, com.google.android.gms.internal.measurement.zzeq r15) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            if (r15 == 0) goto L_0x05dc
            com.google.android.gms.internal.measurement.zzhv<?, ?> r8 = r12.zzq
            com.google.android.gms.internal.measurement.zzes<?> r9 = r12.zzr
            r1 = r0
            r10 = r1
        L_0x0009:
            int r2 = r14.zza()     // Catch:{ all -> 0x05c4 }
            int r3 = r12.zzg(r2)     // Catch:{ all -> 0x05c4 }
            if (r3 >= 0) goto L_0x0077
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x002f
            int r14 = r12.zzm
        L_0x001a:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x002e
            r8.zzb(r13, r10)
        L_0x002e:
            return
        L_0x002f:
            boolean r3 = r12.zzh     // Catch:{ all -> 0x05c4 }
            if (r3 != 0) goto L_0x0035
            r3 = r0
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.measurement.zzgo r3 = r12.zzg     // Catch:{ all -> 0x05c4 }
            java.lang.Object r2 = r9.zza(r15, r3, r2)     // Catch:{ all -> 0x05c4 }
            r3 = r2
        L_0x003c:
            if (r3 == 0) goto L_0x0051
            if (r1 != 0) goto L_0x0044
            com.google.android.gms.internal.measurement.zzew r1 = r9.zzb(r13)     // Catch:{ all -> 0x05c4 }
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
            java.lang.Object r10 = r8.zzc(r13)     // Catch:{ all -> 0x05c4 }
        L_0x005a:
            boolean r2 = r8.zza(r10, r14)     // Catch:{ all -> 0x05c4 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x0062:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0071
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0062
        L_0x0071:
            if (r10 == 0) goto L_0x0076
            r8.zzb(r13, r10)
        L_0x0076:
            return
        L_0x0077:
            int r4 = r12.zzd(r3)     // Catch:{ all -> 0x05c4 }
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
            java.lang.Object r10 = r8.zza()     // Catch:{ zzfn -> 0x059d }
            goto L_0x0580
        L_0x008e:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzhd r6 = r12.zza(r3)     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r6 = r14.zzb(r6, r15)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x00a0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            long r6 = r14.zzt()     // Catch:{ zzfn -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x00b2:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            int r6 = r14.zzs()     // Catch:{ zzfn -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x00c4:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            long r6 = r14.zzr()     // Catch:{ zzfn -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x00d6:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            int r6 = r14.zzq()     // Catch:{ zzfn -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x00e8:
            int r5 = r14.zzp()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzfk r7 = r12.zzc(r3)     // Catch:{ zzfn -> 0x059d }
            if (r7 == 0) goto L_0x00ff
            boolean r7 = r7.zza(r5)     // Catch:{ zzfn -> 0x059d }
            if (r7 == 0) goto L_0x00f9
            goto L_0x00ff
        L_0x00f9:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhf.zza(r2, r5, r10, r8)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x00ff:
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzfn -> 0x059d }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r6, r4)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x010d:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            int r6 = r14.zzo()     // Catch:{ zzfn -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x011f:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzdu r6 = r14.zzn()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x012d:
            boolean r5 = r12.zza(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            if (r5 == 0) goto L_0x0149
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzib.zzf(r13, r4)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzhd r7 = r12.zza(r3)     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r7 = r14.zza(r7, r15)     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzff.zza(r6, r7)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0159
        L_0x0149:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzhd r6 = r12.zza(r3)     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r6 = r14.zza(r6, r15)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
        L_0x0159:
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x015e:
            r12.zza(r13, r4, r14)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0166:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            boolean r6 = r14.zzk()     // Catch:{ zzfn -> 0x059d }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0178:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            int r6 = r14.zzj()     // Catch:{ zzfn -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x018a:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            long r6 = r14.zzi()     // Catch:{ zzfn -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x019c:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            int r6 = r14.zzh()     // Catch:{ zzfn -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x01ae:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            long r6 = r14.zzf()     // Catch:{ zzfn -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x01c0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            long r6 = r14.zzg()     // Catch:{ zzfn -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x01d2:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            float r6 = r14.zze()     // Catch:{ zzfn -> 0x059d }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x01e4:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzfn -> 0x059d }
            double r6 = r14.zzd()     // Catch:{ zzfn -> 0x059d }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x01f6:
            java.lang.Object r2 = r12.zzb(r3)     // Catch:{ zzfn -> 0x059d }
            int r3 = r12.zzd(r3)     // Catch:{ zzfn -> 0x059d }
            r3 = r3 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzib.zzf(r13, r3)     // Catch:{ zzfn -> 0x059d }
            if (r5 != 0) goto L_0x0210
            com.google.android.gms.internal.measurement.zzgh r5 = r12.zzs     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r5 = r5.zze(r2)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r3, r5)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0227
        L_0x0210:
            com.google.android.gms.internal.measurement.zzgh r6 = r12.zzs     // Catch:{ zzfn -> 0x059d }
            boolean r6 = r6.zzc(r5)     // Catch:{ zzfn -> 0x059d }
            if (r6 == 0) goto L_0x0227
            com.google.android.gms.internal.measurement.zzgh r6 = r12.zzs     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r6 = r6.zze(r2)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzgh r7 = r12.zzs     // Catch:{ zzfn -> 0x059d }
            r7.zza(r6, r5)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r3, r6)     // Catch:{ zzfn -> 0x059d }
            r5 = r6
        L_0x0227:
            com.google.android.gms.internal.measurement.zzgh r3 = r12.zzs     // Catch:{ zzfn -> 0x059d }
            java.util.Map r3 = r3.zza(r5)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzgh r4 = r12.zzs     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzgf r2 = r4.zzf(r2)     // Catch:{ zzfn -> 0x059d }
            r14.zza(r3, r2, r15)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0238:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzhd r2 = r12.zza(r3)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzfy r3 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            java.util.List r3 = r3.zza(r13, r4)     // Catch:{ zzfn -> 0x059d }
            r14.zzb(r3, r2, r15)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x024a:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzq(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0258:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzp(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0266:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzo(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0274:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzn(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0282:
            com.google.android.gms.internal.measurement.zzfy r5 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzfn -> 0x059d }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzfn -> 0x059d }
            r14.zzm(r4)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzfk r3 = r12.zzc(r3)     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhf.zza(r2, r4, r3, r10, r8)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0297:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzl(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x02a5:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzh(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x02b3:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzg(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x02c1:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzf(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x02cf:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zze(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x02dd:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzc(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x02eb:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzd(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x02f9:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzb(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0307:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zza(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0315:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzq(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0323:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzp(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0331:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzo(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x033f:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzn(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x034d:
            com.google.android.gms.internal.measurement.zzfy r5 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzfn -> 0x059d }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzfn -> 0x059d }
            r14.zzm(r4)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzfk r3 = r12.zzc(r3)     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhf.zza(r2, r4, r3, r10, r8)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0362:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzl(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0370:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzk(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x037e:
            com.google.android.gms.internal.measurement.zzhd r2 = r12.zza(r3)     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzfy r5 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            java.util.List r3 = r5.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zza(r3, r2, r15)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0390:
            boolean r2 = zzf(r4)     // Catch:{ zzfn -> 0x059d }
            if (r2 == 0) goto L_0x03a4
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzj(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x03a4:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzi(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x03b2:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzh(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x03c0:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzg(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x03ce:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzf(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x03dc:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zze(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x03ea:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzc(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x03f8:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzd(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0406:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zzb(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0414:
            com.google.android.gms.internal.measurement.zzfy r2 = r12.zzp     // Catch:{ zzfn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzfn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            r14.zza(r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0422:
            boolean r2 = r12.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            if (r2 == 0) goto L_0x0440
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzib.zzf(r13, r4)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzhd r3 = r12.zza(r3)     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r3 = r14.zzb(r3, r15)     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzff.zza(r2, r3)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0440:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzhd r2 = r12.zza(r3)     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r2 = r14.zzb(r2, r15)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r2)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0453:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            long r6 = r14.zzt()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0462:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            int r2 = r14.zzs()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r2)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0471:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            long r6 = r14.zzr()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0480:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            int r2 = r14.zzq()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r2)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x048f:
            int r5 = r14.zzp()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzfk r7 = r12.zzc(r3)     // Catch:{ zzfn -> 0x059d }
            if (r7 == 0) goto L_0x04a6
            boolean r7 = r7.zza(r5)     // Catch:{ zzfn -> 0x059d }
            if (r7 == 0) goto L_0x04a0
            goto L_0x04a6
        L_0x04a0:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhf.zza(r2, r5, r10, r8)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x04a6:
            r2 = r4 & r6
            long r6 = (long) r2     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r6, r5)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x04b1:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            int r2 = r14.zzo()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r2)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x04c0:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzdu r2 = r14.zzn()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r2)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x04cf:
            boolean r2 = r12.zza(r13, r3)     // Catch:{ zzfn -> 0x059d }
            if (r2 == 0) goto L_0x04ed
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzib.zzf(r13, r4)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzhd r3 = r12.zza(r3)     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r3 = r14.zza(r3, r15)     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzff.zza(r2, r3)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r2)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x04ed:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzhd r2 = r12.zza(r3)     // Catch:{ zzfn -> 0x059d }
            java.lang.Object r2 = r14.zza(r2, r15)     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r2)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0500:
            r12.zza(r13, r4, r14)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0508:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            boolean r2 = r14.zzk()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r2)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0517:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            int r2 = r14.zzj()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r2)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0526:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            long r6 = r14.zzi()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0535:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            int r2 = r14.zzh()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r2)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0544:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            long r6 = r14.zzf()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0553:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            long r6 = r14.zzg()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0562:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            float r2 = r14.zze()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r2)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0571:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzfn -> 0x059d }
            double r6 = r14.zzd()     // Catch:{ zzfn -> 0x059d }
            com.google.android.gms.internal.measurement.zzib.zza(r13, r4, r6)     // Catch:{ zzfn -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzfn -> 0x059d }
            goto L_0x0009
        L_0x0580:
            boolean r2 = r8.zza(r10, r14)     // Catch:{ zzfn -> 0x059d }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x0588:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0597
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0588
        L_0x0597:
            if (r10 == 0) goto L_0x059c
            r8.zzb(r13, r10)
        L_0x059c:
            return
        L_0x059d:
            r8.zza(r14)     // Catch:{ all -> 0x05c4 }
            if (r10 != 0) goto L_0x05a7
            java.lang.Object r2 = r8.zzc(r13)     // Catch:{ all -> 0x05c4 }
            r10 = r2
        L_0x05a7:
            boolean r2 = r8.zza(r10, r14)     // Catch:{ all -> 0x05c4 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x05af:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x05be
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x05af
        L_0x05be:
            if (r10 == 0) goto L_0x05c3
            r8.zzb(r13, r10)
        L_0x05c3:
            return
        L_0x05c4:
            r14 = move-exception
            int r15 = r12.zzm
        L_0x05c7:
            int r0 = r12.zzn
            if (r15 >= r0) goto L_0x05d6
            int[] r0 = r12.zzl
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza(r13, r0, r10, r8)
            int r15 = r15 + 1
            goto L_0x05c7
        L_0x05d6:
            if (r10 == 0) goto L_0x05db
            r8.zzb(r13, r10)
        L_0x05db:
            throw r14
        L_0x05dc:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzhe, com.google.android.gms.internal.measurement.zzeq):void");
    }

    private static zzhy zze(Object obj) {
        zzfd zzfd = (zzfd) obj;
        zzhy zzhy = zzfd.zzb;
        if (zzhy != zzhy.zza()) {
            return zzhy;
        }
        zzhy zzb2 = zzhy.zzb();
        zzfd.zzb = zzb2;
        return zzb2;
    }

    private static int zza(byte[] bArr, int i, int i2, zzim zzim, Class<?> cls, zzdt zzdt) throws IOException {
        switch (zzgr.zza[zzim.ordinal()]) {
            case 1:
                int zzb2 = zzdq.zzb(bArr, i, zzdt);
                zzdt.zzc = Boolean.valueOf(zzdt.zzb != 0);
                return zzb2;
            case 2:
                return zzdq.zze(bArr, i, zzdt);
            case 3:
                zzdt.zzc = Double.valueOf(zzdq.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzdt.zzc = Integer.valueOf(zzdq.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzdt.zzc = Long.valueOf(zzdq.zzb(bArr, i));
                return i + 8;
            case 8:
                zzdt.zzc = Float.valueOf(zzdq.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza2 = zzdq.zza(bArr, i, zzdt);
                zzdt.zzc = Integer.valueOf(zzdt.zza);
                return zza2;
            case 12:
            case 13:
                int zzb3 = zzdq.zzb(bArr, i, zzdt);
                zzdt.zzc = Long.valueOf(zzdt.zzb);
                return zzb3;
            case 14:
                return zzdq.zza(zzgz.zza().zza((Class) cls), bArr, i, i2, zzdt);
            case 15:
                int zza3 = zzdq.zza(bArr, i, zzdt);
                zzdt.zzc = Integer.valueOf(zzeg.zze(zzdt.zza));
                return zza3;
            case 16:
                int zzb4 = zzdq.zzb(bArr, i, zzdt);
                zzdt.zzc = Long.valueOf(zzeg.zza(zzdt.zzb));
                return zzb4;
            case 17:
                return zzdq.zzd(bArr, i, zzdt);
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
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.measurement.zzdt r30) throws java.io.IOException {
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
            sun.misc.Unsafe r11 = com.google.android.gms.internal.measurement.zzgs.zzb
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzfl r11 = (com.google.android.gms.internal.measurement.zzfl) r11
            boolean r12 = r11.zza()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.measurement.zzfl r11 = r11.zza(r12)
            sun.misc.Unsafe r12 = com.google.android.gms.internal.measurement.zzgs.zzb
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
            com.google.android.gms.internal.measurement.zzhd r1 = r0.zza(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzdq.zza(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
        L_0x005f:
            if (r4 >= r5) goto L_0x0422
            int r8 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r9 = r7.zza
            if (r2 != r9) goto L_0x0422
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzdq.zza(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
            goto L_0x005f
        L_0x007f:
            if (r6 != r10) goto L_0x00a3
            com.google.android.gms.internal.measurement.zzgc r11 = (com.google.android.gms.internal.measurement.zzgc) r11
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x008a:
            if (r1 >= r2) goto L_0x009a
            int r1 = com.google.android.gms.internal.measurement.zzdq.zzb(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzeg.zza(r4)
            r11.zza(r4)
            goto L_0x008a
        L_0x009a:
            if (r1 != r2) goto L_0x009e
            goto L_0x0423
        L_0x009e:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zza()
            throw r1
        L_0x00a3:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzgc r11 = (com.google.android.gms.internal.measurement.zzgc) r11
            int r1 = com.google.android.gms.internal.measurement.zzdq.zzb(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzeg.zza(r8)
            r11.zza(r8)
        L_0x00b4:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdq.zzb(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzeg.zza(r8)
            r11.zza(r8)
            goto L_0x00b4
        L_0x00cc:
            if (r6 != r10) goto L_0x00f0
            com.google.android.gms.internal.measurement.zzfg r11 = (com.google.android.gms.internal.measurement.zzfg) r11
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00d7:
            if (r1 >= r2) goto L_0x00e7
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzeg.zze(r4)
            r11.zzd(r4)
            goto L_0x00d7
        L_0x00e7:
            if (r1 != r2) goto L_0x00eb
            goto L_0x0423
        L_0x00eb:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zza()
            throw r1
        L_0x00f0:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzfg r11 = (com.google.android.gms.internal.measurement.zzfg) r11
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzeg.zze(r4)
            r11.zzd(r4)
        L_0x0101:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzeg.zze(r4)
            r11.zzd(r4)
            goto L_0x0101
        L_0x0119:
            if (r6 != r10) goto L_0x0120
            int r2 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r11, r7)
            goto L_0x0131
        L_0x0120:
            if (r6 != 0) goto L_0x0422
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.measurement.zzdq.zza(r2, r3, r4, r5, r6, r7)
        L_0x0131:
            com.google.android.gms.internal.measurement.zzfd r1 = (com.google.android.gms.internal.measurement.zzfd) r1
            com.google.android.gms.internal.measurement.zzhy r3 = r1.zzb
            com.google.android.gms.internal.measurement.zzhy r4 = com.google.android.gms.internal.measurement.zzhy.zza()
            if (r3 != r4) goto L_0x013c
            r3 = 0
        L_0x013c:
            com.google.android.gms.internal.measurement.zzfk r4 = r0.zzc(r8)
            com.google.android.gms.internal.measurement.zzhv<?, ?> r5 = r0.zzq
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhf.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.measurement.zzhy r3 = (com.google.android.gms.internal.measurement.zzhy) r3
            if (r3 == 0) goto L_0x014e
            r1.zzb = r3
        L_0x014e:
            r1 = r2
            goto L_0x0423
        L_0x0151:
            if (r6 != r10) goto L_0x0422
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01a4
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x019f
            if (r4 != 0) goto L_0x0167
            com.google.android.gms.internal.measurement.zzdu r4 = com.google.android.gms.internal.measurement.zzdu.zza
            r11.add(r4)
            goto L_0x016f
        L_0x0167:
            com.google.android.gms.internal.measurement.zzdu r6 = com.google.android.gms.internal.measurement.zzdu.zza(r3, r1, r4)
            r11.add(r6)
        L_0x016e:
            int r1 = r1 + r4
        L_0x016f:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x019a
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0195
            if (r4 != 0) goto L_0x018d
            com.google.android.gms.internal.measurement.zzdu r4 = com.google.android.gms.internal.measurement.zzdu.zza
            r11.add(r4)
            goto L_0x016f
        L_0x018d:
            com.google.android.gms.internal.measurement.zzdu r6 = com.google.android.gms.internal.measurement.zzdu.zza(r3, r1, r4)
            r11.add(r6)
            goto L_0x016e
        L_0x0195:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zza()
            throw r1
        L_0x019a:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zzb()
            throw r1
        L_0x019f:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zza()
            throw r1
        L_0x01a4:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zzb()
            throw r1
        L_0x01a9:
            if (r6 != r10) goto L_0x0422
            com.google.android.gms.internal.measurement.zzhd r1 = r0.zza(r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x0423
        L_0x01c3:
            if (r6 != r10) goto L_0x0422
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            int r1 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x0216
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0211
            if (r4 != 0) goto L_0x01de
            r11.add(r6)
            goto L_0x01e9
        L_0x01de:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzff.zza
            r8.<init>(r3, r1, r4, r9)
            r11.add(r8)
        L_0x01e8:
            int r1 = r1 + r4
        L_0x01e9:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x020c
            if (r4 != 0) goto L_0x0201
            r11.add(r6)
            goto L_0x01e9
        L_0x0201:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzff.zza
            r8.<init>(r3, r1, r4, r9)
            r11.add(r8)
            goto L_0x01e8
        L_0x020c:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zzb()
            throw r1
        L_0x0211:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zzb()
            throw r1
        L_0x0216:
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0271
            if (r4 != 0) goto L_0x0224
            r11.add(r6)
            goto L_0x0237
        L_0x0224:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.zzie.zza(r3, r1, r8)
            if (r9 == 0) goto L_0x026c
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzff.zza
            r9.<init>(r3, r1, r4, r10)
            r11.add(r9)
        L_0x0236:
            r1 = r8
        L_0x0237:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0267
            if (r4 != 0) goto L_0x024f
            r11.add(r6)
            goto L_0x0237
        L_0x024f:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.zzie.zza(r3, r1, r8)
            if (r9 == 0) goto L_0x0262
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzff.zza
            r9.<init>(r3, r1, r4, r10)
            r11.add(r9)
            goto L_0x0236
        L_0x0262:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zzh()
            throw r1
        L_0x0267:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zzb()
            throw r1
        L_0x026c:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zzh()
            throw r1
        L_0x0271:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zzb()
            throw r1
        L_0x0276:
            r1 = 0
            if (r6 != r10) goto L_0x029e
            com.google.android.gms.internal.measurement.zzds r11 = (com.google.android.gms.internal.measurement.zzds) r11
            int r2 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0282:
            if (r2 >= r4) goto L_0x0295
            int r2 = com.google.android.gms.internal.measurement.zzdq.zzb(r3, r2, r7)
            long r5 = r7.zzb
            int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r5 == 0) goto L_0x0290
            r5 = r13
            goto L_0x0291
        L_0x0290:
            r5 = r1
        L_0x0291:
            r11.zza(r5)
            goto L_0x0282
        L_0x0295:
            if (r2 != r4) goto L_0x0299
            goto L_0x014e
        L_0x0299:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zza()
            throw r1
        L_0x029e:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzds r11 = (com.google.android.gms.internal.measurement.zzds) r11
            int r4 = com.google.android.gms.internal.measurement.zzdq.zzb(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = r13
            goto L_0x02af
        L_0x02ae:
            r6 = r1
        L_0x02af:
            r11.zza(r6)
        L_0x02b2:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.measurement.zzdq.zzb(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02c8
            r6 = r13
            goto L_0x02c9
        L_0x02c8:
            r6 = r1
        L_0x02c9:
            r11.zza(r6)
            goto L_0x02b2
        L_0x02cd:
            if (r6 != r10) goto L_0x02ed
            com.google.android.gms.internal.measurement.zzfg r11 = (com.google.android.gms.internal.measurement.zzfg) r11
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02d8:
            if (r1 >= r2) goto L_0x02e4
            int r4 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r1)
            r11.zzd(r4)
            int r1 = r1 + 4
            goto L_0x02d8
        L_0x02e4:
            if (r1 != r2) goto L_0x02e8
            goto L_0x0423
        L_0x02e8:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zza()
            throw r1
        L_0x02ed:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.measurement.zzfg r11 = (com.google.android.gms.internal.measurement.zzfg) r11
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r18, r19)
            r11.zzd(r1)
        L_0x02f8:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4)
            r11.zzd(r1)
            goto L_0x02f8
        L_0x030c:
            if (r6 != r10) goto L_0x032c
            com.google.android.gms.internal.measurement.zzgc r11 = (com.google.android.gms.internal.measurement.zzgc) r11
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0317:
            if (r1 >= r2) goto L_0x0323
            long r4 = com.google.android.gms.internal.measurement.zzdq.zzb(r3, r1)
            r11.zza(r4)
            int r1 = r1 + 8
            goto L_0x0317
        L_0x0323:
            if (r1 != r2) goto L_0x0327
            goto L_0x0423
        L_0x0327:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zza()
            throw r1
        L_0x032c:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.measurement.zzgc r11 = (com.google.android.gms.internal.measurement.zzgc) r11
            long r8 = com.google.android.gms.internal.measurement.zzdq.zzb(r18, r19)
            r11.zza(r8)
        L_0x0337:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            long r8 = com.google.android.gms.internal.measurement.zzdq.zzb(r3, r4)
            r11.zza(r8)
            goto L_0x0337
        L_0x034b:
            if (r6 != r10) goto L_0x0353
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r11, r7)
            goto L_0x0423
        L_0x0353:
            if (r6 != 0) goto L_0x0422
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r21, r22, r23, r24, r25, r26)
            goto L_0x0423
        L_0x0365:
            if (r6 != r10) goto L_0x0385
            com.google.android.gms.internal.measurement.zzgc r11 = (com.google.android.gms.internal.measurement.zzgc) r11
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0370:
            if (r1 >= r2) goto L_0x037c
            int r1 = com.google.android.gms.internal.measurement.zzdq.zzb(r3, r1, r7)
            long r4 = r7.zzb
            r11.zza(r4)
            goto L_0x0370
        L_0x037c:
            if (r1 != r2) goto L_0x0380
            goto L_0x0423
        L_0x0380:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zza()
            throw r1
        L_0x0385:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzgc r11 = (com.google.android.gms.internal.measurement.zzgc) r11
            int r1 = com.google.android.gms.internal.measurement.zzdq.zzb(r3, r4, r7)
            long r8 = r7.zzb
            r11.zza(r8)
        L_0x0392:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdq.zzb(r3, r4, r7)
            long r8 = r7.zzb
            r11.zza(r8)
            goto L_0x0392
        L_0x03a6:
            if (r6 != r10) goto L_0x03c5
            com.google.android.gms.internal.measurement.zzfc r11 = (com.google.android.gms.internal.measurement.zzfc) r11
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03b1:
            if (r1 >= r2) goto L_0x03bd
            float r4 = com.google.android.gms.internal.measurement.zzdq.zzd(r3, r1)
            r11.zza(r4)
            int r1 = r1 + 4
            goto L_0x03b1
        L_0x03bd:
            if (r1 != r2) goto L_0x03c0
            goto L_0x0423
        L_0x03c0:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zza()
            throw r1
        L_0x03c5:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.measurement.zzfc r11 = (com.google.android.gms.internal.measurement.zzfc) r11
            float r1 = com.google.android.gms.internal.measurement.zzdq.zzd(r18, r19)
            r11.zza(r1)
        L_0x03d0:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            float r1 = com.google.android.gms.internal.measurement.zzdq.zzd(r3, r4)
            r11.zza(r1)
            goto L_0x03d0
        L_0x03e4:
            if (r6 != r10) goto L_0x0403
            com.google.android.gms.internal.measurement.zzeo r11 = (com.google.android.gms.internal.measurement.zzeo) r11
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ef:
            if (r1 >= r2) goto L_0x03fb
            double r4 = com.google.android.gms.internal.measurement.zzdq.zzc(r3, r1)
            r11.zza(r4)
            int r1 = r1 + 8
            goto L_0x03ef
        L_0x03fb:
            if (r1 != r2) goto L_0x03fe
            goto L_0x0423
        L_0x03fe:
            com.google.android.gms.internal.measurement.zzfo r1 = com.google.android.gms.internal.measurement.zzfo.zza()
            throw r1
        L_0x0403:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.measurement.zzeo r11 = (com.google.android.gms.internal.measurement.zzeo) r11
            double r8 = com.google.android.gms.internal.measurement.zzdq.zzc(r18, r19)
            r11.zza(r8)
        L_0x040e:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdq.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            double r8 = com.google.android.gms.internal.measurement.zzdq.zzc(r3, r4)
            r11.zza(r8)
            goto L_0x040e
        L_0x0422:
            r1 = r4
        L_0x0423:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzdt):int");
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.measurement.zzdt r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = com.google.android.gms.internal.measurement.zzgs.zzb
            java.lang.Object r12 = r7.zzb(r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.measurement.zzgh r2 = r7.zzs
            boolean r2 = r2.zzc(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.measurement.zzgh r2 = r7.zzs
            java.lang.Object r2 = r2.zze(r12)
            com.google.android.gms.internal.measurement.zzgh r3 = r7.zzs
            r3.zza(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.measurement.zzgh r8 = r7.zzs
            com.google.android.gms.internal.measurement.zzgf r8 = r8.zzf(r12)
            com.google.android.gms.internal.measurement.zzgh r12 = r7.zzs
            java.util.Map r12 = r12.zza(r1)
            int r10 = com.google.android.gms.internal.measurement.zzdq.zza(r9, r10, r15)
            int r13 = r15.zza
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzb
            V r0 = r8.zzd
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.measurement.zzdq.zza(r10, r9, r1, r15)
            int r10 = r15.zza
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
            com.google.android.gms.internal.measurement.zzim r1 = r8.zzc
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.measurement.zzim r4 = r8.zzc
            V r10 = r8.zzd
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza(r1, r2, r3, r4, r5, r6)
            java.lang.Object r0 = r15.zzc
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.measurement.zzim r1 = r8.zza
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.measurement.zzim r4 = r8.zza
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza(r1, r2, r3, r4, r5, r6)
            java.lang.Object r14 = r15.zzc
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.measurement.zzdq.zza(r10, r9, r2, r11, r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.measurement.zzfo r8 = com.google.android.gms.internal.measurement.zzfo.zzg()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.measurement.zzfo r8 = com.google.android.gms.internal.measurement.zzfo.zza()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.measurement.zzdt):int");
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzdt zzdt) throws IOException {
        int i9;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i10 = i;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        long j2 = j;
        int i14 = i8;
        zzdt zzdt2 = zzdt;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i14 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i13 == 1) {
                    unsafe.putObject(t2, j2, Double.valueOf(zzdq.zzc(bArr, i)));
                    i9 = i10 + 8;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 52:
                if (i13 == 5) {
                    unsafe.putObject(t2, j2, Float.valueOf(zzdq.zzd(bArr, i)));
                    i9 = i10 + 4;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 53:
            case 54:
                if (i13 == 0) {
                    i9 = zzdq.zzb(bArr2, i10, zzdt2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzdt2.zzb));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 55:
            case 62:
                if (i13 == 0) {
                    i9 = zzdq.zza(bArr2, i10, zzdt2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzdt2.zza));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 56:
            case 65:
                if (i13 == 1) {
                    unsafe.putObject(t2, j2, Long.valueOf(zzdq.zzb(bArr, i)));
                    i9 = i10 + 8;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 57:
            case 64:
                if (i13 == 5) {
                    unsafe.putObject(t2, j2, Integer.valueOf(zzdq.zza(bArr, i)));
                    i9 = i10 + 4;
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 58:
                if (i13 == 0) {
                    i9 = zzdq.zzb(bArr2, i10, zzdt2);
                    unsafe.putObject(t2, j2, Boolean.valueOf(zzdt2.zzb != 0));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 59:
                if (i13 == 2) {
                    int zza2 = zzdq.zza(bArr2, i10, zzdt2);
                    int i15 = zzdt2.zza;
                    if (i15 == 0) {
                        unsafe.putObject(t2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zzie.zza(bArr2, zza2, zza2 + i15)) {
                        unsafe.putObject(t2, j2, new String(bArr2, zza2, i15, zzff.zza));
                        zza2 += i15;
                    } else {
                        throw zzfo.zzh();
                    }
                    unsafe.putInt(t2, j3, i12);
                    return zza2;
                }
                return i10;
            case 60:
                if (i13 == 2) {
                    int zza3 = zzdq.zza(zza(i14), bArr2, i10, i2, zzdt2);
                    Object object = unsafe.getInt(t2, j3) == i12 ? unsafe.getObject(t2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t2, j2, zzdt2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzff.zza(object, zzdt2.zzc));
                    }
                    unsafe.putInt(t2, j3, i12);
                    return zza3;
                }
                return i10;
            case 61:
                if (i13 == 2) {
                    i9 = zzdq.zze(bArr2, i10, zzdt2);
                    unsafe.putObject(t2, j2, zzdt2.zzc);
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 63:
                if (i13 == 0) {
                    int zza4 = zzdq.zza(bArr2, i10, zzdt2);
                    int i16 = zzdt2.zza;
                    zzfk zzc2 = zzc(i14);
                    if (zzc2 == null || zzc2.zza(i16)) {
                        unsafe.putObject(t2, j2, Integer.valueOf(i16));
                        i9 = zza4;
                        unsafe.putInt(t2, j3, i12);
                        return i9;
                    }
                    zze(t).zza(i11, Long.valueOf((long) i16));
                    return zza4;
                }
                return i10;
            case 66:
                if (i13 == 0) {
                    i9 = zzdq.zza(bArr2, i10, zzdt2);
                    unsafe.putObject(t2, j2, Integer.valueOf(zzeg.zze(zzdt2.zza)));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 67:
                if (i13 == 0) {
                    i9 = zzdq.zzb(bArr2, i10, zzdt2);
                    unsafe.putObject(t2, j2, Long.valueOf(zzeg.zza(zzdt2.zzb)));
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            case 68:
                if (i13 == 3) {
                    i9 = zzdq.zza(zza(i14), bArr, i, i2, (i11 & -8) | 4, zzdt);
                    Object object2 = unsafe.getInt(t2, j3) == i12 ? unsafe.getObject(t2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t2, j2, zzdt2.zzc);
                    } else {
                        unsafe.putObject(t2, j2, zzff.zza(object2, zzdt2.zzc));
                    }
                    unsafe.putInt(t2, j3, i12);
                    return i9;
                }
                return i10;
            default:
                return i10;
        }
    }

    private final zzhd zza(int i) {
        int i2 = (i / 3) << 1;
        zzhd zzhd = (zzhd) this.zzd[i2];
        if (zzhd != null) {
            return zzhd;
        }
        zzhd zza2 = zzgz.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzfk zzc(int i) {
        return (zzfk) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Type inference failed for: r34v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v26, types: [int] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x036c, code lost:
        if (r0 == r15) goto L_0x03df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03b5, code lost:
        if (r0 == r15) goto L_0x03df;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.measurement.zzdt r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = com.google.android.gms.internal.measurement.zzgs.zzb
            r16 = 0
            r0 = r32
            r2 = r16
            r3 = r2
            r6 = r3
            r1 = -1
            r7 = -1
        L_0x0018:
            if (r0 >= r13) goto L_0x047f
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r0, r12, r3, r9)
            int r3 = r9.zza
            r4 = r0
            r5 = r3
            goto L_0x002b
        L_0x0029:
            r5 = r0
            r4 = r3
        L_0x002b:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x0038
            int r2 = r2 / r8
            int r1 = r15.zza(r3, r2)
            goto L_0x003c
        L_0x0038:
            int r1 = r15.zzg(r3)
        L_0x003c:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004b
            r24 = r3
            r2 = r4
            r9 = r5
            r26 = r10
            r8 = r11
            r18 = r16
            goto L_0x03e3
        L_0x004b:
            int[] r1 = r15.zzc
            int r18 = r2 + 1
            r8 = r1[r18]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r8 & r18
            int r11 = r18 >>> 20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r5
            r5 = r8 & r18
            long r12 = (long) r5
            r5 = 17
            r20 = r8
            if (r11 > r5) goto L_0x02d6
            int r5 = r2 + 2
            r1 = r1[r5]
            int r5 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r5
            r1 = r1 & r18
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
                case 0: goto L_0x02a0;
                case 1: goto L_0x0286;
                case 2: goto L_0x0260;
                case 3: goto L_0x0260;
                case 4: goto L_0x0245;
                case 5: goto L_0x0220;
                case 6: goto L_0x01fd;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01af;
                case 9: goto L_0x0179;
                case 10: goto L_0x015e;
                case 11: goto L_0x0245;
                case 12: goto L_0x012c;
                case 13: goto L_0x01fd;
                case 14: goto L_0x0220;
                case 15: goto L_0x0111;
                case 16: goto L_0x00e4;
                case 17: goto L_0x0092;
                default: goto L_0x0083;
            }
        L_0x0083:
            r12 = r31
            r13 = r35
            r9 = r2
            r11 = r3
            r18 = r5
            r32 = r7
            r8 = r19
        L_0x008f:
            r7 = r4
            goto L_0x02c8
        L_0x0092:
            r8 = 3
            if (r0 != r8) goto L_0x00d8
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.measurement.zzhd r0 = r15.zza(r2)
            r1 = r31
            r9 = r2
            r2 = r4
            r11 = r3
            r3 = r33
            r4 = r8
            r18 = r5
            r8 = r19
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00bb
            r5 = r35
            java.lang.Object r1 = r5.zzc
            r10.putObject(r14, r12, r1)
            goto L_0x00ca
        L_0x00bb:
            r5 = r35
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r5.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzff.zza(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x00ca:
            r6 = r6 | r22
            r12 = r31
            r13 = r33
            r3 = r8
            r2 = r9
            r1 = r11
            r11 = r34
            r9 = r5
            goto L_0x0018
        L_0x00d8:
            r9 = r2
            r11 = r3
            r18 = r5
            r8 = r19
            r12 = r31
            r13 = r35
            goto L_0x0241
        L_0x00e4:
            r9 = r2
            r11 = r3
            r18 = r5
            r8 = r19
            r5 = r35
            if (r0 != 0) goto L_0x010c
            r2 = r12
            r12 = r31
            int r13 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r4, r5)
            long r0 = r5.zzb
            long r19 = com.google.android.gms.internal.measurement.zzeg.zza(r0)
            r0 = r10
            r1 = r30
            r32 = r13
            r13 = r5
            r4 = r19
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r32
            goto L_0x02be
        L_0x010c:
            r12 = r31
            r13 = r5
            goto L_0x0241
        L_0x0111:
            r9 = r2
            r11 = r3
            r18 = r5
            r2 = r12
            r8 = r19
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x0241
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r4, r13)
            int r1 = r13.zza
            int r1 = com.google.android.gms.internal.measurement.zzeg.zze(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x0175
        L_0x012c:
            r9 = r2
            r11 = r3
            r18 = r5
            r2 = r12
            r8 = r19
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x0241
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r4, r13)
            int r1 = r13.zza
            com.google.android.gms.internal.measurement.zzfk r4 = r15.zzc(r9)
            if (r4 == 0) goto L_0x015a
            boolean r4 = r4.zza(r1)
            if (r4 == 0) goto L_0x014c
            goto L_0x015a
        L_0x014c:
            com.google.android.gms.internal.measurement.zzhy r2 = zze(r30)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zza(r8, r1)
            goto L_0x02be
        L_0x015a:
            r10.putInt(r14, r2, r1)
            goto L_0x0175
        L_0x015e:
            r9 = r2
            r11 = r3
            r18 = r5
            r2 = r12
            r8 = r19
            r1 = 2
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x0241
            int r0 = com.google.android.gms.internal.measurement.zzdq.zze(r12, r4, r13)
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r2, r1)
        L_0x0175:
            r6 = r6 | r22
            goto L_0x02be
        L_0x0179:
            r9 = r2
            r11 = r3
            r18 = r5
            r2 = r12
            r8 = r19
            r1 = 2
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x01ab
            com.google.android.gms.internal.measurement.zzhd r0 = r15.zza(r9)
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r0, r12, r4, r5, r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x019c
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x0215
        L_0x019c:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r13.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzff.zza(r1, r4)
            r10.putObject(r14, r2, r1)
            goto L_0x0215
        L_0x01ab:
            r5 = r33
            goto L_0x0241
        L_0x01af:
            r9 = r2
            r11 = r3
            r18 = r5
            r2 = r12
            r8 = r19
            r1 = 2
            r12 = r31
            r5 = r33
            r13 = r35
            if (r0 != r1) goto L_0x0241
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.measurement.zzdq.zzc(r12, r4, r13)
            goto L_0x01ce
        L_0x01ca:
            int r0 = com.google.android.gms.internal.measurement.zzdq.zzd(r12, r4, r13)
        L_0x01ce:
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x0215
        L_0x01d4:
            r9 = r2
            r11 = r3
            r18 = r5
            r2 = r12
            r8 = r19
            r12 = r31
            r5 = r33
            r13 = r35
            if (r0 != 0) goto L_0x0241
            int r0 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r4, r13)
            r32 = r0
            long r0 = r13.zzb
            r19 = 0
            int r0 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x01f3
            r0 = 1
            goto L_0x01f5
        L_0x01f3:
            r0 = r16
        L_0x01f5:
            com.google.android.gms.internal.measurement.zzib.zza(r14, r2, r0)
            r6 = r6 | r22
            r0 = r32
            goto L_0x0217
        L_0x01fd:
            r9 = r2
            r11 = r3
            r18 = r5
            r2 = r12
            r8 = r19
            r12 = r31
            r5 = r33
            r13 = r35
            if (r0 != r1) goto L_0x0241
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
        L_0x0215:
            r6 = r6 | r22
        L_0x0217:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r34
            r13 = r5
            goto L_0x0018
        L_0x0220:
            r9 = r2
            r11 = r3
            r18 = r5
            r2 = r12
            r8 = r19
            r1 = 1
            r12 = r31
            r5 = r33
            r13 = r35
            if (r0 != r1) goto L_0x0241
            long r19 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r4)
            r0 = r10
            r1 = r30
            r32 = r7
            r7 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x02b8
        L_0x0241:
            r32 = r7
            goto L_0x008f
        L_0x0245:
            r9 = r2
            r11 = r3
            r18 = r5
            r32 = r7
            r2 = r12
            r8 = r19
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != 0) goto L_0x02c8
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r7, r13)
            int r1 = r13.zza
            r10.putInt(r14, r2, r1)
            goto L_0x02ba
        L_0x0260:
            r9 = r2
            r11 = r3
            r18 = r5
            r32 = r7
            r2 = r12
            r8 = r19
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != 0) goto L_0x02c8
            int r7 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r7, r13)
            long r4 = r13.zzb
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r7
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r7 = r32
            goto L_0x02c2
        L_0x0286:
            r9 = r2
            r11 = r3
            r18 = r5
            r32 = r7
            r2 = r12
            r8 = r19
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != r1) goto L_0x02c8
            float r0 = com.google.android.gms.internal.measurement.zzdq.zzd(r12, r7)
            com.google.android.gms.internal.measurement.zzib.zza(r14, r2, r0)
            int r0 = r7 + 4
            goto L_0x02ba
        L_0x02a0:
            r9 = r2
            r11 = r3
            r18 = r5
            r32 = r7
            r2 = r12
            r8 = r19
            r1 = 1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != r1) goto L_0x02c8
            double r0 = com.google.android.gms.internal.measurement.zzdq.zzc(r12, r7)
            com.google.android.gms.internal.measurement.zzib.zza(r14, r2, r0)
        L_0x02b8:
            int r0 = r7 + 8
        L_0x02ba:
            r6 = r6 | r22
            r7 = r32
        L_0x02be:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
        L_0x02c2:
            r13 = r33
            r11 = r34
            goto L_0x0018
        L_0x02c8:
            r2 = r7
            r18 = r9
            r26 = r10
            r24 = r11
            r7 = r32
            r9 = r8
            r8 = r34
            goto L_0x03e3
        L_0x02d6:
            r5 = r3
            r17 = r7
            r8 = r19
            r18 = -1
            r7 = r4
            r27 = r12
            r12 = r31
            r13 = r9
            r9 = r2
            r2 = r27
            r1 = 27
            if (r11 != r1) goto L_0x033b
            r1 = 2
            if (r0 != r1) goto L_0x032e
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.measurement.zzfl r0 = (com.google.android.gms.internal.measurement.zzfl) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x030b
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0302
            r1 = 10
            goto L_0x0304
        L_0x0302:
            int r1 = r1 << 1
        L_0x0304:
            com.google.android.gms.internal.measurement.zzfl r0 = r0.zza(r1)
            r10.putObject(r14, r2, r0)
        L_0x030b:
            r11 = r0
            com.google.android.gms.internal.measurement.zzhd r0 = r15.zza(r9)
            r1 = r8
            r2 = r31
            r3 = r7
            r4 = r33
            r7 = r5
            r5 = r11
            r19 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r0, r1, r2, r3, r4, r5, r6)
            r11 = r34
            r1 = r7
            r3 = r8
            r2 = r9
            r9 = r13
            r7 = r17
            r6 = r19
            r13 = r33
            goto L_0x0018
        L_0x032e:
            r19 = r6
            r24 = r5
            r15 = r7
            r25 = r8
            r18 = r9
            r26 = r10
            goto L_0x03b8
        L_0x033b:
            r19 = r6
            r6 = r5
            r1 = 49
            if (r11 > r1) goto L_0x038a
            r5 = r20
            long r4 = (long) r5
            r1 = r0
            r0 = r29
            r32 = r1
            r1 = r30
            r22 = r2
            r2 = r31
            r3 = r7
            r20 = r4
            r4 = r33
            r5 = r8
            r24 = r6
            r15 = r7
            r7 = r32
            r25 = r8
            r8 = r9
            r18 = r9
            r26 = r10
            r9 = r20
            r12 = r22
            r14 = r35
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 != r15) goto L_0x0370
            goto L_0x03df
        L_0x0370:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r7 = r17
            r2 = r18
            r6 = r19
            r1 = r24
            r3 = r25
            r10 = r26
            goto L_0x0018
        L_0x038a:
            r32 = r0
            r22 = r2
            r24 = r6
            r15 = r7
            r25 = r8
            r18 = r9
            r26 = r10
            r5 = r20
            r0 = 50
            if (r11 != r0) goto L_0x03c2
            r7 = r32
            r0 = 2
            if (r7 != r0) goto L_0x03b8
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r22
            r8 = r35
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r8)
            if (r0 != r15) goto L_0x0370
            goto L_0x03df
        L_0x03b8:
            r8 = r34
            r2 = r15
        L_0x03bb:
            r7 = r17
            r6 = r19
            r9 = r25
            goto L_0x03e3
        L_0x03c2:
            r7 = r32
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r8 = r5
            r5 = r25
            r6 = r24
            r9 = r11
            r10 = r22
            r12 = r18
            r13 = r35
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r15) goto L_0x0463
        L_0x03df:
            r8 = r34
            r2 = r0
            goto L_0x03bb
        L_0x03e3:
            if (r9 != r8) goto L_0x03f1
            if (r8 != 0) goto L_0x03e8
            goto L_0x03f1
        L_0x03e8:
            r1 = -1
            r10 = r29
            r13 = r30
            r0 = r2
            r3 = r9
            goto L_0x0489
        L_0x03f1:
            r10 = r29
            boolean r0 = r10.zzh
            if (r0 == 0) goto L_0x043e
            r11 = r35
            com.google.android.gms.internal.measurement.zzeq r0 = r11.zzd
            com.google.android.gms.internal.measurement.zzeq r1 = com.google.android.gms.internal.measurement.zzeq.zza()
            if (r0 == r1) goto L_0x043b
            com.google.android.gms.internal.measurement.zzgo r0 = r10.zzg
            com.google.android.gms.internal.measurement.zzeq r1 = r11.zzd
            r12 = r24
            com.google.android.gms.internal.measurement.zzfd$zzf r0 = r1.zza(r0, r12)
            if (r0 != 0) goto L_0x042b
            com.google.android.gms.internal.measurement.zzhy r4 = zze(r30)
            r0 = r9
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r0, r1, r2, r3, r4, r5)
            r14 = r30
            r13 = r33
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r2 = r18
            r10 = r26
            r12 = r31
            goto L_0x0460
        L_0x042b:
            r13 = r30
            r0 = r13
            com.google.android.gms.internal.measurement.zzfd$zzd r0 = (com.google.android.gms.internal.measurement.zzfd.zzd) r0
            r0.zza()
            com.google.android.gms.internal.measurement.zzew<com.google.android.gms.internal.measurement.zzfd$zzc> r0 = r0.zzc
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x043b:
            r13 = r30
            goto L_0x0442
        L_0x043e:
            r13 = r30
            r11 = r35
        L_0x0442:
            r12 = r24
            com.google.android.gms.internal.measurement.zzhy r4 = zze(r30)
            r0 = r9
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r0, r1, r2, r3, r4, r5)
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r14 = r13
            r2 = r18
            r10 = r26
            r12 = r31
            r13 = r33
        L_0x0460:
            r11 = r8
            goto L_0x0018
        L_0x0463:
            r12 = r24
            r9 = r25
            r15 = r29
            r14 = r30
            r13 = r33
            r11 = r34
            r3 = r9
            r1 = r12
            r7 = r17
            r2 = r18
            r6 = r19
            r10 = r26
            r12 = r31
            r9 = r35
            goto L_0x0018
        L_0x047f:
            r19 = r6
            r17 = r7
            r26 = r10
            r8 = r11
            r13 = r14
            r10 = r15
            r1 = -1
        L_0x0489:
            if (r7 == r1) goto L_0x0491
            long r1 = (long) r7
            r4 = r26
            r4.putInt(r13, r1, r6)
        L_0x0491:
            r1 = 0
            int r2 = r10.zzm
        L_0x0494:
            int r4 = r10.zzn
            if (r2 >= r4) goto L_0x04a7
            int[] r4 = r10.zzl
            r4 = r4[r2]
            com.google.android.gms.internal.measurement.zzhv<?, ?> r5 = r10.zzq
            java.lang.Object r1 = r10.zza(r13, r4, r1, r5)
            com.google.android.gms.internal.measurement.zzhy r1 = (com.google.android.gms.internal.measurement.zzhy) r1
            int r2 = r2 + 1
            goto L_0x0494
        L_0x04a7:
            if (r1 == 0) goto L_0x04ae
            com.google.android.gms.internal.measurement.zzhv<?, ?> r2 = r10.zzq
            r2.zzb(r13, r1)
        L_0x04ae:
            if (r8 != 0) goto L_0x04ba
            r1 = r33
            if (r0 != r1) goto L_0x04b5
            goto L_0x04c0
        L_0x04b5:
            com.google.android.gms.internal.measurement.zzfo r0 = com.google.android.gms.internal.measurement.zzfo.zzg()
            throw r0
        L_0x04ba:
            r1 = r33
            if (r0 > r1) goto L_0x04c1
            if (r3 != r8) goto L_0x04c1
        L_0x04c0:
            return r0
        L_0x04c1:
            com.google.android.gms.internal.measurement.zzfo r0 = com.google.android.gms.internal.measurement.zzfo.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzdt):int");
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void
     arg types: [T, long, boolean]
     candidates:
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzib.zza(byte[], long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void
     arg types: [T, long, float]
     candidates:
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.measurement.zzib.zza(byte[], long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void */
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
    public final void zza(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.measurement.zzdt r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.zzj
            if (r0 == 0) goto L_0x0260
            sun.misc.Unsafe r9 = com.google.android.gms.internal.measurement.zzgs.zzb
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
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r0, r12, r3, r11)
            int r3 = r11.zza
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
            int r0 = r15.zza(r7, r2)
            goto L_0x003e
        L_0x003a:
            int r0 = r15.zzg(r7)
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
            int[] r0 = r15.zzc
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
            int r6 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r8, r11)
            r19 = r1
            long r0 = r11.zzb
            long r21 = com.google.android.gms.internal.measurement.zzeg.zza(r0)
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
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r8, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.measurement.zzeg.zze(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x0095:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0162
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r8, r11)
            int r1 = r11.zza
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x00a4:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            int r0 = com.google.android.gms.internal.measurement.zzdq.zze(r12, r8, r11)
            java.lang.Object r1 = r11.zzc
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00b1:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            com.google.android.gms.internal.measurement.zzhd r0 = r15.zza(r4)
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r0, r12, r8, r13, r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00c8
            java.lang.Object r1 = r11.zzc
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00c8:
            java.lang.Object r5 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzff.zza(r1, r5)
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00d2:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00df
            int r0 = com.google.android.gms.internal.measurement.zzdq.zzc(r12, r8, r11)
            goto L_0x00e3
        L_0x00df:
            int r0 = com.google.android.gms.internal.measurement.zzdq.zzd(r12, r8, r11)
        L_0x00e3:
            java.lang.Object r1 = r11.zzc
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00e9:
            r2 = r1
            if (r6 != 0) goto L_0x01a6
            int r1 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r8, r11)
            long r5 = r11.zzb
            r19 = 0
            int r5 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r5 == 0) goto L_0x00f9
            goto L_0x00fb
        L_0x00f9:
            r0 = r16
        L_0x00fb:
            com.google.android.gms.internal.measurement.zzib.zza(r14, r2, r0)
            r0 = r1
            goto L_0x010d
        L_0x0100:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x01a6
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x010d:
            r2 = r4
            r1 = r7
            goto L_0x015f
        L_0x0111:
            r2 = r1
            if (r6 != r0) goto L_0x01a6
            long r5 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r8)
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
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r12, r8, r11)
            int r1 = r11.zza
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x012f:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0162
            int r6 = com.google.android.gms.internal.measurement.zzdq.zzb(r12, r8, r11)
            long r4 = r11.zzb
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
            float r0 = com.google.android.gms.internal.measurement.zzdq.zzd(r12, r8)
            com.google.android.gms.internal.measurement.zzib.zza(r14, r2, r0)
            int r0 = r8 + 4
            goto L_0x015d
        L_0x0150:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x0162
            double r0 = com.google.android.gms.internal.measurement.zzdq.zzc(r12, r8)
            com.google.android.gms.internal.measurement.zzib.zza(r14, r2, r0)
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
            com.google.android.gms.internal.measurement.zzfl r0 = (com.google.android.gms.internal.measurement.zzfl) r0
            boolean r3 = r0.zza()
            if (r3 != 0) goto L_0x018e
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0185
            r3 = 10
            goto L_0x0187
        L_0x0185:
            int r3 = r3 << 1
        L_0x0187:
            com.google.android.gms.internal.measurement.zzfl r0 = r0.zza(r3)
            r9.putObject(r14, r1, r0)
        L_0x018e:
            r5 = r0
            com.google.android.gms.internal.measurement.zzhd r0 = r15.zza(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r0, r1, r2, r3, r4, r5, r6)
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
            com.google.android.gms.internal.measurement.zzhy r4 = zze(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.android.gms.internal.measurement.zzdq.zza(r0, r1, r2, r3, r4, r5)
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
            com.google.android.gms.internal.measurement.zzfo r0 = com.google.android.gms.internal.measurement.zzfo.zzg()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzdt):void");
    }

    public final void zzc(Object obj) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzib.zzf(obj, zzd2);
            if (zzf2 != null) {
                zzib.zza(obj, zzd2, this.zzs.zzd(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(obj, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzd(obj);
        if (this.zzh) {
            this.zzr.zzc(obj);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzhv<UT, UB> zzhv) {
        zzfk zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzib.zzf(obj, (long) (zzd(i) & 1048575));
        if (zzf2 == null || (zzc2 = zzc(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzs.zza(zzf2), zzc2, ub, zzhv);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map map, zzfk zzfk, Object obj, zzhv zzhv) {
        zzgf<?, ?> zzf2 = this.zzs.zzf(zzb(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zzfk.zza(((Integer) entry.getValue()).intValue())) {
                if (obj == null) {
                    obj = zzhv.zza();
                }
                zzec zzc2 = zzdu.zzc(zzgg.zza(zzf2, entry.getKey(), entry.getValue()));
                try {
                    zzgg.zza(zzc2.zzb(), zzf2, entry.getKey(), entry.getValue());
                    zzhv.zza(obj, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    public final boolean zzd(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.zzm) {
                return !this.zzh || this.zzr.zza(t).zzf();
            }
            int i5 = this.zzl[i3];
            int i6 = this.zzc[i5];
            int zzd2 = zzd(i5);
            if (!this.zzj) {
                int i7 = this.zzc[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = zzb.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzd2) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzd2) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza(t, zzd2, zza(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzb2 = this.zzs.zzb(zzib.zzf(t, (long) (zzd2 & 1048575)));
                            if (!zzb2.isEmpty()) {
                                if (this.zzs.zzf(zzb(i5)).zzc.zza() == zzip.MESSAGE) {
                                    zzhd zzhd = null;
                                    Iterator<?> it = zzb2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzhd == null) {
                                            zzhd = zzgz.zza().zza((Class) next.getClass());
                                        }
                                        if (!zzhd.zzd(next)) {
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
                List list = (List) zzib.zzf(t, (long) (zzd2 & 1048575));
                if (!list.isEmpty()) {
                    zzhd zza2 = zza(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zza2.zzd(list.get(i10))) {
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
            } else if (zza(t, i5, i4, i) && !zza(t, zzd2, zza(i5))) {
                return false;
            }
            i3++;
        }
    }

    private static boolean zza(Object obj, int i, zzhd zzhd) {
        return zzhd.zzd(zzib.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzis zzis) throws IOException {
        if (obj instanceof String) {
            zzis.zza(i, (String) obj);
        } else {
            zzis.zza(i, (zzdu) obj);
        }
    }

    private final void zza(Object obj, int i, zzhe zzhe) throws IOException {
        if (zzf(i)) {
            zzib.zza(obj, (long) (i & 1048575), zzhe.zzm());
        } else if (this.zzi) {
            zzib.zza(obj, (long) (i & 1048575), zzhe.zzl());
        } else {
            zzib.zza(obj, (long) (i & 1048575), zzhe.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzib.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzib.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzib.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzib.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzib.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, int):boolean
     arg types: [T, int]
     candidates:
      com.google.android.gms.internal.measurement.zzgs.zza(int, int):int
      com.google.android.gms.internal.measurement.zzgs.zza(com.google.android.gms.internal.measurement.zzhv, java.lang.Object):int
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Class<?>, java.lang.String):java.lang.reflect.Field
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, long):java.util.List<?>
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzis):void
      com.google.android.gms.internal.measurement.zzhd.zza(java.lang.Object, java.lang.Object):boolean
      com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, int):boolean */
    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzj) {
            return zza((Object) t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzj) {
            int zzd2 = zzd(i);
            long j = (long) (zzd2 & 1048575);
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    return zzib.zze(t, j) != 0.0d;
                case 1:
                    return zzib.zzd(t, j) != 0.0f;
                case 2:
                    return zzib.zzb(t, j) != 0;
                case 3:
                    return zzib.zzb(t, j) != 0;
                case 4:
                    return zzib.zza(t, j) != 0;
                case 5:
                    return zzib.zzb(t, j) != 0;
                case 6:
                    return zzib.zza(t, j) != 0;
                case 7:
                    return zzib.zzc(t, j);
                case 8:
                    Object zzf2 = zzib.zzf(t, j);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzdu) {
                        return !zzdu.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzib.zzf(t, j) != null;
                case 10:
                    return !zzdu.zza.equals(zzib.zzf(t, j));
                case 11:
                    return zzib.zza(t, j) != 0;
                case 12:
                    return zzib.zza(t, j) != 0;
                case 13:
                    return zzib.zza(t, j) != 0;
                case 14:
                    return zzib.zzb(t, j) != 0;
                case 15:
                    return zzib.zza(t, j) != 0;
                case 16:
                    return zzib.zzb(t, j) != 0;
                case 17:
                    return zzib.zzf(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zze2 = zze(i);
            return (zzib.zza(t, (long) (zze2 & 1048575)) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void
     arg types: [T, long, int]
     candidates:
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.measurement.zzib.zza(byte[], long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void */
    private final void zzb(T t, int i) {
        if (!this.zzj) {
            int zze2 = zze(i);
            long j = (long) (zze2 & 1048575);
            zzib.zza((Object) t, j, zzib.zza(t, j) | (1 << (zze2 >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzib.zza(t, (long) (zze(i2) & 1048575)) == i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void
     arg types: [T, long, int]
     candidates:
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.measurement.zzib.zza(byte[], long, byte):void
      com.google.android.gms.internal.measurement.zzib.zza(java.lang.Object, long, int):void */
    private final void zzb(T t, int i, int i2) {
        zzib.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
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
