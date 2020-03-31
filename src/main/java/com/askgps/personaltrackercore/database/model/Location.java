package com.askgps.personaltrackercore.database.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b%\b\u0007\u0018\u00002\u00020\u0001Bí\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\u001fJ\b\u0010B\u001a\u00020\u0003H\u0016R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b\u0017\u00102R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b\u0013\u00102R\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b\u001c\u00102R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b:\u00105R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b;\u00102R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010/R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b=\u00102R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b>\u0010$R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b?\u0010!R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b@\u0010!R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\bA\u00102¨\u0006C"}, d2 = {"Lcom/askgps/personaltrackercore/database/model/Location;", "", "imei", "", "datetime", "", "locationDatetime", "lat", "", "lon", "altitude", "", "accuracy", "", "bearing", "", "speed", "provider", "stepCount", "isLeaveHand", "", "batteryLevel", "", "isFall", "powerOn", "sos", "version", "workShift", "isValid", "indoorNavigation", "Lcom/askgps/personaltrackercore/database/model/IndoorNavigation;", "(Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Short;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/askgps/personaltrackercore/database/model/IndoorNavigation;)V", "getAccuracy", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAltitude", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getBatteryLevel", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getBearing", "()Ljava/lang/Short;", "Ljava/lang/Short;", "getDatetime", "()J", "getImei", "()Ljava/lang/String;", "getIndoorNavigation", "()Lcom/askgps/personaltrackercore/database/model/IndoorNavigation;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLat", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLocationDatetime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLon", "getPowerOn", "getProvider", "getSos", "getSpeed", "getStepCount", "getVersion", "getWorkShift", "toString", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: model.kt */
public final class Location {
    @SerializedName("accuracy")
    private final Integer accuracy;
    @SerializedName("altitude")
    private final Float altitude;
    @SerializedName("battery_level")
    private final Byte batteryLevel;
    @SerializedName("bearing")
    private final Short bearing;
    @SerializedName("datetime")
    @JsonAdapter(DateSerializer.class)
    private final long datetime;
    @SerializedName("phone_number")
    private final String imei;
    @SerializedName("indoorNavigation")
    private final IndoorNavigation indoorNavigation;
    @SerializedName("is_fall")
    private final Boolean isFall;
    @SerializedName("is_leave_hand")
    private final Boolean isLeaveHand;
    @SerializedName("isValid")
    private final Boolean isValid;
    @SerializedName("lat")
    private final Double lat;
    @SerializedName("locationDatetime")
    @JsonAdapter(DateSerializer.class)
    private final Long locationDatetime;
    @SerializedName("lon")
    private final Double lon;
    @SerializedName("power_on")
    private final Boolean powerOn;
    @SerializedName("provider")
    private final String provider;
    @SerializedName("sos")
    private final Boolean sos;
    @SerializedName("speed")
    private final Float speed;
    @SerializedName("step_count")
    private final Integer stepCount;
    @SerializedName("version")
    private final Integer version;
    @SerializedName("workShift")
    private final Boolean workShift;

    public Location(String str, long j, Long l, Double d, Double d2, Float f, Integer num, Short sh, Float f2, String str2, Integer num2, Boolean bool, Byte b, Boolean bool2, Boolean bool3, Boolean bool4, Integer num3, Boolean bool5, Boolean bool6, IndoorNavigation indoorNavigation2) {
        Intrinsics.checkParameterIsNotNull(str, "imei");
        this.imei = str;
        this.datetime = j;
        this.locationDatetime = l;
        this.lat = d;
        this.lon = d2;
        this.altitude = f;
        this.accuracy = num;
        this.bearing = sh;
        this.speed = f2;
        this.provider = str2;
        this.stepCount = num2;
        this.isLeaveHand = bool;
        this.batteryLevel = b;
        this.isFall = bool2;
        this.powerOn = bool3;
        this.sos = bool4;
        this.version = num3;
        this.workShift = bool5;
        this.isValid = bool6;
        this.indoorNavigation = indoorNavigation2;
    }

    public final String getImei() {
        return this.imei;
    }

    public final long getDatetime() {
        return this.datetime;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Location(java.lang.String r25, long r26, java.lang.Long r28, java.lang.Double r29, java.lang.Double r30, java.lang.Float r31, java.lang.Integer r32, java.lang.Short r33, java.lang.Float r34, java.lang.String r35, java.lang.Integer r36, java.lang.Boolean r37, java.lang.Byte r38, java.lang.Boolean r39, java.lang.Boolean r40, java.lang.Boolean r41, java.lang.Integer r42, java.lang.Boolean r43, java.lang.Boolean r44, com.askgps.personaltrackercore.database.model.IndoorNavigation r45, int r46, kotlin.jvm.internal.DefaultConstructorMarker r47) {
        /*
            r24 = this;
            r0 = r46
            r1 = r0 & 4
            if (r1 == 0) goto L_0x000e
            r1 = 0
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r6 = r1
            goto L_0x0010
        L_0x000e:
            r6 = r28
        L_0x0010:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x001a
            r1 = r2
            java.lang.Double r1 = (java.lang.Double) r1
            r7 = r1
            goto L_0x001c
        L_0x001a:
            r7 = r29
        L_0x001c:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0025
            r1 = r2
            java.lang.Double r1 = (java.lang.Double) r1
            r8 = r1
            goto L_0x0027
        L_0x0025:
            r8 = r30
        L_0x0027:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0030
            r1 = r2
            java.lang.Float r1 = (java.lang.Float) r1
            r9 = r1
            goto L_0x0032
        L_0x0030:
            r9 = r31
        L_0x0032:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x003b
            r1 = r2
            java.lang.Integer r1 = (java.lang.Integer) r1
            r10 = r1
            goto L_0x003d
        L_0x003b:
            r10 = r32
        L_0x003d:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0046
            r1 = r2
            java.lang.Short r1 = (java.lang.Short) r1
            r11 = r1
            goto L_0x0048
        L_0x0046:
            r11 = r33
        L_0x0048:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0051
            r1 = r2
            java.lang.Float r1 = (java.lang.Float) r1
            r12 = r1
            goto L_0x0053
        L_0x0051:
            r12 = r34
        L_0x0053:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x005c
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            r13 = r1
            goto L_0x005e
        L_0x005c:
            r13 = r35
        L_0x005e:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0067
            r1 = r2
            java.lang.Integer r1 = (java.lang.Integer) r1
            r14 = r1
            goto L_0x0069
        L_0x0067:
            r14 = r36
        L_0x0069:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0072
            r1 = r2
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r15 = r1
            goto L_0x0074
        L_0x0072:
            r15 = r37
        L_0x0074:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x007e
            r1 = r2
            java.lang.Byte r1 = (java.lang.Byte) r1
            r16 = r1
            goto L_0x0080
        L_0x007e:
            r16 = r38
        L_0x0080:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x008a
            r1 = r2
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r17 = r1
            goto L_0x008c
        L_0x008a:
            r17 = r39
        L_0x008c:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0096
            r1 = r2
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r18 = r1
            goto L_0x0098
        L_0x0096:
            r18 = r40
        L_0x0098:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a4
            r1 = r2
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r19 = r1
            goto L_0x00a6
        L_0x00a4:
            r19 = r41
        L_0x00a6:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b3
            r1 = 2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r20 = r1
            goto L_0x00b5
        L_0x00b3:
            r20 = r42
        L_0x00b5:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00c0
            r1 = r2
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r21 = r1
            goto L_0x00c2
        L_0x00c0:
            r21 = r43
        L_0x00c2:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00cd
            r1 = r2
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r22 = r1
            goto L_0x00cf
        L_0x00cd:
            r22 = r44
        L_0x00cf:
            r1 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00da
            r0 = r2
            com.askgps.personaltrackercore.database.model.IndoorNavigation r0 = (com.askgps.personaltrackercore.database.model.IndoorNavigation) r0
            r23 = r0
            goto L_0x00dc
        L_0x00da:
            r23 = r45
        L_0x00dc:
            r2 = r24
            r3 = r25
            r4 = r26
            r2.<init>(r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.askgps.personaltrackercore.database.model.Location.<init>(java.lang.String, long, java.lang.Long, java.lang.Double, java.lang.Double, java.lang.Float, java.lang.Integer, java.lang.Short, java.lang.Float, java.lang.String, java.lang.Integer, java.lang.Boolean, java.lang.Byte, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, com.askgps.personaltrackercore.database.model.IndoorNavigation, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Long getLocationDatetime() {
        return this.locationDatetime;
    }

    public final Double getLat() {
        return this.lat;
    }

    public final Double getLon() {
        return this.lon;
    }

    public final Float getAltitude() {
        return this.altitude;
    }

    public final Integer getAccuracy() {
        return this.accuracy;
    }

    public final Short getBearing() {
        return this.bearing;
    }

    public final Float getSpeed() {
        return this.speed;
    }

    public final String getProvider() {
        return this.provider;
    }

    public final Integer getStepCount() {
        return this.stepCount;
    }

    public final Boolean isLeaveHand() {
        return this.isLeaveHand;
    }

    public final Byte getBatteryLevel() {
        return this.batteryLevel;
    }

    public final Boolean isFall() {
        return this.isFall;
    }

    public final Boolean getPowerOn() {
        return this.powerOn;
    }

    public final Boolean getSos() {
        return this.sos;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final Boolean getWorkShift() {
        return this.workShift;
    }

    public final Boolean isValid() {
        return this.isValid;
    }

    public final IndoorNavigation getIndoorNavigation() {
        return this.indoorNavigation;
    }

    public String toString() {
        return "Location(imei='" + this.imei + "', datetime=" + this.datetime + ", locationDatetime=" + this.locationDatetime + ", lat=" + this.lat + ", lon=" + this.lon + ", altitude=" + this.altitude + ", accuracy=" + this.accuracy + ", bearing=" + this.bearing + ", speed=" + this.speed + ", provider=" + this.provider + ", stepCount=" + this.stepCount + ", isLeaveHand=" + this.isLeaveHand + ", batteryLevel=" + this.batteryLevel + ", isFall=" + this.isFall + ", powerOn=" + this.powerOn + ", sos=" + this.sos + ", version=" + this.version + ", workShift=" + this.workShift + ", isValid=" + this.isValid + ", indoorNavigation=" + this.indoorNavigation + ')';
    }
}
