package com.askgps.personaltrackercore.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import com.askgps.personaltrackercore.R;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J$\u0010\u0013\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/askgps/personaltrackercore/utils/NotificationHandler;", "Lorg/koin/core/KoinComponent;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "NOTIFY_ID", "", "getNOTIFY_ID", "()I", "getNotification", "Landroid/app/Notification;", SettingsJsonConstants.PROMPT_TITLE_KEY, "", SettingsJsonConstants.PROMPT_MESSAGE_KEY, "intent", "Landroid/app/PendingIntent;", "isSound", "", "isAutoCancel", "notifyTestMessage", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: NotificationHandler.kt */
public final class NotificationHandler implements KoinComponent {
    private final int NOTIFY_ID = 1;
    private final Context ctx;

    public NotificationHandler(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        this.ctx = context;
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final int getNOTIFY_ID() {
        return this.NOTIFY_ID;
    }

    public final Notification getNotification(String str, String str2, PendingIntent pendingIntent, boolean z, boolean z2) {
        Object systemService = this.ctx.getSystemService("notification");
        if (systemService != null) {
            NotificationManager notificationManager = (NotificationManager) systemService;
            String str3 = !z ? "wl_channel_id_02" : "wl_channel_id_01";
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(str3, "WL Server Notification", 4);
                if (!z) {
                    notificationChannel = new NotificationChannel(str3, "WL Server Notification", 2);
                }
                notificationChannel.setDescription("Patient channel");
                notificationChannel.enableLights(true);
                notificationChannel.setLockscreenVisibility(1);
                notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            CharSequence charSequence = str2;
            NotificationCompat.Builder style = new NotificationCompat.Builder(this.ctx, str3).setSmallIcon(R.drawable.ic_red_call).setLargeIcon(BitmapFactory.decodeResource(this.ctx.getResources(), R.drawable.ic_red_call)).setContentTitle(str).setContentText(charSequence).setAutoCancel(z2).setOngoing(!z2).setVisibility(1).setStyle(new NotificationCompat.BigTextStyle().bigText(charSequence));
            if (pendingIntent != null) {
                style.setContentIntent(pendingIntent);
            }
            if (z) {
                style.setSound(RingtoneManager.getDefaultUri(2));
            }
            return style.build();
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
    }

    public final void notifyTestMessage(String str, String str2, PendingIntent pendingIntent) {
        Notification notification = getNotification(str, str2, pendingIntent, false, true);
        Object systemService = this.ctx.getSystemService("notification");
        if (systemService != null) {
            ((NotificationManager) systemService).notify(this.NOTIFY_ID, notification);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
    }
}
