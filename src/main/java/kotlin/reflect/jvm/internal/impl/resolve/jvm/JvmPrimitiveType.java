package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import androidx.exifinterface.media.ExifInterface;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

public enum JvmPrimitiveType {
    BOOLEAN(PrimitiveType.BOOLEAN, "boolean", "Z", "java.lang.Boolean"),
    CHAR(PrimitiveType.CHAR, "char", "C", "java.lang.Character"),
    BYTE(PrimitiveType.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(PrimitiveType.SHORT, "short", ExifInterface.LATITUDE_SOUTH, "java.lang.Short"),
    INT(PrimitiveType.INT, "int", "I", "java.lang.Integer"),
    FLOAT(PrimitiveType.FLOAT, "float", "F", "java.lang.Float"),
    LONG(PrimitiveType.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");
    
    private static final Map<String, JvmPrimitiveType> TYPE_BY_DESC = new HashMap();
    private static final Map<String, JvmPrimitiveType> TYPE_BY_NAME = new HashMap();
    private static final Map<PrimitiveType, JvmPrimitiveType> TYPE_BY_PRIMITIVE_TYPE = new EnumMap(PrimitiveType.class);
    private static final Set<FqName> WRAPPERS_CLASS_NAMES = new HashSet();
    private final String desc;
    private final String name;
    private final PrimitiveType primitiveType;
    private final FqName wrapperFqName;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ void $$$reportNull$$$0(int r7) {
        /*
            r0 = 4
            r1 = 2
            if (r7 == r1) goto L_0x000c
            if (r7 == r0) goto L_0x000c
            switch(r7) {
                case 10: goto L_0x000c;
                case 11: goto L_0x000c;
                case 12: goto L_0x000c;
                case 13: goto L_0x000c;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L_0x000e
        L_0x000c:
            java.lang.String r2 = "@NotNull method %s.%s must not return null"
        L_0x000e:
            if (r7 == r1) goto L_0x0017
            if (r7 == r0) goto L_0x0017
            switch(r7) {
                case 10: goto L_0x0017;
                case 11: goto L_0x0017;
                case 12: goto L_0x0017;
                case 13: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            r3 = 3
            goto L_0x0018
        L_0x0017:
            r3 = r1
        L_0x0018:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType"
            r5 = 0
            switch(r7) {
                case 1: goto L_0x003c;
                case 2: goto L_0x0039;
                case 3: goto L_0x0034;
                case 4: goto L_0x0039;
                case 5: goto L_0x002f;
                case 6: goto L_0x002a;
                case 7: goto L_0x003c;
                case 8: goto L_0x002f;
                case 9: goto L_0x0025;
                case 10: goto L_0x0039;
                case 11: goto L_0x0039;
                case 12: goto L_0x0039;
                case 13: goto L_0x0039;
                default: goto L_0x0020;
            }
        L_0x0020:
            java.lang.String r6 = "className"
            r3[r5] = r6
            goto L_0x0040
        L_0x0025:
            java.lang.String r6 = "wrapperClassName"
            r3[r5] = r6
            goto L_0x0040
        L_0x002a:
            java.lang.String r6 = "primitiveType"
            r3[r5] = r6
            goto L_0x0040
        L_0x002f:
            java.lang.String r6 = "desc"
            r3[r5] = r6
            goto L_0x0040
        L_0x0034:
            java.lang.String r6 = "type"
            r3[r5] = r6
            goto L_0x0040
        L_0x0039:
            r3[r5] = r4
            goto L_0x0040
        L_0x003c:
            java.lang.String r6 = "name"
            r3[r5] = r6
        L_0x0040:
            java.lang.String r5 = "get"
            r6 = 1
            if (r7 == r1) goto L_0x0061
            if (r7 == r0) goto L_0x0061
            switch(r7) {
                case 10: goto L_0x005c;
                case 11: goto L_0x0057;
                case 12: goto L_0x0052;
                case 13: goto L_0x004d;
                default: goto L_0x004a;
            }
        L_0x004a:
            r3[r6] = r4
            goto L_0x0063
        L_0x004d:
            java.lang.String r4 = "getWrapperFqName"
            r3[r6] = r4
            goto L_0x0063
        L_0x0052:
            java.lang.String r4 = "getDesc"
            r3[r6] = r4
            goto L_0x0063
        L_0x0057:
            java.lang.String r4 = "getJavaKeywordName"
            r3[r6] = r4
            goto L_0x0063
        L_0x005c:
            java.lang.String r4 = "getPrimitiveType"
            r3[r6] = r4
            goto L_0x0063
        L_0x0061:
            r3[r6] = r5
        L_0x0063:
            switch(r7) {
                case 1: goto L_0x0075;
                case 2: goto L_0x0077;
                case 3: goto L_0x0075;
                case 4: goto L_0x0077;
                case 5: goto L_0x0070;
                case 6: goto L_0x006b;
                case 7: goto L_0x006b;
                case 8: goto L_0x006b;
                case 9: goto L_0x006b;
                case 10: goto L_0x0077;
                case 11: goto L_0x0077;
                case 12: goto L_0x0077;
                case 13: goto L_0x0077;
                default: goto L_0x0066;
            }
        L_0x0066:
            java.lang.String r4 = "isWrapperClassName"
            r3[r1] = r4
            goto L_0x0077
        L_0x006b:
            java.lang.String r4 = "<init>"
            r3[r1] = r4
            goto L_0x0077
        L_0x0070:
            java.lang.String r4 = "getByDesc"
            r3[r1] = r4
            goto L_0x0077
        L_0x0075:
            r3[r1] = r5
        L_0x0077:
            java.lang.String r2 = java.lang.String.format(r2, r3)
            if (r7 == r1) goto L_0x0088
            if (r7 == r0) goto L_0x0088
            switch(r7) {
                case 10: goto L_0x0088;
                case 11: goto L_0x0088;
                case 12: goto L_0x0088;
                case 13: goto L_0x0088;
                default: goto L_0x0082;
            }
        L_0x0082:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r7.<init>(r2)
            goto L_0x008d
        L_0x0088:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>(r2)
        L_0x008d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.$$$reportNull$$$0(int):void");
    }

    static {
        for (JvmPrimitiveType jvmPrimitiveType : values()) {
            WRAPPERS_CLASS_NAMES.add(jvmPrimitiveType.getWrapperFqName());
            TYPE_BY_NAME.put(jvmPrimitiveType.getJavaKeywordName(), jvmPrimitiveType);
            TYPE_BY_PRIMITIVE_TYPE.put(jvmPrimitiveType.getPrimitiveType(), jvmPrimitiveType);
            TYPE_BY_DESC.put(jvmPrimitiveType.getDesc(), jvmPrimitiveType);
        }
    }

    public static JvmPrimitiveType get(String str) {
        if (str == null) {
            $$$reportNull$$$0(1);
        }
        JvmPrimitiveType jvmPrimitiveType = TYPE_BY_NAME.get(str);
        if (jvmPrimitiveType != null) {
            if (jvmPrimitiveType == null) {
                $$$reportNull$$$0(2);
            }
            return jvmPrimitiveType;
        }
        throw new AssertionError("Non-primitive type name passed: " + str);
    }

    public static JvmPrimitiveType get(PrimitiveType primitiveType2) {
        if (primitiveType2 == null) {
            $$$reportNull$$$0(3);
        }
        JvmPrimitiveType jvmPrimitiveType = TYPE_BY_PRIMITIVE_TYPE.get(primitiveType2);
        if (jvmPrimitiveType == null) {
            $$$reportNull$$$0(4);
        }
        return jvmPrimitiveType;
    }

    private JvmPrimitiveType(PrimitiveType primitiveType2, String str, String str2, String str3) {
        if (primitiveType2 == null) {
            $$$reportNull$$$0(6);
        }
        if (str == null) {
            $$$reportNull$$$0(7);
        }
        if (str2 == null) {
            $$$reportNull$$$0(8);
        }
        if (str3 == null) {
            $$$reportNull$$$0(9);
        }
        this.primitiveType = primitiveType2;
        this.name = str;
        this.desc = str2;
        this.wrapperFqName = new FqName(str3);
    }

    public PrimitiveType getPrimitiveType() {
        PrimitiveType primitiveType2 = this.primitiveType;
        if (primitiveType2 == null) {
            $$$reportNull$$$0(10);
        }
        return primitiveType2;
    }

    public String getJavaKeywordName() {
        String str = this.name;
        if (str == null) {
            $$$reportNull$$$0(11);
        }
        return str;
    }

    public String getDesc() {
        String str = this.desc;
        if (str == null) {
            $$$reportNull$$$0(12);
        }
        return str;
    }

    public FqName getWrapperFqName() {
        FqName fqName = this.wrapperFqName;
        if (fqName == null) {
            $$$reportNull$$$0(13);
        }
        return fqName;
    }
}
