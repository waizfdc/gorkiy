package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ReflectJavaClassifierType.kt */
public final class ReflectJavaClassifierType extends ReflectJavaType implements JavaClassifierType {
    private final JavaClassifier classifier;
    private final Type reflectType;

    public JavaAnnotation findAnnotation(FqName fqName) {
        Intrinsics.checkParameterIsNotNull(fqName, "fqName");
        return null;
    }

    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public ReflectJavaClassifierType(Type type) {
        JavaClassifier javaClassifier;
        Intrinsics.checkParameterIsNotNull(type, "reflectType");
        this.reflectType = type;
        Type reflectType2 = getReflectType();
        if (reflectType2 instanceof Class) {
            javaClassifier = new ReflectJavaClass((Class) reflectType2);
        } else if (reflectType2 instanceof TypeVariable) {
            javaClassifier = new ReflectJavaTypeParameter((TypeVariable) reflectType2);
        } else if (reflectType2 instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) reflectType2).getRawType();
            if (rawType != null) {
                javaClassifier = new ReflectJavaClass((Class) rawType);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
            }
        } else {
            throw new IllegalStateException("Not a classifier type (" + reflectType2.getClass() + "): " + reflectType2);
        }
        this.classifier = javaClassifier;
    }

    public Type getReflectType() {
        return this.reflectType;
    }

    public JavaClassifier getClassifier() {
        return this.classifier;
    }

    public String getClassifierQualifiedName() {
        throw new UnsupportedOperationException("Type not found: " + getReflectType());
    }

    public String getPresentableText() {
        return getReflectType().toString();
    }

    public boolean isRaw() {
        Type reflectType2 = getReflectType();
        if (!(reflectType2 instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) reflectType2).getTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(typeParameters, "getTypeParameters()");
        return (typeParameters.length == 0) ^ true;
    }

    public List<JavaType> getTypeArguments() {
        Iterable<Type> parameterizedTypeArguments = ReflectClassUtilKt.getParameterizedTypeArguments(getReflectType());
        ReflectJavaType.Factory factory = ReflectJavaType.Factory;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameterizedTypeArguments, 10));
        for (Type create : parameterizedTypeArguments) {
            arrayList.add(factory.create(create));
        }
        return (List) arrayList;
    }

    public Collection<JavaAnnotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }
}
