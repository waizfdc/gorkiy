package com.redmadrobot.inputmask.helper;

import com.redmadrobot.inputmask.model.CaretString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/redmadrobot/inputmask/helper/RTLCaretStringIterator;", "Lcom/redmadrobot/inputmask/helper/CaretStringIterator;", "caretString", "Lcom/redmadrobot/inputmask/model/CaretString;", "(Lcom/redmadrobot/inputmask/model/CaretString;)V", "insertionAffectsCaret", "", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: RTLCaretStringIterator.kt */
public final class RTLCaretStringIterator extends CaretStringIterator {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RTLCaretStringIterator(CaretString caretString) {
        super(caretString, 0, 2, null);
        Intrinsics.checkParameterIsNotNull(caretString, "caretString");
    }

    public boolean insertionAffectsCaret() {
        return getCurrentIndex() <= getCaretString().getCaretPosition();
    }
}
