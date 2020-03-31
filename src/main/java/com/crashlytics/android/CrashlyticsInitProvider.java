package com.crashlytics.android;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.FirebaseInfo;

public class CrashlyticsInitProvider extends ContentProvider {
    private static final String NDK_MANIFEST_FLAG = "firebase_crashlytics_ndk_enabled";
    private static final String TAG = "CrashlyticsInitProvider";

    interface EnabledCheckStrategy {
        boolean isCrashlyticsEnabled(Context context);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public boolean onCreate() {
        Context context = getContext();
        if (shouldInitializeFabric(context, new FirebaseInfo(), new ManifestEnabledCheckStrategy())) {
            try {
                Fabric.with(context, createCrashlyticsKits(context.getApplicationContext()));
                Fabric.getLogger().i(TAG, "CrashlyticsInitProvider initialization successful");
                return true;
            } catch (IllegalStateException unused) {
                Fabric.getLogger().i(TAG, "CrashlyticsInitProvider initialization unsuccessful");
                return false;
            }
        } else {
            Fabric.getLogger().i(TAG, "CrashlyticsInitProvider skipping initialization");
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032 A[SYNTHETIC, Splitter:B:12:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.fabric.sdk.android.Kit[] createCrashlyticsKits(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Fabric"
            r1 = 1
            r2 = 0
            android.content.pm.PackageManager r3 = r7.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0020 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0020 }
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r7 = r3.getApplicationInfo(r7, r4)     // Catch:{ NameNotFoundException -> 0x0020 }
            android.os.Bundle r7 = r7.metaData     // Catch:{ NameNotFoundException -> 0x0020 }
            if (r7 == 0) goto L_0x002a
            java.lang.String r3 = "firebase_crashlytics_ndk_enabled"
            boolean r7 = r7.getBoolean(r3, r2)     // Catch:{ NameNotFoundException -> 0x0020 }
            if (r7 == 0) goto L_0x002a
            r7 = r1
            goto L_0x002b
        L_0x0020:
            r7 = move-exception
            io.fabric.sdk.android.Logger r3 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.String r4 = "Unable to get PackageManager while determining if Crashlytics NDK should be initialized"
            r3.d(r0, r4, r7)
        L_0x002a:
            r7 = r2
        L_0x002b:
            com.crashlytics.android.Crashlytics r3 = new com.crashlytics.android.Crashlytics
            r3.<init>()
            if (r7 == 0) goto L_0x0052
            io.fabric.sdk.android.Logger r7 = io.fabric.sdk.android.Fabric.getLogger()     // Catch:{ all -> 0x0048 }
            java.lang.String r4 = "Crashlytics is initializing NDK crash reporter."
            r7.i(r0, r4)     // Catch:{ all -> 0x0048 }
            r7 = 2
            io.fabric.sdk.android.Kit[] r7 = new io.fabric.sdk.android.Kit[r7]     // Catch:{ all -> 0x0048 }
            r7[r2] = r3     // Catch:{ all -> 0x0048 }
            com.crashlytics.android.ndk.CrashlyticsNdk r4 = new com.crashlytics.android.ndk.CrashlyticsNdk     // Catch:{ all -> 0x0048 }
            r4.<init>()     // Catch:{ all -> 0x0048 }
            r7[r1] = r4     // Catch:{ all -> 0x0048 }
            return r7
        L_0x0048:
            r7 = move-exception
            io.fabric.sdk.android.Logger r4 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.String r5 = "Crashlytics failed to initialize NDK crash reporting. Attempting to intialize SDK..."
            r4.e(r0, r5, r7)
        L_0x0052:
            io.fabric.sdk.android.Kit[] r7 = new io.fabric.sdk.android.Kit[r1]
            r7[r2] = r3
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.CrashlyticsInitProvider.createCrashlyticsKits(android.content.Context):io.fabric.sdk.android.Kit[]");
    }

    /* access modifiers changed from: package-private */
    public boolean shouldInitializeFabric(Context context, FirebaseInfo firebaseInfo, EnabledCheckStrategy enabledCheckStrategy) {
        if (firebaseInfo.isFirebaseCrashlyticsEnabled(context)) {
            return enabledCheckStrategy.isCrashlyticsEnabled(context);
        }
        return firebaseInfo.isAutoInitializeFlagEnabled(context);
    }
}
