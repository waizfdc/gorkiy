package com.askgps.personaltrackercore.database;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.Dependency;
import com.askgps.personaltrackercore.database.model.StepSensor;

public final class StepSensorDao_Impl implements StepSensorDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<StepSensor> __insertionAdapterOfStepSensor;

    public StepSensorDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfStepSensor = new EntityInsertionAdapter<StepSensor>(roomDatabase) {
            /* class com.askgps.personaltrackercore.database.StepSensorDao_Impl.AnonymousClass1 */

            public String createQuery() {
                return "INSERT OR REPLACE INTO `StepSensor` (`lastSensorValue`,`stepsTimeStamp`,`stepsAtStartDay`,`stepCount`,`id`) VALUES (?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, StepSensor stepSensor) {
                supportSQLiteStatement.bindLong(1, (long) stepSensor.getLastSensorValue());
                supportSQLiteStatement.bindLong(2, stepSensor.getStepsTimeStamp());
                supportSQLiteStatement.bindLong(3, (long) stepSensor.getStepsAtStartDay());
                supportSQLiteStatement.bindLong(4, (long) stepSensor.getStepCount());
                supportSQLiteStatement.bindLong(5, (long) stepSensor.getId());
            }
        };
    }

    public void updateRow(StepSensor stepSensor) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfStepSensor.insert((Dependency) stepSensor);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public StepSensor getStepInfo() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM StepSensor WHERE id = 1", 0);
        this.__db.assertNotSuspendingTransaction();
        StepSensor stepSensor = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "lastSensorValue");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "stepsTimeStamp");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "stepsAtStartDay");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "stepCount");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "id");
            if (query.moveToFirst()) {
                stepSensor = new StepSensor(query.getInt(columnIndexOrThrow), query.getLong(columnIndexOrThrow2), query.getInt(columnIndexOrThrow3), query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5));
            }
            return stepSensor;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
