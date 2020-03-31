package org.koin.core.parameter;

import androidx.exifinterface.media.ExifInterface;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.error.NoParameterFoundException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001f\b\u0000\u0012\u0016\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0004J\u0014\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\tH\u0002¢\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u0002H\t\"\u0004\b\u0000\u0010\tH\u0002¢\u0006\u0002\u0010\nJ\u0014\u0010\f\u001a\u0002H\t\"\u0004\b\u0000\u0010\tH\u0002¢\u0006\u0002\u0010\nJ\u0014\u0010\r\u001a\u0002H\t\"\u0004\b\u0000\u0010\tH\u0002¢\u0006\u0002\u0010\nJ\u0014\u0010\u000e\u001a\u0002H\t\"\u0004\b\u0000\u0010\tH\u0002¢\u0006\u0002\u0010\nJ\u001b\u0010\u000f\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\t\u0018\u0001H\bJ\u001c\u0010\u0013\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J!\u0010\u0017\u001a\u00020\u0018\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u0002H\t¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0011R\u001d\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Lorg/koin/core/parameter/DefinitionParameters;", "", "values", "", "([Ljava/lang/Object;)V", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "component1", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "elementAt", "i", "", "(I)Ljava/lang/Object;", "get", "isEmpty", "", "isNotEmpty", "set", "", "t", "(ILjava/lang/Object;)V", "size", "Companion", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: DefinitionParameters.kt */
public final class DefinitionParameters {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_PARAMS = 5;
    private final Object[] values;

    public DefinitionParameters(Object... objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "values");
        this.values = objArr;
    }

    public final Object[] getValues() {
        return this.values;
    }

    private final <T> T elementAt(int i) {
        T[] tArr = this.values;
        if (tArr.length > i) {
            return tArr[i];
        }
        throw new NoParameterFoundException("Can't get parameter value #" + i + " from " + this);
    }

    public final <T> T component1() {
        return elementAt(0);
    }

    public final <T> T component2() {
        return elementAt(1);
    }

    public final <T> T component3() {
        return elementAt(2);
    }

    public final <T> T component4() {
        return elementAt(3);
    }

    public final <T> T component5() {
        return elementAt(4);
    }

    public final <T> T get(int i) {
        return this.values[i];
    }

    public final <T> void set(int i, T t) {
        ArraysKt.toMutableList(this.values).set(i, t);
    }

    public final int size() {
        return this.values.length;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public final /* synthetic */ <T> Object get() {
        for (Object obj : getValues()) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (obj instanceof Object) {
                return obj;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lorg/koin/core/parameter/DefinitionParameters$Companion;", "", "()V", "MAX_PARAMS", "", "koin-core"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DefinitionParameters.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
