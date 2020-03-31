package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: typeEnhancement.kt */
final class SimpleResult extends Result {
    private final SimpleType type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleResult(SimpleType simpleType, int i, boolean z) {
        super(simpleType, i, z);
        Intrinsics.checkParameterIsNotNull(simpleType, "type");
        this.type = simpleType;
    }

    public SimpleType getType() {
        return this.type;
    }
}
