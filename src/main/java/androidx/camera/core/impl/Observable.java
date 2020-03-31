package androidx.camera.core.impl;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public interface Observable<T> {

    public interface Observer<T> {
        void onError(Throwable th);

        void onNewData(Object obj);
    }

    void addObserver(Executor executor, Observer<T> observer);

    ListenableFuture<T> fetchData();

    void removeObserver(Observer<T> observer);
}
