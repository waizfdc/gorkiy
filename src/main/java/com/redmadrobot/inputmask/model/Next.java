package com.redmadrobot.inputmask.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/redmadrobot/inputmask/model/Next;", "", "state", "Lcom/redmadrobot/inputmask/model/State;", "insert", "", "pass", "", "value", "(Lcom/redmadrobot/inputmask/model/State;Ljava/lang/Character;ZLjava/lang/Character;)V", "getInsert", "()Ljava/lang/Character;", "Ljava/lang/Character;", "getPass", "()Z", "getState", "()Lcom/redmadrobot/inputmask/model/State;", "getValue", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Next.kt */
public final class Next {
    private final Character insert;
    private final boolean pass;
    private final State state;
    private final Character value;

    public Next(State state2, Character ch, boolean z, Character ch2) {
        Intrinsics.checkParameterIsNotNull(state2, "state");
        this.state = state2;
        this.insert = ch;
        this.pass = z;
        this.value = ch2;
    }

    public final Character getInsert() {
        return this.insert;
    }

    public final boolean getPass() {
        return this.pass;
    }

    public final State getState() {
        return this.state;
    }

    public final Character getValue() {
        return this.value;
    }
}
