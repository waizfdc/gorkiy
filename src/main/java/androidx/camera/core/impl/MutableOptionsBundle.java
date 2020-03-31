package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import java.util.Comparator;
import java.util.TreeMap;

public final class MutableOptionsBundle extends OptionsBundle implements MutableConfig {
    private static final Comparator<Config.Option<?>> ID_COMPARE = new Comparator<Config.Option<?>>() {
        /* class androidx.camera.core.impl.MutableOptionsBundle.AnonymousClass1 */

        public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return compare((Config.Option<?>) ((Config.Option) obj), (Config.Option<?>) ((Config.Option) obj2));
        }

        public int compare(Config.Option<?> option, Config.Option<?> option2) {
            return option.getId().compareTo(option2.getId());
        }
    };

    private MutableOptionsBundle(TreeMap<Config.Option<?>, Object> treeMap) {
        super(treeMap);
    }

    public static MutableOptionsBundle create() {
        return new MutableOptionsBundle(new TreeMap(ID_COMPARE));
    }

    public static MutableOptionsBundle from(Config config) {
        TreeMap treeMap = new TreeMap(ID_COMPARE);
        for (Config.Option next : config.listOptions()) {
            treeMap.put(next, config.retrieveOption(next));
        }
        return new MutableOptionsBundle(treeMap);
    }

    public <ValueT> ValueT removeOption(Config.Option<ValueT> option) {
        return this.mOptions.remove(option);
    }

    public <ValueT> void insertOption(Config.Option<ValueT> option, ValueT valuet) {
        this.mOptions.put(option, valuet);
    }
}
