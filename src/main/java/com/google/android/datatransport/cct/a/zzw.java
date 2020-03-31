package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzw implements ObjectEncoder<zzk> {
    public void encode(Object obj, Object obj2) throws EncodingException, IOException {
        zzk zzk = (zzk) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add("requestTimeMs", zzk.zzf()).add("requestUptimeMs", zzk.zzg());
        if (zzk.zzb() != null) {
            objectEncoderContext.add("clientInfo", zzk.zzb());
        }
        if (zzk.zze() != null) {
            objectEncoderContext.add("logSourceName", zzk.zze());
        } else if (zzk.zzd() != Integer.MIN_VALUE) {
            objectEncoderContext.add("logSource", zzk.zzd());
        } else {
            throw new EncodingException("Log request must have either LogSourceName or LogSource");
        }
        if (!zzk.zzc().isEmpty()) {
            objectEncoderContext.add("logEvent", zzk.zzc());
        }
    }
}
