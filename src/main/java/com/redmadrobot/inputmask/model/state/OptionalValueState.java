package com.redmadrobot.inputmask.model.state;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.redmadrobot.inputmask.model.Next;
import com.redmadrobot.inputmask.model.State;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/OptionalValueState;", "Lcom/redmadrobot/inputmask/model/State;", "child", "type", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", "(Lcom/redmadrobot/inputmask/model/State;Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;)V", "getType", "()Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", "accept", "Lcom/redmadrobot/inputmask/model/Next;", FirebaseAnalytics.Param.CHARACTER, "", "accepts", "", "toString", "", "StateType", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: OptionalValueState.kt */
public final class OptionalValueState extends State {
    private final StateType type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OptionalValueState(State state, StateType stateType) {
        super(super);
        Intrinsics.checkParameterIsNotNull(state, "child");
        Intrinsics.checkParameterIsNotNull(stateType, "type");
        this.type = stateType;
    }

    public final StateType getType() {
        return this.type;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", "", "()V", "AlphaNumeric", "Custom", "Literal", "Numeric", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$Numeric;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$Literal;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$AlphaNumeric;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$Custom;", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: OptionalValueState.kt */
    public static abstract class StateType {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$Numeric;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", "()V", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
        /* compiled from: OptionalValueState.kt */
        public static final class Numeric extends StateType {
            public Numeric() {
                super(null);
            }
        }

        private StateType() {
        }

        public /* synthetic */ StateType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$Literal;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", "()V", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
        /* compiled from: OptionalValueState.kt */
        public static final class Literal extends StateType {
            public Literal() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$AlphaNumeric;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", "()V", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
        /* compiled from: OptionalValueState.kt */
        public static final class AlphaNumeric extends StateType {
            public AlphaNumeric() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType$Custom;", "Lcom/redmadrobot/inputmask/model/state/OptionalValueState$StateType;", FirebaseAnalytics.Param.CHARACTER, "", "characterSet", "", "(CLjava/lang/String;)V", "getCharacter", "()C", "getCharacterSet", "()Ljava/lang/String;", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
        /* compiled from: OptionalValueState.kt */
        public static final class Custom extends StateType {
            private final char character;
            private final String characterSet;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Custom(char c, String str) {
                super(null);
                Intrinsics.checkParameterIsNotNull(str, "characterSet");
                this.character = c;
                this.characterSet = str;
            }

            public final char getCharacter() {
                return this.character;
            }

            public final String getCharacterSet() {
                return this.characterSet;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, char, boolean, int, java.lang.Object):boolean
     arg types: [java.lang.String, char, int, int, ?[OBJECT, ARRAY]]
     candidates:
      kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, java.lang.CharSequence, boolean, int, java.lang.Object):boolean
      kotlin.text.StringsKt__StringsKt.contains$default(java.lang.CharSequence, char, boolean, int, java.lang.Object):boolean */
    private final boolean accepts(char c) {
        StateType stateType = this.type;
        if (stateType instanceof StateType.Numeric) {
            return Character.isDigit(c);
        }
        if (stateType instanceof StateType.Literal) {
            return Character.isLetter(c);
        }
        if (stateType instanceof StateType.AlphaNumeric) {
            return Character.isLetterOrDigit(c);
        }
        if (stateType instanceof StateType.Custom) {
            return StringsKt.contains$default((CharSequence) ((StateType.Custom) stateType).getCharacterSet(), c, false, 2, (Object) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public Next accept(char c) {
        if (accepts(c)) {
            return new Next(nextState(), Character.valueOf(c), true, Character.valueOf(c));
        }
        return new Next(nextState(), null, false, null);
    }

    public String toString() {
        StateType stateType = this.type;
        String str = "null";
        if (stateType instanceof StateType.Literal) {
            StringBuilder sb = new StringBuilder();
            sb.append("[a] -> ");
            if (getChild() != null) {
                str = getChild().toString();
            }
            sb.append(str);
            return sb.toString();
        } else if (stateType instanceof StateType.Numeric) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[9] -> ");
            if (getChild() != null) {
                str = getChild().toString();
            }
            sb2.append(str);
            return sb2.toString();
        } else if (stateType instanceof StateType.AlphaNumeric) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[-] -> ");
            if (getChild() != null) {
                str = getChild().toString();
            }
            sb3.append(str);
            return sb3.toString();
        } else if (stateType instanceof StateType.Custom) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("[");
            sb4.append(((StateType.Custom) this.type).getCharacter());
            sb4.append("] -> ");
            if (getChild() != null) {
                str = getChild().toString();
            }
            sb4.append(str);
            return sb4.toString();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
