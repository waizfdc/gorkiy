package com.askgps.personaltrackercore.repository;

import androidx.exifinterface.media.ExifInterface;
import com.askgps.personaltrackercore.utils.NotificationHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.KoinComponent;
import org.koin.core.qualifier.Qualifier;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;", "org/koin/core/KoinComponentKt$inject$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: KoinComponent.kt */
public final class Repository$$special$$inlined$inject$1 extends Lambda implements Function0<NotificationHandler> {
    final /* synthetic */ Function0 $parameters;
    final /* synthetic */ Qualifier $qualifier;
    final /* synthetic */ KoinComponent $this_inject;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Repository$$special$$inlined$inject$1(KoinComponent koinComponent, Qualifier qualifier, Function0 function0) {
        super(0);
        this.$this_inject = koinComponent;
        this.$qualifier = qualifier;
        this.$parameters = function0;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.askgps.personaltrackercore.utils.NotificationHandler, java.lang.Object] */
    public final NotificationHandler invoke() {
        Koin koin = this.$this_inject.getKoin();
        return koin.get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(NotificationHandler.class), this.$qualifier, this.$parameters);
    }
}
