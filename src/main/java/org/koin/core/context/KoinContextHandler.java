package org.koin.core.context;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lorg/koin/core/context/KoinContextHandler;", "", "()V", "_context", "Lorg/koin/core/context/KoinContext;", "get", "Lorg/koin/core/Koin;", "getContext", "getOrNull", "register", "", "koinContext", "start", "koinApplication", "Lorg/koin/core/KoinApplication;", "stop", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: KoinContextHandler.kt */
public final class KoinContextHandler {
    public static final KoinContextHandler INSTANCE = new KoinContextHandler();
    private static KoinContext _context;

    private KoinContextHandler() {
    }

    private final KoinContext getContext() {
        KoinContext koinContext = _context;
        if (koinContext != null) {
            return koinContext;
        }
        throw new IllegalStateException("No Koin Context configured. Please use startKoin or koinApplication DSL. ".toString());
    }

    public final Koin get() {
        return getContext().get();
    }

    public final Koin getOrNull() {
        KoinContext koinContext = _context;
        if (koinContext != null) {
            return koinContext.getOrNull();
        }
        return null;
    }

    public final void register(KoinContext koinContext) {
        Intrinsics.checkParameterIsNotNull(koinContext, "koinContext");
        synchronized (this) {
            if (_context == null) {
                _context = koinContext;
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("A KoinContext is already started".toString());
            }
        }
    }

    public final void start(KoinApplication koinApplication) {
        Intrinsics.checkParameterIsNotNull(koinApplication, "koinApplication");
        getContext().setup(koinApplication);
    }

    public final void stop() {
        KoinContext koinContext = _context;
        if (koinContext != null) {
            koinContext.stop();
        }
        _context = null;
    }
}
