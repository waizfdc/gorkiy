package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ErrorType.kt */
public final class UnresolvedType extends ErrorType {
    private final String presentableName;

    public UnresolvedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public final String getPresentableName() {
        return this.presentableName;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnresolvedType(String str, TypeConstructor typeConstructor, MemberScope memberScope, List<? extends TypeProjection> list, boolean z) {
        super(typeConstructor, memberScope, list, z);
        Intrinsics.checkParameterIsNotNull(str, "presentableName");
        Intrinsics.checkParameterIsNotNull(typeConstructor, "constructor");
        Intrinsics.checkParameterIsNotNull(memberScope, "memberScope");
        Intrinsics.checkParameterIsNotNull(list, "arguments");
        this.presentableName = str;
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        return new UnresolvedType(this.presentableName, getConstructor(), getMemberScope(), getArguments(), z);
    }
}
