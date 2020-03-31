package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdl;
import com.google.android.gms.internal.measurement.zzdn;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
public abstract class zzdn<MessageType extends zzdl<MessageType, BuilderType>, BuilderType extends zzdn<MessageType, BuilderType>> implements zzgn {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(zzdl zzdl);

    public abstract BuilderType zza(zzeg zzeg, zzeq zzeq) throws IOException;

    /* renamed from: zzp */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2) throws zzfo {
        try {
            zzeg zza = zzeg.zza(bArr, 0, i2, false);
            zza(zza, zzeq.zza());
            zza.zza(0);
            return this;
        } catch (zzfo e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public BuilderType zza(byte[] bArr, int i, int i2, zzeq zzeq) throws zzfo {
        try {
            zzeg zza = zzeg.zza(bArr, 0, i2, false);
            zza(zza, zzeq);
            zza.zza(0);
            return this;
        } catch (zzfo e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    private final String zza(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + String.valueOf(str).length());
        sb.append("Reading ");
        sb.append(name);
        sb.append(" from a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    public final /* synthetic */ zzgn zza(zzgo zzgo) {
        if (zzbt().getClass().isInstance(zzgo)) {
            return zza((zzdl) zzgo);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public final /* synthetic */ zzgn zza(byte[] bArr, zzeq zzeq) throws zzfo {
        return zza(bArr, 0, bArr.length, zzeq);
    }

    public final /* synthetic */ zzgn zza(byte[] bArr) throws zzfo {
        return zza(bArr, 0, bArr.length);
    }
}
