package com.askgps.personaltrackercore.ui.phonebook;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import com.askgps.personaltrackercore.repository.Repository;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bR7\u0010\u0004\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b \t*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00060\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/askgps/personaltrackercore/ui/phonebook/PhoneBookViewModel;", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/KoinComponent;", "()V", "actionPhoneNumber", "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Pair;", "Lcom/askgps/personaltrackercore/ui/phonebook/PhoneBookViewModel$Action;", "Lcom/askgps/personaltrackercore/database/model/PhoneNumber;", "kotlin.jvm.PlatformType", "getActionPhoneNumber", "()Lio/reactivex/subjects/PublishSubject;", "adapter", "Lcom/askgps/personaltrackercore/ui/phonebook/PhoneBookAdapter;", "getAdapter", "()Lcom/askgps/personaltrackercore/ui/phonebook/PhoneBookAdapter;", "phoneNumbers", "Landroidx/lifecycle/LiveData;", "", "getPhoneNumbers", "()Landroidx/lifecycle/LiveData;", "repo", "Lcom/askgps/personaltrackercore/repository/Repository;", "getRepo", "()Lcom/askgps/personaltrackercore/repository/Repository;", "repo$delegate", "Lkotlin/Lazy;", "addPhoneNumber", "", "phoneNumber", "deletePhoneNumber", "Action", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PhoneBookViewModel.kt */
public final class PhoneBookViewModel extends ViewModel implements KoinComponent {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PhoneBookViewModel.class), "repo", "getRepo()Lcom/askgps/personaltrackercore/repository/Repository;"))};
    private final PublishSubject<Pair<Action, PhoneNumber>> actionPhoneNumber;
    private final PhoneBookAdapter adapter = new PhoneBookAdapter(new PhoneBookViewModel$adapter$2(this), new PhoneBookViewModel$adapter$1(this));
    private final LiveData<List<PhoneNumber>> phoneNumbers = getRepo().getPhoneNumbers();
    private final Lazy repo$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new PhoneBookViewModel$$special$$inlined$inject$1(this, null, null));

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/askgps/personaltrackercore/ui/phonebook/PhoneBookViewModel$Action;", "", "(Ljava/lang/String;I)V", "CALL", HttpRequest.METHOD_DELETE, "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PhoneBookViewModel.kt */
    public enum Action {
        CALL,
        DELETE
    }

    public final Repository getRepo() {
        Lazy lazy = this.repo$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Repository) lazy.getValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
     arg types: [kotlin.LazyThreadSafetyMode, com.askgps.personaltrackercore.ui.phonebook.PhoneBookViewModel$$special$$inlined$inject$1]
     candidates:
      kotlin.LazyKt__LazyJVMKt.lazy(java.lang.Object, kotlin.jvm.functions.Function0):kotlin.Lazy<T>
      kotlin.LazyKt__LazyJVMKt.lazy(kotlin.LazyThreadSafetyMode, kotlin.jvm.functions.Function0):kotlin.Lazy<T> */
    public PhoneBookViewModel() {
        PublishSubject<Pair<Action, PhoneNumber>> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<Pair<Action, PhoneNumber>>()");
        this.actionPhoneNumber = create;
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final PublishSubject<Pair<Action, PhoneNumber>> getActionPhoneNumber() {
        return this.actionPhoneNumber;
    }

    public final LiveData<List<PhoneNumber>> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public final PhoneBookAdapter getAdapter() {
        return this.adapter;
    }

    public final void addPhoneNumber(PhoneNumber phoneNumber) {
        Intrinsics.checkParameterIsNotNull(phoneNumber, "phoneNumber");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(super), Dispatchers.getIO(), null, new PhoneBookViewModel$addPhoneNumber$1(this, phoneNumber, null), 2, null);
    }

    public final void deletePhoneNumber(PhoneNumber phoneNumber) {
        Intrinsics.checkParameterIsNotNull(phoneNumber, "phoneNumber");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(super), Dispatchers.getIO(), null, new PhoneBookViewModel$deletePhoneNumber$1(this, phoneNumber, null), 2, null);
    }
}
