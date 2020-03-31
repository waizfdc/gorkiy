package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
public final class zzo extends zza implements zzm {
    zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public final void initialize(IObjectWrapper iObjectWrapper, zzv zzv, long j) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, iObjectWrapper);
        zzb.zza(a_, zzv);
        a_.writeLong(j);
        zzb(1, a_);
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, bundle);
        zzb.zza(a_, z);
        zzb.zza(a_, z2);
        a_.writeLong(j);
        zzb(2, a_);
    }

    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzn zzn, long j) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, bundle);
        zzb.zza(a_, zzn);
        a_.writeLong(j);
        zzb(3, a_);
    }

    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, iObjectWrapper);
        zzb.zza(a_, z);
        a_.writeLong(j);
        zzb(4, a_);
    }

    public final void getUserProperties(String str, String str2, boolean z, zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, z);
        zzb.zza(a_, zzn);
        zzb(5, a_);
    }

    public final void getMaxUserProperties(String str, zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        zzb.zza(a_, zzn);
        zzb(6, a_);
    }

    public final void setUserId(String str, long j) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeLong(j);
        zzb(7, a_);
    }

    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, bundle);
        a_.writeLong(j);
        zzb(8, a_);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, bundle);
        zzb(9, a_);
    }

    public final void getConditionalUserProperties(String str, String str2, zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, zzn);
        zzb(10, a_);
    }

    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, z);
        a_.writeLong(j);
        zzb(11, a_);
    }

    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel a_ = a_();
        a_.writeLong(j);
        zzb(12, a_);
    }

    public final void setMinimumSessionDuration(long j) throws RemoteException {
        Parcel a_ = a_();
        a_.writeLong(j);
        zzb(13, a_);
    }

    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel a_ = a_();
        a_.writeLong(j);
        zzb(14, a_);
    }

    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, iObjectWrapper);
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeLong(j);
        zzb(15, a_);
    }

    public final void getCurrentScreenName(zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzn);
        zzb(16, a_);
    }

    public final void getCurrentScreenClass(zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzn);
        zzb(17, a_);
    }

    public final void setInstanceIdProvider(zzt zzt) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzt);
        zzb(18, a_);
    }

    public final void getCachedAppInstanceId(zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzn);
        zzb(19, a_);
    }

    public final void getAppInstanceId(zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzn);
        zzb(20, a_);
    }

    public final void getGmpAppId(zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzn);
        zzb(21, a_);
    }

    public final void generateEventId(zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzn);
        zzb(22, a_);
    }

    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeLong(j);
        zzb(23, a_);
    }

    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeLong(j);
        zzb(24, a_);
    }

    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, iObjectWrapper);
        a_.writeLong(j);
        zzb(25, a_);
    }

    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, iObjectWrapper);
        a_.writeLong(j);
        zzb(26, a_);
    }

    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, iObjectWrapper);
        zzb.zza(a_, bundle);
        a_.writeLong(j);
        zzb(27, a_);
    }

    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, iObjectWrapper);
        a_.writeLong(j);
        zzb(28, a_);
    }

    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, iObjectWrapper);
        a_.writeLong(j);
        zzb(29, a_);
    }

    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, iObjectWrapper);
        a_.writeLong(j);
        zzb(30, a_);
    }

    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzn zzn, long j) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, iObjectWrapper);
        zzb.zza(a_, zzn);
        a_.writeLong(j);
        zzb(31, a_);
    }

    public final void performAction(Bundle bundle, zzn zzn, long j) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, bundle);
        zzb.zza(a_, zzn);
        a_.writeLong(j);
        zzb(32, a_);
    }

    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel a_ = a_();
        a_.writeInt(i);
        a_.writeString(str);
        zzb.zza(a_, iObjectWrapper);
        zzb.zza(a_, iObjectWrapper2);
        zzb.zza(a_, iObjectWrapper3);
        zzb(33, a_);
    }

    public final void setEventInterceptor(zzs zzs) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzs);
        zzb(34, a_);
    }

    public final void registerOnMeasurementEventListener(zzs zzs) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzs);
        zzb(35, a_);
    }

    public final void unregisterOnMeasurementEventListener(zzs zzs) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzs);
        zzb(36, a_);
    }

    public final void initForTests(Map map) throws RemoteException {
        Parcel a_ = a_();
        a_.writeMap(map);
        zzb(37, a_);
    }

    public final void getTestFlag(zzn zzn, int i) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzn);
        a_.writeInt(i);
        zzb(38, a_);
    }

    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, z);
        zzb(39, a_);
    }

    public final void isDataCollectionEnabled(zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        zzb.zza(a_, zzn);
        zzb(40, a_);
    }
}
