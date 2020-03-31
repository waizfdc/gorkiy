package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class DoubleValue extends ConstantValue<Double> {
    public DoubleValue(double d) {
        super(Double.valueOf(d));
    }

    public SimpleType getType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
        SimpleType doubleType = moduleDescriptor.getBuiltIns().getDoubleType();
        Intrinsics.checkExpressionValueIsNotNull(doubleType, "module.builtIns.doubleType");
        return doubleType;
    }

    public String toString() {
        return ((Number) getValue()).doubleValue() + ".toDouble()";
    }
}
