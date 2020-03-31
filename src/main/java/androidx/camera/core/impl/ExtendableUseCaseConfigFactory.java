package androidx.camera.core.impl;

import androidx.camera.core.CameraInfo;
import java.util.HashMap;
import java.util.Map;

public final class ExtendableUseCaseConfigFactory implements UseCaseConfigFactory {
    private final Map<Class<?>, ConfigProvider<?>> mDefaultProviders = new HashMap();

    public <C extends Config> void installDefaultProvider(Class<C> cls, ConfigProvider<C> configProvider) {
        this.mDefaultProviders.put(cls, configProvider);
    }

    public <C extends UseCaseConfig<?>> C getConfig(Class<C> cls, CameraInfo cameraInfo) {
        ConfigProvider configProvider = this.mDefaultProviders.get(cls);
        if (configProvider != null) {
            return (UseCaseConfig) configProvider.getConfig(cameraInfo);
        }
        return null;
    }
}
