package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzl;
import com.google.android.gms.internal.measurement.zzn;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzt;
import com.google.android.gms.internal.measurement.zzv;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.3 */
public class AppMeasurementDynamiteService extends zzl {
    zzgo zza = null;
    private Map<Integer, zzhn> zzb = new ArrayMap();

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.3 */
    class zza implements zzho {
        private zzs zza;

        zza(zzs zzs) {
            this.zza = zzs;
        }

        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event interceptor threw exception", e);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.3 */
    class zzb implements zzhn {
        private zzs zza;

        zzb(zzs zzs) {
            this.zza = zzs;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event listener threw exception", e);
            }
        }
    }

    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzv zzv, long j) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzgo zzgo = this.zza;
        if (zzgo == null) {
            this.zza = zzgo.zza(context, zzv);
        } else {
            zzgo.zzr().zzi().zza("Attempting to initialize multiple times");
        }
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, bundle, z, z2, j);
    }

    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    public void setUserId(String str, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(null, "_id", str, true, j);
    }

    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zza();
        this.zza.zzv().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(z);
    }

    public void resetAnalyticsData(long j) throws RemoteException {
        zza();
        this.zza.zzh().zzd(j);
    }

    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(j);
    }

    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zza();
        this.zza.zzh().zzb(j);
    }

    public void getMaxUserProperties(String str, zzn zzn) throws RemoteException {
        zza();
        this.zza.zzh();
        Preconditions.checkNotEmpty(str);
        this.zza.zzi().zza(zzn, 25);
    }

    public void getCurrentScreenName(zzn zzn) throws RemoteException {
        zza();
        zza(zzn, this.zza.zzh().zzaj());
    }

    public void getCurrentScreenClass(zzn zzn) throws RemoteException {
        zza();
        zza(zzn, this.zza.zzh().zzak());
    }

    public void getCachedAppInstanceId(zzn zzn) throws RemoteException {
        zza();
        zza(zzn, this.zza.zzh().zzah());
    }

    public void getAppInstanceId(zzn zzn) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzi(this, zzn));
    }

    public void getGmpAppId(zzn zzn) throws RemoteException {
        zza();
        zza(zzn, this.zza.zzh().zzal());
    }

    public void generateEventId(zzn zzn) throws RemoteException {
        zza();
        this.zza.zzi().zza(zzn, this.zza.zzi().zzg());
    }

    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzz().zza(str, j);
    }

    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzz().zzb(str, j);
    }

    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzn zzn, long j) throws RemoteException {
        Bundle bundle2;
        zza();
        Preconditions.checkNotEmpty(str2);
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", SettingsJsonConstants.APP_KEY);
        this.zza.zzq().zza(new zzh(this, zzn, new zzan(str2, new zzam(bundle), SettingsJsonConstants.APP_KEY, j), str));
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzim zzim = this.zza.zzh().zza;
        if (zzim != null) {
            this.zza.zzh().zzab();
            zzim.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzim zzim = this.zza.zzh().zza;
        if (zzim != null) {
            this.zza.zzh().zzab();
            zzim.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zza();
        zzim zzim = this.zza.zzh().zza;
        if (zzim != null) {
            this.zza.zzh().zzab();
            zzim.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzim zzim = this.zza.zzh().zza;
        if (zzim != null) {
            this.zza.zzh().zzab();
            zzim.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzim zzim = this.zza.zzh().zza;
        if (zzim != null) {
            this.zza.zzh().zzab();
            zzim.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzim zzim = this.zza.zzh().zza;
        if (zzim != null) {
            this.zza.zzh().zzab();
            zzim.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzn zzn, long j) throws RemoteException {
        zza();
        zzim zzim = this.zza.zzh().zza;
        Bundle bundle = new Bundle();
        if (zzim != null) {
            this.zza.zzh().zzab();
            zzim.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzn.zza(bundle);
        } catch (RemoteException e) {
            this.zza.zzr().zzi().zza("Error returning bundle value to wrapper", e);
        }
    }

    public void performAction(Bundle bundle, zzn zzn, long j) throws RemoteException {
        zza();
        zzn.zza(null);
    }

    public void getUserProperties(String str, String str2, boolean z, zzn zzn) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzk(this, zzn, str, str2, z));
    }

    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Object obj;
        Object obj2;
        zza();
        Object obj3 = null;
        if (iObjectWrapper == null) {
            obj = null;
        } else {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            obj2 = null;
        } else {
            obj2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj3 = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzr().zza(i, true, false, str, obj, obj2, obj3);
    }

    public void setEventInterceptor(zzs zzs) throws RemoteException {
        zza();
        zzhp zzh = this.zza.zzh();
        zza zza2 = new zza(zzs);
        zzh.zzb();
        zzh.zzw();
        zzh.zzq().zza(new zzhx(zzh, zza2));
    }

    public void registerOnMeasurementEventListener(zzs zzs) throws RemoteException {
        zza();
        zzhn zzhn = this.zzb.get(Integer.valueOf(zzs.zza()));
        if (zzhn == null) {
            zzhn = new zzb(zzs);
            this.zzb.put(Integer.valueOf(zzs.zza()), zzhn);
        }
        this.zza.zzh().zza(zzhn);
    }

    public void unregisterOnMeasurementEventListener(zzs zzs) throws RemoteException {
        zza();
        zzhn remove = this.zzb.remove(Integer.valueOf(zzs.zza()));
        if (remove == null) {
            remove = new zzb(zzs);
        }
        this.zza.zzh().zzb(remove);
    }

    public void setInstanceIdProvider(zzt zzt) throws RemoteException {
        zza();
    }

    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzr().zzf().zza("Conditional user property must not be null");
        } else {
            this.zza.zzh().zza(bundle, j);
        }
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zza();
        this.zza.zzh().zzc(str, str2, bundle);
    }

    public void getConditionalUserProperties(String str, String str2, zzn zzn) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzj(this, zzn, str, str2));
    }

    public void getTestFlag(zzn zzn, int i) throws RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzi().zza(zzn, this.zza.zzh().zzad());
        } else if (i == 1) {
            this.zza.zzi().zza(zzn, this.zza.zzh().zzae().longValue());
        } else if (i == 2) {
            zzla zzi = this.zza.zzi();
            double doubleValue = this.zza.zzh().zzag().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzn.zza(bundle);
            } catch (RemoteException e) {
                zzi.zzx.zzr().zzi().zza("Error returning double value to wrapper", e);
            }
        } else if (i == 3) {
            this.zza.zzi().zza(zzn, this.zza.zzh().zzaf().intValue());
        } else if (i == 4) {
            this.zza.zzi().zza(zzn, this.zza.zzh().zzac().booleanValue());
        }
    }

    private final void zza(zzn zzn, String str) {
        this.zza.zzi().zza(zzn, str);
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zza();
        this.zza.zzh().zzb(z);
    }

    public void isDataCollectionEnabled(zzn zzn) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzl(this, zzn));
    }
}
