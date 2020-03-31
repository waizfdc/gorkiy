package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzex;
import com.google.android.gms.internal.fitness.zzez;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public abstract class zzez<MessageType extends zzex<MessageType, BuilderType>, BuilderType extends zzez<MessageType, BuilderType>> implements zzhn {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(zzex zzex);

    /* renamed from: zzaj */
    public abstract BuilderType clone();

    public final /* synthetic */ zzhn zza(zzho zzho) {
        if (zzbm().getClass().isInstance(zzho)) {
            return zza((zzex) zzho);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
