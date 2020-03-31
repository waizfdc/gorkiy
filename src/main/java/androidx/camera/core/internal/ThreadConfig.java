package androidx.camera.core.internal;

import androidx.camera.core.impl.Config;
import java.util.concurrent.Executor;

public interface ThreadConfig {
    public static final Config.Option<Executor> OPTION_BACKGROUND_EXECUTOR = Config.Option.create("camerax.core.thread.backgroundExecutor", Executor.class);

    public interface Builder<B> {
        B setBackgroundExecutor(Executor executor);
    }

    Executor getBackgroundExecutor();

    Executor getBackgroundExecutor(Executor executor);
}
