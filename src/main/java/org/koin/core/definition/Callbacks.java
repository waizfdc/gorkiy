package org.koin.core.definition;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.fitness.FitnessActivities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012$\b\u0002\u0010\u0003\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J%\u0010\n\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006HÆ\u0003J5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002$\b\u0002\u0010\u0003\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R-\u0010\u0003\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lorg/koin/core/definition/Callbacks;", ExifInterface.GPS_DIRECTION_TRUE, "", "onClose", "Lkotlin/Function1;", "", "Lorg/koin/core/definition/OnCloseCallback;", "(Lkotlin/jvm/functions/Function1;)V", "getOnClose", "()Lkotlin/jvm/functions/Function1;", "component1", "copy", "equals", "", FitnessActivities.OTHER, "hashCode", "", "toString", "", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: Callbacks.kt */
public final class Callbacks<T> {
    private final Function1<T, Unit> onClose;

    public Callbacks() {
        this(null, 1, null);
    }

    public static /* synthetic */ Callbacks copy$default(Callbacks callbacks, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = callbacks.onClose;
        }
        return callbacks.copy(function1);
    }

    public final Function1<T, Unit> component1() {
        return this.onClose;
    }

    public final Callbacks<T> copy(Function1<? super T, Unit> function1) {
        return new Callbacks<>(function1);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Callbacks) && Intrinsics.areEqual(this.onClose, ((Callbacks) obj).onClose);
        }
        return true;
    }

    public int hashCode() {
        Function1<T, Unit> function1 = this.onClose;
        if (function1 != null) {
            return function1.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Callbacks(onClose=" + this.onClose + ")";
    }

    public Callbacks(Function1<? super T, Unit> function1) {
        this.onClose = function1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Callbacks(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1);
    }

    public final Function1<T, Unit> getOnClose() {
        return this.onClose;
    }
}
