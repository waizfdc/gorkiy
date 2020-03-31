package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: KotlinTypeFactory.kt */
final class SimpleTypeImpl extends SimpleType {
    private final List<TypeProjection> arguments;
    private final TypeConstructor constructor;
    private final boolean isMarkedNullable;
    private final MemberScope memberScope;
    private final Function1<KotlinTypeRefiner, SimpleType> refinedTypeFactory;

    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection>, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection>] */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, ? extends kotlin.reflect.jvm.internal.impl.types.SimpleType>, java.lang.Object, kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.SimpleType>] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SimpleTypeImpl(kotlin.reflect.jvm.internal.impl.types.TypeConstructor r2, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> r3, boolean r4, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r5, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, ? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> r6) {
        /*
            r1 = this;
            java.lang.String r0 = "constructor"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "arguments"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "memberScope"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "refinedTypeFactory"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            r1.<init>()
            r1.constructor = r2
            r1.arguments = r3
            r1.isMarkedNullable = r4
            r1.memberScope = r5
            r1.refinedTypeFactory = r6
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r2 = r1.getMemberScope()
            boolean r2 = r2 instanceof kotlin.reflect.jvm.internal.impl.types.ErrorUtils.ErrorScope
            if (r2 != 0) goto L_0x002a
            return
        L_0x002a:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "SimpleTypeImpl should not be created for error type: "
            r3.append(r4)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r4 = r1.getMemberScope()
            r3.append(r4)
            r4 = 10
            r3.append(r4)
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r1.getConstructor()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.SimpleTypeImpl.<init>(kotlin.reflect.jvm.internal.impl.types.TypeConstructor, java.util.List, boolean, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.jvm.functions.Function1):void");
    }

    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    public SimpleType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkParameterIsNotNull(annotations, "newAnnotations");
        if (annotations.isEmpty()) {
            return this;
        }
        return new AnnotatedSimpleType(this, annotations);
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        if (z == isMarkedNullable()) {
            return this;
        }
        if (z) {
            return new NullableSimpleType(this);
        }
        return new NotNullSimpleType(this);
    }

    public SimpleType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeRefiner, "kotlinTypeRefiner");
        SimpleType invoke = this.refinedTypeFactory.invoke(kotlinTypeRefiner);
        return invoke != null ? super : this;
    }
}
