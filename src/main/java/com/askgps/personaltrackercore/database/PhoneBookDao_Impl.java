package com.askgps.personaltrackercore.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.Dependency;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class PhoneBookDao_Impl implements PhoneBookDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PhoneNumber> __deletionAdapterOfPhoneNumber;
    private final EntityInsertionAdapter<PhoneNumber> __insertionAdapterOfPhoneNumber;

    public PhoneBookDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfPhoneNumber = new EntityInsertionAdapter<PhoneNumber>(roomDatabase) {
            /* class com.askgps.personaltrackercore.database.PhoneBookDao_Impl.AnonymousClass1 */

            public String createQuery() {
                return "INSERT OR REPLACE INTO `PhoneNumber` (`name`,`number`) VALUES (?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, PhoneNumber phoneNumber) {
                if (phoneNumber.getName() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, phoneNumber.getName());
                }
                if (phoneNumber.getNumber() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, phoneNumber.getNumber());
                }
            }
        };
        this.__deletionAdapterOfPhoneNumber = new EntityDeletionOrUpdateAdapter<PhoneNumber>(roomDatabase) {
            /* class com.askgps.personaltrackercore.database.PhoneBookDao_Impl.AnonymousClass2 */

            public String createQuery() {
                return "DELETE FROM `PhoneNumber` WHERE `number` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, PhoneNumber phoneNumber) {
                if (phoneNumber.getNumber() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, phoneNumber.getNumber());
                }
            }
        };
    }

    public void addNumber(PhoneNumber phoneNumber) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPhoneNumber.insert((Dependency) phoneNumber);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteNumber(PhoneNumber phoneNumber) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPhoneNumber.handle(phoneNumber);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public LiveData<List<PhoneNumber>> getNumbers() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM PhoneNumber LIMIT 3", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PhoneNumber"}, false, new Callable<List<PhoneNumber>>() {
            /* class com.askgps.personaltrackercore.database.PhoneBookDao_Impl.AnonymousClass3 */

            public List<PhoneNumber> call() throws Exception {
                Cursor query = DBUtil.query(PhoneBookDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, AppMeasurementSdk.ConditionalUserProperty.NAME);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "number");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new PhoneNumber(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2)));
                    }
                    return arrayList;
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
