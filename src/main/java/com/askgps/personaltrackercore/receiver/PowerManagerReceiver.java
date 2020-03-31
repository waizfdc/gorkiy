package com.askgps.personaltrackercore.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.repository.Repository;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/askgps/personaltrackercore/receiver/PowerManagerReceiver;", "Landroid/content/BroadcastReceiver;", "Lorg/koin/core/KoinComponent;", "()V", "repo", "Lcom/askgps/personaltrackercore/repository/Repository;", "getRepo", "()Lcom/askgps/personaltrackercore/repository/Repository;", "repo$delegate", "Lkotlin/Lazy;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PowerManagerReceiver.kt */
public final class PowerManagerReceiver extends BroadcastReceiver implements KoinComponent {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PowerManagerReceiver.class), "repo", "getRepo()Lcom/askgps/personaltrackercore/repository/Repository;"))};
    private final Lazy repo$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new PowerManagerReceiver$$special$$inlined$inject$1(this, null, null));

    private final Repository getRepo() {
        Lazy lazy = this.repo$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Repository) lazy.getValue();
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        LogKt.toLog$default(intent.getAction(), "PowerManagerReceiver intent", (String) null, (String) null, 6, (Object) null);
        String action = intent.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != 798292259) {
                if (hashCode == 1947666138 && action.equals("android.intent.action.ACTION_SHUTDOWN")) {
                    getRepo().processingPowerManagerMessage(false);
                }
            } else if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                getRepo().processingPowerManagerMessage(true);
            }
        }
    }
}
