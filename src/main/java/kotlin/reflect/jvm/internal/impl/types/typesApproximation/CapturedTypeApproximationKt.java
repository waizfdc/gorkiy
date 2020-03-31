package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: CapturedTypeApproximation.kt */
public final class CapturedTypeApproximationKt {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Variance.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Variance.INVARIANT.ordinal()] = 1;
            $EnumSwitchMapping$0[Variance.IN_VARIANCE.ordinal()] = 2;
            $EnumSwitchMapping$0[Variance.OUT_VARIANCE.ordinal()] = 3;
            int[] iArr2 = new int[Variance.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Variance.IN_VARIANCE.ordinal()] = 1;
            $EnumSwitchMapping$1[Variance.OUT_VARIANCE.ordinal()] = 2;
        }
    }

    private static final TypeProjection toTypeProjection(TypeArgument typeArgument) {
        boolean isConsistent = typeArgument.isConsistent();
        if (!_Assertions.ENABLED || isConsistent) {
            CapturedTypeApproximationKt$toTypeProjection$2 capturedTypeApproximationKt$toTypeProjection$2 = new CapturedTypeApproximationKt$toTypeProjection$2(typeArgument);
            if (Intrinsics.areEqual(typeArgument.getInProjection(), typeArgument.getOutProjection())) {
                return new TypeProjectionImpl(typeArgument.getInProjection());
            }
            if (KotlinBuiltIns.isNothing(typeArgument.getInProjection()) && typeArgument.getTypeParameter().getVariance() != Variance.IN_VARIANCE) {
                return new TypeProjectionImpl(capturedTypeApproximationKt$toTypeProjection$2.invoke(Variance.OUT_VARIANCE), typeArgument.getOutProjection());
            }
            if (KotlinBuiltIns.isNullableAny(typeArgument.getOutProjection())) {
                return new TypeProjectionImpl(capturedTypeApproximationKt$toTypeProjection$2.invoke(Variance.IN_VARIANCE), typeArgument.getInProjection());
            }
            return new TypeProjectionImpl(capturedTypeApproximationKt$toTypeProjection$2.invoke(Variance.OUT_VARIANCE), typeArgument.getOutProjection());
        }
        DescriptorRenderer withOptions = DescriptorRenderer.Companion.withOptions(CapturedTypeApproximationKt$toTypeProjection$1$descriptorRenderer$1.INSTANCE);
        throw new AssertionError("Only consistent enhanced type projection can be converted to type projection, but " + '[' + withOptions.render(typeArgument.getTypeParameter()) + ": <" + withOptions.renderType(typeArgument.getInProjection()) + ", " + withOptions.renderType(typeArgument.getOutProjection()) + ">]" + " was found");
    }

    private static final TypeArgument toTypeArgument(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        int i = WhenMappings.$EnumSwitchMapping$0[TypeSubstitutor.combine(typeParameterDescriptor.getVariance(), typeProjection).ordinal()];
        if (i == 1) {
            KotlinType type = typeProjection.getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "type");
            KotlinType type2 = typeProjection.getType();
            Intrinsics.checkExpressionValueIsNotNull(type2, "type");
            return new TypeArgument(typeParameterDescriptor, type, type2);
        } else if (i == 2) {
            KotlinType type3 = typeProjection.getType();
            Intrinsics.checkExpressionValueIsNotNull(type3, "type");
            SimpleType nullableAnyType = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNullableAnyType();
            Intrinsics.checkExpressionValueIsNotNull(nullableAnyType, "typeParameter.builtIns.nullableAnyType");
            return new TypeArgument(typeParameterDescriptor, type3, nullableAnyType);
        } else if (i == 3) {
            SimpleType nothingType = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNothingType();
            Intrinsics.checkExpressionValueIsNotNull(nothingType, "typeParameter.builtIns.nothingType");
            KotlinType type4 = typeProjection.getType();
            Intrinsics.checkExpressionValueIsNotNull(type4, "type");
            return new TypeArgument(typeParameterDescriptor, nothingType, type4);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final TypeProjection approximateCapturedTypesIfNecessary(TypeProjection typeProjection, boolean z) {
        if (typeProjection == null) {
            return null;
        }
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType type = typeProjection.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "typeProjection.type");
        if (!TypeUtils.contains(type, CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1.INSTANCE)) {
            return typeProjection;
        }
        Variance projectionKind = typeProjection.getProjectionKind();
        Intrinsics.checkExpressionValueIsNotNull(projectionKind, "typeProjection.projectionKind");
        if (projectionKind == Variance.OUT_VARIANCE) {
            return new TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getUpper());
        }
        if (z) {
            return new TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getLower());
        }
        return substituteCapturedTypesWithProjections(typeProjection);
    }

    private static final TypeProjection substituteCapturedTypesWithProjections(TypeProjection typeProjection) {
        TypeSubstitutor create = TypeSubstitutor.create(new CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1());
        Intrinsics.checkExpressionValueIsNotNull(create, "TypeSubstitutor.create(o…ojection\n        }\n    })");
        return create.substituteWithoutApproximation(typeProjection);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds<kotlin.reflect.jvm.internal.impl.types.KotlinType> approximateCapturedTypes(kotlin.reflect.jvm.internal.impl.types.KotlinType r8) {
        /*
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            boolean r0 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.isFlexible(r8)
            if (r0 == 0) goto L_0x005d
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.lowerIfFlexible(r8)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r0 = approximateCapturedTypes(r0)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.upperIfFlexible(r8)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r1 = approximateCapturedTypes(r1)
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r2 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds
            java.lang.Object r3 = r0.getLower()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.lowerIfFlexible(r3)
            java.lang.Object r4 = r1.getLower()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.upperIfFlexible(r4)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r3 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r3, r4)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r3 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.inheritEnhancement(r3, r8)
            java.lang.Object r0 = r0.getUpper()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.lowerIfFlexible(r0)
            java.lang.Object r1 = r1.getUpper()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.upperIfFlexible(r1)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r0, r1)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r8 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.inheritEnhancement(r0, r8)
            r2.<init>(r3, r8)
            return r2
        L_0x005d:
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = r8.getConstructor()
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt.isCaptured(r8)
            java.lang.String r2 = "type.builtIns.nothingType"
            r3 = 1
            if (r1 == 0) goto L_0x00e0
            if (r0 == 0) goto L_0x00d8
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor r0 = (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor) r0
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = r0.getProjection()
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$approximateCapturedTypes$1 r1 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$approximateCapturedTypes$1
            r1.<init>(r8)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r0.getType()
            java.lang.String r5 = "typeProjection.type"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r1.invoke(r4)
            kotlin.reflect.jvm.internal.impl.types.Variance r5 = r0.getProjectionKind()
            int[] r6 = kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt.WhenMappings.$EnumSwitchMapping$1
            int r5 = r5.ordinal()
            r5 = r6[r5]
            if (r5 == r3) goto L_0x00c5
            r3 = 2
            if (r5 != r3) goto L_0x00ac
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r0 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getBuiltIns(r8)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r8 = r8.getNothingType()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r2)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r8
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r1.invoke(r8)
            r0.<init>(r8, r4)
            goto L_0x00d7
        L_0x00ac:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Only nontrivial projections should have been captured, not: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r8.<init>(r0)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        L_0x00c5:
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r0 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getBuiltIns(r8)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r8 = r8.getNullableAnyType()
            java.lang.String r1 = "type.builtIns.nullableAnyType"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r1)
            r0.<init>(r4, r8)
        L_0x00d7:
            return r0
        L_0x00d8:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor"
            r8.<init>(r0)
            throw r8
        L_0x00e0:
            java.util.List r1 = r8.getArguments()
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x01b2
            java.util.List r1 = r8.getArguments()
            int r1 = r1.size()
            java.util.List r4 = r0.getParameters()
            int r4 = r4.size()
            if (r1 == r4) goto L_0x00fe
            goto L_0x01b2
        L_0x00fe:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r5 = r8.getArguments()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.List r0 = r0.getParameters()
            java.lang.String r6 = "typeConstructor.parameters"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.zip(r5, r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x0121:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0166
            java.lang.Object r5 = r0.next()
            kotlin.Pair r5 = (kotlin.Pair) r5
            java.lang.Object r6 = r5.component1()
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r6 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r6
            java.lang.Object r5 = r5.component2()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5
            java.lang.String r7 = "typeParameter"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r7)
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument r5 = toTypeArgument(r6, r5)
            boolean r6 = r6.isStarProjection()
            if (r6 == 0) goto L_0x014f
            r1.add(r5)
            r4.add(r5)
            goto L_0x0121
        L_0x014f:
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r5 = approximateProjection(r5)
            java.lang.Object r6 = r5.component1()
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument r6 = (kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument) r6
            java.lang.Object r5 = r5.component2()
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument r5 = (kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument) r5
            r1.add(r6)
            r4.add(r5)
            goto L_0x0121
        L_0x0166:
            r0 = r1
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r5 = r0 instanceof java.util.Collection
            r6 = 0
            if (r5 == 0) goto L_0x0179
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0179
        L_0x0177:
            r3 = r6
            goto L_0x0190
        L_0x0179:
            java.util.Iterator r0 = r0.iterator()
        L_0x017d:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0177
            java.lang.Object r5 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument r5 = (kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument) r5
            boolean r5 = r5.isConsistent()
            r5 = r5 ^ r3
            if (r5 == 0) goto L_0x017d
        L_0x0190:
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r0 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds
            if (r3 == 0) goto L_0x01a2
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getBuiltIns(r8)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r1.getNothingType()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
            goto L_0x01a8
        L_0x01a2:
            java.util.List r1 = (java.util.List) r1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = replaceTypeArguments(r8, r1)
        L_0x01a8:
            java.util.List r4 = (java.util.List) r4
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = replaceTypeArguments(r8, r4)
            r0.<init>(r1, r8)
            return r0
        L_0x01b2:
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds r0 = new kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds
            r0.<init>(r8, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt.approximateCapturedTypes(kotlin.reflect.jvm.internal.impl.types.KotlinType):kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds");
    }

    private static final KotlinType replaceTypeArguments(KotlinType kotlinType, List<TypeArgument> list) {
        boolean z = kotlinType.getArguments().size() == list.size();
        if (!_Assertions.ENABLED || z) {
            Iterable<TypeArgument> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (TypeArgument typeProjection : iterable) {
                arrayList.add(toTypeProjection(typeProjection));
            }
            return TypeSubstitutionKt.replace$default(kotlinType, (List) arrayList, (Annotations) null, 2, (Object) null);
        }
        throw new AssertionError("Incorrect type arguments " + list);
    }

    private static final ApproximationBounds<TypeArgument> approximateProjection(TypeArgument typeArgument) {
        ApproximationBounds<KotlinType> approximateCapturedTypes = approximateCapturedTypes(typeArgument.getInProjection());
        ApproximationBounds<KotlinType> approximateCapturedTypes2 = approximateCapturedTypes(typeArgument.getOutProjection());
        return new ApproximationBounds<>(new TypeArgument(typeArgument.getTypeParameter(), approximateCapturedTypes.component2(), approximateCapturedTypes2.component1()), new TypeArgument(typeArgument.getTypeParameter(), approximateCapturedTypes.component1(), approximateCapturedTypes2.component2()));
    }
}
