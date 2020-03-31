package io.fabric.sdk.android;

public class SilentLogger implements Logger {
    private int logLevel = 7;

    public void d(String str, String str2) {
    }

    public void d(String str, String str2, Throwable th) {
    }

    public void e(String str, String str2) {
    }

    public void e(String str, String str2, Throwable th) {
    }

    public void i(String str, String str2) {
    }

    public void i(String str, String str2, Throwable th) {
    }

    public boolean isLoggable(String str, int i) {
        return false;
    }

    public void log(int i, String str, String str2) {
    }

    public void log(int i, String str, String str2, boolean z) {
    }

    public void setLogLevel(int i) {
    }

    public void v(String str, String str2) {
    }

    public void v(String str, String str2, Throwable th) {
    }

    public void w(String str, String str2) {
    }

    public void w(String str, String str2, Throwable th) {
    }

    public int getLogLevel() {
        return this.logLevel;
    }
}
