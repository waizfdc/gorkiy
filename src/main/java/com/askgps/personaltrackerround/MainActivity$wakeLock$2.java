package com.askgps.personaltrackerround;

import android.os.PowerManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012 \u0003*\b\u0018\u00010\u0001R\u00020\u00020\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainActivity.kt */
final class MainActivity$wakeLock$2 extends Lambda implements Function0<PowerManager.WakeLock> {
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivity$wakeLock$2(MainActivity mainActivity) {
        super(0);
        this.this$0 = mainActivity;
    }

    public final PowerManager.WakeLock invoke() {
        Object systemService = this.this$0.getSystemService("power");
        if (systemService != null) {
            return ((PowerManager) systemService).newWakeLock(1, "PersonalTracker::jobLockTag");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.PowerManager");
    }
}
