package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;

/* compiled from: LazyScopeAdapter.kt */
public final class LazyScopeAdapter extends AbstractScopeAdapter {
    private final NotNullLazyValue<MemberScope> scope;

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope>, kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LazyScopeAdapter(kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> r2) {
        /*
            r1 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            r1.<init>()
            r1.scope = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter.<init>(kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue):void");
    }

    /* access modifiers changed from: protected */
    public MemberScope getWorkerScope() {
        return (MemberScope) this.scope.invoke();
    }
}
