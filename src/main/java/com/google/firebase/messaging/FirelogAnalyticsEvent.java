package com.google.firebase.messaging;

import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.2 */
final class FirelogAnalyticsEvent {
    private final String zza;
    private final Intent zzb;

    /* compiled from: com.google.firebase:firebase-messaging@@20.1.2 */
    static class zza implements ObjectEncoder<FirelogAnalyticsEvent> {
        zza() {
        }

        public final /* synthetic */ void encode(Object obj, Object obj2) throws EncodingException, IOException {
            FirelogAnalyticsEvent firelogAnalyticsEvent = (FirelogAnalyticsEvent) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            Intent zza = firelogAnalyticsEvent.zza();
            objectEncoderContext.add("ttl", zzo.zzf(zza));
            objectEncoderContext.add(NotificationCompat.CATEGORY_EVENT, firelogAnalyticsEvent.zzb());
            objectEncoderContext.add("instanceId", zzo.zzc());
            objectEncoderContext.add("priority", zzo.zzm(zza));
            objectEncoderContext.add("packageName", zzo.zzb());
            objectEncoderContext.add("sdkPlatform", "ANDROID");
            objectEncoderContext.add("messageType", zzo.zzk(zza));
            String zzj = zzo.zzj(zza);
            if (zzj != null) {
                objectEncoderContext.add("messageId", zzj);
            }
            String zzl = zzo.zzl(zza);
            if (zzl != null) {
                objectEncoderContext.add("topic", zzl);
            }
            String zzg = zzo.zzg(zza);
            if (zzg != null) {
                objectEncoderContext.add("collapseKey", zzg);
            }
            if (zzo.zzi(zza) != null) {
                objectEncoderContext.add("analyticsLabel", zzo.zzi(zza));
            }
            if (zzo.zzh(zza) != null) {
                objectEncoderContext.add("composerLabel", zzo.zzh(zza));
            }
            String zzd = zzo.zzd();
            if (zzd != null) {
                objectEncoderContext.add("projectNumber", zzd);
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@20.1.2 */
    static final class zzb implements ObjectEncoder<zzc> {
        zzb() {
        }

        public final /* synthetic */ void encode(Object obj, Object obj2) throws EncodingException, IOException {
            ((ObjectEncoderContext) obj2).add("messaging_client_event", ((zzc) obj).zza());
        }
    }

    FirelogAnalyticsEvent(String str, Intent intent) {
        this.zza = Preconditions.checkNotEmpty(str, "evenType must be non-null");
        this.zzb = (Intent) Preconditions.checkNotNull(intent, "intent must be non-null");
    }

    /* compiled from: com.google.firebase:firebase-messaging@@20.1.2 */
    static final class zzc {
        private final FirelogAnalyticsEvent zza;

        zzc(FirelogAnalyticsEvent firelogAnalyticsEvent) {
            this.zza = (FirelogAnalyticsEvent) Preconditions.checkNotNull(firelogAnalyticsEvent);
        }

        /* access modifiers changed from: package-private */
        public final FirelogAnalyticsEvent zza() {
            return this.zza;
        }
    }

    /* access modifiers changed from: package-private */
    public final Intent zza() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zza;
    }
}
