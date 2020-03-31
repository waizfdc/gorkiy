package com.askgps.personaltrackercore.utils;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.database.model.IndoorDevice;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"com/askgps/personaltrackercore/utils/BluetoothUtils$scanCallback$1", "Landroid/bluetooth/le/ScanCallback;", "onBatchScanResults", "", "results", "", "Landroid/bluetooth/le/ScanResult;", "onScanFailed", "errorCode", "", "onScanResult", "callbackType", "result", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BluetoothUtils.kt */
public final class BluetoothUtils$scanCallback$1 extends ScanCallback {
    final /* synthetic */ BluetoothUtils this$0;

    BluetoothUtils$scanCallback$1(BluetoothUtils bluetoothUtils) {
        this.this$0 = bluetoothUtils;
    }

    public void onScanFailed(int i) {
        super.onScanFailed(i);
        LogKt.toLog$default(Integer.valueOf(i), "onScanFailed", (String) null, "app_bt", 2, (Object) null);
    }

    public void onScanResult(int i, ScanResult scanResult) {
        Intrinsics.checkParameterIsNotNull(scanResult, "result");
        super.onScanResult(i, scanResult);
        LogKt.toLog$default(scanResult, "onScanResult", (String) null, "app_bt", 2, (Object) null);
        Set access$getScanDevices$p = this.this$0.scanDevices;
        BluetoothDevice device = scanResult.getDevice();
        Intrinsics.checkExpressionValueIsNotNull(device, "result.device");
        String address = device.getAddress();
        Intrinsics.checkExpressionValueIsNotNull(address, "result.device.address");
        access$getScanDevices$p.add(new IndoorDevice(address, scanResult.getRssi()));
    }

    public void onBatchScanResults(List<ScanResult> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        super.onBatchScanResults(list);
        LogKt.toLogLn$default(list, null, null, "app_bt", 3, null);
    }
}
