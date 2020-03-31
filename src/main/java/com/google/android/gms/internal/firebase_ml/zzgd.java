package com.google.android.gms.internal.firebase_ml;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
final class zzgd {
    private static final zzgd zzyy = new zzgd();
    private final String zzyz;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzgd() {
        /*
            r4 = this;
            java.lang.String r0 = "java.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            java.lang.String r1 = "9"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0011
            java.lang.String r0 = "9.0.0"
            goto L_0x0015
        L_0x0011:
            java.lang.String r0 = zzp(r0)
        L_0x0015:
            com.google.android.gms.internal.firebase_ml.zzmk r1 = com.google.android.gms.internal.firebase_ml.zzmk.zzahy
            java.lang.String r1 = r1.value()
            com.google.android.gms.internal.firebase_ml.zzmk r2 = com.google.android.gms.internal.firebase_ml.zzmk.zzaia
            java.lang.String r2 = r2.value()
            java.lang.String r3 = com.google.android.gms.internal.firebase_ml.zzfu.VERSION
            r4.<init>(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzgd.<init>():void");
    }

    private zzgd(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder("java/");
        sb.append(zzp(str));
        sb.append(" http-google-%s/");
        sb.append(zzp(str4));
        if (!(str2 == null || str3 == null)) {
            sb.append(" ");
            sb.append(zzo(str2));
            sb.append("/");
            sb.append(zzp(str3));
        }
        this.zzyz = sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zzn(String str) {
        return String.format(this.zzyz, zzo(str));
    }

    /* access modifiers changed from: private */
    public static zzgd zzfk() {
        return zzyy;
    }

    private static String zzo(String str) {
        return str.toLowerCase().replaceAll("[^\\w\\d\\-]", "-");
    }

    private static String zzp(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("(\\d+\\.\\d+\\.\\d+).*").matcher(str);
        return matcher.find() ? matcher.group(1) : str;
    }
}
