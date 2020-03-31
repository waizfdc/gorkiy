package com.google.android.gms.internal.firebase_ml;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzhg extends zzgi {
    private Object data;

    public zzhg(Object obj) {
        super(zzhj.MEDIA_TYPE);
        this.data = zzmf.checkNotNull(obj);
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, zzfo()));
        boolean z = true;
        for (Map.Entry next : zzit.zzf(this.data).entrySet()) {
            Object value = next.getValue();
            if (value != null) {
                String zzaq = zzjs.zzaq((String) next.getKey());
                Class<?> cls = value.getClass();
                if ((value instanceof Iterable) || cls.isArray()) {
                    for (Object zza : zzjo.zzi(value)) {
                        z = zza(z, bufferedWriter, zzaq, zza);
                    }
                } else {
                    z = zza(z, bufferedWriter, zzaq, value);
                }
            }
        }
        bufferedWriter.flush();
    }

    private static boolean zza(boolean z, Writer writer, String str, Object obj) throws IOException {
        if (obj != null && !zzit.isNull(obj)) {
            if (z) {
                z = false;
            } else {
                writer.write("&");
            }
            writer.write(str);
            String zzaq = zzjs.zzaq(obj instanceof Enum ? zziz.zza((Enum) obj).getName() : obj.toString());
            if (zzaq.length() != 0) {
                writer.write("=");
                writer.write(zzaq);
            }
        }
        return z;
    }
}
