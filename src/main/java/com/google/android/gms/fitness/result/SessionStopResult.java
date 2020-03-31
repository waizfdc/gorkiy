package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Session;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class SessionStopResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<SessionStopResult> CREATOR = new zzi();
    private final List<Session> zzoo;
    private final Status zzqr;

    public SessionStopResult(Status status, List<Session> list) {
        this.zzqr = status;
        this.zzoo = Collections.unmodifiableList(list);
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public List<Session> getSessions() {
        return this.zzoo;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SessionStopResult) {
                SessionStopResult sessionStopResult = (SessionStopResult) obj;
                if (this.zzqr.equals(sessionStopResult.zzqr) && Objects.equal(this.zzoo, sessionStopResult.zzoo)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zzoo);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("status", this.zzqr).add("sessions", this.zzoo).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getStatus(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 3, getSessions(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
