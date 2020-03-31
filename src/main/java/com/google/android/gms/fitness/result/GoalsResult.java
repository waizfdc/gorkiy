package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Goal;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class GoalsResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<GoalsResult> CREATOR = new zzf();
    private final Status zzqr;
    private final List<Goal> zzqu;

    public GoalsResult(Status status, List<Goal> list) {
        this.zzqr = status;
        this.zzqu = list;
    }

    public List<Goal> getGoals() {
        return this.zzqu;
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 2, getGoals(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
