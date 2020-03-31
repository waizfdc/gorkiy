package com.hadilq.liveevent;

import androidx.collection.ArraySet;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\fH\u0017J\u0018\u0010\r\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\fH\u0017J\u0018\u0010\u000e\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\fH\u0017J\u0017\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0017¢\u0006\u0002\u0010\u0011R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/hadilq/liveevent/LiveEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MediatorLiveData;", "()V", "observers", "Landroidx/collection/ArraySet;", "Lcom/hadilq/liveevent/LiveEvent$ObserverWrapper;", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "observeForever", "removeObserver", "setValue", "t", "(Ljava/lang/Object;)V", "ObserverWrapper", "liveevent_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: LiveEvent.kt */
public final class LiveEvent<T> extends MediatorLiveData<T> {
    private final ArraySet<ObserverWrapper<? super T>> observers = new ArraySet<>();

    public void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "owner");
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        ObserverWrapper observerWrapper = new ObserverWrapper(observer);
        this.observers.add(observerWrapper);
        super.observe(lifecycleOwner, observerWrapper);
    }

    public void observeForever(Observer<? super T> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        ObserverWrapper observerWrapper = new ObserverWrapper(observer);
        this.observers.add(observerWrapper);
        super.observeForever(observerWrapper);
    }

    public void removeObserver(Observer<? super T> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        Collection collection = this.observers;
        if (collection == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        } else if (TypeIntrinsics.asMutableCollection(collection).remove(observer)) {
            super.removeObserver(observer);
        } else {
            Iterator<ObserverWrapper<? super T>> it = this.observers.iterator();
            Intrinsics.checkExpressionValueIsNotNull(it, "observers.iterator()");
            while (it.hasNext()) {
                ObserverWrapper next = it.next();
                if (Intrinsics.areEqual(next.getObserver(), observer)) {
                    it.remove();
                    super.removeObserver(next);
                    return;
                }
            }
        }
    }

    public void setValue(T t) {
        for (ObserverWrapper newValue : this.observers) {
            newValue.newValue();
        }
        super.setValue(t);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010\rR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/hadilq/liveevent/LiveEvent$ObserverWrapper;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/Observer;", "observer", "(Landroidx/lifecycle/Observer;)V", "getObserver", "()Landroidx/lifecycle/Observer;", "pending", "", "newValue", "", "onChanged", "t", "(Ljava/lang/Object;)V", "liveevent_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: LiveEvent.kt */
    private static final class ObserverWrapper<T> implements Observer<T> {
        private final Observer<T> observer;
        private boolean pending;

        public ObserverWrapper(Observer<T> observer2) {
            Intrinsics.checkParameterIsNotNull(observer2, "observer");
            this.observer = observer2;
        }

        public final Observer<T> getObserver() {
            return this.observer;
        }

        public void onChanged(T t) {
            if (this.pending) {
                this.pending = false;
                this.observer.onChanged(t);
            }
        }

        public final void newValue() {
            this.pending = true;
        }
    }
}
