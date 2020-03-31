package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ScopesHolderForClass.kt */
public final class ScopesHolderForClass<T extends MemberScope> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    public static final Companion Companion = new Companion(null);
    private final ClassDescriptor classDescriptor;
    /* access modifiers changed from: private */
    public final KotlinTypeRefiner kotlinTypeRefinerForOwnerModule;
    /* access modifiers changed from: private */
    public final Function1<KotlinTypeRefiner, T> scopeFactory;
    private final NotNullLazyValue scopeForOwnerModule$delegate;

    private final T getScopeForOwnerModule() {
        return (MemberScope) StorageKt.getValue(this.scopeForOwnerModule$delegate, this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, ? extends T>, kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ScopesHolderForClass(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1, kotlin.reflect.jvm.internal.impl.storage.StorageManager r2, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, ? extends T> r3, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r4) {
        /*
            r0 = this;
            r0.<init>()
            r0.classDescriptor = r1
            r0.scopeFactory = r3
            r0.kotlinTypeRefinerForOwnerModule = r4
            kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass$scopeForOwnerModule$2 r1 = new kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass$scopeForOwnerModule$2
            r1.<init>(r0)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r1 = r2.createLazyValue(r1)
            r0.scopeForOwnerModule$delegate = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass.<init>(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.jvm.functions.Function1, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner):void");
    }

    public /* synthetic */ ScopesHolderForClass(ClassDescriptor classDescriptor2, StorageManager storageManager, Function1 function1, KotlinTypeRefiner kotlinTypeRefiner, DefaultConstructorMarker defaultConstructorMarker) {
        this(classDescriptor2, storageManager, function1, kotlinTypeRefiner);
    }

    public final T getScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkParameterIsNotNull(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (!kotlinTypeRefiner.isRefinementNeededForModule(DescriptorUtilsKt.getModule(this.classDescriptor))) {
            return getScopeForOwnerModule();
        }
        TypeConstructor typeConstructor = this.classDescriptor.getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "classDescriptor.typeConstructor");
        if (!kotlinTypeRefiner.isRefinementNeededForTypeConstructor(typeConstructor)) {
            return getScopeForOwnerModule();
        }
        return kotlinTypeRefiner.getOrPutScopeForClass(this.classDescriptor, new ScopesHolderForClass$getScope$1(this, kotlinTypeRefiner));
    }

    /* compiled from: ScopesHolderForClass.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T extends MemberScope> ScopesHolderForClass<T> create(ClassDescriptor classDescriptor, StorageManager storageManager, KotlinTypeRefiner kotlinTypeRefiner, Function1<? super KotlinTypeRefiner, ? extends T> function1) {
            Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
            Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
            Intrinsics.checkParameterIsNotNull(kotlinTypeRefiner, "kotlinTypeRefinerForOwnerModule");
            Intrinsics.checkParameterIsNotNull(function1, "scopeFactory");
            return new ScopesHolderForClass(classDescriptor, storageManager, function1, kotlinTypeRefiner, null);
        }
    }
}
