package com.google.android.gms.internal.firebase_ml;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.ml.common.FirebaseMLException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzpf implements Handler.Callback {
    private static final Object lock = new Object();
    private static zzpf zzbbt;
    /* access modifiers changed from: private */
    public Handler handler;

    public static Executor zznn() {
        return zzph.INSTANCE;
    }

    public static zzpf zzno() {
        zzpf zzpf;
        synchronized (lock) {
            if (zzbbt == null) {
                HandlerThread handlerThread = new HandlerThread("FirebaseMLHandler", 9);
                handlerThread.start();
                zzbbt = new zzpf(handlerThread.getLooper());
            }
            zzpf = zzbbt;
        }
        return zzpf;
    }

    private zzpf(Looper looper) {
        this.handler = new zze(looper, this);
    }

    public final <ResultT> Task<ResultT> zza(Callable<ResultT> callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.handler.post(new zzpe(callable, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final <ResultT> void zza(Callable callable, long j) {
        Handler handler2 = this.handler;
        handler2.sendMessageDelayed(handler2.obtainMessage(1, callable), j);
    }

    public final <ResultT> void zzb(Callable<ResultT> callable) {
        this.handler.removeMessages(1, callable);
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            try {
                ((Callable) message.obj).call();
            } catch (Exception unused) {
                Log.e("MLTaskExecutor", "Exception when executing the delayed Callable");
            }
        }
        return true;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    static final /* synthetic */ void zza(Callable callable, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(callable.call());
        } catch (FirebaseMLException e) {
            taskCompletionSource.setException(e);
        } catch (Exception e2) {
            taskCompletionSource.setException(new FirebaseMLException("Internal error has occurred when executing Firebase ML tasks", 13, e2));
        }
    }
}
