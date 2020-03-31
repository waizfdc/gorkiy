package androidmads.library.qrgenearator;

import android.graphics.Bitmap;
import android.util.Log;
import androidmads.library.qrgenearator.QRGContents;
import com.google.zxing.WriterException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class QRGSaver {
    public static boolean save(String str, String str2, Bitmap bitmap, int i) throws WriterException {
        String str3 = str + str2 + imgFormat(i);
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        } else {
            Log.v("QRGSaver", "Folder Exists");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str3);
            bitmap.compress((Bitmap.CompressFormat) compressFormat(i), 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            Log.d("QRGSaver", e.toString());
            return false;
        }
    }

    private static String imgFormat(int i) {
        return i == QRGContents.ImageType.IMAGE_PNG ? ".png" : ".jpg";
    }

    private static Comparable<? extends Comparable<? extends Comparable<?>>> compressFormat(int i) {
        return i == QRGContents.ImageType.IMAGE_PNG ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }
}
