package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class ListSubscriptionsResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<ListSubscriptionsResult> CREATOR = new zzg();
    private final Status zzqr;
    private final List<Subscription> zzqv;

    public ListSubscriptionsResult(List<Subscription> list, Status status) {
        this.zzqv = list;
        this.zzqr = status;
    }

    public static ListSubscriptionsResult zzd(Status status) {
        return new ListSubscriptionsResult(Collections.emptyList(), status);
    }

    public List<Subscription> getSubscriptions() {
        return this.zzqv;
    }

    public List<Subscription> getSubscriptions(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (Subscription next : this.zzqv) {
            if (dataType.equals(next.zzu())) {
                arrayList.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzqr;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ListSubscriptionsResult) {
                ListSubscriptionsResult listSubscriptionsResult = (ListSubscriptionsResult) obj;
                if (this.zzqr.equals(listSubscriptionsResult.zzqr) && Objects.equal(this.zzqv, listSubscriptionsResult.zzqv)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzqr, this.zzqv);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("status", this.zzqr).add("subscriptions", this.zzqv).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getSubscriptions(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, getStatus(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
