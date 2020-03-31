package com.askgps.personaltrackercore.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import com.askgps.personaltrackercore.LogKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/askgps/personaltrackercore/utils/AvatarUtils;", "Lorg/koin/core/KoinComponent;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "maxHeight", "", "getMaxHeight", "()I", "maxWidth", "getMaxWidth", "quality", "getQuality", "tag", "", "compressBitmapToByteArray", "", "bitmap", "Landroid/graphics/Bitmap;", "convertBitmapToFile", "Ljava/io/File;", "fileName", "bitMapData", "loadBitmap", "uri", "Landroid/net/Uri;", "normalizeImage", "", "path", "rotateImage", "angle", "", "saveBitmap", "scaleBitmap", "uploadBitmap", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: AvatarUtils.kt */
public final class AvatarUtils implements KoinComponent {
    private final Context context;
    private final int maxHeight = 800;
    private final int maxWidth = SettingsJsonConstants.ANALYTICS_FLUSH_INTERVAL_SECS_DEFAULT;
    private final int quality = 80;
    private final String tag = "AvatarUtils";

    public AvatarUtils(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final int getMaxWidth() {
        return this.maxWidth;
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }

    public final int getQuality() {
        return this.quality;
    }

    public final byte[] uploadBitmap(String str) {
        Intrinsics.checkParameterIsNotNull(str, "uri");
        normalizeImage(str);
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(uri)");
        byte[] compressBitmapToByteArray = compressBitmapToByteArray(scaleBitmap(loadBitmap(parse)));
        LogKt.toFile$default("Upload image size: " + compressBitmapToByteArray.length, this.tag, null, null, 6, null);
        return compressBitmapToByteArray;
    }

    public final byte[] compressBitmapToByteArray(Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, this.quality, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkExpressionValueIsNotNull(byteArray, "outputStream.toByteArray()");
        return byteArray;
    }

    public final Bitmap loadBitmap(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeFile = BitmapFactory.decodeFile(uri.getEncodedPath(), options);
        Intrinsics.checkExpressionValueIsNotNull(decodeFile, "bitmap");
        return decodeFile;
    }

    public final File convertBitmapToFile(String str, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(str, "fileName");
        Intrinsics.checkParameterIsNotNull(bArr, "bitMapData");
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.write(bArr);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            fileOutputStream.flush();
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        return file;
    }

    private final void normalizeImage(String str) {
        if (str != null) {
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
                LogKt.toFile$default("Image orientation: " + attributeInt, this.tag, null, null, 6, null);
                if (attributeInt == 3) {
                    rotateImage(str, 180.0f);
                } else if (attributeInt == 6) {
                    rotateImage(str, 90.0f);
                } else if (attributeInt == 8) {
                    rotateImage(str, 270.0f);
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    private final void rotateImage(String str, float f) {
        float f2 = f;
        LogKt.toFile$default("Rotating " + f2, this.tag, null, null, 6, null);
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        Matrix matrix = new Matrix();
        matrix.postRotate(f2);
        Intrinsics.checkExpressionValueIsNotNull(decodeFile, FirebaseAnalytics.Param.SOURCE);
        Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "output");
        saveBitmap(createBitmap, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029 A[SYNTHETIC, Splitter:B:18:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0032 A[SYNTHETIC, Splitter:B:22:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void saveBitmap(android.graphics.Bitmap r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = 0
            java.io.FileOutputStream r0 = (java.io.FileOutputStream) r0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0023 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0023 }
            android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x001e, all -> 0x001b }
            r0 = 100
            r2 = r1
            java.io.OutputStream r2 = (java.io.OutputStream) r2     // Catch:{ Exception -> 0x001e, all -> 0x001b }
            r4.compress(r5, r0, r2)     // Catch:{ Exception -> 0x001e, all -> 0x001b }
            r1.close()     // Catch:{ IOException -> 0x0016 }
            goto L_0x002f
        L_0x0016:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x002f
        L_0x001b:
            r4 = move-exception
            r0 = r1
            goto L_0x0030
        L_0x001e:
            r4 = move-exception
            r0 = r1
            goto L_0x0024
        L_0x0021:
            r4 = move-exception
            goto L_0x0030
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            r4.printStackTrace()     // Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x002c
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ IOException -> 0x0016 }
        L_0x002c:
            r0.close()     // Catch:{ IOException -> 0x0016 }
        L_0x002f:
            return
        L_0x0030:
            if (r0 != 0) goto L_0x0035
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ IOException -> 0x0039 }
        L_0x0035:
            r0.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r5 = move-exception
            r5.printStackTrace()
        L_0x003d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.askgps.personaltrackercore.utils.AvatarUtils.saveBitmap(android.graphics.Bitmap, java.lang.String):void");
    }

    private final Bitmap scaleBitmap(Bitmap bitmap) {
        Pair pair;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        LogKt.toFile$default("scaling bitmap with size [" + width + 'x' + height + ']', this.tag, null, null, 6, null);
        if (width > height) {
            int i = this.maxWidth;
            pair = TuplesKt.to(Integer.valueOf(i), Integer.valueOf((int) (((float) height) / (((float) width) / ((float) i)))));
        } else if (height > width) {
            pair = TuplesKt.to(Integer.valueOf((int) (((float) width) / (((float) height) / ((float) this.maxHeight)))), Integer.valueOf(this.maxHeight));
        } else {
            pair = TuplesKt.to(Integer.valueOf(this.maxWidth), Integer.valueOf(this.maxHeight));
        }
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        LogKt.toFile$default("target size [" + intValue + 'x' + intValue2 + ']', this.tag, null, null, 6, null);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, intValue, intValue2, false);
        Intrinsics.checkExpressionValueIsNotNull(createScaledBitmap, "Bitmap.createScaledBitma…dth, targetHeight, false)");
        return createScaledBitmap;
    }
}
