package com.askgps.personaltrackercore.ui.phonebook;

import android.view.View;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: PhoneBookAdapter.kt */
final class PhoneBookViewHolder$setOnClickListener$1 implements View.OnClickListener {
    final /* synthetic */ Function1 $clickListener;
    final /* synthetic */ PhoneBookViewHolder this$0;

    PhoneBookViewHolder$setOnClickListener$1(PhoneBookViewHolder phoneBookViewHolder, Function1 function1) {
        this.this$0 = phoneBookViewHolder;
        this.$clickListener = function1;
    }

    public final void onClick(View view) {
        Function1 function1 = this.$clickListener;
        PhoneNumber phoneNumber = this.this$0.binding.getPhoneNumber();
        if (phoneNumber == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(phoneNumber, "binding.phoneNumber!!");
        function1.invoke(phoneNumber);
    }
}
