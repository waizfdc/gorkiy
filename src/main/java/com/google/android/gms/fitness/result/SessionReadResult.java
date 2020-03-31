package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.zzad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class SessionReadResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<SessionReadResult> CREATOR = new zzh();
    private final List<Session> zzoo;
    private final Status zzqr;
    private final List<zzad> zzqw;

    public SessionReadResult(List<Session> list, List<zzad> list2, Status status) {
        this.zzoo = list;
        this.zzqw = Collections.unmodifiableList(list2);
        this.zzqr = status;
    }

    public static SessionReadResult zze(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    public List<Session> getSessions() {
        return this.zzoo;
    }

    public List<DataSet> getDataSet(Session session, DataType dataType) {
        Preconditions.checkArgument(this.zzoo.contains(session), "Attempting to read data for session %s which was not returned", session);
        ArrayList arrayList = new ArrayList();
        for (zzad next : this.zzqw) {
            if (Objects.equal(session, next.getSession()) && dataType.equals(next.getDataSet().getDataType())) {
                arrayList.add(next.getDataSet());
            }
        }
        return arrayList;
    }

    public List<DataSet> getDataSet(Session session) {
        Preconditions.checkArgument(this.zzoo.contains(session), "Attempting to read data for session %s which was not returned", session);
        ArrayList arrayList = new ArrayList();
        for (zzad next : this.zzqw) {
            if (Objects.equal(session, next.getSession())) {
                arrayList.add(next.getDataSet());
            }
        }
        return arrayList;
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SessionReadResult) {
                SessionReadResult sessionReadResult = (SessionReadResult) obj;
                if (this.zzqr.equals(sessionReadResult.zzqr) && Objects.equal(this.zzoo, sessionReadResult.zzoo) && Objects.equal(this.zzqw, sessionReadResult.zzqw)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zzoo, this.zzqw);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("status", this.zzqr).add("sessions", this.zzoo).add("sessionDataSets", this.zzqw).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getSessions(), false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzqw, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getStatus(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
