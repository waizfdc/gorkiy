package com.askgps.personaltrackercore.utils;

import android.content.Context;
import com.askgps.personaltrackercore.repository.Repository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;
import org.koin.core.qualifier.QualifierKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u001c\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/askgps/personaltrackercore/utils/PeriodicJob;", "Lorg/koin/core/KoinComponent;", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;)V", "btUtils", "Lcom/askgps/personaltrackercore/utils/BluetoothUtils;", "getBtUtils", "()Lcom/askgps/personaltrackercore/utils/BluetoothUtils;", "btUtils$delegate", "Lkotlin/Lazy;", "lhUtils", "Lcom/askgps/personaltrackercore/utils/RemovalFromHandUtils;", "getLhUtils", "()Lcom/askgps/personaltrackercore/utils/RemovalFromHandUtils;", "lhUtils$delegate", "repo", "Lcom/askgps/personaltrackercore/repository/Repository;", "getRepo", "()Lcom/askgps/personaltrackercore/repository/Repository;", "repo$delegate", "wifiUtils", "Lcom/askgps/personaltrackercore/utils/WifiUtils;", "getWifiUtils", "()Lcom/askgps/personaltrackercore/utils/WifiUtils;", "wifiUtils$delegate", "getData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PeriodicJob.kt */
public final class PeriodicJob implements KoinComponent {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);
    public static final long SCAN_PERIOD = 180000;
    private final Lazy btUtils$delegate = LazyKt.lazy(new PeriodicJob$btUtils$2(this));
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy lhUtils$delegate;
    private final Lazy repo$delegate;
    /* access modifiers changed from: private */
    public final CoroutineScope scope;
    private final Lazy wifiUtils$delegate = LazyKt.lazy(new PeriodicJob$wifiUtils$2(this));

    static {
        Class<PeriodicJob> cls = PeriodicJob.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "wifiUtils", "getWifiUtils()Lcom/askgps/personaltrackercore/utils/WifiUtils;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "btUtils", "getBtUtils()Lcom/askgps/personaltrackercore/utils/BluetoothUtils;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "lhUtils", "getLhUtils()Lcom/askgps/personaltrackercore/utils/RemovalFromHandUtils;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "repo", "getRepo()Lcom/askgps/personaltrackercore/repository/Repository;"))};
    }

    private final BluetoothUtils getBtUtils() {
        Lazy lazy = this.btUtils$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (BluetoothUtils) lazy.getValue();
    }

    private final RemovalFromHandUtils getLhUtils() {
        Lazy lazy = this.lhUtils$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (RemovalFromHandUtils) lazy.getValue();
    }

    private final Repository getRepo() {
        Lazy lazy = this.repo$delegate;
        KProperty kProperty = $$delegatedProperties[3];
        return (Repository) lazy.getValue();
    }

    private final WifiUtils getWifiUtils() {
        Lazy lazy = this.wifiUtils$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (WifiUtils) lazy.getValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, com.askgps.personaltrackercore.utils.PeriodicJob$$special$$inlined$inject$1]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, com.askgps.personaltrackercore.utils.PeriodicJob$$special$$inlined$inject$2]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public PeriodicJob(Context context2, CoroutineScope coroutineScope) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(coroutineScope, "scope");
        this.context = context2;
        this.scope = coroutineScope;
        Function0 function0 = null;
        this.lhUtils$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new PeriodicJob$$special$$inlined$inject$1(this, QualifierKt.named("RemovalFromHandUtils"), function0));
        this.repo$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new PeriodicJob$$special$$inlined$inject$2(this, null, function0));
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/askgps/personaltrackercore/utils/PeriodicJob$Companion;", "", "()V", "SCAN_PERIOD", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PeriodicJob.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getData(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.askgps.personaltrackercore.utils.PeriodicJob$getData$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.askgps.personaltrackercore.utils.PeriodicJob$getData$1 r0 = (com.askgps.personaltrackercore.utils.PeriodicJob$getData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.askgps.personaltrackercore.utils.PeriodicJob$getData$1 r0 = new com.askgps.personaltrackercore.utils.PeriodicJob$getData$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r1 = r0.L$2
            com.askgps.personaltrackercore.repository.Repository r1 = (com.askgps.personaltrackercore.repository.Repository) r1
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.Deferred r2 = (kotlinx.coroutines.Deferred) r2
            java.lang.Object r0 = r0.L$0
            com.askgps.personaltrackercore.utils.PeriodicJob r0 = (com.askgps.personaltrackercore.utils.PeriodicJob) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0060
        L_0x0036:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.askgps.personaltrackercore.utils.RemovalFromHandUtils r7 = r6.getLhUtils()
            r4 = 180000(0x2bf20, double:8.8932E-319)
            kotlinx.coroutines.Deferred r7 = r7.periodicResultAsync(r4)
            com.askgps.personaltrackercore.repository.Repository r2 = r6.getRepo()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r7 = r7.await(r0)
            if (r7 != r1) goto L_0x005f
            return r1
        L_0x005f:
            r1 = r2
        L_0x0060:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
            java.util.Set r2 = kotlin.collections.SetsKt.emptySet()
            com.askgps.personaltrackercore.database.model.IndoorNavigation r3 = new com.askgps.personaltrackercore.database.model.IndoorNavigation
            r3.<init>(r0, r2)
            r1.processingLeaveHandMessage(r7, r3)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.askgps.personaltrackercore.utils.PeriodicJob.getData(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
