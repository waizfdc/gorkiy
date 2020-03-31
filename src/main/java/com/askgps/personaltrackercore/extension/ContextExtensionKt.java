package com.askgps.personaltrackercore.extension;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidx.core.app.ActivityCompat;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.R;
import com.askgps.personaltrackercore.utils.WifiUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\u0012\u0010\t\u001a\u00020\n*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0003\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\b\u001a\u000e\u0010\r\u001a\u0004\u0018\u00010\u0003*\u00020\bH\u0007\u001a\f\u0010\u000e\u001a\u00020\u0003*\u00020\bH\u0007\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\bH\u0007\u001a\f\u0010\u0011\u001a\u0004\u0018\u00010\u0003*\u00020\b\u001a\f\u0010\u0012\u001a\u00020\u0003*\u00020\bH\u0007\u001a\u0012\u0010\u0013\u001a\u00020\u0014*\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0003\u001a\u0012\u0010\u0016\u001a\u00020\u0014*\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0018²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u0002"}, d2 = {"BATTERY_DEFAULT", "", "FAIL_IMEI", "", "MAX_DELAY", "", "createImageFile", "Ljava/io/File;", "Landroid/content/Context;", "generateQr", "Landroid/graphics/Bitmap;", "text", "getBatteryLevel", "getID", "getImei", "getLastLocation", "Landroid/location/Location;", "getMac", "getSimNumber", "makeCall", "", "number", "openUrl", "url", "personaltrackercore_release", "wifiUtils", "Lcom/askgps/personaltrackercore/utils/WifiUtils;"}, k = 2, mv = {1, 1, 16})
/* compiled from: ContextExtension.kt */
public final class ContextExtensionKt {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(ContextExtensionKt.class, "personaltrackercore_release"), "wifiUtils", "<v#0>"))};
    public static final byte BATTERY_DEFAULT = -1;
    public static final String FAIL_IMEI = "000000000000000";
    public static final int MAX_DELAY = 1000000;

    public static final byte getBatteryLevel(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$this$getBatteryLevel");
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return (byte) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
        }
        return -1;
    }

    public static final String getID(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$this$getID");
        if (Build.VERSION.SDK_INT >= 29) {
            return getMac(context);
        }
        return getImei(context);
    }

    public static final String getImei(Context context) {
        String str;
        Intrinsics.checkParameterIsNotNull(context, "$this$getImei");
        if (ActivityCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == -1) {
            LogKt.toLog$default("Request IMEI failed", (String) null, (String) null, (String) null, 7, (Object) null);
            return FAIL_IMEI;
        }
        Object systemService = context.getSystemService("phone");
        if (systemService != null) {
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                str = telephonyManager.getImei();
            } else {
                str = telephonyManager.getDeviceId();
            }
            Intrinsics.checkExpressionValueIsNotNull(str, "if (Build.VERSION.SDK_IN…       telephone.deviceId");
            return str;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    public static final String getMac(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$this$getMac");
        Lazy lazy = LazyKt.lazy(new ContextExtensionKt$getMac$wifiUtils$2(context));
        KProperty kProperty = $$delegatedProperties[0];
        String macAddr = ((WifiUtils) lazy.getValue()).getMacAddr();
        LogKt.toLog$default(macAddr, "Device_WIFI_Mac= ", (String) null, (String) null, 6, (Object) null);
        if (macAddr == null) {
            return null;
        }
        CharSequence charSequence = macAddr;
        Appendable sb = new StringBuilder();
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (!Character.valueOf(charAt).equals(':')) {
                sb.append(charAt);
            }
        }
        String sb2 = ((StringBuilder) sb).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "filterTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    public static final String getSimNumber(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$this$getSimNumber");
        if (ActivityCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == -1) {
            LogKt.toLog$default("Request sim failed", (String) null, (String) null, (String) null, 7, (Object) null);
            return FAIL_IMEI;
        }
        Object systemService = context.getSystemService("phone");
        if (systemService != null) {
            String line1Number = ((TelephonyManager) systemService).getLine1Number();
            Intrinsics.checkExpressionValueIsNotNull(line1Number, "telephone.line1Number");
            return line1Number;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    public static final Bitmap generateQr(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "$this$generateQr");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Bitmap encodeAsBitmap = new QRGEncoder(str, null, QRGContents.Type.TEXT, (int) context.getResources().getDimension(R.dimen.qr_size)).encodeAsBitmap();
        Intrinsics.checkExpressionValueIsNotNull(encodeAsBitmap, "encoder.encodeAsBitmap()");
        return encodeAsBitmap;
    }

    public static final File createImageFile(Context context) throws IOException {
        Intrinsics.checkParameterIsNotNull(context, "$this$createImageFile");
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        Intrinsics.checkExpressionValueIsNotNull(format, "SimpleDateFormat(\"yyyyMMdd_HHmmss\").format(Date())");
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        Intrinsics.checkExpressionValueIsNotNull(externalFilesDir, "this.getExternalFilesDir…nment.DIRECTORY_PICTURES)");
        File createTempFile = File.createTempFile("photo_" + format + '_', ".jpg", externalFilesDir);
        Intrinsics.checkExpressionValueIsNotNull(createTempFile, "File.createTempFile(\n   …Dir /* directory */\n    )");
        return createTempFile;
    }

    public static final Location getLastLocation(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$this$getLastLocation");
        Object systemService = context.getSystemService(FirebaseAnalytics.Param.LOCATION);
        if (systemService != null) {
            LocationManager locationManager = (LocationManager) systemService;
            return locationManager.getLastKnownLocation(locationManager.getBestProvider(new Criteria(), false));
        }
        throw new TypeCastException("null cannot be cast to non-null type android.location.LocationManager");
    }

    public static final void makeCall(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "$this$makeCall");
        Intrinsics.checkParameterIsNotNull(str, "number");
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:" + str));
        context.startActivity(intent);
    }

    public static final void openUrl(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "$this$openUrl");
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        context.startActivity(intent);
    }
}
