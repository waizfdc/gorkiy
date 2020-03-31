package com.askgps.personaltrackercore;

import com.askgps.personaltrackercore.utils.FallUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/askgps/personaltrackercore/utils/FallUtils;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: BaseMainActivity.kt */
final class BaseMainActivity$fallUtils$2 extends Lambda implements Function0<FallUtils> {
    final /* synthetic */ BaseMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseMainActivity$fallUtils$2(BaseMainActivity baseMainActivity) {
        super(0);
        this.this$0 = baseMainActivity;
    }

    public final FallUtils invoke() {
        return new FallUtils(this.this$0);
    }
}
