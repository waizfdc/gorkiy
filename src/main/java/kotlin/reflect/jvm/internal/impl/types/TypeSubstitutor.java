package kotlin.reflect.jvm.internal.impl.types;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;

public class TypeSubstitutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TypeSubstitutor EMPTY = create(TypeSubstitution.EMPTY);
    private final TypeSubstitution substitution;

    private enum VarianceConflictType {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017 A[FALL_THROUGH] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ void $$$reportNull$$$0(int r12) {
        /*
            r0 = 27
            r1 = 24
            r2 = 6
            if (r12 == r2) goto L_0x0017
            if (r12 == r1) goto L_0x0017
            if (r12 == r0) goto L_0x0017
            switch(r12) {
                case 9: goto L_0x0017;
                case 10: goto L_0x0017;
                case 11: goto L_0x0017;
                default: goto L_0x000e;
            }
        L_0x000e:
            switch(r12) {
                case 17: goto L_0x0017;
                case 18: goto L_0x0017;
                case 19: goto L_0x0017;
                case 20: goto L_0x0017;
                case 21: goto L_0x0017;
                case 22: goto L_0x0017;
                default: goto L_0x0011;
            }
        L_0x0011:
            switch(r12) {
                case 30: goto L_0x0017;
                case 31: goto L_0x0017;
                case 32: goto L_0x0017;
                default: goto L_0x0014;
            }
        L_0x0014:
            java.lang.String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L_0x0019
        L_0x0017:
            java.lang.String r3 = "@NotNull method %s.%s must not return null"
        L_0x0019:
            r4 = 2
            if (r12 == r2) goto L_0x002b
            if (r12 == r1) goto L_0x002b
            if (r12 == r0) goto L_0x002b
            switch(r12) {
                case 9: goto L_0x002b;
                case 10: goto L_0x002b;
                case 11: goto L_0x002b;
                default: goto L_0x0023;
            }
        L_0x0023:
            switch(r12) {
                case 17: goto L_0x002b;
                case 18: goto L_0x002b;
                case 19: goto L_0x002b;
                case 20: goto L_0x002b;
                case 21: goto L_0x002b;
                case 22: goto L_0x002b;
                default: goto L_0x0026;
            }
        L_0x0026:
            switch(r12) {
                case 30: goto L_0x002b;
                case 31: goto L_0x002b;
                case 32: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            r5 = 3
            goto L_0x002c
        L_0x002b:
            r5 = r4
        L_0x002c:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor"
            r7 = 0
            switch(r12) {
                case 1: goto L_0x006e;
                case 2: goto L_0x0069;
                case 3: goto L_0x0064;
                case 4: goto L_0x005f;
                case 5: goto L_0x0034;
                case 6: goto L_0x005c;
                case 7: goto L_0x0057;
                case 8: goto L_0x0052;
                case 9: goto L_0x005c;
                case 10: goto L_0x005c;
                case 11: goto L_0x005c;
                case 12: goto L_0x0057;
                case 13: goto L_0x0052;
                case 14: goto L_0x004d;
                case 15: goto L_0x004d;
                case 16: goto L_0x0048;
                case 17: goto L_0x005c;
                case 18: goto L_0x005c;
                case 19: goto L_0x005c;
                case 20: goto L_0x005c;
                case 21: goto L_0x005c;
                case 22: goto L_0x005c;
                case 23: goto L_0x0043;
                case 24: goto L_0x005c;
                case 25: goto L_0x003e;
                case 26: goto L_0x004d;
                case 27: goto L_0x005c;
                case 28: goto L_0x003e;
                case 29: goto L_0x0039;
                case 30: goto L_0x005c;
                case 31: goto L_0x005c;
                case 32: goto L_0x005c;
                default: goto L_0x0034;
            }
        L_0x0034:
            java.lang.String r8 = "substitution"
            r5[r7] = r8
            goto L_0x0072
        L_0x0039:
            java.lang.String r8 = "projectionKind"
            r5[r7] = r8
            goto L_0x0072
        L_0x003e:
            java.lang.String r8 = "typeParameterVariance"
            r5[r7] = r8
            goto L_0x0072
        L_0x0043:
            java.lang.String r8 = "annotations"
            r5[r7] = r8
            goto L_0x0072
        L_0x0048:
            java.lang.String r8 = "originalProjection"
            r5[r7] = r8
            goto L_0x0072
        L_0x004d:
            java.lang.String r8 = "typeProjection"
            r5[r7] = r8
            goto L_0x0072
        L_0x0052:
            java.lang.String r8 = "howThisTypeIsUsed"
            r5[r7] = r8
            goto L_0x0072
        L_0x0057:
            java.lang.String r8 = "type"
            r5[r7] = r8
            goto L_0x0072
        L_0x005c:
            r5[r7] = r6
            goto L_0x0072
        L_0x005f:
            java.lang.String r8 = "context"
            r5[r7] = r8
            goto L_0x0072
        L_0x0064:
            java.lang.String r8 = "substitutionContext"
            r5[r7] = r8
            goto L_0x0072
        L_0x0069:
            java.lang.String r8 = "second"
            r5[r7] = r8
            goto L_0x0072
        L_0x006e:
            java.lang.String r8 = "first"
            r5[r7] = r8
        L_0x0072:
            java.lang.String r7 = "combine"
            java.lang.String r8 = "filterOutUnsafeVariance"
            java.lang.String r9 = "unsafeSubstitute"
            java.lang.String r10 = "safeSubstitute"
            r11 = 1
            if (r12 == r2) goto L_0x0099
            if (r12 == r1) goto L_0x0096
            if (r12 == r0) goto L_0x0093
            switch(r12) {
                case 9: goto L_0x0090;
                case 10: goto L_0x0090;
                case 11: goto L_0x0090;
                default: goto L_0x0084;
            }
        L_0x0084:
            switch(r12) {
                case 17: goto L_0x008d;
                case 18: goto L_0x008d;
                case 19: goto L_0x008d;
                case 20: goto L_0x008d;
                case 21: goto L_0x008d;
                case 22: goto L_0x008d;
                default: goto L_0x0087;
            }
        L_0x0087:
            switch(r12) {
                case 30: goto L_0x0093;
                case 31: goto L_0x0093;
                case 32: goto L_0x0093;
                default: goto L_0x008a;
            }
        L_0x008a:
            r5[r11] = r6
            goto L_0x009d
        L_0x008d:
            r5[r11] = r9
            goto L_0x009d
        L_0x0090:
            r5[r11] = r10
            goto L_0x009d
        L_0x0093:
            r5[r11] = r7
            goto L_0x009d
        L_0x0096:
            r5[r11] = r8
            goto L_0x009d
        L_0x0099:
            java.lang.String r6 = "getSubstitution"
            r5[r11] = r6
        L_0x009d:
            if (r12 == r11) goto L_0x00c4
            if (r12 == r4) goto L_0x00c4
            switch(r12) {
                case 5: goto L_0x00bf;
                case 6: goto L_0x00c8;
                case 7: goto L_0x00bc;
                case 8: goto L_0x00bc;
                case 9: goto L_0x00c8;
                case 10: goto L_0x00c8;
                case 11: goto L_0x00c8;
                case 12: goto L_0x00b7;
                case 13: goto L_0x00b7;
                case 14: goto L_0x00b7;
                case 15: goto L_0x00b2;
                case 16: goto L_0x00af;
                case 17: goto L_0x00c8;
                case 18: goto L_0x00c8;
                case 19: goto L_0x00c8;
                case 20: goto L_0x00c8;
                case 21: goto L_0x00c8;
                case 22: goto L_0x00c8;
                case 23: goto L_0x00ac;
                case 24: goto L_0x00c8;
                case 25: goto L_0x00a9;
                case 26: goto L_0x00a9;
                case 27: goto L_0x00c8;
                case 28: goto L_0x00a9;
                case 29: goto L_0x00a9;
                case 30: goto L_0x00c8;
                case 31: goto L_0x00c8;
                case 32: goto L_0x00c8;
                default: goto L_0x00a4;
            }
        L_0x00a4:
            java.lang.String r6 = "create"
            r5[r4] = r6
            goto L_0x00c8
        L_0x00a9:
            r5[r4] = r7
            goto L_0x00c8
        L_0x00ac:
            r5[r4] = r8
            goto L_0x00c8
        L_0x00af:
            r5[r4] = r9
            goto L_0x00c8
        L_0x00b2:
            java.lang.String r6 = "substituteWithoutApproximation"
            r5[r4] = r6
            goto L_0x00c8
        L_0x00b7:
            java.lang.String r6 = "substitute"
            r5[r4] = r6
            goto L_0x00c8
        L_0x00bc:
            r5[r4] = r10
            goto L_0x00c8
        L_0x00bf:
            java.lang.String r6 = "<init>"
            r5[r4] = r6
            goto L_0x00c8
        L_0x00c4:
            java.lang.String r6 = "createChainedSubstitutor"
            r5[r4] = r6
        L_0x00c8:
            java.lang.String r3 = java.lang.String.format(r3, r5)
            if (r12 == r2) goto L_0x00e1
            if (r12 == r1) goto L_0x00e1
            if (r12 == r0) goto L_0x00e1
            switch(r12) {
                case 9: goto L_0x00e1;
                case 10: goto L_0x00e1;
                case 11: goto L_0x00e1;
                default: goto L_0x00d5;
            }
        L_0x00d5:
            switch(r12) {
                case 17: goto L_0x00e1;
                case 18: goto L_0x00e1;
                case 19: goto L_0x00e1;
                case 20: goto L_0x00e1;
                case 21: goto L_0x00e1;
                case 22: goto L_0x00e1;
                default: goto L_0x00d8;
            }
        L_0x00d8:
            switch(r12) {
                case 30: goto L_0x00e1;
                case 31: goto L_0x00e1;
                case 32: goto L_0x00e1;
                default: goto L_0x00db;
            }
        L_0x00db:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            r12.<init>(r3)
            goto L_0x00e6
        L_0x00e1:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>(r3)
        L_0x00e6:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.$$$reportNull$$$0(int):void");
    }

    private static final class SubstitutionException extends Exception {
        public SubstitutionException(String str) {
            super(str);
        }
    }

    public static TypeSubstitutor create(TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(0);
        }
        return new TypeSubstitutor(typeSubstitution);
    }

    public static TypeSubstitutor createChainedSubstitutor(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(1);
        }
        if (typeSubstitution2 == null) {
            $$$reportNull$$$0(2);
        }
        return create(DisjointKeysUnionTypeSubstitution.create(typeSubstitution, typeSubstitution2));
    }

    public static TypeSubstitutor create(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(4);
        }
        return create(TypeConstructorSubstitution.create(kotlinType.getConstructor(), kotlinType.getArguments()));
    }

    protected TypeSubstitutor(TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(5);
        }
        this.substitution = typeSubstitution;
    }

    public boolean isEmpty() {
        return this.substitution.isEmpty();
    }

    public TypeSubstitution getSubstitution() {
        TypeSubstitution typeSubstitution = this.substitution;
        if (typeSubstitution == null) {
            $$$reportNull$$$0(6);
        }
        return typeSubstitution;
    }

    public KotlinType safeSubstitute(KotlinType kotlinType, Variance variance) {
        if (kotlinType == null) {
            $$$reportNull$$$0(7);
        }
        if (variance == null) {
            $$$reportNull$$$0(8);
        }
        if (isEmpty()) {
            if (kotlinType == null) {
                $$$reportNull$$$0(9);
            }
            return kotlinType;
        }
        try {
            KotlinType type = unsafeSubstitute(new TypeProjectionImpl(variance, kotlinType), 0).getType();
            if (type == null) {
                $$$reportNull$$$0(10);
            }
            return type;
        } catch (SubstitutionException e) {
            SimpleType createErrorType = ErrorUtils.createErrorType(e.getMessage());
            if (createErrorType == null) {
                $$$reportNull$$$0(11);
            }
            return createErrorType;
        }
    }

    public KotlinType substitute(KotlinType kotlinType, Variance variance) {
        if (kotlinType == null) {
            $$$reportNull$$$0(12);
        }
        if (variance == null) {
            $$$reportNull$$$0(13);
        }
        TypeProjection substitute = substitute(new TypeProjectionImpl(variance, getSubstitution().prepareTopLevelType(kotlinType, variance)));
        if (substitute == null) {
            return null;
        }
        return substitute.getType();
    }

    public TypeProjection substitute(TypeProjection typeProjection) {
        if (typeProjection == null) {
            $$$reportNull$$$0(14);
        }
        TypeProjection substituteWithoutApproximation = substituteWithoutApproximation(typeProjection);
        if (this.substitution.approximateCapturedTypes() || this.substitution.approximateContravariantCapturedTypes()) {
            return CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary(substituteWithoutApproximation, this.substitution.approximateContravariantCapturedTypes());
        }
        return substituteWithoutApproximation;
    }

    public TypeProjection substituteWithoutApproximation(TypeProjection typeProjection) {
        if (typeProjection == null) {
            $$$reportNull$$$0(15);
        }
        if (isEmpty()) {
            return typeProjection;
        }
        try {
            return unsafeSubstitute(typeProjection, 0);
        } catch (SubstitutionException unused) {
            return null;
        }
    }

    private TypeProjection unsafeSubstitute(TypeProjection typeProjection, int i) throws SubstitutionException {
        KotlinType kotlinType;
        if (typeProjection == null) {
            $$$reportNull$$$0(16);
        }
        assertRecursionDepth(i, typeProjection, this.substitution);
        if (typeProjection.isStarProjection()) {
            if (typeProjection == null) {
                $$$reportNull$$$0(17);
            }
            return typeProjection;
        }
        KotlinType type = typeProjection.getType();
        if (type instanceof TypeWithEnhancement) {
            TypeWithEnhancement typeWithEnhancement = (TypeWithEnhancement) type;
            UnwrappedType origin = typeWithEnhancement.getOrigin();
            KotlinType enhancement = typeWithEnhancement.getEnhancement();
            TypeProjection unsafeSubstitute = unsafeSubstitute(new TypeProjectionImpl(typeProjection.getProjectionKind(), origin), i + 1);
            return new TypeProjectionImpl(unsafeSubstitute.getProjectionKind(), TypeWithEnhancementKt.wrapEnhancement(unsafeSubstitute.getType().unwrap(), substitute(enhancement, typeProjection.getProjectionKind())));
        } else if (DynamicTypesKt.isDynamic(type) || (type.unwrap() instanceof RawType)) {
            if (typeProjection == null) {
                $$$reportNull$$$0(18);
            }
            return typeProjection;
        } else {
            TypeProjection typeProjection2 = this.substitution.get(type);
            Variance projectionKind = typeProjection.getProjectionKind();
            if (typeProjection2 == null && FlexibleTypesKt.isFlexible(type) && !TypeCapabilitiesKt.isCustomTypeVariable(type)) {
                FlexibleType asFlexibleType = FlexibleTypesKt.asFlexibleType(type);
                int i2 = i + 1;
                TypeProjection unsafeSubstitute2 = unsafeSubstitute(new TypeProjectionImpl(projectionKind, asFlexibleType.getLowerBound()), i2);
                TypeProjection unsafeSubstitute3 = unsafeSubstitute(new TypeProjectionImpl(projectionKind, asFlexibleType.getUpperBound()), i2);
                Variance projectionKind2 = unsafeSubstitute2.getProjectionKind();
                if (unsafeSubstitute2.getType() != asFlexibleType.getLowerBound() || unsafeSubstitute3.getType() != asFlexibleType.getUpperBound()) {
                    return new TypeProjectionImpl(projectionKind2, KotlinTypeFactory.flexibleType(TypeSubstitutionKt.asSimpleType(unsafeSubstitute2.getType()), TypeSubstitutionKt.asSimpleType(unsafeSubstitute3.getType())));
                }
                if (typeProjection == null) {
                    $$$reportNull$$$0(19);
                }
                return typeProjection;
            } else if (KotlinBuiltIns.isNothing(type) || KotlinTypeKt.isError(type)) {
                if (typeProjection == null) {
                    $$$reportNull$$$0(20);
                }
                return typeProjection;
            } else if (typeProjection2 != null) {
                VarianceConflictType conflictType = conflictType(projectionKind, typeProjection2.getProjectionKind());
                if (!CapturedTypeConstructorKt.isCaptured(type)) {
                    int i3 = AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[conflictType.ordinal()];
                    if (i3 == 1) {
                        throw new SubstitutionException("Out-projection in in-position");
                    } else if (i3 == 2) {
                        return new TypeProjectionImpl(Variance.OUT_VARIANCE, type.getConstructor().getBuiltIns().getNullableAnyType());
                    }
                }
                CustomTypeVariable customTypeVariable = TypeCapabilitiesKt.getCustomTypeVariable(type);
                if (typeProjection2.isStarProjection()) {
                    if (typeProjection2 == null) {
                        $$$reportNull$$$0(21);
                    }
                    return typeProjection2;
                }
                if (customTypeVariable != null) {
                    kotlinType = customTypeVariable.substitutionResult(typeProjection2.getType());
                } else {
                    kotlinType = TypeUtils.makeNullableIfNeeded(typeProjection2.getType(), type.isMarkedNullable());
                }
                if (!type.getAnnotations().isEmpty()) {
                    kotlinType = TypeUtilsKt.replaceAnnotations(kotlinType, new CompositeAnnotations(kotlinType.getAnnotations(), filterOutUnsafeVariance(this.substitution.filterAnnotations(type.getAnnotations()))));
                }
                if (conflictType == VarianceConflictType.NO_CONFLICT) {
                    projectionKind = combine(projectionKind, typeProjection2.getProjectionKind());
                }
                return new TypeProjectionImpl(projectionKind, kotlinType);
            } else {
                TypeProjection substituteCompoundType = substituteCompoundType(typeProjection, i);
                if (substituteCompoundType == null) {
                    $$$reportNull$$$0(22);
                }
                return substituteCompoundType;
            }
        }
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$VarianceConflictType[] r0 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.VarianceConflictType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType = r0
                kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$VarianceConflictType r1 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.VarianceConflictType.OUT_IN_IN_POSITION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType     // Catch:{ NoSuchFieldError -> 0x001d }
                kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$VarianceConflictType r1 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.VarianceConflictType.IN_IN_OUT_POSITION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType     // Catch:{ NoSuchFieldError -> 0x0028 }
                kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$VarianceConflictType r1 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.VarianceConflictType.NO_CONFLICT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.AnonymousClass2.<clinit>():void");
        }
    }

    private static Annotations filterOutUnsafeVariance(Annotations annotations) {
        if (annotations == null) {
            $$$reportNull$$$0(23);
        }
        if (annotations.hasAnnotation(KotlinBuiltIns.FQ_NAMES.unsafeVariance)) {
            return new FilteredAnnotations(annotations, new Function1<FqName, Boolean>() {
                /* class kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.AnonymousClass1 */

                private static /* synthetic */ void $$$reportNull$$$0(int i) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", AppMeasurementSdk.ConditionalUserProperty.NAME, "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
                }

                public Boolean invoke(FqName fqName) {
                    if (fqName == null) {
                        $$$reportNull$$$0(0);
                    }
                    return Boolean.valueOf(!fqName.equals(KotlinBuiltIns.FQ_NAMES.unsafeVariance));
                }
            });
        }
        if (annotations == null) {
            $$$reportNull$$$0(24);
        }
        return annotations;
    }

    private TypeProjection substituteCompoundType(TypeProjection typeProjection, int i) throws SubstitutionException {
        KotlinType type = typeProjection.getType();
        Variance projectionKind = typeProjection.getProjectionKind();
        if (type.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return typeProjection;
        }
        KotlinType kotlinType = null;
        SimpleType abbreviation = SpecialTypesKt.getAbbreviation(type);
        if (abbreviation != null) {
            kotlinType = substitute(abbreviation, Variance.INVARIANT);
        }
        KotlinType replace = TypeSubstitutionKt.replace(type, substituteTypeArguments(type.getConstructor().getParameters(), type.getArguments(), i), this.substitution.filterAnnotations(type.getAnnotations()));
        if ((replace instanceof SimpleType) && (kotlinType instanceof SimpleType)) {
            replace = SpecialTypesKt.withAbbreviation((SimpleType) replace, (SimpleType) kotlinType);
        }
        return new TypeProjectionImpl(projectionKind, replace);
    }

    private List<TypeProjection> substituteTypeArguments(List<TypeParameterDescriptor> list, List<TypeProjection> list2, int i) throws SubstitutionException {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z = false;
        for (int i2 = 0; i2 < list.size(); i2++) {
            TypeParameterDescriptor typeParameterDescriptor = list.get(i2);
            TypeProjection typeProjection = list2.get(i2);
            TypeProjection unsafeSubstitute = unsafeSubstitute(typeProjection, i + 1);
            int i3 = AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[conflictType(typeParameterDescriptor.getVariance(), unsafeSubstitute.getProjectionKind()).ordinal()];
            if (i3 == 1 || i3 == 2) {
                unsafeSubstitute = TypeUtils.makeStarProjection(typeParameterDescriptor);
            } else if (i3 == 3 && typeParameterDescriptor.getVariance() != Variance.INVARIANT && !unsafeSubstitute.isStarProjection()) {
                unsafeSubstitute = new TypeProjectionImpl(Variance.INVARIANT, unsafeSubstitute.getType());
            }
            if (unsafeSubstitute != typeProjection) {
                z = true;
            }
            arrayList.add(unsafeSubstitute);
        }
        return !z ? list2 : arrayList;
    }

    public static Variance combine(Variance variance, TypeProjection typeProjection) {
        if (variance == null) {
            $$$reportNull$$$0(25);
        }
        if (typeProjection == null) {
            $$$reportNull$$$0(26);
        }
        if (!typeProjection.isStarProjection()) {
            return combine(variance, typeProjection.getProjectionKind());
        }
        Variance variance2 = Variance.OUT_VARIANCE;
        if (variance2 == null) {
            $$$reportNull$$$0(27);
        }
        return variance2;
    }

    public static Variance combine(Variance variance, Variance variance2) {
        if (variance == null) {
            $$$reportNull$$$0(28);
        }
        if (variance2 == null) {
            $$$reportNull$$$0(29);
        }
        if (variance == Variance.INVARIANT) {
            if (variance2 == null) {
                $$$reportNull$$$0(30);
            }
            return variance2;
        } else if (variance2 == Variance.INVARIANT) {
            if (variance == null) {
                $$$reportNull$$$0(31);
            }
            return variance;
        } else if (variance == variance2) {
            if (variance2 == null) {
                $$$reportNull$$$0(32);
            }
            return variance2;
        } else {
            throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and " + "projection kind '" + variance2 + "' cannot be combined");
        }
    }

    private static VarianceConflictType conflictType(Variance variance, Variance variance2) {
        if (variance == Variance.IN_VARIANCE && variance2 == Variance.OUT_VARIANCE) {
            return VarianceConflictType.OUT_IN_IN_POSITION;
        }
        if (variance == Variance.OUT_VARIANCE && variance2 == Variance.IN_VARIANCE) {
            return VarianceConflictType.IN_IN_OUT_POSITION;
        }
        return VarianceConflictType.NO_CONFLICT;
    }

    private static void assertRecursionDepth(int i, TypeProjection typeProjection, TypeSubstitution typeSubstitution) {
        if (i > 100) {
            throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + safeToString(typeProjection) + "; substitution: " + safeToString(typeSubstitution));
        }
    }

    private static String safeToString(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (!ExceptionUtilsKt.isProcessCanceledException(th)) {
                return "[Exception while computing toString(): " + th + "]";
            }
            throw th;
        }
    }
}
