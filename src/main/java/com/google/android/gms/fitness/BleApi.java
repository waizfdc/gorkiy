package com.google.android.gms.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public interface BleApi {
    PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice);

    PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, String str);

    PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient googleApiClient);

    @Deprecated
    PendingResult<Status> startBleScan(GoogleApiClient googleApiClient, StartBleScanRequest startBleScanRequest);

    PendingResult<Status> stopBleScan(GoogleApiClient googleApiClient, BleScanCallback bleScanCallback);

    PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice);

    PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, String str);
}
