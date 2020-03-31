package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.cache.MemoryValueCache;
import io.fabric.sdk.android.services.cache.ValueLoader;

public class InstallerPackageNameProvider {
    private static final String NO_INSTALLER_PACKAGE_NAME = "";
    private final MemoryValueCache<String> installerPackageNameCache = new MemoryValueCache<>();
    private final ValueLoader<String> installerPackageNameLoader = new ValueLoader<String>() {
        /* class io.fabric.sdk.android.services.common.InstallerPackageNameProvider.AnonymousClass1 */

        public String load(Context context) throws Exception {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    };

    public String getInstallerPackageName(Context context) {
        try {
            String str = this.installerPackageNameCache.get(context, this.installerPackageNameLoader);
            if ("".equals(str)) {
                return null;
            }
            return str;
        } catch (Exception e) {
            Fabric.getLogger().e(Fabric.TAG, "Failed to determine installer package name", e);
            return null;
        }
    }
}
