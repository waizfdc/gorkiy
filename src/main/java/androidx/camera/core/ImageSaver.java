package androidx.camera.core;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageSaver;
import java.util.concurrent.Executor;

final class ImageSaver implements Runnable {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TAG = "ImageSaver";
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";
    final OnImageSavedCallback mCallback;
    private final Executor mExecutor;
    private final ImageProxy mImage;
    private final int mOrientation;
    private final ImageCapture.OutputFileOptions mOutputFileOptions;

    public interface OnImageSavedCallback {
        void onError(SaveError saveError, String str, Throwable th);

        void onImageSaved(ImageCapture.OutputFileResults outputFileResults);
    }

    public enum SaveError {
        FILE_IO_FAILED,
        ENCODE_FAILED,
        CROP_FAILED,
        UNKNOWN
    }

    ImageSaver(ImageProxy imageProxy, ImageCapture.OutputFileOptions outputFileOptions, int i, Executor executor, OnImageSavedCallback onImageSavedCallback) {
        this.mImage = imageProxy;
        this.mOutputFileOptions = outputFileOptions;
        this.mOrientation = i;
        this.mCallback = onImageSavedCallback;
        this.mExecutor = executor;
    }

    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:70:0x0110 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:45:0x00e8 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v23, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ef, code lost:
        if (isSaveToFile() == false) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f1, code lost:
        r0.delete();
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0108, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0109, code lost:
        if (r3 != null) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x010f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r2.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0114, code lost:
        r2 = e;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0116, code lost:
        r1 = move-exception;
        r5 = r5;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x012c, code lost:
        if (r3 != 2) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x012e, code lost:
        r1 = androidx.camera.core.ImageSaver.SaveError.UNKNOWN;
        r3 = "Failed to transcode mImage";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0133, code lost:
        r1 = androidx.camera.core.ImageSaver.SaveError.CROP_FAILED;
        r3 = "Failed to crop mImage";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0138, code lost:
        r1 = androidx.camera.core.ImageSaver.SaveError.ENCODE_FAILED;
        r3 = "Failed to encode mImage";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0142, code lost:
        if (isSaveToFile() == false) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0150, code lost:
        if (isSaveToFile() == false) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0153, code lost:
        if (r6 == null) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0155, code lost:
        postError(r6, r7, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0159, code lost:
        postSuccess(r5);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:45:0x00e8, B:63:0x0107, B:67:0x010b] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x012b A[Catch:{ all -> 0x0118 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0138 A[Catch:{ all -> 0x0118 }] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r10 = this;
            boolean r0 = r10.isSaveToFile()     // Catch:{ IOException -> 0x0167 }
            if (r0 == 0) goto L_0x000d
            androidx.camera.core.ImageCapture$OutputFileOptions r0 = r10.mOutputFileOptions     // Catch:{ IOException -> 0x0167 }
            java.io.File r0 = r0.getFile()     // Catch:{ IOException -> 0x0167 }
            goto L_0x0015
        L_0x000d:
            java.lang.String r0 = "CameraX"
            java.lang.String r1 = ".tmp"
            java.io.File r0 = java.io.File.createTempFile(r0, r1)     // Catch:{ IOException -> 0x0167 }
        L_0x0015:
            r1 = 1
            r2 = 0
            androidx.camera.core.ImageProxy r3 = r10.mImage     // Catch:{ IOException -> 0x0145, CodecFailedException -> 0x011a }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0104 }
            r4.<init>(r0)     // Catch:{ all -> 0x0104 }
            androidx.camera.core.ImageProxy r5 = r10.mImage     // Catch:{ all -> 0x00f8 }
            byte[] r5 = androidx.camera.core.ImageUtil.imageToJpegByteArray(r5)     // Catch:{ all -> 0x00f8 }
            r4.write(r5)     // Catch:{ all -> 0x00f8 }
            androidx.camera.core.impl.utils.Exif r5 = androidx.camera.core.impl.utils.Exif.createFromFile(r0)     // Catch:{ all -> 0x00f8 }
            r5.attachTimestamp()     // Catch:{ all -> 0x00f8 }
            androidx.camera.core.ImageProxy r6 = r10.mImage     // Catch:{ all -> 0x00f8 }
            int r6 = r6.getFormat()     // Catch:{ all -> 0x00f8 }
            r7 = 256(0x100, float:3.59E-43)
            r8 = 0
            if (r6 != r7) goto L_0x0062
            androidx.camera.core.ImageProxy r6 = r10.mImage     // Catch:{ all -> 0x00f8 }
            androidx.camera.core.ImageProxy$PlaneProxy[] r6 = r6.getPlanes()     // Catch:{ all -> 0x00f8 }
            r6 = r6[r8]     // Catch:{ all -> 0x00f8 }
            java.nio.ByteBuffer r6 = r6.getBuffer()     // Catch:{ all -> 0x00f8 }
            r6.rewind()     // Catch:{ all -> 0x00f8 }
            int r7 = r6.capacity()     // Catch:{ all -> 0x00f8 }
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x00f8 }
            r6.get(r7)     // Catch:{ all -> 0x00f8 }
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x00f8 }
            r6.<init>(r7)     // Catch:{ all -> 0x00f8 }
            androidx.camera.core.impl.utils.Exif r6 = androidx.camera.core.impl.utils.Exif.createFromInputStream(r6)     // Catch:{ all -> 0x00f8 }
            int r6 = r6.getOrientation()     // Catch:{ all -> 0x00f8 }
            r5.setOrientation(r6)     // Catch:{ all -> 0x00f8 }
            goto L_0x0067
        L_0x0062:
            int r6 = r10.mOrientation     // Catch:{ all -> 0x00f8 }
            r5.rotate(r6)     // Catch:{ all -> 0x00f8 }
        L_0x0067:
            androidx.camera.core.ImageCapture$OutputFileOptions r6 = r10.mOutputFileOptions     // Catch:{ all -> 0x00f8 }
            androidx.camera.core.ImageCapture$Metadata r6 = r6.getMetadata()     // Catch:{ all -> 0x00f8 }
            boolean r7 = r6.isReversedHorizontal()     // Catch:{ all -> 0x00f8 }
            if (r7 == 0) goto L_0x0076
            r5.flipHorizontally()     // Catch:{ all -> 0x00f8 }
        L_0x0076:
            boolean r7 = r6.isReversedVertical()     // Catch:{ all -> 0x00f8 }
            if (r7 == 0) goto L_0x007f
            r5.flipVertically()     // Catch:{ all -> 0x00f8 }
        L_0x007f:
            android.location.Location r6 = r6.getLocation()     // Catch:{ all -> 0x00f8 }
            if (r6 == 0) goto L_0x0092
            androidx.camera.core.ImageCapture$OutputFileOptions r6 = r10.mOutputFileOptions     // Catch:{ all -> 0x00f8 }
            androidx.camera.core.ImageCapture$Metadata r6 = r6.getMetadata()     // Catch:{ all -> 0x00f8 }
            android.location.Location r6 = r6.getLocation()     // Catch:{ all -> 0x00f8 }
            r5.attachLocation(r6)     // Catch:{ all -> 0x00f8 }
        L_0x0092:
            r5.save()     // Catch:{ all -> 0x00f8 }
            boolean r5 = r10.isSaveToMediaStore()     // Catch:{ all -> 0x00f8 }
            if (r5 == 0) goto L_0x00d1
            androidx.camera.core.ImageCapture$OutputFileOptions r5 = r10.mOutputFileOptions     // Catch:{ all -> 0x00f8 }
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ all -> 0x00f8 }
            androidx.camera.core.ImageCapture$OutputFileOptions r6 = r10.mOutputFileOptions     // Catch:{ all -> 0x00f8 }
            android.net.Uri r6 = r6.getSaveCollection()     // Catch:{ all -> 0x00f8 }
            androidx.camera.core.ImageCapture$OutputFileOptions r7 = r10.mOutputFileOptions     // Catch:{ all -> 0x00f8 }
            android.content.ContentValues r7 = r7.getContentValues()     // Catch:{ all -> 0x00f8 }
            android.net.Uri r5 = r5.insert(r6, r7)     // Catch:{ all -> 0x00f8 }
            if (r5 != 0) goto L_0x00b8
            androidx.camera.core.ImageSaver$SaveError r6 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ all -> 0x00cc }
            java.lang.String r7 = "Failed to insert URI."
            goto L_0x00e3
        L_0x00b8:
            r10.setUriPending(r5, r1)     // Catch:{ all -> 0x00cc }
            boolean r6 = r10.copyTempFileToUri(r0, r5)     // Catch:{ all -> 0x00cc }
            if (r6 != 0) goto L_0x00c6
            androidx.camera.core.ImageSaver$SaveError r6 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ all -> 0x00cc }
            java.lang.String r7 = "Failed to save to URI."
            goto L_0x00c8
        L_0x00c6:
            r6 = r2
            r7 = r6
        L_0x00c8:
            r10.setUriPending(r5, r8)     // Catch:{ all -> 0x00cc }
            goto L_0x00e3
        L_0x00cc:
            r2 = move-exception
            r9 = r5
            r5 = r2
            r2 = r9
            goto L_0x00f9
        L_0x00d1:
            boolean r5 = r10.isSaveToOutputStream()     // Catch:{ all -> 0x00f8 }
            if (r5 == 0) goto L_0x00e0
            androidx.camera.core.ImageCapture$OutputFileOptions r5 = r10.mOutputFileOptions     // Catch:{ all -> 0x00f8 }
            java.io.OutputStream r5 = r5.getOutputStream()     // Catch:{ all -> 0x00f8 }
            r10.copyTempFileToOutputStream(r0, r5)     // Catch:{ all -> 0x00f8 }
        L_0x00e0:
            r5 = r2
            r6 = r5
            r7 = r6
        L_0x00e3:
            r4.close()     // Catch:{ all -> 0x00f6 }
            if (r3 == 0) goto L_0x00eb
            r3.close()     // Catch:{ IOException -> 0x0116, CodecFailedException -> 0x0114 }
        L_0x00eb:
            boolean r1 = r10.isSaveToFile()
            if (r1 != 0) goto L_0x0153
        L_0x00f1:
            r0.delete()
            goto L_0x0153
        L_0x00f6:
            r2 = move-exception
            goto L_0x0107
        L_0x00f8:
            r5 = move-exception
        L_0x00f9:
            throw r5     // Catch:{ all -> 0x00fa }
        L_0x00fa:
            r6 = move-exception
            r4.close()     // Catch:{ all -> 0x00ff }
            goto L_0x0103
        L_0x00ff:
            r4 = move-exception
            r5.addSuppressed(r4)     // Catch:{ all -> 0x0104 }
        L_0x0103:
            throw r6     // Catch:{ all -> 0x0104 }
        L_0x0104:
            r4 = move-exception
            r5 = r2
            r2 = r4
        L_0x0107:
            throw r2     // Catch:{ all -> 0x0108 }
        L_0x0108:
            r4 = move-exception
            if (r3 == 0) goto L_0x0113
            r3.close()     // Catch:{ all -> 0x010f }
            goto L_0x0113
        L_0x010f:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch:{ IOException -> 0x0116, CodecFailedException -> 0x0114 }
        L_0x0113:
            throw r4     // Catch:{ IOException -> 0x0116, CodecFailedException -> 0x0114 }
        L_0x0114:
            r2 = move-exception
            goto L_0x011d
        L_0x0116:
            r1 = move-exception
            goto L_0x0147
        L_0x0118:
            r1 = move-exception
            goto L_0x015d
        L_0x011a:
            r3 = move-exception
            r5 = r2
            r2 = r3
        L_0x011d:
            int[] r3 = androidx.camera.core.ImageSaver.AnonymousClass1.$SwitchMap$androidx$camera$core$ImageUtil$CodecFailedException$FailureType     // Catch:{ all -> 0x0118 }
            androidx.camera.core.ImageUtil$CodecFailedException$FailureType r4 = r2.getFailureType()     // Catch:{ all -> 0x0118 }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x0118 }
            r3 = r3[r4]     // Catch:{ all -> 0x0118 }
            if (r3 == r1) goto L_0x0138
            r1 = 2
            if (r3 == r1) goto L_0x0133
            androidx.camera.core.ImageSaver$SaveError r1 = androidx.camera.core.ImageSaver.SaveError.UNKNOWN     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = "Failed to transcode mImage"
            goto L_0x013c
        L_0x0133:
            androidx.camera.core.ImageSaver$SaveError r1 = androidx.camera.core.ImageSaver.SaveError.CROP_FAILED     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = "Failed to crop mImage"
            goto L_0x013c
        L_0x0138:
            androidx.camera.core.ImageSaver$SaveError r1 = androidx.camera.core.ImageSaver.SaveError.ENCODE_FAILED     // Catch:{ all -> 0x0118 }
            java.lang.String r3 = "Failed to encode mImage"
        L_0x013c:
            r6 = r1
            r7 = r3
            boolean r1 = r10.isSaveToFile()
            if (r1 != 0) goto L_0x0153
            goto L_0x00f1
        L_0x0145:
            r1 = move-exception
            r5 = r2
        L_0x0147:
            r2 = r1
            androidx.camera.core.ImageSaver$SaveError r6 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ all -> 0x0118 }
            java.lang.String r7 = "Failed to write or close the file"
            boolean r1 = r10.isSaveToFile()
            if (r1 != 0) goto L_0x0153
            goto L_0x00f1
        L_0x0153:
            if (r6 == 0) goto L_0x0159
            r10.postError(r6, r7, r2)
            goto L_0x015c
        L_0x0159:
            r10.postSuccess(r5)
        L_0x015c:
            return
        L_0x015d:
            boolean r2 = r10.isSaveToFile()
            if (r2 != 0) goto L_0x0166
            r0.delete()
        L_0x0166:
            throw r1
        L_0x0167:
            r0 = move-exception
            androidx.camera.core.ImageSaver$SaveError r1 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED
            java.lang.String r2 = "Failed to create temp file"
            r10.postError(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageSaver.run():void");
    }

    /* renamed from: androidx.camera.core.ImageSaver$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$ImageUtil$CodecFailedException$FailureType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.camera.core.ImageUtil$CodecFailedException$FailureType[] r0 = androidx.camera.core.ImageUtil.CodecFailedException.FailureType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.camera.core.ImageSaver.AnonymousClass1.$SwitchMap$androidx$camera$core$ImageUtil$CodecFailedException$FailureType = r0
                androidx.camera.core.ImageUtil$CodecFailedException$FailureType r1 = androidx.camera.core.ImageUtil.CodecFailedException.FailureType.ENCODE_FAILED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = androidx.camera.core.ImageSaver.AnonymousClass1.$SwitchMap$androidx$camera$core$ImageUtil$CodecFailedException$FailureType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.ImageUtil$CodecFailedException$FailureType r1 = androidx.camera.core.ImageUtil.CodecFailedException.FailureType.DECODE_FAILED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = androidx.camera.core.ImageSaver.AnonymousClass1.$SwitchMap$androidx$camera$core$ImageUtil$CodecFailedException$FailureType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.core.ImageUtil$CodecFailedException$FailureType r1 = androidx.camera.core.ImageUtil.CodecFailedException.FailureType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageSaver.AnonymousClass1.<clinit>():void");
        }
    }

    private boolean isSaveToMediaStore() {
        return (this.mOutputFileOptions.getSaveCollection() == null || this.mOutputFileOptions.getContentResolver() == null || this.mOutputFileOptions.getContentValues() == null) ? false : true;
    }

    private boolean isSaveToFile() {
        return this.mOutputFileOptions.getFile() != null;
    }

    private boolean isSaveToOutputStream() {
        return this.mOutputFileOptions.getOutputStream() != null;
    }

    private void setUriPending(Uri uri, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_pending", Integer.valueOf(i));
            this.mOutputFileOptions.getContentResolver().update(uri, contentValues, null, null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        if (r3 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        r2.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean copyTempFileToUri(java.io.File r2, android.net.Uri r3) throws java.io.IOException {
        /*
            r1 = this;
            androidx.camera.core.ImageCapture$OutputFileOptions r0 = r1.mOutputFileOptions
            android.content.ContentResolver r0 = r0.getContentResolver()
            java.io.OutputStream r3 = r0.openOutputStream(r3)
            if (r3 != 0) goto L_0x0013
            r2 = 0
            if (r3 == 0) goto L_0x0012
            r3.close()
        L_0x0012:
            return r2
        L_0x0013:
            r1.copyTempFileToOutputStream(r2, r3)     // Catch:{ all -> 0x001d }
            if (r3 == 0) goto L_0x001b
            r3.close()
        L_0x001b:
            r2 = 1
            return r2
        L_0x001d:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001f }
        L_0x001f:
            r0 = move-exception
            if (r3 == 0) goto L_0x002a
            r3.close()     // Catch:{ all -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r3 = move-exception
            r2.addSuppressed(r3)
        L_0x002a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageSaver.copyTempFileToUri(java.io.File, android.net.Uri):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        r4.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void copyTempFileToOutputStream(java.io.File r4, java.io.OutputStream r5) throws java.io.IOException {
        /*
            r3 = this;
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r4)
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0018 }
        L_0x0009:
            int r1 = r0.read(r4)     // Catch:{ all -> 0x0018 }
            if (r1 <= 0) goto L_0x0014
            r2 = 0
            r5.write(r4, r2, r1)     // Catch:{ all -> 0x0018 }
            goto L_0x0009
        L_0x0014:
            r0.close()
            return
        L_0x0018:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x001a }
        L_0x001a:
            r5 = move-exception
            r0.close()     // Catch:{ all -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r0 = move-exception
            r4.addSuppressed(r0)
        L_0x0023:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageSaver.copyTempFileToOutputStream(java.io.File, java.io.OutputStream):void");
    }

    private void postSuccess(Uri uri) {
        this.mExecutor.execute(new Runnable(uri) {
            /* class androidx.camera.core.$$Lambda$ImageSaver$S9mrYGMPcUwPIjUa0oK9HMzbx_o */
            private final /* synthetic */ Uri f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                ImageSaver.this.lambda$postSuccess$0$ImageSaver(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$postSuccess$0$ImageSaver(Uri uri) {
        this.mCallback.onImageSaved(new ImageCapture.OutputFileResults(uri));
    }

    private void postError(SaveError saveError, String str, Throwable th) {
        this.mExecutor.execute(new Runnable(saveError, str, th) {
            /* class androidx.camera.core.$$Lambda$ImageSaver$eApcZyzsEkLVLazzLEezQzwo */
            private final /* synthetic */ ImageSaver.SaveError f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ Throwable f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                ImageSaver.this.lambda$postError$1$ImageSaver(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    public /* synthetic */ void lambda$postError$1$ImageSaver(SaveError saveError, String str, Throwable th) {
        this.mCallback.onError(saveError, str, th);
    }
}
