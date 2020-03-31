package com.askgps.personaltrackercore.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import com.askgps.personaltrackercore.repository.Repository;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003JI\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001c0\"J\u0006\u0010&\u001a\u00020\u001cJ\u0006\u0010'\u001a\u00020\u001cR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR\u001f\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00160\u00160\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000e¨\u0006("}, d2 = {"Lcom/askgps/personaltrackercore/ui/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/KoinComponent;", "()V", "imei", "Landroidx/lifecycle/MutableLiveData;", "", "getImei", "()Landroidx/lifecycle/MutableLiveData;", "phoneNumbers", "Landroidx/lifecycle/LiveData;", "", "Lcom/askgps/personaltrackercore/database/model/PhoneNumber;", "getPhoneNumbers", "()Landroidx/lifecycle/LiveData;", "repo", "Lcom/askgps/personaltrackercore/repository/Repository;", "getRepo", "()Lcom/askgps/personaltrackercore/repository/Repository;", "repo$delegate", "Lkotlin/Lazy;", "showLoader", "", "getShowLoader", "workIsStart", "kotlin.jvm.PlatformType", "getWorkIsStart", "registerUser", "", "fio", "email", "phone", "password", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "result", "resetAttemptLeft", "setUserStatus", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MainViewModel.kt */
public final class MainViewModel extends ViewModel implements KoinComponent {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MainViewModel.class), "repo", "getRepo()Lcom/askgps/personaltrackercore/repository/Repository;"))};
    private final MutableLiveData<String> imei;
    private final LiveData<List<PhoneNumber>> phoneNumbers;
    private final Lazy repo$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new MainViewModel$$special$$inlined$inject$1(this, null, null));
    private final MutableLiveData<Boolean> showLoader = getRepo().getShowLoader();
    private final LiveData<Boolean> workIsStart;

    /* access modifiers changed from: private */
    public final Repository getRepo() {
        Lazy lazy = this.repo$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Repository) lazy.getValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, com.askgps.personaltrackercore.ui.main.MainViewModel$$special$$inlined$inject$1]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public MainViewModel() {
        LiveData<Boolean> map = Transformations.map(getRepo().getSettings(), MainViewModel$workIsStart$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "Transformations.map(repo…     it.workIsStart\n    }");
        this.workIsStart = map;
        this.phoneNumbers = getRepo().getPhoneNumbers();
        this.imei = getRepo().getImei();
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final MutableLiveData<Boolean> getShowLoader() {
        return this.showLoader;
    }

    public final LiveData<Boolean> getWorkIsStart() {
        return this.workIsStart;
    }

    public final LiveData<List<PhoneNumber>> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public final MutableLiveData<String> getImei() {
        return this.imei;
    }

    public final void resetAttemptLeft() {
        getRepo().resetAttemptLeft();
    }

    public final void registerUser(String str, String str2, String str3, String str4, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "fio");
        Intrinsics.checkParameterIsNotNull(str2, "email");
        Intrinsics.checkParameterIsNotNull(str3, "phone");
        String str5 = str4;
        Intrinsics.checkParameterIsNotNull(str5, "password");
        Function1<? super Boolean, Unit> function12 = function1;
        Intrinsics.checkParameterIsNotNull(function12, "callback");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(super);
        CoroutineContext io2 = Dispatchers.getIO();
        Job unused = BuildersKt__Builders_commonKt.launch$default(viewModelScope, io2, null, new MainViewModel$registerUser$1(this, str, str5, str3, str2, booleanRef, function12, null), 2, null);
    }

    public final void setUserStatus() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(super), Dispatchers.getIO(), null, new MainViewModel$setUserStatus$1(this, null), 2, null);
    }
}
