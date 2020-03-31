package com.askgps.personaltrackercore.location;

import android.app.PendingIntent;
import android.content.Intent;
import com.askgps.personaltrackercore.receiver.LocationUpdatesBroadcastReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/app/PendingIntent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: GoogleApiHelper.kt */
final class GoogleApiHelper$pendingIntent$2 extends Lambda implements Function0<PendingIntent> {
    final /* synthetic */ GoogleApiHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoogleApiHelper$pendingIntent$2(GoogleApiHelper googleApiHelper) {
        super(0);
        this.this$0 = googleApiHelper;
    }

    public final PendingIntent invoke() {
        Intent intent = new Intent(this.this$0.context, LocationUpdatesBroadcastReceiver.class);
        intent.setAction(LocationUpdatesBroadcastReceiver.ACTION_PROCESS_UPDATES);
        return PendingIntent.getBroadcast(this.this$0.context, 1, intent, 134217728);
    }
}
