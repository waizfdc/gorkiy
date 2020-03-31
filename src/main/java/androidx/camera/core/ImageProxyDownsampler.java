package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.ImageProxy;
import java.nio.ByteBuffer;

final class ImageProxyDownsampler {

    enum DownsamplingMethod {
        NEAREST_NEIGHBOR,
        AVERAGING
    }

    private ImageProxyDownsampler() {
    }

    static ForwardingImageProxy downsample(ImageProxy imageProxy, int i, int i2, DownsamplingMethod downsamplingMethod) {
        byte[] bArr;
        ImageProxy imageProxy2 = imageProxy;
        int i3 = i;
        int i4 = i2;
        if (imageProxy.getFormat() != 35) {
            throw new UnsupportedOperationException("Only YUV_420_888 format is currently supported.");
        } else if (imageProxy.getWidth() < i3 || imageProxy.getHeight() < i4) {
            throw new IllegalArgumentException("Downsampled dimension " + new Size(i3, i4) + " is not <= original dimension " + new Size(imageProxy.getWidth(), imageProxy.getHeight()) + ".");
        } else if (imageProxy.getWidth() == i3 && imageProxy.getHeight() == i4) {
            return new ForwardingImageProxyImpl(imageProxy2, imageProxy.getPlanes(), i3, i4);
        } else {
            int[] iArr = {imageProxy.getWidth(), imageProxy.getWidth() / 2, imageProxy.getWidth() / 2};
            int[] iArr2 = {imageProxy.getHeight(), imageProxy.getHeight() / 2, imageProxy.getHeight() / 2};
            int i5 = i3 / 2;
            int[] iArr3 = {i3, i5, i5};
            int i6 = i4 / 2;
            int[] iArr4 = {i4, i6, i6};
            ImageProxy.PlaneProxy[] planeProxyArr = new ImageProxy.PlaneProxy[3];
            for (int i7 = 0; i7 < 3; i7++) {
                ImageProxy.PlaneProxy planeProxy = imageProxy.getPlanes()[i7];
                ByteBuffer buffer = planeProxy.getBuffer();
                byte[] bArr2 = new byte[(iArr3[i7] * iArr4[i7])];
                int i8 = AnonymousClass2.$SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod[downsamplingMethod.ordinal()];
                if (i8 == 1) {
                    bArr = bArr2;
                    resizeNearestNeighbor(buffer, iArr[i7], planeProxy.getPixelStride(), planeProxy.getRowStride(), iArr2[i7], bArr, iArr3[i7], iArr4[i7]);
                } else if (i8 != 2) {
                    bArr = bArr2;
                } else {
                    int i9 = iArr[i7];
                    int pixelStride = planeProxy.getPixelStride();
                    bArr = bArr2;
                    resizeAveraging(buffer, i9, pixelStride, planeProxy.getRowStride(), iArr2[i7], bArr, iArr3[i7], iArr4[i7]);
                }
                planeProxyArr[i7] = createPlaneProxy(iArr3[i7], 1, bArr);
            }
            return new ForwardingImageProxyImpl(imageProxy2, planeProxyArr, i3, i4);
        }
    }

    /* renamed from: androidx.camera.core.ImageProxyDownsampler$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.camera.core.ImageProxyDownsampler$DownsamplingMethod[] r0 = androidx.camera.core.ImageProxyDownsampler.DownsamplingMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.camera.core.ImageProxyDownsampler.AnonymousClass2.$SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod = r0
                androidx.camera.core.ImageProxyDownsampler$DownsamplingMethod r1 = androidx.camera.core.ImageProxyDownsampler.DownsamplingMethod.NEAREST_NEIGHBOR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = androidx.camera.core.ImageProxyDownsampler.AnonymousClass2.$SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.ImageProxyDownsampler$DownsamplingMethod r1 = androidx.camera.core.ImageProxyDownsampler.DownsamplingMethod.AVERAGING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageProxyDownsampler.AnonymousClass2.<clinit>():void");
        }
    }

    private static void resizeNearestNeighbor(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6) {
        float f = ((float) i) / ((float) i5);
        float f2 = ((float) i4) / ((float) i6);
        byte[] bArr2 = new byte[i3];
        int[] iArr = new int[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            iArr[i7] = ((int) (((float) i7) * f)) * i2;
        }
        synchronized (byteBuffer) {
            byteBuffer.rewind();
            for (int i8 = 0; i8 < i6; i8++) {
                int i9 = i8 * i5;
                byteBuffer.position(Math.min((int) (((float) i8) * f2), i4 - 1) * i3);
                byteBuffer.get(bArr2, 0, Math.min(i3, byteBuffer.remaining()));
                for (int i10 = 0; i10 < i5; i10++) {
                    bArr[i9 + i10] = bArr2[iArr[i10]];
                }
            }
        }
    }

    private static void resizeAveraging(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int i7 = i3;
        int i8 = i4;
        int i9 = i5;
        int i10 = i6;
        float f = ((float) i) / ((float) i9);
        float f2 = ((float) i8) / ((float) i10);
        byte[] bArr2 = new byte[i7];
        byte[] bArr3 = new byte[i7];
        int[] iArr = new int[i9];
        int i11 = 0;
        for (int i12 = 0; i12 < i9; i12++) {
            iArr[i12] = ((int) (((float) i12) * f)) * i2;
        }
        synchronized (byteBuffer) {
            byteBuffer.rewind();
            int i13 = 0;
            while (i13 < i10) {
                int i14 = (int) (((float) i13) * f2);
                int i15 = i8 - 1;
                int i16 = i13 * i9;
                byteBuffer2.position(Math.min(i14, i15) * i7);
                byteBuffer2.get(bArr2, i11, Math.min(i7, byteBuffer.remaining()));
                byteBuffer2.position(Math.min(i14 + 1, i15) * i7);
                byteBuffer2.get(bArr3, i11, Math.min(i7, byteBuffer.remaining()));
                for (int i17 = i11; i17 < i9; i17++) {
                    bArr[i16 + i17] = (byte) ((((((bArr2[iArr[i17]] & 255) + (bArr2[iArr[i17] + i2] & 255)) + (bArr3[iArr[i17]] & 255)) + (bArr3[iArr[i17] + i2] & 255)) / 4) & 255);
                }
                i13++;
                i11 = 0;
            }
        }
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(final int i, final int i2, final byte[] bArr) {
        return new ImageProxy.PlaneProxy() {
            /* class androidx.camera.core.ImageProxyDownsampler.AnonymousClass1 */
            final ByteBuffer mBuffer = ByteBuffer.wrap(bArr);

            public int getRowStride() {
                return i;
            }

            public int getPixelStride() {
                return i2;
            }

            public ByteBuffer getBuffer() {
                return this.mBuffer;
            }
        };
    }

    private static final class ForwardingImageProxyImpl extends ForwardingImageProxy {
        private final int mDownsampledHeight;
        private final ImageProxy.PlaneProxy[] mDownsampledPlanes;
        private final int mDownsampledWidth;

        ForwardingImageProxyImpl(ImageProxy imageProxy, ImageProxy.PlaneProxy[] planeProxyArr, int i, int i2) {
            super(imageProxy);
            this.mDownsampledPlanes = planeProxyArr;
            this.mDownsampledWidth = i;
            this.mDownsampledHeight = i2;
        }

        public synchronized int getWidth() {
            return this.mDownsampledWidth;
        }

        public synchronized int getHeight() {
            return this.mDownsampledHeight;
        }

        public synchronized ImageProxy.PlaneProxy[] getPlanes() {
            return this.mDownsampledPlanes;
        }
    }
}
