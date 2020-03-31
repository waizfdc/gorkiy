package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.zzug;
import com.google.android.gms.internal.firebase_ml.zzuj;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public abstract class zzuj<MessageType extends zzug<MessageType, BuilderType>, BuilderType extends zzuj<MessageType, BuilderType>> implements zzxj {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(zzug zzug);

    /* renamed from: zzsn */
    public abstract BuilderType clone();

    public final /* synthetic */ zzxj zza(zzxg zzxg) {
        if (zzty().getClass().isInstance(zzxg)) {
            return zza((zzug) zzxg);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
