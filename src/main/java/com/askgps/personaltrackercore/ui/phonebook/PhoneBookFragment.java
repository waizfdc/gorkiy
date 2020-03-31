package com.askgps.personaltrackercore.ui.phonebook;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.askgps.personaltrackercore.R;
import com.askgps.personaltrackercore.databinding.PhoneBookFragmentBinding;
import com.askgps.personaltrackercore.ui.phonebook.PhoneBookViewModel;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/askgps/personaltrackercore/ui/phonebook/PhoneBookFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lcom/askgps/personaltrackercore/databinding/PhoneBookFragmentBinding;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "viewModel", "Lcom/askgps/personaltrackercore/ui/phonebook/PhoneBookViewModel;", "observeViewModel", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PhoneBookFragment.kt */
public final class PhoneBookFragment extends DialogFragment {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    private PhoneBookFragmentBinding binding;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    /* access modifiers changed from: private */
    public PhoneBookViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PhoneBookViewModel.Action.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PhoneBookViewModel.Action.CALL.ordinal()] = 1;
            $EnumSwitchMapping$0[PhoneBookViewModel.Action.DELETE.ordinal()] = 2;
        }
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

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final /* synthetic */ PhoneBookViewModel access$getViewModel$p(PhoneBookFragment phoneBookFragment) {
        PhoneBookViewModel phoneBookViewModel = phoneBookFragment.viewModel;
        if (phoneBookViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return phoneBookViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/askgps/personaltrackercore/ui/phonebook/PhoneBookFragment$Companion;", "", "()V", "newInstance", "Lcom/askgps/personaltrackercore/ui/phonebook/PhoneBookFragment;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PhoneBookFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PhoneBookFragment newInstance() {
            return new PhoneBookFragment();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        PhoneBookFragmentBinding inflate = PhoneBookFragmentBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "PhoneBookFragmentBinding…flater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return inflate.getRoot();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ViewModel viewModel2 = ViewModelProviders.of(this).get(PhoneBookViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…ookViewModel::class.java)");
        this.viewModel = (PhoneBookViewModel) viewModel2;
        PhoneBookFragmentBinding phoneBookFragmentBinding = this.binding;
        if (phoneBookFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        PhoneBookViewModel phoneBookViewModel = this.viewModel;
        if (phoneBookViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        phoneBookFragmentBinding.setVm(phoneBookViewModel);
        PhoneBookFragmentBinding phoneBookFragmentBinding2 = this.binding;
        if (phoneBookFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        phoneBookFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        PhoneBookFragmentBinding phoneBookFragmentBinding3 = this.binding;
        if (phoneBookFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        phoneBookFragmentBinding3.executePendingBindings();
        observeViewModel();
        PhoneBookFragmentBinding phoneBookFragmentBinding4 = this.binding;
        if (phoneBookFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        phoneBookFragmentBinding4.phoneBookBtnAdd.setOnClickListener(new PhoneBookFragment$onActivityCreated$1(this));
    }

    private final void observeViewModel() {
        PhoneBookViewModel phoneBookViewModel = this.viewModel;
        if (phoneBookViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        phoneBookViewModel.getPhoneNumbers().observe(getViewLifecycleOwner(), new PhoneBookFragment$observeViewModel$1(this));
        CompositeDisposable compositeDisposable2 = this.compositeDisposable;
        PhoneBookViewModel phoneBookViewModel2 = this.viewModel;
        if (phoneBookViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        compositeDisposable2.add(phoneBookViewModel2.getActionPhoneNumber().subscribe(new PhoneBookFragment$observeViewModel$2(this)));
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        return new Dialog(context, R.style.FullScreenDialog);
    }
}
