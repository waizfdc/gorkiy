package com.crashlytics.android.core;

import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

class PreferenceManager {
    static final String PREF_ALWAYS_SEND_REPORTS_KEY = "always_send_reports_opt_in";
    private static final String PREF_MIGRATION_COMPLETE = "preferences_migration_complete";
    private static final boolean SHOULD_ALWAYS_SEND_REPORTS_DEFAULT = false;
    private final CrashlyticsCore kit;
    private final PreferenceStore preferenceStore;

    public static PreferenceManager create(PreferenceStore preferenceStore2, CrashlyticsCore crashlyticsCore) {
        return new PreferenceManager(preferenceStore2, crashlyticsCore);
    }

    public PreferenceManager(PreferenceStore preferenceStore2, CrashlyticsCore crashlyticsCore) {
        this.preferenceStore = preferenceStore2;
        this.kit = crashlyticsCore;
    }

    /* access modifiers changed from: package-private */
    public void setShouldAlwaysSendReports(boolean z) {
        PreferenceStore preferenceStore2 = this.preferenceStore;
        preferenceStore2.save(preferenceStore2.edit().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, z));
    }

    /* access modifiers changed from: package-private */
    public boolean shouldAlwaysSendReports() {
        if (!this.preferenceStore.get().contains(PREF_MIGRATION_COMPLETE)) {
            PreferenceStoreImpl preferenceStoreImpl = new PreferenceStoreImpl(this.kit);
            if (!this.preferenceStore.get().contains(PREF_ALWAYS_SEND_REPORTS_KEY) && preferenceStoreImpl.get().contains(PREF_ALWAYS_SEND_REPORTS_KEY)) {
                boolean z = preferenceStoreImpl.get().getBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, false);
                PreferenceStore preferenceStore2 = this.preferenceStore;
                preferenceStore2.save(preferenceStore2.edit().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, z));
            }
            PreferenceStore preferenceStore3 = this.preferenceStore;
            preferenceStore3.save(preferenceStore3.edit().putBoolean(PREF_MIGRATION_COMPLETE, true));
        }
        return this.preferenceStore.get().getBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, false);
    }
}
