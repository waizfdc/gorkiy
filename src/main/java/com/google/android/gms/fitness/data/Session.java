package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.fitness.zzjn;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class Session extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Session> CREATOR = new zzae();
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
    private final String description;
    private final String name;
    private final long zzib;
    private final long zzic;
    private final int zzip;
    private final zzc zzjg;
    private final String zzma;
    private final Long zzmb;

    public Session(long j, long j2, String str, String str2, String str3, int i, zzc zzc, Long l) {
        this.zzib = j;
        this.zzic = j2;
        this.name = str;
        this.zzma = str2;
        this.description = str3;
        this.zzip = i;
        this.zzjg = zzc;
        this.zzmb = l;
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class Builder {
        /* access modifiers changed from: private */
        public String description = "";
        /* access modifiers changed from: private */
        public String name = null;
        /* access modifiers changed from: private */
        public long zzib = 0;
        /* access modifiers changed from: private */
        public long zzic = 0;
        /* access modifiers changed from: private */
        public int zzip = 4;
        /* access modifiers changed from: private */
        public String zzma = null;
        /* access modifiers changed from: private */
        public Long zzmb;

        public Builder setStartTime(long j, TimeUnit timeUnit) {
            Preconditions.checkState(j > 0, "Start time should be positive.");
            this.zzib = timeUnit.toMillis(j);
            return this;
        }

        public Builder setEndTime(long j, TimeUnit timeUnit) {
            Preconditions.checkState(j >= 0, "End time should be positive.");
            this.zzic = timeUnit.toMillis(j);
            return this;
        }

        public Builder setName(String str) {
            Preconditions.checkArgument(str.length() <= 100, "Session name cannot exceed %d characters", 100);
            this.name = str;
            return this;
        }

        public Builder setIdentifier(String str) {
            Preconditions.checkArgument(str != null && TextUtils.getTrimmedLength(str) > 0);
            this.zzma = str;
            return this;
        }

        public Builder setDescription(String str) {
            Preconditions.checkArgument(str.length() <= 1000, "Session description cannot exceed %d characters", 1000);
            this.description = str;
            return this;
        }

        public Builder setActivity(String str) {
            this.zzip = zzjn.zzp(str);
            return this;
        }

        public Builder setActiveTime(long j, TimeUnit timeUnit) {
            this.zzmb = Long.valueOf(timeUnit.toMillis(j));
            return this;
        }

        public Session build() {
            boolean z = true;
            Preconditions.checkState(this.zzib > 0, "Start time should be specified.");
            long j = this.zzic;
            if (j != 0 && j <= this.zzib) {
                z = false;
            }
            Preconditions.checkState(z, "End time should be later than start time.");
            if (this.zzma == null) {
                String str = this.name;
                if (str == null) {
                    str = "";
                }
                long j2 = this.zzib;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20);
                sb.append(str);
                sb.append(j2);
                this.zzma = sb.toString();
            }
            return new Session(this);
        }
    }

    private Session(Builder builder) {
        this(builder.zzib, builder.zzic, builder.name, builder.zzma, builder.description, builder.zzip, null, builder.zzmb);
    }

    public static Session extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (Session) SafeParcelableSerializer.deserializeFromIntentExtra(intent, EXTRA_SESSION, CREATOR);
    }

    public static String getMimeType(String str) {
        String valueOf = String.valueOf(str);
        return valueOf.length() != 0 ? MIME_TYPE_PREFIX.concat(valueOf) : new String(MIME_TYPE_PREFIX);
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzib, TimeUnit.MILLISECONDS);
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzic, TimeUnit.MILLISECONDS);
    }

    public long getActiveTime(TimeUnit timeUnit) {
        Preconditions.checkState(this.zzmb != null, "Active time is not set");
        return timeUnit.convert(this.zzmb.longValue(), TimeUnit.MILLISECONDS);
    }

    public boolean hasActiveTime() {
        return this.zzmb != null;
    }

    public boolean isOngoing() {
        return this.zzic == 0;
    }

    public String getName() {
        return this.name;
    }

    public String getIdentifier() {
        return this.zzma;
    }

    public String getDescription() {
        return this.description;
    }

    public String getActivity() {
        return zzjn.getName(this.zzip);
    }

    public String getAppPackageName() {
        zzc zzc = this.zzjg;
        if (zzc == null) {
            return null;
        }
        return zzc.getPackageName();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Session)) {
            return false;
        }
        Session session = (Session) obj;
        return this.zzib == session.zzib && this.zzic == session.zzic && Objects.equal(this.name, session.name) && Objects.equal(this.zzma, session.zzma) && Objects.equal(this.description, session.description) && Objects.equal(this.zzjg, session.zzjg) && this.zzip == session.zzip;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzib), Long.valueOf(this.zzic), this.zzma);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("startTime", Long.valueOf(this.zzib)).add("endTime", Long.valueOf(this.zzic)).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).add(SettingsJsonConstants.APP_IDENTIFIER_KEY, this.zzma).add("description", this.description).add("activity", Integer.valueOf(this.zzip)).add("application", this.zzjg).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzib);
        SafeParcelWriter.writeLong(parcel, 2, this.zzic);
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeString(parcel, 4, getIdentifier(), false);
        SafeParcelWriter.writeString(parcel, 5, getDescription(), false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzip);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzjg, i, false);
        SafeParcelWriter.writeLongObject(parcel, 9, this.zzmb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
