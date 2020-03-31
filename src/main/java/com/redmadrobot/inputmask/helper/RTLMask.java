package com.redmadrobot.inputmask.helper;

import com.redmadrobot.inputmask.helper.Mask;
import com.redmadrobot.inputmask.model.CaretString;
import com.redmadrobot.inputmask.model.Notation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/redmadrobot/inputmask/helper/RTLMask;", "Lcom/redmadrobot/inputmask/helper/Mask;", "format", "", "customNotations", "", "Lcom/redmadrobot/inputmask/model/Notation;", "(Ljava/lang/String;Ljava/util/List;)V", "apply", "Lcom/redmadrobot/inputmask/helper/Mask$Result;", "text", "Lcom/redmadrobot/inputmask/model/CaretString;", "makeIterator", "Lcom/redmadrobot/inputmask/helper/CaretStringIterator;", "Factory", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: RTLMask.kt */
public final class RTLMask extends Mask {
    public static final Factory Factory = new Factory(null);
    /* access modifiers changed from: private */
    public static final Map<String, RTLMask> cache = new HashMap();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/redmadrobot/inputmask/helper/RTLMask$Factory;", "", "()V", "cache", "", "", "Lcom/redmadrobot/inputmask/helper/RTLMask;", "getOrCreate", "format", "customNotations", "", "Lcom/redmadrobot/inputmask/model/Notation;", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: RTLMask.kt */
    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RTLMask getOrCreate(String str, List<Notation> list) {
            Intrinsics.checkParameterIsNotNull(str, "format");
            Intrinsics.checkParameterIsNotNull(list, "customNotations");
            RTLMask rTLMask = (RTLMask) RTLMask.cache.get(RTLMaskKt.reversedFormat(str));
            if (rTLMask != null) {
                return rTLMask;
            }
            RTLMask rTLMask2 = new RTLMask(str, list);
            RTLMask.cache.put(RTLMaskKt.reversedFormat(str), rTLMask2);
            return rTLMask2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RTLMask(String str, List<Notation> list) {
        super(RTLMaskKt.reversedFormat(str), list);
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(list, "customNotations");
    }

    public Mask.Result apply(CaretString caretString) {
        Intrinsics.checkParameterIsNotNull(caretString, "text");
        return super.apply(caretString.reversed()).reversed();
    }

    public CaretStringIterator makeIterator(CaretString caretString) {
        Intrinsics.checkParameterIsNotNull(caretString, "text");
        return new RTLCaretStringIterator(caretString);
    }
}
