package androidx.camera.core.impl.utils.executor;

import androidx.core.util.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

final class SequentialExecutor implements Executor {
    private static final String TAG = "SequentialExecutor";
    private final Executor mExecutor;
    final Deque<Runnable> mQueue = new ArrayDeque();
    private final QueueWorker mWorker = new QueueWorker();
    long mWorkerRunCount = 0;
    WorkerRunningState mWorkerRunningState = WorkerRunningState.IDLE;

    enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    SequentialExecutor(Executor executor) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r7.mExecutor.execute(r7.mWorker);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r7.mWorkerRunningState == androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUING) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        if (r8 == false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        r4 = r7.mQueue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        if (r7.mWorkerRunCount != r1) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        if (r7.mWorkerRunningState != androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUING) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        r7.mWorkerRunningState = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0055, code lost:
        monitor-enter(r7.mQueue);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005a, code lost:
        if (r7.mWorkerRunningState == androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.IDLE) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006b, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006e, code lost:
        if ((r1 instanceof java.util.concurrent.RejectedExecutionException) == false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0073, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0074, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute(final java.lang.Runnable r8) {
        /*
            r7 = this;
            androidx.core.util.Preconditions.checkNotNull(r8)
            java.util.Deque<java.lang.Runnable> r0 = r7.mQueue
            monitor-enter(r0)
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r1 = r7.mWorkerRunningState     // Catch:{ all -> 0x007f }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r2 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.RUNNING     // Catch:{ all -> 0x007f }
            if (r1 == r2) goto L_0x0078
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r1 = r7.mWorkerRunningState     // Catch:{ all -> 0x007f }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r2 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUED     // Catch:{ all -> 0x007f }
            if (r1 != r2) goto L_0x0013
            goto L_0x0078
        L_0x0013:
            long r1 = r7.mWorkerRunCount     // Catch:{ all -> 0x007f }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$1 r3 = new androidx.camera.core.impl.utils.executor.SequentialExecutor$1     // Catch:{ all -> 0x007f }
            r3.<init>(r8)     // Catch:{ all -> 0x007f }
            java.util.Deque<java.lang.Runnable> r8 = r7.mQueue     // Catch:{ all -> 0x007f }
            r8.add(r3)     // Catch:{ all -> 0x007f }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r8 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUING     // Catch:{ all -> 0x007f }
            r7.mWorkerRunningState = r8     // Catch:{ all -> 0x007f }
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            r8 = 1
            r0 = 0
            java.util.concurrent.Executor r4 = r7.mExecutor     // Catch:{ RuntimeException -> 0x0052, Error -> 0x0050 }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$QueueWorker r5 = r7.mWorker     // Catch:{ RuntimeException -> 0x0052, Error -> 0x0050 }
            r4.execute(r5)     // Catch:{ RuntimeException -> 0x0052, Error -> 0x0050 }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r3 = r7.mWorkerRunningState
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r4 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUING
            if (r3 == r4) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r8 = r0
        L_0x0035:
            if (r8 == 0) goto L_0x0038
            return
        L_0x0038:
            java.util.Deque<java.lang.Runnable> r4 = r7.mQueue
            monitor-enter(r4)
            long r5 = r7.mWorkerRunCount     // Catch:{ all -> 0x004d }
            int r8 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x004b
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r8 = r7.mWorkerRunningState     // Catch:{ all -> 0x004d }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r0 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUING     // Catch:{ all -> 0x004d }
            if (r8 != r0) goto L_0x004b
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r8 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUED     // Catch:{ all -> 0x004d }
            r7.mWorkerRunningState = r8     // Catch:{ all -> 0x004d }
        L_0x004b:
            monitor-exit(r4)     // Catch:{ all -> 0x004d }
            return
        L_0x004d:
            r8 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x004d }
            throw r8
        L_0x0050:
            r1 = move-exception
            goto L_0x0053
        L_0x0052:
            r1 = move-exception
        L_0x0053:
            java.util.Deque<java.lang.Runnable> r2 = r7.mQueue
            monitor-enter(r2)
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r4 = r7.mWorkerRunningState     // Catch:{ all -> 0x0075 }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r5 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.IDLE     // Catch:{ all -> 0x0075 }
            if (r4 == r5) goto L_0x0062
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r4 = r7.mWorkerRunningState     // Catch:{ all -> 0x0075 }
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r5 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUING     // Catch:{ all -> 0x0075 }
            if (r4 != r5) goto L_0x006b
        L_0x0062:
            java.util.Deque<java.lang.Runnable> r4 = r7.mQueue     // Catch:{ all -> 0x0075 }
            boolean r3 = r4.removeLastOccurrence(r3)     // Catch:{ all -> 0x0075 }
            if (r3 == 0) goto L_0x006b
            goto L_0x006c
        L_0x006b:
            r8 = r0
        L_0x006c:
            boolean r0 = r1 instanceof java.util.concurrent.RejectedExecutionException     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x0074
            if (r8 != 0) goto L_0x0074
            monitor-exit(r2)     // Catch:{ all -> 0x0075 }
            return
        L_0x0074:
            throw r1     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0075 }
            throw r8
        L_0x0078:
            java.util.Deque<java.lang.Runnable> r1 = r7.mQueue     // Catch:{ all -> 0x007f }
            r1.add(r8)     // Catch:{ all -> 0x007f }
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            return
        L_0x007f:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.executor.SequentialExecutor.execute(java.lang.Runnable):void");
    }

    final class QueueWorker implements Runnable {
        QueueWorker() {
        }

        public void run() {
            try {
                workOnQueue();
            } catch (Error e) {
                synchronized (SequentialExecutor.this.mQueue) {
                    SequentialExecutor.this.mWorkerRunningState = WorkerRunningState.IDLE;
                    throw e;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
            if (r1 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r3.run();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
            if (r1 == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void workOnQueue() {
            /*
                r7 = this;
                r0 = 0
                r1 = r0
            L_0x0002:
                androidx.camera.core.impl.utils.executor.SequentialExecutor r2 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch:{ all -> 0x006e }
                java.util.Deque<java.lang.Runnable> r2 = r2.mQueue     // Catch:{ all -> 0x006e }
                monitor-enter(r2)     // Catch:{ all -> 0x006e }
                if (r0 != 0) goto L_0x002c
                androidx.camera.core.impl.utils.executor.SequentialExecutor r0 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch:{ all -> 0x006b }
                androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r0 = r0.mWorkerRunningState     // Catch:{ all -> 0x006b }
                androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r3 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.RUNNING     // Catch:{ all -> 0x006b }
                if (r0 != r3) goto L_0x001c
                monitor-exit(r2)     // Catch:{ all -> 0x006b }
                if (r1 == 0) goto L_0x001b
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L_0x001b:
                return
            L_0x001c:
                androidx.camera.core.impl.utils.executor.SequentialExecutor r0 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch:{ all -> 0x006b }
                long r3 = r0.mWorkerRunCount     // Catch:{ all -> 0x006b }
                r5 = 1
                long r3 = r3 + r5
                r0.mWorkerRunCount = r3     // Catch:{ all -> 0x006b }
                androidx.camera.core.impl.utils.executor.SequentialExecutor r0 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch:{ all -> 0x006b }
                androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r3 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.RUNNING     // Catch:{ all -> 0x006b }
                r0.mWorkerRunningState = r3     // Catch:{ all -> 0x006b }
                r0 = 1
            L_0x002c:
                androidx.camera.core.impl.utils.executor.SequentialExecutor r3 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch:{ all -> 0x006b }
                java.util.Deque<java.lang.Runnable> r3 = r3.mQueue     // Catch:{ all -> 0x006b }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x006b }
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ all -> 0x006b }
                if (r3 != 0) goto L_0x0049
                androidx.camera.core.impl.utils.executor.SequentialExecutor r0 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch:{ all -> 0x006b }
                androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r3 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.IDLE     // Catch:{ all -> 0x006b }
                r0.mWorkerRunningState = r3     // Catch:{ all -> 0x006b }
                monitor-exit(r2)     // Catch:{ all -> 0x006b }
                if (r1 == 0) goto L_0x0048
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L_0x0048:
                return
            L_0x0049:
                monitor-exit(r2)     // Catch:{ all -> 0x006b }
                boolean r2 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x006e }
                r1 = r1 | r2
                r3.run()     // Catch:{ RuntimeException -> 0x0053 }
                goto L_0x0002
            L_0x0053:
                r2 = move-exception
                java.lang.String r4 = "SequentialExecutor"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
                r5.<init>()     // Catch:{ all -> 0x006e }
                java.lang.String r6 = "Exception while executing runnable "
                r5.append(r6)     // Catch:{ all -> 0x006e }
                r5.append(r3)     // Catch:{ all -> 0x006e }
                java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x006e }
                android.util.Log.e(r4, r3, r2)     // Catch:{ all -> 0x006e }
                goto L_0x0002
            L_0x006b:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x006b }
                throw r0     // Catch:{ all -> 0x006e }
            L_0x006e:
                r0 = move-exception
                if (r1 == 0) goto L_0x0078
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L_0x0078:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.executor.SequentialExecutor.QueueWorker.workOnQueue():void");
        }
    }
}
