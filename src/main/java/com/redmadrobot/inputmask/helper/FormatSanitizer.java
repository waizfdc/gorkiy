package com.redmadrobot.inputmask.helper;

import androidx.exifinterface.media.ExifInterface;
import com.redmadrobot.inputmask.helper.Compiler;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002¨\u0006\u000e"}, d2 = {"Lcom/redmadrobot/inputmask/helper/FormatSanitizer;", "", "()V", "checkOpenBraces", "", "string", "", "divideBlocksWithMixedCharacters", "", "blocks", "getFormatBlocks", "formatString", "sanitize", "sortFormatBlocks", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: FormatSanitizer.kt */
public final class FormatSanitizer {
    public final String sanitize(String str) throws Compiler.FormatError {
        Intrinsics.checkParameterIsNotNull(str, "formatString");
        checkOpenBraces(str);
        return CollectionsKt.joinToString$default(sortFormatBlocks(divideBlocksWithMixedCharacters(getFormatBlocks(str))), "", null, null, 0, null, null, 62, null);
    }

    private final List<String> getFormatBlocks(String str) {
        List<String> arrayList = new ArrayList<>();
        if (str != null) {
            char[] charArray = str.toCharArray();
            Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
            int length = charArray.length;
            boolean z = false;
            String str2 = "";
            int i = 0;
            boolean z2 = false;
            while (true) {
                boolean z3 = true;
                if (i >= length) {
                    break;
                }
                char c = charArray[i];
                if ('\\' != c || z2) {
                    if (('[' == c || '{' == c) && !z2) {
                        if (str2.length() <= 0) {
                            z3 = false;
                        }
                        if (z3) {
                            arrayList.add(str2);
                        }
                        str2 = "";
                    }
                    str2 = str2 + c;
                    if ((']' == c || '}' == c) && !z2) {
                        arrayList.add(str2);
                        str2 = "";
                    }
                    z2 = false;
                } else {
                    str2 = str2 + c;
                    z2 = true;
                }
                i++;
            }
            if (str2.length() == 0) {
                z = true;
            }
            if (!z) {
                arrayList.add(str2);
            }
            return arrayList;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.text.StringsKt__StringsJVMKt.startsWith$default(java.lang.String, java.lang.String, boolean, int, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String, int, int, ?[OBJECT, ARRAY]]
     candidates:
      kotlin.text.StringsKt__StringsKt.startsWith$default(java.lang.CharSequence, char, boolean, int, java.lang.Object):boolean
      kotlin.text.StringsKt__StringsKt.startsWith$default(java.lang.CharSequence, java.lang.CharSequence, boolean, int, java.lang.Object):boolean
      kotlin.text.StringsKt__StringsJVMKt.startsWith$default(java.lang.String, java.lang.String, boolean, int, java.lang.Object):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.text.StringsKt__StringsJVMKt.endsWith$default(java.lang.String, java.lang.String, boolean, int, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String, int, int, ?[OBJECT, ARRAY]]
     candidates:
      kotlin.text.StringsKt__StringsKt.endsWith$default(java.lang.CharSequence, char, boolean, int, java.lang.Object):boolean
      kotlin.text.StringsKt__StringsKt.endsWith$default(java.lang.CharSequence, java.lang.CharSequence, boolean, int, java.lang.Object):boolean
      kotlin.text.StringsKt__StringsJVMKt.endsWith$default(java.lang.String, java.lang.String, boolean, int, java.lang.Object):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, java.lang.CharSequence, boolean, int, java.lang.Object):boolean
     arg types: [java.lang.CharSequence, java.lang.String, int, int, ?[OBJECT, ARRAY]]
     candidates:
      kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, char, boolean, int, java.lang.Object):boolean
      kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, java.lang.CharSequence, boolean, int, java.lang.Object):boolean */
    private final List<String> divideBlocksWithMixedCharacters(List<String> list) {
        Iterator<String> it;
        int i;
        Iterator<String> it2;
        String str;
        List<String> arrayList = new ArrayList<>();
        Iterator<String> it3 = list.iterator();
        while (it3.hasNext()) {
            String next = it3.next();
            if (StringsKt.startsWith$default(next, "[", false, 2, (Object) null)) {
                int length = next.length();
                String str2 = "";
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    char charAt = next.charAt(i2);
                    if (charAt != '[') {
                        if (charAt == ']' && !StringsKt.endsWith$default(str2, "\\", false, 2, (Object) null)) {
                            arrayList.add(str2 + charAt);
                            break;
                        }
                        if (charAt == '0' || charAt == '9') {
                            CharSequence charSequence = str2;
                            it2 = it3;
                            if (StringsKt.contains$default(charSequence, (CharSequence) ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) "a", false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) "-", false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR, false, 2, (Object) null)) {
                                i = length;
                                arrayList.add(str2 + "]");
                                StringBuilder sb = new StringBuilder();
                                sb.append('[');
                                sb.append(charAt);
                                str = sb.toString();
                                str2 = str;
                            }
                        } else {
                            it2 = it3;
                        }
                        if (charAt == 'A' || charAt == 'a') {
                            CharSequence charSequence2 = str2;
                            i = length;
                            if (StringsKt.contains$default(charSequence2, (CharSequence) "0", false, 2, (Object) null) || StringsKt.contains$default(charSequence2, (CharSequence) "9", false, 2, (Object) null) || StringsKt.contains$default(charSequence2, (CharSequence) "-", false, 2, (Object) null) || StringsKt.contains$default(charSequence2, (CharSequence) EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR, false, 2, (Object) null)) {
                                arrayList.add(str2 + "]");
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append('[');
                                sb2.append(charAt);
                                str = sb2.toString();
                                str2 = str;
                            }
                        } else {
                            i = length;
                        }
                        if (charAt == '-' || charAt == '_') {
                            CharSequence charSequence3 = str2;
                            if (StringsKt.contains$default(charSequence3, (CharSequence) "0", false, 2, (Object) null) || StringsKt.contains$default(charSequence3, (CharSequence) "9", false, 2, (Object) null) || StringsKt.contains$default(charSequence3, (CharSequence) ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, false, 2, (Object) null) || StringsKt.contains$default(charSequence3, (CharSequence) "a", false, 2, (Object) null)) {
                                arrayList.add(str2 + "]");
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append('[');
                                sb3.append(charAt);
                                str = sb3.toString();
                                str2 = str;
                            }
                        }
                        str = str2 + charAt;
                        str2 = str;
                    } else {
                        str2 = str2 + charAt;
                        it2 = it3;
                        i = length;
                    }
                    i2++;
                    it3 = it2;
                    length = i;
                }
                it = it3;
            } else {
                it = it3;
                arrayList.add(next);
            }
            it3 = it;
        }
        return arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.text.StringsKt__StringsJVMKt.startsWith$default(java.lang.String, java.lang.String, boolean, int, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String, int, int, ?[OBJECT, ARRAY]]
     candidates:
      kotlin.text.StringsKt__StringsKt.startsWith$default(java.lang.CharSequence, char, boolean, int, java.lang.Object):boolean
      kotlin.text.StringsKt__StringsKt.startsWith$default(java.lang.CharSequence, java.lang.CharSequence, boolean, int, java.lang.Object):boolean
      kotlin.text.StringsKt__StringsJVMKt.startsWith$default(java.lang.String, java.lang.String, boolean, int, java.lang.Object):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, java.lang.CharSequence, boolean, int, java.lang.Object):boolean
     arg types: [java.lang.CharSequence, java.lang.String, int, int, ?[OBJECT, ARRAY]]
     candidates:
      kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, char, boolean, int, java.lang.Object):boolean
      kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, java.lang.CharSequence, boolean, int, java.lang.Object):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, java.lang.String, java.lang.String, boolean, int, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String, java.lang.String, int, int, ?[OBJECT, ARRAY]]
     candidates:
      kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, char, char, boolean, int, java.lang.Object):java.lang.String
      kotlin.text.StringsKt__StringsJVMKt.replace$default(java.lang.String, java.lang.String, java.lang.String, boolean, int, java.lang.Object):java.lang.String */
    private final List<String> sortFormatBlocks(List<String> list) {
        List<String> arrayList = new ArrayList<>();
        for (String next : list) {
            if (StringsKt.startsWith$default(next, "[", false, 2, (Object) null)) {
                CharSequence charSequence = next;
                if (StringsKt.contains$default(charSequence, (CharSequence) "0", false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) "9", false, 2, (Object) null)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[");
                    String replace$default = StringsKt.replace$default(StringsKt.replace$default(next, "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
                    if (replace$default != null) {
                        char[] charArray = replace$default.toCharArray();
                        Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
                        sb.append(CollectionsKt.joinToString$default(ArraysKt.sorted(charArray), "", null, null, 0, null, null, 62, null));
                        sb.append("]");
                        next = sb.toString();
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                } else if (StringsKt.contains$default(charSequence, (CharSequence) "a", false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, false, 2, (Object) null)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[");
                    String replace$default2 = StringsKt.replace$default(StringsKt.replace$default(next, "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
                    if (replace$default2 != null) {
                        char[] charArray2 = replace$default2.toCharArray();
                        Intrinsics.checkExpressionValueIsNotNull(charArray2, "(this as java.lang.String).toCharArray()");
                        sb2.append(CollectionsKt.joinToString$default(ArraysKt.sorted(charArray2), "", null, null, 0, null, null, 62, null));
                        sb2.append("]");
                        next = sb2.toString();
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("[");
                    String replace$default3 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(next, "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null), EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, false, 4, (Object) null), "-", "a", false, 4, (Object) null);
                    if (replace$default3 != null) {
                        char[] charArray3 = replace$default3.toCharArray();
                        Intrinsics.checkExpressionValueIsNotNull(charArray3, "(this as java.lang.String).toCharArray()");
                        sb3.append(CollectionsKt.joinToString$default(ArraysKt.sorted(charArray3), "", null, null, 0, null, null, 62, null));
                        sb3.append("]");
                        next = StringsKt.replace$default(StringsKt.replace$default(sb3.toString(), ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR, false, 4, (Object) null), "a", "-", false, 4, (Object) null);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    private final void checkOpenBraces(String str) {
        if (str != null) {
            char[] charArray = str.toCharArray();
            Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (char c : charArray) {
                if ('\\' == c) {
                    z = !z;
                } else {
                    if ('[' == c) {
                        if (!z2) {
                            z2 = !z;
                        } else {
                            throw new Compiler.FormatError();
                        }
                    }
                    if (']' == c && !z) {
                        z2 = false;
                    }
                    if ('{' == c) {
                        if (!z3) {
                            z3 = !z;
                        } else {
                            throw new Compiler.FormatError();
                        }
                    }
                    if ('}' == c && !z) {
                        z3 = false;
                    }
                    z = false;
                }
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
