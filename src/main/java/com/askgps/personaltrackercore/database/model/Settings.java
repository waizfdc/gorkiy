package com.askgps.personaltrackercore.database.model;

import com.askgps.personaltrackercore.BaseMainActivity;
import com.google.android.gms.fitness.FitnessActivities;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/askgps/personaltrackercore/database/model/Settings;", "", "workIsStart", "", "gaskarAddress", "", "locationInterval", "", "sendTelemetryInterval", "removalFromHandJobInterval", "id", "", "(ZLjava/lang/String;JJJI)V", "getGaskarAddress", "()Ljava/lang/String;", "getId", "()I", "getLocationInterval", "()J", "getRemovalFromHandJobInterval", "getSendTelemetryInterval", "getWorkIsStart", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", FitnessActivities.OTHER, "hashCode", "toString", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: model.kt */
public final class Settings {
    private final String gaskarAddress;
    private final int id;
    private final long locationInterval;
    private final long removalFromHandJobInterval;
    private final long sendTelemetryInterval;
    private final boolean workIsStart;

    public Settings() {
        this(false, null, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ Settings copy$default(Settings settings, boolean z, String str, long j, long j2, long j3, int i, int i2, Object obj) {
        Settings settings2 = settings;
        return settings.copy((i2 & 1) != 0 ? settings2.workIsStart : z, (i2 & 2) != 0 ? settings2.gaskarAddress : str, (i2 & 4) != 0 ? settings2.locationInterval : j, (i2 & 8) != 0 ? settings2.sendTelemetryInterval : j2, (i2 & 16) != 0 ? settings2.removalFromHandJobInterval : j3, (i2 & 32) != 0 ? settings2.id : i);
    }

    public final boolean component1() {
        return this.workIsStart;
    }

    public final String component2() {
        return this.gaskarAddress;
    }

    public final long component3() {
        return this.locationInterval;
    }

    public final long component4() {
        return this.sendTelemetryInterval;
    }

    public final long component5() {
        return this.removalFromHandJobInterval;
    }

    public final int component6() {
        return this.id;
    }

    public final Settings copy(boolean z, String str, long j, long j2, long j3, int i) {
        Intrinsics.checkParameterIsNotNull(str, "gaskarAddress");
        return new Settings(z, str, j, j2, j3, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Settings)) {
            return false;
        }
        Settings settings = (Settings) obj;
        return this.workIsStart == settings.workIsStart && Intrinsics.areEqual(this.gaskarAddress, settings.gaskarAddress) && this.locationInterval == settings.locationInterval && this.sendTelemetryInterval == settings.sendTelemetryInterval && this.removalFromHandJobInterval == settings.removalFromHandJobInterval && this.id == settings.id;
    }

    public int hashCode() {
        boolean z = this.workIsStart;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.gaskarAddress;
        return ((((((((i + (str != null ? str.hashCode() : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.locationInterval)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.sendTelemetryInterval)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.removalFromHandJobInterval)) * 31) + this.id;
    }

    public String toString() {
        return "Settings(workIsStart=" + this.workIsStart + ", gaskarAddress=" + this.gaskarAddress + ", locationInterval=" + this.locationInterval + ", sendTelemetryInterval=" + this.sendTelemetryInterval + ", removalFromHandJobInterval=" + this.removalFromHandJobInterval + ", id=" + this.id + ")";
    }

    public Settings(boolean z, String str, long j, long j2, long j3, int i) {
        Intrinsics.checkParameterIsNotNull(str, "gaskarAddress");
        this.workIsStart = z;
        this.gaskarAddress = str;
        this.locationInterval = j;
        this.sendTelemetryInterval = j2;
        this.removalFromHandJobInterval = j3;
        this.id = i;
    }

    public final boolean getWorkIsStart() {
        return this.workIsStart;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Settings(boolean z, String str, long j, long j2, long j3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? BaseMainActivity.Companion.getCustomer().getAddress() : str, (i2 & 4) != 0 ? BaseMainActivity.Companion.getLOCATION_INTERVAL() : j, (i2 & 8) != 0 ? BaseMainActivity.Companion.getTELEMETRY_SEND_INTERVAL() : j2, (i2 & 16) != 0 ? 900000 : j3, (i2 & 32) != 0 ? 1 : i);
    }

    public final String getGaskarAddress() {
        return this.gaskarAddress;
    }

    public final long getLocationInterval() {
        return this.locationInterval;
    }

    public final long getSendTelemetryInterval() {
        return this.sendTelemetryInterval;
    }

    public final long getRemovalFromHandJobInterval() {
        return this.removalFromHandJobInterval;
    }

    public final int getId() {
        return this.id;
    }
}
