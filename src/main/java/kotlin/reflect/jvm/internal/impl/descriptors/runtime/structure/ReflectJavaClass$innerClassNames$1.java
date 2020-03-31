package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$innerClassNames$1 extends Lambda implements Function1<Class<?>, Boolean> {
    public static final ReflectJavaClass$innerClassNames$1 INSTANCE = new ReflectJavaClass$innerClassNames$1();

    ReflectJavaClass$innerClassNames$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((Class<?>) ((Class) obj)));
    }

    public final boolean invoke(Class<?> cls) {
        Intrinsics.checkExpressionValueIsNotNull(cls, "it");
        String simpleName = cls.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "it.simpleName");
        return simpleName.length() == 0;
    }
}
