package com.askgps.personaltrackercore;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.askgps.personaltrackercore.config.CustomerCategory;
import com.askgps.personaltrackercore.database.model.Settings;
import com.askgps.personaltrackercore.extension.ContextExtensionKt;
import com.askgps.personaltrackercore.service.LocationService;
import com.askgps.personaltrackercore.service.PeriodicJobService;
import com.askgps.personaltrackercore.utils.FallUtils;
import com.askgps.personaltrackercore.utils.PedometerUtils;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.koin.core.qualifier.QualifierKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 @2\u00020\u0001:\u0001@B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\"H\u0002J\u0006\u0010%\u001a\u00020\u001eJ\u0006\u0010&\u001a\u00020\u001eJ\b\u0010'\u001a\u00020\"H\u0016J\u0012\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020\"H\u0014J\u001a\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J-\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020.2\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u000203022\u0006\u00104\u001a\u000205H\u0016¢\u0006\u0002\u00106J\u0010\u00107\u001a\u00020\"2\u0006\u00108\u001a\u00020\u001eH\u0016J\b\u00109\u001a\u00020\"H\u0002J\u0010\u0010:\u001a\u00020\"2\u0006\u0010;\u001a\u00020<H\u0004J\b\u0010=\u001a\u00020\"H\u0004J\b\u0010>\u001a\u00020\"H\u0004J\b\u0010?\u001a\u00020\"H\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006A"}, d2 = {"Lcom/askgps/personaltrackercore/BaseMainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "customerCategory", "Lcom/askgps/personaltrackercore/config/CustomerCategory;", "getCustomerCategory", "()Lcom/askgps/personaltrackercore/config/CustomerCategory;", "customerCategory$delegate", "Lkotlin/Lazy;", "fallUtils", "Lcom/askgps/personaltrackercore/utils/FallUtils;", "getFallUtils", "()Lcom/askgps/personaltrackercore/utils/FallUtils;", "fallUtils$delegate", "pedometerUtils", "Lcom/askgps/personaltrackercore/utils/PedometerUtils;", "getPedometerUtils", "()Lcom/askgps/personaltrackercore/utils/PedometerUtils;", "pedometerUtils$delegate", "viewModel", "Lcom/askgps/personaltrackercore/MainActivityViewModel;", "getViewModel", "()Lcom/askgps/personaltrackercore/MainActivityViewModel;", "setViewModel", "(Lcom/askgps/personaltrackercore/MainActivityViewModel;)V", "dispatchKeyEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "hideSystemUI", "", "initViewModel", "initViewPager", "isMyLauncherDefault", "isPhone", "observeViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onWindowFocusChanged", "hasFocus", "requestPermission", "startAllUtils", "settings", "Lcom/askgps/personaltrackercore/database/model/Settings;", "startOnTheHandJob", "stopAllUtils", "stopOnTheHandJob", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseMainActivity.kt */
public abstract class BaseMainActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);
    public static final long DEFAULT_LONG_VALUE = -1;
    public static final int JOB_ID = 1303;
    /* access modifiers changed from: private */
    public static final ReadWriteProperty LOCATION_INTERVAL$delegate = Delegates.INSTANCE.notNull();
    public static final int PAGE_COUNT = 2;
    public static final int PHONE_PAGE_COUNT = 1;
    public static final int REQUEST_PERMISSION = 1;
    public static final int REQUEST_TAKE_PHOTO = 2;
    /* access modifiers changed from: private */
    public static final ReadWriteProperty TELEMETRY_SEND_INTERVAL$delegate = Delegates.INSTANCE.notNull();
    public static CustomerCategory customer;
    /* access modifiers changed from: private */
    public static volatile boolean isNewUser = true;
    private static final String[] permissions = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_PHONE_STATE", "android.permission.CAMERA", "android.permission.BODY_SENSORS", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CALL_PHONE"};
    private HashMap _$_findViewCache;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final Lazy customerCategory$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new BaseMainActivity$$special$$inlined$inject$1(this, QualifierKt.named("customer_category"), null));
    private final Lazy fallUtils$delegate = LazyKt.lazy(new BaseMainActivity$fallUtils$2(this));
    private final Lazy pedometerUtils$delegate = LazyKt.lazy(new BaseMainActivity$pedometerUtils$2(this));
    protected MainActivityViewModel viewModel;

    private final CustomerCategory getCustomerCategory() {
        Lazy lazy = this.customerCategory$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (CustomerCategory) lazy.getValue();
    }

    private final FallUtils getFallUtils() {
        Lazy lazy = this.fallUtils$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (FallUtils) lazy.getValue();
    }

    private final PedometerUtils getPedometerUtils() {
        Lazy lazy = this.pedometerUtils$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (PedometerUtils) lazy.getValue();
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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R+\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006&"}, d2 = {"Lcom/askgps/personaltrackercore/BaseMainActivity$Companion;", "", "()V", "DEFAULT_LONG_VALUE", "", "JOB_ID", "", "<set-?>", "LOCATION_INTERVAL", "getLOCATION_INTERVAL", "()J", "setLOCATION_INTERVAL", "(J)V", "LOCATION_INTERVAL$delegate", "Lkotlin/properties/ReadWriteProperty;", "PAGE_COUNT", "PHONE_PAGE_COUNT", "REQUEST_PERMISSION", "REQUEST_TAKE_PHOTO", "TELEMETRY_SEND_INTERVAL", "getTELEMETRY_SEND_INTERVAL", "setTELEMETRY_SEND_INTERVAL", "TELEMETRY_SEND_INTERVAL$delegate", "customer", "Lcom/askgps/personaltrackercore/config/CustomerCategory;", "getCustomer", "()Lcom/askgps/personaltrackercore/config/CustomerCategory;", "setCustomer", "(Lcom/askgps/personaltrackercore/config/CustomerCategory;)V", "isNewUser", "", "()Z", "setNewUser", "(Z)V", "permissions", "", "", "[Ljava/lang/String;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: BaseMainActivity.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties;

        static {
            Class<Companion> cls = Companion.class;
            $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "TELEMETRY_SEND_INTERVAL", "getTELEMETRY_SEND_INTERVAL()J")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "LOCATION_INTERVAL", "getLOCATION_INTERVAL()J"))};
        }

        public final long getLOCATION_INTERVAL() {
            return ((Number) BaseMainActivity.LOCATION_INTERVAL$delegate.getValue(BaseMainActivity.Companion, $$delegatedProperties[1])).longValue();
        }

        public final long getTELEMETRY_SEND_INTERVAL() {
            return ((Number) BaseMainActivity.TELEMETRY_SEND_INTERVAL$delegate.getValue(BaseMainActivity.Companion, $$delegatedProperties[0])).longValue();
        }

        public final void setLOCATION_INTERVAL(long j) {
            BaseMainActivity.LOCATION_INTERVAL$delegate.setValue(BaseMainActivity.Companion, $$delegatedProperties[1], Long.valueOf(j));
        }

        public final void setTELEMETRY_SEND_INTERVAL(long j) {
            BaseMainActivity.TELEMETRY_SEND_INTERVAL$delegate.setValue(BaseMainActivity.Companion, $$delegatedProperties[0], Long.valueOf(j));
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CustomerCategory getCustomer() {
            CustomerCategory access$getCustomer$cp = BaseMainActivity.customer;
            if (access$getCustomer$cp == null) {
                Intrinsics.throwUninitializedPropertyAccessException("customer");
            }
            return access$getCustomer$cp;
        }

        public final void setCustomer(CustomerCategory customerCategory) {
            Intrinsics.checkParameterIsNotNull(customerCategory, "<set-?>");
            BaseMainActivity.customer = customerCategory;
        }

        public final boolean isNewUser() {
            return BaseMainActivity.isNewUser;
        }

        public final void setNewUser(boolean z) {
            BaseMainActivity.isNewUser = z;
        }
    }

    static {
        Class<BaseMainActivity> cls = BaseMainActivity.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "customerCategory", "getCustomerCategory()Lcom/askgps/personaltrackercore/config/CustomerCategory;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "pedometerUtils", "getPedometerUtils()Lcom/askgps/personaltrackercore/utils/PedometerUtils;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "fallUtils", "getFallUtils()Lcom/askgps/personaltrackercore/utils/FallUtils;"))};
    }

    /* access modifiers changed from: protected */
    public final MainActivityViewModel getViewModel() {
        MainActivityViewModel mainActivityViewModel = this.viewModel;
        if (mainActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return mainActivityViewModel;
    }

    /* access modifiers changed from: protected */
    public final void setViewModel(MainActivityViewModel mainActivityViewModel) {
        Intrinsics.checkParameterIsNotNull(mainActivityViewModel, "<set-?>");
        this.viewModel = mainActivityViewModel;
    }

    /* access modifiers changed from: protected */
    public final CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isPhone()) {
            customer = CustomerCategory.PATIENT_PHONE;
        } else {
            customer = getCustomerCategory();
        }
        Companion companion = Companion;
        CustomerCategory customerCategory = customer;
        if (customerCategory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customer");
        }
        companion.setTELEMETRY_SEND_INTERVAL(customerCategory.getSendLocationInterval());
        Companion companion2 = Companion;
        CustomerCategory customerCategory2 = customer;
        if (customerCategory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customer");
        }
        companion2.setLOCATION_INTERVAL(customerCategory2.getUpdateLocationInterval());
        Thread.setDefaultUncaughtExceptionHandler(new BaseMainActivity$onCreate$1(this));
        setContentView(R.layout.activity_main);
        initViewModel();
        observeViewModel();
        requestPermission();
        LogKt.toFile$default("-----------------------------------------", null, null, null, 7, null);
        LogKt.toFile$default("new start", null, null, null, 7, null);
        initViewPager();
        Intent intent = getIntent();
        if (intent != null) {
            onNewIntent(intent);
        }
    }

    public final boolean isMyLauncherDefault() {
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        return Intrinsics.areEqual(packageManager.resolveActivity(intent, 65536).activityInfo.packageName, getPackageName());
    }

    public final boolean isPhone() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(windowManager, "this.windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels != displayMetrics.widthPixels;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            hideSystemUI();
        }
    }

    private final void hideSystemUI() {
        Window window = getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "window");
        View decorView = window.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(decorView, "window.decorView");
        decorView.setSystemUiVisibility(3846);
    }

    private final void initViewPager() {
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(R.id.main_vp_screens);
        Intrinsics.checkExpressionValueIsNotNull(viewPager, "main_vp_screens");
        viewPager.setAdapter(new BaseMainActivity$initViewPager$1(this, getSupportFragmentManager(), 0));
        ((ViewPager) _$_findCachedViewById(R.id.main_vp_screens)).addOnPageChangeListener(new BaseMainActivity$initViewPager$2(this));
    }

    /* access modifiers changed from: protected */
    public final void startAllUtils(Settings settings) {
        Intrinsics.checkParameterIsNotNull(settings, "settings");
        StringBuilder sb = new StringBuilder();
        sb.append("start all utils for ");
        CustomerCategory customerCategory = customer;
        if (customerCategory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customer");
        }
        sb.append(customerCategory.name());
        LogKt.toFile$default(sb.toString(), null, null, null, 7, null);
        CustomerCategory customerCategory2 = customer;
        if (customerCategory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customer");
        }
        if (customerCategory2 == CustomerCategory.BUILDER_WATCH) {
            getFallUtils().registerSensorListener();
        }
        CustomerCategory customerCategory3 = customer;
        if (customerCategory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customer");
        }
        if (customerCategory3 == CustomerCategory.PATIENT_WATCH) {
            startOnTheHandJob();
        }
        LocationService.Companion.startService(this, settings.getLocationInterval(), settings.getSendTelemetryInterval());
    }

    /* access modifiers changed from: protected */
    public final void stopAllUtils() {
        CustomerCategory customerCategory = customer;
        if (customerCategory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customer");
        }
        if (customerCategory != CustomerCategory.BUILDER_WATCH) {
            stopOnTheHandJob();
        }
        CustomerCategory customerCategory2 = customer;
        if (customerCategory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customer");
        }
        if (customerCategory2 == CustomerCategory.BUILDER_WATCH) {
            getFallUtils().unregisterSensorListener();
        }
        LocationService.Companion.stopService(this);
        LogKt.toFile$default("stop all utils", null, null, null, 7, null);
    }

    /* access modifiers changed from: protected */
    public final void startOnTheHandJob() {
        MainActivityViewModel mainActivityViewModel = this.viewModel;
        if (mainActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Settings value = mainActivityViewModel.getSettings().getValue();
        long removalFromHandJobInterval = value != null ? value.getRemovalFromHandJobInterval() : 900000;
        Object systemService = getSystemService("jobscheduler");
        if (systemService != null) {
            Integer valueOf = Integer.valueOf(((JobScheduler) systemService).schedule(new JobInfo.Builder(JOB_ID, new ComponentName(this, PeriodicJobService.class)).setPeriodic(removalFromHandJobInterval).build()));
            LogKt.toFile$default(valueOf, "onTheHand job with " + removalFromHandJobInterval + " period", null, null, 6, null);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.job.JobScheduler");
    }

    /* access modifiers changed from: protected */
    public final void stopOnTheHandJob() {
        LogKt.toFile$default(this, "stopScheduler", null, null, 6, null);
        Object systemService = getSystemService("jobscheduler");
        if (systemService != null) {
            ((JobScheduler) systemService).cancel(JOB_ID);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.job.JobScheduler");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        MainActivityViewModel mainActivityViewModel = this.viewModel;
        if (mainActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mainActivityViewModel.getSettings().removeObservers(this);
        this.compositeDisposable.dispose();
    }

    public void initViewModel() {
        ViewModel viewModel2 = new ViewModelProvider(this).get(MainActivityViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProvider(this).…ityViewModel::class.java)");
        this.viewModel = (MainActivityViewModel) viewModel2;
    }

    public void observeViewModel() {
        MainActivityViewModel mainActivityViewModel = this.viewModel;
        if (mainActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        mainActivityViewModel.getSuccessfulIdentification().observe(lifecycleOwner, new BaseMainActivity$observeViewModel$1(this));
        MainActivityViewModel mainActivityViewModel2 = this.viewModel;
        if (mainActivityViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mainActivityViewModel2.getSettings().observeForever(new BaseMainActivity$observeViewModel$2(this));
        MainActivityViewModel mainActivityViewModel3 = this.viewModel;
        if (mainActivityViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        mainActivityViewModel3.getShowNetworkError().observe(lifecycleOwner, new BaseMainActivity$observeViewModel$3(this));
    }

    private final void requestPermission() {
        ActivityCompat.requestPermissions(this, permissions, 1);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            MainActivityViewModel mainActivityViewModel = this.viewModel;
            if (mainActivityViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            mainActivityViewModel.getImei().postValue(ContextExtensionKt.getID(this));
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Intrinsics.checkParameterIsNotNull(keyEvent, NotificationCompat.CATEGORY_EVENT);
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 3 || keyCode == 4 || keyCode == 82) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 3 || i == 4 || i == 82) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
