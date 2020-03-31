package com.google.android.gms.internal.firebase_ml;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: com.google.firebase:firebase-ml-common@@22.0.1 */
public final class zzjs {
    private static final zzjr zzafx = new zzju("-_.*", true);
    private static final zzjr zzafy = new zzju("-_.!~*'()@:$&,;=", false);
    private static final zzjr zzafz = new zzju("-_.!~*'()@:$&,;=+/?", false);
    private static final zzjr zzaga = new zzju("-_.!~*'():$&,;=", false);
    private static final zzjr zzagb = new zzju("-_.!~*'()@:$,;/?:", false);

    public static String zzaq(String str) {
        return zzafx.zzap(str);
    }

    public static String zzar(String str) {
        try {
            return URLDecoder.decode(str, HttpRequest.CHARSET_UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String zzas(String str) {
        return zzafy.zzap(str);
    }

    public static String zzat(String str) {
        return zzafz.zzap(str);
    }

    public static String zzau(String str) {
        return zzaga.zzap(str);
    }

    public static String zzav(String str) {
        return zzagb.zzap(str);
    }
}
