package com.google.android.gms.internal.firebase_ml;

import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzrg {
    private static final GmsLogger zzbbo = new GmsLogger("StreamingFormatChecker", "");
    private final LinkedList<Long> zzblf = new LinkedList<>();
    private long zzblg = -1;

    public final void zzc(zzrl zzrl) {
        if (zzrl.zzbkx.getBitmap() != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzblf.add(Long.valueOf(elapsedRealtime));
            if (this.zzblf.size() > 5) {
                this.zzblf.removeFirst();
            }
            if (this.zzblf.size() == 5 && elapsedRealtime - this.zzblf.peekFirst().longValue() < 5000) {
                long j = this.zzblg;
                if (j == -1 || elapsedRealtime - j >= TimeUnit.SECONDS.toMillis(5)) {
                    this.zzblg = elapsedRealtime;
                    zzbbo.w("StreamingFormatChecker", "ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit.");
                }
            }
        }
    }
}
