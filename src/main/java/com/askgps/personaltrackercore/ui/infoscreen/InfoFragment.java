package com.askgps.personaltrackercore.ui.infoscreen;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.askgps.personaltrackercore.LogKt;
import com.askgps.personaltrackercore.R;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0001/B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0004H\u0002J\b\u0010.\u001a\u00020\u0004H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0018\u0010\u0013R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/askgps/personaltrackercore/ui/infoscreen/InfoFragment;", "Landroidx/fragment/app/DialogFragment;", "callback", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", NotificationCompat.CATEGORY_ALARM, "", "getAlarm", "()Z", "alarm$delegate", "Lkotlin/Lazy;", "attemptCount", "", "getAttemptCount", "()Ljava/lang/Integer;", "attemptCount$delegate", "iconId", "getIconId", "()I", "iconId$delegate", "mp", "Landroid/media/MediaPlayer;", "title", "getTitle", "title$delegate", "vibrateObserver", "Landroidx/lifecycle/Observer;", "viewModel", "Lcom/askgps/personaltrackercore/ui/infoscreen/InfoViewModel;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "startPlayAlarm", "stopPlayAlarm", InfoFragment.ALARM_ARGS_KEY, "Companion", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: InfoFragment.kt */
public final class InfoFragment extends DialogFragment {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    private static final String ALARM_ARGS_KEY = "vibrate";
    private static final String ATTEMPT_COUNT_ARGS_KEY = "string_title";
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final int DEFAULT_ICON_ID = R.drawable.ic_success;
    /* access modifiers changed from: private */
    public static final int DEFAULT_STR_ID = R.string.success_identification;
    private static final String ICON_ARGS_KEY = "icon";
    public static final String NETWORK_ERROR_TAG = "network_error_tag";
    private static final String TITLE_ARGS_KEY = "title";
    private HashMap _$_findViewCache;
    private final Lazy alarm$delegate = LazyKt.lazy(new InfoFragment$alarm$2(this));
    private final Lazy attemptCount$delegate = LazyKt.lazy(new InfoFragment$attemptCount$2(this));
    private final Function0<Unit> callback;
    private final Lazy iconId$delegate = LazyKt.lazy(new InfoFragment$iconId$2(this));
    private final MediaPlayer mp = new MediaPlayer();
    private final Lazy title$delegate = LazyKt.lazy(new InfoFragment$title$2(this));
    private final Observer<Boolean> vibrateObserver = new InfoFragment$vibrateObserver$1(this);
    private InfoViewModel viewModel;

    private final boolean getAlarm() {
        Lazy lazy = this.alarm$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Boolean) lazy.getValue()).booleanValue();
    }

    private final Integer getAttemptCount() {
        Lazy lazy = this.attemptCount$delegate;
        KProperty kProperty = $$delegatedProperties[3];
        return (Integer) lazy.getValue();
    }

    private final int getIconId() {
        Lazy lazy = this.iconId$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return ((Number) lazy.getValue()).intValue();
    }

    private final int getTitle() {
        Lazy lazy = this.title$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return ((Number) lazy.getValue()).intValue();
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

    public InfoFragment(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "callback");
        this.callback = function0;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JE\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\u0010\u0016J0\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00072\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J0\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J(\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J(\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J0\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J(\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J(\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/askgps/personaltrackercore/ui/infoscreen/InfoFragment$Companion;", "", "()V", "ALARM_ARGS_KEY", "", "ATTEMPT_COUNT_ARGS_KEY", "DEFAULT_ICON_ID", "", "DEFAULT_STR_ID", "ICON_ARGS_KEY", "NETWORK_ERROR_TAG", "TITLE_ARGS_KEY", "newInstance", "Lcom/askgps/personaltrackercore/ui/infoscreen/InfoFragment;", "strId", "iconId", NotificationCompat.CATEGORY_ALARM, "", "attemptCount", "callback", "Lkotlin/Function0;", "", "(IIZLjava/lang/Integer;Lkotlin/jvm/functions/Function0;)Lcom/askgps/personaltrackercore/ui/infoscreen/InfoFragment;", "showAuthErrorDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "code", "showBatteryLowDialog", "showCameraDialog", "showErrorDialog", "showNetworkErrorDialog", "showSuccessDialog", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: InfoFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ InfoFragment newInstance$default(Companion companion, int i, int i2, boolean z, Integer num, Function0 function0, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z = false;
            }
            boolean z2 = z;
            if ((i3 & 8) != 0) {
                num = null;
            }
            Integer num2 = num;
            if ((i3 & 16) != 0) {
                function0 = InfoFragment$Companion$newInstance$1.INSTANCE;
            }
            return companion.newInstance(i, i2, z2, num2, function0);
        }

        public final InfoFragment newInstance(int i, int i2, boolean z, Integer num, Function0<Unit> function0) {
            Intrinsics.checkParameterIsNotNull(function0, "callback");
            InfoFragment infoFragment = new InfoFragment(function0);
            Bundle bundle = new Bundle();
            if (num != null) {
                num.intValue();
                bundle.putInt(InfoFragment.ATTEMPT_COUNT_ARGS_KEY, num.intValue());
            }
            bundle.putInt("title", i);
            bundle.putInt("icon", i2);
            bundle.putBoolean(InfoFragment.ALARM_ARGS_KEY, z);
            infoFragment.setArguments(bundle);
            return infoFragment;
        }

        public static /* synthetic */ void showSuccessDialog$default(Companion companion, FragmentManager fragmentManager, boolean z, Function0 function0, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                function0 = InfoFragment$Companion$showSuccessDialog$1.INSTANCE;
            }
            companion.showSuccessDialog(fragmentManager, z, function0);
        }

        public final void showSuccessDialog(FragmentManager fragmentManager, boolean z, Function0<Unit> function0) {
            Intrinsics.checkParameterIsNotNull(fragmentManager, "fragmentManager");
            Intrinsics.checkParameterIsNotNull(function0, "callback");
            InfoFragment newInstance$default = newInstance$default(this, R.string.success_identification, R.drawable.ic_success, z, null, function0, 8, null);
            newInstance$default.setCancelable(false);
            newInstance$default.setStyle(1, R.style.FullScreenDialog);
            newInstance$default.show(fragmentManager, (String) null);
        }

        public static /* synthetic */ void showErrorDialog$default(Companion companion, FragmentManager fragmentManager, boolean z, Function0 function0, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                function0 = InfoFragment$Companion$showErrorDialog$1.INSTANCE;
            }
            companion.showErrorDialog(fragmentManager, z, function0);
        }

        public final void showErrorDialog(FragmentManager fragmentManager, boolean z, Function0<Unit> function0) {
            Intrinsics.checkParameterIsNotNull(fragmentManager, "fragmentManager");
            Intrinsics.checkParameterIsNotNull(function0, "callback");
            InfoFragment newInstance$default = newInstance$default(this, R.string.error_identification, R.drawable.ic_error, z, null, function0, 8, null);
            newInstance$default.setCancelable(false);
            newInstance$default.setStyle(1, R.style.FullScreenDialog);
            newInstance$default.show(fragmentManager, (String) null);
        }

        public static /* synthetic */ void showBatteryLowDialog$default(Companion companion, FragmentManager fragmentManager, int i, boolean z, Function0 function0, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                z = false;
            }
            if ((i2 & 8) != 0) {
                function0 = InfoFragment$Companion$showBatteryLowDialog$1.INSTANCE;
            }
            companion.showBatteryLowDialog(fragmentManager, i, z, function0);
        }

        public final void showBatteryLowDialog(FragmentManager fragmentManager, int i, boolean z, Function0<Unit> function0) {
            Intrinsics.checkParameterIsNotNull(fragmentManager, "fragmentManager");
            Intrinsics.checkParameterIsNotNull(function0, "callback");
            InfoFragment newInstance$default = newInstance$default(this, i, R.drawable.ic_error, z, null, function0, 8, null);
            newInstance$default.setCancelable(false);
            newInstance$default.setStyle(1, R.style.FullScreenDialog);
            newInstance$default.show(fragmentManager, (String) null);
        }

        public static /* synthetic */ void showNetworkErrorDialog$default(Companion companion, FragmentManager fragmentManager, boolean z, Function0 function0, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                function0 = InfoFragment$Companion$showNetworkErrorDialog$1.INSTANCE;
            }
            companion.showNetworkErrorDialog(fragmentManager, z, function0);
        }

        public final void showNetworkErrorDialog(FragmentManager fragmentManager, boolean z, Function0<Unit> function0) {
            Intrinsics.checkParameterIsNotNull(fragmentManager, "fragmentManager");
            Intrinsics.checkParameterIsNotNull(function0, "callback");
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(InfoFragment.NETWORK_ERROR_TAG);
            if (findFragmentByTag == null || !findFragmentByTag.isVisible()) {
                InfoFragment newInstance$default = newInstance$default(this, R.string.error_network, R.drawable.ic_signal_off, z, null, function0, 8, null);
                newInstance$default.setCancelable(false);
                newInstance$default.setStyle(1, R.style.FullScreenDialog);
                newInstance$default.show(fragmentManager, InfoFragment.NETWORK_ERROR_TAG);
            }
        }

        public static /* synthetic */ void showErrorDialog$default(Companion companion, FragmentManager fragmentManager, boolean z, int i, Function0 function0, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            if ((i2 & 8) != 0) {
                function0 = InfoFragment$Companion$showErrorDialog$2.INSTANCE;
            }
            companion.showErrorDialog(fragmentManager, z, i, function0);
        }

        public final void showErrorDialog(FragmentManager fragmentManager, boolean z, int i, Function0<Unit> function0) {
            Intrinsics.checkParameterIsNotNull(fragmentManager, "fragmentManager");
            Intrinsics.checkParameterIsNotNull(function0, "callback");
            InfoFragment newInstance = newInstance(R.string.error_identification_with_counter, R.drawable.ic_error, z, Integer.valueOf(i), function0);
            newInstance.setCancelable(false);
            newInstance.setStyle(1, R.style.FullScreenDialog);
            newInstance.show(fragmentManager, (String) null);
        }

        public static /* synthetic */ void showAuthErrorDialog$default(Companion companion, FragmentManager fragmentManager, boolean z, int i, Function0 function0, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            if ((i2 & 8) != 0) {
                function0 = InfoFragment$Companion$showAuthErrorDialog$1.INSTANCE;
            }
            companion.showAuthErrorDialog(fragmentManager, z, i, function0);
        }

        public final void showAuthErrorDialog(FragmentManager fragmentManager, boolean z, int i, Function0<Unit> function0) {
            Intrinsics.checkParameterIsNotNull(fragmentManager, "fragmentManager");
            Intrinsics.checkParameterIsNotNull(function0, "callback");
            InfoFragment newInstance = newInstance(R.string.error_auth, R.drawable.ic_error, z, Integer.valueOf(i), function0);
            newInstance.setCancelable(false);
            newInstance.setStyle(1, R.style.FullScreenDialog);
            newInstance.show(fragmentManager, (String) null);
        }

        public static /* synthetic */ void showCameraDialog$default(Companion companion, FragmentManager fragmentManager, boolean z, Function0 function0, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                function0 = InfoFragment$Companion$showCameraDialog$1.INSTANCE;
            }
            companion.showCameraDialog(fragmentManager, z, function0);
        }

        public final void showCameraDialog(FragmentManager fragmentManager, boolean z, Function0<Unit> function0) {
            Intrinsics.checkParameterIsNotNull(fragmentManager, "fragmentManager");
            Intrinsics.checkParameterIsNotNull(function0, "callback");
            InfoFragment newInstance$default = newInstance$default(this, R.string.need_identification, R.drawable.ic_camera, z, null, function0, 8, null);
            newInstance$default.setCancelable(false);
            newInstance$default.setStyle(1, R.style.FullScreenDialog);
            newInstance$default.show(fragmentManager, (String) null);
        }
    }

    static {
        Class<InfoFragment> cls = InfoFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), NotificationCompat.CATEGORY_ALARM, "getAlarm()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "title", "getTitle()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "iconId", "getIconId()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "attemptCount", "getAttemptCount()Ljava/lang/Integer;"))};
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.info_fragment, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ViewModel viewModel2 = ViewModelProviders.of(this).get(InfoViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…nfoViewModel::class.java)");
        InfoViewModel infoViewModel = (InfoViewModel) viewModel2;
        this.viewModel = infoViewModel;
        if (infoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        infoViewModel.getVibrate().observeForever(this.vibrateObserver);
        ((AppCompatImageView) _$_findCachedViewById(R.id.info_img_icon)).setImageResource(getIconId());
        if (getAttemptCount() != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.info_tv_title);
            Intrinsics.checkExpressionValueIsNotNull(appCompatTextView, "info_tv_title");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(getTitle());
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(title)");
            String format = String.format(string, Arrays.copyOf(new Object[]{getAttemptCount()}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            appCompatTextView.setText(format);
        } else {
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.info_tv_title);
            Intrinsics.checkExpressionValueIsNotNull(appCompatTextView2, "info_tv_title");
            appCompatTextView2.setText(getString(getTitle()));
        }
        if (getAlarm()) {
            startPlayAlarm();
        }
        ((AppCompatButton) _$_findCachedViewById(R.id.info_btn_cancel)).setOnClickListener(new InfoFragment$onActivityCreated$1(this));
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Dialog dialog = new Dialog(context, R.style.FullScreenDialog);
        dialog.setCancelable(false);
        return dialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkParameterIsNotNull(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        stopPlayAlarm();
        this.callback.invoke();
    }

    /* access modifiers changed from: private */
    public final void vibrate() {
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Object systemService = context.getSystemService("vibrator");
        if (systemService != null) {
            Vibrator vibrator = (Vibrator) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot(500, -1));
            } else {
                vibrator.vibrate(500);
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type android.os.Vibrator");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Throwable, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void
     arg types: [java.lang.Exception, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], int, ?[OBJECT, ARRAY]]
     candidates:
      com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Iterable, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void
      com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Object, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void
      com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Throwable, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void */
    private final void startPlayAlarm() {
        InfoViewModel infoViewModel = this.viewModel;
        if (infoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        infoViewModel.startVibration();
        try {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.mp.setDataSource(activity, RingtoneManager.getDefaultUri(4));
                Object systemService = activity.getSystemService("audio");
                if (systemService == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.media.AudioManager");
                } else if (((AudioManager) systemService).getStreamVolume(2) != 0) {
                    this.mp.setLooping(true);
                    this.mp.prepare();
                    this.mp.start();
                }
            }
        } catch (Exception e) {
            LogKt.toLog$default((Throwable) e, (String) null, (String) null, (String) null, 7, (Object) null);
        }
    }

    private final void stopPlayAlarm() {
        this.mp.stop();
        InfoViewModel infoViewModel = this.viewModel;
        if (infoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        infoViewModel.stopVibrate();
        InfoViewModel infoViewModel2 = this.viewModel;
        if (infoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        infoViewModel2.getVibrate().removeObserver(this.vibrateObserver);
    }
}
