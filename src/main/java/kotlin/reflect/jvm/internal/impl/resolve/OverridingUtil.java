package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeCheckerImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

public class OverridingUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final OverridingUtil DEFAULT = new OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, KotlinTypeRefiner.Default.INSTANCE);
    private static final KotlinTypeChecker.TypeConstructorEquality DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = new KotlinTypeChecker.TypeConstructorEquality() {
        /* class kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass1 */

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "a";
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
            if (typeConstructor == null) {
                $$$reportNull$$$0(0);
            }
            if (typeConstructor2 == null) {
                $$$reportNull$$$0(1);
            }
            return typeConstructor.equals(typeConstructor2);
        }
    };
    private static final List<ExternalOverridabilityCondition> EXTERNAL_CONDITIONS = CollectionsKt.toList(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
    /* access modifiers changed from: private */
    public final KotlinTypeChecker.TypeConstructorEquality equalityAxioms;
    private final KotlinTypeRefiner kotlinTypeRefiner;

    /* JADX WARNING: Removed duplicated region for block: B:103:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0057 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0162 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ void $$$reportNull$$$0(int r24) {
        /*
            r0 = r24
            r1 = 41
            r2 = 40
            r3 = 98
            r4 = 93
            r5 = 90
            r6 = 17
            r7 = 12
            r8 = 8
            r9 = 7
            if (r0 == r9) goto L_0x0034
            if (r0 == r8) goto L_0x0034
            if (r0 == r7) goto L_0x0034
            if (r0 == r6) goto L_0x0034
            if (r0 == r5) goto L_0x0034
            if (r0 == r4) goto L_0x0034
            if (r0 == r3) goto L_0x0034
            if (r0 == r2) goto L_0x0034
            if (r0 == r1) goto L_0x0034
            switch(r0) {
                case 20: goto L_0x0034;
                case 21: goto L_0x0034;
                case 22: goto L_0x0034;
                case 23: goto L_0x0034;
                case 24: goto L_0x0034;
                case 25: goto L_0x0034;
                default: goto L_0x0028;
            }
        L_0x0028:
            switch(r0) {
                case 28: goto L_0x0034;
                case 29: goto L_0x0034;
                case 30: goto L_0x0034;
                case 31: goto L_0x0034;
                case 32: goto L_0x0034;
                case 33: goto L_0x0034;
                case 34: goto L_0x0034;
                case 35: goto L_0x0034;
                default: goto L_0x002b;
            }
        L_0x002b:
            switch(r0) {
                case 75: goto L_0x0034;
                case 76: goto L_0x0034;
                case 77: goto L_0x0034;
                case 78: goto L_0x0034;
                case 79: goto L_0x0034;
                default: goto L_0x002e;
            }
        L_0x002e:
            switch(r0) {
                case 85: goto L_0x0034;
                case 86: goto L_0x0034;
                case 87: goto L_0x0034;
                default: goto L_0x0031;
            }
        L_0x0031:
            java.lang.String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L_0x0036
        L_0x0034:
            java.lang.String r10 = "@NotNull method %s.%s must not return null"
        L_0x0036:
            r11 = 2
            if (r0 == r9) goto L_0x0057
            if (r0 == r8) goto L_0x0057
            if (r0 == r7) goto L_0x0057
            if (r0 == r6) goto L_0x0057
            if (r0 == r5) goto L_0x0057
            if (r0 == r4) goto L_0x0057
            if (r0 == r3) goto L_0x0057
            if (r0 == r2) goto L_0x0057
            if (r0 == r1) goto L_0x0057
            switch(r0) {
                case 20: goto L_0x0057;
                case 21: goto L_0x0057;
                case 22: goto L_0x0057;
                case 23: goto L_0x0057;
                case 24: goto L_0x0057;
                case 25: goto L_0x0057;
                default: goto L_0x004c;
            }
        L_0x004c:
            switch(r0) {
                case 28: goto L_0x0057;
                case 29: goto L_0x0057;
                case 30: goto L_0x0057;
                case 31: goto L_0x0057;
                case 32: goto L_0x0057;
                case 33: goto L_0x0057;
                case 34: goto L_0x0057;
                case 35: goto L_0x0057;
                default: goto L_0x004f;
            }
        L_0x004f:
            switch(r0) {
                case 75: goto L_0x0057;
                case 76: goto L_0x0057;
                case 77: goto L_0x0057;
                case 78: goto L_0x0057;
                case 79: goto L_0x0057;
                default: goto L_0x0052;
            }
        L_0x0052:
            switch(r0) {
                case 85: goto L_0x0057;
                case 86: goto L_0x0057;
                case 87: goto L_0x0057;
                default: goto L_0x0055;
            }
        L_0x0055:
            r12 = 3
            goto L_0x0058
        L_0x0057:
            r12 = r11
        L_0x0058:
            java.lang.Object[] r12 = new java.lang.Object[r12]
            java.lang.String r13 = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil"
            r14 = 0
            switch(r0) {
                case 1: goto L_0x0148;
                case 2: goto L_0x0143;
                case 3: goto L_0x0148;
                case 4: goto L_0x013e;
                case 5: goto L_0x013e;
                case 6: goto L_0x0139;
                case 7: goto L_0x0136;
                case 8: goto L_0x0136;
                case 9: goto L_0x0131;
                case 10: goto L_0x012c;
                case 11: goto L_0x0127;
                case 12: goto L_0x0136;
                case 13: goto L_0x0127;
                case 14: goto L_0x0122;
                case 15: goto L_0x011d;
                case 16: goto L_0x0118;
                case 17: goto L_0x0136;
                case 18: goto L_0x011d;
                case 19: goto L_0x0118;
                case 20: goto L_0x0136;
                case 21: goto L_0x0136;
                case 22: goto L_0x0136;
                case 23: goto L_0x0136;
                case 24: goto L_0x0136;
                case 25: goto L_0x0136;
                case 26: goto L_0x011d;
                case 27: goto L_0x0118;
                case 28: goto L_0x0136;
                case 29: goto L_0x0136;
                case 30: goto L_0x0136;
                case 31: goto L_0x0136;
                case 32: goto L_0x0136;
                case 33: goto L_0x0136;
                case 34: goto L_0x0136;
                case 35: goto L_0x0136;
                case 36: goto L_0x011d;
                case 37: goto L_0x0118;
                case 38: goto L_0x0113;
                case 39: goto L_0x010e;
                case 40: goto L_0x0136;
                case 41: goto L_0x0136;
                case 42: goto L_0x0109;
                case 43: goto L_0x0104;
                case 44: goto L_0x00ff;
                case 45: goto L_0x00fa;
                case 46: goto L_0x00f5;
                case 47: goto L_0x00ff;
                case 48: goto L_0x00f0;
                case 49: goto L_0x00ea;
                case 50: goto L_0x00e4;
                case 51: goto L_0x00de;
                case 52: goto L_0x00d8;
                case 53: goto L_0x00d2;
                case 54: goto L_0x00cc;
                case 55: goto L_0x00c6;
                case 56: goto L_0x00c0;
                case 57: goto L_0x00de;
                case 58: goto L_0x00d8;
                case 59: goto L_0x00ba;
                case 60: goto L_0x00de;
                case 61: goto L_0x00ba;
                case 62: goto L_0x00d8;
                case 63: goto L_0x00b4;
                case 64: goto L_0x00ae;
                case 65: goto L_0x00b4;
                case 66: goto L_0x00ae;
                case 67: goto L_0x00a8;
                case 68: goto L_0x00a2;
                case 69: goto L_0x00b4;
                case 70: goto L_0x009c;
                case 71: goto L_0x00ae;
                case 72: goto L_0x0096;
                case 73: goto L_0x0090;
                case 74: goto L_0x008a;
                case 75: goto L_0x0136;
                case 76: goto L_0x0136;
                case 77: goto L_0x0136;
                case 78: goto L_0x0136;
                case 79: goto L_0x0136;
                case 80: goto L_0x0090;
                case 81: goto L_0x00de;
                case 82: goto L_0x00d8;
                case 83: goto L_0x00a2;
                case 84: goto L_0x00de;
                case 85: goto L_0x0136;
                case 86: goto L_0x0136;
                case 87: goto L_0x0136;
                case 88: goto L_0x00a2;
                case 89: goto L_0x0084;
                case 90: goto L_0x0136;
                case 91: goto L_0x00de;
                case 92: goto L_0x007e;
                case 93: goto L_0x0136;
                case 94: goto L_0x0078;
                case 95: goto L_0x0072;
                case 96: goto L_0x008a;
                case 97: goto L_0x006c;
                case 98: goto L_0x0136;
                case 99: goto L_0x0078;
                case 100: goto L_0x0072;
                case 101: goto L_0x00d8;
                case 102: goto L_0x0066;
                case 103: goto L_0x0066;
                case 104: goto L_0x00a2;
                default: goto L_0x0060;
            }
        L_0x0060:
            java.lang.String r15 = "equalityAxioms"
            r12[r14] = r15
            goto L_0x014c
        L_0x0066:
            java.lang.String r15 = "memberDescriptor"
            r12[r14] = r15
            goto L_0x014c
        L_0x006c:
            java.lang.String r15 = "onConflict"
            r12[r14] = r15
            goto L_0x014c
        L_0x0072:
            java.lang.String r15 = "extractFrom"
            r12[r14] = r15
            goto L_0x014c
        L_0x0078:
            java.lang.String r15 = "overrider"
            r12[r14] = r15
            goto L_0x014c
        L_0x007e:
            java.lang.String r15 = "toFilter"
            r12[r14] = r15
            goto L_0x014c
        L_0x0084:
            java.lang.String r15 = "classModality"
            r12[r14] = r15
            goto L_0x014c
        L_0x008a:
            java.lang.String r15 = "descriptorByHandle"
            r12[r14] = r15
            goto L_0x014c
        L_0x0090:
            java.lang.String r15 = "overridables"
            r12[r14] = r15
            goto L_0x014c
        L_0x0096:
            java.lang.String r15 = "bReturnType"
            r12[r14] = r15
            goto L_0x014c
        L_0x009c:
            java.lang.String r15 = "aReturnType"
            r12[r14] = r15
            goto L_0x014c
        L_0x00a2:
            java.lang.String r15 = "descriptors"
            r12[r14] = r15
            goto L_0x014c
        L_0x00a8:
            java.lang.String r15 = "candidate"
            r12[r14] = r15
            goto L_0x014c
        L_0x00ae:
            java.lang.String r15 = "b"
            r12[r14] = r15
            goto L_0x014c
        L_0x00b4:
            java.lang.String r15 = "a"
            r12[r14] = r15
            goto L_0x014c
        L_0x00ba:
            java.lang.String r15 = "notOverridden"
            r12[r14] = r15
            goto L_0x014c
        L_0x00c0:
            java.lang.String r15 = "descriptorsFromSuper"
            r12[r14] = r15
            goto L_0x014c
        L_0x00c6:
            java.lang.String r15 = "fromCurrent"
            r12[r14] = r15
            goto L_0x014c
        L_0x00cc:
            java.lang.String r15 = "fromSuper"
            r12[r14] = r15
            goto L_0x014c
        L_0x00d2:
            java.lang.String r15 = "overriding"
            r12[r14] = r15
            goto L_0x014c
        L_0x00d8:
            java.lang.String r15 = "strategy"
            r12[r14] = r15
            goto L_0x014c
        L_0x00de:
            java.lang.String r15 = "current"
            r12[r14] = r15
            goto L_0x014c
        L_0x00e4:
            java.lang.String r15 = "membersFromCurrent"
            r12[r14] = r15
            goto L_0x014c
        L_0x00ea:
            java.lang.String r15 = "membersFromSupertypes"
            r12[r14] = r15
            goto L_0x014c
        L_0x00f0:
            java.lang.String r15 = "name"
            r12[r14] = r15
            goto L_0x014c
        L_0x00f5:
            java.lang.String r15 = "subTypeParameter"
            r12[r14] = r15
            goto L_0x014c
        L_0x00fa:
            java.lang.String r15 = "superTypeParameter"
            r12[r14] = r15
            goto L_0x014c
        L_0x00ff:
            java.lang.String r15 = "typeChecker"
            r12[r14] = r15
            goto L_0x014c
        L_0x0104:
            java.lang.String r15 = "typeInSub"
            r12[r14] = r15
            goto L_0x014c
        L_0x0109:
            java.lang.String r15 = "typeInSuper"
            r12[r14] = r15
            goto L_0x014c
        L_0x010e:
            java.lang.String r15 = "secondParameters"
            r12[r14] = r15
            goto L_0x014c
        L_0x0113:
            java.lang.String r15 = "firstParameters"
            r12[r14] = r15
            goto L_0x014c
        L_0x0118:
            java.lang.String r15 = "subDescriptor"
            r12[r14] = r15
            goto L_0x014c
        L_0x011d:
            java.lang.String r15 = "superDescriptor"
            r12[r14] = r15
            goto L_0x014c
        L_0x0122:
            java.lang.String r15 = "result"
            r12[r14] = r15
            goto L_0x014c
        L_0x0127:
            java.lang.String r15 = "descriptor"
            r12[r14] = r15
            goto L_0x014c
        L_0x012c:
            java.lang.String r15 = "g"
            r12[r14] = r15
            goto L_0x014c
        L_0x0131:
            java.lang.String r15 = "f"
            r12[r14] = r15
            goto L_0x014c
        L_0x0136:
            r12[r14] = r13
            goto L_0x014c
        L_0x0139:
            java.lang.String r15 = "transformFirst"
            r12[r14] = r15
            goto L_0x014c
        L_0x013e:
            java.lang.String r15 = "candidateSet"
            r12[r14] = r15
            goto L_0x014c
        L_0x0143:
            java.lang.String r15 = "axioms"
            r12[r14] = r15
            goto L_0x014c
        L_0x0148:
            java.lang.String r15 = "kotlinTypeRefiner"
            r12[r14] = r15
        L_0x014c:
            java.lang.String r14 = "filterVisibleFakeOverrides"
            java.lang.String r15 = "getMinimalModality"
            java.lang.String r16 = "determineModalityForFakeOverride"
            java.lang.String r17 = "selectMostSpecificMember"
            java.lang.String r18 = "createTypeChecker"
            java.lang.String r19 = "isOverridableByWithoutExternalConditions"
            java.lang.String r20 = "isOverridableBy"
            java.lang.String r21 = "getOverriddenDeclarations"
            java.lang.String r22 = "filterOverrides"
            r23 = 1
            if (r0 == r9) goto L_0x019e
            if (r0 == r8) goto L_0x019e
            if (r0 == r7) goto L_0x019b
            if (r0 == r6) goto L_0x0198
            if (r0 == r5) goto L_0x0195
            if (r0 == r4) goto L_0x0192
            if (r0 == r3) goto L_0x018d
            if (r0 == r2) goto L_0x018a
            if (r0 == r1) goto L_0x018a
            switch(r0) {
                case 20: goto L_0x0198;
                case 21: goto L_0x0198;
                case 22: goto L_0x0198;
                case 23: goto L_0x0198;
                case 24: goto L_0x0198;
                case 25: goto L_0x0198;
                default: goto L_0x0175;
            }
        L_0x0175:
            switch(r0) {
                case 28: goto L_0x0187;
                case 29: goto L_0x0187;
                case 30: goto L_0x0187;
                case 31: goto L_0x0187;
                case 32: goto L_0x0187;
                case 33: goto L_0x0187;
                case 34: goto L_0x0187;
                case 35: goto L_0x0187;
                default: goto L_0x0178;
            }
        L_0x0178:
            switch(r0) {
                case 75: goto L_0x0184;
                case 76: goto L_0x0184;
                case 77: goto L_0x0184;
                case 78: goto L_0x0184;
                case 79: goto L_0x0184;
                default: goto L_0x017b;
            }
        L_0x017b:
            switch(r0) {
                case 85: goto L_0x0181;
                case 86: goto L_0x0181;
                case 87: goto L_0x0181;
                default: goto L_0x017e;
            }
        L_0x017e:
            r12[r23] = r13
            goto L_0x01a0
        L_0x0181:
            r12[r23] = r16
            goto L_0x01a0
        L_0x0184:
            r12[r23] = r17
            goto L_0x01a0
        L_0x0187:
            r12[r23] = r19
            goto L_0x01a0
        L_0x018a:
            r12[r23] = r18
            goto L_0x01a0
        L_0x018d:
            java.lang.String r13 = "extractMembersOverridableInBothWays"
            r12[r23] = r13
            goto L_0x01a0
        L_0x0192:
            r12[r23] = r14
            goto L_0x01a0
        L_0x0195:
            r12[r23] = r15
            goto L_0x01a0
        L_0x0198:
            r12[r23] = r20
            goto L_0x01a0
        L_0x019b:
            r12[r23] = r21
            goto L_0x01a0
        L_0x019e:
            r12[r23] = r22
        L_0x01a0:
            switch(r0) {
                case 1: goto L_0x0238;
                case 2: goto L_0x0233;
                case 3: goto L_0x0233;
                case 4: goto L_0x022e;
                case 5: goto L_0x022b;
                case 6: goto L_0x022b;
                case 7: goto L_0x023c;
                case 8: goto L_0x023c;
                case 9: goto L_0x0226;
                case 10: goto L_0x0226;
                case 11: goto L_0x0223;
                case 12: goto L_0x023c;
                case 13: goto L_0x021e;
                case 14: goto L_0x021e;
                case 15: goto L_0x021b;
                case 16: goto L_0x021b;
                case 17: goto L_0x023c;
                case 18: goto L_0x021b;
                case 19: goto L_0x021b;
                case 20: goto L_0x023c;
                case 21: goto L_0x023c;
                case 22: goto L_0x023c;
                case 23: goto L_0x023c;
                case 24: goto L_0x023c;
                case 25: goto L_0x023c;
                case 26: goto L_0x0218;
                case 27: goto L_0x0218;
                case 28: goto L_0x023c;
                case 29: goto L_0x023c;
                case 30: goto L_0x023c;
                case 31: goto L_0x023c;
                case 32: goto L_0x023c;
                case 33: goto L_0x023c;
                case 34: goto L_0x023c;
                case 35: goto L_0x023c;
                case 36: goto L_0x0213;
                case 37: goto L_0x0213;
                case 38: goto L_0x0210;
                case 39: goto L_0x0210;
                case 40: goto L_0x023c;
                case 41: goto L_0x023c;
                case 42: goto L_0x020b;
                case 43: goto L_0x020b;
                case 44: goto L_0x020b;
                case 45: goto L_0x0206;
                case 46: goto L_0x0206;
                case 47: goto L_0x0206;
                case 48: goto L_0x0201;
                case 49: goto L_0x0201;
                case 50: goto L_0x0201;
                case 51: goto L_0x0201;
                case 52: goto L_0x0201;
                case 53: goto L_0x01fc;
                case 54: goto L_0x01fc;
                case 55: goto L_0x01f7;
                case 56: goto L_0x01f7;
                case 57: goto L_0x01f7;
                case 58: goto L_0x01f7;
                case 59: goto L_0x01f2;
                case 60: goto L_0x01ed;
                case 61: goto L_0x01ed;
                case 62: goto L_0x01ed;
                case 63: goto L_0x01e8;
                case 64: goto L_0x01e8;
                case 65: goto L_0x01e3;
                case 66: goto L_0x01e3;
                case 67: goto L_0x01dd;
                case 68: goto L_0x01dd;
                case 69: goto L_0x01d7;
                case 70: goto L_0x01d7;
                case 71: goto L_0x01d7;
                case 72: goto L_0x01d7;
                case 73: goto L_0x01d3;
                case 74: goto L_0x01d3;
                case 75: goto L_0x023c;
                case 76: goto L_0x023c;
                case 77: goto L_0x023c;
                case 78: goto L_0x023c;
                case 79: goto L_0x023c;
                case 80: goto L_0x01cd;
                case 81: goto L_0x01cd;
                case 82: goto L_0x01cd;
                case 83: goto L_0x01c9;
                case 84: goto L_0x01c9;
                case 85: goto L_0x023c;
                case 86: goto L_0x023c;
                case 87: goto L_0x023c;
                case 88: goto L_0x01c5;
                case 89: goto L_0x01c5;
                case 90: goto L_0x023c;
                case 91: goto L_0x01c1;
                case 92: goto L_0x01c1;
                case 93: goto L_0x023c;
                case 94: goto L_0x01bb;
                case 95: goto L_0x01bb;
                case 96: goto L_0x01bb;
                case 97: goto L_0x01bb;
                case 98: goto L_0x023c;
                case 99: goto L_0x01bb;
                case 100: goto L_0x01bb;
                case 101: goto L_0x01bb;
                case 102: goto L_0x01b5;
                case 103: goto L_0x01af;
                case 104: goto L_0x01a9;
                default: goto L_0x01a3;
            }
        L_0x01a3:
            java.lang.String r13 = "createWithEqualityAxioms"
            r12[r11] = r13
            goto L_0x023c
        L_0x01a9:
            java.lang.String r13 = "findMaxVisibility"
            r12[r11] = r13
            goto L_0x023c
        L_0x01af:
            java.lang.String r13 = "computeVisibilityToInherit"
            r12[r11] = r13
            goto L_0x023c
        L_0x01b5:
            java.lang.String r13 = "resolveUnknownVisibilityForMember"
            r12[r11] = r13
            goto L_0x023c
        L_0x01bb:
            java.lang.String r13 = "extractMembersOverridableInBothWays"
            r12[r11] = r13
            goto L_0x023c
        L_0x01c1:
            r12[r11] = r14
            goto L_0x023c
        L_0x01c5:
            r12[r11] = r15
            goto L_0x023c
        L_0x01c9:
            r12[r11] = r16
            goto L_0x023c
        L_0x01cd:
            java.lang.String r13 = "createAndBindFakeOverride"
            r12[r11] = r13
            goto L_0x023c
        L_0x01d3:
            r12[r11] = r17
            goto L_0x023c
        L_0x01d7:
            java.lang.String r13 = "isReturnTypeMoreSpecific"
            r12[r11] = r13
            goto L_0x023c
        L_0x01dd:
            java.lang.String r13 = "isMoreSpecificThenAllOf"
            r12[r11] = r13
            goto L_0x023c
        L_0x01e3:
            java.lang.String r13 = "isVisibilityMoreSpecific"
            r12[r11] = r13
            goto L_0x023c
        L_0x01e8:
            java.lang.String r13 = "isMoreSpecific"
            r12[r11] = r13
            goto L_0x023c
        L_0x01ed:
            java.lang.String r13 = "createAndBindFakeOverrides"
            r12[r11] = r13
            goto L_0x023c
        L_0x01f2:
            java.lang.String r13 = "allHasSameContainingDeclaration"
            r12[r11] = r13
            goto L_0x023c
        L_0x01f7:
            java.lang.String r13 = "extractAndBindOverridesForMember"
            r12[r11] = r13
            goto L_0x023c
        L_0x01fc:
            java.lang.String r13 = "isVisibleForOverride"
            r12[r11] = r13
            goto L_0x023c
        L_0x0201:
            java.lang.String r13 = "generateOverridesInFunctionGroup"
            r12[r11] = r13
            goto L_0x023c
        L_0x0206:
            java.lang.String r13 = "areTypeParametersEquivalent"
            r12[r11] = r13
            goto L_0x023c
        L_0x020b:
            java.lang.String r13 = "areTypesEquivalent"
            r12[r11] = r13
            goto L_0x023c
        L_0x0210:
            r12[r11] = r18
            goto L_0x023c
        L_0x0213:
            java.lang.String r13 = "getBasicOverridabilityProblem"
            r12[r11] = r13
            goto L_0x023c
        L_0x0218:
            r12[r11] = r19
            goto L_0x023c
        L_0x021b:
            r12[r11] = r20
            goto L_0x023c
        L_0x021e:
            java.lang.String r13 = "collectOverriddenDeclarations"
            r12[r11] = r13
            goto L_0x023c
        L_0x0223:
            r12[r11] = r21
            goto L_0x023c
        L_0x0226:
            java.lang.String r13 = "overrides"
            r12[r11] = r13
            goto L_0x023c
        L_0x022b:
            r12[r11] = r22
            goto L_0x023c
        L_0x022e:
            java.lang.String r13 = "filterOutOverridden"
            r12[r11] = r13
            goto L_0x023c
        L_0x0233:
            java.lang.String r13 = "<init>"
            r12[r11] = r13
            goto L_0x023c
        L_0x0238:
            java.lang.String r13 = "createWithTypeRefiner"
            r12[r11] = r13
        L_0x023c:
            java.lang.String r10 = java.lang.String.format(r10, r12)
            if (r0 == r9) goto L_0x0264
            if (r0 == r8) goto L_0x0264
            if (r0 == r7) goto L_0x0264
            if (r0 == r6) goto L_0x0264
            if (r0 == r5) goto L_0x0264
            if (r0 == r4) goto L_0x0264
            if (r0 == r3) goto L_0x0264
            if (r0 == r2) goto L_0x0264
            if (r0 == r1) goto L_0x0264
            switch(r0) {
                case 20: goto L_0x0264;
                case 21: goto L_0x0264;
                case 22: goto L_0x0264;
                case 23: goto L_0x0264;
                case 24: goto L_0x0264;
                case 25: goto L_0x0264;
                default: goto L_0x0255;
            }
        L_0x0255:
            switch(r0) {
                case 28: goto L_0x0264;
                case 29: goto L_0x0264;
                case 30: goto L_0x0264;
                case 31: goto L_0x0264;
                case 32: goto L_0x0264;
                case 33: goto L_0x0264;
                case 34: goto L_0x0264;
                case 35: goto L_0x0264;
                default: goto L_0x0258;
            }
        L_0x0258:
            switch(r0) {
                case 75: goto L_0x0264;
                case 76: goto L_0x0264;
                case 77: goto L_0x0264;
                case 78: goto L_0x0264;
                case 79: goto L_0x0264;
                default: goto L_0x025b;
            }
        L_0x025b:
            switch(r0) {
                case 85: goto L_0x0264;
                case 86: goto L_0x0264;
                case 87: goto L_0x0264;
                default: goto L_0x025e;
            }
        L_0x025e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r10)
            goto L_0x0269
        L_0x0264:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r10)
        L_0x0269:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.$$$reportNull$$$0(int):void");
    }

    public static OverridingUtil createWithEqualityAxioms(KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality) {
        if (typeConstructorEquality == null) {
            $$$reportNull$$$0(0);
        }
        return new OverridingUtil(typeConstructorEquality, KotlinTypeRefiner.Default.INSTANCE);
    }

    public static OverridingUtil createWithTypeRefiner(KotlinTypeRefiner kotlinTypeRefiner2) {
        if (kotlinTypeRefiner2 == null) {
            $$$reportNull$$$0(1);
        }
        return new OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, kotlinTypeRefiner2);
    }

    private OverridingUtil(KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality, KotlinTypeRefiner kotlinTypeRefiner2) {
        if (typeConstructorEquality == null) {
            $$$reportNull$$$0(2);
        }
        if (kotlinTypeRefiner2 == null) {
            $$$reportNull$$$0(3);
        }
        this.equalityAxioms = typeConstructorEquality;
        this.kotlinTypeRefiner = kotlinTypeRefiner2;
    }

    public static <D extends CallableDescriptor> Set<D> filterOutOverridden(Set<D> set) {
        if (set == null) {
            $$$reportNull$$$0(4);
        }
        return filterOverrides(set, !set.isEmpty() && DescriptorUtilsKt.isTypeRefinementEnabled(DescriptorUtilsKt.getModule((DeclarationDescriptor) set.iterator().next())), new Function2<D, D, Pair<CallableDescriptor, CallableDescriptor>>() {
            /* class kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass2 */

            public Pair<CallableDescriptor, CallableDescriptor> invoke(D d, D d2) {
                return new Pair<>(d, d2);
            }
        });
    }

    public static <D> Set<D> filterOverrides(Set<D> set, boolean z, Function2<? super D, ? super D, Pair<CallableDescriptor, CallableDescriptor>> function2) {
        if (set == null) {
            $$$reportNull$$$0(5);
        }
        if (function2 == null) {
            $$$reportNull$$$0(6);
        }
        if (set.size() <= 1) {
            if (set == null) {
                $$$reportNull$$$0(7);
            }
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (D next : set) {
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedHashSet.add(next);
                    break;
                }
                Pair invoke = function2.invoke(next, it.next());
                CallableDescriptor callableDescriptor = (CallableDescriptor) invoke.component1();
                CallableDescriptor callableDescriptor2 = (CallableDescriptor) invoke.component2();
                if (overrides(callableDescriptor, callableDescriptor2, z)) {
                    it.remove();
                } else if (overrides(callableDescriptor2, callableDescriptor, z)) {
                    break;
                }
            }
        }
        return linkedHashSet;
    }

    public static <D extends CallableDescriptor> boolean overrides(D d, D d2, boolean z) {
        if (d == null) {
            $$$reportNull$$$0(9);
        }
        if (d2 == null) {
            $$$reportNull$$$0(10);
        }
        if (!d.equals(d2) && DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(d.getOriginal(), d2.getOriginal(), z)) {
            return true;
        }
        CallableDescriptor original = d2.getOriginal();
        for (CallableDescriptor areEquivalent : DescriptorUtils.getAllOverriddenDescriptors(d)) {
            if (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(original, areEquivalent, z)) {
                return true;
            }
        }
        return false;
    }

    public static Set<CallableMemberDescriptor> getOverriddenDeclarations(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(11);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        collectOverriddenDeclarations(callableMemberDescriptor, linkedHashSet);
        return linkedHashSet;
    }

    private static void collectOverriddenDeclarations(CallableMemberDescriptor callableMemberDescriptor, Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(13);
        }
        if (set == null) {
            $$$reportNull$$$0(14);
        }
        if (callableMemberDescriptor.getKind().isReal()) {
            set.add(callableMemberDescriptor);
        } else if (!callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) {
            for (CallableMemberDescriptor collectOverriddenDeclarations : callableMemberDescriptor.getOverriddenDescriptors()) {
                collectOverriddenDeclarations(collectOverriddenDeclarations, set);
            }
        } else {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(15);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(16);
        }
        OverrideCompatibilityInfo isOverridableBy = isOverridableBy(callableDescriptor, callableDescriptor2, classDescriptor, false);
        if (isOverridableBy == null) {
            $$$reportNull$$$0(17);
        }
        return isOverridableBy;
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor, boolean z) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(18);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(19);
        }
        OverrideCompatibilityInfo isOverridableByWithoutExternalConditions = isOverridableByWithoutExternalConditions(callableDescriptor, callableDescriptor2, z);
        boolean z2 = isOverridableByWithoutExternalConditions.getResult() == OverrideCompatibilityInfo.Result.OVERRIDABLE;
        for (ExternalOverridabilityCondition next : EXTERNAL_CONDITIONS) {
            if (next.getContract() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY && (!z2 || next.getContract() != ExternalOverridabilityCondition.Contract.SUCCESS_ONLY)) {
                int i = AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[next.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal()];
                if (i == 1) {
                    z2 = true;
                } else if (i == 2) {
                    OverrideCompatibilityInfo conflict = OverrideCompatibilityInfo.conflict("External condition failed");
                    if (conflict == null) {
                        $$$reportNull$$$0(20);
                    }
                    return conflict;
                } else if (i == 3) {
                    OverrideCompatibilityInfo incompatible = OverrideCompatibilityInfo.incompatible("External condition");
                    if (incompatible == null) {
                        $$$reportNull$$$0(21);
                    }
                    return incompatible;
                }
            }
        }
        if (!z2) {
            if (isOverridableByWithoutExternalConditions == null) {
                $$$reportNull$$$0(22);
            }
            return isOverridableByWithoutExternalConditions;
        }
        for (ExternalOverridabilityCondition next2 : EXTERNAL_CONDITIONS) {
            if (next2.getContract() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) {
                int i2 = AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[next2.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal()];
                if (i2 == 1) {
                    throw new IllegalStateException("Contract violation in " + next2.getClass().getName() + " condition. It's not supposed to end with success");
                } else if (i2 == 2) {
                    OverrideCompatibilityInfo conflict2 = OverrideCompatibilityInfo.conflict("External condition failed");
                    if (conflict2 == null) {
                        $$$reportNull$$$0(23);
                    }
                    return conflict2;
                } else if (i2 == 3) {
                    OverrideCompatibilityInfo incompatible2 = OverrideCompatibilityInfo.incompatible("External condition");
                    if (incompatible2 == null) {
                        $$$reportNull$$$0(24);
                    }
                    return incompatible2;
                }
            }
        }
        OverrideCompatibilityInfo success = OverrideCompatibilityInfo.success();
        if (success == null) {
            $$$reportNull$$$0(25);
        }
        return success;
    }

    public OverrideCompatibilityInfo isOverridableByWithoutExternalConditions(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(26);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(27);
        }
        OverrideCompatibilityInfo basicOverridabilityProblem = getBasicOverridabilityProblem(callableDescriptor, callableDescriptor2);
        if (basicOverridabilityProblem != null) {
            if (basicOverridabilityProblem == null) {
                $$$reportNull$$$0(28);
            }
            return basicOverridabilityProblem;
        }
        List<KotlinType> compiledValueParameters = compiledValueParameters(callableDescriptor);
        List<KotlinType> compiledValueParameters2 = compiledValueParameters(callableDescriptor2);
        List<TypeParameterDescriptor> typeParameters = callableDescriptor.getTypeParameters();
        List<TypeParameterDescriptor> typeParameters2 = callableDescriptor2.getTypeParameters();
        int i = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i < compiledValueParameters.size()) {
                if (!KotlinTypeChecker.DEFAULT.equalTypes(compiledValueParameters.get(i), compiledValueParameters2.get(i))) {
                    OverrideCompatibilityInfo incompatible = OverrideCompatibilityInfo.incompatible("Type parameter number mismatch");
                    if (incompatible == null) {
                        $$$reportNull$$$0(29);
                    }
                    return incompatible;
                }
                i++;
            }
            OverrideCompatibilityInfo conflict = OverrideCompatibilityInfo.conflict("Type parameter number mismatch");
            if (conflict == null) {
                $$$reportNull$$$0(30);
            }
            return conflict;
        }
        KotlinTypeChecker createTypeChecker = createTypeChecker(typeParameters, typeParameters2);
        for (int i2 = 0; i2 < typeParameters.size(); i2++) {
            if (!areTypeParametersEquivalent(typeParameters.get(i2), typeParameters2.get(i2), createTypeChecker)) {
                OverrideCompatibilityInfo incompatible2 = OverrideCompatibilityInfo.incompatible("Type parameter bounds mismatch");
                if (incompatible2 == null) {
                    $$$reportNull$$$0(31);
                }
                return incompatible2;
            }
        }
        for (int i3 = 0; i3 < compiledValueParameters.size(); i3++) {
            if (!areTypesEquivalent(compiledValueParameters.get(i3), compiledValueParameters2.get(i3), createTypeChecker)) {
                OverrideCompatibilityInfo incompatible3 = OverrideCompatibilityInfo.incompatible("Value parameter type mismatch");
                if (incompatible3 == null) {
                    $$$reportNull$$$0(32);
                }
                return incompatible3;
            }
        }
        if (!(callableDescriptor instanceof FunctionDescriptor) || !(callableDescriptor2 instanceof FunctionDescriptor) || ((FunctionDescriptor) callableDescriptor).isSuspend() == ((FunctionDescriptor) callableDescriptor2).isSuspend()) {
            if (z) {
                KotlinType returnType = callableDescriptor.getReturnType();
                KotlinType returnType2 = callableDescriptor2.getReturnType();
                if (!(returnType == null || returnType2 == null)) {
                    if (KotlinTypeKt.isError(returnType2) && KotlinTypeKt.isError(returnType)) {
                        i = 1;
                    }
                    if (i == 0 && !createTypeChecker.isSubtypeOf(this.kotlinTypeRefiner.refineType(returnType2), this.kotlinTypeRefiner.refineType(returnType))) {
                        OverrideCompatibilityInfo conflict2 = OverrideCompatibilityInfo.conflict("Return type mismatch");
                        if (conflict2 == null) {
                            $$$reportNull$$$0(34);
                        }
                        return conflict2;
                    }
                }
            }
            OverrideCompatibilityInfo success = OverrideCompatibilityInfo.success();
            if (success == null) {
                $$$reportNull$$$0(35);
            }
            return success;
        }
        OverrideCompatibilityInfo conflict3 = OverrideCompatibilityInfo.conflict("Incompatible suspendability");
        if (conflict3 == null) {
            $$$reportNull$$$0(33);
        }
        return conflict3;
    }

    public static OverrideCompatibilityInfo getBasicOverridabilityProblem(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        boolean z;
        if (callableDescriptor == null) {
            $$$reportNull$$$0(36);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(37);
        }
        boolean z2 = callableDescriptor instanceof FunctionDescriptor;
        if ((z2 && !(callableDescriptor2 instanceof FunctionDescriptor)) || (((z = callableDescriptor instanceof PropertyDescriptor)) && !(callableDescriptor2 instanceof PropertyDescriptor))) {
            return OverrideCompatibilityInfo.incompatible("Member kind mismatch");
        }
        if (!z2 && !z) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + callableDescriptor);
        } else if (!callableDescriptor.getName().equals(callableDescriptor2.getName())) {
            return OverrideCompatibilityInfo.incompatible("Name mismatch");
        } else {
            OverrideCompatibilityInfo checkReceiverAndParameterCount = checkReceiverAndParameterCount(callableDescriptor, callableDescriptor2);
            if (checkReceiverAndParameterCount != null) {
                return checkReceiverAndParameterCount;
            }
            return null;
        }
    }

    private KotlinTypeChecker createTypeChecker(List<TypeParameterDescriptor> list, List<TypeParameterDescriptor> list2) {
        if (list == null) {
            $$$reportNull$$$0(38);
        }
        if (list2 == null) {
            $$$reportNull$$$0(39);
        }
        if (list.isEmpty()) {
            KotlinTypeChecker withAxioms = KotlinTypeCheckerImpl.withAxioms(this.equalityAxioms);
            if (withAxioms == null) {
                $$$reportNull$$$0(40);
            }
            return withAxioms;
        }
        final HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            hashMap.put(list.get(i).getTypeConstructor(), list2.get(i).getTypeConstructor());
        }
        KotlinTypeChecker withAxioms2 = KotlinTypeCheckerImpl.withAxioms(new KotlinTypeChecker.TypeConstructorEquality() {
            /* class kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass3 */

            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                Object[] objArr = new Object[3];
                if (i != 1) {
                    objArr[0] = "a";
                } else {
                    objArr[0] = "b";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$3";
                objArr[2] = "equals";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            public boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
                if (typeConstructor == null) {
                    $$$reportNull$$$0(0);
                }
                if (typeConstructor2 == null) {
                    $$$reportNull$$$0(1);
                }
                if (OverridingUtil.this.equalityAxioms.equals(typeConstructor, typeConstructor2)) {
                    return true;
                }
                TypeConstructor typeConstructor3 = (TypeConstructor) hashMap.get(typeConstructor);
                TypeConstructor typeConstructor4 = (TypeConstructor) hashMap.get(typeConstructor2);
                if ((typeConstructor3 == null || !typeConstructor3.equals(typeConstructor2)) && (typeConstructor4 == null || !typeConstructor4.equals(typeConstructor))) {
                    return false;
                }
                return true;
            }
        });
        if (withAxioms2 == null) {
            $$$reportNull$$$0(41);
        }
        return withAxioms2;
    }

    private static OverrideCompatibilityInfo checkReceiverAndParameterCount(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        boolean z = true;
        boolean z2 = callableDescriptor.getExtensionReceiverParameter() == null;
        if (callableDescriptor2.getExtensionReceiverParameter() != null) {
            z = false;
        }
        if (z2 != z) {
            return OverrideCompatibilityInfo.incompatible("Receiver presence mismatch");
        }
        if (callableDescriptor.getValueParameters().size() != callableDescriptor2.getValueParameters().size()) {
            return OverrideCompatibilityInfo.incompatible("Value parameter number mismatch");
        }
        return null;
    }

    private boolean areTypesEquivalent(KotlinType kotlinType, KotlinType kotlinType2, KotlinTypeChecker kotlinTypeChecker) {
        if (kotlinType == null) {
            $$$reportNull$$$0(42);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(43);
        }
        if (kotlinTypeChecker == null) {
            $$$reportNull$$$0(44);
        }
        if (KotlinTypeKt.isError(kotlinType) && KotlinTypeKt.isError(kotlinType2)) {
            return true;
        }
        return kotlinTypeChecker.equalTypes(this.kotlinTypeRefiner.refineType(kotlinType), this.kotlinTypeRefiner.refineType(kotlinType2));
    }

    private boolean areTypeParametersEquivalent(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, KotlinTypeChecker kotlinTypeChecker) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(45);
        }
        if (typeParameterDescriptor2 == null) {
            $$$reportNull$$$0(46);
        }
        if (kotlinTypeChecker == null) {
            $$$reportNull$$$0(47);
        }
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        ArrayList arrayList = new ArrayList(typeParameterDescriptor2.getUpperBounds());
        if (upperBounds.size() != arrayList.size()) {
            return false;
        }
        for (KotlinType next : upperBounds) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (areTypesEquivalent(next, (KotlinType) listIterator.next(), kotlinTypeChecker)) {
                    listIterator.remove();
                }
            }
            return false;
        }
        return true;
    }

    private static List<KotlinType> compiledValueParameters(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        ArrayList arrayList = new ArrayList();
        if (extensionReceiverParameter != null) {
            arrayList.add(extensionReceiverParameter.getType());
        }
        for (ValueParameterDescriptor type : callableDescriptor.getValueParameters()) {
            arrayList.add(type.getType());
        }
        return arrayList;
    }

    public void generateOverridesInFunctionGroup(Name name, Collection<? extends CallableMemberDescriptor> collection, Collection<? extends CallableMemberDescriptor> collection2, ClassDescriptor classDescriptor, OverridingStrategy overridingStrategy) {
        if (name == null) {
            $$$reportNull$$$0(48);
        }
        if (collection == null) {
            $$$reportNull$$$0(49);
        }
        if (collection2 == null) {
            $$$reportNull$$$0(50);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(51);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(52);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        for (CallableMemberDescriptor extractAndBindOverridesForMember : collection2) {
            linkedHashSet.removeAll(extractAndBindOverridesForMember(extractAndBindOverridesForMember, collection, classDescriptor, overridingStrategy));
        }
        createAndBindFakeOverrides(classDescriptor, linkedHashSet, overridingStrategy);
    }

    public static boolean isVisibleForOverride(MemberDescriptor memberDescriptor, MemberDescriptor memberDescriptor2) {
        if (memberDescriptor == null) {
            $$$reportNull$$$0(53);
        }
        if (memberDescriptor2 == null) {
            $$$reportNull$$$0(54);
        }
        return !Visibilities.isPrivate(memberDescriptor2.getVisibility()) && Visibilities.isVisibleIgnoringReceiver(memberDescriptor2, memberDescriptor);
    }

    private Collection<CallableMemberDescriptor> extractAndBindOverridesForMember(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection, ClassDescriptor classDescriptor, OverridingStrategy overridingStrategy) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(55);
        }
        if (collection == null) {
            $$$reportNull$$$0(56);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(57);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(58);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        SmartSet create = SmartSet.create();
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            OverrideCompatibilityInfo.Result result = isOverridableBy(callableMemberDescriptor2, callableMemberDescriptor, classDescriptor).getResult();
            boolean isVisibleForOverride = isVisibleForOverride(callableMemberDescriptor, callableMemberDescriptor2);
            int i = AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[result.ordinal()];
            if (i == 1) {
                if (isVisibleForOverride) {
                    create.add(callableMemberDescriptor2);
                }
                arrayList.add(callableMemberDescriptor2);
            } else if (i == 2) {
                if (isVisibleForOverride) {
                    overridingStrategy.overrideConflict(callableMemberDescriptor2, callableMemberDescriptor);
                }
                arrayList.add(callableMemberDescriptor2);
            }
        }
        overridingStrategy.setOverriddenDescriptors(callableMemberDescriptor, create);
        return arrayList;
    }

    private static boolean allHasSameContainingDeclaration(Collection<CallableMemberDescriptor> collection) {
        if (collection == null) {
            $$$reportNull$$$0(59);
        }
        if (collection.size() < 2) {
            return true;
        }
        final DeclarationDescriptor containingDeclaration = collection.iterator().next().getContainingDeclaration();
        return CollectionsKt.all(collection, new Function1<CallableMemberDescriptor, Boolean>() {
            /* class kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass4 */

            public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return Boolean.valueOf(callableMemberDescriptor.getContainingDeclaration() == containingDeclaration);
            }
        });
    }

    private static void createAndBindFakeOverrides(ClassDescriptor classDescriptor, Collection<CallableMemberDescriptor> collection, OverridingStrategy overridingStrategy) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(60);
        }
        if (collection == null) {
            $$$reportNull$$$0(61);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(62);
        }
        if (allHasSameContainingDeclaration(collection)) {
            for (CallableMemberDescriptor singleton : collection) {
                createAndBindFakeOverride(Collections.singleton(singleton), classDescriptor, overridingStrategy);
            }
            return;
        }
        LinkedList linkedList = new LinkedList(collection);
        while (!linkedList.isEmpty()) {
            createAndBindFakeOverride(extractMembersOverridableInBothWays(VisibilityUtilKt.findMemberWithMaxVisibility(linkedList), linkedList, overridingStrategy), classDescriptor, overridingStrategy);
        }
    }

    public static boolean isMoreSpecific(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(63);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(64);
        }
        KotlinType returnType = callableDescriptor.getReturnType();
        KotlinType returnType2 = callableDescriptor2.getReturnType();
        if (!isVisibilityMoreSpecific(callableDescriptor, callableDescriptor2)) {
            return false;
        }
        if (callableDescriptor instanceof FunctionDescriptor) {
            return isReturnTypeMoreSpecific(callableDescriptor, returnType, callableDescriptor2, returnType2);
        }
        if (callableDescriptor instanceof PropertyDescriptor) {
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor;
            PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor2;
            if (!isAccessorMoreSpecific(propertyDescriptor.getSetter(), propertyDescriptor2.getSetter())) {
                return false;
            }
            if (propertyDescriptor.isVar() && propertyDescriptor2.isVar()) {
                return DEFAULT.createTypeChecker(callableDescriptor.getTypeParameters(), callableDescriptor2.getTypeParameters()).equalTypes(returnType, returnType2);
            }
            if ((propertyDescriptor.isVar() || !propertyDescriptor2.isVar()) && isReturnTypeMoreSpecific(callableDescriptor, returnType, callableDescriptor2, returnType2)) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Unexpected callable: " + callableDescriptor.getClass());
    }

    private static boolean isVisibilityMoreSpecific(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2) {
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(65);
        }
        if (declarationDescriptorWithVisibility2 == null) {
            $$$reportNull$$$0(66);
        }
        Integer compare = Visibilities.compare(declarationDescriptorWithVisibility.getVisibility(), declarationDescriptorWithVisibility2.getVisibility());
        return compare == null || compare.intValue() >= 0;
    }

    private static boolean isAccessorMoreSpecific(PropertyAccessorDescriptor propertyAccessorDescriptor, PropertyAccessorDescriptor propertyAccessorDescriptor2) {
        if (propertyAccessorDescriptor == null || propertyAccessorDescriptor2 == null) {
            return true;
        }
        return isVisibilityMoreSpecific(propertyAccessorDescriptor, propertyAccessorDescriptor2);
    }

    private static boolean isMoreSpecificThenAllOf(CallableDescriptor callableDescriptor, Collection<CallableDescriptor> collection) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(67);
        }
        if (collection == null) {
            $$$reportNull$$$0(68);
        }
        for (CallableDescriptor isMoreSpecific : collection) {
            if (!isMoreSpecific(callableDescriptor, isMoreSpecific)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isReturnTypeMoreSpecific(CallableDescriptor callableDescriptor, KotlinType kotlinType, CallableDescriptor callableDescriptor2, KotlinType kotlinType2) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(69);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(70);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(71);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(72);
        }
        return DEFAULT.createTypeChecker(callableDescriptor.getTypeParameters(), callableDescriptor2.getTypeParameters()).isSubtypeOf(kotlinType, kotlinType2);
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [kotlin.jvm.functions.Function1<H, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor>, kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <H> H selectMostSpecificMember(java.util.Collection<H> r8, kotlin.jvm.functions.Function1<H, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> r9) {
        /*
            if (r8 != 0) goto L_0x0007
            r0 = 73
            $$$reportNull$$$0(r0)
        L_0x0007:
            if (r9 != 0) goto L_0x000e
            r0 = 74
            $$$reportNull$$$0(r0)
        L_0x000e:
            int r0 = r8.size()
            r1 = 1
            if (r0 != r1) goto L_0x0021
            java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r8)
            if (r8 != 0) goto L_0x0020
            r9 = 75
            $$$reportNull$$$0(r9)
        L_0x0020:
            return r8
        L_0x0021:
            java.util.ArrayList r0 = new java.util.ArrayList
            r2 = 2
            r0.<init>(r2)
            java.util.List r2 = kotlin.collections.CollectionsKt.map(r8, r9)
            java.lang.Object r3 = kotlin.collections.CollectionsKt.first(r8)
            java.lang.Object r4 = r9.invoke(r3)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r4
            java.util.Iterator r8 = r8.iterator()
        L_0x0039:
            boolean r5 = r8.hasNext()
            if (r5 == 0) goto L_0x0060
            java.lang.Object r5 = r8.next()
            java.lang.Object r6 = r9.invoke(r5)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r6
            boolean r7 = isMoreSpecificThenAllOf(r6, r2)
            if (r7 == 0) goto L_0x0052
            r0.add(r5)
        L_0x0052:
            boolean r7 = isMoreSpecific(r6, r4)
            if (r7 == 0) goto L_0x0039
            boolean r6 = isMoreSpecific(r4, r6)
            if (r6 != 0) goto L_0x0039
            r3 = r5
            goto L_0x0039
        L_0x0060:
            boolean r8 = r0.isEmpty()
            if (r8 == 0) goto L_0x006e
            if (r3 != 0) goto L_0x006d
            r8 = 76
            $$$reportNull$$$0(r8)
        L_0x006d:
            return r3
        L_0x006e:
            int r8 = r0.size()
            if (r8 != r1) goto L_0x0080
            java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r0)
            if (r8 != 0) goto L_0x007f
            r9 = 77
            $$$reportNull$$$0(r9)
        L_0x007f:
            return r8
        L_0x0080:
            r8 = 0
            java.util.Iterator r1 = r0.iterator()
        L_0x0085:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00a0
            java.lang.Object r2 = r1.next()
            java.lang.Object r3 = r9.invoke(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r3
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r3.getReturnType()
            boolean r3 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.isFlexible(r3)
            if (r3 != 0) goto L_0x0085
            r8 = r2
        L_0x00a0:
            if (r8 == 0) goto L_0x00aa
            if (r8 != 0) goto L_0x00a9
            r9 = 78
            $$$reportNull$$$0(r9)
        L_0x00a9:
            return r8
        L_0x00aa:
            java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r0)
            if (r8 != 0) goto L_0x00b5
            r9 = 79
            $$$reportNull$$$0(r9)
        L_0x00b5:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.selectMostSpecificMember(java.util.Collection, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    private static void createAndBindFakeOverride(Collection<CallableMemberDescriptor> collection, ClassDescriptor classDescriptor, OverridingStrategy overridingStrategy) {
        if (collection == null) {
            $$$reportNull$$$0(80);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(81);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(82);
        }
        Collection<CallableMemberDescriptor> filterVisibleFakeOverrides = filterVisibleFakeOverrides(classDescriptor, collection);
        boolean isEmpty = filterVisibleFakeOverrides.isEmpty();
        if (!isEmpty) {
            collection = filterVisibleFakeOverrides;
        }
        CallableMemberDescriptor copy = ((CallableMemberDescriptor) selectMostSpecificMember(collection, new Function1<CallableMemberDescriptor, CallableDescriptor>() {
            /* class kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass5 */

            public CallableMemberDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return callableMemberDescriptor;
            }
        })).copy(classDescriptor, determineModalityForFakeOverride(collection, classDescriptor), isEmpty ? Visibilities.INVISIBLE_FAKE : Visibilities.INHERITED, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        overridingStrategy.setOverriddenDescriptors(copy, collection);
        overridingStrategy.addFakeOverride(copy);
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$9  reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$descriptors$Modality;
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result;
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007d */
        static {
            /*
                kotlin.reflect.jvm.internal.impl.descriptors.Modality[] r0 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$descriptors$Modality = r0
                r1 = 1
                kotlin.reflect.jvm.internal.impl.descriptors.Modality r2 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$descriptors$Modality     // Catch:{ NoSuchFieldError -> 0x001d }
                kotlin.reflect.jvm.internal.impl.descriptors.Modality r3 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$descriptors$Modality     // Catch:{ NoSuchFieldError -> 0x0028 }
                kotlin.reflect.jvm.internal.impl.descriptors.Modality r4 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$descriptors$Modality     // Catch:{ NoSuchFieldError -> 0x0033 }
                kotlin.reflect.jvm.internal.impl.descriptors.Modality r5 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result[] r4 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result = r4
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result r5 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r4 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result     // Catch:{ NoSuchFieldError -> 0x004e }
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result r5 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.CONFLICT     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r4 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result     // Catch:{ NoSuchFieldError -> 0x0058 }
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result r5 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.INCOMPATIBLE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result[] r4 = kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result = r4
                kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result r5 = kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.OVERRIDABLE     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r1 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result     // Catch:{ NoSuchFieldError -> 0x0073 }
                kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result r4 = kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.CONFLICT     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r0 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result     // Catch:{ NoSuchFieldError -> 0x007d }
                kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result r1 = kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.INCOMPATIBLE     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r0 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result     // Catch:{ NoSuchFieldError -> 0x0087 }
                kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result r1 = kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass9.<clinit>():void");
        }
    }

    private static Modality determineModalityForFakeOverride(Collection<CallableMemberDescriptor> collection, ClassDescriptor classDescriptor) {
        if (collection == null) {
            $$$reportNull$$$0(83);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(84);
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (CallableMemberDescriptor next : collection) {
            int i = AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$descriptors$Modality[next.getModality().ordinal()];
            if (i == 1) {
                Modality modality = Modality.FINAL;
                if (modality == null) {
                    $$$reportNull$$$0(85);
                }
                return modality;
            } else if (i == 2) {
                throw new IllegalStateException("Member cannot have SEALED modality: " + next);
            } else if (i == 3) {
                z2 = true;
            } else if (i == 4) {
                z3 = true;
            }
        }
        if (!(!classDescriptor.isExpect() || classDescriptor.getModality() == Modality.ABSTRACT || classDescriptor.getModality() == Modality.SEALED)) {
            z = true;
        }
        if (z2 && !z3) {
            Modality modality2 = Modality.OPEN;
            if (modality2 == null) {
                $$$reportNull$$$0(86);
            }
            return modality2;
        } else if (z2 || !z3) {
            HashSet hashSet = new HashSet();
            for (CallableMemberDescriptor overriddenDeclarations : collection) {
                hashSet.addAll(getOverriddenDeclarations(overriddenDeclarations));
            }
            return getMinimalModality(filterOutOverridden(hashSet), z, classDescriptor.getModality());
        } else {
            Modality modality3 = z ? classDescriptor.getModality() : Modality.ABSTRACT;
            if (modality3 == null) {
                $$$reportNull$$$0(87);
            }
            return modality3;
        }
    }

    private static Modality getMinimalModality(Collection<CallableMemberDescriptor> collection, boolean z, Modality modality) {
        if (collection == null) {
            $$$reportNull$$$0(88);
        }
        if (modality == null) {
            $$$reportNull$$$0(89);
        }
        Modality modality2 = Modality.ABSTRACT;
        for (CallableMemberDescriptor next : collection) {
            Modality modality3 = (!z || next.getModality() != Modality.ABSTRACT) ? next.getModality() : modality;
            if (modality3.compareTo((Enum) modality2) < 0) {
                modality2 = modality3;
            }
        }
        if (modality2 == null) {
            $$$reportNull$$$0(90);
        }
        return modality2;
    }

    private static Collection<CallableMemberDescriptor> filterVisibleFakeOverrides(final ClassDescriptor classDescriptor, Collection<CallableMemberDescriptor> collection) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(91);
        }
        if (collection == null) {
            $$$reportNull$$$0(92);
        }
        List filter = CollectionsKt.filter(collection, new Function1<CallableMemberDescriptor, Boolean>() {
            /* class kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass6 */

            public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return Boolean.valueOf(!Visibilities.isPrivate(callableMemberDescriptor.getVisibility()) && Visibilities.isVisibleIgnoringReceiver(callableMemberDescriptor, classDescriptor));
            }
        });
        if (filter == null) {
            $$$reportNull$$$0(93);
        }
        return filter;
    }

    public static <H> Collection<H> extractMembersOverridableInBothWays(H h, Collection<H> collection, Function1<H, CallableDescriptor> function1, Function1<H, Unit> function12) {
        if (h == null) {
            $$$reportNull$$$0(94);
        }
        if (collection == null) {
            $$$reportNull$$$0(95);
        }
        if (function1 == null) {
            $$$reportNull$$$0(96);
        }
        if (function12 == null) {
            $$$reportNull$$$0(97);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h);
        CallableDescriptor invoke = function1.invoke(h);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            CallableDescriptor invoke2 = function1.invoke(next);
            if (h == next) {
                it.remove();
            } else {
                OverrideCompatibilityInfo.Result bothWaysOverridability = getBothWaysOverridability(invoke, invoke2);
                if (bothWaysOverridability == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (bothWaysOverridability == OverrideCompatibilityInfo.Result.CONFLICT) {
                    function12.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public static OverrideCompatibilityInfo.Result getBothWaysOverridability(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverrideCompatibilityInfo.Result result = DEFAULT.isOverridableBy(callableDescriptor2, callableDescriptor, null).getResult();
        OverrideCompatibilityInfo.Result result2 = DEFAULT.isOverridableBy(callableDescriptor, callableDescriptor2, null).getResult();
        if (result == OverrideCompatibilityInfo.Result.OVERRIDABLE && result2 == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
            return OverrideCompatibilityInfo.Result.OVERRIDABLE;
        }
        return (result == OverrideCompatibilityInfo.Result.CONFLICT || result2 == OverrideCompatibilityInfo.Result.CONFLICT) ? OverrideCompatibilityInfo.Result.CONFLICT : OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    }

    private static Collection<CallableMemberDescriptor> extractMembersOverridableInBothWays(final CallableMemberDescriptor callableMemberDescriptor, Queue<CallableMemberDescriptor> queue, final OverridingStrategy overridingStrategy) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(99);
        }
        if (queue == null) {
            $$$reportNull$$$0(100);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(101);
        }
        return extractMembersOverridableInBothWays(callableMemberDescriptor, queue, new Function1<CallableMemberDescriptor, CallableDescriptor>() {
            /* class kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass7 */

            public CallableDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return callableMemberDescriptor;
            }
        }, new Function1<CallableMemberDescriptor, Unit>() {
            /* class kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass8 */

            public Unit invoke(CallableMemberDescriptor callableMemberDescriptor) {
                overridingStrategy.inheritanceConflict(callableMemberDescriptor, callableMemberDescriptor);
                return Unit.INSTANCE;
            }
        });
    }

    public static void resolveUnknownVisibilityForMember(CallableMemberDescriptor callableMemberDescriptor, Function1<CallableMemberDescriptor, Unit> function1) {
        Visibility visibility;
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(102);
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.getOverriddenDescriptors()) {
            if (callableMemberDescriptor2.getVisibility() == Visibilities.INHERITED) {
                resolveUnknownVisibilityForMember(callableMemberDescriptor2, function1);
            }
        }
        if (callableMemberDescriptor.getVisibility() == Visibilities.INHERITED) {
            Visibility computeVisibilityToInherit = computeVisibilityToInherit(callableMemberDescriptor);
            if (computeVisibilityToInherit == null) {
                if (function1 != null) {
                    function1.invoke(callableMemberDescriptor);
                }
                visibility = Visibilities.PUBLIC;
            } else {
                visibility = computeVisibilityToInherit;
            }
            if (callableMemberDescriptor instanceof PropertyDescriptorImpl) {
                ((PropertyDescriptorImpl) callableMemberDescriptor).setVisibility(visibility);
                for (PropertyAccessorDescriptor resolveUnknownVisibilityForMember : ((PropertyDescriptor) callableMemberDescriptor).getAccessors()) {
                    resolveUnknownVisibilityForMember(resolveUnknownVisibilityForMember, computeVisibilityToInherit == null ? null : function1);
                }
            } else if (callableMemberDescriptor instanceof FunctionDescriptorImpl) {
                ((FunctionDescriptorImpl) callableMemberDescriptor).setVisibility(visibility);
            } else {
                PropertyAccessorDescriptorImpl propertyAccessorDescriptorImpl = (PropertyAccessorDescriptorImpl) callableMemberDescriptor;
                propertyAccessorDescriptorImpl.setVisibility(visibility);
                if (visibility != propertyAccessorDescriptorImpl.getCorrespondingProperty().getVisibility()) {
                    propertyAccessorDescriptorImpl.setDefault(false);
                }
            }
        }
    }

    private static Visibility computeVisibilityToInherit(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(103);
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Visibility findMaxVisibility = findMaxVisibility(overriddenDescriptors);
        if (findMaxVisibility == null) {
            return null;
        }
        if (callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return findMaxVisibility.normalize();
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : overriddenDescriptors) {
            if (callableMemberDescriptor2.getModality() != Modality.ABSTRACT && !callableMemberDescriptor2.getVisibility().equals(findMaxVisibility)) {
                return null;
            }
        }
        return findMaxVisibility;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static kotlin.reflect.jvm.internal.impl.descriptors.Visibility findMaxVisibility(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> r5) {
        /*
            if (r5 != 0) goto L_0x0007
            r0 = 104(0x68, float:1.46E-43)
            $$$reportNull$$$0(r0)
        L_0x0007:
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L_0x0010
            kotlin.reflect.jvm.internal.impl.descriptors.Visibility r5 = kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.DEFAULT_VISIBILITY
            return r5
        L_0x0010:
            java.util.Iterator r0 = r5.iterator()
            r1 = 0
        L_0x0015:
            r2 = r1
        L_0x0016:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0038
            java.lang.Object r3 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.Visibility r3 = r3.getVisibility()
            if (r2 != 0) goto L_0x002a
        L_0x0028:
            r2 = r3
            goto L_0x0016
        L_0x002a:
            java.lang.Integer r4 = kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.compare(r3, r2)
            if (r4 != 0) goto L_0x0031
            goto L_0x0015
        L_0x0031:
            int r4 = r4.intValue()
            if (r4 <= 0) goto L_0x0016
            goto L_0x0028
        L_0x0038:
            if (r2 != 0) goto L_0x003b
            return r1
        L_0x003b:
            java.util.Iterator r5 = r5.iterator()
        L_0x003f:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x005c
            java.lang.Object r0 = r5.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.Visibility r0 = r0.getVisibility()
            java.lang.Integer r0 = kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.compare(r2, r0)
            if (r0 == 0) goto L_0x005b
            int r0 = r0.intValue()
            if (r0 >= 0) goto L_0x003f
        L_0x005b:
            return r1
        L_0x005c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.findMaxVisibility(java.util.Collection):kotlin.reflect.jvm.internal.impl.descriptors.Visibility");
    }

    public static class OverrideCompatibilityInfo {
        private static final OverrideCompatibilityInfo SUCCESS = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        private final String debugMessage;
        private final Result overridable;

        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0038  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x003b  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x005a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            /*
                r0 = 4
                r1 = 3
                r2 = 2
                r3 = 1
                if (r10 == r3) goto L_0x000f
                if (r10 == r2) goto L_0x000f
                if (r10 == r1) goto L_0x000f
                if (r10 == r0) goto L_0x000f
                java.lang.String r4 = "@NotNull method %s.%s must not return null"
                goto L_0x0011
            L_0x000f:
                java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            L_0x0011:
                if (r10 == r3) goto L_0x001b
                if (r10 == r2) goto L_0x001b
                if (r10 == r1) goto L_0x001b
                if (r10 == r0) goto L_0x001b
                r5 = r2
                goto L_0x001c
            L_0x001b:
                r5 = r1
            L_0x001c:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "success"
                java.lang.String r7 = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo"
                r8 = 0
                if (r10 == r3) goto L_0x0031
                if (r10 == r2) goto L_0x0031
                if (r10 == r1) goto L_0x002e
                if (r10 == r0) goto L_0x0031
                r5[r8] = r7
                goto L_0x0035
            L_0x002e:
                r5[r8] = r6
                goto L_0x0035
            L_0x0031:
                java.lang.String r9 = "debugMessage"
                r5[r8] = r9
            L_0x0035:
                switch(r10) {
                    case 1: goto L_0x0045;
                    case 2: goto L_0x0045;
                    case 3: goto L_0x0045;
                    case 4: goto L_0x0045;
                    case 5: goto L_0x0040;
                    case 6: goto L_0x003b;
                    default: goto L_0x0038;
                }
            L_0x0038:
                r5[r3] = r6
                goto L_0x0047
            L_0x003b:
                java.lang.String r6 = "getDebugMessage"
                r5[r3] = r6
                goto L_0x0047
            L_0x0040:
                java.lang.String r6 = "getResult"
                r5[r3] = r6
                goto L_0x0047
            L_0x0045:
                r5[r3] = r7
            L_0x0047:
                if (r10 == r3) goto L_0x005a
                if (r10 == r2) goto L_0x0055
                if (r10 == r1) goto L_0x0050
                if (r10 == r0) goto L_0x0050
                goto L_0x005e
            L_0x0050:
                java.lang.String r6 = "<init>"
                r5[r2] = r6
                goto L_0x005e
            L_0x0055:
                java.lang.String r6 = "conflict"
                r5[r2] = r6
                goto L_0x005e
            L_0x005a:
                java.lang.String r6 = "incompatible"
                r5[r2] = r6
            L_0x005e:
                java.lang.String r4 = java.lang.String.format(r4, r5)
                if (r10 == r3) goto L_0x0070
                if (r10 == r2) goto L_0x0070
                if (r10 == r1) goto L_0x0070
                if (r10 == r0) goto L_0x0070
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r4)
                goto L_0x0075
            L_0x0070:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r4)
            L_0x0075:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.$$$reportNull$$$0(int):void");
        }

        public static OverrideCompatibilityInfo success() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = SUCCESS;
            if (overrideCompatibilityInfo == null) {
                $$$reportNull$$$0(0);
            }
            return overrideCompatibilityInfo;
        }

        public static OverrideCompatibilityInfo incompatible(String str) {
            if (str == null) {
                $$$reportNull$$$0(1);
            }
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, str);
        }

        public static OverrideCompatibilityInfo conflict(String str) {
            if (str == null) {
                $$$reportNull$$$0(2);
            }
            return new OverrideCompatibilityInfo(Result.CONFLICT, str);
        }

        public OverrideCompatibilityInfo(Result result, String str) {
            if (result == null) {
                $$$reportNull$$$0(3);
            }
            if (str == null) {
                $$$reportNull$$$0(4);
            }
            this.overridable = result;
            this.debugMessage = str;
        }

        public Result getResult() {
            Result result = this.overridable;
            if (result == null) {
                $$$reportNull$$$0(5);
            }
            return result;
        }
    }
}
