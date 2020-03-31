package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzu implements ObjectEncoder<zzi> {
    public void encode(Object obj, Object obj2) throws EncodingException, IOException {
        zzi zzi = (zzi) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add("eventTimeMs", zzi.zza()).add("eventUptimeMs", zzi.zzb()).add("timezoneOffsetSeconds", zzi.zzc());
        if (zzi.zzf() != null) {
            objectEncoderContext.add("sourceExtension", zzi.zzf());
        }
        if (zzi.zzg() != null) {
            objectEncoderContext.add("sourceExtensionJsonProto3", zzi.zzg());
        }
        if (zzi.zzd() != Integer.MIN_VALUE) {
            objectEncoderContext.add("eventCode", zzi.zzd());
        }
        if (zzi.zze() != null) {
            objectEncoderContext.add("networkConnectionInfo", zzi.zze());
        }
    }
}
