package androidx.work;

import androidx.work.Data;
import java.util.HashMap;
import java.util.List;

public final class OverwritingInputMerger extends InputMerger {
    public Data merge(List<Data> list) {
        Data.Builder builder = new Data.Builder();
        HashMap hashMap = new HashMap();
        for (Data keyValueMap : list) {
            hashMap.putAll(keyValueMap.getKeyValueMap());
        }
        builder.putAll(hashMap);
        return builder.build();
    }
}
