package com.askgps.personaltrackercore.database;

import com.askgps.personaltrackercore.database.model.Location;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0016\u0010\b\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'¨\u0006\t"}, d2 = {"Lcom/askgps/personaltrackercore/database/LocationDao;", "", "getLocations", "", "Lcom/askgps/personaltrackercore/database/model/Location;", "insertLocations", "", "items", "removeLocation", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DatabaseHelper.kt */
public interface LocationDao {
    List<Location> getLocations();

    void insertLocations(List<Location> list);

    void removeLocation(List<Location> list);
}
