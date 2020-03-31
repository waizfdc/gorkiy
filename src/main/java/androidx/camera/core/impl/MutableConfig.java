package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;

public interface MutableConfig extends Config {
    <ValueT> void insertOption(Config.Option<ValueT> option, ValueT valuet);

    <ValueT> ValueT removeOption(Config.Option<ValueT> option);
}
