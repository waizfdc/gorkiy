package com.google.android.gms.internal.firebase_ml;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzvy {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName(HttpRequest.CHARSET_UTF8);
    public static final byte[] zzcdy;
    private static final ByteBuffer zzcdz;
    private static final zzvc zzcea;

    public static int zzaf(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zzaz(boolean z) {
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

    public static boolean zzi(byte[] bArr) {
        return zzzb.zzi(bArr);
    }

    public static String zzj(byte[] bArr) {
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

    static boolean zzf(zzxg zzxg) {
        if (!(zzxg instanceof zzui)) {
            return false;
        }
        zzui zzui = (zzui) zzxg;
        return false;
    }

    static Object zzc(Object obj, Object obj2) {
        return ((zzxg) obj).zzue().zza((zzxg) obj2).zztw();
    }

    static {
        byte[] bArr = new byte[0];
        zzcdy = bArr;
        zzcdz = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzcdy;
        zzcea = zzvc.zza(bArr2, 0, bArr2.length, false);
    }
}
