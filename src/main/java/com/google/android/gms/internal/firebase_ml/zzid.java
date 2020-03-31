package com.google.android.gms.internal.firebase_ml;

import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final class zzid extends zzhx {
    private final zzsi zzacp;
    private final zzic zzacq;
    private List<String> zzacr = new ArrayList();
    private zzhz zzacs;
    private String zzact;

    zzid(zzic zzic, zzsi zzsi) {
        this.zzacq = zzic;
        this.zzacp = zzsi;
        zzsi.setLenient(true);
    }

    public final void close() throws IOException {
        this.zzacp.close();
    }

    public final String zzhc() {
        if (this.zzacr.isEmpty()) {
            return null;
        }
        List<String> list = this.zzacr;
        return list.get(list.size() - 1);
    }

    public final zzhz zzhb() {
        return this.zzacs;
    }

    public final zzht zzgz() {
        return this.zzacq;
    }

    public final byte zzhe() {
        zzhr();
        return Byte.parseByte(this.zzact);
    }

    public final short zzhf() {
        zzhr();
        return Short.parseShort(this.zzact);
    }

    public final int getIntValue() {
        zzhr();
        return Integer.parseInt(this.zzact);
    }

    public final float zzhg() {
        zzhr();
        return Float.parseFloat(this.zzact);
    }

    public final BigInteger zzhj() {
        zzhr();
        return new BigInteger(this.zzact);
    }

    public final BigDecimal zzhk() {
        zzhr();
        return new BigDecimal(this.zzact);
    }

    public final double zzhi() {
        zzhr();
        return Double.parseDouble(this.zzact);
    }

    public final long zzhh() {
        zzhr();
        return Long.parseLong(this.zzact);
    }

    private final void zzhr() {
        zzmf.checkArgument(this.zzacs == zzhz.VALUE_NUMBER_INT || this.zzacs == zzhz.VALUE_NUMBER_FLOAT);
    }

    public final String getText() {
        return this.zzact;
    }

    public final zzhz zzha() throws IOException {
        zzsk zzsk;
        zzhz zzhz;
        if (this.zzacs != null) {
            int i = zzig.zzaby[this.zzacs.ordinal()];
            if (i == 1) {
                this.zzacp.beginArray();
                this.zzacr.add(null);
            } else if (i == 2) {
                this.zzacp.beginObject();
                this.zzacr.add(null);
            }
        }
        try {
            zzsk = this.zzacp.zzqk();
        } catch (EOFException unused) {
            zzsk = zzsk.END_DOCUMENT;
        }
        switch (zzig.zzacv[zzsk.ordinal()]) {
            case 1:
                this.zzact = "[";
                this.zzacs = zzhz.START_ARRAY;
                break;
            case 2:
                this.zzact = "]";
                this.zzacs = zzhz.END_ARRAY;
                List<String> list = this.zzacr;
                list.remove(list.size() - 1);
                this.zzacp.endArray();
                break;
            case 3:
                this.zzact = "{";
                this.zzacs = zzhz.START_OBJECT;
                break;
            case 4:
                this.zzact = "}";
                this.zzacs = zzhz.END_OBJECT;
                List<String> list2 = this.zzacr;
                list2.remove(list2.size() - 1);
                this.zzacp.endObject();
                break;
            case 5:
                if (!this.zzacp.nextBoolean()) {
                    this.zzact = "false";
                    this.zzacs = zzhz.VALUE_FALSE;
                    break;
                } else {
                    this.zzact = "true";
                    this.zzacs = zzhz.VALUE_TRUE;
                    break;
                }
            case 6:
                this.zzact = "null";
                this.zzacs = zzhz.VALUE_NULL;
                this.zzacp.nextNull();
                break;
            case 7:
                this.zzact = this.zzacp.nextString();
                this.zzacs = zzhz.VALUE_STRING;
                break;
            case 8:
                String nextString = this.zzacp.nextString();
                this.zzact = nextString;
                if (nextString.indexOf(46) == -1) {
                    zzhz = zzhz.VALUE_NUMBER_INT;
                } else {
                    zzhz = zzhz.VALUE_NUMBER_FLOAT;
                }
                this.zzacs = zzhz;
                break;
            case 9:
                this.zzact = this.zzacp.nextName();
                this.zzacs = zzhz.FIELD_NAME;
                List<String> list3 = this.zzacr;
                list3.set(list3.size() - 1, this.zzact);
                break;
            default:
                this.zzact = null;
                this.zzacs = null;
                break;
        }
        return this.zzacs;
    }

    public final zzhx zzhd() throws IOException {
        if (this.zzacs != null) {
            int i = zzig.zzaby[this.zzacs.ordinal()];
            if (i == 1) {
                this.zzacp.skipValue();
                this.zzact = "]";
                this.zzacs = zzhz.END_ARRAY;
            } else if (i == 2) {
                this.zzacp.skipValue();
                this.zzact = "}";
                this.zzacs = zzhz.END_OBJECT;
            }
        }
        return super;
    }
}
