package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class DataSource extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataSource> CREATOR = new zzk();
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_GLUCOSE_ISO151972003 = 8;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_GLUCOSE_ISO151972013 = 9;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_PRESSURE_AAMI = 3;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_PRESSURE_BHS_A_A = 4;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_PRESSURE_BHS_A_B = 5;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_PRESSURE_BHS_B_A = 6;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_PRESSURE_BHS_B_B = 7;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_PRESSURE_ESH2002 = 1;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_PRESSURE_ESH2010 = 2;
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;
    private static final int[] zzje = new int[0];
    private final String name;
    private final int type;
    private final DataType zzhz;
    private final Device zzjf;
    private final zzc zzjg;
    private final String zzjh;
    private final int[] zzji;
    private final String zzjj;

    public DataSource(DataType dataType, String str, int i, Device device, zzc zzc, String str2, int[] iArr) {
        this.zzhz = dataType;
        this.type = i;
        this.name = str;
        this.zzjf = device;
        this.zzjg = zzc;
        this.zzjh = str2;
        this.zzjj = zzm();
        this.zzji = iArr == null ? zzje : iArr;
    }

    public static String zzd(int i) {
        switch (i) {
            case 1:
                return "blood_pressure_esh2002";
            case 2:
                return "blood_pressure_esh2010";
            case 3:
                return "blood_pressure_aami";
            case 4:
                return "blood_pressure_bhs_a_a";
            case 5:
                return "blood_pressure_bhs_a_b";
            case 6:
                return "blood_pressure_bhs_b_a";
            case 7:
                return "blood_pressure_bhs_b_b";
            case 8:
                return "blood_glucose_iso151972003";
            case 9:
                return "blood_glucose_iso151972013";
            default:
                return "unknown";
        }
    }

    /* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public String name;
        /* access modifiers changed from: private */
        public int type = -1;
        /* access modifiers changed from: private */
        public DataType zzhz;
        /* access modifiers changed from: private */
        public Device zzjf;
        /* access modifiers changed from: private */
        public zzc zzjg;
        /* access modifiers changed from: private */
        public String zzjh = "";
        /* access modifiers changed from: private */
        public int[] zzji;

        public final Builder setDataType(DataType dataType) {
            this.zzhz = dataType;
            return this;
        }

        public final Builder setType(int i) {
            this.type = i;
            return this;
        }

        @Deprecated
        public final Builder setName(String str) {
            this.name = str;
            return this;
        }

        public final Builder setDevice(Device device) {
            this.zzjf = device;
            return this;
        }

        public final Builder setAppPackageName(String str) {
            this.zzjg = zzc.zza(str);
            return this;
        }

        public final Builder setAppPackageName(Context context) {
            return setAppPackageName(context.getPackageName());
        }

        public final Builder setStreamName(String str) {
            Preconditions.checkArgument(str != null, "Must specify a valid stream name");
            this.zzjh = str;
            return this;
        }

        @Deprecated
        public final Builder setDataQualityStandards(int... iArr) {
            this.zzji = iArr;
            return this;
        }

        public final DataSource build() {
            boolean z = true;
            Preconditions.checkState(this.zzhz != null, "Must set data type");
            if (this.type < 0) {
                z = false;
            }
            Preconditions.checkState(z, "Must set data source type");
            return new DataSource(this);
        }
    }

    private DataSource(Builder builder) {
        this.zzhz = builder.zzhz;
        this.type = builder.type;
        this.name = builder.name;
        this.zzjf = builder.zzjf;
        this.zzjg = builder.zzjg;
        this.zzjh = builder.zzjh;
        this.zzjj = zzm();
        this.zzji = builder.zzji;
    }

    public static DataSource extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (DataSource) SafeParcelableSerializer.deserializeFromIntentExtra(intent, EXTRA_DATA_SOURCE, CREATOR);
    }

    public DataType getDataType() {
        return this.zzhz;
    }

    public int getType() {
        return this.type;
    }

    @Deprecated
    public String getName() {
        return this.name;
    }

    public String getAppPackageName() {
        zzc zzc = this.zzjg;
        if (zzc == null) {
            return null;
        }
        return zzc.getPackageName();
    }

    public final zzc zzl() {
        return this.zzjg;
    }

    public Device getDevice() {
        return this.zzjf;
    }

    public String getStreamName() {
        return this.zzjh;
    }

    @Deprecated
    public int[] getDataQualityStandards() {
        return this.zzji;
    }

    public String getStreamIdentifier() {
        return this.zzjj;
    }

    private final String zzm() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTypeString());
        sb.append(":");
        sb.append(this.zzhz.getName());
        if (this.zzjg != null) {
            sb.append(":");
            sb.append(this.zzjg.getPackageName());
        }
        if (this.zzjf != null) {
            sb.append(":");
            sb.append(this.zzjf.getStreamIdentifier());
        }
        if (this.zzjh != null) {
            sb.append(":");
            sb.append(this.zzjh);
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataSource)) {
            return false;
        }
        return this.zzjj.equals(((DataSource) obj).zzjj);
    }

    public int hashCode() {
        return this.zzjj.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataSource{");
        sb.append(getTypeString());
        if (this.name != null) {
            sb.append(":");
            sb.append(this.name);
        }
        if (this.zzjg != null) {
            sb.append(":");
            sb.append(this.zzjg);
        }
        if (this.zzjf != null) {
            sb.append(":");
            sb.append(this.zzjf);
        }
        if (this.zzjh != null) {
            sb.append(":");
            sb.append(this.zzjh);
        }
        sb.append(":");
        sb.append(this.zzhz);
        sb.append("}");
        return sb.toString();
    }

    public final String toDebugString() {
        String str;
        String str2;
        int i = this.type;
        String str3 = i != 0 ? i != 1 ? "?" : "d" : "r";
        String zzp = this.zzhz.zzp();
        zzc zzc = this.zzjg;
        String str4 = "";
        if (zzc == null) {
            str = str4;
        } else if (zzc.equals(zzc.zzil)) {
            str = ":gms";
        } else {
            String valueOf = String.valueOf(this.zzjg.getPackageName());
            str = valueOf.length() != 0 ? ":".concat(valueOf) : new String(":");
        }
        Device device = this.zzjf;
        if (device != null) {
            String model = device.getModel();
            String uid = this.zzjf.getUid();
            StringBuilder sb = new StringBuilder(String.valueOf(model).length() + 2 + String.valueOf(uid).length());
            sb.append(":");
            sb.append(model);
            sb.append(":");
            sb.append(uid);
            str2 = sb.toString();
        } else {
            str2 = str4;
        }
        String str5 = this.zzjh;
        if (str5 != null) {
            String valueOf2 = String.valueOf(str5);
            str4 = valueOf2.length() != 0 ? ":".concat(valueOf2) : new String(":");
        }
        StringBuilder sb2 = new StringBuilder(str3.length() + 1 + String.valueOf(zzp).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str4).length());
        sb2.append(str3);
        sb2.append(":");
        sb2.append(zzp);
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str4);
        return sb2.toString();
    }

    private final String getTypeString() {
        return this.type != 0 ? "derived" : "raw";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataType(), i, false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeInt(parcel, 3, getType());
        SafeParcelWriter.writeParcelable(parcel, 4, getDevice(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzjg, i, false);
        SafeParcelWriter.writeString(parcel, 6, getStreamName(), false);
        SafeParcelWriter.writeIntArray(parcel, 8, getDataQualityStandards(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
