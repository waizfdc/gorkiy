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
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.concurrent.TimeUnit;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public interface HistoryApi {
    PendingResult<Status> deleteData(GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest);

    PendingResult<Status> insertData(GoogleApiClient googleApiClient, DataSet dataSet);

    PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient googleApiClient, DataType dataType);

    PendingResult<DailyTotalResult> readDailyTotalFromLocalDevice(GoogleApiClient googleApiClient, DataType dataType);

    PendingResult<DataReadResult> readData(GoogleApiClient googleApiClient, DataReadRequest dataReadRequest);

    PendingResult<Status> registerDataUpdateListener(GoogleApiClient googleApiClient, DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest);

    PendingResult<Status> unregisterDataUpdateListener(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult<Status> updateData(GoogleApiClient googleApiClient, DataUpdateRequest dataUpdateRequest);

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class ViewIntentBuilder {
        private final Context zzhy;
        private final DataType zzhz;
        private DataSource zzia;
        private long zzib;
        private long zzic;
        private String zzid;

        public ViewIntentBuilder(Context context, DataType dataType) {
            this.zzhy = context;
            this.zzhz = dataType;
        }

        public ViewIntentBuilder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            this.zzib = timeUnit.toMillis(j);
            this.zzic = timeUnit.toMillis(j2);
            return this;
        }

        public ViewIntentBuilder setDataSource(DataSource dataSource) {
            Preconditions.checkArgument(dataSource.getDataType().equals(this.zzhz), "Data source %s is not for the data type %s", dataSource, this.zzhz);
            this.zzia = dataSource;
            return this;
        }

        public ViewIntentBuilder setPreferredApplication(String str) {
            this.zzid = str;
            return this;
        }

        public Intent build() {
            Intent intent;
            ResolveInfo resolveActivity;
            boolean z = true;
            Preconditions.checkState(this.zzib > 0, "Start time must be set");
            if (this.zzic <= this.zzib) {
                z = false;
            }
            Preconditions.checkState(z, "End time must be set and after start time");
            Intent intent2 = new Intent(Fitness.ACTION_VIEW);
            intent2.setType(DataType.getMimeType(this.zzia.getDataType()));
            intent2.putExtra(Fitness.EXTRA_START_TIME, this.zzib);
            intent2.putExtra(Fitness.EXTRA_END_TIME, this.zzic);
            SafeParcelableSerializer.serializeToIntentExtra(this.zzia, intent2, DataSource.EXTRA_DATA_SOURCE);
            if (this.zzid == null || (resolveActivity = this.zzhy.getPackageManager().resolveActivity((intent = new Intent(intent2).setPackage(this.zzid)), 0)) == null) {
                return intent2;
            }
            intent.setComponent(new ComponentName(this.zzid, resolveActivity.activityInfo.name));
            return intent;
        }
    }
}
