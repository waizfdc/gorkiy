package com.google.zxing;

public final class ChecksumException extends ReaderException {
    private static final ChecksumException instance = new ChecksumException();

    private ChecksumException() {
    }

    private ChecksumException(Throwable th) {
        super(th);
    }

    public static ChecksumException getChecksumInstance() {
        if (isStackTrace) {
            return new ChecksumException();
        }
        return instance;
    }

    public static ChecksumException getChecksumInstance(Throwable th) {
        if (isStackTrace) {
            return new ChecksumException(th);
        }
        return instance;
    }
}
