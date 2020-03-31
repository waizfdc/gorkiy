package okhttp3.logging;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okio.Buffer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"isProbablyUtf8", "", "Lokio/Buffer;", "okhttp-logging-interceptor"}, k = 2, mv = {1, 1, 16})
/* compiled from: utf8.kt */
public final class Utf8Kt {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.ranges.RangesKt___RangesKt.coerceAtMost(long, long):long
     arg types: [long, int]
     candidates:
      kotlin.ranges.RangesKt___RangesKt.coerceAtMost(byte, byte):byte
      kotlin.ranges.RangesKt___RangesKt.coerceAtMost(double, double):double
      kotlin.ranges.RangesKt___RangesKt.coerceAtMost(float, float):float
      kotlin.ranges.RangesKt___RangesKt.coerceAtMost(int, int):int
      kotlin.ranges.RangesKt___RangesKt.coerceAtMost(java.lang.Comparable, java.lang.Comparable):T
      kotlin.ranges.RangesKt___RangesKt.coerceAtMost(short, short):short
      kotlin.ranges.RangesKt___RangesKt.coerceAtMost(long, long):long */
    public static final boolean isProbablyUtf8(Buffer buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$isProbablyUtf8");
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, RangesKt.coerceAtMost(buffer.size(), 64L));
            for (int i = 0; i < 16; i++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
