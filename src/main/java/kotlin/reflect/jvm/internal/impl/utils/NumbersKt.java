package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: numbers.kt */
public final class NumbersKt {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.text.StringsKt__StringsJVMKt.startsWith$default(java.lang.String, java.lang.String, boolean, int, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String, int, int, ?[OBJECT, ARRAY]]
     candidates:
      kotlin.text.StringsKt__StringsKt.startsWith$default(java.lang.CharSequence, char, boolean, int, java.lang.Object):boolean
      kotlin.text.StringsKt__StringsKt.startsWith$default(java.lang.CharSequence, java.lang.CharSequence, boolean, int, java.lang.Object):boolean
      kotlin.text.StringsKt__StringsJVMKt.startsWith$default(java.lang.String, java.lang.String, boolean, int, java.lang.Object):boolean */
    public static final NumberWithRadix extractRadix(String str) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        if (StringsKt.startsWith$default(str, "0x", false, 2, (Object) null) || StringsKt.startsWith$default(str, "0X", false, 2, (Object) null)) {
            String substring = str.substring(2);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            return new NumberWithRadix(substring, 16);
        } else if (!StringsKt.startsWith$default(str, "0b", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "0B", false, 2, (Object) null)) {
            return new NumberWithRadix(str, 10);
        } else {
            String substring2 = str.substring(2);
            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
            return new NumberWithRadix(substring2, 2);
        }
    }
}
