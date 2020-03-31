package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: RawType.kt */
final class RawTypeImpl$render$3 extends Lambda implements Function2<String, String, String> {
    public static final RawTypeImpl$render$3 INSTANCE = new RawTypeImpl$render$3();

    RawTypeImpl$render$3() {
        super(2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, char, boolean, int, java.lang.Object):boolean
     arg types: [java.lang.String, ?, int, int, ?[OBJECT, ARRAY]]
     candidates:
      kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, java.lang.CharSequence, boolean, int, java.lang.Object):boolean
      kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, char, boolean, int, java.lang.Object):boolean */
    public final String invoke(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$replaceArgs");
        Intrinsics.checkParameterIsNotNull(str2, "newArgs");
        if (!StringsKt.contains$default((CharSequence) str, (char) Typography.less, false, 2, (Object) null)) {
            return str;
        }
        return StringsKt.substringBefore$default(str, (char) Typography.less, (String) null, 2, (Object) null) + ((char) Typography.less) + str2 + ((char) Typography.greater) + StringsKt.substringAfterLast$default(str, (char) Typography.greater, (String) null, 2, (Object) null);
    }
}
