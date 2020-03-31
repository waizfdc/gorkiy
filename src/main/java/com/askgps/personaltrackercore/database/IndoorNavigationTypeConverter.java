package com.askgps.personaltrackercore.database;

import com.askgps.personaltrackercore.database.model.IndoorNavigation;
import com.google.gson.Gson;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/askgps/personaltrackercore/database/IndoorNavigationTypeConverter;", "", "()V", "fromIndoorNavigation", "", "indoorNavigation", "Lcom/askgps/personaltrackercore/database/model/IndoorNavigation;", "toIndoorNavigation", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: TypeConverters.kt */
public final class IndoorNavigationTypeConverter {
    public final String fromIndoorNavigation(IndoorNavigation indoorNavigation) {
        if (indoorNavigation == null) {
            return null;
        }
        return new Gson().toJson(indoorNavigation);
    }

    public final IndoorNavigation toIndoorNavigation(String str) {
        if (str == null) {
            return null;
        }
        return (IndoorNavigation) new Gson().fromJson(str, IndoorNavigation.class);
    }
}
