package androidx.camera.core.impl;

import android.os.SystemClock;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public final class LiveDataObservable<T> implements Observable<T> {
    final MutableLiveData<Result<T>> mLiveData = new MutableLiveData<>();
    private final Map<Observable.Observer<T>, LiveDataObserverAdapter<T>> mObservers = new HashMap();

    public void postValue(T t) {
        this.mLiveData.postValue(Result.fromValue(t));
    }

    public void postError(Throwable th) {
        this.mLiveData.postValue(Result.fromError(th));
    }

    public LiveData<Result<T>> getLiveData() {
        return this.mLiveData;
    }

    public ListenableFuture<T> fetchData() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<T>() {
            /* class androidx.camera.core.impl.LiveDataObservable.AnonymousClass1 */

            public Object attachCompleter(final CallbackToFutureAdapter.Completer<T> completer) {
                CameraXExecutors.mainThreadExecutor().execute(new Runnable() {
                    /* class androidx.camera.core.impl.LiveDataObservable.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        Result value = LiveDataObservable.this.mLiveData.getValue();
                        if (value == null) {
                            completer.setException(new IllegalStateException("Observable has not yet been initialized with a value."));
                        } else if (value.completedSuccessfully()) {
                            completer.set(value.getValue());
                        } else {
                            Preconditions.checkNotNull(value.getError());
                            completer.setException(value.getError());
                        }
                    }
                });
                return LiveDataObservable.this + " [fetch@" + SystemClock.uptimeMillis() + "]";
            }
        });
    }

    public void addObserver(Executor executor, Observable.Observer<T> observer) {
        synchronized (this.mObservers) {
            final LiveDataObserverAdapter liveDataObserverAdapter = this.mObservers.get(observer);
            if (liveDataObserverAdapter != null) {
                liveDataObserverAdapter.disable();
            }
            final LiveDataObserverAdapter liveDataObserverAdapter2 = new LiveDataObserverAdapter(executor, observer);
            this.mObservers.put(observer, liveDataObserverAdapter2);
            CameraXExecutors.mainThreadExecutor().execute(new Runnable() {
                /* class androidx.camera.core.impl.LiveDataObservable.AnonymousClass2 */

                public void run() {
                    LiveDataObservable.this.mLiveData.removeObserver(liveDataObserverAdapter);
                    LiveDataObservable.this.mLiveData.observeForever(liveDataObserverAdapter2);
                }
            });
        }
    }

    public void removeObserver(Observable.Observer<T> observer) {
        synchronized (this.mObservers) {
            final LiveDataObserverAdapter remove = this.mObservers.remove(observer);
            if (remove != null) {
                remove.disable();
                CameraXExecutors.mainThreadExecutor().execute(new Runnable() {
                    /* class androidx.camera.core.impl.LiveDataObservable.AnonymousClass3 */

                    public void run() {
                        LiveDataObservable.this.mLiveData.removeObserver(remove);
                    }
                });
            }
        }
    }

    public static final class Result<T> {
        private Throwable mError;
        private T mValue;

        private Result(T t, Throwable th) {
            this.mValue = t;
            this.mError = th;
        }

        static <T> Result<T> fromValue(T t) {
            return new Result<>(t, null);
        }

        static <T> Result<T> fromError(Throwable th) {
            return new Result<>(null, (Throwable) Preconditions.checkNotNull(th));
        }

        public boolean completedSuccessfully() {
            return this.mError == null;
        }

        public T getValue() {
            if (completedSuccessfully()) {
                return this.mValue;
            }
            throw new IllegalStateException("Result contains an error. Does not contain a value.");
        }

        public Throwable getError() {
            return this.mError;
        }
    }

    private static final class LiveDataObserverAdapter<T> implements Observer<Result<T>> {
        final AtomicBoolean mActive = new AtomicBoolean(true);
        final Executor mExecutor;
        final Observable.Observer<T> mObserver;

        LiveDataObserverAdapter(Executor executor, Observable.Observer<T> observer) {
            this.mExecutor = executor;
            this.mObserver = observer;
        }

        /* access modifiers changed from: package-private */
        public void disable() {
            this.mActive.set(false);
        }

        public void onChanged(final Result<T> result) {
            this.mExecutor.execute(new Runnable() {
                /* class androidx.camera.core.impl.LiveDataObservable.LiveDataObserverAdapter.AnonymousClass1 */

                public void run() {
                    if (LiveDataObserverAdapter.this.mActive.get()) {
                        if (result.completedSuccessfully()) {
                            LiveDataObserverAdapter.this.mObserver.onNewData(result.getValue());
                            return;
                        }
                        Preconditions.checkNotNull(result.getError());
                        LiveDataObserverAdapter.this.mObserver.onError(result.getError());
                    }
                }
            });
        }
    }
}
