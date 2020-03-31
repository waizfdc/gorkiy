package com.google.android.gms.internal.fitness;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.DeviceProperties;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public final class zzj {
    private static int zzmu = -1;

    public static int zza(Context context) {
        if (zzmu == -1) {
            if (DeviceProperties.isWearable(context)) {
                zzmu = 3;
            } else {
                boolean z = false;
                if (DeviceProperties.isTv(context) || DeviceProperties.isAuto(context)) {
                    zzmu = 0;
                } else {
                    if (DeviceProperties.isTablet(context.getResources()) && !zzb(context)) {
                        zzmu = 2;
                    } else {
                        if (!TextUtils.isEmpty(Build.PRODUCT) && Build.PRODUCT.startsWith("glass_")) {
                            z = true;
                        }
                        if (z) {
                            zzmu = 6;
                        } else {
                            zzmu = 1;
                        }
                    }
                }
            }
        }
        return zzmu;
    }

    private static boolean zzb(Context context) {
        try {
            if (((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0) {
                return true;
            }
            return false;
        } catch (Resources.NotFoundException e) {
            Log.e("Fitness", "Unable to determine type of device, assuming phone.", e);
            return true;
        }
    }
}
