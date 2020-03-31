package com.google.zxing;

public abstract class ReaderException extends Exception {
    protected static final boolean isStackTrace = (System.getProperty("surefire.test.class.path") != null);

    public final Throwable fillInStackTrace() {
        return null;
    }

    ReaderException() {
    }

    ReaderException(Throwable th) {
        super(th);
    }
}
