package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i, int i2, int i3) {
        boolean z;
        float f;
        float f2;
        int i4;
        int i5;
        BinaryBitmap binaryBitmap2 = binaryBitmap;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        if (i8 <= 4) {
            try {
                Result decode = this.delegate.decode(binaryBitmap2, map);
                Iterator<Result> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getText().equals(decode.getText())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    list.add(translateResultPoints(decode, i6, i7));
                }
                ResultPoint[] resultPoints = decode.getResultPoints();
                if (resultPoints != null && resultPoints.length != 0) {
                    int width = binaryBitmap.getWidth();
                    int height = binaryBitmap.getHeight();
                    float f3 = (float) width;
                    float f4 = 0.0f;
                    float f5 = (float) height;
                    float f6 = 0.0f;
                    for (ResultPoint resultPoint : resultPoints) {
                        if (resultPoint != null) {
                            float x = resultPoint.getX();
                            float y = resultPoint.getY();
                            if (x < f3) {
                                f3 = x;
                            }
                            if (y < f5) {
                                f5 = y;
                            }
                            if (x > f6) {
                                f6 = x;
                            }
                            if (y > f4) {
                                f4 = y;
                            }
                        }
                    }
                    if (f3 > 100.0f) {
                        f = f6;
                        f2 = f5;
                        i5 = height;
                        i4 = width;
                        doDecodeMultiple(binaryBitmap2.crop(0, 0, (int) f3, height), map, list, i, i2, i8 + 1);
                    } else {
                        f = f6;
                        f2 = f5;
                        i5 = height;
                        i4 = width;
                    }
                    if (f2 > 100.0f) {
                        doDecodeMultiple(binaryBitmap2.crop(0, 0, i4, (int) f2), map, list, i, i2, i8 + 1);
                    }
                    float f7 = f;
                    if (f7 < ((float) (i4 - 100))) {
                        int i9 = (int) f7;
                        doDecodeMultiple(binaryBitmap2.crop(i9, 0, i4 - i9, i5), map, list, i6 + i9, i2, i8 + 1);
                    }
                    if (f4 < ((float) (i5 - 100))) {
                        int i10 = (int) f4;
                        doDecodeMultiple(binaryBitmap2.crop(0, i10, i4, i5 - i10), map, list, i, i7 + i10, i8 + 1);
                    }
                }
            } catch (ReaderException unused) {
            }
        }
    }

    private static Result translateResultPoints(Result result, int i, int i2) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i3 = 0; i3 < resultPoints.length; i3++) {
            ResultPoint resultPoint = resultPoints[i3];
            if (resultPoint != null) {
                resultPointArr[i3] = new ResultPoint(resultPoint.getX() + ((float) i), resultPoint.getY() + ((float) i2));
            }
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), resultPointArr, result.getBarcodeFormat());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }
}
