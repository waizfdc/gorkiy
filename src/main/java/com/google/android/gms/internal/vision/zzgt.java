package com.google.android.gms.internal.vision;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public final class zzgt {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName(HttpRequest.CHARSET_UTF8);
    public static final byte[] zzxc;
    private static final ByteBuffer zzxd;
    private static final zzft zzxe;

    public static int zzab(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zzm(boolean z) {
        return z ? 1231 : 1237;
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzg(byte[] bArr) {
        return zzjs.zzg(bArr);
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static boolean zzf(zzic zzic) {
        if (!(zzic instanceof zzev)) {
            return false;
        }
        zzev zzev = (zzev) zzic;
        return false;
    }

    static Object zzb(Object obj, Object obj2) {
        return ((zzic) obj).zzgi().zza((zzic) obj2).zzgb();
    }

    static {
        byte[] bArr = new byte[0];
        zzxc = bArr;
        zzxd = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzxc;
        zzxe = zzft.zza(bArr2, 0, bArr2.length, false);
    }
}
