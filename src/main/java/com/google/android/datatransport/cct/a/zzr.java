package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzr implements ObjectEncoder<zzg> {
    public void encode(Object obj, Object obj2) throws EncodingException, IOException {
        zzg zzg = (zzg) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        if (zzg.zzc() != null) {
            objectEncoderContext.add("clientType", zzg.zzc().name());
        }
        if (zzg.zzb() != null) {
            objectEncoderContext.add("androidClientInfo", zzg.zzb());
        }
    }
}
