package androidx.camera.extensions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class BlockingCloseAccessCounter {
    private static final int COUNTER_DESTROYED_FLAG = -1;
    private AtomicInteger mAccessCount = new AtomicInteger(0);
    private final Condition mDoneCondition;
    private final Lock mLock;

    BlockingCloseAccessCounter() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mDoneCondition = reentrantLock.newCondition();
    }

    /* access modifiers changed from: package-private */
    public boolean tryIncrement() {
        this.mLock.lock();
        try {
            if (this.mAccessCount.get() == -1) {
                return false;
            }
            this.mAccessCount.getAndIncrement();
            this.mLock.unlock();
            return true;
        } finally {
            this.mLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void decrement() {
        this.mLock.lock();
        try {
            int andDecrement = this.mAccessCount.getAndDecrement();
            if (andDecrement == -1) {
                throw new IllegalStateException("Unable to decrement. Counter already destroyed");
            } else if (andDecrement != 0) {
                this.mDoneCondition.signal();
            } else {
                throw new IllegalStateException("Unable to decrement. No corresponding counter increment");
            }
        } finally {
            this.mLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0005 */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x000f A[SYNTHETIC, Splitter:B:4:0x000f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void destroyAndWaitForZeroAccess() {
        /*
            r3 = this;
            java.util.concurrent.locks.Lock r0 = r3.mLock
            r0.lock()
        L_0x0005:
            java.util.concurrent.atomic.AtomicInteger r0 = r3.mAccessCount     // Catch:{ all -> 0x001b }
            r1 = 0
            r2 = -1
            boolean r0 = r0.compareAndSet(r1, r2)     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0015
            java.util.concurrent.locks.Condition r0 = r3.mDoneCondition     // Catch:{ InterruptedException -> 0x0005 }
            r0.await()     // Catch:{ InterruptedException -> 0x0005 }
            goto L_0x0005
        L_0x0015:
            java.util.concurrent.locks.Lock r0 = r3.mLock
            r0.unlock()
            return
        L_0x001b:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r3.mLock
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.BlockingCloseAccessCounter.destroyAndWaitForZeroAccess():void");
    }
}
