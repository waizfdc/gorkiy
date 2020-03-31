package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
public enum zzex {
    DOUBLE(0, zzez.SCALAR, zzfq.DOUBLE),
    FLOAT(1, zzez.SCALAR, zzfq.FLOAT),
    INT64(2, zzez.SCALAR, zzfq.LONG),
    UINT64(3, zzez.SCALAR, zzfq.LONG),
    INT32(4, zzez.SCALAR, zzfq.INT),
    FIXED64(5, zzez.SCALAR, zzfq.LONG),
    FIXED32(6, zzez.SCALAR, zzfq.INT),
    BOOL(7, zzez.SCALAR, zzfq.BOOLEAN),
    STRING(8, zzez.SCALAR, zzfq.STRING),
    MESSAGE(9, zzez.SCALAR, zzfq.MESSAGE),
    BYTES(10, zzez.SCALAR, zzfq.BYTE_STRING),
    UINT32(11, zzez.SCALAR, zzfq.INT),
    ENUM(12, zzez.SCALAR, zzfq.ENUM),
    SFIXED32(13, zzez.SCALAR, zzfq.INT),
    SFIXED64(14, zzez.SCALAR, zzfq.LONG),
    SINT32(15, zzez.SCALAR, zzfq.INT),
    SINT64(16, zzez.SCALAR, zzfq.LONG),
    GROUP(17, zzez.SCALAR, zzfq.MESSAGE),
    DOUBLE_LIST(18, zzez.VECTOR, zzfq.DOUBLE),
    FLOAT_LIST(19, zzez.VECTOR, zzfq.FLOAT),
    INT64_LIST(20, zzez.VECTOR, zzfq.LONG),
    UINT64_LIST(21, zzez.VECTOR, zzfq.LONG),
    INT32_LIST(22, zzez.VECTOR, zzfq.INT),
    FIXED64_LIST(23, zzez.VECTOR, zzfq.LONG),
    FIXED32_LIST(24, zzez.VECTOR, zzfq.INT),
    BOOL_LIST(25, zzez.VECTOR, zzfq.BOOLEAN),
    STRING_LIST(26, zzez.VECTOR, zzfq.STRING),
    MESSAGE_LIST(27, zzez.VECTOR, zzfq.MESSAGE),
    BYTES_LIST(28, zzez.VECTOR, zzfq.BYTE_STRING),
    UINT32_LIST(29, zzez.VECTOR, zzfq.INT),
    ENUM_LIST(30, zzez.VECTOR, zzfq.ENUM),
    SFIXED32_LIST(31, zzez.VECTOR, zzfq.INT),
    SFIXED64_LIST(32, zzez.VECTOR, zzfq.LONG),
    SINT32_LIST(33, zzez.VECTOR, zzfq.INT),
    SINT64_LIST(34, zzez.VECTOR, zzfq.LONG),
    DOUBLE_LIST_PACKED(35, zzez.PACKED_VECTOR, zzfq.DOUBLE),
    FLOAT_LIST_PACKED(36, zzez.PACKED_VECTOR, zzfq.FLOAT),
    INT64_LIST_PACKED(37, zzez.PACKED_VECTOR, zzfq.LONG),
    UINT64_LIST_PACKED(38, zzez.PACKED_VECTOR, zzfq.LONG),
    INT32_LIST_PACKED(39, zzez.PACKED_VECTOR, zzfq.INT),
    FIXED64_LIST_PACKED(40, zzez.PACKED_VECTOR, zzfq.LONG),
    FIXED32_LIST_PACKED(41, zzez.PACKED_VECTOR, zzfq.INT),
    BOOL_LIST_PACKED(42, zzez.PACKED_VECTOR, zzfq.BOOLEAN),
    UINT32_LIST_PACKED(43, zzez.PACKED_VECTOR, zzfq.INT),
    ENUM_LIST_PACKED(44, zzez.PACKED_VECTOR, zzfq.ENUM),
    SFIXED32_LIST_PACKED(45, zzez.PACKED_VECTOR, zzfq.INT),
    SFIXED64_LIST_PACKED(46, zzez.PACKED_VECTOR, zzfq.LONG),
    SINT32_LIST_PACKED(47, zzez.PACKED_VECTOR, zzfq.INT),
    SINT64_LIST_PACKED(48, zzez.PACKED_VECTOR, zzfq.LONG),
    GROUP_LIST(49, zzez.VECTOR, zzfq.MESSAGE),
    MAP(50, zzez.MAP, zzfq.VOID);
    
    private static final zzex[] zzbe;
    private static final Type[] zzbf = new Type[0];
    private final zzfq zzaz;
    private final int zzba;
    private final zzez zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    private zzex(int i, zzez zzez, zzfq zzfq) {
        int i2;
        this.zzba = i;
        this.zzbb = zzez;
        this.zzaz = zzfq;
        int i3 = zzfa.zza[zzez.ordinal()];
        boolean z = true;
        if (i3 == 1) {
            this.zzbc = zzfq.zza();
        } else if (i3 != 2) {
            this.zzbc = null;
        } else {
            this.zzbc = zzfq.zza();
        }
        this.zzbd = (zzez != zzez.SCALAR || (i2 = zzfa.zzb[zzfq.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int zza() {
        return this.zzba;
    }

    static {
        zzex[] values = values();
        zzbe = new zzex[values.length];
        for (zzex zzex : values) {
            zzbe[zzex.zzba] = zzex;
        }
    }
}
