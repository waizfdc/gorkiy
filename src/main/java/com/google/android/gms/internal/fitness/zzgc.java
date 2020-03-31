package com.google.android.gms.internal.fitness;

import java.lang.reflect.Type;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public enum zzgc {
    DOUBLE(0, zzge.SCALAR, zzgq.DOUBLE),
    FLOAT(1, zzge.SCALAR, zzgq.FLOAT),
    INT64(2, zzge.SCALAR, zzgq.LONG),
    UINT64(3, zzge.SCALAR, zzgq.LONG),
    INT32(4, zzge.SCALAR, zzgq.INT),
    FIXED64(5, zzge.SCALAR, zzgq.LONG),
    FIXED32(6, zzge.SCALAR, zzgq.INT),
    BOOL(7, zzge.SCALAR, zzgq.BOOLEAN),
    STRING(8, zzge.SCALAR, zzgq.STRING),
    MESSAGE(9, zzge.SCALAR, zzgq.MESSAGE),
    BYTES(10, zzge.SCALAR, zzgq.BYTE_STRING),
    UINT32(11, zzge.SCALAR, zzgq.INT),
    ENUM(12, zzge.SCALAR, zzgq.ENUM),
    SFIXED32(13, zzge.SCALAR, zzgq.INT),
    SFIXED64(14, zzge.SCALAR, zzgq.LONG),
    SINT32(15, zzge.SCALAR, zzgq.INT),
    SINT64(16, zzge.SCALAR, zzgq.LONG),
    GROUP(17, zzge.SCALAR, zzgq.MESSAGE),
    DOUBLE_LIST(18, zzge.VECTOR, zzgq.DOUBLE),
    FLOAT_LIST(19, zzge.VECTOR, zzgq.FLOAT),
    INT64_LIST(20, zzge.VECTOR, zzgq.LONG),
    UINT64_LIST(21, zzge.VECTOR, zzgq.LONG),
    INT32_LIST(22, zzge.VECTOR, zzgq.INT),
    FIXED64_LIST(23, zzge.VECTOR, zzgq.LONG),
    FIXED32_LIST(24, zzge.VECTOR, zzgq.INT),
    BOOL_LIST(25, zzge.VECTOR, zzgq.BOOLEAN),
    STRING_LIST(26, zzge.VECTOR, zzgq.STRING),
    MESSAGE_LIST(27, zzge.VECTOR, zzgq.MESSAGE),
    BYTES_LIST(28, zzge.VECTOR, zzgq.BYTE_STRING),
    UINT32_LIST(29, zzge.VECTOR, zzgq.INT),
    ENUM_LIST(30, zzge.VECTOR, zzgq.ENUM),
    SFIXED32_LIST(31, zzge.VECTOR, zzgq.INT),
    SFIXED64_LIST(32, zzge.VECTOR, zzgq.LONG),
    SINT32_LIST(33, zzge.VECTOR, zzgq.INT),
    SINT64_LIST(34, zzge.VECTOR, zzgq.LONG),
    DOUBLE_LIST_PACKED(35, zzge.PACKED_VECTOR, zzgq.DOUBLE),
    FLOAT_LIST_PACKED(36, zzge.PACKED_VECTOR, zzgq.FLOAT),
    INT64_LIST_PACKED(37, zzge.PACKED_VECTOR, zzgq.LONG),
    UINT64_LIST_PACKED(38, zzge.PACKED_VECTOR, zzgq.LONG),
    INT32_LIST_PACKED(39, zzge.PACKED_VECTOR, zzgq.INT),
    FIXED64_LIST_PACKED(40, zzge.PACKED_VECTOR, zzgq.LONG),
    FIXED32_LIST_PACKED(41, zzge.PACKED_VECTOR, zzgq.INT),
    BOOL_LIST_PACKED(42, zzge.PACKED_VECTOR, zzgq.BOOLEAN),
    UINT32_LIST_PACKED(43, zzge.PACKED_VECTOR, zzgq.INT),
    ENUM_LIST_PACKED(44, zzge.PACKED_VECTOR, zzgq.ENUM),
    SFIXED32_LIST_PACKED(45, zzge.PACKED_VECTOR, zzgq.INT),
    SFIXED64_LIST_PACKED(46, zzge.PACKED_VECTOR, zzgq.LONG),
    SINT32_LIST_PACKED(47, zzge.PACKED_VECTOR, zzgq.INT),
    SINT64_LIST_PACKED(48, zzge.PACKED_VECTOR, zzgq.LONG),
    GROUP_LIST(49, zzge.VECTOR, zzgq.MESSAGE),
    MAP(50, zzge.MAP, zzgq.VOID);
    
    private static final zzgc[] zzuq;
    private static final Type[] zzur = new Type[0];
    private final int id;
    private final zzgq zzum;
    private final zzge zzun;
    private final Class<?> zzuo;
    private final boolean zzup;

    private zzgc(int i, zzge zzge, zzgq zzgq) {
        int i2;
        this.id = i;
        this.zzun = zzge;
        this.zzum = zzgq;
        int i3 = zzgf.zzuz[zzge.ordinal()];
        boolean z = true;
        if (i3 == 1) {
            this.zzuo = zzgq.zzbv();
        } else if (i3 != 2) {
            this.zzuo = null;
        } else {
            this.zzuo = zzgq.zzbv();
        }
        this.zzup = (zzge != zzge.SCALAR || (i2 = zzgf.zzva[zzgq.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int id() {
        return this.id;
    }

    static {
        zzgc[] values = values();
        zzuq = new zzgc[values.length];
        for (zzgc zzgc : values) {
            zzuq[zzgc.id] = zzgc;
        }
    }
}
