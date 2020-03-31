package com.google.android.gms.internal.fitness;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.fitness.zzf;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzt extends zzl<zzbt> {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Fitness.CONFIG_API", new zzv(), CLIENT_KEY);
    private static final Api.ClientKey<zzt> CLIENT_KEY = new Api.ClientKey<>();
    private static final zzf.zza zzmw = zzf.zza.FIT_CONFIG;
    public static final Api<Api.ApiOptions.HasGoogleSignInAccountOptions> zzmx = new Api<>("Fitness.CONFIG_CLIENT", new zzx(), CLIENT_KEY);

    private zzt(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, zzmw, connectionCallbacks, onConnectionFailedListener, clientSettings);
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.fitness.internal.IGoogleFitConfigApi";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.fitness.ConfigApi";
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
        if (queryLocalInterface instanceof zzbt) {
            return (zzbt) queryLocalInterface;
        }
        return new zzbs(iBinder);
    }
}
