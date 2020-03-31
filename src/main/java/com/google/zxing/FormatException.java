package com.google.zxing;

public final class FormatException extends ReaderException {
    private static final FormatException instance = new FormatException();

    private FormatException() {
    }

    private FormatException(Throwable th) {
        super(th);
    }

    public static FormatException getFormatInstance() {
        if (isStackTrace) {
            return new FormatException();
        }
        return instance;
    }

    public static FormatException getFormatInstance(Throwable th) {
        if (isStackTrace) {
            return new FormatException(th);
        }
        return instance;
    }
}
