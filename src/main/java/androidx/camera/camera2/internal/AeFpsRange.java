package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;

final class AeFpsRange {
    private Range<Integer> mAeTargetFpsRange = null;

    AeFpsRange(CameraCharacteristics cameraCharacteristics) {
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num != null && num.intValue() == 2) {
            this.mAeTargetFpsRange = pickSuitableFpsRange((Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
        }
    }

    public void addAeFpsRangeOptions(Camera2ImplConfig.Builder builder) {
        if (this.mAeTargetFpsRange != null) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, this.mAeTargetFpsRange);
        }
    }

    private static Range<Integer> getCorrectedFpsRange(Range<Integer> range) {
        int intValue = range.getUpper().intValue();
        int intValue2 = range.getLower().intValue();
        if (range.getUpper().intValue() >= 1000) {
            intValue = range.getUpper().intValue() / 1000;
        }
        if (range.getLower().intValue() >= 1000) {
            intValue2 = range.getLower().intValue() / 1000;
        }
        return new Range<>(Integer.valueOf(intValue2), Integer.valueOf(intValue));
    }

    private static Range<Integer> pickSuitableFpsRange(Range<Integer>[] rangeArr) {
        Range<Integer> range = null;
        if (!(rangeArr == null || rangeArr.length == 0)) {
            for (Range<Integer> correctedFpsRange : rangeArr) {
                Range<Integer> correctedFpsRange2 = getCorrectedFpsRange(correctedFpsRange);
                if (correctedFpsRange2.getUpper().intValue() == 30 && (range == null || correctedFpsRange2.getLower().intValue() < range.getLower().intValue())) {
                    range = correctedFpsRange2;
                }
            }
        }
        return range;
    }
}
