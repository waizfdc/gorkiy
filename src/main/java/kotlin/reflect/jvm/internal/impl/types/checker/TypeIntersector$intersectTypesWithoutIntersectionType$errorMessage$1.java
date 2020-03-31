package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: IntersectionType.kt */
final class TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Set $inputTypes;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(Set set) {
        super(0);
        this.$inputTypes = set;
    }

    public final String invoke() {
        return "This collections cannot be empty! input types: " + CollectionsKt.joinToString$default(this.$inputTypes, null, null, null, 0, null, null, 63, null);
    }
}
