package com.askgps.personaltrackerround.ui.main;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.app.NotificationCompat;
import com.askgps.personaltrackercore.ui.main.MainViewModel;
import com.askgps.personaltrackerround.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "keyCode", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "onKey"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainFragmentPhone.kt */
final class MainFragmentPhone$onActivityCreated$3 implements View.OnKeyListener {
    final /* synthetic */ MainFragmentPhone this$0;

    MainFragmentPhone$onActivityCreated$3(MainFragmentPhone mainFragmentPhone) {
        this.this$0 = mainFragmentPhone;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 66) {
            Intrinsics.checkExpressionValueIsNotNull(keyEvent, NotificationCompat.CATEGORY_EVENT);
            if (keyEvent.getAction() == 1) {
                MainFragmentPhone.access$getViewModel$p(this.this$0).resetAttemptLeft();
                if (this.this$0.getClearPhone().length() <= 0) {
                    TextInputLayout textInputLayout = (TextInputLayout) this.this$0._$_findCachedViewById(R.id.phoneTextInputLayout);
                    Intrinsics.checkExpressionValueIsNotNull(textInputLayout, "phoneTextInputLayout");
                    textInputLayout.setError("Введите номер телефона.");
                } else {
                    MainFragmentPhone mainFragmentPhone = this.this$0;
                    if (!mainFragmentPhone.isPhoneNumber("+7" + this.this$0.getClearPhone())) {
                        TextInputLayout textInputLayout2 = (TextInputLayout) this.this$0._$_findCachedViewById(R.id.phoneTextInputLayout);
                        Intrinsics.checkExpressionValueIsNotNull(textInputLayout2, "phoneTextInputLayout");
                        textInputLayout2.setError("Номер телефона введен неверно.");
                    } else {
                        CheckBox checkBox = (CheckBox) this.this$0._$_findCachedViewById(R.id.agree_check);
                        Intrinsics.checkExpressionValueIsNotNull(checkBox, "agree_check");
                        if (!checkBox.isChecked()) {
                            Context context = this.this$0.getContext();
                            if (context == null) {
                                Intrinsics.throwNpe();
                            }
                            Toast.makeText(context, "Не дано согласие на обработку данных.", 0).show();
                        } else {
                            TextInputLayout textInputLayout3 = (TextInputLayout) this.this$0._$_findCachedViewById(R.id.phoneTextInputLayout);
                            Intrinsics.checkExpressionValueIsNotNull(textInputLayout3, "phoneTextInputLayout");
                            textInputLayout3.setError("");
                            ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(R.id.smsRegProgress);
                            Intrinsics.checkExpressionValueIsNotNull(progressBar, "smsRegProgress");
                            progressBar.setVisibility(0);
                            MainViewModel access$getViewModel$p = MainFragmentPhone.access$getViewModel$p(this.this$0);
                            TextInputEditText textInputEditText = (TextInputEditText) this.this$0._$_findCachedViewById(R.id.fio_edit);
                            Intrinsics.checkExpressionValueIsNotNull(textInputEditText, "fio_edit");
                            String valueOf = String.valueOf(textInputEditText.getText());
                            TextInputEditText textInputEditText2 = (TextInputEditText) this.this$0._$_findCachedViewById(R.id.email_edit);
                            Intrinsics.checkExpressionValueIsNotNull(textInputEditText2, "email_edit");
                            String valueOf2 = String.valueOf(textInputEditText2.getText());
                            access$getViewModel$p.registerUser(valueOf, valueOf2, "+7" + this.this$0.getClearPhone(), "", new Function1<Boolean, Unit>(this) {
                                /* class com.askgps.personaltrackerround.ui.main.MainFragmentPhone$onActivityCreated$3.AnonymousClass1 */
                                final /* synthetic */ MainFragmentPhone$onActivityCreated$3 this$0;

                                {
                                    this.this$0 = r1;
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Boolean) obj).booleanValue());
                                    return Unit.INSTANCE;
                                }

                                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
                                @DebugMetadata(c = "com.askgps.personaltrackerround.ui.main.MainFragmentPhone$onActivityCreated$3$1$1", f = "MainFragmentPhone.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: com.askgps.personaltrackerround.ui.main.MainFragmentPhone$onActivityCreated$3$1$1  reason: invalid class name */
                                /* compiled from: MainFragmentPhone.kt */
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    int label;
                                    private CoroutineScope p$;
                                    final /* synthetic */ AnonymousClass1 this$0;

                                    {
                                        this.this$0 = r1;
                                    }

                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        Intrinsics.checkParameterIsNotNull(continuation, "completion");
                                        AnonymousClass1 r0 = new AnonymousClass1(this.this$0, z, continuation);
                                        r0.p$ = (CoroutineScope) obj;
                                        return r0;
                                    }

                                    public final Object invoke(Object obj, Object obj2) {
                                        return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    public final Object invokeSuspend(Object obj) {
                                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        if (this.label == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            ProgressBar progressBar = (ProgressBar) this.this$0.this$0.this$0._$_findCachedViewById(R.id.smsRegProgress);
                                            Intrinsics.checkExpressionValueIsNotNull(progressBar, "smsRegProgress");
                                            progressBar.setVisibility(8);
                                            if (z) {
                                                TextInputLayout textInputLayout = (TextInputLayout) this.this$0.this$0.this$0._$_findCachedViewById(R.id.smscode_hint);
                                                Intrinsics.checkExpressionValueIsNotNull(textInputLayout, "smscode_hint");
                                                textInputLayout.setVisibility(0);
                                                AppCompatImageButton appCompatImageButton = (AppCompatImageButton) this.this$0.this$0.this$0._$_findCachedViewById(R.id.main_btn_round_action);
                                                Intrinsics.checkExpressionValueIsNotNull(appCompatImageButton, "main_btn_round_action");
                                                appCompatImageButton.setVisibility(0);
                                                MaterialTextView materialTextView = (MaterialTextView) this.this$0.this$0.this$0._$_findCachedViewById(R.id.info_text2_tv);
                                                Intrinsics.checkExpressionValueIsNotNull(materialTextView, "info_text2_tv");
                                                materialTextView.setVisibility(0);
                                            } else {
                                                TextInputLayout textInputLayout2 = (TextInputLayout) this.this$0.this$0.this$0._$_findCachedViewById(R.id.smscode_hint);
                                                Intrinsics.checkExpressionValueIsNotNull(textInputLayout2, "smscode_hint");
                                                textInputLayout2.setVisibility(4);
                                                AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) this.this$0.this$0.this$0._$_findCachedViewById(R.id.main_btn_round_action);
                                                Intrinsics.checkExpressionValueIsNotNull(appCompatImageButton2, "main_btn_round_action");
                                                appCompatImageButton2.setVisibility(4);
                                                MaterialTextView materialTextView2 = (MaterialTextView) this.this$0.this$0.this$0._$_findCachedViewById(R.id.info_text2_tv);
                                                Intrinsics.checkExpressionValueIsNotNull(materialTextView2, "info_text2_tv");
                                                materialTextView2.setVisibility(4);
                                                Context context = this.this$0.this$0.this$0.getContext();
                                                if (context == null) {
                                                    Intrinsics.throwNpe();
                                                }
                                                Toast.makeText(context, "Ошибка регистрации. Повторите позднее.", 0).show();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                }

                                public final void invoke(final boolean z) {
                                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.this$0.this$0.scope, Dispatchers.getMain(), null, new AnonymousClass1(this, null), 2, null);
                                }
                            });
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
