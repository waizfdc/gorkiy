package com.askgps.personaltrackercore.ui.main;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.askgps.personaltrackercore.R;
import com.askgps.personaltrackercore.ui.loader.LoaderFragment;
import com.askgps.personaltrackercore.ui.widget.BatteryWidget;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020\u001bH\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0014\u0010\tR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/askgps/personaltrackercore/ui/main/MainFragment;", "Landroidx/fragment/app/Fragment;", "()V", "cal", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "dayFormat", "", "getDayFormat", "()Ljava/lang/String;", "dayFormat$delegate", "Lkotlin/Lazy;", "loader", "Lcom/askgps/personaltrackercore/ui/loader/LoaderFragment;", "getLoader", "()Lcom/askgps/personaltrackercore/ui/loader/LoaderFragment;", "loader$delegate", "scope", "Lkotlinx/coroutines/CoroutineScope;", "timeFormat", "getTimeFormat", "timeFormat$delegate", "timerJob", "Lkotlinx/coroutines/Job;", "viewModel", "Lcom/askgps/personaltrackercore/ui/main/MainViewModel;", "observeViewModel", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onPause", "onResume", "runClockFace", "setClock", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MainFragment.kt */
public final class MainFragment extends Fragment {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);
    private static final long SECONDS = 1000;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final Calendar cal = Calendar.getInstance();
    private final Lazy dayFormat$delegate = LazyKt.lazy(new MainFragment$dayFormat$2(this));
    private final Lazy loader$delegate = LazyKt.lazy(MainFragment$loader$2.INSTANCE);
    /* access modifiers changed from: private */
    public final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    private final Lazy timeFormat$delegate = LazyKt.lazy(new MainFragment$timeFormat$2(this));
    private Job timerJob;
    /* access modifiers changed from: private */
    public MainViewModel viewModel;

    static {
        Class<MainFragment> cls = MainFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "dayFormat", "getDayFormat()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "timeFormat", "getTimeFormat()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "loader", "getLoader()Lcom/askgps/personaltrackercore/ui/loader/LoaderFragment;"))};
    }

    private final String getDayFormat() {
        Lazy lazy = this.dayFormat$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (String) lazy.getValue();
    }

    /* access modifiers changed from: private */
    public final LoaderFragment getLoader() {
        Lazy lazy = this.loader$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (LoaderFragment) lazy.getValue();
    }

    private final String getTimeFormat() {
        Lazy lazy = this.timeFormat$delegate;
        KProperty kProperty = $$delegatedProperties[1];
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

    public static final /* synthetic */ MainViewModel access$getViewModel$p(MainFragment mainFragment) {
        MainViewModel mainViewModel = mainFragment.viewModel;
        if (mainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return mainViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/askgps/personaltrackercore/ui/main/MainFragment$Companion;", "", "()V", "SECONDS", "", "newInstance", "Lcom/askgps/personaltrackercore/ui/main/MainFragment;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MainFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MainFragment newInstance() {
            return new MainFragment();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.main_fragment, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ViewModel viewModel2 = ViewModelProviders.of(this).get(MainViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…ainViewModel::class.java)");
        this.viewModel = (MainViewModel) viewModel2;
        observeViewModel();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(parentFragmentManager, "parentFragmentManager");
        ((BatteryWidget) _$_findCachedViewById(R.id.main_battery_widget)).setParentFragmentManager(parentFragmentManager);
        ((BatteryWidget) _$_findCachedViewById(R.id.main_battery_widget)).registerBatteryReceiver();
        ((AppCompatButton) _$_findCachedViewById(R.id.main_btn_sos)).setOnClickListener(new MainFragment$onActivityCreated$1(this));
        ((AppCompatButton) _$_findCachedViewById(R.id.main_btn_action)).setOnClickListener(new MainFragment$onActivityCreated$2(this));
    }

    private final void observeViewModel() {
        MainViewModel mainViewModel = this.viewModel;
        if (mainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mainViewModel.getWorkIsStart().observe(getViewLifecycleOwner(), new MainFragment$observeViewModel$1(this));
        MainViewModel mainViewModel2 = this.viewModel;
        if (mainViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mainViewModel2.getShowLoader().observe(getViewLifecycleOwner(), new MainFragment$observeViewModel$2(this));
    }

    public void onResume() {
        super.onResume();
        runClockFace();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((BatteryWidget) _$_findCachedViewById(R.id.main_battery_widget)).unregisterBatteryReceiver();
        _$_clearFindViewByIdCache();
    }

    private final void runClockFace() {
        this.timerJob = BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getDefault(), null, new MainFragment$runClockFace$1(this, null), 2, null);
    }

    /* access modifiers changed from: private */
    public final void setClock() {
        MaterialTextView materialTextView = (MaterialTextView) _$_findCachedViewById(R.id.small_main_tc_time);
        Intrinsics.checkExpressionValueIsNotNull(materialTextView, "small_main_tc_time");
        materialTextView.setText(DateFormat.format(getTimeFormat(), this.cal));
    }

    public void onPause() {
        super.onPause();
        Job job = this.timerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }
}
