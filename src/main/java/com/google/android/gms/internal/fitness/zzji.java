package com.google.android.gms.internal.fitness;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public enum zzji {
    DOUBLE(zzjl.DOUBLE, 1),
    FLOAT(zzjl.FLOAT, 5),
    INT64(zzjl.LONG, 0),
    UINT64(zzjl.LONG, 0),
    INT32(zzjl.INT, 0),
    FIXED64(zzjl.LONG, 1),
    FIXED32(zzjl.INT, 5),
    BOOL(zzjl.BOOLEAN, 0),
    STRING(zzjl.STRING, 2),
    GROUP(zzjl.MESSAGE, 3),
    MESSAGE(zzjl.MESSAGE, 2),
    BYTES(zzjl.BYTE_STRING, 2),
    UINT32(zzjl.INT, 0),
    ENUM(zzjl.ENUM, 0),
    SFIXED32(zzjl.INT, 5),
    SFIXED64(zzjl.LONG, 1),
    SINT32(zzjl.INT, 0),
    SINT64(zzjl.LONG, 0);
    
    private final zzjl zzaax;
    private final int zzaay;

    private zzji(zzjl zzjl, int i) {
        this.zzaax = zzjl;
        this.zzaay = i;
    }

    public final zzjl zzdl() {
        return this.zzaax;
    }

    public final int zzdm() {
        return this.zzaay;
    }

    /* synthetic */ zzji(zzjl zzjl, int i, zzjf zzjf) {
        this(r1, r2, zzjl, i);
    }
}
