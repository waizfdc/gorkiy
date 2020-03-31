package com.askgps.personaltrackercore.service;

import android.app.AlarmManager;
import com.askgps.personaltrackercore.service.LocationService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* compiled from: LocationService.kt */
final /* synthetic */ class LocationService$Companion$stopUpdateLocationJob$1 extends MutablePropertyReference0 {
    LocationService$Companion$stopUpdateLocationJob$1(LocationService.Companion companion) {
        super(companion);
    }

    public String getName() {
        return "alarmMgr";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(LocationService.Companion.class);
    }

    public String getSignature() {
        return "getAlarmMgr()Landroid/app/AlarmManager;";
    }

    public Object get() {
        LocationService.Companion companion = (LocationService.Companion) this.receiver;
        AlarmManager access$getAlarmMgr$cp = LocationService.alarmMgr;
        if (access$getAlarmMgr$cp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alarmMgr");
        }
        return access$getAlarmMgr$cp;
    }

    public void set(Object obj) {
        LocationService.Companion companion = (LocationService.Companion) this.receiver;
        LocationService.alarmMgr = (AlarmManager) obj;
    }
}
