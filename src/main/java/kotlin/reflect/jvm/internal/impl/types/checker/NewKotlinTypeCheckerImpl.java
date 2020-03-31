package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: NewKotlinTypeChecker.kt */
public final class NewKotlinTypeCheckerImpl implements NewKotlinTypeChecker {
    private final KotlinTypeRefiner kotlinTypeRefiner;
    private final OverridingUtil overridingUtil;

    public NewKotlinTypeCheckerImpl(KotlinTypeRefiner kotlinTypeRefiner2) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeRefiner2, "kotlinTypeRefiner");
        this.kotlinTypeRefiner = kotlinTypeRefiner2;
        OverridingUtil createWithTypeRefiner = OverridingUtil.createWithTypeRefiner(getKotlinTypeRefiner());
        Intrinsics.checkExpressionValueIsNotNull(createWithTypeRefiner, "OverridingUtil.createWit…efiner(kotlinTypeRefiner)");
        this.overridingUtil = createWithTypeRefiner;
    }

    public KotlinTypeRefiner getKotlinTypeRefiner() {
        return this.kotlinTypeRefiner;
    }

    public OverridingUtil getOverridingUtil() {
        return this.overridingUtil;
    }

    public boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "subtype");
        Intrinsics.checkParameterIsNotNull(kotlinType2, "supertype");
        return isSubtypeOf(new ClassicTypeCheckerContext(true, false, getKotlinTypeRefiner(), 2, null), kotlinType.unwrap(), kotlinType2.unwrap());
    }

    public boolean equalTypes(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "a");
        Intrinsics.checkParameterIsNotNull(kotlinType2, "b");
        return equalTypes(new ClassicTypeCheckerContext(false, false, getKotlinTypeRefiner(), 2, null), kotlinType.unwrap(), kotlinType2.unwrap());
    }

    public final boolean equalTypes(ClassicTypeCheckerContext classicTypeCheckerContext, UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        Intrinsics.checkParameterIsNotNull(classicTypeCheckerContext, "$this$equalTypes");
        Intrinsics.checkParameterIsNotNull(unwrappedType, "a");
        Intrinsics.checkParameterIsNotNull(unwrappedType2, "b");
        return AbstractTypeChecker.INSTANCE.equalTypes(classicTypeCheckerContext, unwrappedType, unwrappedType2);
    }

    public final boolean isSubtypeOf(ClassicTypeCheckerContext classicTypeCheckerContext, UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        Intrinsics.checkParameterIsNotNull(classicTypeCheckerContext, "$this$isSubtypeOf");
        Intrinsics.checkParameterIsNotNull(unwrappedType, "subType");
        Intrinsics.checkParameterIsNotNull(unwrappedType2, "superType");
        return AbstractTypeChecker.INSTANCE.isSubtypeOf(classicTypeCheckerContext, unwrappedType, unwrappedType2);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.reflect.jvm.internal.impl.types.UnwrappedType] */
    /* JADX WARN: Type inference failed for: r4v10, types: [kotlin.reflect.jvm.internal.impl.types.UnwrappedType] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.types.SimpleType transformToNewType(kotlin.reflect.jvm.internal.impl.types.SimpleType r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r1 = "type"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r1)
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r1 = r18.getConstructor()
            boolean r2 = r1 instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl
            r3 = 1
            r4 = 0
            r5 = 0
            r6 = 10
            if (r2 == 0) goto L_0x0094
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl r1 = (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl) r1
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r2 = r1.getProjection()
            kotlin.reflect.jvm.internal.impl.types.Variance r7 = r2.getProjectionKind()
            kotlin.reflect.jvm.internal.impl.types.Variance r8 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
            if (r7 != r8) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r3 = r5
        L_0x0024:
            if (r3 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r2 = r4
        L_0x0028:
            if (r2 == 0) goto L_0x0034
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r2.getType()
            if (r2 == 0) goto L_0x0034
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r4 = r2.unwrap()
        L_0x0034:
            r10 = r4
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r2 = r1.getNewTypeConstructor()
            if (r2 != 0) goto L_0x0078
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r12 = r1.getProjection()
            java.util.Collection r2 = r1.getSupertypes()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r6)
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L_0x0054:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0068
            java.lang.Object r4 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r4 = r4.unwrap()
            r3.add(r4)
            goto L_0x0054
        L_0x0068:
            r13 = r3
            java.util.List r13 = (java.util.List) r13
            r14 = 0
            r15 = 4
            r16 = 0
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r2 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor
            r11 = r2
            r11.<init>(r12, r13, r14, r15, r16)
            r1.setNewTypeConstructor(r2)
        L_0x0078:
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType r2 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType
            kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus r8 = kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus.FOR_SUBTYPING
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r9 = r1.getNewTypeConstructor()
            if (r9 != 0) goto L_0x0085
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0085:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r11 = r18.getAnnotations()
            boolean r12 = r18.isMarkedNullable()
            r7 = r2
            r7.<init>(r8, r9, r10, r11, r12)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r2
            return r2
        L_0x0094:
            boolean r2 = r1 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor
            if (r2 == 0) goto L_0x00e3
            kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor r1 = (kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor) r1
            java.util.Collection r1 = r1.getSupertypes()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r6)
            r2.<init>(r3)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x00af:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00c7
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
            boolean r4 = r18.isMarkedNullable()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNullableAsSpecified(r3, r4)
            r2.add(r3)
            goto L_0x00af
        L_0x00c7:
            java.util.List r2 = (java.util.List) r2
            java.util.Collection r2 = (java.util.Collection) r2
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r1 = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            r1.<init>(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r2 = r18.getAnnotations()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r1 = (kotlin.reflect.jvm.internal.impl.types.TypeConstructor) r1
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r18.getMemberScope()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r2, r1, r3, r5, r0)
            return r0
        L_0x00e3:
            boolean r2 = r1 instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            if (r2 == 0) goto L_0x012c
            boolean r2 = r18.isMarkedNullable()
            if (r2 == 0) goto L_0x012c
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r1 = (kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) r1
            java.util.Collection r0 = r1.getSupertypes()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r6)
            r2.<init>(r6)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r0 = r0.iterator()
        L_0x0104:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0119
            java.lang.Object r5 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r5
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNullable(r5)
            r2.add(r5)
            r5 = r3
            goto L_0x0104
        L_0x0119:
            java.util.List r2 = (java.util.List) r2
            if (r5 != 0) goto L_0x011e
            goto L_0x0125
        L_0x011e:
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r4 = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            java.util.Collection r2 = (java.util.Collection) r2
            r4.<init>(r2)
        L_0x0125:
            if (r4 == 0) goto L_0x0128
            r1 = r4
        L_0x0128:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r1.createType()
        L_0x012c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl.transformToNewType(kotlin.reflect.jvm.internal.impl.types.SimpleType):kotlin.reflect.jvm.internal.impl.types.SimpleType");
    }

    public UnwrappedType transformToNewType(UnwrappedType unwrappedType) {
        UnwrappedType unwrappedType2;
        Intrinsics.checkParameterIsNotNull(unwrappedType, "type");
        if (unwrappedType instanceof SimpleType) {
            unwrappedType2 = transformToNewType((SimpleType) unwrappedType);
        } else if (unwrappedType instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrappedType;
            SimpleType transformToNewType = transformToNewType(flexibleType.getLowerBound());
            SimpleType transformToNewType2 = transformToNewType(flexibleType.getUpperBound());
            if (transformToNewType == flexibleType.getLowerBound() && transformToNewType2 == flexibleType.getUpperBound()) {
                unwrappedType2 = unwrappedType;
            } else {
                unwrappedType2 = KotlinTypeFactory.flexibleType(transformToNewType, transformToNewType2);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(unwrappedType2, unwrappedType);
    }
}
