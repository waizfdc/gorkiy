package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: mappingUtil.kt */
public final class MappingUtilKt {
    public static final TypeConstructorSubstitution createMappedTypeParametersSubstitution(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "from");
        Intrinsics.checkParameterIsNotNull(classDescriptor2, "to");
        boolean z = classDescriptor.getDeclaredTypeParameters().size() == classDescriptor2.getDeclaredTypeParameters().size();
        if (!_Assertions.ENABLED || z) {
            TypeConstructorSubstitution.Companion companion = TypeConstructorSubstitution.Companion;
            List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
            Intrinsics.checkExpressionValueIsNotNull(declaredTypeParameters, "from.declaredTypeParameters");
            Iterable<TypeParameterDescriptor> iterable = declaredTypeParameters;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (TypeParameterDescriptor typeConstructor : iterable) {
                arrayList.add(typeConstructor.getTypeConstructor());
            }
            Iterable iterable2 = (List) arrayList;
            List<TypeParameterDescriptor> declaredTypeParameters2 = classDescriptor2.getDeclaredTypeParameters();
            Intrinsics.checkExpressionValueIsNotNull(declaredTypeParameters2, "to.declaredTypeParameters");
            Iterable<TypeParameterDescriptor> iterable3 = declaredTypeParameters2;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : iterable3) {
                Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor, "it");
                SimpleType defaultType = typeParameterDescriptor.getDefaultType();
                Intrinsics.checkExpressionValueIsNotNull(defaultType, "it.defaultType");
                arrayList2.add(TypeUtilsKt.asTypeProjection(defaultType));
            }
            return TypeConstructorSubstitution.Companion.createByConstructorsMap$default(companion, MapsKt.toMap(CollectionsKt.zip(iterable2, (List) arrayList2)), false, 2, null);
        }
        throw new AssertionError(classDescriptor + " and " + classDescriptor2 + " should have same number of type parameters, " + "but " + classDescriptor.getDeclaredTypeParameters().size() + " / " + classDescriptor2.getDeclaredTypeParameters().size() + " found");
    }
}
