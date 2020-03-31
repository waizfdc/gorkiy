package com.google.firebase.ml.vision.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_ml.zzrh;
import com.google.android.gms.internal.firebase_ml.zzrm;
import com.google.android.gms.vision.Frame;
import com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.firebase:firebase-ml-vision@@24.0.1 */
public class FirebaseVisionImage {
    private static final zzrh zzbkt = zzrh.zzpx();
    private volatile Bitmap zzbku;
    private volatile ByteBuffer zzbkv;
    private volatile FirebaseVisionImageMetadata zzbkw;
    private volatile Frame zzbkx;
    private volatile byte[] zzbky;
    private final long zzbkz;

    public static FirebaseVisionImage fromByteBuffer(ByteBuffer byteBuffer, FirebaseVisionImageMetadata firebaseVisionImageMetadata) {
        return new FirebaseVisionImage(byteBuffer, firebaseVisionImageMetadata);
    }

    public static FirebaseVisionImage fromByteArray(byte[] bArr, FirebaseVisionImageMetadata firebaseVisionImageMetadata) {
        return new FirebaseVisionImage(bArr, firebaseVisionImageMetadata);
    }

    public static FirebaseVisionImage fromBitmap(Bitmap bitmap) {
        return new FirebaseVisionImage(bitmap);
    }

    public static FirebaseVisionImage fromMediaImage(Image image, int i) {
        Preconditions.checkNotNull(image, "Please provide a valid image");
        Preconditions.checkArgument(image.getFormat() == 256 || image.getFormat() == 35, "Only JPEG and YUV_420_888 are supported now");
        Image.Plane[] planes = image.getPlanes();
        if (image.getFormat() != 256) {
            return new FirebaseVisionImage(zzrh.zza(planes, image.getWidth(), image.getHeight()), new FirebaseVisionImageMetadata.Builder().setFormat(17).setWidth(image.getWidth()).setHeight(image.getHeight()).setRotation(i).build());
        }
        if (planes == null || planes.length != 1) {
            throw new IllegalArgumentException("Unexpected image format, JPEG should have exactly 1 image plane");
        }
        ByteBuffer buffer = planes[0].getBuffer();
        int remaining = buffer.remaining();
        byte[] bArr = new byte[remaining];
        buffer.get(bArr);
        if (i == 0) {
            return new FirebaseVisionImage(bArr);
        }
        return new FirebaseVisionImage(zza(BitmapFactory.decodeByteArray(bArr, 0, remaining), i));
    }

    public static FirebaseVisionImage fromFilePath(Context context, Uri uri) throws IOException {
        Preconditions.checkNotNull(context, "Please provide a valid Context");
        Preconditions.checkNotNull(uri, "Please provide a valid imageUri");
        zzrm.zzpz();
        return new FirebaseVisionImage(zzrm.zza(context.getContentResolver(), uri));
    }

    private FirebaseVisionImage(ByteBuffer byteBuffer, FirebaseVisionImageMetadata firebaseVisionImageMetadata) {
        this.zzbkz = SystemClock.elapsedRealtime();
        this.zzbkv = (ByteBuffer) Preconditions.checkNotNull(byteBuffer);
        this.zzbkw = (FirebaseVisionImageMetadata) Preconditions.checkNotNull(firebaseVisionImageMetadata);
    }

    private FirebaseVisionImage(byte[] bArr, FirebaseVisionImageMetadata firebaseVisionImageMetadata) {
        this(ByteBuffer.wrap((byte[]) Preconditions.checkNotNull(bArr)), firebaseVisionImageMetadata);
    }

    private FirebaseVisionImage(Bitmap bitmap) {
        this.zzbkz = SystemClock.elapsedRealtime();
        this.zzbku = (Bitmap) Preconditions.checkNotNull(bitmap);
    }

    private FirebaseVisionImage(byte[] bArr) {
        this.zzbkz = SystemClock.elapsedRealtime();
        this.zzbky = (byte[]) Preconditions.checkNotNull(bArr);
    }

    public Bitmap getBitmap() {
        return zzpv();
    }

    private final Bitmap zzpv() {
        if (this.zzbku != null) {
            return this.zzbku;
        }
        synchronized (this) {
            if (this.zzbku == null) {
                byte[] zzau = zzau(false);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(zzau, 0, zzau.length);
                if (this.zzbkw != null) {
                    decodeByteArray = zza(decodeByteArray, this.zzbkw.getRotation());
                }
                this.zzbku = decodeByteArray;
            }
        }
        return this.zzbku;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    private static Bitmap zza(Bitmap bitmap, int i) {
        int i2;
        if (i == 0) {
            i2 = 0;
        } else if (i == 1) {
            i2 = 90;
        } else if (i == 2) {
            i2 = 180;
        } else if (i == 3) {
            i2 = 270;
        } else {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Invalid rotation: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    public final Pair<byte[], Float> zze(int i, int i2) {
        int i3;
        int i4;
        byte[] bArr;
        if (this.zzbkw != null) {
            boolean z = this.zzbkw.getRotation() == 1 || this.zzbkw.getRotation() == 3;
            FirebaseVisionImageMetadata firebaseVisionImageMetadata = this.zzbkw;
            i3 = z ? firebaseVisionImageMetadata.getHeight() : firebaseVisionImageMetadata.getWidth();
            i4 = z ? this.zzbkw.getWidth() : this.zzbkw.getHeight();
        } else {
            i3 = zzpv().getWidth();
            i4 = zzpv().getHeight();
        }
        float min = Math.min(((float) i) / ((float) i3), ((float) i2) / ((float) i4));
        if (min < 1.0f) {
            Bitmap zzpv = zzpv();
            Matrix matrix = new Matrix();
            matrix.postScale(min, min);
            bArr = zzrh.zza(Bitmap.createBitmap(zzpv, 0, 0, this.zzbku.getWidth(), this.zzbku.getHeight(), matrix, true));
        } else {
            bArr = zzau(true);
            min = 1.0f;
        }
        return Pair.create(bArr, Float.valueOf(min));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005b, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final byte[] zzau(boolean r3) {
        /*
            r2 = this;
            byte[] r0 = r2.zzbky
            if (r0 == 0) goto L_0x0007
            byte[] r3 = r2.zzbky
            return r3
        L_0x0007:
            monitor-enter(r2)
            byte[] r0 = r2.zzbky     // Catch:{ all -> 0x0068 }
            if (r0 == 0) goto L_0x0010
            byte[] r3 = r2.zzbky     // Catch:{ all -> 0x0068 }
            monitor-exit(r2)     // Catch:{ all -> 0x0068 }
            return r3
        L_0x0010:
            java.nio.ByteBuffer r0 = r2.zzbkv     // Catch:{ all -> 0x0068 }
            if (r0 == 0) goto L_0x005c
            if (r3 == 0) goto L_0x001e
            com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata r3 = r2.zzbkw     // Catch:{ all -> 0x0068 }
            int r3 = r3.getRotation()     // Catch:{ all -> 0x0068 }
            if (r3 != 0) goto L_0x005c
        L_0x001e:
            java.nio.ByteBuffer r3 = r2.zzbkv     // Catch:{ all -> 0x0068 }
            byte[] r3 = com.google.android.gms.internal.firebase_ml.zzrh.zza(r3)     // Catch:{ all -> 0x0068 }
            com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata r0 = r2.zzbkw     // Catch:{ all -> 0x0068 }
            int r0 = r0.getFormat()     // Catch:{ all -> 0x0068 }
            r1 = 17
            if (r0 == r1) goto L_0x0040
            r1 = 842094169(0x32315659, float:1.0322389E-8)
            if (r0 != r1) goto L_0x0038
            byte[] r3 = com.google.android.gms.internal.firebase_ml.zzrh.zzf(r3)     // Catch:{ all -> 0x0068 }
            goto L_0x0040
        L_0x0038:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0068 }
            java.lang.String r0 = "Must be one of: IMAGE_FORMAT_NV21, IMAGE_FORMAT_YV12"
            r3.<init>(r0)     // Catch:{ all -> 0x0068 }
            throw r3     // Catch:{ all -> 0x0068 }
        L_0x0040:
            com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata r0 = r2.zzbkw     // Catch:{ all -> 0x0068 }
            int r0 = r0.getWidth()     // Catch:{ all -> 0x0068 }
            com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata r1 = r2.zzbkw     // Catch:{ all -> 0x0068 }
            int r1 = r1.getHeight()     // Catch:{ all -> 0x0068 }
            byte[] r3 = com.google.android.gms.internal.firebase_ml.zzrh.zza(r3, r0, r1)     // Catch:{ all -> 0x0068 }
            com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata r0 = r2.zzbkw     // Catch:{ all -> 0x0068 }
            int r0 = r0.getRotation()     // Catch:{ all -> 0x0068 }
            if (r0 != 0) goto L_0x005a
            r2.zzbky = r3     // Catch:{ all -> 0x0068 }
        L_0x005a:
            monitor-exit(r2)     // Catch:{ all -> 0x0068 }
            return r3
        L_0x005c:
            android.graphics.Bitmap r3 = r2.zzpv()     // Catch:{ all -> 0x0068 }
            byte[] r3 = com.google.android.gms.internal.firebase_ml.zzrh.zza(r3)     // Catch:{ all -> 0x0068 }
            r2.zzbky = r3     // Catch:{ all -> 0x0068 }
            monitor-exit(r2)     // Catch:{ all -> 0x0068 }
            return r3
        L_0x0068:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0068 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.ml.vision.common.FirebaseVisionImage.zzau(boolean):byte[]");
    }

    public final void zzpw() {
        if (this.zzbkv != null) {
            ByteBuffer byteBuffer = this.zzbkv;
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
            byteBuffer.rewind();
            allocate.put(byteBuffer);
            byteBuffer.rewind();
            allocate.flip();
            this.zzbkv = allocate;
        }
    }

    public final synchronized Frame zza(boolean z, boolean z2) {
        int i = 0;
        Preconditions.checkArgument(!z || !z2, "Can't restrict to bitmap-only and NV21 byte buffer-only");
        if (this.zzbkx == null) {
            Frame.Builder builder = new Frame.Builder();
            if (this.zzbkv == null || z) {
                builder.setBitmap(zzpv());
            } else {
                int i2 = FirebaseVisionImageMetadata.IMAGE_FORMAT_YV12;
                if (z2 && this.zzbkw.getFormat() != 17) {
                    if (this.zzbkw.getFormat() == 842094169) {
                        this.zzbkv = ByteBuffer.wrap(zzrh.zzf(zzrh.zza(this.zzbkv)));
                        this.zzbkw = new FirebaseVisionImageMetadata.Builder().setFormat(17).setWidth(this.zzbkw.getWidth()).setHeight(this.zzbkw.getHeight()).setRotation(this.zzbkw.getRotation()).build();
                    } else {
                        throw new IllegalStateException("Must be one of: IMAGE_FORMAT_NV21, IMAGE_FORMAT_YV12");
                    }
                }
                ByteBuffer byteBuffer = this.zzbkv;
                int width = this.zzbkw.getWidth();
                int height = this.zzbkw.getHeight();
                int format = this.zzbkw.getFormat();
                if (format == 17) {
                    i2 = 17;
                } else if (format != 842094169) {
                    i2 = 0;
                }
                builder.setImageData(byteBuffer, width, height, i2);
                int rotation = this.zzbkw.getRotation();
                if (rotation != 0) {
                    if (rotation == 1) {
                        i = 1;
                    } else if (rotation == 2) {
                        i = 2;
                    } else if (rotation == 3) {
                        i = 3;
                    } else {
                        StringBuilder sb = new StringBuilder(29);
                        sb.append("Invalid rotation: ");
                        sb.append(rotation);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                builder.setRotation(i);
            }
            builder.setTimestampMillis(this.zzbkz);
            this.zzbkx = builder.build();
        }
        return this.zzbkx;
    }
}
