package com.askgps.personaltrackercore.ui.phonebook;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.askgps.personaltrackercore.R;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import com.askgps.personaltrackercore.extension.ContextExtensionKt;
import com.askgps.personaltrackercore.ui.phonebook.PhoneBookFragment;
import com.askgps.personaltrackercore.ui.phonebook.PhoneBookViewModel;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "Lcom/askgps/personaltrackercore/ui/phonebook/PhoneBookViewModel$Action;", "Lcom/askgps/personaltrackercore/database/model/PhoneNumber;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 16})
/* compiled from: PhoneBookFragment.kt */
final class PhoneBookFragment$observeViewModel$2<T> implements Consumer<Pair<? extends PhoneBookViewModel.Action, ? extends PhoneNumber>> {
    final /* synthetic */ PhoneBookFragment this$0;

    PhoneBookFragment$observeViewModel$2(PhoneBookFragment phoneBookFragment) {
        this.this$0 = phoneBookFragment;
    }

    public /* bridge */ /* synthetic */ void accept(Object obj) {
        accept((Pair<? extends PhoneBookViewModel.Action, PhoneNumber>) ((Pair) obj));
    }

    public final void accept(final Pair<? extends PhoneBookViewModel.Action, PhoneNumber> pair) {
        int i = PhoneBookFragment.WhenMappings.$EnumSwitchMapping$0[((PhoneBookViewModel.Action) pair.getFirst()).ordinal()];
        if (i == 1) {
            Context context = this.this$0.getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            new AlertDialog.Builder(context, R.style.Dialog).setTitle(R.string.make_call).setMessage(pair.getSecond().getNumber()).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener(this) {
                /* class com.askgps.personaltrackercore.ui.phonebook.PhoneBookFragment$observeViewModel$2.AnonymousClass1 */
                final /* synthetic */ PhoneBookFragment$observeViewModel$2 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Context context = this.this$0.this$0.getContext();
                    if (context != null) {
                        ContextExtensionKt.makeCall(context, ((PhoneNumber) pair.getSecond()).getNumber());
                    }
                }
            }).setNegativeButton(R.string.cancel, AnonymousClass2.INSTANCE).create().show();
        } else if (i == 2) {
            Context context2 = this.this$0.getContext();
            if (context2 == null) {
                Intrinsics.throwNpe();
            }
            new AlertDialog.Builder(context2, R.style.Dialog).setTitle(R.string.delete_contact).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener(this) {
                /* class com.askgps.personaltrackercore.ui.phonebook.PhoneBookFragment$observeViewModel$2.AnonymousClass3 */
                final /* synthetic */ PhoneBookFragment$observeViewModel$2 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    PhoneBookFragment.access$getViewModel$p(this.this$0.this$0).deletePhoneNumber((PhoneNumber) pair.getSecond());
                }
            }).setNegativeButton(R.string.cancel, AnonymousClass4.INSTANCE).create().show();
        }
    }
}
