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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.askgps.personaltrackercore.BaseMainActivity;
import com.askgps.personaltrackercore.config.CustomerCategory;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import com.askgps.personaltrackercore.ui.loader.LoaderFragment;
import com.askgps.personaltrackercore.ui.main.MainViewModel;
import com.askgps.personaltrackercore.ui.widget.BatteryWidget;
import com.askgps.personaltrackerround.R;
import com.google.android.material.textview.MaterialTextView;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010'\u001a\u00020\u001dH\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\b\u0010)\u001a\u00020\u001dH\u0016J\b\u0010*\u001a\u00020\u001dH\u0016J\b\u0010+\u001a\u00020\u001dH\u0002J\u001a\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u001dH\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0016\u0010\tR\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/askgps/personaltrackerround/ui/main/MainFragmentRound;", "Landroidx/fragment/app/Fragment;", "()V", "cal", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "dayFormat", "", "getDayFormat", "()Ljava/lang/String;", "dayFormat$delegate", "Lkotlin/Lazy;", "job", "Lkotlinx/coroutines/CompletableJob;", "loader", "Lcom/askgps/personaltrackercore/ui/loader/LoaderFragment;", "getLoader", "()Lcom/askgps/personaltrackercore/ui/loader/LoaderFragment;", "loader$delegate", "scope", "Lkotlinx/coroutines/CoroutineScope;", "timeFormat", "getTimeFormat", "timeFormat$delegate", "timerJob", "Lkotlinx/coroutines/Job;", "viewModel", "Lcom/askgps/personaltrackercore/ui/main/MainViewModel;", "observeViewModel", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onPause", "onResume", "requestAddWhiteList", "rotateSecArrow", "sec", "", "withAnim", "", "runClockFace", "setClock", "setDay", "Companion", "round_for_patient_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MainFragmentRound.kt */
public final class MainFragmentRound extends Fragment {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final PhoneNumber DEF_PHONE = new PhoneNumber("Для обращений", "+74958704509");
    private static final long SECONDS = 1000;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final Calendar cal = Calendar.getInstance();
    private final Lazy dayFormat$delegate = LazyKt.lazy(new MainFragmentRound$dayFormat$2(this));
    private final CompletableJob job = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
    private final Lazy loader$delegate = LazyKt.lazy(MainFragmentRound$loader$2.INSTANCE);
    /* access modifiers changed from: private */
    public final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(this.job));
    private final Lazy timeFormat$delegate = LazyKt.lazy(new MainFragmentRound$timeFormat$2(this));
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

    public static final /* synthetic */ MainViewModel access$getViewModel$p(MainFragmentRound mainFragmentRound) {
        MainViewModel mainViewModel = mainFragmentRound.viewModel;
        if (mainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return mainViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/askgps/personaltrackerround/ui/main/MainFragmentRound$Companion;", "", "()V", "DEF_PHONE", "Lcom/askgps/personaltrackercore/database/model/PhoneNumber;", "SECONDS", "", "newInstance", "Lcom/askgps/personaltrackerround/ui/main/MainFragmentRound;", "round_for_patient_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MainFragmentRound.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MainFragmentRound newInstance() {
            return new MainFragmentRound();
        }
    }

    static {
        Class<MainFragmentRound> cls = MainFragmentRound.class;
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
        return layoutInflater.inflate((int) R.layout.main_fragment, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ViewModel viewModel2 = ViewModelProviders.of(this).get(MainViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…ainViewModel::class.java)");
        this.viewModel = (MainViewModel) viewModel2;
        observeViewModel();
        if (BaseMainActivity.Companion.getCustomer() != CustomerCategory.PATIENT_PHONE) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics.checkExpressionValueIsNotNull(parentFragmentManager, "parentFragmentManager");
            ((BatteryWidget) _$_findCachedViewById(R.id.main_battery_widget)).setParentFragmentManager(parentFragmentManager);
            ((BatteryWidget) _$_findCachedViewById(R.id.main_battery_widget)).registerBatteryReceiver();
        }
        ((AppCompatImageButton) _$_findCachedViewById(R.id.main_btn_call)).setOnClickListener(new MainFragmentRound$onActivityCreated$1(this));
        ((AppCompatImageButton) _$_findCachedViewById(R.id.main_btn_round_action)).setOnClickListener(new MainFragmentRound$onActivityCreated$2(this));
        ((AppCompatImageButton) _$_findCachedViewById(R.id.cancelButton)).setOnClickListener(new MainFragmentRound$onActivityCreated$3(this));
    }

    /* access modifiers changed from: private */
    public final void requestAddWhiteList() {
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
        ((BatteryWidget) _$_findCachedViewById(R.id.main_battery_widget)).unregisterBatteryReceiver();
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

    private final void observeViewModel() {
        MainViewModel mainViewModel = this.viewModel;
        if (mainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mainViewModel.getWorkIsStart().observe(getViewLifecycleOwner(), new MainFragmentRound$observeViewModel$1(this));
        MainViewModel mainViewModel2 = this.viewModel;
        if (mainViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mainViewModel2.getShowLoader().observe(getViewLifecycleOwner(), new MainFragmentRound$observeViewModel$2(this));
        MainViewModel mainViewModel3 = this.viewModel;
        if (mainViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mainViewModel3.getPhoneNumbers().observe(getViewLifecycleOwner(), MainFragmentRound$observeViewModel$3.INSTANCE);
        MainViewModel mainViewModel4 = this.viewModel;
        if (mainViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mainViewModel4.getImei().observe(getViewLifecycleOwner(), new MainFragmentRound$observeViewModel$4(this));
    }

    private final void runClockFace() {
        this.timerJob = BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getDefault(), null, new MainFragmentRound$runClockFace$1(this, null), 2, null);
    }

    /* access modifiers changed from: private */
    public final void setDay() {
        MaterialTextView materialTextView = (MaterialTextView) _$_findCachedViewById(R.id.main_tv_day);
        Intrinsics.checkExpressionValueIsNotNull(materialTextView, "main_tv_day");
        materialTextView.setText(DateFormat.format(getDayFormat(), this.cal));
    }

    static /* synthetic */ void rotateSecArrow$default(MainFragmentRound mainFragmentRound, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        mainFragmentRound.rotateSecArrow(i, z);
    }

    private final void rotateSecArrow(int i, boolean z) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.main_img_sec_arrow);
        Intrinsics.checkExpressionValueIsNotNull(appCompatImageView, "main_img_sec_arrow");
        appCompatImageView.setRotation(((float) i) * 6.0f);
    }

    /* access modifiers changed from: private */
    public final void setClock() {
        MaterialTextView materialTextView = (MaterialTextView) _$_findCachedViewById(R.id.main_tc_time);
        Intrinsics.checkExpressionValueIsNotNull(materialTextView, "main_tc_time");
        materialTextView.setText(DateFormat.format(getTimeFormat(), this.cal));
    }
}
