package com.askgps.personaltrackercore.database.model;

import com.google.android.gms.fitness.FitnessActivities;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r¨\u0006&"}, d2 = {"Lcom/askgps/personaltrackercore/database/model/Device;", "", "fio", "", "iD_Data", "deviceId", "code", "address", "phone", "liveness", "comments", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getCode", "setCode", "(Ljava/lang/String;)V", "getComments", "getDeviceId", "getFio", "getID_Data", "getLiveness", "getPhone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", FitnessActivities.OTHER, "hashCode", "", "toString", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: model.kt */
public final class Device {
    @SerializedName("address")
    private final String address;
    @SerializedName("code")
    private String code;
    @SerializedName("comments")
    private final String comments;
    @SerializedName("deviceId")
    private final String deviceId;
    @SerializedName("fio")
    private final String fio;
    @SerializedName("iD_Data")
    private final String iD_Data;
    @SerializedName("doctorName")
    private final String liveness;
    @SerializedName("phone")
    private final String phone;

    public static /* synthetic */ Device copy$default(Device device, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        Device device2 = device;
        int i2 = i;
        return device.copy((i2 & 1) != 0 ? device2.fio : str, (i2 & 2) != 0 ? device2.iD_Data : str2, (i2 & 4) != 0 ? device2.deviceId : str3, (i2 & 8) != 0 ? device2.code : str4, (i2 & 16) != 0 ? device2.address : str5, (i2 & 32) != 0 ? device2.phone : str6, (i2 & 64) != 0 ? device2.liveness : str7, (i2 & 128) != 0 ? device2.comments : str8);
    }

    public final String component1() {
        return this.fio;
    }

    public final String component2() {
        return this.iD_Data;
    }

    public final String component3() {
        return this.deviceId;
    }

    public final String component4() {
        return this.code;
    }

    public final String component5() {
        return this.address;
    }

    public final String component6() {
        return this.phone;
    }

    public final String component7() {
        return this.liveness;
    }

    public final String component8() {
        return this.comments;
    }

    public final Device copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkParameterIsNotNull(str, "fio");
        Intrinsics.checkParameterIsNotNull(str2, "iD_Data");
        Intrinsics.checkParameterIsNotNull(str3, "deviceId");
        Intrinsics.checkParameterIsNotNull(str4, "code");
        Intrinsics.checkParameterIsNotNull(str5, "address");
        String str9 = str6;
        Intrinsics.checkParameterIsNotNull(str9, "phone");
        String str10 = str7;
        Intrinsics.checkParameterIsNotNull(str10, "liveness");
        String str11 = str8;
        Intrinsics.checkParameterIsNotNull(str11, "comments");
        return new Device(str, str2, str3, str4, str5, str9, str10, str11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        return Intrinsics.areEqual(this.fio, device.fio) && Intrinsics.areEqual(this.iD_Data, device.iD_Data) && Intrinsics.areEqual(this.deviceId, device.deviceId) && Intrinsics.areEqual(this.code, device.code) && Intrinsics.areEqual(this.address, device.address) && Intrinsics.areEqual(this.phone, device.phone) && Intrinsics.areEqual(this.liveness, device.liveness) && Intrinsics.areEqual(this.comments, device.comments);
    }

    public int hashCode() {
        String str = this.fio;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.iD_Data;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.deviceId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.code;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.address;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.phone;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.liveness;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.comments;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "Device(fio=" + this.fio + ", iD_Data=" + this.iD_Data + ", deviceId=" + this.deviceId + ", code=" + this.code + ", address=" + this.address + ", phone=" + this.phone + ", liveness=" + this.liveness + ", comments=" + this.comments + ")";
    }

    public Device(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkParameterIsNotNull(str, "fio");
        Intrinsics.checkParameterIsNotNull(str2, "iD_Data");
        Intrinsics.checkParameterIsNotNull(str3, "deviceId");
        Intrinsics.checkParameterIsNotNull(str4, "code");
        Intrinsics.checkParameterIsNotNull(str5, "address");
        Intrinsics.checkParameterIsNotNull(str6, "phone");
        Intrinsics.checkParameterIsNotNull(str7, "liveness");
        Intrinsics.checkParameterIsNotNull(str8, "comments");
        this.fio = str;
        this.iD_Data = str2;
        this.deviceId = str3;
        this.code = str4;
        this.address = str5;
        this.phone = str6;
        this.liveness = str7;
        this.comments = str8;
    }

    public final String getFio() {
        return this.fio;
    }

    public final String getID_Data() {
        return this.iD_Data;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.code = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getLiveness() {
        return this.liveness;
    }

    public final String getComments() {
        return this.comments;
    }
}
