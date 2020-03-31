package com.redmadrobot.inputmask.model.state;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.redmadrobot.inputmask.model.Next;
import com.redmadrobot.inputmask.model.State;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0001H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState;", "Lcom/redmadrobot/inputmask/model/State;", "inheritedType", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "(Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;)V", "child", "type", "(Lcom/redmadrobot/inputmask/model/State;Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;)V", "isElliptical", "", "()Z", "getType", "()Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "accept", "Lcom/redmadrobot/inputmask/model/Next;", FirebaseAnalytics.Param.CHARACTER, "", "accepts", "nextState", "toString", "", "StateType", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: ValueState.kt */
public final class ValueState extends State {
    private final StateType type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "", "()V", "AlphaNumeric", "Custom", "Ellipsis", "Literal", "Numeric", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Numeric;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Literal;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$AlphaNumeric;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Ellipsis;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Custom;", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: ValueState.kt */
    public static abstract class StateType {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Numeric;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "()V", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
        /* compiled from: ValueState.kt */
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

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Literal;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "()V", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
        /* compiled from: ValueState.kt */
        public static final class Literal extends StateType {
            public Literal() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$AlphaNumeric;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "()V", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
        /* compiled from: ValueState.kt */
        public static final class AlphaNumeric extends StateType {
            public AlphaNumeric() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Ellipsis;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "inheritedType", "(Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;)V", "getInheritedType", "()Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
        /* compiled from: ValueState.kt */
        public static final class Ellipsis extends StateType {
            private final StateType inheritedType;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Ellipsis(StateType stateType) {
                super(null);
                Intrinsics.checkParameterIsNotNull(stateType, "inheritedType");
                this.inheritedType = super;
            }

            public final StateType getInheritedType() {
                return this.inheritedType;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/ValueState$StateType$Custom;", "Lcom/redmadrobot/inputmask/model/state/ValueState$StateType;", FirebaseAnalytics.Param.CHARACTER, "", "characterSet", "", "(CLjava/lang/String;)V", "getCharacter", "()C", "getCharacterSet", "()Ljava/lang/String;", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
        /* compiled from: ValueState.kt */
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

    public final StateType getType() {
        return this.type;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValueState(StateType stateType) {
        super(null);
        Intrinsics.checkParameterIsNotNull(stateType, "inheritedType");
        this.type = new StateType.Ellipsis(stateType);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValueState(State state, StateType stateType) {
        super(super);
        Intrinsics.checkParameterIsNotNull(stateType, "type");
        this.type = stateType;
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
        if (stateType instanceof StateType.Ellipsis) {
            StateType inheritedType = ((StateType.Ellipsis) stateType).getInheritedType();
            if (inheritedType instanceof StateType.Numeric) {
                return Character.isDigit(c);
            }
            if (inheritedType instanceof StateType.Literal) {
                return Character.isLetter(c);
            }
            if (inheritedType instanceof StateType.AlphaNumeric) {
                return Character.isLetterOrDigit(c);
            }
            if (inheritedType instanceof StateType.Custom) {
                return StringsKt.contains$default((CharSequence) ((StateType.Custom) ((StateType.Ellipsis) this.type).getInheritedType()).getCharacterSet(), c, false, 2, (Object) null);
            }
            return false;
        } else if (stateType instanceof StateType.Custom) {
            return StringsKt.contains$default((CharSequence) ((StateType.Custom) stateType).getCharacterSet(), c, false, 2, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public Next accept(char c) {
        if (!accepts(c)) {
            return null;
        }
        return new Next(nextState(), Character.valueOf(c), true, Character.valueOf(c));
    }

    public final boolean isElliptical() {
        return this.type instanceof StateType.Ellipsis;
    }

    public State nextState() {
        if (this.type instanceof StateType.Ellipsis) {
            return this;
        }
        return super.nextState();
    }

    public String toString() {
        StateType stateType = this.type;
        String str = "null";
        if (stateType instanceof StateType.Literal) {
            StringBuilder sb = new StringBuilder();
            sb.append("[A] -> ");
            if (getChild() != null) {
                str = getChild().toString();
            }
            sb.append(str);
            return sb.toString();
        } else if (stateType instanceof StateType.Numeric) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[0] -> ");
            if (getChild() != null) {
                str = getChild().toString();
            }
            sb2.append(str);
            return sb2.toString();
        } else if (stateType instanceof StateType.AlphaNumeric) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[_] -> ");
            if (getChild() != null) {
                str = getChild().toString();
            }
            sb3.append(str);
            return sb3.toString();
        } else if (stateType instanceof StateType.Ellipsis) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("[…] -> ");
            if (getChild() != null) {
                str = getChild().toString();
            }
            sb4.append(str);
            return sb4.toString();
        } else if (stateType instanceof StateType.Custom) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[");
            sb5.append(((StateType.Custom) this.type).getCharacter());
            sb5.append("] -> ");
            if (getChild() != null) {
                str = getChild().toString();
            }
            sb5.append(str);
            return sb5.toString();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
