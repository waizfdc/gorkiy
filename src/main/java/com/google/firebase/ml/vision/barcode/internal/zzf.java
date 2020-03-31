package com.google.firebase.ml.vision.barcode.internal;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public interface zzf {
    Rect getBoundingBox();

    FirebaseVisionBarcode.CalendarEvent getCalendarEvent();

    FirebaseVisionBarcode.ContactInfo getContactInfo();

    Point[] getCornerPoints();

    String getDisplayValue();

    FirebaseVisionBarcode.DriverLicense getDriverLicense();

    FirebaseVisionBarcode.Email getEmail();

    int getFormat();

    FirebaseVisionBarcode.GeoPoint getGeoPoint();

    FirebaseVisionBarcode.Phone getPhone();

    byte[] getRawBytes();

    String getRawValue();

    FirebaseVisionBarcode.Sms getSms();

    FirebaseVisionBarcode.UrlBookmark getUrl();

    int getValueType();

    FirebaseVisionBarcode.WiFi getWifi();
}
