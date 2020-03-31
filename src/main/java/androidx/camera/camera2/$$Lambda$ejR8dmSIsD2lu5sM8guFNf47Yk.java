package androidx.camera.camera2;

import android.content.Context;
import androidx.camera.camera2.internal.Camera2CameraFactory;
import androidx.camera.core.impl.CameraFactory;

/* renamed from: androidx.camera.camera2.-$$Lambda$ejR8dmSIsD2lu5sM8guFNf47-Yk  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ejR8dmSIsD2lu5sM8guFNf47Yk implements CameraFactory.Provider {
    public static final /* synthetic */ $$Lambda$ejR8dmSIsD2lu5sM8guFNf47Yk INSTANCE = new $$Lambda$ejR8dmSIsD2lu5sM8guFNf47Yk();

    private /* synthetic */ $$Lambda$ejR8dmSIsD2lu5sM8guFNf47Yk() {
    }

    public final CameraFactory newInstance(Context context) {
        return new Camera2CameraFactory(context);
    }
}
