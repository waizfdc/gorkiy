package com.google.zxing.qrcode.decoder;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class ErrorCorrectionLevel extends Enum<ErrorCorrectionLevel> {
    private static final /* synthetic */ ErrorCorrectionLevel[] $VALUES;
    private static final ErrorCorrectionLevel[] FOR_BITS;
    public static final ErrorCorrectionLevel H;
    public static final ErrorCorrectionLevel L = new ErrorCorrectionLevel("L", 0, 1);
    public static final ErrorCorrectionLevel M = new ErrorCorrectionLevel("M", 1, 0);
    public static final ErrorCorrectionLevel Q = new ErrorCorrectionLevel("Q", 2, 3);
    private final int bits;

    public static ErrorCorrectionLevel valueOf(String str) {
        return (ErrorCorrectionLevel) Enum.valueOf(ErrorCorrectionLevel.class, str);
    }

    public static ErrorCorrectionLevel[] values() {
        return (ErrorCorrectionLevel[]) $VALUES.clone();
    }

    static {
        ErrorCorrectionLevel errorCorrectionLevel = new ErrorCorrectionLevel("H", 3, 2);
        H = errorCorrectionLevel;
        ErrorCorrectionLevel errorCorrectionLevel2 = L;
        ErrorCorrectionLevel errorCorrectionLevel3 = M;
        ErrorCorrectionLevel errorCorrectionLevel4 = Q;
        $VALUES = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel3, errorCorrectionLevel4, errorCorrectionLevel};
        FOR_BITS = new ErrorCorrectionLevel[]{errorCorrectionLevel3, errorCorrectionLevel2, errorCorrectionLevel, errorCorrectionLevel4};
    }

    private ErrorCorrectionLevel(String str, int i, int i2) {
        this.bits = i2;
    }

    public int getBits() {
        return this.bits;
    }

    public static ErrorCorrectionLevel forBits(int i) {
        if (i >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = FOR_BITS;
            if (i < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i];
            }
        }
        throw new IllegalArgumentException();
    }
}
