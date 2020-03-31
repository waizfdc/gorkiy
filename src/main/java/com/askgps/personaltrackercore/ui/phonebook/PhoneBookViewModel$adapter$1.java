package com.askgps.personaltrackercore.ui.phonebook;

import com.askgps.personaltrackercore.database.model.PhoneNumber;
import com.askgps.personaltrackercore.ui.phonebook.PhoneBookViewModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/askgps/personaltrackercore/database/model/PhoneNumber;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: PhoneBookViewModel.kt */
final class PhoneBookViewModel$adapter$1 extends Lambda implements Function1<PhoneNumber, Unit> {
    final /* synthetic */ PhoneBookViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PhoneBookViewModel$adapter$1(PhoneBookViewModel phoneBookViewModel) {
        super(1);
        this.this$0 = phoneBookViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PhoneNumber) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PhoneNumber phoneNumber) {
        Intrinsics.checkParameterIsNotNull(phoneNumber, "it");
        this.this$0.getActionPhoneNumber().onNext(TuplesKt.to(PhoneBookViewModel.Action.DELETE, phoneNumber));
    }
}
