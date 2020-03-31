package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;

public final class AztecWriter implements Writer {
    private static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, null);
    }

    /* JADX WARN: Type inference failed for: r15v10, types: [java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.common.BitMatrix encode(java.lang.String r11, com.google.zxing.BarcodeFormat r12, int r13, int r14, java.util.Map<com.google.zxing.EncodeHintType, ?> r15) {
        /*
            r10 = this;
            r0 = 0
            if (r15 != 0) goto L_0x0005
            r1 = r0
            goto L_0x000d
        L_0x0005:
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.CHARACTER_SET
            java.lang.Object r1 = r15.get(r1)
            java.lang.String r1 = (java.lang.String) r1
        L_0x000d:
            if (r15 != 0) goto L_0x0011
            r2 = r0
            goto L_0x0019
        L_0x0011:
            com.google.zxing.EncodeHintType r2 = com.google.zxing.EncodeHintType.ERROR_CORRECTION
            java.lang.Object r2 = r15.get(r2)
            java.lang.Number r2 = (java.lang.Number) r2
        L_0x0019:
            if (r15 != 0) goto L_0x001c
            goto L_0x0025
        L_0x001c:
            com.google.zxing.EncodeHintType r0 = com.google.zxing.EncodeHintType.AZTEC_LAYERS
            java.lang.Object r15 = r15.get(r0)
            r0 = r15
            java.lang.Number r0 = (java.lang.Number) r0
        L_0x0025:
            if (r1 != 0) goto L_0x002a
            java.nio.charset.Charset r15 = com.google.zxing.aztec.AztecWriter.DEFAULT_CHARSET
            goto L_0x002e
        L_0x002a:
            java.nio.charset.Charset r15 = java.nio.charset.Charset.forName(r1)
        L_0x002e:
            r7 = r15
            if (r2 != 0) goto L_0x0034
            r15 = 33
            goto L_0x0038
        L_0x0034:
            int r15 = r2.intValue()
        L_0x0038:
            r8 = r15
            if (r0 != 0) goto L_0x003d
            r15 = 0
            goto L_0x0041
        L_0x003d:
            int r15 = r0.intValue()
        L_0x0041:
            r9 = r15
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            com.google.zxing.common.BitMatrix r11 = encode(r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.AztecWriter.encode(java.lang.String, com.google.zxing.BarcodeFormat, int, int, java.util.Map):com.google.zxing.common.BitMatrix");
    }

    private static BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return renderResult(Encoder.encode(str.getBytes(charset), i3, i4), i, i2);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    private static BitMatrix renderResult(AztecCode aztecCode, int i, int i2) {
        BitMatrix matrix = aztecCode.getMatrix();
        if (matrix != null) {
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int max = Math.max(i, width);
            int max2 = Math.max(i2, height);
            int min = Math.min(max / width, max2 / height);
            int i3 = (max - (width * min)) / 2;
            int i4 = (max2 - (height * min)) / 2;
            BitMatrix bitMatrix = new BitMatrix(max, max2);
            int i5 = 0;
            while (i5 < height) {
                int i6 = 0;
                int i7 = i3;
                while (i6 < width) {
                    if (matrix.get(i6, i5)) {
                        bitMatrix.setRegion(i7, i4, min, min);
                    }
                    i6++;
                    i7 += min;
                }
                i5++;
                i4 += min;
            }
            return bitMatrix;
        }
        throw new IllegalStateException();
    }
}
