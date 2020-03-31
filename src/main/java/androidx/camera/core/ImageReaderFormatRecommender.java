package androidx.camera.core;

final class ImageReaderFormatRecommender {
    private ImageReaderFormatRecommender() {
    }

    static FormatCombo chooseCombo() {
        return FormatCombo.create(256, 35);
    }

    static abstract class FormatCombo {
        /* access modifiers changed from: package-private */
        public abstract int imageAnalysisFormat();

        /* access modifiers changed from: package-private */
        public abstract int imageCaptureFormat();

        FormatCombo() {
        }

        static FormatCombo create(int i, int i2) {
            return new AutoValue_ImageReaderFormatRecommender_FormatCombo(i, i2);
        }
    }
}
