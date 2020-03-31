package com.google.android.gms.measurement.module;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.internal.zzgo;
import com.google.android.gms.measurement.internal.zzhj;
import com.google.android.gms.measurement.internal.zzhm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
public class Analytics {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    public static final String FIAM_ORIGIN = "fiam";
    private static volatile Analytics zza;
    private final zzgo zzb;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
    public static final class Event extends zzhj {
        public static final String AD_REWARD = "_ar";
        public static final String APP_EXCEPTION = "_ae";

        private Event() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
    public static final class Param extends zzhm {
        public static final String FATAL = "fatal";
        public static final String TIMESTAMP = "timestamp";
        public static final String TYPE = "type";

        private Param() {
        }
    }

    public static Analytics getInstance(Context context) {
        if (zza == null) {
            synchronized (Analytics.class) {
                if (zza == null) {
                    zza = new Analytics(zzgo.zza(context, (zzv) null));
                }
            }
        }
        return zza;
    }

    private Analytics(zzgo zzgo) {
        Preconditions.checkNotNull(zzgo);
        this.zzb = zzgo;
    }
}
