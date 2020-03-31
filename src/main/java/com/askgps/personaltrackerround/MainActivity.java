package com.askgps.personaltrackerround;

import android.content.Intent;
import android.os.PowerManager;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.askgps.personaltrackercore.BaseMainActivity;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.database.model.Settings;
import com.askgps.personaltrackercore.service.MessagingService;
import com.askgps.personaltrackercore.ui.camera.CameraFragment;
import com.askgps.personaltrackercore.ui.infoscreen.InfoFragment;
import com.askgps.personaltrackercore.utils.PeriodicJob;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.HashMap;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0019\u0010\u000f\u001a\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u000f\u001a\u00060\u0010R\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/askgps/personaltrackerround/MainActivity;", "Lcom/askgps/personaltrackercore/BaseMainActivity;", "()V", "job", "Lkotlinx/coroutines/CompletableJob;", "onTheHandJob", "Lkotlinx/coroutines/Job;", "periodicalJob", "Lcom/askgps/personaltrackercore/utils/PeriodicJob;", "getPeriodicalJob", "()Lcom/askgps/personaltrackercore/utils/PeriodicJob;", "periodicalJob$delegate", "Lkotlin/Lazy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "getWakeLock", "()Landroid/os/PowerManager$WakeLock;", "wakeLock$delegate", "observeViewModel", "", "onNewIntent", "intent", "Landroid/content/Intent;", "startIdentification", "withInfoDialog", "", "resetAttemptCount", "timeOut", "", "(Ljava/lang/Long;)V", "Companion", "round_for_patient_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MainActivity.kt */
public final class MainActivity extends BaseMainActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);
    public static final String INTENT_KEY_INFO_DIALOG = "intent_key_info_dialog";
    public static final String INTENT_KEY_START_IDENTIFICATION = "intent_key_start_identification";
    public static final String RESET_ATTEMPT_COUNT = "reset_attempt_count";
    private HashMap _$_findViewCache;
    private final CompletableJob job;
    private Job onTheHandJob;
    private final Lazy periodicalJob$delegate = LazyKt.lazy(new MainActivity$periodicalJob$2(this));
    /* access modifiers changed from: private */
    public final CoroutineScope scope;
    private final Lazy wakeLock$delegate;

    static {
        Class<MainActivity> cls = MainActivity.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "periodicalJob", "getPeriodicalJob()Lcom/askgps/personaltrackercore/utils/PeriodicJob;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "wakeLock", "getWakeLock()Landroid/os/PowerManager$WakeLock;"))};
    }

    private final PeriodicJob getPeriodicalJob() {
        Lazy lazy = this.periodicalJob$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (PeriodicJob) lazy.getValue();
    }

    private final PowerManager.WakeLock getWakeLock() {
        Lazy lazy = this.wakeLock$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (PowerManager.WakeLock) lazy.getValue();
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

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlinx.coroutines.SupervisorKt.SupervisorJob$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.CompletableJob
     arg types: [?[OBJECT, ARRAY], int, ?[OBJECT, ARRAY]]
     candidates:
      kotlinx.coroutines.SupervisorKt.SupervisorJob$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.Job
      kotlinx.coroutines.SupervisorKt.SupervisorJob$default(kotlinx.coroutines.Job, int, java.lang.Object):kotlinx.coroutines.CompletableJob */
    public MainActivity() {
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = SupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorJob$default.plus(Dispatchers.getDefault()));
        this.wakeLock$delegate = LazyKt.lazy(new MainActivity$wakeLock$2(this));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/askgps/personaltrackerround/MainActivity$Companion;", "", "()V", "INTENT_KEY_INFO_DIALOG", "", "INTENT_KEY_START_IDENTIFICATION", "RESET_ATTEMPT_COUNT", "round_for_patient_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: MainActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void observeViewModel() {
        LifecycleOwner lifecycleOwner = this;
        getViewModel().getSuccessfulIdentification().observe(lifecycleOwner, new MainActivity$observeViewModel$1(this));
        getViewModel().getAuthCode().observe(lifecycleOwner, new MainActivity$observeViewModel$2(this));
        getViewModel().getShowNetworkError().observe(lifecycleOwner, new MainActivity$observeViewModel$3(this));
        getViewModel().getSettings().observeForever(new MainActivity$observeViewModel$4(this));
        getCompositeDisposable().add(getViewModel().getShowAlarm().observeOn(AndroidSchedulers.mainThread()).subscribe(new MainActivity$observeViewModel$5(this), MainActivity$observeViewModel$6.INSTANCE));
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra(MessagingService.SERVER_ADDRESS_KEY);
        Long l = null;
        Long l2 = null;
        Long valueOf = Long.valueOf(intent.getLongExtra(MessagingService.SEND_TELEMETRY_INTERVAL_KEY, -1));
        if (!(valueOf.longValue() != -1)) {
            valueOf = null;
        }
        Long valueOf2 = valueOf != null ? Long.valueOf(valueOf.longValue()) : l2;
        Long valueOf3 = Long.valueOf(intent.getLongExtra(MessagingService.LOCATION_INTERVAL_KEY, -1));
        if (!(valueOf3.longValue() != -1)) {
            valueOf3 = null;
        }
        Long valueOf4 = valueOf3 != null ? Long.valueOf(valueOf3.longValue()) : l2;
        Long valueOf5 = Long.valueOf(intent.getLongExtra(MessagingService.REMOVAL_FROM_HAND_INTERVAL_KEY, -1));
        if (valueOf5.longValue() != -1) {
            l = valueOf5;
        }
        if (l != null) {
            l2 = Long.valueOf(l.longValue());
        }
        getViewModel().updateSettings(stringExtra, valueOf4, valueOf2, l2);
        Settings value = getViewModel().getSettings().getValue();
        if (value != null && value.getWorkIsStart()) {
            boolean booleanExtra = intent.getBooleanExtra(INTENT_KEY_START_IDENTIFICATION, false);
            boolean booleanExtra2 = intent.getBooleanExtra(RESET_ATTEMPT_COUNT, false);
            if (booleanExtra) {
                if (booleanExtra2) {
                    getViewModel().resetAttemptCount();
                }
                if (intent.getBooleanExtra(INTENT_KEY_INFO_DIALOG, false)) {
                    InfoFragment.Companion companion = InfoFragment.Companion;
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
                    InfoFragment.Companion.showCameraDialog$default(companion, supportFragmentManager, false, new MainActivity$onNewIntent$7(this), 2, null);
                    return;
                }
                CameraFragment newInstance = CameraFragment.Companion.newInstance();
                newInstance.setCancelable(true);
                newInstance.show(getSupportFragmentManager(), CameraFragment.class.getSimpleName());
            }
        }
    }

    static /* synthetic */ void wakeLock$default(MainActivity mainActivity, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        mainActivity.wakeLock(l);
    }

    private final void wakeLock(Long l) {
        if (getWakeLock().isHeld()) {
            return;
        }
        if (l != null) {
            getWakeLock().acquire(l.longValue());
        } else {
            getWakeLock().acquire();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    /* access modifiers changed from: private */
    public final void startIdentification(boolean z, boolean z2) {
        LogKt.toFile$default("startIdentification(withInfoDialog: withInfoDialog, " + z2 + ": " + z2 + ')', null, null, null, 7, null);
        if (z2) {
            getViewModel().resetAttemptCount();
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(INTENT_KEY_START_IDENTIFICATION, true);
        intent.putExtra(RESET_ATTEMPT_COUNT, z2);
        intent.putExtra(INTENT_KEY_INFO_DIALOG, z);
        intent.setFlags(872415232);
        startActivity(intent);
    }
}
