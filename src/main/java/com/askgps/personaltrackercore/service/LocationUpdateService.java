package com.askgps.personaltrackercore.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.askgps.personaltrackercore.repository.Repository;
import com.askgps.personaltrackercore.utils.WifiUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/askgps/personaltrackercore/service/LocationUpdateService;", "Landroid/app/Service;", "Lorg/koin/core/KoinComponent;", "()V", "repo", "Lcom/askgps/personaltrackercore/repository/Repository;", "getRepo", "()Lcom/askgps/personaltrackercore/repository/Repository;", "repo$delegate", "Lkotlin/Lazy;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LocationUpdateService.kt */
public final class LocationUpdateService extends Service implements KoinComponent {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LocationUpdateService.class), "repo", "getRepo()Lcom/askgps/personaltrackercore/repository/Repository;"))};
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "last_loc";
    private final Lazy repo$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new LocationUpdateService$$special$$inlined$inject$1(this, null, null));

    private final Repository getRepo() {
        Lazy lazy = this.repo$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Repository) lazy.getValue();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/askgps/personaltrackercore/service/LocationUpdateService$Companion;", "", "()V", "TAG", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: LocationUpdateService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
        new WifiUtils(applicationContext).wifiScan();
        return 1;
    }
}
