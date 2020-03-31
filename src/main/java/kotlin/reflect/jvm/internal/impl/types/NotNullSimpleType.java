package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinTypeFactory.kt */
final class NotNullSimpleType extends DelegatingSimpleTypeImpl {
    public boolean isMarkedNullable() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotNullSimpleType(SimpleType simpleType) {
        super(simpleType);
        Intrinsics.checkParameterIsNotNull(simpleType, "delegate");
    }

    public NotNullSimpleType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkParameterIsNotNull(simpleType, "delegate");
        return new NotNullSimpleType(simpleType);
    }
}
