package com.redmadrobot.inputmask.model.state;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.redmadrobot.inputmask.model.Next;
import com.redmadrobot.inputmask.model.State;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/redmadrobot/inputmask/model/state/EOLState;", "Lcom/redmadrobot/inputmask/model/State;", "()V", "accept", "Lcom/redmadrobot/inputmask/model/Next;", FirebaseAnalytics.Param.CHARACTER, "", "toString", "", "input-mask-android_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: EOLState.kt */
public final class EOLState extends State {
    public Next accept(char c) {
        return null;
    }

    public String toString() {
        return "EOL";
    }

    public EOLState() {
        super(null);
    }
}
