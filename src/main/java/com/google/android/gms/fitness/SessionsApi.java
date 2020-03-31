package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public interface SessionsApi {
    PendingResult<Status> insertSession(GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest);

    PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest);

    PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult<Status> startSession(GoogleApiClient googleApiClient, Session session);

    PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, String str);

    PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class ViewIntentBuilder {
        private final Context zzhy;
        private String zzid;
        private Session zzii;
        private boolean zzij = false;

        public ViewIntentBuilder(Context context) {
            this.zzhy = context;
        }

        public ViewIntentBuilder setSession(Session session) {
            this.zzii = session;
            return this;
        }

        public ViewIntentBuilder setPreferredApplication(String str) {
            this.zzid = str;
            this.zzij = true;
            return this;
        }

        public Intent build() {
            Intent intent;
            ResolveInfo resolveActivity;
            Preconditions.checkState(this.zzii != null, "Session must be set");
            Intent intent2 = new Intent(Fitness.ACTION_VIEW);
            intent2.setType(Session.getMimeType(this.zzii.getActivity()));
            SafeParcelableSerializer.serializeToIntentExtra(this.zzii, intent2, Session.EXTRA_SESSION);
            if (!this.zzij) {
                this.zzid = this.zzii.getAppPackageName();
            }
            if (this.zzid == null || (resolveActivity = this.zzhy.getPackageManager().resolveActivity((intent = new Intent(intent2).setPackage(this.zzid)), 0)) == null) {
                return intent2;
            }
            intent.setComponent(new ComponentName(this.zzid, resolveActivity.activityInfo.name));
            return intent;
        }
    }
}
