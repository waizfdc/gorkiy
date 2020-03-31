package com.askgps.personaltrackercore.database;

import com.askgps.personaltrackercore.database.model.StepSensor;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H'¨\u0006\u0007"}, d2 = {"Lcom/askgps/personaltrackercore/database/StepSensorDao;", "", "getStepInfo", "Lcom/askgps/personaltrackercore/database/model/StepSensor;", "updateRow", "", "item", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DatabaseHelper.kt */
public interface StepSensorDao {
    StepSensor getStepInfo();

    void updateRow(StepSensor stepSensor);
}
