package com.askgps.personaltrackercore.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import com.askgps.personaltrackercore.BaseMainActivity;
import com.askgps.personaltrackercore.LogKt;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 J\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/askgps/personaltrackercore/location/GoogleApiHelper;", "Lorg/koin/core/KoinComponent;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fastestTrackingInterval", "", "getFastestTrackingInterval", "()J", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "kotlin.jvm.PlatformType", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "getLocationRequest", "()Lcom/google/android/gms/location/LocationRequest;", "maxWaitTime", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "getPendingIntent", "()Landroid/app/PendingIntent;", "pendingIntent$delegate", "Lkotlin/Lazy;", "requestIsStarted", "", "trackingInterval", "isGPSEnabled", "mContext", "removeLocationUpdates", "", "requestLastLocation", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/google/android/gms/tasks/OnCompleteListener;", "Landroid/location/Location;", "requestLocationUpdates", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GoogleApiHelper.kt */
public final class GoogleApiHelper implements KoinComponent {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(GoogleApiHelper.class), BaseGmsClient.KEY_PENDING_INTENT, "getPendingIntent()Landroid/app/PendingIntent;"))};
    public static final Companion Companion = new Companion(null);
    private static final int REQUEST_CODE = 1;
    /* access modifiers changed from: private */
    public final Context context;
    private final FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(this.context);
    private long maxWaitTime = BaseMainActivity.Companion.getTELEMETRY_SEND_INTERVAL();
    private final Lazy pendingIntent$delegate = LazyKt.lazy(new GoogleApiHelper$pendingIntent$2(this));
    private volatile boolean requestIsStarted;
    private long trackingInterval = BaseMainActivity.Companion.getLOCATION_INTERVAL();

    private final PendingIntent getPendingIntent() {
        Lazy lazy = this.pendingIntent$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (PendingIntent) lazy.getValue();
    }

    public GoogleApiHelper(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/askgps/personaltrackercore/location/GoogleApiHelper$Companion;", "", "()V", "REQUEST_CODE", "", "checkLocationPermission", "", "context", "Landroid/content/Context;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: GoogleApiHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean checkLocationPermission(Context context) {
            boolean z = context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
            LogKt.toLog$default("GoogleApiHelper permission: " + z, (String) null, (String) null, (String) null, 7, (Object) null);
            return z;
        }
    }

    private final long getFastestTrackingInterval() {
        return this.trackingInterval / ((long) 2);
    }

    private final LocationRequest getLocationRequest() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(this.trackingInterval);
        locationRequest.setFastestInterval(getFastestTrackingInterval());
        locationRequest.setMaxWaitTime(this.maxWaitTime);
        locationRequest.setPriority(Build.VERSION.SDK_INT < 24 ? 102 : 100);
        return locationRequest;
    }

    public final void requestLocationUpdates(long j, long j2) {
        this.trackingInterval = j;
        this.maxWaitTime = j2;
        LogKt.toFile$default(Boolean.valueOf(this.requestIsStarted), "LocationRequest already started", null, null, 6, null);
        if (this.requestIsStarted) {
            removeLocationUpdates();
        }
        if (Companion.checkLocationPermission(this.context) && isGPSEnabled(this.context)) {
            LocationRequest locationRequest = getLocationRequest();
            this.fusedLocationClient.requestLocationUpdates(locationRequest, getPendingIntent());
            LogKt.toFile$default(locationRequest, "LocationRequest is active - " + locationRequest.getPriority() + " - " + BaseMainActivity.Companion.getCustomer().name(), null, null, 6, null);
            this.requestIsStarted = true;
        }
    }

    public final boolean isGPSEnabled(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "mContext");
        Object systemService = context2.getSystemService(FirebaseAnalytics.Param.LOCATION);
        if (systemService != null) {
            return ((LocationManager) systemService).isProviderEnabled("gps");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.location.LocationManager");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.tasks.Task.addOnCompleteListener(java.util.concurrent.Executor, com.google.android.gms.tasks.OnCompleteListener<java.lang.String>):com.google.android.gms.tasks.Task<TResult>
     arg types: [java.util.concurrent.ExecutorService, com.google.android.gms.tasks.OnCompleteListener<android.location.Location>]
     candidates:
      com.google.android.gms.tasks.Task.addOnCompleteListener(android.app.Activity, com.google.android.gms.tasks.OnCompleteListener<java.lang.String>):com.google.android.gms.tasks.Task<TResult>
      com.google.android.gms.tasks.Task.addOnCompleteListener(java.util.concurrent.Executor, com.google.android.gms.tasks.OnCompleteListener<java.lang.String>):com.google.android.gms.tasks.Task<TResult> */
    public final void requestLastLocation(OnCompleteListener<Location> onCompleteListener) {
        Intrinsics.checkParameterIsNotNull(onCompleteListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
        Intrinsics.checkExpressionValueIsNotNull(fusedLocationProviderClient, "fusedLocationClient");
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener((Executor) Executors.newSingleThreadExecutor(), (OnCompleteListener<String>) onCompleteListener);
    }

    public final void removeLocationUpdates() {
        LogKt.toFile$default("removeLocationUpdates()", null, null, null, 7, null);
        this.fusedLocationClient.removeLocationUpdates(getPendingIntent());
        this.requestIsStarted = false;
    }
}
