package com.redmadrobot.inputmask.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¨\u0006\u0003"}, d2 = {"reversedFormat", "", "format", "input-mask-android_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: RTLMask.kt */
public final class RTLMaskKt {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, java.lang.String, java.lang.String, boolean, int, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String, java.lang.String, int, int, ?[OBJECT, ARRAY]]
     candidates:
      kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, char, char, boolean, int, java.lang.Object):java.lang.String
      kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, java.lang.String, java.lang.String, boolean, int, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    public static final String reversedFormat(String str) {
        if (str != null) {
            CharSequence replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.reversed((CharSequence) str).toString(), "[\\", "\\]", false, 4, (Object) null), "]\\", "\\[", false, 4, (Object) null), "{\\", "\\}", false, 4, (Object) null), "}\\", "\\{", false, 4, (Object) null);
            Collection arrayList = new ArrayList(replace$default.length());
            for (int i = 0; i < replace$default.length(); i++) {
                char charAt = replace$default.charAt(i);
                if (charAt == '[') {
                    charAt = ']';
                } else if (charAt == ']') {
                    charAt = '[';
                } else if (charAt == '{') {
                    charAt = '}';
                } else if (charAt == '}') {
                    charAt = '{';
                }
                arrayList.add(Character.valueOf(charAt));
            }
            return CollectionsKt.joinToString$default((List) arrayList, "", null, null, 0, null, null, 62, null);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
