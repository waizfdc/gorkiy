package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$methods$1 extends Lambda implements Function1<Method, Boolean> {
    final /* synthetic */ ReflectJavaClass this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReflectJavaClass$methods$1(ReflectJavaClass reflectJavaClass) {
        super(1);
        this.this$0 = reflectJavaClass;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((Method) obj));
    }

    public final boolean invoke(Method method) {
        Intrinsics.checkExpressionValueIsNotNull(method, FirebaseAnalytics.Param.METHOD);
        return !method.isSynthetic() && (!this.this$0.isEnum() || !this.this$0.isEnumValuesOrValueOf(method));
    }
}
