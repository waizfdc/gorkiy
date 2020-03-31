package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class Api<O extends ApiOptions> {
    private final String mName;
    private final AbstractClientBuilder<?, O> zaaw;
    private final zaa<?, O> zaax = null;
    private final ClientKey<?> zaay;
    private final zab<?> zaaz;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.common.api.Api.AbstractClientBuilder.buildClient(android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.internal.ConnectionCallbacks, com.google.android.gms.common.api.internal.OnConnectionFailedListener):T
         arg types: [android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, O, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener]
         candidates:
          com.google.android.gms.common.api.Api.AbstractClientBuilder.buildClient(android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener):T
          com.google.android.gms.common.api.Api.AbstractClientBuilder.buildClient(android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.internal.ConnectionCallbacks, com.google.android.gms.common.api.internal.OnConnectionFailedListener):T */
        @Deprecated
        public T buildClient(Context context, Looper looper, ClientSettings clientSettings, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return buildClient(context, looper, clientSettings, (Object) o, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
        }

        public T buildClient(Context context, Looper looper, ClientSettings clientSettings, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public interface AnyClient {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public static class AnyClientKey<C extends AnyClient> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public interface ApiOptions {

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            Account getAccount();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        public interface HasGoogleSignInAccountOptions extends HasOptions {
            GoogleSignInAccount getGoogleSignInAccount();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        public interface HasOptions extends ApiOptions {
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        public interface NotRequiredOptions extends ApiOptions {
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public interface Client extends AnyClient {
        void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        Feature[] getAvailableFeatures();

        String getEndpointPackageName();

        int getMinApkVersion();

        void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set);

        Feature[] getRequiredFeatures();

        Set<Scope> getScopesForConnectionlessNonSignIn();

        IBinder getServiceBrokerBinder();

        Intent getSignInIntent();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks);

        boolean providesSignIn();

        boolean requiresAccount();

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public static final class ClientKey<C extends Client> extends AnyClientKey<C> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public interface SimpleClient<T extends IInterface> extends AnyClient {
        T createServiceInterface(IBinder iBinder);

        Context getContext();

        String getServiceDescriptor();

        String getStartServiceAction();

        void setState(int i, T t);
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public static abstract class zaa<T extends SimpleClient<? extends IInterface>, O> extends BaseClientBuilder<T, O> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public static final class zab<C extends SimpleClient<? extends IInterface>> extends AnyClientKey<C> {
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.android.gms.common.api.Api$AbstractClientBuilder<C, O>, com.google.android.gms.common.api.Api$AbstractClientBuilder<?, O>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.common.api.Api$ClientKey<C>, java.lang.Object, com.google.android.gms.common.api.Api$ClientKey<?>] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <C extends com.google.android.gms.common.api.Api.Client> Api(java.lang.String r2, com.google.android.gms.common.api.Api.AbstractClientBuilder<C, O> r3, com.google.android.gms.common.api.Api.ClientKey<C> r4) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "Cannot construct an Api with a null ClientBuilder"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3, r0)
            java.lang.String r0 = "Cannot construct an Api with a null ClientKey"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4, r0)
            r1.mName = r2
            r1.zaaw = r3
            r2 = 0
            r1.zaax = r2
            r1.zaay = r4
            r1.zaaz = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.Api.<init>(java.lang.String, com.google.android.gms.common.api.Api$AbstractClientBuilder, com.google.android.gms.common.api.Api$ClientKey):void");
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public static abstract class BaseClientBuilder<T extends AnyClient, O> {
        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;

        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public List<Scope> getImpliedScopes(O o) {
            return Collections.emptyList();
        }
    }

    public final BaseClientBuilder<?, O> zah() {
        return this.zaaw;
    }

    public final AbstractClientBuilder<?, O> zai() {
        Preconditions.checkState(this.zaaw != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.zaaw;
    }

    public final AnyClientKey<?> getClientKey() {
        ClientKey<?> clientKey = this.zaay;
        if (clientKey != null) {
            return clientKey;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public final String getName() {
        return this.mName;
    }
}
