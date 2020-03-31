package com.askgps.personaltrackercore.ui.rightscreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.askgps.personaltrackercore.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/askgps/personaltrackercore/ui/rightscreen/RightScreenFragment;", "Landroidx/fragment/app/Fragment;", "()V", "viewModel", "Lcom/askgps/personaltrackercore/ui/rightscreen/RightScreenViewModel;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setOnClickListeners", "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: RightScreenFragment.kt */
public final class RightScreenFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    public static final String SETTINGS_PASSWORD_HASH = "428f2ad9945663b04963f7398887a65";
    private HashMap _$_findViewCache;
    private RightScreenViewModel viewModel;

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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/askgps/personaltrackercore/ui/rightscreen/RightScreenFragment$Companion;", "", "()V", "SETTINGS_PASSWORD_HASH", "", "newInstance", "Lcom/askgps/personaltrackercore/ui/rightscreen/RightScreenFragment;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RightScreenFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RightScreenFragment newInstance() {
            return new RightScreenFragment();
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
        return layoutInflater.inflate(R.layout.right_screen_fragment, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ViewModel viewModel2 = ViewModelProviders.of(this).get(RightScreenViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…eenViewModel::class.java)");
        this.viewModel = (RightScreenViewModel) viewModel2;
        setOnClickListeners();
    }

    private final void setOnClickListeners() {
        View findViewById;
        ((AppCompatImageButton) _$_findCachedViewById(R.id.right_btn_settings)).setOnClickListener(new RightScreenFragment$setOnClickListeners$1(this));
        ((AppCompatImageButton) _$_findCachedViewById(R.id.right_btn_qr)).setOnClickListener(new RightScreenFragment$setOnClickListeners$2(this));
        ((AppCompatImageButton) _$_findCachedViewById(R.id.right_btn_market)).setOnClickListener(new RightScreenFragment$setOnClickListeners$3(this));
        View view = getView();
        if (view != null && (findViewById = view.findViewById(R.id.right_btn_contacts)) != null) {
            findViewById.setOnClickListener(new RightScreenFragment$setOnClickListeners$4(this));
        }
    }
}
