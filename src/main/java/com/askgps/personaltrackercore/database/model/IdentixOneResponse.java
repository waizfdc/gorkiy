package com.askgps.personaltrackercore.database.model;

import com.google.android.gms.fitness.FitnessActivities;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/askgps/personaltrackercore/database/model/IdentixOneResponse;", "", "conf", "", "idxId", "age", "", "sex", "mood", "liveness", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getAge", "()I", "getConf", "()Ljava/lang/String;", "getIdxId", "getLiveness", "getMood", "getSex", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", FitnessActivities.OTHER, "hashCode", "toString", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: model.kt */
public final class IdentixOneResponse {
    @SerializedName("age")
    private final int age;
    @SerializedName("conf")
    private final String conf;
    @SerializedName("idxid")
    private final String idxId;
    @SerializedName("liveness")
    private final String liveness;
    @SerializedName("mood")
    private final String mood;
    @SerializedName("sex")
    private final int sex;

    public static /* synthetic */ IdentixOneResponse copy$default(IdentixOneResponse identixOneResponse, String str, String str2, int i, int i2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = identixOneResponse.conf;
        }
        if ((i3 & 2) != 0) {
            str2 = identixOneResponse.idxId;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            i = identixOneResponse.age;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = identixOneResponse.sex;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            str3 = identixOneResponse.mood;
        }
        String str6 = str3;
        if ((i3 & 32) != 0) {
            str4 = identixOneResponse.liveness;
        }
        return identixOneResponse.copy(str, str5, i4, i5, str6, str4);
    }

    public final String component1() {
        return this.conf;
    }

    public final String component2() {
        return this.idxId;
    }

    public final int component3() {
        return this.age;
    }

    public final int component4() {
        return this.sex;
    }

    public final String component5() {
        return this.mood;
    }

    public final String component6() {
        return this.liveness;
    }

    public final IdentixOneResponse copy(String str, String str2, int i, int i2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "conf");
        Intrinsics.checkParameterIsNotNull(str2, "idxId");
        Intrinsics.checkParameterIsNotNull(str3, "mood");
        Intrinsics.checkParameterIsNotNull(str4, "liveness");
        return new IdentixOneResponse(str, str2, i, i2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdentixOneResponse)) {
            return false;
        }
        IdentixOneResponse identixOneResponse = (IdentixOneResponse) obj;
        return Intrinsics.areEqual(this.conf, identixOneResponse.conf) && Intrinsics.areEqual(this.idxId, identixOneResponse.idxId) && this.age == identixOneResponse.age && this.sex == identixOneResponse.sex && Intrinsics.areEqual(this.mood, identixOneResponse.mood) && Intrinsics.areEqual(this.liveness, identixOneResponse.liveness);
    }

    public int hashCode() {
        String str = this.conf;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.idxId;
        int hashCode2 = (((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.age) * 31) + this.sex) * 31;
        String str3 = this.mood;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.liveness;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "IdentixOneResponse(conf=" + this.conf + ", idxId=" + this.idxId + ", age=" + this.age + ", sex=" + this.sex + ", mood=" + this.mood + ", liveness=" + this.liveness + ")";
    }

    public IdentixOneResponse(String str, String str2, int i, int i2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "conf");
        Intrinsics.checkParameterIsNotNull(str2, "idxId");
        Intrinsics.checkParameterIsNotNull(str3, "mood");
        Intrinsics.checkParameterIsNotNull(str4, "liveness");
        this.conf = str;
        this.idxId = str2;
        this.age = i;
        this.sex = i2;
        this.mood = str3;
        this.liveness = str4;
    }

    public final String getConf() {
        return this.conf;
    }

    public final String getIdxId() {
        return this.idxId;
    }

    public final int getAge() {
        return this.age;
    }

    public final int getSex() {
        return this.sex;
    }

    public final String getMood() {
        return this.mood;
    }

    public final String getLiveness() {
        return this.liveness;
    }
}
