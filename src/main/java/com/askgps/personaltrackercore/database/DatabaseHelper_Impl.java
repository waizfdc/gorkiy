package com.askgps.personaltrackercore.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.HashSet;

public final class DatabaseHelper_Impl extends DatabaseHelper {
    private volatile LocationDao _locationDao;
    private volatile PhoneBookDao _phoneBookDao;
    private volatile SettingsDao _settingsDao;
    private volatile StepSensorDao _stepSensorDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(9) {
            /* class com.askgps.personaltrackercore.database.DatabaseHelper_Impl.AnonymousClass1 */

            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Location` (`imei` TEXT NOT NULL, `datetime` INTEGER NOT NULL, `locationDatetime` INTEGER, `lat` REAL, `lon` REAL, `altitude` REAL, `accuracy` INTEGER, `bearing` INTEGER, `speed` REAL, `provider` TEXT, `stepCount` INTEGER, `isLeaveHand` INTEGER, `batteryLevel` INTEGER, `isFall` INTEGER, `powerOn` INTEGER, `sos` INTEGER, `version` INTEGER, `workShift` INTEGER, `isValid` INTEGER, `indoorNavigation` TEXT, PRIMARY KEY(`datetime`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `StepSensor` (`lastSensorValue` INTEGER NOT NULL, `stepsTimeStamp` INTEGER NOT NULL, `stepsAtStartDay` INTEGER NOT NULL, `stepCount` INTEGER NOT NULL, `id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Settings` (`workIsStart` INTEGER NOT NULL, `gaskarAddress` TEXT NOT NULL, `locationInterval` INTEGER NOT NULL, `sendTelemetryInterval` INTEGER NOT NULL, `removalFromHandJobInterval` INTEGER NOT NULL, `id` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `PhoneNumber` (`name` TEXT NOT NULL, `number` TEXT NOT NULL, PRIMARY KEY(`number`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a8a3ecc5e4c839f2e534595364f51c26')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Location`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `StepSensor`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Settings`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `PhoneNumber`");
                if (DatabaseHelper_Impl.this.mCallbacks != null) {
                    int size = DatabaseHelper_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) DatabaseHelper_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (DatabaseHelper_Impl.this.mCallbacks != null) {
                    int size = DatabaseHelper_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) DatabaseHelper_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = DatabaseHelper_Impl.this.mDatabase = supportSQLiteDatabase;
                DatabaseHelper_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (DatabaseHelper_Impl.this.mCallbacks != null) {
                    int size = DatabaseHelper_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) DatabaseHelper_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(20);
                hashMap.put("imei", new TableInfo.Column("imei", "TEXT", true, 0, null, 1));
                hashMap.put("datetime", new TableInfo.Column("datetime", "INTEGER", true, 1, null, 1));
                hashMap.put("locationDatetime", new TableInfo.Column("locationDatetime", "INTEGER", false, 0, null, 1));
                hashMap.put("lat", new TableInfo.Column("lat", "REAL", false, 0, null, 1));
                hashMap.put("lon", new TableInfo.Column("lon", "REAL", false, 0, null, 1));
                hashMap.put("altitude", new TableInfo.Column("altitude", "REAL", false, 0, null, 1));
                hashMap.put("accuracy", new TableInfo.Column("accuracy", "INTEGER", false, 0, null, 1));
                hashMap.put("bearing", new TableInfo.Column("bearing", "INTEGER", false, 0, null, 1));
                hashMap.put("speed", new TableInfo.Column("speed", "REAL", false, 0, null, 1));
                hashMap.put("provider", new TableInfo.Column("provider", "TEXT", false, 0, null, 1));
                hashMap.put("stepCount", new TableInfo.Column("stepCount", "INTEGER", false, 0, null, 1));
                hashMap.put("isLeaveHand", new TableInfo.Column("isLeaveHand", "INTEGER", false, 0, null, 1));
                hashMap.put("batteryLevel", new TableInfo.Column("batteryLevel", "INTEGER", false, 0, null, 1));
                hashMap.put("isFall", new TableInfo.Column("isFall", "INTEGER", false, 0, null, 1));
                hashMap.put("powerOn", new TableInfo.Column("powerOn", "INTEGER", false, 0, null, 1));
                hashMap.put("sos", new TableInfo.Column("sos", "INTEGER", false, 0, null, 1));
                hashMap.put("version", new TableInfo.Column("version", "INTEGER", false, 0, null, 1));
                hashMap.put("workShift", new TableInfo.Column("workShift", "INTEGER", false, 0, null, 1));
                hashMap.put("isValid", new TableInfo.Column("isValid", "INTEGER", false, 0, null, 1));
                hashMap.put("indoorNavigation", new TableInfo.Column("indoorNavigation", "TEXT", false, 0, null, 1));
                TableInfo tableInfo = new TableInfo(HttpRequest.HEADER_LOCATION, hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, HttpRequest.HEADER_LOCATION);
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "Location(com.askgps.personaltrackercore.database.model.Location).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(5);
                hashMap2.put("lastSensorValue", new TableInfo.Column("lastSensorValue", "INTEGER", true, 0, null, 1));
                hashMap2.put("stepsTimeStamp", new TableInfo.Column("stepsTimeStamp", "INTEGER", true, 0, null, 1));
                hashMap2.put("stepsAtStartDay", new TableInfo.Column("stepsAtStartDay", "INTEGER", true, 0, null, 1));
                hashMap2.put("stepCount", new TableInfo.Column("stepCount", "INTEGER", true, 0, null, 1));
                hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                TableInfo tableInfo2 = new TableInfo("StepSensor", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "StepSensor");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "StepSensor(com.askgps.personaltrackercore.database.model.StepSensor).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(6);
                hashMap3.put("workIsStart", new TableInfo.Column("workIsStart", "INTEGER", true, 0, null, 1));
                hashMap3.put("gaskarAddress", new TableInfo.Column("gaskarAddress", "TEXT", true, 0, null, 1));
                hashMap3.put("locationInterval", new TableInfo.Column("locationInterval", "INTEGER", true, 0, null, 1));
                hashMap3.put("sendTelemetryInterval", new TableInfo.Column("sendTelemetryInterval", "INTEGER", true, 0, null, 1));
                hashMap3.put("removalFromHandJobInterval", new TableInfo.Column("removalFromHandJobInterval", "INTEGER", true, 0, null, 1));
                hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                TableInfo tableInfo3 = new TableInfo("Settings", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "Settings");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "Settings(com.askgps.personaltrackercore.database.model.Settings).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(2);
                hashMap4.put(AppMeasurementSdk.ConditionalUserProperty.NAME, new TableInfo.Column(AppMeasurementSdk.ConditionalUserProperty.NAME, "TEXT", true, 0, null, 1));
                hashMap4.put("number", new TableInfo.Column("number", "TEXT", true, 1, null, 1));
                TableInfo tableInfo4 = new TableInfo("PhoneNumber", hashMap4, new HashSet(0), new HashSet(0));
                TableInfo read4 = TableInfo.read(supportSQLiteDatabase2, "PhoneNumber");
                if (tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(true, null);
                }
                return new RoomOpenHelper.ValidationResult(false, "PhoneNumber(com.askgps.personaltrackercore.database.model.PhoneNumber).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
            }
        }, "a8a3ecc5e4c839f2e534595364f51c26", "93fa3e983163700f1032b3945bd8bd81")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), HttpRequest.HEADER_LOCATION, "StepSensor", "Settings", "PhoneNumber");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `Location`");
            writableDatabase.execSQL("DELETE FROM `StepSensor`");
            writableDatabase.execSQL("DELETE FROM `Settings`");
            writableDatabase.execSQL("DELETE FROM `PhoneNumber`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    public LocationDao locationDao() {
        LocationDao locationDao;
        if (this._locationDao != null) {
            return this._locationDao;
        }
        synchronized (this) {
            if (this._locationDao == null) {
                this._locationDao = new LocationDao_Impl(this);
            }
            locationDao = this._locationDao;
        }
        return locationDao;
    }

    public StepSensorDao stepSensorDao() {
        StepSensorDao stepSensorDao;
        if (this._stepSensorDao != null) {
            return this._stepSensorDao;
        }
        synchronized (this) {
            if (this._stepSensorDao == null) {
                this._stepSensorDao = new StepSensorDao_Impl(this);
            }
            stepSensorDao = this._stepSensorDao;
        }
        return stepSensorDao;
    }

    public SettingsDao settingsDao() {
        SettingsDao settingsDao;
        if (this._settingsDao != null) {
            return this._settingsDao;
        }
        synchronized (this) {
            if (this._settingsDao == null) {
                this._settingsDao = new SettingsDao_Impl(this);
            }
            settingsDao = this._settingsDao;
        }
        return settingsDao;
    }

    public PhoneBookDao phoneBookDao() {
        PhoneBookDao phoneBookDao;
        if (this._phoneBookDao != null) {
            return this._phoneBookDao;
        }
        synchronized (this) {
            if (this._phoneBookDao == null) {
                this._phoneBookDao = new PhoneBookDao_Impl(this);
            }
            phoneBookDao = this._phoneBookDao;
        }
        return phoneBookDao;
    }
}
