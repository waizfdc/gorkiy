package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class MapValue extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<MapValue> CREATOR = new zzx();
    private final int format;
    private final float value;

    public MapValue(int i, float f) {
        this.format = i;
        this.value = f;
    }

    public static MapValue zza(float f) {
        return new MapValue(2, f);
    }

    public final float asFloat() {
        Preconditions.checkState(this.format == 2, "Value is not in float format");
        return this.value;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapValue)) {
            return false;
        }
        MapValue mapValue = (MapValue) obj;
        int i = this.format;
        if (i == mapValue.format) {
            if (i != 2) {
                return this.value == mapValue.value;
            }
            if (asFloat() == mapValue.asFloat()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (int) this.value;
    }

    public String toString() {
        if (this.format != 2) {
            return "unknown";
        }
        return Float.toString(asFloat());
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.format);
        SafeParcelWriter.writeFloat(parcel, 2, this.value);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
