package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzt;
import com.google.android.gms.fitness.data.zzu;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcp;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new zzap();
    private DataType zzhz;
    private DataSource zzia;
    private final long zzmc;
    private final int zzmd;
    private final zzcm zzok;
    private final PendingIntent zzpk;
    private zzu zzpt;
    private final long zzpu;
    private final long zzpv;
    private final long zzpw;
    private final List<ClientIdentity> zzpx;

    zzao(DataSource dataSource, DataType dataType, IBinder iBinder, long j, long j2, PendingIntent pendingIntent, long j3, int i, long j4, IBinder iBinder2) {
        zzu zzu;
        this.zzia = dataSource;
        this.zzhz = dataType;
        if (iBinder == null) {
            zzu = null;
        } else {
            zzu = zzt.zza(iBinder);
        }
        this.zzpt = zzu;
        this.zzmc = j;
        this.zzpv = j3;
        this.zzpu = j2;
        this.zzpk = pendingIntent;
        this.zzmd = i;
        this.zzpx = Collections.emptyList();
        this.zzpw = j4;
        this.zzok = zzcp.zzj(iBinder2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzao(com.google.android.gms.fitness.request.SensorRequest r17, com.google.android.gms.fitness.data.zzu r18, android.app.PendingIntent r19, com.google.android.gms.internal.fitness.zzcm r20) {
        /*
            r16 = this;
            r0 = r17
            com.google.android.gms.fitness.data.DataSource r1 = r17.getDataSource()
            com.google.android.gms.fitness.data.DataType r2 = r17.getDataType()
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MICROSECONDS
            long r5 = r0.getSamplingRate(r3)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MICROSECONDS
            long r7 = r0.getFastestRate(r3)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MICROSECONDS
            long r9 = r0.getMaxDeliveryLatency(r3)
            int r11 = r17.getAccuracyMode()
            java.util.List r12 = java.util.Collections.emptyList()
            long r13 = r17.zzab()
            r0 = r16
            r3 = r18
            r4 = r19
            r15 = r20
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r11, r12, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.request.zzao.<init>(com.google.android.gms.fitness.request.SensorRequest, com.google.android.gms.fitness.data.zzu, android.app.PendingIntent, com.google.android.gms.internal.fitness.zzcm):void");
    }

    private zzao(DataSource dataSource, DataType dataType, zzu zzu, PendingIntent pendingIntent, long j, long j2, long j3, int i, List<ClientIdentity> list, long j4, zzcm zzcm) {
        this.zzia = dataSource;
        this.zzhz = dataType;
        this.zzpt = zzu;
        this.zzpk = pendingIntent;
        this.zzmc = j;
        this.zzpv = j2;
        this.zzpu = j3;
        this.zzmd = i;
        this.zzpx = list;
        this.zzpw = j4;
        this.zzok = zzcm;
    }

    public final String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", this.zzhz, this.zzia, Long.valueOf(this.zzmc), Long.valueOf(this.zzpv), Long.valueOf(this.zzpu));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzia, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzhz, i, false);
        zzu zzu = this.zzpt;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 3, zzu == null ? null : zzu.asBinder(), false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzmc);
        SafeParcelWriter.writeLong(parcel, 7, this.zzpu);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzpk, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzpv);
        SafeParcelWriter.writeInt(parcel, 10, this.zzmd);
        SafeParcelWriter.writeLong(parcel, 12, this.zzpw);
        zzcm zzcm = this.zzok;
        if (zzcm != null) {
            iBinder = zzcm.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 13, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof zzao) {
                zzao zzao = (zzao) obj;
                if (Objects.equal(this.zzia, zzao.zzia) && Objects.equal(this.zzhz, zzao.zzhz) && Objects.equal(this.zzpt, zzao.zzpt) && this.zzmc == zzao.zzmc && this.zzpv == zzao.zzpv && this.zzpu == zzao.zzpu && this.zzmd == zzao.zzmd) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzia, this.zzhz, this.zzpt, Long.valueOf(this.zzmc), Long.valueOf(this.zzpv), Long.valueOf(this.zzpu), Integer.valueOf(this.zzmd));
    }
}
