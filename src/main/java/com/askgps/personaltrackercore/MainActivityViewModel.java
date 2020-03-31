package com.askgps.personaltrackercore;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.askgps.personaltrackercore.database.model.Settings;
import com.askgps.personaltrackercore.repository.Repository;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010$\u001a\u00020%J3\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010\u000e2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010)¢\u0006\u0002\u0010,R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u001f\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000b¨\u0006-"}, d2 = {"Lcom/askgps/personaltrackercore/MainActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/KoinComponent;", "()V", "attemptCountLeft", "", "getAttemptCountLeft", "()I", "authCode", "Landroidx/lifecycle/LiveData;", "getAuthCode", "()Landroidx/lifecycle/LiveData;", "imei", "Landroidx/lifecycle/MutableLiveData;", "", "getImei", "()Landroidx/lifecycle/MutableLiveData;", "repo", "Lcom/askgps/personaltrackercore/repository/Repository;", "getRepo", "()Lcom/askgps/personaltrackercore/repository/Repository;", "repo$delegate", "Lkotlin/Lazy;", "settings", "Lcom/askgps/personaltrackercore/database/model/Settings;", "getSettings", "showAlarm", "Lio/reactivex/subjects/PublishSubject;", "", "kotlin.jvm.PlatformType", "getShowAlarm", "()Lio/reactivex/subjects/PublishSubject;", "showNetworkError", "getShowNetworkError", "successfulIdentification", "getSuccessfulIdentification", "resetAttemptCount", "", "updateSettings", "address", "locationInterval", "", "sendTelemetryInterval", "removalFromHandInterval", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MainActivityViewModel.kt */
public final class MainActivityViewModel extends ViewModel implements KoinComponent {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MainActivityViewModel.class), "repo", "getRepo()Lcom/askgps/personaltrackercore/repository/Repository;"))};
    private final LiveData<Integer> authCode = getRepo().getAuthCode();
    private final MutableLiveData<String> imei = getRepo().getImei();
    private final Lazy repo$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new MainActivityViewModel$$special$$inlined$inject$1(this, null, null));
    private final LiveData<Settings> settings = getRepo().getSettings();
    private final PublishSubject<Boolean> showAlarm = getRepo().getAlarm();
    private final MutableLiveData<Boolean> showNetworkError = getRepo().getShowNetworkError();
    private final LiveData<Boolean> successfulIdentification = getRepo().getSuccessfulIdentification();

    /* access modifiers changed from: private */
    public final Repository getRepo() {
        Lazy lazy = this.repo$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Repository) lazy.getValue();
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final MutableLiveData<String> getImei() {
        return this.imei;
    }

    public final LiveData<Settings> getSettings() {
        return this.settings;
    }

    public final LiveData<Boolean> getSuccessfulIdentification() {
        return this.successfulIdentification;
    }

    public final LiveData<Integer> getAuthCode() {
        return this.authCode;
    }

    public final PublishSubject<Boolean> getShowAlarm() {
        return this.showAlarm;
    }

    public final int getAttemptCountLeft() {
        return getRepo().getAttemptCountLeft();
    }

    public final MutableLiveData<Boolean> getShowNetworkError() {
        return this.showNetworkError;
    }

    public final void updateSettings(String str, Long l, Long l2, Long l3) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(super), Dispatchers.getIO(), null, new MainActivityViewModel$updateSettings$1(this, str, l, l2, l3, null), 2, null);
    }

    public final void resetAttemptCount() {
        getRepo().resetAttemptLeft();
    }
}
