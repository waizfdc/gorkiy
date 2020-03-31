package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
public enum zzim {
    DOUBLE(zzip.DOUBLE, 1),
    FLOAT(zzip.FLOAT, 5),
    INT64(zzip.LONG, 0),
    UINT64(zzip.LONG, 0),
    INT32(zzip.INT, 0),
    FIXED64(zzip.LONG, 1),
    FIXED32(zzip.INT, 5),
    BOOL(zzip.BOOLEAN, 0),
    STRING(zzip.STRING, 2),
    GROUP(zzip.MESSAGE, 3),
    MESSAGE(zzip.MESSAGE, 2),
    BYTES(zzip.BYTE_STRING, 2),
    UINT32(zzip.INT, 0),
    ENUM(zzip.ENUM, 0),
    SFIXED32(zzip.INT, 5),
    SFIXED64(zzip.LONG, 1),
    SINT32(zzip.INT, 0),
    SINT64(zzip.LONG, 0);
    
    private final zzip zzs;
    private final int zzt;

    private zzim(zzip zzip, int i) {
        this.zzs = zzip;
        this.zzt = i;
    }

    public final zzip zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* synthetic */ zzim(zzip zzip, int i, zzij zzij) {
        this(r1, r2, zzip, i);
    }
}
