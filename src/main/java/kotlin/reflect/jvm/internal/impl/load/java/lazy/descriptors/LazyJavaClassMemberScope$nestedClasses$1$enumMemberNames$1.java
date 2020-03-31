package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1 extends Lambda implements Function0<Set<? extends Name>> {
    final /* synthetic */ LazyJavaClassMemberScope$nestedClasses$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(LazyJavaClassMemberScope$nestedClasses$1 lazyJavaClassMemberScope$nestedClasses$1) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope$nestedClasses$1;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: kotlin.collections.SetsKt___SetsKt.plus(java.util.Set, java.lang.Iterable):java.util.Set<T>
     arg types: [java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name>, java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name>]
     candidates:
      kotlin.collections.SetsKt___SetsKt.plus(java.util.Set, java.lang.Object):java.util.Set<T>
      kotlin.collections.SetsKt___SetsKt.plus(java.util.Set, kotlin.sequences.Sequence):java.util.Set<T>
      kotlin.collections.SetsKt___SetsKt.plus(java.util.Set, java.lang.Object[]):java.util.Set<T>
      kotlin.collections.SetsKt___SetsKt.plus(java.util.Set, java.lang.Iterable):java.util.Set<T> */
    public final Set<Name> invoke() {
        return SetsKt.plus((Set) this.this$0.this$0.getFunctionNames(), (Iterable) this.this$0.this$0.getVariableNames());
    }
}
