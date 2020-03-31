package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzp implements ObjectEncoder<zze> {
    public void encode(Object obj, Object obj2) throws EncodingException, IOException {
        ((ObjectEncoderContext) obj2).add("logRequest", ((zze) obj).zza());
    }
}
