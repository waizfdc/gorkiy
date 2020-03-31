package com.google.android.gms.internal.firebase_ml;

import android.os.Build;
import com.google.android.gms.internal.firebase_ml.zzng;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzrf {
    public static int zzbu(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        StringBuilder sb = new StringBuilder(34);
        sb.append("Invalid landmark type: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int zzbv(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        StringBuilder sb = new StringBuilder(30);
        sb.append("Invalid mode type: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int zzbw(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        StringBuilder sb = new StringBuilder(40);
        sb.append("Invalid classification type: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static zzng.zzac zzb(zzrl zzrl) {
        int i;
        zzng.zzac.zza zza;
        if (zzrl.zzbkx.getBitmap() != null) {
            zza = zzng.zzac.zza.BITMAP;
            if (Build.VERSION.SDK_INT >= 19) {
                i = zzrl.zzbkx.getBitmap().getAllocationByteCount();
            } else {
                i = zzrl.zzbkx.getBitmap().getByteCount();
            }
        } else {
            int format = zzrl.zzbkx.getMetadata().getFormat();
            if (format == 16) {
                zza = zzng.zzac.zza.NV16;
            } else if (format == 17) {
                zza = zzng.zzac.zza.NV21;
            } else if (format != 842094169) {
                zza = zzng.zzac.zza.UNKNOWN_FORMAT;
            } else {
                zza = zzng.zzac.zza.YV12;
            }
            i = zzrl.zzbkx.getGrayscaleImageData().capacity();
        }
        return (zzng.zzac) ((zzvx) zzng.zzac.zzlp().zzb(zza).zzbd(i).zztx());
    }
}
