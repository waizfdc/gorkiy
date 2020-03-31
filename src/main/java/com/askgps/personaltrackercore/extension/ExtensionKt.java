package com.askgps.personaltrackercore.extension;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"dispatchTakePictureIntent", "Ljava/io/File;", "Landroid/app/Activity;", "personaltrackercore_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: Extension.kt */
public final class ExtensionKt {
    public static final File dispatchTakePictureIntent(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "$this$dispatchTakePictureIntent");
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = null;
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            try {
                file = ContextExtensionKt.createImageFile(activity);
            } catch (IOException unused) {
            }
            if (file != null) {
                Uri uriForFile = FileProvider.getUriForFile(activity, activity.getPackageName(), file);
                Intrinsics.checkExpressionValueIsNotNull(uriForFile, "FileProvider.getUriForFi…     it\n                )");
                intent.putExtra("output", uriForFile);
                activity.startActivityForResult(intent, 2);
            }
        }
        return file;
    }
}
