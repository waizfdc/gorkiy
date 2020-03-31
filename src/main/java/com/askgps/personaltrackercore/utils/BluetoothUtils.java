package com.askgps.personaltrackercore.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.Context;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.database.model.IndoorDevice;
import java.util.LinkedHashSet;
import java.util.Set;
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
import kotlinx.coroutines.Deferred;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0013\u0018\u0000 \"2\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002:\u0001\"B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00160\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/askgps/personaltrackercore/utils/BluetoothUtils;", "Lcom/askgps/personaltrackercore/utils/Utils;", "Lcom/askgps/personaltrackercore/utils/Periodic;", "", "Lcom/askgps/personaltrackercore/database/model/IndoorDevice;", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;)V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "bluetoothAdapter$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "scanCallback", "com/askgps/personaltrackercore/utils/BluetoothUtils$scanCallback$1", "Lcom/askgps/personaltrackercore/utils/BluetoothUtils$scanCallback$1;", "scanDevices", "", "onCreate", "", "onDestroy", "onPause", "onResume", "periodicResultAsync", "Lkotlinx/coroutines/Deferred;", "period", "", "scanLeDevice", "stopScanLeDevice", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BluetoothUtils.kt */
public final class BluetoothUtils extends Utils implements Periodic<Set<? extends IndoorDevice>> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(BluetoothUtils.class), "bluetoothAdapter", "getBluetoothAdapter()Landroid/bluetooth/BluetoothAdapter;"))};
    public static final Companion Companion = new Companion(null);
    private static final long SCAN_PERIOD = 10000;
    private static final String TAG = "app_bt";
    private final Lazy bluetoothAdapter$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new BluetoothUtils$bluetoothAdapter$2(this));
    private final Context context;
    private final BluetoothUtils$scanCallback$1 scanCallback = new BluetoothUtils$scanCallback$1(this);
    /* access modifiers changed from: private */
    public final Set<IndoorDevice> scanDevices = new LinkedHashSet();
    private final CoroutineScope scope;

    private final BluetoothAdapter getBluetoothAdapter() {
        Lazy lazy = this.bluetoothAdapter$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (BluetoothAdapter) lazy.getValue();
    }

    public void onDestroy() {
    }

    public Context getContext() {
        return this.context;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, com.askgps.personaltrackercore.utils.BluetoothUtils$bluetoothAdapter$2]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public BluetoothUtils(Context context2, CoroutineScope coroutineScope) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(coroutineScope, "scope");
        this.context = context2;
        this.scope = coroutineScope;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/askgps/personaltrackercore/utils/BluetoothUtils$Companion;", "", "()V", "SCAN_PERIOD", "", "TAG", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: BluetoothUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Deferred<Set<IndoorDevice>> periodicResultAsync(long j) {
        return BuildersKt__Builders_commonKt.async$default(this.scope, null, null, new BluetoothUtils$periodicResultAsync$1(this, j, null), 3, null);
    }

    /* access modifiers changed from: private */
    public final void scanLeDevice() {
        BluetoothLeScanner bluetoothLeScanner;
        LogKt.toLog$default("start scan", (String) null, (String) null, TAG, 3, (Object) null);
        BluetoothAdapter bluetoothAdapter = getBluetoothAdapter();
        if (bluetoothAdapter != null && (bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner()) != null) {
            bluetoothLeScanner.startScan(this.scanCallback);
        }
    }

    /* access modifiers changed from: private */
    public final void stopScanLeDevice() {
        BluetoothLeScanner bluetoothLeScanner;
        BluetoothAdapter bluetoothAdapter = getBluetoothAdapter();
        if (!(bluetoothAdapter == null || (bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner()) == null)) {
            bluetoothLeScanner.stopScan(this.scanCallback);
        }
        LogKt.toLog$default("stop scan", (String) null, (String) null, TAG, 3, (Object) null);
    }

    public void onCreate() {
        BluetoothAdapter bluetoothAdapter = getBluetoothAdapter();
        if (bluetoothAdapter != null) {
            if (!(!bluetoothAdapter.isEnabled())) {
                bluetoothAdapter = null;
            }
            if (bluetoothAdapter != null) {
                bluetoothAdapter.enable();
            }
        }
    }

    public void onResume() {
        scanLeDevice();
    }

    public void onPause() {
        stopScanLeDevice();
    }
}
