package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

public class EnumEntrySyntheticClassDescriptor extends ClassDescriptorBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Annotations annotations;
    /* access modifiers changed from: private */
    public final NotNullLazyValue<Set<Name>> enumMemberNames;
    private final MemberScope scope;
    private final TypeConstructor typeConstructor;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = AppMeasurementSdk.ConditionalUserProperty.NAME;
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    public boolean isActual() {
        return false;
    }

    public boolean isCompanionObject() {
        return false;
    }

    public boolean isData() {
        return false;
    }

    public boolean isExpect() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isInner() {
        return false;
    }

    public static EnumEntrySyntheticClassDescriptor create(StorageManager storageManager, ClassDescriptor classDescriptor, Name name, NotNullLazyValue<Set<Name>> notNullLazyValue, Annotations annotations2, SourceElement sourceElement) {
        if (storageManager == null) {
            $$$reportNull$$$0(0);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(1);
        }
        if (name == null) {
            $$$reportNull$$$0(2);
        }
        if (notNullLazyValue == null) {
            $$$reportNull$$$0(3);
        }
        if (annotations2 == null) {
            $$$reportNull$$$0(4);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(5);
        }
        return new EnumEntrySyntheticClassDescriptor(storageManager, classDescriptor, classDescriptor.getDefaultType(), name, notNullLazyValue, annotations2, sourceElement);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private EnumEntrySyntheticClassDescriptor(StorageManager storageManager, ClassDescriptor classDescriptor, KotlinType kotlinType, Name name, NotNullLazyValue<Set<Name>> notNullLazyValue, Annotations annotations2, SourceElement sourceElement) {
        super(storageManager, classDescriptor, name, sourceElement, false);
        if (storageManager == null) {
            $$$reportNull$$$0(6);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(7);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(8);
        }
        if (name == null) {
            $$$reportNull$$$0(9);
        }
        if (notNullLazyValue == null) {
            $$$reportNull$$$0(10);
        }
        if (annotations2 == null) {
            $$$reportNull$$$0(11);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(12);
        }
        this.annotations = annotations2;
        this.typeConstructor = new ClassTypeConstructorImpl(this, Collections.emptyList(), Collections.singleton(kotlinType), storageManager);
        this.scope = new EnumEntryScope(this, storageManager);
        this.enumMemberNames = notNullLazyValue;
    }

    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(13);
        }
        MemberScope memberScope = this.scope;
        if (memberScope == null) {
            $$$reportNull$$$0(14);
        }
        return memberScope;
    }

    public MemberScope getStaticScope() {
        MemberScope.Empty empty = MemberScope.Empty.INSTANCE;
        if (empty == null) {
            $$$reportNull$$$0(15);
        }
        return empty;
    }

    public Collection<ClassConstructorDescriptor> getConstructors() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(16);
        }
        return emptyList;
    }

    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor2 = this.typeConstructor;
        if (typeConstructor2 == null) {
            $$$reportNull$$$0(17);
        }
        return typeConstructor2;
    }

    public ClassKind getKind() {
        ClassKind classKind = ClassKind.ENUM_ENTRY;
        if (classKind == null) {
            $$$reportNull$$$0(18);
        }
        return classKind;
    }

    public Modality getModality() {
        Modality modality = Modality.FINAL;
        if (modality == null) {
            $$$reportNull$$$0(19);
        }
        return modality;
    }

    public Visibility getVisibility() {
        Visibility visibility = Visibilities.PUBLIC;
        if (visibility == null) {
            $$$reportNull$$$0(20);
        }
        return visibility;
    }

    public Annotations getAnnotations() {
        Annotations annotations2 = this.annotations;
        if (annotations2 == null) {
            $$$reportNull$$$0(21);
        }
        return annotations2;
    }

    public String toString() {
        return "enum entry " + getName();
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(22);
        }
        return emptyList;
    }

    public Collection<ClassDescriptor> getSealedSubclasses() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(23);
        }
        return emptyList;
    }

    private class EnumEntryScope extends MemberScopeImpl {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
        private final MemoizedFunctionToNotNull<Name, Collection<? extends SimpleFunctionDescriptor>> functions;
        private final MemoizedFunctionToNotNull<Name, Collection<? extends PropertyDescriptor>> properties;
        final /* synthetic */ EnumEntrySyntheticClassDescriptor this$0;

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0032  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0095  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00a8  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00ad  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00be  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static /* synthetic */ void $$$reportNull$$$0(int r13) {
            /*
                r0 = 12
                r1 = 9
                r2 = 7
                r3 = 3
                if (r13 == r3) goto L_0x0014
                if (r13 == r2) goto L_0x0014
                if (r13 == r1) goto L_0x0014
                if (r13 == r0) goto L_0x0014
                switch(r13) {
                    case 15: goto L_0x0014;
                    case 16: goto L_0x0014;
                    case 17: goto L_0x0014;
                    case 18: goto L_0x0014;
                    case 19: goto L_0x0014;
                    default: goto L_0x0011;
                }
            L_0x0011:
                java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto L_0x0016
            L_0x0014:
                java.lang.String r4 = "@NotNull method %s.%s must not return null"
            L_0x0016:
                r5 = 2
                if (r13 == r3) goto L_0x0024
                if (r13 == r2) goto L_0x0024
                if (r13 == r1) goto L_0x0024
                if (r13 == r0) goto L_0x0024
                switch(r13) {
                    case 15: goto L_0x0024;
                    case 16: goto L_0x0024;
                    case 17: goto L_0x0024;
                    case 18: goto L_0x0024;
                    case 19: goto L_0x0024;
                    default: goto L_0x0022;
                }
            L_0x0022:
                r6 = r3
                goto L_0x0025
            L_0x0024:
                r6 = r5
            L_0x0025:
                java.lang.Object[] r6 = new java.lang.Object[r6]
                java.lang.String r7 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope"
                r8 = 0
                switch(r13) {
                    case 1: goto L_0x004e;
                    case 2: goto L_0x0049;
                    case 3: goto L_0x0046;
                    case 4: goto L_0x004e;
                    case 5: goto L_0x004e;
                    case 6: goto L_0x0049;
                    case 7: goto L_0x0046;
                    case 8: goto L_0x004e;
                    case 9: goto L_0x0046;
                    case 10: goto L_0x004e;
                    case 11: goto L_0x0041;
                    case 12: goto L_0x0046;
                    case 13: goto L_0x003c;
                    case 14: goto L_0x0037;
                    case 15: goto L_0x0046;
                    case 16: goto L_0x0046;
                    case 17: goto L_0x0046;
                    case 18: goto L_0x0046;
                    case 19: goto L_0x0046;
                    case 20: goto L_0x0032;
                    default: goto L_0x002d;
                }
            L_0x002d:
                java.lang.String r9 = "storageManager"
                r6[r8] = r9
                goto L_0x0052
            L_0x0032:
                java.lang.String r9 = "p"
                r6[r8] = r9
                goto L_0x0052
            L_0x0037:
                java.lang.String r9 = "nameFilter"
                r6[r8] = r9
                goto L_0x0052
            L_0x003c:
                java.lang.String r9 = "kindFilter"
                r6[r8] = r9
                goto L_0x0052
            L_0x0041:
                java.lang.String r9 = "fromSupertypes"
                r6[r8] = r9
                goto L_0x0052
            L_0x0046:
                r6[r8] = r7
                goto L_0x0052
            L_0x0049:
                java.lang.String r9 = "location"
                r6[r8] = r9
                goto L_0x0052
            L_0x004e:
                java.lang.String r9 = "name"
                r6[r8] = r9
            L_0x0052:
                java.lang.String r8 = "getContributedDescriptors"
                java.lang.String r9 = "resolveFakeOverrides"
                java.lang.String r10 = "getContributedFunctions"
                java.lang.String r11 = "getContributedVariables"
                r12 = 1
                if (r13 == r3) goto L_0x008b
                if (r13 == r2) goto L_0x0088
                if (r13 == r1) goto L_0x0083
                if (r13 == r0) goto L_0x0080
                switch(r13) {
                    case 15: goto L_0x007d;
                    case 16: goto L_0x0078;
                    case 17: goto L_0x0073;
                    case 18: goto L_0x006e;
                    case 19: goto L_0x0069;
                    default: goto L_0x0066;
                }
            L_0x0066:
                r6[r12] = r7
                goto L_0x008d
            L_0x0069:
                java.lang.String r7 = "getVariableNames"
                r6[r12] = r7
                goto L_0x008d
            L_0x006e:
                java.lang.String r7 = "getClassifierNames"
                r6[r12] = r7
                goto L_0x008d
            L_0x0073:
                java.lang.String r7 = "getFunctionNames"
                r6[r12] = r7
                goto L_0x008d
            L_0x0078:
                java.lang.String r7 = "computeAllDeclarations"
                r6[r12] = r7
                goto L_0x008d
            L_0x007d:
                r6[r12] = r8
                goto L_0x008d
            L_0x0080:
                r6[r12] = r9
                goto L_0x008d
            L_0x0083:
                java.lang.String r7 = "getSupertypeScope"
                r6[r12] = r7
                goto L_0x008d
            L_0x0088:
                r6[r12] = r10
                goto L_0x008d
            L_0x008b:
                r6[r12] = r11
            L_0x008d:
                switch(r13) {
                    case 1: goto L_0x00ad;
                    case 2: goto L_0x00ad;
                    case 3: goto L_0x00af;
                    case 4: goto L_0x00a8;
                    case 5: goto L_0x00a5;
                    case 6: goto L_0x00a5;
                    case 7: goto L_0x00af;
                    case 8: goto L_0x00a0;
                    case 9: goto L_0x00af;
                    case 10: goto L_0x009d;
                    case 11: goto L_0x009d;
                    case 12: goto L_0x00af;
                    case 13: goto L_0x009a;
                    case 14: goto L_0x009a;
                    case 15: goto L_0x00af;
                    case 16: goto L_0x00af;
                    case 17: goto L_0x00af;
                    case 18: goto L_0x00af;
                    case 19: goto L_0x00af;
                    case 20: goto L_0x0095;
                    default: goto L_0x0090;
                }
            L_0x0090:
                java.lang.String r7 = "<init>"
                r6[r5] = r7
                goto L_0x00af
            L_0x0095:
                java.lang.String r7 = "printScopeStructure"
                r6[r5] = r7
                goto L_0x00af
            L_0x009a:
                r6[r5] = r8
                goto L_0x00af
            L_0x009d:
                r6[r5] = r9
                goto L_0x00af
            L_0x00a0:
                java.lang.String r7 = "computeFunctions"
                r6[r5] = r7
                goto L_0x00af
            L_0x00a5:
                r6[r5] = r10
                goto L_0x00af
            L_0x00a8:
                java.lang.String r7 = "computeProperties"
                r6[r5] = r7
                goto L_0x00af
            L_0x00ad:
                r6[r5] = r11
            L_0x00af:
                java.lang.String r4 = java.lang.String.format(r4, r6)
                if (r13 == r3) goto L_0x00c4
                if (r13 == r2) goto L_0x00c4
                if (r13 == r1) goto L_0x00c4
                if (r13 == r0) goto L_0x00c4
                switch(r13) {
                    case 15: goto L_0x00c4;
                    case 16: goto L_0x00c4;
                    case 17: goto L_0x00c4;
                    case 18: goto L_0x00c4;
                    case 19: goto L_0x00c4;
                    default: goto L_0x00be;
                }
            L_0x00be:
                java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
                r13.<init>(r4)
                goto L_0x00c9
            L_0x00c4:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                r13.<init>(r4)
            L_0x00c9:
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.EnumEntryScope.$$$reportNull$$$0(int):void");
        }

        static {
            Class<EnumEntrySyntheticClassDescriptor> cls = EnumEntrySyntheticClassDescriptor.class;
        }

        public EnumEntryScope(final EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor, StorageManager storageManager) {
            if (storageManager == null) {
                $$$reportNull$$$0(0);
            }
            this.this$0 = enumEntrySyntheticClassDescriptor;
            this.functions = storageManager.createMemoizedFunction(new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>() {
                /* class kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.EnumEntryScope.AnonymousClass1 */

                public Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
                    return EnumEntryScope.this.computeFunctions(name);
                }
            });
            this.properties = storageManager.createMemoizedFunction(new Function1<Name, Collection<? extends PropertyDescriptor>>() {
                /* class kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.EnumEntryScope.AnonymousClass2 */

                public Collection<? extends PropertyDescriptor> invoke(Name name) {
                    return EnumEntryScope.this.computeProperties(name);
                }
            });
            this.allDescriptors = storageManager.createLazyValue(new Function0<Collection<DeclarationDescriptor>>() {
                /* class kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.EnumEntryScope.AnonymousClass3 */

                public Collection<DeclarationDescriptor> invoke() {
                    return EnumEntryScope.this.computeAllDeclarations();
                }
            });
        }

        public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(1);
            }
            if (lookupLocation == null) {
                $$$reportNull$$$0(2);
            }
            Collection<? extends PropertyDescriptor> invoke = this.properties.invoke(name);
            if (invoke == null) {
                $$$reportNull$$$0(3);
            }
            return invoke;
        }

        /* access modifiers changed from: private */
        public Collection<? extends PropertyDescriptor> computeProperties(Name name) {
            if (name == null) {
                $$$reportNull$$$0(4);
            }
            return resolveFakeOverrides(name, getSupertypeScope().getContributedVariables(name, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(5);
            }
            if (lookupLocation == null) {
                $$$reportNull$$$0(6);
            }
            Collection<? extends SimpleFunctionDescriptor> invoke = this.functions.invoke(name);
            if (invoke == null) {
                $$$reportNull$$$0(7);
            }
            return invoke;
        }

        /* access modifiers changed from: private */
        public Collection<? extends SimpleFunctionDescriptor> computeFunctions(Name name) {
            if (name == null) {
                $$$reportNull$$$0(8);
            }
            return resolveFakeOverrides(name, getSupertypeScope().getContributedFunctions(name, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        private MemberScope getSupertypeScope() {
            MemberScope memberScope = this.this$0.getTypeConstructor().getSupertypes().iterator().next().getMemberScope();
            if (memberScope == null) {
                $$$reportNull$$$0(9);
            }
            return memberScope;
        }

        private <D extends CallableMemberDescriptor> Collection<? extends D> resolveFakeOverrides(Name name, Collection<? extends D> collection) {
            if (name == null) {
                $$$reportNull$$$0(10);
            }
            if (collection == null) {
                $$$reportNull$$$0(11);
            }
            final LinkedHashSet linkedHashSet = new LinkedHashSet();
            OverridingUtil.DEFAULT.generateOverridesInFunctionGroup(name, collection, Collections.emptySet(), this.this$0, new NonReportingOverrideStrategy() {
                /* class kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.EnumEntryScope.AnonymousClass4 */

                private static /* synthetic */ void $$$reportNull$$$0(int i) {
                    Object[] objArr = new Object[3];
                    if (i == 1) {
                        objArr[0] = "fromSuper";
                    } else if (i != 2) {
                        objArr[0] = "fakeOverride";
                    } else {
                        objArr[0] = "fromCurrent";
                    }
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                    if (i == 1 || i == 2) {
                        objArr[2] = "conflict";
                    } else {
                        objArr[2] = "addFakeOverride";
                    }
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
                }

                /* access modifiers changed from: protected */
                public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                    if (callableMemberDescriptor == null) {
                        $$$reportNull$$$0(1);
                    }
                    if (callableMemberDescriptor2 == null) {
                        $$$reportNull$$$0(2);
                    }
                }

                public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
                    if (callableMemberDescriptor == null) {
                        $$$reportNull$$$0(0);
                    }
                    OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, null);
                    linkedHashSet.add(callableMemberDescriptor);
                }
            });
            return linkedHashSet;
        }

        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            if (descriptorKindFilter == null) {
                $$$reportNull$$$0(13);
            }
            if (function1 == null) {
                $$$reportNull$$$0(14);
            }
            Collection<DeclarationDescriptor> collection = (Collection) this.allDescriptors.invoke();
            if (collection == null) {
                $$$reportNull$$$0(15);
            }
            return collection;
        }

        /* access modifiers changed from: private */
        public Collection<DeclarationDescriptor> computeAllDeclarations() {
            HashSet hashSet = new HashSet();
            for (Name name : (Set) this.this$0.enumMemberNames.invoke()) {
                hashSet.addAll(getContributedFunctions(name, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
                hashSet.addAll(getContributedVariables(name, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
            }
            return hashSet;
        }

        public Set<Name> getFunctionNames() {
            Set<Name> set = (Set) this.this$0.enumMemberNames.invoke();
            if (set == null) {
                $$$reportNull$$$0(17);
            }
            return set;
        }

        public Set<Name> getVariableNames() {
            Set<Name> set = (Set) this.this$0.enumMemberNames.invoke();
            if (set == null) {
                $$$reportNull$$$0(19);
            }
            return set;
        }
    }
}
