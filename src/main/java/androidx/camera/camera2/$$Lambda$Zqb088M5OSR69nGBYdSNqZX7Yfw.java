package androidx.camera.camera2;

import android.content.Context;
import androidx.camera.camera2.internal.Camera2DeviceSurfaceManager;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;

/* renamed from: androidx.camera.camera2.-$$Lambda$Zqb088M5OSR69nGBYdSNqZX7Yfw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Zqb088M5OSR69nGBYdSNqZX7Yfw implements CameraDeviceSurfaceManager.Provider {
    public static final /* synthetic */ $$Lambda$Zqb088M5OSR69nGBYdSNqZX7Yfw INSTANCE = new $$Lambda$Zqb088M5OSR69nGBYdSNqZX7Yfw();

    private /* synthetic */ $$Lambda$Zqb088M5OSR69nGBYdSNqZX7Yfw() {
    }

    public final CameraDeviceSurfaceManager newInstance(Context context) {
        return new Camera2DeviceSurfaceManager(context);
    }
}
