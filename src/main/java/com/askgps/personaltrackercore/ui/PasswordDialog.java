package com.askgps.personaltrackercore.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.askgps.personaltrackercore.HelperKt;
import com.askgps.personaltrackercore.R;
import com.askgps.personaltrackercore.ui.rightscreen.RightScreenFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/askgps/personaltrackercore/ui/PasswordDialog;", "Landroidx/fragment/app/DialogFragment;", "callback", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "checkPassword", "pass", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PasswordDialog.kt */
public final class PasswordDialog extends DialogFragment {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final Function1<Boolean, Unit> callback;

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

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit>, java.lang.Object, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PasswordDialog(kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r2) {
        /*
            r1 = this;
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            r1.<init>()
            r1.callback = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.askgps.personaltrackercore.ui.PasswordDialog.<init>(kotlin.jvm.functions.Function1):void");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.password_dialog, (ViewGroup) null);
        Context context2 = getContext();
        if (context2 == null) {
            Intrinsics.throwNpe();
        }
        AlertDialog create = new AlertDialog.Builder(context2, R.style.Dialog).setView(inflate).setPositiveButton(R.string.yes, (DialogInterface.OnClickListener) null).setNegativeButton(R.string.cancel, new PasswordDialog$onCreateDialog$1(this)).create();
        create.setOnShowListener(new PasswordDialog$onCreateDialog$$inlined$apply$lambda$1(create, this, inflate));
        setCancelable(false);
        Intrinsics.checkExpressionValueIsNotNull(create, "AlertDialog.Builder(cont…ble = false\n            }");
        return create;
    }

    /* access modifiers changed from: private */
    public final boolean checkPassword(String str) {
        return Intrinsics.areEqual(HelperKt.md5(str + str), RightScreenFragment.SETTINGS_PASSWORD_HASH);
    }
}
