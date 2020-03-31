package com.askgps.personaltrackercore.service;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.askgps.personaltrackercore.BaseMainActivity;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.R;
import com.askgps.personaltrackercore.location.GoogleApiHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/askgps/personaltrackercore/service/LocationService;", "Landroid/app/Service;", "()V", "CHANNEL_ID", "", "googleApiHelper", "Lcom/askgps/personaltrackercore/location/GoogleApiHelper;", "getGoogleApiHelper", "()Lcom/askgps/personaltrackercore/location/GoogleApiHelper;", "googleApiHelper$delegate", "Lkotlin/Lazy;", "createNotificationChannel", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "startUpdateLocationJob", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LocationService.kt */
public final class LocationService extends Service {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LocationService.class), "googleApiHelper", "getGoogleApiHelper()Lcom/askgps/personaltrackercore/location/GoogleApiHelper;"))};
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static AlarmManager alarmMgr;
    /* access modifiers changed from: private */
    public static GoogleApiHelper googleApiHelper;
    /* access modifiers changed from: private */
    public static PendingIntent updateLocationIntent;
    private final String CHANNEL_ID = "LocationUpdateService";
    private final Lazy googleApiHelper$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new LocationService$$special$$inlined$inject$1(this, null, null));

    private final GoogleApiHelper getGoogleApiHelper() {
        Lazy lazy = this.googleApiHelper$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (GoogleApiHelper) lazy.getValue();
    }

    public IBinder onBind(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        return null;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/askgps/personaltrackercore/service/LocationService$Companion;", "", "()V", "alarmMgr", "Landroid/app/AlarmManager;", "googleApiHelper", "Lcom/askgps/personaltrackercore/location/GoogleApiHelper;", "updateLocationIntent", "Landroid/app/PendingIntent;", "startService", "", "context", "Landroid/content/Context;", "locationInterval", "", "sendTelemetryInterval", "stopService", "stopUpdateLocationJob", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: LocationService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void stopUpdateLocationJob() {
            if (LocationService.alarmMgr != null) {
                AlarmManager access$getAlarmMgr$cp = LocationService.alarmMgr;
                if (access$getAlarmMgr$cp == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("alarmMgr");
                }
                PendingIntent access$getUpdateLocationIntent$cp = LocationService.updateLocationIntent;
                if (access$getUpdateLocationIntent$cp == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateLocationIntent");
                }
                access$getAlarmMgr$cp.cancel(access$getUpdateLocationIntent$cp);
            }
        }

        public final void startService(Context context, long j, long j2) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intent intent = new Intent(context, LocationService.class);
            intent.putExtra("locationInterval", j);
            intent.putExtra("sendTelemetryInterval", j2);
            ContextCompat.startForegroundService(context, intent);
        }

        public final void stopService(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Companion companion = this;
            companion.stopUpdateLocationJob();
            if (LocationService.googleApiHelper != null) {
                GoogleApiHelper access$getGoogleApiHelper$cp = LocationService.googleApiHelper;
                if (access$getGoogleApiHelper$cp == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("googleApiHelper");
                }
                access$getGoogleApiHelper$cp.removeLocationUpdates();
            }
            context.stopService(new Intent(context, LocationService.class));
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Long l = null;
        Long valueOf = intent != null ? Long.valueOf(intent.getLongExtra("sendTelemetryInterval", 0)) : null;
        if (intent != null) {
            l = Long.valueOf(intent.getLongExtra("locationInterval", 0));
        }
        createNotificationChannel();
        Context context = this;
        startForeground(101, new NotificationCompat.Builder(context, this.CHANNEL_ID).setContentTitle("Обновление координат").setContentText("СоцМониторинг").setSmallIcon(R.drawable.notification_icon).setContentIntent(PendingIntent.getService(context, 0, new Intent(context, LocationUpdateService.class), 0)).build());
        if (!(l == null || valueOf == null)) {
            getGoogleApiHelper().requestLocationUpdates(l.longValue(), valueOf.longValue());
        }
        startUpdateLocationJob();
        return 1;
    }

    private final void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(this.CHANNEL_ID, "Location update service", 3);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager == null) {
                Intrinsics.throwNpe();
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    /* access modifiers changed from: protected */
    public final void startUpdateLocationJob() {
        LogKt.toFile$default("Run LocationUpdateService alarm", null, null, null, 7, null);
        Object systemService = getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (systemService != null) {
            alarmMgr = (AlarmManager) systemService;
            Context context = this;
            PendingIntent service = PendingIntent.getService(context, 0, new Intent(context, LocationUpdateService.class), 0);
            Intrinsics.checkExpressionValueIsNotNull(service, "PendingIntent.getService(this, 0, intent, 0)");
            Intrinsics.checkExpressionValueIsNotNull(service, "Intent(this, LocationUpd…, 0, intent, 0)\n        }");
            updateLocationIntent = service;
            AlarmManager alarmManager = alarmMgr;
            if (alarmManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("alarmMgr");
            }
            long currentTimeMillis = System.currentTimeMillis();
            long telemetry_send_interval = BaseMainActivity.Companion.getTELEMETRY_SEND_INTERVAL();
            PendingIntent pendingIntent = updateLocationIntent;
            if (pendingIntent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("updateLocationIntent");
            }
            alarmManager.setRepeating(0, currentTimeMillis, telemetry_send_interval, pendingIntent);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.AlarmManager");
    }
}
