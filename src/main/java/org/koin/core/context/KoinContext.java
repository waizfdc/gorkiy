package org.koin.core.context;

import kotlin.Metadata;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lorg/koin/core/context/KoinContext;", "", "get", "Lorg/koin/core/Koin;", "getOrNull", "setup", "", "koinApplication", "Lorg/koin/core/KoinApplication;", "stop", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: KoinContext.kt */
public interface KoinContext {
    Koin get();

    Koin getOrNull();

    void setup(KoinApplication koinApplication);

    void stop();
}
