package com.google.firebase.installations;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: com.google.firebase:firebase-installations@@16.0.0 */
class CrossProcessLock {
    private final FileChannel channel;
    private final FileLock lock;

    private CrossProcessLock(FileChannel fileChannel, FileLock fileLock) {
        this.channel = fileChannel;
        this.lock = fileLock;
    }

    static CrossProcessLock acquire(Context context, String str) {
        try {
            FileChannel channel2 = new RandomAccessFile(new File(context.getFilesDir(), str), "rw").getChannel();
            return new CrossProcessLock(channel2, channel2.lock());
        } catch (IOException e) {
            throw new IllegalStateException("exception while using file locks, should never happen", e);
        }
    }

    /* access modifiers changed from: package-private */
    public void releaseAndClose() {
        try {
            this.lock.release();
            this.channel.close();
        } catch (IOException e) {
            throw new IllegalStateException("exception while using file locks, should never happen", e);
        }
    }
}
