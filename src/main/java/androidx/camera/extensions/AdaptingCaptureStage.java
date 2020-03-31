package androidx.camera.extensions;

import android.hardware.camera2.CaptureRequest;
import android.util.Pair;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.extensions.impl.CaptureStageImpl;

final class AdaptingCaptureStage implements CaptureStage {
    private final CaptureConfig mCaptureRequestConfiguration;
    private final int mId;

    AdaptingCaptureStage(CaptureStageImpl captureStageImpl) {
        this.mId = captureStageImpl.getId();
        Camera2ImplConfig.Builder builder = new Camera2ImplConfig.Builder();
        for (Pair pair : captureStageImpl.getParameters()) {
            builder.setCaptureRequestOption((CaptureRequest.Key) pair.first, pair.second);
        }
        CaptureConfig.Builder builder2 = new CaptureConfig.Builder();
        builder2.addImplementationOptions(builder.build());
        builder2.setTag(Integer.valueOf(this.mId));
        this.mCaptureRequestConfiguration = builder2.build();
    }

    public int getId() {
        return this.mId;
    }

    public CaptureConfig getCaptureConfig() {
        return this.mCaptureRequestConfiguration;
    }
}
