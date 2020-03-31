package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fitness.zzjn;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class Goal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Goal> CREATOR = new zzs();
    public static final int OBJECTIVE_TYPE_DURATION = 2;
    public static final int OBJECTIVE_TYPE_FREQUENCY = 3;
    public static final int OBJECTIVE_TYPE_METRIC = 1;
    private final long zzlj;
    private final long zzlk;
    private final List<Integer> zzll;
    private final Recurrence zzlm;
    private final int zzln;
    private final MetricObjective zzlo;
    private final DurationObjective zzlp;
    private final FrequencyObjective zzlq;

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class DurationObjective extends AbstractSafeParcelable {
        public static final Parcelable.Creator<DurationObjective> CREATOR = new zzp();
        private final long zzlr;

        public long getDuration(TimeUnit timeUnit) {
            return timeUnit.convert(this.zzlr, TimeUnit.NANOSECONDS);
        }

        DurationObjective(long j) {
            this.zzlr = j;
        }

        public DurationObjective(long j, TimeUnit timeUnit) {
            this(timeUnit.toNanos(j));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof DurationObjective) && this.zzlr == ((DurationObjective) obj).zzlr;
        }

        public int hashCode() {
            return (int) this.zzlr;
        }

        public String toString() {
            return Objects.toStringHelper(this).add("duration", Long.valueOf(this.zzlr)).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeLong(parcel, 1, this.zzlr);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class FrequencyObjective extends AbstractSafeParcelable {
        public static final Parcelable.Creator<FrequencyObjective> CREATOR = new zzr();
        private final int frequency;

        public int getFrequency() {
            return this.frequency;
        }

        public FrequencyObjective(int i) {
            this.frequency = i;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof FrequencyObjective) && this.frequency == ((FrequencyObjective) obj).frequency;
        }

        public int hashCode() {
            return this.frequency;
        }

        public String toString() {
            return Objects.toStringHelper(this).add("frequency", Integer.valueOf(this.frequency)).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, getFrequency());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class MetricObjective extends AbstractSafeParcelable {
        public static final Parcelable.Creator<MetricObjective> CREATOR = new zzw();
        private final double value;
        private final String zzls;
        private final double zzlt;

        public String getDataTypeName() {
            return this.zzls;
        }

        public double getValue() {
            return this.value;
        }

        public MetricObjective(String str, double d, double d2) {
            this.zzls = str;
            this.value = d;
            this.zzlt = d2;
        }

        public MetricObjective(String str, double d) {
            this(str, d, 0.0d);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MetricObjective)) {
                return false;
            }
            MetricObjective metricObjective = (MetricObjective) obj;
            return Objects.equal(this.zzls, metricObjective.zzls) && this.value == metricObjective.value && this.zzlt == metricObjective.zzlt;
        }

        public int hashCode() {
            return this.zzls.hashCode();
        }

        public String toString() {
            return Objects.toStringHelper(this).add("dataTypeName", this.zzls).add("value", Double.valueOf(this.value)).add("initialValue", Double.valueOf(this.zzlt)).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getDataTypeName(), false);
            SafeParcelWriter.writeDouble(parcel, 2, getValue());
            SafeParcelWriter.writeDouble(parcel, 3, this.zzlt);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class MismatchedGoalException extends IllegalStateException {
        public MismatchedGoalException(String str) {
            super(str);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public @interface ObjectiveType {
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class Recurrence extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Recurrence> CREATOR = new zzab();
        public static final int UNIT_DAY = 1;
        public static final int UNIT_MONTH = 3;
        public static final int UNIT_WEEK = 2;
        private final int count;
        /* access modifiers changed from: private */
        public final int zzlu;

        @Retention(RetentionPolicy.SOURCE)
        /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
        public @interface RecurrenceUnit {
        }

        public int getCount() {
            return this.count;
        }

        public int getUnit() {
            return this.zzlu;
        }

        public Recurrence(int i, int i2) {
            this.count = i;
            Preconditions.checkState(i2 > 0 && i2 <= 3);
            this.zzlu = i2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Recurrence)) {
                return false;
            }
            Recurrence recurrence = (Recurrence) obj;
            return this.count == recurrence.count && this.zzlu == recurrence.zzlu;
        }

        public int hashCode() {
            return this.zzlu;
        }

        public String toString() {
            String str;
            Objects.ToStringHelper add = Objects.toStringHelper(this).add("count", Integer.valueOf(this.count));
            int i = this.zzlu;
            if (i == 1) {
                str = "day";
            } else if (i == 2) {
                str = "week";
            } else if (i == 3) {
                str = "month";
            } else {
                throw new IllegalArgumentException("invalid unit value");
            }
            return add.add("unit", str).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, getCount());
            SafeParcelWriter.writeInt(parcel, 2, getUnit());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    public long getCreateTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzlj, TimeUnit.NANOSECONDS);
    }

    public long getStartTime(Calendar calendar, TimeUnit timeUnit) {
        if (this.zzlm == null) {
            return timeUnit.convert(this.zzlj, TimeUnit.NANOSECONDS);
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(calendar.getTime());
        int zza = this.zzlm.zzlu;
        if (zza == 1) {
            instance.set(11, 0);
            return timeUnit.convert(instance.getTimeInMillis(), TimeUnit.MILLISECONDS);
        } else if (zza == 2) {
            instance.set(7, 2);
            instance.set(11, 0);
            return timeUnit.convert(instance.getTimeInMillis(), TimeUnit.MILLISECONDS);
        } else if (zza == 3) {
            instance.set(5, 1);
            instance.set(11, 0);
            return timeUnit.convert(instance.getTimeInMillis(), TimeUnit.MILLISECONDS);
        } else {
            int zza2 = this.zzlm.zzlu;
            StringBuilder sb = new StringBuilder(24);
            sb.append("Invalid unit ");
            sb.append(zza2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public long getEndTime(Calendar calendar, TimeUnit timeUnit) {
        if (this.zzlm == null) {
            return timeUnit.convert(this.zzlk, TimeUnit.NANOSECONDS);
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(calendar.getTime());
        int zza = this.zzlm.zzlu;
        if (zza == 1) {
            instance.add(5, 1);
            instance.set(11, 0);
            return timeUnit.convert(instance.getTimeInMillis(), TimeUnit.MILLISECONDS);
        } else if (zza == 2) {
            instance.add(4, 1);
            instance.set(7, 2);
            instance.set(11, 0);
            return timeUnit.convert(instance.getTimeInMillis(), TimeUnit.MILLISECONDS);
        } else if (zza == 3) {
            instance.add(2, 1);
            instance.set(5, 1);
            instance.set(11, 0);
            return timeUnit.convert(instance.getTimeInMillis(), TimeUnit.MILLISECONDS);
        } else {
            int zza2 = this.zzlm.zzlu;
            StringBuilder sb = new StringBuilder(24);
            sb.append("Invalid unit ");
            sb.append(zza2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public String getActivityName() {
        if (this.zzll.isEmpty() || this.zzll.size() > 1) {
            return null;
        }
        return zzjn.getName(this.zzll.get(0).intValue());
    }

    public Recurrence getRecurrence() {
        return this.zzlm;
    }

    public int getObjectiveType() {
        return this.zzln;
    }

    private static String zze(int i) {
        if (i == 0) {
            return "unknown";
        }
        if (i == 1) {
            return "metric";
        }
        if (i == 2) {
            return "duration";
        }
        if (i == 3) {
            return "frequency";
        }
        throw new IllegalArgumentException("invalid objective type value");
    }

    public MetricObjective getMetricObjective() {
        zzf(1);
        return this.zzlo;
    }

    public DurationObjective getDurationObjective() {
        zzf(2);
        return this.zzlp;
    }

    public FrequencyObjective getFrequencyObjective() {
        zzf(3);
        return this.zzlq;
    }

    Goal(long j, long j2, List<Integer> list, Recurrence recurrence, int i, MetricObjective metricObjective, DurationObjective durationObjective, FrequencyObjective frequencyObjective) {
        this.zzlj = j;
        this.zzlk = j2;
        this.zzll = list;
        this.zzlm = recurrence;
        this.zzln = i;
        this.zzlo = metricObjective;
        this.zzlp = durationObjective;
        this.zzlq = frequencyObjective;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Goal)) {
            return false;
        }
        Goal goal = (Goal) obj;
        return this.zzlj == goal.zzlj && this.zzlk == goal.zzlk && Objects.equal(this.zzll, goal.zzll) && Objects.equal(this.zzlm, goal.zzlm) && this.zzln == goal.zzln && Objects.equal(this.zzlo, goal.zzlo) && Objects.equal(this.zzlp, goal.zzlp) && Objects.equal(this.zzlq, goal.zzlq);
    }

    public int hashCode() {
        return this.zzln;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("activity", getActivityName()).add("recurrence", this.zzlm).add("metricObjective", this.zzlo).add("durationObjective", this.zzlp).add("frequencyObjective", this.zzlq).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzlj);
        SafeParcelWriter.writeLong(parcel, 2, this.zzlk);
        SafeParcelWriter.writeList(parcel, 3, this.zzll, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getRecurrence(), i, false);
        SafeParcelWriter.writeInt(parcel, 5, getObjectiveType());
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzlo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzlp, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzlq, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private final void zzf(int i) throws MismatchedGoalException {
        if (i != this.zzln) {
            throw new MismatchedGoalException(String.format("%s goal does not have %s objective", zze(this.zzln), zze(i)));
        }
    }
}
