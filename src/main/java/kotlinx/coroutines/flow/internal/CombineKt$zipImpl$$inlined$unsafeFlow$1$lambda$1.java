package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: Combine.kt */
final class CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector $this_unsafeFlow;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, Continuation continuation, CombineKt$zipImpl$$inlined$unsafeFlow$1 combineKt$zipImpl$$inlined$unsafeFlow$1) {
        super(2, continuation);
        this.$this_unsafeFlow = flowCollector;
        this.this$0 = combineKt$zipImpl$$inlined$unsafeFlow$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = new CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(this.$this_unsafeFlow, continuation, this.this$0);
        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.p$ = (CoroutineScope) obj;
        return combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v21, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v23, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x029a, code lost:
        r0 = new kotlinx.coroutines.flow.internal.AbortFlowException(r12.$this_unsafeFlow);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0280, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0281, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r10, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0285, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0286, code lost:
        r0 = e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:78:0x025d, B:89:0x027f] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0186 A[Catch:{ all -> 0x0273 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01d0 A[Catch:{ all -> 0x0257 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01d3 A[Catch:{ all -> 0x0257 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01df A[Catch:{ all -> 0x0257 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0266  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r1 = r21
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x011d
            if (r2 == r6) goto L_0x00d7
            if (r2 == r5) goto L_0x0099
            if (r2 == r4) goto L_0x0050
            if (r2 != r3) goto L_0x0048
            java.lang.Object r2 = r1.L$9
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r8 = r1.L$8
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r9 = r1.L$7
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            java.lang.Object r10 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r11 = r1.L$5
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r11 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) r11
            java.lang.Object r12 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r12 = (kotlinx.coroutines.channels.ReceiveChannel) r12
            java.lang.Object r13 = r1.L$3
            kotlinx.coroutines.channels.ChannelIterator r13 = (kotlinx.coroutines.channels.ChannelIterator) r13
            java.lang.Object r14 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r14 = (kotlinx.coroutines.channels.ReceiveChannel) r14
            java.lang.Object r15 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r15 = (kotlinx.coroutines.channels.ReceiveChannel) r15
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x0118 }
            r6 = r14
            r5 = 4
            r14 = r12
            r12 = r1
            goto L_0x0241
        L_0x0048:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0050:
            java.lang.Object r2 = r1.L$12
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r3 = r1.L$11
            java.lang.Object r8 = r1.L$10
            java.lang.Object r9 = r1.L$9
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r10 = r1.L$8
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r11 = r1.L$7
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            java.lang.Object r12 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r12 = (kotlinx.coroutines.channels.ReceiveChannel) r12
            java.lang.Object r13 = r1.L$5
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r13 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) r13
            java.lang.Object r14 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r14 = (kotlinx.coroutines.channels.ReceiveChannel) r14
            java.lang.Object r15 = r1.L$3
            kotlinx.coroutines.channels.ChannelIterator r15 = (kotlinx.coroutines.channels.ChannelIterator) r15
            java.lang.Object r4 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r5 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r1.L$0
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x0094 }
            r7 = r5
            r5 = r3
            r3 = r6
            r6 = r4
            r4 = r9
            r9 = r11
            r11 = r13
            r13 = r15
            r15 = r8
            r8 = r10
            r10 = r12
            r12 = r1
            r1 = r0
            r0 = r22
            goto L_0x021c
        L_0x0094:
            r0 = move-exception
            r14 = r4
            r10 = r12
            goto L_0x0119
        L_0x0099:
            java.lang.Object r2 = r1.L$11
            java.lang.Object r3 = r1.L$10
            java.lang.Object r4 = r1.L$9
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r1.L$8
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r1.L$7
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.Object r8 = r1.L$6
            r10 = r8
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r8 = r1.L$5
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r8 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) r8
            java.lang.Object r9 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r11 = r1.L$3
            kotlinx.coroutines.channels.ChannelIterator r11 = (kotlinx.coroutines.channels.ChannelIterator) r11
            java.lang.Object r12 = r1.L$2
            r14 = r12
            kotlinx.coroutines.channels.ReceiveChannel r14 = (kotlinx.coroutines.channels.ReceiveChannel) r14
            java.lang.Object r12 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r12 = (kotlinx.coroutines.channels.ReceiveChannel) r12
            java.lang.Object r13 = r1.L$0
            kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x0118 }
            r7 = r22
            r15 = r3
            r3 = r2
            r2 = r12
            r12 = r1
            r19 = r14
            r14 = r13
            r13 = r19
            goto L_0x01af
        L_0x00d7:
            java.lang.Object r2 = r1.L$9
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r3 = r1.L$8
            kotlinx.coroutines.channels.ReceiveChannel r3 = (kotlinx.coroutines.channels.ReceiveChannel) r3
            java.lang.Object r4 = r1.L$7
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.Object r5 = r1.L$6
            r10 = r5
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r5 = r1.L$5
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r5 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) r5
            java.lang.Object r6 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r8 = r1.L$3
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r1.L$2
            r14 = r9
            kotlinx.coroutines.channels.ReceiveChannel r14 = (kotlinx.coroutines.channels.ReceiveChannel) r14
            java.lang.Object r9 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r11 = r1.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x0118 }
            r15 = r22
            r12 = r1
            r13 = 1
            r19 = r4
            r4 = r2
            r2 = r9
            r9 = r6
            r6 = r19
            r20 = r5
            r5 = r3
            r3 = r11
            r11 = r8
            r8 = r20
            goto L_0x017e
        L_0x0118:
            r0 = move-exception
        L_0x0119:
            r12 = r1
        L_0x011a:
            r1 = r0
            goto L_0x027f
        L_0x011d:
            kotlin.ResultKt.throwOnFailure(r22)
            kotlinx.coroutines.CoroutineScope r2 = r1.p$
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1 r3 = r1.this$0
            kotlinx.coroutines.flow.Flow r3 = r3.$flow$inlined
            kotlinx.coroutines.channels.ReceiveChannel r10 = kotlinx.coroutines.flow.internal.CombineKt.asChannel(r2, r3)
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1 r3 = r1.this$0
            kotlinx.coroutines.flow.Flow r3 = r3.$flow2$inlined
            kotlinx.coroutines.channels.ReceiveChannel r14 = kotlinx.coroutines.flow.internal.CombineKt.asChannel(r2, r3)
            if (r14 == 0) goto L_0x02b9
            r3 = r14
            kotlinx.coroutines.channels.SendChannel r3 = (kotlinx.coroutines.channels.SendChannel) r3
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1 r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1
            r4.<init>(r1, r10)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r3.invokeOnClose(r4)
            kotlinx.coroutines.channels.ChannelIterator r3 = r14.iterator()
            r4 = r7
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ AbortFlowException -> 0x028c, all -> 0x0288 }
            kotlinx.coroutines.channels.ChannelIterator r5 = r10.iterator()     // Catch:{ all -> 0x027a }
            r11 = r1
            r12 = r11
            r6 = r10
            r8 = r6
            r9 = r8
        L_0x0151:
            r12.L$0 = r2     // Catch:{ all -> 0x0276 }
            r12.L$1 = r10     // Catch:{ all -> 0x0276 }
            r12.L$2 = r14     // Catch:{ all -> 0x0276 }
            r12.L$3 = r3     // Catch:{ all -> 0x0276 }
            r12.L$4 = r6     // Catch:{ all -> 0x0276 }
            r12.L$5 = r11     // Catch:{ all -> 0x0276 }
            r12.L$6 = r8     // Catch:{ all -> 0x0276 }
            r12.L$7 = r4     // Catch:{ all -> 0x0276 }
            r12.L$8 = r9     // Catch:{ all -> 0x0276 }
            r12.L$9 = r5     // Catch:{ all -> 0x0276 }
            r13 = 1
            r12.label = r13     // Catch:{ all -> 0x0276 }
            java.lang.Object r15 = r5.hasNext(r11)     // Catch:{ all -> 0x0276 }
            if (r15 != r0) goto L_0x016f
            return r0
        L_0x016f:
            r19 = r3
            r3 = r2
            r2 = r10
            r10 = r8
            r8 = r11
            r11 = r19
            r20 = r6
            r6 = r4
            r4 = r5
            r5 = r9
            r9 = r20
        L_0x017e:
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ all -> 0x0273 }
            boolean r15 = r15.booleanValue()     // Catch:{ all -> 0x0273 }
            if (r15 == 0) goto L_0x025b
            java.lang.Object r15 = r4.next()     // Catch:{ all -> 0x0273 }
            r12.L$0 = r3     // Catch:{ all -> 0x0273 }
            r12.L$1 = r2     // Catch:{ all -> 0x0273 }
            r12.L$2 = r14     // Catch:{ all -> 0x0273 }
            r12.L$3 = r11     // Catch:{ all -> 0x0273 }
            r12.L$4 = r9     // Catch:{ all -> 0x0273 }
            r12.L$5 = r8     // Catch:{ all -> 0x0273 }
            r12.L$6 = r10     // Catch:{ all -> 0x0273 }
            r12.L$7 = r6     // Catch:{ all -> 0x0273 }
            r12.L$8 = r5     // Catch:{ all -> 0x0273 }
            r12.L$9 = r4     // Catch:{ all -> 0x0273 }
            r12.L$10 = r15     // Catch:{ all -> 0x0273 }
            r12.L$11 = r15     // Catch:{ all -> 0x0273 }
            r7 = 2
            r12.label = r7     // Catch:{ all -> 0x0273 }
            java.lang.Object r7 = r11.hasNext(r12)     // Catch:{ all -> 0x0273 }
            if (r7 != r0) goto L_0x01ac
            return r0
        L_0x01ac:
            r13 = r14
            r14 = r3
            r3 = r15
        L_0x01af:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0257 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0257 }
            if (r7 != 0) goto L_0x01c4
            r1 = r4
            r4 = r6
            r6 = r9
            r3 = r11
            r9 = r5
            r11 = r8
            r8 = r10
            r5 = 4
            r10 = r2
            r2 = r14
            r14 = r13
            goto L_0x024d
        L_0x01c4:
            kotlinx.coroutines.flow.FlowCollector r7 = r12.$this_unsafeFlow     // Catch:{ all -> 0x0257 }
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1 r1 = r12.this$0     // Catch:{ all -> 0x0257 }
            kotlin.jvm.functions.Function3 r1 = r1.$transform$inlined     // Catch:{ all -> 0x0257 }
            r16 = r0
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL     // Catch:{ all -> 0x0257 }
            if (r3 != r0) goto L_0x01d3
            r17 = 0
            goto L_0x01d5
        L_0x01d3:
            r17 = r3
        L_0x01d5:
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL     // Catch:{ all -> 0x0257 }
            r18 = r1
            java.lang.Object r1 = r11.next()     // Catch:{ all -> 0x0257 }
            if (r1 != r0) goto L_0x01e0
            r1 = 0
        L_0x01e0:
            r12.L$0 = r14     // Catch:{ all -> 0x0257 }
            r12.L$1 = r2     // Catch:{ all -> 0x0257 }
            r12.L$2 = r13     // Catch:{ all -> 0x0257 }
            r12.L$3 = r11     // Catch:{ all -> 0x0257 }
            r12.L$4 = r9     // Catch:{ all -> 0x0257 }
            r12.L$5 = r8     // Catch:{ all -> 0x0257 }
            r12.L$6 = r10     // Catch:{ all -> 0x0257 }
            r12.L$7 = r6     // Catch:{ all -> 0x0257 }
            r12.L$8 = r5     // Catch:{ all -> 0x0257 }
            r12.L$9 = r4     // Catch:{ all -> 0x0257 }
            r12.L$10 = r15     // Catch:{ all -> 0x0257 }
            r12.L$11 = r3     // Catch:{ all -> 0x0257 }
            r12.L$12 = r7     // Catch:{ all -> 0x0257 }
            r0 = 3
            r12.label = r0     // Catch:{ all -> 0x0257 }
            r0 = r18
            r19 = r17
            r17 = r2
            r2 = r19
            java.lang.Object r0 = r0.invoke(r2, r1, r12)     // Catch:{ all -> 0x0257 }
            r1 = r16
            if (r0 != r1) goto L_0x020e
            return r1
        L_0x020e:
            r2 = r7
            r7 = r17
            r19 = r5
            r5 = r3
            r3 = r14
            r14 = r9
            r9 = r6
            r6 = r13
            r13 = r11
            r11 = r8
            r8 = r19
        L_0x021c:
            r12.L$0 = r3     // Catch:{ all -> 0x0253 }
            r12.L$1 = r7     // Catch:{ all -> 0x0253 }
            r12.L$2 = r6     // Catch:{ all -> 0x0253 }
            r12.L$3 = r13     // Catch:{ all -> 0x0253 }
            r12.L$4 = r14     // Catch:{ all -> 0x0253 }
            r12.L$5 = r11     // Catch:{ all -> 0x0253 }
            r12.L$6 = r10     // Catch:{ all -> 0x0253 }
            r12.L$7 = r9     // Catch:{ all -> 0x0253 }
            r12.L$8 = r8     // Catch:{ all -> 0x0253 }
            r12.L$9 = r4     // Catch:{ all -> 0x0253 }
            r12.L$10 = r15     // Catch:{ all -> 0x0253 }
            r12.L$11 = r5     // Catch:{ all -> 0x0253 }
            r5 = 4
            r12.label = r5     // Catch:{ all -> 0x0253 }
            java.lang.Object r0 = r2.emit(r0, r12)     // Catch:{ all -> 0x0253 }
            if (r0 != r1) goto L_0x023e
            return r1
        L_0x023e:
            r0 = r1
            r2 = r4
            r15 = r7
        L_0x0241:
            r1 = r2
            r2 = r3
            r4 = r9
            r3 = r13
            r9 = r8
            r8 = r10
            r10 = r15
            r19 = r14
            r14 = r6
            r6 = r19
        L_0x024d:
            r7 = 0
            r5 = r1
            r1 = r21
            goto L_0x0151
        L_0x0253:
            r0 = move-exception
            r1 = r0
            r14 = r6
            goto L_0x027f
        L_0x0257:
            r0 = move-exception
            r1 = r0
            r14 = r13
            goto L_0x027f
        L_0x025b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0273 }
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r10, r6)     // Catch:{ AbortFlowException -> 0x0286 }
            boolean r0 = r14.isClosedForReceive()
            if (r0 != 0) goto L_0x02a2
            kotlinx.coroutines.flow.internal.AbortFlowException r0 = new kotlinx.coroutines.flow.internal.AbortFlowException
            kotlinx.coroutines.flow.FlowCollector r1 = r12.$this_unsafeFlow
            r0.<init>(r1)
        L_0x026d:
            java.util.concurrent.CancellationException r0 = (java.util.concurrent.CancellationException) r0
            r14.cancel(r0)
            goto L_0x02a2
        L_0x0273:
            r0 = move-exception
            goto L_0x011a
        L_0x0276:
            r0 = move-exception
            r1 = r0
            r10 = r8
            goto L_0x027f
        L_0x027a:
            r0 = move-exception
            r12 = r21
            goto L_0x011a
        L_0x027f:
            throw r1     // Catch:{ all -> 0x0280 }
        L_0x0280:
            r0 = move-exception
            r2 = r0
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r10, r1)     // Catch:{ AbortFlowException -> 0x0286 }
            throw r2     // Catch:{ AbortFlowException -> 0x0286 }
        L_0x0286:
            r0 = move-exception
            goto L_0x028f
        L_0x0288:
            r0 = move-exception
            r12 = r21
            goto L_0x02a6
        L_0x028c:
            r0 = move-exception
            r12 = r21
        L_0x028f:
            kotlinx.coroutines.flow.FlowCollector r1 = r12.$this_unsafeFlow     // Catch:{ all -> 0x02a5 }
            kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(r0, r1)     // Catch:{ all -> 0x02a5 }
            boolean r0 = r14.isClosedForReceive()
            if (r0 != 0) goto L_0x02a2
            kotlinx.coroutines.flow.internal.AbortFlowException r0 = new kotlinx.coroutines.flow.internal.AbortFlowException
            kotlinx.coroutines.flow.FlowCollector r1 = r12.$this_unsafeFlow
            r0.<init>(r1)
            goto L_0x026d
        L_0x02a2:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x02a5:
            r0 = move-exception
        L_0x02a6:
            boolean r1 = r14.isClosedForReceive()
            if (r1 != 0) goto L_0x02b8
            kotlinx.coroutines.flow.internal.AbortFlowException r1 = new kotlinx.coroutines.flow.internal.AbortFlowException
            kotlinx.coroutines.flow.FlowCollector r2 = r12.$this_unsafeFlow
            r1.<init>(r2)
            java.util.concurrent.CancellationException r1 = (java.util.concurrent.CancellationException) r1
            r14.cancel(r1)
        L_0x02b8:
            throw r0
        L_0x02b9:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
