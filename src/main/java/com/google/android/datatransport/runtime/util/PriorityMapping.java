package com.google.android.datatransport.runtime.util;

import android.util.SparseArray;
import com.google.android.datatransport.Priority;
import java.util.EnumMap;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class PriorityMapping {
    private static EnumMap<Priority, Integer> PRIORITY_INT_MAP;
    private static SparseArray<Priority> PRIORITY_MAP = new SparseArray<>();

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.EnumMap.put(java.lang.Enum, java.lang.Object):V}
     arg types: [com.google.android.datatransport.Priority, int]
     candidates:
      ClspMth{java.util.EnumMap.put(java.lang.Object, java.lang.Object):java.lang.Object}
      ClspMth{java.util.AbstractMap.put(com.google.android.datatransport.Priority, java.lang.Integer):V}
      ClspMth{java.util.Map.put(java.lang.Object, java.lang.Object):V}
      ClspMth{java.util.EnumMap.put(java.lang.Enum, java.lang.Object):V} */
    static {
        EnumMap<Priority, Integer> enumMap = new EnumMap<>(Priority.class);
        PRIORITY_INT_MAP = enumMap;
        enumMap.put((Enum) Priority.DEFAULT, (Object) 0);
        PRIORITY_INT_MAP.put((Enum) Priority.VERY_LOW, (Object) 1);
        PRIORITY_INT_MAP.put((Enum) Priority.HIGHEST, (Object) 2);
        for (Priority next : PRIORITY_INT_MAP.keySet()) {
            PRIORITY_MAP.append(PRIORITY_INT_MAP.get(next).intValue(), next);
        }
    }

    public static Priority valueOf(int i) {
        Priority priority = PRIORITY_MAP.get(i);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i);
    }

    public static int toInt(Priority priority) {
        Integer num = PRIORITY_INT_MAP.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }
}
