package com.askgps.personaltrackercore.database;

import androidx.lifecycle.LiveData;
import com.askgps.personaltrackercore.database.model.Settings;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H'J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH'J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H'J5\u0010\u0013\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/askgps/personaltrackercore/database/SettingsDao;", "", "createSettings", "", "settings", "Lcom/askgps/personaltrackercore/database/model/Settings;", "getSettings", "Landroidx/lifecycle/LiveData;", "setAddress", "address", "", "setLocationInterval", "interval", "", "setRemovalFromHandInterval", "setSendTelemetryInterval", "setWorkIsStart", "workIsStart", "", "updateSettings", "locationInterval", "sendTelemetryInterval", "removalFromHandInterval", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DatabaseHelper.kt */
public interface SettingsDao {
    void createSettings(Settings settings);

    LiveData<Settings> getSettings();

    void setAddress(String str);

    void setLocationInterval(long j);

    void setRemovalFromHandInterval(long j);

    void setSendTelemetryInterval(long j);

    void setWorkIsStart(boolean z);

    void updateSettings(String str, Long l, Long l2, Long l3);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* compiled from: DatabaseHelper.kt */
    public static final class DefaultImpls {
        public static void updateSettings(SettingsDao settingsDao, String str, Long l, Long l2, Long l3) {
            if (str != null) {
                settingsDao.setAddress(str);
            }
            if (l != null) {
                settingsDao.setLocationInterval(l.longValue());
            }
            if (l2 != null) {
                settingsDao.setSendTelemetryInterval(l2.longValue());
            }
            if (l3 != null) {
                settingsDao.setRemovalFromHandInterval(l3.longValue());
            }
        }
    }
}
