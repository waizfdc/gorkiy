package com.askgps.personaltrackercore.utils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/askgps/personaltrackercore/utils/Periodic;", ExifInterface.GPS_DIRECTION_TRUE, "", "periodicResultAsync", "Lkotlinx/coroutines/Deferred;", "period", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Utils.kt */
public interface Periodic<T> {
    Deferred<T> periodicResultAsync(long j);
}
