package com.askgps.personaltrackerround.ui.main;

import android.content.res.ColorStateList;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.askgps.personaltrackercore.BaseMainActivity;
import com.askgps.personaltrackercore.config.CustomerCategory;
import com.askgps.personaltrackerround.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragmentPhone.kt */
final class MainFragmentPhone$observeViewModel$1<T> implements Observer<Boolean> {
    final /* synthetic */ MainFragmentPhone this$0;

    MainFragmentPhone$observeViewModel$1(MainFragmentPhone mainFragmentPhone) {
        this.this$0 = mainFragmentPhone;
    }

    public final void onChanged(Boolean bool) {
        if (BaseMainActivity.Companion.getCustomer() == CustomerCategory.PATIENT_PHONE) {
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_round_action);
            Intrinsics.checkExpressionValueIsNotNull(appCompatImageButton, "main_btn_round_action");
            ViewGroup.LayoutParams layoutParams = appCompatImageButton.getLayoutParams();
            if (layoutParams != null) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.bottomMargin *= 2;
                ((AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_round_action)).setLayoutParams(layoutParams2);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
        }
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        if (bool.booleanValue()) {
            AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_round_action);
            appCompatImageButton2.setImageDrawable(appCompatImageButton2.getResources().getDrawable(R.drawable.ic_stop, null));
            appCompatImageButton2.setBackgroundTintList(ColorStateList.valueOf(appCompatImageButton2.getResources().getColor(R.color.colorSos)));
            MainFragmentPhone.access$getViewModel$p(this.this$0).setUserStatus();
            MaterialTextView materialTextView = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.main_tc_time);
            Intrinsics.checkExpressionValueIsNotNull(materialTextView, "main_tc_time");
            materialTextView.setVisibility(0);
            MaterialTextView materialTextView2 = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.main_tv_day);
            Intrinsics.checkExpressionValueIsNotNull(materialTextView2, "main_tv_day");
            materialTextView2.setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(R.id.main_btn_sos);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "main_btn_sos");
            linearLayout.setVisibility(0);
            AppCompatButton appCompatButton = (AppCompatButton) this.this$0._$_findCachedViewById(R.id.main_btn_news);
            Intrinsics.checkExpressionValueIsNotNull(appCompatButton, "main_btn_news");
            appCompatButton.setVisibility(0);
            LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(R.id.loginLayout);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "loginLayout");
            linearLayout2.setVisibility(8);
            AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_round_action);
            Intrinsics.checkExpressionValueIsNotNull(appCompatImageButton3, "main_btn_round_action");
            appCompatImageButton3.setVisibility(8);
            MaterialTextView materialTextView3 = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.info_text2_tv);
            Intrinsics.checkExpressionValueIsNotNull(materialTextView3, "info_text2_tv");
            materialTextView3.setVisibility(8);
            LinearLayout linearLayout3 = (LinearLayout) this.this$0._$_findCachedViewById(R.id.loginLayout);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "loginLayout");
            linearLayout3.setVisibility(4);
            return;
        }
        AppCompatImageButton appCompatImageButton4 = (AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_round_action);
        appCompatImageButton4.setImageDrawable(appCompatImageButton4.getResources().getDrawable(R.drawable.ic_camera, null));
        appCompatImageButton4.setBackgroundTintList(null);
        LinearLayout linearLayout4 = (LinearLayout) this.this$0._$_findCachedViewById(R.id.main_btn_call);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "main_btn_call");
        linearLayout4.setVisibility(8);
        MaterialTextView materialTextView4 = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.main_tc_time);
        Intrinsics.checkExpressionValueIsNotNull(materialTextView4, "main_tc_time");
        materialTextView4.setVisibility(8);
        MaterialTextView materialTextView5 = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.main_tv_day);
        Intrinsics.checkExpressionValueIsNotNull(materialTextView5, "main_tv_day");
        materialTextView5.setVisibility(8);
        LinearLayout linearLayout5 = (LinearLayout) this.this$0._$_findCachedViewById(R.id.main_btn_sos);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout5, "main_btn_sos");
        linearLayout5.setVisibility(8);
        LinearLayout linearLayout6 = (LinearLayout) this.this$0._$_findCachedViewById(R.id.main_btn_call);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout6, "main_btn_call");
        linearLayout6.setVisibility(8);
        AppCompatButton appCompatButton2 = (AppCompatButton) this.this$0._$_findCachedViewById(R.id.main_btn_news);
        Intrinsics.checkExpressionValueIsNotNull(appCompatButton2, "main_btn_news");
        appCompatButton2.setVisibility(8);
        TextInputLayout textInputLayout = (TextInputLayout) this.this$0._$_findCachedViewById(R.id.smscode_hint);
        Intrinsics.checkExpressionValueIsNotNull(textInputLayout, "smscode_hint");
        textInputLayout.setVisibility(4);
        LinearLayout linearLayout7 = (LinearLayout) this.this$0._$_findCachedViewById(R.id.phoneLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout7, "phoneLayout");
        linearLayout7.setVisibility(0);
        LinearLayout linearLayout8 = (LinearLayout) this.this$0._$_findCachedViewById(R.id.loginLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout8, "loginLayout");
        linearLayout8.setVisibility(0);
        AppCompatImageButton appCompatImageButton5 = (AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.main_btn_round_action);
        Intrinsics.checkExpressionValueIsNotNull(appCompatImageButton5, "main_btn_round_action");
        appCompatImageButton5.setVisibility(4);
        MaterialTextView materialTextView6 = (MaterialTextView) this.this$0._$_findCachedViewById(R.id.info_text2_tv);
        Intrinsics.checkExpressionValueIsNotNull(materialTextView6, "info_text2_tv");
        materialTextView6.setVisibility(4);
        AppCompatImageButton appCompatImageButton6 = (AppCompatImageButton) this.this$0._$_findCachedViewById(R.id.cancelButton);
        Intrinsics.checkExpressionValueIsNotNull(appCompatImageButton6, "cancelButton");
        appCompatImageButton6.setVisibility(8);
    }
}
