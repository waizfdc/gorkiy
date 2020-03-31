package com.askgps.personaltrackercore.database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.askgps.personaltrackercore.database.model.Location;
import java.util.ArrayList;
import java.util.List;

public final class LocationDao_Impl implements LocationDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<Location> __deletionAdapterOfLocation;
    /* access modifiers changed from: private */
    public final IndoorNavigationTypeConverter __indoorNavigationTypeConverter = new IndoorNavigationTypeConverter();
    private final EntityInsertionAdapter<Location> __insertionAdapterOfLocation;

    public LocationDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfLocation = new EntityInsertionAdapter<Location>(roomDatabase) {
            /* class com.askgps.personaltrackercore.database.LocationDao_Impl.AnonymousClass1 */

            public String createQuery() {
                return "INSERT OR IGNORE INTO `Location` (`imei`,`datetime`,`locationDatetime`,`lat`,`lon`,`altitude`,`accuracy`,`bearing`,`speed`,`provider`,`stepCount`,`isLeaveHand`,`batteryLevel`,`isFall`,`powerOn`,`sos`,`version`,`workShift`,`isValid`,`indoorNavigation`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Location location) {
                if (location.getImei() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, location.getImei());
                }
                supportSQLiteStatement.bindLong(2, location.getDatetime());
                if (location.getLocationDatetime() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindLong(3, location.getLocationDatetime().longValue());
                }
                if (location.getLat() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindDouble(4, location.getLat().doubleValue());
                }
                if (location.getLon() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindDouble(5, location.getLon().doubleValue());
                }
                if (location.getAltitude() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindDouble(6, (double) location.getAltitude().floatValue());
                }
                if (location.getAccuracy() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, (long) location.getAccuracy().intValue());
                }
                if (location.getBearing() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindLong(8, (long) location.getBearing().shortValue());
                }
                if (location.getSpeed() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindDouble(9, (double) location.getSpeed().floatValue());
                }
                if (location.getProvider() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, location.getProvider());
                }
                if (location.getStepCount() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, (long) location.getStepCount().intValue());
                }
                Integer num = null;
                Integer valueOf = location.isLeaveHand() == null ? null : Integer.valueOf(location.isLeaveHand().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindLong(12, (long) valueOf.intValue());
                }
                if (location.getBatteryLevel() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindLong(13, (long) location.getBatteryLevel().byteValue());
                }
                Integer valueOf2 = location.isFall() == null ? null : Integer.valueOf(location.isFall().booleanValue() ? 1 : 0);
                if (valueOf2 == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindLong(14, (long) valueOf2.intValue());
                }
                Integer valueOf3 = location.getPowerOn() == null ? null : Integer.valueOf(location.getPowerOn().booleanValue() ? 1 : 0);
                if (valueOf3 == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindLong(15, (long) valueOf3.intValue());
                }
                Integer valueOf4 = location.getSos() == null ? null : Integer.valueOf(location.getSos().booleanValue() ? 1 : 0);
                if (valueOf4 == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindLong(16, (long) valueOf4.intValue());
                }
                if (location.getVersion() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindLong(17, (long) location.getVersion().intValue());
                }
                Integer valueOf5 = location.getWorkShift() == null ? null : Integer.valueOf(location.getWorkShift().booleanValue() ? 1 : 0);
                if (valueOf5 == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindLong(18, (long) valueOf5.intValue());
                }
                if (location.isValid() != null) {
                    num = Integer.valueOf(location.isValid().booleanValue() ? 1 : 0);
                }
                if (num == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindLong(19, (long) num.intValue());
                }
                String fromIndoorNavigation = LocationDao_Impl.this.__indoorNavigationTypeConverter.fromIndoorNavigation(location.getIndoorNavigation());
                if (fromIndoorNavigation == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, fromIndoorNavigation);
                }
            }
        };
        this.__deletionAdapterOfLocation = new EntityDeletionOrUpdateAdapter<Location>(roomDatabase) {
            /* class com.askgps.personaltrackercore.database.LocationDao_Impl.AnonymousClass2 */

            public String createQuery() {
                return "DELETE FROM `Location` WHERE `datetime` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Location location) {
                supportSQLiteStatement.bindLong(1, location.getDatetime());
            }
        };
    }

    public void insertLocations(List<Location> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfLocation.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void removeLocation(List<Location> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfLocation.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public List<Location> getLocations() {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        Long l;
        Double d;
        Double d2;
        Float f;
        Integer num;
        Short sh;
        Float f2;
        Integer num2;
        Integer num3;
        Boolean bool;
        Byte b;
        int i;
        Integer num4;
        Boolean valueOf;
        Integer num5;
        Boolean valueOf2;
        Integer num6;
        Boolean valueOf3;
        Integer valueOf4;
        Integer num7;
        Boolean valueOf5;
        Integer num8;
        Boolean valueOf6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Location GROUP BY datetime;", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "imei");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "datetime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "locationDatetime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "lat");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "lon");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "altitude");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "accuracy");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "bearing");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "speed");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "provider");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "stepCount");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "isLeaveHand");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "batteryLevel");
            roomSQLiteQuery = acquire;
            try {
                columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "isFall");
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "powerOn");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "sos");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "version");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "workShift");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "isValid");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "indoorNavigation");
                int i2 = columnIndexOrThrow;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow2);
                    long j = query.getLong(columnIndexOrThrow3);
                    if (query.isNull(columnIndexOrThrow4)) {
                        l = null;
                    } else {
                        l = Long.valueOf(query.getLong(columnIndexOrThrow4));
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        d = null;
                    } else {
                        d = Double.valueOf(query.getDouble(columnIndexOrThrow5));
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        d2 = null;
                    } else {
                        d2 = Double.valueOf(query.getDouble(columnIndexOrThrow6));
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        f = null;
                    } else {
                        f = Float.valueOf(query.getFloat(columnIndexOrThrow7));
                    }
                    if (query.isNull(columnIndexOrThrow8)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                    }
                    if (query.isNull(columnIndexOrThrow9)) {
                        sh = null;
                    } else {
                        sh = Short.valueOf(query.getShort(columnIndexOrThrow9));
                    }
                    if (query.isNull(columnIndexOrThrow10)) {
                        f2 = null;
                    } else {
                        f2 = Float.valueOf(query.getFloat(columnIndexOrThrow10));
                    }
                    String string2 = query.getString(columnIndexOrThrow11);
                    if (query.isNull(columnIndexOrThrow12)) {
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(query.getInt(columnIndexOrThrow12));
                    }
                    if (query.isNull(columnIndexOrThrow13)) {
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(query.getInt(columnIndexOrThrow13));
                    }
                    boolean z = true;
                    if (num3 == null) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(num3.intValue() != 0);
                    }
                    if (query.isNull(columnIndexOrThrow14)) {
                        i = i2;
                        b = null;
                    } else {
                        b = Byte.valueOf((byte) query.getShort(columnIndexOrThrow14));
                        i = i2;
                    }
                    if (query.isNull(i)) {
                        num4 = null;
                    } else {
                        num4 = Integer.valueOf(query.getInt(i));
                    }
                    if (num4 == null) {
                        valueOf = null;
                    } else {
                        valueOf = Boolean.valueOf(num4.intValue() != 0);
                    }
                    int i3 = columnIndexOrThrow15;
                    int i4 = columnIndexOrThrow13;
                    int i5 = i3;
                    if (query.isNull(i5)) {
                        num5 = null;
                    } else {
                        num5 = Integer.valueOf(query.getInt(i5));
                    }
                    if (num5 == null) {
                        valueOf2 = null;
                    } else {
                        valueOf2 = Boolean.valueOf(num5.intValue() != 0);
                    }
                    int i6 = columnIndexOrThrow16;
                    int i7 = i5;
                    int i8 = i6;
                    if (query.isNull(i8)) {
                        num6 = null;
                    } else {
                        num6 = Integer.valueOf(query.getInt(i8));
                    }
                    if (num6 == null) {
                        valueOf3 = null;
                    } else {
                        valueOf3 = Boolean.valueOf(num6.intValue() != 0);
                    }
                    int i9 = columnIndexOrThrow17;
                    int i10 = i8;
                    int i11 = i9;
                    if (query.isNull(i11)) {
                        valueOf4 = null;
                    } else {
                        valueOf4 = Integer.valueOf(query.getInt(i11));
                    }
                    int i12 = columnIndexOrThrow18;
                    int i13 = i11;
                    int i14 = i12;
                    if (query.isNull(i14)) {
                        num7 = null;
                    } else {
                        num7 = Integer.valueOf(query.getInt(i14));
                    }
                    if (num7 == null) {
                        valueOf5 = null;
                    } else {
                        valueOf5 = Boolean.valueOf(num7.intValue() != 0);
                    }
                    int i15 = columnIndexOrThrow19;
                    int i16 = i14;
                    int i17 = i15;
                    if (query.isNull(i17)) {
                        num8 = null;
                    } else {
                        num8 = Integer.valueOf(query.getInt(i17));
                    }
                    if (num8 == null) {
                        i2 = i;
                        valueOf6 = null;
                    } else {
                        if (num8.intValue() == 0) {
                            z = false;
                        }
                        valueOf6 = Boolean.valueOf(z);
                        i2 = i;
                    }
                    int i18 = columnIndexOrThrow20;
                    int i19 = i17;
                    int i20 = i18;
                    int i21 = i20;
                    int i22 = columnIndexOrThrow14;
                    try {
                        arrayList.add(new Location(string, j, l, d, d2, f, num, sh, f2, string2, num2, bool, b, valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, this.__indoorNavigationTypeConverter.toIndoorNavigation(query.getString(i20))));
                        columnIndexOrThrow13 = i4;
                        columnIndexOrThrow15 = i7;
                        columnIndexOrThrow16 = i10;
                        columnIndexOrThrow17 = i13;
                        columnIndexOrThrow18 = i16;
                        columnIndexOrThrow19 = i19;
                        columnIndexOrThrow14 = i22;
                        columnIndexOrThrow20 = i21;
                    } catch (Throwable th2) {
                        th = th2;
                        query.close();
                        roomSQLiteQuery.release();
                        throw th;
                    }
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }
}
