package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzf;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.p001authapi.zzi;
import com.google.android.gms.internal.p001authapi.zzr;

public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API = new Api<>("Auth.CREDENTIALS_API", zzi, zzg);
    public static final CredentialsApi CredentialsApi = new zzi();
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API = new Api<>("Auth.GOOGLE_SIGN_IN_API", zzj, zzh);
    public static final GoogleSignInApi GoogleSignInApi = new zzf();
    @Deprecated
    public static final Api<AuthProxyOptions> PROXY_API = AuthProxy.API;
    @Deprecated
    public static final ProxyApi ProxyApi = AuthProxy.ProxyApi;
    public static final Api.ClientKey<zzr> zzg = new Api.ClientKey<>();
    public static final Api.ClientKey<zzg> zzh = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzr, AuthCredentialsOptions> zzi = new zzc();
    private static final Api.AbstractClientBuilder<zzg, GoogleSignInOptions> zzj = new zzd();

    private Auth() {
    }

    @Deprecated
    public static class AuthCredentialsOptions implements Api.ApiOptions.Optional {
        private static final AuthCredentialsOptions zzk = new Builder().zzc();
        private final String zzl = null;
        private final boolean zzm;

        public AuthCredentialsOptions(Builder builder) {
            this.zzm = builder.zzn.booleanValue();
        }

        @Deprecated
        public static class Builder {
            protected Boolean zzn = false;

            public Builder forceEnableSaveDialog() {
                this.zzn = true;
                return this;
            }

            public AuthCredentialsOptions zzc() {
                return new AuthCredentialsOptions(this);
            }
        }

        public final Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putBoolean("force_save_dialog", this.zzm);
            return bundle;
        }
    }
}
