package com.redmadrobot.inputmask.helper;

import com.redmadrobot.inputmask.model.CaretString;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/redmadrobot/inputmask/helper/AffinityCalculationStrategy;", "", "(Ljava/lang/String;I)V", "calculateAffinityOfMask", "", "mask", "Lcom/redmadrobot/inputmask/helper/Mask;", "text", "Lcom/redmadrobot/inputmask/model/CaretString;", "prefixIntersection", "", "another", "WHOLE_STRING", "PREFIX", "CAPACITY", "EXTRACTED_VALUE_CAPACITY", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: AffinityCalculationStrategy.kt */
public enum AffinityCalculationStrategy {
    WHOLE_STRING,
    PREFIX,
    CAPACITY,
    EXTRACTED_VALUE_CAPACITY;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AffinityCalculationStrategy.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AffinityCalculationStrategy.WHOLE_STRING.ordinal()] = 1;
            $EnumSwitchMapping$0[AffinityCalculationStrategy.PREFIX.ordinal()] = 2;
            $EnumSwitchMapping$0[AffinityCalculationStrategy.CAPACITY.ordinal()] = 3;
            $EnumSwitchMapping$0[AffinityCalculationStrategy.EXTRACTED_VALUE_CAPACITY.ordinal()] = 4;
        }
    }

    public final int calculateAffinityOfMask(Mask mask, CaretString caretString) {
        int i;
        int i2;
        Intrinsics.checkParameterIsNotNull(mask, "mask");
        Intrinsics.checkParameterIsNotNull(caretString, "text");
        int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i3 == 1) {
            return mask.apply(caretString).getAffinity();
        }
        if (i3 == 2) {
            return prefixIntersection(mask.apply(caretString).getFormattedText().getString(), caretString.getString()).length();
        }
        if (i3 != 3) {
            if (i3 == 4) {
                i = mask.apply(caretString).getExtractedValue().length();
                if (i > mask.totalValueLength()) {
                    return Integer.MIN_VALUE;
                }
                i2 = mask.totalValueLength();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (caretString.getString().length() > mask.totalTextLength()) {
            return Integer.MIN_VALUE;
        } else {
            i = caretString.getString().length();
            i2 = mask.totalTextLength();
        }
        return i - i2;
    }

    private final String prefixIntersection(String str, String str2) {
        boolean z = true;
        if (str.length() == 0) {
            return "";
        }
        if (str2.length() != 0) {
            z = false;
        }
        if (z) {
            return "";
        }
        int i = 0;
        while (i < str.length() && i < str2.length()) {
            if (str.charAt(i) == str2.charAt(i)) {
                i++;
            } else if (str != null) {
                String substring = str.substring(0, i);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        if (str != null) {
            String substring2 = str.substring(0, i);
            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring2;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
