package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public class zzwg extends IOException {
    private zzxg zzced = null;

    public zzwg(String str) {
        super(str);
    }

    public final zzwg zzg(zzxg zzxg) {
        this.zzced = zzxg;
        return this;
    }

    static zzwg zzui() {
        return new zzwg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzwg zzuj() {
        return new zzwg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzwg zzuk() {
        return new zzwg("Protocol message contained an invalid tag (zero).");
    }

    static zzwj zzul() {
        return new zzwj("Protocol message tag had invalid wire type.");
    }

    static zzwg zzum() {
        return new zzwg("Failed to parse the message.");
    }

    static zzwg zzun() {
        return new zzwg("Protocol message had invalid UTF-8.");
    }
}
