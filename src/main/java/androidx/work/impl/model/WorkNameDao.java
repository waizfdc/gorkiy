package androidx.work.impl.model;

import java.util.List;

public interface WorkNameDao {
    List<String> getWorkSpecIdsWithName(String str);

    void insert(WorkName workName);
}
