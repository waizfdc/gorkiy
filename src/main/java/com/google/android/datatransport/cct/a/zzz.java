package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzz implements ObjectEncoder<zzn> {
    public void encode(Object obj, Object obj2) throws EncodingException, IOException {
        zzn zzn = (zzn) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        if (zzn.zzb() != null) {
            objectEncoderContext.add("mobileSubtype", zzn.zzb().name());
        }
        if (zzn.zzc() != null) {
            objectEncoderContext.add("networkType", zzn.zzc().name());
        }
    }
}
