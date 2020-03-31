package com.google.android.gms.fitness;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzh {
    public static Set<Scope> zza(Collection<Scope> collection) {
        Scope scope;
        HashSet hashSet = new HashSet(collection.size());
        for (Scope next : collection) {
            if (next.equals(new Scope(Scopes.FITNESS_ACTIVITY_READ))) {
                scope = new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE);
            } else if (next.equals(new Scope(Scopes.FITNESS_LOCATION_READ))) {
                scope = new Scope(Scopes.FITNESS_LOCATION_READ_WRITE);
            } else if (next.equals(new Scope(Scopes.FITNESS_BODY_READ))) {
                scope = new Scope(Scopes.FITNESS_BODY_READ_WRITE);
            } else if (next.equals(new Scope(Scopes.FITNESS_NUTRITION_READ))) {
                scope = new Scope(Scopes.FITNESS_NUTRITION_READ_WRITE);
            } else if (next.equals(new Scope(Scopes.FITNESS_BLOOD_PRESSURE_READ))) {
                scope = new Scope(Scopes.FITNESS_BLOOD_PRESSURE_READ_WRITE);
            } else if (next.equals(new Scope(Scopes.FITNESS_BLOOD_GLUCOSE_READ))) {
                scope = new Scope(Scopes.FITNESS_BLOOD_GLUCOSE_READ_WRITE);
            } else if (next.equals(new Scope(Scopes.FITNESS_OXYGEN_SATURATION_READ))) {
                scope = new Scope(Scopes.FITNESS_OXYGEN_SATURATION_READ_WRITE);
            } else if (next.equals(new Scope(Scopes.FITNESS_BODY_TEMPERATURE_READ))) {
                scope = new Scope(Scopes.FITNESS_BODY_TEMPERATURE_READ_WRITE);
            } else {
                scope = next.equals(new Scope(Scopes.FITNESS_REPRODUCTIVE_HEALTH_READ)) ? new Scope(Scopes.FITNESS_REPRODUCTIVE_HEALTH_READ_WRITE) : next;
            }
            if (scope.equals(next) || !collection.contains(scope)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }
}
