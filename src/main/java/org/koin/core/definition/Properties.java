package org.koin.core.definition;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.error.MissingPropertyException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003HÂ\u0003J\u001f\u0010\u0007\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001c\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u000f\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0002\u0010\u000eJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J$\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u0002H\fH\u0002¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lorg/koin/core/definition/Properties;", "", "data", "", "", "(Ljava/util/Map;)V", "component1", "copy", "equals", "", FitnessActivities.OTHER, "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Ljava/lang/String;)Ljava/lang/Object;", "getOrNull", "hashCode", "", "set", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "toString", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: Properties.kt */
public final class Properties {
    private final Map<String, Object> data;

    public Properties() {
        this(null, 1, null);
    }

    private final Map<String, Object> component1() {
        return this.data;
    }

    public static /* synthetic */ Properties copy$default(Properties properties, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = properties.data;
        }
        return properties.copy(map);
    }

    public final Properties copy(Map<String, Object> map) {
        Intrinsics.checkParameterIsNotNull(map, "data");
        return new Properties(map);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Properties) && Intrinsics.areEqual(this.data, ((Properties) obj).data);
        }
        return true;
    }

    public int hashCode() {
        Map<String, Object> map = this.data;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Properties(data=" + this.data + ")";
    }

    public Properties(Map<String, Object> map) {
        Intrinsics.checkParameterIsNotNull(map, "data");
        this.data = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Properties(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ConcurrentHashMap() : map);
    }

    public final <T> void set(String str, T t) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Map<String, Object> map = this.data;
        if (t != null) {
            map.put(str, t);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
    }

    public final <T> T getOrNull(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        T t = this.data.get(str);
        if (!(t instanceof Object)) {
            return null;
        }
        return t;
    }

    public final <T> T get(String str) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        T t = this.data.get(str);
        if (!(t instanceof Object)) {
            t = null;
        }
        if (t != null) {
            return t;
        }
        throw new MissingPropertyException("missing property for '" + str + '\'');
    }
}
