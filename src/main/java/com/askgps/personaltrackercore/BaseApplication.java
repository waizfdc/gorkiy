package com.askgps.personaltrackercore;

import android.app.Application;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.CameraXConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/askgps/personaltrackercore/BaseApplication;", "Landroid/app/Application;", "Landroidx/camera/core/CameraXConfig$Provider;", "()V", "getCameraXConfig", "Landroidx/camera/core/CameraXConfig;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseApplication.kt */
public abstract class BaseApplication extends Application implements CameraXConfig.Provider {
    public CameraXConfig getCameraXConfig() {
        CameraXConfig defaultConfig = Camera2Config.defaultConfig();
        Intrinsics.checkExpressionValueIsNotNull(defaultConfig, "Camera2Config.defaultConfig()");
        return defaultConfig;
    }
}
