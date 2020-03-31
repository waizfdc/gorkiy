package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.QueueFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueFileEventStorage implements EventsStorage {
    private final Context context;
    private QueueFile queueFile = new QueueFile(this.workingFile);
    private File targetDirectory;
    private final String targetDirectoryName;
    private final File workingDirectory;
    private final File workingFile;

    public QueueFileEventStorage(Context context2, File file, String str, String str2) throws IOException {
        this.context = context2;
        this.workingDirectory = file;
        this.targetDirectoryName = str2;
        this.workingFile = new File(this.workingDirectory, str);
        createTargetDirectory();
    }

    private void createTargetDirectory() {
        File file = new File(this.workingDirectory, this.targetDirectoryName);
        this.targetDirectory = file;
        if (!file.exists()) {
            this.targetDirectory.mkdirs();
        }
    }

    public void add(byte[] bArr) throws IOException {
        this.queueFile.add(bArr);
    }

    public int getWorkingFileUsedSizeInBytes() {
        return this.queueFile.usedBytes();
    }

    public void rollOver(String str) throws IOException {
        this.queueFile.close();
        move(this.workingFile, new File(this.targetDirectory, str));
        this.queueFile = new QueueFile(this.workingFile);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable, java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void move(java.io.File r6, java.io.File r7) throws java.io.IOException {
        /*
            r5 = this;
            java.lang.String r0 = "Failed to close output stream"
            java.lang.String r1 = "Failed to close file input stream"
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0024 }
            r3.<init>(r6)     // Catch:{ all -> 0x0024 }
            java.io.OutputStream r2 = r5.getMoveOutputStream(r7)     // Catch:{ all -> 0x001f }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x001f }
            io.fabric.sdk.android.services.common.CommonUtils.copyStream(r3, r2, r7)     // Catch:{ all -> 0x001f }
            io.fabric.sdk.android.services.common.CommonUtils.closeOrLog(r3, r1)
            io.fabric.sdk.android.services.common.CommonUtils.closeOrLog(r2, r0)
            r6.delete()
            return
        L_0x001f:
            r7 = move-exception
            r4 = r3
            r3 = r2
            r2 = r4
            goto L_0x0026
        L_0x0024:
            r7 = move-exception
            r3 = r2
        L_0x0026:
            io.fabric.sdk.android.services.common.CommonUtils.closeOrLog(r2, r1)
            io.fabric.sdk.android.services.common.CommonUtils.closeOrLog(r3, r0)
            r6.delete()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.events.QueueFileEventStorage.move(java.io.File, java.io.File):void");
    }

    public OutputStream getMoveOutputStream(File file) throws IOException {
        return new FileOutputStream(file);
    }

    public File getWorkingDirectory() {
        return this.workingDirectory;
    }

    public File getRollOverDirectory() {
        return this.targetDirectory;
    }

    public List<File> getBatchOfFilesToSend(int i) {
        ArrayList arrayList = new ArrayList();
        for (File add : this.targetDirectory.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    public void deleteFilesInRollOverDirectory(List<File> list) {
        for (File next : list) {
            CommonUtils.logControlled(this.context, String.format("deleting sent analytics file %s", next.getName()));
            next.delete();
        }
    }

    public List<File> getAllFilesInRollOverDirectory() {
        return Arrays.asList(this.targetDirectory.listFiles());
    }

    public void deleteWorkingFile() {
        try {
            this.queueFile.close();
        } catch (IOException unused) {
        }
        this.workingFile.delete();
    }

    public boolean isWorkingFileEmpty() {
        return this.queueFile.isEmpty();
    }

    public boolean canWorkingFileStore(int i, int i2) {
        return this.queueFile.hasSpaceFor(i, i2);
    }
}
