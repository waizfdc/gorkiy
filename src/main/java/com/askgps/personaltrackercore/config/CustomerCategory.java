package com.askgps.personaltrackercore.config;

import androidx.work.PeriodicWorkRequest;
import kotlin.Metadata;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u001f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/askgps/personaltrackercore/config/CustomerCategory;", "", "Lorg/koin/core/KoinComponent;", "address", "", "sendLocationInterval", "", "updateLocationInterval", "(Ljava/lang/String;ILjava/lang/String;JJ)V", "getAddress", "()Ljava/lang/String;", "getSendLocationInterval", "()J", "getUpdateLocationInterval", "PATIENT_PHONE", "PATIENT_WATCH", "BUILDER_WATCH", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CustomerCategory.kt */
public enum CustomerCategory implements KoinComponent {
    PATIENT_PHONE("http://185.221.153.208", 120000, 60000),
    PATIENT_WATCH("http://185.221.153.208", 120000, 60000),
    BUILDER_WATCH("http://195.93.229.67:12310", 1200000, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
    
    private final String address;
    private final long sendLocationInterval;
    private final long updateLocationInterval;

    private CustomerCategory(String str, long j, long j2) {
        this.address = str;
        this.sendLocationInterval = j;
        this.updateLocationInterval = j2;
    }

    public final String getAddress() {
        return this.address;
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final long getSendLocationInterval() {
        return this.sendLocationInterval;
    }

    public final long getUpdateLocationInterval() {
        return this.updateLocationInterval;
    }
}
