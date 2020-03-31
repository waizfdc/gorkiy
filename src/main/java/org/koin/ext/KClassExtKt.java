package org.koin.ext;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0002\"\u001e\u0010\u0000\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"classNames", "", "Lkotlin/reflect/KClass;", "", "getFullName", "saveCache", "koin-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: KClassExt.kt */
public final class KClassExtKt {
    private static final Map<KClass<?>, String> classNames = new ConcurrentHashMap();

    public static final String getFullName(KClass<?> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "$this$getFullName");
        String str = classNames.get(kClass);
        return str != null ? str : saveCache(kClass);
    }

    public static final String saveCache(KClass<?> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "$this$saveCache");
        String name = JvmClassMappingKt.getJavaClass((KClass) kClass).getName();
        Map<KClass<?>, String> map = classNames;
        Intrinsics.checkExpressionValueIsNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
        map.put(kClass, name);
        return name;
    }
}
