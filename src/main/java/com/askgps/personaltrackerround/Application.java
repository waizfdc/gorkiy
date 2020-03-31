package com.askgps.personaltrackerround;

import android.content.Context;
import com.askgps.personaltrackercore.BaseApplication;
import com.askgps.personaltrackercore.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.context.ContextFunctionsKt;
import org.koin.core.context.KoinContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/askgps/personaltrackerround/Application;", "Lcom/askgps/personaltrackercore/BaseApplication;", "()V", "onCreate", "", "round_for_patient_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Application.kt */
public final class Application extends BaseApplication {
    public void onCreate() {
        super.onCreate();
        Logger logger = Logger.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
        logger.initFile(applicationContext);
        ContextFunctionsKt.startKoin$default((KoinContext) null, new Application$onCreate$1(this), 1, (Object) null);
    }
}
