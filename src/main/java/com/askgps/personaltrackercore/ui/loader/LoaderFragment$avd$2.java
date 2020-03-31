package com.askgps.personaltrackercore.ui.loader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.askgps.personaltrackercore.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: LoaderFragment.kt */
final class LoaderFragment$avd$2 extends Lambda implements Function0<AnimatedVectorDrawableCompat> {
    final /* synthetic */ LoaderFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoaderFragment$avd$2(LoaderFragment loaderFragment) {
        super(0);
        this.this$0 = loaderFragment;
    }

    public final AnimatedVectorDrawableCompat invoke() {
        Context context = this.this$0.getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        final AnimatedVectorDrawableCompat create = AnimatedVectorDrawableCompat.create(context, R.drawable.avd_loader);
        if (create == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(create, "AnimatedVectorDrawableCo… R.drawable.avd_loader)!!");
        create.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
            /* class com.askgps.personaltrackercore.ui.loader.LoaderFragment$avd$2.AnonymousClass1 */

            public void onAnimationEnd(Drawable drawable) {
                super.onAnimationEnd(drawable);
                create.start();
            }
        });
        return create;
    }
}
