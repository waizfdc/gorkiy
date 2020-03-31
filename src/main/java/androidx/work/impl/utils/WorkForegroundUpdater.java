package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public class WorkForegroundUpdater implements ForegroundUpdater {
    final ForegroundProcessor mForegroundProcessor;
    private final TaskExecutor mTaskExecutor;

    public WorkForegroundUpdater(ForegroundProcessor foregroundProcessor, TaskExecutor taskExecutor) {
        this.mForegroundProcessor = foregroundProcessor;
        this.mTaskExecutor = taskExecutor;
    }

    public ListenableFuture<Void> setForegroundAsync(Context context, UUID uuid, ForegroundInfo foregroundInfo) {
        SettableFuture create = SettableFuture.create();
        final SettableFuture settableFuture = create;
        final UUID uuid2 = uuid;
        final ForegroundInfo foregroundInfo2 = foregroundInfo;
        final Context context2 = context;
        this.mTaskExecutor.executeOnBackgroundThread(new Runnable() {
            /* class androidx.work.impl.utils.WorkForegroundUpdater.AnonymousClass1 */

            public void run() {
                try {
                    if (!settableFuture.isCancelled()) {
                        String uuid = uuid2.toString();
                        WorkForegroundUpdater.this.mForegroundProcessor.startForeground(uuid, foregroundInfo2);
                        context2.startService(SystemForegroundDispatcher.createNotifyIntent(context2, uuid, foregroundInfo2));
                    }
                    settableFuture.set(null);
                } catch (Throwable th) {
                    settableFuture.setException(th);
                }
            }
        });
        return create;
    }
}
