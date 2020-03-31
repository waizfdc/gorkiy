package com.askgps.personaltrackercore.service;

import android.content.ComponentCallbacks;
import androidx.exifinterface.media.ExifInterface;
import com.askgps.personaltrackercore.repository.Repository;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.ComponentCallbackExtKt;
import org.koin.core.qualifier.Qualifier;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()Ljava/lang/Object;", "org/koin/android/ext/android/ComponentCallbackExtKt$inject$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: ComponentCallbackExt.kt */
public final class PeriodicJobService$$special$$inlined$inject$1 extends Lambda implements Function0<Repository> {
    final /* synthetic */ Function0 $parameters;
    final /* synthetic */ Qualifier $qualifier;
    final /* synthetic */ ComponentCallbacks $this_inject;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeriodicJobService$$special$$inlined$inject$1(ComponentCallbacks componentCallbacks, Qualifier qualifier, Function0 function0) {
        super(0);
        this.$this_inject = componentCallbacks;
        this.$qualifier = qualifier;
        this.$parameters = function0;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.askgps.personaltrackercore.repository.Repository, java.lang.Object] */
    public final Repository invoke() {
        ComponentCallbacks componentCallbacks = this.$this_inject;
        return ComponentCallbackExtKt.getKoin(componentCallbacks).get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(Repository.class), this.$qualifier, this.$parameters);
    }
}
