package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
public class zzfo extends IOException {
    private zzgo zza = null;

    public zzfo(String str) {
        super(str);
    }

    static zzfo zza() {
        return new zzfo("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzfo zzb() {
        return new zzfo("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzfo zzc() {
        return new zzfo("CodedInputStream encountered a malformed varint.");
    }

    static zzfo zzd() {
        return new zzfo("Protocol message contained an invalid tag (zero).");
    }

    static zzfo zze() {
        return new zzfo("Protocol message end-group tag did not match expected tag.");
    }

    static zzfn zzf() {
        return new zzfn("Protocol message tag had invalid wire type.");
    }

    static zzfo zzg() {
        return new zzfo("Failed to parse the message.");
    }

    static zzfo zzh() {
        return new zzfo("Protocol message had invalid UTF-8.");
    }
}
