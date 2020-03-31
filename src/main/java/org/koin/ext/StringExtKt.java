package org.koin.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0002*\u00020\u0002¨\u0006\u0005"}, d2 = {"isFloat", "", "", "isInt", "quoted", "koin-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: StringExt.kt */
public final class StringExtKt {
    public static final boolean isFloat(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$isFloat");
        return StringsKt.toFloatOrNull(str) != null;
    }

    public static final boolean isInt(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$isInt");
        return StringsKt.toIntOrNull(str) != null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, java.lang.String, java.lang.String, boolean, int, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String, java.lang.String, int, int, ?[OBJECT, ARRAY]]
     candidates:
      kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, char, char, boolean, int, java.lang.Object):java.lang.String
      kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, java.lang.String, java.lang.String, boolean, int, java.lang.Object):java.lang.String */
    public static final String quoted(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$quoted");
        return StringsKt.replace$default(str, "\"", "", false, 4, (Object) null);
    }
}
