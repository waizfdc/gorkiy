package com.google.firebase.ml.vision.barcode;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzng;
import com.google.firebase.ml.vision.barcode.internal.zzf;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionBarcode {
    public static final int FORMAT_ALL_FORMATS = 0;
    public static final int FORMAT_AZTEC = 4096;
    public static final int FORMAT_CODABAR = 8;
    public static final int FORMAT_CODE_128 = 1;
    public static final int FORMAT_CODE_39 = 2;
    public static final int FORMAT_CODE_93 = 4;
    public static final int FORMAT_DATA_MATRIX = 16;
    public static final int FORMAT_EAN_13 = 32;
    public static final int FORMAT_EAN_8 = 64;
    public static final int FORMAT_ITF = 128;
    public static final int FORMAT_PDF417 = 2048;
    public static final int FORMAT_QR_CODE = 256;
    public static final int FORMAT_UNKNOWN = -1;
    public static final int FORMAT_UPC_A = 512;
    public static final int FORMAT_UPC_E = 1024;
    public static final int TYPE_CALENDAR_EVENT = 11;
    public static final int TYPE_CONTACT_INFO = 1;
    public static final int TYPE_DRIVER_LICENSE = 12;
    public static final int TYPE_EMAIL = 2;
    public static final int TYPE_GEO = 10;
    public static final int TYPE_ISBN = 3;
    public static final int TYPE_PHONE = 4;
    public static final int TYPE_PRODUCT = 5;
    public static final int TYPE_SMS = 6;
    public static final int TYPE_TEXT = 7;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_URL = 8;
    public static final int TYPE_WIFI = 9;
    private static final SparseArray<zzng.zzak.zza> zzbje = new SparseArray<>();
    private static final SparseArray<zzng.zzak.zzb> zzbjf = new SparseArray<>();
    private final zzf zzbjg;

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public @interface BarcodeFormat {
    }

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public @interface BarcodeValueType {
    }

    public FirebaseVisionBarcode(zzf zzf) {
        this.zzbjg = (zzf) Preconditions.checkNotNull(zzf);
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Address {
        public static final int TYPE_HOME = 2;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WORK = 1;
        private final String[] addressLines;
        private final int type;

        @Retention(RetentionPolicy.CLASS)
        /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
        public @interface AddressType {
        }

        public Address(int i, String[] strArr) {
            this.type = i;
            this.addressLines = strArr;
        }

        public int getType() {
            return this.type;
        }

        public String[] getAddressLines() {
            return this.addressLines;
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class GeoPoint {
        private final double lat;
        private final double lng;

        public GeoPoint(double d, double d2) {
            this.lat = d;
            this.lng = d2;
        }

        public double getLat() {
            return this.lat;
        }

        public double getLng() {
            return this.lng;
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Phone {
        public static final int TYPE_FAX = 3;
        public static final int TYPE_HOME = 2;
        public static final int TYPE_MOBILE = 4;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WORK = 1;
        private final String number;
        private final int type;

        @Retention(RetentionPolicy.CLASS)
        /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
        public @interface FormatType {
        }

        public Phone(String str, int i) {
            this.number = str;
            this.type = i;
        }

        public String getNumber() {
            return this.number;
        }

        public int getType() {
            return this.type;
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Sms {
        private final String message;
        private final String phoneNumber;

        public Sms(String str, String str2) {
            this.message = str;
            this.phoneNumber = str2;
        }

        public String getMessage() {
            return this.message;
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class UrlBookmark {
        private final String title;
        private final String url;

        public UrlBookmark(String str, String str2) {
            this.title = str;
            this.url = str2;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUrl() {
            return this.url;
        }
    }

    public Rect getBoundingBox() {
        return this.zzbjg.getBoundingBox();
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class WiFi {
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_WEP = 3;
        public static final int TYPE_WPA = 2;
        private final int encryptionType;
        private final String password;
        private final String ssid;

        @Retention(RetentionPolicy.CLASS)
        /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
        public @interface EncryptionType {
        }

        public WiFi(String str, String str2, int i) {
            this.ssid = str;
            this.password = str2;
            this.encryptionType = i;
        }

        public String getSsid() {
            return this.ssid;
        }

        public String getPassword() {
            return this.password;
        }

        public int getEncryptionType() {
            return this.encryptionType;
        }
    }

    public Point[] getCornerPoints() {
        return this.zzbjg.getCornerPoints();
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class Email {
        public static final int TYPE_HOME = 2;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WORK = 1;
        private final String address;
        private final String body;
        private final String subject;
        private final int type;

        @Retention(RetentionPolicy.CLASS)
        /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
        public @interface FormatType {
        }

        public Email(int i, String str, String str2, String str3) {
            this.type = i;
            this.address = str;
            this.subject = str2;
            this.body = str3;
        }

        public int getType() {
            return this.type;
        }

        public String getAddress() {
            return this.address;
        }

        public String getSubject() {
            return this.subject;
        }

        public String getBody() {
            return this.body;
        }
    }

    public String getRawValue() {
        return this.zzbjg.getRawValue();
    }

    public byte[] getRawBytes() {
        byte[] rawBytes = this.zzbjg.getRawBytes();
        if (rawBytes != null) {
            return Arrays.copyOf(rawBytes, rawBytes.length);
        }
        return null;
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class CalendarEvent {
        private final String description;
        private final String location;
        private final String organizer;
        private final String status;
        private final String summary;
        private final CalendarDateTime zzbjl;
        private final CalendarDateTime zzbjm;

        public CalendarEvent(String str, String str2, String str3, String str4, String str5, CalendarDateTime calendarDateTime, CalendarDateTime calendarDateTime2) {
            this.summary = str;
            this.description = str2;
            this.location = str3;
            this.organizer = str4;
            this.status = str5;
            this.zzbjl = calendarDateTime;
            this.zzbjm = calendarDateTime2;
        }

        public String getSummary() {
            return this.summary;
        }

        public String getDescription() {
            return this.description;
        }

        public String getLocation() {
            return this.location;
        }

        public String getOrganizer() {
            return this.organizer;
        }

        public String getStatus() {
            return this.status;
        }

        public CalendarDateTime getStart() {
            return this.zzbjl;
        }

        public CalendarDateTime getEnd() {
            return this.zzbjm;
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class ContactInfo {
        private final String organization;
        private final String title;
        private final String[] urls;
        private final PersonName zzbjh;
        private final List<Phone> zzbji;
        private final List<Email> zzbjj;
        private final List<Address> zzbjk;

        public ContactInfo(PersonName personName, String str, String str2, List<Phone> list, List<Email> list2, String[] strArr, List<Address> list3) {
            this.zzbjh = personName;
            this.organization = str;
            this.title = str2;
            this.zzbji = list;
            this.zzbjj = list2;
            this.urls = strArr;
            this.zzbjk = list3;
        }

        public PersonName getName() {
            return this.zzbjh;
        }

        public String getOrganization() {
            return this.organization;
        }

        public String getTitle() {
            return this.title;
        }

        public List<Phone> getPhones() {
            return this.zzbji;
        }

        public List<Email> getEmails() {
            return this.zzbjj;
        }

        public String[] getUrls() {
            return this.urls;
        }

        public List<Address> getAddresses() {
            return this.zzbjk;
        }
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class PersonName {
        private final String first;
        private final String formattedName;
        private final String last;
        private final String middle;
        private final String prefix;
        private final String pronunciation;
        private final String suffix;

        public PersonName(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.formattedName = str;
            this.pronunciation = str2;
            this.prefix = str3;
            this.first = str4;
            this.middle = str5;
            this.last = str6;
            this.suffix = str7;
        }

        public String getFormattedName() {
            return this.formattedName;
        }

        public String getPronunciation() {
            return this.pronunciation;
        }

        public String getPrefix() {
            return this.prefix;
        }

        public String getFirst() {
            return this.first;
        }

        public String getMiddle() {
            return this.middle;
        }

        public String getLast() {
            return this.last;
        }

        public String getSuffix() {
            return this.suffix;
        }
    }

    public String getDisplayValue() {
        return this.zzbjg.getDisplayValue();
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class CalendarDateTime {
        private final int day;
        private final int hours;
        private final boolean isUtc;
        private final int minutes;
        private final int month;
        private final String rawValue;
        private final int seconds;
        private final int year;

        public CalendarDateTime(int i, int i2, int i3, int i4, int i5, int i6, boolean z, String str) {
            this.year = i;
            this.month = i2;
            this.day = i3;
            this.hours = i4;
            this.minutes = i5;
            this.seconds = i6;
            this.isUtc = z;
            this.rawValue = str;
        }

        public int getYear() {
            return this.year;
        }

        public int getMonth() {
            return this.month;
        }

        public int getDay() {
            return this.day;
        }

        public int getHours() {
            return this.hours;
        }

        public int getMinutes() {
            return this.minutes;
        }

        public int getSeconds() {
            return this.seconds;
        }

        public boolean isUtc() {
            return this.isUtc;
        }

        public String getRawValue() {
            return this.rawValue;
        }
    }

    public int getFormat() {
        int format = this.zzbjg.getFormat();
        if (format > 4096 || format == 0) {
            return -1;
        }
        return format;
    }

    public int getValueType() {
        return this.zzbjg.getValueType();
    }

    public Email getEmail() {
        return this.zzbjg.getEmail();
    }

    /* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
    public static class DriverLicense {
        private final String addressCity;
        private final String addressState;
        private final String addressStreet;
        private final String addressZip;
        private final String birthDate;
        private final String documentType;
        private final String expiryDate;
        private final String firstName;
        private final String gender;
        private final String issueDate;
        private final String issuingCountry;
        private final String lastName;
        private final String licenseNumber;
        private final String middleName;

        public DriverLicense(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
            this.documentType = str;
            this.firstName = str2;
            this.middleName = str3;
            this.lastName = str4;
            this.gender = str5;
            this.addressStreet = str6;
            this.addressCity = str7;
            this.addressState = str8;
            this.addressZip = str9;
            this.licenseNumber = str10;
            this.issueDate = str11;
            this.expiryDate = str12;
            this.birthDate = str13;
            this.issuingCountry = str14;
        }

        public String getDocumentType() {
            return this.documentType;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getMiddleName() {
            return this.middleName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getGender() {
            return this.gender;
        }

        public String getAddressStreet() {
            return this.addressStreet;
        }

        public String getAddressCity() {
            return this.addressCity;
        }

        public String getAddressState() {
            return this.addressState;
        }

        public String getAddressZip() {
            return this.addressZip;
        }

        public String getLicenseNumber() {
            return this.licenseNumber;
        }

        public String getIssueDate() {
            return this.issueDate;
        }

        public String getExpiryDate() {
            return this.expiryDate;
        }

        public String getBirthDate() {
            return this.birthDate;
        }

        public String getIssuingCountry() {
            return this.issuingCountry;
        }
    }

    public Phone getPhone() {
        return this.zzbjg.getPhone();
    }

    public Sms getSms() {
        return this.zzbjg.getSms();
    }

    public WiFi getWifi() {
        return this.zzbjg.getWifi();
    }

    public UrlBookmark getUrl() {
        return this.zzbjg.getUrl();
    }

    public GeoPoint getGeoPoint() {
        return this.zzbjg.getGeoPoint();
    }

    public CalendarEvent getCalendarEvent() {
        return this.zzbjg.getCalendarEvent();
    }

    public ContactInfo getContactInfo() {
        return this.zzbjg.getContactInfo();
    }

    public DriverLicense getDriverLicense() {
        return this.zzbjg.getDriverLicense();
    }

    public final zzng.zzak.zza zzpo() {
        zzng.zzak.zza zza = zzbje.get(getFormat());
        return zza == null ? zzng.zzak.zza.FORMAT_UNKNOWN : zza;
    }

    public final zzng.zzak.zzb zzpp() {
        zzng.zzak.zzb zzb = zzbjf.get(getValueType());
        return zzb == null ? zzng.zzak.zzb.TYPE_UNKNOWN : zzb;
    }

    static {
        zzbje.put(-1, zzng.zzak.zza.FORMAT_UNKNOWN);
        zzbje.put(1, zzng.zzak.zza.FORMAT_CODE_128);
        zzbje.put(2, zzng.zzak.zza.FORMAT_CODE_39);
        zzbje.put(4, zzng.zzak.zza.FORMAT_CODE_93);
        zzbje.put(8, zzng.zzak.zza.FORMAT_CODABAR);
        zzbje.put(16, zzng.zzak.zza.FORMAT_DATA_MATRIX);
        zzbje.put(32, zzng.zzak.zza.FORMAT_EAN_13);
        zzbje.put(64, zzng.zzak.zza.FORMAT_EAN_8);
        zzbje.put(128, zzng.zzak.zza.FORMAT_ITF);
        zzbje.put(256, zzng.zzak.zza.FORMAT_QR_CODE);
        zzbje.put(512, zzng.zzak.zza.FORMAT_UPC_A);
        zzbje.put(1024, zzng.zzak.zza.FORMAT_UPC_E);
        zzbje.put(2048, zzng.zzak.zza.FORMAT_PDF417);
        zzbje.put(4096, zzng.zzak.zza.FORMAT_AZTEC);
        zzbjf.put(0, zzng.zzak.zzb.TYPE_UNKNOWN);
        zzbjf.put(1, zzng.zzak.zzb.TYPE_CONTACT_INFO);
        zzbjf.put(2, zzng.zzak.zzb.TYPE_EMAIL);
        zzbjf.put(3, zzng.zzak.zzb.TYPE_ISBN);
        zzbjf.put(4, zzng.zzak.zzb.TYPE_PHONE);
        zzbjf.put(5, zzng.zzak.zzb.TYPE_PRODUCT);
        zzbjf.put(6, zzng.zzak.zzb.TYPE_SMS);
        zzbjf.put(7, zzng.zzak.zzb.TYPE_TEXT);
        zzbjf.put(8, zzng.zzak.zzb.TYPE_URL);
        zzbjf.put(9, zzng.zzak.zzb.TYPE_WIFI);
        zzbjf.put(10, zzng.zzak.zzb.TYPE_GEO);
        zzbjf.put(11, zzng.zzak.zzb.TYPE_CALENDAR_EVENT);
        zzbjf.put(12, zzng.zzak.zzb.TYPE_DRIVER_LICENSE);
    }
}
