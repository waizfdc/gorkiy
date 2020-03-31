package androidmads.library.qrgenearator;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import androidmads.library.qrgenearator.QRGContents;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.EnumMap;
import java.util.HashSet;

public class QRGEncoder {
    private static final int BLACK = -16777216;
    private static final int WHITE = -1;
    private String contents = null;
    private int dimension = Integer.MIN_VALUE;
    private String displayContents = null;
    private boolean encoded = false;
    private BarcodeFormat format = null;
    private String title = null;

    public QRGEncoder(String str, Bundle bundle, String str2, int i) {
        this.dimension = i;
        this.encoded = encodeContents(str, bundle, str2);
    }

    public String getTitle() {
        return this.title;
    }

    private boolean encodeContents(String str, Bundle bundle, String str2) {
        BarcodeFormat barcodeFormat = BarcodeFormat.QR_CODE;
        this.format = barcodeFormat;
        if (barcodeFormat == BarcodeFormat.QR_CODE) {
            this.format = BarcodeFormat.QR_CODE;
            encodeQRCodeContents(str, bundle, str2);
        } else if (str != null && str.length() > 0) {
            this.contents = str;
            this.displayContents = str;
            this.title = "Text";
        }
        String str3 = this.contents;
        return str3 != null && str3.length() > 0;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void encodeQRCodeContents(String str, Bundle bundle, String str2) {
        char c;
        switch (str2.hashCode()) {
            case -1309271157:
                if (str2.equals(QRGContents.Type.PHONE)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -670199783:
                if (str2.equals(QRGContents.Type.CONTACT)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 709220992:
                if (str2.equals(QRGContents.Type.SMS)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1349204356:
                if (str2.equals(QRGContents.Type.LOCATION)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1778595596:
                if (str2.equals(QRGContents.Type.TEXT)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1833351709:
                if (str2.equals(QRGContents.Type.EMAIL)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0) {
            if (c == 1) {
                String trim = trim(str);
                if (trim != null) {
                    this.contents = "mailto:" + trim;
                    this.displayContents = trim;
                    this.title = "E-Mail";
                }
            } else if (c == 2) {
                String trim2 = trim(str);
                if (trim2 != null) {
                    this.contents = "tel:" + trim2;
                    this.displayContents = PhoneNumberUtils.formatNumber(trim2);
                    this.title = "Phone";
                }
            } else if (c == 3) {
                String trim3 = trim(str);
                if (trim3 != null) {
                    this.contents = "sms:" + trim3;
                    this.displayContents = PhoneNumberUtils.formatNumber(trim3);
                    this.title = "SMS";
                }
            } else if (c != 4) {
                if (c == 5 && bundle != null) {
                    float f = bundle.getFloat("LAT", Float.MAX_VALUE);
                    float f2 = bundle.getFloat("LONG", Float.MAX_VALUE);
                    if (f != Float.MAX_VALUE && f2 != Float.MAX_VALUE) {
                        this.contents = "geo:" + f + ',' + f2;
                        StringBuilder sb = new StringBuilder();
                        sb.append(f);
                        sb.append(",");
                        sb.append(f2);
                        this.displayContents = sb.toString();
                        this.title = HttpRequest.HEADER_LOCATION;
                    }
                }
            } else if (bundle != null) {
                StringBuilder sb2 = new StringBuilder(100);
                StringBuilder sb3 = new StringBuilder(100);
                sb2.append("MECARD:");
                String trim4 = trim(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
                if (trim4 != null) {
                    sb2.append("N:");
                    sb2.append(escapeMECARD(trim4));
                    sb2.append(';');
                    sb3.append(trim4);
                }
                String trim5 = trim(bundle.getString("postal"));
                if (trim5 != null) {
                    sb2.append("ADR:");
                    sb2.append(escapeMECARD(trim5));
                    sb2.append(';');
                    sb3.append(10);
                    sb3.append(trim5);
                }
                HashSet<String> hashSet = new HashSet<>(QRGContents.PHONE_KEYS.length);
                for (String string : QRGContents.PHONE_KEYS) {
                    String trim6 = trim(bundle.getString(string));
                    if (trim6 != null) {
                        hashSet.add(trim6);
                    }
                }
                for (String str3 : hashSet) {
                    sb2.append("TEL:");
                    sb2.append(escapeMECARD(str3));
                    sb2.append(';');
                    sb3.append(10);
                    sb3.append(PhoneNumberUtils.formatNumber(str3));
                }
                HashSet<String> hashSet2 = new HashSet<>(QRGContents.EMAIL_KEYS.length);
                for (String string2 : QRGContents.EMAIL_KEYS) {
                    String trim7 = trim(bundle.getString(string2));
                    if (trim7 != null) {
                        hashSet2.add(trim7);
                    }
                }
                for (String str4 : hashSet2) {
                    sb2.append("EMAIL:");
                    sb2.append(escapeMECARD(str4));
                    sb2.append(';');
                    sb3.append(10);
                    sb3.append(str4);
                }
                String trim8 = trim(bundle.getString(QRGContents.URL_KEY));
                if (trim8 != null) {
                    sb2.append("URL:");
                    sb2.append(trim8);
                    sb2.append(';');
                    sb3.append(10);
                    sb3.append(trim8);
                }
                String trim9 = trim(bundle.getString(QRGContents.NOTE_KEY));
                if (trim9 != null) {
                    sb2.append("NOTE:");
                    sb2.append(escapeMECARD(trim9));
                    sb2.append(';');
                    sb3.append(10);
                    sb3.append(trim9);
                }
                if (sb3.length() > 0) {
                    sb2.append(';');
                    this.contents = sb2.toString();
                    this.displayContents = sb3.toString();
                    this.title = "Contact";
                    return;
                }
                this.contents = null;
                this.displayContents = null;
            }
        } else if (str != null && str.length() > 0) {
            this.contents = str;
            this.displayContents = str;
            this.title = "Text";
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Map.put(java.lang.Object, java.lang.Object):V}
     arg types: [com.google.zxing.EncodeHintType, java.lang.String]
     candidates:
      ClspMth{java.util.EnumMap.put(java.lang.Enum, java.lang.Object):V}
      ClspMth{java.util.Map.put(java.lang.Object, java.lang.Object):V} */
    public Bitmap encodeAsBitmap() throws WriterException {
        EnumMap enumMap = null;
        if (!this.encoded) {
            return null;
        }
        String guessAppropriateEncoding = guessAppropriateEncoding(this.contents);
        if (guessAppropriateEncoding != null) {
            enumMap = new EnumMap(EncodeHintType.class);
            enumMap.put((Object) EncodeHintType.CHARACTER_SET, (Object) guessAppropriateEncoding);
        }
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        String str = this.contents;
        BarcodeFormat barcodeFormat = this.format;
        int i = this.dimension;
        BitMatrix encode = multiFormatWriter.encode(str, barcodeFormat, i, i, enumMap);
        int width = encode.getWidth();
        int height = encode.getHeight();
        int[] iArr = new int[(width * height)];
        for (int i2 = 0; i2 < height; i2++) {
            int i3 = i2 * width;
            for (int i4 = 0; i4 < width; i4++) {
                iArr[i3 + i4] = encode.get(i4, i2) ? -16777216 : -1;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    private static String guessAppropriateEncoding(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) > 255) {
                return HttpRequest.CHARSET_UTF8;
            }
        }
        return null;
    }

    private static String trim(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim;
    }

    private static String escapeMECARD(String str) {
        if (str == null) {
            return str;
        }
        if (str.indexOf(58) < 0 && str.indexOf(59) < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == ':' || charAt == ';') {
                sb.append('\\');
            }
            sb.append(charAt);
        }
        return sb.toString();
    }
}
