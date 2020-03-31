package com.askgps.personaltrackerround.ui.main;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.askgps.personaltrackercore.BaseMainActivity;
import com.askgps.personaltrackercore.config.CustomerCategory;
import com.askgps.personaltrackercore.extension.ContextExtensionKt;
import com.askgps.personaltrackerround.R;
import com.google.android.material.textview.MaterialTextView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragmentRound.kt */
final class MainFragmentRound$observeViewModel$1<T> implements Observer<Boolean> {
    final /* synthetic */ MainFragmentRound this$0;

    MainFragmentRound$observeViewModel$1(MainFragmentRound mainFragmentRound) {
        this.this$0 = mainFragmentRound;
    }

    public final void onChanged(Boolean bool) {
        if (BaseMainActivity.Companion.getCustomer() == CustomerCategory.PATIENT_PHONE) {
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_round_action);
            Intrinsics.checkExpressionValueIsNotNull(appCompatImageButton, "main_btn_round_action");
            ViewGroup.LayoutParams layoutParams = appCompatImageButton.getLayoutParams();
            if (layoutParams != null) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.bottomMargin *= 2;
                ViewGroup.LayoutParams layoutParams3 = layoutParams2;
                ((AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_call)).setLayoutParams(layoutParams3);
                ((AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_round_action)).setLayoutParams(layoutParams3);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
        }
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        String str = null;
        if (bool.booleanValue()) {
            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_round_action);
            appCompatImageButton2.setImageDrawable(appCompatImageButton2.getResources().getDrawable(R.drawable.ic_stop, null));
            appCompatImageButton2.setBackgroundTintList(ColorStateList.valueOf(appCompatImageButton2.getResources().getColor(R.color.colorSos)));
            if (BaseMainActivity.Companion.getCustomer() != CustomerCategory.PATIENT_PHONE) {
                MaterialTextView materialTextView = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.main_tc_time);
                Intrinsics.checkExpressionValueIsNotNull(materialTextView, "main_tc_time");
                materialTextView.setVisibility(0);
                MaterialTextView materialTextView2 = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.main_tv_day);
                Intrinsics.checkExpressionValueIsNotNull(materialTextView2, "main_tv_day");
                materialTextView2.setVisibility(0);
            }
            AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_call);
            Intrinsics.checkExpressionValueIsNotNull(appCompatImageButton3, "main_btn_call");
            appCompatImageButton3.setVisibility(0);
            AppCompatImageButton appCompatImageButton4 = (AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_round_action);
            Intrinsics.checkExpressionValueIsNotNull(appCompatImageButton4, "main_btn_round_action");
            appCompatImageButton4.setVisibility(4);
            MaterialTextView materialTextView3 = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.loginLayout);
            Intrinsics.checkExpressionValueIsNotNull(materialTextView3, "loginLayout");
            materialTextView3.setVisibility(4);
            return;
        }
        AppCompatImageButton appCompatImageButton5 = (AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_round_action);
        appCompatImageButton5.setImageDrawable(appCompatImageButton5.getResources().getDrawable(R.drawable.ic_camera, null));
        appCompatImageButton5.setBackgroundTintList(null);
        if (BaseMainActivity.Companion.getCustomer() != CustomerCategory.PATIENT_PHONE) {
            MaterialTextView materialTextView4 = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.main_tc_time);
            Intrinsics.checkExpressionValueIsNotNull(materialTextView4, "main_tc_time");
            materialTextView4.setVisibility(4);
            MaterialTextView materialTextView5 = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.main_tv_day);
            Intrinsics.checkExpressionValueIsNotNull(materialTextView5, "main_tv_day");
            materialTextView5.setVisibility(4);
        }
        MaterialTextView materialTextView6 = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.loginLayout);
        Intrinsics.checkExpressionValueIsNotNull(materialTextView6, "loginLayout");
        materialTextView6.setVisibility(0);
        AppCompatImageButton appCompatImageButton6 = (AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_call);
        Intrinsics.checkExpressionValueIsNotNull(appCompatImageButton6, "main_btn_call");
        appCompatImageButton6.setVisibility(4);
        AppCompatImageButton appCompatImageButton7 = (AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_round_action);
        Intrinsics.checkExpressionValueIsNotNull(appCompatImageButton7, "main_btn_round_action");
        appCompatImageButton7.setVisibility(0);
        MaterialTextView materialTextView7 = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.loginLayout);
        Intrinsics.checkExpressionValueIsNotNull(materialTextView7, "loginLayout");
        Context context = this.this$0.getContext();
        if (context != null) {
            str = ContextExtensionKt.getID(context);
        }
        materialTextView7.setText(str);
        AppCompatImageButton appCompatImageButton8 = (AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.cancelButton);
        Intrinsics.checkExpressionValueIsNotNull(appCompatImageButton8, "cancelButton");
        appCompatImageButton8.setVisibility(8);
    }
}
