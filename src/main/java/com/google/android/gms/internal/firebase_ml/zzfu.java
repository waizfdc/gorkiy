package com.google.android.gms.internal.firebase_ml;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzfu {
    public static final String VERSION;
    public static final Integer zzxv = 1;
    public static final Integer zzxw = 26;
    private static final Integer zzxx = 0;

    static {
        String valueOf = String.valueOf(zzxv);
        String valueOf2 = String.valueOf(zzxw);
        String valueOf3 = String.valueOf(zzxx);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 11 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append(valueOf);
        sb.append(".");
        sb.append(valueOf2);
        sb.append(".");
        sb.append(valueOf3);
        sb.append("-SNAPSHOT");
        VERSION = sb.toString().toString();
    }
}
