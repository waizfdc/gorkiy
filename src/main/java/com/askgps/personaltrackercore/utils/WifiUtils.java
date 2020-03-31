package com.askgps.personaltrackercore.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.repository.Repository;
import com.google.android.gms.location.LocationResult;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001.\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u00100\u001a\u0004\u0018\u000101J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000203H\u0016J\b\u00105\u001a\u000203H\u0016J\b\u00106\u001a\u000203H\u0016J\u001f\u00107\u001a\u0002032\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09H@ø\u0001\u0000¢\u0006\u0002\u0010;J\u0011\u0010<\u001a\u000203H@ø\u0001\u0000¢\u0006\u0002\u0010=J\b\u0010>\u001a\u000203H\u0002J\b\u0010?\u001a\u000203H\u0002J\b\u0010@\u001a\u000203H\u0002J\u0006\u0010A\u001a\u000203J\u0018\u0010A\u001a\u0002032\b\u0010B\u001a\u0004\u0018\u00010\u001b2\u0006\u0010C\u001a\u00020&R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0019\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0004¢\u0006\u0004\n\u0002\u0010/\u0002\u0004\n\u0002\b\u0019¨\u0006E"}, d2 = {"Lcom/askgps/personaltrackercore/utils/WifiUtils;", "Lcom/askgps/personaltrackercore/utils/Utils;", "Lorg/koin/core/KoinComponent;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attemptCount", "", "getAttemptCount", "()I", "getContext", "()Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setCount", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter", "()Landroid/content/IntentFilter;", "intentFilter$delegate", "Lkotlin/Lazy;", "locationResult", "Lcom/google/android/gms/location/LocationResult;", "getLocationResult", "()Lcom/google/android/gms/location/LocationResult;", "setLocationResult", "(Lcom/google/android/gms/location/LocationResult;)V", "repo", "Lcom/askgps/personaltrackercore/repository/Repository;", "getRepo", "()Lcom/askgps/personaltrackercore/repository/Repository;", "repo$delegate", "toSend", "", "getToSend", "()Z", "setToSend", "(Z)V", "wifiManager", "Landroid/net/wifi/WifiManager;", "wifiScanReceiver", "com/askgps/personaltrackercore/utils/WifiUtils$wifiScanReceiver$1", "Lcom/askgps/personaltrackercore/utils/WifiUtils$wifiScanReceiver$1;", "getMacAddr", "", "onCreate", "", "onDestroy", "onPause", "onResume", "processWifi", "wifi", "", "Lcom/askgps/personaltrackercore/database/model/IndoorDevice;", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "repeatScan", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanEnd", "scanFailure", "scanSuccess", "wifiScan", "locResult", "isSending", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: WifiUtils.kt */
public final class WifiUtils extends Utils implements KoinComponent {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "app_wifi";
    private final int attemptCount = 3;
    private final Context context;
    private final CoroutineScope coroutineScope;
    private AtomicInteger count = new AtomicInteger(0);
    private final Lazy intentFilter$delegate;
    public volatile LocationResult locationResult;
    private final Lazy repo$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new WifiUtils$$special$$inlined$inject$1(this, null, null));
    private volatile boolean toSend;
    private final WifiManager wifiManager;
    private final WifiUtils$wifiScanReceiver$1 wifiScanReceiver;

    static {
        Class<WifiUtils> cls = WifiUtils.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "repo", "getRepo()Lcom/askgps/personaltrackercore/repository/Repository;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "intentFilter", "getIntentFilter()Landroid/content/IntentFilter;"))};
    }

    private final IntentFilter getIntentFilter() {
        Lazy lazy = this.intentFilter$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (IntentFilter) lazy.getValue();
    }

    /* access modifiers changed from: private */
    public final Repository getRepo() {
        Lazy lazy = this.repo$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Repository) lazy.getValue();
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public Context getContext() {
        return this.context;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, com.askgps.personaltrackercore.utils.WifiUtils$$special$$inlined$inject$1]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public WifiUtils(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        Object systemService = getContext().getApplicationContext().getSystemService("wifi");
        if (systemService != null) {
            this.wifiManager = (WifiManager) systemService;
            this.wifiScanReceiver = new WifiUtils$wifiScanReceiver$1(this);
            this.intentFilter$delegate = LazyKt.lazy(WifiUtils$intentFilter$2.INSTANCE);
            this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.wifi.WifiManager");
    }

    public final int getAttemptCount() {
        return this.attemptCount;
    }

    public final AtomicInteger getCount() {
        return this.count;
    }

    public final void setCount(AtomicInteger atomicInteger) {
        Intrinsics.checkParameterIsNotNull(atomicInteger, "<set-?>");
        this.count = atomicInteger;
    }

    public final boolean getToSend() {
        return this.toSend;
    }

    public final void setToSend(boolean z) {
        this.toSend = z;
    }

    public final LocationResult getLocationResult() {
        LocationResult locationResult2 = this.locationResult;
        if (locationResult2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationResult");
        }
        return locationResult2;
    }

    public final void setLocationResult(LocationResult locationResult2) {
        Intrinsics.checkParameterIsNotNull(locationResult2, "<set-?>");
        this.locationResult = locationResult2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/askgps/personaltrackercore/utils/WifiUtils$Companion;", "", "()V", "TAG", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: WifiUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void wifiScan() {
        wifiScan(null, true);
    }

    public final void wifiScan(LocationResult locationResult2, boolean z) {
        this.toSend = z;
        if (locationResult2 != null) {
            this.locationResult = locationResult2;
        }
        getContext().getApplicationContext().registerReceiver(this.wifiScanReceiver, getIntentFilter());
        this.wifiManager.startScan();
    }

    /* access modifiers changed from: private */
    public final void scanEnd() {
        getContext().getApplicationContext().unregisterReceiver(this.wifiScanReceiver);
    }

    /* access modifiers changed from: private */
    public final void scanSuccess() {
        List<ScanResult> scanResults = this.wifiManager.getScanResults();
        Intrinsics.checkExpressionValueIsNotNull(scanResults, "wifiManager.scanResults");
        Set set = SequencesKt.toSet(SequencesKt.map(CollectionsKt.asSequence(scanResults), WifiUtils$scanSuccess$wifi$1.INSTANCE));
        LogKt.toFile$default(Integer.valueOf(set.size()), "OnReceive - WIFI count", null, TAG, 2, null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getIO(), null, new WifiUtils$scanSuccess$1(this, set, null), 2, null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object processWifi(java.util.Set<com.askgps.personaltrackercore.database.model.IndoorDevice> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.askgps.personaltrackercore.utils.WifiUtils$processWifi$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.askgps.personaltrackercore.utils.WifiUtils$processWifi$1 r0 = (com.askgps.personaltrackercore.utils.WifiUtils$processWifi$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.askgps.personaltrackercore.utils.WifiUtils$processWifi$1 r0 = new com.askgps.personaltrackercore.utils.WifiUtils$processWifi$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r5 = r0.L$1
            java.util.Set r5 = (java.util.Set) r5
            java.lang.Object r5 = r0.L$0
            com.askgps.personaltrackercore.utils.WifiUtils r5 = (com.askgps.personaltrackercore.utils.WifiUtils) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x00cf
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L_0x0051
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r5 = r4.repeatScan(r0)
            if (r5 != r1) goto L_0x00cf
            return r1
        L_0x0051:
            android.content.Context r6 = r4.getContext()
            byte r6 = com.askgps.personaltrackercore.extension.ContextExtensionKt.getBatteryLevel(r6)
            r0 = r4
            com.askgps.personaltrackercore.utils.WifiUtils r0 = (com.askgps.personaltrackercore.utils.WifiUtils) r0
            com.google.android.gms.location.LocationResult r0 = r0.locationResult
            if (r0 != 0) goto L_0x0078
            com.askgps.personaltrackercore.repository.Repository r0 = r4.getRepo()
            java.util.Set r1 = kotlin.collections.SetsKt.emptySet()
            com.askgps.personaltrackercore.database.model.IndoorNavigation r2 = new com.askgps.personaltrackercore.database.model.IndoorNavigation
            r2.<init>(r1, r5)
            com.askgps.personaltrackercore.utils.WifiUtils$processWifi$3 r1 = new com.askgps.personaltrackercore.utils.WifiUtils$processWifi$3
            r1.<init>(r4, r5)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r0.requestLocation(r6, r2, r1)
            goto L_0x00cf
        L_0x0078:
            boolean r0 = r4.toSend
            java.lang.String r1 = "locationResult"
            java.lang.String r2 = "locationResult.locations"
            if (r0 != 0) goto L_0x00a6
            com.askgps.personaltrackercore.repository.Repository r0 = r4.getRepo()
            com.google.android.gms.location.LocationResult r3 = r4.locationResult
            if (r3 != 0) goto L_0x008b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x008b:
            java.util.List r1 = r3.getLocations()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            java.util.Set r2 = kotlin.collections.SetsKt.emptySet()
            com.askgps.personaltrackercore.database.model.IndoorNavigation r3 = new com.askgps.personaltrackercore.database.model.IndoorNavigation
            r3.<init>(r2, r5)
            com.askgps.personaltrackercore.utils.WifiUtils$processWifi$4 r2 = new com.askgps.personaltrackercore.utils.WifiUtils$processWifi$4
            r2.<init>(r4, r5)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r0.saveLocationAsync(r1, r6, r3, r2)
            goto L_0x00cf
        L_0x00a6:
            boolean r0 = r4.toSend
            if (r0 == 0) goto L_0x00cf
            com.askgps.personaltrackercore.repository.Repository r0 = r4.getRepo()
            com.google.android.gms.location.LocationResult r3 = r4.locationResult
            if (r3 != 0) goto L_0x00b5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x00b5:
            java.util.List r1 = r3.getLocations()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            java.util.Set r2 = kotlin.collections.SetsKt.emptySet()
            com.askgps.personaltrackercore.database.model.IndoorNavigation r3 = new com.askgps.personaltrackercore.database.model.IndoorNavigation
            r3.<init>(r2, r5)
            com.askgps.personaltrackercore.utils.WifiUtils$processWifi$5 r2 = new com.askgps.personaltrackercore.utils.WifiUtils$processWifi$5
            r2.<init>(r4, r5)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r0.sendLocationAsync(r1, r6, r3, r2)
        L_0x00cf:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.askgps.personaltrackercore.utils.WifiUtils.processWifi(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void scanFailure() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getIO(), null, new WifiUtils$scanFailure$1(this, null), 2, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object repeatScan(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.askgps.personaltrackercore.utils.WifiUtils$repeatScan$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.askgps.personaltrackercore.utils.WifiUtils$repeatScan$1 r0 = (com.askgps.personaltrackercore.utils.WifiUtils$repeatScan$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.askgps.personaltrackercore.utils.WifiUtils$repeatScan$1 r0 = new com.askgps.personaltrackercore.utils.WifiUtils$repeatScan$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            com.askgps.personaltrackercore.utils.WifiUtils r0 = (com.askgps.personaltrackercore.utils.WifiUtils) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0057
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.concurrent.atomic.AtomicInteger r7 = r6.count
            int r7 = r7.get()
            int r2 = r6.attemptCount
            if (r7 >= r2) goto L_0x0070
            java.util.concurrent.atomic.AtomicInteger r7 = r6.count
            r7.incrementAndGet()
            r4 = 45000(0xafc8, double:2.2233E-319)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r0)
            if (r7 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r0 = r6
        L_0x0057:
            r7 = r0
            com.askgps.personaltrackercore.utils.WifiUtils r7 = (com.askgps.personaltrackercore.utils.WifiUtils) r7
            com.google.android.gms.location.LocationResult r7 = r7.locationResult
            if (r7 == 0) goto L_0x006d
            com.google.android.gms.location.LocationResult r7 = r0.locationResult
            if (r7 != 0) goto L_0x0067
            java.lang.String r1 = "locationResult"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0067:
            boolean r1 = r0.toSend
            r0.wifiScan(r7, r1)
            goto L_0x0070
        L_0x006d:
            r0.wifiScan()
        L_0x0070:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.askgps.personaltrackercore.utils.WifiUtils.repeatScan(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getMacAddr() {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            Intrinsics.checkExpressionValueIsNotNull(list, "Collections.list(Network…e.getNetworkInterfaces())");
            for (NetworkInterface networkInterface : list) {
                if (StringsKt.equals(networkInterface.getName(), "wlan0", true)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte valueOf : hardwareAddress) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("%02X:", Arrays.copyOf(new Object[]{Byte.valueOf(valueOf)}, 1));
                        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                        sb.append(format);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception unused) {
            return "02:00:00:00:00:00";
        }
    }
}
