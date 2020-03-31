package com.askgps.personaltrackercore.service;

import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.askgps.personaltrackercore.LogKt;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.android.ext.android.ComponentCallbackExtKt;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.scope.Scope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0016J\u001c\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0014H\u0002¨\u0006\u0016"}, d2 = {"Lcom/askgps/personaltrackercore/service/MessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "onDeletedMessages", "", "onMessageReceived", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onMessageSent", NotificationCompat.CATEGORY_MESSAGE, "", "onNewToken", "newToken", "onSendError", "error", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "parseData", "data", "", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MessagingService.kt */
public final class MessagingService extends FirebaseMessagingService {
    public static final Companion Companion = new Companion(null);
    public static final String LOCATION_INTERVAL_KEY = "location_interval";
    public static final String OPEN_CAMERA_KEY = "open_camera";
    public static final String REMOVAL_FROM_HAND_INTERVAL_KEY = "removal_from_hand";
    public static final String SEND_TELEMETRY_INTERVAL_KEY = "send_telemetry_interval";
    public static final String SERVER_ADDRESS_KEY = "server_address";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/askgps/personaltrackercore/service/MessagingService$Companion;", "", "()V", "LOCATION_INTERVAL_KEY", "", "OPEN_CAMERA_KEY", "REMOVAL_FROM_HAND_INTERVAL_KEY", "SEND_TELEMETRY_INTERVAL_KEY", "SERVER_ADDRESS_KEY", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MessagingService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intrinsics.checkParameterIsNotNull(remoteMessage, "remoteMessage");
        super.onMessageReceived(remoteMessage);
        LogKt.toFile$default(remoteMessage.getData(), "Firebase message data", null, null, 6, null);
        Map<String, String> data = remoteMessage.getData();
        Intrinsics.checkExpressionValueIsNotNull(data, "remoteMessage.data");
        parseData(data);
    }

    public void onMessageSent(String str) {
        Intrinsics.checkParameterIsNotNull(str, NotificationCompat.CATEGORY_MESSAGE);
        super.onMessageSent(str);
        LogKt.toLog$default(str, NotificationCompat.CATEGORY_MESSAGE, (String) null, (String) null, 6, (Object) null);
    }

    public void onDeletedMessages() {
        super.onDeletedMessages();
    }

    public void onSendError(String str, Exception exc) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        Intrinsics.checkParameterIsNotNull(exc, "ex");
        super.onSendError(str, exc);
    }

    public void onNewToken(String str) {
        Intrinsics.checkParameterIsNotNull(str, "newToken");
        super.onNewToken(str);
        LogKt.toLog$default(str, "newToken", (String) null, (String) null, 6, (Object) null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    private final void parseData(Map<String, String> map) {
        Scope rootScope = ComponentCallbackExtKt.getKoin(this).get_scopeRegistry().getRootScope();
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Class.class);
        Intent intent = new Intent(getApplicationContext(), (Class) rootScope.get(orCreateKotlinClass, QualifierKt.named("MainActivityClass"), (Function0<DefinitionParameters>) null));
        if (map.get(OPEN_CAMERA_KEY) != null) {
            intent.putExtra(OPEN_CAMERA_KEY, true);
        }
        String str = map.get(SERVER_ADDRESS_KEY);
        if (str != null) {
            intent.putExtra(SERVER_ADDRESS_KEY, str);
        }
        String str2 = map.get(SEND_TELEMETRY_INTERVAL_KEY);
        if (str2 != null) {
            try {
                intent.putExtra(SEND_TELEMETRY_INTERVAL_KEY, Long.parseLong(str2));
            } catch (NumberFormatException e) {
                LogKt.toFile$default(e, "Send telemetry interval - string is not valid", null, null, 6, null);
            }
        }
        String str3 = map.get(LOCATION_INTERVAL_KEY);
        if (str3 != null) {
            try {
                intent.putExtra(LOCATION_INTERVAL_KEY, Long.parseLong(str3));
            } catch (NumberFormatException e2) {
                LogKt.toFile$default(e2, "Location interval - string is not valid", null, null, 6, null);
            }
        }
        String str4 = map.get(REMOVAL_FROM_HAND_INTERVAL_KEY);
        if (str4 != null) {
            try {
                intent.putExtra(REMOVAL_FROM_HAND_INTERVAL_KEY, Long.parseLong(str4));
            } catch (NumberFormatException e3) {
                LogKt.toFile$default(e3, "Removal from hand interval - string is not valid", null, null, 6, null);
            }
        }
        intent.setFlags(872415232);
        startActivity(intent);
    }
}
