package com.google.android.material.transition;

import android.content.Context;
import android.transition.Transition;
import com.google.android.material.animation.AnimationUtils;

public class MaterialFadeThrough extends MaterialTransitionSet<FadeThrough> {
    private static final float DEFAULT_START_SCALE = 0.92f;

    public /* bridge */ /* synthetic */ Transition getSecondaryTransition() {
        return super.getSecondaryTransition();
    }

    public /* bridge */ /* synthetic */ void setSecondaryTransition(Transition transition) {
        super.setSecondaryTransition(transition);
    }

    public static MaterialFadeThrough create(Context context) {
        MaterialFadeThrough materialFadeThrough = new MaterialFadeThrough();
        materialFadeThrough.initialize(context);
        return materialFadeThrough;
    }

    private MaterialFadeThrough() {
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    /* access modifiers changed from: package-private */
    public FadeThrough getDefaultPrimaryTransition() {
        return new FadeThrough();
    }

    /* access modifiers changed from: package-private */
    public Transition getDefaultSecondaryTransition() {
        Scale scale = new Scale();
        scale.setMode(1);
        scale.setIncomingStartScale(DEFAULT_START_SCALE);
        return scale;
    }
}
