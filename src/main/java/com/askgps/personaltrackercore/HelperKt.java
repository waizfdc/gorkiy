package com.askgps.personaltrackercore;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0010\u0010\u0006\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¨\u0006\u000b"}, d2 = {"deleteFileFromMediaStore", "", "contentResolver", "Landroid/content/ContentResolver;", "file", "Ljava/io/File;", "deletePictureFile", "path", "", "md5", "s", "personaltrackercore_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: Helper.kt */
public final class HelperKt {
    public static final void deleteFileFromMediaStore(ContentResolver contentResolver, File file) {
        String str;
        Intrinsics.checkParameterIsNotNull(contentResolver, "contentResolver");
        Intrinsics.checkParameterIsNotNull(file, "file");
        try {
            str = file.getCanonicalPath();
            Intrinsics.checkExpressionValueIsNotNull(str, "file.canonicalPath");
        } catch (IOException unused) {
            str = file.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(str, "file.absolutePath");
        }
        Uri contentUri = MediaStore.Files.getContentUri("external");
        if (contentResolver.delete(contentUri, "_data=?", new String[]{str}) == 0) {
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
            if (!Intrinsics.areEqual(absolutePath, str)) {
                contentResolver.delete(contentUri, "_data=?", new String[]{absolutePath});
            }
        }
    }

    public static final void deletePictureFile(String str) {
        if (str != null) {
            LogKt.toFile$default(Boolean.valueOf(new File(str).delete()), "image was deleted", null, null, 6, null);
        }
    }

    public static final String md5(String str) {
        Intrinsics.checkParameterIsNotNull(str, "s");
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            Intrinsics.checkExpressionValueIsNotNull(instance, "MessageDigest.getInstance(\"MD5\")");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            instance.update(bytes);
            byte[] digest = instance.digest();
            Intrinsics.checkExpressionValueIsNotNull(digest, "digest.digest()");
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString(b & 255));
            }
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "hexString.toString()");
            return stringBuffer2;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
