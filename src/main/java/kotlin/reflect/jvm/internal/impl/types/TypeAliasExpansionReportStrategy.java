package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;

/* compiled from: TypeAliasExpansionReportStrategy.kt */
public interface TypeAliasExpansionReportStrategy {
    void boundsViolationInSubstitution(KotlinType kotlinType, KotlinType kotlinType2, KotlinType kotlinType3, TypeParameterDescriptor typeParameterDescriptor);

    void conflictingProjection(TypeAliasDescriptor typeAliasDescriptor, TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType);

    void recursiveTypeAlias(TypeAliasDescriptor typeAliasDescriptor);

    void repeatedAnnotation(AnnotationDescriptor annotationDescriptor);

    /* compiled from: TypeAliasExpansionReportStrategy.kt */
    public static final class DO_NOTHING implements TypeAliasExpansionReportStrategy {
        public static final DO_NOTHING INSTANCE = new DO_NOTHING();

        public void boundsViolationInSubstitution(KotlinType kotlinType, KotlinType kotlinType2, KotlinType kotlinType3, TypeParameterDescriptor typeParameterDescriptor) {
            Intrinsics.checkParameterIsNotNull(kotlinType, "bound");
            Intrinsics.checkParameterIsNotNull(kotlinType2, "unsubstitutedArgument");
            Intrinsics.checkParameterIsNotNull(kotlinType3, "argument");
            Intrinsics.checkParameterIsNotNull(typeParameterDescriptor, "typeParameter");
        }

        public void conflictingProjection(TypeAliasDescriptor typeAliasDescriptor, TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType) {
            Intrinsics.checkParameterIsNotNull(typeAliasDescriptor, "typeAlias");
            Intrinsics.checkParameterIsNotNull(kotlinType, "substitutedArgument");
        }

        public void recursiveTypeAlias(TypeAliasDescriptor typeAliasDescriptor) {
            Intrinsics.checkParameterIsNotNull(typeAliasDescriptor, "typeAlias");
        }

        public void repeatedAnnotation(AnnotationDescriptor annotationDescriptor) {
            Intrinsics.checkParameterIsNotNull(annotationDescriptor, "annotation");
        }

        private DO_NOTHING() {
        }
    }
}
