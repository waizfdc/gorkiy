package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lkotlin/reflect/KClass;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: KClasses.kt */
final class KClasses$isSubclassOf$2 extends Lambda implements Function1<KClass<?>, Boolean> {
    final /* synthetic */ KClass $base;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClasses$isSubclassOf$2(KClass kClass) {
        super(1);
        this.$base = kClass;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((KClass<?>) ((KClass) obj)));
    }

    public final boolean invoke(KClass<?> kClass) {
        return Intrinsics.areEqual(kClass, this.$base);
    }
}
