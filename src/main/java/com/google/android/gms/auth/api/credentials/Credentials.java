package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.Auth;

public class Credentials {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.auth.api.credentials.CredentialsClient.<init>(android.app.Activity, com.google.android.gms.auth.api.Auth$AuthCredentialsOptions):void
     arg types: [android.app.Activity, com.google.android.gms.auth.api.credentials.CredentialsOptions]
     candidates:
      com.google.android.gms.auth.api.credentials.CredentialsClient.<init>(android.content.Context, com.google.android.gms.auth.api.Auth$AuthCredentialsOptions):void
      com.google.android.gms.auth.api.credentials.CredentialsClient.<init>(android.app.Activity, com.google.android.gms.auth.api.Auth$AuthCredentialsOptions):void */
    public static CredentialsClient getClient(Activity activity) {
        return new CredentialsClient(activity, (Auth.AuthCredentialsOptions) CredentialsOptions.DEFAULT);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.auth.api.credentials.CredentialsClient.<init>(android.app.Activity, com.google.android.gms.auth.api.Auth$AuthCredentialsOptions):void
     arg types: [android.app.Activity, com.google.android.gms.auth.api.credentials.CredentialsOptions]
     candidates:
      com.google.android.gms.auth.api.credentials.CredentialsClient.<init>(android.content.Context, com.google.android.gms.auth.api.Auth$AuthCredentialsOptions):void
      com.google.android.gms.auth.api.credentials.CredentialsClient.<init>(android.app.Activity, com.google.android.gms.auth.api.Auth$AuthCredentialsOptions):void */
    public static CredentialsClient getClient(Activity activity, CredentialsOptions credentialsOptions) {
        return new CredentialsClient(activity, (Auth.AuthCredentialsOptions) credentialsOptions);
    }

    public static CredentialsClient getClient(Context context) {
        return new CredentialsClient(context, CredentialsOptions.DEFAULT);
    }

    public static CredentialsClient getClient(Context context, CredentialsOptions credentialsOptions) {
        return new CredentialsClient(context, credentialsOptions);
    }
}
