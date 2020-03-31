package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public class zzhc extends IOException {
    private zzic zzxh = null;

    public zzhc(String str) {
        super(str);
    }

    public final zzhc zzg(zzic zzic) {
        this.zzxh = zzic;
        return this;
    }

    static zzhc zzgm() {
        return new zzhc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzhc zzgn() {
        return new zzhc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzhc zzgo() {
        return new zzhc("CodedInputStream encountered a malformed varint.");
    }

    static zzhc zzgp() {
        return new zzhc("Protocol message contained an invalid tag (zero).");
    }

    static zzhc zzgq() {
        return new zzhc("Protocol message end-group tag did not match expected tag.");
    }

    static zzhb zzgr() {
        return new zzhb("Protocol message tag had invalid wire type.");
    }

    static zzhc zzgs() {
        return new zzhc("Failed to parse the message.");
    }

    static zzhc zzgt() {
        return new zzhc("Protocol message had invalid UTF-8.");
    }
}
