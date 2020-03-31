package com.crashlytics.android.core;

import android.os.AsyncTask;
import androidx.exifinterface.media.ExifInterface;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import okhttp3.internal.cache.DiskLruCache;

public class CrashTest {
    public void throwRuntimeException(String str) {
        throw new RuntimeException(str);
    }

    public int stackOverflow() {
        return stackOverflow() + ((int) Math.random());
    }

    public void indexOutOfBounds() {
        int i = new int[2][10];
        Logger logger = Fabric.getLogger();
        logger.d(CrashlyticsCore.TAG, "Out of bounds value: " + i);
    }

    public void crashAsyncTask(final long j) {
        new AsyncTask<Void, Void, Void>() {
            /* class com.crashlytics.android.core.CrashTest.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                try {
                    Thread.sleep(j);
                } catch (InterruptedException unused) {
                }
                CrashTest.this.throwRuntimeException("Background thread crash");
                return null;
            }
        }.execute(null);
    }

    public void throwFiveChainedExceptions() {
        try {
            privateMethodThatThrowsException(DiskLruCache.VERSION_1);
        } catch (Exception e) {
            throw new RuntimeException(ExifInterface.GPS_MEASUREMENT_2D, e);
        } catch (Exception e2) {
            try {
                throw new RuntimeException(ExifInterface.GPS_MEASUREMENT_3D, e2);
            } catch (Exception e3) {
                try {
                    throw new RuntimeException("4", e3);
                } catch (Exception e4) {
                    throw new RuntimeException("5", e4);
                }
            }
        }
    }

    private void privateMethodThatThrowsException(String str) {
        throw new RuntimeException(str);
    }
}
