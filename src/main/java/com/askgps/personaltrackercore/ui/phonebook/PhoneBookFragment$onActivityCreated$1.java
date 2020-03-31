package com.askgps.personaltrackercore.ui.phonebook;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.askgps.personaltrackercore.R;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: PhoneBookFragment.kt */
final class PhoneBookFragment$onActivityCreated$1 implements View.OnClickListener {
    final /* synthetic */ PhoneBookFragment this$0;

    PhoneBookFragment$onActivityCreated$1(PhoneBookFragment phoneBookFragment) {
        this.this$0 = phoneBookFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        final View inflate = activity.getLayoutInflater().inflate(R.layout.add_contact, (ViewGroup) null);
        Context context = this.this$0.getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        new AlertDialog.Builder(context, R.style.Dialog).setTitle(R.string.add_contact).setView(inflate).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener(this) {
            /* class com.askgps.personaltrackercore.ui.phonebook.PhoneBookFragment$onActivityCreated$1.AnonymousClass1 */
            final /* synthetic */ PhoneBookFragment$onActivityCreated$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                View findViewById = inflate.findViewById(R.id.add_contact_te_name);
                Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById<TextIn…R.id.add_contact_te_name)");
                String valueOf = String.valueOf(((TextInputEditText) findViewById).getText());
                View findViewById2 = inflate.findViewById(R.id.add_contact_te_number);
                Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById<TextIn…id.add_contact_te_number)");
                PhoneBookFragment.access$getViewModel$p(this.this$0.this$0).addPhoneNumber(new PhoneNumber(valueOf, String.valueOf(((TextInputEditText) findViewById2).getText())));
            }
        }).setNegativeButton(R.string.cancel, AnonymousClass2.INSTANCE).create().show();
    }
}
