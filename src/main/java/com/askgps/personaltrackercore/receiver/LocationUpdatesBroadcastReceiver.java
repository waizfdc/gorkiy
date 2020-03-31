package com.askgps.personaltrackercore.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.utils.WifiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000f"}, d2 = {"Lcom/askgps/personaltrackercore/receiver/LocationUpdatesBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Lorg/koin/core/KoinComponent;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "peekService", "Landroid/os/IBinder;", "myContext", NotificationCompat.CATEGORY_SERVICE, "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LocationUpdatesBroadcastReceiver.kt */
public final class LocationUpdatesBroadcastReceiver extends BroadcastReceiver implements KoinComponent {
    public static final String ACTION_PROCESS_UPDATES = "com.askgps.personaltrackercore.action.PROCESS_UPDATES";
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "update_loc";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/askgps/personaltrackercore/receiver/LocationUpdatesBroadcastReceiver$Companion;", "", "()V", "ACTION_PROCESS_UPDATES", "", "TAG", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: LocationUpdatesBroadcastReceiver.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        WifiUtils wifiUtils = new WifiUtils(context);
        if (intent != null && Intrinsics.areEqual(ACTION_PROCESS_UPDATES, intent.getAction())) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), Dispatchers.getDefault(), null, new LocationUpdatesBroadcastReceiver$onReceive$1(intent, wifiUtils, null), 2, null);
        }
    }

    public IBinder peekService(Context context, Intent intent) {
        LogKt.toLog$default(intent, "peekService", (String) null, (String) null, 6, (Object) null);
        IBinder peekService = super.peekService(context, intent);
        Intrinsics.checkExpressionValueIsNotNull(peekService, "super.peekService(myContext, service)");
        return peekService;
    }
}
