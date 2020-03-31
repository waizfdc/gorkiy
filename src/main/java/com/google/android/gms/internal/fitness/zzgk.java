package com.google.android.gms.internal.fitness;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzgk {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName(HttpRequest.CHARSET_UTF8);
    public static final byte[] zzvz;
    private static final ByteBuffer zzwa;
    private static final zzfr zzwb;

    public static int zzc(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzj(long j) {
        return (int) (j ^ (j >>> 32));
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

    public static boolean zzc(byte[] bArr) {
        return zzjc.zzc(bArr);
    }

    public static String zzd(byte[] bArr) {
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

    static boolean zzf(zzho zzho) {
        if (!(zzho instanceof zzey)) {
            return false;
        }
        zzey zzey = (zzey) zzho;
        return false;
    }

    static Object zzb(Object obj, Object obj2) {
        return ((zzho) obj).zzbl().zza((zzho) obj2).zzbq();
    }

    static {
        byte[] bArr = new byte[0];
        zzvz = bArr;
        zzwa = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzvz;
        zzwb = zzfr.zza(bArr2, 0, bArr2.length, false);
    }
}
