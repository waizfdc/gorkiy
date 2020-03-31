package com.askgps.personaltrackercore.ui;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.askgps.personaltrackercore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow", "com/askgps/personaltrackercore/ui/PasswordDialog$onCreateDialog$2$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: PasswordDialog.kt */
final class PasswordDialog$onCreateDialog$$inlined$apply$lambda$1 implements DialogInterface.OnShowListener {
    final /* synthetic */ AlertDialog $this_apply;
    final /* synthetic */ View $view$inlined;
    final /* synthetic */ PasswordDialog this$0;

    PasswordDialog$onCreateDialog$$inlined$apply$lambda$1(AlertDialog alertDialog, PasswordDialog passwordDialog, View view) {
        this.$this_apply = alertDialog;
        this.this$0 = passwordDialog;
        this.$view$inlined = view;
    }

    public final void onShow(DialogInterface dialogInterface) {
        Button button = this.$this_apply.getButton(-1);
        Intrinsics.checkExpressionValueIsNotNull(button, "getButton(AlertDialog.BUTTON_POSITIVE)");
        button.setOnClickListener(new View.OnClickListener(this) {
            /* class com.askgps.personaltrackercore.ui.PasswordDialog$onCreateDialog$$inlined$apply$lambda$1.AnonymousClass1 */
            final /* synthetic */ PasswordDialog$onCreateDialog$$inlined$apply$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                PasswordDialog passwordDialog = this.this$0.this$0;
                View findViewById = this.this$0.$view$inlined.findViewById(R.id.password);
                Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById<EditText>(R.id.password)");
                if (passwordDialog.checkPassword(((EditText) findViewById).getText().toString())) {
                    this.this$0.this$0.callback.invoke(true);
                    this.this$0.$this_apply.dismiss();
                    return;
                }
                Toast.makeText(this.this$0.$this_apply.getContext(), R.string.wrong_password, 0).show();
            }
        });
    }
}
