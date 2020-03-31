package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;

/* compiled from: ReflectJavaField.kt */
public final class ReflectJavaField extends ReflectJavaMember implements JavaField {
    private final Field member;

    public boolean getHasConstantNotNullInitializer() {
        return false;
    }

    public ReflectJavaField(Field field) {
        Intrinsics.checkParameterIsNotNull(field, "member");
        this.member = field;
    }

    public Field getMember() {
        return this.member;
    }

    public boolean isEnumEntry() {
        return getMember().isEnumConstant();
    }

    public ReflectJavaType getType() {
        ReflectJavaType.Factory factory = ReflectJavaType.Factory;
        Type genericType = getMember().getGenericType();
        Intrinsics.checkExpressionValueIsNotNull(genericType, "member.genericType");
        return factory.create(genericType);
    }
}
