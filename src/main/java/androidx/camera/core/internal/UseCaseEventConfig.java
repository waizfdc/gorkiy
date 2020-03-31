package androidx.camera.core.internal;

import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Config;

public interface UseCaseEventConfig {
    public static final Config.Option<UseCase.EventCallback> OPTION_USE_CASE_EVENT_CALLBACK = Config.Option.create("camerax.core.useCaseEventCallback", UseCase.EventCallback.class);

    public interface Builder<B> {
        B setUseCaseEventCallback(UseCase.EventCallback eventCallback);
    }

    UseCase.EventCallback getUseCaseEventCallback();

    UseCase.EventCallback getUseCaseEventCallback(UseCase.EventCallback eventCallback);
}
