package com.askgps.personaltrackercore.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.askgps.personaltrackercore.BaseMainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/askgps/personaltrackercore/database/DatabaseHelper$Companion$MIGRATION_4_5$1", "Landroidx/room/migration/Migration;", "migrate", "", DatabaseHelper.DATABASE_NAME, "Landroidx/sqlite/db/SupportSQLiteDatabase;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DatabaseHelper.kt */
public final class DatabaseHelper$Companion$MIGRATION_4_5$1 extends Migration {
    DatabaseHelper$Companion$MIGRATION_4_5$1(int i, int i2) {
        super(i, i2);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkParameterIsNotNull(supportSQLiteDatabase, DatabaseHelper.DATABASE_NAME);
        supportSQLiteDatabase.beginTransaction();
        try {
            supportSQLiteDatabase.execSQL("ALTER TABLE Settings ADD COLUMN gaskarAddress TEXT NOT NULL DEFAULT `" + BaseMainActivity.Companion.getCustomer().getAddress() + "`;");
            supportSQLiteDatabase.execSQL("ALTER TABLE Settings ADD COLUMN locationInterval INTEGER NOT NULL DEFAULT " + BaseMainActivity.Companion.getLOCATION_INTERVAL() + ";");
            supportSQLiteDatabase.execSQL("ALTER TABLE Settings ADD COLUMN sendTelemetryInterval INTEGER NOT NULL DEFAULT " + BaseMainActivity.Companion.getTELEMETRY_SEND_INTERVAL() + ";");
            supportSQLiteDatabase.setTransactionSuccessful();
        } finally {
            supportSQLiteDatabase.endTransaction();
        }
    }
}
