package com.askgps.personaltrackercore;

import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "t", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "e", "", "uncaughtException"}, k = 3, mv = {1, 1, 16})
/* compiled from: BaseMainActivity.kt */
final class BaseMainActivity$onCreate$1 implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ BaseMainActivity this$0;

    BaseMainActivity$onCreate$1(BaseMainActivity baseMainActivity) {
        this.this$0 = baseMainActivity;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        String message = th.getMessage();
        LogKt.toFile$default(message, "UncaughtException - " + thread, null, null, 6, null);
        Intrinsics.checkExpressionValueIsNotNull(th, "e");
        LogKt.toFile$default(th.getStackTrace(), "StackTrace", null, null, 6, null);
        Intrinsics.checkExpressionValueIsNotNull(thread, "t");
        if (thread.getId() == 1) {
            this.this$0.stopAllUtils();
            System.exit(2);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }
}
