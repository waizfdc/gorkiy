package androidx.work.impl;

import androidx.work.impl.model.WorkSpec;

public interface Scheduler {
    public static final int MAX_SCHEDULER_LIMIT = 50;

    void cancel(String str);

    void schedule(WorkSpec... workSpecArr);
}
