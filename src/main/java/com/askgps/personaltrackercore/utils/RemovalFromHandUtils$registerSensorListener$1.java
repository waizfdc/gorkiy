package com.askgps.personaltrackercore.utils;

import android.hardware.Sensor;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* compiled from: RemovalFromHandUtils.kt */
final /* synthetic */ class RemovalFromHandUtils$registerSensorListener$1 extends MutablePropertyReference0 {
    RemovalFromHandUtils$registerSensorListener$1(RemovalFromHandUtils removalFromHandUtils) {
        super(removalFromHandUtils);
    }

    public String getName() {
        return "defaultSensor";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(RemovalFromHandUtils.class);
    }

    public String getSignature() {
        return "getDefaultSensor()Landroid/hardware/Sensor;";
    }

    public Object get() {
        return ((RemovalFromHandUtils) this.receiver).getDefaultSensor();
    }

    public void set(Object obj) {
        ((RemovalFromHandUtils) this.receiver).setDefaultSensor((Sensor) obj);
    }
}
