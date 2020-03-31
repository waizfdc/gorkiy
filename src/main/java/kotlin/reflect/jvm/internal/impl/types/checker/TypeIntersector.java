package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: IntersectionType.kt */
public final class TypeIntersector {
    public static final TypeIntersector INSTANCE = new TypeIntersector();

    private TypeIntersector() {
    }

    public final SimpleType intersectTypes$descriptors(List<? extends SimpleType> list) {
        Intrinsics.checkParameterIsNotNull(list, "types");
        boolean z = list.size() > 1;
        if (!_Assertions.ENABLED || z) {
            ArrayList arrayList = new ArrayList();
            for (SimpleType simpleType : list) {
                if (simpleType.getConstructor() instanceof IntersectionTypeConstructor) {
                    Collection<KotlinType> supertypes = simpleType.getConstructor().getSupertypes();
                    Intrinsics.checkExpressionValueIsNotNull(supertypes, "type.constructor.supertypes");
                    Iterable<KotlinType> iterable = supertypes;
                    Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    for (KotlinType kotlinType : iterable) {
                        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "it");
                        SimpleType upperIfFlexible = FlexibleTypesKt.upperIfFlexible(kotlinType);
                        if (simpleType.isMarkedNullable()) {
                            upperIfFlexible = upperIfFlexible.makeNullableAsSpecified(true);
                        }
                        arrayList2.add(upperIfFlexible);
                    }
                    arrayList.addAll((List) arrayList2);
                } else {
                    arrayList.add(simpleType);
                }
            }
            Iterable<UnwrappedType> iterable2 = arrayList;
            ResultNullability resultNullability = ResultNullability.START;
            for (UnwrappedType combine : iterable2) {
                resultNullability = resultNullability.combine(combine);
            }
            Collection linkedHashSet = new LinkedHashSet();
            Iterator it = iterable2.iterator();
            while (it.hasNext()) {
                SimpleType simpleType2 = (SimpleType) it.next();
                if (resultNullability == ResultNullability.NOT_NULL) {
                    simpleType2 = SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType2);
                }
                linkedHashSet.add(simpleType2);
            }
            return intersectTypesWithoutIntersectionType((LinkedHashSet) linkedHashSet);
        }
        throw new AssertionError("Size should be at least 2, but it is " + list.size());
    }

    private final SimpleType intersectTypesWithoutIntersectionType(Set<? extends SimpleType> set) {
        if (set.size() == 1) {
            return (SimpleType) CollectionsKt.single(set);
        }
        Function0 typeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1 = new TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(set);
        Collection collection = set;
        Collection<SimpleType> filterTypes = filterTypes(collection, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(this));
        boolean z = !filterTypes.isEmpty();
        if (!_Assertions.ENABLED || z) {
            SimpleType findIntersectionType = IntegerLiteralTypeConstructor.Companion.findIntersectionType(filterTypes);
            if (findIntersectionType != null) {
                return findIntersectionType;
            }
            Collection<SimpleType> filterTypes2 = filterTypes(filterTypes, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(NewKotlinTypeChecker.Companion.getDefault()));
            boolean isEmpty = true ^ filterTypes2.isEmpty();
            if (_Assertions.ENABLED && !isEmpty) {
                throw new AssertionError(typeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1.invoke());
            } else if (filterTypes2.size() < 2) {
                return (SimpleType) CollectionsKt.single(filterTypes2);
            } else {
                return new IntersectionTypeConstructor(collection).createType();
            }
        } else {
            throw new AssertionError(typeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1.invoke());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x000e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b A[EDGE_INSN: B:27:0x005b->B:18:0x005b ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.types.SimpleType> filterTypes(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> r8, kotlin.jvm.functions.Function2<? super kotlin.reflect.jvm.internal.impl.types.SimpleType, ? super kotlin.reflect.jvm.internal.impl.types.SimpleType, java.lang.Boolean> r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r8)
            java.util.Iterator r8 = r0.iterator()
            java.lang.String r1 = "filteredTypes.iterator()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r1)
        L_0x000e:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0061
            java.lang.Object r1 = r8.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r1
            r2 = r0
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r3 = r2 instanceof java.util.Collection
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x002e
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x002e
        L_0x002c:
            r4 = r5
            goto L_0x005b
        L_0x002e:
            java.util.Iterator r2 = r2.iterator()
        L_0x0032:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x002c
            java.lang.Object r3 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r3
            if (r3 == r1) goto L_0x0058
            java.lang.String r6 = "lower"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r6)
            java.lang.String r6 = "upper"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r6)
            java.lang.Object r3 = r9.invoke(r3, r1)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0058
            r3 = r4
            goto L_0x0059
        L_0x0058:
            r3 = r5
        L_0x0059:
            if (r3 == 0) goto L_0x0032
        L_0x005b:
            if (r4 == 0) goto L_0x000e
            r8.remove()
            goto L_0x000e
        L_0x0061:
            java.util.Collection r0 = (java.util.Collection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.filterTypes(java.util.Collection, kotlin.jvm.functions.Function2):java.util.Collection");
    }

    /* access modifiers changed from: private */
    public final boolean isStrictSupertype(KotlinType kotlinType, KotlinType kotlinType2) {
        NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl = NewKotlinTypeChecker.Companion.getDefault();
        return newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType, kotlinType2) && !newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType2, kotlinType);
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: IntersectionType.kt */
    private static final class ResultNullability extends Enum<ResultNullability> {
        private static final /* synthetic */ ResultNullability[] $VALUES;
        public static final ResultNullability ACCEPT_NULL;
        public static final ResultNullability NOT_NULL;
        public static final ResultNullability START;
        public static final ResultNullability UNKNOWN;

        static {
            START start = new START("START", 0);
            START = start;
            ACCEPT_NULL accept_null = new ACCEPT_NULL("ACCEPT_NULL", 1);
            ACCEPT_NULL = accept_null;
            UNKNOWN unknown = new UNKNOWN("UNKNOWN", 2);
            UNKNOWN = unknown;
            NOT_NULL not_null = new NOT_NULL("NOT_NULL", 3);
            NOT_NULL = not_null;
            $VALUES = new ResultNullability[]{start, accept_null, unknown, not_null};
        }

        public static ResultNullability valueOf(String str) {
            return (ResultNullability) Enum.valueOf(ResultNullability.class, str);
        }

        public static ResultNullability[] values() {
            return (ResultNullability[]) $VALUES.clone();
        }

        public abstract ResultNullability combine(UnwrappedType unwrappedType);

        /* compiled from: IntersectionType.kt */
        static final class START extends ResultNullability {
            START(String str, int i) {
                super(str, i, null);
            }

            public ResultNullability combine(UnwrappedType unwrappedType) {
                Intrinsics.checkParameterIsNotNull(unwrappedType, "nextType");
                return getResultNullability(unwrappedType);
            }
        }

        private ResultNullability(String str, int i) {
        }

        public /* synthetic */ ResultNullability(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        /* compiled from: IntersectionType.kt */
        static final class ACCEPT_NULL extends ResultNullability {
            ACCEPT_NULL(String str, int i) {
                super(str, i, null);
            }

            public ResultNullability combine(UnwrappedType unwrappedType) {
                Intrinsics.checkParameterIsNotNull(unwrappedType, "nextType");
                return getResultNullability(unwrappedType);
            }
        }

        /* compiled from: IntersectionType.kt */
        static final class UNKNOWN extends ResultNullability {
            UNKNOWN(String str, int i) {
                super(str, i, null);
            }

            public ResultNullability combine(UnwrappedType unwrappedType) {
                Intrinsics.checkParameterIsNotNull(unwrappedType, "nextType");
                ResultNullability resultNullability = getResultNullability(unwrappedType);
                return resultNullability == ResultNullability.ACCEPT_NULL ? this : super;
            }
        }

        /* compiled from: IntersectionType.kt */
        static final class NOT_NULL extends ResultNullability {
            public NOT_NULL combine(UnwrappedType unwrappedType) {
                Intrinsics.checkParameterIsNotNull(unwrappedType, "nextType");
                return this;
            }

            NOT_NULL(String str, int i) {
                super(str, i, null);
            }
        }

        /* access modifiers changed from: protected */
        public final ResultNullability getResultNullability(UnwrappedType unwrappedType) {
            Intrinsics.checkParameterIsNotNull(unwrappedType, "$this$resultNullability");
            if (unwrappedType.isMarkedNullable()) {
                return ACCEPT_NULL;
            }
            if (NullabilityChecker.INSTANCE.isSubtypeOfAny(unwrappedType)) {
                return NOT_NULL;
            }
            return UNKNOWN;
        }
    }
}
