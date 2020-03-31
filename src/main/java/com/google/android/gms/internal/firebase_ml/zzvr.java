package com.google.android.gms.internal.firebase_ml;

import java.lang.reflect.Type;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public enum zzvr {
    DOUBLE(0, zzvt.SCALAR, zzwi.DOUBLE),
    FLOAT(1, zzvt.SCALAR, zzwi.FLOAT),
    INT64(2, zzvt.SCALAR, zzwi.LONG),
    UINT64(3, zzvt.SCALAR, zzwi.LONG),
    INT32(4, zzvt.SCALAR, zzwi.INT),
    FIXED64(5, zzvt.SCALAR, zzwi.LONG),
    FIXED32(6, zzvt.SCALAR, zzwi.INT),
    BOOL(7, zzvt.SCALAR, zzwi.BOOLEAN),
    STRING(8, zzvt.SCALAR, zzwi.STRING),
    MESSAGE(9, zzvt.SCALAR, zzwi.MESSAGE),
    BYTES(10, zzvt.SCALAR, zzwi.BYTE_STRING),
    UINT32(11, zzvt.SCALAR, zzwi.INT),
    ENUM(12, zzvt.SCALAR, zzwi.ENUM),
    SFIXED32(13, zzvt.SCALAR, zzwi.INT),
    SFIXED64(14, zzvt.SCALAR, zzwi.LONG),
    SINT32(15, zzvt.SCALAR, zzwi.INT),
    SINT64(16, zzvt.SCALAR, zzwi.LONG),
    GROUP(17, zzvt.SCALAR, zzwi.MESSAGE),
    DOUBLE_LIST(18, zzvt.VECTOR, zzwi.DOUBLE),
    FLOAT_LIST(19, zzvt.VECTOR, zzwi.FLOAT),
    INT64_LIST(20, zzvt.VECTOR, zzwi.LONG),
    UINT64_LIST(21, zzvt.VECTOR, zzwi.LONG),
    INT32_LIST(22, zzvt.VECTOR, zzwi.INT),
    FIXED64_LIST(23, zzvt.VECTOR, zzwi.LONG),
    FIXED32_LIST(24, zzvt.VECTOR, zzwi.INT),
    BOOL_LIST(25, zzvt.VECTOR, zzwi.BOOLEAN),
    STRING_LIST(26, zzvt.VECTOR, zzwi.STRING),
    MESSAGE_LIST(27, zzvt.VECTOR, zzwi.MESSAGE),
    BYTES_LIST(28, zzvt.VECTOR, zzwi.BYTE_STRING),
    UINT32_LIST(29, zzvt.VECTOR, zzwi.INT),
    ENUM_LIST(30, zzvt.VECTOR, zzwi.ENUM),
    SFIXED32_LIST(31, zzvt.VECTOR, zzwi.INT),
    SFIXED64_LIST(32, zzvt.VECTOR, zzwi.LONG),
    SINT32_LIST(33, zzvt.VECTOR, zzwi.INT),
    SINT64_LIST(34, zzvt.VECTOR, zzwi.LONG),
    DOUBLE_LIST_PACKED(35, zzvt.PACKED_VECTOR, zzwi.DOUBLE),
    FLOAT_LIST_PACKED(36, zzvt.PACKED_VECTOR, zzwi.FLOAT),
    INT64_LIST_PACKED(37, zzvt.PACKED_VECTOR, zzwi.LONG),
    UINT64_LIST_PACKED(38, zzvt.PACKED_VECTOR, zzwi.LONG),
    INT32_LIST_PACKED(39, zzvt.PACKED_VECTOR, zzwi.INT),
    FIXED64_LIST_PACKED(40, zzvt.PACKED_VECTOR, zzwi.LONG),
    FIXED32_LIST_PACKED(41, zzvt.PACKED_VECTOR, zzwi.INT),
    BOOL_LIST_PACKED(42, zzvt.PACKED_VECTOR, zzwi.BOOLEAN),
    UINT32_LIST_PACKED(43, zzvt.PACKED_VECTOR, zzwi.INT),
    ENUM_LIST_PACKED(44, zzvt.PACKED_VECTOR, zzwi.ENUM),
    SFIXED32_LIST_PACKED(45, zzvt.PACKED_VECTOR, zzwi.INT),
    SFIXED64_LIST_PACKED(46, zzvt.PACKED_VECTOR, zzwi.LONG),
    SINT32_LIST_PACKED(47, zzvt.PACKED_VECTOR, zzwi.INT),
    SINT64_LIST_PACKED(48, zzvt.PACKED_VECTOR, zzwi.LONG),
    GROUP_LIST(49, zzvt.VECTOR, zzwi.MESSAGE),
    MAP(50, zzvt.MAP, zzwi.VOID);
    
    private static final zzvr[] zzccp;
    private static final Type[] zzccq = new Type[0];
    private final int id;
    private final zzwi zzccl;
    private final zzvt zzccm;
    private final Class<?> zzccn;
    private final boolean zzcco;

    private zzvr(int i, zzvt zzvt, zzwi zzwi) {
        int i2;
        this.id = i;
        this.zzccm = zzvt;
        this.zzccl = zzwi;
        int i3 = zzvu.zzccy[zzvt.ordinal()];
        boolean z = true;
        if (i3 == 1) {
            this.zzccn = zzwi.zzuo();
        } else if (i3 != 2) {
            this.zzccn = null;
        } else {
            this.zzccn = zzwi.zzuo();
        }
        this.zzcco = (zzvt != zzvt.SCALAR || (i2 = zzvu.zzccz[zzwi.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int id() {
        return this.id;
    }

    static {
        zzvr[] values = values();
        zzccp = new zzvr[values.length];
        for (zzvr zzvr : values) {
            zzccp[zzvr.id] = zzvr;
        }
    }
}
