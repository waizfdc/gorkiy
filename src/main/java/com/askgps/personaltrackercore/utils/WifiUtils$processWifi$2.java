package com.askgps.personaltrackercore.utils;

import com.google.android.gms.location.LocationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* compiled from: WifiUtils.kt */
final /* synthetic */ class WifiUtils$processWifi$2 extends MutablePropertyReference0 {
    WifiUtils$processWifi$2(WifiUtils wifiUtils) {
        super(wifiUtils);
    }

    public String getName() {
        return "locationResult";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(WifiUtils.class);
    }

    public String getSignature() {
        return "getLocationResult()Lcom/google/android/gms/location/LocationResult;";
    }

    public Object get() {
        return ((WifiUtils) this.receiver).getLocationResult();
    }

    public void set(Object obj) {
        ((WifiUtils) this.receiver).setLocationResult((LocationResult) obj);
    }
}
