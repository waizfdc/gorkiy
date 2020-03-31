package org.koin.core.context;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.error.KoinAppAlreadyStartedException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lorg/koin/core/context/GlobalContext;", "Lorg/koin/core/context/KoinContext;", "()V", "_koin", "Lorg/koin/core/Koin;", "get", "getOrNull", "setup", "", "koinApplication", "Lorg/koin/core/KoinApplication;", "stop", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: GlobalContext.kt */
public final class GlobalContext implements KoinContext {
    private Koin _koin;

    public Koin get() {
        Koin koin = this._koin;
        if (koin != null) {
            return koin;
        }
        throw new IllegalStateException("KoinApplication has not been started".toString());
    }

    public Koin getOrNull() {
        return this._koin;
    }

    public void setup(KoinApplication koinApplication) {
        Intrinsics.checkParameterIsNotNull(koinApplication, "koinApplication");
        synchronized (this) {
            if (this._koin == null) {
                this._koin = koinApplication.getKoin();
                Unit unit = Unit.INSTANCE;
            } else {
                throw new KoinAppAlreadyStartedException("A Koin Application has already been started");
            }
        }
    }

    public void stop() {
        synchronized (this) {
            Koin koin = this._koin;
            if (koin != null) {
                koin.close();
            }
            this._koin = null;
            Unit unit = Unit.INSTANCE;
        }
    }
}
