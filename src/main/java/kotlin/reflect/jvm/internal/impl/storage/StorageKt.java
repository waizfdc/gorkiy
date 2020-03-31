package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: storage.kt */
public final class StorageKt {
    public static final <T> T getValue(NotNullLazyValue notNullLazyValue, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(notNullLazyValue, "$this$getValue");
        Intrinsics.checkParameterIsNotNull(kProperty, "p");
        return notNullLazyValue.invoke();
    }

    public static final <T> T getValue(NullableLazyValue nullableLazyValue, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(nullableLazyValue, "$this$getValue");
        Intrinsics.checkParameterIsNotNull(kProperty, "p");
        return nullableLazyValue.invoke();
    }
}
