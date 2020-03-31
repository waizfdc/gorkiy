package com.askgps.personaltrackerround;

import com.askgps.personaltrackercore.LogKt;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 16})
/* compiled from: MainActivity.kt */
final class MainActivity$observeViewModel$5<T> implements Consumer<Boolean> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$observeViewModel$5(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Throwable, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void
     arg types: [java.lang.Exception, ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], ?[OBJECT, ARRAY], int, ?[OBJECT, ARRAY]]
     candidates:
      com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Iterable, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void
      com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Object, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void
      com.askgps.personaltrackercore.LogKt.toLog$default(java.lang.Throwable, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):void */
    public final void accept(Boolean bool) {
        LogKt.toFile$default(bool, "show alarm", null, null, 6, null);
        try {
            Intrinsics.checkExpressionValueIsNotNull(bool, "it");
            if (bool.booleanValue()) {
                this.this$0.startIdentification(true, true);
            }
        } catch (Exception e) {
            LogKt.toLog$default((Throwable) e, (String) null, (String) null, (String) null, 7, (Object) null);
        }
    }
}
