package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* compiled from: AbstractTypeChecker.kt */
final class AbstractTypeChecker$checkSubtypeForIntegerLiteralType$1 extends Lambda implements Function2<SimpleTypeMarker, SimpleTypeMarker, Boolean> {
    final /* synthetic */ AbstractTypeCheckerContext $this_checkSubtypeForIntegerLiteralType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeChecker$checkSubtypeForIntegerLiteralType$1(AbstractTypeCheckerContext abstractTypeCheckerContext) {
        super(2);
        this.$this_checkSubtypeForIntegerLiteralType = abstractTypeCheckerContext;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return Boolean.valueOf(invoke((SimpleTypeMarker) obj, (SimpleTypeMarker) obj2));
    }

    public final boolean invoke(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "integerLiteralType");
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker2, "type");
        Iterable<KotlinTypeMarker> possibleIntegerTypes = this.$this_checkSubtypeForIntegerLiteralType.possibleIntegerTypes(simpleTypeMarker);
        if ((possibleIntegerTypes instanceof Collection) && ((Collection) possibleIntegerTypes).isEmpty()) {
            return false;
        }
        for (KotlinTypeMarker typeConstructor : possibleIntegerTypes) {
            if (Intrinsics.areEqual(this.$this_checkSubtypeForIntegerLiteralType.typeConstructor(typeConstructor), this.$this_checkSubtypeForIntegerLiteralType.typeConstructor(simpleTypeMarker2))) {
                return true;
            }
        }
        return false;
    }
}
