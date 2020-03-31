package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$nestedClasses$1 extends Lambda implements Function1<Name, ClassDescriptorBase> {
    final /* synthetic */ LazyJavaResolverContext $c;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$nestedClasses$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(1);
        this.this$0 = lazyJavaClassMemberScope;
        this.$c = lazyJavaResolverContext;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r2v11, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase invoke(kotlin.reflect.jvm.internal.impl.name.Name r18) {
        /*
            r17 = this;
            r0 = r17
            r3 = r18
            java.lang.String r1 = "name"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r1)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r1 = r0.this$0
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r1 = r1.nestedClassIndex
            java.lang.Object r1 = r1.invoke()
            java.util.Set r1 = (java.util.Set) r1
            boolean r1 = r1.contains(r3)
            r2 = 0
            if (r1 != 0) goto L_0x0076
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r1 = r0.this$0
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r1 = r1.enumEntryIndex
            java.lang.Object r1 = r1.invoke()
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r1 = r1.get(r3)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField r1 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField) r1
            if (r1 == 0) goto L_0x0073
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r2 = r0.$c
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r2 = r2.getStorageManager()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1 r4 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1
            r4.<init>(r0)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r4 = r2.createLazyValue(r4)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r2 = r0.$c
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r2 = r2.getStorageManager()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r5 = r0.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r5 = r5.getOwnerDescriptor()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r6 = r0.$c
            r7 = r1
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner r7 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner) r7
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r6 = kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(r6, r7)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r7 = r0.$c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r7 = r7.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r7 = r7.getSourceElementFactory()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r1 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement) r1
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r1 = r7.source(r1)
            r7 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r7 = (kotlin.reflect.jvm.internal.impl.descriptors.SourceElement) r7
            r1 = r2
            r2 = r5
            r3 = r18
            r5 = r6
            r6 = r7
            kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor r2 = kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.create(r1, r2, r3, r4, r5, r6)
        L_0x0073:
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase r2 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase) r2
            goto L_0x00d7
        L_0x0076:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r1 = r0.$c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r1 = r1.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder r1 = r1.getFinder()
            kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder$Request r9 = new kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder$Request
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r4 = r0.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = r4.getOwnerDescriptor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r4
            kotlin.reflect.jvm.internal.impl.name.ClassId r4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId(r4)
            if (r4 != 0) goto L_0x0093
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0093:
            kotlin.reflect.jvm.internal.impl.name.ClassId r4 = r4.createNestedClassId(r3)
            java.lang.String r3 = "ownerDescriptor.classId!…createNestedClassId(name)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r3)
            r5 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r3 = r0.this$0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r6 = r3.jClass
            r7 = 2
            r8 = 0
            r3 = r9
            r3.<init>(r4, r5, r6, r7, r8)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r13 = r1.findClass(r9)
            if (r13 == 0) goto L_0x00d5
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r2 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r11 = r0.$c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r1 = r0.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = r1.getOwnerDescriptor()
            r12 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r12 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r12
            r14 = 0
            r15 = 8
            r16 = 0
            r10 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r1 = r0.$c
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r1 = r1.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker r1 = r1.getJavaClassesTracker()
            r3 = r2
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor) r3
            r1.reportClass(r3)
        L_0x00d5:
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase r2 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase) r2
        L_0x00d7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$nestedClasses$1.invoke(kotlin.reflect.jvm.internal.impl.name.Name):kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase");
    }
}
