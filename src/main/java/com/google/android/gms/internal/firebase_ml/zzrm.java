package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.common.internal.GmsLogger;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public final class zzrm {
    private static final GmsLogger zzbbo = new GmsLogger("MLKitImageUtils", "");
    private static zzrm zzbll = new zzrm();

    private zzrm() {
    }

    public static zzrm zzpz() {
        return zzbll;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f A[Catch:{ FileNotFoundException -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap zza(android.content.ContentResolver r8, android.net.Uri r9) throws java.io.IOException {
        /*
            android.graphics.Bitmap r7 = android.provider.MediaStore.Images.Media.getBitmap(r8, r9)     // Catch:{ FileNotFoundException -> 0x005e }
            int r8 = zzb(r8, r9)     // Catch:{ FileNotFoundException -> 0x005e }
            android.graphics.Matrix r0 = new android.graphics.Matrix     // Catch:{ FileNotFoundException -> 0x005e }
            r0.<init>()     // Catch:{ FileNotFoundException -> 0x005e }
            int r3 = r7.getWidth()     // Catch:{ FileNotFoundException -> 0x005e }
            int r4 = r7.getHeight()     // Catch:{ FileNotFoundException -> 0x005e }
            r1 = -1028390912(0xffffffffc2b40000, float:-90.0)
            r2 = 1119092736(0x42b40000, float:90.0)
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = 1065353216(0x3f800000, float:1.0)
            switch(r8) {
                case 2: goto L_0x0044;
                case 3: goto L_0x003d;
                case 4: goto L_0x0039;
                case 5: goto L_0x0032;
                case 6: goto L_0x002e;
                case 7: goto L_0x0027;
                case 8: goto L_0x0023;
                default: goto L_0x0020;
            }     // Catch:{ FileNotFoundException -> 0x005e }
        L_0x0020:
            r8 = 0
        L_0x0021:
            r5 = r8
            goto L_0x004d
        L_0x0023:
            r0.postRotate(r1)     // Catch:{ FileNotFoundException -> 0x005e }
            goto L_0x0042
        L_0x0027:
            r0.postRotate(r1)     // Catch:{ FileNotFoundException -> 0x005e }
            r0.postScale(r5, r6)     // Catch:{ FileNotFoundException -> 0x005e }
            goto L_0x0042
        L_0x002e:
            r0.postRotate(r2)     // Catch:{ FileNotFoundException -> 0x005e }
            goto L_0x0042
        L_0x0032:
            r0.postRotate(r2)     // Catch:{ FileNotFoundException -> 0x005e }
            r0.postScale(r5, r6)     // Catch:{ FileNotFoundException -> 0x005e }
            goto L_0x0042
        L_0x0039:
            r0.postScale(r6, r5)     // Catch:{ FileNotFoundException -> 0x005e }
            goto L_0x0042
        L_0x003d:
            r8 = 1127481344(0x43340000, float:180.0)
            r0.postRotate(r8)     // Catch:{ FileNotFoundException -> 0x005e }
        L_0x0042:
            r5 = r0
            goto L_0x004d
        L_0x0044:
            android.graphics.Matrix r8 = new android.graphics.Matrix     // Catch:{ FileNotFoundException -> 0x005e }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x005e }
            r8.postScale(r5, r6)     // Catch:{ FileNotFoundException -> 0x005e }
            goto L_0x0021
        L_0x004d:
            if (r5 == 0) goto L_0x005d
            r1 = 0
            r2 = 0
            r6 = 1
            r0 = r7
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)     // Catch:{ FileNotFoundException -> 0x005e }
            if (r7 == r8) goto L_0x005d
            r7.recycle()     // Catch:{ FileNotFoundException -> 0x005e }
            r7 = r8
        L_0x005d:
            return r7
        L_0x005e:
            r8 = move-exception
            com.google.android.gms.common.internal.GmsLogger r0 = com.google.android.gms.internal.firebase_ml.zzrm.zzbbo
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r1 = java.lang.String.valueOf(r9)
            int r1 = r1.length()
            int r1 = r1 + 21
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Could not open file: "
            r2.append(r1)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            java.lang.String r1 = "MLKitImageUtils"
            r0.e(r1, r9, r8)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzrm.zza(android.content.ContentResolver, android.net.Uri):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.ContentResolver r5, android.net.Uri r6) {
        /*
            java.lang.String r0 = r6.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = r1.equals(r0)
            r1 = 0
            if (r0 != 0) goto L_0x001a
            java.lang.String r0 = r6.getScheme()
            java.lang.String r2 = "file"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x001a
            return r1
        L_0x001a:
            r0 = 0
            java.io.InputStream r5 = r5.openInputStream(r6)     // Catch:{ IOException -> 0x0039 }
            androidx.exifinterface.media.ExifInterface r2 = new androidx.exifinterface.media.ExifInterface     // Catch:{ all -> 0x002d }
            r2.<init>(r5)     // Catch:{ all -> 0x002d }
            if (r5 == 0) goto L_0x0061
            r5.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x0061
        L_0x002a:
            r5 = move-exception
            r0 = r2
            goto L_0x003a
        L_0x002d:
            r2 = move-exception
            if (r5 == 0) goto L_0x0038
            r5.close()     // Catch:{ all -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r5 = move-exception
            com.google.android.gms.internal.firebase_ml.zzmz.zza(r2, r5)     // Catch:{ IOException -> 0x0039 }
        L_0x0038:
            throw r2     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            r5 = move-exception
        L_0x003a:
            com.google.android.gms.common.internal.GmsLogger r2 = com.google.android.gms.internal.firebase_ml.zzrm.zzbbo
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r3 = java.lang.String.valueOf(r6)
            int r3 = r3.length()
            int r3 = r3 + 48
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "failed to open file to read rotation meta data: "
            r4.append(r3)
            r4.append(r6)
            java.lang.String r6 = r4.toString()
            java.lang.String r3 = "MLKitImageUtils"
            r2.e(r3, r6, r5)
            r2 = r0
        L_0x0061:
            if (r2 != 0) goto L_0x0064
            return r1
        L_0x0064:
            r5 = 1
            java.lang.String r6 = "Orientation"
            int r5 = r2.getAttributeInt(r6, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.zzrm.zzb(android.content.ContentResolver, android.net.Uri):int");
    }
}
