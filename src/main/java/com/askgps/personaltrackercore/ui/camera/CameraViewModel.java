package com.askgps.personaltrackercore.ui.camera;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.askgps.personaltrackercore.repository.Repository;
import com.hadilq.liveevent.LiveEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/askgps/personaltrackercore/ui/camera/CameraViewModel;", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/KoinComponent;", "()V", "idxId", "Lcom/hadilq/liveevent/LiveEvent;", "", "getIdxId", "()Lcom/hadilq/liveevent/LiveEvent;", "repo", "Lcom/askgps/personaltrackercore/repository/Repository;", "getRepo", "()Lcom/askgps/personaltrackercore/repository/Repository;", "repo$delegate", "Lkotlin/Lazy;", "registerUser", "", "path", "searchUser", "startIdentificationAsync", "id", "startIdentificationOnNavigationAsync", "", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CameraViewModel.kt */
public final class CameraViewModel extends ViewModel implements KoinComponent {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CameraViewModel.class), "repo", "getRepo()Lcom/askgps/personaltrackercore/repository/Repository;"))};
    private final LiveEvent<String> idxId = getRepo().getIdxId();
    private final Lazy repo$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new CameraViewModel$$special$$inlined$inject$1(this, null, null));

    /* access modifiers changed from: private */
    public final Repository getRepo() {
        Lazy lazy = this.repo$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Repository) lazy.getValue();
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final LiveEvent<String> getIdxId() {
        return this.idxId;
    }

    public final String searchUser(String str) {
        Intrinsics.checkParameterIsNotNull(str, "path");
        return getRepo().searchUserInIdentix(str);
    }

    public final void startIdentificationAsync(String str) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(super), Dispatchers.getIO(), null, new CameraViewModel$startIdentificationAsync$1(this, str, null), 2, null);
    }

    public final boolean startIdentificationOnNavigationAsync(String str) {
        Intrinsics.checkParameterIsNotNull(str, "path");
        return getRepo().startIdentificationOnNavigationAsync(str);
    }

    public final void registerUser(String str) {
        Intrinsics.checkParameterIsNotNull(str, "path");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(super), Dispatchers.getIO(), null, new CameraViewModel$registerUser$1(this, str, null), 2, null);
    }
}
