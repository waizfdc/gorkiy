package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: KotlinTypeFactory.kt */
final class AnnotatedSimpleType extends DelegatingSimpleTypeImpl {
    private final Annotations annotations;

    public Annotations getAnnotations() {
        return this.annotations;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnnotatedSimpleType(SimpleType simpleType, Annotations annotations2) {
        super(simpleType);
        Intrinsics.checkParameterIsNotNull(simpleType, "delegate");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        this.annotations = annotations2;
    }

    public AnnotatedSimpleType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkParameterIsNotNull(simpleType, "delegate");
        return new AnnotatedSimpleType(simpleType, getAnnotations());
    }
}
