package org.koin.ext;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.context.KoinContextHandler;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.scope.Scope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0006\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002H\u0002¢\u0006\u0002\u0010\u0005\u001a#\u0010\u0006\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\t\u001a\u0019\u0010\n\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\u0005\u001a!\u0010\n\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t\u001a\u0019\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\r\u001a\u0019\u0010\u000e\u001a\u00020\u000f\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\u0010\u001a'\u0010\u0011\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\t\"\u001f\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0012"}, d2 = {"scope", "Lorg/koin/core/scope/Scope;", ExifInterface.GPS_DIRECTION_TRUE, "", "getScope", "(Ljava/lang/Object;)Lorg/koin/core/scope/Scope;", "createScope", "koin", "Lorg/koin/core/Koin;", "(Ljava/lang/Object;Lorg/koin/core/Koin;)Lorg/koin/core/scope/Scope;", "getOrCreateScope", "getScopeId", "", "(Ljava/lang/Object;)Ljava/lang/String;", "getScopeName", "Lorg/koin/core/qualifier/TypeQualifier;", "(Ljava/lang/Object;)Lorg/koin/core/qualifier/TypeQualifier;", "getScopeOrNull", "koin-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: InstanceScopeExt.kt */
public final class InstanceScopeExtKt {
    public static final <T> TypeQualifier getScopeName(T t) {
        Intrinsics.checkParameterIsNotNull(t, "$this$getScopeName");
        return new TypeQualifier(Reflection.getOrCreateKotlinClass(t.getClass()));
    }

    public static final <T> String getScopeId(T t) {
        Intrinsics.checkParameterIsNotNull(t, "$this$getScopeId");
        return KClassExtKt.getFullName(Reflection.getOrCreateKotlinClass(t.getClass())) + "@" + System.identityHashCode(t);
    }

    public static final <T> Scope getScope(T t) {
        Intrinsics.checkParameterIsNotNull(t, "$this$scope");
        return getOrCreateScope(t);
    }

    public static final <T> Scope getOrCreateScope(T t) {
        Intrinsics.checkParameterIsNotNull(t, "$this$getOrCreateScope");
        Koin koin = KoinContextHandler.INSTANCE.get();
        Scope scopeOrNull = getScopeOrNull(t, koin);
        return scopeOrNull != null ? scopeOrNull : createScope(t, koin);
    }

    public static final <T> Scope getOrCreateScope(T t, Koin koin) {
        Intrinsics.checkParameterIsNotNull(t, "$this$getOrCreateScope");
        Intrinsics.checkParameterIsNotNull(koin, "koin");
        String scopeId = getScopeId(t);
        Scope scopeOrNull = koin.getScopeOrNull(scopeId);
        return scopeOrNull != null ? scopeOrNull : koin.createScope(scopeId, getScopeName(t), t);
    }

    static /* synthetic */ Scope getScopeOrNull$default(Object obj, Koin koin, int i, Object obj2) {
        if ((i & 1) != 0) {
            koin = KoinContextHandler.INSTANCE.get();
        }
        return getScopeOrNull(obj, koin);
    }

    private static final <T> Scope getScopeOrNull(T t, Koin koin) {
        return koin.getScopeOrNull(getScopeId(t));
    }

    private static final <T> Scope createScope(T t) {
        return KoinContextHandler.INSTANCE.get().createScope(getScopeId(t), getScopeName(t), t);
    }

    private static final <T> Scope createScope(T t, Koin koin) {
        return koin.createScope(getScopeId(t), getScopeName(t), t);
    }
}
