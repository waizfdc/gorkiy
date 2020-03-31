package com.askgps.personaltrackercore.database.model;

import com.google.android.gms.fitness.FitnessActivities;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/askgps/personaltrackercore/database/model/CheckDeviceResponse;", "", "status", "", "(Ljava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "component1", "copy", "equals", "", FitnessActivities.OTHER, "hashCode", "", "toString", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: model.kt */
public final class CheckDeviceResponse {
    @SerializedName("status")
    private final String status;

    public static /* synthetic */ CheckDeviceResponse copy$default(CheckDeviceResponse checkDeviceResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkDeviceResponse.status;
        }
        return checkDeviceResponse.copy(str);
    }

    public final String component1() {
        return this.status;
    }

    public final CheckDeviceResponse copy(String str) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        return new CheckDeviceResponse(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CheckDeviceResponse) && Intrinsics.areEqual(this.status, ((CheckDeviceResponse) obj).status);
        }
        return true;
    }

    public int hashCode() {
        String str = this.status;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CheckDeviceResponse(status=" + this.status + ")";
    }

    public CheckDeviceResponse(String str) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        this.status = str;
    }

    public final String getStatus() {
        return this.status;
    }
}
