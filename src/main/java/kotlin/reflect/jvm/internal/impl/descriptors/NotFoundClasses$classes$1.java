package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;

/* compiled from: NotFoundClasses.kt */
final class NotFoundClasses$classes$1 extends Lambda implements Function1<NotFoundClasses.ClassRequest, NotFoundClasses.MockClassDescriptor> {
    final /* synthetic */ NotFoundClasses this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotFoundClasses$classes$1(NotFoundClasses notFoundClasses) {
        super(1);
        this.this$0 = notFoundClasses;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor invoke(kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.ClassRequest r10) {
        /*
            r9 = this;
            java.lang.String r0 = "<name for destructuring parameter 0>"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            kotlin.reflect.jvm.internal.impl.name.ClassId r0 = r10.component1()
            java.util.List r10 = r10.component2()
            boolean r1 = r0.isLocal()
            if (r1 != 0) goto L_0x0072
            kotlin.reflect.jvm.internal.impl.name.ClassId r1 = r0.getOuterClassId()
            if (r1 == 0) goto L_0x0031
            kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses r2 = r9.this$0
            java.lang.String r3 = "outerClassId"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
            r3 = r10
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 1
            java.util.List r3 = kotlin.collections.CollectionsKt.drop(r3, r4)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = r2.getClass(r1, r3)
            if (r1 == 0) goto L_0x0031
            kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor) r1
            goto L_0x0046
        L_0x0031:
            kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses r1 = r9.this$0
            kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull r1 = r1.packageFragments
            kotlin.reflect.jvm.internal.impl.name.FqName r2 = r0.getPackageFqName()
            java.lang.String r3 = "classId.packageFqName"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            java.lang.Object r1 = r1.invoke(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor) r1
        L_0x0046:
            boolean r6 = r0.isNestedClass()
            kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$MockClassDescriptor r8 = new kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$MockClassDescriptor
            kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses r2 = r9.this$0
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r3 = r2.storageManager
            r4 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r4
            kotlin.reflect.jvm.internal.impl.name.Name r5 = r0.getShortClassName()
            java.lang.String r0 = "classId.shortClassName"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0)
            java.lang.Object r10 = kotlin.collections.CollectionsKt.firstOrNull(r10)
            java.lang.Integer r10 = (java.lang.Integer) r10
            if (r10 == 0) goto L_0x006b
            int r10 = r10.intValue()
            goto L_0x006c
        L_0x006b:
            r10 = 0
        L_0x006c:
            r7 = r10
            r2 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        L_0x0072:
            java.lang.UnsupportedOperationException r10 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unresolved local class: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r10.<init>(r0)
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$classes$1.invoke(kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$ClassRequest):kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$MockClassDescriptor");
    }
}
