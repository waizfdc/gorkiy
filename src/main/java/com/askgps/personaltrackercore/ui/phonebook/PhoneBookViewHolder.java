package com.askgps.personaltrackercore.ui.phonebook;

import androidx.recyclerview.widget.RecyclerView;
import com.askgps.personaltrackercore.database.model.PhoneNumber;
import com.askgps.personaltrackercore.databinding.PhoneNumberBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u000bJ\u001a\u0010\f\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/askgps/personaltrackercore/ui/phonebook/PhoneBookViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/askgps/personaltrackercore/databinding/PhoneNumberBinding;", "(Lcom/askgps/personaltrackercore/databinding/PhoneNumberBinding;)V", "bind", "", "phoneNumber", "Lcom/askgps/personaltrackercore/database/model/PhoneNumber;", "setOnClickListener", "clickListener", "Lkotlin/Function1;", "setOnLongClickListener", "longClickListener", "personaltrackercore_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PhoneBookAdapter.kt */
public final class PhoneBookViewHolder extends RecyclerView.ViewHolder {
    /* access modifiers changed from: private */
    public final PhoneNumberBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneBookViewHolder(PhoneNumberBinding phoneNumberBinding) {
        super(phoneNumberBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(phoneNumberBinding, "binding");
        this.binding = phoneNumberBinding;
    }

    public final void bind(PhoneNumber phoneNumber) {
        Intrinsics.checkParameterIsNotNull(phoneNumber, "phoneNumber");
        this.binding.setPhoneNumber(phoneNumber);
        this.binding.executePendingBindings();
    }

    public final void setOnClickListener(Function1<? super PhoneNumber, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "clickListener");
        this.binding.getRoot().setOnClickListener(new PhoneBookViewHolder$setOnClickListener$1(this, function1));
    }

    public final void setOnLongClickListener(Function1<? super PhoneNumber, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "longClickListener");
        this.binding.getRoot().setOnLongClickListener(new PhoneBookViewHolder$setOnLongClickListener$1(this, function1));
    }
}
