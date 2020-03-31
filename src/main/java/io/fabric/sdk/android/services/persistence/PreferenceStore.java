package io.fabric.sdk.android.services.persistence;

import android.content.SharedPreferences;

public interface PreferenceStore {
    SharedPreferences.Editor edit();

    SharedPreferences get();

    boolean save(SharedPreferences.Editor editor);
}
