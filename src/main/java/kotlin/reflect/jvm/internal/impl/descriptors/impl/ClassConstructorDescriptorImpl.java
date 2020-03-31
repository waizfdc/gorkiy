package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

public class ClassConstructorDescriptorImpl extends FunctionDescriptorImpl implements ClassConstructorDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Name NAME = Name.special("<init>");
    protected final boolean isPrimary;

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ void $$$reportNull$$$0(int r8) {
        /*
            r0 = 25
            r1 = 19
            if (r8 == r1) goto L_0x000e
            if (r8 == r0) goto L_0x000e
            switch(r8) {
                case 15: goto L_0x000e;
                case 16: goto L_0x000e;
                case 17: goto L_0x000e;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L_0x0010
        L_0x000e:
            java.lang.String r2 = "@NotNull method %s.%s must not return null"
        L_0x0010:
            r3 = 2
            if (r8 == r1) goto L_0x001a
            if (r8 == r0) goto L_0x001a
            switch(r8) {
                case 15: goto L_0x001a;
                case 16: goto L_0x001a;
                case 17: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            r4 = 3
            goto L_0x001b
        L_0x001a:
            r4 = r3
        L_0x001b:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl"
            r6 = 0
            switch(r8) {
                case 1: goto L_0x0053;
                case 2: goto L_0x004e;
                case 3: goto L_0x0049;
                case 4: goto L_0x0023;
                case 5: goto L_0x0053;
                case 6: goto L_0x0049;
                case 7: goto L_0x0023;
                case 8: goto L_0x0053;
                case 9: goto L_0x0049;
                case 10: goto L_0x0044;
                case 11: goto L_0x003f;
                case 12: goto L_0x003a;
                case 13: goto L_0x0044;
                case 14: goto L_0x003f;
                case 15: goto L_0x0037;
                case 16: goto L_0x0037;
                case 17: goto L_0x0037;
                case 18: goto L_0x0032;
                case 19: goto L_0x0037;
                case 20: goto L_0x002d;
                case 21: goto L_0x0028;
                case 22: goto L_0x004e;
                case 23: goto L_0x0053;
                case 24: goto L_0x0049;
                case 25: goto L_0x0037;
                default: goto L_0x0023;
            }
        L_0x0023:
            java.lang.String r7 = "containingDeclaration"
            r4[r6] = r7
            goto L_0x0057
        L_0x0028:
            java.lang.String r7 = "newOwner"
            r4[r6] = r7
            goto L_0x0057
        L_0x002d:
            java.lang.String r7 = "overriddenDescriptors"
            r4[r6] = r7
            goto L_0x0057
        L_0x0032:
            java.lang.String r7 = "originalSubstitutor"
            r4[r6] = r7
            goto L_0x0057
        L_0x0037:
            r4[r6] = r5
            goto L_0x0057
        L_0x003a:
            java.lang.String r7 = "typeParameterDescriptors"
            r4[r6] = r7
            goto L_0x0057
        L_0x003f:
            java.lang.String r7 = "visibility"
            r4[r6] = r7
            goto L_0x0057
        L_0x0044:
            java.lang.String r7 = "unsubstitutedValueParameters"
            r4[r6] = r7
            goto L_0x0057
        L_0x0049:
            java.lang.String r7 = "source"
            r4[r6] = r7
            goto L_0x0057
        L_0x004e:
            java.lang.String r7 = "kind"
            r4[r6] = r7
            goto L_0x0057
        L_0x0053:
            java.lang.String r7 = "annotations"
            r4[r6] = r7
        L_0x0057:
            r6 = 1
            if (r8 == r1) goto L_0x0076
            if (r8 == r0) goto L_0x0071
            switch(r8) {
                case 15: goto L_0x006c;
                case 16: goto L_0x0067;
                case 17: goto L_0x0062;
                default: goto L_0x005f;
            }
        L_0x005f:
            r4[r6] = r5
            goto L_0x007a
        L_0x0062:
            java.lang.String r5 = "getOriginal"
            r4[r6] = r5
            goto L_0x007a
        L_0x0067:
            java.lang.String r5 = "getConstructedClass"
            r4[r6] = r5
            goto L_0x007a
        L_0x006c:
            java.lang.String r5 = "getContainingDeclaration"
            r4[r6] = r5
            goto L_0x007a
        L_0x0071:
            java.lang.String r5 = "copy"
            r4[r6] = r5
            goto L_0x007a
        L_0x0076:
            java.lang.String r5 = "getOverriddenDescriptors"
            r4[r6] = r5
        L_0x007a:
            switch(r8) {
                case 4: goto L_0x009b;
                case 5: goto L_0x009b;
                case 6: goto L_0x009b;
                case 7: goto L_0x0096;
                case 8: goto L_0x0096;
                case 9: goto L_0x0096;
                case 10: goto L_0x0091;
                case 11: goto L_0x0091;
                case 12: goto L_0x0091;
                case 13: goto L_0x0091;
                case 14: goto L_0x0091;
                case 15: goto L_0x009f;
                case 16: goto L_0x009f;
                case 17: goto L_0x009f;
                case 18: goto L_0x008c;
                case 19: goto L_0x009f;
                case 20: goto L_0x0087;
                case 21: goto L_0x0082;
                case 22: goto L_0x0082;
                case 23: goto L_0x0082;
                case 24: goto L_0x0082;
                case 25: goto L_0x009f;
                default: goto L_0x007d;
            }
        L_0x007d:
            java.lang.String r5 = "<init>"
            r4[r3] = r5
            goto L_0x009f
        L_0x0082:
            java.lang.String r5 = "createSubstitutedCopy"
            r4[r3] = r5
            goto L_0x009f
        L_0x0087:
            java.lang.String r5 = "setOverriddenDescriptors"
            r4[r3] = r5
            goto L_0x009f
        L_0x008c:
            java.lang.String r5 = "substitute"
            r4[r3] = r5
            goto L_0x009f
        L_0x0091:
            java.lang.String r5 = "initialize"
            r4[r3] = r5
            goto L_0x009f
        L_0x0096:
            java.lang.String r5 = "createSynthesized"
            r4[r3] = r5
            goto L_0x009f
        L_0x009b:
            java.lang.String r5 = "create"
            r4[r3] = r5
        L_0x009f:
            java.lang.String r2 = java.lang.String.format(r2, r4)
            if (r8 == r1) goto L_0x00b0
            if (r8 == r0) goto L_0x00b0
            switch(r8) {
                case 15: goto L_0x00b0;
                case 16: goto L_0x00b0;
                case 17: goto L_0x00b0;
                default: goto L_0x00aa;
            }
        L_0x00aa:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r2)
            goto L_0x00b5
        L_0x00b0:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r2)
        L_0x00b5:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl.$$$reportNull$$$0(int):void");
    }

    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            $$$reportNull$$$0(20);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ClassConstructorDescriptorImpl(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations annotations, boolean z, CallableMemberDescriptor.Kind kind, SourceElement sourceElement) {
        super(classDescriptor, constructorDescriptor, annotations, NAME, kind, sourceElement);
        if (classDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (kind == null) {
            $$$reportNull$$$0(2);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(3);
        }
        this.isPrimary = z;
    }

    public static ClassConstructorDescriptorImpl create(ClassDescriptor classDescriptor, Annotations annotations, boolean z, SourceElement sourceElement) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(4);
        }
        if (annotations == null) {
            $$$reportNull$$$0(5);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(6);
        }
        return new ClassConstructorDescriptorImpl(classDescriptor, null, annotations, z, CallableMemberDescriptor.Kind.DECLARATION, sourceElement);
    }

    public ClassConstructorDescriptorImpl initialize(List<ValueParameterDescriptor> list, Visibility visibility, List<TypeParameterDescriptor> list2) {
        if (list == null) {
            $$$reportNull$$$0(10);
        }
        if (visibility == null) {
            $$$reportNull$$$0(11);
        }
        if (list2 == null) {
            $$$reportNull$$$0(12);
        }
        super.initialize(null, calculateDispatchReceiverParameter(), list2, list, null, Modality.FINAL, visibility);
        return this;
    }

    public ClassConstructorDescriptorImpl initialize(List<ValueParameterDescriptor> list, Visibility visibility) {
        if (list == null) {
            $$$reportNull$$$0(13);
        }
        if (visibility == null) {
            $$$reportNull$$$0(14);
        }
        initialize(list, visibility, getContainingDeclaration().getDeclaredTypeParameters());
        return this;
    }

    public ReceiverParameterDescriptor calculateDispatchReceiverParameter() {
        ClassDescriptor containingDeclaration = getContainingDeclaration();
        if (!containingDeclaration.isInner()) {
            return null;
        }
        DeclarationDescriptor containingDeclaration2 = containingDeclaration.getContainingDeclaration();
        if (containingDeclaration2 instanceof ClassDescriptor) {
            return ((ClassDescriptor) containingDeclaration2).getThisAsReceiverParameter();
        }
        return null;
    }

    public ClassDescriptor getContainingDeclaration() {
        ClassDescriptor classDescriptor = (ClassDescriptor) super.getContainingDeclaration();
        if (classDescriptor == null) {
            $$$reportNull$$$0(15);
        }
        return classDescriptor;
    }

    public ClassDescriptor getConstructedClass() {
        ClassDescriptor containingDeclaration = getContainingDeclaration();
        if (containingDeclaration == null) {
            $$$reportNull$$$0(16);
        }
        return containingDeclaration;
    }

    public ClassConstructorDescriptor getOriginal() {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) super.getOriginal();
        if (classConstructorDescriptor == null) {
            $$$reportNull$$$0(17);
        }
        return classConstructorDescriptor;
    }

    public ClassConstructorDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(18);
        }
        return (ClassConstructorDescriptor) super.substitute(typeSubstitutor);
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitConstructorDescriptor(this, d);
    }

    public boolean isPrimary() {
        return this.isPrimary;
    }

    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
            $$$reportNull$$$0(19);
        }
        return emptySet;
    }

    /* access modifiers changed from: protected */
    public ClassConstructorDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(21);
        }
        if (kind == null) {
            $$$reportNull$$$0(22);
        }
        if (annotations == null) {
            $$$reportNull$$$0(23);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(24);
        }
        if (kind == CallableMemberDescriptor.Kind.DECLARATION || kind == CallableMemberDescriptor.Kind.SYNTHESIZED) {
            return new ClassConstructorDescriptorImpl((ClassDescriptor) declarationDescriptor, this, annotations, this.isPrimary, CallableMemberDescriptor.Kind.DECLARATION, sourceElement);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\n" + "newOwner: " + declarationDescriptor + "\n" + "kind: " + kind);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.copy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Modality, kotlin.reflect.jvm.internal.impl.descriptors.Visibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, boolean):kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
     arg types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Modality, kotlin.reflect.jvm.internal.impl.descriptors.Visibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, boolean]
     candidates:
      kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl.copy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Modality, kotlin.reflect.jvm.internal.impl.descriptors.Visibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, boolean):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
      kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl.copy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Modality, kotlin.reflect.jvm.internal.impl.descriptors.Visibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, boolean):kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor
      kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.copy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Modality, kotlin.reflect.jvm.internal.impl.descriptors.Visibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, boolean):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
      kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.copy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Modality, kotlin.reflect.jvm.internal.impl.descriptors.Visibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, boolean):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
      kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.copy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Modality, kotlin.reflect.jvm.internal.impl.descriptors.Visibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, boolean):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
      kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.copy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Modality, kotlin.reflect.jvm.internal.impl.descriptors.Visibility, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, boolean):kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor */
    public ClassConstructorDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, CallableMemberDescriptor.Kind kind, boolean z) {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) super.copy(declarationDescriptor, modality, visibility, kind, z);
        if (classConstructorDescriptor == null) {
            $$$reportNull$$$0(25);
        }
        return classConstructorDescriptor;
    }
}
