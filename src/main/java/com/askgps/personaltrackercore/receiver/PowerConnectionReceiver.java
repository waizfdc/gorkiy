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
import org.koin.core.qualifier.Qualifier;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/askgps/personaltrackercore/receiver/PowerConnectionReceiver;", "Landroid/content/BroadcastReceiver;", "Lorg/koin/core/KoinComponent;", "()V", "companion", "Lcom/askgps/personaltrackercore/receiver/PowerConnectionCompanion;", "getCompanion", "()Lcom/askgps/personaltrackercore/receiver/PowerConnectionCompanion;", "companion$delegate", "Lkotlin/Lazy;", "repo", "Lcom/askgps/personaltrackercore/repository/Repository;", "getRepo", "()Lcom/askgps/personaltrackercore/repository/Repository;", "repo$delegate", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PowerConnectionReceiver.kt */
public final class PowerConnectionReceiver extends BroadcastReceiver implements KoinComponent {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    private final Lazy companion$delegate;
    private final Lazy repo$delegate;

    static {
        Class<PowerConnectionReceiver> cls = PowerConnectionReceiver.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "repo", "getRepo()Lcom/askgps/personaltrackercore/repository/Repository;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "companion", "getCompanion()Lcom/askgps/personaltrackercore/receiver/PowerConnectionCompanion;"))};
    }

    private final PowerConnectionCompanion getCompanion() {
        Lazy lazy = this.companion$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (PowerConnectionCompanion) lazy.getValue();
    }

    private final Repository getRepo() {
        Lazy lazy = this.repo$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Repository) lazy.getValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, com.askgps.personaltrackercore.receiver.PowerConnectionReceiver$$special$$inlined$inject$1]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, com.askgps.personaltrackercore.receiver.PowerConnectionReceiver$$special$$inlined$inject$2]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public PowerConnectionReceiver() {
        Qualifier qualifier = null;
        Function0 function0 = null;
        this.repo$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new PowerConnectionReceiver$$special$$inlined$inject$1(this, qualifier, function0));
        this.companion$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new PowerConnectionReceiver$$special$$inlined$inject$2(this, qualifier, function0));
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        LogKt.toFile$default(intent.getAction(), "Received action", null, null, 6, null);
        String action = intent.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -1886648615) {
                if (hashCode == 1019184907 && action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                    getCompanion().startJob();
                    getRepo().endWorkByPower(false);
                }
            } else if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                getCompanion().stopJob();
            }
        }
    }
}
