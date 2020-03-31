package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* compiled from: SupertypeLoopChecker.kt */
public interface SupertypeLoopChecker {
    Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor typeConstructor, Collection<? extends KotlinType> collection, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> function1, Function1<? super KotlinType, Unit> function12);

    /* compiled from: SupertypeLoopChecker.kt */
    public static final class EMPTY implements SupertypeLoopChecker {
        public static final EMPTY INSTANCE = new EMPTY();

        /* JADX WARN: Type inference failed for: r3v0, types: [java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType>, java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType>, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> findLoopsInSupertypesAndDisconnect(kotlin.reflect.jvm.internal.impl.types.TypeConstructor r2, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> r3, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.TypeConstructor, ? extends java.lang.Iterable<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType>> r4, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.Unit> r5) {
            /*
                r1 = this;
                java.lang.String r0 = "currentTypeConstructor"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
                java.lang.String r2 = "superTypes"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r2)
                java.lang.String r2 = "neighbors"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r2)
                java.lang.String r2 = "reportLoop"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r2)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY.findLoopsInSupertypesAndDisconnect(kotlin.reflect.jvm.internal.impl.types.TypeConstructor, java.util.Collection, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):java.util.Collection");
        }

        private EMPTY() {
        }
    }
}
