package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0015\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010 J!\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00028\u00002\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#H\u0014¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u0012H\u0014J\n\u0010'\u001a\u0004\u0018\u00010\bH\u0014J\u0016\u0010(\u001a\u0004\u0018\u00010\b2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#H\u0014R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8TX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u0012\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "capacity", "", "(I)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "getCapacity", "()I", "head", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "size", "ensureCapacity", "", "currentSize", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotent", "wasClosed", "pollInternal", "pollSelectInternal", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: ArrayChannel.kt */
public class ArrayChannel<E> extends AbstractChannel<E> {
    private Object[] buffer;
    private final int capacity;
    private int head;
    private final ReentrantLock lock;
    private int size;

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysEmpty() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysFull() {
        return false;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public ArrayChannel(int i) {
        this.capacity = i;
        if (i < 1 ? false : true) {
            this.lock = new ReentrantLock();
            this.buffer = new Object[Math.min(this.capacity, 8)];
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + this.capacity + " was specified").toString());
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferEmpty() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            return this.size == 0;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferFull() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            return this.size == this.capacity;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public Object offerInternal(E e) {
        ReceiveOrClosed takeFirstReceiveOrPeekClosed;
        Symbol tryResumeReceive;
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (i < this.capacity) {
                this.size = i + 1;
                if (i == 0) {
                    do {
                        takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                        if (takeFirstReceiveOrPeekClosed != null) {
                            if (takeFirstReceiveOrPeekClosed instanceof Closed) {
                                this.size = i;
                                if (takeFirstReceiveOrPeekClosed == null) {
                                    Intrinsics.throwNpe();
                                }
                                lock2.unlock();
                                return takeFirstReceiveOrPeekClosed;
                            }
                            if (takeFirstReceiveOrPeekClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e, null);
                        }
                    } while (tryResumeReceive == null);
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        if (!(tryResumeReceive == CancellableContinuationImplKt.RESUME_TOKEN)) {
                            throw new AssertionError();
                        }
                    }
                    this.size = i;
                    Unit unit = Unit.INSTANCE;
                    lock2.unlock();
                    if (takeFirstReceiveOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    takeFirstReceiveOrPeekClosed.completeResumeReceive(e);
                    if (takeFirstReceiveOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    return takeFirstReceiveOrPeekClosed.getOfferResult();
                }
                ensureCapacity(i);
                this.buffer[(this.head + i) % this.buffer.length] = e;
                Object obj = AbstractChannelKt.OFFER_SUCCESS;
                lock2.unlock();
                return obj;
            }
            Object obj2 = AbstractChannelKt.OFFER_FAILED;
            lock2.unlock();
            return obj2;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public Object offerSelectInternal(E e, SelectInstance<?> selectInstance) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (i < this.capacity) {
                this.size = i + 1;
                if (i == 0) {
                    while (true) {
                        AbstractSendChannel.TryOfferDesc describeTryOffer = describeTryOffer(e);
                        Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryOffer);
                        if (performAtomicTrySelect == null) {
                            this.size = i;
                            ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) describeTryOffer.getResult();
                            Unit unit = Unit.INSTANCE;
                            lock2.unlock();
                            if (receiveOrClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            receiveOrClosed.completeResumeReceive(e);
                            if (receiveOrClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            return receiveOrClosed.getOfferResult();
                        } else if (performAtomicTrySelect == AbstractChannelKt.OFFER_FAILED) {
                            break;
                        } else if (performAtomicTrySelect != AtomicKt.RETRY_ATOMIC) {
                            if (performAtomicTrySelect != SelectKt.getALREADY_SELECTED()) {
                                if (!(performAtomicTrySelect instanceof Closed)) {
                                    throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + performAtomicTrySelect).toString());
                                }
                            }
                            this.size = i;
                            lock2.unlock();
                            return performAtomicTrySelect;
                        }
                    }
                }
                if (!selectInstance.trySelect()) {
                    this.size = i;
                    Object already_selected = SelectKt.getALREADY_SELECTED();
                    lock2.unlock();
                    return already_selected;
                }
                ensureCapacity(i);
                this.buffer[(this.head + i) % this.buffer.length] = e;
                Object obj = AbstractChannelKt.OFFER_SUCCESS;
                lock2.unlock();
                return obj;
            }
            Object obj2 = AbstractChannelKt.OFFER_FAILED;
            lock2.unlock();
            return obj2;
        } finally {
            lock2.unlock();
        }
    }

    private final void ensureCapacity(int i) {
        Object[] objArr = this.buffer;
        if (i >= objArr.length) {
            Object[] objArr2 = new Object[Math.min(objArr.length * 2, this.capacity)];
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr3 = this.buffer;
                objArr2[i2] = objArr3[(this.head + i2) % objArr3.length];
            }
            this.buffer = objArr2;
            this.head = 0;
        }
    }

    /* access modifiers changed from: protected */
    public Object pollInternal() {
        Send send = null;
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object obj = this.buffer[this.head];
            this.buffer[this.head] = null;
            this.size = i - 1;
            Object obj2 = AbstractChannelKt.POLL_FAILED;
            boolean z = false;
            if (i == this.capacity) {
                while (true) {
                    Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                    if (takeFirstSendOrPeekClosed == null) {
                        break;
                    }
                    if (takeFirstSendOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    Symbol tryResumeSend = takeFirstSendOrPeekClosed.tryResumeSend(null);
                    if (tryResumeSend != null) {
                        if (DebugKt.getASSERTIONS_ENABLED()) {
                            if (tryResumeSend == CancellableContinuationImplKt.RESUME_TOKEN) {
                                z = true;
                            }
                            if (!z) {
                                throw new AssertionError();
                            }
                        }
                        if (takeFirstSendOrPeekClosed == null) {
                            Intrinsics.throwNpe();
                        }
                        obj2 = takeFirstSendOrPeekClosed.getPollResult();
                        send = takeFirstSendOrPeekClosed;
                        z = true;
                    } else {
                        send = takeFirstSendOrPeekClosed;
                    }
                }
            }
            if (obj2 != AbstractChannelKt.POLL_FAILED && !(obj2 instanceof Closed)) {
                this.size = i;
                this.buffer[(this.head + i) % this.buffer.length] = obj2;
            }
            this.head = (this.head + 1) % this.buffer.length;
            Unit unit = Unit.INSTANCE;
            lock2.unlock();
            if (z) {
                if (send == null) {
                    Intrinsics.throwNpe();
                }
                send.completeResumeSend();
            }
            return obj;
        } finally {
            lock2.unlock();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlinx.coroutines.channels.Send} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: kotlinx.coroutines.channels.Send} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0065, code lost:
        if (r7 != kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0067, code lost:
        r8.size = r3;
        r8.buffer[r8.head] = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006f, code lost:
        r2.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0072, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0075, code lost:
        if ((r7 instanceof kotlinx.coroutines.channels.Closed) == false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0077, code lost:
        r1 = (kotlinx.coroutines.channels.Send) r7;
        r5 = true;
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0099, code lost:
        throw new java.lang.IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + r7).toString());
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b7 A[Catch:{ all -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object pollSelectInternal(kotlinx.coroutines.selects.SelectInstance<?> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "select"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            r0 = 0
            r1 = r0
            kotlinx.coroutines.channels.Send r1 = (kotlinx.coroutines.channels.Send) r1
            java.util.concurrent.locks.ReentrantLock r2 = r8.lock
            java.util.concurrent.locks.Lock r2 = (java.util.concurrent.locks.Lock) r2
            r2.lock()
            int r3 = r8.size     // Catch:{ all -> 0x00e0 }
            if (r3 != 0) goto L_0x0021
            kotlinx.coroutines.channels.Closed r9 = r8.getClosedForSend()     // Catch:{ all -> 0x00e0 }
            if (r9 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            java.lang.Object r9 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00e0 }
        L_0x001d:
            r2.unlock()
            return r9
        L_0x0021:
            java.lang.Object[] r4 = r8.buffer     // Catch:{ all -> 0x00e0 }
            int r5 = r8.head     // Catch:{ all -> 0x00e0 }
            r4 = r4[r5]     // Catch:{ all -> 0x00e0 }
            java.lang.Object[] r5 = r8.buffer     // Catch:{ all -> 0x00e0 }
            int r6 = r8.head     // Catch:{ all -> 0x00e0 }
            r5[r6] = r0     // Catch:{ all -> 0x00e0 }
            int r0 = r3 + -1
            r8.size = r0     // Catch:{ all -> 0x00e0 }
            java.lang.Object r0 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00e0 }
            int r5 = r8.capacity     // Catch:{ all -> 0x00e0 }
            r6 = 1
            if (r3 != r5) goto L_0x009a
        L_0x0038:
            kotlinx.coroutines.channels.AbstractChannel$TryPollDesc r5 = r8.describeTryPoll()     // Catch:{ all -> 0x00e0 }
            r7 = r5
            kotlinx.coroutines.internal.AtomicDesc r7 = (kotlinx.coroutines.internal.AtomicDesc) r7     // Catch:{ all -> 0x00e0 }
            java.lang.Object r7 = r9.performAtomicTrySelect(r7)     // Catch:{ all -> 0x00e0 }
            if (r7 != 0) goto L_0x0057
            java.lang.Object r0 = r5.getResult()     // Catch:{ all -> 0x00e0 }
            r1 = r0
            kotlinx.coroutines.channels.Send r1 = (kotlinx.coroutines.channels.Send) r1     // Catch:{ all -> 0x00e0 }
            if (r1 != 0) goto L_0x0051
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x00e0 }
        L_0x0051:
            java.lang.Object r0 = r1.getPollResult()     // Catch:{ all -> 0x00e0 }
            r5 = r6
            goto L_0x009b
        L_0x0057:
            java.lang.Object r5 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00e0 }
            if (r7 != r5) goto L_0x005c
            goto L_0x009a
        L_0x005c:
            java.lang.Object r5 = kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC     // Catch:{ all -> 0x00e0 }
            if (r7 != r5) goto L_0x0061
            goto L_0x0038
        L_0x0061:
            java.lang.Object r0 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()     // Catch:{ all -> 0x00e0 }
            if (r7 != r0) goto L_0x0073
            r8.size = r3     // Catch:{ all -> 0x00e0 }
            java.lang.Object[] r9 = r8.buffer     // Catch:{ all -> 0x00e0 }
            int r0 = r8.head     // Catch:{ all -> 0x00e0 }
            r9[r0] = r4     // Catch:{ all -> 0x00e0 }
            r2.unlock()
            return r7
        L_0x0073:
            boolean r0 = r7 instanceof kotlinx.coroutines.channels.Closed     // Catch:{ all -> 0x00e0 }
            if (r0 == 0) goto L_0x007d
            r1 = r7
            kotlinx.coroutines.channels.Send r1 = (kotlinx.coroutines.channels.Send) r1     // Catch:{ all -> 0x00e0 }
            r5 = r6
            r0 = r7
            goto L_0x009b
        L_0x007d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r9.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r0 = "performAtomicTrySelect(describeTryOffer) returned "
            r9.append(r0)     // Catch:{ all -> 0x00e0 }
            r9.append(r7)     // Catch:{ all -> 0x00e0 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00e0 }
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00e0 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00e0 }
            r0.<init>(r9)     // Catch:{ all -> 0x00e0 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x00e0 }
            throw r0     // Catch:{ all -> 0x00e0 }
        L_0x009a:
            r5 = 0
        L_0x009b:
            java.lang.Object r7 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00e0 }
            if (r0 == r7) goto L_0x00b1
            boolean r7 = r0 instanceof kotlinx.coroutines.channels.Closed     // Catch:{ all -> 0x00e0 }
            if (r7 != 0) goto L_0x00b1
            r8.size = r3     // Catch:{ all -> 0x00e0 }
            java.lang.Object[] r9 = r8.buffer     // Catch:{ all -> 0x00e0 }
            int r7 = r8.head     // Catch:{ all -> 0x00e0 }
            int r7 = r7 + r3
            java.lang.Object[] r3 = r8.buffer     // Catch:{ all -> 0x00e0 }
            int r3 = r3.length     // Catch:{ all -> 0x00e0 }
            int r7 = r7 % r3
            r9[r7] = r0     // Catch:{ all -> 0x00e0 }
            goto L_0x00c7
        L_0x00b1:
            boolean r9 = r9.trySelect()     // Catch:{ all -> 0x00e0 }
            if (r9 != 0) goto L_0x00c7
            r8.size = r3     // Catch:{ all -> 0x00e0 }
            java.lang.Object[] r9 = r8.buffer     // Catch:{ all -> 0x00e0 }
            int r0 = r8.head     // Catch:{ all -> 0x00e0 }
            r9[r0] = r4     // Catch:{ all -> 0x00e0 }
            java.lang.Object r9 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()     // Catch:{ all -> 0x00e0 }
            r2.unlock()
            return r9
        L_0x00c7:
            int r9 = r8.head     // Catch:{ all -> 0x00e0 }
            int r9 = r9 + r6
            java.lang.Object[] r0 = r8.buffer     // Catch:{ all -> 0x00e0 }
            int r0 = r0.length     // Catch:{ all -> 0x00e0 }
            int r9 = r9 % r0
            r8.head = r9     // Catch:{ all -> 0x00e0 }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e0 }
            r2.unlock()
            if (r5 == 0) goto L_0x00df
            if (r1 != 0) goto L_0x00dc
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00dc:
            r1.completeResumeSend()
        L_0x00df:
            return r4
        L_0x00e0:
            r9 = move-exception
            r2.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayChannel.pollSelectInternal(kotlinx.coroutines.selects.SelectInstance):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public void onCancelIdempotent(boolean z) {
        if (z) {
            Lock lock2 = this.lock;
            lock2.lock();
            try {
                int i = this.size;
                for (int i2 = 0; i2 < i; i2++) {
                    this.buffer[this.head] = 0;
                    this.head = (this.head + 1) % this.buffer.length;
                }
                this.size = 0;
                Unit unit = Unit.INSTANCE;
            } finally {
                lock2.unlock();
            }
        }
        super.onCancelIdempotent(z);
    }

    /* access modifiers changed from: protected */
    public String getBufferDebugString() {
        return "(buffer:capacity=" + this.capacity + ",size=" + this.size + ')';
    }
}
