package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureMetaData;

public interface CameraCaptureResult {
    CameraCaptureMetaData.AeState getAeState();

    CameraCaptureMetaData.AfMode getAfMode();

    CameraCaptureMetaData.AfState getAfState();

    CameraCaptureMetaData.AwbState getAwbState();

    CameraCaptureMetaData.FlashState getFlashState();

    Object getTag();

    long getTimestamp();

    public static final class EmptyCameraCaptureResult implements CameraCaptureResult {
        public Object getTag() {
            return null;
        }

        public long getTimestamp() {
            return -1;
        }

        public static CameraCaptureResult create() {
            return new EmptyCameraCaptureResult();
        }

        public CameraCaptureMetaData.AfMode getAfMode() {
            return CameraCaptureMetaData.AfMode.UNKNOWN;
        }

        public CameraCaptureMetaData.AfState getAfState() {
            return CameraCaptureMetaData.AfState.UNKNOWN;
        }

        public CameraCaptureMetaData.AeState getAeState() {
            return CameraCaptureMetaData.AeState.UNKNOWN;
        }

        public CameraCaptureMetaData.AwbState getAwbState() {
            return CameraCaptureMetaData.AwbState.UNKNOWN;
        }

        public CameraCaptureMetaData.FlashState getFlashState() {
            return CameraCaptureMetaData.FlashState.UNKNOWN;
        }
    }
}
