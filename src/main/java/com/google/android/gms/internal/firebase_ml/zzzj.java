package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public enum zzzj {
    DOUBLE(zzzm.DOUBLE, 1),
    FLOAT(zzzm.FLOAT, 5),
    INT64(zzzm.LONG, 0),
    UINT64(zzzm.LONG, 0),
    INT32(zzzm.INT, 0),
    FIXED64(zzzm.LONG, 1),
    FIXED32(zzzm.INT, 5),
    BOOL(zzzm.BOOLEAN, 0),
    STRING(zzzm.STRING, 2),
    GROUP(zzzm.MESSAGE, 3),
    MESSAGE(zzzm.MESSAGE, 2),
    BYTES(zzzm.BYTE_STRING, 2),
    UINT32(zzzm.INT, 0),
    ENUM(zzzm.ENUM, 0),
    SFIXED32(zzzm.INT, 5),
    SFIXED64(zzzm.LONG, 1),
    SINT32(zzzm.INT, 0),
    SINT64(zzzm.LONG, 0);
    
    private final zzzm zzcjp;
    private final int zzcjq;

    private zzzj(zzzm zzzm, int i) {
        this.zzcjp = zzzm;
        this.zzcjq = i;
    }

    public final zzzm zzwl() {
        return this.zzcjp;
    }

    public final int zzwm() {
        return this.zzcjq;
    }

    /* synthetic */ zzzj(zzzm zzzm, int i, zzzg zzzg) {
        this(r1, r2, zzzm, i);
    }
}
