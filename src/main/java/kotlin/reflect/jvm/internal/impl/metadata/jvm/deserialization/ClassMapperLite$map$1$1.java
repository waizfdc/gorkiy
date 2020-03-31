package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ClassMapperLite.kt */
final class ClassMapperLite$map$1$1 extends Lambda implements Function2<String, String, Unit> {
    final /* synthetic */ Map $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClassMapperLite$map$1$1(Map map) {
        super(2);
        this.$this_apply = map;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "kotlinSimpleName");
        Intrinsics.checkParameterIsNotNull(str2, "javaInternalName");
        this.$this_apply.put("kotlin/" + str, 'L' + str2 + ';');
    }
}
