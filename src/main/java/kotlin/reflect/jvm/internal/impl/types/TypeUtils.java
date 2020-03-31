package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;

public class TypeUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final SimpleType CANT_INFER_FUNCTION_PARAM_TYPE = ErrorUtils.createErrorType("Cannot be inferred");
    public static final SimpleType DONT_CARE = ErrorUtils.createErrorTypeWithCustomDebugName("DONT_CARE");
    public static final SimpleType NO_EXPECTED_TYPE = new SpecialType("NO_EXPECTED_TYPE");
    public static final SimpleType UNIT_EXPECTED_TYPE = new SpecialType("UNIT_EXPECTED_TYPE");

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0182  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ void $$$reportNull$$$0(int r24) {
        /*
            r0 = r24
            r1 = 7
            r2 = 6
            r3 = 52
            r4 = 47
            r5 = 35
            r6 = 26
            r7 = 19
            r8 = 17
            r9 = 15
            r10 = 11
            r11 = 9
            r12 = 4
            if (r0 == r12) goto L_0x0035
            if (r0 == r11) goto L_0x0035
            if (r0 == r10) goto L_0x0035
            if (r0 == r9) goto L_0x0035
            if (r0 == r8) goto L_0x0035
            if (r0 == r7) goto L_0x0035
            if (r0 == r6) goto L_0x0035
            if (r0 == r5) goto L_0x0035
            if (r0 == r4) goto L_0x0035
            if (r0 == r3) goto L_0x0035
            if (r0 == r2) goto L_0x0035
            if (r0 == r1) goto L_0x0035
            switch(r0) {
                case 55: goto L_0x0035;
                case 56: goto L_0x0035;
                case 57: goto L_0x0035;
                case 58: goto L_0x0035;
                default: goto L_0x0032;
            }
        L_0x0032:
            java.lang.String r13 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L_0x0037
        L_0x0035:
            java.lang.String r13 = "@NotNull method %s.%s must not return null"
        L_0x0037:
            r14 = 2
            if (r0 == r12) goto L_0x0055
            if (r0 == r11) goto L_0x0055
            if (r0 == r10) goto L_0x0055
            if (r0 == r9) goto L_0x0055
            if (r0 == r8) goto L_0x0055
            if (r0 == r7) goto L_0x0055
            if (r0 == r6) goto L_0x0055
            if (r0 == r5) goto L_0x0055
            if (r0 == r4) goto L_0x0055
            if (r0 == r3) goto L_0x0055
            if (r0 == r2) goto L_0x0055
            if (r0 == r1) goto L_0x0055
            switch(r0) {
                case 55: goto L_0x0055;
                case 56: goto L_0x0055;
                case 57: goto L_0x0055;
                case 58: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            r15 = 3
            goto L_0x0056
        L_0x0055:
            r15 = r14
        L_0x0056:
            java.lang.Object[] r15 = new java.lang.Object[r15]
            java.lang.String r16 = "kotlin/reflect/jvm/internal/impl/types/TypeUtils"
            r17 = 0
            switch(r0) {
                case 4: goto L_0x00d7;
                case 5: goto L_0x005f;
                case 6: goto L_0x00d7;
                case 7: goto L_0x00d7;
                case 8: goto L_0x005f;
                case 9: goto L_0x00d7;
                case 10: goto L_0x005f;
                case 11: goto L_0x00d7;
                case 12: goto L_0x00d2;
                case 13: goto L_0x00cd;
                case 14: goto L_0x00c8;
                case 15: goto L_0x00d7;
                case 16: goto L_0x00c3;
                case 17: goto L_0x00d7;
                case 18: goto L_0x005f;
                case 19: goto L_0x00d7;
                case 20: goto L_0x00be;
                case 21: goto L_0x00b9;
                case 22: goto L_0x00b4;
                case 23: goto L_0x005f;
                case 24: goto L_0x00af;
                case 25: goto L_0x005f;
                case 26: goto L_0x00d7;
                case 27: goto L_0x005f;
                case 28: goto L_0x005f;
                case 29: goto L_0x005f;
                case 30: goto L_0x005f;
                case 31: goto L_0x00aa;
                case 32: goto L_0x00a5;
                case 33: goto L_0x00aa;
                case 34: goto L_0x00a0;
                case 35: goto L_0x00d7;
                case 36: goto L_0x009b;
                case 37: goto L_0x0096;
                case 38: goto L_0x005f;
                case 39: goto L_0x0091;
                case 40: goto L_0x005f;
                case 41: goto L_0x008c;
                case 42: goto L_0x0087;
                case 43: goto L_0x0082;
                case 44: goto L_0x0082;
                case 45: goto L_0x007d;
                case 46: goto L_0x0077;
                case 47: goto L_0x00d7;
                case 48: goto L_0x0071;
                case 49: goto L_0x0071;
                case 50: goto L_0x0077;
                case 51: goto L_0x006b;
                case 52: goto L_0x00d7;
                case 53: goto L_0x0065;
                case 54: goto L_0x006b;
                case 55: goto L_0x00d7;
                case 56: goto L_0x00d7;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00d7;
                default: goto L_0x005f;
            }
        L_0x005f:
            java.lang.String r18 = "type"
            r15[r17] = r18
            goto L_0x00d9
        L_0x0065:
            java.lang.String r18 = "literalTypeConstructor"
            r15[r17] = r18
            goto L_0x00d9
        L_0x006b:
            java.lang.String r18 = "expectedType"
            r15[r17] = r18
            goto L_0x00d9
        L_0x0071:
            java.lang.String r18 = "supertypes"
            r15[r17] = r18
            goto L_0x00d9
        L_0x0077:
            java.lang.String r18 = "numberValueTypeConstructor"
            r15[r17] = r18
            goto L_0x00d9
        L_0x007d:
            java.lang.String r18 = "parameterDescriptor"
            r15[r17] = r18
            goto L_0x00d9
        L_0x0082:
            java.lang.String r18 = "isSpecialType"
            r15[r17] = r18
            goto L_0x00d9
        L_0x0087:
            java.lang.String r18 = "specialType"
            r15[r17] = r18
            goto L_0x00d9
        L_0x008c:
            java.lang.String r18 = "typeParameterConstructors"
            r15[r17] = r18
            goto L_0x00d9
        L_0x0091:
            java.lang.String r18 = "typeParameters"
            r15[r17] = r18
            goto L_0x00d9
        L_0x0096:
            java.lang.String r18 = "b"
            r15[r17] = r18
            goto L_0x00d9
        L_0x009b:
            java.lang.String r18 = "a"
            r15[r17] = r18
            goto L_0x00d9
        L_0x00a0:
            java.lang.String r18 = "projections"
            r15[r17] = r18
            goto L_0x00d9
        L_0x00a5:
            java.lang.String r18 = "typeArguments"
            r15[r17] = r18
            goto L_0x00d9
        L_0x00aa:
            java.lang.String r18 = "clazz"
            r15[r17] = r18
            goto L_0x00d9
        L_0x00af:
            java.lang.String r18 = "result"
            r15[r17] = r18
            goto L_0x00d9
        L_0x00b4:
            java.lang.String r18 = "substitutor"
            r15[r17] = r18
            goto L_0x00d9
        L_0x00b9:
            java.lang.String r18 = "superType"
            r15[r17] = r18
            goto L_0x00d9
        L_0x00be:
            java.lang.String r18 = "subType"
            r15[r17] = r18
            goto L_0x00d9
        L_0x00c3:
            java.lang.String r18 = "parameters"
            r15[r17] = r18
            goto L_0x00d9
        L_0x00c8:
            java.lang.String r18 = "refinedTypeFactory"
            r15[r17] = r18
            goto L_0x00d9
        L_0x00cd:
            java.lang.String r18 = "unsubstitutedMemberScope"
            r15[r17] = r18
            goto L_0x00d9
        L_0x00d2:
            java.lang.String r18 = "typeConstructor"
            r15[r17] = r18
            goto L_0x00d9
        L_0x00d7:
            r15[r17] = r16
        L_0x00d9:
            java.lang.String r17 = "getAllSupertypes"
            java.lang.String r18 = "getImmediateSupertypes"
            java.lang.String r19 = "getDefaultTypeProjections"
            java.lang.String r20 = "makeUnsubstitutedType"
            java.lang.String r21 = "makeNullableIfNeeded"
            java.lang.String r22 = "makeNullableAsSpecified"
            r23 = 1
            if (r0 == r12) goto L_0x0123
            if (r0 == r11) goto L_0x0120
            if (r0 == r10) goto L_0x011d
            if (r0 == r9) goto L_0x011d
            if (r0 == r8) goto L_0x011a
            if (r0 == r7) goto L_0x0117
            if (r0 == r6) goto L_0x0114
            if (r0 == r5) goto L_0x010f
            if (r0 == r4) goto L_0x010a
            if (r0 == r3) goto L_0x0105
            if (r0 == r2) goto L_0x0120
            if (r0 == r1) goto L_0x0120
            switch(r0) {
                case 55: goto L_0x0105;
                case 56: goto L_0x0105;
                case 57: goto L_0x0105;
                case 58: goto L_0x0105;
                default: goto L_0x0102;
            }
        L_0x0102:
            r15[r23] = r16
            goto L_0x0125
        L_0x0105:
            java.lang.String r16 = "getPrimitiveNumberType"
            r15[r23] = r16
            goto L_0x0125
        L_0x010a:
            java.lang.String r16 = "getDefaultPrimitiveNumberType"
            r15[r23] = r16
            goto L_0x0125
        L_0x010f:
            java.lang.String r16 = "substituteProjectionsForParameters"
            r15[r23] = r16
            goto L_0x0125
        L_0x0114:
            r15[r23] = r17
            goto L_0x0125
        L_0x0117:
            r15[r23] = r18
            goto L_0x0125
        L_0x011a:
            r15[r23] = r19
            goto L_0x0125
        L_0x011d:
            r15[r23] = r20
            goto L_0x0125
        L_0x0120:
            r15[r23] = r21
            goto L_0x0125
        L_0x0123:
            r15[r23] = r22
        L_0x0125:
            switch(r0) {
                case 1: goto L_0x01b7;
                case 2: goto L_0x01b2;
                case 3: goto L_0x01af;
                case 4: goto L_0x01bb;
                case 5: goto L_0x01ac;
                case 6: goto L_0x01bb;
                case 7: goto L_0x01bb;
                case 8: goto L_0x01ac;
                case 9: goto L_0x01bb;
                case 10: goto L_0x01a7;
                case 11: goto L_0x01bb;
                case 12: goto L_0x01a4;
                case 13: goto L_0x01a4;
                case 14: goto L_0x01a4;
                case 15: goto L_0x01bb;
                case 16: goto L_0x01a1;
                case 17: goto L_0x01bb;
                case 18: goto L_0x019e;
                case 19: goto L_0x01bb;
                case 20: goto L_0x0199;
                case 21: goto L_0x0199;
                case 22: goto L_0x0199;
                case 23: goto L_0x0194;
                case 24: goto L_0x0194;
                case 25: goto L_0x0191;
                case 26: goto L_0x01bb;
                case 27: goto L_0x018c;
                case 28: goto L_0x0187;
                case 29: goto L_0x0182;
                case 30: goto L_0x017d;
                case 31: goto L_0x0178;
                case 32: goto L_0x0178;
                case 33: goto L_0x0173;
                case 34: goto L_0x0173;
                case 35: goto L_0x01bb;
                case 36: goto L_0x016e;
                case 37: goto L_0x016e;
                case 38: goto L_0x0169;
                case 39: goto L_0x0169;
                case 40: goto L_0x0164;
                case 41: goto L_0x0164;
                case 42: goto L_0x015e;
                case 43: goto L_0x015e;
                case 44: goto L_0x015e;
                case 45: goto L_0x0158;
                case 46: goto L_0x0152;
                case 47: goto L_0x01bb;
                case 48: goto L_0x0152;
                case 49: goto L_0x014c;
                case 50: goto L_0x0146;
                case 51: goto L_0x0146;
                case 52: goto L_0x01bb;
                case 53: goto L_0x0146;
                case 54: goto L_0x0146;
                case 55: goto L_0x01bb;
                case 56: goto L_0x01bb;
                case 57: goto L_0x01bb;
                case 58: goto L_0x01bb;
                case 59: goto L_0x0140;
                case 60: goto L_0x013a;
                case 61: goto L_0x0134;
                case 62: goto L_0x012e;
                default: goto L_0x0128;
            }
        L_0x0128:
            java.lang.String r16 = "noExpectedType"
            r15[r14] = r16
            goto L_0x01bb
        L_0x012e:
            java.lang.String r16 = "getTypeParameterDescriptorOrNull"
            r15[r14] = r16
            goto L_0x01bb
        L_0x0134:
            java.lang.String r16 = "isNonReifiedTypeParameter"
            r15[r14] = r16
            goto L_0x01bb
        L_0x013a:
            java.lang.String r16 = "isReifiedTypeParameter"
            r15[r14] = r16
            goto L_0x01bb
        L_0x0140:
            java.lang.String r16 = "isTypeParameter"
            r15[r14] = r16
            goto L_0x01bb
        L_0x0146:
            java.lang.String r16 = "getPrimitiveNumberType"
            r15[r14] = r16
            goto L_0x01bb
        L_0x014c:
            java.lang.String r16 = "findByFqName"
            r15[r14] = r16
            goto L_0x01bb
        L_0x0152:
            java.lang.String r16 = "getDefaultPrimitiveNumberType"
            r15[r14] = r16
            goto L_0x01bb
        L_0x0158:
            java.lang.String r16 = "makeStarProjection"
            r15[r14] = r16
            goto L_0x01bb
        L_0x015e:
            java.lang.String r16 = "contains"
            r15[r14] = r16
            goto L_0x01bb
        L_0x0164:
            java.lang.String r16 = "dependsOnTypeConstructors"
            r15[r14] = r16
            goto L_0x01bb
        L_0x0169:
            java.lang.String r16 = "dependsOnTypeParameters"
            r15[r14] = r16
            goto L_0x01bb
        L_0x016e:
            java.lang.String r16 = "equalTypes"
            r15[r14] = r16
            goto L_0x01bb
        L_0x0173:
            java.lang.String r16 = "substituteProjectionsForParameters"
            r15[r14] = r16
            goto L_0x01bb
        L_0x0178:
            java.lang.String r16 = "substituteParameters"
            r15[r14] = r16
            goto L_0x01bb
        L_0x017d:
            java.lang.String r16 = "getClassDescriptor"
            r15[r14] = r16
            goto L_0x01bb
        L_0x0182:
            java.lang.String r16 = "hasNullableSuperType"
            r15[r14] = r16
            goto L_0x01bb
        L_0x0187:
            java.lang.String r16 = "acceptsNullable"
            r15[r14] = r16
            goto L_0x01bb
        L_0x018c:
            java.lang.String r16 = "isNullableType"
            r15[r14] = r16
            goto L_0x01bb
        L_0x0191:
            r15[r14] = r17
            goto L_0x01bb
        L_0x0194:
            java.lang.String r16 = "collectAllSupertypes"
            r15[r14] = r16
            goto L_0x01bb
        L_0x0199:
            java.lang.String r16 = "createSubstitutedSupertype"
            r15[r14] = r16
            goto L_0x01bb
        L_0x019e:
            r15[r14] = r18
            goto L_0x01bb
        L_0x01a1:
            r15[r14] = r19
            goto L_0x01bb
        L_0x01a4:
            r15[r14] = r20
            goto L_0x01bb
        L_0x01a7:
            java.lang.String r16 = "canHaveSubtypes"
            r15[r14] = r16
            goto L_0x01bb
        L_0x01ac:
            r15[r14] = r21
            goto L_0x01bb
        L_0x01af:
            r15[r14] = r22
            goto L_0x01bb
        L_0x01b2:
            java.lang.String r16 = "makeNotNullable"
            r15[r14] = r16
            goto L_0x01bb
        L_0x01b7:
            java.lang.String r16 = "makeNullable"
            r15[r14] = r16
        L_0x01bb:
            java.lang.String r13 = java.lang.String.format(r13, r15)
            if (r0 == r12) goto L_0x01e0
            if (r0 == r11) goto L_0x01e0
            if (r0 == r10) goto L_0x01e0
            if (r0 == r9) goto L_0x01e0
            if (r0 == r8) goto L_0x01e0
            if (r0 == r7) goto L_0x01e0
            if (r0 == r6) goto L_0x01e0
            if (r0 == r5) goto L_0x01e0
            if (r0 == r4) goto L_0x01e0
            if (r0 == r3) goto L_0x01e0
            if (r0 == r2) goto L_0x01e0
            if (r0 == r1) goto L_0x01e0
            switch(r0) {
                case 55: goto L_0x01e0;
                case 56: goto L_0x01e0;
                case 57: goto L_0x01e0;
                case 58: goto L_0x01e0;
                default: goto L_0x01da;
            }
        L_0x01da:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r13)
            goto L_0x01e5
        L_0x01e0:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r13)
        L_0x01e5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeUtils.$$$reportNull$$$0(int):void");
    }

    public static class SpecialType extends DelegatingSimpleType {
        private final String name;

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0044  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static /* synthetic */ void $$$reportNull$$$0(int r9) {
            /*
                r0 = 4
                r1 = 1
                if (r9 == r1) goto L_0x0009
                if (r9 == r0) goto L_0x0009
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto L_0x000b
            L_0x0009:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            L_0x000b:
                r3 = 3
                r4 = 2
                if (r9 == r1) goto L_0x0013
                if (r9 == r0) goto L_0x0013
                r5 = r3
                goto L_0x0014
            L_0x0013:
                r5 = r4
            L_0x0014:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType"
                r7 = 0
                if (r9 == r1) goto L_0x0030
                if (r9 == r4) goto L_0x002b
                if (r9 == r3) goto L_0x0026
                if (r9 == r0) goto L_0x0030
                java.lang.String r8 = "newAnnotations"
                r5[r7] = r8
                goto L_0x0032
            L_0x0026:
                java.lang.String r8 = "kotlinTypeRefiner"
                r5[r7] = r8
                goto L_0x0032
            L_0x002b:
                java.lang.String r8 = "delegate"
                r5[r7] = r8
                goto L_0x0032
            L_0x0030:
                r5[r7] = r6
            L_0x0032:
                java.lang.String r7 = "refine"
                if (r9 == r1) goto L_0x003e
                if (r9 == r0) goto L_0x003b
                r5[r1] = r6
                goto L_0x0042
            L_0x003b:
                r5[r1] = r7
                goto L_0x0042
            L_0x003e:
                java.lang.String r6 = "toString"
                r5[r1] = r6
            L_0x0042:
                if (r9 == r1) goto L_0x0056
                if (r9 == r4) goto L_0x0052
                if (r9 == r3) goto L_0x004f
                if (r9 == r0) goto L_0x0056
                java.lang.String r3 = "replaceAnnotations"
                r5[r4] = r3
                goto L_0x0056
            L_0x004f:
                r5[r4] = r7
                goto L_0x0056
            L_0x0052:
                java.lang.String r3 = "replaceDelegate"
                r5[r4] = r3
            L_0x0056:
                java.lang.String r2 = java.lang.String.format(r2, r5)
                if (r9 == r1) goto L_0x0064
                if (r9 == r0) goto L_0x0064
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r2)
                goto L_0x0069
            L_0x0064:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>(r2)
            L_0x0069:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeUtils.SpecialType.$$$reportNull$$$0(int):void");
        }

        public SpecialType refine(KotlinTypeRefiner kotlinTypeRefiner) {
            if (kotlinTypeRefiner == null) {
                $$$reportNull$$$0(3);
            }
            return this;
        }

        public SpecialType(String str) {
            this.name = str;
        }

        /* access modifiers changed from: protected */
        public SimpleType getDelegate() {
            throw new IllegalStateException(this.name);
        }

        public SimpleType replaceAnnotations(Annotations annotations) {
            if (annotations == null) {
                $$$reportNull$$$0(0);
            }
            throw new IllegalStateException(this.name);
        }

        public SimpleType makeNullableAsSpecified(boolean z) {
            throw new IllegalStateException(this.name);
        }

        public String toString() {
            String str = this.name;
            if (str == null) {
                $$$reportNull$$$0(1);
            }
            return str;
        }

        public DelegatingSimpleType replaceDelegate(SimpleType simpleType) {
            if (simpleType == null) {
                $$$reportNull$$$0(2);
            }
            throw new IllegalStateException(this.name);
        }
    }

    public static boolean noExpectedType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(0);
        }
        return kotlinType == NO_EXPECTED_TYPE || kotlinType == UNIT_EXPECTED_TYPE;
    }

    public static boolean isDontCarePlaceholder(KotlinType kotlinType) {
        return kotlinType != null && kotlinType.getConstructor() == DONT_CARE.getConstructor();
    }

    public static KotlinType makeNullable(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(1);
        }
        return makeNullableAsSpecified(kotlinType, true);
    }

    public static KotlinType makeNotNullable(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(2);
        }
        return makeNullableAsSpecified(kotlinType, false);
    }

    public static KotlinType makeNullableAsSpecified(KotlinType kotlinType, boolean z) {
        if (kotlinType == null) {
            $$$reportNull$$$0(3);
        }
        UnwrappedType makeNullableAsSpecified = kotlinType.unwrap().makeNullableAsSpecified(z);
        if (makeNullableAsSpecified == null) {
            $$$reportNull$$$0(4);
        }
        return makeNullableAsSpecified;
    }

    public static SimpleType makeNullableIfNeeded(SimpleType simpleType, boolean z) {
        if (simpleType == null) {
            $$$reportNull$$$0(5);
        }
        if (z) {
            SimpleType makeNullableAsSpecified = simpleType.makeNullableAsSpecified(true);
            if (makeNullableAsSpecified == null) {
                $$$reportNull$$$0(6);
            }
            return makeNullableAsSpecified;
        }
        if (simpleType == null) {
            $$$reportNull$$$0(7);
        }
        return simpleType;
    }

    public static KotlinType makeNullableIfNeeded(KotlinType kotlinType, boolean z) {
        if (kotlinType == null) {
            $$$reportNull$$$0(8);
        }
        if (z) {
            return makeNullable(kotlinType);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(9);
        }
        return kotlinType;
    }

    public static SimpleType makeUnsubstitutedType(ClassifierDescriptor classifierDescriptor, MemberScope memberScope, Function1<KotlinTypeRefiner, SimpleType> function1) {
        if (!ErrorUtils.isError(classifierDescriptor)) {
            return makeUnsubstitutedType(classifierDescriptor.getTypeConstructor(), memberScope, function1);
        }
        SimpleType createErrorType = ErrorUtils.createErrorType("Unsubstituted type for " + classifierDescriptor);
        if (createErrorType == null) {
            $$$reportNull$$$0(11);
        }
        return createErrorType;
    }

    public static SimpleType makeUnsubstitutedType(TypeConstructor typeConstructor, MemberScope memberScope, Function1<KotlinTypeRefiner, SimpleType> function1) {
        if (typeConstructor == null) {
            $$$reportNull$$$0(12);
        }
        if (memberScope == null) {
            $$$reportNull$$$0(13);
        }
        if (function1 == null) {
            $$$reportNull$$$0(14);
        }
        SimpleType simpleTypeWithNonTrivialMemberScope = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Annotations.Companion.getEMPTY(), typeConstructor, getDefaultTypeProjections(typeConstructor.getParameters()), false, memberScope, function1);
        if (simpleTypeWithNonTrivialMemberScope == null) {
            $$$reportNull$$$0(15);
        }
        return simpleTypeWithNonTrivialMemberScope;
    }

    public static List<TypeProjection> getDefaultTypeProjections(List<TypeParameterDescriptor> list) {
        if (list == null) {
            $$$reportNull$$$0(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (TypeParameterDescriptor defaultType : list) {
            arrayList.add(new TypeProjectionImpl(defaultType.getDefaultType()));
        }
        List<TypeProjection> list2 = CollectionsKt.toList(arrayList);
        if (list2 == null) {
            $$$reportNull$$$0(17);
        }
        return list2;
    }

    public static List<KotlinType> getImmediateSupertypes(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(18);
        }
        TypeSubstitutor create = TypeSubstitutor.create(kotlinType);
        Collection<KotlinType> supertypes = kotlinType.getConstructor().getSupertypes();
        ArrayList arrayList = new ArrayList(supertypes.size());
        for (KotlinType createSubstitutedSupertype : supertypes) {
            KotlinType createSubstitutedSupertype2 = createSubstitutedSupertype(kotlinType, createSubstitutedSupertype, create);
            if (createSubstitutedSupertype2 != null) {
                arrayList.add(createSubstitutedSupertype2);
            }
        }
        return arrayList;
    }

    public static KotlinType createSubstitutedSupertype(KotlinType kotlinType, KotlinType kotlinType2, TypeSubstitutor typeSubstitutor) {
        if (kotlinType == null) {
            $$$reportNull$$$0(20);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(21);
        }
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(22);
        }
        KotlinType substitute = typeSubstitutor.substitute(kotlinType2, Variance.INVARIANT);
        if (substitute != null) {
            return makeNullableIfNeeded(substitute, kotlinType.isMarkedNullable());
        }
        return null;
    }

    public static boolean isNullableType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(27);
        }
        if (kotlinType.isMarkedNullable()) {
            return true;
        }
        if (FlexibleTypesKt.isFlexible(kotlinType) && isNullableType(FlexibleTypesKt.asFlexibleType(kotlinType).getUpperBound())) {
            return true;
        }
        if (isTypeParameter(kotlinType)) {
            return hasNullableSuperType(kotlinType);
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (!(constructor instanceof IntersectionTypeConstructor)) {
            return false;
        }
        for (KotlinType isNullableType : constructor.getSupertypes()) {
            if (isNullableType(isNullableType)) {
                return true;
            }
        }
        return false;
    }

    public static boolean acceptsNullable(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(28);
        }
        if (kotlinType.isMarkedNullable()) {
            return true;
        }
        if (!FlexibleTypesKt.isFlexible(kotlinType) || !acceptsNullable(FlexibleTypesKt.asFlexibleType(kotlinType).getUpperBound())) {
            return false;
        }
        return true;
    }

    public static boolean hasNullableSuperType(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(29);
        }
        if (kotlinType.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
            return false;
        }
        for (KotlinType isNullableType : getImmediateSupertypes(kotlinType)) {
            if (isNullableType(isNullableType)) {
                return true;
            }
        }
        return false;
    }

    public static ClassDescriptor getClassDescriptor(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(30);
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    public static boolean contains(KotlinType kotlinType, Function1<UnwrappedType, Boolean> function1) {
        if (function1 == null) {
            $$$reportNull$$$0(43);
        }
        return contains(kotlinType, function1, new HashSet());
    }

    private static boolean contains(KotlinType kotlinType, Function1<UnwrappedType, Boolean> function1, HashSet<KotlinType> hashSet) {
        if (function1 == null) {
            $$$reportNull$$$0(44);
        }
        if (kotlinType == null || hashSet.contains(kotlinType)) {
            return false;
        }
        hashSet.add(kotlinType);
        UnwrappedType unwrap = kotlinType.unwrap();
        if (function1.invoke(unwrap).booleanValue()) {
            return true;
        }
        FlexibleType flexibleType = unwrap instanceof FlexibleType ? (FlexibleType) unwrap : null;
        if (flexibleType != null && (contains(flexibleType.getLowerBound(), function1, hashSet) || contains(flexibleType.getUpperBound(), function1, hashSet))) {
            return true;
        }
        if ((unwrap instanceof DefinitelyNotNullType) && contains(((DefinitelyNotNullType) unwrap).getOriginal(), function1, hashSet)) {
            return true;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            for (KotlinType contains : ((IntersectionTypeConstructor) constructor).getSupertypes()) {
                if (contains(contains, function1, hashSet)) {
                    return true;
                }
            }
            return false;
        }
        for (TypeProjection next : kotlinType.getArguments()) {
            if (!next.isStarProjection()) {
                if (contains(next.getType(), function1, hashSet)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static TypeProjection makeStarProjection(TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(45);
        }
        return new StarProjectionImpl(typeParameterDescriptor);
    }

    public static boolean isTypeParameter(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(59);
        }
        return getTypeParameterDescriptorOrNull(kotlinType) != null || (kotlinType.getConstructor() instanceof NewTypeVariableConstructor);
    }

    public static TypeParameterDescriptor getTypeParameterDescriptorOrNull(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(62);
        }
        if (kotlinType.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return (TypeParameterDescriptor) kotlinType.getConstructor().getDeclarationDescriptor();
        }
        return null;
    }
}
