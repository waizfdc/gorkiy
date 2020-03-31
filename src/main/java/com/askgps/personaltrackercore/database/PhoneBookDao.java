package com.askgps.personaltrackercore.database;

import androidx.lifecycle.LiveData;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH'¨\u0006\n"}, d2 = {"Lcom/askgps/personaltrackercore/database/PhoneBookDao;", "", "addNumber", "", "phoneNumber", "Lcom/askgps/personaltrackercore/database/model/PhoneNumber;", "deleteNumber", "getNumbers", "Landroidx/lifecycle/LiveData;", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DatabaseHelper.kt */
public interface PhoneBookDao {
    void addNumber(PhoneNumber phoneNumber);

    void deleteNumber(PhoneNumber phoneNumber);

    LiveData<List<PhoneNumber>> getNumbers();
}
