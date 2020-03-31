package com.google.android.gms.internal.auth;

import android.util.Log;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.UnsupportedEncodingException;

public abstract class zzaz extends FastSafeParcelableJsonResponse {
    private static String zzem = "AUTH";

    public byte[] toByteArray() {
        try {
            return toString().getBytes(HttpRequest.CHARSET_UTF8);
        } catch (UnsupportedEncodingException e) {
            Log.e(zzem, "Error serializing object.", e);
            return null;
        }
    }
}
