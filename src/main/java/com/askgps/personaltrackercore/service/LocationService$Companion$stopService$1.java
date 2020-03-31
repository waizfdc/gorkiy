package com.askgps.personaltrackercore.service;

import com.askgps.personaltrackercore.location.GoogleApiHelper;
import com.askgps.personaltrackercore.service.LocationService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* compiled from: LocationService.kt */
final /* synthetic */ class LocationService$Companion$stopService$1 extends MutablePropertyReference0 {
    LocationService$Companion$stopService$1(LocationService.Companion companion) {
        super(companion);
    }

    public String getName() {
        return "googleApiHelper";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(LocationService.Companion.class);
    }

    public String getSignature() {
        return "getGoogleApiHelper()Lcom/askgps/personaltrackercore/location/GoogleApiHelper;";
    }

    public Object get() {
        LocationService.Companion companion = (LocationService.Companion) this.receiver;
        GoogleApiHelper access$getGoogleApiHelper$cp = LocationService.googleApiHelper;
        if (access$getGoogleApiHelper$cp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleApiHelper");
        }
        return access$getGoogleApiHelper$cp;
    }

    public void set(Object obj) {
        LocationService.Companion companion = (LocationService.Companion) this.receiver;
        LocationService.googleApiHelper = (GoogleApiHelper) obj;
    }
}
