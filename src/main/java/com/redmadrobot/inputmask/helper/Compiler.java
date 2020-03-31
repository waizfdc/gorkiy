package com.redmadrobot.inputmask.helper;

import com.redmadrobot.inputmask.model.Notation;
import com.redmadrobot.inputmask.model.State;
import com.redmadrobot.inputmask.model.state.EOLState;
import com.redmadrobot.inputmask.model.state.FixedState;
import com.redmadrobot.inputmask.model.state.FreeState;
import com.redmadrobot.inputmask.model.state.OptionalValueState;
import com.redmadrobot.inputmask.model.state.ValueState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ/\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0017\u0010\u0013\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Compiler;", "", "customNotations", "", "Lcom/redmadrobot/inputmask/model/Notation;", "(Ljava/util/List;)V", "compile", "Lcom/redmadrobot/inputmask/model/State;", "formatString", "", "valuable", "", "fixed", "lastCharacter", "", "(Ljava/lang/String;ZZLjava/lang/Character;)Lcom/redmadrobot/inputmask/model/State;", "compileWithCustomNotations", "char", "string", "determineInheritedType", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "(Ljava/lang/Character;)Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "determineTypeWithCustomNotations", "FormatError", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Compiler.kt */
public final class Compiler {
    private final List<Notation> customNotations;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Compiler$FormatError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: Compiler.kt */
    public static final class FormatError extends Exception {
    }

    public Compiler(List<Notation> list) {
        Intrinsics.checkParameterIsNotNull(list, "customNotations");
        this.customNotations = list;
    }

    public final State compile(String str) throws FormatError {
        Intrinsics.checkParameterIsNotNull(str, "formatString");
        return compile(new FormatSanitizer().sanitize(str), false, false, null);
    }

    private final State compile(String str, boolean z, boolean z2, Character ch) {
        CharSequence charSequence = str;
        if (charSequence.length() == 0) {
            return new EOLState();
        }
        char first = StringsKt.first(charSequence);
        if (first != '{') {
            if (first != '}') {
                switch (first) {
                    case '[':
                        if (ch == null || '\\' != ch.charValue()) {
                            return compile(StringsKt.drop(str, 1), true, false, Character.valueOf(first));
                        }
                    case '\\':
                        if (ch == null || '\\' != ch.charValue()) {
                            return compile(StringsKt.drop(str, 1), z, z2, Character.valueOf(first));
                        }
                    case ']':
                        if (ch == null || '\\' != ch.charValue()) {
                            return compile(StringsKt.drop(str, 1), false, false, Character.valueOf(first));
                        }
                }
            } else if (ch == null || '\\' != ch.charValue()) {
                return compile(StringsKt.drop(str, 1), false, false, Character.valueOf(first));
            }
        } else if (ch == null || '\\' != ch.charValue()) {
            return compile(StringsKt.drop(str, 1), false, true, Character.valueOf(first));
        }
        if (z) {
            if (first == '-') {
                return new OptionalValueState(compile(StringsKt.drop(str, 1), true, false, Character.valueOf(first)), new OptionalValueState.StateType.AlphaNumeric());
            }
            if (first == '0') {
                return new ValueState(compile(StringsKt.drop(str, 1), true, false, Character.valueOf(first)), new ValueState.StateType.Numeric());
            }
            if (first == '9') {
                return new OptionalValueState(compile(StringsKt.drop(str, 1), true, false, Character.valueOf(first)), new OptionalValueState.StateType.Numeric());
            }
            if (first == 'A') {
                return new ValueState(compile(StringsKt.drop(str, 1), true, false, Character.valueOf(first)), new ValueState.StateType.Literal());
            }
            if (first == '_') {
                return new ValueState(compile(StringsKt.drop(str, 1), true, false, Character.valueOf(first)), new ValueState.StateType.AlphaNumeric());
            }
            if (first == 'a') {
                return new OptionalValueState(compile(StringsKt.drop(str, 1), true, false, Character.valueOf(first)), new OptionalValueState.StateType.Literal());
            }
            if (first != 8230) {
                return compileWithCustomNotations(first, str);
            }
            return new ValueState(determineInheritedType(ch));
        } else if (z2) {
            return new FixedState(compile(StringsKt.drop(str, 1), false, true, Character.valueOf(first)), first);
        } else {
            return new FreeState(compile(StringsKt.drop(str, 1), false, false, Character.valueOf(first)), first);
        }
    }

    private final ValueState.StateType determineInheritedType(Character ch) {
        if ((ch != null && ch.charValue() == '0') || (ch != null && ch.charValue() == '9')) {
            return new ValueState.StateType.Numeric();
        }
        if ((ch != null && ch.charValue() == 'A') || (ch != null && ch.charValue() == 'a')) {
            return new ValueState.StateType.Literal();
        }
        if ((ch != null && ch.charValue() == '_') || (ch != null && ch.charValue() == '-')) {
            return new ValueState.StateType.AlphaNumeric();
        }
        if (ch != null && ch.charValue() == 8230) {
            return new ValueState.StateType.AlphaNumeric();
        }
        if (ch != null && ch.charValue() == '[') {
            return new ValueState.StateType.AlphaNumeric();
        }
        return determineTypeWithCustomNotations(ch);
    }

    private final State compileWithCustomNotations(char c, String str) {
        for (Notation next : this.customNotations) {
            if (next.getCharacter() == c) {
                if (next.isOptional()) {
                    return new OptionalValueState(compile(StringsKt.drop(str, 1), true, false, Character.valueOf(c)), new OptionalValueState.StateType.Custom(c, next.getCharacterSet()));
                }
                return new ValueState(compile(StringsKt.drop(str, 1), true, false, Character.valueOf(c)), new ValueState.StateType.Custom(c, next.getCharacterSet()));
            }
        }
        throw new FormatError();
    }

    private final ValueState.StateType determineTypeWithCustomNotations(Character ch) {
        for (Notation notation : this.customNotations) {
            char character = notation.getCharacter();
            if (ch != null && character == ch.charValue()) {
                return new ValueState.StateType.Custom(ch.charValue(), notation.getCharacterSet());
            }
        }
        throw new FormatError();
    }
}
