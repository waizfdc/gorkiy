package com.google.android.datatransport.cct.a;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
final class zzl extends zzx {
    private final long zza;

    zzl(long j) {
        this.zza = j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzx)) {
            return false;
        }
        if (this.zza == ((zzx) obj).zza()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.zza;
        return ((int) (j ^ (j >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.zza + "}";
    }

    public long zza() {
        return this.zza;
    }
}
