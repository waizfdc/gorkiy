package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
final class DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1 implements KotlinTypeChecker.TypeConstructorEquality {
    final /* synthetic */ CallableDescriptor $a;
    final /* synthetic */ boolean $allowCopiesFromTheSameDeclaration;
    final /* synthetic */ CallableDescriptor $b;

    DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1(boolean z, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        this.$allowCopiesFromTheSameDeclaration = z;
        this.$a = callableDescriptor;
        this.$b = callableDescriptor2;
    }

    /* renamed from: invoke */
    public final boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
        Intrinsics.checkParameterIsNotNull(typeConstructor, "c1");
        Intrinsics.checkParameterIsNotNull(typeConstructor2, "c2");
        if (Intrinsics.areEqual(typeConstructor, typeConstructor2)) {
            return true;
        }
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        ClassifierDescriptor declarationDescriptor2 = typeConstructor2.getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof TypeParameterDescriptor) || !(declarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return false;
        }
        return DescriptorEquivalenceForOverrides.INSTANCE.areTypeParametersEquivalent((TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, this.$allowCopiesFromTheSameDeclaration, new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>(this) {
            /* class kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1.AnonymousClass1 */
            final /* synthetic */ DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(invoke((DeclarationDescriptor) obj, (DeclarationDescriptor) obj2));
            }

            public final boolean invoke(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
                return Intrinsics.areEqual(declarationDescriptor, this.this$0.$a) && Intrinsics.areEqual(declarationDescriptor2, this.this$0.$b);
            }
        });
    }
}
