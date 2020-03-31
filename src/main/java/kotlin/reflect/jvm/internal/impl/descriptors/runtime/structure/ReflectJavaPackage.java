package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaPackage.kt */
public final class ReflectJavaPackage extends ReflectJavaElement implements JavaPackage {
    private final FqName fqName;

    public JavaAnnotation findAnnotation(FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return null;
    }

    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public ReflectJavaPackage(FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        this.fqName = fqName2;
    }

    public FqName getFqName() {
        return this.fqName;
    }

    public Collection<JavaClass> getClasses(Function1<? super Name, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "nameFilter");
        return CollectionsKt.emptyList();
    }

    public Collection<JavaPackage> getSubPackages() {
        return CollectionsKt.emptyList();
    }

    public List<JavaAnnotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaPackage) && Intrinsics.areEqual(getFqName(), ((ReflectJavaPackage) obj).getFqName());
    }

    public int hashCode() {
        return getFqName().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getFqName();
    }
}
