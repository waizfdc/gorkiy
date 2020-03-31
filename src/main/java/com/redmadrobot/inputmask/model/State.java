package com.redmadrobot.inputmask.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0000H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/redmadrobot/inputmask/model/State;", "", "child", "(Lcom/redmadrobot/inputmask/model/State;)V", "getChild", "()Lcom/redmadrobot/inputmask/model/State;", "accept", "Lcom/redmadrobot/inputmask/model/Next;", FirebaseAnalytics.Param.CHARACTER, "", "autocomplete", "nextState", "toString", "", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: State.kt */
public abstract class State {
    private final State child;

    public abstract Next accept(char c);

    public Next autocomplete() {
        return null;
    }

    public State(State state) {
        this.child = state;
    }

    public final State getChild() {
        return this.child;
    }

    public State nextState() {
        State state = this.child;
        if (state == null) {
            Intrinsics.throwNpe();
        }
        return state;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BASE -> ");
        State state = this.child;
        sb.append(state != null ? state.toString() : "null");
        return sb.toString();
    }
}
