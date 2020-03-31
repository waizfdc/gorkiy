package com.askgps.personaltrackercore.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.Dependency;
import com.askgps.personaltrackercore.database.SettingsDao;
import com.askgps.personaltrackercore.database.model.Settings;
import java.util.concurrent.Callable;

public final class SettingsDao_Impl implements SettingsDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    private final EntityInsertionAdapter<Settings> __insertionAdapterOfSettings;
    private final SharedSQLiteStatement __preparedStmtOfSetAddress;
    private final SharedSQLiteStatement __preparedStmtOfSetLocationInterval;
    private final SharedSQLiteStatement __preparedStmtOfSetRemovalFromHandInterval;
    private final SharedSQLiteStatement __preparedStmtOfSetSendTelemetryInterval;
    private final SharedSQLiteStatement __preparedStmtOfSetWorkIsStart;

    public SettingsDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSettings = new EntityInsertionAdapter<Settings>(roomDatabase) {
            /* class com.askgps.personaltrackercore.database.SettingsDao_Impl.AnonymousClass1 */

            public String createQuery() {
                return "INSERT OR IGNORE INTO `Settings` (`workIsStart`,`gaskarAddress`,`locationInterval`,`sendTelemetryInterval`,`removalFromHandJobInterval`,`id`) VALUES (?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Settings settings) {
                supportSQLiteStatement.bindLong(1, settings.getWorkIsStart() ? 1 : 0);
                if (settings.getGaskarAddress() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, settings.getGaskarAddress());
                }
                supportSQLiteStatement.bindLong(3, settings.getLocationInterval());
                supportSQLiteStatement.bindLong(4, settings.getSendTelemetryInterval());
                supportSQLiteStatement.bindLong(5, settings.getRemovalFromHandJobInterval());
                supportSQLiteStatement.bindLong(6, (long) settings.getId());
            }
        };
        this.__preparedStmtOfSetWorkIsStart = new SharedSQLiteStatement(roomDatabase) {
            /* class com.askgps.personaltrackercore.database.SettingsDao_Impl.AnonymousClass2 */

            public String createQuery() {
                return "UPDATE Settings SET workIsStart=? WHERE id = 1";
            }
        };
        this.__preparedStmtOfSetAddress = new SharedSQLiteStatement(roomDatabase) {
            /* class com.askgps.personaltrackercore.database.SettingsDao_Impl.AnonymousClass3 */

            public String createQuery() {
                return "UPDATE Settings SET gaskarAddress=? WHERE id = 1";
            }
        };
        this.__preparedStmtOfSetLocationInterval = new SharedSQLiteStatement(roomDatabase) {
            /* class com.askgps.personaltrackercore.database.SettingsDao_Impl.AnonymousClass4 */

            public String createQuery() {
                return "UPDATE Settings SET locationInterval=? WHERE id = 1";
            }
        };
        this.__preparedStmtOfSetSendTelemetryInterval = new SharedSQLiteStatement(roomDatabase) {
            /* class com.askgps.personaltrackercore.database.SettingsDao_Impl.AnonymousClass5 */

            public String createQuery() {
                return "UPDATE Settings SET sendTelemetryInterval=? WHERE id = 1";
            }
        };
        this.__preparedStmtOfSetRemovalFromHandInterval = new SharedSQLiteStatement(roomDatabase) {
            /* class com.askgps.personaltrackercore.database.SettingsDao_Impl.AnonymousClass6 */

            public String createQuery() {
                return "UPDATE Settings SET removalFromHandJobInterval=? WHERE id = 1";
            }
        };
    }

    public void createSettings(Settings settings) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSettings.insert((Dependency) settings);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void updateSettings(String str, Long l, Long l2, Long l3) {
        this.__db.beginTransaction();
        try {
            SettingsDao.DefaultImpls.updateSettings(this, str, l, l2, l3);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void setWorkIsStart(boolean z) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetWorkIsStart.acquire();
        acquire.bindLong(1, z ? 1 : 0);
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetWorkIsStart.release(acquire);
        }
    }

    public void setAddress(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetAddress.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetAddress.release(acquire);
        }
    }

    public void setLocationInterval(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetLocationInterval.acquire();
        acquire.bindLong(1, j);
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetLocationInterval.release(acquire);
        }
    }

    public void setSendTelemetryInterval(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetSendTelemetryInterval.acquire();
        acquire.bindLong(1, j);
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetSendTelemetryInterval.release(acquire);
        }
    }

    public void setRemovalFromHandInterval(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetRemovalFromHandInterval.acquire();
        acquire.bindLong(1, j);
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetRemovalFromHandInterval.release(acquire);
        }
    }

    public LiveData<Settings> getSettings() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Settings WHERE id = 1", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"Settings"}, false, new Callable<Settings>() {
            /* class com.askgps.personaltrackercore.database.SettingsDao_Impl.AnonymousClass7 */

            public Settings call() throws Exception {
                Settings settings = null;
                boolean z = false;
                Cursor query = DBUtil.query(SettingsDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "workIsStart");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "gaskarAddress");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "locationInterval");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "sendTelemetryInterval");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "removalFromHandJobInterval");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "id");
                    if (query.moveToFirst()) {
                        if (query.getInt(columnIndexOrThrow) != 0) {
                            z = true;
                        }
                        settings = new Settings(z, query.getString(columnIndexOrThrow2), query.getLong(columnIndexOrThrow3), query.getLong(columnIndexOrThrow4), query.getLong(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6));
                    }
                    return settings;
                } finally {
                    query.close();
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }
        });
    }
}
