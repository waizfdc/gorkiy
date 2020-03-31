package androidx.camera.core.impl.utils;

import android.os.Looper;
import androidx.core.util.Preconditions;

public final class Threads {
    private Threads() {
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean isBackgroundThread() {
        return !isMainThread();
    }

    public static void checkMainThread() {
        Preconditions.checkState(isMainThread(), "Not in application's main thread");
    }

    public static void checkBackgroundThread() {
        Preconditions.checkState(isBackgroundThread(), "In application's main thread");
    }
}
