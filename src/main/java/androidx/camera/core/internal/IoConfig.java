package androidx.camera.core.internal;

import androidx.camera.core.impl.Config;
import java.util.concurrent.Executor;

public interface IoConfig {
    public static final Config.Option<Executor> OPTION_IO_EXECUTOR = Config.Option.create("camerax.core.io.ioExecutor", Executor.class);

    public interface Builder<B> {
        B setIoExecutor(Executor executor);
    }

    Executor getIoExecutor();

    Executor getIoExecutor(Executor executor);
}
