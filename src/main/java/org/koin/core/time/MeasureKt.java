package org.koin.core.time;

import androidx.exifinterface.media.ExifInterface;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00010\b\"\u0004\b\u0000\u0010\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\t0\u0003\u001a'\u0010\u0007\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\t0\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"measureDuration", "", "code", "Lkotlin/Function0;", "", SettingsJsonConstants.PROMPT_MESSAGE_KEY, "", "measureDurationForResult", "Lkotlin/Pair;", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "koin-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: Measure.kt */
public final class MeasureKt {
    public static final double measureDuration(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "code");
        TimeMark markNow = TimeSource.Monotonic.INSTANCE.markNow();
        function0.invoke();
        return Duration.m970getInMillisecondsimpl(markNow.elapsedNow());
    }

    public static final void measureDuration(String str, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Intrinsics.checkParameterIsNotNull(function0, "code");
        double measureDuration = measureDuration(function0);
        System.out.println((Object) (str + " - " + measureDuration + " ms"));
    }

    public static final <T> Pair<T, Double> measureDurationForResult(Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "code");
        return new Pair<>(function0.invoke(), Double.valueOf(Duration.m970getInMillisecondsimpl(TimeSource.Monotonic.INSTANCE.markNow().elapsedNow())));
    }

    public static final <T> T measureDurationForResult(String str, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Intrinsics.checkParameterIsNotNull(function0, "code");
        Pair<T, Double> measureDurationForResult = measureDurationForResult(function0);
        T component1 = measureDurationForResult.component1();
        double doubleValue = measureDurationForResult.component2().doubleValue();
        System.out.println((Object) (str + " - " + doubleValue + " ms"));
        return component1;
    }
}
