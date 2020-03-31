package com.redmadrobot.inputmask.helper;

import com.google.android.gms.fitness.FitnessActivities;
import com.redmadrobot.inputmask.helper.Compiler;
import com.redmadrobot.inputmask.model.CaretString;
import com.redmadrobot.inputmask.model.Next;
import com.redmadrobot.inputmask.model.Notation;
import com.redmadrobot.inputmask.model.State;
import com.redmadrobot.inputmask.model.state.EOLState;
import com.redmadrobot.inputmask.model.state.FixedState;
import com.redmadrobot.inputmask.model.state.FreeState;
import com.redmadrobot.inputmask.model.state.OptionalValueState;
import com.redmadrobot.inputmask.model.state.ValueState;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001d\u001e\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001c\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/redmadrobot/inputmask/helper/Mask;", "", "format", "", "(Ljava/lang/String;)V", "customNotations", "", "Lcom/redmadrobot/inputmask/model/Notation;", "(Ljava/lang/String;Ljava/util/List;)V", "getCustomNotations", "()Ljava/util/List;", "initialState", "Lcom/redmadrobot/inputmask/model/State;", "acceptableTextLength", "", "acceptableValueLength", "appendPlaceholder", "state", "placeholder", "apply", "Lcom/redmadrobot/inputmask/helper/Mask$Result;", "text", "Lcom/redmadrobot/inputmask/model/CaretString;", "makeIterator", "Lcom/redmadrobot/inputmask/helper/CaretStringIterator;", "noMandatoryCharactersLeftAfterState", "", "totalTextLength", "totalValueLength", "AutocompletionStack", "Factory", "Result", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Mask.kt */
public class Mask {
    public static final Factory Factory = new Factory(null);
    /* access modifiers changed from: private */
    public static final Map<String, Mask> cache = new HashMap();
    private final List<Notation> customNotations;
    private final State initialState;

    public Mask(String str, List<Notation> list) {
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(list, "customNotations");
        this.customNotations = list;
        this.initialState = new Compiler(list).compile(str);
    }

    /* access modifiers changed from: protected */
    public final List<Notation> getCustomNotations() {
        return this.customNotations;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Mask(String str) {
        this(str, CollectionsKt.emptyList());
        Intrinsics.checkParameterIsNotNull(str, "format");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u0000J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Mask$Result;", "", "formattedText", "Lcom/redmadrobot/inputmask/model/CaretString;", "extractedValue", "", "affinity", "", "complete", "", "(Lcom/redmadrobot/inputmask/model/CaretString;Ljava/lang/String;IZ)V", "getAffinity", "()I", "getComplete", "()Z", "getExtractedValue", "()Ljava/lang/String;", "getFormattedText", "()Lcom/redmadrobot/inputmask/model/CaretString;", "component1", "component2", "component3", "component4", "copy", "equals", FitnessActivities.OTHER, "hashCode", "reversed", "toString", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: Mask.kt */
    public static final class Result {
        private final int affinity;
        private final boolean complete;
        private final String extractedValue;
        private final CaretString formattedText;

        public static /* synthetic */ Result copy$default(Result result, CaretString caretString, String str, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                caretString = result.formattedText;
            }
            if ((i2 & 2) != 0) {
                str = result.extractedValue;
            }
            if ((i2 & 4) != 0) {
                i = result.affinity;
            }
            if ((i2 & 8) != 0) {
                z = result.complete;
            }
            return result.copy(caretString, str, i, z);
        }

        public final CaretString component1() {
            return this.formattedText;
        }

        public final String component2() {
            return this.extractedValue;
        }

        public final int component3() {
            return this.affinity;
        }

        public final boolean component4() {
            return this.complete;
        }

        public final Result copy(CaretString caretString, String str, int i, boolean z) {
            Intrinsics.checkParameterIsNotNull(caretString, "formattedText");
            Intrinsics.checkParameterIsNotNull(str, "extractedValue");
            return new Result(caretString, str, i, z);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Result) {
                    Result result = (Result) obj;
                    if (Intrinsics.areEqual(this.formattedText, result.formattedText) && Intrinsics.areEqual(this.extractedValue, result.extractedValue)) {
                        if (this.affinity == result.affinity) {
                            if (this.complete == result.complete) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            CaretString caretString = this.formattedText;
            int i = 0;
            int hashCode = (caretString != null ? caretString.hashCode() : 0) * 31;
            String str = this.extractedValue;
            if (str != null) {
                i = str.hashCode();
            }
            int i2 = (((hashCode + i) * 31) + this.affinity) * 31;
            boolean z = this.complete;
            if (z) {
                z = true;
            }
            return i2 + (z ? 1 : 0);
        }

        public String toString() {
            return "Result(formattedText=" + this.formattedText + ", extractedValue=" + this.extractedValue + ", affinity=" + this.affinity + ", complete=" + this.complete + ")";
        }

        public Result(CaretString caretString, String str, int i, boolean z) {
            Intrinsics.checkParameterIsNotNull(caretString, "formattedText");
            Intrinsics.checkParameterIsNotNull(str, "extractedValue");
            this.formattedText = caretString;
            this.extractedValue = str;
            this.affinity = i;
            this.complete = z;
        }

        public final CaretString getFormattedText() {
            return this.formattedText;
        }

        public final String getExtractedValue() {
            return this.extractedValue;
        }

        public final int getAffinity() {
            return this.affinity;
        }

        public final boolean getComplete() {
            return this.complete;
        }

        public final Result reversed() {
            CaretString reversed = this.formattedText.reversed();
            String str = this.extractedValue;
            if (str != null) {
                return new Result(reversed, StringsKt.reversed((CharSequence) str).toString(), this.affinity, this.complete);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Mask$Factory;", "", "()V", "cache", "", "", "Lcom/redmadrobot/inputmask/helper/Mask;", "getOrCreate", "format", "customNotations", "", "Lcom/redmadrobot/inputmask/model/Notation;", "isValid", "", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: Mask.kt */
    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Mask getOrCreate(String str, List<Notation> list) {
            Intrinsics.checkParameterIsNotNull(str, "format");
            Intrinsics.checkParameterIsNotNull(list, "customNotations");
            Mask mask = (Mask) Mask.cache.get(str);
            if (mask != null) {
                return mask;
            }
            Mask mask2 = new Mask(str, list);
            Mask.cache.put(str, mask2);
            return mask2;
        }

        public final boolean isValid(String str, List<Notation> list) {
            Intrinsics.checkParameterIsNotNull(str, "format");
            Intrinsics.checkParameterIsNotNull(list, "customNotations");
            try {
                new Mask(str, list);
                return true;
            } catch (Compiler.FormatError unused) {
                return false;
            }
        }
    }

    public Result apply(CaretString caretString) {
        Next autocomplete;
        Intrinsics.checkParameterIsNotNull(caretString, "text");
        CaretStringIterator makeIterator = makeIterator(caretString);
        int caretPosition = caretString.getCaretPosition();
        State state = this.initialState;
        AutocompletionStack autocompletionStack = new AutocompletionStack();
        boolean insertionAffectsCaret = makeIterator.insertionAffectsCaret();
        boolean deletionAffectsCaret = makeIterator.deletionAffectsCaret();
        Character next = makeIterator.next();
        int i = 0;
        String str = "";
        String str2 = str;
        while (next != null) {
            Next accept = state.accept(next.charValue());
            if (accept != null) {
                if (deletionAffectsCaret) {
                    autocompletionStack.push(state.autocomplete());
                }
                state = accept.getState();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                Character insert = accept.getInsert();
                if (insert == null) {
                    insert = "";
                }
                sb.append(insert);
                str = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                Character value = accept.getValue();
                if (value == null) {
                    value = "";
                }
                sb2.append(value);
                str2 = sb2.toString();
                if (accept.getPass()) {
                    insertionAffectsCaret = makeIterator.insertionAffectsCaret();
                    deletionAffectsCaret = makeIterator.deletionAffectsCaret();
                    next = makeIterator.next();
                    i++;
                } else if (insertionAffectsCaret && accept.getInsert() != null) {
                    caretPosition++;
                }
            } else {
                if (deletionAffectsCaret) {
                    caretPosition--;
                }
                insertionAffectsCaret = makeIterator.insertionAffectsCaret();
                deletionAffectsCaret = makeIterator.deletionAffectsCaret();
                next = makeIterator.next();
            }
            i--;
        }
        while (caretString.getCaretGravity().getAutocomplete() && insertionAffectsCaret && (autocomplete = state.autocomplete()) != null) {
            state = autocomplete.getState();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            Character insert2 = autocomplete.getInsert();
            if (insert2 == null) {
                insert2 = "";
            }
            sb3.append(insert2);
            str = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str2);
            Character value2 = autocomplete.getValue();
            if (value2 == null) {
                value2 = "";
            }
            sb4.append(value2);
            str2 = sb4.toString();
            if (autocomplete.getInsert() != null) {
                caretPosition++;
            }
        }
        while (caretString.getCaretGravity().getAutoskip() && !autocompletionStack.empty()) {
            Object pop = autocompletionStack.pop();
            Intrinsics.checkExpressionValueIsNotNull(pop, "autocompletionStack.pop()");
            Next next2 = (Next) pop;
            if (str.length() == caretPosition) {
                if (next2.getInsert() != null) {
                    Character insert3 = next2.getInsert();
                    char last = StringsKt.last(str);
                    if (insert3 != null && insert3.charValue() == last) {
                        str = StringsKt.dropLast(str, 1);
                        caretPosition--;
                    }
                }
                if (next2.getValue() != null) {
                    Character value3 = next2.getValue();
                    char last2 = StringsKt.last(str2);
                    if (value3 != null && value3.charValue() == last2) {
                        str2 = StringsKt.dropLast(str2, 1);
                    }
                }
            } else if (next2.getInsert() != null) {
                caretPosition--;
            }
        }
        return new Result(new CaretString(str, caretPosition, caretString.getCaretGravity()), str2, i, noMandatoryCharactersLeftAfterState(state));
    }

    public CaretStringIterator makeIterator(CaretString caretString) {
        Intrinsics.checkParameterIsNotNull(caretString, "text");
        return new CaretStringIterator(caretString, 0, 2, null);
    }

    public final String placeholder() {
        return appendPlaceholder(this.initialState, "");
    }

    public final int acceptableTextLength() {
        State state = this.initialState;
        int i = 0;
        while (state != null && !(state instanceof EOLState)) {
            if ((state instanceof FixedState) || (state instanceof FreeState) || (state instanceof ValueState)) {
                i++;
            }
            state = state.getChild();
        }
        return i;
    }

    public final int totalTextLength() {
        State state = this.initialState;
        int i = 0;
        while (state != null && !(state instanceof EOLState)) {
            if ((state instanceof FixedState) || (state instanceof FreeState) || (state instanceof ValueState) || (state instanceof OptionalValueState)) {
                i++;
            }
            state = state.getChild();
        }
        return i;
    }

    public final int acceptableValueLength() {
        State state = this.initialState;
        int i = 0;
        while (state != null && !(state instanceof EOLState)) {
            if ((state instanceof FixedState) || (state instanceof ValueState)) {
                i++;
            }
            state = state.getChild();
        }
        return i;
    }

    public final int totalValueLength() {
        State state = this.initialState;
        int i = 0;
        while (state != null && !(state instanceof EOLState)) {
            if ((state instanceof FixedState) || (state instanceof ValueState) || (state instanceof OptionalValueState)) {
                i++;
            }
            state = state.getChild();
        }
        return i;
    }

    private final String appendPlaceholder(State state, String str) {
        if (state == null || (state instanceof EOLState)) {
            return str;
        }
        if (state instanceof FixedState) {
            State child = state.getChild();
            return appendPlaceholder(child, str + ((FixedState) state).getOwnCharacter());
        } else if (state instanceof FreeState) {
            State child2 = state.getChild();
            return appendPlaceholder(child2, str + ((FreeState) state).getOwnCharacter());
        } else if (state instanceof OptionalValueState) {
            OptionalValueState optionalValueState = (OptionalValueState) state;
            OptionalValueState.StateType type = optionalValueState.getType();
            if (type instanceof OptionalValueState.StateType.AlphaNumeric) {
                State child3 = state.getChild();
                return appendPlaceholder(child3, str + "-");
            } else if (type instanceof OptionalValueState.StateType.Literal) {
                State child4 = state.getChild();
                return appendPlaceholder(child4, str + "a");
            } else if (type instanceof OptionalValueState.StateType.Numeric) {
                State child5 = state.getChild();
                return appendPlaceholder(child5, str + "0");
            } else if (type instanceof OptionalValueState.StateType.Custom) {
                State child6 = state.getChild();
                return appendPlaceholder(child6, str + ((OptionalValueState.StateType.Custom) optionalValueState.getType()).getCharacter());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!(state instanceof ValueState)) {
            return str;
        } else {
            ValueState valueState = (ValueState) state;
            ValueState.StateType type2 = valueState.getType();
            if (type2 instanceof ValueState.StateType.AlphaNumeric) {
                State child7 = state.getChild();
                return appendPlaceholder(child7, str + "-");
            } else if (type2 instanceof ValueState.StateType.Literal) {
                State child8 = state.getChild();
                return appendPlaceholder(child8, str + "a");
            } else if (type2 instanceof ValueState.StateType.Numeric) {
                State child9 = state.getChild();
                return appendPlaceholder(child9, str + "0");
            } else if (type2 instanceof ValueState.StateType.Ellipsis) {
                return str;
            } else {
                if (type2 instanceof ValueState.StateType.Custom) {
                    State child10 = state.getChild();
                    return appendPlaceholder(child10, str + ((ValueState.StateType.Custom) valueState.getType()).getCharacter());
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    private final boolean noMandatoryCharactersLeftAfterState(State state) {
        if (state instanceof EOLState) {
            return true;
        }
        if (state instanceof ValueState) {
            return ((ValueState) state).isElliptical();
        }
        if (state instanceof FixedState) {
            return false;
        }
        return noMandatoryCharactersLeftAfterState(state.nextState());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/redmadrobot/inputmask/helper/Mask$AutocompletionStack;", "Ljava/util/Stack;", "Lcom/redmadrobot/inputmask/model/Next;", "()V", "push", "item", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: Mask.kt */
    private static final class AutocompletionStack extends Stack<Next> {
        public /* bridge */ boolean contains(Next next) {
            return super.contains((Object) next);
        }

        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof Next : true) {
                return contains((Next) obj);
            }
            return false;
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ int indexOf(Next next) {
            return super.indexOf((Object) next);
        }

        public final /* bridge */ int indexOf(Object obj) {
            if (obj != null ? obj instanceof Next : true) {
                return indexOf((Next) obj);
            }
            return -1;
        }

        public /* bridge */ int lastIndexOf(Next next) {
            return super.lastIndexOf((Object) next);
        }

        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj != null ? obj instanceof Next : true) {
                return lastIndexOf((Next) obj);
            }
            return -1;
        }

        public final /* bridge */ Next remove(int i) {
            return removeAt(i);
        }

        public /* bridge */ boolean remove(Next next) {
            return super.remove((Object) next);
        }

        public final /* bridge */ boolean remove(Object obj) {
            if (obj != null ? obj instanceof Next : true) {
                return remove((Next) obj);
            }
            return false;
        }

        public /* bridge */ Next removeAt(int i) {
            return (Next) super.remove(i);
        }

        public final /* bridge */ int size() {
            return getSize();
        }

        public Next push(Next next) {
            if (next != null) {
                return (Next) super.push((Object) next);
            }
            removeAllElements();
            return null;
        }
    }
}
