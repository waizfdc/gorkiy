package com.google.android.material.transition;

import android.content.Context;
import android.transition.Transition;
import android.transition.TransitionSet;

abstract class MaterialTransitionSet<T extends Transition> extends TransitionSet {
    protected Context context;
    private T primaryTransition;
    private Transition secondaryTransition;

    /* access modifiers changed from: package-private */
    public abstract T getDefaultPrimaryTransition();

    /* access modifiers changed from: package-private */
    public abstract Transition getDefaultSecondaryTransition();

    MaterialTransitionSet() {
    }

    /* access modifiers changed from: protected */
    public void initialize(Context context2) {
        this.context = context2;
        T defaultPrimaryTransition = getDefaultPrimaryTransition();
        this.primaryTransition = defaultPrimaryTransition;
        addTransition(defaultPrimaryTransition);
        setSecondaryTransition(getDefaultSecondaryTransition());
    }

    public T getPrimaryTransition() {
        return this.primaryTransition;
    }

    public Transition getSecondaryTransition() {
        return this.secondaryTransition;
    }

    public void setSecondaryTransition(Transition transition) {
        TransitionUtils.maybeRemoveTransition(super, this.secondaryTransition);
        this.secondaryTransition = transition;
        TransitionUtils.maybeAddTransition(super, transition);
    }
}
