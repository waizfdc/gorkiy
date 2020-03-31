package androidx.camera.core.internal;

import androidx.camera.core.impl.Config;

public interface TargetConfig<T> {
    public static final Config.Option<Class<?>> OPTION_TARGET_CLASS = Config.Option.create("camerax.core.target.class", Class.class);
    public static final Config.Option<String> OPTION_TARGET_NAME = Config.Option.create("camerax.core.target.name", String.class);

    public interface Builder<T, B> {
        B setTargetClass(Class cls);

        B setTargetName(String str);
    }

    Class<T> getTargetClass();

    Class<T> getTargetClass(Class<T> cls);

    String getTargetName();

    String getTargetName(String str);
}
