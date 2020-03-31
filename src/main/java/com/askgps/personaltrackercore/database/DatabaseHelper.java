package com.askgps.personaltrackercore.database;

import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/askgps/personaltrackercore/database/DatabaseHelper;", "Landroidx/room/RoomDatabase;", "()V", "locationDao", "Lcom/askgps/personaltrackercore/database/LocationDao;", "phoneBookDao", "Lcom/askgps/personaltrackercore/database/PhoneBookDao;", "settingsDao", "Lcom/askgps/personaltrackercore/database/SettingsDao;", "stepSensorDao", "Lcom/askgps/personaltrackercore/database/StepSensorDao;", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DatabaseHelper.kt */
public abstract class DatabaseHelper extends RoomDatabase {
    public static final Companion Companion = new Companion(null);
    public static final String DATABASE_NAME = "database";
    /* access modifiers changed from: private */
    public static final Migration[] MIGRATIONS;
    /* access modifiers changed from: private */
    public static final Migration MIGRATION_2_3 = new DatabaseHelper$Companion$MIGRATION_2_3$1(2, 3);
    /* access modifiers changed from: private */
    public static final Migration MIGRATION_3_4 = new DatabaseHelper$Companion$MIGRATION_3_4$1(3, 4);
    /* access modifiers changed from: private */
    public static final Migration MIGRATION_4_5 = new DatabaseHelper$Companion$MIGRATION_4_5$1(4, 5);
    /* access modifiers changed from: private */
    public static final Migration MIGRATION_5_6 = new DatabaseHelper$Companion$MIGRATION_5_6$1(5, 6);
    /* access modifiers changed from: private */
    public static final Migration MIGRATION_6_7 = new DatabaseHelper$Companion$MIGRATION_6_7$1(6, 7);
    /* access modifiers changed from: private */
    public static final Migration MIGRATION_7_8 = new DatabaseHelper$Companion$MIGRATION_7_8$1(7, 8);
    /* access modifiers changed from: private */
    public static final Migration MIGRATION_8_9;

    public abstract LocationDao locationDao();

    public abstract PhoneBookDao phoneBookDao();

    public abstract SettingsDao settingsDao();

    public abstract StepSensorDao stepSensorDao();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/askgps/personaltrackercore/database/DatabaseHelper$Companion;", "", "()V", "DATABASE_NAME", "", "MIGRATIONS", "", "Landroidx/room/migration/Migration;", "getMIGRATIONS", "()[Landroidx/room/migration/Migration;", "[Landroidx/room/migration/Migration;", "MIGRATION_2_3", "getMIGRATION_2_3", "()Landroidx/room/migration/Migration;", "MIGRATION_3_4", "getMIGRATION_3_4", "MIGRATION_4_5", "getMIGRATION_4_5", "MIGRATION_5_6", "getMIGRATION_5_6", "MIGRATION_6_7", "getMIGRATION_6_7", "MIGRATION_7_8", "getMIGRATION_7_8", "MIGRATION_8_9", "getMIGRATION_8_9", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DatabaseHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Migration getMIGRATION_2_3() {
            return DatabaseHelper.MIGRATION_2_3;
        }

        public final Migration getMIGRATION_3_4() {
            return DatabaseHelper.MIGRATION_3_4;
        }

        public final Migration getMIGRATION_4_5() {
            return DatabaseHelper.MIGRATION_4_5;
        }

        public final Migration getMIGRATION_5_6() {
            return DatabaseHelper.MIGRATION_5_6;
        }

        public final Migration getMIGRATION_6_7() {
            return DatabaseHelper.MIGRATION_6_7;
        }

        public final Migration getMIGRATION_7_8() {
            return DatabaseHelper.MIGRATION_7_8;
        }

        public final Migration getMIGRATION_8_9() {
            return DatabaseHelper.MIGRATION_8_9;
        }

        public final Migration[] getMIGRATIONS() {
            return DatabaseHelper.MIGRATIONS;
        }
    }

    static {
        Migration databaseHelper$Companion$MIGRATION_8_9$1 = new DatabaseHelper$Companion$MIGRATION_8_9$1(8, 9);
        MIGRATION_8_9 = databaseHelper$Companion$MIGRATION_8_9$1;
        MIGRATIONS = new Migration[]{MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6, MIGRATION_6_7, MIGRATION_7_8, databaseHelper$Companion$MIGRATION_8_9$1};
    }
}
