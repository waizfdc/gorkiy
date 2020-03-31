package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SlideDistance extends Visibility {
    private int slideDistance;
    private int slideEdge;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    public SlideDistance(Context context, int i) {
        this.slideEdge = i;
        this.slideDistance = context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideEdge(int i) {
        this.slideEdge = i;
    }

    public int getSlideDistance() {
        return this.slideDistance;
    }

    public void setSlideDistance(int i) {
        this.slideDistance = i;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createTranslationAppearAnimator(viewGroup, view);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createTranslationDisappearAnimator(viewGroup, view);
    }

    private Animator createTranslationAppearAnimator(View view, View view2) {
        int i = this.slideEdge;
        if (i == 3) {
            return createTranslationXAnimator(view2, (float) this.slideDistance, 0.0f);
        }
        if (i == 5) {
            return createTranslationXAnimator(view2, (float) (-this.slideDistance), 0.0f);
        }
        if (i == 48) {
            return createTranslationYAnimator(view2, (float) (-this.slideDistance), 0.0f);
        }
        if (i == 80) {
            return createTranslationYAnimator(view2, (float) this.slideDistance, 0.0f);
        }
        if (i == 8388611) {
            return createTranslationXAnimator(view2, (float) (isRtl(view) ? this.slideDistance : -this.slideDistance), 0.0f);
        } else if (i == 8388613) {
            return createTranslationXAnimator(view2, (float) (isRtl(view) ? -this.slideDistance : this.slideDistance), 0.0f);
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + this.slideEdge);
        }
    }

    private Animator createTranslationDisappearAnimator(View view, View view2) {
        int i = this.slideEdge;
        if (i == 3) {
            return createTranslationXAnimator(view2, 0.0f, (float) (-this.slideDistance));
        }
        if (i == 5) {
            return createTranslationXAnimator(view2, 0.0f, (float) this.slideDistance);
        }
        if (i == 48) {
            return createTranslationYAnimator(view2, 0.0f, (float) this.slideDistance);
        }
        if (i == 80) {
            return createTranslationYAnimator(view2, 0.0f, (float) (-this.slideDistance));
        }
        if (i == 8388611) {
            return createTranslationXAnimator(view2, 0.0f, (float) (isRtl(view) ? -this.slideDistance : this.slideDistance));
        } else if (i == 8388613) {
            return createTranslationXAnimator(view2, 0.0f, (float) (isRtl(view) ? this.slideDistance : -this.slideDistance));
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + this.slideEdge);
        }
    }

    private static Animator createTranslationXAnimator(View view, float f, float f2) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f, f2));
    }

    private static Animator createTranslationYAnimator(View view, float f, float f2) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f, f2));
    }

    private static boolean isRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }
}
