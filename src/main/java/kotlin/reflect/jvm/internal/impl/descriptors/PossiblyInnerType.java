package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: typeParameterUtils.kt */
public final class PossiblyInnerType {
    private final List<TypeProjection> arguments;
    private final ClassifierDescriptorWithTypeParameters classifierDescriptor;
    private final PossiblyInnerType outerType;

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection>, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PossiblyInnerType(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters r2, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> r3, kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType r4) {
        /*
            r1 = this;
            java.lang.String r0 = "classifierDescriptor"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "arguments"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            r1.<init>()
            r1.classifierDescriptor = r2
            r1.arguments = r3
            r1.outerType = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType.<init>(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters, java.util.List, kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType):void");
    }

    public final ClassifierDescriptorWithTypeParameters getClassifierDescriptor() {
        return this.classifierDescriptor;
    }

    public final List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public final PossiblyInnerType getOuterType() {
        return this.outerType;
    }
}
