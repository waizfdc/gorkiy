package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class SensorRequest {
    public static final int ACCURACY_MODE_DEFAULT = 2;
    public static final int ACCURACY_MODE_HIGH = 3;
    public static final int ACCURACY_MODE_LOW = 1;
    private final DataType zzhz;
    private final DataSource zzia;
    private final long zzmc;
    private final int zzmd;
    private final long zzpu;
    private final long zzpv;
    private final long zzpy;

    private SensorRequest(Builder builder) {
        this.zzia = builder.zzia;
        this.zzhz = builder.zzhz;
        this.zzmc = builder.zzmc;
        this.zzpv = builder.zzpv;
        this.zzpu = builder.zzpu;
        this.zzmd = builder.zzmd;
        this.zzpy = builder.zzpy;
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static class Builder {
        /* access modifiers changed from: private */
        public DataType zzhz;
        /* access modifiers changed from: private */
        public DataSource zzia;
        /* access modifiers changed from: private */
        public long zzmc = -1;
        /* access modifiers changed from: private */
        public int zzmd = 2;
        /* access modifiers changed from: private */
        public long zzpu = 0;
        /* access modifiers changed from: private */
        public long zzpv = 0;
        /* access modifiers changed from: private */
        public long zzpy = LongCompanionObject.MAX_VALUE;
        private boolean zzpz = false;

        public Builder setDataSource(DataSource dataSource) {
            this.zzia = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.zzhz = dataType;
            return this;
        }

        public Builder setSamplingRate(long j, TimeUnit timeUnit) {
            Preconditions.checkArgument(j >= 0, "Cannot use a negative sampling interval");
            long micros = timeUnit.toMicros(j);
            this.zzmc = micros;
            if (!this.zzpz) {
                this.zzpv = micros / 2;
            }
            return this;
        }

        public Builder setFastestRate(int i, TimeUnit timeUnit) {
            Preconditions.checkArgument(i >= 0, "Cannot use a negative interval");
            this.zzpz = true;
            this.zzpv = timeUnit.toMicros((long) i);
            return this;
        }

        public Builder setMaxDeliveryLatency(int i, TimeUnit timeUnit) {
            Preconditions.checkArgument(i >= 0, "Cannot use a negative delivery interval");
            this.zzpu = timeUnit.toMicros((long) i);
            return this;
        }

        public Builder setAccuracyMode(int i) {
            if (!(i == 1 || i == 3)) {
                i = 2;
            }
            this.zzmd = i;
            return this;
        }

        public Builder setTimeout(long j, TimeUnit timeUnit) {
            boolean z = true;
            Preconditions.checkArgument(j > 0, "Invalid time out value specified: %d", Long.valueOf(j));
            if (timeUnit == null) {
                z = false;
            }
            Preconditions.checkArgument(z, "Invalid time unit specified");
            this.zzpy = timeUnit.toMicros(j);
            return this;
        }

        public SensorRequest build() {
            DataSource dataSource;
            boolean z = false;
            Preconditions.checkState((this.zzia == null && this.zzhz == null) ? false : true, "Must call setDataSource() or setDataType()");
            DataType dataType = this.zzhz;
            if (dataType == null || (dataSource = this.zzia) == null || dataType.equals(dataSource.getDataType())) {
                z = true;
            }
            Preconditions.checkState(z, "Specified data type is incompatible with specified data source");
            return new SensorRequest(this);
        }
    }

    public DataSource getDataSource() {
        return this.zzia;
    }

    public DataType getDataType() {
        return this.zzhz;
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzmc, TimeUnit.MICROSECONDS);
    }

    public long getFastestRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzpv, TimeUnit.MICROSECONDS);
    }

    public long getMaxDeliveryLatency(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzpu, TimeUnit.MICROSECONDS);
    }

    public int getAccuracyMode() {
        return this.zzmd;
    }

    public final long zzab() {
        return this.zzpy;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("dataSource", this.zzia).add("dataType", this.zzhz).add("samplingRateMicros", Long.valueOf(this.zzmc)).add("deliveryLatencyMicros", Long.valueOf(this.zzpu)).add("timeOutMicros", Long.valueOf(this.zzpy)).toString();
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SensorRequest) {
                SensorRequest sensorRequest = (SensorRequest) obj;
                if (Objects.equal(this.zzia, sensorRequest.zzia) && Objects.equal(this.zzhz, sensorRequest.zzhz) && this.zzmc == sensorRequest.zzmc && this.zzpv == sensorRequest.zzpv && this.zzpu == sensorRequest.zzpu && this.zzmd == sensorRequest.zzmd && this.zzpy == sensorRequest.zzpy) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzia, this.zzhz, Long.valueOf(this.zzmc), Long.valueOf(this.zzpv), Long.valueOf(this.zzpu), Integer.valueOf(this.zzmd), Long.valueOf(this.zzpy));
    }
}
