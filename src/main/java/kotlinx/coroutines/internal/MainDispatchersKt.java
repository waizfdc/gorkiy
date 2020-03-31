package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0007\u001a\u001a\u0010\u0005\u001a\u00020\u0004*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "isMissing", "", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: MainDispatchers.kt */
public final class MainDispatchersKt {
    private static final String FAST_SERVICE_LOADER_PROPERTY_NAME = "kotlinx.coroutines.fast.service.loader";

    public static final MainCoroutineDispatcher tryCreateDispatcher(MainDispatcherFactory mainDispatcherFactory, List<? extends MainDispatcherFactory> list) {
        Intrinsics.checkParameterIsNotNull(mainDispatcherFactory, "$this$tryCreateDispatcher");
        Intrinsics.checkParameterIsNotNull(list, "factories");
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th) {
            return new MissingMainCoroutineDispatcher(th, mainDispatcherFactory.hintOnError());
        }
    }

    public static final boolean isMissing(MainCoroutineDispatcher mainCoroutineDispatcher) {
        Intrinsics.checkParameterIsNotNull(mainCoroutineDispatcher, "$this$isMissing");
        return mainCoroutineDispatcher instanceof MissingMainCoroutineDispatcher;
    }
}
