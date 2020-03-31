package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class PrimitiveType extends Enum<PrimitiveType> {
    private static final /* synthetic */ PrimitiveType[] $VALUES;
    public static final PrimitiveType BOOLEAN = new PrimitiveType("BOOLEAN", 0, "Boolean");
    public static final PrimitiveType BYTE = new PrimitiveType("BYTE", 2, "Byte");
    public static final PrimitiveType CHAR = new PrimitiveType("CHAR", 1, "Char");
    public static final PrimitiveType DOUBLE;
    public static final PrimitiveType FLOAT = new PrimitiveType("FLOAT", 5, "Float");
    public static final PrimitiveType INT = new PrimitiveType("INT", 4, "Int");
    public static final PrimitiveType LONG = new PrimitiveType("LONG", 6, "Long");
    public static final Set<PrimitiveType> NUMBER_TYPES;
    public static final PrimitiveType SHORT = new PrimitiveType("SHORT", 3, "Short");
    private FqName arrayTypeFqName = null;
    private final Name arrayTypeName;
    private FqName typeFqName = null;
    private final Name typeName;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/PrimitiveType";
        if (i == 1 || i == 2) {
            objArr[1] = "getTypeFqName";
        } else if (i == 3) {
            objArr[1] = "getArrayTypeName";
        } else if (i == 4 || i == 5) {
            objArr[1] = "getArrayTypeFqName";
        } else {
            objArr[1] = "getTypeName";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    public static PrimitiveType valueOf(String str) {
        return (PrimitiveType) Enum.valueOf(PrimitiveType.class, str);
    }

    public static PrimitiveType[] values() {
        return (PrimitiveType[]) $VALUES.clone();
    }

    static {
        PrimitiveType primitiveType = new PrimitiveType("DOUBLE", 7, "Double");
        DOUBLE = primitiveType;
        PrimitiveType primitiveType2 = CHAR;
        PrimitiveType primitiveType3 = BYTE;
        PrimitiveType primitiveType4 = SHORT;
        PrimitiveType primitiveType5 = INT;
        PrimitiveType primitiveType6 = FLOAT;
        PrimitiveType primitiveType7 = LONG;
        $VALUES = new PrimitiveType[]{BOOLEAN, primitiveType2, primitiveType3, primitiveType4, primitiveType5, primitiveType6, primitiveType7, primitiveType};
        NUMBER_TYPES = Collections.unmodifiableSet(EnumSet.of(super, primitiveType3, primitiveType4, primitiveType5, primitiveType6, primitiveType7, primitiveType));
    }

    private PrimitiveType(String str, int i, String str2) {
        this.typeName = Name.identifier(str2);
        this.arrayTypeName = Name.identifier(str2 + "Array");
    }

    public Name getTypeName() {
        Name name = this.typeName;
        if (name == null) {
            $$$reportNull$$$0(0);
        }
        return name;
    }

    public FqName getTypeFqName() {
        FqName fqName = this.typeFqName;
        if (fqName != null) {
            if (fqName == null) {
                $$$reportNull$$$0(1);
            }
            return fqName;
        }
        FqName child = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName);
        this.typeFqName = child;
        if (child == null) {
            $$$reportNull$$$0(2);
        }
        return child;
    }

    public Name getArrayTypeName() {
        Name name = this.arrayTypeName;
        if (name == null) {
            $$$reportNull$$$0(3);
        }
        return name;
    }

    public FqName getArrayTypeFqName() {
        FqName fqName = this.arrayTypeFqName;
        if (fqName != null) {
            if (fqName == null) {
                $$$reportNull$$$0(4);
            }
            return fqName;
        }
        FqName child = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME.child(this.arrayTypeName);
        this.arrayTypeFqName = child;
        if (child == null) {
            $$$reportNull$$$0(5);
        }
        return child;
    }
}
