package com.askgps.personaltrackerround.ui.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import com.askgps.personaltrackercore.ui.loader.LoaderFragment;
import com.askgps.personaltrackercore.ui.main.MainViewModel;
import com.askgps.personaltrackerround.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import com.redmadrobot.inputmask.MaskedTextChangedListener;
import com.redmadrobot.inputmask.helper.Mask;
import com.redmadrobot.inputmask.model.CaretString;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020#H\u0002J\u0012\u0010&\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010/\u001a\u00020#H\u0016J\b\u00100\u001a\u00020#H\u0016J\b\u00101\u001a\u00020#H\u0016J\b\u00102\u001a\u00020#H\u0016J\b\u00103\u001a\u00020#H\u0002J\b\u00104\u001a\u00020#H\u0002J\b\u00105\u001a\u00020#H\u0002J\b\u00106\u001a\u00020#H\u0002J\n\u00107\u001a\u000208*\u000209R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\nR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001c\u0010\nR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/askgps/personaltrackerround/ui/main/MainFragmentPhone;", "Landroidx/fragment/app/Fragment;", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "getPATTERN", "()Ljava/util/regex/Pattern;", "REG", "", "getREG", "()Ljava/lang/String;", "cal", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "dayFormat", "getDayFormat", "dayFormat$delegate", "Lkotlin/Lazy;", "job", "Lkotlinx/coroutines/CompletableJob;", "loader", "Lcom/askgps/personaltrackercore/ui/loader/LoaderFragment;", "getLoader", "()Lcom/askgps/personaltrackercore/ui/loader/LoaderFragment;", "loader$delegate", "scope", "Lkotlinx/coroutines/CoroutineScope;", "timeFormat", "getTimeFormat", "timeFormat$delegate", "timerJob", "Lkotlinx/coroutines/Job;", "viewModel", "Lcom/askgps/personaltrackercore/ui/main/MainViewModel;", "click_btn_round", "", "getClearPhone", "observeViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onPause", "onResume", "requestAddWhiteList", "runClockFace", "setClock", "setDay", "isPhoneNumber", "", "", "Companion", "round_for_patient_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MainFragmentPhone.kt */
public final class MainFragmentPhone extends Fragment {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final PhoneNumber DEF_PHONE = new PhoneNumber("Для обращений", "+7-495-870-45-09");
    /* access modifiers changed from: private */
    public static final String NEWS_URL = NEWS_URL;
    private static final String PHONE_MASK = "([000]) [000] [00] [00]";
    private static final long SECONDS = 1000;
    /* access modifiers changed from: private */
    public static final String SOS_PHONE = SOS_PHONE;
    private final Pattern PATTERN;
    private final String REG = "^\\+?[78][-\\(]?\\d{3}\\)?-?\\d{3}-?\\d{2}-?\\d{2}$";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final Calendar cal = Calendar.getInstance();
    private final Lazy dayFormat$delegate = LazyKt.lazy(new MainFragmentPhone$dayFormat$2(this));
    private final CompletableJob job = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
    private final Lazy loader$delegate = LazyKt.lazy(MainFragmentPhone$loader$2.INSTANCE);
    /* access modifiers changed from: private */
    public final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(this.job));
    private final Lazy timeFormat$delegate = LazyKt.lazy(new MainFragmentPhone$timeFormat$2(this));
    private Job timerJob;
    /* access modifiers changed from: private */
    public MainViewModel viewModel;

    private final String getDayFormat() {
        Lazy lazy = this.dayFormat$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (String) lazy.getValue();
    }

    /* access modifiers changed from: private */
    public final LoaderFragment getLoader() {
        Lazy lazy = this.loader$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (LoaderFragment) lazy.getValue();
    }

    private final String getTimeFormat() {
        Lazy lazy = this.timeFormat$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (String) lazy.getValue();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlinx.coroutines.SupervisorKt.SupervisorJob$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.CompletableJob
     arg types: [?[OBJECT, ARRAY], int, ?[OBJECT, ARRAY]]
     candidates:
      kotlinx.coroutines.SupervisorKt.SupervisorJob$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.Job
      kotlinx.coroutines.SupervisorKt.SupervisorJob$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.CompletableJob */
    public MainFragmentPhone() {
        Pattern compile = Pattern.compile("^\\+?[78][-\\(]?\\d{3}\\)?-?\\d{3}-?\\d{2}-?\\d{2}$");
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(REG)");
        this.PATTERN = compile;
    }

    public static final /* synthetic */ MainViewModel access$getViewModel$p(MainFragmentPhone mainFragmentPhone) {
        MainViewModel mainViewModel = mainFragmentPhone.viewModel;
        if (mainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return mainViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/askgps/personaltrackerround/ui/main/MainFragmentPhone$Companion;", "", "()V", "DEF_PHONE", "Lcom/askgps/personaltrackercore/database/model/PhoneNumber;", "NEWS_URL", "", "PHONE_MASK", "SECONDS", "", "SOS_PHONE", "newInstance", "Lcom/askgps/personaltrackerround/ui/main/MainFragmentPhone;", "round_for_patient_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MainFragmentPhone.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MainFragmentPhone newInstance() {
            return new MainFragmentPhone();
        }
    }

    static {
        Class<MainFragmentPhone> cls = MainFragmentPhone.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "loader", "getLoader()Lcom/askgps/personaltrackercore/ui/loader/LoaderFragment;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "dayFormat", "getDayFormat()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "timeFormat", "getTimeFormat()Ljava/lang/String;"))};
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate((int) R.layout.phone_main_fragment, viewGroup, false);
    }

    public final String getREG() {
        return this.REG;
    }

    public final Pattern getPATTERN() {
        return this.PATTERN;
    }

    public final boolean isPhoneNumber(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$isPhoneNumber");
        return this.PATTERN.matcher(charSequence).find();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ViewModel viewModel2 = ViewModelProviders.of(this).get(MainViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…ainViewModel::class.java)");
        MainViewModel mainViewModel = (MainViewModel) viewModel2;
        this.viewModel = mainViewModel;
        if (mainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mainViewModel.setUserStatus();
        observeViewModel();
        ((LinearLayout) _$_findCachedViewById(R.id.main_btn_sos)).setOnClickListener(new MainFragmentPhone$onActivityCreated$1(this));
        ((LinearLayout) _$_findCachedViewById(R.id.main_btn_call)).setOnClickListener(new MainFragmentPhone$onActivityCreated$2(this));
        EditText editText = (EditText) _$_findCachedViewById(R.id.phone_edit);
        Intrinsics.checkExpressionValueIsNotNull(editText, "phone_edit");
        MaskedTextChangedListener maskedTextChangedListener = new MaskedTextChangedListener(PHONE_MASK, editText);
        ((EditText) _$_findCachedViewById(R.id.phone_edit)).addTextChangedListener(maskedTextChangedListener);
        EditText editText2 = (EditText) _$_findCachedViewById(R.id.phone_edit);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "phone_edit");
        editText2.setOnFocusChangeListener(maskedTextChangedListener);
        ((EditText) _$_findCachedViewById(R.id.phone_edit)).setOnKeyListener(new MainFragmentPhone$onActivityCreated$3(this));
        ((TextInputEditText) _$_findCachedViewById(R.id.smscode_edit)).setOnKeyListener(new MainFragmentPhone$onActivityCreated$4(this));
        ((AppCompatImageButton) _$_findCachedViewById(R.id.main_btn_round_action)).setOnClickListener(new MainFragmentPhone$onActivityCreated$5(this));
        ((AppCompatImageButton) _$_findCachedViewById(R.id.cancelButton)).setOnClickListener(new MainFragmentPhone$onActivityCreated$6(this));
        ((AppCompatButton) _$_findCachedViewById(R.id.main_btn_news)).setOnClickListener(new MainFragmentPhone$onActivityCreated$7(this));
        requestAddWhiteList();
    }

    /* access modifiers changed from: private */
    public final String getClearPhone() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.phone_edit);
        Intrinsics.checkExpressionValueIsNotNull(editText, "phone_edit");
        String obj = editText.getText().toString();
        return new Mask(PHONE_MASK).apply(new CaretString(obj, obj.length(), new CaretString.CaretGravity.FORWARD(false))).getExtractedValue();
    }

    /* access modifiers changed from: private */
    public final void click_btn_round() {
        TextInputEditText textInputEditText = (TextInputEditText) _$_findCachedViewById(R.id.smscode_edit);
        Intrinsics.checkExpressionValueIsNotNull(textInputEditText, "smscode_edit");
        if (String.valueOf(textInputEditText.getText()).length() < 4) {
            TextInputLayout textInputLayout = (TextInputLayout) _$_findCachedViewById(R.id.smscode_hint);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout, "smscode_hint");
            textInputLayout.setError(getString(R.string.error_sms));
            return;
        }
        CheckBox checkBox = (CheckBox) _$_findCachedViewById(R.id.agree_check);
        Intrinsics.checkExpressionValueIsNotNull(checkBox, "agree_check");
        if (!checkBox.isChecked()) {
            Context context = getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            Toast.makeText(context, "Не дано согласие на обработку данных.", 0).show();
            return;
        }
        MainViewModel mainViewModel = this.viewModel;
        if (mainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        TextInputEditText textInputEditText2 = (TextInputEditText) _$_findCachedViewById(R.id.fio_edit);
        Intrinsics.checkExpressionValueIsNotNull(textInputEditText2, "fio_edit");
        String valueOf = String.valueOf(textInputEditText2.getText());
        TextInputEditText textInputEditText3 = (TextInputEditText) _$_findCachedViewById(R.id.email_edit);
        Intrinsics.checkExpressionValueIsNotNull(textInputEditText3, "email_edit");
        TextInputEditText textInputEditText4 = (TextInputEditText) _$_findCachedViewById(R.id.smscode_edit);
        Intrinsics.checkExpressionValueIsNotNull(textInputEditText4, "smscode_edit");
        mainViewModel.registerUser(valueOf, String.valueOf(textInputEditText3.getText()), "+7" + getClearPhone(), String.valueOf(textInputEditText4.getText()), new MainFragmentPhone$click_btn_round$1(this));
    }

    public void onResume() {
        super.onResume();
        runClockFace();
    }

    public void onPause() {
        super.onPause();
        Job job2 = this.timerJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlinx.coroutines.JobKt.cancelChildren$default(kotlinx.coroutines.Job, java.util.concurrent.CancellationException, int, java.lang.Object):void
     arg types: [kotlinx.coroutines.CompletableJob, ?[OBJECT, ARRAY], int, ?[OBJECT, ARRAY]]
     candidates:
      kotlinx.coroutines.JobKt.cancelChildren$default(kotlin.coroutines.CoroutineContext, java.lang.Throwable, int, java.lang.Object):void
      kotlinx.coroutines.JobKt.cancelChildren$default(kotlin.coroutines.CoroutineContext, java.util.concurrent.CancellationException, int, java.lang.Object):void
      kotlinx.coroutines.JobKt.cancelChildren$default(kotlinx.coroutines.Job, java.lang.Throwable, int, java.lang.Object):void
      kotlinx.coroutines.JobKt.cancelChildren$default(kotlinx.coroutines.Job, java.util.concurrent.CancellationException, int, java.lang.Object):void */
    public void onDestroy() {
        JobKt__JobKt.cancelChildren$default((Job) this.job, (CancellationException) null, 1, (Object) null);
        super.onDestroy();
    }

    private final void requestAddWhiteList() {
        String str;
        Intent intent = new Intent();
        Context context = getContext();
        if (context == null || (str = context.getPackageName()) == null) {
            str = "";
        }
        Context context2 = getContext();
        PowerManager powerManager = (PowerManager) (context2 != null ? context2.getSystemService("power") : null);
        if (powerManager == null) {
            Intrinsics.throwNpe();
        }
        if (!powerManager.isIgnoringBatteryOptimizations(str)) {
            intent.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + str));
            startActivity(intent);
        }
    }

    private final void observeViewModel() {
        MainViewModel mainViewModel = this.viewModel;
        if (mainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mainViewModel.getWorkIsStart().observe(getViewLifecycleOwner(), new MainFragmentPhone$observeViewModel$1(this));
        MainViewModel mainViewModel2 = this.viewModel;
        if (mainViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mainViewModel2.getShowLoader().observe(getViewLifecycleOwner(), new MainFragmentPhone$observeViewModel$2(this));
        MainViewModel mainViewModel3 = this.viewModel;
        if (mainViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mainViewModel3.getPhoneNumbers().observe(getViewLifecycleOwner(), MainFragmentPhone$observeViewModel$3.INSTANCE);
        MainViewModel mainViewModel4 = this.viewModel;
        if (mainViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mainViewModel4.getImei().observe(getViewLifecycleOwner(), MainFragmentPhone$observeViewModel$4.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void setDay() {
        MaterialTextView materialTextView = (MaterialTextView) _$_findCachedViewById(R.id.main_tv_day);
        Intrinsics.checkExpressionValueIsNotNull(materialTextView, "main_tv_day");
        materialTextView.setText(DateFormat.format(getDayFormat(), this.cal));
    }

    /* access modifiers changed from: private */
    public final void setClock() {
        MaterialTextView materialTextView = (MaterialTextView) _$_findCachedViewById(R.id.main_tc_time);
        Intrinsics.checkExpressionValueIsNotNull(materialTextView, "main_tc_time");
        materialTextView.setText(DateFormat.format(getTimeFormat(), this.cal));
    }

    private final void runClockFace() {
        this.timerJob = BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getDefault(), null, new MainFragmentPhone$runClockFace$1(this, null), 2, null);
    }
}
