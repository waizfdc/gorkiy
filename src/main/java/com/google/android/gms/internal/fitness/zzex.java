package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzex;
import com.google.android.gms.internal.fitness.zzez;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public abstract class zzex<MessageType extends zzex<MessageType, BuilderType>, BuilderType extends zzez<MessageType, BuilderType>> implements zzho {
    protected int zzrb = 0;

    public final zzff zzag() {
        try {
            zzfn zzj = zzff.zzj(zzbk());
            zzb(zzj.zzau());
            return zzj.zzat();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzah() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzg(int i) {
        throw new UnsupportedOperationException();
    }
}
