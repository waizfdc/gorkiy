package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: NewCapturedType.kt */
final class NewCapturedTypeConstructor$refine$$inlined$let$lambda$1 extends Lambda implements Function0<List<? extends UnwrappedType>> {
    final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner$inlined;
    final /* synthetic */ NewCapturedTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewCapturedTypeConstructor$refine$$inlined$let$lambda$1(NewCapturedTypeConstructor newCapturedTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
        super(0);
        this.this$0 = newCapturedTypeConstructor;
        this.$kotlinTypeRefiner$inlined = kotlinTypeRefiner;
    }

    public final List<UnwrappedType> invoke() {
        Iterable<UnwrappedType> supertypes = this.this$0.getSupertypes();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(supertypes, 10));
        for (UnwrappedType refine : supertypes) {
            arrayList.add(refine.refine(this.$kotlinTypeRefiner$inlined));
        }
        return (List) arrayList;
    }
}
