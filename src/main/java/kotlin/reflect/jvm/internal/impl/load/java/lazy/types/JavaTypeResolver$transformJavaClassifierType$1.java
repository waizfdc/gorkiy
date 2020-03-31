package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaTypeResolver.kt */
final class JavaTypeResolver$transformJavaClassifierType$1 extends Lambda implements Function0<SimpleType> {
    final /* synthetic */ JavaClassifierType $javaType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaTypeResolver$transformJavaClassifierType$1(JavaClassifierType javaClassifierType) {
        super(0);
        this.$javaType = javaClassifierType;
    }

    public final SimpleType invoke() {
        SimpleType createErrorType = ErrorUtils.createErrorType("Unresolved java class " + this.$javaType.getPresentableText());
        Intrinsics.checkExpressionValueIsNotNull(createErrorType, "ErrorUtils.createErrorTy…vaType.presentableText}\")");
        return createErrorType;
    }
}
