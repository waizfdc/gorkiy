package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public enum zzka {
    DOUBLE(zzkd.DOUBLE, 1),
    FLOAT(zzkd.FLOAT, 5),
    INT64(zzkd.LONG, 0),
    UINT64(zzkd.LONG, 0),
    INT32(zzkd.INT, 0),
    FIXED64(zzkd.LONG, 1),
    FIXED32(zzkd.INT, 5),
    BOOL(zzkd.BOOLEAN, 0),
    STRING(zzkd.STRING, 2),
    GROUP(zzkd.MESSAGE, 3),
    MESSAGE(zzkd.MESSAGE, 2),
    BYTES(zzkd.BYTE_STRING, 2),
    UINT32(zzkd.INT, 0),
    ENUM(zzkd.ENUM, 0),
    SFIXED32(zzkd.INT, 5),
    SFIXED64(zzkd.LONG, 1),
    SINT32(zzkd.INT, 0),
    SINT64(zzkd.LONG, 0);
    
    private final zzkd zzace;
    private final int zzacf;

    private zzka(zzkd zzkd, int i) {
        this.zzace = zzkd;
        this.zzacf = i;
    }

    public final zzkd zzip() {
        return this.zzace;
    }

    public final int zziq() {
        return this.zzacf;
    }

    /* synthetic */ zzka(zzkd zzkd, int i, zzjx zzjx) {
        this(r1, r2, zzkd, i);
    }
}
