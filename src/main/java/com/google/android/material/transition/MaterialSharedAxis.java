package com.google.android.material.transition;

import android.content.Context;
import android.transition.Transition;
import androidx.core.view.GravityCompat;
import com.google.android.material.animation.AnimationUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MaterialSharedAxis extends MaterialTransitionSet<Transition> {
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    private final int axis;
    private final boolean forward;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    public /* bridge */ /* synthetic */ Transition getPrimaryTransition() {
        return super.getPrimaryTransition();
    }

    public /* bridge */ /* synthetic */ Transition getSecondaryTransition() {
        return super.getSecondaryTransition();
    }

    public /* bridge */ /* synthetic */ void setSecondaryTransition(Transition transition) {
        super.setSecondaryTransition(transition);
    }

    public static MaterialSharedAxis create(Context context, int i, boolean z) {
        MaterialSharedAxis materialSharedAxis = new MaterialSharedAxis(i, z);
        materialSharedAxis.initialize(context);
        return materialSharedAxis;
    }

    private MaterialSharedAxis(int i, boolean z) {
        this.axis = i;
        this.forward = z;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    /* access modifiers changed from: package-private */
    public Transition getDefaultPrimaryTransition() {
        int i = this.axis;
        if (i == 0) {
            return new SlideDistance(this.context, this.forward ? GravityCompat.END : GravityCompat.START);
        } else if (i == 1) {
            return new SlideDistance(this.context, this.forward ? 80 : 48);
        } else if (i == 2) {
            return new Scale(this.forward);
        } else {
            throw new IllegalArgumentException("Invalid axis: " + this.axis);
        }
    }

    /* access modifiers changed from: package-private */
    public Transition getDefaultSecondaryTransition() {
        return new FadeThrough();
    }

    public int getAxis() {
        return this.axis;
    }

    public boolean isEntering() {
        return this.forward;
    }
}
