package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: SpecialTypes.kt */
final class LazyWrappedType$refine$1 extends Lambda implements Function0<KotlinType> {
    final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner;
    final /* synthetic */ LazyWrappedType this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyWrappedType$refine$1(LazyWrappedType lazyWrappedType, KotlinTypeRefiner kotlinTypeRefiner) {
        super(0);
        this.this$0 = lazyWrappedType;
        this.$kotlinTypeRefiner = kotlinTypeRefiner;
    }

    public final KotlinType invoke() {
        return this.$kotlinTypeRefiner.refineType((KotlinType) this.this$0.computation.invoke());
    }
}
