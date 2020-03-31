package org.koin.java;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.koin.core.qualifier.Qualifier;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
/* compiled from: KoinJavaComponent.kt */
final class KoinJavaComponent$inject$1 extends Lambda implements Function0<T> {
    final /* synthetic */ Class $clazz;
    final /* synthetic */ Function0 $parameters;
    final /* synthetic */ Qualifier $qualifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KoinJavaComponent$inject$1(Class cls, Qualifier qualifier, Function0 function0) {
        super(0);
        this.$clazz = cls;
        this.$qualifier = qualifier;
        this.$parameters = function0;
    }

    public final T invoke() {
        return KoinJavaComponent.get(this.$clazz, this.$qualifier, this.$parameters);
    }
}
