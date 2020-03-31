package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: signatureEnhancement.kt */
final class SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1 extends Lambda implements Function2<List<? extends FqName>, T, T> {
    final /* synthetic */ Annotations $composedAnnotation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1(Annotations annotations) {
        super(2);
        this.$composedAnnotation = annotations;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((List<FqName>) ((List) obj), obj2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T invoke(java.util.List<kotlin.reflect.jvm.internal.impl.name.FqName> r5, java.lang.Object r6) {
        /*
            r4 = this;
            java.lang.String r0 = "$this$ifPresent"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "qualifier"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r0 = r5 instanceof java.util.Collection
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001d
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001d
        L_0x001b:
            r1 = r2
            goto L_0x003a
        L_0x001d:
            java.util.Iterator r5 = r5.iterator()
        L_0x0021:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x001b
            java.lang.Object r0 = r5.next()
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = (kotlin.reflect.jvm.internal.impl.name.FqName) r0
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r3 = r4.$composedAnnotation
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r0 = r3.findAnnotation(r0)
            if (r0 == 0) goto L_0x0037
            r0 = r1
            goto L_0x0038
        L_0x0037:
            r0 = r2
        L_0x0038:
            if (r0 == 0) goto L_0x0021
        L_0x003a:
            if (r1 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r6 = 0
        L_0x003e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1.invoke(java.util.List, java.lang.Object):java.lang.Object");
    }
}
